package c.b.b.e.a;

public class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f3398b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f3399c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f3400d;

    public e(g gVar, u uVar, int i) {
        this.f3400d = gVar;
        this.f3398b = uVar;
        this.f3399c = i;
    }

    public void run() {
        try {
            if (this.f3398b.isCancelled()) {
                this.f3400d.m = null;
                this.f3400d.cancel(false);
            } else {
                this.f3400d.s(this.f3399c, this.f3398b);
            }
        } finally {
            g.q(this.f3400d, null);
        }
    }
}
