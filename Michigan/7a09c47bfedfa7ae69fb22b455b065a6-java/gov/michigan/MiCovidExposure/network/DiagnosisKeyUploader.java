package gov.michigan.MiCovidExposure.network;

import android.content.Context;
import android.net.Uri;
import b.b.k.i;
import b.f.a.b;
import b.x.t;
import c.a.b.f;
import c.a.b.l;
import c.a.b.n;
import c.a.b.q;
import c.a.b.v;
import c.a.b.x.h;
import c.b.b.b.c;
import c.b.b.b.e;
import c.b.b.c.a;
import c.b.b.e.a.u;
import e.a.a.e.k;
import e.a.a.e.m;
import e.a.a.e.o;
import e.a.a.e.p;
import e.a.a.e.r;
import e.a.a.e.s;
import g.b.a.c;
import gov.michigan.MiCovidExposure.BuildConfig;
import gov.michigan.MiCovidExposure.common.AppExecutors;
import gov.michigan.MiCovidExposure.notify.ShareDiagnosisViewModel;
import gov.michigan.MiCovidExposure.storage.ExposureNotificationSharedPreferences;
import gov.michigan.MiCovidExposure.utils.CustomUtility;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DiagnosisKeyUploader {
    public static final a BASE64 = a.f4692a;
    public static final int DEFAULT_PERIOD = 144;
    public static final int DEFAULT_TRANSMISSION_RISK = 1;
    public static final String DEFAULT_VERIFICATION_CODE = "POSITIVE_TEST_123456";
    public static final int FAKE_INTERVAL_NUM = 2650847;
    public static final int FAKE_SAFETYNET_ATTESTATION_LENGTH = 5394;
    public static final int KEY_SIZE_BYTES = 16;
    public static final int MAX_RETRIES = 3;
    public static final int PADDING_SIZE_MAX = 2048;
    public static final int PADDING_SIZE_MIN = 1024;
    public static final String PLATFORM = "android";
    public static final SecureRandom RAND = new SecureRandom();
    public static final float RETRY_BACKOFF = 1.0f;
    public static final String TAG = "KeyUploader";
    public static final c TIMEOUT = c.m(30);
    public static JSONObject certPayload = new JSONObject();
    public final Context context;
    public final CountryCodes countryCodes;
    public final DiagnosisAttestor diagnosisAttestor;
    public final Uris uris;

    public static class KeySubmission {
        public List<String> applicableCountryCodes;
        public c.b.b.b.c<DiagnosisKey> diagnosisKeys;
        public boolean isFakeTraffic;
        public long onSetDate;
        public JSONObject payload;
        public String revisionToken;
        public int transmissionRisk;
        public Uri uri;
        public String verificationCode;

        public KeySubmission() {
        }
    }

    public static class SubmitKeysRequest extends h<String> {
        public SubmitKeysRequest(Uri uri, JSONObject jSONObject, q.b<String> bVar, q.a aVar) {
            super(1, uri.toString(), jSONObject.toString(), bVar, aVar);
            setRetryPolicy(new f((int) DiagnosisKeyUploader.TIMEOUT.s(), 3, 1.0f));
        }

        @Override // c.a.b.x.h, c.a.b.o
        public String getBodyContentType() {
            return "application/json";
        }

        @Override // c.a.b.x.h, c.a.b.o
        public q<String> parseNetworkResponse(l lVar) {
            try {
                String str = new String(lVar.f2828b, t.k2(lVar.f2829c, h.PROTOCOL_CHARSET));
                if (lVar.f2827a < 400) {
                    return new q<>(str, t.j2(lVar));
                }
                return new q<>(new v(lVar));
            } catch (UnsupportedEncodingException e2) {
                StringBuilder h = c.a.a.a.a.h("UnsupportedEncodingException ");
                h.append(e2.getMessage());
                CustomUtility.customLogger(h.toString());
                String str2 = "UnsupportedEncodingException " + e2;
                return new q<>(new n(e2));
            } catch (Exception e3) {
                StringBuilder h2 = c.a.a.a.a.h("General Exception block ");
                h2.append(e3.getMessage());
                CustomUtility.customLogger(h2.toString());
                String str3 = "General Exception block " + e3;
                return new q<>(new n(e3));
            }
        }
    }

    public DiagnosisKeyUploader(Context context2) {
        this.context = context2;
        this.diagnosisAttestor = new DiagnosisAttestor(context2);
        this.countryCodes = new CountryCodes(context2);
        this.uris = new Uris(context2);
    }

    /* access modifiers changed from: private */
    /* renamed from: addCountryCodes */
    public u<List<KeySubmission>> g(List<KeySubmission> list, List<String> list2) {
        for (KeySubmission keySubmission : list) {
            keySubmission.applicableCountryCodes = list2;
        }
        return t.N1(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: addKeys */
    public u<List<KeySubmission>> f(List<KeySubmission> list, c.b.b.b.c<DiagnosisKey> cVar) {
        for (KeySubmission keySubmission : list) {
            keySubmission.diagnosisKeys = cVar;
        }
        return t.N1(list);
    }

    private u<KeySubmission> addPayload(KeySubmission keySubmission) {
        keySubmission.revisionToken = new ExposureNotificationSharedPreferences(this.context.getApplicationContext()).getRevisionToken("");
        keySubmission.onSetDate = new ExposureNotificationSharedPreferences(this.context.getApplicationContext()).getOnSetValue(0);
        JSONArray jSONArray = new JSONArray();
        try {
            e w = keySubmission.diagnosisKeys.listIterator();
            while (w.hasNext()) {
                DiagnosisKey diagnosisKey = (DiagnosisKey) w.next();
                String str = "Adding key: " + diagnosisKey + " to submission.";
                jSONArray.put(new JSONObject().put("key", BASE64.c(diagnosisKey.getKeyBytes())).put("rollingStartNumber", diagnosisKey.getIntervalNumber()).put("rollingPeriod", 144).put("transmissionRisk", 0));
            }
            JSONArray jSONArray2 = new JSONArray();
            for (String str2 : keySubmission.applicableCountryCodes) {
                jSONArray2.put(str2);
            }
            c.b.b.e.a.l<JSONObject> attestFor = this.diagnosisAttestor.attestFor(keySubmission.diagnosisKeys, keySubmission.applicableCountryCodes, keySubmission.verificationCode);
            c.b.b.e.a.l.r(attestFor);
            return attestFor.u(new e.a.a.e.l(keySubmission, jSONArray), AppExecutors.getLightweightExecutor());
        } catch (JSONException e2) {
            StringBuilder h = c.a.a.a.a.h("JSONException occurred while generating payload ");
            h.append(e2.getMessage());
            CustomUtility.customLogger(h.toString());
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: private */
    public u<List<KeySubmission>> addPayloads(List<KeySubmission> list) {
        ArrayList arrayList = new ArrayList();
        for (KeySubmission keySubmission : list) {
            arrayList.add(addPayload(keySubmission));
        }
        return t.k(arrayList);
    }

    public static /* synthetic */ u c(KeySubmission keySubmission, JSONArray jSONArray, JSONObject jSONObject) {
        keySubmission.payload = new JSONObject().put("temporaryExposureKeys", jSONArray).put("healthAuthorityID", BuildConfig.APPLICATION_ID).put("hmacKey", jSONObject.get("hmacKey")).put("verificationPayload", jSONObject.get("vcert")).put("revisionToken", keySubmission.revisionToken).put("padding", randomBase64Data(RAND.nextInt(1024) + 1024));
        if (keySubmission.onSetDate != 0) {
            keySubmission.payload.put("symptomOnsetInterval", keySubmission.onSetDate);
        }
        StringBuilder h = c.a.a.a.a.h("request NKS server ");
        h.append(keySubmission.payload);
        h.toString();
        return t.N1(keySubmission);
    }

    private u<?> doUpload(c.b.b.b.c<DiagnosisKey> cVar, boolean z) {
        if (cVar.isEmpty()) {
            return t.N1(null);
        }
        StringBuilder h = c.a.a.a.a.h("Uploading ");
        h.append(cVar.size());
        h.append(" keys...");
        CustomUtility.customLogger(h.toString());
        cVar.size();
        u N1 = t.N1(this.countryCodes.getExposureRelevantCountryCodes());
        c.b.b.e.a.l s = c.b.b.e.a.l.s(N1);
        Uris uris2 = this.uris;
        uris2.getClass();
        return s.u(new e.a.a.e.u(uris2), AppExecutors.getLightweightExecutor()).u(new r(this, z), AppExecutors.getLightweightExecutor()).u(new p(this, N1), AppExecutors.getLightweightExecutor()).u(new e.a.a.e.n(this, cVar), AppExecutors.getLightweightExecutor()).u(new e.a.a.e.q(this), AppExecutors.getLightweightExecutor()).u(new e.a.a.e.t(this), AppExecutors.getBackgroundExecutor());
    }

    public static /* synthetic */ void i(b bVar, v vVar) {
        if (vVar.f2851b.f2827a < 400 || !new String(vVar.f2851b.f2828b).contains("missing_revision_token")) {
            ShareDiagnosisViewModel.error_token_flag = "generic";
            CustomUtility.customLogger(String.format("A_CW_ERROR Diagnosis Key upload error: [%s]", new String(vVar.f2851b.f2828b)));
        } else {
            CustomUtility.customLogger("A_CW_ERROR Resubmission failed - Diagnosis Key upload error");
            ShareDiagnosisViewModel.error_token_flag = "revision_token";
        }
        bVar.b();
    }

    public static String randomBase64Data(int i) {
        byte[] bArr = new byte[((int) (((double) i) * 0.75d))];
        RAND.nextBytes(bArr);
        return BASE64.c(bArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: startSubmissionsForUris */
    public u<List<KeySubmission>> d(List<Uri> list, boolean z) {
        list.size();
        ArrayList arrayList = new ArrayList();
        for (Uri uri : list) {
            KeySubmission keySubmission = new KeySubmission();
            keySubmission.uri = uri;
            keySubmission.transmissionRisk = 1;
            keySubmission.verificationCode = DEFAULT_VERIFICATION_CODE;
            keySubmission.isFakeTraffic = z;
            arrayList.add(keySubmission);
        }
        return t.N1(arrayList);
    }

    /* access modifiers changed from: private */
    public u<List<Void>> submitToServers(List<KeySubmission> list) {
        ArrayList arrayList = new ArrayList();
        AtomicReference atomicReference = new AtomicReference("");
        for (KeySubmission keySubmission : list) {
            arrayList.add(i.j.z(new m(this, atomicReference, keySubmission)));
        }
        return t.k(arrayList);
    }

    public /* synthetic */ u e(u uVar, List list) {
        return c.b.b.e.a.l.s(uVar).u(new o(this, list), AppExecutors.getLightweightExecutor());
    }

    public u<?> fakeUpload() {
        c.a o = c.b.b.b.c.o();
        for (int i = 0; i < 14; i++) {
            byte[] bArr = new byte[16];
            RAND.nextBytes(bArr);
            o.a(DiagnosisKey.newBuilder().setKeyBytes(bArr).setIntervalNumber(FAKE_INTERVAL_NUM).build());
        }
        return doUpload(o.b(), true);
    }

    public /* synthetic */ void h(AtomicReference atomicReference, b bVar, String str) {
        if (str != null && !str.equals("")) {
            try {
                atomicReference.set(new JSONObject(str).getString("revisionToken"));
            } catch (JSONException unused) {
            }
        }
        CustomUtility.customLogger("Diagnosis Key upload succeeded.");
        if (atomicReference.get() != null && !((String) atomicReference.get()).equals("")) {
            new ExposureNotificationSharedPreferences(this.context.getApplicationContext()).setRevisionToken((String) atomicReference.get());
        }
        bVar.a(null);
    }

    public /* synthetic */ Object j(AtomicReference atomicReference, KeySubmission keySubmission, b bVar) {
        SubmitKeysRequest submitKeysRequest = new SubmitKeysRequest(keySubmission.uri, keySubmission.payload, new k(this, atomicReference, bVar), new s(bVar));
        RequestQueueSingleton.get(this.context).a(submitKeysRequest);
        return submitKeysRequest;
    }

    public u<?> upload(c.b.b.b.c<DiagnosisKey> cVar) {
        return doUpload(cVar, false);
    }
}
