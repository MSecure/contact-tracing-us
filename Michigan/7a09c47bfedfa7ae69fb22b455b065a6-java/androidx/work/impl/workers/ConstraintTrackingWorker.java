package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import b.b0.m;
import b.b0.y.k;
import b.b0.y.p.c;
import b.b0.y.p.d;
import b.b0.y.r.p;
import b.b0.y.r.r;
import c.b.b.e.a.u;
import java.util.Collections;
import java.util.List;

public class ConstraintTrackingWorker extends ListenableWorker implements c {

    /* renamed from: g  reason: collision with root package name */
    public static final String f488g = m.e("ConstraintTrkngWrkr");

    /* renamed from: b  reason: collision with root package name */
    public WorkerParameters f489b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f490c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f491d = false;

    /* renamed from: e  reason: collision with root package name */
    public b.b0.y.s.r.c<ListenableWorker.a> f492e = new b.b0.y.s.r.c<>();

    /* renamed from: f  reason: collision with root package name */
    public ListenableWorker f493f;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ConstraintTrackingWorker constraintTrackingWorker = ConstraintTrackingWorker.this;
            Object obj = constraintTrackingWorker.getInputData().f1028a.get("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
            String str = obj instanceof String ? (String) obj : null;
            if (TextUtils.isEmpty(str)) {
                m.c().b(ConstraintTrackingWorker.f488g, "No worker to delegate to.", new Throwable[0]);
            } else {
                ListenableWorker b2 = constraintTrackingWorker.getWorkerFactory().b(constraintTrackingWorker.getApplicationContext(), str, constraintTrackingWorker.f489b);
                constraintTrackingWorker.f493f = b2;
                if (b2 == null) {
                    m.c().a(ConstraintTrackingWorker.f488g, "No worker to delegate to.", new Throwable[0]);
                } else {
                    p i = ((r) k.b(constraintTrackingWorker.getApplicationContext()).f1096c.h()).i(constraintTrackingWorker.getId().toString());
                    if (i != null) {
                        d dVar = new d(constraintTrackingWorker.getApplicationContext(), constraintTrackingWorker.getTaskExecutor(), constraintTrackingWorker);
                        dVar.b(Collections.singletonList(i));
                        if (dVar.a(constraintTrackingWorker.getId().toString())) {
                            m.c().a(ConstraintTrackingWorker.f488g, String.format("Constraints met for delegate %s", str), new Throwable[0]);
                            try {
                                u<ListenableWorker.a> startWork = constraintTrackingWorker.f493f.startWork();
                                startWork.b(new b.b0.y.t.a(constraintTrackingWorker, startWork), constraintTrackingWorker.getBackgroundExecutor());
                                return;
                            } catch (Throwable th) {
                                m.c().a(ConstraintTrackingWorker.f488g, String.format("Delegated worker %s threw exception in startWork.", str), th);
                                synchronized (constraintTrackingWorker.f490c) {
                                    if (constraintTrackingWorker.f491d) {
                                        m.c().a(ConstraintTrackingWorker.f488g, "Constraints were unmet, Retrying.", new Throwable[0]);
                                        constraintTrackingWorker.b();
                                    } else {
                                        constraintTrackingWorker.a();
                                    }
                                    return;
                                }
                            }
                        } else {
                            m.c().a(ConstraintTrackingWorker.f488g, String.format("Constraints not met for delegate %s. Requesting retry.", str), new Throwable[0]);
                            constraintTrackingWorker.b();
                            return;
                        }
                    }
                }
            }
            constraintTrackingWorker.a();
        }
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f489b = workerParameters;
    }

    public void a() {
        this.f492e.k(new ListenableWorker.a.C0005a());
    }

    public void b() {
        this.f492e.k(new ListenableWorker.a.b());
    }

    @Override // b.b0.y.p.c
    public void c(List<String> list) {
    }

    @Override // b.b0.y.p.c
    public void e(List<String> list) {
        m.c().a(f488g, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.f490c) {
            this.f491d = true;
        }
    }

    @Override // androidx.work.ListenableWorker
    public b.b0.y.s.s.a getTaskExecutor() {
        return k.b(getApplicationContext()).f1097d;
    }

    @Override // androidx.work.ListenableWorker
    public boolean isRunInForeground() {
        ListenableWorker listenableWorker = this.f493f;
        return listenableWorker != null && listenableWorker.isRunInForeground();
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.f493f;
        if (listenableWorker != null && !listenableWorker.isStopped()) {
            this.f493f.stop();
        }
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> startWork() {
        getBackgroundExecutor().execute(new a());
        return this.f492e;
    }
}
