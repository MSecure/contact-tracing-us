package c.b.d;

import b.x.t;
import c.b.d.b;
import c.b.d.f0;
import c.b.d.i1;
import c.b.d.k0;
import c.b.d.k0.a;
import c.b.d.x2;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class k0<MessageType extends k0<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends b<MessageType, BuilderType> {

    /* renamed from: d  reason: collision with root package name */
    public static Map<Object, k0<?, ?>> f5347d = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public r2 f5348b = r2.f5781f;

    /* renamed from: c  reason: collision with root package name */
    public int f5349c = -1;

    public static abstract class a<MessageType extends k0<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends b.a<MessageType, BuilderType> {

        /* renamed from: b  reason: collision with root package name */
        public MessageType f5350b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f5351c;

        /* renamed from: a */
        public MessageType buildPartial() {
            if (this.f5351c) {
                return this.f5350b;
            }
            this.f5350b.h();
            this.f5351c = true;
            return this.f5350b;
        }

        public final void b() {
            if (this.f5351c) {
                MessageType messagetype = (MessageType) ((k0) this.f5350b.b(e.NEW_MUTABLE_INSTANCE));
                z1.f5964c.b(messagetype).a(messagetype, this.f5350b);
                this.f5350b = messagetype;
                this.f5351c = false;
            }
        }

        @Override // c.b.d.i1.a
        public i1 build() {
            MessageType a2 = buildPartial();
            if (a2.isInitialized()) {
                return a2;
            }
            throw b.a.newUninitializedMessageException(a2);
        }

        public BuilderType c(k kVar, z zVar) {
            b();
            try {
                d2 b2 = z1.f5964c.b(this.f5350b);
                MessageType messagetype = this.f5350b;
                l lVar = kVar.f5339d;
                if (lVar == null) {
                    lVar = new l(kVar);
                }
                b2.h(messagetype, lVar, zVar);
                return this;
            } catch (RuntimeException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw e2;
            }
        }

        @Override // c.b.d.b.a, c.b.d.b.a, c.b.d.b.a, java.lang.Object
        public b.a clone() {
            throw null;
        }

        public BuilderType d(MessageType messagetype) {
            b();
            MessageType messagetype2 = this.f5350b;
            z1.f5964c.b(messagetype2).a(messagetype2, messagetype);
            return this;
        }

        public BuilderType e(byte[] bArr, int i, int i2, z zVar) {
            b();
            try {
                z1.f5964c.b(this.f5350b).i(this.f5350b, bArr, i, i + i2, new f(zVar));
                return this;
            } catch (o0 e2) {
                throw e2;
            } catch (IndexOutOfBoundsException unused) {
                throw o0.i();
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            }
        }

        @Override // c.b.d.j1
        public i1 getDefaultInstanceForType() {
            return null;
        }

        @Override // c.b.d.b.a
        public b.a internalMergeFrom(b bVar) {
            b();
            MessageType messagetype = this.f5350b;
            z1.f5964c.b(messagetype).a(messagetype, (k0) bVar);
            return this;
        }

        @Override // c.b.d.j1
        public final boolean isInitialized() {
            return k0.g(this.f5350b, false);
        }

        @Override // c.b.d.b.a, c.b.d.b.a
        public b.a mergeFrom(byte[] bArr, int i, int i2) {
            e(bArr, i, i2, z.a());
            return this;
        }

        @Override // c.b.d.b.a, c.b.d.b.a, c.b.d.b.a, java.lang.Object
        /* renamed from: clone  reason: collision with other method in class */
        public i1.a m4clone() {
            throw null;
        }

        @Override // c.b.d.b.a, c.b.d.b.a
        /* renamed from: mergeFrom  reason: collision with other method in class */
        public i1.a m6mergeFrom(byte[] bArr, int i, int i2) {
            e(bArr, i, i2, z.a());
            return this;
        }

        @Override // c.b.d.b.a, c.b.d.b.a, c.b.d.b.a, java.lang.Object
        /* renamed from: clone  reason: collision with other method in class */
        public Object m5clone() {
            throw null;
        }
    }

    public static abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends k0<MessageType, BuilderType> implements Object<MessageType, BuilderType> {

        /* renamed from: e  reason: collision with root package name */
        public f0<c> f5352e = f0.f5261d;

        @Override // c.b.d.k0, c.b.d.j1
        public /* bridge */ /* synthetic */ i1 getDefaultInstanceForType() {
            return k0.super.getDefaultInstanceForType();
        }

        public f0<c> k() {
            f0<c> f0Var = this.f5352e;
            if (f0Var.f5263b) {
                this.f5352e = f0Var.clone();
            }
            return this.f5352e;
        }

        @Override // c.b.d.k0, c.b.d.i1
        public /* bridge */ /* synthetic */ i1.a newBuilderForType() {
            return k0.super.newBuilderForType();
        }

        @Override // c.b.d.k0, c.b.d.i1
        public /* bridge */ /* synthetic */ i1.a toBuilder() {
            return k0.super.toBuilder();
        }
    }

    public static final class c implements f0.c<c> {

        /* renamed from: b  reason: collision with root package name */
        public final int f5353b;

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: c.b.d.k0$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.d.f0.c
        public i1.a O(i1.a aVar, i1 i1Var) {
            a aVar2 = (a) aVar;
            aVar2.d((k0) i1Var);
            return aVar2;
        }

        @Override // c.b.d.f0.c
        public int a() {
            return 0;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return 0 - ((c) obj).f5353b;
        }

        @Override // c.b.d.f0.c
        public boolean e() {
            return false;
        }

        @Override // c.b.d.f0.c
        public x2.b g() {
            return null;
        }

        @Override // c.b.d.f0.c
        public x2.c j() {
            throw null;
        }

        @Override // c.b.d.f0.c
        public boolean l() {
            return false;
        }
    }

    public static class d<ContainingType extends i1, Type> extends w<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        public final c f5354a;
    }

    public enum e {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static final class f implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        public final Class<?> f5361b;

        public f(i1 i1Var) {
            Class<?> cls = i1Var.getClass();
            this.f5361b = cls;
            cls.getName();
            i1Var.toByteArray();
        }
    }

    public static <T extends k0<?, ?>> T e(Class<T> cls) {
        k0<?, ?> k0Var = f5347d.get(cls);
        if (k0Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                k0Var = (T) f5347d.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (k0Var == null) {
            k0Var = (T) ((k0) v2.b(cls)).getDefaultInstanceForType();
            if (k0Var != null) {
                f5347d.put(cls, k0Var);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) k0Var;
    }

    public static final <T extends k0<T, ?>> boolean g(T t, boolean z) {
        byte byteValue = ((Byte) t.b(e.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean e2 = z1.f5964c.b(t).e(t);
        if (z) {
            t.c(e.SET_MEMOIZED_IS_INITIALIZED, e2 ? t : null);
        }
        return e2;
    }

    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
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

    public Object a() {
        return b(e.BUILD_MESSAGE_INFO);
    }

    public Object b(e eVar) {
        return d(eVar, null, null);
    }

    public Object c(e eVar, Object obj) {
        return d(eVar, obj, null);
    }

    public abstract Object d(e eVar, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        return z1.f5964c.b(this).b(this, (k0) obj);
    }

    /* renamed from: f */
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) ((k0) b(e.GET_DEFAULT_INSTANCE));
    }

    @Override // c.b.d.b
    public int getMemoizedSerializedSize() {
        return this.f5349c;
    }

    @Override // c.b.d.i1
    public final w1<MessageType> getParserForType() {
        return (w1) b(e.GET_PARSER);
    }

    @Override // c.b.d.i1
    public int getSerializedSize() {
        if (this.f5349c == -1) {
            this.f5349c = z1.f5964c.b(this).f(this);
        }
        return this.f5349c;
    }

    public void h() {
        z1.f5964c.b(this).g(this);
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int d2 = z1.f5964c.b(this).d(this);
        this.memoizedHashCode = d2;
        return d2;
    }

    /* renamed from: i */
    public final BuilderType newBuilderForType() {
        return (BuilderType) ((a) b(e.NEW_BUILDER));
    }

    @Override // c.b.d.j1
    public final boolean isInitialized() {
        return g(this, true);
    }

    /* renamed from: j */
    public final BuilderType toBuilder() {
        BuilderType buildertype = (BuilderType) ((a) b(e.NEW_BUILDER));
        buildertype.b();
        MessageType messagetype = buildertype.f5350b;
        z1.f5964c.b(messagetype).a(messagetype, this);
        return buildertype;
    }

    @Override // c.b.d.b
    public void setMemoizedSerializedSize(int i) {
        this.f5349c = i;
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        t.x2(this, sb, 0);
        return sb.toString();
    }

    @Override // c.b.d.i1
    public void writeTo(m mVar) {
        d2 b2 = z1.f5964c.b(this);
        n nVar = mVar.f5425a;
        if (nVar == null) {
            nVar = new n(mVar);
        }
        b2.j(this, nVar);
    }
}
