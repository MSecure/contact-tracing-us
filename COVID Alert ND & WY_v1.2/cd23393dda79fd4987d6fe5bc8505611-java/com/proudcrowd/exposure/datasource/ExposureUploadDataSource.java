package com.proudcrowd.exposure.datasource;

import android.net.Uri;
import android.util.Log;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.bugfender.sdk.Bugfender;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.io.BaseEncoding;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FluentFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import com.google.gson.GsonBuilder;
import com.proudcrowd.exposure.core.DiagnosisKey;
import com.proudcrowd.exposure.core.ExposureApplication;
import com.proudcrowd.exposure.datamodel.ConsentDetail;
import com.proudcrowd.exposure.datamodel.ConsentPostDetail;
import com.proudcrowd.exposure.datamodel.DiagnosisKeyPostDetail;
import com.proudcrowd.exposure.datasource.ExposureUploadDataSource;
import com.proudcrowd.exposure.misc.AppExecutors;
import com.proudcrowd.exposure.misc.StringUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.threeten.bp.Duration;

/* access modifiers changed from: package-private */
public class ExposureUploadDataSource {
    private static final BaseEncoding BASE64 = BaseEncoding.base64();
    private static final Joiner COMMA_JOINER = Joiner.on(',');
    private static final int FAKE_SIGNED_JWT_LENGTH = 5394;
    private static final String HASH_ALGO = "HmacSHA256";
    private static final int HASH_KEY_SIZE = 32;
    private static final int PADDING_SIZE_MAX = 2048;
    private static final int PADDING_SIZE_MIN = 1024;
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String TAG = "ExposureUploadDataSource";
    private final ExposureApplication applicationContext;
    private final RequestQueue httpRequestQueue;
    private final String regionCode;

