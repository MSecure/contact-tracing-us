package com.google.android.apps.exposurenotification.roaming;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import f.b.a.a.a.m.p;
import f.b.a.a.a.u.a;
import f.b.a.a.a.u.b;
import f.b.a.a.a.u.d;
import f.b.a.a.a.x.l;
import f.b.b.f.a.a;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;

public class CountryCheckingWorker extends ListenableWorker {

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f393e;

    /* renamed from: f  reason: collision with root package name */
    public final d f394f;

    /* renamed from: g  reason: collision with root package name */
    public final l f395g;

    /* renamed from: h  reason: collision with root package name */
    public final p f396h;

    public CountryCheckingWorker(Context context, WorkerParameters workerParameters, ExecutorService executorService, d dVar, l lVar, p pVar) {
        super(context, workerParameters);
        this.f393e = executorService;
        this.f394f = dVar;
        this.f395g = lVar;
        this.f396h = pVar;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        f.b.b.f.a.l z = f.b.b.f.a.l.x(this.f395g.a()).z(new b(this), this.f393e);
        a aVar = new a(this);
        ExecutorService executorService = this.f393e;
        a.b bVar = new a.b(z, Exception.class, aVar);
        ((l.a) z).a(bVar, f.b.a.c.b.o.b.A1(executorService, bVar));
        return bVar;
    }
}
