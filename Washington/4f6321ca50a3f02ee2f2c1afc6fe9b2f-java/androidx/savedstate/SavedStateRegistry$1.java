package androidx.savedstate;

import e.p.g;
import e.p.h;
import e.p.j;
import e.u.a;

public class SavedStateRegistry$1 implements h {
    public final /* synthetic */ a a;

    public SavedStateRegistry$1(a aVar) {
        this.a = aVar;
    }

    @Override // e.p.h
    public void d(j jVar, g.a aVar) {
        a aVar2;
        boolean z;
        if (aVar == g.a.ON_START) {
            aVar2 = this.a;
            z = true;
        } else if (aVar == g.a.ON_STOP) {
            aVar2 = this.a;
            z = false;
        } else {
            return;
        }
        aVar2.f1898e = z;
    }
}
