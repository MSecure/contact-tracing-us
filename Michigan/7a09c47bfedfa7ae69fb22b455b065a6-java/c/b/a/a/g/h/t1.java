package c.b.a.a.g.h;

import b.x.t;
import c.b.a.a.g.h.t1;
import c.b.a.a.g.h.t1.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class t1<MessageType extends t1<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends g0<MessageType, BuilderType> {
    public static Map<Object, t1<?, ?>> zzyb = new ConcurrentHashMap();
    public c4 zzxz = c4.f3851f;
    public int zzya = -1;

    public static abstract class a<MessageType extends t1<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends j0<MessageType, BuilderType> {

        /* renamed from: b  reason: collision with root package name */
        public final MessageType f4033b;

        /* renamed from: c  reason: collision with root package name */
        public MessageType f4034c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f4035d = false;

        public a(MessageType messagetype) {
            this.f4033b = messagetype;
            this.f4034c = (MessageType) ((t1) messagetype.g(4, null, null));
        }

        @Override // c.b.a.a.g.h.d3
        public final /* synthetic */ c3 b() {
            return this.f4033b;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: c.b.a.a.g.h.t1$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Object
        public /* synthetic */ Object clone() {
            a aVar = (a) this.f4033b.g(5, null, null);
            aVar.h((t1) j());
            return aVar;
        }

        public final j0 g(byte[] bArr, int i, int i2, e1 e1Var) {
            if (this.f4035d) {
                i();
                this.f4035d = false;
            }
            try {
                n3.f3973c.b(this.f4034c).g(this.f4034c, bArr, 0, i2, new n0(e1Var));
                return this;
            } catch (c2 e2) {
                throw e2;
            } catch (IndexOutOfBoundsException unused) {
                throw c2.a();
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            }
        }

        public final BuilderType h(MessageType messagetype) {
            if (this.f4035d) {
                i();
                this.f4035d = false;
            }
            MessageType messagetype2 = this.f4034c;
            n3.f3973c.b(messagetype2).h(messagetype2, messagetype);
            return this;
        }

        public void i() {
            MessageType messagetype = (MessageType) ((t1) this.f4034c.g(4, null, null));
            n3.f3973c.b(messagetype).h(messagetype, this.f4034c);
            this.f4034c = messagetype;
        }

        @Override // c.b.a.a.g.h.d3
        public final boolean isInitialized() {
            return t1.i(this.f4034c, false);
        }

        public c3 j() {
            if (!this.f4035d) {
                MessageType messagetype = this.f4034c;
                n3.f3973c.b(messagetype).a(messagetype);
                this.f4035d = true;
            }
            return this.f4034c;
        }
    }

    public static class b<T extends t1<T, ?>> extends l0<T> {
        public b(T t) {
        }
    }

    public static final class c implements l1<c> {

        /* renamed from: b  reason: collision with root package name */
        public final int f4036b;

        /* renamed from: c  reason: collision with root package name */
        public final p4 f4037c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f4038d;

        @Override // c.b.a.a.g.h.l1
        public final f3 E(f3 f3Var, f3 f3Var2) {
            throw new UnsupportedOperationException();
        }

        @Override // c.b.a.a.g.h.l1
        public final w4 K() {
            throw null;
        }

        @Override // c.b.a.a.g.h.l1
        public final boolean N() {
            return false;
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            return 0 - ((c) obj).f4036b;
        }

        @Override // c.b.a.a.g.h.l1
        public final int h() {
            return 0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: c.b.a.a.g.h.t1$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.a.a.g.h.l1
        public final b3 o(b3 b3Var, c3 c3Var) {
            return ((a) b3Var).h((t1) c3Var);
        }

        @Override // c.b.a.a.g.h.l1
        public final p4 u() {
            return null;
        }

        @Override // c.b.a.a.g.h.l1
        public final boolean w() {
            return false;
        }
    }

    public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends t1<MessageType, BuilderType> implements d3 {
        public j1<c> zzyg = j1.f3909d;

        public final j1<c> k() {
            j1<c> j1Var = this.zzyg;
            if (j1Var.f3911b) {
                this.zzyg = (j1) j1Var.clone();
            }
            return this.zzyg;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4039a = {1, 2, 3, 4, 5, 6, 7};
    }

    public static class f<ContainingType extends c3, Type> extends f1<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        public final c3 f4040a;

        /* renamed from: b  reason: collision with root package name */
        public final c f4041b;
    }

    public static Object h(Method method, Object obj, Object... objArr) {
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

    public static final <T extends t1<T, ?>> boolean i(T t, boolean z) {
        byte byteValue = ((Byte) t.g(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean f2 = n3.f3973c.b(t).f(t);
        if (z) {
            t.g(2, f2 ? t : null, null);
        }
        return f2;
    }

    public static <T extends t1<?, ?>> T j(Class<T> cls) {
        t1<?, ?> t1Var = zzyb.get(cls);
        if (t1Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t1Var = (T) zzyb.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t1Var == null) {
            t1Var = (T) ((t1) ((t1) j4.h(cls)).g(6, null, null));
            if (t1Var != null) {
                zzyb.put(cls, t1Var);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) t1Var;
    }

    @Override // c.b.a.a.g.h.c3
    public final /* synthetic */ b3 a() {
        return (a) g(5, null, null);
    }

    @Override // c.b.a.a.g.h.d3
    public final /* synthetic */ c3 b() {
        return (t1) g(6, null, null);
    }

    @Override // c.b.a.a.g.h.c3
    public final int d() {
        if (this.zzya == -1) {
            this.zzya = n3.f3973c.b(this).e(this);
        }
        return this.zzya;
    }

    @Override // c.b.a.a.g.h.c3
    public final /* synthetic */ b3 e() {
        a aVar = (a) g(5, null, null);
        aVar.h(this);
        return aVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return n3.f3973c.b(this).b(this, (t1) obj);
        }
        return false;
    }

    @Override // c.b.a.a.g.h.c3
    public final void f(b1 b1Var) {
        q3 b2 = n3.f3973c.b(this);
        d1 d1Var = b1Var.f3844a;
        if (d1Var == null) {
            d1Var = new d1(b1Var);
        }
        b2.i(this, d1Var);
    }

    public abstract Object g(int i, Object obj, Object obj2);

    public int hashCode() {
        int i = this.zzte;
        if (i != 0) {
            return i;
        }
        int d2 = n3.f3973c.b(this).d(this);
        this.zzte = d2;
        return d2;
    }

    @Override // c.b.a.a.g.h.d3
    public final boolean isInitialized() {
        return i(this, true);
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        t.i4(this, sb, 0);
        return sb.toString();
    }
}
