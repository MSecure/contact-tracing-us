package e.p;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import e.p.h;

public class w extends d {
    public final /* synthetic */ v this$0;

    public class a extends d {
        public a() {
        }

        public void onActivityPostResumed(Activity activity) {
            w.this.this$0.b();
        }

        public void onActivityPostStarted(Activity activity) {
            w.this.this$0.e();
        }
    }

    public w(v vVar) {
        this.this$0 = vVar;
    }

    @Override // e.p.d
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 29) {
            int i2 = x.c;
            ((x) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag")).b = this.this$0.f1546i;
        }
    }

    @Override // e.p.d
    public void onActivityPaused(Activity activity) {
        v vVar = this.this$0;
        int i2 = vVar.c - 1;
        vVar.c = i2;
        if (i2 == 0) {
            vVar.f1543f.postDelayed(vVar.f1545h, 700);
        }
    }

    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        activity.registerActivityLifecycleCallbacks(new a());
    }

    @Override // e.p.d
    public void onActivityStopped(Activity activity) {
        v vVar = this.this$0;
        int i2 = vVar.b - 1;
        vVar.b = i2;
        if (i2 == 0 && vVar.f1541d) {
            vVar.f1544g.e(h.a.ON_STOP);
            vVar.f1542e = true;
        }
    }
}
