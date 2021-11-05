package com.google.android.gms.nearby.messages.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import c.b.a.a.d.g;
import c.b.a.a.d.k.e;
import c.b.a.a.d.k.o.k;
import c.b.a.a.d.m.c;
import c.b.a.a.d.m.f;
import c.b.a.a.g.e.da;
import c.b.a.a.g.e.fa;
import c.b.a.a.g.e.ga;
import c.b.a.a.g.e.ia;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import java.lang.ref.WeakReference;

public final class zzai extends f<zzr> {
    public final ia<k.a, IBinder> zzd = new ia<>();
    public final ClientAppContext zze;
    public final int zzf;

    @TargetApi(14)
    public zzai(Context context, Looper looper, e.a aVar, e.b bVar, c cVar, MessagesOptions messagesOptions) {
        super(context, looper, 62, cVar, aVar, bVar);
        ClientAppContext clientAppContext;
        int i;
        String str = cVar.f3090e;
        int zza = zza(context);
        if (messagesOptions != null) {
            String str2 = messagesOptions.zza;
            boolean z = messagesOptions.zzb;
            String str3 = messagesOptions.zzd;
            this.zze = clientAppContext;
            i = messagesOptions.zzc;
        } else {
            clientAppContext = new ClientAppContext(str, null, false, null, zza);
            this.zze = clientAppContext;
            i = -1;
        }
        this.zzf = i;
        if (zza == 1) {
            Activity activity = (Activity) context;
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                String.format("Registering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", activity.getPackageName());
            }
            activity.getApplication().registerActivityLifecycleCallbacks(new zzak(activity, this));
        }
    }

    public static int zza(Context context) {
        if (context instanceof Activity) {
            return 1;
        }
        if (context instanceof Application) {
            return 2;
        }
        return context instanceof Service ? 3 : 0;
    }

    @Override // c.b.a.a.d.m.b
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
        return queryLocalInterface instanceof zzr ? (zzr) queryLocalInterface : new zzu(iBinder);
    }

    @Override // c.b.a.a.d.m.b, c.b.a.a.d.k.a.f
    public final void disconnect() {
        try {
            zza(2);
        } catch (RemoteException e2) {
            if (Log.isLoggable("NearbyMessagesClient", 2)) {
                String.format("Failed to emit CLIENT_DISCONNECTED from override of GmsClient#disconnect(): %s", e2);
            }
        }
        this.zzd.f3610a.clear();
        super.disconnect();
    }

    @Override // c.b.a.a.d.m.b
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle getServiceRequestExtraArgs = super.getGetServiceRequestExtraArgs();
        getServiceRequestExtraArgs.putInt("NearbyPermissions", this.zzf);
        getServiceRequestExtraArgs.putParcelable("ClientAppContext", this.zze);
        return getServiceRequestExtraArgs;
    }

    @Override // c.b.a.a.d.m.b, c.b.a.a.d.k.a.f
    public final int getMinApkVersion() {
        return g.f2932a;
    }

    @Override // c.b.a.a.d.m.b
    public final String getServiceDescriptor() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    @Override // c.b.a.a.d.m.b
    public final String getStartServiceAction() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    @Override // c.b.a.a.d.m.b, c.b.a.a.d.k.a.f
    public final boolean requiresGooglePlayServices() {
        return Nearby.zza(getContext());
    }

    public final void zza(int i) {
        String str;
        if (i == 1) {
            str = "ACTIVITY_STOPPED";
        } else if (i == 2) {
            str = "CLIENT_DISCONNECTED";
        } else if (Log.isLoggable("NearbyMessagesClient", 5)) {
            String.format("Received unknown/unforeseen client lifecycle event %d, can't do anything with it.", Integer.valueOf(i));
            return;
        } else {
            return;
        }
        if (isConnected()) {
            zzk zzk = new zzk(i);
            if (Log.isLoggable("NearbyMessagesClient", 3)) {
                String.format("Emitting client lifecycle event %s", str);
            }
            ((zzr) getService()).zza(zzk);
        } else if (Log.isLoggable("NearbyMessagesClient", 3)) {
            String.format("Failed to emit client lifecycle event %s due to GmsClient being disconnected", str);
        }
    }

    public final void zza(k<c.b.a.a.d.k.o.e<Status>> kVar, PendingIntent pendingIntent) {
        ((zzr) getService()).zza(new zzch(null, new fa(kVar), pendingIntent));
    }

    @Deprecated
    public final void zza(k<c.b.a.a.d.k.o.e<Status>> kVar, PendingIntent pendingIntent, zzac zzac, SubscribeOptions subscribeOptions) {
        zza(kVar, pendingIntent, zzac, subscribeOptions, this.zze.zza);
    }

    public final void zza(k<c.b.a.a.d.k.o.e<Status>> kVar, PendingIntent pendingIntent, zzac zzac, SubscribeOptions subscribeOptions, int i) {
        ((zzr) getService()).zza(new SubscribeRequest(null, subscribeOptions.getStrategy(), new fa(kVar), subscribeOptions.getFilter(), pendingIntent, null, zzac, subscribeOptions.zza, subscribeOptions.zzb, this.zze.zza));
    }

    public final void zza(k<c.b.a.a.d.k.o.e<Status>> kVar, k<MessageListener> kVar2) {
        k.a<L> aVar = kVar2.f3020c;
        if (aVar != null) {
            fa faVar = new fa(kVar);
            if (!(this.zzd.a(aVar) != null)) {
                faVar.zza(new Status(0, null));
                return;
            }
            ((zzr) getService()).zza(new zzch(this.zzd.a(aVar), faVar, null));
            this.zzd.f3610a.remove(aVar);
        }
    }

    @Deprecated
    public final void zza(k<c.b.a.a.d.k.o.e<Status>> kVar, k<MessageListener> kVar2, zzac zzac, SubscribeOptions subscribeOptions, byte[] bArr) {
        zza(kVar, kVar2, zzac, subscribeOptions, null, this.zze.zza);
    }

    public final void zza(k<c.b.a.a.d.k.o.e<Status>> kVar, zzag zzag) {
        ((zzr) getService()).zza(new zzcf(zzag, new fa(kVar)));
    }

    @Deprecated
    public final void zza(k<c.b.a.a.d.k.o.e<Status>> kVar, zzag zzag, zzw zzw, PublishOptions publishOptions) {
        zza(kVar, zzag, zzw, publishOptions, this.zze.zza);
    }

    public final void zza(k<c.b.a.a.d.k.o.e<Status>> kVar, zzag zzag, zzw zzw, PublishOptions publishOptions, int i) {
        ((zzr) getService()).zza(new zzca(zzag, publishOptions.getStrategy(), new fa(kVar), zzw, i));
    }

    public final void zzb(k<c.b.a.a.d.k.o.e<Status>> kVar, k<StatusCallback> kVar2) {
        k.a<L> aVar = kVar2.f3020c;
        if (aVar != null) {
            if (!(this.zzd.a(aVar) != null)) {
                this.zzd.f3610a.put(aVar, new WeakReference<>(new ga(kVar2)));
            }
            zzcc zzcc = new zzcc(new fa(kVar), this.zzd.a(aVar));
            zzcc.zza = true;
            ((zzr) getService()).zza(zzcc);
        }
    }

    public final void zzc(k<c.b.a.a.d.k.o.e<Status>> kVar, k<StatusCallback> kVar2) {
        k.a<L> aVar = kVar2.f3020c;
        if (aVar != null) {
            fa faVar = new fa(kVar);
            if (!(this.zzd.a(aVar) != null)) {
                faVar.zza(new Status(0, null));
                return;
            }
            zzcc zzcc = new zzcc(faVar, this.zzd.a(aVar));
            zzcc.zza = false;
            ((zzr) getService()).zza(zzcc);
            this.zzd.f3610a.remove(aVar);
        }
    }

    public final void zza(k<c.b.a.a.d.k.o.e<Status>> kVar, k<MessageListener> kVar2, zzac zzac, SubscribeOptions subscribeOptions, byte[] bArr, int i) {
        k.a<L> aVar = kVar2.f3020c;
        if (aVar != null) {
            if (!(this.zzd.a(aVar) != null)) {
                this.zzd.f3610a.put(aVar, new WeakReference<>(new da(kVar2)));
            }
            ((zzr) getService()).zza(new SubscribeRequest(this.zzd.a(aVar), subscribeOptions.getStrategy(), new fa(kVar), subscribeOptions.getFilter(), null, null, zzac, subscribeOptions.zza, i));
        }
    }
}
