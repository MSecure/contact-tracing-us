package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class n1 extends y<n1, b> implements Object {
    public static final int CRT_FIELD_NUMBER = 8;
    public static final n1 DEFAULT_INSTANCE;
    public static final int DP_FIELD_NUMBER = 6;
    public static final int DQ_FIELD_NUMBER = 7;
    public static final int D_FIELD_NUMBER = 3;
    public static volatile y0<n1> PARSER = null;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int P_FIELD_NUMBER = 4;
    public static final int Q_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 1;
    public i crt_;
    public i d_;
    public i dp_;
    public i dq_;
    public i p_;
    public o1 publicKey_;
    public i q_;
    public int version_;

    static {
        n1 n1Var = new n1();
        DEFAULT_INSTANCE = n1Var;
        y.defaultInstanceMap.put(n1.class, n1Var);
    }

    public n1() {
        i iVar = i.f3564c;
        this.d_ = iVar;
        this.p_ = iVar;
        this.q_ = iVar;
        this.dp_ = iVar;
        this.dq_ = iVar;
        this.crt_ = iVar;
    }

    public static void n(n1 n1Var, i iVar) {
        if (n1Var != null) {
            iVar.getClass();
            n1Var.q_ = iVar;
            return;
        }
        throw null;
    }

    public static void o(n1 n1Var, i iVar) {
        if (n1Var != null) {
            iVar.getClass();
            n1Var.dp_ = iVar;
            return;
        }
        throw null;
    }

    public static void p(n1 n1Var, i iVar) {
        if (n1Var != null) {
            iVar.getClass();
            n1Var.dq_ = iVar;
            return;
        }
        throw null;
    }

    public static void q(n1 n1Var, i iVar) {
        if (n1Var != null) {
            iVar.getClass();
            n1Var.crt_ = iVar;
            return;
        }
        throw null;
    }

    public static void r(n1 n1Var, o1 o1Var) {
        if (n1Var != null) {
            o1Var.getClass();
            n1Var.publicKey_ = o1Var;
            return;
        }
        throw null;
    }

    public static void s(n1 n1Var, i iVar) {
        if (n1Var != null) {
            iVar.getClass();
            n1Var.d_ = iVar;
            return;
        }
        throw null;
    }

    public static void t(n1 n1Var, i iVar) {
        if (n1Var != null) {
            iVar.getClass();
            n1Var.p_ = iVar;
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
                return new n1();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<n1> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (n1.class) {
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

    public o1 u() {
        o1 o1Var = this.publicKey_;
        return o1Var == null ? o1.DEFAULT_INSTANCE : o1Var;
    }

    public static final class b extends y.a<n1, b> implements Object {
        public b() {
            super(n1.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(n1.DEFAULT_INSTANCE);
        }
    }
}
