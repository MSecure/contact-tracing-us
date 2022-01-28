package com.google.android.gms.internal.nearby;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final /* synthetic */ class zzer implements OnCompleteListener {
    private final zzei zza;

    zzer(zzei zzei) {
        this.zza = zzei;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        this.zza.zza(task);
    }
}
