package com.google.android.apps.exposurenotification.roaming;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import f.b.a.a.a.o.p;
import f.b.a.a.a.w.a;
import f.b.a.a.a.w.b;
import f.b.a.a.a.w.d;
import f.b.a.a.a.z.m;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;

public class CountryCheckingWorker extends ListenableWorker {

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f409e;

    /* renamed from: f  reason: collision with root package name */
    public final d f410f;

    /* renamed from: g  reason: collision with root package name */
    public final m f411g;

    /* renamed from: h  reason: collision with root package name */
    public final p f412h;

    public CountryCheckingWorker(Context context, WorkerParameters workerParameters, ExecutorService executorService, d dVar, m mVar, p pVar) {
        super(context, workerParameters);
        this.f409e = executorService;
        this.f410f = dVar;
        this.f411g = mVar;
        this.f412h = pVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        l z = l.x(this.f411g.a()).z(new b(this), this.f409e);
        a aVar = new a(this);
        ExecutorService executorService = this.f409e;
        a.b bVar = new a.b(z, Exception.class, aVar);
        ((l.a) z).a(bVar, f.b.a.c.b.o.b.z1(executorService, bVar));
        return bVar;
    }
}
