package com.google.android.gms.tasks;

import java.util.concurrent.CountDownLatch;

/* compiled from: com.google.android.gms:play-services-tasks@@17.2.0 */
public final class Tasks$zzb implements OnCanceledListener, OnFailureListener, OnSuccessListener {
    public final CountDownLatch zza = new CountDownLatch(1);

    public Tasks$zzb(zzy zzy) {
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void onCanceled() {
        this.zza.countDown();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.zza.countDown();
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.zza.countDown();
    }
}
