package f.b.c.k.v;

import f.b.f.b1;
import f.b.f.p1;
import f.b.f.z;
import java.util.Objects;

public final class b extends z<b, C0118b> implements Object {
    private static final b DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile b1<b> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 2;
    private String name_ = "";
    private p1 readTime_;

    /* renamed from: f.b.c.k.v.b$b  reason: collision with other inner class name */
    public static final class C0118b extends z.a<b, C0118b> implements Object {
        public C0118b() {
            super(b.DEFAULT_INSTANCE);
        }

        public C0118b(a aVar) {
            super(b.DEFAULT_INSTANCE);
        }
    }

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        z.registerDefaultInstance(b.class, bVar);
    }

    public static void c(b bVar, String str) {
        Objects.requireNonNull(bVar);
        str.getClass();
        bVar.name_ = str;
    }

    public static void d(b bVar, p1 p1Var) {
        Objects.requireNonNull(bVar);
        p1Var.getClass();
        bVar.readTime_ = p1Var;
    }

    public static b e() {
        return DEFAULT_INSTANCE;
    }

    public static C0118b h() {
        return (C0118b) DEFAULT_INSTANCE.createBuilder();
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"name_", "readTime_"});
            case 3:
                return new b();
            case 4:
                return new C0118b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<b> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (b.class) {
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
        p1 p1Var = this.readTime_;
        return p1Var == null ? p1.e() : p1Var;
    }
}
