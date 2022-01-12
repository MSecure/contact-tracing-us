package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.android.volley.Cache;
import com.android.volley.CacheDispatcher;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.List;

public abstract class Request<T> implements Comparable<Request<T>> {
    public Cache.Entry mCacheEntry;
    public boolean mCanceled;
    public final int mDefaultTrafficStatsTag;
    public Response.ErrorListener mErrorListener;
    public final VolleyLog.MarkerLog mEventLog;
    public final Object mLock;
    public final int mMethod;
    public NetworkRequestCompleteListener mRequestCompleteListener;
    public RequestQueue mRequestQueue;
    public boolean mResponseDelivered;
    public DefaultRetryPolicy mRetryPolicy;
    public Integer mSequence;
    public boolean mShouldCache;
    public boolean mShouldRetryServerErrors;
    public final String mUrl;

    public interface NetworkRequestCompleteListener {
    }

    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public Request(int i, String str, Response.ErrorListener errorListener) {
        Uri parse;
        String host;
        this.mEventLog = VolleyLog.MarkerLog.ENABLED ? new VolleyLog.MarkerLog() : null;
        this.mLock = new Object();
        this.mShouldCache = true;
        int i2 = 0;
        this.mCanceled = false;
        this.mResponseDelivered = false;
        this.mShouldRetryServerErrors = false;
        this.mCacheEntry = null;
        this.mMethod = i;
        this.mUrl = str;
        this.mErrorListener = errorListener;
        this.mRetryPolicy = new DefaultRetryPolicy();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i2 = host.hashCode();
        }
        this.mDefaultTrafficStatsTag = i2;
    }

    public void addMarker(String str) {
        if (VolleyLog.MarkerLog.ENABLED) {
            this.mEventLog.add(str, Thread.currentThread().getId());
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        Request request = (Request) obj;
        if (request != null) {
            return this.mSequence.intValue() - request.mSequence.intValue();
        }
        throw null;
    }

    public abstract void deliverResponse(T t);

    public void finish(final String str) {
        RequestQueue requestQueue = this.mRequestQueue;
        if (requestQueue != null) {
            synchronized (requestQueue.mCurrentRequests) {
                requestQueue.mCurrentRequests.remove(this);
            }
            synchronized (requestQueue.mFinishedListeners) {
                for (RequestQueue.RequestFinishedListener requestFinishedListener : requestQueue.mFinishedListeners) {
                    requestFinishedListener.onRequestFinished(this);
                }
            }
        }
        if (VolleyLog.MarkerLog.ENABLED) {
            final long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.android.volley.Request.AnonymousClass1 */

                    public void run() {
                        Request.this.mEventLog.add(str, id);
                        Request request = Request.this;
                        request.mEventLog.finish(request.toString());
                    }
                });
                return;
            }
            this.mEventLog.add(str, id);
            this.mEventLog.finish(toString());
        }
    }

    public byte[] getBody() throws AuthFailureError {
        return null;
    }

    public String getBodyContentType() {
        return GeneratedOutlineSupport.outline10("application/x-www-form-urlencoded; charset=", RNCWebViewManager.HTML_ENCODING);
    }

    public String getCacheKey() {
        String str = this.mUrl;
        int i = this.mMethod;
        if (i == 0 || i == -1) {
            return str;
        }
        return Integer.toString(i) + '-' + str;
    }

    @Deprecated
    public byte[] getPostBody() throws AuthFailureError {
        return null;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mCanceled;
        }
        return z;
    }

    public void notifyListenerResponseNotUsable() {
        NetworkRequestCompleteListener networkRequestCompleteListener;
        synchronized (this.mLock) {
            networkRequestCompleteListener = this.mRequestCompleteListener;
        }
        if (networkRequestCompleteListener != null) {
            ((CacheDispatcher.WaitingRequestManager) networkRequestCompleteListener).onNoUsableResponseReceived(this);
        }
    }

    public void notifyListenerResponseReceived(Response<?> response) {
        NetworkRequestCompleteListener networkRequestCompleteListener;
        List<Request<?>> remove;
        synchronized (this.mLock) {
            networkRequestCompleteListener = this.mRequestCompleteListener;
        }
        if (networkRequestCompleteListener != null) {
            CacheDispatcher.WaitingRequestManager waitingRequestManager = (CacheDispatcher.WaitingRequestManager) networkRequestCompleteListener;
            Cache.Entry entry = response.cacheEntry;
            if (entry != null) {
                if (!(entry.ttl < System.currentTimeMillis())) {
                    String cacheKey = getCacheKey();
                    synchronized (waitingRequestManager) {
                        remove = waitingRequestManager.mWaitingRequests.remove(cacheKey);
                    }
                    if (remove != null) {
                        if (VolleyLog.DEBUG) {
                            VolleyLog.v("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                        }
                        for (Request<?> request : remove) {
                            ((ExecutorDelivery) waitingRequestManager.mCacheDispatcher.mDelivery).postResponse(request, response, null);
                        }
                        return;
                    }
                    return;
                }
            }
            waitingRequestManager.onNoUsableResponseReceived(this);
        }
    }

    public abstract Response<T> parseNetworkResponse(NetworkResponse networkResponse);

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("0x");
        outline17.append(Integer.toHexString(this.mDefaultTrafficStatsTag));
        String sb = outline17.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(isCanceled() ? "[X] " : "[ ] ");
        sb2.append(this.mUrl);
        sb2.append(" ");
        sb2.append(sb);
        sb2.append(" ");
        sb2.append(Priority.NORMAL);
        sb2.append(" ");
        sb2.append(this.mSequence);
        return sb2.toString();
    }
}
