package c.a.b;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.CallSuper;
import android.support.annotation.GuardedBy;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import c.a.b.b;
import c.a.b.d;
import c.a.b.p;
import c.a.b.q;
import c.a.b.w;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public abstract class o<T> implements Comparable<o<T>> {
    public static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
    public b.a mCacheEntry;
    @GuardedBy("mLock")
    public boolean mCanceled;
    public final int mDefaultTrafficStatsTag;
    @GuardedBy("mLock")
    @Nullable
    public q.a mErrorListener;
    public final w.a mEventLog;
    public final Object mLock;
    public final int mMethod;
    @GuardedBy("mLock")
    public b mRequestCompleteListener;
    public p mRequestQueue;
    @GuardedBy("mLock")
    public boolean mResponseDelivered;
    public s mRetryPolicy;
    public Integer mSequence;
    public boolean mShouldCache;
    public boolean mShouldRetryServerErrors;
    public Object mTag;
    public final String mUrl;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f2222b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f2223c;

        public a(String str, long j) {
            this.f2222b = str;
            this.f2223c = j;
        }

        public void run() {
            o.this.mEventLog.a(this.f2222b, this.f2223c);
            o.this.mEventLog.b(o.this.toString());
        }
    }

    public interface b {
    }

    public enum c {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public o(int i, String str, @Nullable q.a aVar) {
        this.mEventLog = w.a.f2241c ? new w.a() : null;
        this.mLock = new Object();
        this.mShouldCache = true;
        this.mCanceled = false;
        this.mResponseDelivered = false;
        this.mShouldRetryServerErrors = false;
        this.mCacheEntry = null;
        this.mMethod = i;
        this.mUrl = str;
        this.mErrorListener = aVar;
        setRetryPolicy(new f(2500, 1, 1.0f));
        this.mDefaultTrafficStatsTag = findDefaultTrafficStatsTag(str);
    }

    @Deprecated
    public o(String str, q.a aVar) {
        this(-1, str, aVar);
    }

    private byte[] encodeParameters(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(c.a.a.a.a.o("Encoding not supported: ", str), e2);
        }
    }

    public static int findDefaultTrafficStatsTag(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    public void addMarker(String str) {
        if (w.a.f2241c) {
            this.mEventLog.a(str, Thread.currentThread().getId());
        }
    }

    @CallSuper
    public void cancel() {
        synchronized (this.mLock) {
            this.mCanceled = true;
            this.mErrorListener = null;
        }
    }

    public int compareTo(o<T> oVar) {
        c priority = getPriority();
        c priority2 = oVar.getPriority();
        return priority == priority2 ? this.mSequence.intValue() - oVar.mSequence.intValue() : priority2.ordinal() - priority.ordinal();
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((o) ((o) obj));
    }

    public void deliverError(v vVar) {
        q.a aVar;
        synchronized (this.mLock) {
            aVar = this.mErrorListener;
        }
        if (aVar != null) {
            aVar.a(vVar);
        }
    }

    public abstract void deliverResponse(T t);

    public void finish(String str) {
        p pVar = this.mRequestQueue;
        if (pVar != null) {
            synchronized (pVar.f2230b) {
                pVar.f2230b.remove(this);
            }
            synchronized (pVar.j) {
                for (p.a aVar : pVar.j) {
                    aVar.a(this);
                }
            }
        }
        if (w.a.f2241c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new a(str, id));
                return;
            }
            this.mEventLog.a(str, id);
            this.mEventLog.b(toString());
        }
    }

    public byte[] getBody() {
        Map<String, String> params = getParams();
        if (params == null || params.size() <= 0) {
            return null;
        }
        return encodeParameters(params, getParamsEncoding());
    }

    public String getBodyContentType() {
        StringBuilder g = c.a.a.a.a.g("application/x-www-form-urlencoded; charset=");
        g.append(getParamsEncoding());
        return g.toString();
    }

    public b.a getCacheEntry() {
        return this.mCacheEntry;
    }

    public String getCacheKey() {
        String url = getUrl();
        int method = getMethod();
        if (method == 0 || method == -1) {
            return url;
        }
        return Integer.toString(method) + '-' + url;
    }

    @Nullable
    public q.a getErrorListener() {
        q.a aVar;
        synchronized (this.mLock) {
            aVar = this.mErrorListener;
        }
        return aVar;
    }

    public Map<String, String> getHeaders() {
        return Collections.emptyMap();
    }

    public int getMethod() {
        return this.mMethod;
    }

    public Map<String, String> getParams() {
        return null;
    }

    public String getParamsEncoding() {
        return DEFAULT_PARAMS_ENCODING;
    }

    @Deprecated
    public byte[] getPostBody() {
        Map<String, String> postParams = getPostParams();
        if (postParams == null || postParams.size() <= 0) {
            return null;
        }
        return encodeParameters(postParams, getPostParamsEncoding());
    }

    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Deprecated
    public Map<String, String> getPostParams() {
        return getParams();
    }

    @Deprecated
    public String getPostParamsEncoding() {
        return getParamsEncoding();
    }

    public c getPriority() {
        return c.NORMAL;
    }

    public s getRetryPolicy() {
        return this.mRetryPolicy;
    }

    public final int getSequence() {
        Integer num = this.mSequence;
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public Object getTag() {
        return this.mTag;
    }

    public final int getTimeoutMs() {
        return ((f) getRetryPolicy()).f2202a;
    }

    public int getTrafficStatsTag() {
        return this.mDefaultTrafficStatsTag;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean hasHadResponseDelivered() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mResponseDelivered;
        }
        return z;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mCanceled;
        }
        return z;
    }

    public void markDelivered() {
        synchronized (this.mLock) {
            this.mResponseDelivered = true;
        }
    }

    public void notifyListenerResponseNotUsable() {
        b bVar;
        synchronized (this.mLock) {
            bVar = this.mRequestCompleteListener;
        }
        if (bVar != null) {
            ((d.a) bVar).b(this);
        }
    }

    public void notifyListenerResponseReceived(q<?> qVar) {
        b bVar;
        List<o<?>> remove;
        synchronized (this.mLock) {
            bVar = this.mRequestCompleteListener;
        }
        if (bVar != null) {
            d.a aVar = (d.a) bVar;
            b.a aVar2 = qVar.f2235b;
            if (aVar2 != null) {
                if (!(aVar2.f2193e < System.currentTimeMillis())) {
                    String cacheKey = getCacheKey();
                    synchronized (aVar) {
                        remove = aVar.f2200a.remove(cacheKey);
                    }
                    if (remove != null) {
                        if (w.f2239a) {
                            w.b("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), cacheKey);
                        }
                        for (o<?> oVar : remove) {
                            ((g) aVar.f2201b.f2199e).a(oVar, qVar);
                        }
                        return;
                    }
                    return;
                }
            }
            aVar.b(this);
        }
    }

    public v parseNetworkError(v vVar) {
        return vVar;
    }

    public abstract q<T> parseNetworkResponse(l lVar);

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: c.a.b.o<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public o<?> setCacheEntry(b.a aVar) {
        this.mCacheEntry = aVar;
        return this;
    }

    public void setNetworkRequestCompleteListener(b bVar) {
        synchronized (this.mLock) {
            this.mRequestCompleteListener = bVar;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: c.a.b.o<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public o<?> setRequestQueue(p pVar) {
        this.mRequestQueue = pVar;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: c.a.b.o<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public o<?> setRetryPolicy(s sVar) {
        this.mRetryPolicy = sVar;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: c.a.b.o<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final o<?> setSequence(int i) {
        this.mSequence = Integer.valueOf(i);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: c.a.b.o<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final o<?> setShouldCache(boolean z) {
        this.mShouldCache = z;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: c.a.b.o<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final o<?> setShouldRetryServerErrors(boolean z) {
        this.mShouldRetryServerErrors = z;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: c.a.b.o<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public o<?> setTag(Object obj) {
        this.mTag = obj;
        return this;
    }

    public final boolean shouldCache() {
        return this.mShouldCache;
    }

    public final boolean shouldRetryServerErrors() {
        return this.mShouldRetryServerErrors;
    }

    public String toString() {
        StringBuilder g = c.a.a.a.a.g("0x");
        g.append(Integer.toHexString(getTrafficStatsTag()));
        String sb = g.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(isCanceled() ? "[X] " : "[ ] ");
        sb2.append(getUrl());
        sb2.append(" ");
        sb2.append(sb);
        sb2.append(" ");
        sb2.append(getPriority());
        sb2.append(" ");
        sb2.append(this.mSequence);
        return sb2.toString();
    }
}
