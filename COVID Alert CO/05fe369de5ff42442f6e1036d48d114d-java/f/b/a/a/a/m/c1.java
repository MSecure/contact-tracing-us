package f.b.a.a.a.m;

import android.os.Bundle;
import com.google.android.apps.exposurenotification.home.ExposureNotificationActivity;
import e.p.f0;
import g.b.a.c.c.a;
import g.b.b.b;

public abstract class c1 extends y0 implements b {
    public volatile a t;
    public final Object u = new Object();

    @Override // g.b.b.b
    public final Object e() {
        if (this.t == null) {
            synchronized (this.u) {
                if (this.t == null) {
                    this.t = new a(this);
                }
            }
        }
        return this.t.e();
    }

    @Override // androidx.activity.ComponentActivity, e.p.g
    public f0.b l() {
        f0.b D0 = f.b.a.c.b.o.b.D0(((g.b.a.c.b.a) f.b.a.c.b.o.b.t0(this, g.b.a.c.b.a.class)).a());
        if (D0 != null) {
            return D0;
        }
        return super.l();
    }

    @Override // f.b.a.a.a.m.y0, androidx.activity.ComponentActivity, e.m.a.r, e.i.a.h
    public void onCreate(Bundle bundle) {
        ((a1) e()).c((ExposureNotificationActivity) this);
        super.onCreate(bundle);
    }
}
