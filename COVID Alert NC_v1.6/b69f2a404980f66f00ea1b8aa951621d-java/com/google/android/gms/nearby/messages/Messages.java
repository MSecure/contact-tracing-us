package com.google.android.gms.nearby.messages;

import android.app.PendingIntent;
import android.content.Intent;
import c.b.a.a.c.k.e;
import c.b.a.a.c.k.f;
import com.google.android.gms.common.api.Status;

@Deprecated
public interface Messages {
    @Deprecated
    f<Status> getPermissionStatus(e eVar);

    void handleIntent(Intent intent, MessageListener messageListener);

    f<Status> publish(e eVar, Message message);

    f<Status> publish(e eVar, Message message, PublishOptions publishOptions);

    f<Status> registerStatusCallback(e eVar, StatusCallback statusCallback);

    f<Status> subscribe(e eVar, PendingIntent pendingIntent);

    f<Status> subscribe(e eVar, PendingIntent pendingIntent, SubscribeOptions subscribeOptions);

    f<Status> subscribe(e eVar, MessageListener messageListener);

    f<Status> subscribe(e eVar, MessageListener messageListener, SubscribeOptions subscribeOptions);

    f<Status> unpublish(e eVar, Message message);

    f<Status> unregisterStatusCallback(e eVar, StatusCallback statusCallback);

    f<Status> unsubscribe(e eVar, PendingIntent pendingIntent);

    f<Status> unsubscribe(e eVar, MessageListener messageListener);
}
