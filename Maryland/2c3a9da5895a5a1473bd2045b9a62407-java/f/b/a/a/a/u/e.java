package f.b.a.a.a.u;

import f.b.a.a.a.u.a;
import f.b.a.a.a.u.i;
import f.b.a.a.a.u.s;
import f.b.a.a.a.u.u;
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

public final class e extends z<e, b> implements Object {
    public static final int API_CALL_FIELD_NUMBER = 2;
    public static final int BUILD_ID_FIELD_NUMBER = 5;
    private static final e DEFAULT_INSTANCE;
    public static final int HOURS_SINCE_LAST_BATCH_FIELD_NUMBER = 7;
    private static volatile b1<e> PARSER = null;
    public static final int REGION_IDENTIFIER_FIELD_NUMBER = 6;
    public static final int RPC_CALL_FIELD_NUMBER = 1;
    public static final int UI_INTERACTION_FIELD_NUMBER = 4;
    public static final int WORK_MANAGER_TASK_FIELD_NUMBER = 3;
    private c0.i<a> apiCall_ = z.emptyProtobufList();
    private int bitField0_;
    private int buildId_;
    private int hoursSinceLastBatch_;
    private String regionIdentifier_ = "";
    private c0.i<i> rpcCall_ = z.emptyProtobufList();
    private c0.i<s> uiInteraction_ = z.emptyProtobufList();
    private c0.i<u> workManagerTask_ = z.emptyProtobufList();

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

