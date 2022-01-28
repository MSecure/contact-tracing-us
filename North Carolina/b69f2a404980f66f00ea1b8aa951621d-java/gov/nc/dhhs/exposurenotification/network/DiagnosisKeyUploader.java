package gov.nc.dhhs.exposurenotification.network;

import android.content.Context;
import android.net.Uri;
import b.b.k.i;
import b.f.a.b;
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
import d.a.a.a.g.k;
import d.a.a.a.g.m;
import d.a.a.a.g.o;
import d.a.a.a.g.p;
import d.a.a.a.g.r;
import d.a.a.a.g.s;
import d.a.a.a.g.t;
import e.c.a.c;
import gov.nc.dhhs.exposurenotification.common.AppExecutors;
import gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisViewModel;
import gov.nc.dhhs.exposurenotification.storage.ExposureNotificationSharedPreferences;
import gov.nc.dhhs.exposurenotification.utils.CustomUtility;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DiagnosisKeyUploader {
    public static final a BASE64 = a.f3351a;
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
    public static final c TIMEOUT = c.k(30);
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
            setRetryPolicy(new f((int) DiagnosisKeyUploader.TIMEOUT.p(), 3, 1.0f));
        }

        @Override // c.a.b.x.h, c.a.b.o
        public String getBodyContentType() {
            return "application/json";
        }

        @Override // c.a.b.x.h, c.a.b.o
        public q<String> parseNetworkResponse(l lVar) {
            try {
                String str = new String(lVar.f2218b, i.j.L0(lVar.f2219c, h.PROTOCOL_CHARSET));
                if (lVar.f2217a < 400) {
                    return new q<>(str, i.j.K0(lVar));
                }
                return new q<>(new v(lVar));
            } catch (UnsupportedEncodingException e2) {
                StringBuilder g = c.a.a.a.a.g("UnsupportedEncodingException ");
                g.append(e2.getMessage());
                CustomUtility.customLogger(g.toString());
                String str2 = "UnsupportedEncodingException " + e2;
                return new q<>(new n(e2));
            } catch (Exception e3) {
                StringBuilder g2 = c.a.a.a.a.g("General Exception block ");
                g2.append(e3.getMessage());
                CustomUtility.customLogger(g2.toString());
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
        return c.b.a.a.c.n.c.k1(list);
    }

    /* access modifiers changed from: private */
    /* renamed from: addKeys */
    public u<List<KeySubmission>> f(List<KeySubmission> list, c.b.b.b.c<DiagnosisKey> cVar) {
        for (KeySubmission keySubmission : list) {
            keySubmission.diagnosisKeys = cVar;
        }
        return c.b.a.a.c.n.c.k1(list);
    }

    private u<KeySubmission> addPayload(KeySubmission keySubmission) {
        keySubmission.revisionToken = new ExposureNotificationSharedPreferences(this.context.getApplicationContext()).getRevisionToken("");
        keySubmission.onSetDate = new ExposureNotificationSharedPreferences(this.context.getApplicationContext()).getOnSetValue(0);
        JSONArray jSONArray = new JSONArray();
        try {
            e u = keySubmission.diagnosisKeys.listIterator();
            while (u.hasNext()) {
                DiagnosisKey diagnosisKey = (DiagnosisKey) u.next();
                String str = "Adding key: " + diagnosisKey + " to submission.";
                CustomUtility.customLogger("Adding key: " + diagnosisKey + " to submission.");
                jSONArray.put(new JSONObject().put("key", BASE64.c(diagnosisKey.getKeyBytes())).put("rollingStartNumber", diagnosisKey.getIntervalNumber()).put("rollingPeriod", 144).put("transmissionRisk", 0));
            }
            JSONArray jSONArray2 = new JSONArray();
            for (String str2 : keySubmission.applicableCountryCodes) {
                jSONArray2.put(str2);
            }
            c.b.b.e.a.l<JSONObject> attestFor = this.diagnosisAttestor.attestFor(keySubmission.diagnosisKeys, keySubmission.applicableCountryCodes, keySubmission.verificationCode);
            c.b.b.e.a.l.r(attestFor);
            return attestFor.u(new k(keySubmission, jSONArray), AppExecutors.getLightweightExecutor());
        } catch (JSONException e2) {
            StringBuilder g = c.a.a.a.a.g("JSONException occurred while generating payload ");
            g.append(e2.getMessage());
            CustomUtility.customLogger(g.toString());
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: private */
    public u<List<KeySubmission>> addPayloads(List<KeySubmission> list) {
        ArrayList arrayList = new ArrayList();
        for (KeySubmission keySubmission : list) {
            arrayList.add(addPayload(keySubmission));
        }
        return c.b.a.a.c.n.c.k(arrayList);
    }

    public static /* synthetic */ u b(KeySubmission keySubmission, JSONArray jSONArray, JSONObject jSONObject) {
        keySubmission.payload = new JSONObject().put("temporaryExposureKeys", jSONArray).put("healthAuthorityID", "gov.nc.dhhs.exposurenotifications").put("hmacKey", jSONObject.get("hmacKey")).put("verificationPayload", jSONObject.get("vcert")).put("revisionToken", keySubmission.revisionToken).put("padding", randomBase64Data(RAND.nextInt(1024) + 1024));
        if (keySubmission.onSetDate != 0) {
            keySubmission.payload.put("symptomOnsetInterval", keySubmission.onSetDate);
        }
        StringBuilder g = c.a.a.a.a.g("request NKS server ");
        g.append(keySubmission.payload);
        g.toString();
        return c.b.a.a.c.n.c.k1(keySubmission);
    }

    private u<?> doUpload(c.b.b.b.c<DiagnosisKey> cVar, boolean z) {
        if (cVar.isEmpty()) {
            return c.b.a.a.c.n.c.k1(null);
        }
        StringBuilder g = c.a.a.a.a.g("Uploading ");
        g.append(cVar.size());
        g.append(" keys...");
        CustomUtility.customLogger(g.toString());
        cVar.size();
        u k1 = c.b.a.a.c.n.c.k1(this.countryCodes.getExposureRelevantCountryCodes());
        c.b.b.e.a.l s = c.b.b.e.a.l.s(k1);
        Uris uris2 = this.uris;
        uris2.getClass();
        return s.u(new d.a.a.a.g.u(uris2), AppExecutors.getLightweightExecutor()).u(new s(this, z), AppExecutors.getLightweightExecutor()).u(new m(this, k1), AppExecutors.getLightweightExecutor()).u(new p(this, cVar), AppExecutors.getLightweightExecutor()).u(new d.a.a.a.g.l(this), AppExecutors.getLightweightExecutor()).u(new d.a.a.a.g.q(this), AppExecutors.getBackgroundExecutor());
    }

    public static /* synthetic */ void i(b bVar, v vVar) {
        if (vVar.f2238b.f2217a < 400 || !new String(vVar.f2238b.f2218b).contains("missing_revision_token")) {
            ShareDiagnosisViewModel.error_token_flag = "generic";
            CustomUtility.customLogger(String.format("A_CW_ERROR Diagnosis Key upload error: [%s]", new String(vVar.f2238b.f2218b)));
            new String(vVar.f2238b.f2218b);
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
        return c.b.a.a.c.n.c.k1(arrayList);
    }

    /* access modifiers changed from: private */
    public u<List<Void>> submitToServers(List<KeySubmission> list) {
        ArrayList arrayList = new ArrayList();
        AtomicReference atomicReference = new AtomicReference("");
        for (KeySubmission keySubmission : list) {
            arrayList.add(i.j.b0(new r(this, atomicReference, keySubmission)));
        }
        return c.b.a.a.c.n.c.k(arrayList);
    }

    public /* synthetic */ u e(u uVar, List list) {
        return c.b.b.e.a.l.s(uVar).u(new o(this, list), AppExecutors.getLightweightExecutor());
    }

    public u<?> fakeUpload() {
        c.a p = c.b.b.b.c.p();
        for (int i = 0; i < 14; i++) {
            byte[] bArr = new byte[16];
            RAND.nextBytes(bArr);
            p.a(DiagnosisKey.newBuilder().setKeyBytes(bArr).setIntervalNumber(FAKE_INTERVAL_NUM).build());
        }
        return doUpload(p.b(), true);
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
        SubmitKeysRequest submitKeysRequest = new SubmitKeysRequest(keySubmission.uri, keySubmission.payload, new t(this, atomicReference, bVar), new d.a.a.a.g.n(bVar));
        RequestQueueSingleton.get(this.context).a(submitKeysRequest);
        return submitKeysRequest;
    }

    public u<?> upload(c.b.b.b.c<DiagnosisKey> cVar) {
        return doUpload(cVar, false);
    }
}
