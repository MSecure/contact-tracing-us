package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;
import f.b.a.a.a.c0.j0;
import f.b.a.a.a.c0.k0;
import f.b.a.a.a.c0.l0;
import f.b.a.a.a.c0.n1;
import f.b.a.a.a.c0.p0;
import f.b.a.a.a.c0.q1;
import f.b.a.a.a.h0.p;
import f.b.a.a.a.p0.r;
import f.b.a.a.a.y.n;
import f.b.a.c.b.o.b;
import f.b.b.a.g;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.d;
/* loaded from: classes.dex */
public class ProvideDiagnosisKeysWorker extends ListenableWorker {
    public static final d o = d.h(4);
    public static final f.b.a.a.a.t.p0.a p = f.b.a.a.a.t.p0.a.e("ProvideDiagnosisKeysWkr");
    public static final d q = d.n(10);
    public static final d r = d.n(10);

    /* renamed from: g */
    public final n f383g;

    /* renamed from: h */
    public final n1 f384h;

    /* renamed from: i */
    public final q1 f385i;

    /* renamed from: j */
    public final DiagnosisKeysDataMapping f386j;

    /* renamed from: k */
    public final ExecutorService f387k;

    /* renamed from: l */
    public final ScheduledExecutorService f388l;
    public final r m;
    public final f.b.a.a.a.a0.r n;

    /* loaded from: classes.dex */
    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Exception {
        public c() {
        }

        public c(a aVar) {
        }
    }

