package com.facebook.react.packagerconnection;

import android.net.Uri;
import com.facebook.common.logging.FLog;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.ReconnectingWebSocket;
import java.util.Map;
import org.json.JSONObject;

public final class JSPackagerClient implements ReconnectingWebSocket.MessageCallback {
    public Map<String, RequestHandler> mRequestHandlers;
    public ReconnectingWebSocket mWebSocket;

    public class ResponderImpl implements Responder {
        public Object mId;

        public ResponderImpl(Object obj) {
            this.mId = obj;
        }

        public void error(Object obj) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", 2);
                jSONObject.put("id", this.mId);
                jSONObject.put("error", obj);
                JSPackagerClient.this.mWebSocket.sendMessage(jSONObject.toString());
            } catch (Exception e) {
                FLog.e("JSPackagerClient", "Responding with error failed", e);
            }
        }

        public void respond(Object obj) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", 2);
                jSONObject.put("id", this.mId);
                jSONObject.put("result", obj);
                JSPackagerClient.this.mWebSocket.sendMessage(jSONObject.toString());
            } catch (Exception e) {
                FLog.e("JSPackagerClient", "Responding failed", e);
            }
        }
    }

    public JSPackagerClient(String str, PackagerConnectionSettings packagerConnectionSettings, Map<String, RequestHandler> map, ReconnectingWebSocket.ConnectionCallback connectionCallback) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("ws").encodedAuthority(packagerConnectionSettings.getDebugServerHost()).appendPath("message").appendQueryParameter("device", AndroidInfoHelpers.getFriendlyDeviceName()).appendQueryParameter("app", packagerConnectionSettings.mPackageName).appendQueryParameter("clientid", str);
        this.mWebSocket = new ReconnectingWebSocket(builder.build().toString(), this, connectionCallback);
        this.mRequestHandlers = map;
    }

    public final void abortOnMessage(Object obj, String str) {
        if (obj != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", 2);
                jSONObject.put("id", obj);
                jSONObject.put("error", str);
                this.mWebSocket.sendMessage(jSONObject.toString());
            } catch (Exception e) {
                FLog.e("JSPackagerClient", "Responding with error failed", e);
            }
        }
        FLog.e("JSPackagerClient", "Handling the message failed with reason: " + str);
    }

    public void onMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("version");
            String optString = jSONObject.optString("method");
            Object opt = jSONObject.opt("id");
            Object opt2 = jSONObject.opt("params");
            if (optInt != 2) {
                FLog.e("JSPackagerClient", "Message with incompatible or missing version of protocol received: " + optInt);
            } else if (optString == null) {
                abortOnMessage(opt, "No method provided");
            } else {
                RequestHandler requestHandler = this.mRequestHandlers.get(optString);
                if (requestHandler == null) {
                    abortOnMessage(opt, "No request handler for method: " + optString);
                } else if (opt == null) {
                    requestHandler.onNotification(opt2);
                } else {
                    requestHandler.onRequest(opt2, new ResponderImpl(opt));
                }
            }
        } catch (Exception e) {
            FLog.e("JSPackagerClient", "Handling the message failed", e);
        }
    }
}
