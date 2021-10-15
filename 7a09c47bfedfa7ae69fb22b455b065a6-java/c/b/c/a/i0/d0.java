package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class d0 extends y<d0, b> implements Object {
    public static final int AEAD_DEM_FIELD_NUMBER = 2;
    public static final d0 DEFAULT_INSTANCE;
    public static volatile y0<d0> PARSER;
    public x0 aeadDem_;

    public static final class b extends y.a<d0, b> implements Object {
        public b(a aVar) {
            super(d0.DEFAULT_INSTANCE);
        }
    }

    static {
        d0 d0Var = new d0();
        DEFAULT_INSTANCE = d0Var;
        y.defaultInstanceMap.put(d0.class, d0Var);
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"aeadDem_"});
            case 3:
                return new d0();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<d0> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (d0.class) {
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

    public x0 n() {
        x0 x0Var = this.aeadDem_;
        return x0Var == null ? x0.DEFAULT_INSTANCE : x0Var;
    }
}
