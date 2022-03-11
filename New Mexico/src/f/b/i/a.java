package f.b.i;

import f.b.g.b1;
import f.b.g.z;
/* loaded from: classes.dex */
public final class a extends z<a, b> implements Object {
    private static final a DEFAULT_INSTANCE;
    public static final int LATITUDE_FIELD_NUMBER = 1;
    public static final int LONGITUDE_FIELD_NUMBER = 2;
    private static volatile b1<a> PARSER;
    private double latitude_;
    private double longitude_;

    /* loaded from: classes.dex */
    public static final class b extends z.a<a, b> implements Object {
        public b() {
            super(a.DEFAULT_INSTANCE);
        }

        public b(C0130a aVar) {
            super(a.DEFAULT_INSTANCE);
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        z.registerDefaultInstance(a.class, aVar);
    }

    public static void c(a aVar, double d2) {
        aVar.latitude_ = d2;
    }

    public static void d(a aVar, double d2) {
        aVar.longitude_ = d2;
    }

    public static a e() {
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0000\u0002\u0000", new Object[]{"latitude_", "longitude_"});
            case 3:
                return new a();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<a> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (a.class) {
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

    public double f() {
        return this.latitude_;
    }

    public double g() {
        return this.longitude_;
    }
}
