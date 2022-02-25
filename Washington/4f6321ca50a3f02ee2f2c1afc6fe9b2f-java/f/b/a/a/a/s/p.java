package f.b.a.a.a.s;

import f.b.f.b1;
import f.b.f.j;
import f.b.f.k;
import f.b.f.r;
import f.b.f.z;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class p extends z<p, b> implements r {
    private static final p DEFAULT_INSTANCE;
    public static final int KEY_DATA_FIELD_NUMBER = 1;
    private static volatile b1<p> PARSER = null;
    public static final int ROLLING_PERIOD_FIELD_NUMBER = 4;
    public static final int ROLLING_START_INTERVAL_NUMBER_FIELD_NUMBER = 3;
    public static final int TRANSMISSION_RISK_LEVEL_FIELD_NUMBER = 2;
    private int bitField0_;
    private j keyData_ = j.c;
    private int rollingPeriod_ = 144;
    private int rollingStartIntervalNumber_;
    private int transmissionRiskLevel_;

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

    public static final class b extends z.a<p, b> implements r {
        private b() {
            super(p.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b clearKeyData() {
            copyOnWrite();
            ((p) this.instance).clearKeyData();
            return this;
        }

        public b clearRollingPeriod() {
            copyOnWrite();
            ((p) this.instance).clearRollingPeriod();
            return this;
        }

        public b clearRollingStartIntervalNumber() {
            copyOnWrite();
            ((p) this.instance).clearRollingStartIntervalNumber();
            return this;
        }

        public b clearTransmissionRiskLevel() {
            copyOnWrite();
            ((p) this.instance).clearTransmissionRiskLevel();
            return this;
        }

        @Override // f.b.a.a.a.s.r
        public j getKeyData() {
            return ((p) this.instance).getKeyData();
        }

        @Override // f.b.a.a.a.s.r
        public int getRollingPeriod() {
            return ((p) this.instance).getRollingPeriod();
        }

        @Override // f.b.a.a.a.s.r
        public int getRollingStartIntervalNumber() {
            return ((p) this.instance).getRollingStartIntervalNumber();
        }

        @Override // f.b.a.a.a.s.r
        public int getTransmissionRiskLevel() {
            return ((p) this.instance).getTransmissionRiskLevel();
        }

        @Override // f.b.a.a.a.s.r
        public boolean hasKeyData() {
            return ((p) this.instance).hasKeyData();
        }

        @Override // f.b.a.a.a.s.r
        public boolean hasRollingPeriod() {
            return ((p) this.instance).hasRollingPeriod();
        }

        @Override // f.b.a.a.a.s.r
        public boolean hasRollingStartIntervalNumber() {
            return ((p) this.instance).hasRollingStartIntervalNumber();
        }

        @Override // f.b.a.a.a.s.r
        public boolean hasTransmissionRiskLevel() {
            return ((p) this.instance).hasTransmissionRiskLevel();
        }

        public b setKeyData(j jVar) {
            copyOnWrite();
            ((p) this.instance).setKeyData(jVar);
            return this;
        }

        public b setRollingPeriod(int i2) {
            copyOnWrite();
            ((p) this.instance).setRollingPeriod(i2);
            return this;
        }

        public b setRollingStartIntervalNumber(int i2) {
            copyOnWrite();
            ((p) this.instance).setRollingStartIntervalNumber(i2);
            return this;
        }

        public b setTransmissionRiskLevel(int i2) {
            copyOnWrite();
            ((p) this.instance).setTransmissionRiskLevel(i2);
            return this;
        }
    }

    static {
        p pVar = new p();
        DEFAULT_INSTANCE = pVar;
        z.registerDefaultInstance(p.class, pVar);
    }

    private p() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearKeyData() {
        this.bitField0_ &= -2;
        this.keyData_ = getDefaultInstance().getKeyData();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearRollingPeriod() {
        this.bitField0_ &= -9;
        this.rollingPeriod_ = 144;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearRollingStartIntervalNumber() {
        this.bitField0_ &= -5;
        this.rollingStartIntervalNumber_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearTransmissionRiskLevel() {
        this.bitField0_ &= -3;
        this.transmissionRiskLevel_ = 0;
    }

    public static p getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(p pVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(pVar);
    }

    public static p parseDelimitedFrom(InputStream inputStream) {
        return (p) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static p parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (p) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static p parseFrom(j jVar) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static p parseFrom(j jVar, r rVar) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static p parseFrom(k kVar) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static p parseFrom(k kVar, r rVar) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static p parseFrom(InputStream inputStream) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static p parseFrom(InputStream inputStream, r rVar) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static p parseFrom(ByteBuffer byteBuffer) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static p parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static p parseFrom(byte[] bArr) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static p parseFrom(byte[] bArr, r rVar) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<p> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setKeyData(j jVar) {
        jVar.getClass();
        this.bitField0_ |= 1;
        this.keyData_ = jVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setRollingPeriod(int i2) {
        this.bitField0_ |= 8;
        this.rollingPeriod_ = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setRollingStartIntervalNumber(int i2) {
        this.bitField0_ |= 4;
        this.rollingStartIntervalNumber_ = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setTransmissionRiskLevel(int i2) {
        this.bitField0_ |= 2;
        this.transmissionRiskLevel_ = i2;
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\n\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\u0004\u0003", new Object[]{"bitField0_", "keyData_", "transmissionRiskLevel_", "rollingStartIntervalNumber_", "rollingPeriod_"});
            case 3:
                return new p();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<p> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (p.class) {
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

    @Override // f.b.a.a.a.s.r
    public j getKeyData() {
        return this.keyData_;
    }

    @Override // f.b.a.a.a.s.r
    public int getRollingPeriod() {
        return this.rollingPeriod_;
    }

    @Override // f.b.a.a.a.s.r
    public int getRollingStartIntervalNumber() {
        return this.rollingStartIntervalNumber_;
    }

    @Override // f.b.a.a.a.s.r
    public int getTransmissionRiskLevel() {
        return this.transmissionRiskLevel_;
    }

    @Override // f.b.a.a.a.s.r
    public boolean hasKeyData() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // f.b.a.a.a.s.r
    public boolean hasRollingPeriod() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // f.b.a.a.a.s.r
    public boolean hasRollingStartIntervalNumber() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // f.b.a.a.a.s.r
    public boolean hasTransmissionRiskLevel() {
        return (this.bitField0_ & 2) != 0;
    }
}
