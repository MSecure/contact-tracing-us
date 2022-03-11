package f.b.a.a.a.a0;

import android.content.Context;
import android.database.Cursor;
import e.b.a.m;
import f.b.a.a.a.a0.r;
import f.b.a.a.a.c0.q1;
import f.b.a.a.a.h0.a;
import f.b.a.a.a.h0.c;
import f.b.a.a.a.h0.d;
import f.b.a.a.a.h0.n;
import f.b.a.a.a.h0.p;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.n0.g;
import f.b.a.a.a.n0.h;
import f.b.a.a.a.n0.m1;
import f.b.a.a.a.n0.n1;
import f.b.a.a.a.n0.q;
import f.b.a.b.f;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import f.b.b.f.a.w;
import f.b.g.d0;
import gov.nm.covid19.exposurenotifications.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;
import l.b.a.d;
import l.b.a.e;
/* loaded from: classes.dex */
public class s implements r {

    /* renamed from: j */
    public static final f.b.a.a.a.t.p0.a f2188j = f.b.a.a.a.t.p0.a.e("FirelogAnalyticsLogger");

    /* renamed from: k */
    public static final d f2189k = d.n(120);
    public final g.a<q1> a;
    public final String b;
    public final a1 c;

    /* renamed from: d */
    public final f<c> f2190d;

    /* renamed from: e */
    public final f.b.a.a.a.t.q0.a f2191e;

    /* renamed from: f */
    public final h f2192f;

    /* renamed from: g */
    public final w f2193g;

    /* renamed from: h */
    public final ScheduledExecutorService f2194h;

    /* renamed from: i */
    public final f.b.a.a.a.n0.q1 f2195i;

    /* loaded from: classes.dex */
    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public s(Context context, a1 a1Var, g.a<q1> aVar, f<c> fVar, h hVar, f.b.a.a.a.t.q0.a aVar2, f.b.a.a.a.n0.q1 q1Var, w wVar, ScheduledExecutorService scheduledExecutorService) {
        this.b = context.getResources().getString(R.string.enx_regionIdentifier);
        this.f2190d = fVar;
        this.c = a1Var;
        this.a = aVar;
        this.f2191e = aVar2;
        this.f2192f = hVar;
        this.f2193g = wVar;
        this.f2194h = scheduledExecutorService;
        this.f2195i = q1Var;
        f2188j.f("Using firelog analytics logger.");
        c cVar = new c(hVar);
        synchronized (a1Var) {
            a1.m = cVar;
        }
    }

    @Override // f.b.a.a.a.a0.r
    public void a(n.c cVar) {
        f2188j.f(cVar.toString());
        l x = l.x(this.f2193g.mo18submit((Runnable) new Runnable(c.newBuilder().addUiInteraction(n.newBuilder().setEventType(cVar).build()).build()) { // from class: f.b.a.a.a.a0.d
            public final /* synthetic */ c c;

            {
                this.c = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                s.this.o(this.c);
            }
        }));
        k kVar = k.a;
        w wVar = this.f2193g;
        a.b bVar = new a.b(x, Exception.class, kVar);
        x.a(bVar, f.b.a.c.b.o.b.k1(wVar, bVar));
    }

