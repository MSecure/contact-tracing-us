package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class s0 extends y<s0, b> implements Object {
    public static final s0 DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    public static volatile y0<s0> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public i keyValue_ = i.f4933c;
    public u0 params_;
    public int version_;

    static {
        s0 s0Var = new s0();
        DEFAULT_INSTANCE = s0Var;
        y.defaultInstanceMap.put(s0.class, s0Var);
    }

    public static void n(s0 s0Var, u0 u0Var) {
        if (s0Var != null) {
            u0Var.getClass();
            s0Var.params_ = u0Var;
            return;
        }
        throw null;
    }

    public static void o(s0 s0Var, i iVar) {
        if (s0Var != null) {
            iVar.getClass();
            s0Var.keyValue_ = iVar;
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
                return new d1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 3:
                return new s0();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<s0> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (s0.class) {
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

    public u0 p() {
        u0 u0Var = this.params_;
        return u0Var == null ? u0.DEFAULT_INSTANCE : u0Var;
    }

    public static final class b extends y.a<s0, b> implements Object {
        public b() {
            super(s0.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(s0.DEFAULT_INSTANCE);
        }
    }
}
