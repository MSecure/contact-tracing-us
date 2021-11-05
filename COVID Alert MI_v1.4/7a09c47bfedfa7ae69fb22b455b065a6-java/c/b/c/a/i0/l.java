package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class l extends y<l, b> implements Object {
    public static final l DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    public static volatile y0<l> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public i keyValue_ = i.f4933c;
    public n params_;
    public int version_;

    static {
        l lVar = new l();
        DEFAULT_INSTANCE = lVar;
        y.defaultInstanceMap.put(l.class, lVar);
    }

    public static void n(l lVar, n nVar) {
        if (lVar != null) {
            nVar.getClass();
            lVar.params_ = nVar;
            return;
        }
        throw null;
    }

    public static void o(l lVar, i iVar) {
        if (lVar != null) {
            iVar.getClass();
            lVar.keyValue_ = iVar;
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
                return new l();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<l> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (l.class) {
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

    public n p() {
        n nVar = this.params_;
        return nVar == null ? n.DEFAULT_INSTANCE : nVar;
    }

    public static final class b extends y.a<l, b> implements Object {
        public b() {
            super(l.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(l.DEFAULT_INSTANCE);
        }
    }
}
