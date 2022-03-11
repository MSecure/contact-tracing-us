package e.v.n;

import android.os.CancellationSignal;
import e.g.a.f;
import e.v.g;
import e.v.i;
import f.b.b.f.a.u;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class d {
    public static Executor a = new a();

    /* loaded from: classes.dex */
    public static class a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static <T> u<T> a(g gVar, boolean z, Callable<T> callable) {
        Executor executor;
        if (z) {
            executor = gVar.c;
        } else {
            executor = gVar.b;
        }
        f fVar = new f();
        executor.execute(new c(callable, fVar));
        return fVar;
    }

    public static <T> u<T> b(g gVar, boolean z, Callable<T> callable, i iVar, boolean z2, CancellationSignal cancellationSignal) {
        Executor executor;
        if (z) {
            executor = gVar.c;
        } else {
            executor = gVar.b;
        }
        f fVar = new f();
        executor.execute(new c(callable, fVar));
        fVar.a(new a(fVar, cancellationSignal), a);
        if (z2) {
            fVar.a(new b(iVar), a);
        }
        return fVar;
    }
}
