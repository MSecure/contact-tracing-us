package c.b.c.a;

import c.b.c.a.y;
import java.security.GeneralSecurityException;
import java.util.Set;

public class v implements y.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ i f3821a;

    public v(i iVar) {
        this.f3821a = iVar;
    }

    @Override // c.b.c.a.y.a
    public <Q> f<Q> a(Class<Q> cls) {
        try {
            return new g(this.f3821a, cls);
        } catch (IllegalArgumentException e2) {
            throw new GeneralSecurityException("Primitive type not supported", e2);
        }
    }

    @Override // c.b.c.a.y.a
    public Set<Class<?>> b() {
        return this.f3821a.f();
    }

    @Override // c.b.c.a.y.a
    public f<?> c() {
        i iVar = this.f3821a;
        return new g(iVar, iVar.f3486c);
    }

    @Override // c.b.c.a.y.a
    public Class<?> d() {
        return null;
    }

    @Override // c.b.c.a.y.a
    public Class<?> e() {
        return this.f3821a.getClass();
    }
}
