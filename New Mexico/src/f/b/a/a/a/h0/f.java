package f.b.a.a.a.h0;

import f.b.g.b1;
import f.b.g.j;
import f.b.g.k;
import f.b.g.r;
import f.b.g.z;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class f extends z<f, b> implements g {
    private static final f DEFAULT_INSTANCE;
    private static volatile b1<f> PARSER;
    public static final int SIGNATURE_ALGORITHM_FIELD_NUMBER;
    public static final int VERIFICATION_KEY_ID_FIELD_NUMBER;
    public static final int VERIFICATION_KEY_VERSION_FIELD_NUMBER;
    private int bitField0_;
    private String verificationKeyVersion_ = "";
    private String verificationKeyId_ = "";
    private String signatureAlgorithm_ = "";

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
    public static final class b extends z.a<f, b> implements g {
        private b() {
            super(f.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b clearSignatureAlgorithm() {
            copyOnWrite();
            ((f) this.instance).clearSignatureAlgorithm();
            return this;
        }

        public b clearVerificationKeyId() {
            copyOnWrite();
            ((f) this.instance).clearVerificationKeyId();
            return this;
        }

        public b clearVerificationKeyVersion() {
            copyOnWrite();
            ((f) this.instance).clearVerificationKeyVersion();
            return this;
        }

        @Override // f.b.a.a.a.h0.g
        public String getSignatureAlgorithm() {
            return ((f) this.instance).getSignatureAlgorithm();
        }

        @Override // f.b.a.a.a.h0.g
        public j getSignatureAlgorithmBytes() {
            return ((f) this.instance).getSignatureAlgorithmBytes();
        }

        @Override // f.b.a.a.a.h0.g
        public String getVerificationKeyId() {
            return ((f) this.instance).getVerificationKeyId();
        }

        @Override // f.b.a.a.a.h0.g
        public j getVerificationKeyIdBytes() {
            return ((f) this.instance).getVerificationKeyIdBytes();
        }

        @Override // f.b.a.a.a.h0.g
        public String getVerificationKeyVersion() {
            return ((f) this.instance).getVerificationKeyVersion();
        }

        @Override // f.b.a.a.a.h0.g
        public j getVerificationKeyVersionBytes() {
            return ((f) this.instance).getVerificationKeyVersionBytes();
        }

        @Override // f.b.a.a.a.h0.g
        public boolean hasSignatureAlgorithm() {
            return ((f) this.instance).hasSignatureAlgorithm();
        }

        @Override // f.b.a.a.a.h0.g
        public boolean hasVerificationKeyId() {
            return ((f) this.instance).hasVerificationKeyId();
        }

        @Override // f.b.a.a.a.h0.g
        public boolean hasVerificationKeyVersion() {
            return ((f) this.instance).hasVerificationKeyVersion();
        }

        public b setSignatureAlgorithm(String str) {
            copyOnWrite();
            ((f) this.instance).setSignatureAlgorithm(str);
            return this;
        }

        public b setSignatureAlgorithmBytes(j jVar) {
            copyOnWrite();
            ((f) this.instance).setSignatureAlgorithmBytes(jVar);
            return this;
        }

        public b setVerificationKeyId(String str) {
            copyOnWrite();
            ((f) this.instance).setVerificationKeyId(str);
            return this;
        }

        public b setVerificationKeyIdBytes(j jVar) {
            copyOnWrite();
            ((f) this.instance).setVerificationKeyIdBytes(jVar);
            return this;
        }

        public b setVerificationKeyVersion(String str) {
            copyOnWrite();
            ((f) this.instance).setVerificationKeyVersion(str);
            return this;
        }

        public b setVerificationKeyVersionBytes(j jVar) {
            copyOnWrite();
            ((f) this.instance).setVerificationKeyVersionBytes(jVar);
            return this;
        }
    }

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        z.registerDefaultInstance(f.class, fVar);
    }

    private f() {
    }

    public void clearSignatureAlgorithm() {
        this.bitField0_ &= -5;
        this.signatureAlgorithm_ = getDefaultInstance().getSignatureAlgorithm();
    }

    public void clearVerificationKeyId() {
        this.bitField0_ &= -3;
        this.verificationKeyId_ = getDefaultInstance().getVerificationKeyId();
    }

    public void clearVerificationKeyVersion() {
        this.bitField0_ &= -2;
        this.verificationKeyVersion_ = getDefaultInstance().getVerificationKeyVersion();
    }

    public static f getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(f fVar) {
        return DEFAULT_INSTANCE.createBuilder(fVar);
    }

    public static f parseDelimitedFrom(InputStream inputStream) {
        return (f) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static f parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (f) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static f parseFrom(j jVar) {
        return (f) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static f parseFrom(j jVar, r rVar) {
        return (f) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static f parseFrom(k kVar) {
        return (f) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static f parseFrom(k kVar, r rVar) {
        return (f) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static f parseFrom(InputStream inputStream) {
        return (f) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static f parseFrom(InputStream inputStream, r rVar) {
        return (f) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static f parseFrom(ByteBuffer byteBuffer) {
        return (f) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static f parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (f) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static f parseFrom(byte[] bArr) {
        return (f) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static f parseFrom(byte[] bArr, r rVar) {
        return (f) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<f> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    public void setSignatureAlgorithm(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.signatureAlgorithm_ = str;
    }

    public void setSignatureAlgorithmBytes(j jVar) {
        this.signatureAlgorithm_ = jVar.B();
        this.bitField0_ |= 4;
    }

    public void setVerificationKeyId(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.verificationKeyId_ = str;
    }

    public void setVerificationKeyIdBytes(j jVar) {
        this.verificationKeyId_ = jVar.B();
        this.bitField0_ |= 2;
    }

    public void setVerificationKeyVersion(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.verificationKeyVersion_ = str;
    }

    public void setVerificationKeyVersionBytes(j jVar) {
        this.verificationKeyVersion_ = jVar.B();
        this.bitField0_ |= 1;
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0003\u0005\u0003\u0000\u0000\u0000\u0003\b\u0000\u0004\b\u0001\u0005\b\u0002", new Object[]{"bitField0_", "verificationKeyVersion_", "verificationKeyId_", "signatureAlgorithm_"});
            case 3:
                return new f();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<f> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (f.class) {
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

    @Override // f.b.a.a.a.h0.g
    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm_;
    }

    @Override // f.b.a.a.a.h0.g
    public j getSignatureAlgorithmBytes() {
        return j.n(this.signatureAlgorithm_);
    }

    @Override // f.b.a.a.a.h0.g
    public String getVerificationKeyId() {
        return this.verificationKeyId_;
    }

    @Override // f.b.a.a.a.h0.g
    public j getVerificationKeyIdBytes() {
        return j.n(this.verificationKeyId_);
    }

    @Override // f.b.a.a.a.h0.g
    public String getVerificationKeyVersion() {
        return this.verificationKeyVersion_;
    }

    @Override // f.b.a.a.a.h0.g
    public j getVerificationKeyVersionBytes() {
        return j.n(this.verificationKeyVersion_);
    }

    @Override // f.b.a.a.a.h0.g
    public boolean hasSignatureAlgorithm() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // f.b.a.a.a.h0.g
    public boolean hasVerificationKeyId() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // f.b.a.a.a.h0.g
    public boolean hasVerificationKeyVersion() {
        return (this.bitField0_ & 1) != 0;
    }
}
