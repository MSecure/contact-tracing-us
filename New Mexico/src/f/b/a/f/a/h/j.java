package f.b.a.f.a.h;
/* loaded from: classes.dex */
public final class j implements Runnable {
    public final /* synthetic */ r b;
    public final /* synthetic */ k c;

    public j(k kVar, r rVar) {
        this.c = kVar;
        this.b = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.c.b) {
            c<? super ResultT> cVar = this.c.c;
            if (cVar != 0) {
                cVar.a(this.b.d());
            }
        }
    }
}