    @Override // f.b.a.a.a.a0.r
    public u<?> b(boolean z) {
        f.b.a.a.a.t.p0.a aVar;
        String str;
        g gVar = null;
        if (!z) {
            Iterator it = ((ArrayList) this.f2192f.b()).iterator();
            g gVar2 = null;
            while (it.hasNext()) {
                g gVar3 = (g) it.next();
                try {
                    for (f.b.a.a.a.h0.a aVar2 : c.parseFrom(f.b.b.c.a.a.a(gVar3.a())).getApiCallList()) {
                        if (aVar2.getApiCallType().equals(a.b.CALL_STOP)) {
                            gVar2 = gVar3;
                        }
                    }
                } catch (d0 e2) {
                    f2188j.c("Error decoding EnxLogExtension: " + e2);
                }
            }
            f2188j.a(gVar2 != null ? "findLastStopCallIfExists: Found last stop call: " + gVar2 : "findLastStopCallIfExists: No stop call found");
            gVar = gVar2;
            aVar = f2188j;
            if (gVar != null) {
                str = "!isEnabled but stop call found, partially uploading logs.";
            } else {
                aVar.a("!isEnabled and no stop call found, not uploading logs.");
                return new s.a(new r.a());
            }
        } else {
            aVar = f2188j;
            str = "isEnabled, fully uploading logs.";
        }
        aVar.a(str);
        e c = this.f2191e.c();
        f.b.b.a.l<e> r = this.c.r();
        if (!r.b()) {
            f2188j.f("Skipped firelog upload - no last timestamp, resetting");
            this.c.s();
        } else if (d.c(r.a(), c).t() < 4) {
            f2188j.f("Skipped firelog upload - less than 4 hours");
        } else {
            int t = (int) d.c(r.a(), c).r(30).t();
            this.c.s();
            List<g> b2 = this.f2192f.b();
            c.b newBuilder = c.newBuilder();
            Iterator it2 = ((ArrayList) b2).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                g gVar4 = (g) it2.next();
                try {
                    newBuilder.mergeFrom(f.b.b.c.a.a.a(gVar4.a()));
                    if (gVar != null && gVar4.b() == gVar.b()) {
                        f2188j.a("Stopping to build EnxLogExtension at " + gVar);
                        break;
                    }
                } catch (d0 e3) {
                    f2188j.c("Error reading from AnalyticsLoggingRepository: " + e3);
                    return new s.a(e3);
                }
            }
            l y = l.x(f.b.a.c.b.o.b.R0(Boolean.valueOf(this.c.a.getBoolean("ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY", false)))).z(new i(newBuilder.setBuildId(12000042).setHoursSinceLastBatch(t).setRegionIdentifier(this.b).build()) { // from class: f.b.a.a.a.a0.j
                public final /* synthetic */ c b;

                {
                    this.b = r2;
                }

                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0030: RETURN  
                      (wrap: f.b.b.f.a.u : 0x002c: INVOKE  (r0v1 f.b.b.f.a.u A[REMOVE]) = 
                      (wrap: f.b.a.a.a.a0.i : 0x0029: CONSTRUCTOR  (r3v3 f.b.a.a.a.a0.i A[REMOVE]) = (r0v0 'sVar' f.b.a.a.a.a0.s), (r1v0 'cVar' f.b.a.a.a.h0.c) call: f.b.a.a.a.a0.i.<init>(f.b.a.a.a.a0.s, f.b.a.a.a.h0.c):void type: CONSTRUCTOR)
                     type: STATIC call: e.b.a.m.e.n0(e.g.a.d):f.b.b.f.a.u)
                     in method: f.b.a.a.a.a0.j.a(java.lang.Object):f.b.b.f.a.u, file: classes.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.a0.i, state: NOT_LOADED
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
                    	... 18 more
                    */
                @Override // f.b.b.f.a.i
                public final f.b.b.f.a.u a(java.lang.Object r3) {
                    /*
                        r2 = this;
                        f.b.a.a.a.a0.s r0 = f.b.a.a.a.a0.s.this
                        f.b.a.a.a.h0.c r1 = r2.b
                        java.lang.Boolean r3 = (java.lang.Boolean) r3
                        java.util.Objects.requireNonNull(r0)
                        boolean r3 = r3.booleanValue()
                        if (r3 != 0) goto L_0x0027
                        f.b.a.a.a.t.p0.a r3 = f.b.a.a.a.a0.s.f2188j
                        java.lang.String r1 = "Skipped firelog upload."
                        r3.f(r1)
                        f.b.a.a.a.n0.h r3 = r0.f2192f
                        r3.a()
                        f.b.a.a.a.a0.s$b r3 = new f.b.a.a.a.a0.s$b
                        r0 = 0
                        r3.<init>(r0)
                        f.b.b.f.a.s$a r0 = new f.b.b.f.a.s$a
                        r0.<init>(r3)
                        goto L_0x0030
                    L_0x0027:
                        f.b.a.a.a.a0.i r3 = new f.b.a.a.a.a0.i
                        r3.<init>(r0, r1)
                        f.b.b.f.a.u r0 = e.b.a.m.e.n0(r3)
                    L_0x0030:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.a0.j.a(java.lang.Object):f.b.b.f.a.u");
                }
            }, this.f2193g).y(new f.b.b.a.g(gVar) { // from class: f.b.a.a.a.a0.h
                public final /* synthetic */ g b;

                {
                    this.b = r2;
                }

                @Override // f.b.b.a.g
                public final Object a(Object obj) {
                    s sVar = s.this;
                    g gVar5 = this.b;
                    Objects.requireNonNull(sVar);
                    if (gVar5 != null) {
                        f.b.a.a.a.t.p0.a aVar3 = s.f2188j;
                        aVar3.a("ErasingEventsBatchUpToIncludingEvent " + gVar5);
                        f.b.a.a.a.n0.c cVar = sVar.f2192f.a;
                        f.b.a.a.a.n0.d dVar = (f.b.a.a.a.n0.d) cVar;
                        e.v.n.d.a(dVar.a, true, new f.b.a.a.a.n0.f(dVar, gVar5.b()));
                    } else {
                        sVar.f2192f.a();
                    }
                    s.f2188j.f("Analytics log batch sent to Firelog.");
                    return null;
                }
            }, this.f2193g);
            a aVar3 = a.a;
            w wVar = this.f2193g;
            a.b bVar = new a.b(y, b.class, aVar3);
            y.a(bVar, f.b.a.c.b.o.b.k1(wVar, bVar));
            return bVar;
        }
        return f.b.b.f.a.s.c;
    }

