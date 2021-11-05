package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class f0 extends y<f0, b> implements Object {
    public static final f0 DEFAULT_INSTANCE;
    public static final int DEM_PARAMS_FIELD_NUMBER = 2;
    public static final int EC_POINT_FORMAT_FIELD_NUMBER = 3;
    public static final int KEM_PARAMS_FIELD_NUMBER = 1;
    public static volatile y0<f0> PARSER;
    public d0 demParams_;
    public int ecPointFormat_;
    public i0 kemParams_;

    public static final class b extends y.a<f0, b> implements Object {
        public b(a aVar) {
            super(f0.DEFAULT_INSTANCE);
        }
    }

    static {
        f0 f0Var = new f0();
        DEFAULT_INSTANCE = f0Var;
        y.defaultInstanceMap.put(f0.class, f0Var);
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"kemParams_", "demParams_", "ecPointFormat_"});
            case 3:
                return new f0();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<f0> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (f0.class) {
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

    public d0 n() {
        d0 d0Var = this.demParams_;
        return d0Var == null ? d0.DEFAULT_INSTANCE : d0Var;
    }

    public x o() {
        x b2 = x.b(this.ecPointFormat_);
        return b2 == null ? x.UNRECOGNIZED : b2;
    }

    public i0 p() {
        i0 i0Var = this.kemParams_;
        return i0Var == null ? i0.DEFAULT_INSTANCE : i0Var;
    }
}
