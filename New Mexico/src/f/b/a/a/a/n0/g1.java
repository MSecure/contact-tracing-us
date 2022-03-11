package f.b.a.a.a.n0;

import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class g1 implements Callable<Long> {
    public final /* synthetic */ k1 a;
    public final /* synthetic */ f1 b;

    public g1(f1 f1Var, k1 k1Var) {
        this.b = f1Var;
        this.a = k1Var;
    }

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
