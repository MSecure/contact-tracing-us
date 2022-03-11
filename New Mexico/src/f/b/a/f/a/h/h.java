package f.b.a.f.a.h;
/* loaded from: classes.dex */
public final class h implements Runnable {
    public final /* synthetic */ r b;
    public final /* synthetic */ i c;

    public h(i iVar, r rVar) {
        this.c = iVar;
        this.b = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.c.b) {
            b bVar = this.c.c;
            if (bVar != null) {
                bVar.b(this.b.c());
            }
        }
    }
}
