package f.b.a.a.a.g0;

import f.b.g.b1;
import f.b.g.c0;
import f.b.g.j;
import f.b.g.k;
import f.b.g.r;
import f.b.g.z;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class d extends z<d, b> implements e {
    public static final int COUNT_FIELD_NUMBER = 5;
    private static final d DEFAULT_INSTANCE;
    public static final int HEALTH_AUTHORITY_FIELD_NUMBER = 1;
    private static volatile b1<d> PARSER = null;
    public static final int PAYLOAD_SIZE_FIELD_NUMBER = 4;
    public static final int RPC_CALL_RESULT_FIELD_NUMBER = 3;
    public static final int RPC_CALL_TYPE_FIELD_NUMBER = 2;
    private int bitField0_;
    private int count_;
    private String healthAuthority_ = "";
    private int payloadSize_;
    private int rpcCallResult_;
    private int rpcCallType_;

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

    public static final class b extends z.a<d, b> implements e {
        private b() {
            super(d.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b clearCount() {
            copyOnWrite();
            ((d) this.instance).clearCount();
            return this;
        }

        @Deprecated
        public b clearHealthAuthority() {
            copyOnWrite();
            ((d) this.instance).clearHealthAuthority();
            return this;
        }

        public b clearPayloadSize() {
            copyOnWrite();
            ((d) this.instance).clearPayloadSize();
            return this;
        }

        public b clearRpcCallResult() {
            copyOnWrite();
            ((d) this.instance).clearRpcCallResult();
            return this;
        }

        public b clearRpcCallType() {
            copyOnWrite();
            ((d) this.instance).clearRpcCallType();
            return this;
        }

        @Override // f.b.a.a.a.g0.e
        public int getCount() {
            return ((d) this.instance).getCount();
        }

        @Override // f.b.a.a.a.g0.e
        @Deprecated
        public String getHealthAuthority() {
            return ((d) this.instance).getHealthAuthority();
        }

        @Override // f.b.a.a.a.g0.e
        @Deprecated
        public j getHealthAuthorityBytes() {
            return ((d) this.instance).getHealthAuthorityBytes();
        }

        @Override // f.b.a.a.a.g0.e
        public int getPayloadSize() {
            return ((d) this.instance).getPayloadSize();
        }

        @Override // f.b.a.a.a.g0.e
        public c getRpcCallResult() {
            return ((d) this.instance).getRpcCallResult();
        }

        @Override // f.b.a.a.a.g0.e
        public EnumC0074d getRpcCallType() {
            return ((d) this.instance).getRpcCallType();
        }

        @Override // f.b.a.a.a.g0.e
        public boolean hasCount() {
            return ((d) this.instance).hasCount();
        }

        @Override // f.b.a.a.a.g0.e
        @Deprecated
        public boolean hasHealthAuthority() {
            return ((d) this.instance).hasHealthAuthority();
        }

        @Override // f.b.a.a.a.g0.e
        public boolean hasPayloadSize() {
            return ((d) this.instance).hasPayloadSize();
        }

        @Override // f.b.a.a.a.g0.e
        public boolean hasRpcCallResult() {
            return ((d) this.instance).hasRpcCallResult();
        }

        @Override // f.b.a.a.a.g0.e
        public boolean hasRpcCallType() {
            return ((d) this.instance).hasRpcCallType();
        }

        public b setCount(int i2) {
            copyOnWrite();
            ((d) this.instance).setCount(i2);
            return this;
        }

        @Deprecated
        public b setHealthAuthority(String str) {
            copyOnWrite();
            ((d) this.instance).setHealthAuthority(str);
            return this;
        }

        @Deprecated
        public b setHealthAuthorityBytes(j jVar) {
            copyOnWrite();
            ((d) this.instance).setHealthAuthorityBytes(jVar);
            return this;
        }

        public b setPayloadSize(int i2) {
            copyOnWrite();
            ((d) this.instance).setPayloadSize(i2);
            return this;
        }

        public b setRpcCallResult(c cVar) {
            copyOnWrite();
            ((d) this.instance).setRpcCallResult(cVar);
            return this;
        }

        public b setRpcCallType(EnumC0074d dVar) {
            copyOnWrite();
            ((d) this.instance).setRpcCallType(dVar);
            return this;
        }
    }

    public enum c implements c0.c {
        RESULT_FAILED_UNKNOWN(0),
        RESULT_SUCCESS(1),
        RESULT_FAILED_GENERIC_4XX(2),
        RESULT_FAILED_GENERIC_5XX(3),
        RESULT_FAILED_TIMEOUT(4),
        RESULT_FAILED_PARSING(5),
        RESULT_FAILED_NO_CONNECTION(6),
        RESULT_FAILED_NETWORK_ERROR(7);
        
        public static final int RESULT_FAILED_GENERIC_4XX_VALUE = 2;
        public static final int RESULT_FAILED_GENERIC_5XX_VALUE = 3;
        public static final int RESULT_FAILED_NETWORK_ERROR_VALUE = 7;
        public static final int RESULT_FAILED_NO_CONNECTION_VALUE = 6;
        public static final int RESULT_FAILED_PARSING_VALUE = 5;
        public static final int RESULT_FAILED_TIMEOUT_VALUE = 4;
        public static final int RESULT_FAILED_UNKNOWN_VALUE = 0;
        public static final int RESULT_SUCCESS_VALUE = 1;
        private static final c0.d<c> internalValueMap = new a();
        private final int value;

        public class a implements c0.d<c> {
            @Override // f.b.g.c0.d
            public c findValueByNumber(int i2) {
                return c.forNumber(i2);
            }
        }

        public static final class b implements c0.e {
            public static final c0.e INSTANCE = new b();

            private b() {
            }

            @Override // f.b.g.c0.e
            public boolean isInRange(int i2) {
                return c.forNumber(i2) != null;
            }
        }

        private c(int i2) {
            this.value = i2;
        }

        public static c forNumber(int i2) {
            switch (i2) {
                case 0:
                    return RESULT_FAILED_UNKNOWN;
                case 1:
                    return RESULT_SUCCESS;
                case 2:
                    return RESULT_FAILED_GENERIC_4XX;
                case 3:
                    return RESULT_FAILED_GENERIC_5XX;
                case 4:
                    return RESULT_FAILED_TIMEOUT;
                case 5:
                    return RESULT_FAILED_PARSING;
                case 6:
                    return RESULT_FAILED_NO_CONNECTION;
                case 7:
                    return RESULT_FAILED_NETWORK_ERROR;
                default:
                    return null;
            }
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

    /* renamed from: f.b.a.a.a.g0.d$d  reason: collision with other inner class name */
    public enum EnumC0074d implements c0.c {
        RPC_TYPE_UNKNOWN(0),
        RPC_TYPE_KEYS_DOWNLOAD(1),
        RPC_TYPE_KEYS_UPLOAD(2),
        RPC_TYPE_VERIFICATION(3),
        RPC_TYPE_ENPA_REMOTE_CONFIG_FETCH(4);
        
        public static final int RPC_TYPE_ENPA_REMOTE_CONFIG_FETCH_VALUE = 4;
        public static final int RPC_TYPE_KEYS_DOWNLOAD_VALUE = 1;
        public static final int RPC_TYPE_KEYS_UPLOAD_VALUE = 2;
        public static final int RPC_TYPE_UNKNOWN_VALUE = 0;
        public static final int RPC_TYPE_VERIFICATION_VALUE = 3;
        private static final c0.d<EnumC0074d> internalValueMap = new a();
        private final int value;

        /* renamed from: f.b.a.a.a.g0.d$d$a */
        public class a implements c0.d<EnumC0074d> {
            @Override // f.b.g.c0.d
            public EnumC0074d findValueByNumber(int i2) {
                return EnumC0074d.forNumber(i2);
            }
        }

        /* renamed from: f.b.a.a.a.g0.d$d$b */
        public static final class b implements c0.e {
            public static final c0.e INSTANCE = new b();

            private b() {
            }

            @Override // f.b.g.c0.e
            public boolean isInRange(int i2) {
                return EnumC0074d.forNumber(i2) != null;
            }
        }

        private EnumC0074d(int i2) {
            this.value = i2;
        }

        public static EnumC0074d forNumber(int i2) {
            if (i2 == 0) {
                return RPC_TYPE_UNKNOWN;
            }
            if (i2 == 1) {
                return RPC_TYPE_KEYS_DOWNLOAD;
            }
            if (i2 == 2) {
                return RPC_TYPE_KEYS_UPLOAD;
            }
            if (i2 == 3) {
                return RPC_TYPE_VERIFICATION;
            }
            if (i2 != 4) {
                return null;
            }
            return RPC_TYPE_ENPA_REMOTE_CONFIG_FETCH;
        }

        public static c0.d<EnumC0074d> internalGetValueMap() {
            return internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return b.INSTANCE;
        }

        @Deprecated
        public static EnumC0074d valueOf(int i2) {
            return forNumber(i2);
        }

        @Override // f.b.g.c0.c
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        z.registerDefaultInstance(d.class, dVar);
    }

    private d() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearCount() {
        this.bitField0_ &= -17;
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
    private void clearPayloadSize() {
        this.bitField0_ &= -9;
        this.payloadSize_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearRpcCallResult() {
        this.bitField0_ &= -5;
        this.rpcCallResult_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearRpcCallType() {
        this.bitField0_ &= -3;
        this.rpcCallType_ = 0;
    }

    public static d getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(d dVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(dVar);
    }

    public static d parseDelimitedFrom(InputStream inputStream) {
        return (d) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static d parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (d) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static d parseFrom(j jVar) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static d parseFrom(j jVar, r rVar) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static d parseFrom(k kVar) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static d parseFrom(k kVar, r rVar) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static d parseFrom(InputStream inputStream) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static d parseFrom(InputStream inputStream, r rVar) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static d parseFrom(ByteBuffer byteBuffer) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static d parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static d parseFrom(byte[] bArr) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static d parseFrom(byte[] bArr, r rVar) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<d> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setCount(int i2) {
        this.bitField0_ |= 16;
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
    private void setPayloadSize(int i2) {
        this.bitField0_ |= 8;
        this.payloadSize_ = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setRpcCallResult(c cVar) {
        this.rpcCallResult_ = cVar.getNumber();
        this.bitField0_ |= 4;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setRpcCallType(EnumC0074d dVar) {
        this.rpcCallType_ = dVar.getNumber();
        this.bitField0_ |= 2;
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\f\u0002\u0004\u0004\u0003\u0005\u0004\u0004", new Object[]{"bitField0_", "healthAuthority_", "rpcCallType_", EnumC0074d.internalGetVerifier(), "rpcCallResult_", c.internalGetVerifier(), "payloadSize_", "count_"});
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

    @Override // f.b.a.a.a.g0.e
    public int getCount() {
        return this.count_;
    }

    @Override // f.b.a.a.a.g0.e
    @Deprecated
    public String getHealthAuthority() {
        return this.healthAuthority_;
    }

    @Override // f.b.a.a.a.g0.e
    @Deprecated
    public j getHealthAuthorityBytes() {
        return j.n(this.healthAuthority_);
    }

    @Override // f.b.a.a.a.g0.e
    public int getPayloadSize() {
        return this.payloadSize_;
    }

    @Override // f.b.a.a.a.g0.e
    public c getRpcCallResult() {
        c forNumber = c.forNumber(this.rpcCallResult_);
        return forNumber == null ? c.RESULT_FAILED_UNKNOWN : forNumber;
    }

    @Override // f.b.a.a.a.g0.e
    public EnumC0074d getRpcCallType() {
        EnumC0074d forNumber = EnumC0074d.forNumber(this.rpcCallType_);
        return forNumber == null ? EnumC0074d.RPC_TYPE_UNKNOWN : forNumber;
    }

    @Override // f.b.a.a.a.g0.e
    public boolean hasCount() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // f.b.a.a.a.g0.e
    @Deprecated
    public boolean hasHealthAuthority() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // f.b.a.a.a.g0.e
    public boolean hasPayloadSize() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // f.b.a.a.a.g0.e
    public boolean hasRpcCallResult() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // f.b.a.a.a.g0.e
    public boolean hasRpcCallType() {
        return (this.bitField0_ & 2) != 0;
    }
}
