package f.b.a.b.i.s;

import f.b.a.a.a.a0.l;
import f.b.a.b.i.f;
import f.b.a.b.i.i;
import f.b.a.b.i.m;
import f.b.a.b.i.p.e;
import f.b.a.b.i.s.h.r;
import f.b.a.b.i.t.b;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public class c implements e {

    /* renamed from: f */
    public static final Logger f2635f = Logger.getLogger(m.class.getName());
    public final r a;
    public final Executor b;
    public final e c;

    /* renamed from: d */
    public final f.b.a.b.i.s.i.c f2636d;

    /* renamed from: e */
    public final b f2637e;

    public c(Executor executor, e eVar, r rVar, f.b.a.b.i.s.i.c cVar, b bVar) {
        this.b = executor;
        this.c = eVar;
        this.a = rVar;
        this.f2636d = cVar;
        this.f2637e = bVar;
    }

    @Override // f.b.a.b.i.s.e
    public void a(i iVar, f fVar, l lVar) {
        this.b.execute(new Runnable(this, iVar, lVar, fVar) { // from class: f.b.a.b.i.s.a
            public final c b;
            public final i c;

            /* renamed from: d  reason: collision with root package name */
            public final l f2633d;

            /* renamed from: e  reason: collision with root package name */
            public final f f2634e;

            {
                this.b = r1;
                this.c = r2;
                this.f2633d = r3;
                this.f2634e = r4;
            }

            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0041: INVOKE  
                  (wrap: f.b.a.b.i.t.b : 0x003a: IGET  (r4v4 f.b.a.b.i.t.b A[REMOVE]) = (r0v0 'cVar' f.b.a.b.i.s.c) f.b.a.b.i.s.c.e f.b.a.b.i.t.b)
                  (wrap: f.b.a.b.i.s.b : 0x003e: CONSTRUCTOR  (r5v1 f.b.a.b.i.s.b A[REMOVE]) = 
                  (r0v0 'cVar' f.b.a.b.i.s.c)
                  (r1v0 'iVar2' f.b.a.b.i.i)
                  (wrap: f.b.a.b.i.f : 0x0036: INVOKE  (r3v4 f.b.a.b.i.f A[REMOVE]) = (r4v3 'a' f.b.a.b.i.p.m), (r3v0 'fVar2' f.b.a.b.i.f) type: INTERFACE call: f.b.a.b.i.p.m.a(f.b.a.b.i.f):f.b.a.b.i.f)
                 call: f.b.a.b.i.s.b.<init>(f.b.a.b.i.s.c, f.b.a.b.i.i, f.b.a.b.i.f):void type: CONSTRUCTOR)
                 type: INTERFACE call: f.b.a.b.i.t.b.c(f.b.a.b.i.t.b$a):java.lang.Object in method: f.b.a.b.i.s.a.run():void, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.b.i.s.b, state: NOT_LOADED
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
                	... 20 more
                */
            @Override // java.lang.Runnable
            public void run() {
                /*
                    r6 = this;
                    f.b.a.b.i.s.c r0 = r6.b
                    f.b.a.b.i.i r1 = r6.c
                    f.b.a.a.a.a0.l r2 = r6.f2633d
                    f.b.a.b.i.f r3 = r6.f2634e
                    java.util.logging.Logger r4 = f.b.a.b.i.s.c.f2635f
                    f.b.a.b.i.p.e r4 = r0.c     // Catch: Exception -> 0x0049
                    java.lang.String r5 = r1.b()     // Catch: Exception -> 0x0049
                    f.b.a.b.i.p.m r4 = r4.a(r5)     // Catch: Exception -> 0x0049
                    if (r4 != 0) goto L_0x0036
                    java.lang.String r0 = "Transport backend '%s' is not registered"
                    r3 = 1
                    java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: Exception -> 0x0049
                    r4 = 0
                    java.lang.String r1 = r1.b()     // Catch: Exception -> 0x0049
                    r3[r4] = r1     // Catch: Exception -> 0x0049
                    java.lang.String r0 = java.lang.String.format(r0, r3)     // Catch: Exception -> 0x0049
                    java.util.logging.Logger r1 = f.b.a.b.i.s.c.f2635f     // Catch: Exception -> 0x0049
                    r1.warning(r0)     // Catch: Exception -> 0x0049
                    java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch: Exception -> 0x0049
                    r1.<init>(r0)     // Catch: Exception -> 0x0049
                    e.g.a.b r0 = r2.a     // Catch: Exception -> 0x0049
                    r0.d(r1)     // Catch: Exception -> 0x0049
                    goto L_0x0065
                L_0x0036:
                    f.b.a.b.i.f r3 = r4.a(r3)     // Catch: Exception -> 0x0049
                    f.b.a.b.i.t.b r4 = r0.f2637e     // Catch: Exception -> 0x0049
                    f.b.a.b.i.s.b r5 = new f.b.a.b.i.s.b     // Catch: Exception -> 0x0049
                    r5.<init>(r0, r1, r3)     // Catch: Exception -> 0x0049
                    r4.c(r5)     // Catch: Exception -> 0x0049
                    r0 = 0
                    r2.a(r0)     // Catch: Exception -> 0x0049
                    goto L_0x0065
                L_0x0049:
                    r0 = move-exception
                    java.util.logging.Logger r1 = f.b.a.b.i.s.c.f2635f
                    java.lang.String r3 = "Error scheduling event "
                    java.lang.StringBuilder r3 = f.a.a.a.a.h(r3)
                    java.lang.String r4 = r0.getMessage()
                    r3.append(r4)
                    java.lang.String r3 = r3.toString()
                    r1.warning(r3)
                    e.g.a.b r1 = r2.a
                    r1.d(r0)
                L_0x0065:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.b.i.s.a.run():void");
            }
        });
    }
}
