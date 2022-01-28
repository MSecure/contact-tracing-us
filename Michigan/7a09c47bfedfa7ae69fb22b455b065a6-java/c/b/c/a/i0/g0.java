package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class g0 extends y<g0, b> implements Object {
    public static final g0 DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static volatile y0<g0> PARSER = null;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int VERSION_FIELD_NUMBER = 1;
    public i keyValue_ = i.f4933c;
    public h0 publicKey_;
    public int version_;

    static {
        g0 g0Var = new g0();
        DEFAULT_INSTANCE = g0Var;
        y.defaultInstanceMap.put(g0.class, g0Var);
    }

    public static void n(g0 g0Var, h0 h0Var) {
        if (g0Var != null) {
            h0Var.getClass();
            g0Var.publicKey_ = h0Var;
            return;
        }
        throw null;
    }

    public static void o(g0 g0Var, i iVar) {
        if (g0Var != null) {
            iVar.getClass();
            g0Var.keyValue_ = iVar;
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
                return new d1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "publicKey_", "keyValue_"});
            case 3:
                return new g0();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<g0> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (g0.class) {
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

    public static final class b extends y.a<g0, b> implements Object {
        public b() {
            super(g0.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(g0.DEFAULT_INSTANCE);
        }
    }
}
