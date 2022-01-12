package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zav implements PendingResult.StatusListener {
    public final /* synthetic */ BasePendingResult zaa;
    public final /* synthetic */ zaw zab;

    public zav(zaw zaw, BasePendingResult basePendingResult) {
        this.zab = zaw;
        this.zaa = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        this.zab.zaa.remove(this.zaa);
    }
}
