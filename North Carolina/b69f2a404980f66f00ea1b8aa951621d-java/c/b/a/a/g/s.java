package c.b.a.a.g;

public final class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f2882b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ r f2883c;

    public s(r rVar, h hVar) {
        this.f2883c = rVar;
        this.f2882b = hVar;
    }

    public final void run() {
        synchronized (this.f2883c.f2880b) {
            if (this.f2883c.f2881c != null) {
                this.f2883c.f2881c.c(this.f2882b.e());
            }
        }
    }
}
