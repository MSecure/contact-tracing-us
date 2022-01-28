package f.b.a.d.a.i0;

import f.b.g.b1;
import f.b.g.c0;
import f.b.g.z;
import java.util.Objects;

public final class e extends z<e, b> implements Object {
    private static final e DEFAULT_INSTANCE;
    public static final int ERROR_DETAILS_FIELD_NUMBER = 2;
    private static volatile b1<e> PARSER = null;
    public static final int STATUS_CODE_FIELD_NUMBER = 1;
    private int bitField0_;
    private String errorDetails_ = "";
    private int statusCode_;

    public static final class b extends z.a<e, b> implements Object {
        public b() {
            super(e.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(e.DEFAULT_INSTANCE);
        }
    }

    public enum c implements c0.c {
        UNKNOWN_FAILURE(0),
        OK(1),
        CANCELLED_FAILURE(2),
        INVALID_PARAMETER_FAILURE(3),
        LIBRARY_UNAVAILABLE(4);
        
        public final int b;

        public static final class a implements c0.e {
            public static final c0.e a = new a();

            @Override // f.b.g.c0.e
            public boolean isInRange(int i2) {
                return c.a(i2) != null;
            }
        }

        /* access modifiers changed from: public */
        c(int i2) {
            this.b = i2;
        }

        public static c a(int i2) {
            if (i2 == 0) {
                return UNKNOWN_FAILURE;
            }
            if (i2 == 1) {
                return OK;
            }
            if (i2 == 2) {
                return CANCELLED_FAILURE;
            }
            if (i2 == 3) {
                return INVALID_PARAMETER_FAILURE;
            }
            if (i2 != 4) {
                return null;
            }
            return LIBRARY_UNAVAILABLE;
        }

        @Override // f.b.g.c0.c
        public final int getNumber() {
            return this.b;
        }
    }

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        z.registerDefaultInstance(e.class, eVar);
    }

    public static void c(e eVar, c cVar) {
        Objects.requireNonNull(eVar);
        eVar.statusCode_ = cVar.b;
        eVar.bitField0_ |= 1;
    }

    public static void d(e eVar, String str) {
        Objects.requireNonNull(eVar);
        str.getClass();
        eVar.bitField0_ |= 2;
        eVar.errorDetails_ = str;
    }

    public static e e() {
        return DEFAULT_INSTANCE;
    }

    public static b h() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001", new Object[]{"bitField0_", "statusCode_", c.a.a, "errorDetails_"});
            case 3:
                return new e();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<e> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (e.class) {
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

    public String f() {
        return this.errorDetails_;
    }

    public c g() {
        c a2 = c.a(this.statusCode_);
        return a2 == null ? c.UNKNOWN_FAILURE : a2;
    }
}
