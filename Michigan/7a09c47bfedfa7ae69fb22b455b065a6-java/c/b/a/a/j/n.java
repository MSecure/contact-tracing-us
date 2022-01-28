package c.b.a.a.j;

public final class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f4123b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ m f4124c;

    public n(m mVar, i iVar) {
        this.f4124c = mVar;
        this.f4123b = iVar;
    }

    public final void run() {
        if (((b0) this.f4123b).f4104d) {
            this.f4124c.f4122c.j();
            return;
        }
        try {
            this.f4124c.f4122c.i(this.f4124c.f4121b.a(this.f4123b));
        } catch (g e2) {
            if (e2.getCause() instanceof Exception) {
                this.f4124c.f4122c.h((Exception) e2.getCause());
            } else {
                this.f4124c.f4122c.h(e2);
            }
        } catch (Exception e3) {
            this.f4124c.f4122c.h(e3);
        }
    }
}
