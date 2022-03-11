package androidx.lifecycle;

import e.r.e;
import e.r.h;
import e.r.j;
import e.r.l;
/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements j {
    public final e a;
    public final j b;

    public FullLifecycleObserverAdapter(e eVar, j jVar) {
        this.a = eVar;
        this.b = jVar;
    }

    @Override // e.r.j
    public void d(l lVar, h.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
                this.a.c(lVar);
                break;
            case 1:
                this.a.g(lVar);
                break;
            case 2:
                this.a.a(lVar);
                break;
            case 3:
                this.a.e(lVar);
                break;
            case 4:
                this.a.f(lVar);
                break;
            case 5:
                this.a.b(lVar);
                break;
            case 6:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        j jVar = this.b;
        if (jVar != null) {
            jVar.d(lVar, aVar);
        }
    }
}
