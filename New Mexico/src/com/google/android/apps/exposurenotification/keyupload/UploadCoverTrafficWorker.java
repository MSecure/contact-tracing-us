package com.google.android.apps.exposurenotification.keyupload;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker;
import e.c0.f;
import e.c0.w;
import f.b.a.a.a.d0.d;
import f.b.a.a.a.p0.r;
import f.b.a.a.a.t.j0;
import f.b.a.a.a.t.m0;
import f.b.a.a.a.z.a0;
import f.b.a.a.a.z.e0;
import f.b.a.a.a.z.f0;
import f.b.a.a.a.z.o;
import f.b.a.a.a.z.s;
import f.b.a.a.a.z.v;
import f.b.b.b.b;
import f.b.b.b.c;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import f.b.b.f.a.x;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import l.b.a.d;
/* loaded from: classes.dex */
public final class UploadCoverTrafficWorker extends ListenableWorker {
    public static final f.b.a.a.a.t.p0.a n = f.b.a.a.a.t.p0.a.e("UploadCoverTrafficWrk");
    public static final TimeUnit o = TimeUnit.HOURS;
    public static final d p = d.i(10000);
    public static final d q = d.h(25);
    public static final d r = d.h(24);

    /* renamed from: g */
    public final f0 f361g;

    /* renamed from: h */
    public final ExecutorService f362h;

    /* renamed from: i */
    public final ExecutorService f363i;

    /* renamed from: j */
    public final x f364j;

    /* renamed from: k */
    public final SecureRandom f365k;

    /* renamed from: l */
    public final r f366l;
    public final w m;

