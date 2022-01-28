package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class a extends y<a, b> implements Object {
    public static final a DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 3;
    public static volatile y0<a> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public i keyValue_ = i.f3564c;
    public c params_;
    public int version_;

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        y.defaultInstanceMap.put(a.class, aVar);
    }

    public static void n(a aVar, i iVar) {
        if (aVar != null) {
            iVar.getClass();
            aVar.keyValue_ = iVar;
            return;
        }
        throw null;
    }

    public static void o(a aVar, c cVar) {
        if (aVar != null) {
            cVar.getClass();
            aVar.params_ = cVar;
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
                return new d1(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"version_", "keyValue_", "params_"});
            case 3:
                return new a();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<a> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (a.class) {
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

    public static final class b extends y.a<a, b> implements Object {
        public b() {
            super(a.DEFAULT_INSTANCE);
        }

        public b(C0089a aVar) {
            super(a.DEFAULT_INSTANCE);
        }
    }
}
