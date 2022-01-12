package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zabe implements Runnable {
    public final /* synthetic */ GoogleApiManager.zaa zaa;

    public zabe(GoogleApiManager.zaa zaa2) {
        this.zaa = zaa2;
    }

    public final void run() {
        this.zaa.zam();
    }
}
