package f.b.a.a.a.u;

import f.b.f.b1;
import f.b.f.c0;
import f.b.f.j;
import f.b.f.k;
import f.b.f.r;
import f.b.f.z;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class h extends z<h, b> implements Object {
    private static final h DEFAULT_INSTANCE;
    public static final int ERROR_DETAILS_FIELD_NUMBER = 2;
    private static volatile b1<h> PARSER = null;
    public static final int STATUS_CODE_FIELD_NUMBER = 1;
    private int bitField0_;
    private String errorDetails_ = "";
    private int statusCode_;

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

    public static final class b extends z.a<h, b> implements Object {
        private b() {
            super(h.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b clearErrorDetails() {
            copyOnWrite();
            ((h) this.instance).clearErrorDetails();
            return this;
        }

        public b clearStatusCode() {
            copyOnWrite();
            ((h) this.instance).clearStatusCode();
            return this;
        }

        public String getErrorDetails() {
            return ((h) this.instance).getErrorDetails();
        }

        public j getErrorDetailsBytes() {
            return ((h) this.instance).getErrorDetailsBytes();
        }

        public c getStatusCode() {
            return ((h) this.instance).getStatusCode();
        }

        public boolean hasErrorDetails() {
            return ((h) this.instance).hasErrorDetails();
        }

        public boolean hasStatusCode() {
            return ((h) this.instance).hasStatusCode();
        }

        public b setErrorDetails(String str) {
            copyOnWrite();
            ((h) this.instance).setErrorDetails(str);
            return this;
        }

        public b setErrorDetailsBytes(j jVar) {
            copyOnWrite();
            ((h) this.instance).setErrorDetailsBytes(jVar);
            return this;
        }

        public b setStatusCode(c cVar) {
            copyOnWrite();
            ((h) this.instance).setStatusCode(cVar);
            return this;
        }
    }

    public enum c implements c0.c {
        UNKNOWN_FAILURE(0),
        OK(1),
        CANCELLED_FAILURE(2),
        INVALID_PARAMETER_FAILURE(3),
        LIBRARY_UNAVAILABLE(4);
        
        public static final int CANCELLED_FAILURE_VALUE = 2;
        public static final int INVALID_PARAMETER_FAILURE_VALUE = 3;
        public static final int LIBRARY_UNAVAILABLE_VALUE = 4;
        public static final int OK_VALUE = 1;
        public static final int UNKNOWN_FAILURE_VALUE = 0;
        private static final c0.d<c> internalValueMap = new a();
        private final int value;

        public class a implements c0.d<c> {
            @Override // f.b.f.c0.d
            public c findValueByNumber(int i2) {
                return c.forNumber(i2);
            }
        }

        public static final class b implements c0.e {
            public static final c0.e INSTANCE = new b();

            private b() {
            }

            @Override // f.b.f.c0.e
            public boolean isInRange(int i2) {
                return c.forNumber(i2) != null;
            }
        }

        private c(int i2) {
            this.value = i2;
        }

        public static c forNumber(int i2) {
            if (i2 == 0) {
                return UNKNOWN_FAILURE;
            }
            if (i2 == 1) {
                return OK;
            }
            if (i2 == 2) {
                return CANCELLED_FAILURE;
            }
            if (i2 == 3) {
                return INVALID_PARAMETER_FAILURE;
            }
            if (i2 != 4) {
                return null;
            }
            return LIBRARY_UNAVAILABLE;
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

        @Override // f.b.f.c0.c
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        z.registerDefaultInstance(h.class, hVar);
    }

    private h() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearErrorDetails() {
        this.bitField0_ &= -3;
        this.errorDetails_ = getDefaultInstance().getErrorDetails();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearStatusCode() {
        this.bitField0_ &= -2;
        this.statusCode_ = 0;
    }

    public static h getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(h hVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(hVar);
    }

    public static h parseDelimitedFrom(InputStream inputStream) {
        return (h) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static h parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (h) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static h parseFrom(j jVar) {
        return (h) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static h parseFrom(j jVar, r rVar) {
        return (h) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static h parseFrom(k kVar) {
        return (h) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static h parseFrom(k kVar, r rVar) {
        return (h) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static h parseFrom(InputStream inputStream) {
        return (h) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static h parseFrom(InputStream inputStream, r rVar) {
        return (h) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static h parseFrom(ByteBuffer byteBuffer) {
        return (h) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static h parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (h) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static h parseFrom(byte[] bArr) {
        return (h) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static h parseFrom(byte[] bArr, r rVar) {
        return (h) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<h> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setErrorDetails(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.errorDetails_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setErrorDetailsBytes(j jVar) {
        this.errorDetails_ = jVar.B();
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setStatusCode(c cVar) {
        this.statusCode_ = cVar.getNumber();
        this.bitField0_ |= 1;
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001", new Object[]{"bitField0_", "statusCode_", c.internalGetVerifier(), "errorDetails_"});
            case 3:
                return new h();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<h> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (h.class) {
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

    public String getErrorDetails() {
        return this.errorDetails_;
    }

    public j getErrorDetailsBytes() {
        return j.n(this.errorDetails_);
    }

    public c getStatusCode() {
        c forNumber = c.forNumber(this.statusCode_);
        return forNumber == null ? c.UNKNOWN_FAILURE : forNumber;
    }

    public boolean hasErrorDetails() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasStatusCode() {
        return (this.bitField0_ & 1) != 0;
    }
}
