package c.b.a.a.g.h;

import gov.michigan.MiCovidExposure.BuildConfig;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public final class j4 {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f3913a = Logger.getLogger(j4.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public static final Unsafe f3914b = k();

    /* renamed from: c  reason: collision with root package name */
    public static final Class<?> f3915c = m0.f3941a;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f3916d = n(Long.TYPE);

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f3917e = n(Integer.TYPE);

    /* renamed from: f  reason: collision with root package name */
    public static final c f3918f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f3919g;
    public static final boolean h;
    public static final long i = ((long) i(byte[].class));
    public static final boolean j;

    public static final class a extends c {
        public a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // c.b.a.a.g.h.j4.c
        public final void a(Object obj, long j, double d2) {
            c(obj, j, Double.doubleToLongBits(d2));
        }

        @Override // c.b.a.a.g.h.j4.c
        public final void b(Object obj, long j, float f2) {
            e(obj, j, Float.floatToIntBits(f2));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.a.a.g.h.j4.c
        public final void d(Object obj, long j, boolean z) {
            if (j4.j) {
                j4.b(obj, j, z ? (byte) 1 : 0);
            } else {
                j4.g(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // c.b.a.a.g.h.j4.c
        public final void f(Object obj, long j, byte b2) {
            if (j4.j) {
                j4.b(obj, j, b2);
            } else {
                j4.g(obj, j, b2);
            }
        }

        @Override // c.b.a.a.g.h.j4.c
        public final boolean i(Object obj, long j) {
            return j4.j ? j4.t(obj, j) != 0 : j4.u(obj, j) != 0;
        }

        @Override // c.b.a.a.g.h.j4.c
        public final float j(Object obj, long j) {
            return Float.intBitsToFloat(g(obj, j));
        }

        @Override // c.b.a.a.g.h.j4.c
        public final double k(Object obj, long j) {
            return Double.longBitsToDouble(h(obj, j));
        }

        @Override // c.b.a.a.g.h.j4.c
        public final byte l(Object obj, long j) {
            if (j4.j) {
                return j4.t(obj, j);
            }
            return j4.u(obj, j);
        }
    }

    public static final class b extends c {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // c.b.a.a.g.h.j4.c
        public final void a(Object obj, long j, double d2) {
            c(obj, j, Double.doubleToLongBits(d2));
        }

        @Override // c.b.a.a.g.h.j4.c
        public final void b(Object obj, long j, float f2) {
            e(obj, j, Float.floatToIntBits(f2));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.a.a.g.h.j4.c
        public final void d(Object obj, long j, boolean z) {
            if (j4.j) {
                j4.b(obj, j, z ? (byte) 1 : 0);
            } else {
                j4.g(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // c.b.a.a.g.h.j4.c
        public final void f(Object obj, long j, byte b2) {
            if (j4.j) {
                j4.b(obj, j, b2);
            } else {
                j4.g(obj, j, b2);
            }
        }

        @Override // c.b.a.a.g.h.j4.c
        public final boolean i(Object obj, long j) {
            return j4.j ? j4.t(obj, j) != 0 : j4.u(obj, j) != 0;
        }

        @Override // c.b.a.a.g.h.j4.c
        public final float j(Object obj, long j) {
            return Float.intBitsToFloat(g(obj, j));
        }

        @Override // c.b.a.a.g.h.j4.c
        public final double k(Object obj, long j) {
            return Double.longBitsToDouble(h(obj, j));
        }

        @Override // c.b.a.a.g.h.j4.c
        public final byte l(Object obj, long j) {
            if (j4.j) {
                return j4.t(obj, j);
            }
            return j4.u(obj, j);
        }
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public Unsafe f3920a;

        public c(Unsafe unsafe) {
            this.f3920a = unsafe;
        }

        public abstract void a(Object obj, long j, double d2);

        public abstract void b(Object obj, long j, float f2);

        public final void c(Object obj, long j, long j2) {
            this.f3920a.putLong(obj, j, j2);
        }

        public abstract void d(Object obj, long j, boolean z);

        public final void e(Object obj, long j, int i) {
            this.f3920a.putInt(obj, j, i);
        }

        public abstract void f(Object obj, long j, byte b2);

        public final int g(Object obj, long j) {
            return this.f3920a.getInt(obj, j);
        }

        public final long h(Object obj, long j) {
            return this.f3920a.getLong(obj, j);
        }

        public abstract boolean i(Object obj, long j);

        public abstract float j(Object obj, long j);

        public abstract double k(Object obj, long j);

        public abstract byte l(Object obj, long j);
    }

    public static final class d extends c {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // c.b.a.a.g.h.j4.c
        public final void a(Object obj, long j, double d2) {
            this.f3920a.putDouble(obj, j, d2);
        }

        @Override // c.b.a.a.g.h.j4.c
        public final void b(Object obj, long j, float f2) {
            this.f3920a.putFloat(obj, j, f2);
        }

        @Override // c.b.a.a.g.h.j4.c
        public final void d(Object obj, long j, boolean z) {
            this.f3920a.putBoolean(obj, j, z);
        }

        @Override // c.b.a.a.g.h.j4.c
        public final void f(Object obj, long j, byte b2) {
            this.f3920a.putByte(obj, j, b2);
        }

        @Override // c.b.a.a.g.h.j4.c
        public final boolean i(Object obj, long j) {
            return this.f3920a.getBoolean(obj, j);
        }

        @Override // c.b.a.a.g.h.j4.c
        public final float j(Object obj, long j) {
            return this.f3920a.getFloat(obj, j);
        }

        @Override // c.b.a.a.g.h.j4.c
        public final double k(Object obj, long j) {
            return this.f3920a.getDouble(obj, j);
        }

        @Override // c.b.a.a.g.h.j4.c
        public final byte l(Object obj, long j) {
            return this.f3920a.getByte(obj, j);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x016c A[SYNTHETIC, Splitter:B:41:0x016c] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02f6  */
    static {
        Class cls;
        Class cls2;
        boolean z;
        Unsafe unsafe;
        boolean z2;
        boolean z3;
        Field l;
        c cVar;
        Object th;
        Object th2;
        c cVar2 = null;
        if (f3914b != null) {
            if (!m0.a()) {
                cVar2 = new d(f3914b);
            } else if (f3916d) {
                cVar2 = new a(f3914b);
            } else if (f3917e) {
                cVar2 = new b(f3914b);
            }
        }
        f3918f = cVar2;
        Unsafe unsafe2 = f3914b;
        if (unsafe2 == null) {
            cls2 = long[].class;
        } else {
            try {
                Class<?> cls3 = unsafe2.getClass();
                cls2 = long[].class;
                try {
                    cls3.getMethod("objectFieldOffset", Field.class);
                    cls3.getMethod("getLong", Object.class, Long.TYPE);
                    if (l() != null) {
                        if (m0.a()) {
                            cls = int[].class;
                        } else {
                            cls3.getMethod("getByte", Long.TYPE);
                            Class<?>[] clsArr = new Class[2];
                            clsArr[0] = Long.TYPE;
                            cls = int[].class;
                            try {
                                clsArr[1] = Byte.TYPE;
                                cls3.getMethod("putByte", clsArr);
                                cls3.getMethod("getInt", Long.TYPE);
                                cls3.getMethod("putInt", Long.TYPE, Integer.TYPE);
                                cls3.getMethod("getLong", Long.TYPE);
                                cls3.getMethod("putLong", Long.TYPE, Long.TYPE);
                                cls3.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
                                cls3.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
                            } catch (Throwable th3) {
                                th2 = th3;
                            }
                        }
                        z = true;
                        f3919g = z;
                        unsafe = f3914b;
                        if (unsafe != null) {
                            z3 = false;
                        } else {
                            try {
                                Class<?> cls4 = unsafe.getClass();
                                try {
                                    cls4.getMethod("objectFieldOffset", Field.class);
                                    cls4.getMethod("arrayBaseOffset", Class.class);
                                    Class<?>[] clsArr2 = new Class[1];
                                    clsArr2[0] = Class.class;
                                    cls4.getMethod("arrayIndexScale", clsArr2);
                                    Class<?>[] clsArr3 = new Class[2];
                                    clsArr3[0] = Object.class;
                                    try {
                                        clsArr3[1] = Long.TYPE;
                                        cls4.getMethod("getInt", clsArr3);
                                        Class<?>[] clsArr4 = new Class[3];
                                        clsArr4[0] = Object.class;
                                        clsArr4[1] = Long.TYPE;
                                        clsArr4[2] = Integer.TYPE;
                                        cls4.getMethod("putInt", clsArr4);
                                        cls4.getMethod("getLong", Object.class, Long.TYPE);
                                        cls4.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
                                        cls4.getMethod("getObject", Object.class, Long.TYPE);
                                        cls4.getMethod("putObject", Object.class, Long.TYPE, Object.class);
                                        if (m0.a()) {
                                            z3 = true;
                                        } else {
                                            cls4.getMethod("getByte", Object.class, Long.TYPE);
                                            cls4.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
                                            cls4.getMethod("getBoolean", Object.class, Long.TYPE);
                                            cls4.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
                                            cls4.getMethod("getFloat", Object.class, Long.TYPE);
                                            cls4.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
                                            cls4.getMethod("getDouble", Object.class, Long.TYPE);
                                            Class<?>[] clsArr5 = new Class[3];
                                            clsArr5[0] = Object.class;
                                            z2 = true;
                                            try {
                                                clsArr5[1] = Long.TYPE;
                                                clsArr5[2] = Double.TYPE;
                                                cls4.getMethod("putDouble", clsArr5);
                                                z3 = true;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                Logger logger = f3913a;
                                                Level level = Level.WARNING;
                                                String valueOf = String.valueOf(th);
                                                StringBuilder sb = new StringBuilder(valueOf.length() + 71);
                                                sb.append("platform method missing - proto runtime falling back to safer methods: ");
                                                sb.append(valueOf);
                                                logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
                                                z3 = false;
                                                h = z3;
                                                i(boolean[].class);
                                                j(boolean[].class);
                                                i(cls);
                                                j(cls);
                                                i(cls2);
                                                j(cls2);
                                                i(float[].class);
                                                j(float[].class);
                                                i(double[].class);
                                                j(double[].class);
                                                i(Object[].class);
                                                j(Object[].class);
                                                l = l();
                                                cVar.f3920a.objectFieldOffset(l);
                                                j = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN ? z2 : false;
                                            }
                                            h = z3;
                                            i(boolean[].class);
                                            j(boolean[].class);
                                            i(cls);
                                            j(cls);
                                            i(cls2);
                                            j(cls2);
                                            i(float[].class);
                                            j(float[].class);
                                            i(double[].class);
                                            j(double[].class);
                                            i(Object[].class);
                                            j(Object[].class);
                                            l = l();
                                            if (!(l == null || (cVar = f3918f) == null)) {
                                                cVar.f3920a.objectFieldOffset(l);
                                            }
                                            j = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN ? z2 : false;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        z2 = true;
                                        Logger logger2 = f3913a;
                                        Level level2 = Level.WARNING;
                                        String valueOf2 = String.valueOf(th);
                                        StringBuilder sb2 = new StringBuilder(valueOf2.length() + 71);
                                        sb2.append("platform method missing - proto runtime falling back to safer methods: ");
                                        sb2.append(valueOf2);
                                        logger2.logp(level2, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb2.toString());
                                        z3 = false;
                                        h = z3;
                                        i(boolean[].class);
                                        j(boolean[].class);
                                        i(cls);
                                        j(cls);
                                        i(cls2);
                                        j(cls2);
                                        i(float[].class);
                                        j(float[].class);
                                        i(double[].class);
                                        j(double[].class);
                                        i(Object[].class);
                                        j(Object[].class);
                                        l = l();
                                        cVar.f3920a.objectFieldOffset(l);
                                        j = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN ? z2 : false;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    z2 = true;
                                    Logger logger22 = f3913a;
                                    Level level22 = Level.WARNING;
                                    String valueOf22 = String.valueOf(th);
                                    StringBuilder sb22 = new StringBuilder(valueOf22.length() + 71);
                                    sb22.append("platform method missing - proto runtime falling back to safer methods: ");
                                    sb22.append(valueOf22);
                                    logger22.logp(level22, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb22.toString());
                                    z3 = false;
                                    h = z3;
                                    i(boolean[].class);
                                    j(boolean[].class);
                                    i(cls);
                                    j(cls);
                                    i(cls2);
                                    j(cls2);
                                    i(float[].class);
                                    j(float[].class);
                                    i(double[].class);
                                    j(double[].class);
                                    i(Object[].class);
                                    j(Object[].class);
                                    l = l();
                                    cVar.f3920a.objectFieldOffset(l);
                                    j = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN ? z2 : false;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                z2 = true;
                                Logger logger222 = f3913a;
                                Level level222 = Level.WARNING;
                                String valueOf222 = String.valueOf(th);
                                StringBuilder sb222 = new StringBuilder(valueOf222.length() + 71);
                                sb222.append("platform method missing - proto runtime falling back to safer methods: ");
                                sb222.append(valueOf222);
                                logger222.logp(level222, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb222.toString());
                                z3 = false;
                                h = z3;
                                i(boolean[].class);
                                j(boolean[].class);
                                i(cls);
                                j(cls);
                                i(cls2);
                                j(cls2);
                                i(float[].class);
                                j(float[].class);
                                i(double[].class);
                                j(double[].class);
                                i(Object[].class);
                                j(Object[].class);
                                l = l();
                                cVar.f3920a.objectFieldOffset(l);
                                j = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN ? z2 : false;
                            }
                        }
                        z2 = true;
                        h = z3;
                        i(boolean[].class);
                        j(boolean[].class);
                        i(cls);
                        j(cls);
                        i(cls2);
                        j(cls2);
                        i(float[].class);
                        j(float[].class);
                        i(double[].class);
                        j(double[].class);
                        i(Object[].class);
                        j(Object[].class);
                        l = l();
                        cVar.f3920a.objectFieldOffset(l);
                        j = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN ? z2 : false;
                    }
                } catch (Throwable th8) {
                    th2 = th8;
                    cls = int[].class;
                    Logger logger3 = f3913a;
                    Level level3 = Level.WARNING;
                    String valueOf3 = String.valueOf(th2);
                    StringBuilder sb3 = new StringBuilder(valueOf3.length() + 71);
                    sb3.append("platform method missing - proto runtime falling back to safer methods: ");
                    sb3.append(valueOf3);
                    logger3.logp(level3, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb3.toString());
                    z = false;
                    f3919g = z;
                    unsafe = f3914b;
                    if (unsafe != null) {
                    }
                    z2 = true;
                    h = z3;
                    i(boolean[].class);
                    j(boolean[].class);
                    i(cls);
                    j(cls);
                    i(cls2);
                    j(cls2);
                    i(float[].class);
                    j(float[].class);
                    i(double[].class);
                    j(double[].class);
                    i(Object[].class);
                    j(Object[].class);
                    l = l();
                    cVar.f3920a.objectFieldOffset(l);
                    j = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN ? z2 : false;
                }
            } catch (Throwable th9) {
                th2 = th9;
                cls2 = long[].class;
                cls = int[].class;
                Logger logger32 = f3913a;
                Level level32 = Level.WARNING;
                String valueOf32 = String.valueOf(th2);
                StringBuilder sb32 = new StringBuilder(valueOf32.length() + 71);
                sb32.append("platform method missing - proto runtime falling back to safer methods: ");
                sb32.append(valueOf32);
                logger32.logp(level32, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb32.toString());
                z = false;
                f3919g = z;
                unsafe = f3914b;
                if (unsafe != null) {
                }
                z2 = true;
                h = z3;
                i(boolean[].class);
                j(boolean[].class);
                i(cls);
                j(cls);
                i(cls2);
                j(cls2);
                i(float[].class);
                j(float[].class);
                i(double[].class);
                j(double[].class);
                i(Object[].class);
                j(Object[].class);
                l = l();
                cVar.f3920a.objectFieldOffset(l);
                j = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN ? z2 : false;
            }
        }
        cls = int[].class;
        z = false;
        f3919g = z;
        unsafe = f3914b;
        if (unsafe != null) {
        }
        z2 = true;
        h = z3;
        i(boolean[].class);
        j(boolean[].class);
        i(cls);
        j(cls);
        i(cls2);
        j(cls2);
        i(float[].class);
        j(float[].class);
        i(double[].class);
        j(double[].class);
        i(Object[].class);
        j(Object[].class);
        l = l();
        cVar.f3920a.objectFieldOffset(l);
        j = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN ? z2 : false;
    }

    public static byte a(byte[] bArr, long j2) {
        return f3918f.l(bArr, i + j2);
    }

    public static void b(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int m = m(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        c cVar = f3918f;
        cVar.e(obj, j3, ((255 & b2) << i2) | (m & (~(BuildConfig.VERSION_CODE << i2))));
    }

    public static void c(Object obj, long j2, double d2) {
        f3918f.a(obj, j2, d2);
    }

    public static void d(Object obj, long j2, long j3) {
        f3918f.c(obj, j2, j3);
    }

    public static void e(Object obj, long j2, Object obj2) {
        f3918f.f3920a.putObject(obj, j2, obj2);
    }

    public static void f(byte[] bArr, long j2, byte b2) {
        f3918f.f(bArr, i + j2, b2);
    }

    public static void g(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        c cVar = f3918f;
        cVar.e(obj, j3, ((255 & b2) << i2) | (m(obj, j3) & (~(BuildConfig.VERSION_CODE << i2))));
    }

    public static <T> T h(Class<T> cls) {
        try {
            return (T) f3914b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int i(Class<?> cls) {
        if (h) {
            return f3918f.f3920a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int j(Class<?> cls) {
        if (h) {
            return f3918f.f3920a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static Unsafe k() {
        try {
            return (Unsafe) AccessController.doPrivileged(new i4());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field l() {
        Field field;
        Field field2;
        if (m0.a()) {
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

    public static int m(Object obj, long j2) {
        return f3918f.g(obj, j2);
    }

    public static boolean n(Class<?> cls) {
        if (!m0.a()) {
            return false;
        }
        try {
            Class<?> cls2 = f3915c;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static long o(Object obj, long j2) {
        return f3918f.h(obj, j2);
    }

    public static boolean p(Object obj, long j2) {
        return f3918f.i(obj, j2);
    }

    public static float q(Object obj, long j2) {
        return f3918f.j(obj, j2);
    }

    public static double r(Object obj, long j2) {
        return f3918f.k(obj, j2);
    }

    public static Object s(Object obj, long j2) {
        return f3918f.f3920a.getObject(obj, j2);
    }

    public static byte t(Object obj, long j2) {
        return (byte) (m(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3)));
    }

    public static byte u(Object obj, long j2) {
        return (byte) (m(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3)));
    }
}
