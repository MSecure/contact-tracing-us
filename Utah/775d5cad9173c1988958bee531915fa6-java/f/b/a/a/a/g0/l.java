package f.b.a.a.a.g0;

import f.b.a.a.a.g0.f;
import f.b.a.a.a.g0.k;
import f.b.g.b1;
import f.b.g.c0;
import f.b.g.j;
import f.b.g.r;
import f.b.g.z;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class l extends z<l, b> implements Object {
    public static final int BATCH_NUM_FIELD_NUMBER = 4;
    public static final int BATCH_SIZE_FIELD_NUMBER = 5;
    private static final l DEFAULT_INSTANCE;
    public static final int END_TIMESTAMP_FIELD_NUMBER = 2;
    public static final int KEYS_FIELD_NUMBER = 7;
    private static volatile b1<l> PARSER = null;
    public static final int REGION_FIELD_NUMBER = 3;
    public static final int SIGNATURE_INFOS_FIELD_NUMBER = 6;
    public static final int START_TIMESTAMP_FIELD_NUMBER = 1;
    private int batchNum_;
    private int batchSize_;
    private int bitField0_;
    private long endTimestamp_;
    private c0.i<k> keys_ = z.emptyProtobufList();
    private String region_ = "";
    private c0.i<f> signatureInfos_ = z.emptyProtobufList();
    private long startTimestamp_;

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

    public static final class b extends z.a<l, b> implements Object {
        private b() {
            super(l.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b addAllKeys(Iterable<? extends k> iterable) {
            copyOnWrite();
            ((l) this.instance).addAllKeys(iterable);
            return this;
        }

        public b addAllSignatureInfos(Iterable<? extends f> iterable) {
            copyOnWrite();
            ((l) this.instance).addAllSignatureInfos(iterable);
            return this;
        }

        public b addKeys(int i2, k.b bVar) {
            copyOnWrite();
            ((l) this.instance).addKeys(i2, (k) bVar.build());
            return this;
        }

        public b addKeys(int i2, k kVar) {
            copyOnWrite();
            ((l) this.instance).addKeys(i2, kVar);
            return this;
        }

        public b addKeys(k.b bVar) {
            copyOnWrite();
            ((l) this.instance).addKeys((k) bVar.build());
            return this;
        }

        public b addKeys(k kVar) {
            copyOnWrite();
            ((l) this.instance).addKeys(kVar);
            return this;
        }

        public b addSignatureInfos(int i2, f.b bVar) {
            copyOnWrite();
            ((l) this.instance).addSignatureInfos(i2, (f) bVar.build());
            return this;
        }

        public b addSignatureInfos(int i2, f fVar) {
            copyOnWrite();
            ((l) this.instance).addSignatureInfos(i2, fVar);
            return this;
        }

        public b addSignatureInfos(f.b bVar) {
            copyOnWrite();
            ((l) this.instance).addSignatureInfos((f) bVar.build());
            return this;
        }

        public b addSignatureInfos(f fVar) {
            copyOnWrite();
            ((l) this.instance).addSignatureInfos(fVar);
            return this;
        }

        public b clearBatchNum() {
            copyOnWrite();
            ((l) this.instance).clearBatchNum();
            return this;
        }

        public b clearBatchSize() {
            copyOnWrite();
            ((l) this.instance).clearBatchSize();
            return this;
        }

        public b clearEndTimestamp() {
            copyOnWrite();
            ((l) this.instance).clearEndTimestamp();
            return this;
        }

        public b clearKeys() {
            copyOnWrite();
            ((l) this.instance).clearKeys();
            return this;
        }

        public b clearRegion() {
            copyOnWrite();
            ((l) this.instance).clearRegion();
            return this;
        }

        public b clearSignatureInfos() {
            copyOnWrite();
            ((l) this.instance).clearSignatureInfos();
            return this;
        }

        public b clearStartTimestamp() {
            copyOnWrite();
            ((l) this.instance).clearStartTimestamp();
            return this;
        }

        public int getBatchNum() {
            return ((l) this.instance).getBatchNum();
        }

        public int getBatchSize() {
            return ((l) this.instance).getBatchSize();
        }

        public long getEndTimestamp() {
            return ((l) this.instance).getEndTimestamp();
        }

        public k getKeys(int i2) {
            return ((l) this.instance).getKeys(i2);
        }

        public int getKeysCount() {
            return ((l) this.instance).getKeysCount();
        }

        public List<k> getKeysList() {
            return Collections.unmodifiableList(((l) this.instance).getKeysList());
        }

        public String getRegion() {
            return ((l) this.instance).getRegion();
        }

        public j getRegionBytes() {
            return ((l) this.instance).getRegionBytes();
        }

        public f getSignatureInfos(int i2) {
            return ((l) this.instance).getSignatureInfos(i2);
        }

        public int getSignatureInfosCount() {
            return ((l) this.instance).getSignatureInfosCount();
        }

        public List<f> getSignatureInfosList() {
            return Collections.unmodifiableList(((l) this.instance).getSignatureInfosList());
        }

        public long getStartTimestamp() {
            return ((l) this.instance).getStartTimestamp();
        }

        public boolean hasBatchNum() {
            return ((l) this.instance).hasBatchNum();
        }

        public boolean hasBatchSize() {
            return ((l) this.instance).hasBatchSize();
        }

        public boolean hasEndTimestamp() {
            return ((l) this.instance).hasEndTimestamp();
        }

        public boolean hasRegion() {
            return ((l) this.instance).hasRegion();
        }

        public boolean hasStartTimestamp() {
            return ((l) this.instance).hasStartTimestamp();
        }

        public b removeKeys(int i2) {
            copyOnWrite();
            ((l) this.instance).removeKeys(i2);
            return this;
        }

        public b removeSignatureInfos(int i2) {
            copyOnWrite();
            ((l) this.instance).removeSignatureInfos(i2);
            return this;
        }

        public b setBatchNum(int i2) {
            copyOnWrite();
            ((l) this.instance).setBatchNum(i2);
            return this;
        }

        public b setBatchSize(int i2) {
            copyOnWrite();
            ((l) this.instance).setBatchSize(i2);
            return this;
        }

        public b setEndTimestamp(long j2) {
            copyOnWrite();
            ((l) this.instance).setEndTimestamp(j2);
            return this;
        }

        public b setKeys(int i2, k.b bVar) {
            copyOnWrite();
            ((l) this.instance).setKeys(i2, (k) bVar.build());
            return this;
        }

        public b setKeys(int i2, k kVar) {
            copyOnWrite();
            ((l) this.instance).setKeys(i2, kVar);
            return this;
        }

        public b setRegion(String str) {
            copyOnWrite();
            ((l) this.instance).setRegion(str);
            return this;
        }

        public b setRegionBytes(j jVar) {
            copyOnWrite();
            ((l) this.instance).setRegionBytes(jVar);
            return this;
        }

        public b setSignatureInfos(int i2, f.b bVar) {
            copyOnWrite();
            ((l) this.instance).setSignatureInfos(i2, (f) bVar.build());
            return this;
        }

        public b setSignatureInfos(int i2, f fVar) {
            copyOnWrite();
            ((l) this.instance).setSignatureInfos(i2, fVar);
            return this;
        }

        public b setStartTimestamp(long j2) {
            copyOnWrite();
            ((l) this.instance).setStartTimestamp(j2);
            return this;
        }
    }

    static {
        l lVar = new l();
        DEFAULT_INSTANCE = lVar;
        z.registerDefaultInstance(l.class, lVar);
    }

    private l() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllKeys(Iterable<? extends k> iterable) {
        ensureKeysIsMutable();
        f.b.g.a.addAll((Iterable) iterable, (List) this.keys_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllSignatureInfos(Iterable<? extends f> iterable) {
        ensureSignatureInfosIsMutable();
        f.b.g.a.addAll((Iterable) iterable, (List) this.signatureInfos_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addKeys(int i2, k kVar) {
        kVar.getClass();
        ensureKeysIsMutable();
        this.keys_.add(i2, kVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addKeys(k kVar) {
        kVar.getClass();
        ensureKeysIsMutable();
        this.keys_.add(kVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addSignatureInfos(int i2, f fVar) {
        fVar.getClass();
        ensureSignatureInfosIsMutable();
        this.signatureInfos_.add(i2, fVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addSignatureInfos(f fVar) {
        fVar.getClass();
        ensureSignatureInfosIsMutable();
        this.signatureInfos_.add(fVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearBatchNum() {
        this.bitField0_ &= -9;
        this.batchNum_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearBatchSize() {
        this.bitField0_ &= -17;
        this.batchSize_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearEndTimestamp() {
        this.bitField0_ &= -3;
        this.endTimestamp_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearKeys() {
        this.keys_ = z.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearRegion() {
        this.bitField0_ &= -5;
        this.region_ = getDefaultInstance().getRegion();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearSignatureInfos() {
        this.signatureInfos_ = z.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearStartTimestamp() {
        this.bitField0_ &= -2;
        this.startTimestamp_ = 0;
    }

    private void ensureKeysIsMutable() {
        if (!this.keys_.g()) {
            this.keys_ = z.mutableCopy(this.keys_);
        }
    }

    private void ensureSignatureInfosIsMutable() {
        if (!this.signatureInfos_.g()) {
            this.signatureInfos_ = z.mutableCopy(this.signatureInfos_);
        }
    }

    public static l getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(l lVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(lVar);
    }

    public static l parseDelimitedFrom(InputStream inputStream) {
        return (l) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static l parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (l) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static l parseFrom(j jVar) {
        return (l) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static l parseFrom(j jVar, r rVar) {
        return (l) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static l parseFrom(f.b.g.k kVar) {
        return (l) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static l parseFrom(f.b.g.k kVar, r rVar) {
        return (l) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static l parseFrom(InputStream inputStream) {
        return (l) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static l parseFrom(InputStream inputStream, r rVar) {
        return (l) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static l parseFrom(ByteBuffer byteBuffer) {
        return (l) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static l parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (l) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static l parseFrom(byte[] bArr) {
        return (l) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static l parseFrom(byte[] bArr, r rVar) {
        return (l) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<l> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeKeys(int i2) {
        ensureKeysIsMutable();
        this.keys_.remove(i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeSignatureInfos(int i2) {
        ensureSignatureInfosIsMutable();
        this.signatureInfos_.remove(i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setBatchNum(int i2) {
        this.bitField0_ |= 8;
        this.batchNum_ = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setBatchSize(int i2) {
        this.bitField0_ |= 16;
        this.batchSize_ = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setEndTimestamp(long j2) {
        this.bitField0_ |= 2;
        this.endTimestamp_ = j2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setKeys(int i2, k kVar) {
        kVar.getClass();
        ensureKeysIsMutable();
        this.keys_.set(i2, kVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setRegion(String str) {
        str.getClass();
        this.bitField0_ |= 4;
        this.region_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setRegionBytes(j jVar) {
        this.region_ = jVar.B();
        this.bitField0_ |= 4;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSignatureInfos(int i2, f fVar) {
        fVar.getClass();
        ensureSignatureInfosIsMutable();
        this.signatureInfos_.set(i2, fVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setStartTimestamp(long j2) {
        this.bitField0_ |= 1;
        this.startTimestamp_ = j2;
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001\u0005\u0000\u0002\u0005\u0001\u0003\b\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u001b\u0007\u001b", new Object[]{"bitField0_", "startTimestamp_", "endTimestamp_", "region_", "batchNum_", "batchSize_", "signatureInfos_", f.class, "keys_", k.class});
            case 3:
                return new l();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<l> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (l.class) {
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

    public int getBatchNum() {
        return this.batchNum_;
    }

    public int getBatchSize() {
        return this.batchSize_;
    }

    public long getEndTimestamp() {
        return this.endTimestamp_;
    }

    public k getKeys(int i2) {
        return this.keys_.get(i2);
    }

    public int getKeysCount() {
        return this.keys_.size();
    }

    public List<k> getKeysList() {
        return this.keys_;
    }

    public m getKeysOrBuilder(int i2) {
        return this.keys_.get(i2);
    }

    public List<? extends m> getKeysOrBuilderList() {
        return this.keys_;
    }

    public String getRegion() {
        return this.region_;
    }

    public j getRegionBytes() {
        return j.n(this.region_);
    }

    public f getSignatureInfos(int i2) {
        return this.signatureInfos_.get(i2);
    }

    public int getSignatureInfosCount() {
        return this.signatureInfos_.size();
    }

    public List<f> getSignatureInfosList() {
        return this.signatureInfos_;
    }

    public g getSignatureInfosOrBuilder(int i2) {
        return this.signatureInfos_.get(i2);
    }

    public List<? extends g> getSignatureInfosOrBuilderList() {
        return this.signatureInfos_;
    }

    public long getStartTimestamp() {
        return this.startTimestamp_;
    }

    public boolean hasBatchNum() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasBatchSize() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasEndTimestamp() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasRegion() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasStartTimestamp() {
        return (this.bitField0_ & 1) != 0;
    }
}
