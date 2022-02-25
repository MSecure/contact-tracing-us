package f.b.a.a.a.s;

import f.b.a.a.a.s.k;
import f.b.a.a.a.s.p;
import f.b.f.b1;
import f.b.f.c0;
import f.b.f.j;
import f.b.f.r;
import f.b.f.z;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class q extends z<q, b> implements Object {
    public static final int BATCH_NUM_FIELD_NUMBER = 4;
    public static final int BATCH_SIZE_FIELD_NUMBER = 5;
    private static final q DEFAULT_INSTANCE;
    public static final int END_TIMESTAMP_FIELD_NUMBER = 2;
    public static final int KEYS_FIELD_NUMBER = 7;
    private static volatile b1<q> PARSER = null;
    public static final int REGION_FIELD_NUMBER = 3;
    public static final int SIGNATURE_INFOS_FIELD_NUMBER = 6;
    public static final int START_TIMESTAMP_FIELD_NUMBER = 1;
    private int batchNum_;
    private int batchSize_;
    private int bitField0_;
    private long endTimestamp_;
    private c0.i<p> keys_ = z.emptyProtobufList();
    private String region_ = "";
    private c0.i<k> signatureInfos_ = z.emptyProtobufList();
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

    public static final class b extends z.a<q, b> implements Object {
        private b() {
            super(q.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b addAllKeys(Iterable<? extends p> iterable) {
            copyOnWrite();
            ((q) this.instance).addAllKeys(iterable);
            return this;
        }

        public b addAllSignatureInfos(Iterable<? extends k> iterable) {
            copyOnWrite();
            ((q) this.instance).addAllSignatureInfos(iterable);
            return this;
        }

        public b addKeys(int i2, p.b bVar) {
            copyOnWrite();
            ((q) this.instance).addKeys(i2, (p) bVar.build());
            return this;
        }

        public b addKeys(int i2, p pVar) {
            copyOnWrite();
            ((q) this.instance).addKeys(i2, pVar);
            return this;
        }

        public b addKeys(p.b bVar) {
            copyOnWrite();
            ((q) this.instance).addKeys((p) bVar.build());
            return this;
        }

        public b addKeys(p pVar) {
            copyOnWrite();
            ((q) this.instance).addKeys(pVar);
            return this;
        }

        public b addSignatureInfos(int i2, k.b bVar) {
            copyOnWrite();
            ((q) this.instance).addSignatureInfos(i2, (k) bVar.build());
            return this;
        }

        public b addSignatureInfos(int i2, k kVar) {
            copyOnWrite();
            ((q) this.instance).addSignatureInfos(i2, kVar);
            return this;
        }

        public b addSignatureInfos(k.b bVar) {
            copyOnWrite();
            ((q) this.instance).addSignatureInfos((k) bVar.build());
            return this;
        }

        public b addSignatureInfos(k kVar) {
            copyOnWrite();
            ((q) this.instance).addSignatureInfos(kVar);
            return this;
        }

        public b clearBatchNum() {
            copyOnWrite();
            ((q) this.instance).clearBatchNum();
            return this;
        }

        public b clearBatchSize() {
            copyOnWrite();
            ((q) this.instance).clearBatchSize();
            return this;
        }

        public b clearEndTimestamp() {
            copyOnWrite();
            ((q) this.instance).clearEndTimestamp();
            return this;
        }

        public b clearKeys() {
            copyOnWrite();
            ((q) this.instance).clearKeys();
            return this;
        }

        public b clearRegion() {
            copyOnWrite();
            ((q) this.instance).clearRegion();
            return this;
        }

        public b clearSignatureInfos() {
            copyOnWrite();
            ((q) this.instance).clearSignatureInfos();
            return this;
        }

        public b clearStartTimestamp() {
            copyOnWrite();
            ((q) this.instance).clearStartTimestamp();
            return this;
        }

        public int getBatchNum() {
            return ((q) this.instance).getBatchNum();
        }

        public int getBatchSize() {
            return ((q) this.instance).getBatchSize();
        }

        public long getEndTimestamp() {
            return ((q) this.instance).getEndTimestamp();
        }

        public p getKeys(int i2) {
            return ((q) this.instance).getKeys(i2);
        }

        public int getKeysCount() {
            return ((q) this.instance).getKeysCount();
        }

        public List<p> getKeysList() {
            return Collections.unmodifiableList(((q) this.instance).getKeysList());
        }

        public String getRegion() {
            return ((q) this.instance).getRegion();
        }

        public j getRegionBytes() {
            return ((q) this.instance).getRegionBytes();
        }

        public k getSignatureInfos(int i2) {
            return ((q) this.instance).getSignatureInfos(i2);
        }

        public int getSignatureInfosCount() {
            return ((q) this.instance).getSignatureInfosCount();
        }

        public List<k> getSignatureInfosList() {
            return Collections.unmodifiableList(((q) this.instance).getSignatureInfosList());
        }

        public long getStartTimestamp() {
            return ((q) this.instance).getStartTimestamp();
        }

        public boolean hasBatchNum() {
            return ((q) this.instance).hasBatchNum();
        }

        public boolean hasBatchSize() {
            return ((q) this.instance).hasBatchSize();
        }

        public boolean hasEndTimestamp() {
            return ((q) this.instance).hasEndTimestamp();
        }

        public boolean hasRegion() {
            return ((q) this.instance).hasRegion();
        }

        public boolean hasStartTimestamp() {
            return ((q) this.instance).hasStartTimestamp();
        }

        public b removeKeys(int i2) {
            copyOnWrite();
            ((q) this.instance).removeKeys(i2);
            return this;
        }

        public b removeSignatureInfos(int i2) {
            copyOnWrite();
            ((q) this.instance).removeSignatureInfos(i2);
            return this;
        }

        public b setBatchNum(int i2) {
            copyOnWrite();
            ((q) this.instance).setBatchNum(i2);
            return this;
        }

        public b setBatchSize(int i2) {
            copyOnWrite();
            ((q) this.instance).setBatchSize(i2);
            return this;
        }

        public b setEndTimestamp(long j2) {
            copyOnWrite();
            ((q) this.instance).setEndTimestamp(j2);
            return this;
        }

        public b setKeys(int i2, p.b bVar) {
            copyOnWrite();
            ((q) this.instance).setKeys(i2, (p) bVar.build());
            return this;
        }

        public b setKeys(int i2, p pVar) {
            copyOnWrite();
            ((q) this.instance).setKeys(i2, pVar);
            return this;
        }

        public b setRegion(String str) {
            copyOnWrite();
            ((q) this.instance).setRegion(str);
            return this;
        }

        public b setRegionBytes(j jVar) {
            copyOnWrite();
            ((q) this.instance).setRegionBytes(jVar);
            return this;
        }

        public b setSignatureInfos(int i2, k.b bVar) {
            copyOnWrite();
            ((q) this.instance).setSignatureInfos(i2, (k) bVar.build());
            return this;
        }

        public b setSignatureInfos(int i2, k kVar) {
            copyOnWrite();
            ((q) this.instance).setSignatureInfos(i2, kVar);
            return this;
        }

        public b setStartTimestamp(long j2) {
            copyOnWrite();
            ((q) this.instance).setStartTimestamp(j2);
            return this;
        }
    }

    static {
        q qVar = new q();
        DEFAULT_INSTANCE = qVar;
        z.registerDefaultInstance(q.class, qVar);
    }

    private q() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllKeys(Iterable<? extends p> iterable) {
        ensureKeysIsMutable();
        f.b.f.a.addAll((Iterable) iterable, (List) this.keys_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllSignatureInfos(Iterable<? extends k> iterable) {
        ensureSignatureInfosIsMutable();
        f.b.f.a.addAll((Iterable) iterable, (List) this.signatureInfos_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addKeys(int i2, p pVar) {
        pVar.getClass();
        ensureKeysIsMutable();
        this.keys_.add(i2, pVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addKeys(p pVar) {
        pVar.getClass();
        ensureKeysIsMutable();
        this.keys_.add(pVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addSignatureInfos(int i2, k kVar) {
        kVar.getClass();
        ensureSignatureInfosIsMutable();
        this.signatureInfos_.add(i2, kVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addSignatureInfos(k kVar) {
        kVar.getClass();
        ensureSignatureInfosIsMutable();
        this.signatureInfos_.add(kVar);
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

    public static q getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(q qVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(qVar);
    }

    public static q parseDelimitedFrom(InputStream inputStream) {
        return (q) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static q parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (q) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static q parseFrom(j jVar) {
        return (q) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static q parseFrom(j jVar, r rVar) {
        return (q) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static q parseFrom(f.b.f.k kVar) {
        return (q) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static q parseFrom(f.b.f.k kVar, r rVar) {
        return (q) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static q parseFrom(InputStream inputStream) {
        return (q) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static q parseFrom(InputStream inputStream, r rVar) {
        return (q) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static q parseFrom(ByteBuffer byteBuffer) {
        return (q) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static q parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (q) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static q parseFrom(byte[] bArr) {
        return (q) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static q parseFrom(byte[] bArr, r rVar) {
        return (q) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<q> parser() {
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
    private void setKeys(int i2, p pVar) {
        pVar.getClass();
        ensureKeysIsMutable();
        this.keys_.set(i2, pVar);
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
    private void setSignatureInfos(int i2, k kVar) {
        kVar.getClass();
        ensureSignatureInfosIsMutable();
        this.signatureInfos_.set(i2, kVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setStartTimestamp(long j2) {
        this.bitField0_ |= 1;
        this.startTimestamp_ = j2;
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001\u0005\u0000\u0002\u0005\u0001\u0003\b\u0002\u0004\u0004\u0003\u0005\u0004\u0004\u0006\u001b\u0007\u001b", new Object[]{"bitField0_", "startTimestamp_", "endTimestamp_", "region_", "batchNum_", "batchSize_", "signatureInfos_", k.class, "keys_", p.class});
            case 3:
                return new q();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<q> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (q.class) {
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

    public p getKeys(int i2) {
        return this.keys_.get(i2);
    }

    public int getKeysCount() {
        return this.keys_.size();
    }

    public List<p> getKeysList() {
        return this.keys_;
    }

    public r getKeysOrBuilder(int i2) {
        return this.keys_.get(i2);
    }

    public List<? extends r> getKeysOrBuilderList() {
        return this.keys_;
    }

    public String getRegion() {
        return this.region_;
    }

    public j getRegionBytes() {
        return j.n(this.region_);
    }

    public k getSignatureInfos(int i2) {
        return this.signatureInfos_.get(i2);
    }

    public int getSignatureInfosCount() {
        return this.signatureInfos_.size();
    }

    public List<k> getSignatureInfosList() {
        return this.signatureInfos_;
    }

    public l getSignatureInfosOrBuilder(int i2) {
        return this.signatureInfos_.get(i2);
    }

    public List<? extends l> getSignatureInfosOrBuilderList() {
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
