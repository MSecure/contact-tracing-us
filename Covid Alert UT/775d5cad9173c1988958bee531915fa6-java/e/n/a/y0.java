package e.n.a;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import e.q.f0;
import e.q.g;
import e.q.g0;
import e.q.h;
import e.q.h0;
import e.q.m;
import e.q.z;
import e.v.a;
import e.v.b;
import e.v.c;

public class y0 implements g, c, h0 {
    public final m b;
    public final g0 c;

    /* renamed from: d  reason: collision with root package name */
    public f0.b f1801d;

    /* renamed from: e  reason: collision with root package name */
    public m f1802e = null;

    /* renamed from: f  reason: collision with root package name */
    public b f1803f = null;

    public y0(m mVar, g0 g0Var) {
        this.b = mVar;
        this.c = g0Var;
    }

    @Override // e.q.l
    public h a() {
        e();
        return this.f1802e;
    }

    public void b(h.a aVar) {
        m mVar = this.f1802e;
        mVar.d("handleLifecycleEvent");
        mVar.g(aVar.a());
    }

    @Override // e.v.c
    public a d() {
        e();
        return this.f1803f.b;
    }

    public void e() {
        if (this.f1802e == null) {
            this.f1802e = new m(this);
            this.f1803f = new b(this);
        }
    }

    @Override // e.q.h0
    public g0 i() {
        e();
        return this.c;
    }

    @Override // e.q.g
    public f0.b l() {
        f0.b l2 = this.b.l();
        if (!l2.equals(this.b.R)) {
            this.f1801d = l2;
            return l2;
        }
        if (this.f1801d == null) {
            Application application = null;
            Context applicationContext = this.b.t0().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    break;
                } else if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                } else {
                    applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                }
            }
            this.f1801d = new z(application, this, this.b.f1727g);
        }
        return this.f1801d;
    }
}
