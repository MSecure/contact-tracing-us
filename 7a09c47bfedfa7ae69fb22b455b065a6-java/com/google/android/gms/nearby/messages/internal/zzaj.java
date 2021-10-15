package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import b.x.t;
import c.b.a.a.d.k.a;
import c.b.a.a.d.k.d;
import c.b.a.a.d.k.o.e;
import c.b.a.a.d.k.o.k;
import c.b.a.a.d.m.c;
import c.b.a.a.g.e.da;
import c.b.a.a.j.i;
import c.b.a.a.j.j;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;

public final class zzaj extends MessagesClient {
    public static final a.g<zzai> zza = new a.g<>();
    public static final a.AbstractC0062a<zzai, MessagesOptions> zzb;
    public static final a<MessagesOptions> zzc;
    public final int zzd;

    static {
        zzat zzat = new zzat();
        zzb = zzat;
        zzc = new a<>("Nearby.MESSAGES_API", zzat, zza);
    }

    public zzaj(Activity activity, MessagesOptions messagesOptions) {
        super(activity, zzc, messagesOptions, d.a.f2942c);
        this.zzd = 1;
        activity.getApplication().registerActivityLifecycleCallbacks(new zzbb(activity, this, null));
    }

    public zzaj(Context context, MessagesOptions messagesOptions) {
        super(context, zzc, messagesOptions, d.a.f2942c);
        this.zzd = zzai.zza(context);
    }

    /* access modifiers changed from: private */
    public final <T> k<e<Status>> zza(j<T> jVar) {
        return registerListener(new zzay(this, jVar), Status.class.getName());
    }

    private final <T> i<Void> zza(k<T> kVar, zzbe zzbe, zzbe zzbe2) {
        zzba zzba = new zzba(this, kVar, zzbe);
        k.a<L> aVar = kVar.f3020c;
        t.D(aVar, "Key must not be null");
        return doRegisterEventListener(zzba, new zzaz(this, aVar, zzbe2));
    }

    private final i<Void> zza(zzbe zzbe) {
        return doWrite(new zzbc(this, zzbe));
    }

    /* access modifiers changed from: private */
    public final void zza(int i) {
        zza((zzbe) new zzau(1));
    }

    private final <T> k<T> zzb(T t) {
        if (t == null) {
            return null;
        }
        return registerListener(t, t.getClass().getName());
    }

    @Override // c.b.a.a.d.k.d
    public final c.a createClientSettingsBuilder() {
        c.a createClientSettingsBuilder = super.createClientSettingsBuilder();
        if (getApiOptions() != null) {
            String str = ((MessagesOptions) getApiOptions()).zze;
        }
        return createClientSettingsBuilder;
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final void handleIntent(Intent intent, MessageListener messageListener) {
        da.e0(intent, messageListener);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final i<Void> publish(Message message) {
        return publish(message, PublishOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final i<Void> publish(Message message, PublishOptions publishOptions) {
        t.C(message);
        t.C(publishOptions);
        k zzb2 = zzb(message);
        return zza(zzb2, new zzam(this, message, new zzaw(this, zzb(publishOptions.getCallback()), zzb2), publishOptions), new zzal(message));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final i<Void> registerStatusCallback(StatusCallback statusCallback) {
        t.C(statusCallback);
        k zzb2 = zzb(statusCallback);
        return zza(zzb2, new zzas(zzb2), new zzar(zzb2));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final i<Void> subscribe(PendingIntent pendingIntent) {
        return subscribe(pendingIntent, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final i<Void> subscribe(PendingIntent pendingIntent, SubscribeOptions subscribeOptions) {
        t.C(pendingIntent);
        t.C(subscribeOptions);
        k zzb2 = zzb(subscribeOptions.getCallback());
        return zza((zzbe) new zzaq(this, pendingIntent, zzb2 == null ? null : new zzbf(zzb2), subscribeOptions));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final i<Void> subscribe(MessageListener messageListener) {
        return subscribe(messageListener, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final i<Void> subscribe(MessageListener messageListener, SubscribeOptions subscribeOptions) {
        t.C(messageListener);
        t.C(subscribeOptions);
        t.r(subscribeOptions.getStrategy().zza() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        k zzb2 = zzb(messageListener);
        k zzb3 = zzb(subscribeOptions.getCallback());
        return zza(zzb2, new zzao(this, zzb2, new zzav(this, zzb3, zzb3), subscribeOptions), new zzan(zzb2));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final i<Void> unpublish(Message message) {
        t.C(message);
        return zza(message);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final i<Void> unregisterStatusCallback(StatusCallback statusCallback) {
        t.C(statusCallback);
        return zza(statusCallback);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final i<Void> unsubscribe(PendingIntent pendingIntent) {
        t.C(pendingIntent);
        return zza((zzbe) new zzap(pendingIntent));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final i<Void> unsubscribe(MessageListener messageListener) {
        t.C(messageListener);
        return zza(messageListener);
    }

    public final /* synthetic */ void zza(PendingIntent pendingIntent, zzbf zzbf, SubscribeOptions subscribeOptions, zzai zzai, k kVar) {
        zzai.zza(kVar, pendingIntent, zzbf, subscribeOptions, this.zzd);
    }

    public final /* synthetic */ void zza(k kVar, zzbf zzbf, SubscribeOptions subscribeOptions, zzai zzai, k kVar2) {
        zzai.zza(kVar2, kVar, zzbf, subscribeOptions, null, this.zzd);
    }

    public final /* synthetic */ void zza(Message message, zzbd zzbd, PublishOptions publishOptions, zzai zzai, k kVar) {
        zzai.zza(kVar, zzag.zza(message), zzbd, publishOptions, this.zzd);
    }

    private final <T> i<Void> zza(T t) {
        j jVar = new j();
        doUnregisterEventListener(t.Y(t, t.getClass().getName())).b(new zzax(this, jVar));
        return jVar.f4109a;
    }
}
