package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import b.b.k.i;
import c.b.a.a.c.k.a;
import c.b.a.a.c.k.d;
import c.b.a.a.c.k.o.e;
import c.b.a.a.c.k.o.k;
import c.b.a.a.c.l.c;
import c.b.a.a.e.c.da;
import c.b.a.a.g.h;
import c.b.a.a.g.i;
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
    public static final a.AbstractC0055a<zzai, MessagesOptions> zzb;
    public static final a<MessagesOptions> zzc;
    public final int zzd;

    static {
        zzat zzat = new zzat();
        zzb = zzat;
        zzc = new a<>("Nearby.MESSAGES_API", zzat, zza);
    }

    public zzaj(Activity activity, MessagesOptions messagesOptions) {
        super(activity, zzc, messagesOptions, d.a.f2305c);
        this.zzd = 1;
        activity.getApplication().registerActivityLifecycleCallbacks(new zzbb(activity, this, null));
    }

    public zzaj(Context context, MessagesOptions messagesOptions) {
        super(context, zzc, messagesOptions, d.a.f2305c);
        this.zzd = zzai.zza(context);
    }

    /* access modifiers changed from: private */
    public final <T> k<e<Status>> zza(i<T> iVar) {
        return registerListener(new zzay(this, iVar), Status.class.getName());
    }

    private final <T> h<Void> zza(k<T> kVar, zzbe zzbe, zzbe zzbe2) {
        zzba zzba = new zzba(this, kVar, zzbe);
        k.a<L> aVar = kVar.f2377c;
        i.j.t(aVar, "Key must not be null");
        return doRegisterEventListener(zzba, new zzaz(this, aVar, zzbe2));
    }

    private final h<Void> zza(zzbe zzbe) {
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

    @Override // c.b.a.a.c.k.d
    public final c.a createClientSettingsBuilder() {
        c.a createClientSettingsBuilder = super.createClientSettingsBuilder();
        if (getApiOptions() != null) {
            String str = ((MessagesOptions) getApiOptions()).zze;
        }
        return createClientSettingsBuilder;
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final void handleIntent(Intent intent, MessageListener messageListener) {
        da.c(intent, messageListener);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final h<Void> publish(Message message) {
        return publish(message, PublishOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final h<Void> publish(Message message, PublishOptions publishOptions) {
        i.j.s(message);
        i.j.s(publishOptions);
        k zzb2 = zzb(message);
        return zza(zzb2, new zzam(this, message, new zzaw(this, zzb(publishOptions.getCallback()), zzb2), publishOptions), new zzal(message));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final h<Void> registerStatusCallback(StatusCallback statusCallback) {
        i.j.s(statusCallback);
        k zzb2 = zzb(statusCallback);
        return zza(zzb2, new zzas(zzb2), new zzar(zzb2));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final h<Void> subscribe(PendingIntent pendingIntent) {
        return subscribe(pendingIntent, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final h<Void> subscribe(PendingIntent pendingIntent, SubscribeOptions subscribeOptions) {
        i.j.s(pendingIntent);
        i.j.s(subscribeOptions);
        k zzb2 = zzb(subscribeOptions.getCallback());
        return zza((zzbe) new zzaq(this, pendingIntent, zzb2 == null ? null : new zzbf(zzb2), subscribeOptions));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final h<Void> subscribe(MessageListener messageListener) {
        return subscribe(messageListener, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final h<Void> subscribe(MessageListener messageListener, SubscribeOptions subscribeOptions) {
        i.j.s(messageListener);
        i.j.s(subscribeOptions);
        i.j.k(subscribeOptions.getStrategy().zza() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        k zzb2 = zzb(messageListener);
        k zzb3 = zzb(subscribeOptions.getCallback());
        return zza(zzb2, new zzao(this, zzb2, new zzav(this, zzb3, zzb3), subscribeOptions), new zzan(zzb2));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final h<Void> unpublish(Message message) {
        i.j.s(message);
        return zza(message);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final h<Void> unregisterStatusCallback(StatusCallback statusCallback) {
        i.j.s(statusCallback);
        return zza(statusCallback);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final h<Void> unsubscribe(PendingIntent pendingIntent) {
        i.j.s(pendingIntent);
        return zza((zzbe) new zzap(pendingIntent));
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final h<Void> unsubscribe(MessageListener messageListener) {
        i.j.s(messageListener);
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

    private final <T> h<Void> zza(T t) {
        c.b.a.a.g.i iVar = new c.b.a.a.g.i();
        doUnregisterEventListener(i.j.L(t, t.getClass().getName())).b(new zzax(this, iVar));
        return iVar.f2856a;
    }
}
