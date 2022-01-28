package f.b.a.a.a.b0;

import e.t.l;
import e.v.a.f.f;
import java.util.concurrent.Callable;

public class e implements Callable<Void> {
    public final /* synthetic */ d a;

    public e(d dVar) {
        this.a = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Void call() {
        f a2 = this.a.c.a();
        this.a.a.c();
        try {
            a2.d();
            this.a.a.l();
            this.a.a.g();
            l lVar = this.a.c;
            if (a2 != lVar.c) {
                return null;
            }
            lVar.a.set(false);
            return null;
        } catch (Throwable th) {
            this.a.a.g();
            this.a.c.c(a2);
            throw th;
        }
    }
}
