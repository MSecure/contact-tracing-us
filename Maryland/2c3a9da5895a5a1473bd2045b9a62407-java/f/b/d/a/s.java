package f.b.d.a;

import f.b.d.a.a;
import f.b.d.a.n;
import f.b.f.a1;
import f.b.f.b1;
import f.b.f.j;
import f.b.f.p1;
import f.b.f.z;
import java.util.Objects;

public final class s extends z<s, b> implements Object {
    public static final int ARRAY_VALUE_FIELD_NUMBER = 9;
    public static final int BOOLEAN_VALUE_FIELD_NUMBER = 1;
    public static final int BYTES_VALUE_FIELD_NUMBER = 18;
    private static final s DEFAULT_INSTANCE;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 3;
    public static final int GEO_POINT_VALUE_FIELD_NUMBER = 8;
    public static final int INTEGER_VALUE_FIELD_NUMBER = 2;
    public static final int MAP_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 11;
    private static volatile b1<s> PARSER = null;
    public static final int REFERENCE_VALUE_FIELD_NUMBER = 5;
    public static final int STRING_VALUE_FIELD_NUMBER = 17;
    public static final int TIMESTAMP_VALUE_FIELD_NUMBER = 10;
    private int valueTypeCase_ = 0;
    private Object valueType_;

    public static final class b extends z.a<s, b> implements Object {
        public b() {
            super(s.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(s.DEFAULT_INSTANCE);
        }

        public b b(a.b bVar) {
            copyOnWrite();
            s.h((s) this.instance, (a) bVar.build());
            return this;
        }

        public b c(double d2) {
            copyOnWrite();
            s.m((s) this.instance, d2);
            return this;
        }

        public b d(long j2) {
            copyOnWrite();
            s.l((s) this.instance, j2);
            return this;
        }

        public b e(n.b bVar) {
            copyOnWrite();
            s.i((s) this.instance, (n) bVar.build());
            return this;
        }

        public b f(n nVar) {
            copyOnWrite();
            s.i((s) this.instance, nVar);
            return this;
        }
    }

    public enum c {
        NULL_VALUE(11),
        BOOLEAN_VALUE(1),
        INTEGER_VALUE(2),
        DOUBLE_VALUE(3),
        TIMESTAMP_VALUE(10),
        STRING_VALUE(17),
        BYTES_VALUE(18),
        REFERENCE_VALUE(5),
        GEO_POINT_VALUE(8),
        ARRAY_VALUE(9),
        MAP_VALUE(6),
        VALUETYPE_NOT_SET(0);

        /* access modifiers changed from: public */
        c(int i2) {
        }
    }

    static {
        s sVar = new s();
        DEFAULT_INSTANCE = sVar;
        z.registerDefaultInstance(s.class, sVar);
    }

    public static void c(s sVar, p1 p1Var) {
        Objects.requireNonNull(sVar);
        p1Var.getClass();
        sVar.valueType_ = p1Var;
        sVar.valueTypeCase_ = 10;
    }

    public static void d(s sVar, String str) {
        Objects.requireNonNull(sVar);
        str.getClass();
        sVar.valueTypeCase_ = 17;
        sVar.valueType_ = str;
    }

    public static void e(s sVar, j jVar) {
        Objects.requireNonNull(sVar);
        jVar.getClass();
        sVar.valueTypeCase_ = 18;
        sVar.valueType_ = jVar;
    }

    public static void f(s sVar, String str) {
        Objects.requireNonNull(sVar);
        str.getClass();
        sVar.valueTypeCase_ = 5;
        sVar.valueType_ = str;
    }

    public static void g(s sVar, f.b.h.a aVar) {
        Objects.requireNonNull(sVar);
        aVar.getClass();
        sVar.valueType_ = aVar;
        sVar.valueTypeCase_ = 8;
    }

    public static void h(s sVar, a aVar) {
        Objects.requireNonNull(sVar);
        aVar.getClass();
        sVar.valueType_ = aVar;
        sVar.valueTypeCase_ = 9;
    }

