package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class i1 extends y<i1, b> implements Object {
    public static final i1 DEFAULT_INSTANCE;
    public static final int HASH_TYPE_FIELD_NUMBER = 1;
    public static volatile y0<i1> PARSER;
    public int hashType_;

    public static final class b extends y.a<i1, b> implements Object {
        public b(a aVar) {
            super(i1.DEFAULT_INSTANCE);
        }
    }

    static {
        i1 i1Var = new i1();
        DEFAULT_INSTANCE = i1Var;
        y.defaultInstanceMap.put(i1.class, i1Var);
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"hashType_"});
            case 3:
                return new i1();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<i1> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (i1.class) {
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

    public o0 n() {
        o0 b2 = o0.b(this.hashType_);
        return b2 == null ? o0.UNRECOGNIZED : b2;
    }
}
