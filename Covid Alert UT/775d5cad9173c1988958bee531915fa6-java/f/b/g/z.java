package f.b.g;

import f.b.g.a;
import f.b.g.c0;
import f.b.g.t0;
import f.b.g.v;
import f.b.g.z;
import f.b.g.z.a;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public abstract class z<MessageType extends z<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a<MessageType, BuilderType> {
    private static Map<Object, z<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    public int memoizedSerializedSize = -1;
    public s1 unknownFields = s1.f3682f;

    public static class b<T extends z<T, ?>> extends b<T> {
        public final T a;

        public b(T t) {
            this.a = t;
        }
    }

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends z<MessageType, BuilderType> implements Object<MessageType, BuilderType> {
        public v<d> extensions = v.f3686d;

        public v<d> b() {
            v<d> vVar = this.extensions;
            if (vVar.b) {
                this.extensions = vVar.clone();
            }
            return this.extensions;
        }

        @Override // f.b.g.z, f.b.g.z, f.b.g.u0
        public /* bridge */ /* synthetic */ t0 getDefaultInstanceForType() {
            return z.super.getDefaultInstanceForType();
        }

        @Override // f.b.g.z, f.b.g.z, f.b.g.t0
        public /* bridge */ /* synthetic */ t0.a newBuilderForType() {
            return z.super.newBuilderForType();
        }

        @Override // f.b.g.z, f.b.g.z, f.b.g.t0
        public /* bridge */ /* synthetic */ t0.a toBuilder() {
            return z.super.toBuilder();
        }
    }

    public static final class d implements v.a<d> {
        public final c0.d<?> b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final y1 f3729d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f3730e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f3731f;

        public d(c0.d<?> dVar, int i2, y1 y1Var, boolean z, boolean z2) {
            this.b = dVar;
            this.c = i2;
            this.f3729d = y1Var;
            this.f3730e = z;
            this.f3731f = z2;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.c - ((d) obj).c;
        }

        @Override // f.b.g.v.a
        public boolean d() {
            return this.f3730e;
        }

        @Override // f.b.g.v.a
        public y1 g() {
            return this.f3729d;
        }

        @Override // f.b.g.v.a
        public int getNumber() {
            return this.c;
        }

        @Override // f.b.g.v.a
        public z1 j() {
            return this.f3729d.b;
        }

        @Override // f.b.g.v.a
        public boolean k() {
            return this.f3731f;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: f.b.g.z$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.g.v.a
        public t0.a p(t0.a aVar, t0 t0Var) {
            return ((a) aVar).mergeFrom((z) t0Var);
        }
    }

    public static class e<ContainingType extends t0, Type> extends p<ContainingType, Type> {
        public final ContainingType a;
        public final Type b;
        public final t0 c;

        /* renamed from: d  reason: collision with root package name */
        public final d f3732d;

        /* JADX WARN: Incorrect args count in method signature: (TContainingType;TType;Lf/b/g/t0;Lf/b/g/z$d;Ljava/lang/Class;)V */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: f.b.g.t0 */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        public e(t0 t0Var, Object obj, t0 t0Var2, d dVar) {
            if (t0Var == 0) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (dVar.f3729d == y1.MESSAGE && t0Var2 == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.a = t0Var;
                this.b = obj;
                this.c = t0Var2;
                this.f3732d = dVar;
            }
        }
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

    /* access modifiers changed from: private */
    public static <MessageType extends c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>, T> e<MessageType, T> checkIsLite(p<MessageType, T> pVar) {
        Objects.requireNonNull(pVar);
        return (e) pVar;
    }

    private static <T extends z<T, ?>> T checkMessageInitialized(T t) {
        if (t == null || t.isInitialized()) {
            return t;
        }
        q1 newUninitializedMessageException = t.newUninitializedMessageException();
        Objects.requireNonNull(newUninitializedMessageException);
        throw new d0(newUninitializedMessageException.getMessage());
    }

    public static c0.a emptyBooleanList() {
        return h.f3614e;
    }

    public static c0.b emptyDoubleList() {
        return o.f3680e;
    }

    public static c0.f emptyFloatList() {
        return x.f3718e;
    }

    public static c0.g emptyIntList() {
        return b0.f3595e;
    }

    public static c0.h emptyLongList() {
        return k0.f3659e;
    }

    public static <E> c0.i<E> emptyProtobufList() {
        return f1.f3608e;
    }

    private final void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == s1.f3682f) {
            this.unknownFields = s1.e();
        }
    }

    public static <T extends z<?, ?>> T getDefaultInstance(Class<T> cls) {
        z<?, ?> zVar = defaultInstanceMap.get(cls);
        if (zVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zVar = (T) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zVar == null) {
            zVar = (T) ((z) v1.b(cls)).getDefaultInstanceForType();
            if (zVar != null) {
                defaultInstanceMap.put(cls, zVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zVar;
    }

    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            StringBuilder h2 = f.a.a.a.a.h("Generated message class \"");
            h2.append(cls.getName());
            h2.append("\" missing method \"");
            h2.append(str);
            h2.append("\".");
            throw new RuntimeException(h2.toString(), e2);
        }
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

    public static final <T extends z<T, ?>> boolean isInitialized(T t, boolean z) {
        byte byteValue = ((Byte) t.dynamicMethod(f.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean b2 = e1.c.b(t).b(t);
        if (z) {
            t.dynamicMethod(f.SET_MEMOIZED_IS_INITIALIZED, b2 ? t : null);
        }
        return b2;
    }

    public static c0.a mutableCopy(c0.a aVar) {
        int i2 = ((h) aVar).f3615d;
        return ((h) aVar).d(i2 == 0 ? 10 : i2 * 2);
    }

    public static <E> c0.i<E> mutableCopy(c0.i<E> iVar) {
        int size = iVar.size();
        return iVar.d(size == 0 ? 10 : size * 2);
    }

    public static Object newMessageInfo(t0 t0Var, String str, Object[] objArr) {
        return new g1(t0Var, str, objArr);
    }

    public static <ContainingType extends t0, Type> e<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, t0 t0Var, c0.d<?> dVar, int i2, y1 y1Var, boolean z, Class cls) {
        return new e<>(containingtype, Collections.emptyList(), t0Var, new d(dVar, i2, y1Var, true, z));
    }

    public static <ContainingType extends t0, Type> e<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, t0 t0Var, c0.d<?> dVar, int i2, y1 y1Var, Class cls) {
        return new e<>(containingtype, type, t0Var, new d(dVar, i2, y1Var, false, false));
    }

    public static <T extends z<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream) {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, r.a()));
    }

    public static <T extends z<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream, r rVar) {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, rVar));
    }

    public static <T extends z<T, ?>> T parseFrom(T t, j jVar) {
        return (T) checkMessageInitialized(parseFrom(t, jVar, r.a()));
    }

    public static <T extends z<T, ?>> T parseFrom(T t, j jVar, r rVar) {
        return (T) checkMessageInitialized(parsePartialFrom(t, jVar, rVar));
    }

    public static <T extends z<T, ?>> T parseFrom(T t, k kVar) {
        return (T) parseFrom(t, kVar, r.a());
    }

    public static <T extends z<T, ?>> T parseFrom(T t, k kVar, r rVar) {
        return (T) checkMessageInitialized(parsePartialFrom(t, kVar, rVar));
    }

    public static <T extends z<T, ?>> T parseFrom(T t, InputStream inputStream) {
        return (T) checkMessageInitialized(parsePartialFrom(t, k.f(inputStream), r.a()));
    }

    public static <T extends z<T, ?>> T parseFrom(T t, InputStream inputStream, r rVar) {
        return (T) checkMessageInitialized(parsePartialFrom(t, k.f(inputStream), rVar));
    }

    public static <T extends z<T, ?>> T parseFrom(T t, ByteBuffer byteBuffer) {
        return (T) parseFrom(t, byteBuffer, r.a());
    }

    public static <T extends z<T, ?>> T parseFrom(T t, ByteBuffer byteBuffer, r rVar) {
        return (T) checkMessageInitialized(parseFrom(t, k.g(byteBuffer, false), rVar));
    }

    public static <T extends z<T, ?>> T parseFrom(T t, byte[] bArr) {
        return (T) checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, r.a()));
    }

    public static <T extends z<T, ?>> T parseFrom(T t, byte[] bArr, r rVar) {
        return (T) checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, rVar));
    }

    private static <T extends z<T, ?>> T parsePartialDelimitedFrom(T t, InputStream inputStream, r rVar) {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            k f2 = k.f(new a.AbstractC0124a.C0125a(inputStream, k.t(read, inputStream)));
            T t2 = (T) parsePartialFrom(t, f2, rVar);
            try {
                f2.a(0);
                return t2;
            } catch (d0 e2) {
                throw e2;
            }
        } catch (IOException e3) {
            throw new d0(e3.getMessage());
        }
    }

    private static <T extends z<T, ?>> T parsePartialFrom(T t, j jVar, r rVar) {
        try {
            k v = jVar.v();
            T t2 = (T) parsePartialFrom(t, v, rVar);
            try {
                v.a(0);
                return t2;
            } catch (d0 e2) {
                throw e2;
            }
        } catch (d0 e3) {
            throw e3;
        }
    }

    public static <T extends z<T, ?>> T parsePartialFrom(T t, k kVar) {
        return (T) parsePartialFrom(t, kVar, r.a());
    }

    public static <T extends z<T, ?>> T parsePartialFrom(T t, k kVar, r rVar) {
        T t2 = (T) ((z) t.dynamicMethod(f.NEW_MUTABLE_INSTANCE));
        try {
            j1 b2 = e1.c.b(t2);
            l lVar = kVar.f3634d;
            if (lVar == null) {
                lVar = new l(kVar);
            }
            b2.c(t2, lVar, rVar);
            b2.i(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof d0) {
                throw ((d0) e2.getCause());
            }
            throw new d0(e2.getMessage());
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof d0) {
                throw ((d0) e3.getCause());
            }
            throw e3;
        }
    }

    private static <T extends z<T, ?>> T parsePartialFrom(T t, byte[] bArr, r rVar) {
        return (T) checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, rVar));
    }

    public static <T extends z<?, ?>> void registerDefaultInstance(Class<T> cls, T t) {
        defaultInstanceMap.put(cls, t);
    }

    public Object buildMessageInfo() {
        return dynamicMethod(f.BUILD_MESSAGE_INFO);
    }

    public final <MessageType extends z<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType createBuilder() {
        return (BuilderType) ((a) dynamicMethod(f.NEW_BUILDER));
    }

    public final <MessageType extends z<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType createBuilder(MessageType messagetype) {
        return (BuilderType) createBuilder().mergeFrom(messagetype);
    }

    public Object dynamicMethod(f fVar) {
        return dynamicMethod(fVar, null, null);
    }

    public Object dynamicMethod(f fVar, Object obj) {
        return dynamicMethod(fVar, obj, null);
    }

    public abstract Object dynamicMethod(f fVar, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        return e1.c.b(this).d(this, (z) obj);
    }

    @Override // f.b.g.u0
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) ((z) dynamicMethod(f.GET_DEFAULT_INSTANCE));
    }

    @Override // f.b.g.a
    public int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize;
    }

    @Override // f.b.g.t0
    public final b1<MessageType> getParserForType() {
        return (b1) dynamicMethod(f.GET_PARSER);
    }

    @Override // f.b.g.t0
    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = e1.c.b(this).f(this);
        }
        return this.memoizedSerializedSize;
    }

    public int hashCode() {
        int i2 = this.memoizedHashCode;
        if (i2 != 0) {
            return i2;
        }
        int j2 = e1.c.b(this).j(this);
        this.memoizedHashCode = j2;
        return j2;
    }

    @Override // f.b.g.u0
    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    public void makeImmutable() {
        e1.c.b(this).i(this);
    }

    public void mergeLengthDelimitedField(int i2, j jVar) {
        ensureUnknownFieldsInitialized();
        s1 s1Var = this.unknownFields;
        s1Var.a();
        if (i2 != 0) {
            s1Var.f((i2 << 3) | 2, jVar);
            return;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public final void mergeUnknownFields(s1 s1Var) {
        this.unknownFields = s1.d(this.unknownFields, s1Var);
    }

    public void mergeVarintField(int i2, int i3) {
        ensureUnknownFieldsInitialized();
        s1 s1Var = this.unknownFields;
        s1Var.a();
        if (i2 != 0) {
            s1Var.f((i2 << 3) | 0, Long.valueOf((long) i3));
            return;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    @Override // f.b.g.t0
    public final BuilderType newBuilderForType() {
        return (BuilderType) ((a) dynamicMethod(f.NEW_BUILDER));
    }

    public boolean parseUnknownField(int i2, k kVar) {
        if ((i2 & 7) == 4) {
            return false;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.c(i2, kVar);
    }

    @Override // f.b.g.a
    public void setMemoizedSerializedSize(int i2) {
        this.memoizedSerializedSize = i2;
    }

    @Override // f.b.g.t0
    public final BuilderType toBuilder() {
        BuilderType buildertype = (BuilderType) ((a) dynamicMethod(f.NEW_BUILDER));
        buildertype.mergeFrom(this);
        return buildertype;
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        f.b.a.c.b.o.b.i1(this, sb, 0);
        return sb.toString();
    }

    @Override // f.b.g.t0
    public void writeTo(m mVar) {
        j1 b2 = e1.c.b(this);
        n nVar = mVar.a;
        if (nVar == null) {
            nVar = new n(mVar);
        }
        b2.h(this, nVar);
    }

    public static c0.b mutableCopy(c0.b bVar) {
        int i2 = ((o) bVar).f3681d;
        return ((o) bVar).d(i2 == 0 ? 10 : i2 * 2);
    }

    public static abstract class a<MessageType extends z<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a.AbstractC0124a<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        public MessageType instance;
        public boolean isBuilt = false;

        public a(MessageType messagetype) {
            this.defaultInstance = messagetype;
            this.instance = (MessageType) ((z) messagetype.dynamicMethod(f.NEW_MUTABLE_INSTANCE));
        }

        private void mergeFromInstance(MessageType messagetype, MessageType messagetype2) {
            e1.c.b(messagetype).a(messagetype, messagetype2);
        }

        @Override // f.b.g.t0.a
        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw a.AbstractC0124a.newUninitializedMessageException(buildPartial);
        }

        @Override // f.b.g.t0.a
        public MessageType buildPartial() {
            if (this.isBuilt) {
                return this.instance;
            }
            this.instance.makeImmutable();
            this.isBuilt = true;
            return this.instance;
        }

        public final BuilderType clear() {
            this.instance = (MessageType) ((z) this.instance.dynamicMethod(f.NEW_MUTABLE_INSTANCE));
            return this;
        }

        @Override // java.lang.Object, f.b.g.a.AbstractC0124a, f.b.g.a.AbstractC0124a, f.b.g.a.AbstractC0124a
        public BuilderType clone() {
            BuilderType buildertype = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            buildertype.mergeFrom(buildPartial());
            return buildertype;
        }

        public final void copyOnWrite() {
            if (this.isBuilt) {
                copyOnWriteInternal();
                this.isBuilt = false;
            }
        }

        public void copyOnWriteInternal() {
            MessageType messagetype = (MessageType) ((z) this.instance.dynamicMethod(f.NEW_MUTABLE_INSTANCE));
            mergeFromInstance(messagetype, this.instance);
            this.instance = messagetype;
        }

        @Override // f.b.g.u0
        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        public BuilderType internalMergeFrom(MessageType messagetype) {
            return mergeFrom((z) messagetype);
        }

        @Override // f.b.g.u0
        public final boolean isInitialized() {
            return z.isInitialized(this.instance, false);
        }

        @Override // f.b.g.a.AbstractC0124a, f.b.g.a.AbstractC0124a
        public BuilderType mergeFrom(k kVar, r rVar) {
            copyOnWrite();
            try {
                j1 b = e1.c.b(this.instance);
                MessageType messagetype = this.instance;
                l lVar = kVar.f3634d;
                if (lVar == null) {
                    lVar = new l(kVar);
                }
                b.c(messagetype, lVar, rVar);
                return this;
            } catch (RuntimeException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw e2;
            }
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            copyOnWrite();
            mergeFromInstance(this.instance, messagetype);
            return this;
        }

        @Override // f.b.g.a.AbstractC0124a, f.b.g.a.AbstractC0124a
        public BuilderType mergeFrom(byte[] bArr, int i2, int i3) {
            return mergeFrom(bArr, i2, i3, r.a());
        }

        @Override // f.b.g.a.AbstractC0124a, f.b.g.a.AbstractC0124a
        public BuilderType mergeFrom(byte[] bArr, int i2, int i3, r rVar) {
            copyOnWrite();
            try {
                e1.c.b(this.instance).e(this.instance, bArr, i2, i2 + i3, new f(rVar));
                return this;
            } catch (d0 e2) {
                throw e2;
            } catch (IndexOutOfBoundsException unused) {
                throw d0.h();
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            }
        }
    }

    public static c0.f mutableCopy(c0.f fVar) {
        int i2 = ((x) fVar).f3719d;
        return ((x) fVar).d(i2 == 0 ? 10 : i2 * 2);
    }

    public static <T extends z<T, ?>> T parsePartialFrom(T t, byte[] bArr, int i2, int i3, r rVar) {
        T t2 = (T) ((z) t.dynamicMethod(f.NEW_MUTABLE_INSTANCE));
        try {
            j1 b2 = e1.c.b(t2);
            b2.e(t2, bArr, i2, i2 + i3, new f(rVar));
            b2.i(t2);
            if (t2.memoizedHashCode == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof d0) {
                throw ((d0) e2.getCause());
            }
            throw new d0(e2.getMessage());
        } catch (IndexOutOfBoundsException unused) {
            throw d0.h();
        }
    }

    public static c0.g mutableCopy(c0.g gVar) {
        int i2 = ((b0) gVar).f3596d;
        return ((b0) gVar).d(i2 == 0 ? 10 : i2 * 2);
    }

    public static c0.h mutableCopy(c0.h hVar) {
        int i2 = ((k0) hVar).f3660d;
        return ((k0) hVar).d(i2 == 0 ? 10 : i2 * 2);
    }
}
