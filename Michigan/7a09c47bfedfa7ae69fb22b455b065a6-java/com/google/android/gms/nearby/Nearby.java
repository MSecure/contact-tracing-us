package com.google.android.gms.nearby;

import android.app.Activity;
import android.content.Context;
import b.x.t;
import c.b.a.a.d.k.a;
import c.b.a.a.d.p.b;
import c.b.a.a.g.e.bb;
import c.b.a.a.g.e.d6;
import c.b.a.a.g.e.f9;
import c.b.a.a.g.e.k8;
import c.b.a.a.g.e.la;
import c.b.a.a.g.e.u4;
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
    public static final a<ConnectionsOptions> CONNECTIONS_API = new a<>("Nearby.CONNECTIONS_API", d6.f3535b, d6.f3534a);
    @Deprecated
    public static final Connections Connections = new d6();
    @Deprecated
    public static final a<MessagesOptions> MESSAGES_API = new a<>("Nearby.MESSAGES_API", zzbh.zzc, zzbh.zzb);
    @Deprecated
    public static final Messages Messages = zzbh.zza;
    public static final zzd zza = new zzbx();
    @Deprecated
    public static final a<a.d.c> zzb = new a<>("Nearby.BOOTSTRAP_API", f9.f3567b, f9.f3566a);
    @Deprecated
    public static final k8 zzc = new f9();

    public static final ConnectionsClient getConnectionsClient(Activity activity) {
        t.D(activity, "Activity must not be null");
        return new u4(activity);
    }

    public static final ConnectionsClient getConnectionsClient(Context context) {
        t.D(context, "Context must not be null");
        return new u4(context);
    }

    public static ExposureNotificationClient getExposureNotificationClient(Context context) {
        t.D(context, "Context must not be null");
        return new bb(context);
    }

    public static final MessagesClient getMessagesClient(Activity activity) {
        t.D(activity, "Activity must not be null");
        return new zzaj(activity, (MessagesOptions) null);
    }

    public static final MessagesClient getMessagesClient(Activity activity, MessagesOptions messagesOptions) {
        t.D(activity, "Activity must not be null");
        t.D(messagesOptions, "Options must not be null");
        return new zzaj(activity, messagesOptions);
    }

    public static final MessagesClient getMessagesClient(Context context) {
        t.D(context, "Context must not be null");
        return new zzaj(context, (MessagesOptions) null);
    }

    public static final MessagesClient getMessagesClient(Context context, MessagesOptions messagesOptions) {
        t.D(context, "Context must not be null");
        t.D(messagesOptions, "Options must not be null");
        return new zzaj(context, messagesOptions);
    }

    public static boolean zza(Context context) {
        if (b.a(context).f3180a.checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
            return la.c(context.getContentResolver(), "gms:nearby:requires_gms_check");
        }
        return true;
    }
}
