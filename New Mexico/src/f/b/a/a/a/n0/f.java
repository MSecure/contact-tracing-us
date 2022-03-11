package f.b.a.a.a.n0;

import e.v.l;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class f implements Callable<Void> {
    public final /* synthetic */ long a;
    public final /* synthetic */ d b;

    public f(d dVar, long j2) {
        this.b = dVar;
        this.a = j2;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        e.x.a.f.f a = this.b.f2333d.a();
        a.b.bindLong(1, this.a);
        this.b.a.c();
        try {
            a.d();
            this.b.a.l();
        } finally {
            this.b.a.g();
            l lVar = this.b.f2333d;
            if (a == lVar.c) {
                lVar.a.set(false);
            }
        }
    }
}
