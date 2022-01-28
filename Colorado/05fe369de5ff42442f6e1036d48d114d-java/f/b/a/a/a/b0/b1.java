package f.b.a.a.a.b0;

import java.util.concurrent.Callable;

public class b1 implements Callable<Long> {
    public final /* synthetic */ e1 a;
    public final /* synthetic */ a1 b;

    public b1(a1 a1Var, e1 e1Var) {
        this.b = a1Var;
        this.a = e1Var;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Long call() {
        this.b.a.c();
        try {
            long f2 = this.b.b.f(this.a);
            this.b.a.l();
            return Long.valueOf(f2);
        } finally {
            this.b.a.g();
        }
    }
}
