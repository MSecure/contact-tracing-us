package f.b.a.a.a.s;

import f.b.a.a.a.s.h;
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

public final class d extends z<d, b> implements Object {
    private static final d DEFAULT_INSTANCE;
    private static volatile b1<d> PARSER = null;
    public static final int RESPONSE_STATUS_FIELD_NUMBER = 1;
    public static final int SHARES_FIELD_NUMBER = 2;
    private int bitField0_;
    private h responseStatus_;
    private c0.i<j> shares_ = z.emptyProtobufList();

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

    public static final class b extends z.a<d, b> implements Object {
        private b() {
            super(d.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b addAllShares(Iterable<? extends j> iterable) {
            copyOnWrite();
            ((d) this.instance).addAllShares(iterable);
            return this;
        }

        public b addShares(j jVar) {
            copyOnWrite();
            ((d) this.instance).addShares(jVar);
            return this;
        }

        public b clearResponseStatus() {
            copyOnWrite();
            ((d) this.instance).clearResponseStatus();
            return this;
        }

        public b clearShares() {
            copyOnWrite();
            ((d) this.instance).clearShares();
            return this;
        }

        public h getResponseStatus() {
            return ((d) this.instance).getResponseStatus();
        }

        public j getShares(int i2) {
            return ((d) this.instance).getShares(i2);
        }

        public int getSharesCount() {
            return ((d) this.instance).getSharesCount();
        }

        public List<j> getSharesList() {
            return Collections.unmodifiableList(((d) this.instance).getSharesList());
        }

        public boolean hasResponseStatus() {
            return ((d) this.instance).hasResponseStatus();
        }

        public b mergeResponseStatus(h hVar) {
            copyOnWrite();
            ((d) this.instance).mergeResponseStatus(hVar);
            return this;
        }

        public b setResponseStatus(h.b bVar) {
            copyOnWrite();
            ((d) this.instance).setResponseStatus((h) bVar.build());
            return this;
        }

        public b setResponseStatus(h hVar) {
            copyOnWrite();
            ((d) this.instance).setResponseStatus(hVar);
            return this;
        }

        public b setShares(int i2, j jVar) {
            copyOnWrite();
            ((d) this.instance).setShares(i2, jVar);
            return this;
        }
    }

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        z.registerDefaultInstance(d.class, dVar);
    }

    private d() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllShares(Iterable<? extends j> iterable) {
        ensureSharesIsMutable();
        f.b.f.a.addAll((Iterable) iterable, (List) this.shares_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addShares(j jVar) {
        jVar.getClass();
        ensureSharesIsMutable();
        this.shares_.add(jVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearResponseStatus() {
        this.responseStatus_ = null;
        this.bitField0_ &= -2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearShares() {
        this.shares_ = z.emptyProtobufList();
    }

    private void ensureSharesIsMutable() {
        if (!this.shares_.g()) {
            this.shares_ = z.mutableCopy(this.shares_);
        }
    }

    public static d getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mergeResponseStatus(h hVar) {
        hVar.getClass();
        h hVar2 = this.responseStatus_;
        if (!(hVar2 == null || hVar2 == h.getDefaultInstance())) {
            hVar = (h) ((h.b) h.newBuilder(this.responseStatus_).mergeFrom((z) hVar)).buildPartial();
        }
        this.responseStatus_ = hVar;
        this.bitField0_ |= 1;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(d dVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(dVar);
    }

    public static d parseDelimitedFrom(InputStream inputStream) {
        return (d) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static d parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (d) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static d parseFrom(j jVar) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static d parseFrom(j jVar, r rVar) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static d parseFrom(k kVar) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static d parseFrom(k kVar, r rVar) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static d parseFrom(InputStream inputStream) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static d parseFrom(InputStream inputStream, r rVar) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static d parseFrom(ByteBuffer byteBuffer) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static d parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static d parseFrom(byte[] bArr) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static d parseFrom(byte[] bArr, r rVar) {
        return (d) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<d> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setResponseStatus(h hVar) {
        hVar.getClass();
        this.responseStatus_ = hVar;
        this.bitField0_ |= 1;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setShares(int i2, j jVar) {
        jVar.getClass();
        ensureSharesIsMutable();
        this.shares_.set(i2, jVar);
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\t\u0000\u0002\u001c", new Object[]{"bitField0_", "responseStatus_", "shares_"});
            case 3:
                return new d();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<d> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (d.class) {
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

    public h getResponseStatus() {
        h hVar = this.responseStatus_;
        return hVar == null ? h.getDefaultInstance() : hVar;
    }

    public j getShares(int i2) {
        return this.shares_.get(i2);
    }

    public int getSharesCount() {
        return this.shares_.size();
    }

    public List<j> getSharesList() {
        return this.shares_;
    }

    public boolean hasResponseStatus() {
        return (this.bitField0_ & 1) != 0;
    }
}
