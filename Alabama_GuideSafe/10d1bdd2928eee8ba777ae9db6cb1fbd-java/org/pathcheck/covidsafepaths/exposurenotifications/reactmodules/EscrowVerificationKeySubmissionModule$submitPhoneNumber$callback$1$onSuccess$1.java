package org.pathcheck.covidsafepaths.exposurenotifications.reactmodules;

import com.facebook.react.bridge.ReactApplicationContext;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.EscrowVerificationClient;
import org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.EscrowVerificationClient$postMetaInfo$2;
import org.pathcheck.covidsafepaths.exposurenotifications.utils.Result;

@DebugMetadata(c = "org.pathcheck.covidsafepaths.exposurenotifications.reactmodules.EscrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1$onSuccess$1", f = "EscrowVerificationKeySubmissionModule.kt", l = {48}, m = "invokeSuspend")
/* compiled from: EscrowVerificationKeySubmissionModule.kt */
public final class EscrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ List $keys;
    public Object L$0;
    public Object L$1;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ EscrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EscrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1$onSuccess$1(EscrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1 escrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1, List list, Continuation continuation) {
        super(2, continuation);
        this.this$0 = escrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1;
        this.$keys = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        EscrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1$onSuccess$1 escrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1$onSuccess$1 = new EscrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1$onSuccess$1(this.this$0, this.$keys, continuation);
        escrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1$onSuccess$1.p$ = (CoroutineScope) obj;
        return escrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1$onSuccess$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> continuation2 = continuation;
        Intrinsics.checkNotNullParameter(continuation2, "completion");
        EscrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1$onSuccess$1 escrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1$onSuccess$1 = new EscrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1$onSuccess$1(this.this$0, this.$keys, continuation2);
        escrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1$onSuccess$1.p$ = coroutineScope;
        return escrowVerificationKeySubmissionModule$submitPhoneNumber$callback$1$onSuccess$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            MoreExecutors.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            List list = this.$keys;
            if (list != null) {
                EscrowVerificationClient escrowVerificationClient = EscrowVerificationClient.INSTANCE;
                ReactApplicationContext reactApplicationContext = this.this$0.this$0.getReactApplicationContext();
                Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "reactApplicationContext");
                String str = this.this$0.$phoneNumber;
                this.L$0 = coroutineScope;
                this.L$1 = list;
                this.label = 1;
                obj = MoreExecutors.coroutineScope(new EscrowVerificationClient$postMetaInfo$2(list, str, reactApplicationContext, null), this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                this.this$0.$promise.reject(new Exception("No exposure keys"));
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            List list2 = (List) this.L$1;
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            MoreExecutors.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result result = (Result) obj;
        if (result instanceof Result.Success) {
            this.this$0.$promise.resolve(null);
        } else if (result instanceof Result.Failure) {
            Result.Failure failure = (Result.Failure) result;
            this.this$0.$promise.reject(String.valueOf(failure.error.code), failure.error.message);
        }
        return Unit.INSTANCE;
    }
}