    public static void i(s sVar, n nVar) {
        Objects.requireNonNull(sVar);
        nVar.getClass();
        sVar.valueType_ = nVar;
        sVar.valueTypeCase_ = 6;
    }

    public static void j(s sVar, a1 a1Var) {
        Objects.requireNonNull(sVar);
        sVar.valueType_ = Integer.valueOf(a1Var.getNumber());
        sVar.valueTypeCase_ = 11;
    }

    public static void k(s sVar, boolean z) {
        sVar.valueTypeCase_ = 1;
        sVar.valueType_ = Boolean.valueOf(z);
    }

    public static void l(s sVar, long j2) {
        sVar.valueTypeCase_ = 2;
        sVar.valueType_ = Long.valueOf(j2);
    }

    public static void m(s sVar, double d2) {
        sVar.valueTypeCase_ = 3;
        sVar.valueType_ = Double.valueOf(d2);
    }

    public static s q() {
        return DEFAULT_INSTANCE;
    }

    public static b z() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u000b\u0001\u0000\u0001\u0012\u000b\u0000\u0000\u0000\u0001:\u0000\u00025\u0000\u00033\u0000\u0005Ȼ\u0000\u0006<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b?\u0000\u0011Ȼ\u0000\u0012=\u0000", new Object[]{"valueType_", "valueTypeCase_", n.class, f.b.h.a.class, a.class, p1.class});
            case 3:
                return new s();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<s> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (s.class) {
                        b1Var = PARSER;
                        if (b1Var == null) {
                            b1Var = new z.b<>(DEFAULT_INSTANCE);
                            PARSER = b1Var;
                        }
                    }
                }
                return b1Var;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public a n() {
        return this.valueTypeCase_ == 9 ? (a) this.valueType_ : a.g();
    }

    public boolean o() {
        if (this.valueTypeCase_ == 1) {
            return ((Boolean) this.valueType_).booleanValue();
        }
        return false;
    }

    public j p() {
        return this.valueTypeCase_ == 18 ? (j) this.valueType_ : j.c;
    }

    public double r() {
        if (this.valueTypeCase_ == 3) {
            return ((Double) this.valueType_).doubleValue();
        }
        return 0.0d;
    }

    public f.b.h.a s() {
        return this.valueTypeCase_ == 8 ? (f.b.h.a) this.valueType_ : f.b.h.a.e();
    }

    public long t() {
        if (this.valueTypeCase_ == 2) {
            return ((Long) this.valueType_).longValue();
        }
        return 0;
    }

    public n u() {
        return this.valueTypeCase_ == 6 ? (n) this.valueType_ : n.d();
    }

    public String v() {
        return this.valueTypeCase_ == 5 ? (String) this.valueType_ : "";
    }

    public String w() {
        return this.valueTypeCase_ == 17 ? (String) this.valueType_ : "";
    }

    public p1 x() {
        return this.valueTypeCase_ == 10 ? (p1) this.valueType_ : p1.e();
    }

    public c y() {
        int i2 = this.valueTypeCase_;
        if (i2 == 0) {
            return c.VALUETYPE_NOT_SET;
        }
        if (i2 == 1) {
            return c.BOOLEAN_VALUE;
        }
        if (i2 == 2) {
            return c.INTEGER_VALUE;
        }
        if (i2 == 3) {
            return c.DOUBLE_VALUE;
        }
        if (i2 == 5) {
            return c.REFERENCE_VALUE;
        }
        if (i2 == 6) {
            return c.MAP_VALUE;
        }
        if (i2 == 17) {
            return c.STRING_VALUE;
        }
        if (i2 == 18) {
            return c.BYTES_VALUE;
        }
        switch (i2) {
            case 8:
                return c.GEO_POINT_VALUE;
            case 9:
                return c.ARRAY_VALUE;
            case 10:
                return c.TIMESTAMP_VALUE;
            case 11:
                return c.NULL_VALUE;
            default:
                return null;
        }
    }
}
