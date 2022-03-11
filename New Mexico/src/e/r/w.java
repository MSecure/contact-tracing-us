package e.r;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import e.r.h;
/* loaded from: classes.dex */
public class w extends d {
    public final /* synthetic */ v this$0;

    /* loaded from: classes.dex */
    public class a extends d {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            w.this.this$0.b();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            w.this.this$0.e();
        }
    }

    public w(v vVar) {
        this.this$0 = vVar;
    }

    @Override // e.r.d, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 29) {
            int i2 = x.c;
            ((x) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag")).b = this.this$0.f1906i;
        }
    }

    @Override // e.r.d, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        v vVar = this.this$0;
        int i2 = vVar.c - 1;
        vVar.c = i2;
        if (i2 == 0) {
            vVar.f1903f.postDelayed(vVar.f1905h, 700);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        activity.registerActivityLifecycleCallbacks(new a());
    }

    @Override // e.r.d, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        v vVar = this.this$0;
        int i2 = vVar.b - 1;
        vVar.b = i2;
        if (i2 == 0 && vVar.f1901d) {
            vVar.f1904g.e(h.a.ON_STOP);
            vVar.f1902e = true;
        }
    }
}
