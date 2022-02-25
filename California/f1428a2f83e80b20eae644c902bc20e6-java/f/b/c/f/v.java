package f.b.c.f;

import f.b.c.j.c;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class v extends a {
    public final Set<Class<?>> a;
    public final Set<Class<?>> b;
    public final Set<Class<?>> c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<Class<?>> f2963d;

    /* renamed from: e  reason: collision with root package name */
    public final Set<Class<?>> f2964e;

    /* renamed from: f  reason: collision with root package name */
    public final e f2965f;

    public static class a implements c {
        public final c a;

        public a(Set<Class<?>> set, c cVar) {
            this.a = cVar;
        }
    }

    public v(d<?> dVar, e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (o oVar : dVar.b) {
            if (oVar.c == 0) {
                if (oVar.a()) {
                    hashSet3.add(oVar.a);
                } else {
                    hashSet.add(oVar.a);
                }
            } else if (oVar.a()) {
                hashSet4.add(oVar.a);
            } else {
                hashSet2.add(oVar.a);
            }
        }
        if (!dVar.f2958f.isEmpty()) {
            hashSet.add(c.class);
        }
        this.a = Collections.unmodifiableSet(hashSet);
        this.b = Collections.unmodifiableSet(hashSet2);
        this.c = Collections.unmodifiableSet(hashSet3);
        this.f2963d = Collections.unmodifiableSet(hashSet4);
        this.f2964e = dVar.f2958f;
        this.f2965f = eVar;
    }

    @Override // f.b.c.f.e, f.b.c.f.a
    public <T> T a(Class<T> cls) {
        if (this.a.contains(cls)) {
            T t = (T) this.f2965f.a(cls);
            return !cls.equals(c.class) ? t : (T) new a(this.f2964e, t);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", cls));
    }

    @Override // f.b.c.f.e
    public <T> f.b.c.m.a<T> b(Class<T> cls) {
        if (this.b.contains(cls)) {
            return this.f2965f.b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }

    @Override // f.b.c.f.e, f.b.c.f.a
    public <T> Set<T> c(Class<T> cls) {
        if (this.c.contains(cls)) {
            return this.f2965f.c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }

    @Override // f.b.c.f.e
    public <T> f.b.c.m.a<Set<T>> d(Class<T> cls) {
        if (this.f2963d.contains(cls)) {
            return this.f2965f.d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }
}
