package f.b.a.a.a.h0;

import f.b.g.b1;
import f.b.g.c0;
import f.b.g.j;
import f.b.g.r;
import f.b.g.z;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class k extends z<k, b> implements m {
    public static final int DAYS_SINCE_ONSET_OF_SYMPTOMS_FIELD_NUMBER;
    private static final k DEFAULT_INSTANCE;
    public static final int KEY_DATA_FIELD_NUMBER;
    private static volatile b1<k> PARSER;
    public static final int REPORT_TYPE_FIELD_NUMBER;
    public static final int ROLLING_PERIOD_FIELD_NUMBER;
    public static final int ROLLING_START_INTERVAL_NUMBER_FIELD_NUMBER;
    public static final int TRANSMISSION_RISK_LEVEL_FIELD_NUMBER;
    private int bitField0_;
    private int daysSinceOnsetOfSymptoms_;
    private int reportType_;
    private int rollingStartIntervalNumber_;
    private int transmissionRiskLevel_;
    private j keyData_ = j.c;
    private int rollingPeriod_ = 144;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            z.f.values();
            int[] iArr = new int[7];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[4] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[5] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[6] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[0] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[1] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<k, b> implements m {
        private b() {
            super(k.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b clearDaysSinceOnsetOfSymptoms() {
            copyOnWrite();
            ((k) this.instance).clearDaysSinceOnsetOfSymptoms();
            return this;
        }

        public b clearKeyData() {
            copyOnWrite();
            ((k) this.instance).clearKeyData();
            return this;
        }

        public b clearReportType() {
            copyOnWrite();
            ((k) this.instance).clearReportType();
            return this;
        }

        public b clearRollingPeriod() {
            copyOnWrite();
            ((k) this.instance).clearRollingPeriod();
            return this;
        }

        public b clearRollingStartIntervalNumber() {
            copyOnWrite();
            ((k) this.instance).clearRollingStartIntervalNumber();
            return this;
        }

        public b clearTransmissionRiskLevel() {
            copyOnWrite();
            ((k) this.instance).clearTransmissionRiskLevel();
            return this;
        }

        @Override // f.b.a.a.a.h0.m
        public int getDaysSinceOnsetOfSymptoms() {
            return ((k) this.instance).getDaysSinceOnsetOfSymptoms();
        }

        @Override // f.b.a.a.a.h0.m
        public j getKeyData() {
            return ((k) this.instance).getKeyData();
        }

        @Override // f.b.a.a.a.h0.m
        public c getReportType() {
            return ((k) this.instance).getReportType();
        }

        @Override // f.b.a.a.a.h0.m
        public int getRollingPeriod() {
            return ((k) this.instance).getRollingPeriod();
        }

        @Override // f.b.a.a.a.h0.m
        public int getRollingStartIntervalNumber() {
            return ((k) this.instance).getRollingStartIntervalNumber();
        }

        @Override // f.b.a.a.a.h0.m
        public int getTransmissionRiskLevel() {
            return ((k) this.instance).getTransmissionRiskLevel();
        }

        @Override // f.b.a.a.a.h0.m
        public boolean hasDaysSinceOnsetOfSymptoms() {
            return ((k) this.instance).hasDaysSinceOnsetOfSymptoms();
        }

        @Override // f.b.a.a.a.h0.m
        public boolean hasKeyData() {
            return ((k) this.instance).hasKeyData();
        }

        @Override // f.b.a.a.a.h0.m
        public boolean hasReportType() {
            return ((k) this.instance).hasReportType();
        }

        @Override // f.b.a.a.a.h0.m
        public boolean hasRollingPeriod() {
            return ((k) this.instance).hasRollingPeriod();
        }

        @Override // f.b.a.a.a.h0.m
        public boolean hasRollingStartIntervalNumber() {
            return ((k) this.instance).hasRollingStartIntervalNumber();
        }

        @Override // f.b.a.a.a.h0.m
        public boolean hasTransmissionRiskLevel() {
            return ((k) this.instance).hasTransmissionRiskLevel();
        }

        public b setDaysSinceOnsetOfSymptoms(int i2) {
            copyOnWrite();
            ((k) this.instance).setDaysSinceOnsetOfSymptoms(i2);
            return this;
        }

        public b setKeyData(j jVar) {
            copyOnWrite();
            ((k) this.instance).setKeyData(jVar);
            return this;
        }

        public b setReportType(c cVar) {
            copyOnWrite();
            ((k) this.instance).setReportType(cVar);
            return this;
        }

        public b setRollingPeriod(int i2) {
            copyOnWrite();
            ((k) this.instance).setRollingPeriod(i2);
            return this;
        }

        public b setRollingStartIntervalNumber(int i2) {
            copyOnWrite();
            ((k) this.instance).setRollingStartIntervalNumber(i2);
            return this;
        }

        public b setTransmissionRiskLevel(int i2) {
            copyOnWrite();
            ((k) this.instance).setTransmissionRiskLevel(i2);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum c implements c0.c {
        REPORT_TYPE_UNKNOWN(0),
        CONFIRMED_TEST(1),
        CONFIRMED_CLINICAL_DIAGNOSIS(2),
        SELF_REPORT(3),
        RECURSIVE(4),
        REVOKED(5);
        
        public static final int CONFIRMED_CLINICAL_DIAGNOSIS_VALUE;
        public static final int CONFIRMED_TEST_VALUE;
        public static final int RECURSIVE_VALUE;
        public static final int REPORT_TYPE_UNKNOWN_VALUE;
        public static final int REVOKED_VALUE;
        public static final int SELF_REPORT_VALUE;
        private static final c0.d<c> internalValueMap = new a();
        private final int value;

        /* loaded from: classes.dex */
        public class a implements c0.d<c> {
            @Override // f.b.g.c0.d
            public c findValueByNumber(int i2) {
                return c.forNumber(i2);
            }
        }

        /* loaded from: classes.dex */
        public static final class b implements c0.e {
            public static final c0.e INSTANCE = new b();

            private b() {
            }

            @Override // f.b.g.c0.e
            public boolean isInRange(int i2) {
                return c.forNumber(i2) != null;
            }
        }

        c(int i2) {
            this.value = i2;
        }

        public static c forNumber(int i2) {
            if (i2 == 0) {
                return REPORT_TYPE_UNKNOWN;
            }
            if (i2 == 1) {
                return CONFIRMED_TEST;
            }
            if (i2 == 2) {
                return CONFIRMED_CLINICAL_DIAGNOSIS;
            }
            if (i2 == 3) {
                return SELF_REPORT;
            }
            if (i2 == 4) {
                return RECURSIVE;
            }
            if (i2 != 5) {
                return null;
            }
            return REVOKED;
        }

        public static c0.d<c> internalGetValueMap() {
            return internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return b.INSTANCE;
        }

        @Deprecated
        public static c valueOf(int i2) {
            return forNumber(i2);
        }

        @Override // f.b.g.c0.c
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        k kVar = new k();
        DEFAULT_INSTANCE = kVar;
        z.registerDefaultInstance(k.class, kVar);
    }

    private k() {
    }

    public void clearDaysSinceOnsetOfSymptoms() {
        this.bitField0_ &= -33;
        this.daysSinceOnsetOfSymptoms_ = 0;
    }

    public void clearKeyData() {
        this.bitField0_ &= -2;
        this.keyData_ = getDefaultInstance().getKeyData();
    }

    public void clearReportType() {
        this.bitField0_ &= -17;
        this.reportType_ = 0;
    }

    public void clearRollingPeriod() {
        this.bitField0_ &= -9;
        this.rollingPeriod_ = 144;
    }

    public void clearRollingStartIntervalNumber() {
        this.bitField0_ &= -5;
        this.rollingStartIntervalNumber_ = 0;
    }

    public void clearTransmissionRiskLevel() {
        this.bitField0_ &= -3;
        this.transmissionRiskLevel_ = 0;
    }

    public static k getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(k kVar) {
        return DEFAULT_INSTANCE.createBuilder(kVar);
    }

    public static k parseDelimitedFrom(InputStream inputStream) {
        return (k) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static k parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (k) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static k parseFrom(j jVar) {
        return (k) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static k parseFrom(j jVar, r rVar) {
        return (k) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static k parseFrom(f.b.g.k kVar) {
        return (k) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static k parseFrom(f.b.g.k kVar, r rVar) {
        return (k) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static k parseFrom(InputStream inputStream) {
        return (k) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static k parseFrom(InputStream inputStream, r rVar) {
        return (k) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static k parseFrom(ByteBuffer byteBuffer) {
        return (k) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static k parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (k) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static k parseFrom(byte[] bArr) {
        return (k) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static k parseFrom(byte[] bArr, r rVar) {
        return (k) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<k> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    public void setDaysSinceOnsetOfSymptoms(int i2) {
        this.bitField0_ |= 32;
        this.daysSinceOnsetOfSymptoms_ = i2;
    }

    public void setKeyData(j jVar) {
        jVar.getClass();
        this.bitField0_ |= 1;
        this.keyData_ = jVar;
    }

    public void setReportType(c cVar) {
        this.reportType_ = cVar.getNumber();
        this.bitField0_ |= 16;
    }

    public void setRollingPeriod(int i2) {
        this.bitField0_ |= 8;
        this.rollingPeriod_ = i2;
    }

    public void setRollingStartIntervalNumber(int i2) {
        this.bitField0_ |= 4;
        this.rollingStartIntervalNumber_ = i2;
    }

    public void setTransmissionRiskLevel(int i2) {
        this.bitField0_ |= 2;
        this.transmissionRiskLevel_ = i2;
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\n\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\u0004\u0003\u0005\f\u0004\u0006\u000f\u0005", new Object[]{"bitField0_", "keyData_", "transmissionRiskLevel_", "rollingStartIntervalNumber_", "rollingPeriod_", "reportType_", c.internalGetVerifier(), "daysSinceOnsetOfSymptoms_"});
            case 3:
                return new k();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<k> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (k.class) {
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

    @Override // f.b.a.a.a.h0.m
    public int getDaysSinceOnsetOfSymptoms() {
        return this.daysSinceOnsetOfSymptoms_;
    }

    @Override // f.b.a.a.a.h0.m
    public j getKeyData() {
        return this.keyData_;
    }

    @Override // f.b.a.a.a.h0.m
    public c getReportType() {
        c forNumber = c.forNumber(this.reportType_);
        return forNumber == null ? c.REPORT_TYPE_UNKNOWN : forNumber;
    }

    @Override // f.b.a.a.a.h0.m
    public int getRollingPeriod() {
        return this.rollingPeriod_;
    }

    @Override // f.b.a.a.a.h0.m
    public int getRollingStartIntervalNumber() {
        return this.rollingStartIntervalNumber_;
    }

    @Override // f.b.a.a.a.h0.m
    public int getTransmissionRiskLevel() {
        return this.transmissionRiskLevel_;
    }

    @Override // f.b.a.a.a.h0.m
    public boolean hasDaysSinceOnsetOfSymptoms() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // f.b.a.a.a.h0.m
    public boolean hasKeyData() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // f.b.a.a.a.h0.m
    public boolean hasReportType() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // f.b.a.a.a.h0.m
    public boolean hasRollingPeriod() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // f.b.a.a.a.h0.m
    public boolean hasRollingStartIntervalNumber() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // f.b.a.a.a.h0.m
    public boolean hasTransmissionRiskLevel() {
        return (this.bitField0_ & 2) != 0;
    }
}
