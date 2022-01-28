package c.b.c.a.i0;

import c.b.c.a.j0.a.a0;
import c.b.c.a.j0.a.c1;
import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

@Deprecated
public final class g1 extends y<g1, b> implements Object {
    public static final int CONFIG_NAME_FIELD_NUMBER = 1;
    public static final g1 DEFAULT_INSTANCE;
    public static final int ENTRY_FIELD_NUMBER = 2;
    public static volatile y0<g1> PARSER;
    public String configName_ = "";
    public a0.c<y0> entry_ = c1.f4900e;

    static {
        g1 g1Var = new g1();
        DEFAULT_INSTANCE = g1Var;
        y.defaultInstanceMap.put(g1.class, g1Var);
    }

    public static void n(g1 g1Var, String str) {
        if (g1Var != null) {
            str.getClass();
            g1Var.configName_ = str;
            return;
        }
        throw null;
    }

    public static b o() {
        return (b) DEFAULT_INSTANCE.e();
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"configName_", "entry_", y0.class});
            case 3:
                return new g1();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<g1> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (g1.class) {
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

    public static final class b extends y.a<g1, b> implements Object {
        public b() {
            super(g1.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(g1.DEFAULT_INSTANCE);
        }
    }
}
