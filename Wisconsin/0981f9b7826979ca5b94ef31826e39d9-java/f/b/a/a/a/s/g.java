package f.b.a.a.a.s;

import f.b.f.b1;
import f.b.f.j;
import f.b.f.k;
import f.b.f.r;
import f.b.f.z;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class g extends z<g, b> implements Object {
    public static final int BINS_FIELD_NUMBER = 1;
    private static final g DEFAULT_INSTANCE;
    public static final int EPSILON_FIELD_NUMBER = 2;
    public static final int HAMMING_WEIGHT_FIELD_NUMBER = 5;
    public static final int NUMBER_SERVERS_FIELD_NUMBER = 4;
    private static volatile b1<g> PARSER = null;
    public static final int PRIME_FIELD_NUMBER = 3;
    private int bins_;
    private int bitField0_;
    private double epsilon_;
    private int hammingWeight_;
    private int numberServers_;
    private long prime_;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|(2:1|2)|3|5|6|7|8|9|11|12|13|15|16|17|18|19|20|22) */
        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|1|2|3|5|6|7|8|9|11|12|13|15|16|17|18|19|20|22) */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0020 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0025 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0012 */
        static {
            z.f.values();
            int[] iArr = new int[7];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[4] = 2;
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[2] = 3;
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[5] = 4;
            } catch (NoSuchFieldError unused2) {
            }
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[6] = 5;
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[0] = 6;
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[1] = 7;
        }
    }

    public static final class b extends z.a<g, b> implements Object {
        private b() {
            super(g.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b clearBins() {
            copyOnWrite();
            ((g) this.instance).clearBins();
            return this;
        }

        public b clearEpsilon() {
            copyOnWrite();
            ((g) this.instance).clearEpsilon();
            return this;
        }

        public b clearHammingWeight() {
            copyOnWrite();
            ((g) this.instance).clearHammingWeight();
            return this;
        }

        public b clearNumberServers() {
            copyOnWrite();
            ((g) this.instance).clearNumberServers();
            return this;
        }

        public b clearPrime() {
            copyOnWrite();
            ((g) this.instance).clearPrime();
            return this;
        }

        public int getBins() {
            return ((g) this.instance).getBins();
        }

        public double getEpsilon() {
            return ((g) this.instance).getEpsilon();
        }

        public int getHammingWeight() {
            return ((g) this.instance).getHammingWeight();
        }

        public int getNumberServers() {
            return ((g) this.instance).getNumberServers();
        }

        public long getPrime() {
            return ((g) this.instance).getPrime();
        }

        public boolean hasBins() {
            return ((g) this.instance).hasBins();
        }

        public boolean hasEpsilon() {
            return ((g) this.instance).hasEpsilon();
        }

        public boolean hasHammingWeight() {
            return ((g) this.instance).hasHammingWeight();
        }

        public boolean hasNumberServers() {
            return ((g) this.instance).hasNumberServers();
        }

        public boolean hasPrime() {
            return ((g) this.instance).hasPrime();
        }

        public b setBins(int i2) {
            copyOnWrite();
            ((g) this.instance).setBins(i2);
            return this;
        }

        public b setEpsilon(double d2) {
            copyOnWrite();
            ((g) this.instance).setEpsilon(d2);
            return this;
        }

        public b setHammingWeight(int i2) {
            copyOnWrite();
            ((g) this.instance).setHammingWeight(i2);
            return this;
        }

        public b setNumberServers(int i2) {
            copyOnWrite();
            ((g) this.instance).setNumberServers(i2);
            return this;
        }

        public b setPrime(long j2) {
            copyOnWrite();
            ((g) this.instance).setPrime(j2);
            return this;
        }
    }

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        z.registerDefaultInstance(g.class, gVar);
    }

    private g() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearBins() {
        this.bitField0_ &= -2;
        this.bins_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearEpsilon() {
        this.bitField0_ &= -3;
        this.epsilon_ = 0.0d;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearHammingWeight() {
        this.bitField0_ &= -17;
        this.hammingWeight_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearNumberServers() {
        this.bitField0_ &= -9;
        this.numberServers_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearPrime() {
        this.bitField0_ &= -5;
        this.prime_ = 0;
    }

    public static g getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(g gVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(gVar);
    }

    public static g parseDelimitedFrom(InputStream inputStream) {
        return (g) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static g parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (g) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static g parseFrom(j jVar) {
        return (g) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static g parseFrom(j jVar, r rVar) {
        return (g) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static g parseFrom(k kVar) {
        return (g) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static g parseFrom(k kVar, r rVar) {
        return (g) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static g parseFrom(InputStream inputStream) {
        return (g) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static g parseFrom(InputStream inputStream, r rVar) {
        return (g) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static g parseFrom(ByteBuffer byteBuffer) {
        return (g) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static g parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (g) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static g parseFrom(byte[] bArr) {
        return (g) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static g parseFrom(byte[] bArr, r rVar) {
        return (g) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<g> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setBins(int i2) {
        this.bitField0_ |= 1;
        this.bins_ = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setEpsilon(double d2) {
        this.bitField0_ |= 2;
        this.epsilon_ = d2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setHammingWeight(int i2) {
        this.bitField0_ |= 16;
        this.hammingWeight_ = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setNumberServers(int i2) {
        this.bitField0_ |= 8;
        this.numberServers_ = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPrime(long j2) {
        this.bitField0_ |= 4;
        this.prime_ = j2;
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0000\u0001\u0003\u0003\u0002\u0004\u0004\u0003\u0005\u0004\u0004", new Object[]{"bitField0_", "bins_", "epsilon_", "prime_", "numberServers_", "hammingWeight_"});
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

    public int getBins() {
        return this.bins_;
    }

    public double getEpsilon() {
        return this.epsilon_;
    }

    public int getHammingWeight() {
        return this.hammingWeight_;
    }

    public int getNumberServers() {
        return this.numberServers_;
    }

    public long getPrime() {
        return this.prime_;
    }

    public boolean hasBins() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasEpsilon() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasHammingWeight() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasNumberServers() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasPrime() {
        return (this.bitField0_ & 4) != 0;
    }
}
