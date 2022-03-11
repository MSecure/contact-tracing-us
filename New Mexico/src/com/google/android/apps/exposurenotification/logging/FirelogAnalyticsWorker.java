package com.google.android.apps.exposurenotification.logging;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.logging.FirelogAnalyticsWorker;
import f.b.a.a.a.a0.m;
import f.b.a.a.a.a0.n;
import f.b.a.a.a.a0.r;
import f.b.a.a.a.h0.p;
import f.b.a.c.b.o.b;
import f.b.b.a.g;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import l.b.a.d;
/* loaded from: classes.dex */
public class FirelogAnalyticsWorker extends ListenableWorker {

    /* renamed from: j */
    public static final d f367j = d.h(4).r(30);

    /* renamed from: g */
    public final r f368g;

    /* renamed from: h */
    public final f.b.a.a.a.p0.r f369h;

    /* renamed from: i */
    public final ExecutorService f370i;

    public FirelogAnalyticsWorker(Context context, WorkerParameters workerParameters, r rVar, f.b.a.a.a.p0.r rVar2, ExecutorService executorService) {
        super(context, workerParameters);
        this.f368g = rVar;
        this.f370i = executorService;
        this.f369h = rVar2;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        l x = l.x(this.f369h.b());
        r rVar = this.f368g;
        Objects.requireNonNull(rVar);
        l y = x.z(new i() { // from class: f.b.a.a.a.a0.q
            @Override // f.b.b.f.a.i
            public final u a(Object obj) {
                return r.this.b(((Boolean) obj).booleanValue());
            }
        }, this.f370i).y(new g() { // from class: f.b.a.a.a.a0.o
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                FirelogAnalyticsWorker.this.f368g.g(p.d.TASK_FIRELOG_ANALYTICS);
                return new ListenableWorker.a.c();
            }
        }, this.f370i);
        m mVar = new g() { // from class: f.b.a.a.a.a0.m
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                r.a aVar = (r.a) obj;
                FirelogAnalyticsWorker.this.f368g.h(p.d.TASK_FIRELOG_ANALYTICS);
                return new ListenableWorker.a.c();
            }
        };
        ExecutorService executorService = this.f370i;
        a.b bVar = new a.b(y, r.a.class, mVar);
        y.a(bVar, b.k1(executorService, bVar));
        n nVar = new g() { // from class: f.b.a.a.a.a0.n
            @Override // f.b.b.a.g
            public final Object a(Object obj) {
                FirelogAnalyticsWorker.this.f368g.k(p.d.TASK_FIRELOG_ANALYTICS, (Exception) obj);
                return new ListenableWorker.a.C0003a();
            }
        };
        ExecutorService executorService2 = this.f370i;
        a.b bVar2 = new a.b(bVar, Exception.class, nVar);
        bVar.a(bVar2, b.k1(executorService2, bVar2));
        return bVar2;
    }
}
