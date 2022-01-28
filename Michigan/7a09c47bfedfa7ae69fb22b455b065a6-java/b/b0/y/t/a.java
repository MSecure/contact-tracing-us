package b.b0.y.t;

import androidx.work.impl.workers.ConstraintTrackingWorker;
import c.b.b.e.a.u;

public class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f1338b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ConstraintTrackingWorker f1339c;

    public a(ConstraintTrackingWorker constraintTrackingWorker, u uVar) {
        this.f1339c = constraintTrackingWorker;
        this.f1338b = uVar;
    }

    public void run() {
        synchronized (this.f1339c.f490c) {
            if (this.f1339c.f491d) {
                this.f1339c.b();
            } else {
                this.f1339c.f492e.m(this.f1338b);
            }
        }
    }
}
