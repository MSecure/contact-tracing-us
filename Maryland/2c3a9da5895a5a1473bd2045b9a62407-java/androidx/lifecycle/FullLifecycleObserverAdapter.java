package androidx.lifecycle;

import e.p.d;
import e.p.g;
import e.p.h;
import e.p.j;

public class FullLifecycleObserverAdapter implements h {
    public final d a;
    public final h b;

    public FullLifecycleObserverAdapter(d dVar, h hVar) {
        this.a = dVar;
        this.b = hVar;
    }

    @Override // e.p.h
    public void d(j jVar, g.a aVar) {
        switch (aVar.ordinal()) {
            case 0:
                this.a.c(jVar);
                break;
            case 1:
                this.a.g(jVar);
                break;
            case 2:
                this.a.a(jVar);
                break;
            case 3:
                this.a.e(jVar);
                break;
            case 4:
                this.a.f(jVar);
                break;
            case 5:
                this.a.b(jVar);
                break;
            case 6:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        h hVar = this.b;
        if (hVar != null) {
            hVar.d(jVar, aVar);
        }
    }
}
