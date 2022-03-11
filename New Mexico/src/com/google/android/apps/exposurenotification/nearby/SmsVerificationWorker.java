package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker;
import e.b.a.m;
import f.b.a.a.a.c0.b1;
import f.b.a.a.a.c0.q1;
import f.b.a.a.a.c0.r0;
import f.b.a.a.a.c0.s0;
import f.b.a.a.a.c0.u0;
import f.b.a.a.a.c0.x0;
import f.b.a.a.a.c0.z0;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.n0.k0;
import f.b.a.a.a.p0.r;
import f.b.a.a.a.t.g0;
import f.b.a.a.a.t.h0;
import f.b.a.a.a.z.f0;
import f.b.a.c.b.l.b;
import f.b.b.a.g;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import f.b.b.f.a.x;
import gov.nm.covid19.exposurenotifications.R;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public class SmsVerificationWorker extends ListenableWorker {
    public static final l.b.a.d r = l.b.a.d.n(10);

    /* renamed from: g */
    public final q1 f389g;

    /* renamed from: h */
    public final k0 f390h;

    /* renamed from: i */
    public final f0 f391i;

    /* renamed from: j */
    public final h0 f392j;

    /* renamed from: k */
    public final ExecutorService f393k;

    /* renamed from: l */
    public final ExecutorService f394l;
    public final x m;
    public final SecureRandom n;
    public final r o;
    public final f.b.a.a.a.t.q0.a p;
    public final a1 q;

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

    /* loaded from: classes.dex */
    public static class d extends Exception {
        public d() {
        }

        public d(a aVar) {
        }
    }

    public SmsVerificationWorker(Context context, WorkerParameters workerParameters, q1 q1Var, a1 a1Var, k0 k0Var, f0 f0Var, h0 h0Var, ExecutorService executorService, ExecutorService executorService2, x xVar, SecureRandom secureRandom, r rVar, f.b.a.a.a.t.q0.a aVar) {
        super(context, workerParameters);
        this.f389g = q1Var;
        this.q = a1Var;
        this.f390h = k0Var;
        this.f391i = f0Var;
        this.f392j = h0Var;
        this.f393k = executorService;
        this.f394l = executorService2;
        this.m = xVar;
        this.n = secureRandom;
        this.o = rVar;
        this.p = aVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        ListenableWorker.a.c cVar;
        Object obj = this.c.b.a.get("SmsReceivedWorker.DEEP_LINK_URI_STRING");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            cVar = new ListenableWorker.a.c();
        } else {
            Uri parse = Uri.parse(str);
            if (parse == null || Uri.EMPTY.equals(parse)) {
                cVar = new ListenableWorker.a.c();
            } else if (!m.e.S0(this.b)) {
                cVar = new ListenableWorker.a.c();
            } else {
                l y = l.x(this.o.b()).z(new i() { // from class: f.b.a.a.a.c0.c1
                    @Override // f.b.b.f.a.i
                    public final u a(Object obj2) {
                        SmsVerificationWorker smsVerificationWorker = SmsVerificationWorker.this;
                        Objects.requireNonNull(smsVerificationWorker);
                        if (!((Boolean) obj2).booleanValue()) {
                            return new s.a(new SmsVerificationWorker.b(null));
                        }
                        l x = l.x(m.e.o0(smsVerificationWorker.f389g.a.a(), SmsVerificationWorker.r, smsVerificationWorker.m));
                        t0 t0Var = t0.a;
                        ExecutorService executorService = smsVerificationWorker.f394l;
                        a.C0110a aVar = new a.C0110a(x, b.class, t0Var);
                        x.a(aVar, f.b.a.c.b.o.b.k1(executorService, aVar));
                        return aVar;
                    }
                }, this.f394l).z(new i(g0.c(parse)) { // from class: f.b.a.a.a.c0.v0
                    public final /* synthetic */ f.b.b.a.l b;

                    {
                        this.b = r2;
                    }

                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0044: INVOKE  (r6v7 'y2' f.b.b.f.a.l) = 
                          (wrap: f.b.b.f.a.l : 0x003c: INVOKE  (r6v6 f.b.b.f.a.l A[REMOVE]) = 
                          (wrap: f.b.b.f.a.l : 0x0031: INVOKE  (r1v4 f.b.b.f.a.l A[REMOVE]) = 
                          (wrap: f.b.b.f.a.l : 0x0026: INVOKE  (r1v3 f.b.b.f.a.l A[REMOVE]) = 
                          (wrap: f.b.b.f.a.u<java.util.List<f.b.a.a.a.n0.j0>> : 0x0022: INVOKE  (r1v2 f.b.b.f.a.u<java.util.List<f.b.a.a.a.n0.j0>> A[REMOVE]) = 
                          (wrap: f.b.a.a.a.n0.k0 : 0x0020: IGET  (r1v1 f.b.a.a.a.n0.k0 A[REMOVE]) = (r0v0 'smsVerificationWorker' com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker) com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker.h f.b.a.a.a.n0.k0)
                          (r6v4 'str2' java.lang.String)
                         type: VIRTUAL call: f.b.a.a.a.n0.k0.c(java.lang.String):f.b.b.f.a.u)
                         type: STATIC call: f.b.b.f.a.l.x(f.b.b.f.a.u):f.b.b.f.a.l)
                          (wrap: f.b.a.a.a.c0.w0 : 0x002c: CONSTRUCTOR  (r2v0 f.b.a.a.a.c0.w0 A[REMOVE]) = 
                          (r0v0 'smsVerificationWorker' com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker)
                          (r6v4 'str2' java.lang.String)
                         call: f.b.a.a.a.c0.w0.<init>(com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker, java.lang.String):void type: CONSTRUCTOR)
                          (wrap: java.util.concurrent.ExecutorService : 0x002f: IGET  (r3v0 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'smsVerificationWorker' com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker) com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker.l java.util.concurrent.ExecutorService)
                         type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                          (wrap: f.b.a.a.a.c0.a1 : 0x0037: CONSTRUCTOR  (r2v1 f.b.a.a.a.c0.a1 A[REMOVE]) = 
                          (r0v0 'smsVerificationWorker' com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker)
                          (r6v4 'str2' java.lang.String)
                         call: f.b.a.a.a.c0.a1.<init>(com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker, java.lang.String):void type: CONSTRUCTOR)
                          (wrap: java.util.concurrent.ExecutorService : 0x003a: IGET  (r6v5 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'smsVerificationWorker' com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker) com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker.k java.util.concurrent.ExecutorService)
                         type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                          (wrap: f.b.a.a.a.c0.d1 : 0x0040: SGET  (r1v5 f.b.a.a.a.c0.d1 A[REMOVE]) =  f.b.a.a.a.c0.d1.a f.b.a.a.a.c0.d1)
                          (wrap: java.util.concurrent.ExecutorService : 0x0042: IGET  (r2v2 java.util.concurrent.ExecutorService A[REMOVE]) = (r0v0 'smsVerificationWorker' com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker) com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker.l java.util.concurrent.ExecutorService)
                         type: VIRTUAL call: f.b.b.f.a.l.y(f.b.b.a.g, java.util.concurrent.Executor):f.b.b.f.a.l in method: f.b.a.a.a.c0.v0.a(java.lang.Object):f.b.b.f.a.u, file: classes.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.c0.w0, state: NOT_LOADED
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
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                        	... 14 more
                        */
                    @Override // f.b.b.f.a.i
                    public final f.b.b.f.a.u a(java.lang.Object r6) {
                        /*
                            r5 = this;
                            com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker r0 = com.google.android.apps.exposurenotification.nearby.SmsVerificationWorker.this
                            f.b.b.a.l r1 = r5.b
                            java.lang.Void r6 = (java.lang.Void) r6
                            java.util.Objects.requireNonNull(r0)
                            boolean r6 = r1.b()
                            if (r6 != 0) goto L_0x001a
                            java.lang.Exception r6 = new java.lang.Exception
                            r6.<init>()
                            f.b.b.f.a.s$a r0 = new f.b.b.f.a.s$a
                            r0.<init>(r6)
                            goto L_0x006d
                        L_0x001a:
                            java.lang.Object r6 = r1.a()
                            java.lang.String r6 = (java.lang.String) r6
                            f.b.a.a.a.n0.k0 r1 = r0.f390h
                            f.b.b.f.a.u r1 = r1.c(r6)
                            f.b.b.f.a.l r1 = f.b.b.f.a.l.x(r1)
                            f.b.a.a.a.c0.w0 r2 = new f.b.a.a.a.c0.w0
                            r2.<init>(r0, r6)
                            java.util.concurrent.ExecutorService r3 = r0.f394l
                            f.b.b.f.a.l r1 = r1.z(r2, r3)
                            f.b.a.a.a.c0.a1 r2 = new f.b.a.a.a.c0.a1
                            r2.<init>(r0, r6)
                            java.util.concurrent.ExecutorService r6 = r0.f393k
                            f.b.b.f.a.l r6 = r1.z(r2, r6)
                            f.b.a.a.a.c0.d1 r1 = f.b.a.a.a.c0.d1.a
                            java.util.concurrent.ExecutorService r2 = r0.f394l
                            f.b.b.f.a.l r6 = r6.y(r1, r2)
                            java.lang.Class<f.b.a.a.a.z.f0$c> r1 = f.b.a.a.a.z.f0.c.class
                            f.b.a.a.a.c0.q0 r2 = f.b.a.a.a.c0.q0.a
                            java.util.concurrent.ExecutorService r3 = r0.f394l
                            f.b.b.f.a.a$a r4 = new f.b.b.f.a.a$a
                            r4.<init>(r6, r1, r2)
                            java.util.concurrent.Executor r1 = f.b.a.c.b.o.b.k1(r3, r4)
                            r6.a(r4, r1)
                            java.lang.Class<f.b.a.a.a.z.f0$d> r6 = f.b.a.a.a.z.f0.d.class
                            f.b.a.a.a.c0.y0 r1 = f.b.a.a.a.c0.y0.a
                            java.util.concurrent.ExecutorService r0 = r0.f394l
                            f.b.b.f.a.a$a r2 = new f.b.b.f.a.a$a
                            r2.<init>(r4, r6, r1)
                            java.util.concurrent.Executor r6 = f.b.a.c.b.o.b.k1(r0, r2)
                            r4.a(r2, r6)
                            r0 = r2
                        L_0x006d:
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.c0.v0.a(java.lang.Object):f.b.b.f.a.u");
                    }
                }, this.f394l).y(x0.a, this.f394l);
                z0 z0Var = z0.a;
                ExecutorService executorService = this.f394l;
                a.b bVar = new a.b(y, d.class, z0Var);
                y.a(bVar, f.b.a.c.b.o.b.k1(executorService, bVar));
                s0 s0Var = s0.a;
                ExecutorService executorService2 = this.f394l;
                a.b bVar2 = new a.b(bVar, c.class, s0Var);
                bVar.a(bVar2, f.b.a.c.b.o.b.k1(executorService2, bVar2));
                u0 u0Var = new g(parse) { // from class: f.b.a.a.a.c0.u0
                    public final /* synthetic */ Uri b;

                    {
                        this.b = r2;
                    }

                    @Override // f.b.b.a.g
                    public final Object a(Object obj2) {
                        SmsVerificationWorker smsVerificationWorker = SmsVerificationWorker.this;
                        Uri uri = this.b;
                        SmsVerificationWorker.b bVar3 = (SmsVerificationWorker.b) obj2;
                        h0 h0Var = smsVerificationWorker.f392j;
                        Context context = smsVerificationWorker.b;
                        String str2 = g0.a;
                        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                        launchIntentForPackage.setFlags(268468224);
                        launchIntentForPackage.putExtra("IntentUtil.ACTION_SMS_VERIFICATION", true);
                        launchIntentForPackage.putExtra("IntentUtil.EXTRA_DEEP_LINK", uri);
                        Intent b2 = g0.b(smsVerificationWorker.b);
                        b2.putExtra("IntentUtil.ACTION_SMS_VERIFICATION", true);
                        h0Var.c(context, R.string.notify_others_notification_title, R.string.enx_testVerificationNotificationBody, launchIntentForPackage, b2);
                        return new ListenableWorker.a.c();
                    }
                };
                ExecutorService executorService3 = this.f394l;
                a.b bVar3 = new a.b(bVar2, b.class, u0Var);
                bVar2.a(bVar3, f.b.a.c.b.o.b.k1(executorService3, bVar3));
                r0 r0Var = r0.a;
                ExecutorService executorService4 = this.f394l;
                a.b bVar4 = new a.b(bVar3, r.a.class, r0Var);
                bVar3.a(bVar4, f.b.a.c.b.o.b.k1(executorService4, bVar4));
                b1 b1Var = b1.a;
                ExecutorService executorService5 = this.f394l;
                a.b bVar5 = new a.b(bVar4, Throwable.class, b1Var);
                bVar4.a(bVar5, f.b.a.c.b.o.b.k1(executorService5, bVar5));
                return bVar5;
            }
        }
        return f.b.a.c.b.o.b.R0(cVar);
    }
}
