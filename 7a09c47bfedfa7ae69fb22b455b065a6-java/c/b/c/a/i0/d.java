package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class d extends y<d, b> implements Object {
    public static final int AES_CTR_KEY_FIELD_NUMBER = 2;
    public static final d DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FIELD_NUMBER = 3;
    public static volatile y0<d> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public i aesCtrKey_;
    public s0 hmacKey_;
    public int version_;

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        y.defaultInstanceMap.put(d.class, dVar);
    }

    public static void n(d dVar, i iVar) {
        if (dVar != null) {
            iVar.getClass();
            dVar.aesCtrKey_ = iVar;
            return;
        }
        throw null;
    }

    public static void o(d dVar, s0 s0Var) {
        if (dVar != null) {
            s0Var.getClass();
            dVar.hmacKey_ = s0Var;
            return;
        }
        throw null;
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"version_", "aesCtrKey_", "hmacKey_"});
            case 3:
                return new d();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<d> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (d.class) {
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

    public s0 p() {
        s0 s0Var = this.hmacKey_;
        return s0Var == null ? s0.DEFAULT_INSTANCE : s0Var;
    }

    public static final class b extends y.a<d, b> implements Object {
        public b() {
            super(d.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(d.DEFAULT_INSTANCE);
        }
    }
}
