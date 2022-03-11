package f.b.a.a.a.h0;

import f.b.g.b1;
import f.b.g.c0;
import f.b.g.j;
import f.b.g.k;
import f.b.g.r;
import f.b.g.z;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class a extends z<a, c> implements b {
    public static final int API_CALL_TYPE_FIELD_NUMBER;
    public static final int COUNT_FIELD_NUMBER;
    private static final a DEFAULT_INSTANCE;
    public static final int HEALTH_AUTHORITY_FIELD_NUMBER;
    private static volatile b1<a> PARSER;
    public static final int STATUS_CODE_FIELD_NUMBER;
    private int apiCallType_;
    private int bitField0_;
    private int count_;
    private String healthAuthority_ = "";
    private int statusCode_;

    /* renamed from: f.b.a.a.a.h0.a$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0073a {
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
    public enum b implements c0.c {
        CALL_GET_EXPOSURE_NOTIFICATION_CLIENT(0),
        CALL_START(1),
        CALL_STOP(2),
        CALL_IS_ENABLED(3),
        CALL_SET_DIAGNOSIS_KEYS_DATA_MAPPING(4),
        CALL_GET_DAILY_SUMMARIES(5),
        CALL_DEVICE_SUPPORTS_LOCATIONLESS_SCANNING(6),
        CALL_PROVIDE_DIAGNOSIS_KEYS(7);
        
        public static final int CALL_DEVICE_SUPPORTS_LOCATIONLESS_SCANNING_VALUE;
        public static final int CALL_GET_DAILY_SUMMARIES_VALUE;
        public static final int CALL_GET_EXPOSURE_NOTIFICATION_CLIENT_VALUE;
        public static final int CALL_IS_ENABLED_VALUE;
        public static final int CALL_PROVIDE_DIAGNOSIS_KEYS_VALUE;
        public static final int CALL_SET_DIAGNOSIS_KEYS_DATA_MAPPING_VALUE;
        public static final int CALL_START_VALUE;
        public static final int CALL_STOP_VALUE;
        private static final c0.d<b> internalValueMap = new C0074a();
        private final int value;

        /* renamed from: f.b.a.a.a.h0.a$b$a */
        /* loaded from: classes.dex */
        public class C0074a implements c0.d<b> {
            @Override // f.b.g.c0.d
            public b findValueByNumber(int i2) {
                return b.forNumber(i2);
            }
        }

        /* renamed from: f.b.a.a.a.h0.a$b$b */
        /* loaded from: classes.dex */
        public static final class C0075b implements c0.e {
            public static final c0.e INSTANCE = new C0075b();

            private C0075b() {
            }

            @Override // f.b.g.c0.e
            public boolean isInRange(int i2) {
                return b.forNumber(i2) != null;
            }
        }

        b(int i2) {
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
            return C0075b.INSTANCE;
        }

        @Deprecated
        public static b valueOf(int i2) {
            return forNumber(i2);
        }

        @Override // f.b.g.c0.c
        public final int getNumber() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends z.a<a, c> implements b {
        private c() {
            super(a.DEFAULT_INSTANCE);
        }

        public /* synthetic */ c(C0073a aVar) {
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

        @Override // f.b.a.a.a.h0.b
        public b getApiCallType() {
            return ((a) this.instance).getApiCallType();
        }

        @Override // f.b.a.a.a.h0.b
        public int getCount() {
            return ((a) this.instance).getCount();
        }

        @Override // f.b.a.a.a.h0.b
        @Deprecated
        public String getHealthAuthority() {
            return ((a) this.instance).getHealthAuthority();
        }

        @Override // f.b.a.a.a.h0.b
        @Deprecated
        public j getHealthAuthorityBytes() {
            return ((a) this.instance).getHealthAuthorityBytes();
        }

        @Override // f.b.a.a.a.h0.b
        public int getStatusCode() {
            return ((a) this.instance).getStatusCode();
        }

        @Override // f.b.a.a.a.h0.b
        public boolean hasApiCallType() {
            return ((a) this.instance).hasApiCallType();
        }

        @Override // f.b.a.a.a.h0.b
        public boolean hasCount() {
            return ((a) this.instance).hasCount();
        }

        @Override // f.b.a.a.a.h0.b
        @Deprecated
        public boolean hasHealthAuthority() {
            return ((a) this.instance).hasHealthAuthority();
        }

        @Override // f.b.a.a.a.h0.b
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

    public void clearApiCallType() {
        this.bitField0_ &= -3;
        this.apiCallType_ = 0;
    }

    public void clearCount() {
        this.bitField0_ &= -9;
        this.count_ = 0;
    }

    public void clearHealthAuthority() {
        this.bitField0_ &= -2;
        this.healthAuthority_ = getDefaultInstance().getHealthAuthority();
    }

    public void clearStatusCode() {
        this.bitField0_ &= -5;
        this.statusCode_ = 0;
    }

    public static a getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static c newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static c newBuilder(a aVar) {
        return DEFAULT_INSTANCE.createBuilder(aVar);
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

    public void setApiCallType(b bVar) {
        this.apiCallType_ = bVar.getNumber();
        this.bitField0_ |= 2;
    }

    public void setCount(int i2) {
        this.bitField0_ |= 8;
        this.count_ = i2;
    }

    public void setHealthAuthority(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.healthAuthority_ = str;
    }

    public void setHealthAuthorityBytes(j jVar) {
        this.healthAuthority_ = jVar.B();
        this.bitField0_ |= 1;
    }

    public void setStatusCode(int i2) {
        this.bitField0_ |= 4;
        this.statusCode_ = i2;
    }

    @Override // f.b.g.z
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

    @Override // f.b.a.a.a.h0.b
    public b getApiCallType() {
        b forNumber = b.forNumber(this.apiCallType_);
        return forNumber == null ? b.CALL_GET_EXPOSURE_NOTIFICATION_CLIENT : forNumber;
    }

    @Override // f.b.a.a.a.h0.b
    public int getCount() {
        return this.count_;
    }

    @Override // f.b.a.a.a.h0.b
    @Deprecated
    public String getHealthAuthority() {
        return this.healthAuthority_;
    }

    @Override // f.b.a.a.a.h0.b
    @Deprecated
    public j getHealthAuthorityBytes() {
        return j.n(this.healthAuthority_);
    }

    @Override // f.b.a.a.a.h0.b
    public int getStatusCode() {
        return this.statusCode_;
    }

    @Override // f.b.a.a.a.h0.b
    public boolean hasApiCallType() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // f.b.a.a.a.h0.b
    public boolean hasCount() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // f.b.a.a.a.h0.b
    @Deprecated
    public boolean hasHealthAuthority() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // f.b.a.a.a.h0.b
    public boolean hasStatusCode() {
        return (this.bitField0_ & 4) != 0;
    }
}
