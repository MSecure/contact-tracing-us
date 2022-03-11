package f.b.a.a.a.v;

import android.os.Bundle;
import com.google.android.apps.exposurenotification.settings.ExposureAboutActivity;
import e.b.a.j;
import e.p.b0;
import g.a.a.b.c.a;
import g.a.b.b;

public abstract class m0 extends j implements b {
    public volatile a p;
    public final Object q = new Object();

    @Override // g.a.b.b
    public final Object d() {
        if (this.p == null) {
            synchronized (this.q) {
                if (this.p == null) {
                    this.p = new a(this);
                }
            }
        }
        return this.p.d();
    }

    @Override // androidx.activity.ComponentActivity, e.p.f
    public b0.b k() {
        b0.b I0 = f.b.a.c.b.o.b.I0(this);
        return I0 != null ? I0 : super.k();
    }

    @Override // androidx.activity.ComponentActivity, e.m.a.o, e.i.a.f
    public void onCreate(Bundle bundle) {
        ((j0) d()).d((ExposureAboutActivity) this);
        super.onCreate(bundle);
    }
}
