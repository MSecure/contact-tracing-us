package e.c0.a0.u;

import androidx.work.impl.workers.ConstraintTrackingWorker;
import f.b.b.f.a.u;
/* loaded from: classes.dex */
public class a implements Runnable {
    public final /* synthetic */ u b;
    public final /* synthetic */ ConstraintTrackingWorker c;

    public a(ConstraintTrackingWorker constraintTrackingWorker, u uVar) {
        this.c = constraintTrackingWorker;
        this.b = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.c.f322h) {
            if (this.c.f323i) {
                this.c.h();
            } else {
                this.c.f324j.l(this.b);
            }
        }
    }
}
