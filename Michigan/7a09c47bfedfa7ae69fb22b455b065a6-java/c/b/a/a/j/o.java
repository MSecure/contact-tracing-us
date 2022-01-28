package c.b.a.a.j;

public final class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f4125b;

    public o(p pVar) {
        this.f4125b = pVar;
    }

    public final void run() {
        synchronized (this.f4125b.f4127b) {
            if (this.f4125b.f4128c != null) {
                this.f4125b.f4128c.b();
            }
        }
    }
}
