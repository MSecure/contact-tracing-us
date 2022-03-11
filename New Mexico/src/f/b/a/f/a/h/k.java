package f.b.a.f.a.h;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class k<ResultT> implements l<ResultT> {
    public final Executor a;
    public final Object b = new Object();
    public final c<? super ResultT> c;

    public k(Executor executor, c<? super ResultT> cVar) {
        this.a = executor;
        this.c = cVar;
    }

    @Override // f.b.a.f.a.h.l
    public final void a(r<ResultT> rVar) {
        if (rVar.e()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.a.execute(new j(this, rVar));
                }
            }
        }
    }
}
