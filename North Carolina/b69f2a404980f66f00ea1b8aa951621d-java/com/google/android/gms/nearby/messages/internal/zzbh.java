package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.content.Intent;
import b.b.k.i;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.e;
import c.b.a.a.c.k.f;
import c.b.a.a.e.c.da;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;

public final class zzbh implements Messages {
    public static final zzbh zza = new zzbh();
    public static final a.g<zzai> zzb = new a.g<>();
    public static final a.AbstractC0055a<zzai, MessagesOptions> zzc = new zzbk();

    @Override // com.google.android.gms.nearby.messages.Messages
    public final f<Status> getPermissionStatus(e eVar) {
        return eVar.a(new zzbs(this, eVar));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final void handleIntent(Intent intent, MessageListener messageListener) {
        da.c(intent, messageListener);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final f<Status> publish(e eVar, Message message) {
        return publish(eVar, message, PublishOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final f<Status> publish(e eVar, Message message, PublishOptions publishOptions) {
        i.j.s(message);
        i.j.s(publishOptions);
        if (publishOptions.getCallback() == null) {
            return eVar.a(new zzbm(this, eVar, message, null, publishOptions));
        }
        publishOptions.getCallback();
        if (eVar != null) {
            throw new UnsupportedOperationException();
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final f<Status> registerStatusCallback(e eVar, StatusCallback statusCallback) {
        i.j.s(statusCallback);
        if (eVar != null) {
            throw new UnsupportedOperationException();
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final f<Status> subscribe(e eVar, PendingIntent pendingIntent) {
        return subscribe(eVar, pendingIntent, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final f<Status> subscribe(e eVar, PendingIntent pendingIntent, SubscribeOptions subscribeOptions) {
        i.j.s(pendingIntent);
        i.j.s(subscribeOptions);
        if (subscribeOptions.getCallback() == null) {
            return eVar.a(new zzbn(this, eVar, pendingIntent, null, subscribeOptions));
        }
        subscribeOptions.getCallback();
        if (eVar != null) {
            throw new UnsupportedOperationException();
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final f<Status> subscribe(e eVar, MessageListener messageListener) {
        return subscribe(eVar, messageListener, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final f<Status> unpublish(e eVar, Message message) {
        i.j.s(message);
        return eVar.a(new zzbl(this, eVar, message));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final f<Status> unregisterStatusCallback(e eVar, StatusCallback statusCallback) {
        i.j.s(statusCallback);
        if (eVar != null) {
            throw new UnsupportedOperationException();
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final f<Status> unsubscribe(e eVar, PendingIntent pendingIntent) {
        i.j.s(pendingIntent);
        return eVar.a(new zzbp(this, eVar, pendingIntent));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final f<Status> unsubscribe(e eVar, MessageListener messageListener) {
        i.j.s(messageListener);
        if (eVar != null) {
            throw new UnsupportedOperationException();
        }
        throw null;
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final f<Status> subscribe(e eVar, MessageListener messageListener, SubscribeOptions subscribeOptions) {
        i.j.s(messageListener);
        i.j.s(subscribeOptions);
        i.j.k(subscribeOptions.getStrategy().zza() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        if (eVar != null) {
            throw new UnsupportedOperationException();
        }
        throw null;
    }
}
