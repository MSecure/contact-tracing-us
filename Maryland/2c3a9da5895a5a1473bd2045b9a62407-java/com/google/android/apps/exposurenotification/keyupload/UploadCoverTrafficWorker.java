package com.google.android.apps.exposurenotification.keyupload;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import f.b.a.a.a.n.o;
import f.b.a.a.a.n.p;
import f.b.a.a.a.n.v;
import f.b.a.a.a.q.a;
import f.b.a.a.a.q.d;
import f.b.a.a.a.z.m;
import f.b.a.c.b.o.b;
import f.b.b.b.b;
import f.b.b.b.c;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import f.b.b.f.a.x;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public final class UploadCoverTrafficWorker extends ListenableWorker {

    /* renamed from: k  reason: collision with root package name */
    public static final TimeUnit f354k = TimeUnit.HOURS;

    /* renamed from: e  reason: collision with root package name */
    public final v f355e;

    /* renamed from: f  reason: collision with root package name */
    public final ExecutorService f356f;

    /* renamed from: g  reason: collision with root package name */
    public final ExecutorService f357g;

    /* renamed from: h  reason: collision with root package name */
    public final x f358h;

    /* renamed from: i  reason: collision with root package name */
    public final SecureRandom f359i;

    /* renamed from: j  reason: collision with root package name */
    public final m f360j;

    public UploadCoverTrafficWorker(Context context, WorkerParameters workerParameters, v vVar, ExecutorService executorService, ExecutorService executorService2, x xVar, SecureRandom secureRandom, m mVar) {
        super(context, workerParameters);
        this.f355e = vVar;
        this.f356f = executorService;
        this.f357g = executorService2;
        this.f358h = xVar;
        this.f359i = secureRandom;
        this.f360j = mVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        if (!(this.f359i.nextDouble() < 0.08333333333333333d)) {
            return b.d1(new ListenableWorker.a.c());
        }
        l y = l.x(this.f360j.a()).z(new o(this), this.f357g).y(p.a, this.f357g);
        f.b.a.a.a.n.m mVar = f.b.a.a.a.n.m.a;
        ExecutorService executorService = this.f357g;
        a.b bVar = new a.b(y, Throwable.class, mVar);
        ((l.a) y).a(bVar, b.z1(executorService, bVar));
        return bVar;
    }

    public final List<d> g() {
        f.b.b.b.a<Object> aVar = c.c;
        b.z(4, "initialCapacity");
        Object[] objArr = new Object[4];
        int i2 = 0;
        int i3 = 0;
        while (i2 < 14) {
            byte[] bArr = new byte[16];
            this.f359i.nextBytes(bArr);
            f.b.b.c.a aVar2 = d.a;
            a.b bVar = new a.b();
            bVar.b(144);
            bVar.c(1);
            bVar.a = new d.b(bArr);
            bVar.c(i2 % 7);
            bVar.b = 2650847;
            d a = bVar.a();
            int i4 = i3 + 1;
            if (objArr.length < i4) {
                objArr = Arrays.copyOf(objArr, b.AbstractC0104b.b(objArr.length, i4));
            }
            objArr[i3] = a;
            i2++;
            i3 = i4;
        }
        return c.p(objArr, i3);
    }
}
