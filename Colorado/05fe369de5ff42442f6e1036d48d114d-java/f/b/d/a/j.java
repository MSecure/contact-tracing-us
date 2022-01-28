package f.b.d.a;

import f.b.g.b1;
import f.b.g.z;

public final class j extends z<j, b> implements Object {
    public static final int COUNT_FIELD_NUMBER = 2;
    private static final j DEFAULT_INSTANCE;
    private static volatile b1<j> PARSER = null;
    public static final int TARGET_ID_FIELD_NUMBER = 1;
    private int count_;
    private int targetId_;

    public static final class b extends z.a<j, b> implements Object {
        public b(a aVar) {
            super(j.DEFAULT_INSTANCE);
        }
    }

    static {
        j jVar = new j();
        DEFAULT_INSTANCE = jVar;
        z.registerDefaultInstance(j.class, jVar);
    }

    public static j c() {
        return DEFAULT_INSTANCE;
    }

    public int d() {
        return this.targetId_;
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004", new Object[]{"targetId_", "count_"});
            case 3:
                return new j();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<j> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (j.class) {
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

    public int getCount() {
        return this.count_;
    }
}
