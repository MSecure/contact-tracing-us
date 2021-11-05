package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class j1 extends y<j1, b> implements Object {
    public static final int CRT_FIELD_NUMBER = 8;
    public static final j1 DEFAULT_INSTANCE;
    public static final int DP_FIELD_NUMBER = 6;
    public static final int DQ_FIELD_NUMBER = 7;
    public static final int D_FIELD_NUMBER = 3;
    public static volatile y0<j1> PARSER = null;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int P_FIELD_NUMBER = 4;
    public static final int Q_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 1;
    public i crt_;
    public i d_;
    public i dp_;
    public i dq_;
    public i p_;
    public k1 publicKey_;
    public i q_;
    public int version_;

    static {
        j1 j1Var = new j1();
        DEFAULT_INSTANCE = j1Var;
        y.defaultInstanceMap.put(j1.class, j1Var);
    }

    public j1() {
        i iVar = i.f4933c;
        this.d_ = iVar;
        this.p_ = iVar;
        this.q_ = iVar;
        this.dp_ = iVar;
        this.dq_ = iVar;
        this.crt_ = iVar;
    }

    public static void n(j1 j1Var, i iVar) {
        if (j1Var != null) {
            iVar.getClass();
            j1Var.q_ = iVar;
            return;
        }
        throw null;
    }

    public static void o(j1 j1Var, i iVar) {
        if (j1Var != null) {
            iVar.getClass();
            j1Var.dp_ = iVar;
            return;
        }
        throw null;
    }

    public static void p(j1 j1Var, i iVar) {
        if (j1Var != null) {
            iVar.getClass();
            j1Var.dq_ = iVar;
            return;
        }
        throw null;
    }

    public static void q(j1 j1Var, i iVar) {
        if (j1Var != null) {
            iVar.getClass();
            j1Var.crt_ = iVar;
            return;
        }
        throw null;
    }

    public static void r(j1 j1Var, k1 k1Var) {
        if (j1Var != null) {
            k1Var.getClass();
            j1Var.publicKey_ = k1Var;
            return;
        }
        throw null;
    }

    public static void s(j1 j1Var, i iVar) {
        if (j1Var != null) {
            iVar.getClass();
            j1Var.d_ = iVar;
            return;
        }
        throw null;
    }

    public static void t(j1 j1Var, i iVar) {
        if (j1Var != null) {
            iVar.getClass();
            j1Var.p_ = iVar;
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
                return new d1(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n\u0005\n\u0006\n\u0007\n\b\n", new Object[]{"version_", "publicKey_", "d_", "p_", "q_", "dp_", "dq_", "crt_"});
            case 3:
                return new j1();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<j1> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (j1.class) {
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

    public k1 u() {
        k1 k1Var = this.publicKey_;
        return k1Var == null ? k1.DEFAULT_INSTANCE : k1Var;
    }

    public static final class b extends y.a<j1, b> implements Object {
        public b() {
            super(j1.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(j1.DEFAULT_INSTANCE);
        }
    }
}
