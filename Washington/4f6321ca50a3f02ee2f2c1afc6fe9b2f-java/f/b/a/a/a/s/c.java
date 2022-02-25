package f.b.a.a.a.s;

import f.b.a.a.a.s.g;
import f.b.f.b0;
import f.b.f.b1;
import f.b.f.c0;
import f.b.f.j;
import f.b.f.k;
import f.b.f.r;
import f.b.f.z;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class c extends z<c, b> implements Object {
    public static final int DATA_BITS_FIELD_NUMBER = 3;
    private static final c DEFAULT_INSTANCE;
    private static volatile b1<c> PARSER = null;
    public static final int PRIO_PARAMETERS_FIELD_NUMBER = 1;
    public static final int PUBLIC_KEYS_FIELD_NUMBER = 2;
    private int bitField0_;
    private c0.g dataBits_ = z.emptyIntList();
    private g prioParameters_;
    private c0.i<String> publicKeys_ = z.emptyProtobufList();

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

    public static final class b extends z.a<c, b> implements Object {
        private b() {
            super(c.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b addAllDataBits(Iterable<? extends Integer> iterable) {
            copyOnWrite();
            ((c) this.instance).addAllDataBits(iterable);
            return this;
        }

        public b addAllPublicKeys(Iterable<String> iterable) {
            copyOnWrite();
            ((c) this.instance).addAllPublicKeys(iterable);
            return this;
        }

        public b addDataBits(int i2) {
            copyOnWrite();
            ((c) this.instance).addDataBits(i2);
            return this;
        }

        public b addPublicKeys(String str) {
            copyOnWrite();
            ((c) this.instance).addPublicKeys(str);
            return this;
        }

        public b addPublicKeysBytes(j jVar) {
            copyOnWrite();
            ((c) this.instance).addPublicKeysBytes(jVar);
            return this;
        }

        public b clearDataBits() {
            copyOnWrite();
            ((c) this.instance).clearDataBits();
            return this;
        }

        public b clearPrioParameters() {
            copyOnWrite();
            ((c) this.instance).clearPrioParameters();
            return this;
        }

        public b clearPublicKeys() {
            copyOnWrite();
            ((c) this.instance).clearPublicKeys();
            return this;
        }

        public int getDataBits(int i2) {
            return ((c) this.instance).getDataBits(i2);
        }

        public int getDataBitsCount() {
            return ((c) this.instance).getDataBitsCount();
        }

        public List<Integer> getDataBitsList() {
            return Collections.unmodifiableList(((c) this.instance).getDataBitsList());
        }

        public g getPrioParameters() {
            return ((c) this.instance).getPrioParameters();
        }

        public String getPublicKeys(int i2) {
            return ((c) this.instance).getPublicKeys(i2);
        }

        public j getPublicKeysBytes(int i2) {
            return ((c) this.instance).getPublicKeysBytes(i2);
        }

        public int getPublicKeysCount() {
            return ((c) this.instance).getPublicKeysCount();
        }

        public List<String> getPublicKeysList() {
            return Collections.unmodifiableList(((c) this.instance).getPublicKeysList());
        }

        public boolean hasPrioParameters() {
            return ((c) this.instance).hasPrioParameters();
        }

        public b mergePrioParameters(g gVar) {
            copyOnWrite();
            ((c) this.instance).mergePrioParameters(gVar);
            return this;
        }

        public b setDataBits(int i2, int i3) {
            copyOnWrite();
            ((c) this.instance).setDataBits(i2, i3);
            return this;
        }

        public b setPrioParameters(g.b bVar) {
            copyOnWrite();
            ((c) this.instance).setPrioParameters((g) bVar.build());
            return this;
        }

        public b setPrioParameters(g gVar) {
            copyOnWrite();
            ((c) this.instance).setPrioParameters(gVar);
            return this;
        }

        public b setPublicKeys(int i2, String str) {
            copyOnWrite();
            ((c) this.instance).setPublicKeys(i2, str);
            return this;
        }
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        z.registerDefaultInstance(c.class, cVar);
    }

    private c() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllDataBits(Iterable<? extends Integer> iterable) {
        ensureDataBitsIsMutable();
        f.b.f.a.addAll((Iterable) iterable, (List) this.dataBits_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllPublicKeys(Iterable<String> iterable) {
        ensurePublicKeysIsMutable();
        f.b.f.a.addAll((Iterable) iterable, (List) this.publicKeys_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addDataBits(int i2) {
        ensureDataBitsIsMutable();
        ((b0) this.dataBits_).i(i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addPublicKeys(String str) {
        str.getClass();
        ensurePublicKeysIsMutable();
        this.publicKeys_.add(str);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addPublicKeysBytes(j jVar) {
        ensurePublicKeysIsMutable();
        this.publicKeys_.add(jVar.B());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearDataBits() {
        this.dataBits_ = z.emptyIntList();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearPrioParameters() {
        this.prioParameters_ = null;
        this.bitField0_ &= -2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearPublicKeys() {
        this.publicKeys_ = z.emptyProtobufList();
    }

    private void ensureDataBitsIsMutable() {
        c0.g gVar = this.dataBits_;
        if (!((f.b.f.c) gVar).b) {
            this.dataBits_ = z.mutableCopy(gVar);
        }
    }

    private void ensurePublicKeysIsMutable() {
        if (!this.publicKeys_.g()) {
            this.publicKeys_ = z.mutableCopy(this.publicKeys_);
        }
    }

    public static c getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mergePrioParameters(g gVar) {
        gVar.getClass();
        g gVar2 = this.prioParameters_;
        if (!(gVar2 == null || gVar2 == g.getDefaultInstance())) {
            gVar = (g) ((g.b) g.newBuilder(this.prioParameters_).mergeFrom((z) gVar)).buildPartial();
        }
        this.prioParameters_ = gVar;
        this.bitField0_ |= 1;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(c cVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(cVar);
    }

    public static c parseDelimitedFrom(InputStream inputStream) {
        return (c) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static c parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (c) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static c parseFrom(j jVar) {
        return (c) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static c parseFrom(j jVar, r rVar) {
        return (c) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static c parseFrom(k kVar) {
        return (c) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static c parseFrom(k kVar, r rVar) {
        return (c) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static c parseFrom(InputStream inputStream) {
        return (c) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static c parseFrom(InputStream inputStream, r rVar) {
        return (c) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static c parseFrom(ByteBuffer byteBuffer) {
        return (c) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static c parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (c) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static c parseFrom(byte[] bArr) {
        return (c) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static c parseFrom(byte[] bArr, r rVar) {
        return (c) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<c> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setDataBits(int i2, int i3) {
        ensureDataBitsIsMutable();
        b0 b0Var = (b0) this.dataBits_;
        b0Var.h();
        b0Var.j(i2);
        int[] iArr = b0Var.c;
        int i4 = iArr[i2];
        iArr[i2] = i3;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPrioParameters(g gVar) {
        gVar.getClass();
        this.prioParameters_ = gVar;
        this.bitField0_ |= 1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPublicKeys(int i2, String str) {
        str.getClass();
        ensurePublicKeysIsMutable();
        this.publicKeys_.set(i2, str);
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\t\u0000\u0002\u001a\u0003\u001d", new Object[]{"bitField0_", "prioParameters_", "publicKeys_", "dataBits_"});
            case 3:
                return new c();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<c> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (c.class) {
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

    public int getDataBits(int i2) {
        b0 b0Var = (b0) this.dataBits_;
        b0Var.j(i2);
        return b0Var.c[i2];
    }

    public int getDataBitsCount() {
        return ((b0) this.dataBits_).size();
    }

    public List<Integer> getDataBitsList() {
        return this.dataBits_;
    }

    public g getPrioParameters() {
        g gVar = this.prioParameters_;
        return gVar == null ? g.getDefaultInstance() : gVar;
    }

    public String getPublicKeys(int i2) {
        return this.publicKeys_.get(i2);
    }

    public j getPublicKeysBytes(int i2) {
        return j.n(this.publicKeys_.get(i2));
    }

    public int getPublicKeysCount() {
        return this.publicKeys_.size();
    }

    public List<String> getPublicKeysList() {
        return this.publicKeys_;
    }

    public boolean hasPrioParameters() {
        return (this.bitField0_ & 1) != 0;
    }
}
