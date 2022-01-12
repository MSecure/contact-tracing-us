package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.RecentlyNonNull;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public abstract class GmsClient<T extends IInterface> extends BaseGmsClient<T> implements Api.Client {
    public final Set<Scope> zab;
    public final Account zac;

    /* JADX WARNING: Illegal instructions before constructor call */
    public GmsClient(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull int i, @RecentlyNonNull ClientSettings clientSettings, @RecentlyNonNull ConnectionCallbacks connectionCallbacks, @RecentlyNonNull OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, r4, r5, i, new zag(connectionCallbacks), new zai(onConnectionFailedListener), clientSettings.zah);
        synchronized (GmsClientSupervisor.zzb) {
            if (GmsClientSupervisor.zzc == null) {
                GmsClientSupervisor.zzc = new zzg(context.getApplicationContext());
            }
        }
        GmsClientSupervisor gmsClientSupervisor = GmsClientSupervisor.zzc;
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
        ReactYogaConfigProvider.checkNotNull(connectionCallbacks);
        ReactYogaConfigProvider.checkNotNull(onConnectionFailedListener);
        this.zac = clientSettings.zaa;
        Set<Scope> set = clientSettings.zac;
        for (Scope scope : set) {
            if (!set.contains(scope)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.zab = set;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.zab : Collections.emptySet();
    }
}
