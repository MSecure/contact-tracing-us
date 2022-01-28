package c.b.a.a.g.b;

import gov.michigan.MiCovidExposure.BuildConfig;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

public final class n3 {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f3364a = Logger.getLogger(n3.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public static final Unsafe f3365b = j();

    /* renamed from: c  reason: collision with root package name */
    public static final Class<?> f3366c = t.f3414a;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f3367d = n(Long.TYPE);

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f3368e = n(Integer.TYPE);

    /* renamed from: f  reason: collision with root package name */
    public static final d f3369f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f3370g;
    public static final boolean h;
    public static final long i = ((long) l(byte[].class));
    public static final long j;
    public static final boolean k;

    public static final class a extends d {
        public a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // c.b.a.a.g.b.n3.d
        public final void b(long j, byte b2) {
            Memory.pokeByte((int) (j & -1), b2);
        }

        @Override // c.b.a.a.g.b.n3.d
        public final void c(Object obj, long j, double d2) {
            f(obj, j, Double.doubleToLongBits(d2));
        }

        @Override // c.b.a.a.g.b.n3.d
        public final void d(Object obj, long j, float f2) {
            e(obj, j, Float.floatToIntBits(f2));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.a.a.g.b.n3.d
        public final void g(Object obj, long j, boolean z) {
            if (n3.k) {
                n3.c(obj, j, z ? (byte) 1 : 0);
            } else {
                n3.i(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // c.b.a.a.g.b.n3.d
        public final void h(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & -1), bArr, (int) j, (int) j3);
        }

        @Override // c.b.a.a.g.b.n3.d
        public final void i(Object obj, long j, byte b2) {
            if (n3.k) {
                n3.c(obj, j, b2);
            } else {
                n3.i(obj, j, b2);
            }
        }

        @Override // c.b.a.a.g.b.n3.d
        public final boolean l(Object obj, long j) {
            return n3.k ? n3.u(obj, j) != 0 : n3.v(obj, j) != 0;
        }

        @Override // c.b.a.a.g.b.n3.d
        public final float m(Object obj, long j) {
            return Float.intBitsToFloat(j(obj, j));
        }

        @Override // c.b.a.a.g.b.n3.d
        public final double n(Object obj, long j) {
            return Double.longBitsToDouble(k(obj, j));
        }

        @Override // c.b.a.a.g.b.n3.d
        public final byte o(Object obj, long j) {
            if (n3.k) {
                return n3.u(obj, j);
            }
            return n3.v(obj, j);
        }
    }

    public static final class b extends d {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // c.b.a.a.g.b.n3.d
        public final void b(long j, byte b2) {
            Memory.pokeByte(j, b2);
        }

        @Override // c.b.a.a.g.b.n3.d
        public final void c(Object obj, long j, double d2) {
            f(obj, j, Double.doubleToLongBits(d2));
        }

        @Override // c.b.a.a.g.b.n3.d
        public final void d(Object obj, long j, float f2) {
            e(obj, j, Float.floatToIntBits(f2));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.a.a.g.b.n3.d
        public final void g(Object obj, long j, boolean z) {
            if (n3.k) {
                n3.c(obj, j, z ? (byte) 1 : 0);
            } else {
                n3.i(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // c.b.a.a.g.b.n3.d
        public final void h(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }

        @Override // c.b.a.a.g.b.n3.d
        public final void i(Object obj, long j, byte b2) {
            if (n3.k) {
                n3.c(obj, j, b2);
            } else {
                n3.i(obj, j, b2);
            }
        }

        @Override // c.b.a.a.g.b.n3.d
        public final boolean l(Object obj, long j) {
            return n3.k ? n3.u(obj, j) != 0 : n3.v(obj, j) != 0;
        }

        @Override // c.b.a.a.g.b.n3.d
        public final float m(Object obj, long j) {
            return Float.intBitsToFloat(j(obj, j));
        }

        @Override // c.b.a.a.g.b.n3.d
        public final double n(Object obj, long j) {
            return Double.longBitsToDouble(k(obj, j));
        }

        @Override // c.b.a.a.g.b.n3.d
        public final byte o(Object obj, long j) {
            if (n3.k) {
                return n3.u(obj, j);
            }
            return n3.v(obj, j);
        }
    }

    public static final class c extends d {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // c.b.a.a.g.b.n3.d
        public final void b(long j, byte b2) {
            this.f3371a.putByte(j, b2);
        }

        @Override // c.b.a.a.g.b.n3.d
        public final void c(Object obj, long j, double d2) {
            this.f3371a.putDouble(obj, j, d2);
        }

        @Override // c.b.a.a.g.b.n3.d
        public final void d(Object obj, long j, float f2) {
            this.f3371a.putFloat(obj, j, f2);
        }

        @Override // c.b.a.a.g.b.n3.d
        public final void g(Object obj, long j, boolean z) {
            this.f3371a.putBoolean(obj, j, z);
        }

        @Override // c.b.a.a.g.b.n3.d
        public final void h(byte[] bArr, long j, long j2, long j3) {
            this.f3371a.copyMemory(bArr, n3.i + j, (Object) null, j2, j3);
        }

        @Override // c.b.a.a.g.b.n3.d
        public final void i(Object obj, long j, byte b2) {
            this.f3371a.putByte(obj, j, b2);
        }

        @Override // c.b.a.a.g.b.n3.d
        public final boolean l(Object obj, long j) {
            return this.f3371a.getBoolean(obj, j);
        }

        @Override // c.b.a.a.g.b.n3.d
        public final float m(Object obj, long j) {
            return this.f3371a.getFloat(obj, j);
        }

        @Override // c.b.a.a.g.b.n3.d
        public final double n(Object obj, long j) {
            return this.f3371a.getDouble(obj, j);
        }

        @Override // c.b.a.a.g.b.n3.d
        public final byte o(Object obj, long j) {
            return this.f3371a.getByte(obj, j);
        }
    }

    public static abstract class d {

        /* renamed from: a  reason: collision with root package name */
        public Unsafe f3371a;

        public d(Unsafe unsafe) {
            this.f3371a = unsafe;
        }

        public final long a(Field field) {
            return this.f3371a.objectFieldOffset(field);
        }

        public abstract void b(long j, byte b2);

        public abstract void c(Object obj, long j, double d2);

        public abstract void d(Object obj, long j, float f2);

        public final void e(Object obj, long j, int i) {
            this.f3371a.putInt(obj, j, i);
        }

        public final void f(Object obj, long j, long j2) {
            this.f3371a.putLong(obj, j, j2);
        }

        public abstract void g(Object obj, long j, boolean z);

        public abstract void h(byte[] bArr, long j, long j2, long j3);

        public abstract void i(Object obj, long j, byte b2);

        public final int j(Object obj, long j) {
            return this.f3371a.getInt(obj, j);
        }

        public final long k(Object obj, long j) {
            return this.f3371a.getLong(obj, j);
        }

        public abstract boolean l(Object obj, long j);

        public abstract float m(Object obj, long j);

        public abstract double n(Object obj, long j);

        public abstract byte o(Object obj, long j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0086 A[SYNTHETIC, Splitter:B:15:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0169 A[SYNTHETIC, Splitter:B:40:0x0169] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x02e0  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02f8  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0315  */
    static {
        d dVar;
        Unsafe unsafe;
        Class cls;
        Class cls2;
        boolean z;
        Unsafe unsafe2;
        boolean z2;
        boolean z3;
        Field field;
        d dVar2;
        d dVar3;
        Object th;
        Class<?>[] clsArr;
        Object th2;
        if (f3365b != null) {
            if (!t.a()) {
                dVar = new c(f3365b);
            } else if (f3367d) {
                dVar = new b(f3365b);
            } else if (f3368e) {
                dVar = new a(f3365b);
            }
            f3369f = dVar;
            unsafe = f3365b;
            boolean z4 = false;
            if (unsafe != null) {
                cls2 = long[].class;
            } else {
                try {
                    Class<?> cls3 = unsafe.getClass();
                    cls2 = long[].class;
                    try {
                        cls3.getMethod("objectFieldOffset", Field.class);
                        cls3.getMethod("getLong", Object.class, Long.TYPE);
                        if (k() != null) {
                            if (t.a()) {
                                cls = int[].class;
                            } else {
                                cls3.getMethod("getByte", Long.TYPE);
                                Class<?>[] clsArr2 = new Class[2];
                                clsArr2[0] = Long.TYPE;
                                cls = int[].class;
                                try {
                                    clsArr2[1] = Byte.TYPE;
                                    cls3.getMethod("putByte", clsArr2);
                                    cls3.getMethod("getInt", Long.TYPE);
                                    cls3.getMethod("putInt", Long.TYPE, Integer.TYPE);
                                    cls3.getMethod("getLong", Long.TYPE);
                                    cls3.getMethod("putLong", Long.TYPE, Long.TYPE);
                                    cls3.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
                                    cls3.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    Logger logger = f3364a;
                                    Level level = Level.WARNING;
                                    String valueOf = String.valueOf(th2);
                                    StringBuilder sb = new StringBuilder(valueOf.length() + 71);
                                    sb.append("platform method missing - proto runtime falling back to safer methods: ");
                                    sb.append(valueOf);
                                    logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
                                    z = false;
                                    f3370g = z;
                                    unsafe2 = f3365b;
                                    if (unsafe2 != null) {
                                    }
                                    z2 = true;
                                    h = z3;
                                    l(boolean[].class);
                                    m(boolean[].class);
                                    l(cls);
                                    m(cls);
                                    l(cls2);
                                    m(cls2);
                                    l(float[].class);
                                    m(float[].class);
                                    l(double[].class);
                                    m(double[].class);
                                    l(Object[].class);
                                    m(Object[].class);
                                    Field k2 = k();
                                    j = (k2 != null || (dVar3 = f3369f) == null) ? -1 : dVar3.a(k2);
                                    Field h2 = h(String.class, "value");
                                    if (h2 == null) {
                                    }
                                    dVar2.a(field);
                                    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                                    }
                                    k = z4;
                                }
                            }
                            z = true;
                            f3370g = z;
                            unsafe2 = f3365b;
                            if (unsafe2 != null) {
                                z3 = false;
                            } else {
                                try {
                                    Class<?> cls4 = unsafe2.getClass();
                                    try {
                                        cls4.getMethod("objectFieldOffset", Field.class);
                                        cls4.getMethod("arrayBaseOffset", Class.class);
                                        Class<?>[] clsArr3 = new Class[1];
                                        clsArr3[0] = Class.class;
                                        cls4.getMethod("arrayIndexScale", clsArr3);
                                        clsArr = new Class[2];
                                        clsArr[0] = Object.class;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        z2 = true;
                                        Logger logger2 = f3364a;
                                        Level level2 = Level.WARNING;
                                        String valueOf2 = String.valueOf(th);
                                        StringBuilder sb2 = new StringBuilder(valueOf2.length() + 71);
                                        sb2.append("platform method missing - proto runtime falling back to safer methods: ");
                                        sb2.append(valueOf2);
                                        logger2.logp(level2, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb2.toString());
                                        z3 = false;
                                        h = z3;
                                        l(boolean[].class);
                                        m(boolean[].class);
                                        l(cls);
                                        m(cls);
                                        l(cls2);
                                        m(cls2);
                                        l(float[].class);
                                        m(float[].class);
                                        l(double[].class);
                                        m(double[].class);
                                        l(Object[].class);
                                        m(Object[].class);
                                        Field k22 = k();
                                        j = (k22 != null || (dVar3 = f3369f) == null) ? -1 : dVar3.a(k22);
                                        Field h22 = h(String.class, "value");
                                        if (h22 == null) {
                                        }
                                        dVar2.a(field);
                                        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                                        }
                                        k = z4;
                                    }
                                    try {
                                        clsArr[1] = Long.TYPE;
                                        cls4.getMethod("getInt", clsArr);
                                        Class<?>[] clsArr4 = new Class[3];
                                        clsArr4[0] = Object.class;
                                        clsArr4[1] = Long.TYPE;
                                        clsArr4[2] = Integer.TYPE;
                                        cls4.getMethod("putInt", clsArr4);
                                        cls4.getMethod("getLong", Object.class, Long.TYPE);
                                        cls4.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
                                        cls4.getMethod("getObject", Object.class, Long.TYPE);
                                        cls4.getMethod("putObject", Object.class, Long.TYPE, Object.class);
                                        if (t.a()) {
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
                                            } catch (Throwable th5) {
                                                th = th5;
                                                Logger logger22 = f3364a;
                                                Level level22 = Level.WARNING;
                                                String valueOf22 = String.valueOf(th);
                                                StringBuilder sb22 = new StringBuilder(valueOf22.length() + 71);
                                                sb22.append("platform method missing - proto runtime falling back to safer methods: ");
                                                sb22.append(valueOf22);
                                                logger22.logp(level22, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb22.toString());
                                                z3 = false;
                                                h = z3;
                                                l(boolean[].class);
                                                m(boolean[].class);
                                                l(cls);
                                                m(cls);
                                                l(cls2);
                                                m(cls2);
                                                l(float[].class);
                                                m(float[].class);
                                                l(double[].class);
                                                m(double[].class);
                                                l(Object[].class);
                                                m(Object[].class);
                                                Field k222 = k();
                                                j = (k222 != null || (dVar3 = f3369f) == null) ? -1 : dVar3.a(k222);
                                                Field h222 = h(String.class, "value");
                                                if (h222 == null) {
                                                }
                                                dVar2.a(field);
                                                if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                                                }
                                                k = z4;
                                            }
                                            h = z3;
                                            l(boolean[].class);
                                            m(boolean[].class);
                                            l(cls);
                                            m(cls);
                                            l(cls2);
                                            m(cls2);
                                            l(float[].class);
                                            m(float[].class);
                                            l(double[].class);
                                            m(double[].class);
                                            l(Object[].class);
                                            m(Object[].class);
                                            Field k2222 = k();
                                            j = (k2222 != null || (dVar3 = f3369f) == null) ? -1 : dVar3.a(k2222);
                                            Field h2222 = h(String.class, "value");
                                            field = (h2222 == null && h2222.getType() == char[].class) ? h2222 : null;
                                            if (!(field == null || (dVar2 = f3369f) == null)) {
                                                dVar2.a(field);
                                            }
                                            if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                                                z4 = z2;
                                            }
                                            k = z4;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        z2 = true;
                                        Logger logger222 = f3364a;
                                        Level level222 = Level.WARNING;
                                        String valueOf222 = String.valueOf(th);
                                        StringBuilder sb222 = new StringBuilder(valueOf222.length() + 71);
                                        sb222.append("platform method missing - proto runtime falling back to safer methods: ");
                                        sb222.append(valueOf222);
                                        logger222.logp(level222, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb222.toString());
                                        z3 = false;
                                        h = z3;
                                        l(boolean[].class);
                                        m(boolean[].class);
                                        l(cls);
                                        m(cls);
                                        l(cls2);
                                        m(cls2);
                                        l(float[].class);
                                        m(float[].class);
                                        l(double[].class);
                                        m(double[].class);
                                        l(Object[].class);
                                        m(Object[].class);
                                        Field k22222 = k();
                                        j = (k22222 != null || (dVar3 = f3369f) == null) ? -1 : dVar3.a(k22222);
                                        Field h22222 = h(String.class, "value");
                                        if (h22222 == null) {
                                        }
                                        dVar2.a(field);
                                        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                                        }
                                        k = z4;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    z2 = true;
                                    Logger logger2222 = f3364a;
                                    Level level2222 = Level.WARNING;
                                    String valueOf2222 = String.valueOf(th);
                                    StringBuilder sb2222 = new StringBuilder(valueOf2222.length() + 71);
                                    sb2222.append("platform method missing - proto runtime falling back to safer methods: ");
                                    sb2222.append(valueOf2222);
                                    logger2222.logp(level2222, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb2222.toString());
                                    z3 = false;
                                    h = z3;
                                    l(boolean[].class);
                                    m(boolean[].class);
                                    l(cls);
                                    m(cls);
                                    l(cls2);
                                    m(cls2);
                                    l(float[].class);
                                    m(float[].class);
                                    l(double[].class);
                                    m(double[].class);
                                    l(Object[].class);
                                    m(Object[].class);
                                    Field k222222 = k();
                                    j = (k222222 != null || (dVar3 = f3369f) == null) ? -1 : dVar3.a(k222222);
                                    Field h222222 = h(String.class, "value");
                                    if (h222222 == null) {
                                    }
                                    dVar2.a(field);
                                    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                                    }
                                    k = z4;
                                }
                            }
                            z2 = true;
                            h = z3;
                            l(boolean[].class);
                            m(boolean[].class);
                            l(cls);
                            m(cls);
                            l(cls2);
                            m(cls2);
                            l(float[].class);
                            m(float[].class);
                            l(double[].class);
                            m(double[].class);
                            l(Object[].class);
                            m(Object[].class);
                            Field k2222222 = k();
                            j = (k2222222 != null || (dVar3 = f3369f) == null) ? -1 : dVar3.a(k2222222);
                            Field h2222222 = h(String.class, "value");
                            if (h2222222 == null) {
                            }
                            dVar2.a(field);
                            if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                            }
                            k = z4;
                        }
                    } catch (Throwable th8) {
                        th2 = th8;
                        cls = int[].class;
                        Logger logger3 = f3364a;
                        Level level3 = Level.WARNING;
                        String valueOf3 = String.valueOf(th2);
                        StringBuilder sb3 = new StringBuilder(valueOf3.length() + 71);
                        sb3.append("platform method missing - proto runtime falling back to safer methods: ");
                        sb3.append(valueOf3);
                        logger3.logp(level3, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb3.toString());
                        z = false;
                        f3370g = z;
                        unsafe2 = f3365b;
                        if (unsafe2 != null) {
                        }
                        z2 = true;
                        h = z3;
                        l(boolean[].class);
                        m(boolean[].class);
                        l(cls);
                        m(cls);
                        l(cls2);
                        m(cls2);
                        l(float[].class);
                        m(float[].class);
                        l(double[].class);
                        m(double[].class);
                        l(Object[].class);
                        m(Object[].class);
                        Field k22222222 = k();
                        j = (k22222222 != null || (dVar3 = f3369f) == null) ? -1 : dVar3.a(k22222222);
                        Field h22222222 = h(String.class, "value");
                        if (h22222222 == null) {
                        }
                        dVar2.a(field);
                        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                        }
                        k = z4;
                    }
                } catch (Throwable th9) {
                    th2 = th9;
                    cls2 = long[].class;
                    cls = int[].class;
                    Logger logger32 = f3364a;
                    Level level32 = Level.WARNING;
                    String valueOf32 = String.valueOf(th2);
                    StringBuilder sb32 = new StringBuilder(valueOf32.length() + 71);
                    sb32.append("platform method missing - proto runtime falling back to safer methods: ");
                    sb32.append(valueOf32);
                    logger32.logp(level32, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb32.toString());
                    z = false;
                    f3370g = z;
                    unsafe2 = f3365b;
                    if (unsafe2 != null) {
                    }
                    z2 = true;
                    h = z3;
                    l(boolean[].class);
                    m(boolean[].class);
                    l(cls);
                    m(cls);
                    l(cls2);
                    m(cls2);
                    l(float[].class);
                    m(float[].class);
                    l(double[].class);
                    m(double[].class);
                    l(Object[].class);
                    m(Object[].class);
                    Field k222222222 = k();
                    j = (k222222222 != null || (dVar3 = f3369f) == null) ? -1 : dVar3.a(k222222222);
                    Field h222222222 = h(String.class, "value");
                    if (h222222222 == null) {
                    }
                    dVar2.a(field);
                    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                    }
                    k = z4;
                }
            }
            cls = int[].class;
            z = false;
            f3370g = z;
            unsafe2 = f3365b;
            if (unsafe2 != null) {
            }
            z2 = true;
            h = z3;
            l(boolean[].class);
            m(boolean[].class);
            l(cls);
            m(cls);
            l(cls2);
            m(cls2);
            l(float[].class);
            m(float[].class);
            l(double[].class);
            m(double[].class);
            l(Object[].class);
            m(Object[].class);
            Field k2222222222 = k();
            j = (k2222222222 != null || (dVar3 = f3369f) == null) ? -1 : dVar3.a(k2222222222);
            Field h2222222222 = h(String.class, "value");
            if (h2222222222 == null) {
            }
            dVar2.a(field);
            if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            }
            k = z4;
        }
        dVar = null;
        f3369f = dVar;
        unsafe = f3365b;
        boolean z42 = false;
        if (unsafe != null) {
        }
        cls = int[].class;
        z = false;
        f3370g = z;
        unsafe2 = f3365b;
        if (unsafe2 != null) {
        }
        z2 = true;
        h = z3;
        l(boolean[].class);
        m(boolean[].class);
        l(cls);
        m(cls);
        l(cls2);
        m(cls2);
        l(float[].class);
        m(float[].class);
        l(double[].class);
        m(double[].class);
        l(Object[].class);
        m(Object[].class);
        Field k22222222222 = k();
        j = (k22222222222 != null || (dVar3 = f3369f) == null) ? -1 : dVar3.a(k22222222222);
        Field h22222222222 = h(String.class, "value");
        if (h22222222222 == null) {
        }
        dVar2.a(field);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
        }
        k = z42;
    }

