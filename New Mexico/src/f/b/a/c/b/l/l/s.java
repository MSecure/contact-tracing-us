package f.b.a.c.b.l.l;

import f.b.a.c.b.l.a;
/* loaded from: classes.dex */
public final class s implements Runnable {
    public final /* synthetic */ r b;

    public s(r rVar) {
        this.b = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.e eVar = this.b.a.b;
        eVar.k(eVar.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
