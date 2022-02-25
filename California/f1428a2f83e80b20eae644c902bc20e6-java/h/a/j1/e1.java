package h.a.j1;

public class e1 implements Runnable {
    public final /* synthetic */ z b;
    public final /* synthetic */ boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ z0 f3604d;

    public e1(z0 z0Var, z zVar, boolean z) {
        this.f3604d = z0Var;
        this.b = zVar;
        this.c = z;
    }

    public void run() {
        this.f3604d.r.c(this.b, this.c);
    }
}
