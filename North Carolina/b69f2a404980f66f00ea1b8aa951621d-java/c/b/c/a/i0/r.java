package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class r extends y<r, b> implements Object {
    public static final r DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static volatile y0<r> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public i keyValue_ = i.f3564c;
    public int version_;

    static {
        r rVar = new r();
        DEFAULT_INSTANCE = rVar;
        y.defaultInstanceMap.put(r.class, rVar);
    }

    public static void n(r rVar, i iVar) {
        if (rVar != null) {
            iVar.getClass();
            rVar.keyValue_ = iVar;
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
                return new d1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"version_", "keyValue_"});
            case 3:
                return new r();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<r> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (r.class) {
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

    public static final class b extends y.a<r, b> implements Object {
        public b() {
            super(r.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(r.DEFAULT_INSTANCE);
        }
    }
}
