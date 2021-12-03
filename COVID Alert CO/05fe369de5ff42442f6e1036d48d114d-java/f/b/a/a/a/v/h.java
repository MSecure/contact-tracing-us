package f.b.a.a.a.v;

import f.b.a.a.a.v.f;
import f.b.g.b1;
import f.b.g.j;
import f.b.g.k;
import f.b.g.r;
import f.b.g.z;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class h extends z<h, b> implements j {
    public static final int BATCH_NUM_FIELD_NUMBER = 2;
    public static final int BATCH_SIZE_FIELD_NUMBER = 3;
    private static final h DEFAULT_INSTANCE;
    private static volatile b1<h> PARSER = null;
    public static final int SIGNATURE_FIELD_NUMBER = 4;
    public static final int SIGNATURE_INFO_FIELD_NUMBER = 1;
    private int batchNum_;
    private int batchSize_;
    private int bitField0_;
    private f signatureInfo_;
    private j signature_ = j.c;

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

    public static final class b extends z.a<h, b> implements j {
        private b() {
            super(h.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b clearBatchNum() {
            copyOnWrite();
            ((h) this.instance).clearBatchNum();
            return this;
        }

        public b clearBatchSize() {
            copyOnWrite();
            ((h) this.instance).clearBatchSize();
            return this;
        }

        public b clearSignature() {
            copyOnWrite();
            ((h) this.instance).clearSignature();
            return this;
        }

        public b clearSignatureInfo() {
            copyOnWrite();
            ((h) this.instance).clearSignatureInfo();
            return this;
        }

        @Override // f.b.a.a.a.v.j
        public int getBatchNum() {
            return ((h) this.instance).getBatchNum();
        }

        @Override // f.b.a.a.a.v.j
        public int getBatchSize() {
            return ((h) this.instance).getBatchSize();
        }

        @Override // f.b.a.a.a.v.j
        public j getSignature() {
            return ((h) this.instance).getSignature();
        }

        @Override // f.b.a.a.a.v.j
        public f getSignatureInfo() {
            return ((h) this.instance).getSignatureInfo();
        }

        @Override // f.b.a.a.a.v.j
        public boolean hasBatchNum() {
            return ((h) this.instance).hasBatchNum();
        }

        @Override // f.b.a.a.a.v.j
        public boolean hasBatchSize() {
            return ((h) this.instance).hasBatchSize();
        }

        @Override // f.b.a.a.a.v.j
        public boolean hasSignature() {
            return ((h) this.instance).hasSignature();
        }

        @Override // f.b.a.a.a.v.j
        public boolean hasSignatureInfo() {
            return ((h) this.instance).hasSignatureInfo();
        }

        public b mergeSignatureInfo(f fVar) {
            copyOnWrite();
            ((h) this.instance).mergeSignatureInfo(fVar);
            return this;
        }

        public b setBatchNum(int i2) {
            copyOnWrite();
            ((h) this.instance).setBatchNum(i2);
            return this;
        }

        public b setBatchSize(int i2) {
            copyOnWrite();
            ((h) this.instance).setBatchSize(i2);
            return this;
        }

        public b setSignature(j jVar) {
            copyOnWrite();
            ((h) this.instance).setSignature(jVar);
            return this;
        }

        public b setSignatureInfo(f.b bVar) {
            copyOnWrite();
            ((h) this.instance).setSignatureInfo((f) bVar.build());
            return this;
        }

        public b setSignatureInfo(f fVar) {
            copyOnWrite();
            ((h) this.instance).setSignatureInfo(fVar);
            return this;
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
    private void clearBatchNum() {
        this.bitField0_ &= -3;
        this.batchNum_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearBatchSize() {
        this.bitField0_ &= -5;
        this.batchSize_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearSignature() {
        this.bitField0_ &= -9;
        this.signature_ = getDefaultInstance().getSignature();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearSignatureInfo() {
        this.signatureInfo_ = null;
        this.bitField0_ &= -2;
    }

    public static h getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mergeSignatureInfo(f fVar) {
        fVar.getClass();
        f fVar2 = this.signatureInfo_;
        if (!(fVar2 == null || fVar2 == f.getDefaultInstance())) {
            fVar = (f) ((f.b) f.newBuilder(this.signatureInfo_).mergeFrom((z) fVar)).buildPartial();
        }
        this.signatureInfo_ = fVar;
        this.bitField0_ |= 1;
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
    private void setBatchNum(int i2) {
        this.bitField0_ |= 2;
        this.batchNum_ = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setBatchSize(int i2) {
        this.bitField0_ |= 4;
        this.batchSize_ = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSignature(j jVar) {
        jVar.getClass();
        this.bitField0_ |= 8;
        this.signature_ = jVar;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSignatureInfo(f fVar) {
        fVar.getClass();
        this.signatureInfo_ = fVar;
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\n\u0003", new Object[]{"bitField0_", "signatureInfo_", "batchNum_", "batchSize_", "signature_"});
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

    @Override // f.b.a.a.a.v.j
    public int getBatchNum() {
        return this.batchNum_;
    }

    @Override // f.b.a.a.a.v.j
    public int getBatchSize() {
        return this.batchSize_;
    }

    @Override // f.b.a.a.a.v.j
    public j getSignature() {
        return this.signature_;
    }

    @Override // f.b.a.a.a.v.j
    public f getSignatureInfo() {
        f fVar = this.signatureInfo_;
        return fVar == null ? f.getDefaultInstance() : fVar;
    }

    @Override // f.b.a.a.a.v.j
    public boolean hasBatchNum() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // f.b.a.a.a.v.j
    public boolean hasBatchSize() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // f.b.a.a.a.v.j
    public boolean hasSignature() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // f.b.a.a.a.v.j
    public boolean hasSignatureInfo() {
        return (this.bitField0_ & 1) != 0;
    }
}
