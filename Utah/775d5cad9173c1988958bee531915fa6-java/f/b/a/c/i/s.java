package f.b.a.c.i;

public final class s implements Runnable {
    public final /* synthetic */ h b;
    public final /* synthetic */ r c;

    public s(r rVar, h hVar) {
        this.c = rVar;
        this.b = hVar;
    }

    public final void run() {
        synchronized (this.c.b) {
            d<TResult> dVar = this.c.c;
            if (dVar != null) {
                dVar.a(this.b);
            }
        }
    }
}
