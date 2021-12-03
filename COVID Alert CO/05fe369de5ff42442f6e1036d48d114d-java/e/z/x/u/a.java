package e.z.x.u;

import androidx.work.impl.workers.ConstraintTrackingWorker;
import f.b.b.f.a.u;

public class a implements Runnable {
    public final /* synthetic */ u b;
    public final /* synthetic */ ConstraintTrackingWorker c;

    public a(ConstraintTrackingWorker constraintTrackingWorker, u uVar) {
        this.c = constraintTrackingWorker;
        this.b = uVar;
    }

    public void run() {
        synchronized (this.c.f318f) {
            if (this.c.f319g) {
                this.c.h();
            } else {
                this.c.f320h.l(this.b);
            }
        }
    }
}
