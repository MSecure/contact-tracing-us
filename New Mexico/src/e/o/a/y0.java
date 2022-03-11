package e.o.a;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import e.r.f0;
import e.r.g;
import e.r.g0;
import e.r.h;
import e.r.h0;
import e.r.m;
import e.r.z;
import e.w.a;
import e.w.b;
import e.w.c;
/* loaded from: classes.dex */
public class y0 implements g, c, h0 {
    public final m b;
    public final g0 c;

    /* renamed from: d  reason: collision with root package name */
    public f0.b f1886d;

    /* renamed from: e  reason: collision with root package name */
    public m f1887e = null;

    /* renamed from: f  reason: collision with root package name */
    public b f1888f = null;

    public y0(m mVar, g0 g0Var) {
        this.b = mVar;
        this.c = g0Var;
    }

    @Override // e.r.l
    public h a() {
        e();
        return this.f1887e;
    }

    public void b(h.a aVar) {
        m mVar = this.f1887e;
        mVar.d("handleLifecycleEvent");
        mVar.g(aVar.a());
    }

    @Override // e.w.c
    public a d() {
        e();
        return this.f1888f.b;
    }

    public void e() {
        if (this.f1887e == null) {
            this.f1887e = new m(this);
            this.f1888f = new b(this);
        }
    }

    @Override // e.r.h0
    public g0 i() {
        e();
        return this.c;
    }

    @Override // e.r.g
    public f0.b l() {
        f0.b l2 = this.b.l();
        if (!l2.equals(this.b.R)) {
            this.f1886d = l2;
            return l2;
        }
        if (this.f1886d == null) {
            Application application = null;
            Context applicationContext = this.b.v0().getApplicationContext();
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
            this.f1886d = new z(application, this, this.b.f1812g);
        }
        return this.f1886d;
    }
}
