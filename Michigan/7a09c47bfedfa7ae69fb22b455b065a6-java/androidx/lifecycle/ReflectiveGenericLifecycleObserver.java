package androidx.lifecycle;

import b.o.b;
import b.o.f;
import b.o.g;
import b.o.i;

public class ReflectiveGenericLifecycleObserver implements g {

    /* renamed from: a  reason: collision with root package name */
    public final Object f246a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f247b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f246a = obj;
        this.f247b = b.f2207c.b(obj.getClass());
    }

    @Override // b.o.g
    public void d(i iVar, f.a aVar) {
        b.a aVar2 = this.f247b;
        Object obj = this.f246a;
        b.a.a(aVar2.f2210a.get(aVar), iVar, aVar, obj);
        b.a.a(aVar2.f2210a.get(f.a.ON_ANY), iVar, aVar, obj);
    }
}
