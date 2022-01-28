package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class o extends y<o, b> implements Object {
    public static final o DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    public static volatile y0<o> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public i keyValue_ = i.f3564c;
    public q params_;
    public int version_;

    static {
        o oVar = new o();
        DEFAULT_INSTANCE = oVar;
        y.defaultInstanceMap.put(o.class, oVar);
    }

    public static void n(o oVar, q qVar) {
        if (oVar != null) {
            qVar.getClass();
            oVar.params_ = qVar;
            return;
        }
        throw null;
    }

    public static void o(o oVar, i iVar) {
        if (oVar != null) {
            iVar.getClass();
            oVar.keyValue_ = iVar;
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
                return new o();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<o> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (o.class) {
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

    public q p() {
        q qVar = this.params_;
        return qVar == null ? q.DEFAULT_INSTANCE : qVar;
    }

    public static final class b extends y.a<o, b> implements Object {
        public b() {
            super(o.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(o.DEFAULT_INSTANCE);
        }
    }
}
