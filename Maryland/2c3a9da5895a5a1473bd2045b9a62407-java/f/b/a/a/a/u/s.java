package f.b.a.a.a.u;

import f.b.f.b1;
import f.b.f.c0;
import f.b.f.j;
import f.b.f.k;
import f.b.f.r;
import f.b.f.z;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class s extends z<s, b> implements t {
    public static final int COUNT_FIELD_NUMBER = 3;
    private static final s DEFAULT_INSTANCE;
    public static final int EVENT_TYPE_FIELD_NUMBER = 2;
    public static final int HEALTH_AUTHORITY_FIELD_NUMBER = 1;
    private static volatile b1<s> PARSER;
    private int bitField0_;
    private int count_;
    private int eventType_;
    private String healthAuthority_ = "";

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

    public static final class b extends z.a<s, b> implements t {
        private b() {
            super(s.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b clearCount() {
            copyOnWrite();
            ((s) this.instance).clearCount();
            return this;
        }

        public b clearEventType() {
            copyOnWrite();
            ((s) this.instance).clearEventType();
            return this;
        }

        @Deprecated
        public b clearHealthAuthority() {
            copyOnWrite();
            ((s) this.instance).clearHealthAuthority();
            return this;
        }

        @Override // f.b.a.a.a.u.t
        public int getCount() {
            return ((s) this.instance).getCount();
        }

        @Override // f.b.a.a.a.u.t
        public c getEventType() {
            return ((s) this.instance).getEventType();
        }

        @Override // f.b.a.a.a.u.t
        @Deprecated
        public String getHealthAuthority() {
            return ((s) this.instance).getHealthAuthority();
        }

        @Override // f.b.a.a.a.u.t
        @Deprecated
        public j getHealthAuthorityBytes() {
            return ((s) this.instance).getHealthAuthorityBytes();
        }

        @Override // f.b.a.a.a.u.t
        public boolean hasCount() {
            return ((s) this.instance).hasCount();
        }

        @Override // f.b.a.a.a.u.t
        public boolean hasEventType() {
            return ((s) this.instance).hasEventType();
        }

        @Override // f.b.a.a.a.u.t
        @Deprecated
        public boolean hasHealthAuthority() {
            return ((s) this.instance).hasHealthAuthority();
        }

        public b setCount(int i2) {
            copyOnWrite();
            ((s) this.instance).setCount(i2);
            return this;
        }

        public b setEventType(c cVar) {
            copyOnWrite();
            ((s) this.instance).setEventType(cVar);
            return this;
        }

        @Deprecated
        public b setHealthAuthority(String str) {
            copyOnWrite();
            ((s) this.instance).setHealthAuthority(str);
            return this;
        }

        @Deprecated
        public b setHealthAuthorityBytes(j jVar) {
            copyOnWrite();
            ((s) this.instance).setHealthAuthorityBytes(jVar);
            return this;
        }
    }

    public enum c implements c0.c {
        UNKNOWN(0),
        APP_OPENED(1),
        BLUETOOTH_DISABLED_WARNING_SHOWN(2),
        LOCATION_PERMISSION_WARNING_SHOWN(3),
        LOW_STORAGE_WARNING_SHOWN(4),
        SHARE_APP_CLICKED(5);
        
        public static final int APP_OPENED_VALUE = 1;
        public static final int BLUETOOTH_DISABLED_WARNING_SHOWN_VALUE = 2;
        public static final int LOCATION_PERMISSION_WARNING_SHOWN_VALUE = 3;
        public static final int LOW_STORAGE_WARNING_SHOWN_VALUE = 4;
        public static final int SHARE_APP_CLICKED_VALUE = 5;
        public static final int UNKNOWN_VALUE = 0;
        private static final c0.d<c> internalValueMap = new a();
        private final int value;

        public class a implements c0.d<c> {
            @Override // f.b.f.c0.d
            public c findValueByNumber(int i2) {
                return c.forNumber(i2);
            }
        }

        public static final class b implements c0.e {
            public static final c0.e INSTANCE = new b();

            private b() {
            }

            @Override // f.b.f.c0.e
            public boolean isInRange(int i2) {
                return c.forNumber(i2) != null;
            }
        }

        private c(int i2) {
            this.value = i2;
        }

        public static c forNumber(int i2) {
            if (i2 == 0) {
                return UNKNOWN;
            }
            if (i2 == 1) {
                return APP_OPENED;
            }
            if (i2 == 2) {
                return BLUETOOTH_DISABLED_WARNING_SHOWN;
            }
            if (i2 == 3) {
                return LOCATION_PERMISSION_WARNING_SHOWN;
            }
            if (i2 == 4) {
                return LOW_STORAGE_WARNING_SHOWN;
            }
            if (i2 != 5) {
                return null;
            }
            return SHARE_APP_CLICKED;
        }

        public static c0.d<c> internalGetValueMap() {
            return internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return b.INSTANCE;
        }

        @Deprecated
        public static c valueOf(int i2) {
            return forNumber(i2);
        }

        @Override // f.b.f.c0.c
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        s sVar = new s();
        DEFAULT_INSTANCE = sVar;
        z.registerDefaultInstance(s.class, sVar);
    }

    private s() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearCount() {
        this.bitField0_ &= -5;
        this.count_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearEventType() {
        this.bitField0_ &= -3;
        this.eventType_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearHealthAuthority() {
        this.bitField0_ &= -2;
        this.healthAuthority_ = getDefaultInstance().getHealthAuthority();
    }

    public static s getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(s sVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(sVar);
    }

    public static s parseDelimitedFrom(InputStream inputStream) {
        return (s) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static s parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (s) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static s parseFrom(j jVar) {
        return (s) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static s parseFrom(j jVar, r rVar) {
        return (s) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static s parseFrom(k kVar) {
        return (s) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static s parseFrom(k kVar, r rVar) {
        return (s) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static s parseFrom(InputStream inputStream) {
        return (s) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static s parseFrom(InputStream inputStream, r rVar) {
        return (s) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static s parseFrom(ByteBuffer byteBuffer) {
        return (s) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static s parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (s) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static s parseFrom(byte[] bArr) {
        return (s) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static s parseFrom(byte[] bArr, r rVar) {
        return (s) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<s> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setCount(int i2) {
        this.bitField0_ |= 4;
        this.count_ = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setEventType(c cVar) {
        this.eventType_ = cVar.getNumber();
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setHealthAuthority(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.healthAuthority_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setHealthAuthorityBytes(j jVar) {
        this.healthAuthority_ = jVar.B();
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0004\u0002", new Object[]{"bitField0_", "healthAuthority_", "eventType_", c.internalGetVerifier(), "count_"});
            case 3:
                return new s();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<s> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (s.class) {
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

    @Override // f.b.a.a.a.u.t
    public int getCount() {
        return this.count_;
    }

    @Override // f.b.a.a.a.u.t
    public c getEventType() {
        c forNumber = c.forNumber(this.eventType_);
        return forNumber == null ? c.UNKNOWN : forNumber;
    }

    @Override // f.b.a.a.a.u.t
    @Deprecated
    public String getHealthAuthority() {
        return this.healthAuthority_;
    }

    @Override // f.b.a.a.a.u.t
    @Deprecated
    public j getHealthAuthorityBytes() {
        return j.n(this.healthAuthority_);
    }

    @Override // f.b.a.a.a.u.t
    public boolean hasCount() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // f.b.a.a.a.u.t
    public boolean hasEventType() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // f.b.a.a.a.u.t
    @Deprecated
    public boolean hasHealthAuthority() {
        return (this.bitField0_ & 1) != 0;
    }
}
