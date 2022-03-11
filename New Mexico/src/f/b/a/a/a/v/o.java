package f.b.a.a.a.v;

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
public abstract class o extends l implements b {
    public ContextWrapper Y;
    public volatile g Z;
    public final Object a0 = new Object();
    public boolean b0 = false;

    @Override // e.o.a.m
    public void O(Activity activity) {
        boolean z = true;
        this.D = true;
        ContextWrapper contextWrapper = this.Y;
        if (!(contextWrapper == null || g.b(contextWrapper) == activity)) {
            z = false;
        }
        d.b(z, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        Q0();
        R0();
    }

    @Override // e.o.a.m
    public void P(Context context) {
        super.P(context);
        Q0();
        R0();
    }

    public final void Q0() {
        if (this.Y == null) {
            this.Y = new ViewComponentManager$FragmentContextWrapper(super.k(), this);
        }
    }

    public void R0() {
        if (!this.b0) {
            this.b0 = true;
            ((s) e()).x((r) this);
        }
    }

    @Override // e.o.a.m
    public LayoutInflater Z(Bundle bundle) {
        return LayoutInflater.from(new ViewComponentManager$FragmentContextWrapper(u(), this));
    }

    @Override // g.b.b.b
    public final Object e() {
        if (this.Z == null) {
            synchronized (this.a0) {
                if (this.Z == null) {
                    this.Z = new g(this);
                }
            }
        }
        return this.Z.e();
    }

    @Override // e.o.a.m
    public Context k() {
        if (super.k() == null && this.Y == null) {
            return null;
        }
        Q0();
        return this.Y;
    }

    @Override // e.o.a.m, e.r.g
    public f0.b l() {
        return f.b.a.c.b.o.b.G0(this, super.l());
    }
}
