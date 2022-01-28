package androidx.lifecycle;

import b.n.b;
import b.n.f;
import b.n.g;
import b.n.i;

public class ReflectiveGenericLifecycleObserver implements g {

    /* renamed from: a  reason: collision with root package name */
    public final Object f166a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f167b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f166a = obj;
        this.f167b = b.f1380c.b(obj.getClass());
    }

    @Override // b.n.g
    public void d(i iVar, f.a aVar) {
        b.a aVar2 = this.f167b;
        Object obj = this.f166a;
        b.a.a(aVar2.f1383a.get(aVar), iVar, aVar, obj);
        b.a.a(aVar2.f1383a.get(f.a.ON_ANY), iVar, aVar, obj);
    }
}
