package f.b.d.a;

import f.b.f.b1;
import f.b.f.c0;
import f.b.f.z;
import java.util.Objects;

public final class g extends z<g, b> implements Object {
    private static final g DEFAULT_INSTANCE;
    public static final int FIELD_PATHS_FIELD_NUMBER = 1;
    private static volatile b1<g> PARSER;
    private c0.i<String> fieldPaths_ = z.emptyProtobufList();

    public static final class b extends z.a<g, b> implements Object {
        public b() {
            super(g.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(g.DEFAULT_INSTANCE);
        }
    }

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        z.registerDefaultInstance(g.class, gVar);
    }

    public static void c(g gVar, String str) {
        Objects.requireNonNull(gVar);
        str.getClass();
        if (!gVar.fieldPaths_.g()) {
            gVar.fieldPaths_ = z.mutableCopy(gVar.fieldPaths_);
        }
        gVar.fieldPaths_.add(str);
    }

    public static g d() {
        return DEFAULT_INSTANCE;
    }

    public static b g() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"fieldPaths_"});
            case 3:
                return new g();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<g> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (g.class) {
                        b1Var = PARSER;
                        if (b1Var == null) {
                            b1Var = new z.b<>(DEFAULT_INSTANCE);
                            PARSER = b1Var;
                        }
                    }
                }
                return b1Var;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public String e(int i2) {
        return this.fieldPaths_.get(i2);
    }

    public int f() {
        return this.fieldPaths_.size();
    }
}
