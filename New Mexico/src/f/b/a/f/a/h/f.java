package f.b.a.f.a.h;
/* loaded from: classes.dex */
public final class f implements Runnable {
    public final /* synthetic */ r b;
    public final /* synthetic */ g c;

    public f(g gVar, r rVar) {
        this.c = gVar;
        this.b = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.c.b) {
            a<ResultT> aVar = this.c.c;
            if (aVar != 0) {
                aVar.a(this.b);
            }
        }
    }
}
