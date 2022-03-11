package f.b.a.f.a.h;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class g<ResultT> implements l<ResultT> {
    public final Executor a;
    public final Object b = new Object();
    public final a<ResultT> c;

    public g(Executor executor, a<ResultT> aVar) {
        this.a = executor;
        this.c = aVar;
    }

    @Override // f.b.a.f.a.h.l
    public final void a(r<ResultT> rVar) {
        synchronized (this.b) {
            if (this.c != null) {
                this.a.execute(new f(this, rVar));
            }
        }
    }
}
