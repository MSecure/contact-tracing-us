package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class b0 extends y<b0, b> implements Object {
    public static final b0 DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;
    public static volatile y0<b0> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public static final int X_FIELD_NUMBER = 3;
    public static final int Y_FIELD_NUMBER = 4;
    public z params_;
    public int version_;
    public i x_;
    public i y_;

    static {
        b0 b0Var = new b0();
        DEFAULT_INSTANCE = b0Var;
        y.defaultInstanceMap.put(b0.class, b0Var);
    }

    public b0() {
        i iVar = i.f4933c;
        this.x_ = iVar;
        this.y_ = iVar;
    }

    public static void n(b0 b0Var, z zVar) {
        if (b0Var != null) {
            zVar.getClass();
            b0Var.params_ = zVar;
            return;
        }
        throw null;
    }

    public static void o(b0 b0Var, i iVar) {
        if (b0Var != null) {
            iVar.getClass();
            b0Var.x_ = iVar;
            return;
        }
        throw null;
    }

    public static void p(b0 b0Var, i iVar) {
        if (b0Var != null) {
            iVar.getClass();
            b0Var.y_ = iVar;
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
                return new b0();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<b0> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (b0.class) {
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

    public z q() {
        z zVar = this.params_;
        return zVar == null ? z.DEFAULT_INSTANCE : zVar;
    }

    public static final class b extends y.a<b0, b> implements Object {
        public b() {
            super(b0.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(b0.DEFAULT_INSTANCE);
        }
    }
}
