package c.b.b.e.a;

public class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ u f4748b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f4749c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f4750d;

    public e(g gVar, u uVar, int i) {
        this.f4750d = gVar;
        this.f4748b = uVar;
        this.f4749c = i;
    }

    public void run() {
        try {
            if (this.f4748b.isCancelled()) {
                this.f4750d.m = null;
                this.f4750d.cancel(false);
            } else {
                this.f4750d.s(this.f4749c, this.f4748b);
            }
        } finally {
            g.q(this.f4750d, null);
        }
    }
}
