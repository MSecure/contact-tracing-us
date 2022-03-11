package f.b.a.a.a.e0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper;
import g.b.a.c.c.d;
import g.b.a.c.c.g;
/* loaded from: classes.dex */
public abstract class w5 extends e6 {
    public ContextWrapper i0;
    public boolean j0 = false;

    private void J0() {
        if (this.i0 == null) {
            this.i0 = new ViewComponentManager$FragmentContextWrapper(super.k(), this);
        }
    }

    @Override // f.b.a.a.a.e0.q5
    public void K0() {
        if (!this.j0) {
            this.j0 = true;
            ((u6) e()).k((t6) this);
        }
    }

    @Override // f.b.a.a.a.e0.q5, e.o.a.m
    public void O(Activity activity) {
        super.O(activity);
        ContextWrapper contextWrapper = this.i0;
        d.b(contextWrapper == null || g.b(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        J0();
        K0();
    }

    @Override // f.b.a.a.a.e0.q5, e.o.a.m
    public void P(Context context) {
        super.P(context);
        J0();
        K0();
    }

    @Override // f.b.a.a.a.e0.q5, e.o.a.m
    public LayoutInflater Z(Bundle bundle) {
        return LayoutInflater.from(new ViewComponentManager$FragmentContextWrapper(LayoutInflater.from(new ViewComponentManager$FragmentContextWrapper(u(), this)), this));
    }

    @Override // f.b.a.a.a.e0.q5, e.o.a.m
    public Context k() {
        if (super.k() == null && this.i0 == null) {
            return null;
        }
        J0();
        return this.i0;
    }
}
