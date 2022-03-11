package com.google.android.apps.exposurenotification.roaming;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.roaming.CountryCheckingWorker;
import e.x.a.f.f;
import f.b.a.a.a.h0.p;
import f.b.a.a.a.k0.c;
import f.b.a.a.a.n0.s;
import f.b.a.a.a.n0.v;
import f.b.a.a.a.p0.r;
import f.b.a.a.a.t.p0.a;
import f.b.a.c.b.o.b;
import f.b.b.a.g;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import l.b.a.d;
import l.b.a.e;
/* loaded from: classes.dex */
public class CountryCheckingWorker extends ListenableWorker {

    /* renamed from: k */
    public static final a f441k = a.e("CountryCheckingWorker");

    /* renamed from: g */
    public final ExecutorService f442g;

    /* renamed from: h */
    public final c f443h;

    /* renamed from: i */
    public final r f444i;

    /* renamed from: j */
    public final f.b.a.a.a.a0.r f445j;

    public CountryCheckingWorker(Context context, WorkerParameters workerParameters, ExecutorService executorService, c cVar, r rVar, f.b.a.a.a.a0.r rVar2) {
        super(context, workerParameters);
        this.f442g = executorService;
        this.f443h = cVar;
        this.f444i = rVar;
        this.f445j = rVar2;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        l z = l.x(this.f444i.b()).z(new i() { // from class: f.b.a.a.a.k0.b
            @Override // f.b.b.f.a.i
            public final u a(Object obj) {
                CountryCheckingWorker countryCheckingWorker = CountryCheckingWorker.this;
                f.b.a.a.a.a0.r rVar = countryCheckingWorker.f445j;
                p.d dVar = p.d.TASK_COUNTRY_CHECKING;
                rVar.i(dVar);
                if (((Boolean) obj).booleanValue()) {
                    countryCheckingWorker.f443h.a();
                }
                c cVar = countryCheckingWorker.f443h;
                v vVar = cVar.b;
                e w = cVar.c.c().w(d.f(14));
                f.b.a.a.a.n0.r rVar2 = vVar.a;
                long G = w.G();
                s sVar = (s) rVar2;
                sVar.a.b();
                f a = sVar.c.a();
                a.b.bindLong(1, G);
                sVar.a.c();
                try {
                    a.d();
                    sVar.a.l();
                    countryCheckingWorker.f445j.g(dVar);
                    return f.b.a.c.b.o.b.R0(new ListenableWorker.a.c());
                } finally {
                    sVar.a.g();
                    e.v.l lVar = sVar.c;
                    if (a == lVar.c) {
                        lVar.a.set(false);
                    }
                }
            }
        }, this.f442g);
        f.b.a.a.a.k0.a aVar = new g() { // from class: f.b.a.a.a.k0.a
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                CountryCheckingWorker countryCheckingWorker = CountryCheckingWorker.this;
                Exception exc = (Exception) obj;
                Objects.requireNonNull(countryCheckingWorker);
                CountryCheckingWorker.f441k.d("Failure to check country code", exc);
                countryCheckingWorker.f445j.k(p.d.TASK_COUNTRY_CHECKING, exc);
                return new ListenableWorker.a.C0003a();
            }
        };
        ExecutorService executorService = this.f442g;
        a.b bVar = new a.b(z, Exception.class, aVar);
        ((l.a) z).a(bVar, b.k1(executorService, bVar));
        return bVar;
    }
}
