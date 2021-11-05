package c.a.b;

public class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ o f2194b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f2195c;

    public c(d dVar, o oVar) {
        this.f2195c = dVar;
        this.f2194b = oVar;
    }

    public void run() {
        try {
            this.f2195c.f2197c.put(this.f2194b);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
