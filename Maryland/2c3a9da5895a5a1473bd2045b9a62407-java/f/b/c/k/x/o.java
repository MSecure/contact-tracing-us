package f.b.c.k.x;

public final /* synthetic */ class o implements Runnable {
    public final p b;
    public final Runnable c;

    public o(p pVar, Runnable runnable) {
        this.b = pVar;
        this.c = runnable;
    }

    public void run() {
        p pVar = this.b;
        this.c.run();
        pVar.c.release();
    }
}
