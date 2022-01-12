package org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.zao;
import com.google.android.gms.common.internal.zap;
import com.google.android.gms.internal.safetynet.zzl;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi$AttestationResponse;
import com.google.android.gms.safetynet.SafetyNetClient;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzu;
import com.google.common.util.concurrent.MoreExecutors;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.pathcheck.covidsafepaths.BuildConfig;

@DebugMetadata(c = "org.pathcheck.covidsafepaths.exposurenotifications.network.escrowserver.DeviceIDHelper$getDeviceID$2", f = "DeviceIDHelper.kt", l = {}, m = "invokeSuspend")
/* compiled from: DeviceIDHelper.kt */
public final class DeviceIDHelper$getDeviceID$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $nonceData;
    public CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceIDHelper$getDeviceID$2(Context context, String str, Continuation continuation) {
        super(2, continuation);
        this.$context = context;
        this.$nonceData = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        DeviceIDHelper$getDeviceID$2 deviceIDHelper$getDeviceID$2 = new DeviceIDHelper$getDeviceID$2(this.$context, this.$nonceData, continuation);
        deviceIDHelper$getDeviceID$2.p$ = (CoroutineScope) obj;
        return deviceIDHelper$getDeviceID$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        Continuation<? super String> continuation2 = continuation;
        Intrinsics.checkNotNullParameter(continuation2, "completion");
        DeviceIDHelper$getDeviceID$2 deviceIDHelper$getDeviceID$2 = new DeviceIDHelper$getDeviceID$2(this.$context, this.$nonceData, continuation2);
        deviceIDHelper$getDeviceID$2.p$ = coroutineScope;
        return deviceIDHelper$getDeviceID$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TResult tresult;
        String str;
        MoreExecutors.throwOnFailure(obj);
        SafetyNetClient client = SafetyNet.getClient(this.$context);
        String str2 = this.$nonceData;
        Charset charset = Charsets.UTF_8;
        if (str2 != null) {
            byte[] bytes = str2.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            Log.w("DeviceIDHelper", "nonce compare:" + new String(bytes, Charsets.UTF_8) + ':' + this.$nonceData);
            GoogleApiClient googleApiClient = client.zah;
            BaseImplementation$ApiMethodImpl enqueue = googleApiClient.enqueue(new zzl(googleApiClient, bytes, BuildConfig.SAFETY_NET_API_KEY));
            zao zao = new zao(new SafetyNetApi$AttestationResponse());
            PendingResultUtil.zaa zaa = PendingResultUtil.zaa;
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            enqueue.addStatusListener(new zap(enqueue, taskCompletionSource, zao, zaa));
            zzu<TResult> zzu = taskCompletionSource.zza;
            try {
                ReactYogaConfigProvider.await(zzu);
            } catch (Exception e) {
                String message = e.getMessage();
                Intrinsics.checkNotNull(message);
                Log.e("AttestationError:", message);
            }
            try {
                Intrinsics.checkNotNullExpressionValue(zzu, "task");
                tresult = zzu.getResult();
            } catch (Exception e2) {
                String message2 = e2.getMessage();
                Intrinsics.checkNotNull(message2);
                Log.e("DeviceIDHelper", message2);
                tresult = null;
            }
            String str3 = "";
            if (tresult == null) {
                return str3;
            }
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("response:");
            String jwsResult = tresult.getJwsResult();
            Intrinsics.checkNotNullExpressionValue(jwsResult, "result.jwsResult");
            outline17.append(StringsKt__StringNumberConversionsKt.split$default(jwsResult, new String[]{"."}, false, 0, 6).size());
            outline17.append("\n----------------------------------------\n");
            Log.w("DeviceIDHelper", outline17.toString());
            StringBuilder sb = new StringBuilder();
            sb.append("response parse:");
            DeviceIDHelper deviceIDHelper = DeviceIDHelper.INSTANCE;
            String jwsResult2 = tresult.getJwsResult();
            if (jwsResult2 == null) {
                Log.w("DeviceIDHelper", "null results");
                str = "result.jwsResult";
            } else {
                str = "result.jwsResult";
                List split$default = StringsKt__StringNumberConversionsKt.split$default(jwsResult2, new String[]{"."}, false, 0, 6);
                if (split$default.size() != 3) {
                    StringBuilder outline172 = GeneratedOutlineSupport.outline17("results size != 3 : ");
                    outline172.append(split$default.size());
                    Log.w("DeviceIDHelper", outline172.toString());
                } else {
                    byte[] decode = Base64.decode((String) split$default.get(1), 0);
                    Intrinsics.checkNotNullExpressionValue(decode, "Base64.decode(jwtParts[1], Base64.DEFAULT)");
                    try {
                        JSONObject jSONObject = new JSONObject(new String(decode, Charsets.UTF_8));
                        if (jSONObject.has("nonce")) {
                            str3 = str3 + "nonce:" + jSONObject.getString("nonce");
                        }
                        if (jSONObject.has("apkCertificateDigestSha256")) {
                            JSONArray jSONArray = jSONObject.getJSONArray("apkCertificateDigestSha256");
                            String[] strArr = new String[jSONArray.length()];
                            int length = jSONArray.length();
                            for (int i = 0; i < length; i++) {
                                strArr[i] = jSONArray.getString(i);
                            }
                            str3 = str3 + "\ncertDigests:" + strArr;
                        }
                        if (jSONObject.has("apkDigestSha256")) {
                            str3 = str3 + "\napkDigestSha256:" + jSONObject.getString("apkDigestSha256");
                        }
                        if (jSONObject.has("apkPackageName")) {
                            str3 = str3 + "\napkPackageName:" + jSONObject.getString("apkPackageName");
                        }
                        if (jSONObject.has("basicIntegrity")) {
                            str3 = str3 + "\nbasicIntegrity:" + jSONObject.getBoolean("basicIntegrity");
                        }
                        if (jSONObject.has("ctsProfileMatch")) {
                            str3 = str3 + "\nctsProfileMatch:" + jSONObject.getBoolean("ctsProfileMatch");
                        }
                        if (jSONObject.has("timestampMs")) {
                            str3 = str3 + "\ntimestampMs:" + jSONObject.getLong("timestampMs");
                        }
                        if (jSONObject.has("advice")) {
                            str3 = str3 + "\nadvice:" + jSONObject.getString("advice");
                        }
                    } catch (JSONException e3) {
                        StringBuilder outline173 = GeneratedOutlineSupport.outline17("problem parsing decodedJWTPayload:");
                        outline173.append(e3.getMessage());
                        Log.e("DeviceIDHelper", outline173.toString(), e3);
                    }
                    sb.append(str3);
                    Log.w("DeviceIDHelper", sb.toString());
                    String jwsResult3 = tresult.getJwsResult();
                    Intrinsics.checkNotNullExpressionValue(jwsResult3, str);
                    return jwsResult3;
                }
            }
            str3 = null;
            sb.append(str3);
            Log.w("DeviceIDHelper", sb.toString());
            String jwsResult32 = tresult.getJwsResult();
            Intrinsics.checkNotNullExpressionValue(jwsResult32, str);
            return jwsResult32;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
