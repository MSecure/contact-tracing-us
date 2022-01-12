package org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver;

import android.content.Context;
import android.util.Log;
import com.google.common.util.concurrent.MoreExecutors;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.pathcheck.covidsafepaths.exposurenotifications.storage.ExposureNotificationSharedPreferences;
import retrofit2.Response;

@DebugMetadata(c = "org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.EscrowVerificationClient$refresh$2", f = "EscrowVerificationClient.kt", l = {122}, m = "invokeSuspend")
/* compiled from: EscrowVerificationClient.kt */
public final class EscrowVerificationClient$refresh$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AuthResponse>, Object> {
    public final /* synthetic */ Context $context;
    public Object L$0;
    public int label;
    public CoroutineScope p$;

    @DebugMetadata(c = "org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.EscrowVerificationClient$refresh$2$1", f = "EscrowVerificationClient.kt", l = {135}, m = "invokeSuspend")
    /* renamed from: org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.EscrowVerificationClient$refresh$2$1  reason: invalid class name */
    /* compiled from: EscrowVerificationClient.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AuthResponse>, Object> {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public int label;
        public CoroutineScope p$;
        public final /* synthetic */ EscrowVerificationClient$refresh$2 this$0;

        {
            this.this$0 = r1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, continuation);
            r0.p$ = (CoroutineScope) obj;
            return r0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AuthResponse> continuation) {
            Continuation<? super AuthResponse> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, continuation2);
            r0.p$ = coroutineScope;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int i = this.label;
            if (i == 0) {
                MoreExecutors.throwOnFailure(obj);
                CoroutineScope coroutineScope = this.p$;
                ExposureNotificationSharedPreferences access$getSharedPrefs = EscrowVerificationClient.access$getSharedPrefs(EscrowVerificationClient.INSTANCE, this.this$0.$context);
                IBackendService access$getService$p = EscrowVerificationClient.access$getService$p(EscrowVerificationClient.INSTANCE);
                String string = access$getSharedPrefs.sharedPreferences.getString("ExposureNotificationSharedPreferences.ESCROW_VERIFICATION_REFRESH_TOKEN", "");
                Intrinsics.checkNotNullExpressionValue(string, "prefs.getEscrowVerificationRefreshToken(\"\")");
                Response<AuthResponse> execute = access$getService$p.refreshToken(string, "refresh_token").execute();
                Intrinsics.checkNotNullExpressionValue(execute, "resp");
                String str = null;
                if (execute.isSuccessful()) {
                    Log.w("BackendService", "Refresh token success");
                    T t = execute.body;
                    String str2 = t != null ? t.accessToken : null;
                    T t2 = execute.body;
                    if (t2 != null) {
                        str = t2.refreshToken;
                    }
                    access$getSharedPrefs.setEscrowVerificationTokens(str2, str);
                    return execute.body;
                }
                AuthResponse authResponse = new AuthResponse();
                execute.code();
                if (execute.code() != 401) {
                    return authResponse;
                }
                Log.w("BackendService", "Re-authenticating");
                EscrowVerificationClient escrowVerificationClient = EscrowVerificationClient.INSTANCE;
                Context context = this.this$0.$context;
                this.L$0 = coroutineScope;
                this.L$1 = access$getSharedPrefs;
                this.L$2 = execute;
                this.L$3 = authResponse;
                this.label = 1;
                obj = MoreExecutors.coroutineScope(new EscrowVerificationClient$authenticate$2(context, null), this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else if (i == 1) {
                AuthResponse authResponse2 = (AuthResponse) this.L$3;
                Response response = (Response) this.L$2;
                ExposureNotificationSharedPreferences exposureNotificationSharedPreferences = (ExposureNotificationSharedPreferences) this.L$1;
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                MoreExecutors.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return (AuthResponse) obj;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EscrowVerificationClient$refresh$2(Context context, Continuation continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        EscrowVerificationClient$refresh$2 escrowVerificationClient$refresh$2 = new EscrowVerificationClient$refresh$2(this.$context, continuation);
        escrowVerificationClient$refresh$2.p$ = (CoroutineScope) obj;
        return escrowVerificationClient$refresh$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AuthResponse> continuation) {
        Continuation<? super AuthResponse> continuation2 = continuation;
        Intrinsics.checkNotNullParameter(continuation2, "completion");
        EscrowVerificationClient$refresh$2 escrowVerificationClient$refresh$2 = new EscrowVerificationClient$refresh$2(this.$context, continuation2);
        escrowVerificationClient$refresh$2.p$ = coroutineScope;
        return escrowVerificationClient$refresh$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int i = this.label;
        if (i == 0) {
            MoreExecutors.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            CoroutineDispatcher coroutineDispatcher = Dispatchers.IO;
            AnonymousClass1 r3 = new AnonymousClass1(this, null);
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = MoreExecutors.withContext(coroutineDispatcher, r3, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            MoreExecutors.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
