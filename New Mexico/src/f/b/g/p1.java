package f.b.g;

import f.b.g.z;
/* loaded from: classes.dex */
public final class p1 extends z<p1, b> implements Object {
    private static final p1 DEFAULT_INSTANCE;
    public static final int NANOS_FIELD_NUMBER = 2;
    private static volatile b1<p1> PARSER = null;
    public static final int SECONDS_FIELD_NUMBER = 1;
    private int nanos_;
    private long seconds_;

    /* loaded from: classes.dex */
    public static final class b extends z.a<p1, b> implements Object {
        public b() {
            super(p1.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(p1.DEFAULT_INSTANCE);
        }

        public b b(int i2) {
            copyOnWrite();
            p1.d((p1) this.instance, i2);
            return this;
        }

        public b c(long j2) {
            copyOnWrite();
            p1.c((p1) this.instance, j2);
            return this;
        }
    }

    static {
        p1 p1Var = new p1();
        DEFAULT_INSTANCE = p1Var;
        z.registerDefaultInstance(p1.class, p1Var);
    }

    public static void c(p1 p1Var, long j2) {
        p1Var.seconds_ = j2;
    }

    public static void d(p1 p1Var, int i2) {
        p1Var.nanos_ = i2;
    }

    public static p1 e() {
        return DEFAULT_INSTANCE;
    }

    public static b h() {
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"seconds_", "nanos_"});
            case 3:
                return new p1();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<p1> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (p1.class) {
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

    public int f() {
        return this.nanos_;
    }

    public long g() {
        return this.seconds_;
    }
}
