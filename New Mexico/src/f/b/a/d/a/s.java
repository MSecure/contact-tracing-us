package f.b.a.d.a;

import android.net.Uri;
import e.b.a.m;
import f.a.b.o;
import f.a.b.p;
import f.a.b.w.b;
import f.a.b.w.h;
import f.b.a.a.a.g0.q;
import f.b.a.d.a.d0;
import f.b.a.d.a.h0;
import f.b.a.d.a.j0.c;
import f.b.a.d.a.j0.e;
import f.b.a.d.a.q;
import f.b.b.a.g;
import f.b.b.a.l;
import f.b.b.f.a.a;
import f.b.b.f.a.u;
import f.b.b.f.a.w;
import java.util.Objects;
import l.b.a.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class s implements f0 {

    /* renamed from: f */
    public static final d f2867f = d.n(10);

    /* renamed from: g */
    public static final h0 f2868g = h0.f().a();
    public f.b.a.d.a.j0.d a;
    public final Uri b;
    public final w c = t.f2871d;

    /* renamed from: d */
    public final l<b0> f2869d;

    /* renamed from: e */
    public final d0 f2870e;

    /* loaded from: classes.dex */
    public static class a extends e {
        public a(Uri uri, p.b<JSONObject> bVar, p.a aVar) {
            super(0, uri.toString(), null, bVar, aVar);
            this.m = new f.a.b.e((int) s.f2867f.u(), 3, 1.0f);
        }
    }

    public s(Uri uri, l<b0> lVar, d0.a aVar) {
        this.b = uri;
        this.f2869d = lVar;
        this.f2870e = aVar.a("PAPrioRemoteConfig");
        o oVar = new o(new h(), new b(new f.a.b.w.e()));
        oVar.b();
        this.a = new c(oVar);
    }

    @Override // f.b.a.d.a.f0
    public u<h0> a() {
        f.b.b.f.a.l y = f.b.b.f.a.l.x(m.e.n0(new e.g.a.d() { // from class: f.b.a.d.a.c
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0013: CONSTRUCTOR  (r5v1 'aVar' f.b.a.d.a.s$a) = 
                  (wrap: android.net.Uri : 0x0011: IGET  (r3v0 android.net.Uri A[REMOVE]) = (r0v0 'sVar' f.b.a.d.a.s) f.b.a.d.a.s.b android.net.Uri)
                  (wrap: f.b.a.d.a.b : 0x0007: CONSTRUCTOR  (r1v0 f.b.a.d.a.b A[REMOVE]) = (r0v0 'sVar' f.b.a.d.a.s), (r5v0 'bVar' e.g.a.b) call: f.b.a.d.a.b.<init>(f.b.a.d.a.s, e.g.a.b):void type: CONSTRUCTOR)
                  (wrap: f.b.a.d.a.d : 0x000c: CONSTRUCTOR  (r2v0 f.b.a.d.a.d A[REMOVE]) = (r0v0 'sVar' f.b.a.d.a.s), (r5v0 'bVar' e.g.a.b) call: f.b.a.d.a.d.<init>(f.b.a.d.a.s, e.g.a.b):void type: CONSTRUCTOR)
                 call: f.b.a.d.a.s.a.<init>(android.net.Uri, f.a.b.p$b, f.a.b.p$a):void type: CONSTRUCTOR in method: f.b.a.d.a.c.a(e.g.a.b):java.lang.Object, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.d.a.b, state: NOT_LOADED
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
            public final java.lang.Object a(e.g.a.b r5) {
                /*
                    r4 = this;
                    f.b.a.d.a.s r0 = f.b.a.d.a.s.this
                    java.util.Objects.requireNonNull(r0)
                    f.b.a.d.a.b r1 = new f.b.a.d.a.b
                    r1.<init>(r0, r5)
                    f.b.a.d.a.d r2 = new f.b.a.d.a.d
                    r2.<init>(r0, r5)
                    f.b.a.d.a.s$a r5 = new f.b.a.d.a.s$a
                    android.net.Uri r3 = r0.b
                    r5.<init>(r3, r1, r2)
                    f.b.a.d.a.j0.d r0 = r0.a
                    f.b.a.d.a.j0.c r0 = (f.b.a.d.a.j0.c) r0
                    f.a.b.o r0 = r0.a
                    r0.a(r5)
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.d.a.c.a(e.g.a.b):java.lang.Object");
            }
        })).y(new g() { // from class: f.b.a.d.a.a
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                s sVar = s.this;
                JSONObject jSONObject = (JSONObject) obj;
                Objects.requireNonNull(sVar);
                if (jSONObject == null) {
                    ((q) sVar.f2870e).a.c("Invalid jsonObj, using default remote configs");
                } else {
                    h0.a f2 = h0.f();
                    try {
                        if (jSONObject.has("enpa_enabled")) {
                            ((q.b) f2).a = Boolean.valueOf(jSONObject.getBoolean("enpa_enabled"));
                        }
                        if (jSONObject.has("enpa_collection_frequency")) {
                            ((q.b) f2).b = Long.valueOf(jSONObject.getLong("enpa_collection_frequency"));
                        }
                        if (jSONObject.has("device_attestation_required")) {
                            ((q.b) f2).c = Boolean.valueOf(jSONObject.getBoolean("device_attestation_required"));
                        }
                        if (jSONObject.has("certificate_pha")) {
                            String string = jSONObject.getString("certificate_pha");
                            Objects.requireNonNull(string, "Null phaCertificate");
                            ((q.b) f2).f2861d = string;
                        }
                        if (jSONObject.has("certificate_facilitator")) {
                            String string2 = jSONObject.getString("certificate_facilitator");
                            Objects.requireNonNull(string2, "Null facilitatorCertificate");
                            ((q.b) f2).f2862e = string2;
                        }
                        if (jSONObject.has("encryption_key_id_pha")) {
                            String string3 = jSONObject.getString("encryption_key_id_pha");
                            Objects.requireNonNull(string3, "Null phaEncryptionKeyId");
                            ((q.b) f2).f2863f = string3;
                        }
                        if (jSONObject.has("encryption_key_id_facilitator")) {
                            String string4 = jSONObject.getString("encryption_key_id_facilitator");
                            Objects.requireNonNull(string4, "Null facilitatorEncryptionKeyId");
                            ((q.b) f2).f2864g = string4;
                        }
                        return f2.a();
                    } catch (JSONException e2) {
                        ((f.b.a.a.a.g0.q) sVar.f2870e).a.d("Failed to parse remote config json, using defaults", e2);
                    }
                }
                return s.f2868g;
            }
        }, this.c);
        e eVar = new g() { // from class: f.b.a.d.a.e
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ((f.b.a.a.a.g0.q) s.this.f2870e).a.d("Failed to fetch or convert remote configuration.", (Exception) obj);
                return s.f2868g;
            }
        };
        w wVar = this.c;
        a.b bVar = new a.b(y, Exception.class, eVar);
        y.a(bVar, f.b.a.c.b.o.b.k1(wVar, bVar));
        return bVar;
    }
}
