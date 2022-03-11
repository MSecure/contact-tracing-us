package f.b.a.a.a.u;

import f.b.a.a.a.u.d;
import f.b.a.a.a.u.g;
import f.b.f.b1;
import f.b.f.j;
import f.b.f.k;
import f.b.f.r;
import f.b.f.z;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class f extends z<f, b> implements Object {
    public static final int CREATED_FIELD_NUMBER = 2;
    private static final f DEFAULT_INSTANCE;
    public static final int PACKETS_RESPONSE_FIELD_NUMBER = 5;
    private static volatile b1<f> PARSER = null;
    public static final int PRIO_PARAMS_FIELD_NUMBER = 3;
    public static final int SCHEMA_VERSION_FIELD_NUMBER = 4;
    public static final int UUID_FIELD_NUMBER = 1;
    private int bitField0_;
    private String created_ = "";
    private d packetsResponse_;
    private g prioParams_;
    private int schemaVersion_;
    private String uuid_ = "";

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

    public static final class b extends z.a<f, b> implements Object {
        private b() {
            super(f.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Deprecated
        public b clearCreated() {
            copyOnWrite();
            ((f) this.instance).clearCreated();
            return this;
        }

        public b clearPacketsResponse() {
            copyOnWrite();
            ((f) this.instance).clearPacketsResponse();
            return this;
        }

        public b clearPrioParams() {
            copyOnWrite();
            ((f) this.instance).clearPrioParams();
            return this;
        }

        public b clearSchemaVersion() {
            copyOnWrite();
            ((f) this.instance).clearSchemaVersion();
            return this;
        }

        public b clearUuid() {
            copyOnWrite();
            ((f) this.instance).clearUuid();
            return this;
        }

        @Deprecated
        public String getCreated() {
            return ((f) this.instance).getCreated();
        }

        @Deprecated
        public j getCreatedBytes() {
            return ((f) this.instance).getCreatedBytes();
        }

        public d getPacketsResponse() {
            return ((f) this.instance).getPacketsResponse();
        }

        public g getPrioParams() {
            return ((f) this.instance).getPrioParams();
        }

        public int getSchemaVersion() {
            return ((f) this.instance).getSchemaVersion();
        }

        public String getUuid() {
            return ((f) this.instance).getUuid();
        }

        public j getUuidBytes() {
            return ((f) this.instance).getUuidBytes();
        }

        @Deprecated
        public boolean hasCreated() {
            return ((f) this.instance).hasCreated();
        }

        public boolean hasPacketsResponse() {
            return ((f) this.instance).hasPacketsResponse();
        }

        public boolean hasPrioParams() {
            return ((f) this.instance).hasPrioParams();
        }

        public boolean hasSchemaVersion() {
            return ((f) this.instance).hasSchemaVersion();
        }

        public boolean hasUuid() {
            return ((f) this.instance).hasUuid();
        }

        public b mergePacketsResponse(d dVar) {
            copyOnWrite();
            ((f) this.instance).mergePacketsResponse(dVar);
            return this;
        }

        public b mergePrioParams(g gVar) {
            copyOnWrite();
            ((f) this.instance).mergePrioParams(gVar);
            return this;
        }

        @Deprecated
        public b setCreated(String str) {
            copyOnWrite();
            ((f) this.instance).setCreated(str);
            return this;
        }

        @Deprecated
        public b setCreatedBytes(j jVar) {
            copyOnWrite();
            ((f) this.instance).setCreatedBytes(jVar);
            return this;
        }

        public b setPacketsResponse(d.b bVar) {
            copyOnWrite();
            ((f) this.instance).setPacketsResponse((d) bVar.build());
            return this;
        }

        public b setPacketsResponse(d dVar) {
            copyOnWrite();
            ((f) this.instance).setPacketsResponse(dVar);
            return this;
        }

        public b setPrioParams(g.b bVar) {
            copyOnWrite();
            ((f) this.instance).setPrioParams((g) bVar.build());
            return this;
        }

        public b setPrioParams(g gVar) {
            copyOnWrite();
            ((f) this.instance).setPrioParams(gVar);
            return this;
        }

        public b setSchemaVersion(int i2) {
            copyOnWrite();
            ((f) this.instance).setSchemaVersion(i2);
            return this;
        }

        public b setUuid(String str) {
            copyOnWrite();
            ((f) this.instance).setUuid(str);
            return this;
        }

        public b setUuidBytes(j jVar) {
            copyOnWrite();
            ((f) this.instance).setUuidBytes(jVar);
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

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearCreated() {
        this.bitField0_ &= -3;
        this.created_ = getDefaultInstance().getCreated();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearPacketsResponse() {
        this.packetsResponse_ = null;
        this.bitField0_ &= -17;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearPrioParams() {
        this.prioParams_ = null;
        this.bitField0_ &= -5;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearSchemaVersion() {
        this.bitField0_ &= -9;
        this.schemaVersion_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearUuid() {
        this.bitField0_ &= -2;
        this.uuid_ = getDefaultInstance().getUuid();
    }

    public static f getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mergePacketsResponse(d dVar) {
        dVar.getClass();
        d dVar2 = this.packetsResponse_;
        if (!(dVar2 == null || dVar2 == d.getDefaultInstance())) {
            dVar = (d) ((d.b) d.newBuilder(this.packetsResponse_).mergeFrom((z) dVar)).buildPartial();
        }
        this.packetsResponse_ = dVar;
        this.bitField0_ |= 16;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void mergePrioParams(g gVar) {
        gVar.getClass();
        g gVar2 = this.prioParams_;
        if (!(gVar2 == null || gVar2 == g.getDefaultInstance())) {
            gVar = (g) ((g.b) g.newBuilder(this.prioParams_).mergeFrom((z) gVar)).buildPartial();
        }
        this.prioParams_ = gVar;
        this.bitField0_ |= 4;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(f fVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(fVar);
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

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setCreated(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.created_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setCreatedBytes(j jVar) {
        this.created_ = jVar.B();
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPacketsResponse(d dVar) {
        dVar.getClass();
        this.packetsResponse_ = dVar;
        this.bitField0_ |= 16;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setPrioParams(g gVar) {
        gVar.getClass();
        this.prioParams_ = gVar;
        this.bitField0_ |= 4;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setSchemaVersion(int i2) {
        this.bitField0_ |= 8;
        this.schemaVersion_ = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setUuid(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.uuid_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setUuidBytes(j jVar) {
        this.uuid_ = jVar.B();
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\t\u0002\u0004\u0004\u0003\u0005\t\u0004", new Object[]{"bitField0_", "uuid_", "created_", "prioParams_", "schemaVersion_", "packetsResponse_"});
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

    @Deprecated
    public String getCreated() {
        return this.created_;
    }

    @Deprecated
    public j getCreatedBytes() {
        return j.n(this.created_);
    }

    public d getPacketsResponse() {
        d dVar = this.packetsResponse_;
        return dVar == null ? d.getDefaultInstance() : dVar;
    }

    public g getPrioParams() {
        g gVar = this.prioParams_;
        return gVar == null ? g.getDefaultInstance() : gVar;
    }

    public int getSchemaVersion() {
        return this.schemaVersion_;
    }

    public String getUuid() {
        return this.uuid_;
    }

    public j getUuidBytes() {
        return j.n(this.uuid_);
    }

    @Deprecated
    public boolean hasCreated() {
        return (this.bitField0_ & 2) != 0;
    }

    public boolean hasPacketsResponse() {
        return (this.bitField0_ & 16) != 0;
    }

    public boolean hasPrioParams() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasSchemaVersion() {
        return (this.bitField0_ & 8) != 0;
    }

    public boolean hasUuid() {
        return (this.bitField0_ & 1) != 0;
    }
}
