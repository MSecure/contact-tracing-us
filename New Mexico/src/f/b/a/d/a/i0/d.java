package f.b.a.d.a.i0;

import f.b.g.b1;
import f.b.g.z;
/* loaded from: classes.dex */
public final class d extends z<d, b> implements Object {
    public static final int BINS_FIELD_NUMBER;
    private static final d DEFAULT_INSTANCE;
    public static final int EPSILON_FIELD_NUMBER;
    public static final int HAMMING_WEIGHT_FIELD_NUMBER;
    public static final int NUMBER_SERVERS_FIELD_NUMBER;
    private static volatile b1<d> PARSER;
    public static final int PRIME_FIELD_NUMBER;
    private int bins_;
    private int bitField0_;
    private double epsilon_;
    private int hammingWeight_;
    private int numberServers_;
    private long prime_;

    /* loaded from: classes.dex */
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

    public static void c(d dVar, int i2) {
        dVar.bitField0_ |= 1;
        dVar.bins_ = i2;
    }

    public static void d(d dVar, double d2) {
        dVar.bitField0_ |= 2;
        dVar.epsilon_ = d2;
    }

    public static void e(d dVar, long j2) {
        dVar.bitField0_ |= 4;
        dVar.prime_ = j2;
    }

    public static void f(d dVar, int i2) {
        dVar.bitField0_ |= 8;
        dVar.numberServers_ = i2;
    }

    public static d h() {
        return DEFAULT_INSTANCE;
    }

    public static b r() {
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0000\u0001\u0003\u0003\u0002\u0004\u0004\u0003\u0005\u0004\u0004", new Object[]{"bitField0_", "bins_", "epsilon_", "prime_", "numberServers_", "hammingWeight_"});
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

    public int g() {
        return this.bins_;
    }

    public double i() {
        return this.epsilon_;
    }

    public int j() {
        return this.hammingWeight_;
    }

    public int k() {
        return this.numberServers_;
    }

    public long l() {
        return this.prime_;
    }

    public boolean m() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean n() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean o() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean p() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean q() {
        return (this.bitField0_ & 4) != 0;
    }
}
