package f.b.a.c.i;

public final class p implements Runnable {
    public final /* synthetic */ q b;

    public p(q qVar) {
        this.b = qVar;
    }

    public final void run() {
        synchronized (this.b.b) {
            c cVar = this.b.c;
            if (cVar != null) {
                cVar.c();
            }
        }
    }
}
