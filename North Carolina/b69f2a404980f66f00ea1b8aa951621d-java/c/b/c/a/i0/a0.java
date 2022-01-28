package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class a0 extends y<a0, b> implements Object {
    public static final a0 DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static volatile y0<a0> PARSER = null;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int VERSION_FIELD_NUMBER = 1;
    public i keyValue_ = i.f3564c;
    public b0 publicKey_;
    public int version_;

    static {
        a0 a0Var = new a0();
        DEFAULT_INSTANCE = a0Var;
        y.defaultInstanceMap.put(a0.class, a0Var);
    }

    public static void n(a0 a0Var, b0 b0Var) {
        if (a0Var != null) {
            b0Var.getClass();
            a0Var.publicKey_ = b0Var;
            return;
        }
        throw null;
    }

    public static void o(a0 a0Var, i iVar) {
        if (a0Var != null) {
            iVar.getClass();
            a0Var.keyValue_ = iVar;
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
                return new a0();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<a0> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (a0.class) {
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

    public b0 p() {
        b0 b0Var = this.publicKey_;
        return b0Var == null ? b0.DEFAULT_INSTANCE : b0Var;
    }

    public static final class b extends y.a<a0, b> implements Object {
        public b() {
            super(a0.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(a0.DEFAULT_INSTANCE);
        }
    }
}
