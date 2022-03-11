package f.b.a.a.a.f0;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper;
import e.r.f0;
import g.b.a.c.c.d;
import g.b.a.c.c.g;
import g.b.b.b;
/* loaded from: classes.dex */
public abstract class j0 extends f0 implements b {
    public ContextWrapper c0;
    public volatile g d0;
    public final Object e0 = new Object();
    public boolean f0 = false;

    @Override // e.o.a.m
    public void O(Activity activity) {
        boolean z = true;
        this.D = true;
        ContextWrapper contextWrapper = this.c0;
        if (!(contextWrapper == null || g.b(contextWrapper) == activity)) {
            z = false;
        }
        d.b(z, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        O0();
        P0();
    }

    public final void O0() {
        if (this.c0 == null) {
            this.c0 = new ViewComponentManager$FragmentContextWrapper(super.k(), this);
        }
    }

    @Override // e.o.a.m
    public void P(Context context) {
        super.P(context);
        O0();
        P0();
    }

    public void P0() {
        if (!this.f0) {
            this.f0 = true;
            ((r0) e()).D((q0) this);
        }
    }

    @Override // e.o.a.m
    public LayoutInflater Z(Bundle bundle) {
        return LayoutInflater.from(new ViewComponentManager$FragmentContextWrapper(u(), this));
    }

    @Override // g.b.b.b
    public final Object e() {
        if (this.d0 == null) {
            synchronized (this.e0) {
                if (this.d0 == null) {
                    this.d0 = new g(this);
                }
            }
        }
        return this.d0.e();
    }

    @Override // e.o.a.m
    public Context k() {
        if (super.k() == null && this.c0 == null) {
            return null;
        }
        O0();
        return this.c0;
    }

    @Override // e.o.a.m, e.r.g
    public f0.b l() {
        return f.b.a.c.b.o.b.G0(this, super.l());
    }
}
