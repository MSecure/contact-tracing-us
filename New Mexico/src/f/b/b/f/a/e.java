package f.b.b.f.a;
/* loaded from: classes.dex */
public class e implements Runnable {
    public final /* synthetic */ u b;
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g f3451d;

    public e(g gVar, u uVar, int i2) {
        this.f3451d = gVar;
        this.b = uVar;
        this.c = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.b.isCancelled()) {
                g gVar = this.f3451d;
                gVar.m = null;
                gVar.cancel(false);
            } else {
                this.f3451d.G(this.c, this.b);
            }
        } finally {
            g.D(this.f3451d, null);
        }
    }
}
