package f.b.a.a.a.n0;

import e.v.l;
import e.x.a.f.f;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class t implements Callable<Void> {
    public final /* synthetic */ s a;

    public t(s sVar) {
        this.a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() {
        f a = this.a.f2372d.a();
        this.a.a.c();
        try {
            a.d();
            this.a.a.l();
            this.a.a.g();
            l lVar = this.a.f2372d;
            if (a != lVar.c) {
                return null;
            }
            lVar.a.set(false);
            return null;
        } catch (Throwable th) {
            this.a.a.g();
            this.a.f2372d.c(a);
            throw th;
        }
    }
}
