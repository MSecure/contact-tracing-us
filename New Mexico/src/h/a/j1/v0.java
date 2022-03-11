package h.a.j1;

import h.a.j1.w;
/* loaded from: classes.dex */
public class v0 implements Runnable {
    public final /* synthetic */ w.a b;
    public final /* synthetic */ Throwable c;

    public v0(w.a aVar, Throwable th) {
        this.b = aVar;
        this.c = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.c);
    }
}
