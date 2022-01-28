package androidx.savedstate;

import b.n.f;
import b.n.g;
import b.n.i;
import b.s.a;

public class SavedStateRegistry$1 implements g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f286a;

    public SavedStateRegistry$1(a aVar) {
        this.f286a = aVar;
    }

    @Override // b.n.g
    public void d(i iVar, f.a aVar) {
        boolean z;
        a aVar2;
        if (aVar == f.a.ON_START) {
            aVar2 = this.f286a;
            z = true;
        } else if (aVar == f.a.ON_STOP) {
            aVar2 = this.f286a;
            z = false;
        } else {
            return;
        }
        aVar2.f1711e = z;
    }
}
