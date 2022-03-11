package androidx.lifecycle;

import e.p.c;
import e.p.g;
import e.p.h;
import e.p.j;

public class ReflectiveGenericLifecycleObserver implements h {
    public final Object a;
    public final c.a b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.a = obj;
        this.b = c.c.b(obj.getClass());
    }

    @Override // e.p.h
    public void d(j jVar, g.a aVar) {
        c.a aVar2 = this.b;
        Object obj = this.a;
        c.a.a(aVar2.a.get(aVar), jVar, aVar, obj);
        c.a.a(aVar2.a.get(g.a.ON_ANY), jVar, aVar, obj);
    }
}
