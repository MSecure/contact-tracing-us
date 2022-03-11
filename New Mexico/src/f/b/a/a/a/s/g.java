package f.b.a.a.a.s;

import e.b.a.m;
import f.b.a.f.a.a.b;
import f.b.b.f.a.l;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import l.b.a.d;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: d */
    public static final d f2381d = d.n(30);
    public final b a;
    public final ExecutorService b;
    public final ScheduledExecutorService c;

    /* loaded from: classes.dex */
    public static class a extends Exception {
        public a(Throwable th) {
            super(th);
        }
    }

    public g(b bVar, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.a = bVar;
        this.b = executorService;
        this.c = scheduledExecutorService;
    }

    public l<f.b.a.f.a.a.a> a() {
        return l.x(m.e.n0(new e.g.a.d() { // from class: f.b.a.a.a.s.e
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0016: INVOKE  
                  (wrap: f.b.a.f.a.h.m<f.b.a.f.a.a.a> : 0x000f: IGET  (r5v1 f.b.a.f.a.h.m<f.b.a.f.a.a.a> A[REMOVE]) = (r1v1 'a2' f.b.a.f.a.h.r<f.b.a.f.a.a.a>) f.b.a.f.a.h.r.b f.b.a.f.a.h.m)
                  (wrap: f.b.a.f.a.h.g : 0x0013: CONSTRUCTOR  (r3v0 f.b.a.f.a.h.g A[REMOVE]) = 
                  (wrap: java.util.concurrent.ExecutorService : 0x0008: IGET  (r0v1 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'gVar' f.b.a.a.a.s.g) f.b.a.a.a.s.g.b java.util.concurrent.ExecutorService)
                  (wrap: f.b.a.a.a.s.c : 0x000c: CONSTRUCTOR  (r2v0 f.b.a.a.a.s.c A[REMOVE]) = (r5v0 'bVar' e.g.a.b) call: f.b.a.a.a.s.c.<init>(e.g.a.b):void type: CONSTRUCTOR)
                 call: f.b.a.f.a.h.g.<init>(java.util.concurrent.Executor, f.b.a.f.a.h.a):void type: CONSTRUCTOR)
                 type: VIRTUAL call: f.b.a.f.a.h.m.a(f.b.a.f.a.h.l):void in method: f.b.a.a.a.s.e.a(e.g.a.b):java.lang.Object, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.s.c, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:709)
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
            @Override // e.g.a.d
            public final java.lang.Object a(e.g.a.b r5) {
                /*
                    r4 = this;
                    f.b.a.a.a.s.g r0 = f.b.a.a.a.s.g.this
                    f.b.a.f.a.a.b r1 = r0.a
                    f.b.a.f.a.h.r r1 = r1.a()
                    java.util.concurrent.ExecutorService r0 = r0.b
                    f.b.a.a.a.s.c r2 = new f.b.a.a.a.s.c
                    r2.<init>(r5)
                    f.b.a.f.a.h.m<ResultT> r5 = r1.b
                    f.b.a.f.a.h.g r3 = new f.b.a.f.a.h.g
                    r3.<init>(r0, r2)
                    r5.a(r3)
                    r1.h()
                    java.lang.String r5 = "PlayCoreTask"
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.s.e.a(e.g.a.b):java.lang.Object");
            }
        })).A(f2381d.u(), TimeUnit.MILLISECONDS, this.c);
    }
}
