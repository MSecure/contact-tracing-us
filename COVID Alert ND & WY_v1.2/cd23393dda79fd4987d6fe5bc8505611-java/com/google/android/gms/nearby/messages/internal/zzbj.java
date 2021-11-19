package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.nearby.zzks;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzbj implements Messages {
    public static final zzbj zza = new zzbj();
    public static final Api.ClientKey<zzag> zzb = new Api.ClientKey<>();
    public static final Api.AbstractClientBuilder<zzag, MessagesOptions> zzc = new zzbi();

    private zzbj() {
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> publish(GoogleApiClient googleApiClient, Message message, PublishOptions publishOptions) {
        Preconditions.checkNotNull(message);
        Preconditions.checkNotNull(publishOptions);
        zzbs zzbs = null;
        ListenerHolder registerListener = publishOptions.getCallback() == null ? null : googleApiClient.registerListener(publishOptions.getCallback());
        if (registerListener != null) {
            zzbs = new zzbs(registerListener);
        }
        return googleApiClient.execute(new zzbk(this, googleApiClient, message, zzbs, publishOptions));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> publish(GoogleApiClient googleApiClient, Message message) {
        return publish(googleApiClient, message, PublishOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> unpublish(GoogleApiClient googleApiClient, Message message) {
        Preconditions.checkNotNull(message);
        return googleApiClient.execute(new zzbn(this, googleApiClient, message));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener, SubscribeOptions subscribeOptions) {
        Preconditions.checkNotNull(messageListener);
        Preconditions.checkNotNull(subscribeOptions);
        Preconditions.checkArgument(subscribeOptions.getStrategy().zza() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        ListenerHolder registerListener = googleApiClient.registerListener(messageListener);
        zzbx zzbx = null;
        ListenerHolder registerListener2 = subscribeOptions.getCallback() == null ? null : googleApiClient.registerListener(subscribeOptions.getCallback());
        if (registerListener2 != null) {
            zzbx = new zzbx(registerListener2);
        }
        return googleApiClient.execute(new zzbm(this, googleApiClient, registerListener, zzbx, subscribeOptions));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return subscribe(googleApiClient, messageListener, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent, SubscribeOptions subscribeOptions) {
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkNotNull(subscribeOptions);
        zzbx zzbx = null;
        ListenerHolder registerListener = subscribeOptions.getCallback() == null ? null : googleApiClient.registerListener(subscribeOptions.getCallback());
        if (registerListener != null) {
            zzbx = new zzbx(registerListener);
        }
        return googleApiClient.execute(new zzbp(this, googleApiClient, pendingIntent, zzbx, subscribeOptions));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return subscribe(googleApiClient, pendingIntent, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, MessageListener messageListener) {
        Preconditions.checkNotNull(messageListener);
        return googleApiClient.execute(new zzbo(this, googleApiClient, googleApiClient.registerListener(messageListener)));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        Preconditions.checkNotNull(pendingIntent);
        return googleApiClient.execute(new zzbr(this, googleApiClient, pendingIntent));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final void handleIntent(Intent intent, MessageListener messageListener) {
        zzks.zza(intent, messageListener);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> getPermissionStatus(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzbq(this, googleApiClient));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> registerStatusCallback(GoogleApiClient googleApiClient, StatusCallback statusCallback) {
        Preconditions.checkNotNull(statusCallback);
        return googleApiClient.execute(new zzbt(this, googleApiClient, googleApiClient.registerListener(statusCallback)));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> unregisterStatusCallback(GoogleApiClient googleApiClient, StatusCallback statusCallback) {
        Preconditions.checkNotNull(statusCallback);
        return googleApiClient.execute(new zzbl(this, googleApiClient, googleApiClient.registerListener(statusCallback)));
    }
}
