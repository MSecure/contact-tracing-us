package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class z extends y<z, b> implements Object {
    public static final int CURVE_FIELD_NUMBER = 2;
    public static final z DEFAULT_INSTANCE;
    public static final int ENCODING_FIELD_NUMBER = 3;
    public static final int HASH_TYPE_FIELD_NUMBER = 1;
    public static volatile y0<z> PARSER;
    public int curve_;
    public int encoding_;
    public int hashType_;

    public static final class b extends y.a<z, b> implements Object {
        public b(a aVar) {
            super(z.DEFAULT_INSTANCE);
        }
    }

    static {
        z zVar = new z();
        DEFAULT_INSTANCE = zVar;
        y.defaultInstanceMap.put(z.class, zVar);
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"hashType_", "curve_", "encoding_"});
            case 3:
                return new z();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<z> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (z.class) {
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

    public m0 n() {
        m0 b2 = m0.b(this.curve_);
        return b2 == null ? m0.UNRECOGNIZED : b2;
    }

    public c0 o() {
        c0 b2 = c0.b(this.encoding_);
        return b2 == null ? c0.UNRECOGNIZED : b2;
    }

    public o0 p() {
        o0 b2 = o0.b(this.hashType_);
        return b2 == null ? o0.UNRECOGNIZED : b2;
    }
}
