package androidx.lifecycle;

import b.n.c;
import b.n.f;
import b.n.g;
import b.n.i;

public class FullLifecycleObserverAdapter implements g {

    /* renamed from: a  reason: collision with root package name */
    public final c f158a;

    /* renamed from: b  reason: collision with root package name */
    public final g f159b;

    public FullLifecycleObserverAdapter(c cVar, g gVar) {
        this.f158a = cVar;
        this.f159b = gVar;
    }

    @Override // b.n.g
    public void d(i iVar, f.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
                this.f158a.c(iVar);
                break;
            case 1:
                this.f158a.g(iVar);
                break;
            case 2:
                this.f158a.a(iVar);
                break;
            case 3:
                this.f158a.e(iVar);
                break;
            case 4:
                this.f158a.f(iVar);
                break;
            case 5:
                this.f158a.b(iVar);
                break;
            case 6:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        g gVar = this.f159b;
        if (gVar != null) {
            gVar.d(iVar, aVar);
        }
    }
}
