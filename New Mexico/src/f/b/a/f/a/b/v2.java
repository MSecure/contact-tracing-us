package f.b.a.f.a.b;

import f.b.a.f.a.e.r;
import java.io.File;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class v2 {
    public final d0 a;
    public final r<v3> b;
    public final s1 c;

    /* renamed from: d */
    public final r<Executor> f3326d;

    /* renamed from: e */
    public final d1 f3327e;

    public v2(d0 d0Var, r<v3> rVar, s1 s1Var, r<Executor> rVar2, d1 d1Var) {
        this.a = d0Var;
        this.b = rVar;
        this.c = s1Var;
        this.f3326d = rVar2;
        this.f3327e = d1Var;
    }

    public final void a(t2 t2Var) {
        File n = this.a.n(t2Var.b, t2Var.c, t2Var.f3316e);
        if (n.exists()) {
            File n2 = this.a.n(t2Var.b, t2Var.f3315d, t2Var.f3316e);
            n2.mkdirs();
            if (n.renameTo(n2)) {
                this.f3326d.a().execute(new Runnable(t2Var) { // from class: f.b.a.f.a.b.u2
                    public final /* synthetic */ t2 c;

                    {
                        this.c = r2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        v2 v2Var = v2.this;
                        t2 t2Var2 = this.c;
                        v2Var.a.b(t2Var2.b, t2Var2.f3315d, t2Var2.f3316e);
                    }
                });
                s1 s1Var = this.c;
                s1Var.b(new k1(s1Var, t2Var.b, t2Var.f3315d, t2Var.f3316e));
                this.f3327e.a(t2Var.b);
                this.b.a().e(t2Var.a, t2Var.b);
                return;
            }
            throw new z0(String.format("Cannot promote pack %s from %s to %s", t2Var.b, n.getAbsolutePath(), n2.getAbsolutePath()), t2Var.a);
        }
        throw new z0(String.format("Cannot find pack files to promote for pack %s at %s", t2Var.b, n.getAbsolutePath()), t2Var.a);
    }
}
