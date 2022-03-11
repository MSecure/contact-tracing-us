package com.google.android.apps.exposurenotification.nearby;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.ExposureInfoCleanupWorker;
import e.b.a.m;
import f.b.a.a.a.c0.a;
import f.b.a.a.a.c0.c;
import f.b.a.a.a.c0.o1;
import f.b.a.a.a.c0.q1;
import f.b.a.c.b.o.b;
import f.b.a.c.f.b.d;
import f.b.b.f.a.a;
import f.b.b.f.a.i;
import f.b.b.f.a.l;
import f.b.b.f.a.s;
import f.b.b.f.a.u;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes.dex */
public class ExposureInfoCleanupWorker extends ListenableWorker {

    /* renamed from: g */
    public final q1 f371g;

    /* renamed from: h */
    public final o1 f372h;

    /* renamed from: i */
    public final ExecutorService f373i;

    /* renamed from: j */
    public final ScheduledExecutorService f374j;

    public ExposureInfoCleanupWorker(Context context, WorkerParameters workerParameters, q1 q1Var, o1 o1Var, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        super(context, workerParameters);
        this.f371g = q1Var;
        this.f372h = o1Var;
        this.f373i = executorService;
        this.f374j = scheduledExecutorService;
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        l y = l.x(m.e.o0(this.f371g.b(), q1.f2205d, this.f374j)).z(new i() { // from class: f.b.a.a.a.c0.b
            @Override // f.b.b.f.a.i
            public final u a(Object obj) {
                ExposureInfoCleanupWorker exposureInfoCleanupWorker = ExposureInfoCleanupWorker.this;
                Set set = (Set) obj;
                Objects.requireNonNull(exposureInfoCleanupWorker);
                if (set.contains(d.EN_NOT_SUPPORT) || set.contains(d.NOT_IN_ALLOWLIST)) {
                    exposureInfoCleanupWorker.f372h.a();
                }
                return s.c;
            }
        }, this.f373i).y(c.a, this.f373i);
        a aVar = a.a;
        ExecutorService executorService = this.f373i;
        a.b bVar = new a.b(y, Exception.class, aVar);
        y.a(bVar, b.k1(executorService, bVar));
        return bVar;
    }
}
