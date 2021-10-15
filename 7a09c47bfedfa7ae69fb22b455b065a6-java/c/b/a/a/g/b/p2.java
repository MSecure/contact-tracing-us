package c.b.a.a.g.b;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class p2 {

    /* renamed from: c  reason: collision with root package name */
    public static final p2 f3390c = new p2();

    /* renamed from: a  reason: collision with root package name */
    public final v2 f3391a;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentMap<Class<?>, u2<?>> f3392b = new ConcurrentHashMap();

    public p2() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        v2 v2Var = null;
        for (int i = 0; i <= 0; i++) {
            try {
                v2Var = (v2) Class.forName(strArr[0]).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused) {
                v2Var = null;
            }
            if (v2Var != null) {
                break;
            }
        }
        this.f3391a = v2Var == null ? new u1() : v2Var;
    }

    public final <T> u2<T> a(Class<T> cls) {
        b1.e(cls, "messageType");
        u2<T> u2Var = (u2<T>) this.f3392b.get(cls);
        if (u2Var != null) {
            return u2Var;
        }
        u2<T> a2 = this.f3391a.a(cls);
        b1.e(cls, "messageType");
        b1.e(a2, "schema");
        u2<T> u2Var2 = (u2<T>) this.f3392b.putIfAbsent(cls, a2);
        return u2Var2 != null ? u2Var2 : a2;
    }

    public final <T> u2<T> b(T t) {
        return a(t.getClass());
    }
}
