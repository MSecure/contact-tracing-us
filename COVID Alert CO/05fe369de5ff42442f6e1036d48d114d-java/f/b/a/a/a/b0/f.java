package f.b.a.a.a.b0;

import e.t.l;
import java.util.concurrent.Callable;

public class f implements Callable<Void> {
    public final /* synthetic */ long a;
    public final /* synthetic */ d b;

    public f(d dVar, long j2) {
        this.b = dVar;
        this.a = j2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Void call() {
        e.v.a.f.f a2 = this.b.f2080d.a();
        a2.b.bindLong(1, this.a);
        this.b.a.c();
        try {
            a2.d();
            this.b.a.l();
        } finally {
            this.b.a.g();
            l lVar = this.b.f2080d;
            if (a2 == lVar.c) {
                lVar.a.set(false);
            }
        }
    }
}
