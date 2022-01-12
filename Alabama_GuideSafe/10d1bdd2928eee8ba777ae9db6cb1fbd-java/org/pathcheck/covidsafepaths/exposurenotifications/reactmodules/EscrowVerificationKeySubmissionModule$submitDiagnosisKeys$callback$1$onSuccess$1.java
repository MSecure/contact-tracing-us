package org.pathcheck.covidsafepaths.exposurenotifications.reactmodules;

import com.facebook.react.bridge.ReactApplicationContext;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import com.google.common.util.concurrent.MoreExecutors;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.EscrowVerificationClient;
import org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.ExposureKey;
import org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.PositiveSubmission;
import org.pathcheck.covidsafepaths.exposurenotifications.utils.Result;

@DebugMetadata(c = "org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.EscrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1$onSuccess$1", f = "EscrowVerificationKeySubmissionModule.kt", l = {93}, m = "invokeSuspend")
/* compiled from: EscrowVerificationKeySubmissionModule.kt */
public final class EscrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ List $keys;
    public double D$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ EscrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EscrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1$onSuccess$1(EscrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1 escrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = escrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1;
        this.$keys = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        EscrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1$onSuccess$1 escrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1$onSuccess$1 = new EscrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1$onSuccess$1(this.this$0, this.$keys, continuation);
        escrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1$onSuccess$1.p$ = (CoroutineScope) obj;
        return escrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1$onSuccess$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> continuation2 = continuation;
        Intrinsics.checkNotNullParameter(continuation2, "completion");
        EscrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1$onSuccess$1 escrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1$onSuccess$1 = new EscrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1$onSuccess$1(this.this$0, this.$keys, continuation2);
        escrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1$onSuccess$1.p$ = coroutineScope;
        return escrowVerificationKeySubmissionModule$submitDiagnosisKeys$callback$1$onSuccess$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        ExposureKey exposureKey;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            MoreExecutors.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            List<TemporaryExposureKey> list = this.$keys;
            if (list != null) {
                double floor = Math.floor((double) (new Date().getTime() / ((long) 600000)));
                ArrayList arrayList = new ArrayList();
                for (TemporaryExposureKey temporaryExposureKey : list) {
                    if (temporaryExposureKey.getKeyData() == null || ((double) (temporaryExposureKey.zzd + temporaryExposureKey.zzb)) > floor) {
                        exposureKey = null;
                    } else {
                        byte[] keyData = temporaryExposureKey.getKeyData();
                        Intrinsics.checkNotNullExpressionValue(keyData, "temp.keyData");
                        exposureKey = new ExposureKey(keyData, temporaryExposureKey.zzd, temporaryExposureKey.zzc, temporaryExposureKey.zzb);
                    }
                    if (exposureKey != null) {
                        arrayList.add(exposureKey);
                    }
                }
                Date date = new Date((long) this.this$0.$date);
                EscrowVerificationClient escrowVerificationClient = EscrowVerificationClient.INSTANCE;
                ReactApplicationContext reactApplicationContext = this.this$0.this$0.getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "reactApplicationContext");
                PositiveSubmission positiveSubmission = new PositiveSubmission(arrayList, this.this$0.$verificationCode, new SimpleDateFormat("MM/dd/yyyy", Locale.US).format(date), null, null, null, null, 120);
                this.L$0 = coroutineScope;
                this.L$1 = list;
                this.D$0 = floor;
                this.L$2 = date;
                this.L$3 = arrayList;
                this.label = 1;
                obj2 = escrowVerificationClient.postPositiveSubmission(reactApplicationContext, positiveSubmission, 3, this);
                if (obj2 == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                this.this$0.$promise.reject(String.valueOf(999), "NoKeysOnDevice");
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            List list2 = (List) this.L$3;
            Date date2 = (Date) this.L$2;
            List list3 = (List) this.L$1;
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            MoreExecutors.throwOnFailure(obj);
            obj2 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result result = (Result) obj2;
        if (result instanceof Result.Success) {
            this.this$0.$promise.resolve(null);
        } else if (result instanceof Result.Failure) {
            Result.Failure failure = (Result.Failure) result;
            this.this$0.$promise.reject(String.valueOf(failure.error.code), failure.error.message);
        }
        return Unit.INSTANCE;
    }
}
