package f.b.a.a.a.g0;

import f.b.a.a.a.g0.h;
import f.b.g.b1;
import f.b.g.c0;
import f.b.g.j;
import f.b.g.k;
import f.b.g.r;
import f.b.g.z;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class i extends z<i, b> implements Object {
    private static final i DEFAULT_INSTANCE;
    private static volatile b1<i> PARSER = null;
    public static final int SIGNATURES_FIELD_NUMBER = 1;
    private c0.i<h> signatures_ = z.emptyProtobufList();

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

    public static final class b extends z.a<i, b> implements Object {
        private b() {
            super(i.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b addAllSignatures(Iterable<? extends h> iterable) {
            copyOnWrite();
            ((i) this.instance).addAllSignatures(iterable);
            return this;
        }

        public b addSignatures(int i2, h.b bVar) {
            copyOnWrite();
            ((i) this.instance).addSignatures(i2, (h) bVar.build());
            return this;
        }

        public b addSignatures(int i2, h hVar) {
            copyOnWrite();
            ((i) this.instance).addSignatures(i2, hVar);
            return this;
        }

        public b addSignatures(h.b bVar) {
            copyOnWrite();
            ((i) this.instance).addSignatures((h) bVar.build());
            return this;
        }

        public b addSignatures(h hVar) {
            copyOnWrite();
            ((i) this.instance).addSignatures(hVar);
            return this;
        }

        public b clearSignatures() {
            copyOnWrite();
            ((i) this.instance).clearSignatures();
            return this;
        }

        public h getSignatures(int i2) {
            return ((i) this.instance).getSignatures(i2);
        }

        public int getSignaturesCount() {
            return ((i) this.instance).getSignaturesCount();
        }

        public List<h> getSignaturesList() {
            return Collections.unmodifiableList(((i) this.instance).getSignaturesList());
        }

        public b removeSignatures(int i2) {
            copyOnWrite();
            ((i) this.instance).removeSignatures(i2);
            return this;
        }

        public b setSignatures(int i2, h.b bVar) {
            copyOnWrite();
            ((i) this.instance).setSignatures(i2, (h) bVar.build());
            return this;
        }

        public b setSignatures(int i2, h hVar) {
            copyOnWrite();
            ((i) this.instance).setSignatures(i2, hVar);
            return this;
        }
    }

    static {
        i iVar = new i();
        DEFAULT_INSTANCE = iVar;
        z.registerDefaultInstance(i.class, iVar);
    }

    private i() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllSignatures(Iterable<? extends h> iterable) {
        ensureSignaturesIsMutable();
        f.b.g.a.addAll((Iterable) iterable, (List) this.signatures_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addSignatures(int i2, h hVar) {
        hVar.getClass();
        ensureSignaturesIsMutable();
        this.signatures_.add(i2, hVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addSignatures(h hVar) {
        hVar.getClass();
        ensureSignaturesIsMutable();
        this.signatures_.add(hVar);
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

    public static i getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(i iVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(iVar);
    }

    public static i parseDelimitedFrom(InputStream inputStream) {
        return (i) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static i parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (i) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static i parseFrom(j jVar) {
        return (i) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static i parseFrom(j jVar, r rVar) {
        return (i) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static i parseFrom(k kVar) {
        return (i) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static i parseFrom(k kVar, r rVar) {
        return (i) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static i parseFrom(InputStream inputStream) {
        return (i) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static i parseFrom(InputStream inputStream, r rVar) {
        return (i) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static i parseFrom(ByteBuffer byteBuffer) {
        return (i) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static i parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (i) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static i parseFrom(byte[] bArr) {
        return (i) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static i parseFrom(byte[] bArr, r rVar) {
        return (i) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<i> parser() {
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
    private void setSignatures(int i2, h hVar) {
        hVar.getClass();
        ensureSignaturesIsMutable();
        this.signatures_.set(i2, hVar);
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"signatures_", h.class});
            case 3:
                return new i();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<i> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (i.class) {
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

    public h getSignatures(int i2) {
        return this.signatures_.get(i2);
    }

    public int getSignaturesCount() {
        return this.signatures_.size();
    }

    public List<h> getSignaturesList() {
        return this.signatures_;
    }

    public j getSignaturesOrBuilder(int i2) {
        return this.signatures_.get(i2);
    }

    public List<? extends j> getSignaturesOrBuilderList() {
        return this.signatures_;
    }
}
