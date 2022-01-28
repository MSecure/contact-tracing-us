package androidx.lifecycle;

import b.o.c;
import b.o.f;
import b.o.g;
import b.o.i;

public class FullLifecycleObserverAdapter implements g {

    /* renamed from: a  reason: collision with root package name */
    public final c f237a;

    /* renamed from: b  reason: collision with root package name */
    public final g f238b;

    public FullLifecycleObserverAdapter(c cVar, g gVar) {
        this.f237a = cVar;
        this.f238b = gVar;
    }

    @Override // b.o.g
    public void d(i iVar, f.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
                this.f237a.c(iVar);
                break;
            case 1:
                this.f237a.g(iVar);
                break;
            case 2:
                this.f237a.a(iVar);
                break;
            case 3:
                this.f237a.e(iVar);
                break;
            case 4:
                this.f237a.f(iVar);
                break;
            case 5:
                this.f237a.b(iVar);
                break;
            case 6:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        g gVar = this.f238b;
        if (gVar != null) {
            gVar.d(iVar, aVar);
        }
    }
}
