package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class m1 extends y<m1, b> implements Object {
    public static final m1 DEFAULT_INSTANCE;
    public static final int MGF1_HASH_FIELD_NUMBER = 2;
    public static volatile y0<m1> PARSER = null;
    public static final int SALT_LENGTH_FIELD_NUMBER = 3;
    public static final int SIG_HASH_FIELD_NUMBER = 1;
    public int mgf1Hash_;
    public int saltLength_;
    public int sigHash_;

    public static final class b extends y.a<m1, b> implements Object {
        public b(a aVar) {
            super(m1.DEFAULT_INSTANCE);
        }
    }

    static {
        m1 m1Var = new m1();
        DEFAULT_INSTANCE = m1Var;
        y.defaultInstanceMap.put(m1.class, m1Var);
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\u0004", new Object[]{"sigHash_", "mgf1Hash_", "saltLength_"});
            case 3:
                return new m1();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<m1> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (m1.class) {
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
        o0 b2 = o0.b(this.mgf1Hash_);
        return b2 == null ? o0.UNRECOGNIZED : b2;
    }

    public o0 o() {
        o0 b2 = o0.b(this.sigHash_);
        return b2 == null ? o0.UNRECOGNIZED : b2;
    }
}
