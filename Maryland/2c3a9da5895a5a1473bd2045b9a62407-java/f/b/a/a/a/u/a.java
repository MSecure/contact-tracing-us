package f.b.a.a.a.u;

import f.b.f.b1;
import f.b.f.c0;
import f.b.f.j;
import f.b.f.k;
import f.b.f.r;
import f.b.f.z;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class a extends z<a, c> implements b {
    public static final int API_CALL_TYPE_FIELD_NUMBER = 2;
    public static final int COUNT_FIELD_NUMBER = 4;
    private static final a DEFAULT_INSTANCE;
    public static final int HEALTH_AUTHORITY_FIELD_NUMBER = 1;
    private static volatile b1<a> PARSER = null;
    public static final int STATUS_CODE_FIELD_NUMBER = 3;
    private int apiCallType_;
    private int bitField0_;
    private int count_;
    private String healthAuthority_ = "";
    private int statusCode_;

    /* renamed from: f.b.a.a.a.u.a$a  reason: collision with other inner class name */
    public static /* synthetic */ class C0075a {
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

    public enum b implements c0.c {
        CALL_GET_EXPOSURE_NOTIFICATION_CLIENT(0),
        CALL_START(1),
        CALL_STOP(2),
        CALL_IS_ENABLED(3),
        CALL_SET_DIAGNOSIS_KEYS_DATA_MAPPING(4),
        CALL_GET_DAILY_SUMMARIES(5),
        CALL_DEVICE_SUPPORTS_LOCATIONLESS_SCANNING(6),
        CALL_PROVIDE_DIAGNOSIS_KEYS(7);
        
        public static final int CALL_DEVICE_SUPPORTS_LOCATIONLESS_SCANNING_VALUE = 6;
        public static final int CALL_GET_DAILY_SUMMARIES_VALUE = 5;
        public static final int CALL_GET_EXPOSURE_NOTIFICATION_CLIENT_VALUE = 0;
        public static final int CALL_IS_ENABLED_VALUE = 3;
        public static final int CALL_PROVIDE_DIAGNOSIS_KEYS_VALUE = 7;
        public static final int CALL_SET_DIAGNOSIS_KEYS_DATA_MAPPING_VALUE = 4;
        public static final int CALL_START_VALUE = 1;
        public static final int CALL_STOP_VALUE = 2;
        private static final c0.d<b> internalValueMap = new C0076a();
        private final int value;

        /* renamed from: f.b.a.a.a.u.a$b$a  reason: collision with other inner class name */
        public class C0076a implements c0.d<b> {
            @Override // f.b.f.c0.d
            public b findValueByNumber(int i2) {
                return b.forNumber(i2);
            }
        }

        /* renamed from: f.b.a.a.a.u.a$b$b  reason: collision with other inner class name */
        public static final class C0077b implements c0.e {
            public static final c0.e INSTANCE = new C0077b();

            private C0077b() {
            }

            @Override // f.b.f.c0.e
            public boolean isInRange(int i2) {
                return b.forNumber(i2) != null;
            }
        }

        private b(int i2) {
            this.value = i2;
        }

        public static b forNumber(int i2) {
            switch (i2) {
                case 0:
                    return CALL_GET_EXPOSURE_NOTIFICATION_CLIENT;
                case 1:
                    return CALL_START;
                case 2:
                    return CALL_STOP;
                case 3:
                    return CALL_IS_ENABLED;
                case 4:
                    return CALL_SET_DIAGNOSIS_KEYS_DATA_MAPPING;
                case 5:
                    return CALL_GET_DAILY_SUMMARIES;
                case 6:
                    return CALL_DEVICE_SUPPORTS_LOCATIONLESS_SCANNING;
                case 7:
                    return CALL_PROVIDE_DIAGNOSIS_KEYS;
                default:
                    return null;
            }
        }

        public static c0.d<b> internalGetValueMap() {
            return internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return C0077b.INSTANCE;
        }

        @Deprecated
        public static b valueOf(int i2) {
            return forNumber(i2);
        }

        @Override // f.b.f.c0.c
        public final int getNumber() {
            return this.value;
        }
    }

    public static final class c extends z.a<a, c> implements b {
        private c() {
            super(a.DEFAULT_INSTANCE);
        }

        public /* synthetic */ c(C0075a aVar) {
            this();
        }

        public c clearApiCallType() {
            copyOnWrite();
            ((a) this.instance).clearApiCallType();
            return this;
        }

        public c clearCount() {
            copyOnWrite();
            ((a) this.instance).clearCount();
            return this;
        }

        @Deprecated
        public c clearHealthAuthority() {
            copyOnWrite();
            ((a) this.instance).clearHealthAuthority();
            return this;
        }

        public c clearStatusCode() {
            copyOnWrite();
            ((a) this.instance).clearStatusCode();
            return this;
        }

        @Override // f.b.a.a.a.u.b
        public b getApiCallType() {
            return ((a) this.instance).getApiCallType();
        }

        @Override // f.b.a.a.a.u.b
        public int getCount() {
            return ((a) this.instance).getCount();
        }

        @Override // f.b.a.a.a.u.b
        @Deprecated
        public String getHealthAuthority() {
            return ((a) this.instance).getHealthAuthority();
        }

        @Override // f.b.a.a.a.u.b
        @Deprecated
        public j getHealthAuthorityBytes() {
            return ((a) this.instance).getHealthAuthorityBytes();
        }

        @Override // f.b.a.a.a.u.b
        public int getStatusCode() {
            return ((a) this.instance).getStatusCode();
        }

        @Override // f.b.a.a.a.u.b
        public boolean hasApiCallType() {
            return ((a) this.instance).hasApiCallType();
        }

        @Override // f.b.a.a.a.u.b
        public boolean hasCount() {
            return ((a) this.instance).hasCount();
        }

        @Override // f.b.a.a.a.u.b
        @Deprecated
        public boolean hasHealthAuthority() {
            return ((a) this.instance).hasHealthAuthority();
        }

        @Override // f.b.a.a.a.u.b
        public boolean hasStatusCode() {
            return ((a) this.instance).hasStatusCode();
        }

        public c setApiCallType(b bVar) {
            copyOnWrite();
            ((a) this.instance).setApiCallType(bVar);
            return this;
        }

        public c setCount(int i2) {
            copyOnWrite();
            ((a) this.instance).setCount(i2);
            return this;
        }

        @Deprecated
        public c setHealthAuthority(String str) {
            copyOnWrite();
            ((a) this.instance).setHealthAuthority(str);
            return this;
        }

        @Deprecated
        public c setHealthAuthorityBytes(j jVar) {
            copyOnWrite();
            ((a) this.instance).setHealthAuthorityBytes(jVar);
            return this;
        }

        public c setStatusCode(int i2) {
            copyOnWrite();
            ((a) this.instance).setStatusCode(i2);
            return this;
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        z.registerDefaultInstance(a.class, aVar);
    }

    private a() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearApiCallType() {
        this.bitField0_ &= -3;
        this.apiCallType_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearCount() {
        this.bitField0_ &= -9;
        this.count_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearHealthAuthority() {
        this.bitField0_ &= -2;
        this.healthAuthority_ = getDefaultInstance().getHealthAuthority();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearStatusCode() {
        this.bitField0_ &= -5;
        this.statusCode_ = 0;
    }

    public static a getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static c newBuilder() {
        return (c) DEFAULT_INSTANCE.createBuilder();
    }

    public static c newBuilder(a aVar) {
        return (c) DEFAULT_INSTANCE.createBuilder(aVar);
    }

    public static a parseDelimitedFrom(InputStream inputStream) {
        return (a) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static a parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (a) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static a parseFrom(j jVar) {
        return (a) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static a parseFrom(j jVar, r rVar) {
        return (a) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static a parseFrom(k kVar) {
        return (a) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static a parseFrom(k kVar, r rVar) {
        return (a) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static a parseFrom(InputStream inputStream) {
        return (a) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static a parseFrom(InputStream inputStream, r rVar) {
        return (a) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static a parseFrom(ByteBuffer byteBuffer) {
        return (a) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static a parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (a) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static a parseFrom(byte[] bArr) {
        return (a) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static a parseFrom(byte[] bArr, r rVar) {
        return (a) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<a> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setApiCallType(b bVar) {
        this.apiCallType_ = bVar.getNumber();
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setCount(int i2) {
        this.bitField0_ |= 8;
        this.count_ = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setHealthAuthority(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.healthAuthority_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setHealthAuthorityBytes(j jVar) {
        this.healthAuthority_ = jVar.B();
        this.bitField0_ |= 1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setStatusCode(int i2) {
        this.bitField0_ |= 4;
        this.statusCode_ = i2;
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0004\u0002\u0004\u0004\u0003", new Object[]{"bitField0_", "healthAuthority_", "apiCallType_", b.internalGetVerifier(), "statusCode_", "count_"});
            case 3:
                return new a();
            case 4:
                return new c(null);
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

    @Override // f.b.a.a.a.u.b
    public b getApiCallType() {
        b forNumber = b.forNumber(this.apiCallType_);
        return forNumber == null ? b.CALL_GET_EXPOSURE_NOTIFICATION_CLIENT : forNumber;
    }

    @Override // f.b.a.a.a.u.b
    public int getCount() {
        return this.count_;
    }

    @Override // f.b.a.a.a.u.b
    @Deprecated
    public String getHealthAuthority() {
        return this.healthAuthority_;
    }

    @Override // f.b.a.a.a.u.b
    @Deprecated
    public j getHealthAuthorityBytes() {
        return j.n(this.healthAuthority_);
    }

    @Override // f.b.a.a.a.u.b
    public int getStatusCode() {
        return this.statusCode_;
    }

    @Override // f.b.a.a.a.u.b
    public boolean hasApiCallType() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // f.b.a.a.a.u.b
    public boolean hasCount() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // f.b.a.a.a.u.b
    @Deprecated
    public boolean hasHealthAuthority() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // f.b.a.a.a.u.b
    public boolean hasStatusCode() {
        return (this.bitField0_ & 4) != 0;
    }
}