    public static final class b extends z.a<e, b> implements Object {
        private b() {
            super(e.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b addAllApiCall(Iterable<? extends a> iterable) {
            copyOnWrite();
            ((e) this.instance).addAllApiCall(iterable);
            return this;
        }

        public b addAllRpcCall(Iterable<? extends i> iterable) {
            copyOnWrite();
            ((e) this.instance).addAllRpcCall(iterable);
            return this;
        }

        public b addAllUiInteraction(Iterable<? extends s> iterable) {
            copyOnWrite();
            ((e) this.instance).addAllUiInteraction(iterable);
            return this;
        }

        public b addAllWorkManagerTask(Iterable<? extends u> iterable) {
            copyOnWrite();
            ((e) this.instance).addAllWorkManagerTask(iterable);
            return this;
        }

        public b addApiCall(int i2, a.c cVar) {
            copyOnWrite();
            ((e) this.instance).addApiCall(i2, (a) cVar.build());
            return this;
        }

        public b addApiCall(int i2, a aVar) {
            copyOnWrite();
            ((e) this.instance).addApiCall(i2, aVar);
            return this;
        }

        public b addApiCall(a.c cVar) {
            copyOnWrite();
            ((e) this.instance).addApiCall((a) cVar.build());
            return this;
        }

        public b addApiCall(a aVar) {
            copyOnWrite();
            ((e) this.instance).addApiCall(aVar);
            return this;
        }

        public b addRpcCall(int i2, i.b bVar) {
            copyOnWrite();
            ((e) this.instance).addRpcCall(i2, (i) bVar.build());
            return this;
        }

        public b addRpcCall(int i2, i iVar) {
            copyOnWrite();
            ((e) this.instance).addRpcCall(i2, iVar);
            return this;
        }

        public b addRpcCall(i.b bVar) {
            copyOnWrite();
            ((e) this.instance).addRpcCall((i) bVar.build());
            return this;
        }

        public b addRpcCall(i iVar) {
            copyOnWrite();
            ((e) this.instance).addRpcCall(iVar);
            return this;
        }

        public b addUiInteraction(int i2, s.b bVar) {
            copyOnWrite();
            ((e) this.instance).addUiInteraction(i2, (s) bVar.build());
            return this;
        }

        public b addUiInteraction(int i2, s sVar) {
            copyOnWrite();
            ((e) this.instance).addUiInteraction(i2, sVar);
            return this;
        }

        public b addUiInteraction(s.b bVar) {
            copyOnWrite();
            ((e) this.instance).addUiInteraction((s) bVar.build());
            return this;
        }

        public b addUiInteraction(s sVar) {
            copyOnWrite();
            ((e) this.instance).addUiInteraction(sVar);
            return this;
        }

        public b addWorkManagerTask(int i2, u.b bVar) {
            copyOnWrite();
            ((e) this.instance).addWorkManagerTask(i2, (u) bVar.build());
            return this;
        }

        public b addWorkManagerTask(int i2, u uVar) {
            copyOnWrite();
            ((e) this.instance).addWorkManagerTask(i2, uVar);
            return this;
        }

        public b addWorkManagerTask(u.b bVar) {
            copyOnWrite();
            ((e) this.instance).addWorkManagerTask((u) bVar.build());
            return this;
        }

        public b addWorkManagerTask(u uVar) {
            copyOnWrite();
            ((e) this.instance).addWorkManagerTask(uVar);
            return this;
        }

        public b clearApiCall() {
            copyOnWrite();
            ((e) this.instance).clearApiCall();
            return this;
        }

        public b clearBuildId() {
            copyOnWrite();
            ((e) this.instance).clearBuildId();
            return this;
        }

        public b clearHoursSinceLastBatch() {
            copyOnWrite();
            ((e) this.instance).clearHoursSinceLastBatch();
            return this;
        }

        public b clearRegionIdentifier() {
            copyOnWrite();
            ((e) this.instance).clearRegionIdentifier();
            return this;
        }

        public b clearRpcCall() {
            copyOnWrite();
            ((e) this.instance).clearRpcCall();
            return this;
        }

        public b clearUiInteraction() {
            copyOnWrite();
            ((e) this.instance).clearUiInteraction();
            return this;
        }

        public b clearWorkManagerTask() {
            copyOnWrite();
            ((e) this.instance).clearWorkManagerTask();
            return this;
        }

        public a getApiCall(int i2) {
            return ((e) this.instance).getApiCall(i2);
        }

        public int getApiCallCount() {
            return ((e) this.instance).getApiCallCount();
        }

        public List<a> getApiCallList() {
            return Collections.unmodifiableList(((e) this.instance).getApiCallList());
        }

        public int getBuildId() {
            return ((e) this.instance).getBuildId();
        }

        public int getHoursSinceLastBatch() {
            return ((e) this.instance).getHoursSinceLastBatch();
        }

        public String getRegionIdentifier() {
            return ((e) this.instance).getRegionIdentifier();
        }

        public j getRegionIdentifierBytes() {
            return ((e) this.instance).getRegionIdentifierBytes();
        }

        public i getRpcCall(int i2) {
            return ((e) this.instance).getRpcCall(i2);
        }

        public int getRpcCallCount() {
            return ((e) this.instance).getRpcCallCount();
        }

        public List<i> getRpcCallList() {
            return Collections.unmodifiableList(((e) this.instance).getRpcCallList());
        }

        public s getUiInteraction(int i2) {
            return ((e) this.instance).getUiInteraction(i2);
        }

        public int getUiInteractionCount() {
            return ((e) this.instance).getUiInteractionCount();
        }

        public List<s> getUiInteractionList() {
            return Collections.unmodifiableList(((e) this.instance).getUiInteractionList());
        }

        public u getWorkManagerTask(int i2) {
            return ((e) this.instance).getWorkManagerTask(i2);
        }

        public int getWorkManagerTaskCount() {
            return ((e) this.instance).getWorkManagerTaskCount();
        }

        public List<u> getWorkManagerTaskList() {
            return Collections.unmodifiableList(((e) this.instance).getWorkManagerTaskList());
        }

        public boolean hasBuildId() {
            return ((e) this.instance).hasBuildId();
        }

        public boolean hasHoursSinceLastBatch() {
            return ((e) this.instance).hasHoursSinceLastBatch();
        }

        public boolean hasRegionIdentifier() {
            return ((e) this.instance).hasRegionIdentifier();
        }

        public b removeApiCall(int i2) {
            copyOnWrite();
            ((e) this.instance).removeApiCall(i2);
            return this;
        }

        public b removeRpcCall(int i2) {
            copyOnWrite();
            ((e) this.instance).removeRpcCall(i2);
            return this;
        }

        public b removeUiInteraction(int i2) {
            copyOnWrite();
            ((e) this.instance).removeUiInteraction(i2);
            return this;
        }

        public b removeWorkManagerTask(int i2) {
            copyOnWrite();
            ((e) this.instance).removeWorkManagerTask(i2);
            return this;
        }

        public b setApiCall(int i2, a.c cVar) {
            copyOnWrite();
            ((e) this.instance).setApiCall(i2, (a) cVar.build());
            return this;
        }

        public b setApiCall(int i2, a aVar) {
            copyOnWrite();
            ((e) this.instance).setApiCall(i2, aVar);
            return this;
        }

        public b setBuildId(int i2) {
            copyOnWrite();
            ((e) this.instance).setBuildId(i2);
            return this;
        }

        public b setHoursSinceLastBatch(int i2) {
            copyOnWrite();
            ((e) this.instance).setHoursSinceLastBatch(i2);
            return this;
        }

        public b setRegionIdentifier(String str) {
            copyOnWrite();
            ((e) this.instance).setRegionIdentifier(str);
            return this;
        }

        public b setRegionIdentifierBytes(j jVar) {
            copyOnWrite();
            ((e) this.instance).setRegionIdentifierBytes(jVar);
            return this;
        }

        public b setRpcCall(int i2, i.b bVar) {
            copyOnWrite();
            ((e) this.instance).setRpcCall(i2, (i) bVar.build());
            return this;
        }

        public b setRpcCall(int i2, i iVar) {
            copyOnWrite();
            ((e) this.instance).setRpcCall(i2, iVar);
            return this;
        }

        public b setUiInteraction(int i2, s.b bVar) {
            copyOnWrite();
            ((e) this.instance).setUiInteraction(i2, (s) bVar.build());
            return this;
        }

        public b setUiInteraction(int i2, s sVar) {
            copyOnWrite();
            ((e) this.instance).setUiInteraction(i2, sVar);
            return this;
        }

        public b setWorkManagerTask(int i2, u.b bVar) {
            copyOnWrite();
            ((e) this.instance).setWorkManagerTask(i2, (u) bVar.build());
            return this;
        }

        public b setWorkManagerTask(int i2, u uVar) {
            copyOnWrite();
            ((e) this.instance).setWorkManagerTask(i2, uVar);
            return this;
        }
    }

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        z.registerDefaultInstance(e.class, eVar);
    }

