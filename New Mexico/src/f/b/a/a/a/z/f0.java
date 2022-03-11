package f.b.a.a.a.z;

import e.b.a.m;
import f.a.b.u;
import f.b.a.a.a.z.a0;
import f.b.a.a.a.z.f0;
import f.b.a.c.b.o.b;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Objects;
import l.b.a.r;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: d */
    public static final f.b.a.a.a.t.p0.a f2551d = f.b.a.a.a.t.p0.a.e("UploadController");
    public final c0 a;
    public final d0 b;
    public final f.b.a.a.a.d0.b c;

    /* loaded from: classes.dex */
    public static class a extends d {
        public a(u uVar) {
            super(uVar);
        }

        public a(g0 g0Var) {
            super(g0Var);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends d {
        public b(u uVar) {
            super(uVar);
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Exception {
    }

    /* loaded from: classes.dex */
    public static abstract class d extends Exception {
        public final g0 b;

        /* JADX WARN: Removed duplicated region for block: B:96:0x015f  */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public d(u uVar) {
            super(uVar);
            g0 g0Var = g0.SERVER_ERROR;
            g0Var = g0.UNKNOWN;
            g0 g0Var2 = g0.APP_ERROR;
            if (uVar.b != null) {
                JSONObject j0 = m.e.j0(uVar);
                String str = "errorCode";
                String optString = j0.optString(!j0.has(str) ? "code" : str);
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
                } else if (i2 == 401) {
                    g0Var = g0.UNAUTHORIZED_CLIENT;
                } else if (i2 != 429) {
                    if (i2 != 500) {
                        switch (i2) {
                            case 403:
                            case 404:
                            case 405:
                                g0Var = g0Var2;
                                break;
                        }
                    }
                } else {
                    g0Var = g0.RATE_LIMITED;
                }
                this.b = g0Var;
            }
            this.b = g0Var;
        }

        public d(g0 g0Var) {
            this.b = g0Var;
        }
    }

    /* loaded from: classes.dex */
    public static class e extends d {
        public e(u uVar) {
            super(uVar);
        }
    }

    /* loaded from: classes.dex */
    public static class f extends d {
        public f(u uVar) {
            super(uVar);
        }
    }

    public f0(c0 c0Var, d0 d0Var, f.b.a.a.a.d0.b bVar) {
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
        return m.e.n0(new e.g.a.d(i0Var) { // from class: f.b.a.a.a.z.h
            public final /* synthetic */ i0 b;

            {
                this.b = r2;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004e: CONSTRUCTOR  (r14v1 'aVar' f.b.a.a.a.z.c0$a) = 
                  (wrap: java.lang.String : 0x0043: IGET  (r6v0 java.lang.String A[REMOVE]) = (r0v0 'c0Var2' f.b.a.a.a.z.c0) f.b.a.a.a.z.c0.e java.lang.String)
                  (wrap: android.net.Uri : 0x0045: IGET  (r7v0 android.net.Uri A[REMOVE]) = (r0v0 'c0Var2' f.b.a.a.a.z.c0) f.b.a.a.a.z.c0.c android.net.Uri)
                  (r8v0 'put' org.json.JSONObject)
                  (wrap: f.b.a.a.a.z.e : 0x0039: CONSTRUCTOR  (r9v0 f.b.a.a.a.z.e A[REMOVE]) = 
                  (r0v0 'c0Var2' f.b.a.a.a.z.c0)
                  (r8v0 'put' org.json.JSONObject)
                  (r14v0 'bVar' e.g.a.b)
                  (r1v0 'i0Var2' f.b.a.a.a.z.i0)
                 call: f.b.a.a.a.z.e.<init>(f.b.a.a.a.z.c0, org.json.JSONObject, e.g.a.b, f.b.a.a.a.z.i0):void type: CONSTRUCTOR)
                  (wrap: f.b.a.a.a.z.d : 0x003e: CONSTRUCTOR  (r10v0 f.b.a.a.a.z.d A[REMOVE]) = (r0v0 'c0Var2' f.b.a.a.a.z.c0), (r14v0 'bVar' e.g.a.b) call: f.b.a.a.a.z.d.<init>(f.b.a.a.a.z.c0, e.g.a.b):void type: CONSTRUCTOR)
                  (wrap: f.b.a.a.a.t.q0.a : 0x0047: IGET  (r11v0 f.b.a.a.a.t.q0.a A[REMOVE]) = (r0v0 'c0Var2' f.b.a.a.a.z.c0) f.b.a.a.a.z.c0.f f.b.a.a.a.t.q0.a)
                  (wrap: boolean : 0x0049: INVOKE  (r12v0 boolean A[REMOVE]) = (r1v0 'i0Var2' f.b.a.a.a.z.i0) type: VIRTUAL call: f.b.a.a.a.z.i0.c():boolean)
                 call: f.b.a.a.a.z.c0.a.<init>(java.lang.String, android.net.Uri, org.json.JSONObject, f.a.b.p$b, f.a.b.p$a, f.b.a.a.a.t.q0.a, boolean):void type: CONSTRUCTOR in method: f.b.a.a.a.z.h.a(e.g.a.b):java.lang.Object, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.z.e, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:709)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                	... 10 more
                */
            @Override // e.g.a.d
            public final java.lang.Object a(e.g.a.b r14) {
                /*
                    r13 = this;
                    f.b.a.a.a.z.c0 r0 = f.b.a.a.a.z.c0.this
                    f.b.a.a.a.z.i0 r1 = r13.b
                    java.util.Objects.requireNonNull(r0)
                    org.json.JSONObject r2 = new org.json.JSONObject
                    r2.<init>()
                    l.b.a.f r3 = r1.g()
                    java.lang.String r4 = "testDate"
                    org.json.JSONObject r2 = r2.put(r4, r3)
                    long r3 = r1.i()
                    java.lang.String r5 = "tzOffset"
                    org.json.JSONObject r2 = r2.put(r5, r3)
                    java.lang.String r3 = r1.f()
                    java.lang.String r4 = "phone"
                    org.json.JSONObject r2 = r2.put(r4, r3)
                    java.lang.String r3 = r1.e()
                    java.lang.String r4 = "nonce"
                    org.json.JSONObject r8 = r2.put(r4, r3)
                    e.b.a.m.e.a(r8)
                    f.b.a.a.a.z.e r9 = new f.b.a.a.a.z.e
                    r9.<init>(r0, r8, r14, r1)
                    f.b.a.a.a.z.d r10 = new f.b.a.a.a.z.d
                    r10.<init>(r0, r14)
                    f.b.a.a.a.z.c0$a r14 = new f.b.a.a.a.z.c0$a
                    java.lang.String r6 = r0.f2541e
                    android.net.Uri r7 = r0.c
                    f.b.a.a.a.t.q0.a r11 = r0.f2542f
                    boolean r12 = r1.c()
                    r5 = r14
                    r5.<init>(r6, r7, r8, r9, r10, r11, r12)
                    f.b.a.a.a.d0.g r0 = r0.f2540d
                    r0.a(r14)
                    return r14
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.z.h.a(e.g.a.b):java.lang.Object");
            }
        });
    }

    public f.b.b.f.a.u<e0> b(e0 e0Var) {
        if (!this.c.a()) {
            return new s.a(new c());
        }
        f2551d.f("Submitting code...");
        c0 c0Var = this.a;
        Objects.requireNonNull(c0Var);
        f.b.a.a.a.t.p0.a aVar = c0.f2536h;
        aVar.a("Submitting verification code: " + e0Var);
        return m.e.n0(new e.g.a.d(e0Var) { // from class: f.b.a.a.a.z.a
            public final /* synthetic */ e0 b;

            {
                this.b = r2;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0061: CONSTRUCTOR  (r14v1 'aVar3' f.b.a.a.a.z.c0$a) = 
                  (wrap: java.lang.String : 0x0056: IGET  (r6v0 java.lang.String A[REMOVE]) = (r0v0 'c0Var2' f.b.a.a.a.z.c0) f.b.a.a.a.z.c0.e java.lang.String)
                  (wrap: android.net.Uri : 0x0058: IGET  (r7v0 android.net.Uri A[REMOVE]) = (r0v0 'c0Var2' f.b.a.a.a.z.c0) f.b.a.a.a.z.c0.a android.net.Uri)
                  (r8v0 'put' org.json.JSONObject)
                  (wrap: f.b.a.a.a.z.b : 0x004c: CONSTRUCTOR  (r9v0 f.b.a.a.a.z.b A[REMOVE]) = 
                  (r0v0 'c0Var2' f.b.a.a.a.z.c0)
                  (r8v0 'put' org.json.JSONObject)
                  (r14v0 'bVar' e.g.a.b)
                  (r1v0 'e0Var2' f.b.a.a.a.z.e0)
                 call: f.b.a.a.a.z.b.<init>(f.b.a.a.a.z.c0, org.json.JSONObject, e.g.a.b, f.b.a.a.a.z.e0):void type: CONSTRUCTOR)
                  (wrap: f.b.a.a.a.z.f : 0x0051: CONSTRUCTOR  (r10v0 f.b.a.a.a.z.f A[REMOVE]) = (r0v0 'c0Var2' f.b.a.a.a.z.c0), (r14v0 'bVar' e.g.a.b) call: f.b.a.a.a.z.f.<init>(f.b.a.a.a.z.c0, e.g.a.b):void type: CONSTRUCTOR)
                  (wrap: f.b.a.a.a.t.q0.a : 0x005a: IGET  (r11v0 f.b.a.a.a.t.q0.a A[REMOVE]) = (r0v0 'c0Var2' f.b.a.a.a.z.c0) f.b.a.a.a.z.c0.f f.b.a.a.a.t.q0.a)
                  (wrap: boolean : 0x005c: INVOKE  (r12v0 boolean A[REMOVE]) = (r1v0 'e0Var2' f.b.a.a.a.z.e0) type: VIRTUAL call: f.b.a.a.a.z.e0.f():boolean)
                 call: f.b.a.a.a.z.c0.a.<init>(java.lang.String, android.net.Uri, org.json.JSONObject, f.a.b.p$b, f.a.b.p$a, f.b.a.a.a.t.q0.a, boolean):void type: CONSTRUCTOR in method: f.b.a.a.a.z.a.a(e.g.a.b):java.lang.Object, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.z.b, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:709)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                	... 10 more
                */
            @Override // e.g.a.d
            public final java.lang.Object a(e.g.a.b r14) {
                /*
                    r13 = this;
                    f.b.a.a.a.z.c0 r0 = f.b.a.a.a.z.c0.this
                    f.b.a.a.a.z.e0 r1 = r13.b
                    java.util.Objects.requireNonNull(r0)
                    org.json.JSONObject r2 = new org.json.JSONObject
                    r2.<init>()
                    java.lang.String r3 = r1.r()
                    java.lang.String r4 = "code"
                    org.json.JSONObject r2 = r2.put(r4, r3)
                    org.json.JSONArray r3 = f.b.a.a.a.z.c0.f2539k
                    java.lang.String r4 = "accept"
                    org.json.JSONObject r8 = r2.put(r4, r3)
                    java.lang.String r2 = r1.k()
                    boolean r2 = android.text.TextUtils.isEmpty(r2)
                    if (r2 != 0) goto L_0x0031
                    java.lang.String r2 = r1.k()
                    java.lang.String r3 = "nonce"
                    r8.put(r3, r2)
                L_0x0031:
                    e.b.a.m.e.a(r8)
                    f.b.a.a.a.t.p0.a r2 = f.b.a.a.a.z.c0.f2536h
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r4 = "Submitting verification code: "
                    r3.append(r4)
                    r3.append(r8)
                    java.lang.String r3 = r3.toString()
                    r2.a(r3)
                    f.b.a.a.a.z.b r9 = new f.b.a.a.a.z.b
                    r9.<init>(r0, r8, r14, r1)
                    f.b.a.a.a.z.f r10 = new f.b.a.a.a.z.f
                    r10.<init>(r0, r14)
                    f.b.a.a.a.z.c0$a r14 = new f.b.a.a.a.z.c0$a
                    java.lang.String r6 = r0.f2541e
                    android.net.Uri r7 = r0.a
                    f.b.a.a.a.t.q0.a r11 = r0.f2542f
                    boolean r12 = r1.f()
                    r5 = r14
                    r5.<init>(r6, r7, r8, r9, r10, r11, r12)
                    f.b.a.a.a.d0.g r0 = r0.f2540d
                    r0.a(r14)
                    return r14
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.z.a.a(e.g.a.b):java.lang.Object");
            }
        });
    }

    public f.b.b.f.a.u<e0> c(e0 e0Var) {
        if (!this.c.a()) {
            return new s.a(new c());
        }
        f2551d.f("Submitting keys for verification certificate...");
        c0 c0Var = this.a;
        Objects.requireNonNull(c0Var);
        return m.e.n0(new e.g.a.d(e0Var) { // from class: f.b.a.a.a.z.i
            public final /* synthetic */ e0 b;

            {
                this.b = r2;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00fd: CONSTRUCTOR  (r15v2 'aVar3' f.b.a.a.a.z.c0$a) = 
                  (wrap: java.lang.String : 0x00f2: IGET  (r7v5 java.lang.String A[REMOVE]) = (r0v0 'c0Var2' f.b.a.a.a.z.c0) f.b.a.a.a.z.c0.e java.lang.String)
                  (wrap: android.net.Uri : 0x00f4: IGET  (r8v1 android.net.Uri A[REMOVE]) = (r0v0 'c0Var2' f.b.a.a.a.z.c0) f.b.a.a.a.z.c0.b android.net.Uri)
                  (r9v2 'put2' org.json.JSONObject)
                  (wrap: f.b.a.a.a.z.g : 0x00e8: CONSTRUCTOR  (r10v0 f.b.a.a.a.z.g A[REMOVE]) = 
                  (r0v0 'c0Var2' f.b.a.a.a.z.c0)
                  (r9v2 'put2' org.json.JSONObject)
                  (r15v0 'bVar' e.g.a.b)
                  (r1v0 'e0Var2' f.b.a.a.a.z.e0)
                 call: f.b.a.a.a.z.g.<init>(f.b.a.a.a.z.c0, org.json.JSONObject, e.g.a.b, f.b.a.a.a.z.e0):void type: CONSTRUCTOR)
                  (wrap: f.b.a.a.a.z.c : 0x00ed: CONSTRUCTOR  (r11v0 f.b.a.a.a.z.c A[REMOVE]) = (r0v0 'c0Var2' f.b.a.a.a.z.c0), (r15v0 'bVar' e.g.a.b) call: f.b.a.a.a.z.c.<init>(f.b.a.a.a.z.c0, e.g.a.b):void type: CONSTRUCTOR)
                  (wrap: f.b.a.a.a.t.q0.a : 0x00f6: IGET  (r12v0 f.b.a.a.a.t.q0.a A[REMOVE]) = (r0v0 'c0Var2' f.b.a.a.a.z.c0) f.b.a.a.a.z.c0.f f.b.a.a.a.t.q0.a)
                  (wrap: boolean : 0x00f8: INVOKE  (r13v0 boolean A[REMOVE]) = (r1v0 'e0Var2' f.b.a.a.a.z.e0) type: VIRTUAL call: f.b.a.a.a.z.e0.f():boolean)
                 call: f.b.a.a.a.z.c0.a.<init>(java.lang.String, android.net.Uri, org.json.JSONObject, f.a.b.p$b, f.a.b.p$a, f.b.a.a.a.t.q0.a, boolean):void type: CONSTRUCTOR in method: f.b.a.a.a.z.i.a(e.g.a.b):java.lang.Object, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:301)
                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.z.g, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:709)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                	... 16 more
                */
            @Override // e.g.a.d
            public final java.lang.Object a(e.g.a.b r15) {
                /*
                    r14 = this;
                    f.b.a.a.a.z.c0 r0 = f.b.a.a.a.z.c0.this
                    f.b.a.a.a.z.e0 r1 = r14.b
                    java.util.Objects.requireNonNull(r0)
                    org.json.JSONObject r2 = new org.json.JSONObject
                    r2.<init>()
                    java.lang.String r3 = r1.h()
                    java.lang.String r4 = "token"
                    org.json.JSONObject r2 = r2.put(r4, r3)
                    java.lang.String r3 = "HmacSHA256"
                    java.util.ArrayList r4 = new java.util.ArrayList
                    f.b.b.b.c r5 = r1.g()
                    int r5 = r5.size()
                    r4.<init>(r5)
                    f.b.b.b.c r5 = r1.g()
                    f.b.b.b.a r5 = r5.listIterator()
                L_0x002d:
                    boolean r6 = r5.hasNext()
                    if (r6 == 0) goto L_0x0076
                    java.lang.Object r6 = r5.next()
                    f.b.a.a.a.d0.d r6 = (f.b.a.a.a.d0.d) r6
                    java.util.Locale r7 = java.util.Locale.ENGLISH
                    r8 = 4
                    java.lang.Object[] r8 = new java.lang.Object[r8]
                    r9 = 0
                    f.b.b.c.a r10 = f.b.a.a.a.z.c0.f2538j
                    byte[] r11 = r6.c()
                    java.lang.String r10 = r10.c(r11)
                    r8[r9] = r10
                    r9 = 1
                    int r10 = r6.a()
                    java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
                    r8[r9] = r10
                    r9 = 2
                    int r10 = r6.d()
                    java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
                    r8[r9] = r10
                    r9 = 3
                    int r6 = r6.e()
                    java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
                    r8[r9] = r6
                    java.lang.String r6 = "%s.%d.%d.%d"
                    java.lang.String r6 = java.lang.String.format(r7, r6, r8)
                    r4.add(r6)
                    goto L_0x002d
                L_0x0076:
                    java.util.Collections.sort(r4)
                    f.b.b.a.i r5 = f.b.a.a.a.z.c0.f2537i
                    java.lang.String r4 = r5.a(r4)
                    f.b.a.a.a.t.p0.a r5 = f.b.a.a.a.z.c0.f2536h
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    f.b.b.b.c r7 = r1.g()
                    int r7 = r7.size()
                    r6.append(r7)
                    java.lang.String r7 = " keys for hashing prior to verification: ["
                    r6.append(r7)
                    r6.append(r4)
                    java.lang.String r7 = "]"
                    r6.append(r7)
                    java.lang.String r6 = r6.toString()
                    r5.a(r6)
                    javax.crypto.Mac r6 = javax.crypto.Mac.getInstance(r3)     // Catch: NoSuchAlgorithmException -> 0x0108, InvalidKeyException -> 0x0106
                    javax.crypto.spec.SecretKeySpec r7 = new javax.crypto.spec.SecretKeySpec     // Catch: NoSuchAlgorithmException -> 0x0108, InvalidKeyException -> 0x0106
                    f.b.b.c.a r8 = f.b.a.a.a.z.c0.f2538j     // Catch: NoSuchAlgorithmException -> 0x0108, InvalidKeyException -> 0x0106
                    java.lang.String r9 = r1.d()     // Catch: NoSuchAlgorithmException -> 0x0108, InvalidKeyException -> 0x0106
                    byte[] r9 = r8.a(r9)     // Catch: NoSuchAlgorithmException -> 0x0108, InvalidKeyException -> 0x0106
                    r7.<init>(r9, r3)     // Catch: NoSuchAlgorithmException -> 0x0108, InvalidKeyException -> 0x0106
                    r6.init(r7)     // Catch: NoSuchAlgorithmException -> 0x0108, InvalidKeyException -> 0x0106
                    java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch: NoSuchAlgorithmException -> 0x0108, InvalidKeyException -> 0x0106
                    byte[] r3 = r4.getBytes(r3)     // Catch: NoSuchAlgorithmException -> 0x0108, InvalidKeyException -> 0x0106
                    byte[] r3 = r6.doFinal(r3)     // Catch: NoSuchAlgorithmException -> 0x0108, InvalidKeyException -> 0x0106
                    java.lang.String r3 = r8.c(r3)     // Catch: NoSuchAlgorithmException -> 0x0108, InvalidKeyException -> 0x0106
                    java.lang.String r4 = "ekeyhmac"
                    org.json.JSONObject r9 = r2.put(r4, r3)
                    e.b.a.m.e.a(r9)
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    r2.<init>()
                    java.lang.String r3 = "Submitting request for certificate: "
                    r2.append(r3)
                    r2.append(r9)
                    java.lang.String r2 = r2.toString()
                    r5.a(r2)
                    f.b.a.a.a.z.g r10 = new f.b.a.a.a.z.g
                    r10.<init>(r0, r9, r15, r1)
                    f.b.a.a.a.z.c r11 = new f.b.a.a.a.z.c
                    r11.<init>(r0, r15)
                    f.b.a.a.a.z.c0$a r15 = new f.b.a.a.a.z.c0$a
                    java.lang.String r7 = r0.f2541e
                    android.net.Uri r8 = r0.b
                    f.b.a.a.a.t.q0.a r12 = r0.f2542f
                    boolean r13 = r1.f()
                    r6 = r15
                    r6.<init>(r7, r8, r9, r10, r11, r12, r13)
                    f.b.a.a.a.d0.g r0 = r0.f2540d
                    r0.a(r15)
                    return r15
                L_0x0106:
                    r15 = move-exception
                    goto L_0x0109
                L_0x0108:
                    r15 = move-exception
                L_0x0109:
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r0.<init>(r15)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.z.i.a(e.g.a.b):java.lang.Object");
            }
        });
    }

    public f.b.b.f.a.u<e0> d(e0 e0Var) {
        f.b.b.f.a.u uVar;
        if (!this.c.a()) {
            return new s.a(new c());
        }
        f2551d.f("Uploading keys and verification certificate to the keyserver.");
        d0 d0Var = this.b;
        Objects.requireNonNull(d0Var);
        if (e0Var.g().isEmpty()) {
            d0.f2544h.a("Zero keys given, skipping.");
            return f.b.a.c.b.o.b.R0(e0Var);
        }
        f.b.a.a.a.t.p0.a aVar = d0.f2544h;
        StringBuilder h2 = f.a.a.a.a.h("Uploading keys: [");
        h2.append(e0Var.g().size());
        h2.append("]");
        aVar.a(h2.toString());
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            f.b.b.b.a<f.b.a.a.a.d0.d> t = e0Var.g().listIterator();
            while (t.hasNext()) {
                f.b.a.a.a.d0.d next = t.next();
                f.b.a.a.a.t.p0.a aVar2 = d0.f2544h;
                aVar2.a("Adding key: " + next + " to submission.");
                jSONArray.put(new JSONObject().put("key", d0.f2545i.c(next.c())).put("rollingStartNumber", next.a()).put("rollingPeriod", next.d()).put("transmissionRisk", next.e()));
            }
            JSONArray jSONArray2 = new JSONArray();
            f.b.b.b.a<String> t2 = e0Var.m().listIterator();
            while (t2.hasNext()) {
                jSONArray2.put(t2.next());
            }
            jSONObject.put("temporaryExposureKeys", jSONArray).put("healthAuthorityID", d0Var.a.getString(R.string.health_authority_id)).put("hmacKey", e0Var.d()).put("verificationPayload", e0Var.a()).put("traveler", e0Var.c());
            if (e0Var.o() != null) {
                l.b.a.e w = e0Var.o().A(r.f4641g).w();
                f.b.b.c.a aVar3 = f.b.a.a.a.d0.d.a;
                jSONObject.put("symptomOnsetInterval", (int) (w.G() / f.b.a.a.a.d0.d.c));
            }
            if (e0Var.n() != null) {
                jSONObject.put("revisionToken", e0Var.n());
            }
            m.e.a(jSONObject);
            uVar = f.b.a.c.b.o.b.R0(jSONObject);
        } catch (JSONException e2) {
            uVar = new s.a(e2);
        }
        return l.x(uVar).z(new i(e0Var) { // from class: f.b.a.a.a.z.n
            public final /* synthetic */ e0 b;

            {
                this.b = r2;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0016: RETURN  
                  (wrap: f.b.b.f.a.u : 0x0012: INVOKE  (r4v2 f.b.b.f.a.u A[REMOVE]) = 
                  (wrap: f.b.a.a.a.z.m : 0x000f: CONSTRUCTOR  (r2v0 f.b.a.a.a.z.m A[REMOVE]) = 
                  (r0v0 'd0Var2' f.b.a.a.a.z.d0)
                  (wrap: org.json.JSONObject : 0x0004: CHECK_CAST (r4v1 org.json.JSONObject A[REMOVE]) = (org.json.JSONObject) (r4v0 'obj' java.lang.Object))
                  (wrap: boolean : 0x0009: INVOKE  (r1v1 boolean A[REMOVE]) = (r1v0 'e0Var2' f.b.a.a.a.z.e0) type: VIRTUAL call: f.b.a.a.a.z.e0.f():boolean)
                 call: f.b.a.a.a.z.m.<init>(f.b.a.a.a.z.d0, org.json.JSONObject, boolean):void type: CONSTRUCTOR)
                 type: STATIC call: e.b.a.m.e.n0(e.g.a.d):f.b.b.f.a.u)
                 in method: f.b.a.a.a.z.n.a(java.lang.Object):f.b.b.f.a.u, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.z.m, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:328)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                	... 10 more
                */
            @Override // f.b.b.f.a.i
            public final f.b.b.f.a.u a(java.lang.Object r4) {
                /*
                    r3 = this;
                    f.b.a.a.a.z.d0 r0 = f.b.a.a.a.z.d0.this
                    f.b.a.a.a.z.e0 r1 = r3.b
                    org.json.JSONObject r4 = (org.json.JSONObject) r4
                    java.util.Objects.requireNonNull(r0)
                    boolean r1 = r1.f()
                    f.b.a.a.a.z.m r2 = new f.b.a.a.a.z.m
                    r2.<init>(r0, r4, r1)
                    f.b.b.f.a.u r4 = e.b.a.m.e.n0(r2)
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.z.n.a(java.lang.Object):f.b.b.f.a.u");
            }
        }, d0Var.f2546d).z(new i(e0Var) { // from class: f.b.a.a.a.z.l
            public final /* synthetic */ e0 b;

            {
                this.b = r2;
            }

            @Override // f.b.b.f.a.i
            public final f.b.b.f.a.u a(Object obj) {
                d0 d0Var2 = d0.this;
                e0 e0Var2 = this.b;
                JSONObject jSONObject2 = (JSONObject) obj;
                Objects.requireNonNull(d0Var2);
                if (e0Var2.f()) {
                    return b.R0(e0Var2);
                }
                try {
                    a0.b bVar = (a0.b) e0Var2.q();
                    bVar.f2525k = jSONObject2.getString("revisionToken");
                    return b.R0(bVar.a());
                } catch (JSONException unused) {
                    throw new f0.a(g0.SERVER_ERROR);
                }
            }
        }, d0Var.f2547e);
    }
}
