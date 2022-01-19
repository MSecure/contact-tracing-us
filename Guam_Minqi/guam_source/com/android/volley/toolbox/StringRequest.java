package com.android.volley.toolbox;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import java.io.UnsupportedEncodingException;

public class StringRequest extends Request<String> {
    public Response.Listener<String> mListener;
    public final Object mLock = new Object();

    public StringRequest(String str, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(0, str, errorListener);
        this.mListener = listener;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.android.volley.Request
    public void deliverResponse(String str) {
        Response.Listener<String> listener;
        String str2 = str;
        synchronized (this.mLock) {
            listener = this.mListener;
        }
        if (listener != null) {
            listener.onResponse(str2);
        }
    }

    @Override // com.android.volley.Request
    public Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
        String str;
        try {
            str = new String(networkResponse.data, AppCompatDelegateImpl.ConfigurationImplApi17.parseCharset(networkResponse.headers, "ISO-8859-1"));
        } catch (UnsupportedEncodingException unused) {
            str = new String(networkResponse.data);
        }
        return new Response<>(str, AppCompatDelegateImpl.ConfigurationImplApi17.parseCacheHeaders(networkResponse));
    }
}
