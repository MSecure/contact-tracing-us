package f.b.a.a.a.y;

import e.b.a.m;
import f.a.b.u;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;
import l.b.a.r;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f0 {

    /* renamed from: d  reason: collision with root package name */
    public static final f.b.a.a.a.s.d0.a f2503d = f.b.a.a.a.s.d0.a.e("UploadController");
    public final c0 a;
    public final d0 b;
    public final f.b.a.a.a.c0.b c;

    public static class a extends d {
        public a(u uVar) {
            super(uVar);
        }

        public a(g0 g0Var) {
            super(g0Var);
        }
    }

    public static class b extends d {
        public b(u uVar) {
            super(uVar);
        }
    }

    public static class c extends Exception {
    }

    public static abstract class d extends Exception {
        public final g0 b;

        public d(u uVar) {
            super(uVar);
            g0 g0Var = g0.SERVER_ERROR;
            g0 g0Var2 = g0.UNKNOWN;
            g0 g0Var3 = g0.APP_ERROR;
            if (uVar.b != null) {
                JSONObject i0 = m.e.i0(uVar);
                String str = "errorCode";
                String optString = i0.optString(!i0.has(str) ? "code" : str);
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
                        case -1187776554:
                            if (optString.equals("missing_nonce")) {
                                c = 22;
                                break;
                            }
                            break;
                        case -1186136747:
                            if (optString.equals("missing_phone")) {
                                c = 21;
                                break;
                            }
                            break;
                        case -1147005209:
                            if (optString.equals("missing_date")) {
                                c = 19;
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
                        case 526735606:
                            if (optString.equals("invalid_date")) {
                                c = 20;
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
                                g0Var = g0.CODE_INVALID;
                                break;
                            case 14:
                            case 15:
                                g0Var = g0.CODE_EXPIRED;
                                break;
                            case 16:
                                g0Var = g0.UNSUPPORTED_TEST_TYPE;
                                break;
                        }
                    }
                    this.b = g0Var;
                } else if (i2 != 401) {
                    if (i2 == 429) {
                        g0Var = g0.RATE_LIMITED;
                    } else if (i2 != 500) {
                        switch (i2) {
                        }
                    }
                    this.b = g0Var;
                }
                g0Var = g0Var3;
                this.b = g0Var;
            }
            g0Var = g0Var2;
            this.b = g0Var;
        }

        public d(g0 g0Var) {
            this.b = g0Var;
        }
    }

    public static class e extends d {
        public e(u uVar) {
            super(uVar);
        }
    }

    public static class f extends d {
        public f(u uVar) {
            super(uVar);
        }
    }

    public f0(c0 c0Var, d0 d0Var, f.b.a.a.a.c0.b bVar) {
        this.a = c0Var;
        this.b = d0Var;
        this.c = bVar;
    }

    public f.b.b.f.a.u<i0> a(i0 i0Var) {
        if (!this.c.a()) {
            return new s.a(new c());
        }
        c0 c0Var = this.a;
        Objects.requireNonNull(c0Var);
        return m.e.l0(new h(c0Var, i0Var));
    }

    public f.b.b.f.a.u<e0> b(e0 e0Var) {
        if (!this.c.a()) {
            return new s.a(new c());
        }
        f2503d.f("Submitting code...");
        c0 c0Var = this.a;
        Objects.requireNonNull(c0Var);
        f.b.a.a.a.s.d0.a aVar = c0.f2488h;
        aVar.a("Submitting verification code: " + e0Var);
        return m.e.l0(new a(c0Var, e0Var));
    }

    public f.b.b.f.a.u<e0> c(e0 e0Var) {
        if (!this.c.a()) {
            return new s.a(new c());
        }
        f2503d.f("Submitting keys for verification certificate...");
        c0 c0Var = this.a;
        Objects.requireNonNull(c0Var);
        return m.e.l0(new i(c0Var, e0Var));
    }

    public f.b.b.f.a.u<e0> d(e0 e0Var) {
        f.b.b.f.a.u uVar;
        if (!this.c.a()) {
            return new s.a(new c());
        }
        f2503d.f("Uploading keys and verification certificate to the keyserver.");
        d0 d0Var = this.b;
        Objects.requireNonNull(d0Var);
        if (e0Var.g().isEmpty()) {
            d0.f2496h.a("Zero keys given, skipping.");
            return f.b.a.c.b.o.b.Q0(e0Var);
        }
        f.b.a.a.a.s.d0.a aVar = d0.f2496h;
        StringBuilder h2 = f.a.a.a.a.h("Uploading keys: [");
        h2.append(e0Var.g().size());
        h2.append("]");
        aVar.a(h2.toString());
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            f.b.b.b.a<f.b.a.a.a.c0.d> t = e0Var.g().listIterator();
            while (t.hasNext()) {
                f.b.a.a.a.c0.d next = t.next();
                f.b.a.a.a.s.d0.a aVar2 = d0.f2496h;
                aVar2.a("Adding key: " + next + " to submission.");
                jSONArray.put(new JSONObject().put("key", d0.f2497i.c(next.c())).put("rollingStartNumber", next.a()).put("rollingPeriod", next.d()).put("transmissionRisk", next.e()));
            }
            JSONArray jSONArray2 = new JSONArray();
            f.b.b.b.a<String> t2 = e0Var.m().listIterator();
            while (t2.hasNext()) {
                jSONArray2.put(t2.next());
            }
            jSONObject.put("temporaryExposureKeys", jSONArray).put("healthAuthorityID", d0Var.a.getString(R.string.health_authority_id)).put("hmacKey", e0Var.d()).put("verificationPayload", e0Var.a()).put("traveler", e0Var.c());
            if (e0Var.o() != null) {
                l.b.a.e w = e0Var.o().A(r.f4386g).w();
                f.b.b.c.a aVar3 = f.b.a.a.a.c0.d.a;
                jSONObject.put("symptomOnsetInterval", (int) (w.G() / f.b.a.a.a.c0.d.c));
            }
            if (e0Var.n() != null) {
                jSONObject.put("revisionToken", e0Var.n());
            }
            m.e.a(jSONObject);
            uVar = f.b.a.c.b.o.b.Q0(jSONObject);
        } catch (JSONException e2) {
            uVar = new s.a(e2);
        }
        return l.x(uVar).z(new n(d0Var, e0Var), d0Var.f2498d).z(new l(d0Var, e0Var), d0Var.f2499e);
    }
}
