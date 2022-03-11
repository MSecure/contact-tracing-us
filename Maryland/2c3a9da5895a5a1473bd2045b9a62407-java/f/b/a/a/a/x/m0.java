package f.b.a.a.a.x;

import android.os.Bundle;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsActivity;
import e.b.a.j;
import e.p.b0;
import g.a.a.c.c.a;
import g.a.b.b;

public abstract class m0 extends j implements b {
    public volatile a q;
    public final Object r = new Object();

    @Override // g.a.b.b
    public final Object e() {
        if (this.q == null) {
            synchronized (this.r) {
                if (this.q == null) {
                    this.q = new a(this);
                }
            }
        }
        return this.q.e();
    }

    @Override // androidx.activity.ComponentActivity, e.p.f
    public b0.b l() {
        b0.b I0 = f.b.a.c.b.o.b.I0(this);
        return I0 != null ? I0 : super.l();
    }

    @Override // androidx.activity.ComponentActivity, e.m.a.r, e.i.a.h
    public void onCreate(Bundle bundle) {
        ((p0) e()).c((PrivateAnalyticsActivity) this);
        super.onCreate(bundle);
    }
}
