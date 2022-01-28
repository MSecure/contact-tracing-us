package c.a.b;

public class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o f2801b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f2802c;

    public c(d dVar, o oVar) {
        this.f2802c = dVar;
        this.f2801b = oVar;
    }

    public void run() {
        try {
            this.f2802c.f2804c.put(this.f2801b);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
