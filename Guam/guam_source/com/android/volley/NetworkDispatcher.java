package com.android.volley;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.android.volley.ExecutorDelivery;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.NoCache;
import java.util.concurrent.BlockingQueue;

public class NetworkDispatcher extends Thread {
    public final Cache mCache;
    public final ResponseDelivery mDelivery;
    public final Network mNetwork;
    public final BlockingQueue<Request<?>> mQueue;
    public volatile boolean mQuit = false;

    public NetworkDispatcher(BlockingQueue<Request<?>> blockingQueue, Network network, Cache cache, ResponseDelivery responseDelivery) {
        this.mQueue = blockingQueue;
        this.mNetwork = network;
        this.mCache = cache;
        this.mDelivery = responseDelivery;
    }

    public final void processRequest() throws InterruptedException {
        boolean z;
        Request<?> take = this.mQueue.take();
        SystemClock.elapsedRealtime();
        try {
            take.addMarker("network-queue-take");
            if (take.isCanceled()) {
                take.finish("network-discard-cancelled");
                take.notifyListenerResponseNotUsable();
                return;
            }
            TrafficStats.setThreadStatsTag(take.mDefaultTrafficStatsTag);
            NetworkResponse performRequest = ((BasicNetwork) this.mNetwork).performRequest(take);
            take.addMarker("network-http-complete");
            if (performRequest.notModified) {
                synchronized (take.mLock) {
                    z = take.mResponseDelivered;
                }
                if (z) {
                    take.finish("not-modified");
                    take.notifyListenerResponseNotUsable();
                    return;
                }
            }
            Response<?> parseNetworkResponse = take.parseNetworkResponse(performRequest);
            take.addMarker("network-parse-complete");
            if (take.mShouldCache && parseNetworkResponse.cacheEntry != null) {
                Cache cache = this.mCache;
                take.getCacheKey();
                if (((NoCache) cache) != null) {
                    take.addMarker("network-cache-written");
                } else {
                    throw null;
                }
            }
            synchronized (take.mLock) {
                take.mResponseDelivered = true;
            }
            ((ExecutorDelivery) this.mDelivery).postResponse(take, parseNetworkResponse, null);
            take.notifyListenerResponseReceived(parseNetworkResponse);
        } catch (VolleyError e) {
            SystemClock.elapsedRealtime();
            if (take != null) {
                ExecutorDelivery executorDelivery = (ExecutorDelivery) this.mDelivery;
                if (executorDelivery != null) {
                    take.addMarker("post-error");
                    executorDelivery.mResponsePoster.execute(new ExecutorDelivery.ResponseDeliveryRunnable(take, new Response(e), null));
                    take.notifyListenerResponseNotUsable();
                    return;
                }
                throw null;
            }
            throw null;
        } catch (Exception e2) {
            Log.e("Volley", VolleyLog.buildMessage("Unhandled exception %s", e2.toString()), e2);
            VolleyError volleyError = new VolleyError(e2);
            SystemClock.elapsedRealtime();
            ExecutorDelivery executorDelivery2 = (ExecutorDelivery) this.mDelivery;
            if (executorDelivery2 != null) {
                take.addMarker("post-error");
                executorDelivery2.mResponsePoster.execute(new ExecutorDelivery.ResponseDeliveryRunnable(take, new Response(volleyError), null));
                take.notifyListenerResponseNotUsable();
                return;
            }
            throw null;
        }
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                processRequest();
            } catch (InterruptedException unused) {
                if (this.mQuit) {
                    Thread.currentThread().interrupt();
                    return;
                }
                VolleyLog.e("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
