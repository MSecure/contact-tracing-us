package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class k1 extends y<k1, b> implements Object {
    public static final k1 DEFAULT_INSTANCE;
    public static final int E_FIELD_NUMBER = 4;
    public static final int N_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    public static volatile y0<k1> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public i e_;
    public i n_;
    public i1 params_;
    public int version_;

    static {
        k1 k1Var = new k1();
        DEFAULT_INSTANCE = k1Var;
        y.defaultInstanceMap.put(k1.class, k1Var);
    }

    public k1() {
        i iVar = i.f4933c;
        this.n_ = iVar;
        this.e_ = iVar;
    }

    public static void n(k1 k1Var, i1 i1Var) {
        if (k1Var != null) {
            i1Var.getClass();
            k1Var.params_ = i1Var;
            return;
        }
        throw null;
    }

    public static void o(k1 k1Var, i iVar) {
        if (k1Var != null) {
            iVar.getClass();
            k1Var.n_ = iVar;
            return;
        }
        throw null;
    }

    public static void p(k1 k1Var, i iVar) {
        if (k1Var != null) {
            iVar.getClass();
            k1Var.e_ = iVar;
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
                return new d1(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"version_", "params_", "n_", "e_"});
            case 3:
                return new k1();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<k1> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (k1.class) {
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

    public i1 q() {
        i1 i1Var = this.params_;
        return i1Var == null ? i1.DEFAULT_INSTANCE : i1Var;
    }

    public static final class b extends y.a<k1, b> implements Object {
        public b() {
            super(k1.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(k1.DEFAULT_INSTANCE);
        }
    }
}
