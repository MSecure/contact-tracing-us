package f.b.a.a.a.n0;

import e.v.l;
import e.x.a.f.f;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class e0 implements Callable<Void> {
    public final /* synthetic */ long a;
    public final /* synthetic */ d0 b;

    public e0(d0 d0Var, long j2) {
        this.b = d0Var;
        this.a = j2;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        f a = this.b.f2334d.a();
        a.b.bindLong(1, this.a);
        this.b.a.c();
        try {
            a.d();
            this.b.a.l();
        } finally {
            this.b.a.g();
            l lVar = this.b.f2334d;
            if (a == lVar.c) {
                lVar.a.set(false);
            }
        }
    }
}
