package c.b.a.a.j;

public final class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f4132b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ q f4133c;

    public r(q qVar, i iVar) {
        this.f4133c = qVar;
        this.f4132b = iVar;
    }

    public final void run() {
        synchronized (this.f4133c.f4130b) {
            if (this.f4133c.f4131c != null) {
                this.f4133c.f4131c.onComplete(this.f4132b);
            }
        }
    }
}
