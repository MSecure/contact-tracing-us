package com.google.android.apps.exposurenotification.keyupload;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import e.b0.f;
import e.b0.w;
import f.b.a.a.a.c0.d;
import f.b.a.a.a.n0.m;
import f.b.a.a.a.y.a0;
import f.b.a.a.a.y.e0;
import f.b.a.a.a.y.f0;
import f.b.a.a.a.y.o;
import f.b.a.a.a.y.s;
import f.b.a.a.a.y.t;
import f.b.a.a.a.y.v;
import f.b.b.b.b;
import f.b.b.b.c;
import f.b.b.f.a.a;
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

public final class UploadCoverTrafficWorker extends ListenableWorker {
    public static final f.b.a.a.a.s.d0.a n = f.b.a.a.a.s.d0.a.e("UploadCoverTrafficWrk");
    public static final TimeUnit o = TimeUnit.HOURS;
    public static final d p = d.i(10000);
    public static final d q = d.h(25);
    public static final d r = d.h(24);

    /* renamed from: g  reason: collision with root package name */
    public final f0 f358g;

    /* renamed from: h  reason: collision with root package name */
    public final ExecutorService f359h;

    /* renamed from: i  reason: collision with root package name */
    public final ExecutorService f360i;

    /* renamed from: j  reason: collision with root package name */
    public final x f361j;

    /* renamed from: k  reason: collision with root package name */
    public final SecureRandom f362k;

    /* renamed from: l  reason: collision with root package name */
    public final m f363l;
    public final w m;

    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public UploadCoverTrafficWorker(Context context, WorkerParameters workerParameters, f0 f0Var, ExecutorService executorService, ExecutorService executorService2, x xVar, SecureRandom secureRandom, m mVar, w wVar) {
        super(context, workerParameters);
        this.f358g = f0Var;
        this.f359h = executorService;
        this.f360i = executorService2;
        this.f361j = xVar;
        this.f362k = secureRandom;
        this.f363l = mVar;
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
            l y = l.x(this.f358g.c(g())).z(new t(this), this.f359h).y(v.a, this.f360i);
            f.b.a.a.a.y.u uVar = f.b.a.a.a.y.u.a;
            ExecutorService executorService = this.f360i;
            a.b bVar = new a.b(y, Throwable.class, uVar);
            y.a(bVar, f.b.a.c.b.o.b.j1(executorService, bVar));
            return bVar;
        } else if (!j(0.08333333333333333d)) {
            return f.b.a.c.b.o.b.Q0(new ListenableWorker.a.c());
        } else {
            l y2 = l.x(this.f363l.b()).z(new f.b.a.a.a.y.x(this), this.f360i).y(o.a, this.f360i);
            s sVar = s.a;
            ExecutorService executorService2 = this.f360i;
            a.b bVar2 = new a.b(y2, b.class, sVar);
            y2.a(bVar2, f.b.a.c.b.o.b.j1(executorService2, bVar2));
            f.b.a.a.a.y.w wVar = f.b.a.a.a.y.w.a;
            ExecutorService executorService3 = this.f360i;
            a.b bVar3 = new a.b(bVar2, Throwable.class, wVar);
            bVar2.a(bVar3, f.b.a.c.b.o.b.j1(executorService3, bVar3));
            return bVar3;
        }
    }

    public final e0 g() {
        e0.a i2 = e0.i("FAKE-VALIDATION-CODE", f.b.a.a.a.s.x.a(this.f362k));
        i2.b(true);
        i2.c(i());
        a0.b bVar = (a0.b) i2;
        bVar.f2471e = f.b.a.a.a.s.a0.c(100);
        return bVar.a();
    }

    public final e0 h() {
        e0.a i2 = e0.i("FAKE-VALIDATION-CODE", f.b.a.a.a.s.x.a(this.f362k));
        i2.b(true);
        i2.c(i());
        c w = c.w("US", "CA");
        a0.b bVar = (a0.b) i2;
        bVar.f2470d = w == null ? null : c.s(w);
        bVar.f2473g = f.b.a.a.a.s.a0.c(32);
        bVar.f2471e = f.b.a.a.a.s.a0.c(100);
        bVar.f2474h = f.b.a.a.a.s.a0.c(100);
        bVar.f2475i = l.b.a.f.P(2020, 1, 1);
        return bVar.a();
    }

    public final List<f.b.a.a.a.c0.d> i() {
        f.b.b.b.a<Object> aVar = c.c;
        f.b.a.c.b.o.b.y(4, "initialCapacity");
        Object[] objArr = new Object[4];
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (i2 < 14) {
            byte[] bArr = new byte[16];
            this.f362k.nextBytes(bArr);
            d.a f2 = f.b.a.a.a.c0.d.f();
            f2.c(bArr);
            f2.e(i2 % 7);
            f2.b(2650847);
            f.b.a.a.a.c0.d a2 = f2.a();
            Objects.requireNonNull(a2);
            int i4 = i3 + 1;
            if (objArr.length < i4) {
                objArr = Arrays.copyOf(objArr, b.AbstractC0103b.b(objArr.length, i4));
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
        return this.f362k.nextDouble() < d2;
    }
}
