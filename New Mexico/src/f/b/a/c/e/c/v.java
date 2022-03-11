package f.b.a.c.e.c;

import android.content.Context;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import f.b.a.c.b.l.a;
import f.b.a.c.b.l.c;
import f.b.a.c.b.l.l.k;
import f.b.a.c.b.l.l.l;
import f.b.a.c.b.o.b;
import f.b.a.c.f.b.b;
import f.b.a.c.f.b.d;
import f.b.a.c.f.b.e;
import f.b.a.c.f.b.f;
import f.b.a.c.i.h;
import f.b.a.c.i.i;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class v extends c<a.c.C0084c> implements f.b.a.c.f.b.c {

    /* renamed from: h */
    public static final a<a.c.C0084c> f2785h = new a<>("Nearby.EXPOSURE_NOTIFICATION_API", new p(), new a.f());

    /* renamed from: i */
    public static final long f2786i;

    /* renamed from: j */
    public static final long f2787j;

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        f2786i = timeUnit.toMillis(2);
        f2787j = timeUnit.toMillis(60);
    }

    public v(Context context) {
        super(context, f2785h, null, c.a.c);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> a() {
        l.a a = l.a();
        a.a = k3.a;
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.p};
        return b.C1(l(1, a.a()), f2786i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> b(List<File> list) {
        b.a aVar = new b.a();
        f.b.a.c.f.b.b bVar = new f.b.a.c.f.b.b(4, aVar.a, 50, aVar.b, 50, aVar.c, 50, aVar.f2804d, 50, aVar.f2805e);
        l.a a = l.a();
        a.a = new f(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2829i};
        return f.b.a.c.b.o.b.C1(f.b.a.c.b.o.b.C1(l(0, a.a()), f2786i).i(new f.b.a.c.i.a(list, bVar, "TYZWQ32170AXEUVCDW7A") { // from class: f.b.a.c.e.c.n3
            public final /* synthetic */ List b;
            public final /* synthetic */ f.b.a.c.f.b.b c;

            {
                this.b = r2;
                this.c = r3;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002e: IPUT  
                  (wrap: f.b.a.c.e.c.i : 0x002b: CONSTRUCTOR  (r4v1 f.b.a.c.e.c.i A[REMOVE]) = (r0v0 'vVar' f.b.a.c.e.c.v), (r2v0 'bVar2' f.b.a.c.f.b.b), (r3v2 'aVar2' f.b.a.c.f.b.a), ("TYZWQ32170AXEUVCDW7A") call: f.b.a.c.e.c.i.<init>(f.b.a.c.e.c.v, f.b.a.c.f.b.b, f.b.a.c.f.b.a, java.lang.String):void type: CONSTRUCTOR)
                  (r1v2 'a2' f.b.a.c.b.l.l.l$a)
                 f.b.a.c.b.l.l.l.a.a f.b.a.c.b.l.l.k in method: f.b.a.c.e.c.n3.a(f.b.a.c.i.h):java.lang.Object, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.c.e.c.i, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:447)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                	... 18 more
                */
            @Override // f.b.a.c.i.a
            public final java.lang.Object a(f.b.a.c.i.h r11) {
                /*
                    r10 = this;
                    f.b.a.c.e.c.v r0 = f.b.a.c.e.c.v.this
                    java.util.List r1 = r10.b
                    f.b.a.c.f.b.b r2 = r10.c
                    java.util.Objects.requireNonNull(r0)
                    java.lang.Object r11 = r11.l()
                    java.lang.Long r11 = (java.lang.Long) r11
                    long r3 = r11.longValue()
                    r11 = 0
                    r5 = 1
                    r6 = 17203704004(0x4016bb0c4, double:8.4997591296E-314)
                    java.lang.String r8 = "TYZWQ32170AXEUVCDW7A"
                    int r9 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
                    if (r9 < 0) goto L_0x0047
                    f.b.a.c.f.b.a r3 = new f.b.a.c.f.b.a
                    r3.<init>(r1)
                    f.b.a.c.b.l.l.l$a r1 = f.b.a.c.b.l.l.l.a()
                    f.b.a.c.e.c.i r4 = new f.b.a.c.e.c.i
                    r4.<init>(r0, r2, r3, r8)
                    r1.a = r4
                    f.b.a.c.b.c[] r2 = new f.b.a.c.b.c[r5]
                    f.b.a.c.b.c r3 = f.b.a.c.f.c.n
                    r2[r11] = r3
                    r1.b = r2
                    f.b.a.c.b.l.l.l r11 = r1.a()
                    f.b.a.c.i.h r11 = r0.l(r5, r11)
                    long r0 = f.b.a.c.e.c.v.f2787j
                    f.b.a.c.i.h r11 = f.b.a.c.b.o.b.C1(r11, r0)
                    goto L_0x0062
                L_0x0047:
                    f.b.a.c.b.l.l.l$a r3 = f.b.a.c.b.l.l.l.a()
                    f.b.a.c.e.c.i3 r4 = new f.b.a.c.e.c.i3
                    r4.<init>(r0, r1, r2, r8)
                    r3.a = r4
                    f.b.a.c.b.c[] r1 = new f.b.a.c.b.c[r5]
                    f.b.a.c.b.c r2 = f.b.a.c.f.c.f2827g
                    r1[r11] = r2
                    r3.b = r1
                    f.b.a.c.b.l.l.l r11 = r3.a()
                    f.b.a.c.i.h r11 = r0.l(r5, r11)
                L_0x0062:
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.c.e.c.n3.a(f.b.a.c.i.h):java.lang.Object");
            }
        }), f2787j);
    }

    @Override // f.b.a.c.f.b.c
    public final h<List<TemporaryExposureKey>> c() {
        l.a a = l.a();
        a.a = new k() { // from class: f.b.a.c.e.c.e
            @Override // f.b.a.c.b.l.l.k
            public final void a(Object obj, Object obj2) {
                r rVar = new r((i) obj2);
                o0 o0Var = new o0(null);
                o0Var.b = rVar;
                ((m1) ((s2) obj).t()).d(o0Var);
            }
        };
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2827g};
        return f.b.a.c.b.o.b.C1(l(0, a.a()), f2786i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<List<DailySummary>> d(DailySummariesConfig dailySummariesConfig) {
        l.a a = l.a();
        a.a = new k(dailySummariesConfig) { // from class: f.b.a.c.e.c.h
            public final /* synthetic */ DailySummariesConfig b;

            {
                this.b = r2;
            }

            @Override // f.b.a.c.b.l.l.k
            public final void a(Object obj, Object obj2) {
                DailySummariesConfig dailySummariesConfig2 = this.b;
                k kVar = new k((i) obj2);
                y yVar = new y(null);
                yVar.b = kVar;
                yVar.c = dailySummariesConfig2;
                ((m1) ((s2) obj).t()).L(yVar);
            }
        };
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2831k};
        return f.b.a.c.b.o.b.C1(l(0, a.a()), f2786i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<List<e>> e() {
        l.a a = l.a();
        a.a = new k("TYZWQ32170AXEUVCDW7A") { // from class: f.b.a.c.e.c.h3
            @Override // f.b.a.c.b.l.l.k
            public final void a(Object obj, Object obj2) {
                u uVar = new u((i) obj2);
                e0 e0Var = new e0(null);
                e0Var.b = uVar;
                e0Var.c = "TYZWQ32170AXEUVCDW7A";
                ((m1) ((s2) obj).t()).u(e0Var);
            }
        };
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2827g};
        return f.b.a.c.b.o.b.C1(l(0, a.a()), f2786i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Long> f() {
        l.a a = l.a();
        a.a = new f(this);
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2829i};
        return f.b.a.c.b.o.b.C1(l(0, a.a()), f2786i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<DiagnosisKeysDataMapping> g() {
        l.a a = l.a();
        a.a = new k() { // from class: f.b.a.c.e.c.b
            @Override // f.b.a.c.b.l.l.k
            public final void a(Object obj, Object obj2) {
                l lVar = new l((i) obj2);
                b0 b0Var = new b0((a0) null);
                b0Var.b = lVar;
                ((m1) ((s2) obj).t()).x(b0Var);
            }
        };
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.m};
        return f.b.a.c.b.o.b.C1(l(0, a.a()), f2786i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Set<d>> getStatus() {
        l.a a = l.a();
        a.a = new k() { // from class: f.b.a.c.e.c.d
            @Override // f.b.a.c.b.l.l.k
            public final void a(Object obj, Object obj2) {
                m mVar = new m((i) obj2);
                l0 l0Var = new l0((k0) null);
                l0Var.b = mVar;
                ((m1) ((s2) obj).t()).s(l0Var);
            }
        };
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2832l};
        return f.b.a.c.b.o.b.C1(l(0, a.a()), f2786i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> h() {
        l.a a = l.a();
        a.a = j3.a;
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.q};
        return f.b.a.c.b.o.b.C1(l(1, a.a()), f2786i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> i(DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        l.a a = l.a();
        a.a = new k() { // from class: f.b.a.c.e.c.v2
            @Override // f.b.a.c.b.l.l.k
            public final void a(Object obj, Object obj2) {
                DiagnosisKeysDataMapping diagnosisKeysDataMapping2 = DiagnosisKeysDataMapping.this;
                a<a.c.C0084c> aVar = v.f2785h;
                h2 h2Var = new h2(null);
                h2Var.b = new o((i) obj2);
                h2Var.c = diagnosisKeysDataMapping2;
                ((m1) ((s2) obj).t()).R(h2Var);
            }
        };
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.m};
        return f.b.a.c.b.o.b.C1(l(1, a.a()), f2786i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Boolean> isEnabled() {
        l.a a = l.a();
        a.a = new k() { // from class: f.b.a.c.e.c.g
            @Override // f.b.a.c.b.l.l.k
            public final void a(Object obj, Object obj2) {
                q qVar = new q((i) obj2);
                v1 v1Var = new v1(null);
                v1Var.b = qVar;
                ((m1) ((s2) obj).t()).q(v1Var);
            }
        };
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2827g};
        return f.b.a.c.b.o.b.C1(l(0, a.a()), f2786i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<f> j() {
        l.a a = l.a();
        a.a = new k() { // from class: f.b.a.c.e.c.c
            @Override // f.b.a.c.b.l.l.k
            public final void a(Object obj, Object obj2) {
                n nVar = new n((i) obj2);
                h0 h0Var = new h0((g0) null);
                h0Var.b = nVar;
                ((m1) ((s2) obj).t()).f(h0Var);
            }
        };
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.o};
        return f.b.a.c.b.o.b.C1(l(0, a.a()), f2786i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> start() {
        l.a a = l.a();
        a.a = l3.a;
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2827g};
        return f.b.a.c.b.o.b.C1(l(1, a.a()), f2786i);
    }

    @Override // f.b.a.c.f.b.c
    public final h<Void> stop() {
        l.a a = l.a();
        a.a = m3.a;
        a.b = new f.b.a.c.b.c[]{f.b.a.c.f.c.f2827g};
        return f.b.a.c.b.o.b.C1(l(1, a.a()), f2786i);
    }
}
