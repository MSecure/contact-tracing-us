package c.b.c.a.j0.a;

import c.b.c.a.j0.a.a;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.r0;
import c.b.c.a.j0.a.u;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class y<MessageType extends y<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a<MessageType, BuilderType> {
    public static Map<Object, y<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    public int memoizedSerializedSize = -1;
    public m1 unknownFields = m1.f;

    public static abstract class a<MessageType extends y<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a.AbstractC0091a<MessageType, BuilderType> {

        /* renamed from: b  reason: collision with root package name */
        public final MessageType f3673b;

        /* renamed from: c  reason: collision with root package name */
        public MessageType f3674c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3675d = false;

        public a(MessageType messagetype) {
            this.f3673b = messagetype;
            this.f3674c = (MessageType) ((y) messagetype.f(f.NEW_MUTABLE_INSTANCE, null, null));
        }

        public final MessageType b() {
            MessageType c2 = c();
            if (c2.isInitialized()) {
                return c2;
            }
            throw new k1();
        }

        public MessageType c() {
            if (this.f3675d) {
                return this.f3674c;
            }
            MessageType messagetype = this.f3674c;
            if (messagetype != null) {
                b1.f3523c.b(messagetype).f(messagetype);
                this.f3675d = true;
                return this.f3674c;
            }
            throw null;
        }

        @Override // java.lang.Object
        public Object clone() {
            a aVar = (a) this.f3673b.f(f.NEW_BUILDER, null, null);
            aVar.e(c());
            return aVar;
        }

        public final void d() {
            if (this.f3675d) {
                MessageType messagetype = (MessageType) ((y) this.f3674c.f(f.NEW_MUTABLE_INSTANCE, null, null));
                b1.f3523c.b(messagetype).a(messagetype, this.f3674c);
                this.f3674c = messagetype;
                this.f3675d = false;
            }
        }

        public BuilderType e(MessageType messagetype) {
            d();
            f(this.f3674c, messagetype);
            return this;
        }

        public final void f(MessageType messagetype, MessageType messagetype2) {
            b1.f3523c.b(messagetype).a(messagetype, messagetype2);
        }

        @Override // c.b.c.a.j0.a.s0
        public r0 getDefaultInstanceForType() {
            return this.f3673b;
        }

        @Override // c.b.c.a.j0.a.s0
        public final boolean isInitialized() {
            return y.j(this.f3674c, false);
        }
    }

    public static class b<T extends y<T, ?>> extends b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T f3676a;

        public b(T t) {
            this.f3676a = t;
        }

        @Override // c.b.c.a.j0.a.y0
        public Object b(j jVar, q qVar) {
            return y.m(this.f3676a, jVar, qVar);
        }
    }

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends y<MessageType, BuilderType> implements Object<MessageType, BuilderType> {
        public u<d> extensions = u.f3651d;

        public u<d> n() {
            u<d> uVar = this.extensions;
            if (uVar.f3653b) {
                this.extensions = uVar.clone();
            }
            return this.extensions;
        }
    }

    public static final class d implements u.a<d> {

        /* renamed from: b  reason: collision with root package name */
        public final int f3677b;

        @Override // c.b.c.a.j0.a.u.a
        public int a() {
            return 0;
        }

        @Override // c.b.c.a.j0.a.u.a
        public boolean c() {
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return 0 - ((d) obj).f3677b;
        }

        @Override // c.b.c.a.j0.a.u.a
        public s1 e() {
            return null;
        }

        @Override // c.b.c.a.j0.a.u.a
        public t1 h() {
            throw null;
        }

        @Override // c.b.c.a.j0.a.u.a
        public boolean j() {
            return false;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: c.b.c.a.j0.a.y$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.c.a.j0.a.u.a
        public r0.a m(r0.a aVar, r0 r0Var) {
            a aVar2 = (a) aVar;
            aVar2.e((y) r0Var);
            return aVar2;
        }
    }

    public static class e<ContainingType extends r0, Type> extends o<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        public final d f3678a;
    }

    public enum f {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static <T extends y<T, ?>> T d(T t) {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new b0(new k1().getMessage());
    }

    public static <T extends y<?, ?>> T g(Class<T> cls) {
        y<?, ?> yVar = defaultInstanceMap.get(cls);
        if (yVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                yVar = (T) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (yVar == null) {
            yVar = (T) ((y) p1.a(cls)).getDefaultInstanceForType();
            if (yVar != null) {
                defaultInstanceMap.put(cls, yVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) yVar;
    }

    public static Object i(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static final <T extends y<T, ?>> boolean j(T t, boolean z) {
        byte byteValue = ((Byte) t.f(f.GET_MEMOIZED_IS_INITIALIZED, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean b2 = b1.f3523c.b(t).b(t);
        if (z) {
            t.f(f.SET_MEMOIZED_IS_INITIALIZED, b2 ? t : null, null);
        }
        return b2;
    }

    public static <T extends y<T, ?>> T k(T t, i iVar, q qVar) {
        try {
            i.g gVar = (i.g) iVar;
            j f2 = j.f(gVar.f3569e, gVar.u(), gVar.size(), true);
            T t2 = (T) m(t, f2, qVar);
            try {
                f2.a(0);
                d(t2);
                return t2;
            } catch (b0 e2) {
                throw e2;
            }
        } catch (b0 e3) {
            throw e3;
        }
    }

    public static <T extends y<T, ?>> T l(T t, byte[] bArr, q qVar) {
        int length = bArr.length;
        T t2 = (T) ((y) t.f(f.NEW_MUTABLE_INSTANCE, null, null));
        try {
            f1 b2 = b1.f3523c.b(t2);
            b2.h(t2, bArr, 0, 0 + length, new e(qVar));
            b2.f(t2);
            if (t2.memoizedHashCode == 0) {
                d(t2);
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof b0) {
                throw ((b0) e2.getCause());
            }
            throw new b0(e2.getMessage());
        } catch (IndexOutOfBoundsException unused) {
            throw b0.h();
        }
    }

    public static <T extends y<T, ?>> T m(T t, j jVar, q qVar) {
        T t2 = (T) ((y) t.f(f.NEW_MUTABLE_INSTANCE, null, null));
        try {
            f1 b2 = b1.f3523c.b(t2);
            k kVar = jVar.f3589c;
            if (kVar == null) {
                kVar = new k(jVar);
            }
            b2.j(t2, kVar, qVar);
            b2.f(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof b0) {
                throw ((b0) e2.getCause());
            }
            throw new b0(e2.getMessage());
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof b0) {
                throw ((b0) e3.getCause());
            }
            throw e3;
        }
    }

    @Override // c.b.c.a.j0.a.r0
    public void a(l lVar) {
        f1 b2 = b1.f3523c.b(this);
        m mVar = lVar.f3601a;
        if (mVar == null) {
            mVar = new m(lVar);
        }
        b2.i(this, mVar);
    }

    public final <MessageType extends y<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType e() {
        return (BuilderType) ((a) f(f.NEW_BUILDER, null, null));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        return b1.f3523c.b(this).c(this, (y) obj);
    }

    public abstract Object f(f fVar, Object obj, Object obj2);

    @Override // c.b.c.a.j0.a.r0
    public final y0<MessageType> getParserForType() {
        return (y0) f(f.GET_PARSER, null, null);
    }

    @Override // c.b.c.a.j0.a.r0
    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = b1.f3523c.b(this).d(this);
        }
        return this.memoizedSerializedSize;
    }

    /* renamed from: h */
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) ((y) f(f.GET_DEFAULT_INSTANCE, null, null));
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int g = b1.f3523c.b(this).g(this);
        this.memoizedHashCode = g;
        return g;
    }

    @Override // c.b.c.a.j0.a.s0
    public final boolean isInitialized() {
        return j(this, true);
    }

    @Override // c.b.c.a.j0.a.r0
    public r0.a newBuilderForType() {
        return (a) f(f.NEW_BUILDER, null, null);
    }

    @Override // c.b.c.a.j0.a.r0
    public r0.a toBuilder() {
        a aVar = (a) f(f.NEW_BUILDER, null, null);
        aVar.d();
        aVar.f(aVar.f3674c, this);
        return aVar;
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        c.b.a.a.c.n.c.R1(this, sb, 0);
        return sb.toString();
    }
}
