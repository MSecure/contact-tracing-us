package c.b.c.a;

import c.b.c.a.y;
import java.security.GeneralSecurityException;
import java.util.Set;

public class w implements y.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ s f5223a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f5224b;

    public w(s sVar, i iVar) {
        this.f5223a = sVar;
        this.f5224b = iVar;
    }

    @Override // c.b.c.a.y.a
    public <Q> f<Q> a(Class<Q> cls) {
        try {
            return new r(this.f5223a, this.f5224b, cls);
        } catch (IllegalArgumentException e2) {
            throw new GeneralSecurityException("Primitive type not supported", e2);
        }
    }

    @Override // c.b.c.a.y.a
    public Set<Class<?>> b() {
        return this.f5223a.f();
    }

    @Override // c.b.c.a.y.a
    public f<?> c() {
        s sVar = this.f5223a;
        return new r(sVar, this.f5224b, sVar.f4839c);
    }

    @Override // c.b.c.a.y.a
    public Class<?> d() {
        return this.f5224b.getClass();
    }

    @Override // c.b.c.a.y.a
    public Class<?> e() {
        return this.f5223a.getClass();
    }
}
