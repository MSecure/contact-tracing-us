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
public final class p extends z<p, b> implements q {
    public static final int COUNT_FIELD_NUMBER;
    private static final p DEFAULT_INSTANCE;
    public static final int HEALTH_AUTHORITY_FIELD_NUMBER;
    public static final int HOURS_SINCE_LAST_RUN_FIELD_NUMBER;
    private static volatile b1<p> PARSER;
    public static final int STATUS_FIELD_NUMBER;
    public static final int WORKER_TASK_FIELD_NUMBER;
    private int bitField0_;
    private int count_;
    private String healthAuthority_ = "";
    private int hoursSinceLastRun_;
    private int status_;
    private int workerTask_;

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
    public static final class b extends z.a<p, b> implements q {
        private b() {
            super(p.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b clearCount() {
            copyOnWrite();
            ((p) this.instance).clearCount();
            return this;
        }

        @Deprecated
        public b clearHealthAuthority() {
            copyOnWrite();
            ((p) this.instance).clearHealthAuthority();
            return this;
        }

        public b clearHoursSinceLastRun() {
            copyOnWrite();
            ((p) this.instance).clearHoursSinceLastRun();
            return this;
        }

        public b clearStatus() {
            copyOnWrite();
            ((p) this.instance).clearStatus();
            return this;
        }

        public b clearWorkerTask() {
            copyOnWrite();
            ((p) this.instance).clearWorkerTask();
            return this;
        }

        @Override // f.b.a.a.a.h0.q
        public int getCount() {
            return ((p) this.instance).getCount();
        }

        @Override // f.b.a.a.a.h0.q
        @Deprecated
        public String getHealthAuthority() {
            return ((p) this.instance).getHealthAuthority();
        }

        @Override // f.b.a.a.a.h0.q
        @Deprecated
        public j getHealthAuthorityBytes() {
            return ((p) this.instance).getHealthAuthorityBytes();
        }

        @Override // f.b.a.a.a.h0.q
        public int getHoursSinceLastRun() {
            return ((p) this.instance).getHoursSinceLastRun();
        }

        @Override // f.b.a.a.a.h0.q
        public c getStatus() {
            return ((p) this.instance).getStatus();
        }

        @Override // f.b.a.a.a.h0.q
        public d getWorkerTask() {
            return ((p) this.instance).getWorkerTask();
        }

        @Override // f.b.a.a.a.h0.q
        public boolean hasCount() {
            return ((p) this.instance).hasCount();
        }

        @Override // f.b.a.a.a.h0.q
        @Deprecated
        public boolean hasHealthAuthority() {
            return ((p) this.instance).hasHealthAuthority();
        }

        @Override // f.b.a.a.a.h0.q
        public boolean hasHoursSinceLastRun() {
            return ((p) this.instance).hasHoursSinceLastRun();
        }

        @Override // f.b.a.a.a.h0.q
        public boolean hasStatus() {
            return ((p) this.instance).hasStatus();
        }

        @Override // f.b.a.a.a.h0.q
        public boolean hasWorkerTask() {
            return ((p) this.instance).hasWorkerTask();
        }

        public b setCount(int i2) {
            copyOnWrite();
            ((p) this.instance).setCount(i2);
            return this;
        }

        @Deprecated
        public b setHealthAuthority(String str) {
            copyOnWrite();
            ((p) this.instance).setHealthAuthority(str);
            return this;
        }

        @Deprecated
        public b setHealthAuthorityBytes(j jVar) {
            copyOnWrite();
            ((p) this.instance).setHealthAuthorityBytes(jVar);
            return this;
        }

        public b setHoursSinceLastRun(int i2) {
            copyOnWrite();
            ((p) this.instance).setHoursSinceLastRun(i2);
            return this;
        }

        public b setStatus(c cVar) {
            copyOnWrite();
            ((p) this.instance).setStatus(cVar);
            return this;
        }

        public b setWorkerTask(d dVar) {
            copyOnWrite();
            ((p) this.instance).setWorkerTask(dVar);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum c implements c0.c {
        STATUS_UNKNOWN(0),
        STATUS_STARTED(1),
        STATUS_SUCCESS(2),
        STATUS_TIMEOUT(3),
        STATUS_FAIL(4),
        STATUS_ABANDONED(5);
        
        public static final int STATUS_ABANDONED_VALUE;
        public static final int STATUS_FAIL_VALUE;
        public static final int STATUS_STARTED_VALUE;
        public static final int STATUS_SUCCESS_VALUE;
        public static final int STATUS_TIMEOUT_VALUE;
        public static final int STATUS_UNKNOWN_VALUE;
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

        @Override // f.b.g.c0.c
        public final int getNumber() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public enum d implements c0.c {
        TASK_UNKNOWN(0),
        TASK_PROVIDE_DIAGNOSIS_KEYS(2),
        TASK_STATE_UPDATED(3),
        TASK_SUBMIT_PRIVATE_ANALYTICS(4),
        TASK_COUNTRY_CHECKING(5),
        TASK_FIRELOG_ANALYTICS(6);
        
        public static final int TASK_COUNTRY_CHECKING_VALUE;
        public static final int TASK_FIRELOG_ANALYTICS_VALUE;
        public static final int TASK_PROVIDE_DIAGNOSIS_KEYS_VALUE;
        public static final int TASK_STATE_UPDATED_VALUE;
        public static final int TASK_SUBMIT_PRIVATE_ANALYTICS_VALUE;
        public static final int TASK_UNKNOWN_VALUE;
        private static final c0.d<d> internalValueMap = new a();
        private final int value;

        /* loaded from: classes.dex */
        public class a implements c0.d<d> {
            @Override // f.b.g.c0.d
            public d findValueByNumber(int i2) {
                return d.forNumber(i2);
            }
        }

        /* loaded from: classes.dex */
        public static final class b implements c0.e {
            public static final c0.e INSTANCE = new b();

            private b() {
            }

            @Override // f.b.g.c0.e
            public boolean isInRange(int i2) {
                return d.forNumber(i2) != null;
            }
        }

        d(int i2) {
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

        @Override // f.b.g.c0.c
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        p pVar = new p();
        DEFAULT_INSTANCE = pVar;
        z.registerDefaultInstance(p.class, pVar);
    }

    private p() {
    }

    public void clearCount() {
        this.bitField0_ &= -9;
        this.count_ = 0;
    }

    public void clearHealthAuthority() {
        this.bitField0_ &= -2;
        this.healthAuthority_ = getDefaultInstance().getHealthAuthority();
    }

    public void clearHoursSinceLastRun() {
        this.bitField0_ &= -17;
        this.hoursSinceLastRun_ = 0;
    }

    public void clearStatus() {
        this.bitField0_ &= -5;
        this.status_ = 0;
    }

    public void clearWorkerTask() {
        this.bitField0_ &= -3;
        this.workerTask_ = 0;
    }

    public static p getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(p pVar) {
        return DEFAULT_INSTANCE.createBuilder(pVar);
    }

    public static p parseDelimitedFrom(InputStream inputStream) {
        return (p) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static p parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (p) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static p parseFrom(j jVar) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static p parseFrom(j jVar, r rVar) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static p parseFrom(k kVar) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static p parseFrom(k kVar, r rVar) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static p parseFrom(InputStream inputStream) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static p parseFrom(InputStream inputStream, r rVar) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static p parseFrom(ByteBuffer byteBuffer) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static p parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static p parseFrom(byte[] bArr) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static p parseFrom(byte[] bArr, r rVar) {
        return (p) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<p> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    public void setCount(int i2) {
        this.bitField0_ |= 8;
        this.count_ = i2;
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

    public void setHoursSinceLastRun(int i2) {
        this.bitField0_ |= 16;
        this.hoursSinceLastRun_ = i2;
    }

    public void setStatus(c cVar) {
        this.status_ = cVar.getNumber();
        this.bitField0_ |= 4;
    }

    public void setWorkerTask(d dVar) {
        this.workerTask_ = dVar.getNumber();
        this.bitField0_ |= 2;
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\f\u0001\u0003\f\u0002\u0004\u0004\u0003\u0005\u0004\u0004", new Object[]{"bitField0_", "healthAuthority_", "workerTask_", d.internalGetVerifier(), "status_", c.internalGetVerifier(), "count_", "hoursSinceLastRun_"});
            case 3:
                return new p();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<p> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (p.class) {
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

    @Override // f.b.a.a.a.h0.q
    public int getCount() {
        return this.count_;
    }

    @Override // f.b.a.a.a.h0.q
    @Deprecated
    public String getHealthAuthority() {
        return this.healthAuthority_;
    }

    @Override // f.b.a.a.a.h0.q
    @Deprecated
    public j getHealthAuthorityBytes() {
        return j.n(this.healthAuthority_);
    }

    @Override // f.b.a.a.a.h0.q
    public int getHoursSinceLastRun() {
        return this.hoursSinceLastRun_;
    }

    @Override // f.b.a.a.a.h0.q
    public c getStatus() {
        c forNumber = c.forNumber(this.status_);
        return forNumber == null ? c.STATUS_UNKNOWN : forNumber;
    }

    @Override // f.b.a.a.a.h0.q
    public d getWorkerTask() {
        d forNumber = d.forNumber(this.workerTask_);
        return forNumber == null ? d.TASK_UNKNOWN : forNumber;
    }

    @Override // f.b.a.a.a.h0.q
    public boolean hasCount() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // f.b.a.a.a.h0.q
    @Deprecated
    public boolean hasHealthAuthority() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // f.b.a.a.a.h0.q
    public boolean hasHoursSinceLastRun() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // f.b.a.a.a.h0.q
    public boolean hasStatus() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // f.b.a.a.a.h0.q
    public boolean hasWorkerTask() {
        return (this.bitField0_ & 2) != 0;
    }
}