    @Override // f.b.a.a.a.a0.r
    public u<?> c(d.EnumC0076d dVar, int i2) {
        c n = n(dVar, i2);
        f.b.a.a.a.t.p0.a aVar = f2188j;
        aVar.f(dVar + " succeeded with payload size: " + i2);
        return this.f2193g.mo18submit((Runnable) new Runnable(n) { // from class: f.b.a.a.a.a0.f
            public final /* synthetic */ c c;

            {
                this.c = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                s.this.o(this.c);
            }
        });
    }

    @Override // f.b.a.a.a.a0.r
    public u<?> d(a.b bVar, Exception exc) {
        int i2 = exc instanceof f.b.a.c.b.l.b ? ((f.b.a.c.b.l.b) exc).b.c : -2;
        f.b.a.a.a.t.p0.a aVar = f2188j;
        aVar.d(bVar + " failed.", exc);
        return this.f2193g.mo18submit((Runnable) new Runnable(c.newBuilder().addApiCall(f.b.a.a.a.h0.a.newBuilder().setApiCallType(bVar).setStatusCode(i2).build()).build()) { // from class: f.b.a.a.a.a0.e
            public final /* synthetic */ c c;

            {
                this.c = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                s.this.o(this.c);
            }
        });
    }

    @Override // f.b.a.a.a.a0.r
    public u<?> e(d.EnumC0076d dVar, Throwable th) {
        return this.f2193g.mo18submit((Runnable) new Runnable(m(dVar, th)) { // from class: f.b.a.a.a.a0.g
            public final /* synthetic */ c c;

            {
                this.c = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                s.this.o(this.c);
            }
        });
    }

    @Override // f.b.a.a.a.a0.r
    public u<?> f(a.b bVar) {
        f.b.a.a.a.t.p0.a aVar = f2188j;
        aVar.f(bVar + " succeeded.");
        return this.f2193g.mo18submit((Runnable) new Runnable(c.newBuilder().addApiCall(f.b.a.a.a.h0.a.newBuilder().setApiCallType(bVar).setStatusCode(0).build()).build()) { // from class: f.b.a.a.a.a0.b
            public final /* synthetic */ c c;

            {
                this.c = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                s.this.o(this.c);
            }
        });
    }

    @Override // f.b.a.a.a.a0.r
    public void g(p.d dVar) {
        o(c.newBuilder().addWorkManagerTask(p.newBuilder().setWorkerTask(dVar).setStatus(p.c.STATUS_SUCCESS).build()).build());
        f.b.a.a.a.t.p0.a aVar = f2188j;
        aVar.f(dVar + " finished with status: SUCCESS");
    }

    @Override // f.b.a.a.a.a0.r
    public void h(p.d dVar) {
        p.c cVar = p.c.STATUS_ABANDONED;
        o(c.newBuilder().addWorkManagerTask(p.newBuilder().setWorkerTask(dVar).setStatus(cVar).build()).build());
        f.b.a.a.a.t.p0.a aVar = f2188j;
        aVar.c(dVar + " finished with status: " + cVar);
    }

