package com.google.android.gms.nearby;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.nearby.zzei;
import com.google.android.gms.internal.nearby.zzfq;
import com.google.android.gms.internal.nearby.zzkz;
import com.google.android.gms.internal.nearby.zzl;
import com.google.android.gms.internal.nearby.zzm;
import com.google.android.gms.internal.nearby.zzt;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.ConnectionsOptions;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.internal.zzal;
import com.google.android.gms.nearby.messages.internal.zzbj;
import com.google.android.gms.nearby.messages.internal.zzbz;
import com.google.android.gms.nearby.messages.zzd;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class Nearby {
    @Deprecated
    public static final Api<ConnectionsOptions> CONNECTIONS_API = new Api<>("Nearby.CONNECTIONS_API", zzfq.zzb, zzfq.zza);
    @Deprecated
    public static final Connections Connections = new zzfq();
    @Deprecated
    public static final Api<MessagesOptions> MESSAGES_API = new Api<>("Nearby.MESSAGES_API", zzbj.zzc, zzbj.zzb);
    @Deprecated
    public static final Messages Messages = zzbj.zza;
    private static final zzd zza = new zzbz();
    @Deprecated
    private static final Api<Api.ApiOptions.NoOptions> zzb = new Api<>("Nearby.BOOTSTRAP_API", zzm.zzb, zzm.zza);
    @Deprecated
    private static final zzl zzc = new zzm();

    private Nearby() {
    }

    public static final MessagesClient getMessagesClient(Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        return new zzal(activity, (MessagesOptions) null);
    }

    public static final MessagesClient getMessagesClient(Activity activity, MessagesOptions messagesOptions) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        Preconditions.checkNotNull(messagesOptions, "Options must not be null");
        return new zzal(activity, messagesOptions);
    }

    public static final MessagesClient getMessagesClient(Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        return new zzal(context, (MessagesOptions) null);
    }

    public static final MessagesClient getMessagesClient(Context context, MessagesOptions messagesOptions) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(messagesOptions, "Options must not be null");
        return new zzal(context, messagesOptions);
    }

    public static final ConnectionsClient getConnectionsClient(Activity activity) {
        Preconditions.checkNotNull(activity, "Activity must not be null");
        return new zzei(activity, (ConnectionsOptions) null);
    }

    public static final ConnectionsClient getConnectionsClient(Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        return new zzei(context, (ConnectionsOptions) null);
    }

    public static ExposureNotificationClient getExposureNotificationClient(Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        return new zzt(context);
    }

    public static boolean zza(Context context) {
        if (Wrappers.packageManager(context).checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
            return zzkz.zza(context.getContentResolver(), "gms:nearby:requires_gms_check", true);
        }
        return true;
    }
}
