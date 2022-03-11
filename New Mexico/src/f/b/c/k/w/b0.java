package f.b.c.k.w;

import android.content.Context;
import e.b.a.m;
import f.b.a.c.i.c0;
import f.b.a.c.i.e0;
import f.b.a.c.i.h;
import f.b.c.k.s.e;
import f.b.c.k.x.c;
import f.b.c.k.x.j;
import f.b.c.k.x.m;
import h.a.b;
import h.a.k0;
import h.a.n;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class b0 {
    public h<k0> a;
    public final c b;
    public h.a.c c;

    /* renamed from: d */
    public c.b f3646d;

    /* renamed from: e */
    public final Context f3647e;

    /* renamed from: f */
    public final e f3648f;

    /* renamed from: g */
    public final b f3649g;

    public b0(c cVar, Context context, e eVar, b bVar) {
        this.b = cVar;
        this.f3647e = context;
        this.f3648f = eVar;
        this.f3649g = bVar;
        b();
    }

    public final void a() {
        if (this.f3646d != null) {
            m.a(m.a.DEBUG, "GrpcCallProvider", "Clearing the connectivityAttemptTimer", new Object[0]);
            this.f3646d.a();
            this.f3646d = null;
        }
    }

    public final void b() {
        Executor executor = j.c;
        y yVar = new Callable(this) { // from class: f.b.c.k.w.y
            public final b0 a;

            {
                this.a = r1;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0051: INVOKE  
                  (wrap: f.b.c.k.x.c : 0x004a: IGET  (r3v5 f.b.c.k.x.c A[REMOVE]) = (r0v0 'b0Var' f.b.c.k.w.b0) f.b.c.k.w.b0.b f.b.c.k.x.c)
                  (wrap: f.b.c.k.w.z : 0x004e: CONSTRUCTOR  (r5v4 f.b.c.k.w.z A[REMOVE]) = (r0v0 'b0Var' f.b.c.k.w.b0), (r2v1 'bVar' h.a.i1.a$b) call: f.b.c.k.w.z.<init>(f.b.c.k.w.b0, h.a.k0):void type: CONSTRUCTOR)
                 type: VIRTUAL call: f.b.c.k.x.c.b(java.lang.Runnable):void in method: f.b.c.k.w.y.call():java.lang.Object, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.c.k.w.z, state: NOT_LOADED
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
                	... 18 more
                */
            @Override // java.util.concurrent.Callable
            public java.lang.Object call() {
                /*
                    r9 = this;
                    f.b.c.k.w.b0 r0 = r9.a
                    java.lang.String r1 = "GrpcCallProvider"
                    android.content.Context r2 = r0.f3647e
                    f.b.c.k.s.e r3 = r0.f3648f
                    r4 = 0
                    f.b.a.c.g.a.a(r2)     // Catch: f -> 0x0011, g -> 0x000f, IllegalStateException -> 0x000d
                    goto L_0x001e
                L_0x000d:
                    r5 = move-exception
                    goto L_0x0012
                L_0x000f:
                    r5 = move-exception
                    goto L_0x0012
                L_0x0011:
                    r5 = move-exception
                L_0x0012:
                    r6 = 1
                    java.lang.Object[] r6 = new java.lang.Object[r6]
                    r6[r4] = r5
                    f.b.c.k.x.m$a r5 = f.b.c.k.x.m.a.WARN
                    java.lang.String r7 = "Failed to update ssl context: %s"
                    f.b.c.k.x.m.a(r5, r1, r7, r6)
                L_0x001e:
                    java.lang.String r5 = r3.c
                    h.a.m0 r6 = h.a.m0.b
                    if (r6 == 0) goto L_0x0098
                    h.a.l0 r5 = r6.a(r5)
                    boolean r3 = r3.f3537d
                    if (r3 != 0) goto L_0x002f
                    r5.c()
                L_0x002f:
                    r6 = 30
                    java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
                    r5.b(r6, r3)
                    h.a.i1.a r3 = new h.a.i1.a
                    r3.<init>(r5)
                    r3.b = r2
                    h.a.i1.a$b r2 = new h.a.i1.a$b
                    h.a.l0<?> r5 = r3.a
                    h.a.k0 r5 = r5.a()
                    android.content.Context r3 = r3.b
                    r2.<init>(r5, r3)
                    f.b.c.k.x.c r3 = r0.b
                    f.b.c.k.w.z r5 = new f.b.c.k.w.z
                    r5.<init>(r0, r2)
                    r3.b(r5)
                    h.a.c r3 = h.a.c.f4077k
                    h.a.c$a<h.a.m1.c$a> r5 = h.a.m1.c.a
                    h.a.m1.c$a r6 = h.a.m1.c.a.ASYNC
                    h.a.c r3 = r3.e(r5, r6)
                    java.lang.String r5 = "channel"
                    f.b.a.c.b.o.b.A(r2, r5)
                    java.lang.String r6 = "callOptions"
                    f.b.a.c.b.o.b.A(r3, r6)
                    h.a.b r7 = r0.f3649g
                    h.a.c r8 = new h.a.c
                    r8.<init>(r3)
                    r8.f4078d = r7
                    f.b.a.c.b.o.b.A(r2, r5)
                    f.b.a.c.b.o.b.A(r8, r6)
                    f.b.c.k.x.c r3 = r0.b
                    f.b.c.k.x.c$c r3 = r3.a
                    java.util.Objects.requireNonNull(r8)
                    h.a.c r5 = new h.a.c
                    r5.<init>(r8)
                    r5.b = r3
                    f.b.d.a.k$a r3 = new f.b.d.a.k$a
                    r3.<init>(r2, r5)
                    h.a.c r3 = r3.b
                    r0.c = r3
                    java.lang.Object[] r0 = new java.lang.Object[r4]
                    f.b.c.k.x.m$a r3 = f.b.c.k.x.m.a.DEBUG
                    java.lang.String r4 = "Channel successfully reset."
                    f.b.c.k.x.m.a(r3, r1, r4, r0)
                    return r2
                L_0x0098:
                    h.a.m0$c r0 = new h.a.m0$c
                    java.lang.String r1 = "No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact"
                    r0.<init>(r1)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.c.k.w.y.call():java.lang.Object");
            }
        };
        m.e.r(executor, "Executor must not be null");
        m.e.r(yVar, "Callback must not be null");
        c0 c0Var = new c0();
        executor.execute(new e0(c0Var, yVar));
        this.a = c0Var;
    }

    public final void c(k0 k0Var) {
        n j2 = k0Var.j(true);
        m.a aVar = m.a.DEBUG;
        f.b.c.k.x.m.a(aVar, "GrpcCallProvider", "Current gRPC connectivity state: " + j2, new Object[0]);
        a();
        if (j2 == n.CONNECTING) {
            f.b.c.k.x.m.a(aVar, "GrpcCallProvider", "Setting the connectivityAttemptTimer", new Object[0]);
            this.f3646d = this.b.a(c.d.CONNECTIVITY_ATTEMPT_TIMER, 15000, new Runnable(this, k0Var) { // from class: f.b.c.k.w.v
                public final b0 b;
                public final k0 c;

                {
                    this.b = r1;
                    this.c = r2;
                }

                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001a: INVOKE  
                      (wrap: f.b.c.k.x.c : 0x0013: IGET  (r2v2 f.b.c.k.x.c A[REMOVE]) = (r0v0 'b0Var' f.b.c.k.w.b0) f.b.c.k.w.b0.b f.b.c.k.x.c)
                      (wrap: f.b.c.k.w.x : 0x0017: CONSTRUCTOR  (r3v1 f.b.c.k.w.x A[REMOVE]) = (r0v0 'b0Var' f.b.c.k.w.b0), (r1v0 'k0Var2' h.a.k0) call: f.b.c.k.w.x.<init>(f.b.c.k.w.b0, h.a.k0):void type: CONSTRUCTOR)
                     type: VIRTUAL call: f.b.c.k.x.c.b(java.lang.Runnable):void in method: f.b.c.k.w.v.run():void, file: classes.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.c.k.w.x, state: NOT_LOADED
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
                    	... 10 more
                    */
                @Override // java.lang.Runnable
                public void run() {
                    /*
                        r6 = this;
                        f.b.c.k.w.b0 r0 = r6.b
                        h.a.k0 r1 = r6.c
                        r2 = 0
                        java.lang.Object[] r2 = new java.lang.Object[r2]
                        f.b.c.k.x.m$a r3 = f.b.c.k.x.m.a.DEBUG
                        java.lang.String r4 = "GrpcCallProvider"
                        java.lang.String r5 = "connectivityAttemptTimer elapsed. Resetting the channel."
                        f.b.c.k.x.m.a(r3, r4, r5, r2)
                        r0.a()
                        f.b.c.k.x.c r2 = r0.b
                        f.b.c.k.w.x r3 = new f.b.c.k.w.x
                        r3.<init>(r0, r1)
                        r2.b(r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: f.b.c.k.w.v.run():void");
                }
            });
        }
        k0Var.k(j2, new Runnable(this, k0Var) { // from class: f.b.c.k.w.w
            public final b0 b;
            public final k0 c;

            {
                this.b = r1;
                this.c = r2;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  
                  (wrap: f.b.c.k.x.c : 0x0004: IGET  (r2v0 f.b.c.k.x.c A[REMOVE]) = (r0v0 'b0Var' f.b.c.k.w.b0) f.b.c.k.w.b0.b f.b.c.k.x.c)
                  (wrap: f.b.c.k.w.a0 : 0x0008: CONSTRUCTOR  (r3v0 f.b.c.k.w.a0 A[REMOVE]) = 
                  (r0v0 'b0Var' f.b.c.k.w.b0)
                  (wrap: h.a.k0 : 0x0002: IGET  (r1v0 h.a.k0 A[REMOVE]) = (r4v0 'this' f.b.c.k.w.w A[IMMUTABLE_TYPE, THIS]) f.b.c.k.w.w.c h.a.k0)
                 call: f.b.c.k.w.a0.<init>(f.b.c.k.w.b0, h.a.k0):void type: CONSTRUCTOR)
                 type: VIRTUAL call: f.b.c.k.x.c.b(java.lang.Runnable):void in method: f.b.c.k.w.w.run():void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.c.k.w.a0, state: NOT_LOADED
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
                	... 10 more
                */
            @Override // java.lang.Runnable
            public void run() {
                /*
                    r4 = this;
                    f.b.c.k.w.b0 r0 = r4.b
                    h.a.k0 r1 = r4.c
                    f.b.c.k.x.c r2 = r0.b
                    f.b.c.k.w.a0 r3 = new f.b.c.k.w.a0
                    r3.<init>(r0, r1)
                    r2.b(r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.c.k.w.w.run():void");
            }
        });
    }
}
