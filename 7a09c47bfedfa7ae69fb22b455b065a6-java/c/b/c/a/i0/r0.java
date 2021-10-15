package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class r0 extends y<r0, b> implements Object {
    public static final r0 DEFAULT_INSTANCE;
    public static final int HASH_FIELD_NUMBER = 1;
    public static volatile y0<r0> PARSER = null;
    public static final int SALT_FIELD_NUMBER = 2;
    public int hash_;
    public i salt_ = i.f4933c;

    public static final class b extends y.a<r0, b> implements Object {
        public b(a aVar) {
            super(r0.DEFAULT_INSTANCE);
        }
    }

    static {
        r0 r0Var = new r0();
        DEFAULT_INSTANCE = r0Var;
        y.defaultInstanceMap.put(r0.class, r0Var);
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\n", new Object[]{"hash_", "salt_"});
            case 3:
                return new r0();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<r0> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (r0.class) {
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
        o0 b2 = o0.b(this.hash_);
        return b2 == null ? o0.UNRECOGNIZED : b2;
    }
}
