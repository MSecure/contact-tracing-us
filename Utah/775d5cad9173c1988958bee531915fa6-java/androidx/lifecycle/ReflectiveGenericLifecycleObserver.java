package androidx.lifecycle;

import e.q.c;
import e.q.h;
import e.q.j;
import e.q.l;

public class ReflectiveGenericLifecycleObserver implements j {
    public final Object a;
    public final c.a b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
        this.b = c.c.b(obj.getClass());
    }

    @Override // e.q.j
    public void d(l lVar, h.a aVar) {
        c.a aVar2 = this.b;
        Object obj = this.a;
        c.a.a(aVar2.a.get(aVar), lVar, aVar, obj);
        c.a.a(aVar2.a.get(h.a.ON_ANY), lVar, aVar, obj);
    }
}
