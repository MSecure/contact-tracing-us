package e.o.a;

import e.f.a;
import e.o.a.a1;
/* loaded from: classes.dex */
public class h implements Runnable {
    public final /* synthetic */ a1.d b;
    public final /* synthetic */ a1.d c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f1789d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ a f1790e;

    public h(c cVar, a1.d dVar, a1.d dVar2, boolean z, a aVar) {
        this.b = dVar;
        this.c = dVar2;
        this.f1789d = z;
        this.f1790e = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        t0.c(this.b.c, this.c.c, this.f1789d, this.f1790e, false);
    }
}
