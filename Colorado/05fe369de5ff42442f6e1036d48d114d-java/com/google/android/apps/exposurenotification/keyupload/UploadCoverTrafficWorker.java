package com.google.android.apps.exposurenotification.keyupload;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import e.z.e;
import e.z.t;
import f.b.a.a.a.d0.m;
import f.b.a.a.a.i.b0;
import f.b.a.a.a.i.y;
import f.b.a.a.a.o.a0;
import f.b.a.a.a.o.e0;
import f.b.a.a.a.o.f0;
import f.b.a.a.a.o.o;
import f.b.a.a.a.o.s;
import f.b.a.a.a.o.v;
import f.b.a.a.a.o.w;
import f.b.a.a.a.r.d;
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
import l.b.a.f;

public final class UploadCoverTrafficWorker extends ListenableWorker {

    /* renamed from: l  reason: collision with root package name */
    public static final f.b.a.a.a.i.e0.a f353l = f.b.a.a.a.i.e0.a.e("UploadCoverTrafficWrk");
    public static final TimeUnit m = TimeUnit.HOURS;

    /* renamed from: e  reason: collision with root package name */
    public final f0 f354e;

    /* renamed from: f  reason: collision with root package name */
    public final ExecutorService f355f;

    /* renamed from: g  reason: collision with root package name */
    public final ExecutorService f356g;

    /* renamed from: h  reason: collision with root package name */
    public final x f357h;

    /* renamed from: i  reason: collision with root package name */
    public final SecureRandom f358i;

    /* renamed from: j  reason: collision with root package name */
    public final m f359j;

    /* renamed from: k  reason: collision with root package name */
    public final t f360k;

    public static class b extends Exception {
        public b() {
        }

        public b(a aVar) {
        }
    }

    public UploadCoverTrafficWorker(Context context, WorkerParameters workerParameters, f0 f0Var, ExecutorService executorService, ExecutorService executorService2, x xVar, SecureRandom secureRandom, m mVar, t tVar) {
        super(context, workerParameters);
        this.f354e = f0Var;
        this.f355f = executorService;
        this.f356g = executorService2;
        this.f357h = xVar;
        this.f358i = secureRandom;
        this.f359j = mVar;
        this.f360k = tVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        e eVar = this.c.b;
        boolean z = false;
        if (eVar != null) {
            Object obj = eVar.a.get("UploadCoverTrafficWorker.IS_DELAYED_EXECUTION");
            if (obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false) {
                z = true;
            }
        }
        if (z) {
            l y = l.x(this.f354e.c(g())).z(new f.b.a.a.a.o.t(this), this.f355f).y(v.a, this.f356g);
            f.b.a.a.a.o.u uVar = f.b.a.a.a.o.u.a;
            ExecutorService executorService = this.f356g;
            a.b bVar = new a.b(y, Throwable.class, uVar);
            y.a(bVar, f.b.a.c.b.o.b.g1(executorService, bVar));
            return bVar;
        } else if (!j(0.08333333333333333d)) {
            return f.b.a.c.b.o.b.O0(new ListenableWorker.a.c());
        } else {
            l y2 = l.x(this.f359j.b()).z(new f.b.a.a.a.o.x(this), this.f356g).y(o.a, this.f356g);
            s sVar = s.a;
            ExecutorService executorService2 = this.f356g;
            a.b bVar2 = new a.b(y2, b.class, sVar);
            y2.a(bVar2, f.b.a.c.b.o.b.g1(executorService2, bVar2));
            w wVar = w.a;
            ExecutorService executorService3 = this.f356g;
            a.b bVar3 = new a.b(bVar2, Throwable.class, wVar);
            bVar2.a(bVar3, f.b.a.c.b.o.b.g1(executorService3, bVar3));
            return bVar3;
        }
    }

    public final e0 g() {
        e0.a i2 = e0.i("FAKE-VALIDATION-CODE", y.a(this.f358i));
        i2.b(true);
        i2.c(i());
        a0.b bVar = (a0.b) i2;
        bVar.f2279e = b0.c(100);
        return bVar.a();
    }

    public final e0 h() {
        e0.a i2 = e0.i("FAKE-VALIDATION-CODE", y.a(this.f358i));
        i2.b(true);
        i2.c(i());
        c w = c.w("US", "CA");
        a0.b bVar = (a0.b) i2;
        bVar.f2278d = w == null ? null : c.s(w);
        bVar.f2281g = b0.c(32);
        bVar.f2279e = b0.c(100);
        bVar.f2282h = b0.c(100);
        bVar.f2283i = f.P(2020, 1, 1);
        return bVar.a();
    }

    public final List<d> i() {
        f.b.b.b.a<Object> aVar = c.c;
        f.b.a.c.b.o.b.y(4, "initialCapacity");
        Object[] objArr = new Object[4];
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (i2 < 14) {
            byte[] bArr = new byte[16];
            this.f358i.nextBytes(bArr);
            d.a f2 = d.f();
            f2.c(bArr);
            f2.e(i2 % 7);
            f2.b(2650847);
            d a2 = f2.a();
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
        return this.f358i.nextDouble() < d2;
    }
}
