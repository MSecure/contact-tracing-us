package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class e extends y<e, b> implements Object {
    public static final int AES_CTR_KEY_FORMAT_FIELD_NUMBER = 1;
    public static final e DEFAULT_INSTANCE;
    public static final int HMAC_KEY_FORMAT_FIELD_NUMBER = 2;
    public static volatile y0<e> PARSER;
    public j aesCtrKeyFormat_;
    public t0 hmacKeyFormat_;

    public static final class b extends y.a<e, b> implements Object {
        public b(a aVar) {
            super(e.DEFAULT_INSTANCE);
        }
    }

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        y.defaultInstanceMap.put(e.class, eVar);
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"aesCtrKeyFormat_", "hmacKeyFormat_"});
            case 3:
                return new e();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<e> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (e.class) {
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

    public j n() {
        j jVar = this.aesCtrKeyFormat_;
        return jVar == null ? j.DEFAULT_INSTANCE : jVar;
    }

    public t0 o() {
        t0 t0Var = this.hmacKeyFormat_;
        return t0Var == null ? t0.DEFAULT_INSTANCE : t0Var;
    }
}
