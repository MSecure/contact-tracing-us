package androidx.savedstate;

import b.o.f;
import b.o.g;
import b.o.i;
import b.t.b;

public class SavedStateRegistry$1 implements g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f392a;

    public SavedStateRegistry$1(b bVar) {
        this.f392a = bVar;
    }

    @Override // b.o.g
    public void d(i iVar, f.a aVar) {
        boolean z;
        b bVar;
        if (aVar == f.a.ON_START) {
            bVar = this.f392a;
            z = true;
        } else if (aVar == f.a.ON_STOP) {
            bVar = this.f392a;
            z = false;
        } else {
            return;
        }
        bVar.f2583e = z;
    }
}
