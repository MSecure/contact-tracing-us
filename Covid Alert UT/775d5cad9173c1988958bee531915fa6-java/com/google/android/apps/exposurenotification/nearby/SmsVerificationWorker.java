package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import android.net.Uri;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import e.b.a.m;
import f.b.a.a.a.b0.i1;
import f.b.a.a.a.b0.k0;
import f.b.a.a.a.b0.l0;
import f.b.a.a.a.b0.m0;
import f.b.a.a.a.b0.n0;
import f.b.a.a.a.b0.o0;
import f.b.a.a.a.b0.q0;
import f.b.a.a.a.b0.r0;
import f.b.a.a.a.l0.i0;
import f.b.a.a.a.l0.v0;
import f.b.a.a.a.n0.m;
import f.b.a.a.a.s.v;
import f.b.a.a.a.y.f0;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import f.b.b.f.a.x;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;

public class SmsVerificationWorker extends ListenableWorker {
    public static final l.b.a.d r = l.b.a.d.n(10);

    /* renamed from: g  reason: collision with root package name */
    public final i1 f382g;

    /* renamed from: h  reason: collision with root package name */
    public final i0 f383h;

    /* renamed from: i  reason: collision with root package name */
    public final f0 f384i;

    /* renamed from: j  reason: collision with root package name */
    public final v f385j;

    /* renamed from: k  reason: collision with root package name */
    public final ExecutorService f386k;

    /* renamed from: l  reason: collision with root package name */
    public final ExecutorService f387l;
    public final x m;
    public final SecureRandom n;
    public final m o;
    public final f.b.a.a.a.s.e0.a p;
    public final v0 q;

    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public static class c extends Exception {
        public c() {
        }

        public c(a aVar) {
        }
    }

    public static class d extends Exception {
        public d() {
        }

        public d(a aVar) {
        }
    }

    public SmsVerificationWorker(Context context, WorkerParameters workerParameters, i1 i1Var, v0 v0Var, i0 i0Var, f0 f0Var, v vVar, ExecutorService executorService, ExecutorService executorService2, x xVar, SecureRandom secureRandom, m mVar, f.b.a.a.a.s.e0.a aVar) {
        super(context, workerParameters);
        this.f382g = i1Var;
        this.q = v0Var;
        this.f383h = i0Var;
        this.f384i = f0Var;
        this.f385j = vVar;
        this.f386k = executorService;
        this.f387l = executorService2;
        this.m = xVar;
        this.n = secureRandom;
        this.o = mVar;
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
            } else if (!m.e.N0(this.b)) {
                cVar = new ListenableWorker.a.c();
            } else {
                l y = l.x(this.o.b()).z(new l0(this), this.f387l).z(new q0(this, f.b.a.a.a.s.u.c(parse)), this.f387l).y(m0.a, this.f387l);
                k0 k0Var = k0.a;
                ExecutorService executorService = this.f387l;
                a.C0108a aVar = new a.C0108a(y, f.b.a.c.b.l.b.class, k0Var);
                y.a(aVar, f.b.a.c.b.o.b.j1(executorService, aVar));
                r0 r0Var = r0.a;
                ExecutorService executorService2 = this.f387l;
                a.b bVar = new a.b(aVar, d.class, r0Var);
                aVar.a(bVar, f.b.a.c.b.o.b.j1(executorService2, bVar));
                n0 n0Var = n0.a;
                ExecutorService executorService3 = this.f387l;
                a.b bVar2 = new a.b(bVar, c.class, n0Var);
                bVar.a(bVar2, f.b.a.c.b.o.b.j1(executorService3, bVar2));
                o0 o0Var = new o0(this, parse);
                ExecutorService executorService4 = this.f387l;
                a.b bVar3 = new a.b(bVar2, b.class, o0Var);
                bVar2.a(bVar3, f.b.a.c.b.o.b.j1(executorService4, bVar3));
                f.b.a.a.a.b0.v0 v0Var = f.b.a.a.a.b0.v0.a;
                ExecutorService executorService5 = this.f387l;
                a.b bVar4 = new a.b(bVar3, Throwable.class, v0Var);
                bVar3.a(bVar4, f.b.a.c.b.o.b.j1(executorService5, bVar4));
                return bVar4;
            }
        }
        return f.b.a.c.b.o.b.Q0(cVar);
    }
}
