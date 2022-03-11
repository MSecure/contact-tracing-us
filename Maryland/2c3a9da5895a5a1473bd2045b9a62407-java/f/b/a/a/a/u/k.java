package f.b.a.a.a.u;

import f.b.f.b1;
import f.b.f.j;
import f.b.f.r;
import f.b.f.z;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class k extends z<k, b> implements l {
    private static final k DEFAULT_INSTANCE;
    private static volatile b1<k> PARSER = null;
    public static final int SIGNATURE_ALGORITHM_FIELD_NUMBER = 5;
    public static final int VERIFICATION_KEY_ID_FIELD_NUMBER = 4;
    public static final int VERIFICATION_KEY_VERSION_FIELD_NUMBER = 3;
    private int bitField0_;
    private String signatureAlgorithm_ = "";
    private String verificationKeyId_ = "";
    private String verificationKeyVersion_ = "";

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

    public static final class b extends z.a<k, b> implements l {
        private b() {
            super(k.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b clearSignatureAlgorithm() {
            copyOnWrite();
            ((k) this.instance).clearSignatureAlgorithm();
            return this;
        }

        public b clearVerificationKeyId() {
            copyOnWrite();
            ((k) this.instance).clearVerificationKeyId();
            return this;
        }

        public b clearVerificationKeyVersion() {
            copyOnWrite();
            ((k) this.instance).clearVerificationKeyVersion();
            return this;
        }

        @Override // f.b.a.a.a.u.l
        public String getSignatureAlgorithm() {
            return ((k) this.instance).getSignatureAlgorithm();
        }

        @Override // f.b.a.a.a.u.l
        public j getSignatureAlgorithmBytes() {
            return ((k) this.instance).getSignatureAlgorithmBytes();
        }

        @Override // f.b.a.a.a.u.l
        public String getVerificationKeyId() {
            return ((k) this.instance).getVerificationKeyId();
        }

        @Override // f.b.a.a.a.u.l
        public j getVerificationKeyIdBytes() {
            return ((k) this.instance).getVerificationKeyIdBytes();
        }

        @Override // f.b.a.a.a.u.l
        public String getVerificationKeyVersion() {
            return ((k) this.instance).getVerificationKeyVersion();
        }

        @Override // f.b.a.a.a.u.l
        public j getVerificationKeyVersionBytes() {
            return ((k) this.instance).getVerificationKeyVersionBytes();
        }

        @Override // f.b.a.a.a.u.l
        public boolean hasSignatureAlgorithm() {
            return ((k) this.instance).hasSignatureAlgorithm();
        }

        @Override // f.b.a.a.a.u.l
        public boolean hasVerificationKeyId() {
            return ((k) this.instance).hasVerificationKeyId();
        }

        @Override // f.b.a.a.a.u.l
        public boolean hasVerificationKeyVersion() {
            return ((k) this.instance).hasVerificationKeyVersion();
        }

        public b setSignatureAlgorithm(String str) {
            copyOnWrite();
            ((k) this.instance).setSignatureAlgorithm(str);
            return this;
        }

        public b setSignatureAlgorithmBytes(j jVar) {
            copyOnWrite();
            ((k) this.instance).setSignatureAlgorithmBytes(jVar);
            return this;
        }

        public b setVerificationKeyId(String str) {
            copyOnWrite();
            ((k) this.instance).setVerificationKeyId(str);
            return this;
        }

        public b setVerificationKeyIdBytes(j jVar) {
            copyOnWrite();
            ((k) this.instance).setVerificationKeyIdBytes(jVar);
            return this;
        }

        public b setVerificationKeyVersion(String str) {
            copyOnWrite();
            ((k) this.instance).setVerificationKeyVersion(str);
            return this;
        }

        public b setVerificationKeyVersionBytes(j jVar) {
            copyOnWrite();
            ((k) this.instance).setVerificationKeyVersionBytes(jVar);
            return this;
        }
    }

    static {
        k kVar = new k();
        DEFAULT_INSTANCE = kVar;
        z.registerDefaultInstance(k.class, kVar);
    }

    private k() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearSignatureAlgorithm() {
        this.bitField0_ &= -5;
        this.signatureAlgorithm_ = getDefaultInstance().getSignatureAlgorithm();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearVerificationKeyId() {
        this.bitField0_ &= -3;
        this.verificationKeyId_ = getDefaultInstance().getVerificationKeyId();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearVerificationKeyVersion() {
        this.bitField0_ &= -2;
        this.verificationKeyVersion_ = getDefaultInstance().getVerificationKeyVersion();
    }

    public static k getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(k kVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(kVar);
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

    public static k parseFrom(f.b.f.k kVar) {
        return (k) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static k parseFrom(f.b.f.k kVar, r rVar) {
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

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSignatureAlgorithm(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.signatureAlgorithm_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSignatureAlgorithmBytes(j jVar) {
        this.signatureAlgorithm_ = jVar.B();
        this.bitField0_ |= 4;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setVerificationKeyId(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.verificationKeyId_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setVerificationKeyIdBytes(j jVar) {
        this.verificationKeyId_ = jVar.B();
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setVerificationKeyVersion(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.verificationKeyVersion_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setVerificationKeyVersionBytes(j jVar) {
        this.verificationKeyVersion_ = jVar.B();
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0003\u0005\u0003\u0000\u0000\u0000\u0003\b\u0000\u0004\b\u0001\u0005\b\u0002", new Object[]{"bitField0_", "verificationKeyVersion_", "verificationKeyId_", "signatureAlgorithm_"});
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

    @Override // f.b.a.a.a.u.l
    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm_;
    }

    @Override // f.b.a.a.a.u.l
    public j getSignatureAlgorithmBytes() {
        return j.n(this.signatureAlgorithm_);
    }

    @Override // f.b.a.a.a.u.l
    public String getVerificationKeyId() {
        return this.verificationKeyId_;
    }

    @Override // f.b.a.a.a.u.l
    public j getVerificationKeyIdBytes() {
        return j.n(this.verificationKeyId_);
    }

    @Override // f.b.a.a.a.u.l
    public String getVerificationKeyVersion() {
        return this.verificationKeyVersion_;
    }

    @Override // f.b.a.a.a.u.l
    public j getVerificationKeyVersionBytes() {
        return j.n(this.verificationKeyVersion_);
    }

    @Override // f.b.a.a.a.u.l
    public boolean hasSignatureAlgorithm() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // f.b.a.a.a.u.l
    public boolean hasVerificationKeyId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // f.b.a.a.a.u.l
    public boolean hasVerificationKeyVersion() {
        return (this.bitField0_ & 1) != 0;
    }
}