    public static byte a(byte[] bArr, long j2) {
        return f3369f.o(bArr, i + j2);
    }

    public static long b(Field field) {
        return f3369f.a(field);
    }

    public static void c(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int o = o(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        d dVar = f3369f;
        dVar.e(obj, j3, ((255 & b2) << i2) | (o & (~(BuildConfig.VERSION_CODE << i2))));
    }

    public static void d(Object obj, long j2, double d2) {
        f3369f.c(obj, j2, d2);
    }

    public static void e(Object obj, long j2, long j3) {
        f3369f.f(obj, j2, j3);
    }

    public static void f(Object obj, long j2, Object obj2) {
        f3369f.f3371a.putObject(obj, j2, obj2);
    }

    public static void g(byte[] bArr, long j2, byte b2) {
        f3369f.i(bArr, i + j2, b2);
    }

    public static Field h(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void i(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        d dVar = f3369f;
        dVar.e(obj, j3, ((255 & b2) << i2) | (o(obj, j3) & (~(BuildConfig.VERSION_CODE << i2))));
    }

    public static Unsafe j() {
        try {
            return (Unsafe) AccessController.doPrivileged(new o3());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field k() {
        Field h2;
        if (t.a() && (h2 = h(Buffer.class, "effectiveDirectAddress")) != null) {
            return h2;
        }
        Field h3 = h(Buffer.class, "address");
        if (h3 == null || h3.getType() != Long.TYPE) {
            return null;
        }
        return h3;
    }

    public static int l(Class<?> cls) {
        if (h) {
            return f3369f.f3371a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int m(Class<?> cls) {
        if (h) {
            return f3369f.f3371a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static boolean n(Class<?> cls) {
        if (!t.a()) {
            return false;
        }
        try {
            Class<?> cls2 = f3366c;
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

    public static int o(Object obj, long j2) {
        return f3369f.j(obj, j2);
    }

    public static long p(Object obj, long j2) {
        return f3369f.k(obj, j2);
    }

    public static boolean q(Object obj, long j2) {
        return f3369f.l(obj, j2);
    }

    public static float r(Object obj, long j2) {
        return f3369f.m(obj, j2);
    }

    public static double s(Object obj, long j2) {
        return f3369f.n(obj, j2);
    }

    public static Object t(Object obj, long j2) {
        return f3369f.f3371a.getObject(obj, j2);
    }

    public static byte u(Object obj, long j2) {
        return (byte) (o(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3)));
    }

    public static byte v(Object obj, long j2) {
        return (byte) (o(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3)));
    }
}
