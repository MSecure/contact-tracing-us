package f.b.a.a.a;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import e.b.a.m;
import e.p.a.b;
import f.b.a.a.a.g0.n;
import f.b.a.a.a.g0.s.e;
import f.b.a.a.a.g0.s.f;
import f.b.a.a.a.g0.s.g;
import f.b.a.a.a.g0.s.h;
import f.b.a.a.a.g0.s.j;
import f.b.a.a.a.g0.s.k;
import f.b.a.a.a.g0.s.l;
import f.b.a.a.a.g0.s.o;
import f.b.a.a.a.g0.s.p;
import f.b.a.a.a.g0.s.q;
import f.b.a.a.a.g0.s.r;
import f.b.a.d.a.c0;
import f.b.a.d.a.d0;
import f.b.a.d.a.f0;
import f.b.a.d.a.g0;
import f.b.b.f.a.u;
import f.b.b.f.a.w;
import g.b.a.c.c.d;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Objects;
/*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
    java.lang.UnsupportedOperationException
    	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
    	at java.util.AbstractList.equals(AbstractList.java:519)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
    */
/* loaded from: classes.dex */
public class i implements b {
    public final /* synthetic */ k a;

    public i(k kVar) {
        this.a = kVar;
    }

    @Override // e.p.a.b
    public ListenableWorker a(Context context, WorkerParameters workerParameters) {
        k kVar = this.a.t;
        Objects.requireNonNull(kVar);
        o oVar = kVar.o;
        Context t = d.t(kVar.c);
        n nVar = new n(kVar.F.get(), kVar.r(), kVar.E.get(), kVar.o());
        w wVar = kVar.u.get();
        r rVar = new r(kVar.b());
        h hVar = new h(kVar.A.get(), kVar.x.get(), kVar.i(), m.e.k1(kVar.f2293e));
        q qVar = new q(kVar.b());
        f.b.a.a.a.g0.s.d dVar = new f.b.a.a.a.g0.s.d(kVar.b());
        e eVar = new e(kVar.b());
        j jVar = new j(kVar.b());
        f.b.a.a.a.g0.s.m mVar = new f.b.a.a.a.g0.s.m(kVar.b());
        g gVar = new g(kVar.b());
        l lVar = new l(kVar.b());
        f.b.a.a.a.g0.s.i iVar = new f.b.a.a.a.g0.s.i(kVar.b());
        p pVar = new p(kVar.b());
        f fVar = new f(kVar.b());
        k kVar2 = new k(kVar.b());
        Objects.requireNonNull(oVar);
        f.b.a.a.a.g0.s.b bVar = new g0.b(nVar, rVar, hVar, qVar, dVar, jVar, gVar, t, lVar, eVar, mVar, iVar, pVar, fVar, kVar2, wVar) { // from class: f.b.a.a.a.g0.s.b
            public final /* synthetic */ n b;
            public final /* synthetic */ r c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ h f2259d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ q f2260e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f2261f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ j f2262g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ g f2263h;

            /* renamed from: i  reason: collision with root package name */
            public final /* synthetic */ Context f2264i;

            /* renamed from: j  reason: collision with root package name */
            public final /* synthetic */ l f2265j;

            /* renamed from: k  reason: collision with root package name */
            public final /* synthetic */ e f2266k;

            /* renamed from: l  reason: collision with root package name */
            public final /* synthetic */ m f2267l;
            public final /* synthetic */ i m;
            public final /* synthetic */ p n;
            public final /* synthetic */ f o;
            public final /* synthetic */ k p;
            public final /* synthetic */ w q;

            {
                this.b = r4;
                this.c = r5;
                this.f2259d = r6;
                this.f2260e = r7;
                this.f2261f = r8;
                this.f2262g = r9;
                this.f2263h = r10;
                this.f2264i = r11;
                this.f2265j = r12;
                this.f2266k = r13;
                this.f2267l = r14;
                this.m = r15;
                this.n = r16;
                this.o = r17;
                this.p = r18;
                this.q = r19;
            }

            @Override // f.b.a.d.a.g0.b
            public final u get() {
                o oVar2 = o.this;
                n nVar2 = this.b;
                r rVar2 = this.c;
                h hVar2 = this.f2259d;
                q qVar2 = this.f2260e;
                d dVar2 = this.f2261f;
                j jVar2 = this.f2262g;
                g gVar2 = this.f2263h;
                Context context2 = this.f2264i;
                l lVar2 = this.f2265j;
                e eVar2 = this.f2266k;
                m mVar2 = this.f2267l;
                i iVar2 = this.m;
                p pVar2 = this.n;
                f fVar2 = this.o;
                k kVar3 = this.p;
                w wVar2 = this.q;
                Objects.requireNonNull(oVar2);
                Objects.requireNonNull(nVar2);
                f.b.b.f.a.l y = f.b.b.f.a.l.x(m.e.n0(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0046: INVOKE  (r0v4 'y' f.b.b.f.a.l) = 
                      (wrap: f.b.b.f.a.l : 0x0037: INVOKE  (r0v3 f.b.b.f.a.l A[REMOVE]) = 
                      (wrap: f.b.b.f.a.u : 0x0033: INVOKE  (r0v2 f.b.b.f.a.u A[REMOVE]) = 
                      (wrap: f.b.a.a.a.g0.e : 0x0030: CONSTRUCTOR  (r0v1 f.b.a.a.a.g0.e A[REMOVE]) = (r1v0 'nVar2' f.b.a.a.a.g0.n) call: f.b.a.a.a.g0.e.<init>(f.b.a.a.a.g0.n):void type: CONSTRUCTOR)
                     type: STATIC call: e.b.a.m.e.n0(e.g.a.d):f.b.b.f.a.u)
                     type: STATIC call: f.b.b.f.a.l.x(f.b.b.f.a.u):f.b.b.f.a.l)
                      (wrap: f.b.a.a.a.g0.a : 0x003f: CONSTRUCTOR  (r15v3 f.b.a.a.a.g0.a A[REMOVE]) = (r1v0 'nVar2' f.b.a.a.a.g0.n) call: f.b.a.a.a.g0.a.<init>(f.b.a.a.a.g0.n):void type: CONSTRUCTOR)
                      (wrap: f.b.b.f.a.w : 0x0044: IGET  (r14v1 f.b.b.f.a.w A[REMOVE]) = (r1v0 'nVar2' f.b.a.a.a.g0.n) f.b.a.a.a.g0.n.a f.b.b.f.a.w)
                     type: VIRTUAL call: f.b.b.f.a.l.y(f.b.b.a.g, java.util.concurrent.Executor):f.b.b.f.a.l in method: f.b.a.a.a.g0.s.b.get():f.b.b.f.a.u, file: classes.dex
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
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.g0.e, state: NOT_LOADED
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
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:768)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    r0 = r21
                    f.b.a.a.a.g0.s.o r2 = f.b.a.a.a.g0.s.o.this
                    f.b.a.a.a.g0.n r1 = r0.b
                    f.b.a.a.a.g0.s.r r3 = r0.c
                    f.b.a.a.a.g0.s.h r4 = r0.f2259d
                    f.b.a.a.a.g0.s.q r5 = r0.f2260e
                    f.b.a.a.a.g0.s.d r6 = r0.f2261f
                    f.b.a.a.a.g0.s.j r7 = r0.f2262g
                    f.b.a.a.a.g0.s.g r8 = r0.f2263h
                    android.content.Context r9 = r0.f2264i
                    f.b.a.a.a.g0.s.l r10 = r0.f2265j
                    f.b.a.a.a.g0.s.e r11 = r0.f2266k
                    f.b.a.a.a.g0.s.m r12 = r0.f2267l
                    f.b.a.a.a.g0.s.i r13 = r0.m
                    f.b.a.a.a.g0.s.p r14 = r0.n
                    f.b.a.a.a.g0.s.f r15 = r0.o
                    r16 = r15
                    f.b.a.a.a.g0.s.k r15 = r0.p
                    r17 = r15
                    f.b.b.f.a.w r15 = r0.q
                    java.util.Objects.requireNonNull(r2)
                    java.util.Objects.requireNonNull(r1)
                    f.b.a.a.a.g0.e r0 = new f.b.a.a.a.g0.e
                    r0.<init>(r1)
                    f.b.b.f.a.u r0 = e.b.a.m.e.n0(r0)
                    f.b.b.f.a.l r0 = f.b.b.f.a.l.x(r0)
                    r18 = r15
                    f.b.a.a.a.g0.a r15 = new f.b.a.a.a.g0.a
                    r15.<init>(r1)
                    r19 = r14
                    f.b.b.f.a.w r14 = r1.a
                    f.b.b.f.a.l r0 = r0.y(r15, r14)
                    java.lang.Class<java.lang.Exception> r14 = java.lang.Exception.class
                    f.b.a.a.a.g0.c r15 = f.b.a.a.a.g0.c.a
                    f.b.b.f.a.w r1 = r1.a
                    r20 = r13
                    f.b.b.f.a.a$b r13 = new f.b.b.f.a.a$b
                    r13.<init>(r0, r14, r15)
                    java.util.concurrent.Executor r1 = f.b.a.c.b.o.b.k1(r1, r13)
                    r0.a(r13, r1)
                    f.b.a.a.a.g0.s.c r0 = new f.b.a.a.a.g0.s.c
                    r1 = r0
                    r15 = r13
                    r13 = r20
                    r14 = r19
                    r19 = r18
                    r18 = r0
                    r0 = r15
                    r15 = r16
                    r16 = r17
                    r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
                    r2 = r18
                    r1 = r19
                    f.b.b.f.a.u r0 = f.b.a.c.b.o.b.v1(r0, r2, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.g0.s.b.get():f.b.b.f.a.u");
            }
        };
        f0 q = kVar.q();
        f.b.a.a.a.g0.r rVar2 = kVar.p;
        Context t2 = d.t(kVar.c);
        f.b.a.a.a.g0.r rVar3 = kVar.p;
        Context t3 = d.t(kVar.c);
        Objects.requireNonNull(rVar3);
        String string = t3.getString(R.string.enx_healthAuthorityID);
        Objects.requireNonNull(string, "Cannot return null from a non-@Nullable @Provides method");
        d0.a l1 = m.e.l1(kVar.p);
        Objects.requireNonNull(rVar2);
        return new SubmitPrivateAnalyticsWorker(context, workerParameters, new g0(bVar, q, new c0(new f.b.a.d.a.r(t2, string, l1), kVar.O.get(), m.e.l1(kVar.p)), kVar.p(), m.e.l1(kVar.p), kVar.g()), kVar.v.get(), kVar.v(), m.e.k1(kVar.f2293e), kVar.b(), kVar.o(), kVar.g());
    }
}
