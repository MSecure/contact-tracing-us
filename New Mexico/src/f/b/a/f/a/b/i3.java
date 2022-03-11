package f.b.a.f.a.b;

import android.os.Handler;
import android.os.Looper;
import f.b.a.f.a.c.d;
import f.b.a.f.a.e.a;
import f.b.a.f.a.e.r;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class i3 {

    /* renamed from: e */
    public static final a f3242e = new a("AssetPackManager");
    public final d0 a;
    public final r<v3> b;
    public final y c;

    /* renamed from: d */
    public final r<Executor> f3243d;

    public i3(d0 d0Var, r<v3> rVar, y yVar, f.b.a.f.a.g.a aVar, s1 s1Var, d1 d1Var, o0 o0Var, r<Executor> rVar2, d dVar, m2 m2Var) {
        new Handler(Looper.getMainLooper());
        this.a = d0Var;
        this.b = rVar;
        this.c = yVar;
        this.f3243d = rVar2;
    }

    public final void a(boolean z) {
        boolean z2;
        y yVar = this.c;
        synchronized (yVar) {
            z2 = yVar.f3369e != null;
        }
        y yVar2 = this.c;
        synchronized (yVar2) {
            yVar2.f3370f = z;
            yVar2.b();
        }
        if (z && !z2) {
            this.f3243d.a().execute(new Runnable() { // from class: f.b.a.f.a.b.h3
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ac: INVOKE  
                      (r1v3 'f2' f.b.a.f.a.h.r<java.util.List<java.lang.String>>)
                      (wrap: java.util.concurrent.Executor : 0x009c: INVOKE  (r2v2 java.util.concurrent.Executor A[REMOVE]) = 
                      (wrap: f.b.a.f.a.e.r<java.util.concurrent.Executor> : 0x009a: IGET  (r2v1 f.b.a.f.a.e.r<java.util.concurrent.Executor> A[REMOVE]) = (r0v0 'i3Var' f.b.a.f.a.b.i3) f.b.a.f.a.b.i3.d f.b.a.f.a.e.r)
                     type: INTERFACE call: f.b.a.f.a.e.r.a():java.lang.Object)
                      (wrap: f.b.a.f.a.b.g3 : 0x00a9: CONSTRUCTOR  (r4v3 f.b.a.f.a.b.g3 A[REMOVE]) = (r3v1 'd0Var2' f.b.a.f.a.b.d0) call: f.b.a.f.a.b.g3.<init>(f.b.a.f.a.b.d0):void type: CONSTRUCTOR)
                     type: VIRTUAL call: f.b.a.f.a.h.r.b(java.util.concurrent.Executor, f.b.a.f.a.h.c):f.b.a.f.a.h.r in method: f.b.a.f.a.b.h3.run():void, file: classes.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.f.a.b.g3, state: NOT_LOADED
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
                public final void run() {
                    /*
                        r13 = this;
                        f.b.a.f.a.b.i3 r0 = f.b.a.f.a.b.i3.this
                        f.b.a.f.a.e.r<f.b.a.f.a.b.v3> r1 = r0.b
                        java.lang.Object r1 = r1.a()
                        f.b.a.f.a.b.v3 r1 = (f.b.a.f.a.b.v3) r1
                        f.b.a.f.a.b.d0 r2 = r0.a
                        java.util.Objects.requireNonNull(r2)
                        java.util.HashMap r3 = new java.util.HashMap
                        r3.<init>()
                        java.util.HashMap r4 = new java.util.HashMap
                        r4.<init>()
                        r5 = 0
                        r6 = 1
                        java.util.List r7 = r2.h()     // Catch: IOException -> 0x006a
                        java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch: IOException -> 0x006a
                        java.util.Iterator r7 = r7.iterator()     // Catch: IOException -> 0x006a
                    L_0x0025:
                        boolean r8 = r7.hasNext()     // Catch: IOException -> 0x006a
                        if (r8 == 0) goto L_0x0076
                        java.lang.Object r8 = r7.next()     // Catch: IOException -> 0x006a
                        java.io.File r8 = (java.io.File) r8     // Catch: IOException -> 0x006a
                        java.lang.String r9 = r8.getName()     // Catch: IOException -> 0x006a
                        java.lang.String r9 = r2.u(r9)     // Catch: IOException -> 0x006a
                        r10 = 0
                        if (r9 != 0) goto L_0x003d
                        goto L_0x0060
                    L_0x003d:
                        java.io.File r11 = new java.io.File     // Catch: IOException -> 0x006a
                        java.lang.String r12 = "assets"
                        r11.<init>(r9, r12)     // Catch: IOException -> 0x006a
                        boolean r12 = r11.isDirectory()     // Catch: IOException -> 0x006a
                        if (r12 != 0) goto L_0x0056
                        f.b.a.f.a.e.a r9 = f.b.a.f.a.b.d0.c     // Catch: IOException -> 0x006a
                        java.lang.Object[] r12 = new java.lang.Object[r6]     // Catch: IOException -> 0x006a
                        r12[r5] = r11     // Catch: IOException -> 0x006a
                        java.lang.String r11 = "Failed to find assets directory: %s"
                        r9.b(r11, r12)     // Catch: IOException -> 0x006a
                        goto L_0x0060
                    L_0x0056:
                        java.lang.String r10 = r11.getCanonicalPath()     // Catch: IOException -> 0x006a
                        f.b.a.f.a.b.h0 r11 = new f.b.a.f.a.b.h0     // Catch: IOException -> 0x006a
                        r11.<init>(r5, r9, r10)     // Catch: IOException -> 0x006a
                        r10 = r11
                    L_0x0060:
                        if (r10 == 0) goto L_0x0025
                        java.lang.String r8 = r8.getName()     // Catch: IOException -> 0x006a
                        r4.put(r8, r10)     // Catch: IOException -> 0x006a
                        goto L_0x0025
                    L_0x006a:
                        r7 = move-exception
                        f.b.a.f.a.e.a r8 = f.b.a.f.a.b.d0.c
                        java.lang.Object[] r6 = new java.lang.Object[r6]
                        r6[r5] = r7
                        java.lang.String r5 = "Could not process directory while scanning installed packs: %s"
                        r8.b(r5, r6)
                    L_0x0076:
                        java.util.Set r4 = r4.keySet()
                        java.util.Iterator r4 = r4.iterator()
                    L_0x007e:
                        boolean r5 = r4.hasNext()
                        if (r5 == 0) goto L_0x0096
                        java.lang.Object r5 = r4.next()
                        java.lang.String r5 = (java.lang.String) r5
                        long r6 = r2.l(r5)
                        java.lang.Long r6 = java.lang.Long.valueOf(r6)
                        r3.put(r5, r6)
                        goto L_0x007e
                    L_0x0096:
                        f.b.a.f.a.h.r r1 = r1.f(r3)
                        f.b.a.f.a.e.r<java.util.concurrent.Executor> r2 = r0.f3243d
                        java.lang.Object r2 = r2.a()
                        java.util.concurrent.Executor r2 = (java.util.concurrent.Executor) r2
                        f.b.a.f.a.b.d0 r3 = r0.a
                        r3.getClass()
                        f.b.a.f.a.b.g3 r4 = new f.b.a.f.a.b.g3
                        r4.<init>(r3)
                        r1.b(r2, r4)
                        f.b.a.f.a.e.r<java.util.concurrent.Executor> r0 = r0.f3243d
                        java.lang.Object r0 = r0.a()
                        java.util.concurrent.Executor r0 = (java.util.concurrent.Executor) r0
                        f.b.a.f.a.b.f3 r2 = f.b.a.f.a.b.f3.a
                        r1.a(r0, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: f.b.a.f.a.b.h3.run():void");
                }
            });
        }
    }
}
