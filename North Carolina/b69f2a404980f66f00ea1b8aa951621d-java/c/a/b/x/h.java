package c.a.b.x;

import android.support.annotation.GuardedBy;
import android.support.annotation.Nullable;
import android.util.Log;
import c.a.b.l;
import c.a.b.o;
import c.a.b.q;
import c.a.b.w;
import java.io.UnsupportedEncodingException;

public abstract class h<T> extends o<T> {
    public static final String PROTOCOL_CHARSET = "utf-8";
    public static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", PROTOCOL_CHARSET);
    @GuardedBy("mLock")
    @Nullable
    public q.b<T> mListener;
    public final Object mLock;
    @Nullable
    public final String mRequestBody;

    public h(int i, String str, @Nullable String str2, q.b<T> bVar, @Nullable q.a aVar) {
        super(i, str, aVar);
        this.mLock = new Object();
        this.mListener = bVar;
        this.mRequestBody = str2;
    }

    @Deprecated
    public h(String str, String str2, q.b<T> bVar, q.a aVar) {
        this(-1, str, str2, bVar, aVar);
    }

    @Override // c.a.b.o
    public void cancel() {
        super.cancel();
        synchronized (this.mLock) {
            this.mListener = null;
        }
    }

    @Override // c.a.b.o
    public void deliverResponse(T t) {
        q.b<T> bVar;
        synchronized (this.mLock) {
            bVar = this.mListener;
        }
        if (bVar != null) {
            bVar.a(t);
        }
    }

    @Override // c.a.b.o
    public byte[] getBody() {
        try {
            if (this.mRequestBody == null) {
                return null;
            }
            return this.mRequestBody.getBytes(PROTOCOL_CHARSET);
        } catch (UnsupportedEncodingException unused) {
            Log.wtf("Volley", w.a("Unsupported Encoding while trying to get the bytes of %s using %s", this.mRequestBody, PROTOCOL_CHARSET));
            return null;
        }
    }

    @Override // c.a.b.o
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    @Override // c.a.b.o
    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }

    @Override // c.a.b.o
    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Override // c.a.b.o
    public abstract q<T> parseNetworkResponse(l lVar);
}
