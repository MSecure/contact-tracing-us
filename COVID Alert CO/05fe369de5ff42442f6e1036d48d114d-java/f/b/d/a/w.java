package f.b.d.a;

import f.b.g.b1;
import f.b.g.c0;
import f.b.g.p1;
import f.b.g.z;

public final class w extends z<w, b> implements Object {
    private static final w DEFAULT_INSTANCE;
    private static volatile b1<w> PARSER = null;
    public static final int TRANSFORM_RESULTS_FIELD_NUMBER = 2;
    public static final int UPDATE_TIME_FIELD_NUMBER = 1;
    private c0.i<s> transformResults_ = z.emptyProtobufList();
    private p1 updateTime_;

    public static final class b extends z.a<w, b> implements Object {
        public b(a aVar) {
            super(w.DEFAULT_INSTANCE);
        }
    }

    static {
        w wVar = new w();
        DEFAULT_INSTANCE = wVar;
        z.registerDefaultInstance(w.class, wVar);
    }

    public s c(int i2) {
        return this.transformResults_.get(i2);
    }

    public int d() {
        return this.transformResults_.size();
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\t\u0002\u001b", new Object[]{"updateTime_", "transformResults_", s.class});
            case 3:
                return new w();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<w> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (w.class) {
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

    public p1 e() {
        p1 p1Var = this.updateTime_;
        return p1Var == null ? p1.e() : p1Var;
    }
}
