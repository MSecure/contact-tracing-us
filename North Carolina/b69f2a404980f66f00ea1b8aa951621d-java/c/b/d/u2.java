package c.b.d;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public final class u2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f4353a = Logger.getLogger(u2.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public static final Unsafe f4354b = q();

    /* renamed from: c  reason: collision with root package name */
    public static final Class<?> f4355c = e.f3844a;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f4356d = f(Long.TYPE);

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f4357e = f(Integer.TYPE);
    public static final e f;
    public static final boolean g;
    public static final boolean h;
    public static final long i = ((long) c(byte[].class));
    public static final long j;
    public static final boolean k;

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

        @Override // c.b.d.u2.e
        public void c(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // c.b.d.u2.e
        public boolean d(Object obj, long j) {
            return u2.k ? u2.j(obj, j) != 0 : u2.k(obj, j) != 0;
        }

        @Override // c.b.d.u2.e
        public byte e(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // c.b.d.u2.e
        public byte f(Object obj, long j) {
            if (u2.k) {
                return u2.j(obj, j);
            }
            return u2.k(obj, j);
        }

        @Override // c.b.d.u2.e
        public double g(Object obj, long j) {
            return Double.longBitsToDouble(j(obj, j));
        }

        @Override // c.b.d.u2.e
        public float h(Object obj, long j) {
            return Float.intBitsToFloat(i(obj, j));
        }

        @Override // c.b.d.u2.e
        public Object l(Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.d.u2.e
        public void n(Object obj, long j, boolean z) {
            if (u2.k) {
                u2.u(obj, j, z ? (byte) 1 : 0);
            } else {
                u2.v(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // c.b.d.u2.e
        public void o(Object obj, long j, byte b2) {
            if (u2.k) {
                u2.u(obj, j, b2);
            } else {
                u2.v(obj, j, b2);
            }
        }

        @Override // c.b.d.u2.e
        public void p(Object obj, long j, double d2) {
            s(obj, j, Double.doubleToLongBits(d2));
        }

        @Override // c.b.d.u2.e
        public void q(Object obj, long j, float f) {
            r(obj, j, Float.floatToIntBits(f));
        }
    }

    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // c.b.d.u2.e
        public void c(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // c.b.d.u2.e
        public boolean d(Object obj, long j) {
            return u2.k ? u2.j(obj, j) != 0 : u2.k(obj, j) != 0;
        }

        @Override // c.b.d.u2.e
        public byte e(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // c.b.d.u2.e
        public byte f(Object obj, long j) {
            if (u2.k) {
                return u2.j(obj, j);
            }
            return u2.k(obj, j);
        }

        @Override // c.b.d.u2.e
        public double g(Object obj, long j) {
            return Double.longBitsToDouble(j(obj, j));
        }

        @Override // c.b.d.u2.e
        public float h(Object obj, long j) {
            return Float.intBitsToFloat(i(obj, j));
        }

        @Override // c.b.d.u2.e
        public Object l(Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: boolean */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // c.b.d.u2.e
        public void n(Object obj, long j, boolean z) {
            if (u2.k) {
                u2.u(obj, j, z ? (byte) 1 : 0);
            } else {
                u2.v(obj, j, z ? (byte) 1 : 0);
            }
        }

        @Override // c.b.d.u2.e
        public void o(Object obj, long j, byte b2) {
            if (u2.k) {
                u2.u(obj, j, b2);
            } else {
                u2.v(obj, j, b2);
            }
        }

        @Override // c.b.d.u2.e
        public void p(Object obj, long j, double d2) {
            s(obj, j, Double.doubleToLongBits(d2));
        }

        @Override // c.b.d.u2.e
        public void q(Object obj, long j, float f) {
            r(obj, j, Float.floatToIntBits(f));
        }
    }

    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // c.b.d.u2.e
        public void c(long j, byte[] bArr, long j2, long j3) {
            this.f4358a.copyMemory((Object) null, j, bArr, u2.i + j2, j3);
        }

        @Override // c.b.d.u2.e
        public boolean d(Object obj, long j) {
            return this.f4358a.getBoolean(obj, j);
        }

        @Override // c.b.d.u2.e
        public byte e(long j) {
            return this.f4358a.getByte(j);
        }

        @Override // c.b.d.u2.e
        public byte f(Object obj, long j) {
            return this.f4358a.getByte(obj, j);
        }

        @Override // c.b.d.u2.e
        public double g(Object obj, long j) {
            return this.f4358a.getDouble(obj, j);
        }

        @Override // c.b.d.u2.e
        public float h(Object obj, long j) {
            return this.f4358a.getFloat(obj, j);
        }

        @Override // c.b.d.u2.e
        public Object l(Field field) {
            return k(this.f4358a.staticFieldBase(field), this.f4358a.staticFieldOffset(field));
        }

        @Override // c.b.d.u2.e
        public void n(Object obj, long j, boolean z) {
            this.f4358a.putBoolean(obj, j, z);
        }

        @Override // c.b.d.u2.e
        public void o(Object obj, long j, byte b2) {
            this.f4358a.putByte(obj, j, b2);
        }

        @Override // c.b.d.u2.e
        public void p(Object obj, long j, double d2) {
            this.f4358a.putDouble(obj, j, d2);
        }

        @Override // c.b.d.u2.e
        public void q(Object obj, long j, float f) {
            this.f4358a.putFloat(obj, j, f);
        }
    }

    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        public Unsafe f4358a;

        public e(Unsafe unsafe) {
            this.f4358a = unsafe;
        }

        public final int a(Class<?> cls) {
            return this.f4358a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f4358a.arrayIndexScale(cls);
        }

        public abstract void c(long j, byte[] bArr, long j2, long j3);

        public abstract boolean d(Object obj, long j);

        public abstract byte e(long j);

        public abstract byte f(Object obj, long j);

        public abstract double g(Object obj, long j);

        public abstract float h(Object obj, long j);

        public final int i(Object obj, long j) {
            return this.f4358a.getInt(obj, j);
        }

        public final long j(Object obj, long j) {
            return this.f4358a.getLong(obj, j);
        }

        public final Object k(Object obj, long j) {
            return this.f4358a.getObject(obj, j);
        }

        public abstract Object l(Field field);

        public final long m(Field field) {
            return this.f4358a.objectFieldOffset(field);
        }

        public abstract void n(Object obj, long j, boolean z);

        public abstract void o(Object obj, long j, byte b2);

        public abstract void p(Object obj, long j, double d2);

        public abstract void q(Object obj, long j, float f);

        public final void r(Object obj, long j, int i) {
            this.f4358a.putInt(obj, j, i);
        }

        public final void s(Object obj, long j, long j2) {
            this.f4358a.putLong(obj, j, j2);
        }

        public final void t(Object obj, long j, Object obj2) {
            this.f4358a.putObject(obj, j, obj2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x015c A[SYNTHETIC, Splitter:B:41:0x015c] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x02df  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x02e2  */
    static {
        Class cls;
        Class cls2;
        boolean z;
        Unsafe unsafe;
        boolean z2;
        boolean z3;
        e eVar;
        Object th;
        Object th2;
        e eVar2 = null;
        if (f4354b != null) {
            if (!e.a()) {
                eVar2 = new d(f4354b);
            } else if (f4356d) {
                eVar2 = new c(f4354b);
            } else if (f4357e) {
                eVar2 = new b(f4354b);
            }
        }
        f = eVar2;
        Unsafe unsafe2 = f4354b;
        if (unsafe2 == null) {
            cls2 = float[].class;
        } else {
            try {
                Class<?> cls3 = unsafe2.getClass();
                cls2 = float[].class;
                try {
                    cls3.getMethod("objectFieldOffset", Field.class);
                    cls3.getMethod("getLong", Object.class, Long.TYPE);
                    if (e() != null) {
                        if (e.a()) {
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
                        g = z;
                        unsafe = f4354b;
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
                                        if (e.a()) {
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
                                                    f4353a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
                                                    z3 = false;
                                                    h = z3;
                                                    c(boolean[].class);
                                                    d(boolean[].class);
                                                    c(int[].class);
                                                    d(int[].class);
                                                    c(cls);
                                                    d(cls);
                                                    c(cls2);
                                                    d(cls2);
                                                    c(double[].class);
                                                    d(double[].class);
                                                    c(Object[].class);
                                                    d(Object[].class);
                                                    Field e2 = e();
                                                    j = (e2 != null || (eVar = f) == null) ? -1 : eVar.m(e2);
                                                    k = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
                                                }
                                            } catch (Throwable th5) {
                                                th = th5;
                                                z2 = true;
                                                f4353a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
                                                z3 = false;
                                                h = z3;
                                                c(boolean[].class);
                                                d(boolean[].class);
                                                c(int[].class);
                                                d(int[].class);
                                                c(cls);
                                                d(cls);
                                                c(cls2);
                                                d(cls2);
                                                c(double[].class);
                                                d(double[].class);
                                                c(Object[].class);
                                                d(Object[].class);
                                                Field e22 = e();
                                                j = (e22 != null || (eVar = f) == null) ? -1 : eVar.m(e22);
                                                k = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
                                            }
                                            h = z3;
                                            c(boolean[].class);
                                            d(boolean[].class);
                                            c(int[].class);
                                            d(int[].class);
                                            c(cls);
                                            d(cls);
                                            c(cls2);
                                            d(cls2);
                                            c(double[].class);
                                            d(double[].class);
                                            c(Object[].class);
                                            d(Object[].class);
                                            Field e222 = e();
                                            j = (e222 != null || (eVar = f) == null) ? -1 : eVar.m(e222);
                                            k = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        z2 = true;
                                        f4353a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
                                        z3 = false;
                                        h = z3;
                                        c(boolean[].class);
                                        d(boolean[].class);
                                        c(int[].class);
                                        d(int[].class);
                                        c(cls);
                                        d(cls);
                                        c(cls2);
                                        d(cls2);
                                        c(double[].class);
                                        d(double[].class);
                                        c(Object[].class);
                                        d(Object[].class);
                                        Field e2222 = e();
                                        j = (e2222 != null || (eVar = f) == null) ? -1 : eVar.m(e2222);
                                        k = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    z2 = true;
                                    f4353a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
                                    z3 = false;
                                    h = z3;
                                    c(boolean[].class);
                                    d(boolean[].class);
                                    c(int[].class);
                                    d(int[].class);
                                    c(cls);
                                    d(cls);
                                    c(cls2);
                                    d(cls2);
                                    c(double[].class);
                                    d(double[].class);
                                    c(Object[].class);
                                    d(Object[].class);
                                    Field e22222 = e();
                                    j = (e22222 != null || (eVar = f) == null) ? -1 : eVar.m(e22222);
                                    k = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                z2 = true;
                                f4353a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
                                z3 = false;
                                h = z3;
                                c(boolean[].class);
                                d(boolean[].class);
                                c(int[].class);
                                d(int[].class);
                                c(cls);
                                d(cls);
                                c(cls2);
                                d(cls2);
                                c(double[].class);
                                d(double[].class);
                                c(Object[].class);
                                d(Object[].class);
                                Field e222222 = e();
                                j = (e222222 != null || (eVar = f) == null) ? -1 : eVar.m(e222222);
                                k = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
                            }
                        }
                        z2 = true;
                        h = z3;
                        c(boolean[].class);
                        d(boolean[].class);
                        c(int[].class);
                        d(int[].class);
                        c(cls);
                        d(cls);
                        c(cls2);
                        d(cls2);
                        c(double[].class);
                        d(double[].class);
                        c(Object[].class);
                        d(Object[].class);
                        Field e2222222 = e();
                        j = (e2222222 != null || (eVar = f) == null) ? -1 : eVar.m(e2222222);
                        k = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
                    }
                } catch (Throwable th9) {
                    th2 = th9;
                    cls = long[].class;
                    f4353a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th2);
                    z = false;
                    g = z;
                    unsafe = f4354b;
                    if (unsafe != null) {
                    }
                    z2 = true;
                    h = z3;
                    c(boolean[].class);
                    d(boolean[].class);
                    c(int[].class);
                    d(int[].class);
                    c(cls);
                    d(cls);
                    c(cls2);
                    d(cls2);
                    c(double[].class);
                    d(double[].class);
                    c(Object[].class);
                    d(Object[].class);
                    Field e22222222 = e();
                    j = (e22222222 != null || (eVar = f) == null) ? -1 : eVar.m(e22222222);
                    k = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
                }
            } catch (Throwable th10) {
                th2 = th10;
                cls2 = float[].class;
                cls = long[].class;
                f4353a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th2);
                z = false;
                g = z;
                unsafe = f4354b;
                if (unsafe != null) {
                }
                z2 = true;
                h = z3;
                c(boolean[].class);
                d(boolean[].class);
                c(int[].class);
                d(int[].class);
                c(cls);
                d(cls);
                c(cls2);
                d(cls2);
                c(double[].class);
                d(double[].class);
                c(Object[].class);
                d(Object[].class);
                Field e222222222 = e();
                j = (e222222222 != null || (eVar = f) == null) ? -1 : eVar.m(e222222222);
                k = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
            }
        }
        cls = long[].class;
        z = false;
        g = z;
        unsafe = f4354b;
        if (unsafe != null) {
        }
        z2 = true;
        h = z3;
        c(boolean[].class);
        d(boolean[].class);
        c(int[].class);
        d(int[].class);
        c(cls);
        d(cls);
        c(cls2);
        d(cls2);
        c(double[].class);
        d(double[].class);
        c(Object[].class);
        d(Object[].class);
        Field e2222222222 = e();
        j = (e2222222222 != null || (eVar = f) == null) ? -1 : eVar.m(e2222222222);
        k = ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN ? z2 : false;
    }

    public static void A(Object obj, long j2, Object obj2) {
        f.t(obj, j2, obj2);
    }

    public static long a(ByteBuffer byteBuffer) {
        return f.j(byteBuffer, j);
    }

    public static <T> T b(Class<T> cls) {
        try {
            return (T) f4354b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int c(Class<?> cls) {
        if (h) {
            return f.a(cls);
        }
        return -1;
    }

    public static int d(Class<?> cls) {
        if (h) {
            return f.b(cls);
        }
        return -1;
    }

    public static Field e() {
        Field field;
        Field field2;
        if (e.a()) {
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
        if (!e.a()) {
            return false;
        }
        try {
            Class<?> cls2 = f4355c;
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

    public static boolean g(Object obj, long j2) {
        return f.d(obj, j2);
    }

    public static byte h(long j2) {
        return f.e(j2);
    }

    public static byte i(byte[] bArr, long j2) {
        return f.f(bArr, i + j2);
    }

    public static byte j(Object obj, long j2) {
        return (byte) ((n(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    public static byte k(Object obj, long j2) {
        return (byte) ((n(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    public static double l(Object obj, long j2) {
        return f.g(obj, j2);
    }

    public static float m(Object obj, long j2) {
        return f.h(obj, j2);
    }

    public static int n(Object obj, long j2) {
        return f.i(obj, j2);
    }

    public static long o(Object obj, long j2) {
        return f.j(obj, j2);
    }

    public static Object p(Object obj, long j2) {
        return f.k(obj, j2);
    }

    public static Unsafe q() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long r(Field field) {
        return f.m(field);
    }

    public static void s(Object obj, long j2, boolean z) {
        f.n(obj, j2, z);
    }

    public static void t(byte[] bArr, long j2, byte b2) {
        f.o(bArr, i + j2, b2);
    }

    public static void u(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int n = n(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        e eVar = f;
        eVar.r(obj, j3, ((255 & b2) << i2) | (n & (~(255 << i2))));
    }

    public static void v(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        e eVar = f;
        eVar.r(obj, j3, ((255 & b2) << i2) | (n(obj, j3) & (~(255 << i2))));
    }

    public static void w(Object obj, long j2, double d2) {
        f.p(obj, j2, d2);
    }

    public static void x(Object obj, long j2, float f2) {
        f.q(obj, j2, f2);
    }

    public static void y(Object obj, long j2, int i2) {
        f.r(obj, j2, i2);
    }

    public static void z(Object obj, long j2, long j3) {
        f.s(obj, j2, j3);
    }
}
