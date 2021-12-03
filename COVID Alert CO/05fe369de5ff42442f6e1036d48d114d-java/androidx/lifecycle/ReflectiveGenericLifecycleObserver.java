package androidx.lifecycle;

import e.p.c;
import e.p.h;
import e.p.j;
import e.p.l;

public class ReflectiveGenericLifecycleObserver implements j {
    public final Object a;
    public final c.a b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
        this.b = c.c.b(obj.getClass());
    }

    @Override // e.p.j
    public void d(l lVar, h.a aVar) {
        c.a aVar2 = this.b;
        Object obj = this.a;
        c.a.a(aVar2.a.get(aVar), lVar, aVar, obj);
        c.a.a(aVar2.a.get(h.a.ON_ANY), lVar, aVar, obj);
    }
}
