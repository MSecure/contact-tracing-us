package f.b.b.f.a;

public class e implements Runnable {
    public final /* synthetic */ u b;
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f3133d;

    public e(g gVar, u uVar, int i2) {
        this.f3133d = gVar;
        this.b = uVar;
        this.c = i2;
    }

    public void run() {
        try {
            if (this.b.isCancelled()) {
                g gVar = this.f3133d;
                gVar.m = null;
                gVar.cancel(false);
            } else {
                this.f3133d.G(this.c, this.b);
            }
        } finally {
            g.D(this.f3133d, null);
        }
    }
}
