package c.b.a.a.g;

public final class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f2884b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ u f2885c;

    public t(u uVar, h hVar) {
        this.f2885c = uVar;
        this.f2884b = hVar;
    }

    public final void run() {
        synchronized (this.f2885c.f2887b) {
            if (this.f2885c.f2888c != null) {
                this.f2885c.f2888c.onSuccess((Object) this.f2884b.f());
            }
        }
    }
}
