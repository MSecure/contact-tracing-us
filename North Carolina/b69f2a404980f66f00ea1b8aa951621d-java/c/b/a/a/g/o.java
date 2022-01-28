package c.b.a.a.g;

public final class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f2873b;

    public o(n nVar) {
        this.f2873b = nVar;
    }

    public final void run() {
        synchronized (this.f2873b.f2871b) {
            if (this.f2873b.f2872c != null) {
                this.f2873b.f2872c.b();
            }
        }
    }
}
