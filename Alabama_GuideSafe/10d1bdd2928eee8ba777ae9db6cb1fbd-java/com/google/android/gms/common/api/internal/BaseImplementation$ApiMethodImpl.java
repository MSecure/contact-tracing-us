package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.safetynet.zzk$zza;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class BaseImplementation$ApiMethodImpl<R extends Result, A extends Api.AnyClient> extends BasePendingResult<R> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseImplementation$ApiMethodImpl(@RecentlyNonNull Api<?> api, @RecentlyNonNull GoogleApiClient googleApiClient) {
        super(googleApiClient);
        ReactYogaConfigProvider.checkNotNull(googleApiClient, "GoogleApiClient must not be null");
        ReactYogaConfigProvider.checkNotNull(api, "Api must not be null");
    }

    public abstract void doExecute(@RecentlyNonNull A a) throws RemoteException;

    public final void setFailedResult(@RecentlyNonNull Status status) {
        ReactYogaConfigProvider.checkArgument(!status.isSuccess(), "Failed result must not be success");
        setResult(new zzk$zza(status, null));
    }
}
