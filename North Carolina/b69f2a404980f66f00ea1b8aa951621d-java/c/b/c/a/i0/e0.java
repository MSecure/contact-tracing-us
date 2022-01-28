package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class e0 extends y<e0, b> implements Object {
    public static final e0 DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 1;
    public static volatile y0<e0> PARSER;
    public f0 params_;

    public static final class b extends y.a<e0, b> implements Object {
        public b(a aVar) {
            super(e0.DEFAULT_INSTANCE);
        }
    }

    static {
        e0 e0Var = new e0();
        DEFAULT_INSTANCE = e0Var;
        y.defaultInstanceMap.put(e0.class, e0Var);
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"params_"});
            case 3:
                return new e0();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<e0> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (e0.class) {
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

    public f0 n() {
        f0 f0Var = this.params_;
        return f0Var == null ? f0.DEFAULT_INSTANCE : f0Var;
    }
}
