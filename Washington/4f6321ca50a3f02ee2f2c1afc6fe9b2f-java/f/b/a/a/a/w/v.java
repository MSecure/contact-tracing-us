package f.b.a.a.a.w;

import e.t.l;
import e.v.a.f.f;
import java.util.concurrent.Callable;

public class v implements Callable<Void> {
    public final /* synthetic */ long a;
    public final /* synthetic */ u b;

    public v(u uVar, long j2) {
        this.b = uVar;
        this.a = j2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Void call() {
        f a2 = this.b.f2292d.a();
        a2.b.bindLong(1, this.a);
        this.b.a.c();
        try {
            a2.d();
            this.b.a.l();
        } finally {
            this.b.a.g();
            l lVar = this.b.f2292d;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        }
    }
}
