package com.google.android.gms.nearby.messages;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.d;
import c.b.a.a.g.h;

public abstract class MessagesClient extends d<MessagesOptions> {
    public MessagesClient(Activity activity, a<MessagesOptions> aVar, MessagesOptions messagesOptions, d.a aVar2) {
        super(activity, (a) aVar, (a.d) messagesOptions, aVar2);
    }

    public MessagesClient(Context context, a<MessagesOptions> aVar, MessagesOptions messagesOptions, d.a aVar2) {
        super(context, aVar, messagesOptions, aVar2);
    }

    public abstract void handleIntent(Intent intent, MessageListener messageListener);

    public abstract h<Void> publish(Message message);

    public abstract h<Void> publish(Message message, PublishOptions publishOptions);

    public abstract h<Void> registerStatusCallback(StatusCallback statusCallback);

    public abstract h<Void> subscribe(PendingIntent pendingIntent);

    public abstract h<Void> subscribe(PendingIntent pendingIntent, SubscribeOptions subscribeOptions);

    public abstract h<Void> subscribe(MessageListener messageListener);

    public abstract h<Void> subscribe(MessageListener messageListener, SubscribeOptions subscribeOptions);

    public abstract h<Void> unpublish(Message message);

    public abstract h<Void> unregisterStatusCallback(StatusCallback statusCallback);

    public abstract h<Void> unsubscribe(PendingIntent pendingIntent);

    public abstract h<Void> unsubscribe(MessageListener messageListener);
}
