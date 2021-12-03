package f.b.a.a.a.l0;

import e.u.l;
import e.w.a.f.f;
import java.util.concurrent.Callable;

public class b0 implements Callable<Void> {
    public final /* synthetic */ long a;
    public final /* synthetic */ a0 b;

    public b0(a0 a0Var, long j2) {
        this.b = a0Var;
        this.a = j2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Void call() {
        f a2 = this.b.f2275d.a();
        a2.b.bindLong(1, this.a);
        this.b.a.c();
        try {
            a2.d();
            this.b.a.l();
        } finally {
            this.b.a.g();
            l lVar = this.b.f2275d;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        }
    }
}
