package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestQueue {
    public final Cache mCache;
    public CacheDispatcher mCacheDispatcher;
    public final PriorityBlockingQueue<Request<?>> mCacheQueue = new PriorityBlockingQueue<>();
    public final Set<Request<?>> mCurrentRequests = new HashSet();
    public final ResponseDelivery mDelivery;
    public final NetworkDispatcher[] mDispatchers;
    public final List<RequestFinishedListener> mFinishedListeners = new ArrayList();
    public final Network mNetwork;
    public final PriorityBlockingQueue<Request<?>> mNetworkQueue = new PriorityBlockingQueue<>();
    public final AtomicInteger mSequenceGenerator = new AtomicInteger();

    public interface RequestFinishedListener<T> {
        void onRequestFinished(Request<T> request);
    }

    public RequestQueue(Cache cache, Network network) {
        ExecutorDelivery executorDelivery = new ExecutorDelivery(new Handler(Looper.getMainLooper()));
        this.mCache = cache;
        this.mNetwork = network;
        this.mDispatchers = new NetworkDispatcher[4];
        this.mDelivery = executorDelivery;
    }

    public <T> Request<T> add(Request<T> request) {
        request.mRequestQueue = this;
        synchronized (this.mCurrentRequests) {
            this.mCurrentRequests.add(request);
        }
        request.mSequence = Integer.valueOf(this.mSequenceGenerator.incrementAndGet());
        request.addMarker("add-to-queue");
        if (!request.mShouldCache) {
            this.mNetworkQueue.add(request);
            return request;
        }
        this.mCacheQueue.add(request);
        return request;
    }
}
