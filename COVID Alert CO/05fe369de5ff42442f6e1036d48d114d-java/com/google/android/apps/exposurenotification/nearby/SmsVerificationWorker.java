package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import android.net.Uri;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import e.b.a.m;
import f.b.a.a.a.b0.i0;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.d0.m;
import f.b.a.a.a.i.v;
import f.b.a.a.a.i.w;
import f.b.a.a.a.o.f0;
import f.b.a.a.a.q.i1;
import f.b.a.a.a.q.k0;
import f.b.a.a.a.q.l0;
import f.b.a.a.a.q.m0;
import f.b.a.a.a.q.n0;
import f.b.a.a.a.q.o0;
import f.b.a.a.a.q.q0;
import f.b.a.a.a.q.r0;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import f.b.b.f.a.x;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;

public class SmsVerificationWorker extends ListenableWorker {
    public static final l.b.a.d p = l.b.a.d.n(10);

    /* renamed from: e  reason: collision with root package name */
    public final i1 f382e;

    /* renamed from: f  reason: collision with root package name */
    public final i0 f383f;

    /* renamed from: g  reason: collision with root package name */
    public final f0 f384g;

    /* renamed from: h  reason: collision with root package name */
    public final w f385h;

    /* renamed from: i  reason: collision with root package name */
    public final ExecutorService f386i;

    /* renamed from: j  reason: collision with root package name */
    public final ExecutorService f387j;

    /* renamed from: k  reason: collision with root package name */
    public final x f388k;

    /* renamed from: l  reason: collision with root package name */
    public final SecureRandom f389l;
    public final m m;
    public final f.b.a.a.a.i.f0.a n;
    public final v0 o;

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

    public SmsVerificationWorker(Context context, WorkerParameters workerParameters, i1 i1Var, v0 v0Var, i0 i0Var, f0 f0Var, w wVar, ExecutorService executorService, ExecutorService executorService2, x xVar, SecureRandom secureRandom, m mVar, f.b.a.a.a.i.f0.a aVar) {
        super(context, workerParameters);
        this.f382e = i1Var;
        this.o = v0Var;
        this.f383f = i0Var;
        this.f384g = f0Var;
        this.f385h = wVar;
        this.f386i = executorService;
        this.f387j = executorService2;
        this.f388k = xVar;
        this.f389l = secureRandom;
        this.m = mVar;
        this.n = aVar;
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
            } else if (!m.h.C0(this.b)) {
                cVar = new ListenableWorker.a.c();
            } else {
                l y = l.x(this.m.b()).z(new l0(this), this.f387j).z(new q0(this, v.c(parse)), this.f387j).y(m0.a, this.f387j);
                k0 k0Var = k0.a;
                ExecutorService executorService = this.f387j;
                a.C0108a aVar = new a.C0108a(y, f.b.a.c.b.l.b.class, k0Var);
                y.a(aVar, f.b.a.c.b.o.b.g1(executorService, aVar));
                r0 r0Var = r0.a;
                ExecutorService executorService2 = this.f387j;
                a.b bVar = new a.b(aVar, d.class, r0Var);
                aVar.a(bVar, f.b.a.c.b.o.b.g1(executorService2, bVar));
                n0 n0Var = n0.a;
                ExecutorService executorService3 = this.f387j;
                a.b bVar2 = new a.b(bVar, c.class, n0Var);
                bVar.a(bVar2, f.b.a.c.b.o.b.g1(executorService3, bVar2));
                o0 o0Var = new o0(this, parse);
                ExecutorService executorService4 = this.f387j;
                a.b bVar3 = new a.b(bVar2, b.class, o0Var);
                bVar2.a(bVar3, f.b.a.c.b.o.b.g1(executorService4, bVar3));
                f.b.a.a.a.q.v0 v0Var = f.b.a.a.a.q.v0.a;
                ExecutorService executorService5 = this.f387j;
                a.b bVar4 = new a.b(bVar3, Throwable.class, v0Var);
                bVar3.a(bVar4, f.b.a.c.b.o.b.g1(executorService5, bVar4));
                return bVar4;
            }
        }
        return f.b.a.c.b.o.b.O0(cVar);
    }
}
