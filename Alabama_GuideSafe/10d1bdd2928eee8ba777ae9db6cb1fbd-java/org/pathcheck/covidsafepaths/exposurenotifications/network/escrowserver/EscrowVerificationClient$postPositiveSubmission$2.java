package org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver;

import android.content.Context;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.gson.Gson;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNullPointerException;
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
import okhttp3.ResponseBody;
import org.pathcheck.covidsafepaths.exposurenotifications.utils.Error;
import org.pathcheck.covidsafepaths.exposurenotifications.utils.Result;
import retrofit2.Response;

@DebugMetadata(c = "org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.EscrowVerificationClient$postPositiveSubmission$2", f = "EscrowVerificationClient.kt", l = {149}, m = "invokeSuspend")
/* compiled from: EscrowVerificationClient.kt */
public final class EscrowVerificationClient$postPositiveSubmission$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ int $retries;
    public final /* synthetic */ PositiveSubmission $submission;
    public Object L$0;
    public int label;
    public CoroutineScope p$;

    @DebugMetadata(c = "org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.EscrowVerificationClient$postPositiveSubmission$2$1", f = "EscrowVerificationClient.kt", l = {170, 204, 210}, m = "invokeSuspend")
    /* renamed from: org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.EscrowVerificationClient$postPositiveSubmission$2$1  reason: invalid class name */
    /* compiled from: EscrowVerificationClient.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
        public int I$0;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public Object L$5;
        public Object L$6;
        public Object L$7;
        public Object L$8;
        public int label;
        public CoroutineScope p$;
        public final /* synthetic */ EscrowVerificationClient$postPositiveSubmission$2 this$0;

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
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
            Continuation<? super Result<? extends Unit>> continuation2 = continuation;
            Intrinsics.checkNotNullParameter(continuation2, "completion");
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, continuation2);
            r0.p$ = coroutineScope;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:61:0x0227  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0235  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x027e  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x02c3  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object obj2;
            CoroutineSingletons coroutineSingletons;
            CoroutineScope coroutineScope;
            String str;
            Response<NonceResponse> response;
            int i;
            String str2;
            Gson gson;
            String str3;
            Object obj3;
            Response<SuccessResponse> response2;
            String str4;
            AuthResponse authResponse;
            String string;
            Object obj4;
            String str5;
            PositiveSubmission positiveSubmission;
            CoroutineSingletons coroutineSingletons2;
            Response<SuccessResponse> execute;
            String string2;
            String string3;
            CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
            int i2 = this.label;
            String str6 = "";
            if (i2 == 0) {
                MoreExecutors.throwOnFailure(obj);
                CoroutineScope coroutineScope2 = this.p$;
                StringBuilder sb = new StringBuilder();
                DeviceIDHelper deviceIDHelper = DeviceIDHelper.INSTANCE;
                byte[] bArr = new byte[32];
                DeviceIDHelper.secureRandom.nextBytes(bArr);
                String encode = DeviceIDHelper.BASE64_LOWER.encode(bArr);
                Intrinsics.checkNotNullExpressionValue(encode, "BASE64_LOWER.encode(bytes)");
                sb.append(encode);
                sb.append(System.currentTimeMillis());
                String sb2 = sb.toString();
                Response<NonceResponse> execute2 = EscrowVerificationClient.access$getService$p(EscrowVerificationClient.INSTANCE).getNonce(sb2).execute();
                Intrinsics.checkNotNullExpressionValue(execute2, "service.getNonce(uID).execute()");
                if (!execute2.isSuccessful()) {
                    Log.w("BackendService", "Post nonce failed");
                    int code = execute2.code();
                    ResponseBody responseBody = execute2.errorBody;
                    if (!(responseBody == null || (string3 = responseBody.string()) == null)) {
                        str6 = string3;
                    }
                    return new Result.Failure(new Error(code, str6, null, 4));
                }
                String str7 = execute2.rawResponse.headers().get("set-cookie");
                T t = execute2.body;
                String str8 = t != null ? t.nonceData : null;
                if (str8 == null || str7 == null) {
                    Log.w("BackendService", "Post nonce failed nonce:" + str8 + ", cookie:" + str7);
                    return new Result.Success(Unit.INSTANCE);
                }
                EscrowVerificationClient$postPositiveSubmission$2 escrowVerificationClient$postPositiveSubmission$2 = this.this$0;
                PositiveSubmission positiveSubmission2 = escrowVerificationClient$postPositiveSubmission$2.$submission;
                DeviceIDHelper deviceIDHelper2 = DeviceIDHelper.INSTANCE;
                Context context = escrowVerificationClient$postPositiveSubmission$2.$context;
                this.L$0 = coroutineScope2;
                this.L$1 = sb2;
                this.L$2 = execute2;
                this.L$3 = str7;
                this.L$4 = str8;
                this.L$5 = positiveSubmission2;
                this.label = 1;
                obj4 = deviceIDHelper2.getDeviceID(str8, context, this);
                if (obj4 == coroutineSingletons3) {
                    return coroutineSingletons3;
                }
                str = sb2;
                coroutineScope = coroutineScope2;
                positiveSubmission = positiveSubmission2;
                response = execute2;
                str5 = str7;
                str2 = str8;
            } else if (i2 == 1) {
                positiveSubmission = (PositiveSubmission) this.L$5;
                str5 = (String) this.L$3;
                MoreExecutors.throwOnFailure(obj);
                str = (String) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                str2 = (String) this.L$4;
                response = (Response) this.L$2;
                obj4 = obj;
            } else if (i2 == 2) {
                response2 = (Response) this.L$7;
                int i3 = this.I$0;
                str3 = (String) this.L$6;
                gson = (Gson) this.L$5;
                str2 = (String) this.L$4;
                response = (Response) this.L$2;
                str = (String) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                MoreExecutors.throwOnFailure(obj);
                coroutineSingletons = coroutineSingletons3;
                str4 = (String) this.L$3;
                i = i3;
                obj3 = obj;
                authResponse = (AuthResponse) obj3;
                if (authResponse == null) {
                    EscrowVerificationClient.access$getSharedPrefs(EscrowVerificationClient.INSTANCE, this.this$0.$context).setEscrowVerificationTokens(authResponse.accessToken, authResponse.refreshToken);
                    EscrowVerificationClient escrowVerificationClient = EscrowVerificationClient.INSTANCE;
                    EscrowVerificationClient$postPositiveSubmission$2 escrowVerificationClient$postPositiveSubmission$22 = this.this$0;
                    Context context2 = escrowVerificationClient$postPositiveSubmission$22.$context;
                    this.L$0 = coroutineScope;
                    this.L$1 = str;
                    this.L$2 = response;
                    this.L$3 = str4;
                    this.L$4 = str2;
                    this.L$5 = gson;
                    this.L$6 = str3;
                    this.I$0 = i;
                    this.L$7 = response2;
                    this.L$8 = authResponse;
                    this.label = 3;
                    obj2 = MoreExecutors.coroutineScope(new EscrowVerificationClient$postPositiveSubmission$2(escrowVerificationClient$postPositiveSubmission$22.$submission, context2, escrowVerificationClient$postPositiveSubmission$22.$retries - 1, null), this);
                    if (obj2 == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    return (Result) obj2;
                }
                Log.w("BackendService", "Auth error, couldn't refresh");
                int code2 = response2.code();
                ResponseBody responseBody2 = response2.errorBody;
                if (!(responseBody2 == null || (string = responseBody2.string()) == null)) {
                    str6 = string;
                }
                return new Result.Failure(new Error(code2, str6, null, 4));
            } else if (i2 == 3) {
                AuthResponse authResponse2 = (AuthResponse) this.L$8;
                Response response3 = (Response) this.L$7;
                String str9 = (String) this.L$6;
                Gson gson2 = (Gson) this.L$5;
                String str10 = (String) this.L$4;
                String str11 = (String) this.L$3;
                Response response4 = (Response) this.L$2;
                String str12 = (String) this.L$1;
                CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                MoreExecutors.throwOnFailure(obj);
                obj2 = obj;
                return (Result) obj2;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str13 = (String) obj4;
            if (positiveSubmission != null) {
                Intrinsics.checkNotNullParameter(str13, "<set-?>");
                positiveSubmission.deviceVerificationPayload = str13;
                gson = new Gson();
                String json = gson.toJson(this.this$0.$submission);
                Log.w("BackendService", "submission:");
                int length = json.length() / RNCWebViewManager.COMMAND_CLEAR_FORM_DATA;
                if (length >= 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 * RNCWebViewManager.COMMAND_CLEAR_FORM_DATA;
                        int i6 = i4 + 1;
                        int i7 = i6 * RNCWebViewManager.COMMAND_CLEAR_FORM_DATA;
                        if (i7 > json.length()) {
                            i7 = json.length();
                        }
                        Intrinsics.checkNotNullExpressionValue(json, "sub_json");
                        Intrinsics.checkNotNullExpressionValue(json.substring(i5, i7), "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (i4 == length) {
                            break;
                        }
                        i4 = i6;
                    }
                }
                List<ExposureKey> list = this.this$0.$submission.keys;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Key:");
                        outline17.append(it.next().keyData);
                        Log.w("BackendService", outline17.toString());
                    }
                }
                try {
                    List<ExposureKey> list2 = this.this$0.$submission.keys;
                    Intrinsics.checkNotNull(list2);
                    if (list2.isEmpty()) {
                        Log.w("BackendService", "There are no keys");
                        coroutineSingletons2 = coroutineSingletons3;
                        try {
                            return new Result.Failure(new Error(999, "NoKeysOnDevice", null, 4));
                        } catch (KotlinNullPointerException unused) {
                            Log.e("BackendService", "Keys are null");
                            IBackendService access$getService$p = EscrowVerificationClient.access$getService$p(EscrowVerificationClient.INSTANCE);
                            StringBuilder outline172 = GeneratedOutlineSupport.outline17("Bearer ");
                            outline172.append(EscrowVerificationClient.access$getSharedPrefs(EscrowVerificationClient.INSTANCE, this.this$0.$context).sharedPreferences.getString("ExposureNotificationSharedPreferences.ESCROW_VERIFICATION_ACCESS_TOKEN", str6));
                            execute = access$getService$p.postPositiveDiagnosis(outline172.toString(), str5, this.this$0.$submission).execute();
                            Intrinsics.checkNotNullExpressionValue(execute, "resp");
                            if (execute.isSuccessful()) {
                            }
                        }
                    } else {
                        coroutineSingletons2 = coroutineSingletons3;
                        IBackendService access$getService$p2 = EscrowVerificationClient.access$getService$p(EscrowVerificationClient.INSTANCE);
                        StringBuilder outline1722 = GeneratedOutlineSupport.outline17("Bearer ");
                        outline1722.append(EscrowVerificationClient.access$getSharedPrefs(EscrowVerificationClient.INSTANCE, this.this$0.$context).sharedPreferences.getString("ExposureNotificationSharedPreferences.ESCROW_VERIFICATION_ACCESS_TOKEN", str6));
                        execute = access$getService$p2.postPositiveDiagnosis(outline1722.toString(), str5, this.this$0.$submission).execute();
                        Intrinsics.checkNotNullExpressionValue(execute, "resp");
                        if (execute.isSuccessful()) {
                            Log.w("BackendService", "Success");
                            return new Result.Success(Unit.INSTANCE);
                        } else if (execute.code() != 401 || this.this$0.$retries <= 0) {
                            StringBuilder outline173 = GeneratedOutlineSupport.outline17("Unknown error (");
                            outline173.append(execute.code());
                            outline173.append("):");
                            ResponseBody responseBody3 = execute.errorBody;
                            outline173.append(responseBody3 != null ? responseBody3.string() : null);
                            outline173.append('|');
                            outline173.append((Object) execute.body);
                            Log.w("BackendService", outline173.toString());
                            int code3 = execute.code();
                            ResponseBody responseBody4 = execute.errorBody;
                            if (!(responseBody4 == null || (string2 = responseBody4.string()) == null)) {
                                str6 = string2;
                            }
                            return new Result.Failure(new Error(code3, str6, null, 4));
                        } else {
                            Log.w("BackendService", "Refreshing token...");
                            EscrowVerificationClient escrowVerificationClient2 = EscrowVerificationClient.INSTANCE;
                            Context context3 = this.this$0.$context;
                            this.L$0 = coroutineScope;
                            this.L$1 = str;
                            this.L$2 = response;
                            this.L$3 = str5;
                            this.L$4 = str2;
                            this.L$5 = gson;
                            this.L$6 = json;
                            i = RNCWebViewManager.COMMAND_CLEAR_FORM_DATA;
                            this.I$0 = RNCWebViewManager.COMMAND_CLEAR_FORM_DATA;
                            this.L$7 = execute;
                            this.label = 2;
                            obj3 = MoreExecutors.coroutineScope(new EscrowVerificationClient$refresh$2(context3, null), this);
                            coroutineSingletons = coroutineSingletons2;
                            if (obj3 == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                            response2 = execute;
                            str4 = str5;
                            str3 = json;
                            authResponse = (AuthResponse) obj3;
                            if (authResponse == null) {
                            }
                        }
                    }
                } catch (KotlinNullPointerException unused2) {
                    coroutineSingletons2 = coroutineSingletons3;
                    Log.e("BackendService", "Keys are null");
                    IBackendService access$getService$p22 = EscrowVerificationClient.access$getService$p(EscrowVerificationClient.INSTANCE);
                    StringBuilder outline17222 = GeneratedOutlineSupport.outline17("Bearer ");
                    outline17222.append(EscrowVerificationClient.access$getSharedPrefs(EscrowVerificationClient.INSTANCE, this.this$0.$context).sharedPreferences.getString("ExposureNotificationSharedPreferences.ESCROW_VERIFICATION_ACCESS_TOKEN", str6));
                    execute = access$getService$p22.postPositiveDiagnosis(outline17222.toString(), str5, this.this$0.$submission).execute();
                    Intrinsics.checkNotNullExpressionValue(execute, "resp");
                    if (execute.isSuccessful()) {
                    }
                }
            } else {
                throw null;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EscrowVerificationClient$postPositiveSubmission$2(PositiveSubmission positiveSubmission, Context context, int i, Continuation continuation) {
        super(2, continuation);
        this.$submission = positiveSubmission;
        this.$context = context;
        this.$retries = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        EscrowVerificationClient$postPositiveSubmission$2 escrowVerificationClient$postPositiveSubmission$2 = new EscrowVerificationClient$postPositiveSubmission$2(this.$submission, this.$context, this.$retries, continuation);
        escrowVerificationClient$postPositiveSubmission$2.p$ = (CoroutineScope) obj;
        return escrowVerificationClient$postPositiveSubmission$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        Continuation<? super Result<? extends Unit>> continuation2 = continuation;
        Intrinsics.checkNotNullParameter(continuation2, "completion");
        EscrowVerificationClient$postPositiveSubmission$2 escrowVerificationClient$postPositiveSubmission$2 = new EscrowVerificationClient$postPositiveSubmission$2(this.$submission, this.$context, this.$retries, continuation2);
        escrowVerificationClient$postPositiveSubmission$2.p$ = coroutineScope;
        return escrowVerificationClient$postPositiveSubmission$2.invokeSuspend(Unit.INSTANCE);
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
