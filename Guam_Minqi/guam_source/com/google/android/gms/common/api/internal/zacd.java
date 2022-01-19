package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zacd implements Runnable {
    public final /* synthetic */ zacb zaa;

    public zacd(zacb zacb) {
        this.zaa = zacb;
    }

    public final void run() {
        ((GoogleApiManager.zac) this.zaa.zah).zaa(new ConnectionResult(4));
    }
}