    public ProvideDiagnosisKeysWorker(Context context, WorkerParameters workerParameters, n nVar, q1 q1Var, n1 n1Var, DiagnosisKeysDataMapping diagnosisKeysDataMapping, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, r rVar, f.b.a.a.a.a0.r rVar2) {
        super(context, workerParameters);
        this.f383g = nVar;
        this.f385i = q1Var;
        this.f384h = n1Var;
        this.f386j = diagnosisKeysDataMapping;
        this.f387k = executorService;
        this.f388l = scheduledExecutorService;
        this.m = rVar;
        this.n = rVar2;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        p.a("Starting worker providing the DiagnosisKeysDataMapping to the API, downloading diagnosis key files and submitting them to the API for exposure detection, then storing the token used.");
        l z = l.x(this.m.b()).z(new i() { // from class: f.b.a.a.a.c0.h0
            @Override // f.b.b.f.a.i
            public final u a(Object obj) {
                ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker = ProvideDiagnosisKeysWorker.this;
                provideDiagnosisKeysWorker.n.i(p.d.TASK_PROVIDE_DIAGNOSIS_KEYS);
                if (!((Boolean) obj).booleanValue()) {
                    return new s.a(new ProvideDiagnosisKeysWorker.c(null));
                }
                l x = l.x(m.e.o0(provideDiagnosisKeysWorker.f385i.a.g(), ProvideDiagnosisKeysWorker.q, provideDiagnosisKeysWorker.f388l));
                o0 o0Var = o0.a;
                ExecutorService executorService = provideDiagnosisKeysWorker.f387k;
                a.C0110a aVar = new a.C0110a(x, Exception.class, o0Var);
                x.a(aVar, b.k1(executorService, aVar));
                return aVar;
            }
        }, this.f387k).z(new i() { // from class: f.b.a.a.a.c0.i0
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003b: INVOKE  (r5v8 'uVar' f.b.b.f.a.u<?>) = 
                  (wrap: f.b.a.c.i.h<java.lang.Void> : 0x0033: INVOKE  (r5v7 f.b.a.c.i.h<java.lang.Void> A[REMOVE]) = 
                  (wrap: f.b.a.c.i.h<java.lang.Void> : 0x002a: INVOKE  (r1v3 f.b.a.c.i.h<java.lang.Void> A[REMOVE]) = 
                  (wrap: f.b.a.c.i.h<java.lang.Void> : 0x0021: INVOKE  (r1v2 f.b.a.c.i.h<java.lang.Void> A[REMOVE]) = 
                  (wrap: f.b.a.c.f.b.c : 0x001f: IGET  (r2v2 f.b.a.c.f.b.c A[REMOVE]) = (r5v6 'q1Var' f.b.a.a.a.c0.q1) f.b.a.a.a.c0.q1.a f.b.a.c.f.b.c)
                  (r1v0 'diagnosisKeysDataMapping' com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping)
                 type: INTERFACE call: f.b.a.c.f.b.c.i(com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping):f.b.a.c.i.h)
                  (wrap: f.b.a.a.a.c0.f : 0x0027: CONSTRUCTOR  (r2v3 f.b.a.a.a.c0.f A[REMOVE]) = (r5v6 'q1Var' f.b.a.a.a.c0.q1) call: f.b.a.a.a.c0.f.<init>(f.b.a.a.a.c0.q1):void type: CONSTRUCTOR)
                 type: VIRTUAL call: f.b.a.c.i.h.d(f.b.a.c.i.e):f.b.a.c.i.h)
                  (wrap: f.b.a.a.a.c0.j : 0x0030: CONSTRUCTOR  (r2v4 f.b.a.a.a.c0.j A[REMOVE]) = (r5v6 'q1Var' f.b.a.a.a.c0.q1) call: f.b.a.a.a.c0.j.<init>(f.b.a.a.a.c0.q1):void type: CONSTRUCTOR)
                 type: VIRTUAL call: f.b.a.c.i.h.f(f.b.a.c.i.f):f.b.a.c.i.h)
                  (wrap: l.b.a.d : 0x0037: SGET  (r1v4 l.b.a.d A[REMOVE]) =  com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker.r l.b.a.d)
                  (wrap: java.util.concurrent.ScheduledExecutorService : 0x0039: IGET  (r2v5 java.util.concurrent.ScheduledExecutorService A[REMOVE]) = (r0v0 'provideDiagnosisKeysWorker' com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker) com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker.l java.util.concurrent.ScheduledExecutorService)
                 type: STATIC call: e.b.a.m.e.o0(f.b.a.c.i.h, l.b.a.d, java.util.concurrent.ScheduledExecutorService):f.b.b.f.a.u in method: f.b.a.a.a.c0.i0.a(java.lang.Object):f.b.b.f.a.u, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.c0.f, state: NOT_LOADED
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
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:768)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                	... 16 more
                */
            @Override // f.b.b.f.a.i
            public final f.b.b.f.a.u a(java.lang.Object r5) {
                /*
                    r4 = this;
                    com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker r0 = com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker.this
                    com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping r5 = (com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping) r5
                    com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping r1 = r0.f386j
                    boolean r5 = r5.equals(r1)
                    if (r5 == 0) goto L_0x0016
                    f.b.a.a.a.t.p0.a r5 = com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker.p
                    java.lang.String r1 = "DiagnosisKeysDataMapping unchanged, not requesting update"
                    r5.a(r1)
                    f.b.b.f.a.u<?> r5 = f.b.b.f.a.s.c
                    goto L_0x003f
                L_0x0016:
                    f.b.a.a.a.t.p0.a r5 = com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker.p
                    java.lang.String r2 = "Updated DiagnosisKeysDataMapping detected, calling Nearby.setDiagnosisKeysDataMapping"
                    r5.a(r2)
                    f.b.a.a.a.c0.q1 r5 = r0.f385i
                    f.b.a.c.f.b.c r2 = r5.a
                    f.b.a.c.i.h r1 = r2.i(r1)
                    f.b.a.a.a.c0.f r2 = new f.b.a.a.a.c0.f
                    r2.<init>(r5)
                    f.b.a.c.i.h r1 = r1.d(r2)
                    f.b.a.a.a.c0.j r2 = new f.b.a.a.a.c0.j
                    r2.<init>(r5)
                    f.b.a.c.i.h r5 = r1.f(r2)
                    l.b.a.d r1 = com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker.r
                    java.util.concurrent.ScheduledExecutorService r2 = r0.f388l
                    f.b.b.f.a.u r5 = e.b.a.m.e.o0(r5, r1, r2)
                L_0x003f:
                    f.b.b.f.a.l r5 = f.b.b.f.a.l.x(r5)
                    java.lang.Class<java.lang.Exception> r1 = java.lang.Exception.class
                    f.b.a.a.a.c0.g0 r2 = f.b.a.a.a.c0.g0.a
                    java.util.concurrent.ExecutorService r0 = r0.f387k
                    f.b.b.f.a.a$a r3 = new f.b.b.f.a.a$a
                    r3.<init>(r5, r1, r2)
                    java.util.concurrent.Executor r0 = f.b.a.c.b.o.b.k1(r0, r3)
                    r5.a(r3, r0)
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.c0.i0.a(java.lang.Object):f.b.b.f.a.u");
            }
        }, this.f387k);
        p0 p0Var = p0.a;
        ExecutorService executorService = this.f387k;
        a.C0110a aVar = new a.C0110a(z, b.class, p0Var);
        ((l.a) z).a(aVar, f.b.a.c.b.o.b.k1(executorService, aVar));
        l<T> z2 = aVar.z(new i() { // from class: f.b.a.a.a.c0.n0
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0115: INVOKE  
                  (r2v4 'arrayList2' java.util.ArrayList)
                  (wrap: f.b.b.f.a.l : 0x0111: INVOKE  (r3v13 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x0106: INVOKE  (r4v11 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.u : 0x0102: INVOKE  (r4v10 f.b.b.f.a.u A[REMOVE]) = 
                  (wrap: f.b.a.a.a.y.g : 0x00ff: CONSTRUCTOR  (r4v9 f.b.a.a.a.y.g A[REMOVE]) = (r1v7 'rVar2' f.b.a.a.a.y.r), (r3v11 'oVar' f.b.a.a.a.y.o) call: f.b.a.a.a.y.g.<init>(f.b.a.a.a.y.r, f.b.a.a.a.y.o):void type: CONSTRUCTOR)
                 type: STATIC call: e.b.a.m.e.n0(e.g.a.d):f.b.b.f.a.u)
                 type: STATIC call: f.b.b.f.a.l.x(f.b.b.f.a.u):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.y.h : 0x010c: CONSTRUCTOR  (r5v4 f.b.a.a.a.y.h A[REMOVE]) = (r1v7 'rVar2' f.b.a.a.a.y.r), (r3v11 'oVar' f.b.a.a.a.y.o) call: f.b.a.a.a.y.h.<init>(f.b.a.a.a.y.r, f.b.a.a.a.y.o):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x010f: IGET  (r3v12 java.util.concurrent.ExecutorService A[REMOVE]) = (r1v7 'rVar2' f.b.a.a.a.y.r) f.b.a.a.a.y.r.d java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.y(f.b.b.a.g, java.util.concurrent.Executor):f.b.b.f.a.l)
                 type: VIRTUAL call: java.util.ArrayList.add(java.lang.Object):boolean in method: f.b.a.a.a.c0.n0.a(java.lang.Object):f.b.b.f.a.u, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:206)
                	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.y.g, state: NOT_LOADED
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
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                	... 22 more
                */
            @Override // f.b.b.f.a.i
            public final f.b.b.f.a.u a(java.lang.Object r10) {
                /*
                // Method dump skipped, instructions count: 347
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.c0.n0.a(java.lang.Object):f.b.b.f.a.u");
            }
        }, this.f387k);
        n1 n1Var = this.f384h;
        Objects.requireNonNull(n1Var);
        l y = z2.z(new i() { // from class: f.b.a.a.a.c0.s
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0196: INVOKE  
                  (wrap: f.b.a.c.i.h<java.lang.Void> : 0x018d: INVOKE  (r3v5 f.b.a.c.i.h<java.lang.Void> A[REMOVE]) = 
                  (r2v7 'b2' f.b.a.c.i.h<java.lang.Void>)
                  (wrap: f.b.a.a.a.c0.h : 0x018a: CONSTRUCTOR  (r3v4 f.b.a.a.a.c0.h A[REMOVE]) = (r1v2 'q1Var' f.b.a.a.a.c0.q1) call: f.b.a.a.a.c0.h.<init>(f.b.a.a.a.c0.q1):void type: CONSTRUCTOR)
                 type: VIRTUAL call: f.b.a.c.i.h.d(f.b.a.c.i.e):f.b.a.c.i.h)
                  (wrap: f.b.a.a.a.c0.d : 0x0193: CONSTRUCTOR  (r4v1 f.b.a.a.a.c0.d A[REMOVE]) = (r1v2 'q1Var' f.b.a.a.a.c0.q1) call: f.b.a.a.a.c0.d.<init>(f.b.a.a.a.c0.q1):void type: CONSTRUCTOR)
                 type: VIRTUAL call: f.b.a.c.i.h.f(f.b.a.c.i.f):f.b.a.c.i.h in method: f.b.a.a.a.c0.s.a(java.lang.Object):f.b.b.f.a.u, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.c0.h, state: NOT_LOADED
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
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:768)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                	... 14 more
                */
            @Override // f.b.b.f.a.i
            public final f.b.b.f.a.u a(java.lang.Object r13) {
                /*
                // Method dump skipped, instructions count: 434
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.c0.s.a(java.lang.Object):f.b.b.f.a.u");
            }
        }, this.f387k).y(new g() { // from class: f.b.a.a.a.c0.m0
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ProvideDiagnosisKeysWorker.this.n.g(p.d.TASK_PROVIDE_DIAGNOSIS_KEYS);
                return new ListenableWorker.a.c();
            }
        }, this.f387k);
        j0 j0Var = new g() { // from class: f.b.a.a.a.c0.j0
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ProvideDiagnosisKeysWorker.c cVar = (ProvideDiagnosisKeysWorker.c) obj;
                ProvideDiagnosisKeysWorker.this.n.h(p.d.TASK_PROVIDE_DIAGNOSIS_KEYS);
                return new ListenableWorker.a.c();
            }
        };
        ExecutorService executorService2 = this.f387k;
        a.b bVar = new a.b(y, c.class, j0Var);
        y.a(bVar, f.b.a.c.b.o.b.k1(executorService2, bVar));
        k0 k0Var = new g() { // from class: f.b.a.a.a.c0.k0
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ProvideDiagnosisKeysWorker.this.n.k(p.d.TASK_PROVIDE_DIAGNOSIS_KEYS, (r.a) obj);
                return new ListenableWorker.a.C0003a();
            }
        };
        ExecutorService executorService3 = this.f387k;
        a.b bVar2 = new a.b(bVar, r.a.class, k0Var);
        bVar.a(bVar2, f.b.a.c.b.o.b.k1(executorService3, bVar2));
        l0 l0Var = new g() { // from class: f.b.a.a.a.c0.l0
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker = ProvideDiagnosisKeysWorker.this;
                Exception exc = (Exception) obj;
                Objects.requireNonNull(provideDiagnosisKeysWorker);
                ProvideDiagnosisKeysWorker.p.d("Failure to provide diagnosis keys", exc);
                provideDiagnosisKeysWorker.n.k(p.d.TASK_PROVIDE_DIAGNOSIS_KEYS, exc);
                return new ListenableWorker.a.C0003a();
            }
        };
        ExecutorService executorService4 = this.f387k;
        a.b bVar3 = new a.b(bVar2, Exception.class, l0Var);
        bVar2.a(bVar3, f.b.a.c.b.o.b.k1(executorService4, bVar3));
        return bVar3;
    }
}
