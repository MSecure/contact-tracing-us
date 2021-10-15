package c.b.c.a;

import c.b.c.a.i0.v0;
import c.b.c.a.j0.a.r0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class i<KeyProtoT extends r0> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<KeyProtoT> f4837a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Class<?>, b<?, KeyProtoT>> f4838b;

    /* renamed from: c  reason: collision with root package name */
    public final Class<?> f4839c;

    public static abstract class a<KeyFormatProtoT extends r0, KeyT> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<KeyFormatProtoT> f4840a;

        public a(Class<KeyFormatProtoT> cls) {
            this.f4840a = cls;
        }

        public abstract KeyT a(KeyFormatProtoT keyformatprotot);

        public abstract KeyFormatProtoT b(c.b.c.a.j0.a.i iVar);

        public abstract void c(KeyFormatProtoT keyformatprotot);
    }

    public static abstract class b<PrimitiveT, KeyT> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<PrimitiveT> f4841a;

        public b(Class<PrimitiveT> cls) {
            this.f4841a = cls;
        }

        public abstract PrimitiveT a(KeyT keyt);
    }

    @SafeVarargs
    public i(Class<KeyProtoT> cls, b<?, KeyProtoT>... bVarArr) {
        Class<Void> cls2;
        this.f4837a = cls;
        HashMap hashMap = new HashMap();
        for (b<?, KeyProtoT> bVar : bVarArr) {
            if (!hashMap.containsKey(bVar.f4841a)) {
                hashMap.put(bVar.f4841a, bVar);
            } else {
                StringBuilder h = c.a.a.a.a.h("KeyTypeManager constructed with duplicate factories for primitive ");
                h.append(bVar.f4841a.getCanonicalName());
                throw new IllegalArgumentException(h.toString());
            }
        }
        if (bVarArr.length > 0) {
            cls2 = bVarArr[0].f4841a;
        } else {
            cls2 = Void.class;
        }
        this.f4839c = cls2;
        this.f4838b = Collections.unmodifiableMap(hashMap);
    }

    public abstract String a();

    public final <P> P b(KeyProtoT keyprotot, Class<P> cls) {
        b<?, KeyProtoT> bVar = this.f4838b.get(cls);
        if (bVar != null) {
            return (P) bVar.a(keyprotot);
        }
        StringBuilder h = c.a.a.a.a.h("Requested primitive class ");
        h.append(cls.getCanonicalName());
        h.append(" not supported.");
        throw new IllegalArgumentException(h.toString());
    }

    public a<?, KeyProtoT> c() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract v0.c d();

    public abstract KeyProtoT e(c.b.c.a.j0.a.i iVar);

    public final Set<Class<?>> f() {
        return this.f4838b.keySet();
    }

    public abstract void g(KeyProtoT keyprotot);
}
