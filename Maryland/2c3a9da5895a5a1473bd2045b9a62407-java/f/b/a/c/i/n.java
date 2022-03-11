package f.b.a.c.i;

public final class n implements Runnable {
    public final /* synthetic */ h b;
    public final /* synthetic */ l c;

    public n(l lVar, h hVar) {
        this.c = lVar;
        this.b = hVar;
    }

    public final void run() {
        if (this.b.l()) {
            this.c.c.r();
            return;
        }
        try {
            this.c.c.q(this.c.b.a(this.b));
        } catch (g e2) {
            if (e2.getCause() instanceof Exception) {
                this.c.c.p((Exception) e2.getCause());
            } else {
                this.c.c.p(e2);
            }
        } catch (Exception e3) {
            this.c.c.p(e3);
        }
    }
}
