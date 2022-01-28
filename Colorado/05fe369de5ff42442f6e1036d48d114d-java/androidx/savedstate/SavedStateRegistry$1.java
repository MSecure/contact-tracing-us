package androidx.savedstate;

import e.p.h;
import e.p.j;
import e.p.l;
import e.u.a;

public class SavedStateRegistry$1 implements j {
    public final /* synthetic */ a a;

    public SavedStateRegistry$1(a aVar) {
        this.a = aVar;
    }

    @Override // e.p.j
    public void d(l lVar, h.a aVar) {
        a aVar2;
        boolean z;
        if (aVar == h.a.ON_START) {
            aVar2 = this.a;
            z = true;
        } else if (aVar == h.a.ON_STOP) {
            aVar2 = this.a;
            z = false;
        } else {
            return;
        }
        aVar2.f1747e = z;
    }
}
