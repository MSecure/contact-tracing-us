package f.b.a.a.a.p0;

import e.b.a.m;
import e.v.l;
import e.x.a.f.f;
import f.b.a.a.a.c0.o1;
import f.b.a.a.a.c0.q1;
import f.b.a.a.a.c0.u1;
import f.b.a.a.a.n0.f1;
import f.b.a.a.a.n0.l1;
import f.b.a.a.a.n0.r0;
import f.b.a.a.a.n0.v0;
import f.b.a.a.a.t.a0;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.d;
import l.b.a.e;
/* loaded from: classes.dex */
public class r {

    /* renamed from: f */
    public static final f.b.a.a.a.t.p0.a f2376f = f.b.a.a.a.t.p0.a.e("WorkerStartupManager");

    /* renamed from: g */
    public static final d f2377g = d.n(10);

    /* renamed from: h */
    public static final d f2378h = d.n(10);
    public final q1 a;
    public final u1 b;
    public final a0 c;

    /* renamed from: d */
    public final ExecutorService f2379d;

    /* renamed from: e */
    public final ScheduledExecutorService f2380e;

    /* loaded from: classes.dex */
    public static class a extends Exception {
        public a(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Exception {
        public b(Throwable th) {
            super(th);
        }
    }

    public r(q1 q1Var, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, u1 u1Var, a0 a0Var) {
        this.a = q1Var;
        this.f2379d = executorService;
        this.f2380e = scheduledExecutorService;
        this.b = u1Var;
        this.c = a0Var;
    }

    public final void a() {
        a0 a0Var = this.c;
        v0 v0Var = a0Var.f2385g;
        e w = a0Var.n.c().w(a0.p);
        r0 r0Var = (r0) v0Var.a;
        r0Var.a.b();
        f a2 = r0Var.c.a();
        a2.b.bindLong(1, m.e.c0(w));
        r0Var.a.c();
        try {
            a2.d();
            r0Var.a.l();
            l1 l1Var = a0Var.f2386h;
            e w2 = a0Var.n.c().w(a0.q);
            f1 f1Var = (f1) l1Var.a;
            f1Var.a.b();
            f a3 = f1Var.c.a();
            a3.b.bindLong(1, m.e.c0(w2));
            f1Var.a.c();
            try {
                a3.d();
                f1Var.a.l();
                o1 o1Var = a0Var.f2388j;
                f.b.a.a.a.j0.d b2 = o1Var.a.b();
                if (!o1Var.d(b2) && o1Var.f(b2)) {
                    a0Var.f2388j.a();
                }
                a0 a0Var2 = this.c;
                l1 l1Var2 = a0Var2.f2386h;
                e c = a0Var2.n.c();
                f1 f1Var2 = (f1) l1Var2.a;
                f1Var2.a.b();
                f a4 = f1Var2.f2336d.a();
                a4.b.bindLong(1, m.e.c0(c));
                f1Var2.a.c();
                try {
                    a4.d();
                    f1Var2.a.l();
                } finally {
                    f1Var2.a.g();
                    l lVar = f1Var2.f2336d;
                    if (a4 == lVar.c) {
                        lVar.a.set(false);
                    }
                }
            } finally {
                f1Var.a.g();
                l lVar2 = f1Var.c;
                if (a3 == lVar2.c) {
                    lVar2.a.set(false);
                }
            }
        } finally {
            r0Var.a.g();
            l lVar3 = r0Var.c;
            if (a2 == lVar3.c) {
                lVar3.a.set(false);
            }
        }
    }

    public u<Boolean> b() {
        f.b.b.f.a.l z = f.b.b.f.a.l.x(m.e.o0(this.a.c(), f2377g, this.f2380e)).z(new i() { // from class: f.b.a.a.a.p0.d
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0026: INVOKE  (r6v9 'z2' f.b.b.f.a.l) = 
                  (wrap: f.b.b.f.a.l : 0x001b: INVOKE  (r6v8 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.u : 0x0017: INVOKE  (r6v7 f.b.b.f.a.u A[REMOVE]) = 
                  (wrap: f.b.a.c.i.h<f.b.a.c.f.b.f> : 0x000f: INVOKE  (r6v6 f.b.a.c.i.h<f.b.a.c.f.b.f> A[REMOVE]) = 
                  (wrap: f.b.a.a.a.c0.q1 : 0x000d: IGET  (r6v5 f.b.a.a.a.c0.q1 A[REMOVE]) = (r0v0 'rVar' f.b.a.a.a.p0.r) f.b.a.a.a.p0.r.a f.b.a.a.a.c0.q1)
                 type: VIRTUAL call: f.b.a.a.a.c0.q1.a():f.b.a.c.i.h)
                  (wrap: l.b.a.d : 0x0013: SGET  (r1v1 l.b.a.d A[REMOVE]) =  f.b.a.a.a.p0.r.h l.b.a.d)
                  (wrap: java.util.concurrent.ScheduledExecutorService : 0x0015: IGET  (r2v0 java.util.concurrent.ScheduledExecutorService A[REMOVE]) = (r0v0 'rVar' f.b.a.a.a.p0.r) f.b.a.a.a.p0.r.e java.util.concurrent.ScheduledExecutorService)
                 type: STATIC call: e.b.a.m.e.o0(f.b.a.c.i.h, l.b.a.d, java.util.concurrent.ScheduledExecutorService):f.b.b.f.a.u)
                 type: STATIC call: f.b.b.f.a.l.x(f.b.b.f.a.u):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.p0.a : 0x0021: CONSTRUCTOR  (r1v2 f.b.a.a.a.p0.a A[REMOVE]) = (r0v0 'rVar' f.b.a.a.a.p0.r) call: f.b.a.a.a.p0.a.<init>(f.b.a.a.a.p0.r):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x0024: IGET  (r2v1 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'rVar' f.b.a.a.a.p0.r) f.b.a.a.a.p0.r.d java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l in method: f.b.a.a.a.p0.d.a(java.lang.Object):f.b.b.f.a.u, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.p0.a, state: NOT_LOADED
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
                	... 14 more
                */
            @Override // f.b.b.f.a.i
            public final f.b.b.f.a.u a(java.lang.Object r6) {
                /*
                    r5 = this;
                    f.b.a.a.a.p0.r r0 = f.b.a.a.a.p0.r.this
                    java.lang.Boolean r6 = (java.lang.Boolean) r6
                    r0.a()
                    boolean r6 = r6.booleanValue()
                    if (r6 == 0) goto L_0x0047
                    f.b.a.a.a.c0.q1 r6 = r0.a
                    f.b.a.c.i.h r6 = r6.a()
                    l.b.a.d r1 = f.b.a.a.a.p0.r.f2378h
                    java.util.concurrent.ScheduledExecutorService r2 = r0.f2380e
                    f.b.b.f.a.u r6 = e.b.a.m.e.o0(r6, r1, r2)
                    f.b.b.f.a.l r6 = f.b.b.f.a.l.x(r6)
                    f.b.a.a.a.p0.a r1 = new f.b.a.a.a.p0.a
                    r1.<init>(r0)
                    java.util.concurrent.ExecutorService r2 = r0.f2379d
                    f.b.b.f.a.l r6 = r6.z(r1, r2)
                    java.lang.Class<java.lang.Exception> r1 = java.lang.Exception.class
                    f.b.a.a.a.p0.b r2 = f.b.a.a.a.p0.b.a
                    java.util.concurrent.ExecutorService r3 = r0.f2379d
                    f.b.b.f.a.a$a r4 = new f.b.b.f.a.a$a
                    r4.<init>(r6, r1, r2)
                    java.util.concurrent.Executor r1 = f.b.a.c.b.o.b.k1(r3, r4)
                    f.b.b.f.a.l$a r6 = (f.b.b.f.a.l.a) r6
                    r6.a(r4, r1)
                    f.b.a.a.a.p0.i r6 = f.b.a.a.a.p0.i.a
                    java.util.concurrent.ExecutorService r0 = r0.f2379d
                    f.b.b.f.a.l r6 = r4.y(r6, r0)
                    goto L_0x0053
                L_0x0047:
                    f.b.b.f.a.l r6 = r0.c()
                    f.b.a.a.a.p0.h r1 = f.b.a.a.a.p0.h.a
                    java.util.concurrent.ExecutorService r0 = r0.f2379d
                    f.b.b.f.a.l r6 = r6.y(r1, r0)
                L_0x0053:
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.p0.d.a(java.lang.Object):f.b.b.f.a.u");
            }
        }, this.f2379d);
        f fVar = new i() { // from class: f.b.a.a.a.p0.f
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0028: RETURN  
                  (wrap: f.b.b.f.a.b : 0x0024: INVOKE  (r4v3 f.b.b.f.a.b A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l<java.lang.Void> : 0x0019: INVOKE  (r1v1 f.b.b.f.a.l<java.lang.Void> A[REMOVE]) = (r0v0 'rVar' f.b.a.a.a.p0.r) type: VIRTUAL call: f.b.a.a.a.p0.r.c():f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.p0.e : 0x001f: CONSTRUCTOR  (r2v0 f.b.a.a.a.p0.e A[REMOVE]) = (r4v1 'exc' java.lang.Exception) call: f.b.a.a.a.p0.e.<init>(java.lang.Exception):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x0022: IGET  (r4v2 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'rVar' f.b.a.a.a.p0.r) f.b.a.a.a.p0.r.d java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                 in method: f.b.a.a.a.p0.f.a(java.lang.Object):f.b.b.f.a.u, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.p0.e, state: NOT_LOADED
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
                	... 14 more
                */
            @Override // f.b.b.f.a.i
            public final f.b.b.f.a.u a(java.lang.Object r4) {
                /*
                    r3 = this;
                    f.b.a.a.a.p0.r r0 = f.b.a.a.a.p0.r.this
                    java.lang.Exception r4 = (java.lang.Exception) r4
                    java.util.Objects.requireNonNull(r0)
                    boolean r1 = r4 instanceof f.b.a.a.a.p0.r.b
                    if (r1 == 0) goto L_0x0016
                    f.b.a.a.a.p0.r$a r0 = new f.b.a.a.a.p0.r$a
                    r0.<init>(r4)
                    f.b.b.f.a.s$a r4 = new f.b.b.f.a.s$a
                    r4.<init>(r0)
                    goto L_0x0028
                L_0x0016:
                    r0.a()
                    f.b.b.f.a.l r1 = r0.c()
                    f.b.a.a.a.p0.e r2 = new f.b.a.a.a.p0.e
                    r2.<init>(r4)
                    java.util.concurrent.ExecutorService r4 = r0.f2379d
                    f.b.b.f.a.l r4 = r1.z(r2, r4)
                L_0x0028:
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.p0.f.a(java.lang.Object):f.b.b.f.a.u");
            }
        };
        ExecutorService executorService = this.f2379d;
        a.C0110a aVar = new a.C0110a(z, Exception.class, fVar);
        ((l.a) z).a(aVar, f.b.a.c.b.o.b.k1(executorService, aVar));
        return aVar;
    }

    public final f.b.b.f.a.l<Void> c() {
        f.b.b.f.a.l z = f.b.b.f.a.l.x(m.e.o0(this.a.b(), q1.f2205d, this.f2380e)).z(new i() { // from class: f.b.a.a.a.p0.j
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0102: RETURN  
                  (wrap: f.b.b.f.a.l : 0x00fe: INVOKE  (r9v6 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x00f3: INVOKE  (r9v5 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x00ef: INVOKE  (r9v4 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x00e4: INVOKE  (r1v16 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x00d9: INVOKE  (r1v15 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x00ce: INVOKE  (r1v14 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x00c3: INVOKE  (r1v13 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x00b8: INVOKE  (r1v12 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x00ad: INVOKE  (r1v11 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x00a2: INVOKE  (r1v10 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x0097: INVOKE  (r1v9 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.u : 0x0093: INVOKE  (r1v8 f.b.b.f.a.u A[REMOVE]) = 
                  (wrap: e.v.g : 0x008b: IGET  (r2v0 e.v.g A[REMOVE]) = (r1v6 'dVar2' f.b.a.a.a.n0.d) f.b.a.a.a.n0.d.a e.v.g)
                  true
                  (wrap: f.b.a.a.a.n0.e : 0x008f: CONSTRUCTOR  (r3v0 f.b.a.a.a.n0.e A[REMOVE]) = (r1v6 'dVar2' f.b.a.a.a.n0.d) call: f.b.a.a.a.n0.e.<init>(f.b.a.a.a.n0.d):void type: CONSTRUCTOR)
                 type: STATIC call: e.v.n.d.a(e.v.g, boolean, java.util.concurrent.Callable):f.b.b.f.a.u)
                 type: STATIC call: f.b.b.f.a.l.x(f.b.b.f.a.u):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.t.c : 0x009d: CONSTRUCTOR  (r2v1 f.b.a.a.a.t.c A[REMOVE]) = (r9v2 'a0Var' f.b.a.a.a.t.a0) call: f.b.a.a.a.t.c.<init>(f.b.a.a.a.t.a0):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x00a0: IGET  (r3v1 java.util.concurrent.ExecutorService A[REMOVE]) = (r9v2 'a0Var' f.b.a.a.a.t.a0) f.b.a.a.a.t.a0.o java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.t.d : 0x00a8: CONSTRUCTOR  (r2v2 f.b.a.a.a.t.d A[REMOVE]) = (r9v2 'a0Var' f.b.a.a.a.t.a0) call: f.b.a.a.a.t.d.<init>(f.b.a.a.a.t.a0):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x00ab: IGET  (r3v2 java.util.concurrent.ExecutorService A[REMOVE]) = (r9v2 'a0Var' f.b.a.a.a.t.a0) f.b.a.a.a.t.a0.o java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.t.b : 0x00b3: CONSTRUCTOR  (r2v3 f.b.a.a.a.t.b A[REMOVE]) = (r9v2 'a0Var' f.b.a.a.a.t.a0) call: f.b.a.a.a.t.b.<init>(f.b.a.a.a.t.a0):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x00b6: IGET  (r3v3 java.util.concurrent.ExecutorService A[REMOVE]) = (r9v2 'a0Var' f.b.a.a.a.t.a0) f.b.a.a.a.t.a0.o java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.t.a : 0x00be: CONSTRUCTOR  (r2v4 f.b.a.a.a.t.a A[REMOVE]) = (r9v2 'a0Var' f.b.a.a.a.t.a0) call: f.b.a.a.a.t.a.<init>(f.b.a.a.a.t.a0):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x00c1: IGET  (r3v4 java.util.concurrent.ExecutorService A[REMOVE]) = (r9v2 'a0Var' f.b.a.a.a.t.a0) f.b.a.a.a.t.a0.o java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.t.i : 0x00c9: CONSTRUCTOR  (r2v5 f.b.a.a.a.t.i A[REMOVE]) = (r9v2 'a0Var' f.b.a.a.a.t.a0) call: f.b.a.a.a.t.i.<init>(f.b.a.a.a.t.a0):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x00cc: IGET  (r3v5 java.util.concurrent.ExecutorService A[REMOVE]) = (r9v2 'a0Var' f.b.a.a.a.t.a0) f.b.a.a.a.t.a0.o java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.t.g : 0x00d4: CONSTRUCTOR  (r2v6 f.b.a.a.a.t.g A[REMOVE]) = (r9v2 'a0Var' f.b.a.a.a.t.a0) call: f.b.a.a.a.t.g.<init>(f.b.a.a.a.t.a0):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x00d7: IGET  (r3v6 java.util.concurrent.ExecutorService A[REMOVE]) = (r9v2 'a0Var' f.b.a.a.a.t.a0) f.b.a.a.a.t.a0.o java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.t.h : 0x00df: CONSTRUCTOR  (r2v7 f.b.a.a.a.t.h A[REMOVE]) = (r9v2 'a0Var' f.b.a.a.a.t.a0) call: f.b.a.a.a.t.h.<init>(f.b.a.a.a.t.a0):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x00e2: IGET  (r3v7 java.util.concurrent.ExecutorService A[REMOVE]) = (r9v2 'a0Var' f.b.a.a.a.t.a0) f.b.a.a.a.t.a0.o java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.t.e : 0x00ea: CONSTRUCTOR  (r2v8 f.b.a.a.a.t.e A[REMOVE]) = (r9v2 'a0Var' f.b.a.a.a.t.a0) call: f.b.a.a.a.t.e.<init>(f.b.a.a.a.t.a0):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x00ed: IGET  (r9v3 java.util.concurrent.ExecutorService A[REMOVE]) = (r9v2 'a0Var' f.b.a.a.a.t.a0) f.b.a.a.a.t.a0.o java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                 type: STATIC call: f.b.b.f.a.l.x(f.b.b.f.a.u):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.p0.g : 0x00f9: CONSTRUCTOR  (r1v17 f.b.a.a.a.p0.g A[REMOVE]) = (r0v0 'rVar' f.b.a.a.a.p0.r) call: f.b.a.a.a.p0.g.<init>(f.b.a.a.a.p0.r):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x00fc: IGET  (r0v1 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'rVar' f.b.a.a.a.p0.r) f.b.a.a.a.p0.r.d java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                 in method: f.b.a.a.a.p0.j.a(java.lang.Object):f.b.b.f.a.u, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.t.c, state: NOT_LOADED
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
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:768)
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
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:768)
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
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:768)
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
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:768)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:328)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                	... 14 more
                */
            @Override // f.b.b.f.a.i
            public final f.b.b.f.a.u a(java.lang.Object r9) {
                /*
                    r8 = this;
                    f.b.a.a.a.p0.r r0 = f.b.a.a.a.p0.r.this
                    java.util.Set r9 = (java.util.Set) r9
                    java.util.Objects.requireNonNull(r0)
                    f.b.a.c.f.b.d r1 = f.b.a.c.f.b.d.EN_NOT_SUPPORT
                    boolean r1 = r9.contains(r1)
                    if (r1 != 0) goto L_0x001c
                    f.b.a.c.f.b.d r1 = f.b.a.c.f.b.d.NOT_IN_ALLOWLIST
                    boolean r9 = r9.contains(r1)
                    if (r9 == 0) goto L_0x0018
                    goto L_0x001c
                L_0x0018:
                    f.b.b.f.a.u<?> r9 = f.b.b.f.a.s.c
                    goto L_0x0102
                L_0x001c:
                    f.b.a.a.a.t.a0 r9 = r0.c
                    f.b.a.a.a.c0.o1 r1 = r9.f2388j
                    boolean r1 = r1.e()
                    if (r1 == 0) goto L_0x0085
                    f.b.a.a.a.c0.o1 r1 = r9.f2388j
                    f.b.a.a.a.n0.a1 r2 = r1.a
                    f.b.a.a.a.j0.d r2 = r2.b()
                    boolean r3 = r1.f(r2)
                    r4 = 0
                    if (r3 == 0) goto L_0x005a
                    boolean r3 = r1.d(r2)
                    if (r3 != 0) goto L_0x003d
                    goto L_0x005a
                L_0x003d:
                    l.b.a.d r2 = r1.b(r2)
                    l.b.a.d r1 = r1.c()
                    long r6 = r1.s()
                    long r1 = r2.s()
                    long r6 = r6 - r1
                    r1 = 1
                    long r6 = r6 + r1
                    long r1 = java.lang.Math.max(r6, r4)
                    l.b.a.d r1 = l.b.a.d.f(r1)
                    goto L_0x005e
                L_0x005a:
                    l.b.a.d r1 = l.b.a.d.f(r4)
                L_0x005e:
                    e.c0.w r2 = r9.f2389k
                    e.c0.p$a r3 = new e.c0.p$a
                    java.lang.Class<com.google.android.apps.exposurenotification.nearby.ExposureInfoCleanupWorker> r4 = com.google.android.apps.exposurenotification.nearby.ExposureInfoCleanupWorker.class
                    r3.<init>(r4)
                    java.util.Set<java.lang.String> r4 = r3.f1261d
                    java.lang.String r5 = "EXPOSURE_INFO_CLEANUP_WORKER_TAG"
                    r4.add(r5)
                    long r4 = r1.b
                    java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS
                    e.c0.x$a r1 = r3.e(r4, r1)
                    e.c0.p$a r1 = (e.c0.p.a) r1
                    e.c0.x r1 = r1.a()
                    e.c0.p r1 = (e.c0.p) r1
                    e.c0.h r3 = e.c0.h.KEEP
                    java.lang.String r4 = "ExposureInfoCleanupWorker"
                    r2.f(r4, r3, r1)
                L_0x0085:
                    f.b.a.a.a.n0.h r1 = r9.b
                    f.b.a.a.a.n0.c r1 = r1.a
                    f.b.a.a.a.n0.d r1 = (f.b.a.a.a.n0.d) r1
                    e.v.g r2 = r1.a
                    f.b.a.a.a.n0.e r3 = new f.b.a.a.a.n0.e
                    r3.<init>(r1)
                    r1 = 1
                    f.b.b.f.a.u r1 = e.v.n.d.a(r2, r1, r3)
                    f.b.b.f.a.l r1 = f.b.b.f.a.l.x(r1)
                    f.b.a.a.a.t.c r2 = new f.b.a.a.a.t.c
                    r2.<init>(r9)
                    java.util.concurrent.ExecutorService r3 = r9.o
                    f.b.b.f.a.l r1 = r1.z(r2, r3)
                    f.b.a.a.a.t.d r2 = new f.b.a.a.a.t.d
                    r2.<init>(r9)
                    java.util.concurrent.ExecutorService r3 = r9.o
                    f.b.b.f.a.l r1 = r1.z(r2, r3)
                    f.b.a.a.a.t.b r2 = new f.b.a.a.a.t.b
                    r2.<init>(r9)
                    java.util.concurrent.ExecutorService r3 = r9.o
                    f.b.b.f.a.l r1 = r1.z(r2, r3)
                    f.b.a.a.a.t.a r2 = new f.b.a.a.a.t.a
                    r2.<init>(r9)
                    java.util.concurrent.ExecutorService r3 = r9.o
                    f.b.b.f.a.l r1 = r1.z(r2, r3)
                    f.b.a.a.a.t.i r2 = new f.b.a.a.a.t.i
                    r2.<init>(r9)
                    java.util.concurrent.ExecutorService r3 = r9.o
                    f.b.b.f.a.l r1 = r1.z(r2, r3)
                    f.b.a.a.a.t.g r2 = new f.b.a.a.a.t.g
                    r2.<init>(r9)
                    java.util.concurrent.ExecutorService r3 = r9.o
                    f.b.b.f.a.l r1 = r1.z(r2, r3)
                    f.b.a.a.a.t.h r2 = new f.b.a.a.a.t.h
                    r2.<init>(r9)
                    java.util.concurrent.ExecutorService r3 = r9.o
                    f.b.b.f.a.l r1 = r1.z(r2, r3)
                    f.b.a.a.a.t.e r2 = new f.b.a.a.a.t.e
                    r2.<init>(r9)
                    java.util.concurrent.ExecutorService r9 = r9.o
                    f.b.b.f.a.l r9 = r1.z(r2, r9)
                    f.b.b.f.a.l r9 = f.b.b.f.a.l.x(r9)
                    f.b.a.a.a.p0.g r1 = new f.b.a.a.a.p0.g
                    r1.<init>(r0)
                    java.util.concurrent.ExecutorService r0 = r0.f2379d
                    f.b.b.f.a.l r9 = r9.z(r1, r0)
                L_0x0102:
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.p0.j.a(java.lang.Object):f.b.b.f.a.u");
            }
        }, this.f2379d);
        c cVar = c.a;
        ExecutorService executorService = this.f2379d;
        a.C0110a aVar = new a.C0110a(z, Exception.class, cVar);
        ((l.a) z).a(aVar, f.b.a.c.b.o.b.k1(executorService, aVar));
        return aVar;
    }
}
