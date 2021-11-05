package c.b.c.a.j0.a;

import gov.michigan.MiCovidExposure.BuildConfig;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public final class p1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f5001a = Logger.getLogger(p1.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public static final Unsafe f5002b = o();

    /* renamed from: c  reason: collision with root package name */
    public static final Class<?> f5003c = d.f4903a;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f5004d = e(Long.TYPE);

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f5005e = e(Integer.TYPE);

    /* renamed from: f  reason: collision with root package name */
    public static final e f5006f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f5007g;
    public static final boolean h;
    public static final long i = ((long) b(byte[].class));
    public static final boolean j;

    public class a implements PrivilegedExceptionAction<Unsafe> {
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

        @Override // c.b.c.a.j0.a.p1.e
        public boolean c(Object obj, long j) {
            return p1.j ? p1.h(obj, j) != 0 : p1.i(obj, j) != 0;
        }

        @Override // c.b.c.a.j0.a.p1.e
        public byte d(Object obj, long j) {
            if (p1.j) {
                return p1.h(obj, j);
            }
            return p1.i(obj, j);
        }

        @Override // c.b.c.a.j0.a.p1.e
        public double e(Object obj, long j) {
            return Double.longBitsToDouble(h(obj, j));
        }

        @Override // c.b.c.a.j0.a.p1.e
        public float f(Object obj, long j) {
            return Float.intBitsToFloat(g(obj, j));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.c.a.j0.a.p1.e
        public void k(Object obj, long j, boolean z) {
            if (p1.j) {
                p1.r(obj, j, z ? (byte) 1 : 0);
            } else {
                p1.s(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // c.b.c.a.j0.a.p1.e
        public void l(Object obj, long j, byte b2) {
            if (p1.j) {
                p1.r(obj, j, b2);
            } else {
                p1.s(obj, j, b2);
            }
        }

        @Override // c.b.c.a.j0.a.p1.e
        public void m(Object obj, long j, double d2) {
            p(obj, j, Double.doubleToLongBits(d2));
        }

        @Override // c.b.c.a.j0.a.p1.e
        public void n(Object obj, long j, float f2) {
            o(obj, j, Float.floatToIntBits(f2));
        }
    }

    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // c.b.c.a.j0.a.p1.e
        public boolean c(Object obj, long j) {
            return p1.j ? p1.h(obj, j) != 0 : p1.i(obj, j) != 0;
        }

        @Override // c.b.c.a.j0.a.p1.e
        public byte d(Object obj, long j) {
            if (p1.j) {
                return p1.h(obj, j);
            }
            return p1.i(obj, j);
        }

        @Override // c.b.c.a.j0.a.p1.e
        public double e(Object obj, long j) {
            return Double.longBitsToDouble(h(obj, j));
        }

        @Override // c.b.c.a.j0.a.p1.e
        public float f(Object obj, long j) {
            return Float.intBitsToFloat(g(obj, j));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.c.a.j0.a.p1.e
        public void k(Object obj, long j, boolean z) {
            if (p1.j) {
                p1.r(obj, j, z ? (byte) 1 : 0);
            } else {
                p1.s(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // c.b.c.a.j0.a.p1.e
        public void l(Object obj, long j, byte b2) {
            if (p1.j) {
                p1.r(obj, j, b2);
            } else {
                p1.s(obj, j, b2);
            }
        }

        @Override // c.b.c.a.j0.a.p1.e
        public void m(Object obj, long j, double d2) {
            p(obj, j, Double.doubleToLongBits(d2));
        }

        @Override // c.b.c.a.j0.a.p1.e
        public void n(Object obj, long j, float f2) {
            o(obj, j, Float.floatToIntBits(f2));
        }
    }

    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // c.b.c.a.j0.a.p1.e
        public boolean c(Object obj, long j) {
            return this.f5008a.getBoolean(obj, j);
        }

        @Override // c.b.c.a.j0.a.p1.e
        public byte d(Object obj, long j) {
            return this.f5008a.getByte(obj, j);
        }

        @Override // c.b.c.a.j0.a.p1.e
        public double e(Object obj, long j) {
            return this.f5008a.getDouble(obj, j);
        }

        @Override // c.b.c.a.j0.a.p1.e
        public float f(Object obj, long j) {
            return this.f5008a.getFloat(obj, j);
        }

        @Override // c.b.c.a.j0.a.p1.e
        public void k(Object obj, long j, boolean z) {
            this.f5008a.putBoolean(obj, j, z);
        }

        @Override // c.b.c.a.j0.a.p1.e
        public void l(Object obj, long j, byte b2) {
            this.f5008a.putByte(obj, j, b2);
        }

        @Override // c.b.c.a.j0.a.p1.e
        public void m(Object obj, long j, double d2) {
            this.f5008a.putDouble(obj, j, d2);
        }

        @Override // c.b.c.a.j0.a.p1.e
        public void n(Object obj, long j, float f2) {
            this.f5008a.putFloat(obj, j, f2);
        }
    }

    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        public Unsafe f5008a;

        public e(Unsafe unsafe) {
            this.f5008a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f5008a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f5008a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j);

        public abstract byte d(Object obj, long j);

        public abstract double e(Object obj, long j);

        public abstract float f(Object obj, long j);

        public final int g(Object obj, long j) {
            return this.f5008a.getInt(obj, j);
        }

        public final long h(Object obj, long j) {
            return this.f5008a.getLong(obj, j);
        }

        public final Object i(Object obj, long j) {
            return this.f5008a.getObject(obj, j);
        }

        public final long j(Field field) {
            return this.f5008a.objectFieldOffset(field);
        }

        public abstract void k(Object obj, long j, boolean z);

        public abstract void l(Object obj, long j, byte b2);

        public abstract void m(Object obj, long j, double d2);

        public abstract void n(Object obj, long j, float f2);

        public final void o(Object obj, long j, int i) {
            this.f5008a.putInt(obj, j, i);
        }

        public final void p(Object obj, long j, long j2) {
            this.f5008a.putLong(obj, j, j2);
        }

        public final void q(Object obj, long j, Object obj2) {
            this.f5008a.putObject(obj, j, obj2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x015c A[SYNTHETIC, Splitter:B:41:0x015c] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x02dc  */
    static {
        Class cls;
        Class cls2;
        boolean z;
        Unsafe unsafe;
        boolean z2;
        boolean z3;
        Field d2;
        e eVar;
        Object th;
        Object th2;
        e eVar2 = null;
        if (f5002b != null) {
            if (!d.a()) {
                eVar2 = new d(f5002b);
            } else if (f5004d) {
                eVar2 = new c(f5002b);
            } else if (f5005e) {
                eVar2 = new b(f5002b);
            }
        }
        f5006f = eVar2;
        Unsafe unsafe2 = f5002b;
        if (unsafe2 == null) {
            cls2 = float[].class;
        } else {
            try {
                Class<?> cls3 = unsafe2.getClass();
                cls2 = float[].class;
                try {
                    cls3.getMethod("objectFieldOffset", Field.class);
                    cls3.getMethod("getLong", Object.class, Long.TYPE);
                    if (d() != null) {
                        if (d.a()) {
                            cls = long[].class;
                        } else {
                            cls3.getMethod("getByte", Long.TYPE);
                            Class<?>[] clsArr = new Class[2];
                            clsArr[0] = Long.TYPE;
                            cls = long[].class;
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
                        f5007g = z;
                        unsafe = f5002b;
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
                                        if (d.a()) {
                                            z3 = true;
                                        } else {
                                            Class<?>[] clsArr5 = new Class[2];
                                            clsArr5[0] = Object.class;
                                            try {
                                                clsArr5[1] = Long.TYPE;
                                                cls4.getMethod("getByte", clsArr5);
                                                Class<?>[] clsArr6 = new Class[3];
                                                clsArr6[0] = Object.class;
                                                clsArr6[1] = Long.TYPE;
                                                clsArr6[2] = Byte.TYPE;
                                                cls4.getMethod("putByte", clsArr6);
                                                cls4.getMethod("getBoolean", Object.class, Long.TYPE);
                                                cls4.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
                                                cls4.getMethod("getFloat", Object.class, Long.TYPE);
                                                cls4.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
                                                cls4.getMethod("getDouble", Object.class, Long.TYPE);
                                                Class<?>[] clsArr7 = new Class[3];
                                                clsArr7[0] = Object.class;
                                                z2 = true;
                                                try {
                                                    clsArr7[1] = Long.TYPE;
                                                    clsArr7[2] = Double.TYPE;
                                                    cls4.getMethod("putDouble", clsArr7);
                                                    z3 = true;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    f5001a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
                                                    z3 = false;
                                                    h = z3;
                                                    b(boolean[].class);
                                                    c(boolean[].class);
                                                    b(int[].class);
                                                    c(int[].class);
                                                    b(cls);
                                                    c(cls);
                                                    b(cls2);
                                                    c(cls2);
                                                    b(double[].class);
                                                    c(double[].class);
                                                    b(Object[].class);
                                                    c(Object[].class);
                                                    d2 = d();
                                                    eVar.j(d2);
                                                    j = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
                                                }
                                            } catch (Throwable th5) {
                                                th = th5;
                                                z2 = true;
                                                f5001a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
                                                z3 = false;
                                                h = z3;
                                                b(boolean[].class);
                                                c(boolean[].class);
                                                b(int[].class);
                                                c(int[].class);
                                                b(cls);
                                                c(cls);
                                                b(cls2);
                                                c(cls2);
                                                b(double[].class);
                                                c(double[].class);
                                                b(Object[].class);
                                                c(Object[].class);
                                                d2 = d();
                                                eVar.j(d2);
                                                j = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
                                            }
                                            h = z3;
                                            b(boolean[].class);
                                            c(boolean[].class);
                                            b(int[].class);
                                            c(int[].class);
                                            b(cls);
                                            c(cls);
                                            b(cls2);
                                            c(cls2);
                                            b(double[].class);
                                            c(double[].class);
                                            b(Object[].class);
                                            c(Object[].class);
                                            d2 = d();
                                            if (!(d2 == null || (eVar = f5006f) == null)) {
                                                eVar.j(d2);
                                            }
                                            j = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        z2 = true;
                                        f5001a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
                                        z3 = false;
                                        h = z3;
                                        b(boolean[].class);
                                        c(boolean[].class);
                                        b(int[].class);
                                        c(int[].class);
                                        b(cls);
                                        c(cls);
                                        b(cls2);
                                        c(cls2);
                                        b(double[].class);
                                        c(double[].class);
                                        b(Object[].class);
                                        c(Object[].class);
                                        d2 = d();
                                        eVar.j(d2);
                                        j = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    z2 = true;
                                    f5001a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
                                    z3 = false;
                                    h = z3;
                                    b(boolean[].class);
                                    c(boolean[].class);
                                    b(int[].class);
                                    c(int[].class);
                                    b(cls);
                                    c(cls);
                                    b(cls2);
                                    c(cls2);
                                    b(double[].class);
                                    c(double[].class);
                                    b(Object[].class);
                                    c(Object[].class);
                                    d2 = d();
                                    eVar.j(d2);
                                    j = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                z2 = true;
                                f5001a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
                                z3 = false;
                                h = z3;
                                b(boolean[].class);
                                c(boolean[].class);
                                b(int[].class);
                                c(int[].class);
                                b(cls);
                                c(cls);
                                b(cls2);
                                c(cls2);
                                b(double[].class);
                                c(double[].class);
                                b(Object[].class);
                                c(Object[].class);
                                d2 = d();
                                eVar.j(d2);
                                j = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
                            }
                        }
                        z2 = true;
                        h = z3;
                        b(boolean[].class);
                        c(boolean[].class);
                        b(int[].class);
                        c(int[].class);
                        b(cls);
                        c(cls);
                        b(cls2);
                        c(cls2);
                        b(double[].class);
                        c(double[].class);
                        b(Object[].class);
                        c(Object[].class);
                        d2 = d();
                        eVar.j(d2);
                        j = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
                    }
                } catch (Throwable th9) {
                    th2 = th9;
                    cls = long[].class;
                    f5001a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th2);
                    z = false;
                    f5007g = z;
                    unsafe = f5002b;
                    if (unsafe != null) {
                    }
                    z2 = true;
                    h = z3;
                    b(boolean[].class);
                    c(boolean[].class);
                    b(int[].class);
                    c(int[].class);
                    b(cls);
                    c(cls);
                    b(cls2);
                    c(cls2);
                    b(double[].class);
                    c(double[].class);
                    b(Object[].class);
                    c(Object[].class);
                    d2 = d();
                    eVar.j(d2);
                    j = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
                }
            } catch (Throwable th10) {
                th2 = th10;
                cls2 = float[].class;
                cls = long[].class;
                f5001a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th2);
                z = false;
                f5007g = z;
                unsafe = f5002b;
                if (unsafe != null) {
                }
                z2 = true;
                h = z3;
                b(boolean[].class);
                c(boolean[].class);
                b(int[].class);
                c(int[].class);
                b(cls);
                c(cls);
                b(cls2);
                c(cls2);
                b(double[].class);
                c(double[].class);
                b(Object[].class);
                c(Object[].class);
                d2 = d();
                eVar.j(d2);
                j = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
            }
        }
        cls = long[].class;
        z = false;
        f5007g = z;
        unsafe = f5002b;
        if (unsafe != null) {
        }
        z2 = true;
        h = z3;
        b(boolean[].class);
        c(boolean[].class);
        b(int[].class);
        c(int[].class);
        b(cls);
        c(cls);
        b(cls2);
        c(cls2);
        b(double[].class);
        c(double[].class);
        b(Object[].class);
        c(Object[].class);
        d2 = d();
        eVar.j(d2);
        j = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
    }

    public static <T> T a(Class<T> cls) {
        try {
            return (T) f5002b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int b(Class<?> cls) {
        if (h) {
            return f5006f.a(cls);
        }
        return -1;
    }

    public static int c(Class<?> cls) {
        if (h) {
            return f5006f.b(cls);
        }
        return -1;
    }

    public static Field d() {
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

    public static boolean e(Class<?> cls) {
        if (!d.a()) {
            return false;
        }
        try {
            Class<?> cls2 = f5003c;
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

    public static boolean f(Object obj, long j2) {
        return f5006f.c(obj, j2);
    }

    public static byte g(byte[] bArr, long j2) {
        return f5006f.d(bArr, i + j2);
    }

    public static byte h(Object obj, long j2) {
        return (byte) ((l(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3))) & BuildConfig.VERSION_CODE);
    }

    public static byte i(Object obj, long j2) {
        return (byte) ((l(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3))) & BuildConfig.VERSION_CODE);
    }

    public static double j(Object obj, long j2) {
        return f5006f.e(obj, j2);
    }

    public static float k(Object obj, long j2) {
        return f5006f.f(obj, j2);
    }

    public static int l(Object obj, long j2) {
        return f5006f.g(obj, j2);
    }

    public static long m(Object obj, long j2) {
        return f5006f.h(obj, j2);
    }

    public static Object n(Object obj, long j2) {
        return f5006f.i(obj, j2);
    }

    public static Unsafe o() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void p(Object obj, long j2, boolean z) {
        f5006f.k(obj, j2, z);
    }

    public static void q(byte[] bArr, long j2, byte b2) {
        f5006f.l(bArr, i + j2, b2);
    }

    public static void r(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int l = l(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        e eVar = f5006f;
        eVar.o(obj, j3, ((255 & b2) << i2) | (l & (~(BuildConfig.VERSION_CODE << i2))));
    }

    public static void s(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        e eVar = f5006f;
        eVar.o(obj, j3, ((255 & b2) << i2) | (l(obj, j3) & (~(BuildConfig.VERSION_CODE << i2))));
    }

    public static void t(Object obj, long j2, double d2) {
        f5006f.m(obj, j2, d2);
    }

    public static void u(Object obj, long j2, float f2) {
        f5006f.n(obj, j2, f2);
    }

    public static void v(Object obj, long j2, int i2) {
        f5006f.o(obj, j2, i2);
    }

    public static void w(Object obj, long j2, long j3) {
        f5006f.p(obj, j2, j3);
    }

    public static void x(Object obj, long j2, Object obj2) {
        f5006f.q(obj, j2, obj2);
    }
}
