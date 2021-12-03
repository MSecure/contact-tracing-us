package f.b.a.a.a.s;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import g.b.a.c.c.c;
import g.b.a.c.c.f;
import g.b.a.c.c.g;

public abstract class k5 extends r5 {
    public ContextWrapper e0;
    public boolean f0 = false;

    @Override // f.b.a.a.a.s.c5
    public void B0() {
        if (!this.f0) {
            this.f0 = true;
            ((n6) e()).A((m6) this);
        }
    }

    @Override // e.m.a.m, f.b.a.a.a.s.c5
    public void I(Activity activity) {
        super.I(activity);
        ContextWrapper contextWrapper = this.e0;
        c.b(contextWrapper == null || f.b(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        if (this.e0 == null) {
            this.e0 = new g(this.X, this);
            B0();
        }
    }

    @Override // e.m.a.m, f.b.a.a.a.s.c5
    public void J(Context context) {
        super.J(context);
        if (this.e0 == null) {
            this.e0 = new g(this.X, this);
            B0();
        }
    }

    @Override // e.m.a.m, f.b.a.a.a.s.c5
    public LayoutInflater T(Bundle bundle) {
        return LayoutInflater.from(new g(LayoutInflater.from(new g(r(), this)), this));
    }

    @Override // e.m.a.m, f.b.a.a.a.s.c5
    public Context j() {
        return this.e0;
    }
}
