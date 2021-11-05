package gov.michigan.MiCovidExposure.network;

import android.content.Context;
import android.net.Uri;
import b.b.k.i;
import b.f.a.b;
import c.a.b.f;
import c.a.b.q;
import c.a.b.v;
import c.b.b.a.g;
import c.b.b.a.k;
import c.b.b.c.a;
import c.b.b.e.a.l;
import c.b.b.e.a.u;
import e.a.a.e.d;
import g.b.a.c;
import gov.michigan.MiCovidExposure.BuildConfig;
import gov.michigan.MiCovidExposure.network.AutoValue_DiagnosisAttestor_Attestation;
import gov.michigan.MiCovidExposure.network.AutoValue_DiagnosisAttestor_Overlay;
import gov.michigan.MiCovidExposure.notify.ShareDiagnosisEditFragment;
import gov.michigan.MiCovidExposure.notify.ShareDiagnosisViewModel;
import gov.michigan.MiCovidExposure.storage.ExposureNotificationSharedPreferences;
import gov.michigan.MiCovidExposure.utils.CustomUtility;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class DiagnosisAttestor {
    public static final a BASE64 = a.f4692a;
    public static final g COMMAS = new g(String.valueOf(','));
    public static final int FAKE_ATTESTATION_LENGTH = 1024;
    public static final String HASH_ALGO = "HmacSHA256";
    public static final int HMAC_KEY_LEN_BYTES = 16;
    public static final SecureRandom RAND = new SecureRandom();
    public static final String TAG = "DiagnosisAttestor";
    public static JSONObject certPayload = new JSONObject();
    public final Context context;

    public static abstract class Attestation {

        public static abstract class Builder {
            public abstract Attestation build();

            public abstract Builder setOverlay(Overlay overlay);

            public abstract Builder setToken(String str);
        }

        public static Builder newBuilder() {
            return new AutoValue_DiagnosisAttestor_Attestation.Builder().setOverlay(Overlay.newBuilder().build());
        }

        public abstract Overlay overlay();

        public abstract String token();
    }

    public static abstract class Overlay {

        public static abstract class Builder {
            public abstract Overlay build();
        }

        public static Builder newBuilder() {
            return new AutoValue_DiagnosisAttestor_Overlay.Builder();
        }
    }

    public static class VerificationRequest extends c.a.b.x.g {
        public static final int MAX_RETRIES = 3;
        public static final float RETRY_BACKOFF = 1.0f;
        public static final c TIMEOUT = c.m(30);
        public final String apiKey;

        public VerificationRequest(String str, Uri uri, JSONObject jSONObject, q.b<JSONObject> bVar, q.a aVar) {
            super(1, uri.toString(), jSONObject, bVar, aVar);
            setRetryPolicy(new f((int) TIMEOUT.s(), 3, 1.0f));
            this.apiKey = str;
        }

        @Override // c.a.b.o
        public Map<String, String> getHeaders() {
            HashMap hashMap = new HashMap(super.getHeaders());
            hashMap.put("X-API-KEY", this.apiKey);
            hashMap.toString();
            return hashMap;
        }
    }

    public DiagnosisAttestor(Context context2) {
        this.context = context2;
    }

    public static /* synthetic */ void b(b bVar, JSONObject jSONObject) {
        String str = "Certificate obtained: " + jSONObject;
        bVar.a(captureCertResponse(jSONObject));
    }

    public static /* synthetic */ void c(b bVar, v vVar) {
        VolleyUtils.getErrorMessage(vVar, "Call failed; network problem?");
        ShareDiagnosisViewModel.error_token_flag = "generic";
        String.format("Certificate error: [%s]", vVar.toString());
        if (vVar.f2851b.f2827a != 200) {
            String.format("Certificate error: [%s]", vVar.toString());
            int i = vVar.f2851b.f2827a;
            StringBuilder h = c.a.a.a.a.h("Ceritifate ::::: Message = ");
            h.append(vVar.f2851b.f2828b);
            h.toString();
        }
        bVar.d(new Exception(vVar));
    }

    public static JSONObject captureCertResponse(JSONObject jSONObject) {
        try {
            if (jSONObject.has("vcert") && !k.c(jSONObject.getString("vcert"))) {
                String str = "vcert " + jSONObject.get("vcert");
                certPayload.put("vcert", jSONObject.get("vcert"));
            }
            return certPayload;
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    private JSONObject certRequestBody(String str, c.b.b.b.c<DiagnosisKey> cVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", str);
        jSONObject.put("tekmac", hashedKeys(cVar));
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0091 A[Catch:{ IOException -> 0x0104 }] */
    private String hashedKeys(c.b.b.b.c<DiagnosisKey> cVar) {
        String str;
        StringBuilder sb;
        Object next;
        ArrayList arrayList = new ArrayList(cVar.size());
        ArrayList arrayList2 = new ArrayList(Collections.unmodifiableList(cVar));
        Collections.sort(arrayList2, e.a.a.e.c.f6278b);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            DiagnosisKey diagnosisKey = (DiagnosisKey) it.next();
            arrayList.add(String.format(Locale.ENGLISH, "%s.%d.%d.%d", BASE64.c(diagnosisKey.getKeyBytes()), Integer.valueOf(diagnosisKey.getIntervalNumber()), Integer.valueOf(diagnosisKey.getRollingPeriod()), 0));
        }
        g gVar = COMMAS;
        if (gVar != null) {
            Iterator it2 = arrayList.iterator();
            StringBuilder sb2 = new StringBuilder();
            try {
                if (it2.hasNext()) {
                    Object next2 = it2.next();
                    if (next2 != null) {
                        if (next2 instanceof CharSequence) {
                            StringBuilder sb3 = sb2;
                            str = (CharSequence) next2;
                            sb = sb3;
                            sb2.append(str);
                            if (it2.hasNext()) {
                                sb2.append((CharSequence) gVar.f4659a);
                                next = it2.next();
                                if (next == null) {
                                    throw null;
                                } else if (next instanceof CharSequence) {
                                    sb3 = sb;
                                    next2 = next;
                                    str = (CharSequence) next2;
                                    sb = sb3;
                                    sb2.append(str);
                                    if (it2.hasNext()) {
                                        sb2 = sb;
                                    }
                                }
                                throw null;
                            }
                            sb2 = sb;
                        } else {
                            next = next2;
                            sb = sb2;
                        }
                        str = next.toString();
                        sb2.append(str);
                        if (it2.hasNext()) {
                        }
                        sb2 = sb;
                    } else {
                        throw null;
                    }
                }
                String sb4 = sb2.toString();
                cVar.size();
                CustomUtility.customLogger(cVar.size() + " keys for hashing prior to verification: [" + sb4 + "]");
                try {
                    Mac instance = Mac.getInstance(HASH_ALGO);
                    instance.init(new SecretKeySpec(BASE64.a(newHmacKey()), HASH_ALGO));
                    return BASE64.c(instance.doFinal(sb4.getBytes(StandardCharsets.UTF_8)));
                } catch (InvalidKeyException | NoSuchAlgorithmException e2) {
                    throw new RuntimeException(e2);
                }
            } catch (IOException e3) {
                throw new AssertionError(e3);
            }
        } else {
            throw null;
        }
    }

    public static String newHmacKey() {
        byte[] bArr = new byte[16];
        RAND.nextBytes(bArr);
        new String(bArr, StandardCharsets.UTF_8);
        StringBuilder h = c.a.a.a.a.h("HMAC KEY ");
        h.append(BASE64.c(bArr));
        CustomUtility.customLogger(h.toString());
        try {
            certPayload.put("hmacKey", BASE64.c(bArr));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return BASE64.c(bArr);
    }

    private u<JSONObject> submitKeysForCert(c.b.b.b.c<DiagnosisKey> cVar) {
        Uri parse = Uri.parse(BuildConfig.MI_HMAC_URI);
        String pinToken = new ExposureNotificationSharedPreferences(this.context.getApplicationContext()).getPinToken("");
        new JSONObject();
        return i.j.z(new e.a.a.e.a(this, pinToken, cVar, parse));
    }

    public l<JSONObject> attestFor(c.b.b.b.c<DiagnosisKey> cVar, List<String> list, String str) {
        return l.s(submitKeysForCert(cVar));
    }

    public /* synthetic */ Object d(String str, c.b.b.b.c cVar, Uri uri, b bVar) {
        e.a.a.e.b bVar2 = new e.a.a.e.b(bVar);
        d dVar = new d(bVar);
        JSONObject certRequestBody = certRequestBody(str, cVar);
        String str2 = "Submitting request for certificate: " + certRequestBody;
        VerificationRequest verificationRequest = new VerificationRequest(ShareDiagnosisEditFragment.API_KEY, uri, certRequestBody, bVar2, dVar);
        RequestQueueSingleton.get(this.context).a(verificationRequest);
        return verificationRequest;
    }
}
