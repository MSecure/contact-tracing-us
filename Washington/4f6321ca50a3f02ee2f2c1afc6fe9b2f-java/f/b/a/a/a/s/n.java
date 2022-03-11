package f.b.a.a.a.s;

import f.b.a.a.a.s.m;
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

public final class n extends z<n, b> implements Object {
    private static final n DEFAULT_INSTANCE;
    private static volatile b1<n> PARSER = null;
    public static final int SIGNATURES_FIELD_NUMBER = 1;
    private c0.i<m> signatures_ = z.emptyProtobufList();

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

    public static final class b extends z.a<n, b> implements Object {
        private b() {
            super(n.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b addAllSignatures(Iterable<? extends m> iterable) {
            copyOnWrite();
            ((n) this.instance).addAllSignatures(iterable);
            return this;
        }

        public b addSignatures(int i2, m.b bVar) {
            copyOnWrite();
            ((n) this.instance).addSignatures(i2, (m) bVar.build());
            return this;
        }

        public b addSignatures(int i2, m mVar) {
            copyOnWrite();
            ((n) this.instance).addSignatures(i2, mVar);
            return this;
        }

        public b addSignatures(m.b bVar) {
            copyOnWrite();
            ((n) this.instance).addSignatures((m) bVar.build());
            return this;
        }

        public b addSignatures(m mVar) {
            copyOnWrite();
            ((n) this.instance).addSignatures(mVar);
            return this;
        }

        public b clearSignatures() {
            copyOnWrite();
            ((n) this.instance).clearSignatures();
            return this;
        }

        public m getSignatures(int i2) {
            return ((n) this.instance).getSignatures(i2);
        }

        public int getSignaturesCount() {
            return ((n) this.instance).getSignaturesCount();
        }

        public List<m> getSignaturesList() {
            return Collections.unmodifiableList(((n) this.instance).getSignaturesList());
        }

        public b removeSignatures(int i2) {
            copyOnWrite();
            ((n) this.instance).removeSignatures(i2);
            return this;
        }

        public b setSignatures(int i2, m.b bVar) {
            copyOnWrite();
            ((n) this.instance).setSignatures(i2, (m) bVar.build());
            return this;
        }

        public b setSignatures(int i2, m mVar) {
            copyOnWrite();
            ((n) this.instance).setSignatures(i2, mVar);
            return this;
        }
    }

    static {
        n nVar = new n();
        DEFAULT_INSTANCE = nVar;
        z.registerDefaultInstance(n.class, nVar);
    }

    private n() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllSignatures(Iterable<? extends m> iterable) {
        ensureSignaturesIsMutable();
        f.b.f.a.addAll((Iterable) iterable, (List) this.signatures_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addSignatures(int i2, m mVar) {
        mVar.getClass();
        ensureSignaturesIsMutable();
        this.signatures_.add(i2, mVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addSignatures(m mVar) {
        mVar.getClass();
        ensureSignaturesIsMutable();
        this.signatures_.add(mVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearSignatures() {
        this.signatures_ = z.emptyProtobufList();
    }

    private void ensureSignaturesIsMutable() {
        if (!this.signatures_.g()) {
            this.signatures_ = z.mutableCopy(this.signatures_);
        }
    }

    public static n getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(n nVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(nVar);
    }

    public static n parseDelimitedFrom(InputStream inputStream) {
        return (n) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static n parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (n) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static n parseFrom(j jVar) {
        return (n) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static n parseFrom(j jVar, r rVar) {
        return (n) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static n parseFrom(k kVar) {
        return (n) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static n parseFrom(k kVar, r rVar) {
        return (n) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static n parseFrom(InputStream inputStream) {
        return (n) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static n parseFrom(InputStream inputStream, r rVar) {
        return (n) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static n parseFrom(ByteBuffer byteBuffer) {
        return (n) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static n parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (n) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static n parseFrom(byte[] bArr) {
        return (n) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static n parseFrom(byte[] bArr, r rVar) {
        return (n) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<n> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeSignatures(int i2) {
        ensureSignaturesIsMutable();
        this.signatures_.remove(i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSignatures(int i2, m mVar) {
        mVar.getClass();
        ensureSignaturesIsMutable();
        this.signatures_.set(i2, mVar);
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"signatures_", m.class});
            case 3:
                return new n();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<n> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (n.class) {
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

    public m getSignatures(int i2) {
        return this.signatures_.get(i2);
    }

    public int getSignaturesCount() {
        return this.signatures_.size();
    }

    public List<m> getSignaturesList() {
        return this.signatures_;
    }

    public o getSignaturesOrBuilder(int i2) {
        return this.signatures_.get(i2);
    }

    public List<? extends o> getSignaturesOrBuilderList() {
        return this.signatures_;
    }
}
