package f.b.a.a.a.s;

import f.b.a.a.a.s.k;
import f.b.f.b1;
import f.b.f.j;
import f.b.f.r;
import f.b.f.z;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class m extends z<m, b> implements o {
    public static final int BATCH_NUM_FIELD_NUMBER = 2;
    public static final int BATCH_SIZE_FIELD_NUMBER = 3;
    private static final m DEFAULT_INSTANCE;
    private static volatile b1<m> PARSER = null;
    public static final int SIGNATURE_FIELD_NUMBER = 4;
    public static final int SIGNATURE_INFO_FIELD_NUMBER = 1;
    private int batchNum_;
    private int batchSize_;
    private int bitField0_;
    private k signatureInfo_;
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

    public static final class b extends z.a<m, b> implements o {
        private b() {
            super(m.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b clearBatchNum() {
            copyOnWrite();
            ((m) this.instance).clearBatchNum();
            return this;
        }

        public b clearBatchSize() {
            copyOnWrite();
            ((m) this.instance).clearBatchSize();
            return this;
        }

        public b clearSignature() {
            copyOnWrite();
            ((m) this.instance).clearSignature();
            return this;
        }

        public b clearSignatureInfo() {
            copyOnWrite();
            ((m) this.instance).clearSignatureInfo();
            return this;
        }

        @Override // f.b.a.a.a.s.o
        public int getBatchNum() {
            return ((m) this.instance).getBatchNum();
        }

        @Override // f.b.a.a.a.s.o
        public int getBatchSize() {
            return ((m) this.instance).getBatchSize();
        }

        @Override // f.b.a.a.a.s.o
        public j getSignature() {
            return ((m) this.instance).getSignature();
        }

        @Override // f.b.a.a.a.s.o
        public k getSignatureInfo() {
            return ((m) this.instance).getSignatureInfo();
        }

        @Override // f.b.a.a.a.s.o
        public boolean hasBatchNum() {
            return ((m) this.instance).hasBatchNum();
        }

        @Override // f.b.a.a.a.s.o
        public boolean hasBatchSize() {
            return ((m) this.instance).hasBatchSize();
        }

        @Override // f.b.a.a.a.s.o
        public boolean hasSignature() {
            return ((m) this.instance).hasSignature();
        }

        @Override // f.b.a.a.a.s.o
        public boolean hasSignatureInfo() {
            return ((m) this.instance).hasSignatureInfo();
        }

        public b mergeSignatureInfo(k kVar) {
            copyOnWrite();
            ((m) this.instance).mergeSignatureInfo(kVar);
            return this;
        }

        public b setBatchNum(int i2) {
            copyOnWrite();
            ((m) this.instance).setBatchNum(i2);
            return this;
        }

        public b setBatchSize(int i2) {
            copyOnWrite();
            ((m) this.instance).setBatchSize(i2);
            return this;
        }

        public b setSignature(j jVar) {
            copyOnWrite();
            ((m) this.instance).setSignature(jVar);
            return this;
        }

        public b setSignatureInfo(k.b bVar) {
            copyOnWrite();
            ((m) this.instance).setSignatureInfo((k) bVar.build());
            return this;
        }

        public b setSignatureInfo(k kVar) {
            copyOnWrite();
            ((m) this.instance).setSignatureInfo(kVar);
            return this;
        }
    }

    static {
        m mVar = new m();
        DEFAULT_INSTANCE = mVar;
        z.registerDefaultInstance(m.class, mVar);
    }

    private m() {
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

    public static m getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mergeSignatureInfo(k kVar) {
        kVar.getClass();
        k kVar2 = this.signatureInfo_;
        if (!(kVar2 == null || kVar2 == k.getDefaultInstance())) {
            kVar = (k) ((k.b) k.newBuilder(this.signatureInfo_).mergeFrom((z) kVar)).buildPartial();
        }
        this.signatureInfo_ = kVar;
        this.bitField0_ |= 1;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(m mVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(mVar);
    }

    public static m parseDelimitedFrom(InputStream inputStream) {
        return (m) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static m parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (m) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static m parseFrom(j jVar) {
        return (m) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static m parseFrom(j jVar, r rVar) {
        return (m) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static m parseFrom(f.b.f.k kVar) {
        return (m) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static m parseFrom(f.b.f.k kVar, r rVar) {
        return (m) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static m parseFrom(InputStream inputStream) {
        return (m) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static m parseFrom(InputStream inputStream, r rVar) {
        return (m) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static m parseFrom(ByteBuffer byteBuffer) {
        return (m) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static m parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (m) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static m parseFrom(byte[] bArr) {
        return (m) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static m parseFrom(byte[] bArr, r rVar) {
        return (m) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<m> parser() {
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
    private void setSignatureInfo(k kVar) {
        kVar.getClass();
        this.signatureInfo_ = kVar;
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\u0004\u0001\u0003\u0004\u0002\u0004\n\u0003", new Object[]{"bitField0_", "signatureInfo_", "batchNum_", "batchSize_", "signature_"});
            case 3:
                return new m();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<m> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (m.class) {
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

    @Override // f.b.a.a.a.s.o
    public int getBatchNum() {
        return this.batchNum_;
    }

    @Override // f.b.a.a.a.s.o
    public int getBatchSize() {
        return this.batchSize_;
    }

    @Override // f.b.a.a.a.s.o
    public j getSignature() {
        return this.signature_;
    }

    @Override // f.b.a.a.a.s.o
    public k getSignatureInfo() {
        k kVar = this.signatureInfo_;
        return kVar == null ? k.getDefaultInstance() : kVar;
    }

    @Override // f.b.a.a.a.s.o
    public boolean hasBatchNum() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // f.b.a.a.a.s.o
    public boolean hasBatchSize() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // f.b.a.a.a.s.o
    public boolean hasSignature() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // f.b.a.a.a.s.o
    public boolean hasSignatureInfo() {
        return (this.bitField0_ & 1) != 0;
    }
}
