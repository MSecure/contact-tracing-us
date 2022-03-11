package f.b.a.a.a.n;

import android.util.Log;
import e.b.a.m;
import f.a.b.u;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import java.util.Objects;
import l.b.a.q;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class v {
    public final s a;
    public final t b;

    public static class a extends c {
        public a(u uVar) {
            super(uVar);
        }

        public a(x xVar) {
            super(xVar);
        }
    }

    public static class b extends c {
        public b(u uVar) {
            super(uVar);
        }
    }

    public static abstract class c extends Exception {
        public final x b;

        public c(u uVar) {
            super(uVar);
            x xVar = x.SERVER_ERROR;
            x xVar2 = x.UNKNOWN;
            x xVar3 = x.APP_ERROR;
            if (uVar.b != null) {
                JSONObject c0 = m.h.c0(uVar);
                String str = "errorCode";
                String optString = c0.optString(!c0.has(str) ? "code" : str);
                int i2 = uVar.b.a;
                if (i2 == 400) {
                    char c = 65535;
                    switch (optString.hashCode()) {
                        case -1967136956:
                            if (optString.equals("code_not_found")) {
                                c = 11;
                                break;
                            }
                            break;
                        case -1924040562:
                            if (optString.equals("missing_revision_token")) {
                                c = 6;
                                break;
                            }
                            break;
                        case -1844530699:
                            if (optString.equals("health_authority_missing_region_config")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -1751411743:
                            if (optString.equals("unable_to_load_health_authority")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1675512393:
                            if (optString.equals("invalid_report_type_transition")) {
                                c = '\t';
                                break;
                            }
                            break;
                        case -1603678939:
                            if (optString.equals("unknown_health_authority_id")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -1474036827:
                            if (optString.equals("key_already_revised")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case -1352225475:
                            if (optString.equals("unsupported_test_type")) {
                                c = 16;
                                break;
                            }
                            break;
                        case -1290617133:
                            if (optString.equals("code_expired")) {
                                c = 14;
                                break;
                            }
                            break;
                        case -1128445519:
                            if (optString.equals("token_invalid")) {
                                c = '\r';
                                break;
                            }
                            break;
                        case -272863466:
                            if (optString.equals("code_user_unauthorized")) {
                                c = '\f';
                                break;
                            }
                            break;
                        case -102498593:
                            if (optString.equals("token_expired")) {
                                c = 15;
                                break;
                            }
                            break;
                        case 147895261:
                            if (optString.equals("invalid_revision_token")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 247349866:
                            if (optString.equals("health_authority_verification_certificate_invalid")) {
                                c = 3;
                                break;
                            }
                            break;
                        case 778975750:
                            if (optString.equals("internal_error")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 1207582805:
                            if (optString.equals("bad_request")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 1407791743:
                            if (optString.equals("invalid_test_type")) {
                                c = 17;
                                break;
                            }
                            break;
                        case 1832234399:
                            if (optString.equals("hmac_invalid")) {
                                c = 18;
                                break;
                            }
                            break;
                        case 1978403237:
                            if (optString.equals("code_invalid")) {
                                c = '\n';
                                break;
                            }
                            break;
                    }
                    if (!(c == 0 || c == 1 || c == 2 || c == 3 || c == 4)) {
                        switch (c) {
                            case '\n':
                            case 11:
                            case '\f':
                            case '\r':
                                xVar = x.CODE_INVALID;
                                break;
                            case 14:
                            case 15:
                                xVar = x.CODE_EXPIRED;
                                break;
                            case 16:
                                xVar = x.UNSUPPORTED_TEST_TYPE;
                                break;
                        }
                    }
                    this.b = xVar;
                } else if (i2 != 401) {
                    if (i2 == 429) {
                        xVar = x.RATE_LIMITED;
                    } else if (i2 != 500) {
                        switch (i2) {
                        }
                    }
                    this.b = xVar;
                }
                xVar = xVar3;
                this.b = xVar;
            }
            xVar = xVar2;
            this.b = xVar;
        }

        public c(x xVar) {
            this.b = xVar;
        }
    }

    public static class d extends c {
        public d(u uVar) {
            super(uVar);
        }
    }

    public static class e extends c {
        public e(u uVar) {
            super(uVar);
        }
    }

    public v(s sVar, t tVar) {
        this.a = sVar;
        this.b = tVar;
    }

    public f.b.b.f.a.u<u> a(u uVar) {
        Log.i("UploadController", "Submitting code...");
        s sVar = this.a;
        Objects.requireNonNull(sVar);
        String str = "Submitting verification code: " + uVar;
        return m.h.f0(new b(sVar, uVar));
    }

    public f.b.b.f.a.u<u> b(u uVar) {
        f.b.b.f.a.u uVar2;
        Log.i("UploadController", "Uploading keys and verification certificate to the keyserver.");
        t tVar = this.b;
        Objects.requireNonNull(tVar);
        if (uVar.g().isEmpty()) {
            return f.b.a.c.b.o.b.d1(uVar);
        }
        uVar.g().size();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            f.b.b.b.a<f.b.a.a.a.q.d> t = uVar.g().listIterator();
            while (t.hasNext()) {
                f.b.a.a.a.q.d next = t.next();
                String str = "Adding key: " + next + " to submission.";
                jSONArray.put(new JSONObject().put("key", t.f2199h.c(next.c())).put("rollingStartNumber", next.a()).put("rollingPeriod", next.d()).put("transmissionRisk", next.e()));
            }
            JSONArray jSONArray2 = new JSONArray();
            f.b.b.b.a<String> t2 = uVar.l().listIterator();
            while (t2.hasNext()) {
                jSONArray2.put(t2.next());
            }
            jSONObject.put("temporaryExposureKeys", jSONArray).put("healthAuthorityID", tVar.a.getPackageName()).put("hmacKey", uVar.d()).put("verificationPayload", uVar.a()).put("traveler", uVar.c());
            if (uVar.n() != null) {
                l.b.a.d w = uVar.n().A(q.f4166g).w();
                f.b.b.c.a aVar = f.b.a.a.a.q.d.a;
                jSONObject.put("symptomOnsetInterval", (int) (w.E() / f.b.a.a.a.q.d.c));
            }
            if (uVar.m() != null) {
                jSONObject.put("revisionToken", uVar.m());
            }
            m.h.a(jSONObject);
            uVar2 = f.b.a.c.b.o.b.d1(jSONObject);
        } catch (JSONException e2) {
            uVar2 = new s.a(e2);
        }
        return l.x(uVar2).z(new k(tVar, uVar), tVar.f2200d).z(new i(tVar, uVar), tVar.f2201e);
    }
}
