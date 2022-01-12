package com.google.android.gms.common.internal;

import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zap implements PendingResult.StatusListener {
    public final /* synthetic */ PendingResult zaa;
    public final /* synthetic */ TaskCompletionSource zab;
    public final /* synthetic */ PendingResultUtil.ResultConverter zac;
    public final /* synthetic */ PendingResultUtil.zaa zad;

    public zap(PendingResult pendingResult, TaskCompletionSource taskCompletionSource, PendingResultUtil.ResultConverter resultConverter, PendingResultUtil.zaa zaa2) {
        this.zaa = pendingResult;
        this.zab = taskCompletionSource;
        this.zac = resultConverter;
        this.zad = zaa2;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void onComplete(Status status) {
        if (status.isSuccess()) {
            PendingResult pendingResult = this.zaa;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            BasePendingResult basePendingResult = (BasePendingResult) pendingResult;
            if (basePendingResult != null) {
                ReactYogaConfigProvider.checkState(!basePendingResult.zak, "Result has already been consumed.");
                ReactYogaConfigProvider.checkState(true, "Cannot await if then() has been called.");
                try {
                    if (!basePendingResult.zae.await(0, timeUnit)) {
                        basePendingResult.forceFailureUnlessReady(Status.RESULT_TIMEOUT);
                    }
                } catch (InterruptedException unused) {
                    basePendingResult.forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
                }
                ReactYogaConfigProvider.checkState(basePendingResult.isReady(), "Result is not ready.");
                TaskCompletionSource taskCompletionSource = this.zab;
                Response response = ((zao) this.zac).zaa;
                response.zza = (T) basePendingResult.zac();
                taskCompletionSource.zza.zza(response);
                return;
            }
            throw null;
        }
        TaskCompletionSource taskCompletionSource2 = this.zab;
        if (((zan) this.zad) != null) {
            taskCompletionSource2.zza.zza((Exception) ReactYogaConfigProvider.fromStatus(status));
            return;
        }
        throw null;
    }
}
