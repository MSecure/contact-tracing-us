package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.nearby.zzks;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzal extends MessagesClient {
    private static final Api.ClientKey<zzag> zza;
    private static final Api.AbstractClientBuilder<zzag, MessagesOptions> zzb;
    private static final Api<MessagesOptions> zzc;
    private final int zzd;

    public zzal(Context context, MessagesOptions messagesOptions) {
        super(context, zzc, messagesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zzd = zzag.zza(context);
    }

    public zzal(Activity activity, MessagesOptions messagesOptions) {
        super(activity, zzc, messagesOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zzd = 1;
        activity.getApplication().registerActivityLifecycleCallbacks(new zzbd(activity, this, null));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> publish(Message message, PublishOptions publishOptions) {
        Preconditions.checkNotNull(message);
        Preconditions.checkNotNull(publishOptions);
        ListenerHolder zzb2 = zzb(message);
        return zza(zzb2, new zzak(this, message, new zzau(this, zzb(publishOptions.getCallback()), zzb2), publishOptions), new zzan(message));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> publish(Message message) {
        return publish(message, PublishOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unpublish(Message message) {
        Preconditions.checkNotNull(message);
        return zza(message);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(MessageListener messageListener, SubscribeOptions subscribeOptions) {
        Preconditions.checkNotNull(messageListener);
        Preconditions.checkNotNull(subscribeOptions);
        Preconditions.checkArgument(subscribeOptions.getStrategy().zza() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        ListenerHolder zzb2 = zzb(messageListener);
        ListenerHolder zzb3 = zzb(subscribeOptions.getCallback());
        return zza(zzb2, new zzam(this, zzb2, new zzax(this, zzb3, zzb3), subscribeOptions), new zzap(zzb2));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(MessageListener messageListener) {
        return subscribe(messageListener, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(PendingIntent pendingIntent, SubscribeOptions subscribeOptions) {
        zzbh zzbh;
        Preconditions.checkNotNull(pendingIntent);
        Preconditions.checkNotNull(subscribeOptions);
        ListenerHolder zzb2 = zzb(subscribeOptions.getCallback());
        if (zzb2 == null) {
            zzbh = null;
        } else {
            zzbh = new zzbh(zzb2);
        }
        return zza((zzbc) new zzao(this, pendingIntent, zzbh, subscribeOptions));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(PendingIntent pendingIntent) {
        return subscribe(pendingIntent, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unsubscribe(MessageListener messageListener) {
        Preconditions.checkNotNull(messageListener);
        return zza(messageListener);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unsubscribe(PendingIntent pendingIntent) {
        Preconditions.checkNotNull(pendingIntent);
        return zza((zzbc) new zzar(pendingIntent));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final void handleIntent(Intent intent, MessageListener messageListener) {
        zzks.zza(intent, messageListener);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> registerStatusCallback(StatusCallback statusCallback) {
        Preconditions.checkNotNull(statusCallback);
        ListenerHolder zzb2 = zzb(statusCallback);
        return zza(zzb2, new zzaq(zzb2), new zzat(zzb2));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unregisterStatusCallback(StatusCallback statusCallback) {
        Preconditions.checkNotNull(statusCallback);
        return zza(statusCallback);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.GoogleApi
    public final ClientSettings.Builder createClientSettingsBuilder() {
        ClientSettings.Builder createClientSettingsBuilder = super.createClientSettingsBuilder();
        if (getApiOptions() != null) {
            String str = ((MessagesOptions) getApiOptions()).zze;
        }
        return createClientSettingsBuilder;
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        zza((zzbc) new zzas(1));
    }

    /* access modifiers changed from: private */
    public final <T> ListenerHolder<BaseImplementation.ResultHolder<Status>> zza(TaskCompletionSource<T> taskCompletionSource) {
        return registerListener(new zzaw(this, taskCompletionSource), Status.class.getName());
    }

    private final <T> Task<Void> zza(T t) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        doUnregisterEventListener(ListenerHolders.createListenerKey(t, t.getClass().getName())).addOnCompleteListener(new zzaz(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private final <T> ListenerHolder<T> zzb(T t) {
        if (t == null) {
            return null;
        }
        return registerListener(t, t.getClass().getName());
    }

    private final <T> Task<Void> zza(ListenerHolder<T> listenerHolder, zzbc zzbc, zzbc zzbc2) {
        return doRegisterEventListener(new zzay(this, listenerHolder, zzbc), new zzbb(this, (ListenerHolder.ListenerKey) Preconditions.checkNotNull(listenerHolder.getListenerKey(), "Key must not be null"), zzbc2));
    }

    private final Task<Void> zza(zzbc zzbc) {
        return doWrite(new zzba(this, zzbc));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(PendingIntent pendingIntent, zzbh zzbh, SubscribeOptions subscribeOptions, zzag zzag, ListenerHolder listenerHolder) throws RemoteException {
        zzag.zza(listenerHolder, pendingIntent, zzbh, subscribeOptions, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(ListenerHolder listenerHolder, zzbh zzbh, SubscribeOptions subscribeOptions, zzag zzag, ListenerHolder listenerHolder2) throws RemoteException {
        zzag.zza(listenerHolder2, listenerHolder, zzbh, subscribeOptions, null, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Message message, zzbf zzbf, PublishOptions publishOptions, zzag zzag, ListenerHolder listenerHolder) throws RemoteException {
        zzag.zza(listenerHolder, zzae.zza(message), zzbf, publishOptions, this.zzd);
    }

    static {
        Api.ClientKey<zzag> clientKey = new Api.ClientKey<>();
        zza = clientKey;
        zzav zzav = new zzav();
        zzb = zzav;
        zzc = new Api<>("Nearby.MESSAGES_API", zzav, clientKey);
    }
}
