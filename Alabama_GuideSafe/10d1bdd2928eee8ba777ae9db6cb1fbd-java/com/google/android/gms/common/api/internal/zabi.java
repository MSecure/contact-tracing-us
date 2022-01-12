package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.IAccountAccessor;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zabi implements Runnable {
    public final /* synthetic */ ConnectionResult zaa;
    public final /* synthetic */ GoogleApiManager.zac zab;

    public zabi(GoogleApiManager.zac zac, ConnectionResult connectionResult) {
        this.zab = zac;
        this.zaa = connectionResult;
    }

    public final void run() {
        IAccountAccessor iAccountAccessor;
        GoogleApiManager.zac zac = this.zab;
        GoogleApiManager.zaa<?> zaa2 = GoogleApiManager.this.zam.get(zac.zac);
        if (zaa2 != null) {
            if (this.zaa.isSuccess()) {
                GoogleApiManager.zac zac2 = this.zab;
                zac2.zaf = true;
                if (zac2.zab.requiresSignIn()) {
                    GoogleApiManager.zac zac3 = this.zab;
                    if (zac3.zaf && (iAccountAccessor = zac3.zad) != null) {
                        zac3.zab.getRemoteService(iAccountAccessor, zac3.zae);
                        return;
                    }
                    return;
                }
                try {
                    this.zab.zab.getRemoteService(null, this.zab.zab.getScopesForConnectionlessNonSignIn());
                } catch (SecurityException e) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
                    this.zab.zab.disconnect("Failed to get service from broker.");
                    zaa2.zaa(new ConnectionResult(10), null);
                }
            } else {
                zaa2.zaa(this.zaa, null);
            }
        }
    }
}
