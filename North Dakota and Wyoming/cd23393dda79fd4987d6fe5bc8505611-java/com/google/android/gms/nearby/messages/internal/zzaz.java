package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzaz implements OnCompleteListener<Boolean> {
    private final /* synthetic */ TaskCompletionSource zza;

    zzaz(zzal zzal, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task<Boolean> task) {
        if (task.isSuccessful()) {
            this.zza.setResult(null);
        } else {
            this.zza.setException(task.getException());
        }
    }
}
