package com.facebook.react.packagerconnection;

import com.facebook.common.logging.FLog;
import com.facebook.react.packagerconnection.JSPackagerClient;

public abstract class NotificationOnlyHandler implements RequestHandler {
    public static final String TAG = JSPackagerClient.class.getSimpleName();

    @Override // com.facebook.react.packagerconnection.RequestHandler
    public abstract void onNotification(Object obj);

    @Override // com.facebook.react.packagerconnection.RequestHandler
    public final void onRequest(Object obj, Responder responder) {
        ((JSPackagerClient.ResponderImpl) responder).error("Request is not supported");
        FLog.e(TAG, "Request is not supported");
    }
}
