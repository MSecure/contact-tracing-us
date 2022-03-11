package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import e.c0.a0.l;
import e.c0.a0.q.c;
import e.c0.a0.q.d;
import e.c0.a0.s.o;
import e.c0.a0.s.q;
import e.c0.n;
import f.b.b.f.a.u;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class ConstraintTrackingWorker extends ListenableWorker implements c {

    /* renamed from: l */
    public static final String f320l = n.e("ConstraintTrkngWrkr");

    /* renamed from: g */
    public WorkerParameters f321g;

    /* renamed from: h */
    public final Object f322h = new Object();

    /* renamed from: i */
    public volatile boolean f323i = false;

    /* renamed from: j */
    public e.c0.a0.t.s.c<ListenableWorker.a> f324j = new e.c0.a0.t.s.c<>();

    /* renamed from: k */
    public ListenableWorker f325k;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
            ConstraintTrackingWorker.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            ConstraintTrackingWorker constraintTrackingWorker = ConstraintTrackingWorker.this;
            Object obj = constraintTrackingWorker.c.b.a.get("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
            String str = obj instanceof String ? (String) obj : null;
            if (TextUtils.isEmpty(str)) {
                n.c().b(ConstraintTrackingWorker.f320l, "No worker to delegate to.", new Throwable[0]);
            } else {
                ListenableWorker b = constraintTrackingWorker.c.f303d.b(constraintTrackingWorker.b, str, constraintTrackingWorker.f321g);
                constraintTrackingWorker.f325k = b;
                if (b == null) {
                    n.c().a(ConstraintTrackingWorker.f320l, "No worker to delegate to.", new Throwable[0]);
                } else {
                    o i2 = ((q) l.h(constraintTrackingWorker.b).c.r()).i(constraintTrackingWorker.c.a.toString());
                    if (i2 != null) {
                        Context context = constraintTrackingWorker.b;
                        d dVar = new d(context, l.h(context).f1106d, constraintTrackingWorker);
                        dVar.b(Collections.singletonList(i2));
                        if (dVar.a(constraintTrackingWorker.c.a.toString())) {
                            n.c().a(ConstraintTrackingWorker.f320l, String.format("Constraints met for delegate %s", str), new Throwable[0]);
                            try {
                                u<ListenableWorker.a> d2 = constraintTrackingWorker.f325k.d();
                                d2.a(new e.c0.a0.u.a(constraintTrackingWorker, d2), constraintTrackingWorker.c.c);
                                return;
                            } catch (Throwable th) {
                                n c = n.c();
                                String str2 = ConstraintTrackingWorker.f320l;
                                c.a(str2, String.format("Delegated worker %s threw exception in startWork.", str), th);
                                synchronized (constraintTrackingWorker.f322h) {
                                    try {
                                        if (constraintTrackingWorker.f323i) {
                                            n.c().a(str2, "Constraints were unmet, Retrying.", new Throwable[0]);
                                            constraintTrackingWorker.h();
                                        } else {
                                            constraintTrackingWorker.g();
                                        }
                                        return;
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                            }
                        } else {
                            n.c().a(ConstraintTrackingWorker.f320l, String.format("Constraints not met for delegate %s. Requesting retry.", str), new Throwable[0]);
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
        this.f321g = workerParameters;
    }

    @Override // androidx.work.ListenableWorker
    public boolean a() {
        ListenableWorker listenableWorker = this.f325k;
        return listenableWorker != null && listenableWorker.a();
    }

    @Override // androidx.work.ListenableWorker
    public void b() {
        ListenableWorker listenableWorker = this.f325k;
        if (listenableWorker != null && !listenableWorker.f299d) {
            this.f325k.f();
        }
    }

    @Override // e.c0.a0.q.c
    public void c(List<String> list) {
    }

    @Override // androidx.work.ListenableWorker
    public u<ListenableWorker.a> d() {
        this.c.c.execute(new a());
        return this.f324j;
    }

    @Override // e.c0.a0.q.c
    public void e(List<String> list) {
        n.c().a(f320l, String.format("Constraints changed for %s", list), new Throwable[0]);
        synchronized (this.f322h) {
            this.f323i = true;
        }
    }

    public void g() {
        this.f324j.j(new ListenableWorker.a.C0003a());
    }

    public void h() {
        this.f324j.j(new ListenableWorker.a.b());
    }
}
