package c.b.c.a;

import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.r0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class i<KeyProtoT extends r0> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<KeyProtoT> f3484a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Class<?>, b<?, KeyProtoT>> f3485b;

    /* renamed from: c  reason: collision with root package name */
    public final Class<?> f3486c;

    public static abstract class a<KeyFormatProtoT extends r0, KeyT> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<KeyFormatProtoT> f3487a;

        public a(Class<KeyFormatProtoT> cls) {
            this.f3487a = cls;
        }

        public abstract KeyT a(KeyFormatProtoT keyformatprotot);

        public abstract KeyFormatProtoT b(c.b.c.a.j0.a.i iVar);

        public abstract void c(KeyFormatProtoT keyformatprotot);
    }

    public static abstract class b<PrimitiveT, KeyT> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<PrimitiveT> f3488a;

        public b(Class<PrimitiveT> cls) {
            this.f3488a = cls;
        }

        public abstract PrimitiveT a(KeyT keyt);
    }

    @SafeVarargs
    public i(Class<KeyProtoT> cls, b<?, KeyProtoT>... bVarArr) {
        Class<Void> cls2;
        this.f3484a = cls;
        HashMap hashMap = new HashMap();
        for (b<?, KeyProtoT> bVar : bVarArr) {
            if (!hashMap.containsKey(bVar.f3488a)) {
                hashMap.put(bVar.f3488a, bVar);
            } else {
                StringBuilder g = c.a.a.a.a.g("KeyTypeManager constructed with duplicate factories for primitive ");
                g.append(bVar.f3488a.getCanonicalName());
                throw new IllegalArgumentException(g.toString());
            }
        }
        if (bVarArr.length > 0) {
            cls2 = bVarArr[0].f3488a;
        } else {
            cls2 = Void.class;
        }
        this.f3486c = cls2;
        this.f3485b = Collections.unmodifiableMap(hashMap);
    }

    public abstract String a();

    public final <P> P b(KeyProtoT keyprotot, Class<P> cls) {
        b<?, KeyProtoT> bVar = this.f3485b.get(cls);
        if (bVar != null) {
            return (P) bVar.a(keyprotot);
        }
        StringBuilder g = c.a.a.a.a.g("Requested primitive class ");
        g.append(cls.getCanonicalName());
        g.append(" not supported.");
        throw new IllegalArgumentException(g.toString());
    }

    public a<?, KeyProtoT> c() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract v0.c d();

    public abstract KeyProtoT e(c.b.c.a.j0.a.i iVar);

    public final Set<Class<?>> f() {
        return this.f3485b.keySet();
    }

    public abstract void g(KeyProtoT keyprotot);
}
