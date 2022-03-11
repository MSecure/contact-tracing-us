package f.b.a.d.a;

import com.google.android.apps.exposurenotification.privateanalytics.PrioJni;
import f.a.a.a.a;
import f.b.a.a.a.g0.f;
import f.b.a.a.a.g0.q;
import f.b.a.a.a.g0.r;
import f.b.a.d.a.d0;
import f.b.a.d.a.g0;
import f.b.a.d.a.i0.a;
import f.b.a.d.a.i0.b;
import f.b.a.d.a.i0.d;
import f.b.a.d.a.i0.e;
import f.b.a.d.a.x;
import f.b.b.a.g;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public class g0 {
    public final ExecutorService a = t.c;
    public final SecureRandom b = new SecureRandom();
    public final f0 c;

    /* renamed from: d */
    public final c0 f2845d;

    /* renamed from: e */
    public final a0 f2846e;

    /* renamed from: f */
    public final d0 f2847f;

    /* renamed from: g */
    public v f2848g;

    /* renamed from: h */
    public final int f2849h;

    /* renamed from: i */
    public final b f2850i;

    /* loaded from: classes.dex */
    public static class a extends Exception {
    }

    /* loaded from: classes.dex */
    public interface b {
        u<u> get();
    }

    /* loaded from: classes.dex */
    public enum c {
        SUCCESS,
        FAILURE
    }

    public g0(b bVar, f0 f0Var, c0 c0Var, a0 a0Var, d0.a aVar, int i2) {
        this.f2850i = bVar;
        this.c = f0Var;
        this.f2845d = c0Var;
        this.f2846e = a0Var;
        r rVar = ((f) aVar).a;
        Objects.requireNonNull(rVar);
        this.f2847f = new q(rVar, f.b.a.a.a.t.p0.a.e("PAPrioSubmitter"));
        this.f2848g = new x(aVar);
        this.f2849h = i2;
    }

    public static boolean a(int i2, Calendar calendar) {
        return calendar.get(3) % 2 == i2 / 7 && calendar.get(7) == (i2 % 7) + 1;
    }

    public final List<u<c>> b(List<w> list, h0 h0Var) {
        boolean z;
        ArrayList arrayList = new ArrayList(list.size());
        for (w wVar : list) {
            e0 e0Var = wVar.a;
            double d2 = wVar.c;
            if (this.b.nextDouble() > d2) {
                d0 d0Var = this.f2847f;
                StringBuilder h2 = f.a.a.a.a.h("Skipping sample for metric ");
                h2.append(e0Var.b());
                h2.append(". samplingRate=");
                h2.append(d2);
                ((q) d0Var).a.a(h2.toString());
                z = false;
            } else {
                z = true;
            }
            if (z) {
                String b2 = wVar.a.b();
                l y = l.x(wVar.a.a()).y(new g(wVar, h0Var) { // from class: f.b.a.d.a.m
                    public final /* synthetic */ w b;
                    public final /* synthetic */ h0 c;

                    {
                        this.b = r2;
                        this.c = r3;
                    }

                    @Override // f.b.b.a.g
                    public final Object a(Object obj) {
                        g0 g0Var = g0.this;
                        w wVar2 = this.b;
                        h0 h0Var2 = this.c;
                        List list2 = (List) obj;
                        Objects.requireNonNull(g0Var);
                        double d3 = wVar2.b;
                        String g2 = h0Var2.g();
                        String d4 = h0Var2.d();
                        d.b r = d.r();
                        int size = list2.size();
                        r.copyOnWrite();
                        d.c((d) r.instance, size);
                        r.copyOnWrite();
                        d.d((d) r.instance, d3);
                        r.copyOnWrite();
                        d.f((d) r.instance, 2);
                        r.copyOnWrite();
                        d.e((d) r.instance, 4293918721L);
                        d build = r.build();
                        d0 d0Var2 = g0Var.f2847f;
                        StringBuilder h3 = a.h("Generating packets w/ params: bins=");
                        h3.append(build.g());
                        h3.append(" epsilon=");
                        h3.append(build.i());
                        ((q) d0Var2).a.f(h3.toString());
                        a.b g3 = f.b.a.d.a.i0.a.g();
                        g3.copyOnWrite();
                        f.b.a.d.a.i0.a.d((f.b.a.d.a.i0.a) g3.instance, list2);
                        g3.copyOnWrite();
                        f.b.a.d.a.i0.a.c((f.b.a.d.a.i0.a) g3.instance, build);
                        g3.copyOnWrite();
                        f.b.a.d.a.i0.a.e((f.b.a.d.a.i0.a) g3.instance, g2);
                        g3.copyOnWrite();
                        f.b.a.d.a.i0.a.e((f.b.a.d.a.i0.a) g3.instance, d4);
                        return g3.build();
                    }
                }, this.a).y(new g() { // from class: f.b.a.d.a.n
                    @Override // f.b.b.a.g
                    public final Object a(Object obj) {
                        boolean z2;
                        b bVar;
                        g0 g0Var = g0.this;
                        f.b.a.d.a.i0.a aVar = (f.b.a.d.a.i0.a) obj;
                        Objects.requireNonNull(g0Var);
                        Objects.requireNonNull(aVar, "Null createPacketsParameters");
                        x xVar = (x) g0Var.f2848g;
                        Objects.requireNonNull(xVar);
                        e.b h3 = e.h();
                        x.b bVar2 = x.b;
                        d0 d0Var2 = xVar.a;
                        synchronized (bVar2) {
                            if (!bVar2.b) {
                                bVar2.b = true;
                                try {
                                    ((q) d0Var2).a.a("Loading Prio native library");
                                    System.loadLibrary("prioclient");
                                    bVar2.a = true;
                                    ((q) d0Var2).a.a("Prio native library loaded successfully");
                                } catch (NullPointerException | SecurityException | UnsatisfiedLinkError e2) {
                                    bVar2.a = false;
                                    ((q) d0Var2).a.d("Prio native library load failed.", e2);
                                }
                            } else {
                                ((q) d0Var2).a.a("Prio native library load skipped; already attempted with result=" + bVar2.a);
                            }
                            z2 = bVar2.a;
                        }
                        if (z2) {
                            try {
                                bVar = b.g(PrioJni.createPackets(aVar.toByteArray()));
                                d0 d0Var3 = xVar.a;
                                ((q) d0Var3).a.a("Response Status: " + bVar.d().g());
                                if (bVar.d().g() != e.c.OK) {
                                    d0 d0Var4 = xVar.a;
                                    ((q) d0Var4).a.g("Error when creating packets: " + bVar.d().f());
                                }
                            } catch (Exception unused) {
                                e.c cVar = e.c.UNKNOWN_FAILURE;
                                h3.copyOnWrite();
                                e.c((e) h3.instance, cVar);
                                h3.copyOnWrite();
                                e.d((e) h3.instance, "Unable to parse responseBytes");
                                ((q) xVar.a).a.g("Unable to parse responseBytes");
                            }
                            Objects.requireNonNull(bVar, "Null createPacketsResponse");
                            return new p(aVar, bVar, null);
                        }
                        e.c cVar2 = e.c.LIBRARY_UNAVAILABLE;
                        h3.copyOnWrite();
                        e.c((e) h3.instance, cVar2);
                        h3.copyOnWrite();
                        e.d((e) h3.instance, "Prio is not available.");
                        ((q) xVar.a).a.c("Prio is not available.");
                        b.C0091b f2 = b.f();
                        f2.copyOnWrite();
                        b.c((b) f2.instance, h3.build());
                        bVar = f2.build();
                        Objects.requireNonNull(bVar, "Null createPacketsResponse");
                        return new p(aVar, bVar, null);
                    }
                }, this.a).y(new g(b2, h0Var) { // from class: f.b.a.d.a.l
                    public final /* synthetic */ String b;
                    public final /* synthetic */ h0 c;

                    {
                        this.b = r2;
                        this.c = r3;
                    }

                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x02d6: INVOKE  
                          (wrap: f.b.c.k.x.c : 0x02cf: IGET  (r3v25 f.b.c.k.x.c A[REMOVE]) = (r0v34 'nVar' f.b.c.k.s.n) f.b.c.k.s.n.c f.b.c.k.x.c)
                          (wrap: f.b.c.k.s.j : 0x02d3: CONSTRUCTOR  (r5v3 f.b.c.k.s.j A[REMOVE]) = (r0v34 'nVar' f.b.c.k.s.n), (r4v16 'arrayList3' java.util.ArrayList), (r2v18 'iVar' f.b.a.c.i.i) call: f.b.c.k.s.j.<init>(f.b.c.k.s.n, java.util.List, f.b.a.c.i.i):void type: CONSTRUCTOR)
                         type: VIRTUAL call: f.b.c.k.x.c.b(java.lang.Runnable):void in method: f.b.a.d.a.l.a(java.lang.Object):java.lang.Object, file: classes.dex
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
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:136)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.c.k.s.j, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                        	... 40 more
                        */
                    @Override // f.b.b.a.g
                    /* Code decompiled incorrectly, please refer to instructions dump */
                    public final java.lang.Object a(java.lang.Object r22) {
                        /*
                        // Method dump skipped, instructions count: 864
                        */
                        throw new UnsupportedOperationException("Method not decompiled: f.b.a.d.a.l.a(java.lang.Object):java.lang.Object");
                    }
                }, this.a).y(new g(b2) { // from class: f.b.a.d.a.k
                    public final /* synthetic */ String b;

                    {
                        this.b = r2;
                    }

                    @Override // f.b.b.a.g
                    public final Object a(Object obj) {
                        g0 g0Var = g0.this;
                        String str = this.b;
                        u uVar = (u) obj;
                        ((q) g0Var.f2847f).a.a(String.format("Workflow for prioDataPoint %s finished successfully.", str));
                        return g0.c.SUCCESS;
                    }
                }, this.a);
                j jVar = new g(b2) { // from class: f.b.a.d.a.j
                    public final /* synthetic */ String b;

                    {
                        this.b = r2;
                    }

                    @Override // f.b.b.a.g
                    public final Object a(Object obj) {
                        g0 g0Var = g0.this;
                        String str = this.b;
                        d0 d0Var2 = g0Var.f2847f;
                        String x = f.a.a.a.a.x("Error submitting prioDataPoint", str);
                        ((q) d0Var2).a.h(x, (Exception) obj);
                        return g0.c.FAILURE;
                    }
                };
                ExecutorService executorService = this.a;
                a.b bVar = new a.b(y, Exception.class, jVar);
                y.a(bVar, f.b.a.c.b.o.b.k1(executorService, bVar));
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }
}
