package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker;
import f.b.a.a.a.c0.t;
import f.b.a.a.a.c0.y;
import f.b.a.a.a.c0.z;
import f.b.a.a.a.d0.d;
import f.b.a.a.a.h0.k;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.n0.j0;
import f.b.a.a.a.n0.k0;
import f.b.a.a.a.z.a0;
import f.b.a.a.a.z.e0;
import f.b.a.a.a.z.f0;
import f.b.a.c.b.o.b;
import f.b.b.a.l;
import f.b.b.b.b;
import f.b.b.b.c;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import f.b.g.d0;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public class PreAuthTEKsReceivedWorker extends ListenableWorker {

    /* renamed from: g */
    public final k0 f377g;

    /* renamed from: h */
    public final f0 f378h;

    /* renamed from: i */
    public final ExecutorService f379i;

    /* renamed from: j */
    public final ExecutorService f380j;

    /* renamed from: k */
    public final SecureRandom f381k;

    /* renamed from: l */
    public final f.b.a.a.a.t.q0.a f382l;
    public final a1 m;

    /* loaded from: classes.dex */
    public static class a extends Exception {
    }

    public PreAuthTEKsReceivedWorker(Context context, WorkerParameters workerParameters, a1 a1Var, k0 k0Var, f0 f0Var, ExecutorService executorService, ExecutorService executorService2, SecureRandom secureRandom, f.b.a.a.a.t.q0.a aVar) {
        super(context, workerParameters);
        this.m = a1Var;
        this.f377g = k0Var;
        this.f378h = f0Var;
        this.f379i = executorService;
        this.f380j = executorService2;
        this.f381k = secureRandom;
        this.f382l = aVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        byte[] bArr;
        l lVar;
        Object obj = this.c.b.a.get("PreAuthTEKsReceivedWorker.KEYS_BYTES");
        int i2 = 0;
        if (obj instanceof Byte[]) {
            Byte[] bArr2 = (Byte[]) obj;
            bArr = new byte[bArr2.length];
            for (int i3 = 0; i3 < bArr2.length; i3++) {
                bArr[i3] = bArr2[i3].byteValue();
            }
        } else {
            bArr = null;
        }
        if (bArr == null || bArr.length == 0) {
            return b.R0(new ListenableWorker.a.C0003a());
        }
        try {
            List<k> keysList = f.b.a.a.a.h0.l.parseFrom(bArr).getKeysList();
            b.z(4, "initialCapacity");
            Object[] objArr = new Object[4];
            for (k kVar : keysList) {
                d.a f2 = d.f();
                f2.c(kVar.getKeyData().z());
                f2.b(kVar.getRollingStartIntervalNumber());
                f2.d(kVar.getRollingPeriod());
                f2.e(kVar.getTransmissionRiskLevel());
                d a2 = f2.a();
                int i4 = i2 + 1;
                if (objArr.length < i4) {
                    objArr = Arrays.copyOf(objArr, b.AbstractC0105b.b(objArr.length, i4));
                }
                objArr[i2] = a2;
                i2 = i4;
            }
            lVar = l.c(c.p(objArr, i2));
        } catch (d0 unused) {
            lVar = f.b.b.a.a.b;
        }
        if (!lVar.b()) {
            return f.b.a.c.b.o.b.R0(new ListenableWorker.a.C0003a());
        }
        f.b.b.f.a.l z = f.b.b.f.a.l.x(this.f377g.e()).z(new i((List) lVar.a()) { // from class: f.b.a.a.a.c0.f0
            public final /* synthetic */ List b;

            {
                this.b = r2;
            }

            @Override // f.b.b.f.a.i
            public final u a(Object obj2) {
                PreAuthTEKsReceivedWorker preAuthTEKsReceivedWorker = PreAuthTEKsReceivedWorker.this;
                List list = this.b;
                l lVar2 = (l) obj2;
                Objects.requireNonNull(preAuthTEKsReceivedWorker);
                if (!lVar2.b()) {
                    return new s.a(new PreAuthTEKsReceivedWorker.a());
                }
                j0 j0Var = (j0) lVar2.a();
                a0.b bVar = (a0.b) e0.j(list, j0Var.p(), f.b.a.a.a.t.j0.a(preAuthTEKsReceivedWorker.f381k));
                bVar.f2519e = j0Var.j();
                bVar.f2523i = j0Var.k();
                bVar.f2522h = j0Var.b();
                bVar.d(j0.e.TRAVELED.equals(j0Var.o()));
                return f.b.a.c.b.o.b.R0(bVar.a());
            }
        }, this.f380j).z(new i() { // from class: f.b.a.a.a.c0.v
            @Override // f.b.b.f.a.i
            public final u a(Object obj2) {
                PreAuthTEKsReceivedWorker preAuthTEKsReceivedWorker = PreAuthTEKsReceivedWorker.this;
                e0 e0Var = (e0) obj2;
                Objects.requireNonNull(preAuthTEKsReceivedWorker);
                return TextUtils.isEmpty(e0Var.a()) ? preAuthTEKsReceivedWorker.f378h.c(e0Var) : f.b.a.c.b.o.b.R0(e0Var);
            }
        }, this.f379i).z(new i() { // from class: f.b.a.a.a.c0.x
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0019: RETURN  
                  (wrap: f.b.b.f.a.l : 0x0015: INVOKE  (r4v3 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x000a: INVOKE  (r1v2 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.u<java.lang.String> : 0x0006: INVOKE  (r1v1 f.b.b.f.a.u<java.lang.String> A[REMOVE]) = 
                  (wrap: f.b.a.a.a.n0.k0 : 0x0004: IGET  (r1v0 f.b.a.a.a.n0.k0 A[REMOVE]) = (r0v0 'preAuthTEKsReceivedWorker' com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker) com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker.g f.b.a.a.a.n0.k0)
                 type: VIRTUAL call: f.b.a.a.a.n0.k0.d():f.b.b.f.a.u)
                 type: STATIC call: f.b.b.f.a.l.x(f.b.b.f.a.u):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.c0.a0 : 0x0010: CONSTRUCTOR  (r2v0 f.b.a.a.a.c0.a0 A[REMOVE]) = 
                  (wrap: f.b.a.a.a.z.e0 : 0x0002: CHECK_CAST (r4v1 f.b.a.a.a.z.e0 A[REMOVE]) = (f.b.a.a.a.z.e0) (r4v0 'obj2' java.lang.Object))
                 call: f.b.a.a.a.c0.a0.<init>(f.b.a.a.a.z.e0):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x0013: IGET  (r4v2 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'preAuthTEKsReceivedWorker' com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker) com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker.i java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.y(f.b.b.a.g, java.util.concurrent.Executor):f.b.b.f.a.l)
                 in method: f.b.a.a.a.c0.x.a(java.lang.Object):f.b.b.f.a.u, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.c0.a0, state: NOT_LOADED
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
                	... 10 more
                */
            @Override // f.b.b.f.a.i
            public final f.b.b.f.a.u a(java.lang.Object r4) {
                /*
                    r3 = this;
                    com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker r0 = com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker.this
                    f.b.a.a.a.z.e0 r4 = (f.b.a.a.a.z.e0) r4
                    f.b.a.a.a.n0.k0 r1 = r0.f377g
                    f.b.b.f.a.u r1 = r1.d()
                    f.b.b.f.a.l r1 = f.b.b.f.a.l.x(r1)
                    f.b.a.a.a.c0.a0 r2 = new f.b.a.a.a.c0.a0
                    r2.<init>(r4)
                    java.util.concurrent.ExecutorService r4 = r0.f379i
                    f.b.b.f.a.l r4 = r1.y(r2, r4)
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.c0.x.a(java.lang.Object):f.b.b.f.a.u");
            }
        }, this.f380j);
        f0 f0Var = this.f378h;
        Objects.requireNonNull(f0Var);
        f.b.b.f.a.l y = z.z(new i() { // from class: f.b.a.a.a.c0.i1
            @Override // f.b.b.f.a.i
            public final u a(Object obj2) {
                return f0.this.d((e0) obj2);
            }
        }, this.f379i).z(new i() { // from class: f.b.a.a.a.c0.w
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0038: RETURN  
                  (wrap: f.b.b.f.a.l : 0x0034: INVOKE  (r4v5 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x0029: INVOKE  (r4v4 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.u<f.b.b.a.l<f.b.a.a.a.n0.j0>> : 0x0025: INVOKE  (r4v3 f.b.b.f.a.u<f.b.b.a.l<f.b.a.a.a.n0.j0>> A[REMOVE]) = 
                  (wrap: f.b.a.a.a.n0.k0 : 0x0023: IGET  (r4v2 f.b.a.a.a.n0.k0 A[REMOVE]) = (r0v0 'preAuthTEKsReceivedWorker' com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker) com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker.g f.b.a.a.a.n0.k0)
                 type: VIRTUAL call: f.b.a.a.a.n0.k0.e():f.b.b.f.a.u)
                 type: STATIC call: f.b.b.f.a.l.x(f.b.b.f.a.u):f.b.b.f.a.l)
                  (wrap: f.b.a.a.a.c0.c0 : 0x002f: CONSTRUCTOR  (r2v3 f.b.a.a.a.c0.c0 A[REMOVE]) = 
                  (r0v0 'preAuthTEKsReceivedWorker' com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker)
                  (wrap: f.b.a.a.a.c0.b0 : 0x0020: CONSTRUCTOR  (r1v2 f.b.a.a.a.c0.b0 A[REMOVE]) = (r4v1 'e0Var' f.b.a.a.a.z.e0) call: f.b.a.a.a.c0.b0.<init>(f.b.a.a.a.z.e0):void type: CONSTRUCTOR)
                 call: f.b.a.a.a.c0.c0.<init>(com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker, f.b.b.a.g):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x0032: IGET  (r0v1 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'preAuthTEKsReceivedWorker' com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker) com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker.i java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.y(f.b.b.a.g, java.util.concurrent.Executor):f.b.b.f.a.l)
                 in method: f.b.a.a.a.c0.w.a(java.lang.Object):f.b.b.f.a.u, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.c0.c0, state: NOT_LOADED
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
                	... 10 more
                */
            @Override // f.b.b.f.a.i
            public final f.b.b.f.a.u a(java.lang.Object r4) {
                /*
                    r3 = this;
                    com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker r0 = com.google.android.apps.exposurenotification.nearby.PreAuthTEKsReceivedWorker.this
                    f.b.a.a.a.z.e0 r4 = (f.b.a.a.a.z.e0) r4
                    f.b.a.a.a.n0.a1 r1 = r0.m
                    f.b.a.a.a.t.q0.a r2 = r0.f382l
                    l.b.a.e r2 = r2.c()
                    r1.x(r2)
                    java.lang.String r1 = r4.p()     // Catch: IllegalArgumentException | NullPointerException -> 0x0018
                    f.b.a.a.a.n0.j0$d r1 = f.b.a.a.a.n0.j0.d.a(r1)     // Catch: IllegalArgumentException | NullPointerException -> 0x0018
                    goto L_0x0019
                L_0x0018:
                    r1 = 0
                L_0x0019:
                    f.b.a.a.a.n0.a1 r2 = r0.m
                    r2.v(r1)
                    f.b.a.a.a.c0.b0 r1 = new f.b.a.a.a.c0.b0
                    r1.<init>(r4)
                    f.b.a.a.a.n0.k0 r4 = r0.f377g
                    f.b.b.f.a.u r4 = r4.e()
                    f.b.b.f.a.l r4 = f.b.b.f.a.l.x(r4)
                    f.b.a.a.a.c0.c0 r2 = new f.b.a.a.a.c0.c0
                    r2.<init>(r0, r1)
                    java.util.concurrent.ExecutorService r0 = r0.f379i
                    f.b.b.f.a.l r4 = r4.y(r2, r0)
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.c0.w.a(java.lang.Object):f.b.b.f.a.u");
            }
        }, this.f379i).z(f.b.a.a.a.c0.e0.a, this.f380j).y(t.a, this.f380j);
        f.b.a.a.a.c0.u uVar = f.b.a.a.a.c0.u.a;
        ExecutorService executorService = this.f380j;
        a.b bVar = new a.b(y, a.class, uVar);
        y.a(bVar, f.b.a.c.b.o.b.k1(executorService, bVar));
        y yVar = y.a;
        ExecutorService executorService2 = this.f380j;
        a.b bVar2 = new a.b(bVar, f0.c.class, yVar);
        bVar.a(bVar2, f.b.a.c.b.o.b.k1(executorService2, bVar2));
        f.b.a.a.a.c0.d0 d0Var = f.b.a.a.a.c0.d0.a;
        ExecutorService executorService3 = this.f380j;
        a.b bVar3 = new a.b(bVar2, f0.d.class, d0Var);
        bVar2.a(bVar3, f.b.a.c.b.o.b.k1(executorService3, bVar3));
        z zVar = z.a;
        ExecutorService executorService4 = this.f380j;
        a.b bVar4 = new a.b(bVar3, Exception.class, zVar);
        bVar3.a(bVar4, f.b.a.c.b.o.b.k1(executorService4, bVar4));
        return bVar4;
    }
}