    ExposureUploadDataSource(ExposureApplication exposureApplication, RequestQueue requestQueue, String str) {
        this.applicationContext = exposureApplication;
        this.httpRequestQueue = requestQueue;
        this.regionCode = str;
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<?> execute(Uri uri, ImmutableList<DiagnosisKey> immutableList) {
        return doUpload(uri, immutableList, false);
    }

    /* access modifiers changed from: package-private */
    public ListenableFuture<?> executeFakeTraffic(Uri uri, ImmutableList<DiagnosisKey> immutableList) {
        return doUpload(uri, immutableList, true);
    }

    private ListenableFuture<?> doUpload(Uri uri, ImmutableList<DiagnosisKey> immutableList, boolean z) {
        ListenableFuture listenableFuture;
        if (immutableList.isEmpty()) {
            return Futures.immediateFuture(null);
        }
        Hmac calculate = Hmac.calculate(immutableList);
        if (z) {
            listenableFuture = Futures.immediateFuture(null);
        } else {
            listenableFuture = new ConsentPostDataSource(this.applicationContext.mDeviceGuid, new ConsentPostDetail(this.applicationContext.mCitizenCode, calculate.hashValue)).ExecuteFutureRequest();
        }
        return FluentFuture.from(listenableFuture).transformAsync(new AsyncFunction(z, immutableList, calculate, uri) {
            /* class com.proudcrowd.exposure.datasource.$$Lambda$ExposureUploadDataSource$wEEdIutWjsBI6VCyyHyh1kVnYpo */
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ ImmutableList f$2;
            public final /* synthetic */ ExposureUploadDataSource.Hmac f$3;
            public final /* synthetic */ Uri f$4;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
                this.f$4 = r5;
            }

            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return ExposureUploadDataSource.this.lambda$doUpload$0$ExposureUploadDataSource(this.f$1, this.f$2, this.f$3, this.f$4, (ConsentDetail) obj);
            }
        }, AppExecutors.getBackgroundExecutor());
    }

    public /* synthetic */ ListenableFuture lambda$doUpload$0$ExposureUploadDataSource(boolean z, ImmutableList immutableList, Hmac hmac, Uri uri, ConsentDetail consentDetail) throws Exception {
        boolean z2;
        int i;
        String str;
        if (!z && !consentDetail.isValidCitizenCode) {
            return Futures.immediateFuture(null);
        }
        if (z) {
            str = StringUtils.randomBase64Data(FAKE_SIGNED_JWT_LENGTH);
            z2 = false;
            i = (int) (System.currentTimeMillis() / TimeUnit.MINUTES.toMillis(10));
        } else {
            boolean z3 = consentDetail.isTraveler;
            String str2 = consentDetail.verificationPayload;
            i = consentDetail.symptomOnsetInterval;
            z2 = z3;
            str = str2;
        }
        return submitToKeyServer(uri, createUploadPayload(immutableList, hmac.hashKey, str, i, z2), z);
    }

    private DiagnosisKeyPostDetail createUploadPayload(ImmutableList<DiagnosisKey> immutableList, String str, String str2, int i, boolean z) {
        DiagnosisKeyPostDetail diagnosisKeyPostDetail = new DiagnosisKeyPostDetail();
        diagnosisKeyPostDetail.padding = StringUtils.randomBase64Data(RANDOM.nextInt(1024) + 1024);
        diagnosisKeyPostDetail.healthAuthorityID = this.applicationContext.getPackageName();
        diagnosisKeyPostDetail.symptomOnsetInterval = i;
        diagnosisKeyPostDetail.traveler = z;
        diagnosisKeyPostDetail.hmacKey = str;
        diagnosisKeyPostDetail.verificationPayload = str2;
        diagnosisKeyPostDetail.temporaryExposureKeys = immutableList;
        return diagnosisKeyPostDetail;
    }

    private ListenableFuture<Void> submitToKeyServer(Uri uri, DiagnosisKeyPostDetail diagnosisKeyPostDetail, boolean z) {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver(z, diagnosisKeyPostDetail, uri) {
            /* class com.proudcrowd.exposure.datasource.$$Lambda$ExposureUploadDataSource$3QOqRfmtDaxUq04747fGuhM2214 */
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ DiagnosisKeyPostDetail f$2;
            public final /* synthetic */ Uri f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return ExposureUploadDataSource.this.lambda$submitToKeyServer$3$ExposureUploadDataSource(this.f$1, this.f$2, this.f$3, completer);
            }
        });
    }

    public /* synthetic */ Object lambda$submitToKeyServer$3$ExposureUploadDataSource(boolean z, DiagnosisKeyPostDetail diagnosisKeyPostDetail, Uri uri, CallbackToFutureAdapter.Completer completer) throws Exception {
        $$Lambda$ExposureUploadDataSource$u35aa854bFPGQc0dMXtn8xS2c3g r4 = new Response.Listener() {
            /* class com.proudcrowd.exposure.datasource.$$Lambda$ExposureUploadDataSource$u35aa854bFPGQc0dMXtn8xS2c3g */

            @Override // com.android.volley.Response.Listener
            public final void onResponse(Object obj) {
                ExposureUploadDataSource.lambda$null$1(CallbackToFutureAdapter.Completer.this, (String) obj);
            }
        };
        $$Lambda$ExposureUploadDataSource$H5Q5Uw3PSvxDjPQuZelaLv10H0 r5 = new Response.ErrorListener(z, completer) {
            /* class com.proudcrowd.exposure.datasource.$$Lambda$ExposureUploadDataSource$H5Q5Uw3PSvxDjPQuZelaLv10H0 */
            public final /* synthetic */ boolean f$0;
            public final /* synthetic */ CallbackToFutureAdapter.Completer f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            @Override // com.android.volley.Response.ErrorListener
            public final void onErrorResponse(VolleyError volleyError) {
                ExposureUploadDataSource.lambda$null$2(this.f$0, this.f$1, volleyError);
            }
        };
        String json = new GsonBuilder().disableHtmlEscaping().setExclusionStrategies(new DiagnosisKey.SerializationExclusionStrategy()).create().toJson(diagnosisKeyPostDetail);
        String str = TAG;
        Log.d(str, "Submitting " + json);
        SubmitKeysRequest submitKeysRequest = new SubmitKeysRequest(uri, json, z, r4, r5);
        this.httpRequestQueue.add(submitKeysRequest);
        return submitKeysRequest;
    }

    static /* synthetic */ void lambda$null$1(CallbackToFutureAdapter.Completer completer, String str) {
        Log.i(TAG, String.format("Diagnosis Key upload succeeded. [%s]", str != null ? str.toString() : ""));
        completer.set(null);
    }

    static /* synthetic */ void lambda$null$2(boolean z, CallbackToFutureAdapter.Completer completer, VolleyError volleyError) {
        String str;
        if (volleyError == null || volleyError.networkResponse == null) {
            str = "Unknown key upload error";
        } else {
            if (volleyError.networkResponse.data != null) {
                str = new String(volleyError.networkResponse.data, StandardCharsets.UTF_8);
            } else {
                str = String.format("%s: %s", String.valueOf(volleyError.networkResponse.statusCode), volleyError.getClass().getSimpleName());
            }
            if (z && (volleyError instanceof AuthFailureError)) {
                completer.set(null);
                return;
            }
        }
        Log.e(TAG, String.format("Diagnosis Key upload error. [%s]", str));
        Bugfender.d("Diagnosis Key upload error.", str);
        completer.setException(new VolleyError(str));
    }

    /* access modifiers changed from: private */
    public static class Hmac {
        private String hashKey;
        private String hashValue;

        Hmac(String str, String str2) {
            this.hashKey = str;
            this.hashValue = str2;
        }

        /* access modifiers changed from: private */
        public static Hmac calculate(List<DiagnosisKey> list) {
            ArrayList arrayList = new ArrayList();
            for (DiagnosisKey diagnosisKey : list) {
                arrayList.add(String.format(Locale.getDefault(), "%s.%d.%d.%d", diagnosisKey.getKey(), Integer.valueOf(diagnosisKey.getRollingStartNumber()), Integer.valueOf(diagnosisKey.getRollingPeriod()), Integer.valueOf(diagnosisKey.getTransmissionRisk())));
            }
            Collections.sort(arrayList);
            byte[] bytes = ExposureUploadDataSource.COMMA_JOINER.join(arrayList).getBytes();
            byte[] bArr = new byte[32];
            ExposureUploadDataSource.RANDOM.nextBytes(bArr);
            try {
                Mac instance = Mac.getInstance(ExposureUploadDataSource.HASH_ALGO);
                instance.init(new SecretKeySpec(bArr, ExposureUploadDataSource.HASH_ALGO));
                return new Hmac(ExposureUploadDataSource.BASE64.encode(bArr), ExposureUploadDataSource.BASE64.encode(instance.doFinal(bytes)));
            } catch (InvalidKeyException | NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static class SubmitKeysRequest extends JsonRequest<String> {
        private static final int MAX_RETRIES = 3;
        private static final float RETRY_BACKOFF = 1.0f;
        private static final Duration TIMEOUT = Duration.ofSeconds(30);
        private boolean isCoverTraffic;

        @Override // com.android.volley.Request, com.android.volley.toolbox.JsonRequest
        public String getBodyContentType() {
            return AbstractSpiCall.ACCEPT_JSON_VALUE;
        }

        SubmitKeysRequest(Uri uri, String str, boolean z, Response.Listener<String> listener, Response.ErrorListener errorListener) {
            super(1, uri.toString(), str, listener, errorListener);
            setRetryPolicy(new DefaultRetryPolicy((int) TIMEOUT.toMillis(), 3, 1.0f));
            this.isCoverTraffic = z;
        }

        /* access modifiers changed from: protected */
        @Override // com.android.volley.Request, com.android.volley.toolbox.JsonRequest
        public Response<String> parseNetworkResponse(NetworkResponse networkResponse) {
            try {
                String str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers, "utf-8"));
                boolean z = true;
                boolean z2 = networkResponse.statusCode < 400;
                if (this.isCoverTraffic && !z2) {
                    if (networkResponse.statusCode != 401) {
                        z = false;
                    }
                    z2 = z;
                }
                if (z2) {
                    return Response.success(str, HttpHeaderParser.parseCacheHeaders(networkResponse));
                }
                return Response.error(new VolleyError(networkResponse));
            } catch (UnsupportedEncodingException e) {
                return Response.error(new ParseError(e));
            }
        }

        @Override // com.android.volley.Request
        public Map<String, String> getHeaders() throws AuthFailureError {
            Map<String, String> headers = super.getHeaders();
            if (!this.isCoverTraffic) {
                return headers;
            }
            HashMap hashMap = new HashMap();
            if (headers != null) {
                hashMap.putAll(headers);
            }
            hashMap.put("X-Chaff", "true");
            return hashMap;
        }
    }
}
