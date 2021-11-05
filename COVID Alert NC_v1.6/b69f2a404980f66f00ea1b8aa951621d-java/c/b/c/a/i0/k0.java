package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class k0 extends y<k0, b> implements Object {
    public static final k0 DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    public static volatile y0<k0> PARSER = null;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 3;
    public static final int VERSION_FIELD_NUMBER = 1;
    public i keyValue_ = i.f3564c;
    public l0 publicKey_;
    public int version_;

    static {
        k0 k0Var = new k0();
        DEFAULT_INSTANCE = k0Var;
        y.defaultInstanceMap.put(k0.class, k0Var);
    }

    public static void n(k0 k0Var, i iVar) {
        if (k0Var != null) {
            iVar.getClass();
            k0Var.keyValue_ = iVar;
            return;
        }
        throw null;
    }

    public static void o(k0 k0Var, l0 l0Var) {
        if (k0Var != null) {
            l0Var.getClass();
            k0Var.publicKey_ = l0Var;
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
                return new d1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"version_", "keyValue_", "publicKey_"});
            case 3:
                return new k0();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<k0> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (k0.class) {
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

    public static final class b extends y.a<k0, b> implements Object {
        public b() {
            super(k0.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(k0.DEFAULT_INSTANCE);
        }
    }
}
