package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.zas;
import com.google.android.gms.signin.internal.zam;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zacc implements Runnable {
    public final /* synthetic */ zam zaa;
    public final /* synthetic */ zacb zab;

    public zacc(zacb zacb, zam zam) {
        this.zab = zacb;
        this.zaa = zam;
    }

    public final void run() {
        zacb zacb = this.zab;
        zam zam = this.zaa;
        if (zacb != null) {
            ConnectionResult connectionResult = zam.zab;
            if (connectionResult.isSuccess()) {
                zas zas = zam.zac;
                ReactYogaConfigProvider.checkNotNull(zas);
                ConnectionResult connectionResult2 = zas.zac;
                if (!connectionResult2.isSuccess()) {
                    String valueOf = String.valueOf(connectionResult2);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("SignInCoordinator", sb.toString(), new Exception());
                    ((GoogleApiManager.zac) zacb.zah).zaa(connectionResult2);
                    zacb.zag.disconnect();
                    return;
                }
                zace zace = zacb.zah;
                IAccountAccessor zaa2 = zas.zaa();
                Set<Scope> set = zacb.zae;
                GoogleApiManager.zac zac = (GoogleApiManager.zac) zace;
                if (zac == null) {
                    throw null;
                } else if (zaa2 == null || set == null) {
                    Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                    zac.zaa(new ConnectionResult(4));
                } else {
                    zac.zad = zaa2;
                    zac.zae = set;
                    if (zac.zaf) {
                        zac.zab.getRemoteService(zaa2, set);
                    }
                }
            } else {
                ((GoogleApiManager.zac) zacb.zah).zaa(connectionResult);
            }
            zacb.zag.disconnect();
            return;
        }
        throw null;
    }
}
