package f.b.a.a.a.h0;

import f.b.g.b1;
import f.b.g.c0;
import f.b.g.j;
import f.b.g.k;
import f.b.g.r;
import f.b.g.z;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class n extends z<n, b> implements o {
    public static final int COUNT_FIELD_NUMBER;
    private static final n DEFAULT_INSTANCE;
    public static final int EVENT_TYPE_FIELD_NUMBER;
    public static final int HEALTH_AUTHORITY_FIELD_NUMBER;
    private static volatile b1<n> PARSER;
    private int bitField0_;
    private int count_;
    private int eventType_;
    private String healthAuthority_ = "";

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            z.f.values();
            int[] iArr = new int[7];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[4] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[5] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[6] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[0] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[1] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends z.a<n, b> implements o {
        private b() {
            super(n.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b clearCount() {
            copyOnWrite();
            ((n) this.instance).clearCount();
            return this;
        }

        public b clearEventType() {
            copyOnWrite();
            ((n) this.instance).clearEventType();
            return this;
        }

        @Deprecated
        public b clearHealthAuthority() {
            copyOnWrite();
            ((n) this.instance).clearHealthAuthority();
            return this;
        }

        @Override // f.b.a.a.a.h0.o
        public int getCount() {
            return ((n) this.instance).getCount();
        }

        @Override // f.b.a.a.a.h0.o
        public c getEventType() {
            return ((n) this.instance).getEventType();
        }

        @Override // f.b.a.a.a.h0.o
        @Deprecated
        public String getHealthAuthority() {
            return ((n) this.instance).getHealthAuthority();
        }

        @Override // f.b.a.a.a.h0.o
        @Deprecated
        public j getHealthAuthorityBytes() {
            return ((n) this.instance).getHealthAuthorityBytes();
        }

        @Override // f.b.a.a.a.h0.o
        public boolean hasCount() {
            return ((n) this.instance).hasCount();
        }

        @Override // f.b.a.a.a.h0.o
        public boolean hasEventType() {
            return ((n) this.instance).hasEventType();
        }

        @Override // f.b.a.a.a.h0.o
        @Deprecated
        public boolean hasHealthAuthority() {
            return ((n) this.instance).hasHealthAuthority();
        }

        public b setCount(int i2) {
            copyOnWrite();
            ((n) this.instance).setCount(i2);
            return this;
        }

        public b setEventType(c cVar) {
            copyOnWrite();
            ((n) this.instance).setEventType(cVar);
            return this;
        }

        @Deprecated
        public b setHealthAuthority(String str) {
            copyOnWrite();
            ((n) this.instance).setHealthAuthority(str);
            return this;
        }

        @Deprecated
        public b setHealthAuthorityBytes(j jVar) {
            copyOnWrite();
            ((n) this.instance).setHealthAuthorityBytes(jVar);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum c implements c0.c {
        UNKNOWN(0),
        APP_OPENED(1),
        BLUETOOTH_DISABLED_WARNING_SHOWN(2),
        LOCATION_PERMISSION_WARNING_SHOWN(3),
        LOW_STORAGE_WARNING_SHOWN(4),
        SHARE_APP_CLICKED(5);
        
        public static final int APP_OPENED_VALUE;
        public static final int BLUETOOTH_DISABLED_WARNING_SHOWN_VALUE;
        public static final int LOCATION_PERMISSION_WARNING_SHOWN_VALUE;
        public static final int LOW_STORAGE_WARNING_SHOWN_VALUE;
        public static final int SHARE_APP_CLICKED_VALUE;
        public static final int UNKNOWN_VALUE;
        private static final c0.d<c> internalValueMap = new a();
        private final int value;

        /* loaded from: classes.dex */
        public class a implements c0.d<c> {
            @Override // f.b.g.c0.d
            public c findValueByNumber(int i2) {
                return c.forNumber(i2);
            }
        }

        /* loaded from: classes.dex */
        public static final class b implements c0.e {
            public static final c0.e INSTANCE = new b();

            private b() {
            }

            @Override // f.b.g.c0.e
            public boolean isInRange(int i2) {
                return c.forNumber(i2) != null;
            }
        }

        c(int i2) {
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

        @Override // f.b.g.c0.c
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        n nVar = new n();
        DEFAULT_INSTANCE = nVar;
        z.registerDefaultInstance(n.class, nVar);
    }

    private n() {
    }

    public void clearCount() {
        this.bitField0_ &= -5;
        this.count_ = 0;
    }

    public void clearEventType() {
        this.bitField0_ &= -3;
        this.eventType_ = 0;
    }

    public void clearHealthAuthority() {
        this.bitField0_ &= -2;
        this.healthAuthority_ = getDefaultInstance().getHealthAuthority();
    }

    public static n getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(n nVar) {
        return DEFAULT_INSTANCE.createBuilder(nVar);
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

    public void setCount(int i2) {
        this.bitField0_ |= 4;
        this.count_ = i2;
    }

    public void setEventType(c cVar) {
        this.eventType_ = cVar.getNumber();
        this.bitField0_ |= 2;
    }

    public void setHealthAuthority(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.healthAuthority_ = str;
    }

    public void setHealthAuthorityBytes(j jVar) {
        this.healthAuthority_ = jVar.B();
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\u0004\u0002", new Object[]{"bitField0_", "healthAuthority_", "eventType_", c.internalGetVerifier(), "count_"});
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

    @Override // f.b.a.a.a.h0.o
    public int getCount() {
        return this.count_;
    }

    @Override // f.b.a.a.a.h0.o
    public c getEventType() {
        c forNumber = c.forNumber(this.eventType_);
        return forNumber == null ? c.UNKNOWN : forNumber;
    }

    @Override // f.b.a.a.a.h0.o
    @Deprecated
    public String getHealthAuthority() {
        return this.healthAuthority_;
    }

    @Override // f.b.a.a.a.h0.o
    @Deprecated
    public j getHealthAuthorityBytes() {
        return j.n(this.healthAuthority_);
    }

    @Override // f.b.a.a.a.h0.o
    public boolean hasCount() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // f.b.a.a.a.h0.o
    public boolean hasEventType() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // f.b.a.a.a.h0.o
    @Deprecated
    public boolean hasHealthAuthority() {
        return (this.bitField0_ & 1) != 0;
    }
}
