package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class i0 extends y<i0, b> implements Object {
    public static final int CURVE_TYPE_FIELD_NUMBER = 1;
    public static final i0 DEFAULT_INSTANCE;
    public static final int HKDF_HASH_TYPE_FIELD_NUMBER = 2;
    public static final int HKDF_SALT_FIELD_NUMBER = 11;
    public static volatile y0<i0> PARSER;
    public int curveType_;
    public int hkdfHashType_;
    public i hkdfSalt_ = i.f3564c;

    public static final class b extends y.a<i0, b> implements Object {
        public b(a aVar) {
            super(i0.DEFAULT_INSTANCE);
        }
    }

    static {
        i0 i0Var = new i0();
        DEFAULT_INSTANCE = i0Var;
        y.defaultInstanceMap.put(i0.class, i0Var);
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"curveType_", "hkdfHashType_", "hkdfSalt_"});
            case 3:
                return new i0();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<i0> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (i0.class) {
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
        m0 b2 = m0.b(this.curveType_);
        return b2 == null ? m0.UNRECOGNIZED : b2;
    }

    public o0 o() {
        o0 b2 = o0.b(this.hkdfHashType_);
        return b2 == null ? o0.UNRECOGNIZED : b2;
    }
}