    private e() {
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllApiCall(Iterable<? extends a> iterable) {
        ensureApiCallIsMutable();
        f.b.f.a.addAll((Iterable) iterable, (List) this.apiCall_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllRpcCall(Iterable<? extends i> iterable) {
        ensureRpcCallIsMutable();
        f.b.f.a.addAll((Iterable) iterable, (List) this.rpcCall_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllUiInteraction(Iterable<? extends s> iterable) {
        ensureUiInteractionIsMutable();
        f.b.f.a.addAll((Iterable) iterable, (List) this.uiInteraction_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addAllWorkManagerTask(Iterable<? extends u> iterable) {
        ensureWorkManagerTaskIsMutable();
        f.b.f.a.addAll((Iterable) iterable, (List) this.workManagerTask_);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addApiCall(int i2, a aVar) {
        aVar.getClass();
        ensureApiCallIsMutable();
        this.apiCall_.add(i2, aVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addApiCall(a aVar) {
        aVar.getClass();
        ensureApiCallIsMutable();
        this.apiCall_.add(aVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addRpcCall(int i2, i iVar) {
        iVar.getClass();
        ensureRpcCallIsMutable();
        this.rpcCall_.add(i2, iVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addRpcCall(i iVar) {
        iVar.getClass();
        ensureRpcCallIsMutable();
        this.rpcCall_.add(iVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addUiInteraction(int i2, s sVar) {
        sVar.getClass();
        ensureUiInteractionIsMutable();
        this.uiInteraction_.add(i2, sVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addUiInteraction(s sVar) {
        sVar.getClass();
        ensureUiInteractionIsMutable();
        this.uiInteraction_.add(sVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addWorkManagerTask(int i2, u uVar) {
        uVar.getClass();
        ensureWorkManagerTaskIsMutable();
        this.workManagerTask_.add(i2, uVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void addWorkManagerTask(u uVar) {
        uVar.getClass();
        ensureWorkManagerTaskIsMutable();
        this.workManagerTask_.add(uVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearApiCall() {
        this.apiCall_ = z.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearBuildId() {
        this.bitField0_ &= -2;
        this.buildId_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearHoursSinceLastBatch() {
        this.bitField0_ &= -5;
        this.hoursSinceLastBatch_ = 0;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearRegionIdentifier() {
        this.bitField0_ &= -3;
        this.regionIdentifier_ = getDefaultInstance().getRegionIdentifier();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearRpcCall() {
        this.rpcCall_ = z.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearUiInteraction() {
        this.uiInteraction_ = z.emptyProtobufList();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void clearWorkManagerTask() {
        this.workManagerTask_ = z.emptyProtobufList();
    }

    private void ensureApiCallIsMutable() {
        if (!this.apiCall_.g()) {
            this.apiCall_ = z.mutableCopy(this.apiCall_);
        }
    }

    private void ensureRpcCallIsMutable() {
        if (!this.rpcCall_.g()) {
            this.rpcCall_ = z.mutableCopy(this.rpcCall_);
        }
    }

    private void ensureUiInteractionIsMutable() {
        if (!this.uiInteraction_.g()) {
            this.uiInteraction_ = z.mutableCopy(this.uiInteraction_);
        }
    }

    private void ensureWorkManagerTaskIsMutable() {
        if (!this.workManagerTask_.g()) {
            this.workManagerTask_ = z.mutableCopy(this.workManagerTask_);
        }
    }

    public static e getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(e eVar) {
        return (b) DEFAULT_INSTANCE.createBuilder(eVar);
    }

    public static e parseDelimitedFrom(InputStream inputStream) {
        return (e) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static e parseDelimitedFrom(InputStream inputStream, r rVar) {
        return (e) z.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static e parseFrom(j jVar) {
        return (e) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static e parseFrom(j jVar, r rVar) {
        return (e) z.parseFrom(DEFAULT_INSTANCE, jVar, rVar);
    }

    public static e parseFrom(k kVar) {
        return (e) z.parseFrom(DEFAULT_INSTANCE, kVar);
    }

    public static e parseFrom(k kVar, r rVar) {
        return (e) z.parseFrom(DEFAULT_INSTANCE, kVar, rVar);
    }

    public static e parseFrom(InputStream inputStream) {
        return (e) z.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static e parseFrom(InputStream inputStream, r rVar) {
        return (e) z.parseFrom(DEFAULT_INSTANCE, inputStream, rVar);
    }

    public static e parseFrom(ByteBuffer byteBuffer) {
        return (e) z.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static e parseFrom(ByteBuffer byteBuffer, r rVar) {
        return (e) z.parseFrom(DEFAULT_INSTANCE, byteBuffer, rVar);
    }

    public static e parseFrom(byte[] bArr) {
        return (e) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static e parseFrom(byte[] bArr, r rVar) {
        return (e) z.parseFrom(DEFAULT_INSTANCE, bArr, rVar);
    }

    public static b1<e> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeApiCall(int i2) {
        ensureApiCallIsMutable();
        this.apiCall_.remove(i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeRpcCall(int i2) {
        ensureRpcCallIsMutable();
        this.rpcCall_.remove(i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeUiInteraction(int i2) {
        ensureUiInteractionIsMutable();
        this.uiInteraction_.remove(i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void removeWorkManagerTask(int i2) {
        ensureWorkManagerTaskIsMutable();
        this.workManagerTask_.remove(i2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setApiCall(int i2, a aVar) {
        aVar.getClass();
        ensureApiCallIsMutable();
        this.apiCall_.set(i2, aVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setBuildId(int i2) {
        this.bitField0_ |= 1;
        this.buildId_ = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setHoursSinceLastBatch(int i2) {
        this.bitField0_ |= 4;
        this.hoursSinceLastBatch_ = i2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setRegionIdentifier(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.regionIdentifier_ = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setRegionIdentifierBytes(j jVar) {
        this.regionIdentifier_ = jVar.B();
        this.bitField0_ |= 2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setRpcCall(int i2, i iVar) {
        iVar.getClass();
        ensureRpcCallIsMutable();
        this.rpcCall_.set(i2, iVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setUiInteraction(int i2, s sVar) {
        sVar.getClass();
        ensureUiInteractionIsMutable();
        this.uiInteraction_.set(i2, sVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setWorkManagerTask(int i2, u uVar) {
        uVar.getClass();
        ensureWorkManagerTaskIsMutable();
        this.workManagerTask_.set(i2, uVar);
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004\u001b\u0005\u0004\u0000\u0006\b\u0001\u0007\u0004\u0002", new Object[]{"bitField0_", "rpcCall_", i.class, "apiCall_", a.class, "workManagerTask_", u.class, "uiInteraction_", s.class, "buildId_", "regionIdentifier_", "hoursSinceLastBatch_"});
            case 3:
                return new e();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<e> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (e.class) {
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

    public a getApiCall(int i2) {
        return this.apiCall_.get(i2);
    }

    public int getApiCallCount() {
        return this.apiCall_.size();
    }

    public List<a> getApiCallList() {
        return this.apiCall_;
    }

    public b getApiCallOrBuilder(int i2) {
        return this.apiCall_.get(i2);
    }

    public List<? extends b> getApiCallOrBuilderList() {
        return this.apiCall_;
    }

    public int getBuildId() {
        return this.buildId_;
    }

    public int getHoursSinceLastBatch() {
        return this.hoursSinceLastBatch_;
    }

    public String getRegionIdentifier() {
        return this.regionIdentifier_;
    }

    public j getRegionIdentifierBytes() {
        return j.n(this.regionIdentifier_);
    }

    public i getRpcCall(int i2) {
        return this.rpcCall_.get(i2);
    }

    public int getRpcCallCount() {
        return this.rpcCall_.size();
    }

    public List<i> getRpcCallList() {
        return this.rpcCall_;
    }

    public j getRpcCallOrBuilder(int i2) {
        return this.rpcCall_.get(i2);
    }

    public List<? extends j> getRpcCallOrBuilderList() {
        return this.rpcCall_;
    }

    public s getUiInteraction(int i2) {
        return this.uiInteraction_.get(i2);
    }

    public int getUiInteractionCount() {
        return this.uiInteraction_.size();
    }

    public List<s> getUiInteractionList() {
        return this.uiInteraction_;
    }

    public t getUiInteractionOrBuilder(int i2) {
        return this.uiInteraction_.get(i2);
    }

    public List<? extends t> getUiInteractionOrBuilderList() {
        return this.uiInteraction_;
    }

    public u getWorkManagerTask(int i2) {
        return this.workManagerTask_.get(i2);
    }

    public int getWorkManagerTaskCount() {
        return this.workManagerTask_.size();
    }

    public List<u> getWorkManagerTaskList() {
        return this.workManagerTask_;
    }

    public v getWorkManagerTaskOrBuilder(int i2) {
        return this.workManagerTask_.get(i2);
    }

    public List<? extends v> getWorkManagerTaskOrBuilderList() {
        return this.workManagerTask_;
    }

    public boolean hasBuildId() {
        return (this.bitField0_ & 1) != 0;
    }

    public boolean hasHoursSinceLastBatch() {
        return (this.bitField0_ & 4) != 0;
    }

    public boolean hasRegionIdentifier() {
        return (this.bitField0_ & 2) != 0;
    }
}