    /* loaded from: classes.dex */
    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public UploadCoverTrafficWorker(Context context, WorkerParameters workerParameters, f0 f0Var, ExecutorService executorService, ExecutorService executorService2, x xVar, SecureRandom secureRandom, r rVar, w wVar) {
        super(context, workerParameters);
        this.f361g = f0Var;
        this.f362h = executorService;
        this.f363i = executorService2;
        this.f364j = xVar;
        this.f365k = secureRandom;
        this.f366l = rVar;
        this.m = wVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        f fVar = this.c.b;
        boolean z = false;
        if (fVar != null) {
            Object obj = fVar.a.get("UploadCoverTrafficWorker.IS_DELAYED_EXECUTION");
            if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
                z = true;
            }
        }
        if (z) {
            l y = l.x(this.f361g.c(g())).z(new i() { // from class: f.b.a.a.a.z.t
                @Override // f.b.b.f.a.i
                public final u a(Object obj2) {
                    UploadCoverTrafficWorker uploadCoverTrafficWorker = UploadCoverTrafficWorker.this;
                    e0 e0Var = (e0) obj2;
                    return uploadCoverTrafficWorker.f361g.d(uploadCoverTrafficWorker.h());
                }
            }, this.f362h).y(v.a, this.f363i);
            f.b.a.a.a.z.u uVar = f.b.a.a.a.z.u.a;
            ExecutorService executorService = this.f363i;
            a.b bVar = new a.b(y, Throwable.class, uVar);
            y.a(bVar, f.b.a.c.b.o.b.k1(executorService, bVar));
            return bVar;
        } else if (!j(0.08333333333333333d)) {
            return f.b.a.c.b.o.b.R0(new ListenableWorker.a.c());
        } else {
            l y2 = l.x(this.f366l.b()).z(new i() { // from class: f.b.a.a.a.z.x
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007f: RETURN  
                      (wrap: f.b.b.f.a.l : 0x007b: INVOKE  (r0v2 f.b.b.f.a.l A[REMOVE]) = 
                      (wrap: f.b.b.f.a.l : 0x0070: INVOKE  (r7v7 f.b.b.f.a.l A[REMOVE]) = 
                      (wrap: f.b.b.f.a.l : 0x0065: INVOKE  (r7v6 f.b.b.f.a.l A[REMOVE]) = 
                      (wrap: f.b.b.f.a.l : 0x005a: INVOKE  (r7v5 f.b.b.f.a.l A[REMOVE]) = (r7v4 'uVar2' f.b.b.f.a.u) type: STATIC call: f.b.b.f.a.l.x(f.b.b.f.a.u):f.b.b.f.a.l)
                      (wrap: f.b.a.a.a.z.p : 0x0060: CONSTRUCTOR  (r1v1 f.b.a.a.a.z.p A[REMOVE]) = (r0v0 'uploadCoverTrafficWorker' com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker) call: f.b.a.a.a.z.p.<init>(com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker):void type: CONSTRUCTOR)
                      (wrap: java.util.concurrent.ExecutorService : 0x0063: IGET  (r2v0 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'uploadCoverTrafficWorker' com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker) com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker.h java.util.concurrent.ExecutorService)
                     type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                      (wrap: f.b.a.a.a.z.q : 0x006b: CONSTRUCTOR  (r1v2 f.b.a.a.a.z.q A[REMOVE]) = (r0v0 'uploadCoverTrafficWorker' com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker) call: f.b.a.a.a.z.q.<init>(com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker):void type: CONSTRUCTOR)
                      (wrap: java.util.concurrent.ExecutorService : 0x006e: IGET  (r2v1 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'uploadCoverTrafficWorker' com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker) com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker.h java.util.concurrent.ExecutorService)
                     type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                      (wrap: f.b.a.a.a.z.z : 0x0076: CONSTRUCTOR  (r1v3 f.b.a.a.a.z.z A[REMOVE]) = (r0v0 'uploadCoverTrafficWorker' com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker) call: f.b.a.a.a.z.z.<init>(com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker):void type: CONSTRUCTOR)
                      (wrap: java.util.concurrent.ExecutorService : 0x0079: IGET  (r0v1 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'uploadCoverTrafficWorker' com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker) com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker.h java.util.concurrent.ExecutorService)
                     type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                     in method: f.b.a.a.a.z.x.a(java.lang.Object):f.b.b.f.a.u, file: classes.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.z.p, state: NOT_LOADED
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
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:328)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 14 more
                    */
                @Override // f.b.b.f.a.i
                public final f.b.b.f.a.u a(java.lang.Object r7) {
                    /*
                        r6 = this;
                        com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker r0 = com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker.this
                        java.lang.Boolean r7 = (java.lang.Boolean) r7
                        java.util.Objects.requireNonNull(r0)
                        boolean r7 = r7.booleanValue()
                        if (r7 != 0) goto L_0x0019
                        com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker$b r7 = new com.google.android.apps.exposurenotification.keyupload.UploadCoverTrafficWorker$b
                        r0 = 0
                        r7.<init>(r0)
                        f.b.b.f.a.s$a r0 = new f.b.b.f.a.s$a
                        r0.<init>(r7)
                        goto L_0x007f
                    L_0x0019:
                        r1 = 4595172819793696085(0x3fc5555555555555, double:0.16666666666666666)
                        boolean r7 = r0.j(r1)
                        if (r7 != 0) goto L_0x0027
                        f.b.b.f.a.u<?> r7 = f.b.b.f.a.s.c
                        goto L_0x005a
                    L_0x0027:
                        f.b.a.a.a.z.f0 r7 = r0.f361g
                        java.security.SecureRandom r1 = r0.f365k
                        f.b.b.c.a r2 = f.b.a.a.a.t.j0.a
                        r2 = 256(0x100, float:3.59E-43)
                        byte[] r2 = new byte[r2]
                        r1.nextBytes(r2)
                        f.b.b.c.a r1 = f.b.a.a.a.t.j0.a
                        java.lang.String r1 = r1.c(r2)
                        l.b.a.f r2 = l.b.a.f.f4612e
                        l.b.a.a r2 = l.b.a.a.b()
                        l.b.a.f r2 = l.b.a.f.O(r2)
                        r3 = 0
                        java.lang.String r5 = "FAKE-PHONE-NUMBER"
                        f.b.a.a.a.z.i0$a r1 = f.b.a.a.a.z.i0.d(r5, r1, r2, r3)
                        f.b.a.a.a.z.b0$b r1 = (f.b.a.a.a.z.b0.b) r1
                        java.lang.Boolean r2 = java.lang.Boolean.TRUE
                        r1.f2535g = r2
                        f.b.a.a.a.z.i0 r1 = r1.a()
                        f.b.b.f.a.u r7 = r7.a(r1)
                    L_0x005a:
                        f.b.b.f.a.l r7 = f.b.b.f.a.l.x(r7)
                        f.b.a.a.a.z.p r1 = new f.b.a.a.a.z.p
                        r1.<init>(r0)
                        java.util.concurrent.ExecutorService r2 = r0.f362h
                        f.b.b.f.a.l r7 = r7.z(r1, r2)
                        f.b.a.a.a.z.q r1 = new f.b.a.a.a.z.q
                        r1.<init>(r0)
                        java.util.concurrent.ExecutorService r2 = r0.f362h
                        f.b.b.f.a.l r7 = r7.z(r1, r2)
                        f.b.a.a.a.z.z r1 = new f.b.a.a.a.z.z
                        r1.<init>(r0)
                        java.util.concurrent.ExecutorService r0 = r0.f362h
                        f.b.b.f.a.l r0 = r7.z(r1, r0)
                    L_0x007f:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.z.x.a(java.lang.Object):f.b.b.f.a.u");
                }
            }, this.f363i).y(o.a, this.f363i);
            s sVar = s.a;
            ExecutorService executorService2 = this.f363i;
            a.b bVar2 = new a.b(y2, b.class, sVar);
            y2.a(bVar2, f.b.a.c.b.o.b.k1(executorService2, bVar2));
            f.b.a.a.a.z.w wVar = f.b.a.a.a.z.w.a;
            ExecutorService executorService3 = this.f363i;
            a.b bVar3 = new a.b(bVar2, Throwable.class, wVar);
            bVar2.a(bVar3, f.b.a.c.b.o.b.k1(executorService3, bVar3));
            return bVar3;
        }
    }

    public final e0 g() {
        e0.a i2 = e0.i("FAKE-VALIDATION-CODE", j0.a(this.f365k));
        i2.b(true);
        i2.c(i());
        a0.b bVar = (a0.b) i2;
        bVar.f2519e = m0.c(100);
        return bVar.a();
    }

    public final e0 h() {
        e0.a i2 = e0.i("FAKE-VALIDATION-CODE", j0.a(this.f365k));
        i2.b(true);
        i2.c(i());
        c w = c.w("US", "CA");
        a0.b bVar = (a0.b) i2;
        bVar.f2518d = w == null ? null : c.s(w);
        bVar.f2521g = m0.c(32);
        bVar.f2519e = m0.c(100);
        bVar.f2522h = m0.c(100);
        bVar.f2523i = l.b.a.f.P(2020, 1, 1);
        return bVar.a();
    }

    public final List<f.b.a.a.a.d0.d> i() {
        f.b.b.b.a<Object> aVar = c.c;
        f.b.a.c.b.o.b.z(4, "initialCapacity");
        Object[] objArr = new Object[4];
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (i2 < 14) {
            byte[] bArr = new byte[16];
            this.f365k.nextBytes(bArr);
            d.a f2 = f.b.a.a.a.d0.d.f();
            f2.c(bArr);
            f2.e(i2 % 7);
            f2.b(2650847);
            f.b.a.a.a.d0.d a2 = f2.a();
            Objects.requireNonNull(a2);
            int i4 = i3 + 1;
            if (objArr.length < i4) {
                objArr = Arrays.copyOf(objArr, b.AbstractC0105b.b(objArr.length, i4));
            } else if (z) {
                objArr = (Object[]) objArr.clone();
            } else {
                objArr[i3] = a2;
                i2++;
                i3++;
            }
            z = false;
            objArr[i3] = a2;
            i2++;
            i3++;
        }
        return c.p(objArr, i3);
    }

    public final boolean j(double d2) {
        return this.f365k.nextDouble() < d2;
    }
}
