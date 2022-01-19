package com.facebook.react.packagerconnection;

import com.facebook.common.logging.FLog;

public abstract class RequestOnlyHandler implements RequestHandler {
    public static final String TAG = JSPackagerClient.class.getSimpleName();

    @Override // com.facebook.react.packagerconnection.RequestHandler
    public final void onNotification(Object obj) {
        FLog.e(TAG, "Notification is not supported");
    }

    @Override // com.facebook.react.packagerconnection.RequestHandler
    public abstract void onRequest(Object obj, Responder responder);
}
