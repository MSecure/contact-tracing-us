package com.google.android.apps.exposurenotification.keyupload;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import f.b.a.a.a.l.n;
import f.b.a.a.a.l.o;
import f.b.a.a.a.l.p;
import f.b.a.a.a.l.u;
import f.b.a.a.a.o.a;
import f.b.a.a.a.o.d;
import f.b.a.a.a.x.l;
import f.b.a.c.b.o.b;
import f.b.b.b.b;
import f.b.b.b.c;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public final class UploadCoverTrafficWorker extends ListenableWorker {

    /* renamed from: j  reason: collision with root package name */
    public static final TimeUnit f345j = TimeUnit.HOURS;

    /* renamed from: e  reason: collision with root package name */
    public final u f346e;

    /* renamed from: f  reason: collision with root package name */
    public final ExecutorService f347f;

    /* renamed from: g  reason: collision with root package name */
    public final ExecutorService f348g;

    /* renamed from: h  reason: collision with root package name */
    public final SecureRandom f349h;

    /* renamed from: i  reason: collision with root package name */
    public final l f350i;

    public UploadCoverTrafficWorker(Context context, WorkerParameters workerParameters, u uVar, ExecutorService executorService, ExecutorService executorService2, SecureRandom secureRandom, l lVar) {
        super(context, workerParameters);
        this.f346e = uVar;
        this.f347f = executorService;
        this.f348g = executorService2;
        this.f349h = secureRandom;
        this.f350i = lVar;
    }

    @Override // androidx.work.ListenableWorker
    public f.b.b.f.a.u<ListenableWorker.a> d() {
        if (!(this.f349h.nextDouble() < 0.08333333333333333d)) {
            return b.c1(new ListenableWorker.a.c());
        }
        f.b.b.f.a.l y = f.b.b.f.a.l.x(this.f350i.a()).z(new p(this), this.f348g).y(n.a, this.f348g);
        o oVar = o.a;
        ExecutorService executorService = this.f348g;
        a.b bVar = new a.b(y, Throwable.class, oVar);
        ((l.a) y).a(bVar, b.A1(executorService, bVar));
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
            this.f349h.nextBytes(bArr);
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
                objArr = Arrays.copyOf(objArr, b.AbstractC0100b.b(objArr.length, i4));
            }
            objArr[i3] = a;
            i2++;
            i3 = i4;
        }
        return c.p(objArr, i3);
    }
}
