package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class o1 extends y<o1, b> implements Object {
    public static final o1 DEFAULT_INSTANCE;
    public static final int E_FIELD_NUMBER = 4;
    public static final int N_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    public static volatile y0<o1> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public i e_;
    public i n_;
    public m1 params_;
    public int version_;

    static {
        o1 o1Var = new o1();
        DEFAULT_INSTANCE = o1Var;
        y.defaultInstanceMap.put(o1.class, o1Var);
    }

    public o1() {
        i iVar = i.f4933c;
        this.n_ = iVar;
        this.e_ = iVar;
    }

    public static void n(o1 o1Var, m1 m1Var) {
        if (o1Var != null) {
            m1Var.getClass();
            o1Var.params_ = m1Var;
            return;
        }
        throw null;
    }

    public static void o(o1 o1Var, i iVar) {
        if (o1Var != null) {
            iVar.getClass();
            o1Var.n_ = iVar;
            return;
        }
        throw null;
    }

    public static void p(o1 o1Var, i iVar) {
        if (o1Var != null) {
            iVar.getClass();
            o1Var.e_ = iVar;
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
                return new o1();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<o1> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (o1.class) {
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

    public m1 q() {
        m1 m1Var = this.params_;
        return m1Var == null ? m1.DEFAULT_INSTANCE : m1Var;
    }

    public static final class b extends y.a<o1, b> implements Object {
        public b() {
            super(o1.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(o1.DEFAULT_INSTANCE);
        }
    }
}
