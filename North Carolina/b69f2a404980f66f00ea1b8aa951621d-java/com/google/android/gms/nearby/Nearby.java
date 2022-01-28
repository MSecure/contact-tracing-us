package com.google.android.gms.nearby;

import android.app.Activity;
import android.content.Context;
import b.b.k.i;
import c.b.a.a.c.k.a;
import c.b.a.a.c.o.b;
import c.b.a.a.e.c.bb;
import c.b.a.a.e.c.d6;
import c.b.a.a.e.c.f9;
import c.b.a.a.e.c.k8;
import c.b.a.a.e.c.la;
import c.b.a.a.e.c.u4;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.internal.zzaj;
import com.google.android.gms.nearby.messages.internal.zzbh;
import com.google.android.gms.nearby.messages.internal.zzbx;
import com.google.android.gms.nearby.messages.zzd;

public final class Nearby {
    @Deprecated
    public static final a<ConnectionsOptions> CONNECTIONS_API = new a<>("Nearby.CONNECTIONS_API", d6.f2550b, d6.f2549a);
    @Deprecated
    public static final Connections Connections = new d6();
    @Deprecated
    public static final a<MessagesOptions> MESSAGES_API = new a<>("Nearby.MESSAGES_API", zzbh.zzc, zzbh.zzb);
    @Deprecated
    public static final Messages Messages = zzbh.zza;
    public static final zzd zza = new zzbx();
    @Deprecated
    public static final a<a.d.c> zzb = new a<>("Nearby.BOOTSTRAP_API", f9.f2582b, f9.f2581a);
    @Deprecated
    public static final k8 zzc = new f9();

    public static final ConnectionsClient getConnectionsClient(Activity activity) {
        i.j.t(activity, "Activity must not be null");
        return new u4(activity);
    }

    public static final ConnectionsClient getConnectionsClient(Context context) {
        i.j.t(context, "Context must not be null");
        return new u4(context);
    }

    public static ExposureNotificationClient getExposureNotificationClient(Context context) {
        i.j.t(context, "Context must not be null");
        return new bb(context);
    }

    public static final MessagesClient getMessagesClient(Activity activity) {
        i.j.t(activity, "Activity must not be null");
        return new zzaj(activity, (MessagesOptions) null);
    }

    public static final MessagesClient getMessagesClient(Activity activity, MessagesOptions messagesOptions) {
        i.j.t(activity, "Activity must not be null");
        i.j.t(messagesOptions, "Options must not be null");
        return new zzaj(activity, messagesOptions);
    }

    public static final MessagesClient getMessagesClient(Context context) {
        i.j.t(context, "Context must not be null");
        return new zzaj(context, (MessagesOptions) null);
    }

    public static final MessagesClient getMessagesClient(Context context, MessagesOptions messagesOptions) {
        i.j.t(context, "Context must not be null");
        i.j.t(messagesOptions, "Options must not be null");
        return new zzaj(context, messagesOptions);
    }

    public static boolean zza(Context context) {
        if (b.a(context).f2499a.checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
            return la.c(context.getContentResolver(), "gms:nearby:requires_gms_check");
        }
        return true;
    }
}
