package com.google.android.apps.exposurenotification.privateanalytics;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.privateanalytics.SubmitPrivateAnalyticsWorker;
import f.b.a.a.a.g0.j;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.p0.r;
import f.b.a.a.a.t.p0.a;
import f.b.a.c.b.o.b;
import f.b.a.d.a.b0;
import f.b.a.d.a.g0;
import f.b.b.a.g;
import f.b.b.a.l;
import f.b.b.b.c;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.u;
import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import l.b.a.d;
import l.b.a.e;
/* loaded from: classes.dex */
public class SubmitPrivateAnalyticsWorker extends ListenableWorker {
    public static final a n = a.e("PrioSubmitWorker");
    public static final d o = d.f(1);

    /* renamed from: g */
    public final g0 f429g;

    /* renamed from: h */
    public final ExecutorService f430h;

    /* renamed from: i */
    public final a1 f431i;

    /* renamed from: j */
    public final f.b.a.a.a.t.q0.a f432j;

    /* renamed from: k */
    public final r f433k;

    /* renamed from: l */
    public final l<b0> f434l;
    public int m;

    public SubmitPrivateAnalyticsWorker(Context context, WorkerParameters workerParameters, g0 g0Var, ExecutorService executorService, r rVar, f.b.a.a.a.t.q0.a aVar, a1 a1Var, l<b0> lVar, int i2) {
        super(context, workerParameters);
        this.f429g = g0Var;
        this.f430h = executorService;
        this.f432j = aVar;
        this.f431i = a1Var;
        this.f433k = rVar;
        this.f434l = lVar;
        this.m = i2;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        n.a("Starting worker for submitting private analytics to ingestion server.");
        f.b.b.f.a.l y = f.b.b.f.a.l.x(this.f433k.b()).z(new i() { // from class: f.b.a.a.a.g0.h
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0128: RETURN  
                  (wrap: f.b.b.f.a.l : 0x0128: INVOKE  (r11v10 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.l : 0x011d: INVOKE  (r0v5 f.b.b.f.a.l A[REMOVE]) = 
                  (wrap: f.b.b.f.a.u<f.b.a.d.a.h0> : 0x0119: INVOKE  (r0v4 f.b.b.f.a.u<f.b.a.d.a.h0> A[REMOVE]) = 
                  (wrap: f.b.a.d.a.f0 : 0x0117: IGET  (r0v3 f.b.a.d.a.f0 A[REMOVE]) = (r11v8 'g0Var' f.b.a.d.a.g0) f.b.a.d.a.g0.c f.b.a.d.a.f0)
                 type: INTERFACE call: f.b.a.d.a.f0.a():f.b.b.f.a.u)
                 type: STATIC call: f.b.b.f.a.l.x(f.b.b.f.a.u):f.b.b.f.a.l)
                  (wrap: f.b.a.d.a.o : 0x0123: CONSTRUCTOR  (r1v6 f.b.a.d.a.o A[REMOVE]) = (r11v8 'g0Var' f.b.a.d.a.g0) call: f.b.a.d.a.o.<init>(f.b.a.d.a.g0):void type: CONSTRUCTOR)
                  (wrap: java.util.concurrent.ExecutorService : 0x0126: IGET  (r11v9 java.util.concurrent.ExecutorService A[REMOVE]) = (r11v8 'g0Var' f.b.a.d.a.g0) f.b.a.d.a.g0.a java.util.concurrent.ExecutorService)
                 type: VIRTUAL call: f.b.b.f.a.l.z(f.b.b.f.a.i, java.util.concurrent.Executor):f.b.b.f.a.l)
                 in method: f.b.a.a.a.g0.h.a(java.lang.Object):f.b.b.f.a.u, file: classes.dex
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.d.a.o, state: NOT_LOADED
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
            public final f.b.b.f.a.u a(java.lang.Object r11) {
                /*
                // Method dump skipped, instructions count: 320
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.g0.h.a(java.lang.Object):f.b.b.f.a.u");
            }
        }, this.f430h).y(new g() { // from class: f.b.a.a.a.g0.i
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                c cVar = (c) obj;
                SubmitPrivateAnalyticsWorker.this.g();
                return new ListenableWorker.a.c();
            }
        }, this.f430h);
        j jVar = new g() { // from class: f.b.a.a.a.g0.j
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                g0.a aVar = (g0.a) obj;
                SubmitPrivateAnalyticsWorker.this.g();
                return new ListenableWorker.a.c();
            }
        };
        ExecutorService executorService = this.f430h;
        a.b bVar = new a.b(y, g0.a.class, jVar);
        y.a(bVar, b.k1(executorService, bVar));
        f.b.a.a.a.g0.g gVar = new g() { // from class: f.b.a.a.a.g0.g
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                SubmitPrivateAnalyticsWorker submitPrivateAnalyticsWorker = SubmitPrivateAnalyticsWorker.this;
                Objects.requireNonNull(submitPrivateAnalyticsWorker);
                SubmitPrivateAnalyticsWorker.n.d("Failure to submit private analytics", (Exception) obj);
                submitPrivateAnalyticsWorker.g();
                return new ListenableWorker.a.C0003a();
            }
        };
        ExecutorService executorService2 = this.f430h;
        a.b bVar2 = new a.b(bVar, Exception.class, gVar);
        bVar.a(bVar2, b.k1(executorService2, bVar2));
        return bVar2;
    }

    public final void g() {
        a1 a1Var = this.f431i;
        e c = this.f432j.c();
        if (a1Var.j()) {
            a1Var.a.edit().putLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_WORKER_RUN_TIME", c.G()).apply();
        }
        if (g0.a(this.m, Calendar.getInstance())) {
            a1 a1Var2 = this.f431i;
            e c2 = this.f432j.c();
            if (a1Var2.j()) {
                a1Var2.a.edit().putLong("ExposureNotificationSharedPreferences.PRIVATE_ANALYTICS_LAST_WORKER_RUN_TIME_FOR_BIWEEKLY", c2.G()).apply();
            }
        }
    }
}
