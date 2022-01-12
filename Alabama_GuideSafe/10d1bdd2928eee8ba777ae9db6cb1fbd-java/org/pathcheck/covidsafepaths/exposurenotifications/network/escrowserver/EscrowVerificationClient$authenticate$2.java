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

@DebugMetadata(c = "org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.EscrowVerificationClient$authenticate$2", f = "EscrowVerificationClient.kt", l = {72}, m = "invokeSuspend")
/* compiled from: EscrowVerificationClient.kt */
public final class EscrowVerificationClient$authenticate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AuthResponse>, Object> {
    public final /* synthetic */ Context $context;
    public Object L$0;
    public int label;
    public CoroutineScope p$;

    @DebugMetadata(c = "org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.EscrowVerificationClient$authenticate$2$1", f = "EscrowVerificationClient.kt", l = {94}, m = "invokeSuspend")
    /* renamed from: org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.EscrowVerificationClient$authenticate$2$1  reason: invalid class name */
    /* compiled from: EscrowVerificationClient.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AuthResponse>, Object> {
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public int label;
        public CoroutineScope p$;
        public final /* synthetic */ EscrowVerificationClient$authenticate$2 this$0;

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
            String str;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int i = this.label;
            if (i == 0) {
                MoreExecutors.throwOnFailure(obj);
                CoroutineScope coroutineScope = this.p$;
                StringBuilder sb = new StringBuilder();
                DeviceIDHelper deviceIDHelper = DeviceIDHelper.INSTANCE;
                byte[] bArr = new byte[32];
                DeviceIDHelper.secureRandom.nextBytes(bArr);
                String encode = DeviceIDHelper.BASE64_LOWER.encode(bArr);
                Intrinsics.checkNotNullExpressionValue(encode, "BASE64_LOWER.encode(bytes)");
                sb.append(encode);
                sb.append(System.currentTimeMillis());
                String sb2 = sb.toString();
                Response<NonceResponse> execute = EscrowVerificationClient.access$getService$p(EscrowVerificationClient.INSTANCE).getNonce(sb2).execute();
                Intrinsics.checkNotNullExpressionValue(execute, "service.getNonce(uID).execute()");
                if (!execute.isSuccessful()) {
                    Log.w("BackendService", "Auth successful");
                    AuthResponse authResponse = new AuthResponse();
                    execute.code();
                    return authResponse;
                }
                String str2 = execute.rawResponse.headers().get("set-cookie");
                T t = execute.body;
                String str3 = t != null ? t.nonceData : null;
                Log.w("BackendService", "nonce:" + str3 + ", cookie:" + str2);
                if (str3 == null || str2 == null) {
                    return new AuthResponse();
                }
                DeviceIDHelper deviceIDHelper2 = DeviceIDHelper.INSTANCE;
                Context context = this.this$0.$context;
                this.L$0 = coroutineScope;
                this.L$1 = sb2;
                this.L$2 = execute;
                this.L$3 = str2;
                this.L$4 = str3;
                this.label = 1;
                obj = deviceIDHelper2.getDeviceID(str3, context, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
                str = str2;
            } else if (i == 1) {
                String str4 = (String) this.L$4;
                str = (String) this.L$3;
                Response response = (Response) this.L$2;
                String str5 = (String) this.L$1;
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    MoreExecutors.throwOnFailure(obj);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Response<AuthResponse> execute2 = EscrowVerificationClient.access$getService$p(EscrowVerificationClient.INSTANCE).auth(str, "device_code", "Android", (String) obj).execute();
            Intrinsics.checkNotNullExpressionValue(execute2, "resp");
            if (execute2.isSuccessful()) {
                ExposureNotificationSharedPreferences access$getSharedPrefs = EscrowVerificationClient.access$getSharedPrefs(EscrowVerificationClient.INSTANCE, this.this$0.$context);
                T t2 = execute2.body;
                String str6 = t2 != null ? t2.accessToken : null;
                T t3 = execute2.body;
                access$getSharedPrefs.setEscrowVerificationTokens(str6, t3 != null ? t3.refreshToken : null);
                return execute2.body;
            }
            AuthResponse authResponse2 = new AuthResponse();
            execute2.code();
            if (execute2.code() == 401) {
                Log.w("BackendService", "Authentication unauthorized");
            } else {
                Log.w("BackendService", "Authentication error: " + execute2.code());
            }
            return authResponse2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EscrowVerificationClient$authenticate$2(Context context, Continuation continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        EscrowVerificationClient$authenticate$2 escrowVerificationClient$authenticate$2 = new EscrowVerificationClient$authenticate$2(this.$context, continuation);
        escrowVerificationClient$authenticate$2.p$ = (CoroutineScope) obj;
        return escrowVerificationClient$authenticate$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AuthResponse> continuation) {
        Continuation<? super AuthResponse> continuation2 = continuation;
        Intrinsics.checkNotNullParameter(continuation2, "completion");
        EscrowVerificationClient$authenticate$2 escrowVerificationClient$authenticate$2 = new EscrowVerificationClient$authenticate$2(this.$context, continuation2);
        escrowVerificationClient$authenticate$2.p$ = coroutineScope;
        return escrowVerificationClient$authenticate$2.invokeSuspend(Unit.INSTANCE);
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
