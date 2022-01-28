package b.r.o;

import android.annotation.SuppressLint;
import android.os.CancellationSignal;
import b.f.a.f;
import b.r.h;
import b.r.j;
import c.b.b.e.a.u;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

@SuppressLint({"RestrictedAPI"})
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static Executor f1678a = new a();

    public static class a implements Executor {
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static <T> u<T> a(h hVar, boolean z, Callable<T> callable) {
        Executor transactionExecutor = z ? hVar.getTransactionExecutor() : hVar.getQueryExecutor();
        f fVar = new f();
        transactionExecutor.execute(new c(callable, fVar));
        return fVar;
    }

    public static <T> u<T> b(h hVar, boolean z, Callable<T> callable, j jVar, boolean z2, CancellationSignal cancellationSignal) {
        Executor transactionExecutor = z ? hVar.getTransactionExecutor() : hVar.getQueryExecutor();
        f fVar = new f();
        transactionExecutor.execute(new c(callable, fVar));
        fVar.b(new a(fVar, cancellationSignal), f1678a);
        if (z2) {
            fVar.b(new b(jVar), f1678a);
        }
        return fVar;
    }
}
