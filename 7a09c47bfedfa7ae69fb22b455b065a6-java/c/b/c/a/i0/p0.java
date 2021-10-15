package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class p0 extends y<p0, b> implements Object {
    public static final p0 DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    public static volatile y0<p0> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public i keyValue_ = i.f4933c;
    public r0 params_;
    public int version_;

    static {
        p0 p0Var = new p0();
        DEFAULT_INSTANCE = p0Var;
        y.defaultInstanceMap.put(p0.class, p0Var);
    }

    public static void n(p0 p0Var, r0 r0Var) {
        if (p0Var != null) {
            r0Var.getClass();
            p0Var.params_ = r0Var;
            return;
        }
        throw null;
    }

    public static void o(p0 p0Var, i iVar) {
        if (p0Var != null) {
            iVar.getClass();
            p0Var.keyValue_ = iVar;
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
                return new p0();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<p0> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (p0.class) {
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

    public r0 p() {
        r0 r0Var = this.params_;
        return r0Var == null ? r0.DEFAULT_INSTANCE : r0Var;
    }

    public static final class b extends y.a<p0, b> implements Object {
        public b() {
            super(p0.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(p0.DEFAULT_INSTANCE);
        }
    }
}
