package f.b.d.a;

import f.b.f.b1;
import f.b.f.m0;
import f.b.f.n0;
import f.b.f.y1;
import f.b.f.z;
import java.util.Map;
import java.util.Objects;

public final class l extends z<l, b> implements Object {
    public static final int ADD_TARGET_FIELD_NUMBER = 2;
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final l DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER = 4;
    private static volatile b1<l> PARSER = null;
    public static final int REMOVE_TARGET_FIELD_NUMBER = 3;
    private String database_ = "";
    private n0<String, String> labels_ = n0.c;
    private int targetChangeCase_ = 0;
    private Object targetChange_;

    public static final class b extends z.a<l, b> implements Object {
        public b() {
            super(l.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(l.DEFAULT_INSTANCE);
        }
    }

    public static final class c {
        public static final m0<String, String> a;

        static {
            y1 y1Var = y1.STRING;
            a = new m0<>(y1Var, "", y1Var, "");
        }
    }

    static {
        l lVar = new l();
        DEFAULT_INSTANCE = lVar;
        z.registerDefaultInstance(l.class, lVar);
    }

    public static Map c(l lVar) {
        n0<String, String> n0Var = lVar.labels_;
        if (!n0Var.b) {
            lVar.labels_ = n0Var.c();
        }
        return lVar.labels_;
    }

    public static void d(l lVar, String str) {
        Objects.requireNonNull(lVar);
        str.getClass();
        lVar.database_ = str;
    }

    public static void e(l lVar, q qVar) {
        Objects.requireNonNull(lVar);
        qVar.getClass();
        lVar.targetChange_ = qVar;
        lVar.targetChangeCase_ = 2;
    }

    public static void f(l lVar, int i2) {
        lVar.targetChangeCase_ = 3;
        lVar.targetChange_ = Integer.valueOf(i2);
    }

    public static l g() {
        return DEFAULT_INSTANCE;
    }

    public static b h() {
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u0002<\u0000\u00037\u0000\u00042", new Object[]{"targetChange_", "targetChangeCase_", "database_", q.class, "labels_", c.a});
            case 3:
                return new l();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<l> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (l.class) {
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
}
