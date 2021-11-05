package b.z.y.t;

import androidx.work.impl.workers.ConstraintTrackingWorker;
import c.b.b.e.a.u;

public class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f2187b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ConstraintTrackingWorker f2188c;

    public a(ConstraintTrackingWorker constraintTrackingWorker, u uVar) {
        this.f2188c = constraintTrackingWorker;
        this.f2187b = uVar;
    }

    public void run() {
        synchronized (this.f2188c.f352c) {
            if (this.f2188c.f353d) {
                this.f2188c.b();
            } else {
                this.f2188c.f354e.m(this.f2187b);
            }
        }
    }
}
