package com.android.volley.toolbox;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectRequest extends JsonRequest<JSONObject> {
    public JsonObjectRequest(String str, JSONObject jSONObject, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(0, str, null, listener, errorListener);
    }

    @Override // com.android.volley.Request
    public Response<JSONObject> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            return new Response<>(new JSONObject(new String(networkResponse.data, AppCompatDelegateImpl.ConfigurationImplApi17.parseCharset(networkResponse.headers, "utf-8"))), AppCompatDelegateImpl.ConfigurationImplApi17.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e) {
            return new Response<>(new ParseError(e));
        } catch (JSONException e2) {
            return new Response<>(new ParseError(e2));
        }
    }
}
