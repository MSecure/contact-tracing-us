package f.b.g;

import f.b.g.z;
/* loaded from: classes.dex */
public final class a0 extends z<a0, b> implements Object {
    private static final a0 DEFAULT_INSTANCE;
    private static volatile b1<a0> PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 1;
    private int value_;

    /* loaded from: classes.dex */
    public static final class b extends z.a<a0, b> implements Object {
        public b() {
            super(a0.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(a0.DEFAULT_INSTANCE);
        }
    }

    static {
        a0 a0Var = new a0();
        DEFAULT_INSTANCE = a0Var;
        z.registerDefaultInstance(a0.class, a0Var);
    }

    public static void c(a0 a0Var, int i2) {
        a0Var.value_ = i2;
    }

    public static a0 d() {
        return DEFAULT_INSTANCE;
    }

    public static b f() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0004", new Object[]{"value_"});
            case 3:
                return new a0();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<a0> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (a0.class) {
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

    public int e() {
        return this.value_;
    }
}
