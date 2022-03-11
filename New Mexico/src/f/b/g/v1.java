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
/* loaded from: classes.dex */
public final class v1 {
    public static final Unsafe b;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f3951d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f3952e;

    /* renamed from: f  reason: collision with root package name */
    public static final e f3953f;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f3954g;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f3955h;

    /* renamed from: i  reason: collision with root package name */
    public static final long f3956i;

    /* renamed from: j  reason: collision with root package name */
    public static final long f3957j;

    /* renamed from: k  reason: collision with root package name */
    public static final boolean f3958k;
    public static final Logger a = Logger.getLogger(v1.class.getName());
    public static final Class<?> c = d.a;

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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
            if (v1.f3958k) {
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
            if (v1.f3958k) {
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.g.v1.e
        public void m(Object obj, long j2, boolean z) {
            if (v1.f3958k) {
                v1.t(obj, j2, z ? (byte) 1 : 0);
            } else {
                v1.u(obj, j2, z ? (byte) 1 : 0);
            }
        }

        @Override // f.b.g.v1.e
        public void n(Object obj, long j2, byte b) {
            if (v1.f3958k) {
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

    /* loaded from: classes.dex */
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
            if (v1.f3958k) {
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
            if (v1.f3958k) {
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

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f.b.g.v1.e
        public void m(Object obj, long j2, boolean z) {
            if (v1.f3958k) {
                v1.t(obj, j2, z ? (byte) 1 : 0);
            } else {
                v1.u(obj, j2, z ? (byte) 1 : 0);
            }
        }

        @Override // f.b.g.v1.e
        public void n(Object obj, long j2, byte b) {
            if (v1.f3958k) {
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

    /* loaded from: classes.dex */
    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // f.b.g.v1.e
        public void c(long j2, byte[] bArr, long j3, long j4) {
            this.a.copyMemory((Object) null, j2, bArr, v1.f3956i + j3, j4);
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

    /* loaded from: classes.dex */
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

    /* JADX WARN: Removed duplicated region for block: B:36:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0130 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        Class cls;
        Class cls2;
        Object th;
        Class<?> cls3;
        boolean z;
        Unsafe unsafe;
        Object th2;
        Class<?> cls4;
        Class<?>[] clsArr;
        Class<?> cls5;
        boolean z2;
        e eVar;
        Unsafe q = q();
        b = q;
        Class<?> cls6 = Long.TYPE;
        boolean f2 = f(cls6);
        f3951d = f2;
        Class<?> cls7 = Integer.TYPE;
        boolean f3 = f(cls7);
        f3952e = f3;
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
        f3953f = eVar2;
        if (q == null) {
            cls2 = int[].class;
        } else {
            try {
                cls3 = q.getClass();
                cls2 = int[].class;
                try {
                    cls3.getMethod("objectFieldOffset", Field.class);
                    cls3.getMethod("getLong", Object.class, cls6);
                } catch (Throwable th3) {
                    th = th3;
                    cls = boolean[].class;
                    a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
                    z = false;
                    f3954g = z;
                    unsafe = b;
                    if (unsafe == null) {
                    }
                    z2 = false;
                    f3955h = z2;
                    f3956i = (long) c(byte[].class);
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
                    f3957j = (e2 != null || (eVar = f3953f) == null) ? -1 : eVar.l(e2);
                    f3958k = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN;
                }
            } catch (Throwable th4) {
                th = th4;
                cls2 = int[].class;
            }
            if (e() != null) {
                if (d.a()) {
                    cls = boolean[].class;
                } else {
                    cls3.getMethod("getByte", cls6);
                    Class<?>[] clsArr2 = new Class[2];
                    clsArr2[0] = cls6;
                    cls = boolean[].class;
                    try {
                        clsArr2[1] = Byte.TYPE;
                        cls3.getMethod("putByte", clsArr2);
                        cls3.getMethod("getInt", cls6);
                        cls3.getMethod("putInt", cls6, cls7);
                        cls3.getMethod("getLong", cls6);
                        cls3.getMethod("putLong", cls6, cls6);
                        cls3.getMethod("copyMemory", cls6, cls6, cls6);
                        cls3.getMethod("copyMemory", Object.class, cls6, Object.class, cls6, cls6);
                    } catch (Throwable th5) {
                        th = th5;
                        a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
                        z = false;
                        f3954g = z;
                        unsafe = b;
                        if (unsafe == null) {
                        }
                        z2 = false;
                        f3955h = z2;
                        f3956i = (long) c(byte[].class);
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
                        f3957j = (e22 != null || (eVar = f3953f) == null) ? -1 : eVar.l(e22);
                        f3958k = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN;
                    }
                }
                z = true;
                f3954g = z;
                unsafe = b;
                if (unsafe == null) {
                    try {
                        cls4 = unsafe.getClass();
                        cls4.getMethod("objectFieldOffset", Field.class);
                        cls4.getMethod("arrayBaseOffset", Class.class);
                        cls4.getMethod("arrayIndexScale", Class.class);
                        clsArr = new Class[2];
                        clsArr[0] = Object.class;
                        cls5 = Long.TYPE;
                    } catch (Throwable th6) {
                        th2 = th6;
                    }
                    try {
                        clsArr[1] = cls5;
                        cls4.getMethod("getInt", clsArr);
                        Class<?>[] clsArr3 = new Class[3];
                        clsArr3[0] = Object.class;
                        clsArr3[1] = cls5;
                        clsArr3[2] = Integer.TYPE;
                        cls4.getMethod("putInt", clsArr3);
                        Class<?>[] clsArr4 = new Class[2];
                        clsArr4[0] = Object.class;
                        clsArr4[1] = cls5;
                        cls4.getMethod("getLong", clsArr4);
                        Class<?>[] clsArr5 = new Class[3];
                        clsArr5[0] = Object.class;
                        clsArr5[1] = cls5;
                        clsArr5[2] = cls5;
                        cls4.getMethod("putLong", clsArr5);
                        cls4.getMethod("getObject", Object.class, cls5);
                        cls4.getMethod("putObject", Object.class, cls5, Object.class);
                        if (!d.a()) {
                            cls4.getMethod("getByte", Object.class, cls5);
                            cls4.getMethod("putByte", Object.class, cls5, Byte.TYPE);
                            cls4.getMethod("getBoolean", Object.class, cls5);
                            cls4.getMethod("putBoolean", Object.class, cls5, Boolean.TYPE);
                            Class<?>[] clsArr6 = new Class[2];
                            clsArr6[0] = Object.class;
                            clsArr6[1] = cls5;
                            cls4.getMethod("getFloat", clsArr6);
                            Class<?>[] clsArr7 = new Class[3];
                            clsArr7[0] = Object.class;
                            clsArr7[1] = cls5;
                            clsArr7[2] = Float.TYPE;
                            cls4.getMethod("putFloat", clsArr7);
                            Class<?>[] clsArr8 = new Class[2];
                            clsArr8[0] = Object.class;
                            clsArr8[1] = cls5;
                            cls4.getMethod("getDouble", clsArr8);
                            cls4.getMethod("putDouble", Object.class, cls5, Double.TYPE);
                        }
                        z2 = true;
                    } catch (Throwable th7) {
                        th2 = th7;
                        a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th2);
                        z2 = false;
                        f3955h = z2;
                        f3956i = (long) c(byte[].class);
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
                        f3957j = (e222 != null || (eVar = f3953f) == null) ? -1 : eVar.l(e222);
                        f3958k = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN;
                    }
                    f3955h = z2;
                    f3956i = (long) c(byte[].class);
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
                    f3957j = (e2222 != null || (eVar = f3953f) == null) ? -1 : eVar.l(e2222);
                    f3958k = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN;
                }
                z2 = false;
                f3955h = z2;
                f3956i = (long) c(byte[].class);
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
                f3957j = (e22222 != null || (eVar = f3953f) == null) ? -1 : eVar.l(e22222);
                f3958k = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN;
            }
        }
        cls = boolean[].class;
        z = false;
        f3954g = z;
        unsafe = b;
        if (unsafe == null) {
        }
        z2 = false;
        f3955h = z2;
        f3956i = (long) c(byte[].class);
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
        f3957j = (e222222 != null || (eVar = f3953f) == null) ? -1 : eVar.l(e222222);
        f3958k = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN;
    }

    public static long a(ByteBuffer byteBuffer) {
        return f3953f.j(byteBuffer, f3957j);
    }

    public static <T> T b(Class<T> cls) {
        try {
            return (T) b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int c(Class<?> cls) {
        if (f3955h) {
            return f3953f.a(cls);
        }
        return -1;
    }

    public static int d(Class<?> cls) {
        if (f3955h) {
            return f3953f.b(cls);
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
        return f3953f.d(obj, j2);
    }

    public static byte h(long j2) {
        return f3953f.e(j2);
    }

    public static byte i(byte[] bArr, long j2) {
        return f3953f.f(bArr, f3956i + j2);
    }

    public static byte j(Object obj, long j2) {
        return (byte) ((n(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    public static byte k(Object obj, long j2) {
        return (byte) ((n(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    public static double l(Object obj, long j2) {
        return f3953f.g(obj, j2);
    }

    public static float m(Object obj, long j2) {
        return f3953f.h(obj, j2);
    }

    public static int n(Object obj, long j2) {
        return f3953f.i(obj, j2);
    }

    public static long o(Object obj, long j2) {
        return f3953f.j(obj, j2);
    }

    public static Object p(Object obj, long j2) {
        return f3953f.k(obj, j2);
    }

    public static Unsafe q() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void r(Object obj, long j2, boolean z) {
        f3953f.m(obj, j2, z);
    }

    public static void s(byte[] bArr, long j2, byte b2) {
        f3953f.n(bArr, f3956i + j2, b2);
    }

    public static void t(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int n = n(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        e eVar = f3953f;
        eVar.q(obj, j3, ((255 & b2) << i2) | (n & (~(255 << i2))));
    }

    public static void u(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        e eVar = f3953f;
        eVar.q(obj, j3, ((255 & b2) << i2) | (n(obj, j3) & (~(255 << i2))));
    }

    public static void v(Object obj, long j2, double d2) {
        f3953f.o(obj, j2, d2);
    }

    public static void w(Object obj, long j2, float f2) {
        f3953f.p(obj, j2, f2);
    }

    public static void x(Object obj, long j2, int i2) {
        f3953f.q(obj, j2, i2);
    }

    public static void y(Object obj, long j2, long j3) {
        f3953f.r(obj, j2, j3);
    }

    public static void z(Object obj, long j2, Object obj2) {
        f3953f.s(obj, j2, obj2);
    }
}