    /* JADX WARN: Finally extract failed */
    @Override // f.b.a.a.a.a0.r
    public void i(p.d dVar) {
        f.b.a.a.a.n0.q1 q1Var = this.f2195i;
        p.c cVar = p.c.STATUS_STARTED;
        String str = cVar.toString();
        String str2 = dVar.name() + ":" + str;
        n1 n1Var = (n1) q1Var.a;
        Objects.requireNonNull(n1Var);
        e.v.i t = e.v.i.t("SELECT lastRunTimestampMillis FROM WorkerStatusEntity WHERE workerTaskNameAndStatus =  ?", 1);
        if (str2 == null) {
            t.J(1);
        } else {
            t.L(1, str2);
        }
        n1Var.a.b();
        Long l2 = null;
        int i2 = 0;
        Cursor b2 = e.v.p.b.b(n1Var.a, t, false, null);
        try {
            if (b2.moveToFirst() && !b2.isNull(0)) {
                l2 = Long.valueOf(b2.getLong(0));
            }
            f.b.b.a.l c = l2 != null ? f.b.b.a.l.c(e.z(l2.longValue())) : f.b.b.a.a.b;
            if (c.b()) {
                i2 = (int) l.b.a.d.c((l.b.a.x.d) c.a(), this.f2191e.c()).r(30).t();
            }
            f.b.a.a.a.n0.q1 q1Var2 = this.f2195i;
            String str3 = cVar.toString();
            e c2 = this.f2191e.c();
            m1 m1Var = q1Var2.a;
            q qVar = new q(dVar.name() + ":" + str3, c2.G());
            n1 n1Var2 = (n1) m1Var;
            n1Var2.a.b();
            n1Var2.a.c();
            try {
                n1Var2.b.e(qVar);
                n1Var2.a.l();
                n1Var2.a.g();
                o(c.newBuilder().addWorkManagerTask(p.newBuilder().setWorkerTask(dVar).setStatus(cVar).setHoursSinceLastRun(i2).build()).build());
                f2188j.f(dVar + " started");
            } catch (Throwable th) {
                n1Var2.a.g();
                throw th;
            }
        } finally {
            b2.close();
            t.Q();
        }
    }

    @Override // f.b.a.a.a.a0.r
    public void j(d.EnumC0076d dVar, int i2) {
        o(n(dVar, i2));
        f.b.a.a.a.t.p0.a aVar = f2188j;
        aVar.f(dVar + " succeeded with payload size: " + i2);
    }

    @Override // f.b.a.a.a.a0.r
    public void k(p.d dVar, Throwable th) {
        p.c cVar = p.c.STATUS_FAIL;
        if (th instanceof TimeoutException) {
            cVar = p.c.STATUS_TIMEOUT;
        }
        o(c.newBuilder().addWorkManagerTask(p.newBuilder().setWorkerTask(dVar).setStatus(cVar).build()).build());
        f.b.a.a.a.t.p0.a aVar = f2188j;
        aVar.c(dVar + " failed with status: " + cVar);
    }

    @Override // f.b.a.a.a.a0.r
    public void l(d.EnumC0076d dVar, Throwable th) {
        o(m(dVar, th));
    }

    public final c m(d.EnumC0076d dVar, Throwable th) {
        d.c r0 = m.e.r0(th);
        int p0 = m.e.p0(th);
        String k0 = m.e.k0(th);
        String l0 = m.e.l0(th);
        f.b.a.a.a.t.p0.a aVar = f2188j;
        aVar.c(dVar + " failed.  Result:[" + r0 + "] HTTP status:[" + p0 + "] Server error:[" + k0 + ":" + l0 + "]");
        return c.newBuilder().addRpcCall(f.b.a.a.a.h0.d.newBuilder().setRpcCallType(dVar).setRpcCallResult(r0).build()).build();
    }

    public final c n(d.EnumC0076d dVar, int i2) {
        return c.newBuilder().addRpcCall(f.b.a.a.a.h0.d.newBuilder().setRpcCallType(dVar).setPayloadSize(i2).setRpcCallResult(d.c.RESULT_SUCCESS).build()).build();
    }

    public final void o(c cVar) {
        if (this.c.a.getBoolean("ExposureNotificationSharedPreferences.SHARE_ANALYTICS_KEY", false)) {
            this.f2192f.c(cVar);
            if (!this.c.r().b()) {
                this.c.s();
            }
            f2188j.f("App analytics enabled via in-app consent. Sending log event.");
            return;
        }
        f2188j.a("App analytics disabled via in-app consent. Not sending log event.");
    }
}
