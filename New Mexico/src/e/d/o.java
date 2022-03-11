package e.d;
/* loaded from: classes.dex */
public class o implements Runnable {
    public final /* synthetic */ r b;
    public final /* synthetic */ e c;

    public o(e eVar, r rVar) {
        this.c = eVar;
        this.b = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.X.e().c(this.b);
    }
}
