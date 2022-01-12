package com.android.volley.toolbox;

import android.util.Log;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

public abstract class JsonRequest<T> extends Request<T> {
    public static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", "utf-8");
    public Response.Listener<T> mListener;
    public final Object mLock = new Object();
    public final String mRequestBody;

    public JsonRequest(int i, String str, String str2, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        super(i, str, errorListener);
        this.mListener = listener;
        this.mRequestBody = str2;
    }

    @Override // com.android.volley.Request
    public void deliverResponse(T t) {
        Response.Listener<T> listener;
        synchronized (this.mLock) {
            listener = this.mListener;
        }
        if (listener != null) {
            listener.onResponse(t);
        }
    }

    @Override // com.android.volley.Request
    public byte[] getBody() {
        try {
            if (this.mRequestBody == null) {
                return null;
            }
            return this.mRequestBody.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            Log.wtf("Volley", VolleyLog.buildMessage("Unsupported Encoding while trying to get the bytes of %s using %s", this.mRequestBody, "utf-8"));
            return null;
        }
    }

    @Override // com.android.volley.Request
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    @Override // com.android.volley.Request
    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }
}
