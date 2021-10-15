package c.b.c.a.i0;

import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class d1 extends y<d1, b> implements Object {
    public static final d1 DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    public static volatile y0<d1> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public e1 params_;
    public int version_;

    static {
        d1 d1Var = new d1();
        DEFAULT_INSTANCE = d1Var;
        y.defaultInstanceMap.put(d1.class, d1Var);
    }

    public static void n(d1 d1Var, e1 e1Var) {
        if (d1Var != null) {
            e1Var.getClass();
            d1Var.params_ = e1Var;
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
                return new c.b.c.a.j0.a.d1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"version_", "params_"});
            case 3:
                return new d1();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<d1> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (d1.class) {
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

    public static final class b extends y.a<d1, b> implements Object {
        public b() {
            super(d1.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(d1.DEFAULT_INSTANCE);
        }
    }
}
