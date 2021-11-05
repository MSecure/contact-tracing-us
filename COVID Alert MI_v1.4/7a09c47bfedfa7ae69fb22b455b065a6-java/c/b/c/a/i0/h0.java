package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class h0 extends y<h0, b> implements Object {
    public static final h0 DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    public static volatile y0<h0> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public static final int X_FIELD_NUMBER = 3;
    public static final int Y_FIELD_NUMBER = 4;
    public f0 params_;
    public int version_;
    public i x_;
    public i y_;

    static {
        h0 h0Var = new h0();
        DEFAULT_INSTANCE = h0Var;
        y.defaultInstanceMap.put(h0.class, h0Var);
    }

    public h0() {
        i iVar = i.f4933c;
        this.x_ = iVar;
        this.y_ = iVar;
    }

    public static void n(h0 h0Var, f0 f0Var) {
        if (h0Var != null) {
            f0Var.getClass();
            h0Var.params_ = f0Var;
            return;
        }
        throw null;
    }

    public static void o(h0 h0Var, i iVar) {
        if (h0Var != null) {
            iVar.getClass();
            h0Var.x_ = iVar;
            return;
        }
        throw null;
    }

    public static void p(h0 h0Var, i iVar) {
        if (h0Var != null) {
            iVar.getClass();
            h0Var.y_ = iVar;
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
                return new d1(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"version_", "params_", "x_", "y_"});
            case 3:
                return new h0();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<h0> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (h0.class) {
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

    public f0 q() {
        f0 f0Var = this.params_;
        return f0Var == null ? f0.DEFAULT_INSTANCE : f0Var;
    }

    public static final class b extends y.a<h0, b> implements Object {
        public b() {
            super(h0.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(h0.DEFAULT_INSTANCE);
        }
    }
}
