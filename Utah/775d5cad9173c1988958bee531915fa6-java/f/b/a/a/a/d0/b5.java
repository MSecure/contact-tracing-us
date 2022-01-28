package f.b.a.a.a.d0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper;
import g.b.a.c.c.d;
import g.b.a.c.c.g;

public abstract class b5 extends q5 {
    public ContextWrapper f0;
    public boolean g0 = false;

    @Override // f.b.a.a.a.d0.c5
    private void G0() {
        if (this.f0 == null) {
            this.f0 = new ViewComponentManager$FragmentContextWrapper(super.j(), this);
        }
    }

    @Override // f.b.a.a.a.d0.c5
    public void H0() {
        if (!this.g0) {
            this.g0 = true;
            ((p5) e()).u((o5) this);
        }
    }

    @Override // f.b.a.a.a.d0.c5, e.n.a.m
    public void M(Activity activity) {
        super.M(activity);
        ContextWrapper contextWrapper = this.f0;
        d.b(contextWrapper == null || g.b(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        G0();
        H0();
    }

    @Override // f.b.a.a.a.d0.c5, e.n.a.m
    public void N(Context context) {
        super.N(context);
        G0();
        H0();
    }

    @Override // f.b.a.a.a.d0.c5, e.n.a.m
    public LayoutInflater X(Bundle bundle) {
        return LayoutInflater.from(new ViewComponentManager$FragmentContextWrapper(LayoutInflater.from(new ViewComponentManager$FragmentContextWrapper(t(), this)), this));
    }

    @Override // f.b.a.a.a.d0.c5, e.n.a.m
    public Context j() {
        if (super.j() == null && this.f0 == null) {
            return null;
        }
        G0();
        return this.f0;
    }
}
