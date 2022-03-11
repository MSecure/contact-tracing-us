package f.b.a.a.a.u;

import f.b.f.b1;
import f.b.f.c0;
import f.b.f.j;
import f.b.f.k;
import f.b.f.r;
import f.b.f.z;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class u extends z<u, b> implements v {
    public static final int COUNT_FIELD_NUMBER = 4;
    private static final u DEFAULT_INSTANCE;
    public static final int HEALTH_AUTHORITY_FIELD_NUMBER = 1;
    public static final int HOURS_SINCE_LAST_RUN_FIELD_NUMBER = 5;
    private static volatile b1<u> PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 3;
    public static final int WORKER_TASK_FIELD_NUMBER = 2;
    private int bitField0_;
    private int count_;
    private String healthAuthority_ = "";
    private int hoursSinceLastRun_;
    private int status_;
    private int workerTask_;

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

    public static final class b extends z.a<u, b> implements v {
        private b() {
            super(u.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b clearCount() {
            copyOnWrite();
            ((u) this.instance).clearCount();
            return this;
        }

        @Deprecated
        public b clearHealthAuthority() {
            copyOnWrite();
            ((u) this.instance).clearHealthAuthority();
            return this;
        }

        public b clearHoursSinceLastRun() {
            copyOnWrite();
            ((u) this.instance).clearHoursSinceLastRun();
            return this;
        }

        public b clearStatus() {
            copyOnWrite();
            ((u) this.instance).clearStatus();
            return this;
        }

        public b clearWorkerTask() {
            copyOnWrite();
            ((u) this.instance).clearWorkerTask();
            return this;
        }

        @Override // f.b.a.a.a.u.v
        public int getCount() {
            return ((u) this.instance).getCount();
        }

        @Override // f.b.a.a.a.u.v
        @Deprecated
        public String getHealthAuthority() {
            return ((u) this.instance).getHealthAuthority();
        }

        @Override // f.b.a.a.a.u.v
        @Deprecated
        public j getHealthAuthorityBytes() {
            return ((u) this.instance).getHealthAuthorityBytes();
        }

        @Override // f.b.a.a.a.u.v
        public int getHoursSinceLastRun() {
            return ((u) this.instance).getHoursSinceLastRun();
        }

        @Override // f.b.a.a.a.u.v
        public c getStatus() {
            return ((u) this.instance).getStatus();
        }

        @Override // f.b.a.a.a.u.v
        public d getWorkerTask() {
            return ((u) this.instance).getWorkerTask();
        }

        @Override // f.b.a.a.a.u.v
        public boolean hasCount() {
            return ((u) this.instance).hasCount();
        }

        @Override // f.b.a.a.a.u.v
        @Deprecated
        public boolean hasHealthAuthority() {
            return ((u) this.instance).hasHealthAuthority();
        }

        @Override // f.b.a.a.a.u.v
        public boolean hasHoursSinceLastRun() {
            return ((u) this.instance).hasHoursSinceLastRun();
        }

        @Override // f.b.a.a.a.u.v
        public boolean hasStatus() {
            return ((u) this.instance).hasStatus();
        }

        @Override // f.b.a.a.a.u.v
        public boolean hasWorkerTask() {
            return ((u) this.instance).hasWorkerTask();
        }

        public b setCount(int i2) {
            copyOnWrite();
            ((u) this.instance).setCount(i2);
            return this;
        }

        @Deprecated
        public b setHealthAuthority(String str) {
            copyOnWrite();
            ((u) this.instance).setHealthAuthority(str);
            return this;
        }

        @Deprecated
        public b setHealthAuthorityBytes(j jVar) {
            copyOnWrite();
            ((u) this.instance).setHealthAuthorityBytes(jVar);
            return this;
        }

        public b setHoursSinceLastRun(int i2) {
            copyOnWrite();
            ((u) this.instance).setHoursSinceLastRun(i2);
            return this;
        }

        public b setStatus(c cVar) {
            copyOnWrite();
            ((u) this.instance).setStatus(cVar);
            return this;
        }

        public b setWorkerTask(d dVar) {
            copyOnWrite();
            ((u) this.instance).setWorkerTask(dVar);
            return this;
        }
    }

    public enum c implements c0.c {
        STATUS_UNKNOWN(0),
        STATUS_STARTED(1),
        STATUS_SUCCESS(2),
        STATUS_TIMEOUT(3),
        STATUS_FAIL(4),
        STATUS_ABANDONED(5);
        
        public static final int STATUS_ABANDONED_VALUE = 5;
        public static final int STATUS_FAIL_VALUE = 4;
        public static final int STATUS_STARTED_VALUE = 1;
        public static final int STATUS_SUCCESS_VALUE = 2;
        public static final int STATUS_TIMEOUT_VALUE = 3;
        public static final int STATUS_UNKNOWN_VALUE = 0;
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
                return STATUS_UNKNOWN;
            }
            if (i2 == 1) {
                return STATUS_STARTED;
            }
            if (i2 == 2) {
                return STATUS_SUCCESS;
            }
            if (i2 == 3) {
                return STATUS_TIMEOUT;
            }
            if (i2 == 4) {
                return STATUS_FAIL;
            }
            if (i2 != 5) {
                return null;
            }
            return STATUS_ABANDONED;
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

    public enum d implements c0.c {
        TASK_UNKNOWN(0),
        TASK_PROVIDE_DIAGNOSIS_KEYS(2),
        TASK_STATE_UPDATED(3),
        TASK_SUBMIT_PRIVATE_ANALYTICS(4),
        TASK_COUNTRY_CHECKING(5),
        TASK_FIRELOG_ANALYTICS(6);
        
        public static final int TASK_COUNTRY_CHECKING_VALUE = 5;
        public static final int TASK_FIRELOG_ANALYTICS_VALUE = 6;
        public static final int TASK_PROVIDE_DIAGNOSIS_KEYS_VALUE = 2;
        public static final int TASK_STATE_UPDATED_VALUE = 3;
        public static final int TASK_SUBMIT_PRIVATE_ANALYTICS_VALUE = 4;
        public static final int TASK_UNKNOWN_VALUE = 0;
        private static final c0.d<d> internalValueMap = new a();
        private final int value;

        public class a implements c0.d<d> {
            @Override // f.b.f.c0.d
            public d findValueByNumber(int i2) {
                return d.forNumber(i2);
            }
        }

        public static final class b implements c0.e {
            public static final c0.e INSTANCE = new b();

            private b() {
            }

            @Override // f.b.f.c0.e
            public boolean isInRange(int i2) {
                return d.forNumber(i2) != null;
            }
        }

        private d(int i2) {
            this.value = i2;
        }

        public static d forNumber(int i2) {
            if (i2 == 0) {
                return TASK_UNKNOWN;
            }
            if (i2 == 2) {
                return TASK_PROVIDE_DIAGNOSIS_KEYS;
            }
            if (i2 == 3) {
                return TASK_STATE_UPDATED;
            }
            if (i2 == 4) {
                return TASK_SUBMIT_PRIVATE_ANALYTICS;
            }
            if (i2 == 5) {
                return TASK_COUNTRY_CHECKING;
            }
            if (i2 != 6) {
                return null;
            }
            return TASK_FIRELOG_ANALYTICS;
        }

        public static c0.d<d> internalGetValueMap() {
            return internalValueMap;
        }

        public static c0.e internalGetVerifier() {
            return b.INSTANCE;
        }

        @Deprecated
        public static d valueOf(int i2) {
            return forNumber(i2);
        }

        @Override // f.b.f.c0.c
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        u uVar = new u();
        DEFAULT_INSTANCE = uVar;
        z.registerDefaultInstance(u.class, uVar);
    }

    private u() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearCount() {
        this.bitField0_ &= -9;
        this.count_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearHealthAuthority() {
        this.bitField0_ &= -2;
        this.healthAuthority_ = getDefaultInstance().getHealthAuthority();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearHoursSinceLastRun() {
        this.bitField0_ &= -17;
        this.hoursSinceLastRun_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearStatus() {
        this.bitField0_ &= -5;
        this.status_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearWorkerTask() {
        this.bitField0_ &= -3;
        this.workerTask_ = 0;
    }

    public static u getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(u uVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(uVar);
    }

    public static u parseDelimitedFrom(InputStream inputStream) {
        return (u) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static u parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (u) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static u parseFrom(j jVar) {
        return (u) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static u parseFrom(j jVar, r rVar) {
        return (u) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static u parseFrom(k kVar) {
        return (u) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static u parseFrom(k kVar, r rVar) {
        return (u) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static u parseFrom(InputStream inputStream) {
        return (u) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static u parseFrom(InputStream inputStream, r rVar) {
        return (u) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static u parseFrom(ByteBuffer byteBuffer) {
        return (u) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static u parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (u) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static u parseFrom(byte[] bArr) {
        return (u) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static u parseFrom(byte[] bArr, r rVar) {
        return (u) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<u> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setCount(int i2) {
        this.bitField0_ |= 8;
        this.count_ = i2;
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

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setHoursSinceLastRun(int i2) {
        this.bitField0_ |= 16;
        this.hoursSinceLastRun_ = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setStatus(c cVar) {
        this.status_ = cVar.getNumber();
        this.bitField0_ |= 4;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setWorkerTask(d dVar) {
        this.workerTask_ = dVar.getNumber();
        this.bitField0_ |= 2;
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\f\u0002\u0004\u0004\u0003\u0005\u0004\u0004", new Object[]{"bitField0_", "healthAuthority_", "workerTask_", d.internalGetVerifier(), "status_", c.internalGetVerifier(), "count_", "hoursSinceLastRun_"});
            case 3:
                return new u();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<u> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (u.class) {
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

    @Override // f.b.a.a.a.u.v
    public int getCount() {
        return this.count_;
    }

    @Override // f.b.a.a.a.u.v
    @Deprecated
    public String getHealthAuthority() {
        return this.healthAuthority_;
    }

    @Override // f.b.a.a.a.u.v
    @Deprecated
    public j getHealthAuthorityBytes() {
        return j.n(this.healthAuthority_);
    }

    @Override // f.b.a.a.a.u.v
    public int getHoursSinceLastRun() {
        return this.hoursSinceLastRun_;
    }

    @Override // f.b.a.a.a.u.v
    public c getStatus() {
        c forNumber = c.forNumber(this.status_);
        return forNumber == null ? c.STATUS_UNKNOWN : forNumber;
    }

    @Override // f.b.a.a.a.u.v
    public d getWorkerTask() {
        d forNumber = d.forNumber(this.workerTask_);
        return forNumber == null ? d.TASK_UNKNOWN : forNumber;
    }

    @Override // f.b.a.a.a.u.v
    public boolean hasCount() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // f.b.a.a.a.u.v
    @Deprecated
    public boolean hasHealthAuthority() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // f.b.a.a.a.u.v
    public boolean hasHoursSinceLastRun() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // f.b.a.a.a.u.v
    public boolean hasStatus() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // f.b.a.a.a.u.v
    public boolean hasWorkerTask() {
        return (this.bitField0_ & 2) != 0;
    }
}
