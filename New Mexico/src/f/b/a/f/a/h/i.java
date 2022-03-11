package f.b.a.f.a.h;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class i<ResultT> implements l<ResultT> {
    public final Executor a;
    public final Object b = new Object();
    public final b c;

    public i(Executor executor, b bVar) {
        this.a = executor;
        this.c = bVar;
    }

    @Override // f.b.a.f.a.h.l
    public final void a(r<ResultT> rVar) {
        if (!rVar.e()) {
            synchronized (this.b) {
                if (this.c != null) {
                    this.a.execute(new h(this, rVar));
                }
            }
        }
    }
}
