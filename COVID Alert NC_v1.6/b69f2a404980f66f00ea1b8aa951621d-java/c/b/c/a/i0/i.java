package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class i extends y<i, b> implements Object {
    public static final i DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    public static volatile y0<i> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public c.b.c.a.j0.a.i keyValue_ = c.b.c.a.j0.a.i.f3564c;
    public k params_;
    public int version_;

    static {
        i iVar = new i();
        DEFAULT_INSTANCE = iVar;
        y.defaultInstanceMap.put(i.class, iVar);
    }

    public static void n(i iVar, k kVar) {
        if (iVar != null) {
            kVar.getClass();
            iVar.params_ = kVar;
            return;
        }
        throw null;
    }

    public static void o(i iVar, c.b.c.a.j0.a.i iVar2) {
        if (iVar != null) {
            iVar2.getClass();
            iVar.keyValue_ = iVar2;
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
                return new i();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<i> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (i.class) {
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

    public static final class b extends y.a<i, b> implements Object {
        public b() {
            super(i.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(i.DEFAULT_INSTANCE);
        }
    }
}
