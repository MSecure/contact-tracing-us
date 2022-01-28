package c.b.a.a.g;

public final class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f2868b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f2869c;

    public m(l lVar, h hVar) {
        this.f2869c = lVar;
        this.f2868b = hVar;
    }

    public final void run() {
        if (((a0) this.f2868b).f2852d) {
            this.f2869c.f2867c.j();
            return;
        }
        try {
            this.f2869c.f2867c.i(this.f2869c.f2866b.a(this.f2868b));
        } catch (f e2) {
            if (e2.getCause() instanceof Exception) {
                this.f2869c.f2867c.h((Exception) e2.getCause());
            } else {
                this.f2869c.f2867c.h(e2);
            }
        } catch (Exception e3) {
            this.f2869c.f2867c.h(e3);
        }
    }
}
