package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zacb;
import com.google.android.gms.common.api.internal.zacc;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.zar;
import com.google.android.gms.signin.zad;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public class SignInClientImpl extends GmsClient<zae> implements zad {
    public final boolean zaa;
    public final ClientSettings zab;
    public final Bundle zac;
    public final Integer zad;

    public SignInClientImpl(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull boolean z, @RecentlyNonNull ClientSettings clientSettings, @RecentlyNonNull Bundle bundle, @RecentlyNonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks, @RecentlyNonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zaa = z;
        this.zab = clientSettings;
        this.zac = bundle;
        this.zad = clientSettings.zak;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @RecentlyNonNull
    public /* synthetic */ IInterface createServiceInterface(@RecentlyNonNull IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof zae) {
            return (zae) queryLocalInterface;
        }
        return new zah(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @RecentlyNonNull
    public Bundle getGetServiceRequestExtraArgs() {
        if (!this.zzl.getPackageName().equals(this.zab.zag)) {
            this.zac.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zab.zag);
        }
        return this.zac;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    @RecentlyNonNull
    public int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @RecentlyNonNull
    public String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @RecentlyNonNull
    public String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    @RecentlyNonNull
    public boolean requiresSignIn() {
        return this.zaa;
    }

    @Override // com.google.android.gms.signin.zad
    public final void zaa(zac zac2) {
        ReactYogaConfigProvider.checkNotNull(zac2, "Expecting a valid ISignInCallbacks");
        try {
            Account account = this.zab.zaa;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(account.name)) {
                googleSignInAccount = Storage.getInstance(this.zzl).getSavedDefaultGoogleSignInAccount();
            }
            Integer num = this.zad;
            ReactYogaConfigProvider.checkNotNull(num);
            ((zae) getService()).zaa(new zak(new zar(account, num.intValue(), googleSignInAccount)), zac2);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zacb zacb = (zacb) zac2;
                zacb.zac.post(new zacc(zacb, new zam()));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // com.google.android.gms.signin.zad
    public final void zab() {
        BaseGmsClient.LegacyClientCallbackAdapter legacyClientCallbackAdapter = new BaseGmsClient.LegacyClientCallbackAdapter();
        ReactYogaConfigProvider.checkNotNull(legacyClientCallbackAdapter, "Connection progress callbacks cannot be null.");
        this.zzb = legacyClientCallbackAdapter;
        zza(2, null);
    }
}
