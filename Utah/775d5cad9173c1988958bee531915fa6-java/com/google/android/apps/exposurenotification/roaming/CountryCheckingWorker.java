package com.google.android.apps.exposurenotification.roaming;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import f.b.a.a.a.i0.b;
import f.b.a.a.a.i0.c;
import f.b.a.a.a.n0.m;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.z.r;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;

public class CountryCheckingWorker extends ListenableWorker {

    /* renamed from: k  reason: collision with root package name */
    public static final a f431k = a.e("CountryCheckingWorker");

    /* renamed from: g  reason: collision with root package name */
    public final ExecutorService f432g;

    /* renamed from: h  reason: collision with root package name */
    public final c f433h;

    /* renamed from: i  reason: collision with root package name */
    public final m f434i;

    /* renamed from: j  reason: collision with root package name */
    public final r f435j;

    public CountryCheckingWorker(Context context, WorkerParameters workerParameters, ExecutorService executorService, c cVar, m mVar, r rVar) {
        super(context, workerParameters);
        this.f432g = executorService;
        this.f433h = cVar;
        this.f434i = mVar;
        this.f435j = rVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        l z = l.x(this.f434i.b()).z(new b(this), this.f432g);
        f.b.a.a.a.i0.a aVar = new f.b.a.a.a.i0.a(this);
        ExecutorService executorService = this.f432g;
        a.b bVar = new a.b(z, Exception.class, aVar);
        ((l.a) z).a(bVar, f.b.a.c.b.o.b.j1(executorService, bVar));
        return bVar;
    }
}
