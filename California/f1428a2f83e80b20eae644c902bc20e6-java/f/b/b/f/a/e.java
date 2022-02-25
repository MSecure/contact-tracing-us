package f.b.b.f.a;

public class e implements Runnable {
    public final /* synthetic */ u b;
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f2933d;

    public e(g gVar, u uVar, int i2) {
        this.f2933d = gVar;
        this.b = uVar;
        this.c = i2;
    }

    public void run() {
        try {
            if (this.b.isCancelled()) {
                g gVar = this.f2933d;
                gVar.m = null;
                gVar.cancel(false);
            } else {
                this.f2933d.G(this.c, this.b);
            }
        } finally {
            g.D(this.f2933d, null);
        }
    }
}
