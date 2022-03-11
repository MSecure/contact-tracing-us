package e.j.a;

import android.app.Activity;
/* loaded from: classes.dex */
public class b implements Runnable {
    public final /* synthetic */ Activity b;

    public b(Activity activity) {
        this.b = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.b.isFinishing() && !e.b(this.b)) {
            this.b.recreate();
        }
    }
}
