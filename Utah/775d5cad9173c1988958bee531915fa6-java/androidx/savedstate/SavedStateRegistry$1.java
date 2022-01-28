package androidx.savedstate;

import e.q.h;
import e.q.j;
import e.q.l;
import e.v.a;

public class SavedStateRegistry$1 implements j {
    public final /* synthetic */ a a;

    public SavedStateRegistry$1(a aVar) {
        this.a = aVar;
    }

    @Override // e.q.j
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
        aVar2.f2022e = z;
    }
}
