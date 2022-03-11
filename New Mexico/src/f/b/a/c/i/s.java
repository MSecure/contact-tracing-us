package f.b.a.c.i;
/* loaded from: classes.dex */
public final class s implements Runnable {
    public final /* synthetic */ h b;
    public final /* synthetic */ r c;

    public s(r rVar, h hVar) {
        this.c = rVar;
        this.b = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.c.b) {
            d<TResult> dVar = this.c.c;
            if (dVar != 0) {
                dVar.a(this.b);
            }
        }
    }
}
