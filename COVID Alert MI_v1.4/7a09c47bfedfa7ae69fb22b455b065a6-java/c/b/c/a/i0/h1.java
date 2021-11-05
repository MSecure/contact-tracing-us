package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class h1 extends y<h1, b> implements Object {
    public static final h1 DEFAULT_INSTANCE;
    public static final int MODULUS_SIZE_IN_BITS_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    public static volatile y0<h1> PARSER = null;
    public static final int PUBLIC_EXPONENT_FIELD_NUMBER = 3;
    public int modulusSizeInBits_;
    public i1 params_;
    public i publicExponent_ = i.f4933c;

    public static final class b extends y.a<h1, b> implements Object {
        public b(a aVar) {
            super(h1.DEFAULT_INSTANCE);
        }
    }

    static {
        h1 h1Var = new h1();
        DEFAULT_INSTANCE = h1Var;
        y.defaultInstanceMap.put(h1.class, h1Var);
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\n", new Object[]{"params_", "modulusSizeInBits_", "publicExponent_"});
            case 3:
                return new h1();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<h1> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (h1.class) {
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
