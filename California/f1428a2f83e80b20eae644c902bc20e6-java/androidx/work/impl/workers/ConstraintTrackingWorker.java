package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import e.b0.l;
import e.b0.x.q.c;
import e.b0.x.q.d;
import e.b0.x.s.o;
import e.b0.x.s.q;
import f.b.b.f.a.u;
import java.util.Collections;
import java.util.List;

public class ConstraintTrackingWorker extends ListenableWorker implements c {

    /* renamed from: j  reason: collision with root package name */
    public static final String f320j = l.e("ConstraintTrkngWrkr");

    /* renamed from: e  reason: collision with root package name */
    public WorkerParameters f321e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f322f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public volatile boolean f323g = false;

    /* renamed from: h  reason: collision with root package name */
    public e.b0.x.t.p.c<ListenableWorker.a> f324h = new e.b0.x.t.p.c<>();

    /* renamed from: i  reason: collision with root package name */
    public ListenableWorker f325i;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ConstraintTrackingWorker constraintTrackingWorker = ConstraintTrackingWorker.this;
            Object obj = constraintTrackingWorker.c.b.a.get("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
            String str = obj instanceof String ? (String) obj : null;
            if (TextUtils.isEmpty(str)) {
                l.c().b(ConstraintTrackingWorker.f320j, "No worker to delegate to.", new Throwable[0]);
            } else {
                ListenableWorker b2 = constraintTrackingWorker.c.f304d.b(constraintTrackingWorker.b, str, constraintTrackingWorker.f321e);
                constraintTrackingWorker.f325i = b2;
                if (b2 == null) {
                    l.c().a(ConstraintTrackingWorker.f320j, "No worker to delegate to.", new Throwable[0]);
                } else {
                    o i2 = ((q) e.b0.x.l.d(constraintTrackingWorker.b).c.r()).i(constraintTrackingWorker.c.a.toString());
                    if (i2 != null) {
                        Context context = constraintTrackingWorker.b;
                        d dVar = new d(context, e.b0.x.l.d(context).f1029d, constraintTrackingWorker);
                        dVar.b(Collections.singletonList(i2));
                        if (dVar.a(constraintTrackingWorker.c.a.toString())) {
                            l.c().a(ConstraintTrackingWorker.f320j, String.format("Constraints met for delegate %s", str), new Throwable[0]);
                            try {
                                u<ListenableWorker.a> d2 = constraintTrackingWorker.f325i.d();
                                d2.a(new e.b0.x.u.a(constraintTrackingWorker, d2), constraintTrackingWorker.c.c);
                                return;
                            } catch (Throwable th) {
                                l c = l.c();
                                String str2 = ConstraintTrackingWorker.f320j;
                                c.a(str2, String.format("Delegated worker %s threw exception in startWork.", str), th);
                                synchronized (constraintTrackingWorker.f322f) {
                                    if (constraintTrackingWorker.f323g) {
                                        l.c().a(str2, "Constraints were unmet, Retrying.", new Throwable[0]);
                                        constraintTrackingWorker.h();
                                    } else {
                                        constraintTrackingWorker.g();
                                    }
                                    return;
                                }
                            }
                        } else {
                            l.c().a(ConstraintTrackingWorker.f320j, String.format("Constraints not met for delegate %s. Requesting retry.", str), new Throwable[0]);
                            constraintTrackingWorker.h();
                            return;
                        }
                    }
                }
            }
            constraintTrackingWorker.g();
        }
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f321e = workerParameters;
    }

    @Override // androidx.work.ListenableWorker
    public boolean a() {
        ListenableWorker listenableWorker = this.f325i;
        return listenableWorker != null && listenableWorker.a();
    }

    @Override // androidx.work.ListenableWorker
    public void b() {
        ListenableWorker listenableWorker = this.f325i;
        if (listenableWorker != null) {
            listenableWorker.f();
        }
    }

    @Override // e.b0.x.q.c
    public void c(List<String> list) {
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        this.c.c.execute(new a());
        return this.f324h;
    }

    @Override // e.b0.x.q.c
    public void e(List<String> list) {
        l.c().a(f320j, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.f322f) {
            this.f323g = true;
        }
    }

    public void g() {
        this.f324h.j(new ListenableWorker.a.C0002a());
    }

    public void h() {
        this.f324h.j(new ListenableWorker.a.b());
    }
}
