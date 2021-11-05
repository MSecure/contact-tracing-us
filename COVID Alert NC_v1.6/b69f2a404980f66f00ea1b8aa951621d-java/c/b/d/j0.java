package c.b.d;

import c.b.d.b;
import c.b.d.f0;
import c.b.d.h1;
import c.b.d.j0;
import c.b.d.j0.a;
import c.b.d.w2;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class j0<MessageType extends j0<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends b<MessageType, BuilderType> {

    /* renamed from: d  reason: collision with root package name */
    public static Map<Object, j0<?, ?>> f3920d = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public q2 f3921b = q2.f;

    /* renamed from: c  reason: collision with root package name */
    public int f3922c = -1;

    public static abstract class a<MessageType extends j0<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends b.a<MessageType, BuilderType> {

        /* renamed from: b  reason: collision with root package name */
        public MessageType f3923b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3924c;

        /* renamed from: a */
        public MessageType buildPartial() {
            if (this.f3924c) {
                return this.f3923b;
            }
            this.f3923b.h();
            this.f3924c = true;
            return this.f3923b;
        }

        public final void b() {
            if (this.f3924c) {
                MessageType messagetype = (MessageType) ((j0) this.f3923b.b(e.NEW_MUTABLE_INSTANCE));
                y1.f4411c.b(messagetype).a(messagetype, this.f3923b);
                this.f3923b = messagetype;
                this.f3924c = false;
            }
        }

        @Override // c.b.d.h1.a
        public h1 build() {
            MessageType a2 = buildPartial();
            if (a2.isInitialized()) {
                return a2;
            }
            throw b.a.newUninitializedMessageException(a2);
        }

        public BuilderType c(k kVar, z zVar) {
            b();
            try {
                c2 b2 = y1.f4411c.b(this.f3923b);
                MessageType messagetype = this.f3923b;
                l lVar = kVar.f3937d;
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
            MessageType messagetype2 = this.f3923b;
            y1.f4411c.b(messagetype2).a(messagetype2, messagetype);
            return this;
        }

        public BuilderType e(byte[] bArr, int i, int i2, z zVar) {
            b();
            try {
                y1.f4411c.b(this.f3923b).i(this.f3923b, bArr, i, i + i2, new f(zVar));
                return this;
            } catch (n0 e2) {
                throw e2;
            } catch (IndexOutOfBoundsException unused) {
                throw n0.i();
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            }
        }

        @Override // c.b.d.i1
        public h1 getDefaultInstanceForType() {
            return null;
        }

        @Override // c.b.d.b.a
        public b.a internalMergeFrom(b bVar) {
            b();
            MessageType messagetype = this.f3923b;
            y1.f4411c.b(messagetype).a(messagetype, (j0) bVar);
            return this;
        }

        @Override // c.b.d.i1
        public final boolean isInitialized() {
            return j0.g(this.f3923b, false);
        }

        @Override // c.b.d.b.a, c.b.d.b.a
        public b.a mergeFrom(byte[] bArr, int i, int i2) {
            e(bArr, i, i2, z.a());
            return this;
        }

        @Override // c.b.d.b.a, c.b.d.b.a, c.b.d.b.a, java.lang.Object
        /* renamed from: clone  reason: collision with other method in class */
        public h1.a m4clone() {
            throw null;
        }

        @Override // c.b.d.b.a, c.b.d.b.a
        /* renamed from: mergeFrom  reason: collision with other method in class */
        public h1.a m6mergeFrom(byte[] bArr, int i, int i2) {
            e(bArr, i, i2, z.a());
            return this;
        }

        @Override // c.b.d.b.a, c.b.d.b.a, c.b.d.b.a, java.lang.Object
        /* renamed from: clone  reason: collision with other method in class */
        public Object m5clone() {
            throw null;
        }
    }

    public static abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends j0<MessageType, BuilderType> implements Object<MessageType, BuilderType> {

        /* renamed from: e  reason: collision with root package name */
        public f0<c> f3925e = f0.f3858d;

        @Override // c.b.d.j0, c.b.d.i1
        public /* bridge */ /* synthetic */ h1 getDefaultInstanceForType() {
            return j0.super.getDefaultInstanceForType();
        }

        public f0<c> k() {
            f0<c> f0Var = this.f3925e;
            if (f0Var.f3860b) {
                this.f3925e = f0Var.clone();
            }
            return this.f3925e;
        }

        @Override // c.b.d.j0, c.b.d.h1
        public /* bridge */ /* synthetic */ h1.a newBuilderForType() {
            return j0.super.newBuilderForType();
        }

        @Override // c.b.d.j0, c.b.d.h1
        public /* bridge */ /* synthetic */ h1.a toBuilder() {
            return j0.super.toBuilder();
        }
    }

    public static final class c implements f0.c<c> {

        /* renamed from: b  reason: collision with root package name */
        public final int f3926b;

        @Override // c.b.d.f0.c
        public int a() {
            return 0;
        }

        @Override // c.b.d.f0.c
        public boolean c() {
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return 0 - ((c) obj).f3926b;
        }

        @Override // c.b.d.f0.c
        public w2.b e() {
            return null;
        }

        @Override // c.b.d.f0.c
        public w2.c h() {
            throw null;
        }

        @Override // c.b.d.f0.c
        public boolean j() {
            return false;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: c.b.d.j0$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.d.f0.c
        public h1.a r(h1.a aVar, h1 h1Var) {
            a aVar2 = (a) aVar;
            aVar2.d((j0) h1Var);
            return aVar2;
        }
    }

    public static class d<ContainingType extends h1, Type> extends w<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        public final c f3927a;
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
        public final Class<?> f3932b;

        public f(h1 h1Var) {
            Class<?> cls = h1Var.getClass();
            this.f3932b = cls;
            cls.getName();
            h1Var.toByteArray();
        }
    }

    public static <T extends j0<?, ?>> T e(Class<T> cls) {
        j0<?, ?> j0Var = f3920d.get(cls);
        if (j0Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                j0Var = (T) f3920d.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (j0Var == null) {
            j0Var = (T) ((j0) u2.b(cls)).getDefaultInstanceForType();
            if (j0Var != null) {
                f3920d.put(cls, j0Var);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) j0Var;
    }

    public static final <T extends j0<T, ?>> boolean g(T t, boolean z) {
        byte byteValue = ((Byte) t.b(e.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean b2 = y1.f4411c.b(t).b(t);
        if (z) {
            t.c(e.SET_MEMOIZED_IS_INITIALIZED, b2 ? t : null);
        }
        return b2;
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
        return y1.f4411c.b(this).c(this, (j0) obj);
    }

    /* renamed from: f */
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) ((j0) b(e.GET_DEFAULT_INSTANCE));
    }

    @Override // c.b.d.b
    public int getMemoizedSerializedSize() {
        return this.f3922c;
    }

    @Override // c.b.d.h1
    public final v1<MessageType> getParserForType() {
        return (v1) b(e.GET_PARSER);
    }

    @Override // c.b.d.h1
    public int getSerializedSize() {
        if (this.f3922c == -1) {
            this.f3922c = y1.f4411c.b(this).d(this);
        }
        return this.f3922c;
    }

    public void h() {
        y1.f4411c.b(this).f(this);
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int g = y1.f4411c.b(this).g(this);
        this.memoizedHashCode = g;
        return g;
    }

    /* renamed from: i */
    public final BuilderType newBuilderForType() {
        return (BuilderType) ((a) b(e.NEW_BUILDER));
    }

    @Override // c.b.d.i1
    public final boolean isInitialized() {
        return g(this, true);
    }

    /* renamed from: j */
    public final BuilderType toBuilder() {
        BuilderType buildertype = (BuilderType) ((a) b(e.NEW_BUILDER));
        buildertype.b();
        MessageType messagetype = buildertype.f3923b;
        y1.f4411c.b(messagetype).a(messagetype, this);
        return buildertype;
    }

    @Override // c.b.d.b
    public void setMemoizedSerializedSize(int i) {
        this.f3922c = i;
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        c.b.a.a.c.n.c.S1(this, sb, 0);
        return sb.toString();
    }

    @Override // c.b.d.h1
    public void writeTo(m mVar) {
        c2 b2 = y1.f4411c.b(this);
        n nVar = mVar.f3993a;
        if (nVar == null) {
            nVar = new n(mVar);
        }
        b2.j(this, nVar);
    }
}
