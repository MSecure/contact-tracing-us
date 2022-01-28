package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class q1 extends y<q1, b> implements Object {
    public static final q1 DEFAULT_INSTANCE;
    public static volatile y0<q1> PARSER;

    public static final class b extends y.a<q1, b> implements Object {
        public b(a aVar) {
            super(q1.DEFAULT_INSTANCE);
        }
    }

    static {
        q1 q1Var = new q1();
        DEFAULT_INSTANCE = q1Var;
        y.defaultInstanceMap.put(q1.class, q1Var);
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0000", null);
            case 3:
                return new q1();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<q1> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (q1.class) {
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
}
