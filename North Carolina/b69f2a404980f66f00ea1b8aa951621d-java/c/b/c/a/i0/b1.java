package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class b1 extends y<b1, b> implements Object {
    public static final b1 DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    public static volatile y0<b1> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public c1 params_;
    public int version_;

    static {
        b1 b1Var = new b1();
        DEFAULT_INSTANCE = b1Var;
        y.defaultInstanceMap.put(b1.class, b1Var);
    }

    public static void n(b1 b1Var, c1 c1Var) {
        if (b1Var != null) {
            c1Var.getClass();
            b1Var.params_ = c1Var;
            return;
        }
        throw null;
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"version_", "params_"});
            case 3:
                return new b1();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<b1> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (b1.class) {
                        y0Var = PARSER;
                        if (y0Var == null) {
                            y0Var = new y.b<>(DEFAULT_INSTANCE);
                            PARSER = y0Var;
                        }
                    }
                }
                return y0Var;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static final class b extends y.a<b1, b> implements Object {
        public b() {
            super(b1.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(b1.DEFAULT_INSTANCE);
        }
    }
}
