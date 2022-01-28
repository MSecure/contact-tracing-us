package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class l0 extends y<l0, b> implements Object {
    public static final l0 DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 2;
    public static volatile y0<l0> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public i keyValue_ = i.f4933c;
    public int version_;

    static {
        l0 l0Var = new l0();
        DEFAULT_INSTANCE = l0Var;
        y.defaultInstanceMap.put(l0.class, l0Var);
    }

    public static void n(l0 l0Var, i iVar) {
        if (l0Var != null) {
            iVar.getClass();
            l0Var.keyValue_ = iVar;
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
                return new d1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"version_", "keyValue_"});
            case 3:
                return new l0();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<l0> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (l0.class) {
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

    public static final class b extends y.a<l0, b> implements Object {
        public b() {
            super(l0.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(l0.DEFAULT_INSTANCE);
        }
    }
}
