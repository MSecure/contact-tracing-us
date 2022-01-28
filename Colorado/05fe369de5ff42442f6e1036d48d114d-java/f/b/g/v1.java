package f.b.g;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public final class v1 {
    public static final Logger a = Logger.getLogger(v1.class.getName());
    public static final Unsafe b;
    public static final Class<?> c = d.a;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f3632d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f3633e;

    /* renamed from: f  reason: collision with root package name */
    public static final e f3634f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f3635g;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f3636h;

    /* renamed from: i  reason: collision with root package name */
    public static final long f3637i = ((long) c(byte[].class));

    /* renamed from: j  reason: collision with root package name */
    public static final long f3638j;

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f3639k = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    public static class a implements PrivilegedExceptionAction<Unsafe> {
        /* renamed from: a */
        public Unsafe run() {
            Field[] declaredFields = Unsafe.class.getDeclaredFields();
            for (Field field : declaredFields) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    public static final class b extends e {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // f.b.g.v1.e
        public void c(long j2, byte[] bArr, long j3, long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // f.b.g.v1.e
        public boolean d(Object obj, long j2) {
            if (v1.f3639k) {
                return v1.j(obj, j2) != 0;
            }
            if (v1.k(obj, j2) != 0) {
                return true;
            }
            return false;
        }

        @Override // f.b.g.v1.e
        public byte e(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // f.b.g.v1.e
        public byte f(Object obj, long j2) {
            if (v1.f3639k) {
                return v1.j(obj, j2);
            }
            return v1.k(obj, j2);
        }

        @Override // f.b.g.v1.e
        public double g(Object obj, long j2) {
            return Double.longBitsToDouble(j(obj, j2));
        }

        @Override // f.b.g.v1.e
        public float h(Object obj, long j2) {
            return Float.intBitsToFloat(i(obj, j2));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.g.v1.e
        public void m(Object obj, long j2, boolean z) {
            if (v1.f3639k) {
                v1.t(obj, j2, z ? (byte) 1 : 0);
            } else {
                v1.u(obj, j2, z ? (byte) 1 : 0);
            }
        }

        @Override // f.b.g.v1.e
        public void n(Object obj, long j2, byte b) {
            if (v1.f3639k) {
                v1.t(obj, j2, b);
            } else {
                v1.u(obj, j2, b);
            }
        }

        @Override // f.b.g.v1.e
        public void o(Object obj, long j2, double d2) {
            r(obj, j2, Double.doubleToLongBits(d2));
        }

        @Override // f.b.g.v1.e
        public void p(Object obj, long j2, float f2) {
            q(obj, j2, Float.floatToIntBits(f2));
        }
    }

    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // f.b.g.v1.e
        public void c(long j2, byte[] bArr, long j3, long j4) {
            throw new UnsupportedOperationException();
        }

        @Override // f.b.g.v1.e
        public boolean d(Object obj, long j2) {
            if (v1.f3639k) {
                return v1.j(obj, j2) != 0;
            }
            if (v1.k(obj, j2) != 0) {
                return true;
            }
            return false;
        }

        @Override // f.b.g.v1.e
        public byte e(long j2) {
            throw new UnsupportedOperationException();
        }

        @Override // f.b.g.v1.e
        public byte f(Object obj, long j2) {
            if (v1.f3639k) {
                return v1.j(obj, j2);
            }
            return v1.k(obj, j2);
        }

        @Override // f.b.g.v1.e
        public double g(Object obj, long j2) {
            return Double.longBitsToDouble(j(obj, j2));
        }

        @Override // f.b.g.v1.e
        public float h(Object obj, long j2) {
            return Float.intBitsToFloat(i(obj, j2));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.g.v1.e
        public void m(Object obj, long j2, boolean z) {
            if (v1.f3639k) {
                v1.t(obj, j2, z ? (byte) 1 : 0);
            } else {
                v1.u(obj, j2, z ? (byte) 1 : 0);
            }
        }

        @Override // f.b.g.v1.e
        public void n(Object obj, long j2, byte b) {
            if (v1.f3639k) {
                v1.t(obj, j2, b);
            } else {
                v1.u(obj, j2, b);
            }
        }

        @Override // f.b.g.v1.e
        public void o(Object obj, long j2, double d2) {
            r(obj, j2, Double.doubleToLongBits(d2));
        }

        @Override // f.b.g.v1.e
        public void p(Object obj, long j2, float f2) {
            q(obj, j2, Float.floatToIntBits(f2));
        }
    }

    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // f.b.g.v1.e
        public void c(long j2, byte[] bArr, long j3, long j4) {
            this.a.copyMemory((Object) null, j2, bArr, v1.f3637i + j3, j4);
        }

        @Override // f.b.g.v1.e
        public boolean d(Object obj, long j2) {
            return this.a.getBoolean(obj, j2);
        }

        @Override // f.b.g.v1.e
        public byte e(long j2) {
            return this.a.getByte(j2);
        }

        @Override // f.b.g.v1.e
        public byte f(Object obj, long j2) {
            return this.a.getByte(obj, j2);
        }

        @Override // f.b.g.v1.e
        public double g(Object obj, long j2) {
            return this.a.getDouble(obj, j2);
        }

        @Override // f.b.g.v1.e
        public float h(Object obj, long j2) {
            return this.a.getFloat(obj, j2);
        }

        @Override // f.b.g.v1.e
        public void m(Object obj, long j2, boolean z) {
            this.a.putBoolean(obj, j2, z);
        }

        @Override // f.b.g.v1.e
        public void n(Object obj, long j2, byte b) {
            this.a.putByte(obj, j2, b);
        }

        @Override // f.b.g.v1.e
        public void o(Object obj, long j2, double d2) {
            this.a.putDouble(obj, j2, d2);
        }

        @Override // f.b.g.v1.e
        public void p(Object obj, long j2, float f2) {
            this.a.putFloat(obj, j2, f2);
        }
    }

    public static abstract class e {
        public Unsafe a;

        public e(Unsafe unsafe) {
            this.a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.a.arrayIndexScale(cls);
        }

        public abstract void c(long j2, byte[] bArr, long j3, long j4);

        public abstract boolean d(Object obj, long j2);

        public abstract byte e(long j2);

        public abstract byte f(Object obj, long j2);

        public abstract double g(Object obj, long j2);

        public abstract float h(Object obj, long j2);

        public final int i(Object obj, long j2) {
            return this.a.getInt(obj, j2);
        }

        public final long j(Object obj, long j2) {
            return this.a.getLong(obj, j2);
        }

        public final Object k(Object obj, long j2) {
            return this.a.getObject(obj, j2);
        }

        public final long l(Field field) {
            return this.a.objectFieldOffset(field);
        }

        public abstract void m(Object obj, long j2, boolean z);

        public abstract void n(Object obj, long j2, byte b);

        public abstract void o(Object obj, long j2, double d2);

        public abstract void p(Object obj, long j2, float f2);

        public final void q(Object obj, long j2, int i2) {
            this.a.putInt(obj, j2, i2);
        }

        public final void r(Object obj, long j2, long j3) {
            this.a.putLong(obj, j2, j3);
        }

        public final void s(Object obj, long j2, Object obj2) {
            this.a.putObject(obj, j2, obj2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0130 A[SYNTHETIC, Splitter:B:39:0x0130] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0287  */
    static {
        Class cls;
        Class cls2;
        boolean z;
        Unsafe unsafe;
        boolean z2;
        e eVar;
        Object th;
        Object th2;
        Unsafe q = q();
        b = q;
        Class<?> cls3 = Long.TYPE;
        boolean f2 = f(cls3);
        f3632d = f2;
        Class<?> cls4 = Integer.TYPE;
        boolean f3 = f(cls4);
        f3633e = f3;
        e eVar2 = null;
        if (q != null) {
            if (!d.a()) {
                eVar2 = new d(q);
            } else if (f2) {
                eVar2 = new c(q);
            } else if (f3) {
                eVar2 = new b(q);
            }
        }
        f3634f = eVar2;
        if (q == null) {
            cls2 = int[].class;
        } else {
            try {
                Class<?> cls5 = q.getClass();
                cls2 = int[].class;
                try {
                    cls5.getMethod("objectFieldOffset", Field.class);
                    cls5.getMethod("getLong", Object.class, cls3);
                    if (e() != null) {
                        if (d.a()) {
                            cls = boolean[].class;
                        } else {
                            cls5.getMethod("getByte", cls3);
                            Class<?>[] clsArr = new Class[2];
                            clsArr[0] = cls3;
                            cls = boolean[].class;
                            try {
                                clsArr[1] = Byte.TYPE;
                                cls5.getMethod("putByte", clsArr);
                                cls5.getMethod("getInt", cls3);
                                cls5.getMethod("putInt", cls3, cls4);
                                cls5.getMethod("getLong", cls3);
                                cls5.getMethod("putLong", cls3, cls3);
                                cls5.getMethod("copyMemory", cls3, cls3, cls3);
                                cls5.getMethod("copyMemory", Object.class, cls3, Object.class, cls3, cls3);
                            } catch (Throwable th3) {
                                th2 = th3;
                            }
                        }
                        z = true;
                        f3635g = z;
                        unsafe = b;
                        if (unsafe == null) {
                            try {
                                Class<?> cls6 = unsafe.getClass();
                                cls6.getMethod("objectFieldOffset", Field.class);
                                cls6.getMethod("arrayBaseOffset", Class.class);
                                cls6.getMethod("arrayIndexScale", Class.class);
                                Class<?>[] clsArr2 = new Class[2];
                                clsArr2[0] = Object.class;
                                Class<?> cls7 = Long.TYPE;
                                try {
                                    clsArr2[1] = cls7;
                                    cls6.getMethod("getInt", clsArr2);
                                    Class<?>[] clsArr3 = new Class[3];
                                    clsArr3[0] = Object.class;
                                    clsArr3[1] = cls7;
                                    clsArr3[2] = Integer.TYPE;
                                    cls6.getMethod("putInt", clsArr3);
                                    cls6.getMethod("getLong", Object.class, cls7);
                                    cls6.getMethod("putLong", Object.class, cls7, cls7);
                                    cls6.getMethod("getObject", Object.class, cls7);
                                    cls6.getMethod("putObject", Object.class, cls7, Object.class);
                                    if (!d.a()) {
                                        cls6.getMethod("getByte", Object.class, cls7);
                                        cls6.getMethod("putByte", Object.class, cls7, Byte.TYPE);
                                        cls6.getMethod("getBoolean", Object.class, cls7);
                                        cls6.getMethod("putBoolean", Object.class, cls7, Boolean.TYPE);
                                        cls6.getMethod("getFloat", Object.class, cls7);
                                        cls6.getMethod("putFloat", Object.class, cls7, Float.TYPE);
                                        cls6.getMethod("getDouble", Object.class, cls7);
                                        cls6.getMethod("putDouble", Object.class, cls7, Double.TYPE);
                                    }
                                    z2 = true;
                                } catch (Throwable th4) {
                                    th = th4;
                                    Logger logger = a;
                                    Level level = Level.WARNING;
                                    logger.log(level, "platform method missing - proto runtime falling back to safer methods: " + th);
                                    z2 = false;
                                    f3636h = z2;
                                    c(cls);
                                    d(cls);
                                    c(cls2);
                                    d(cls2);
                                    c(long[].class);
                                    d(long[].class);
                                    c(float[].class);
                                    d(float[].class);
                                    c(double[].class);
                                    d(double[].class);
                                    c(Object[].class);
                                    d(Object[].class);
                                    Field e2 = e();
                                    f3638j = (e2 != null || (eVar = f3634f) == null) ? -1 : eVar.l(e2);
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                Logger logger2 = a;
                                Level level2 = Level.WARNING;
                                logger2.log(level2, "platform method missing - proto runtime falling back to safer methods: " + th);
                                z2 = false;
                                f3636h = z2;
                                c(cls);
                                d(cls);
                                c(cls2);
                                d(cls2);
                                c(long[].class);
                                d(long[].class);
                                c(float[].class);
                                d(float[].class);
                                c(double[].class);
                                d(double[].class);
                                c(Object[].class);
                                d(Object[].class);
                                Field e22 = e();
                                f3638j = (e22 != null || (eVar = f3634f) == null) ? -1 : eVar.l(e22);
                            }
                            f3636h = z2;
                            c(cls);
                            d(cls);
                            c(cls2);
                            d(cls2);
                            c(long[].class);
                            d(long[].class);
                            c(float[].class);
                            d(float[].class);
                            c(double[].class);
                            d(double[].class);
                            c(Object[].class);
                            d(Object[].class);
                            Field e222 = e();
                            f3638j = (e222 != null || (eVar = f3634f) == null) ? -1 : eVar.l(e222);
                        }
                        z2 = false;
                        f3636h = z2;
                        c(cls);
                        d(cls);
                        c(cls2);
                        d(cls2);
                        c(long[].class);
                        d(long[].class);
                        c(float[].class);
                        d(float[].class);
                        c(double[].class);
                        d(double[].class);
                        c(Object[].class);
                        d(Object[].class);
                        Field e2222 = e();
                        f3638j = (e2222 != null || (eVar = f3634f) == null) ? -1 : eVar.l(e2222);
                    }
                } catch (Throwable th6) {
                    th2 = th6;
                    cls = boolean[].class;
                    Logger logger3 = a;
                    Level level3 = Level.WARNING;
                    logger3.log(level3, "platform method missing - proto runtime falling back to safer methods: " + th2);
                    z = false;
                    f3635g = z;
                    unsafe = b;
                    if (unsafe == null) {
                    }
                    z2 = false;
                    f3636h = z2;
                    c(cls);
                    d(cls);
                    c(cls2);
                    d(cls2);
                    c(long[].class);
                    d(long[].class);
                    c(float[].class);
                    d(float[].class);
                    c(double[].class);
                    d(double[].class);
                    c(Object[].class);
                    d(Object[].class);
                    Field e22222 = e();
                    f3638j = (e22222 != null || (eVar = f3634f) == null) ? -1 : eVar.l(e22222);
                }
            } catch (Throwable th7) {
                th2 = th7;
                cls2 = int[].class;
                cls = boolean[].class;
                Logger logger32 = a;
                Level level32 = Level.WARNING;
                logger32.log(level32, "platform method missing - proto runtime falling back to safer methods: " + th2);
                z = false;
                f3635g = z;
                unsafe = b;
                if (unsafe == null) {
                }
                f3636h = z2;
                c(cls);
                d(cls);
                c(cls2);
                d(cls2);
                c(long[].class);
                d(long[].class);
                c(float[].class);
                d(float[].class);
                c(double[].class);
                d(double[].class);
                c(Object[].class);
                d(Object[].class);
                Field e222222 = e();
                f3638j = (e222222 != null || (eVar = f3634f) == null) ? -1 : eVar.l(e222222);
            }
        }
        cls = boolean[].class;
        z = false;
        f3635g = z;
        unsafe = b;
        if (unsafe == null) {
        }
        f3636h = z2;
        c(cls);
        d(cls);
        c(cls2);
        d(cls2);
        c(long[].class);
        d(long[].class);
        c(float[].class);
        d(float[].class);
        c(double[].class);
        d(double[].class);
        c(Object[].class);
        d(Object[].class);
        Field e2222222 = e();
        f3638j = (e2222222 != null || (eVar = f3634f) == null) ? -1 : eVar.l(e2222222);
    }

    public static long a(ByteBuffer byteBuffer) {
        return f3634f.j(byteBuffer, f3638j);
    }

    public static <T> T b(Class<T> cls) {
        try {
            return (T) b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int c(Class<?> cls) {
        if (f3636h) {
            return f3634f.a(cls);
        }
        return -1;
    }

    public static int d(Class<?> cls) {
        if (f3636h) {
            return f3634f.b(cls);
        }
        return -1;
    }

    public static Field e() {
        Field field;
        Field field2;
        if (d.a()) {
            try {
                field2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                field2 = null;
            }
            if (field2 != null) {
                return field2;
            }
        }
        try {
            field = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            field = null;
        }
        if (field == null || field.getType() != Long.TYPE) {
            return null;
        }
        return field;
    }

    public static boolean f(Class<?> cls) {
        if (!d.a()) {
            return false;
        }
        try {
            Class<?> cls2 = c;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean g(Object obj, long j2) {
        return f3634f.d(obj, j2);
    }

    public static byte h(long j2) {
        return f3634f.e(j2);
    }

    public static byte i(byte[] bArr, long j2) {
        return f3634f.f(bArr, f3637i + j2);
    }

    public static byte j(Object obj, long j2) {
        return (byte) ((n(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    public static byte k(Object obj, long j2) {
        return (byte) ((n(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    public static double l(Object obj, long j2) {
        return f3634f.g(obj, j2);
    }

    public static float m(Object obj, long j2) {
        return f3634f.h(obj, j2);
    }

    public static int n(Object obj, long j2) {
        return f3634f.i(obj, j2);
    }

    public static long o(Object obj, long j2) {
        return f3634f.j(obj, j2);
    }

    public static Object p(Object obj, long j2) {
        return f3634f.k(obj, j2);
    }

    public static Unsafe q() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void r(Object obj, long j2, boolean z) {
        f3634f.m(obj, j2, z);
    }

    public static void s(byte[] bArr, long j2, byte b2) {
        f3634f.n(bArr, f3637i + j2, b2);
    }

    public static void t(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int n = n(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        e eVar = f3634f;
        eVar.q(obj, j3, ((255 & b2) << i2) | (n & (~(255 << i2))));
    }

    public static void u(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        e eVar = f3634f;
        eVar.q(obj, j3, ((255 & b2) << i2) | (n(obj, j3) & (~(255 << i2))));
    }

    public static void v(Object obj, long j2, double d2) {
        f3634f.o(obj, j2, d2);
    }

    public static void w(Object obj, long j2, float f2) {
        f3634f.p(obj, j2, f2);
    }

    public static void x(Object obj, long j2, int i2) {
        f3634f.q(obj, j2, i2);
    }

    public static void y(Object obj, long j2, long j3) {
        f3634f.r(obj, j2, j3);
    }

    public static void z(Object obj, long j2, Object obj2) {
        f3634f.s(obj, j2, obj2);
    }
}
