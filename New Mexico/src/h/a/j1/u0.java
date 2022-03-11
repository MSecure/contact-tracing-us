package h.a.j1;

import h.a.j1.w;
/* loaded from: classes.dex */
public class u0 implements Runnable {
    public final /* synthetic */ w.a b;
    public final /* synthetic */ long c;

    public u0(w.a aVar, long j2) {
        this.b = aVar;
        this.c = j2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.c);
    }
}
