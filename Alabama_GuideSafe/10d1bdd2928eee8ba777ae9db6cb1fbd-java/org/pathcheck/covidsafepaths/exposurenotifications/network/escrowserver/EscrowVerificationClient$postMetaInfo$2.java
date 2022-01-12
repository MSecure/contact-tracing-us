package org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import com.google.common.hash.AbstractHashFunction;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.hash.MessageDigestHashFunction;
import com.google.common.util.concurrent.MoreExecutors;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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

@DebugMetadata(c = "org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.EscrowVerificationClient$postMetaInfo$2", f = "EscrowVerificationClient.kt", l = {229}, m = "invokeSuspend")
/* compiled from: EscrowVerificationClient.kt */
public final class EscrowVerificationClient$postMetaInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $phone_number;
    public final /* synthetic */ List $teks;
    public Object L$0;
    public int label;
    public CoroutineScope p$;

    @DebugMetadata(c = "org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.EscrowVerificationClient$postMetaInfo$2$1", f = "EscrowVerificationClient.kt", l = {257, 263}, m = "invokeSuspend")
    /* renamed from: org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.EscrowVerificationClient$postMetaInfo$2$1  reason: invalid class name */
    /* compiled from: EscrowVerificationClient.kt */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
        public double D$0;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public Object L$5;
        public int label;
        public CoroutineScope p$;
        public final /* synthetic */ EscrowVerificationClient$postMetaInfo$2 this$0;

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

        /* JADX WARNING: Removed duplicated region for block: B:49:0x0188  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x0329  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            double d;
            String str;
            String str2;
            MetaInfoSubmission metaInfoSubmission;
            Response<SuccessResponse> response;
            String str3;
            MessageDigestHashFunction.MessageDigestHasher messageDigestHasher;
            byte[] bytes;
            HashCode hashCode;
            String str4;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            int i = this.label;
            String str5 = "";
            if (i == 0) {
                MoreExecutors.throwOnFailure(obj);
                coroutineScope = this.p$;
                d = Math.floor((double) (new Date().getTime() / ((long) 600000)));
                List<TemporaryExposureKey> list = this.this$0.$teks;
                ArrayList arrayList = new ArrayList();
                for (TemporaryExposureKey temporaryExposureKey : list) {
                    String str6 = ((double) (temporaryExposureKey.zzd + temporaryExposureKey.zzb)) <= d ? Base64.encodeToString(temporaryExposureKey.getKeyData(), 8) + '.' + temporaryExposureKey.zzb + '.' + temporaryExposureKey.zzd + '.' + temporaryExposureKey.zzc : null;
                    if (str6 != null) {
                        arrayList.add(str6);
                    }
                }
                Intrinsics.checkNotNullParameter(arrayList, "$this$joinToString");
                Intrinsics.checkNotNullParameter(",", "separator");
                Intrinsics.checkNotNullParameter(str5, "prefix");
                Intrinsics.checkNotNullParameter(str5, "postfix");
                Intrinsics.checkNotNullParameter("...", "truncated");
                StringBuilder sb = new StringBuilder();
                Intrinsics.checkNotNullParameter(arrayList, "$this$joinTo");
                Intrinsics.checkNotNullParameter(sb, "buffer");
                Intrinsics.checkNotNullParameter(",", "separator");
                Intrinsics.checkNotNullParameter(str5, "prefix");
                Intrinsics.checkNotNullParameter(str5, "postfix");
                Intrinsics.checkNotNullParameter("...", "truncated");
                sb.append((CharSequence) str5);
                Iterator it = arrayList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    Object next = it.next();
                    i2++;
                    if (i2 > 1) {
                        sb.append((CharSequence) ",");
                    }
                    Intrinsics.checkNotNullParameter(sb, "$this$appendElement");
                    if (next != null ? next instanceof CharSequence : true) {
                        sb.append((CharSequence) next);
                    } else if (next instanceof Character) {
                        sb.append(((Character) next).charValue());
                    } else {
                        sb.append((CharSequence) String.valueOf(next));
                    }
                }
                sb.append((CharSequence) str5);
                str = sb.toString();
                Intrinsics.checkNotNullExpressionValue(str, "joinTo(StringBuilder(), …ed, transform).toString()");
                AbstractHashFunction sha512 = Hashing.sha512();
                Charset charset = StandardCharsets.UTF_8;
                if (sha512 != null) {
                    MessageDigestHashFunction messageDigestHashFunction = (MessageDigestHashFunction) sha512;
                    if (messageDigestHashFunction.supportsClone) {
                        try {
                            messageDigestHasher = new MessageDigestHashFunction.MessageDigestHasher((MessageDigest) messageDigestHashFunction.prototype.clone(), messageDigestHashFunction.bytes, null);
                        } catch (CloneNotSupportedException unused) {
                        }
                        bytes = str.toString().getBytes(charset);
                        if (bytes == null) {
                            int length = bytes.length;
                            ReactYogaConfigProvider.checkState1(!messageDigestHasher.done, "Cannot re-use a Hasher after calling hash() on it");
                            messageDigestHasher.digest.update(bytes, 0, length);
                            ReactYogaConfigProvider.checkState1(!messageDigestHasher.done, "Cannot re-use a Hasher after calling hash() on it");
                            messageDigestHasher.done = true;
                            if (messageDigestHasher.bytes == messageDigestHasher.digest.getDigestLength()) {
                                hashCode = HashCode.fromBytesNoCopy(messageDigestHasher.digest.digest());
                            } else {
                                hashCode = HashCode.fromBytesNoCopy(Arrays.copyOf(messageDigestHasher.digest.digest(), messageDigestHasher.bytes));
                            }
                            str2 = hashCode.toString();
                            Intrinsics.checkNotNullExpressionValue(str2, "Hashing.sha512()\n       …              .toString()");
                            metaInfoSubmission = new MetaInfoSubmission(str2, this.this$0.$phone_number);
                            response = EscrowVerificationClient.access$getService$p(EscrowVerificationClient.INSTANCE).postMetaInfo("Bearer " + EscrowVerificationClient.access$getSharedPrefs(EscrowVerificationClient.INSTANCE, this.this$0.$context).sharedPreferences.getString("ExposureNotificationSharedPreferences.ESCROW_VERIFICATION_ACCESS_TOKEN", str5), metaInfoSubmission).execute();
                            Intrinsics.checkNotNullExpressionValue(response, "resp");
                            if (response.isSuccessful()) {
                                Log.w("BackendService", "Success");
                                return new Result.Success(Unit.INSTANCE);
                            } else if (response.code() == 401) {
                                Log.w("BackendService", "Refreshing token...");
                                EscrowVerificationClient escrowVerificationClient = EscrowVerificationClient.INSTANCE;
                                Context context = this.this$0.$context;
                                this.L$0 = coroutineScope;
                                this.D$0 = d;
                                this.L$1 = str;
                                this.L$2 = str2;
                                this.L$3 = metaInfoSubmission;
                                this.L$4 = response;
                                this.label = 1;
                                obj = MoreExecutors.coroutineScope(new EscrowVerificationClient$refresh$2(context, null), this);
                                if (obj == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            } else {
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Unknown error (");
                                sb2.append(response.code());
                                sb2.append("):");
                                ResponseBody responseBody = response.errorBody;
                                sb2.append(responseBody != null ? responseBody.string() : null);
                                Log.w("BackendService", sb2.toString());
                                int code = response.code();
                                ResponseBody responseBody2 = response.errorBody;
                                if (responseBody2 == null || (str4 = responseBody2.string()) == null) {
                                    str4 = str5;
                                }
                                return new Result.Failure(new Error(code, str4, null, 4));
                            }
                        } else {
                            throw null;
                        }
                    }
                    try {
                        messageDigestHasher = new MessageDigestHashFunction.MessageDigestHasher(MessageDigest.getInstance(messageDigestHashFunction.prototype.getAlgorithm()), messageDigestHashFunction.bytes, null);
                        bytes = str.toString().getBytes(charset);
                        if (bytes == null) {
                        }
                    } catch (NoSuchAlgorithmException e) {
                        throw new AssertionError(e);
                    }
                } else {
                    throw null;
                }
            } else if (i == 1) {
                response = (Response) this.L$4;
                metaInfoSubmission = (MetaInfoSubmission) this.L$3;
                str2 = (String) this.L$2;
                str = (String) this.L$1;
                d = this.D$0;
                coroutineScope = (CoroutineScope) this.L$0;
                MoreExecutors.throwOnFailure(obj);
            } else if (i == 2) {
                AuthResponse authResponse = (AuthResponse) this.L$5;
                Response response2 = (Response) this.L$4;
                MetaInfoSubmission metaInfoSubmission2 = (MetaInfoSubmission) this.L$3;
                String str7 = (String) this.L$2;
                String str8 = (String) this.L$1;
                CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                try {
                    MoreExecutors.throwOnFailure(obj);
                    return (Result) obj;
                } catch (Exception e2) {
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("MetaInfo EXCEPTION:");
                    outline17.append(e2.getLocalizedMessage());
                    Log.e("BackendService", outline17.toString());
                    String localizedMessage = e2.getLocalizedMessage();
                    if (localizedMessage != null) {
                        str5 = localizedMessage;
                    }
                    return new Result.Failure(new Error(600, str5, null, 4));
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AuthResponse authResponse2 = (AuthResponse) obj;
            if (authResponse2 != null) {
                EscrowVerificationClient.access$getSharedPrefs(EscrowVerificationClient.INSTANCE, this.this$0.$context).setEscrowVerificationTokens(authResponse2.accessToken, authResponse2.refreshToken);
                EscrowVerificationClient escrowVerificationClient2 = EscrowVerificationClient.INSTANCE;
                Context context2 = this.this$0.$context;
                List list2 = this.this$0.$teks;
                String str9 = this.this$0.$phone_number;
                this.L$0 = coroutineScope;
                this.D$0 = d;
                this.L$1 = str;
                this.L$2 = str2;
                this.L$3 = metaInfoSubmission;
                this.L$4 = response;
                this.L$5 = authResponse2;
                this.label = 2;
                obj = MoreExecutors.coroutineScope(new EscrowVerificationClient$postMetaInfo$2(list2, str9, context2, null), this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
                return (Result) obj;
            }
            Log.w("BackendService", "Auth error, couldn't refresh");
            int code2 = response.code();
            ResponseBody responseBody3 = response.errorBody;
            if (responseBody3 == null || (str3 = responseBody3.string()) == null) {
                str3 = str5;
            }
            return new Result.Failure(new Error(code2, str3, null, 4));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EscrowVerificationClient$postMetaInfo$2(List list, String str, Context context, Continuation continuation) {
        super(2, continuation);
        this.$teks = list;
        this.$phone_number = str;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        EscrowVerificationClient$postMetaInfo$2 escrowVerificationClient$postMetaInfo$2 = new EscrowVerificationClient$postMetaInfo$2(this.$teks, this.$phone_number, this.$context, continuation);
        escrowVerificationClient$postMetaInfo$2.p$ = (CoroutineScope) obj;
        return escrowVerificationClient$postMetaInfo$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit>> continuation) {
        Continuation<? super Result<? extends Unit>> continuation2 = continuation;
        Intrinsics.checkNotNullParameter(continuation2, "completion");
        EscrowVerificationClient$postMetaInfo$2 escrowVerificationClient$postMetaInfo$2 = new EscrowVerificationClient$postMetaInfo$2(this.$teks, this.$phone_number, this.$context, continuation2);
        escrowVerificationClient$postMetaInfo$2.p$ = coroutineScope;
        return escrowVerificationClient$postMetaInfo$2.invokeSuspend(Unit.INSTANCE);
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
