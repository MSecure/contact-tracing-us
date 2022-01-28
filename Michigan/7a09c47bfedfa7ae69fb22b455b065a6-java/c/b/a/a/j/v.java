package c.b.a.a.j;

public final class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f4142b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ u f4143c;

    public v(u uVar, i iVar) {
        this.f4143c = uVar;
        this.f4142b = iVar;
    }

    public final void run() {
        synchronized (this.f4143c.f4140b) {
            if (this.f4143c.f4141c != null) {
                this.f4143c.f4141c.onSuccess((Object) this.f4142b.f());
            }
        }
    }
}
