package c.b.a.a.g;

public final class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f2874b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ q f2875c;

    public p(q qVar, h hVar) {
        this.f2875c = qVar;
        this.f2874b = hVar;
    }

    public final void run() {
        synchronized (this.f2875c.f2877b) {
            if (this.f2875c.f2878c != null) {
                this.f2875c.f2878c.onComplete(this.f2874b);
            }
        }
    }
}
