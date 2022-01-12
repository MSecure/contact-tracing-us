package org.pathcheck.covidsafepaths.exposurenotifications.reactmodules;

import com.facebook.react.bridge.Promise;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* compiled from: EscrowVerificationKeySubmissionModule.kt */
public final class EscrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1 implements FutureCallback<List<? extends TemporaryExposureKey>> {
    public final /* synthetic */ double $date;
    public final /* synthetic */ Promise $promise;
    public final /* synthetic */ String $verificationCode;
    public final /* synthetic */ EscrowVerificationKeySubmissionModule this$0;

    public EscrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1(EscrowVerificationKeySubmissionModule escrowVerificationKeySubmissionModule, double d, String str, Promise promise) {
        this.this$0 = escrowVerificationKeySubmissionModule;
        this.$date = d;
        this.$verificationCode = str;
        this.$promise = promise;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public void onFailure(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "exception");
        this.$promise.reject(th);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.common.util.concurrent.FutureCallback
    public void onSuccess(List<? extends TemporaryExposureKey> list) {
        MoreExecutors.launch$default(GlobalScope.INSTANCE, Dispatchers.IO, null, new EscrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1$onSuccess$1(this, list, null), 2, null);
    }
}
