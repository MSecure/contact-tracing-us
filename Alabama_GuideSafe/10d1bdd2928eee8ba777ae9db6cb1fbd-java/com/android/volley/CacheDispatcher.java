package com.android.volley;

import android.os.Process;
import com.android.volley.Request;
import com.android.volley.toolbox.NoCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class CacheDispatcher extends Thread {
    public static final boolean DEBUG = VolleyLog.DEBUG;
    public final Cache mCache;
    public final BlockingQueue<Request<?>> mCacheQueue;
    public final ResponseDelivery mDelivery;
    public final BlockingQueue<Request<?>> mNetworkQueue;
    public volatile boolean mQuit = false;
    public final WaitingRequestManager mWaitingRequestManager;

    public static class WaitingRequestManager implements Request.NetworkRequestCompleteListener {
        public final CacheDispatcher mCacheDispatcher;
        public final Map<String, List<Request<?>>> mWaitingRequests = new HashMap();

        public WaitingRequestManager(CacheDispatcher cacheDispatcher) {
            this.mCacheDispatcher = cacheDispatcher;
        }

        public static boolean access$000(WaitingRequestManager waitingRequestManager, Request request) {
            synchronized (waitingRequestManager) {
                String cacheKey = request.getCacheKey();
                if (waitingRequestManager.mWaitingRequests.containsKey(cacheKey)) {
                    List<Request<?>> list = waitingRequestManager.mWaitingRequests.get(cacheKey);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    request.addMarker("waiting-for-response");
                    list.add(request);
                    waitingRequestManager.mWaitingRequests.put(cacheKey, list);
                    if (VolleyLog.DEBUG) {
                        VolleyLog.buildMessage("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
                    }
                    return true;
                }
                waitingRequestManager.mWaitingRequests.put(cacheKey, null);
                synchronized (request.mLock) {
                    request.mRequestCompleteListener = waitingRequestManager;
                }
                if (VolleyLog.DEBUG) {
                    VolleyLog.buildMessage("new request, sending to network %s", cacheKey);
                }
                return false;
            }
        }

        public synchronized void onNoUsableResponseReceived(Request<?> request) {
            String cacheKey = request.getCacheKey();
            List<Request<?>> remove = this.mWaitingRequests.remove(cacheKey);
            if (remove != null && !remove.isEmpty()) {
                if (VolleyLog.DEBUG) {
                    VolleyLog.v("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), cacheKey);
                }
                Request<?> remove2 = remove.remove(0);
                this.mWaitingRequests.put(cacheKey, remove);
                synchronized (remove2.mLock) {
                    remove2.mRequestCompleteListener = this;
                }
                try {
                    this.mCacheDispatcher.mNetworkQueue.put(remove2);
                } catch (InterruptedException e) {
                    VolleyLog.e("Couldn't add request to queue. %s", e.toString());
                    Thread.currentThread().interrupt();
                    CacheDispatcher cacheDispatcher = this.mCacheDispatcher;
                    cacheDispatcher.mQuit = true;
                    cacheDispatcher.interrupt();
                }
            }
        }
    }

    public CacheDispatcher(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, Cache cache, ResponseDelivery responseDelivery) {
        this.mCacheQueue = blockingQueue;
        this.mNetworkQueue = blockingQueue2;
        this.mCache = cache;
        this.mDelivery = responseDelivery;
        this.mWaitingRequestManager = new WaitingRequestManager(this);
    }

    public final void processRequest() throws InterruptedException {
        Request<?> take = this.mCacheQueue.take();
        take.addMarker("cache-queue-take");
        if (take.isCanceled()) {
            take.finish("cache-discard-canceled");
            return;
        }
        Cache cache = this.mCache;
        take.getCacheKey();
        if (((NoCache) cache) != null) {
            take.addMarker("cache-miss");
            if (!WaitingRequestManager.access$000(this.mWaitingRequestManager, take)) {
                this.mNetworkQueue.put(take);
                return;
            }
            return;
        }
        throw null;
    }

    public void run() {
        if (DEBUG) {
            VolleyLog.v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        if (((NoCache) this.mCache) != null) {
            while (true) {
                try {
                    processRequest();
                } catch (InterruptedException unused) {
                    if (this.mQuit) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    VolleyLog.e("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
                }
            }
        } else {
            throw null;
        }
    }
}
