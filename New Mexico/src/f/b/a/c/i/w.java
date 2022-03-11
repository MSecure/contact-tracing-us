package f.b.a.c.i;
/* loaded from: classes.dex */
public final class w implements Runnable {
    public final /* synthetic */ h b;
    public final /* synthetic */ v c;

    public w(v vVar, h hVar) {
        this.c = vVar;
        this.b = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.c.b) {
            f<? super TResult> fVar = this.c.c;
            if (fVar != 0) {
                fVar.a(this.b.l());
            }
        }
    }
}
