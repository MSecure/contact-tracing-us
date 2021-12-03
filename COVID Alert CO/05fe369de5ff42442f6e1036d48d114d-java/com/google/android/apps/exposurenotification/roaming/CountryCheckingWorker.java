package com.google.android.apps.exposurenotification.roaming;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import f.b.a.a.a.d0.m;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.p.r;
import f.b.a.a.a.y.b;
import f.b.a.a.a.y.d;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;

public class CountryCheckingWorker extends ListenableWorker {

    /* renamed from: i  reason: collision with root package name */
    public static final a f435i = a.e("CountryCheckingWorker");

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f436e;

    /* renamed from: f  reason: collision with root package name */
    public final d f437f;

    /* renamed from: g  reason: collision with root package name */
    public final m f438g;

    /* renamed from: h  reason: collision with root package name */
    public final r f439h;

    public CountryCheckingWorker(Context context, WorkerParameters workerParameters, ExecutorService executorService, d dVar, m mVar, r rVar) {
        super(context, workerParameters);
        this.f436e = executorService;
        this.f437f = dVar;
        this.f438g = mVar;
        this.f439h = rVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        l z = l.x(this.f438g.b()).z(new b(this), this.f436e);
        f.b.a.a.a.y.a aVar = new f.b.a.a.a.y.a(this);
        ExecutorService executorService = this.f436e;
        a.b bVar = new a.b(z, Exception.class, aVar);
        ((l.a) z).a(bVar, f.b.a.c.b.o.b.g1(executorService, bVar));
        return bVar;
    }
}
