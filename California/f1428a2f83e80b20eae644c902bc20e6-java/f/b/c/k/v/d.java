package f.b.c.k.v;

import f.b.f.b1;
import f.b.f.p1;
import f.b.f.z;
import java.util.Objects;

public final class d extends z<d, b> implements Object {
    private static final d DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile b1<d> PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private String name_ = "";
    private p1 version_;

    public static final class b extends z.a<d, b> implements Object {
        public b() {
            super(d.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(d.DEFAULT_INSTANCE);
        }
    }

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        z.registerDefaultInstance(d.class, dVar);
    }

    public static void c(d dVar, String str) {
        Objects.requireNonNull(dVar);
        str.getClass();
        dVar.name_ = str;
    }

    public static void d(d dVar, p1 p1Var) {
        Objects.requireNonNull(dVar);
        p1Var.getClass();
        dVar.version_ = p1Var;
    }

    public static d e() {
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"name_", "version_"});
            case 3:
                return new d();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<d> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (d.class) {
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

    public String f() {
        return this.name_;
    }

    public p1 g() {
        p1 p1Var = this.version_;
        return p1Var == null ? p1.e() : p1Var;
    }
}
