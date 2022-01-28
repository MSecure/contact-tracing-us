package c.b.a.a.g.b;

import b.x.t;
import c.b.a.a.g.b.z0;
import c.b.a.a.g.b.z0.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class z0<MessageType extends z0<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends p<MessageType, BuilderType> {
    public static Map<Object, z0<?, ?>> zzjr = new ConcurrentHashMap();
    public i3 zzjp = i3.f3314f;
    public int zzjq = -1;

    public static abstract class a<MessageType extends z0<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends q<MessageType, BuilderType> {

        /* renamed from: b  reason: collision with root package name */
        public final MessageType f3484b;

        /* renamed from: c  reason: collision with root package name */
        public MessageType f3485c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3486d = false;

        public a(MessageType messagetype) {
            this.f3484b = messagetype;
            this.f3485c = (MessageType) ((z0) messagetype.g(4, null, null));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: c.b.a.a.g.b.z0$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Object
        public /* synthetic */ Object clone() {
            a aVar = (a) this.f3484b.g(5, null, null);
            aVar.g((z0) i());
            return aVar;
        }

        @Override // c.b.a.a.g.b.g2
        public final /* synthetic */ e2 e() {
            return this.f3484b;
        }

        public final BuilderType g(MessageType messagetype) {
            h();
            MessageType messagetype2 = this.f3485c;
            p2.f3390c.b(messagetype2).e(messagetype2, messagetype);
            return this;
        }

        public void h() {
            if (this.f3486d) {
                MessageType messagetype = (MessageType) ((z0) this.f3485c.g(4, null, null));
                p2.f3390c.b(messagetype).e(messagetype, this.f3485c);
                this.f3485c = messagetype;
                this.f3486d = false;
            }
        }

        public e2 i() {
            if (!this.f3486d) {
                MessageType messagetype = this.f3485c;
                p2.f3390c.b(messagetype).i(messagetype);
                this.f3486d = true;
            }
            return this.f3485c;
        }

        @Override // c.b.a.a.g.b.g2
        public final boolean isInitialized() {
            return z0.i(this.f3485c);
        }
    }

    public static class b<T extends z0<T, ?>> extends r<T> {
        public b(T t) {
        }
    }

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends z0<MessageType, BuilderType> implements g2 {
        public q0<d> zzjv = q0.f3394d;
    }

    public static final class d implements t0<d> {

        /* renamed from: b  reason: collision with root package name */
        public final int f3487b;

        /* renamed from: c  reason: collision with root package name */
        public final v3 f3488c;

        @Override // c.b.a.a.g.b.t0
        public final v3 I() {
            return null;
        }

        @Override // c.b.a.a.g.b.t0
        public final j2 J(j2 j2Var, j2 j2Var2) {
            throw new UnsupportedOperationException();
        }

        @Override // c.b.a.a.g.b.t0
        public final boolean M() {
            return false;
        }

        @Override // c.b.a.a.g.b.t0
        public final int c() {
            return 0;
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            return 0 - ((d) obj).f3487b;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: c.b.a.a.g.b.z0$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.a.a.g.b.t0
        public final f2 q(f2 f2Var, e2 e2Var) {
            return ((a) f2Var).g((z0) e2Var);
        }

        @Override // c.b.a.a.g.b.t0
        public final a4 v() {
            throw null;
        }

        @Override // c.b.a.a.g.b.t0
        public final boolean z() {
            return false;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3489a = {1, 2, 3, 4, 5, 6, 7};
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

    /* JADX WARN: Incorrect args count in method signature: <T:Lc/b/a/a/g/b/z0<TT;*>;>(TT;Z)Z */
    public static final boolean i(z0 z0Var) {
        byte byteValue = ((Byte) z0Var.g(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        return p2.f3390c.b(z0Var).f(z0Var);
    }

    public static <T extends z0<?, ?>> T j(Class<T> cls) {
        T t = (T) zzjr.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) zzjr.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t != null) {
            return t;
        }
        String name = cls.getName();
        throw new IllegalStateException(name.length() != 0 ? "Unable to get default instance for: ".concat(name) : new String("Unable to get default instance for: "));
    }

    @Override // c.b.a.a.g.b.e2
    public final /* synthetic */ f2 a() {
        return (a) g(5, null, null);
    }

    @Override // c.b.a.a.g.b.e2
    public final void b(g0 g0Var) {
        u2 a2 = p2.f3390c.a(getClass());
        i0 i0Var = g0Var.f3271a;
        if (i0Var == null) {
            i0Var = new i0(g0Var);
        }
        a2.g(this, i0Var);
    }

    @Override // c.b.a.a.g.b.e2
    public final /* synthetic */ f2 c() {
        a aVar = (a) g(5, null, null);
        aVar.g(this);
        return aVar;
    }

    @Override // c.b.a.a.g.b.e2
    public final int d() {
        if (this.zzjq == -1) {
            this.zzjq = p2.f3390c.b(this).j(this);
        }
        return this.zzjq;
    }

    @Override // c.b.a.a.g.b.g2
    public final /* synthetic */ e2 e() {
        return (z0) g(6, null, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((z0) g(6, null, null)).getClass().isInstance(obj)) {
            return false;
        }
        return p2.f3390c.b(this).b(this, (z0) obj);
    }

    public abstract Object g(int i, Object obj, Object obj2);

    public int hashCode() {
        int i = this.zzex;
        if (i != 0) {
            return i;
        }
        int d2 = p2.f3390c.b(this).d(this);
        this.zzex = d2;
        return d2;
    }

    @Override // c.b.a.a.g.b.g2
    public final boolean isInitialized() {
        byte byteValue = ((Byte) g(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean f2 = p2.f3390c.b(this).f(this);
        g(2, f2 ? this : null, null);
        return f2;
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        t.h4(this, sb, 0);
        return sb.toString();
    }
}
