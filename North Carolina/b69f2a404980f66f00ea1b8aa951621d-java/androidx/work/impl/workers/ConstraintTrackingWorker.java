package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import b.z.m;
import b.z.y.k;
import b.z.y.p.c;
import b.z.y.p.d;
import b.z.y.r.p;
import b.z.y.r.r;
import c.b.b.e.a.u;
import java.util.Collections;
import java.util.List;

public class ConstraintTrackingWorker extends ListenableWorker implements c {
    public static final String g = m.e("ConstraintTrkngWrkr");

    /* renamed from: b  reason: collision with root package name */
    public WorkerParameters f351b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f352c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f353d = false;

    /* renamed from: e  reason: collision with root package name */
    public b.z.y.s.r.c<ListenableWorker.a> f354e = new b.z.y.s.r.c<>();
    public ListenableWorker f;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ConstraintTrackingWorker constraintTrackingWorker = ConstraintTrackingWorker.this;
            Object obj = constraintTrackingWorker.getInputData().f1913a.get("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
            String str = obj instanceof String ? (String) obj : null;
            if (TextUtils.isEmpty(str)) {
                m.c().b(ConstraintTrackingWorker.g, "No worker to delegate to.", new Throwable[0]);
            } else {
                ListenableWorker a2 = constraintTrackingWorker.getWorkerFactory().a(constraintTrackingWorker.getApplicationContext(), str, constraintTrackingWorker.f351b);
                constraintTrackingWorker.f = a2;
                if (a2 == null) {
                    m.c().a(ConstraintTrackingWorker.g, "No worker to delegate to.", new Throwable[0]);
                } else {
                    p i = ((r) k.b(constraintTrackingWorker.getApplicationContext()).f1971c.h()).i(constraintTrackingWorker.getId().toString());
                    if (i != null) {
                        d dVar = new d(constraintTrackingWorker.getApplicationContext(), constraintTrackingWorker.getTaskExecutor(), constraintTrackingWorker);
                        dVar.b(Collections.singletonList(i));
                        if (dVar.a(constraintTrackingWorker.getId().toString())) {
                            m.c().a(ConstraintTrackingWorker.g, String.format("Constraints met for delegate %s", str), new Throwable[0]);
                            try {
                                u<ListenableWorker.a> startWork = constraintTrackingWorker.f.startWork();
                                startWork.b(new b.z.y.t.a(constraintTrackingWorker, startWork), constraintTrackingWorker.getBackgroundExecutor());
                                return;
                            } catch (Throwable th) {
                                m.c().a(ConstraintTrackingWorker.g, String.format("Delegated worker %s threw exception in startWork.", str), th);
                                synchronized (constraintTrackingWorker.f352c) {
                                    if (constraintTrackingWorker.f353d) {
                                        m.c().a(ConstraintTrackingWorker.g, "Constraints were unmet, Retrying.", new Throwable[0]);
                                        constraintTrackingWorker.b();
                                    } else {
                                        constraintTrackingWorker.a();
                                    }
                                    return;
                                }
                            }
                        } else {
                            m.c().a(ConstraintTrackingWorker.g, String.format("Constraints not met for delegate %s. Requesting retry.", str), new Throwable[0]);
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
        this.f351b = workerParameters;
    }

    public void a() {
        this.f354e.k(new ListenableWorker.a.C0004a());
    }

    public void b() {
        this.f354e.k(new ListenableWorker.a.b());
    }

    @Override // b.z.y.p.c
    public void c(List<String> list) {
    }

    @Override // b.z.y.p.c
    public void e(List<String> list) {
        m.c().a(g, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.f352c) {
            this.f353d = true;
        }
    }

    @Override // androidx.work.ListenableWorker
    public b.z.y.s.s.a getTaskExecutor() {
        return k.b(getApplicationContext()).f1972d;
    }

    @Override // androidx.work.ListenableWorker
    public boolean isRunInForeground() {
        ListenableWorker listenableWorker = this.f;
        return listenableWorker != null && listenableWorker.isRunInForeground();
    }

    @Override // androidx.work.ListenableWorker
    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.f;
        if (listenableWorker != null && !listenableWorker.isStopped()) {
            this.f.stop();
        }
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> startWork() {
        getBackgroundExecutor().execute(new a());
        return this.f354e;
    }
}
