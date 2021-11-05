package c.b.c.a;

import c.b.c.a.y;
import java.security.GeneralSecurityException;
import java.util.Set;

public class w implements y.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f3822a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f3823b;

    public w(s sVar, i iVar) {
        this.f3822a = sVar;
        this.f3823b = iVar;
    }

    @Override // c.b.c.a.y.a
    public <Q> f<Q> a(Class<Q> cls) {
        try {
            return new r(this.f3822a, this.f3823b, cls);
        } catch (IllegalArgumentException e2) {
            throw new GeneralSecurityException("Primitive type not supported", e2);
        }
    }

    @Override // c.b.c.a.y.a
    public Set<Class<?>> b() {
        return this.f3822a.f();
    }

    @Override // c.b.c.a.y.a
    public f<?> c() {
        s sVar = this.f3822a;
        return new r(sVar, this.f3823b, sVar.f3486c);
    }

    @Override // c.b.c.a.y.a
    public Class<?> d() {
        return this.f3823b.getClass();
    }

    @Override // c.b.c.a.y.a
    public Class<?> e() {
        return this.f3822a.getClass();
    }
}
