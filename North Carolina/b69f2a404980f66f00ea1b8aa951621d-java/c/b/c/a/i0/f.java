package c.b.c.a.i0;

import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.i;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class f extends y<f, b> implements Object {
    public static final f DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;
    public static volatile y0<f> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public i keyValue_ = i.f3564c;
    public h params_;
    public int version_;

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        y.defaultInstanceMap.put(f.class, fVar);
    }

    public static void n(f fVar, h hVar) {
        if (fVar != null) {
            hVar.getClass();
            fVar.params_ = hVar;
            return;
        }
        throw null;
    }

    public static void o(f fVar, i iVar) {
        if (fVar != null) {
            iVar.getClass();
            fVar.keyValue_ = iVar;
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
                return new f();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<f> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (f.class) {
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

    public h p() {
        h hVar = this.params_;
        return hVar == null ? h.DEFAULT_INSTANCE : hVar;
    }

    public static final class b extends y.a<f, b> implements Object {
        public b() {
            super(f.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(f.DEFAULT_INSTANCE);
        }
    }
}
