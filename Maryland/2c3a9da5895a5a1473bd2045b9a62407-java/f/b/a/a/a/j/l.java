package f.b.a.a.a.j;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import e.p.b0;
import g.a.a.c.c.e;
import g.a.a.c.c.f;
import g.a.b.b;

public abstract class l extends j implements b {
    public ContextWrapper Z;
    public volatile e a0;
    public final Object b0 = new Object();

    public final void E0() {
        if (this.Z == null) {
            this.Z = new f(super.k(), this);
            ((o) e()).a((n) this);
        }
    }

    @Override // e.m.a.l
    public void J(Activity activity) {
        boolean z = true;
        this.D = true;
        ContextWrapper contextWrapper = this.Z;
        if (!(contextWrapper == null || e.b(contextWrapper) == activity)) {
            z = false;
        }
        f.b.a.c.b.o.b.I(z, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        E0();
    }

    @Override // e.m.a.l
    public void K(Context context) {
        super.K(context);
        E0();
    }

    @Override // e.m.a.l
    public LayoutInflater T(Bundle bundle) {
        return LayoutInflater.from(new f(r(), this));
    }

    @Override // g.a.b.b
    public final Object e() {
        if (this.a0 == null) {
            synchronized (this.b0) {
                if (this.a0 == null) {
                    this.a0 = new e(this);
                }
            }
        }
        return this.a0.e();
    }

    @Override // e.m.a.l
    public Context k() {
        return this.Z;
    }

    @Override // e.p.f, e.m.a.l
    public b0.b l() {
        b0.b R0 = f.b.a.c.b.o.b.R0(this);
        return R0 != null ? R0 : super.l();
    }
}
