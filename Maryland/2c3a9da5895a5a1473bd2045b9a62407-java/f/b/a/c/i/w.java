package f.b.a.c.i;

public final class w implements Runnable {
    public final /* synthetic */ h b;
    public final /* synthetic */ v c;

    public w(v vVar, h hVar) {
        this.c = vVar;
        this.b = hVar;
    }

    public final void run() {
        synchronized (this.c.b) {
            f<? super TResult> fVar = this.c.c;
            if (fVar != null) {
                fVar.b((Object) this.b.k());
            }
        }
    }
}
