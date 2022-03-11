package f.b.a.a.a.h0;

import f.b.a.a.a.h0.a;
import f.b.a.a.a.h0.d;
import f.b.a.a.a.h0.n;
import f.b.a.a.a.h0.p;
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
/* loaded from: classes.dex */
public final class c extends z<c, b> implements Object {
    public static final int API_CALL_FIELD_NUMBER;
    public static final int BUILD_ID_FIELD_NUMBER;
    private static final c DEFAULT_INSTANCE;
    public static final int HOURS_SINCE_LAST_BATCH_FIELD_NUMBER;
    private static volatile b1<c> PARSER;
    public static final int REGION_IDENTIFIER_FIELD_NUMBER;
    public static final int RPC_CALL_FIELD_NUMBER;
    public static final int UI_INTERACTION_FIELD_NUMBER;
    public static final int WORK_MANAGER_TASK_FIELD_NUMBER;
    private int bitField0_;
    private int buildId_;
    private int hoursSinceLastBatch_;
    private c0.i<d> rpcCall_ = z.emptyProtobufList();
    private c0.i<a> apiCall_ = z.emptyProtobufList();
    private c0.i<p> workManagerTask_ = z.emptyProtobufList();
    private c0.i<n> uiInteraction_ = z.emptyProtobufList();
    private String regionIdentifier_ = "";

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
    public static final class b extends z.a<c, b> implements Object {
        private b() {
            super(c.DEFAULT_INSTANCE);
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public b addAllApiCall(Iterable<? extends a> iterable) {
            copyOnWrite();
            ((c) this.instance).addAllApiCall(iterable);
            return this;
        }

        public b addAllRpcCall(Iterable<? extends d> iterable) {
            copyOnWrite();
            ((c) this.instance).addAllRpcCall(iterable);
            return this;
        }

        public b addAllUiInteraction(Iterable<? extends n> iterable) {
            copyOnWrite();
            ((c) this.instance).addAllUiInteraction(iterable);
            return this;
        }

        public b addAllWorkManagerTask(Iterable<? extends p> iterable) {
            copyOnWrite();
            ((c) this.instance).addAllWorkManagerTask(iterable);
            return this;
        }

        public b addApiCall(int i2, a.c cVar) {
            copyOnWrite();
            ((c) this.instance).addApiCall(i2, cVar.build());
            return this;
        }

        public b addApiCall(int i2, a aVar) {
            copyOnWrite();
            ((c) this.instance).addApiCall(i2, aVar);
            return this;
        }

        public b addApiCall(a.c cVar) {
            copyOnWrite();
            ((c) this.instance).addApiCall(cVar.build());
            return this;
        }

        public b addApiCall(a aVar) {
            copyOnWrite();
            ((c) this.instance).addApiCall(aVar);
            return this;
        }

        public b addRpcCall(int i2, d.b bVar) {
            copyOnWrite();
            ((c) this.instance).addRpcCall(i2, bVar.build());
            return this;
        }

        public b addRpcCall(int i2, d dVar) {
            copyOnWrite();
            ((c) this.instance).addRpcCall(i2, dVar);
            return this;
        }

        public b addRpcCall(d.b bVar) {
            copyOnWrite();
            ((c) this.instance).addRpcCall(bVar.build());
            return this;
        }

        public b addRpcCall(d dVar) {
            copyOnWrite();
            ((c) this.instance).addRpcCall(dVar);
            return this;
        }

        public b addUiInteraction(int i2, n.b bVar) {
            copyOnWrite();
            ((c) this.instance).addUiInteraction(i2, bVar.build());
            return this;
        }

        public b addUiInteraction(int i2, n nVar) {
            copyOnWrite();
            ((c) this.instance).addUiInteraction(i2, nVar);
            return this;
        }

        public b addUiInteraction(n.b bVar) {
            copyOnWrite();
            ((c) this.instance).addUiInteraction(bVar.build());
            return this;
        }

        public b addUiInteraction(n nVar) {
            copyOnWrite();
            ((c) this.instance).addUiInteraction(nVar);
            return this;
        }

        public b addWorkManagerTask(int i2, p.b bVar) {
            copyOnWrite();
            ((c) this.instance).addWorkManagerTask(i2, bVar.build());
            return this;
        }

        public b addWorkManagerTask(int i2, p pVar) {
            copyOnWrite();
            ((c) this.instance).addWorkManagerTask(i2, pVar);
            return this;
        }

        public b addWorkManagerTask(p.b bVar) {
            copyOnWrite();
            ((c) this.instance).addWorkManagerTask(bVar.build());
            return this;
        }

        public b addWorkManagerTask(p pVar) {
            copyOnWrite();
            ((c) this.instance).addWorkManagerTask(pVar);
            return this;
        }

        public b clearApiCall() {
            copyOnWrite();
            ((c) this.instance).clearApiCall();
            return this;
        }

        public b clearBuildId() {
            copyOnWrite();
            ((c) this.instance).clearBuildId();
            return this;
        }

        public b clearHoursSinceLastBatch() {
            copyOnWrite();
            ((c) this.instance).clearHoursSinceLastBatch();
            return this;
        }

        public b clearRegionIdentifier() {
            copyOnWrite();
            ((c) this.instance).clearRegionIdentifier();
            return this;
        }

        public b clearRpcCall() {
            copyOnWrite();
            ((c) this.instance).clearRpcCall();
            return this;
        }

        public b clearUiInteraction() {
            copyOnWrite();
            ((c) this.instance).clearUiInteraction();
            return this;
        }

        public b clearWorkManagerTask() {
            copyOnWrite();
            ((c) this.instance).clearWorkManagerTask();
            return this;
        }

        public a getApiCall(int i2) {
            return ((c) this.instance).getApiCall(i2);
        }

        public int getApiCallCount() {
            return ((c) this.instance).getApiCallCount();
        }

        public List<a> getApiCallList() {
            return Collections.unmodifiableList(((c) this.instance).getApiCallList());
        }

        public int getBuildId() {
            return ((c) this.instance).getBuildId();
        }

        public int getHoursSinceLastBatch() {
            return ((c) this.instance).getHoursSinceLastBatch();
        }

        public String getRegionIdentifier() {
            return ((c) this.instance).getRegionIdentifier();
        }

        public j getRegionIdentifierBytes() {
            return ((c) this.instance).getRegionIdentifierBytes();
        }

        public d getRpcCall(int i2) {
            return ((c) this.instance).getRpcCall(i2);
        }

        public int getRpcCallCount() {
            return ((c) this.instance).getRpcCallCount();
        }

        public List<d> getRpcCallList() {
            return Collections.unmodifiableList(((c) this.instance).getRpcCallList());
        }

        public n getUiInteraction(int i2) {
            return ((c) this.instance).getUiInteraction(i2);
        }

        public int getUiInteractionCount() {
            return ((c) this.instance).getUiInteractionCount();
        }

        public List<n> getUiInteractionList() {
            return Collections.unmodifiableList(((c) this.instance).getUiInteractionList());
        }

        public p getWorkManagerTask(int i2) {
            return ((c) this.instance).getWorkManagerTask(i2);
        }

        public int getWorkManagerTaskCount() {
            return ((c) this.instance).getWorkManagerTaskCount();
        }

        public List<p> getWorkManagerTaskList() {
            return Collections.unmodifiableList(((c) this.instance).getWorkManagerTaskList());
        }

        public boolean hasBuildId() {
            return ((c) this.instance).hasBuildId();
        }

        public boolean hasHoursSinceLastBatch() {
            return ((c) this.instance).hasHoursSinceLastBatch();
        }

        public boolean hasRegionIdentifier() {
            return ((c) this.instance).hasRegionIdentifier();
        }

        public b removeApiCall(int i2) {
            copyOnWrite();
            ((c) this.instance).removeApiCall(i2);
            return this;
        }

        public b removeRpcCall(int i2) {
            copyOnWrite();
            ((c) this.instance).removeRpcCall(i2);
            return this;
        }

        public b removeUiInteraction(int i2) {
            copyOnWrite();
            ((c) this.instance).removeUiInteraction(i2);
            return this;
        }

        public b removeWorkManagerTask(int i2) {
            copyOnWrite();
            ((c) this.instance).removeWorkManagerTask(i2);
            return this;
        }

        public b setApiCall(int i2, a.c cVar) {
            copyOnWrite();
            ((c) this.instance).setApiCall(i2, cVar.build());
            return this;
        }

        public b setApiCall(int i2, a aVar) {
            copyOnWrite();
            ((c) this.instance).setApiCall(i2, aVar);
            return this;
        }

        public b setBuildId(int i2) {
            copyOnWrite();
            ((c) this.instance).setBuildId(i2);
            return this;
        }

        public b setHoursSinceLastBatch(int i2) {
            copyOnWrite();
            ((c) this.instance).setHoursSinceLastBatch(i2);
            return this;
        }

        public b setRegionIdentifier(String str) {
            copyOnWrite();
            ((c) this.instance).setRegionIdentifier(str);
            return this;
        }

        public b setRegionIdentifierBytes(j jVar) {
            copyOnWrite();
            ((c) this.instance).setRegionIdentifierBytes(jVar);
            return this;
        }

        public b setRpcCall(int i2, d.b bVar) {
            copyOnWrite();
            ((c) this.instance).setRpcCall(i2, bVar.build());
            return this;
        }

        public b setRpcCall(int i2, d dVar) {
            copyOnWrite();
            ((c) this.instance).setRpcCall(i2, dVar);
            return this;
        }

        public b setUiInteraction(int i2, n.b bVar) {
            copyOnWrite();
            ((c) this.instance).setUiInteraction(i2, bVar.build());
            return this;
        }

        public b setUiInteraction(int i2, n nVar) {
            copyOnWrite();
            ((c) this.instance).setUiInteraction(i2, nVar);
            return this;
        }

        public b setWorkManagerTask(int i2, p.b bVar) {
            copyOnWrite();
            ((c) this.instance).setWorkManagerTask(i2, bVar.build());
            return this;
        }

        public b setWorkManagerTask(int i2, p pVar) {
            copyOnWrite();
            ((c) this.instance).setWorkManagerTask(i2, pVar);
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

    public void addAllApiCall(Iterable<? extends a> iterable) {
        ensureApiCallIsMutable();
        f.b.g.a.addAll((Iterable) iterable, (List) this.apiCall_);
    }

    public void addAllRpcCall(Iterable<? extends d> iterable) {
        ensureRpcCallIsMutable();
        f.b.g.a.addAll((Iterable) iterable, (List) this.rpcCall_);
    }

    public void addAllUiInteraction(Iterable<? extends n> iterable) {
        ensureUiInteractionIsMutable();
        f.b.g.a.addAll((Iterable) iterable, (List) this.uiInteraction_);
    }

    public void addAllWorkManagerTask(Iterable<? extends p> iterable) {
        ensureWorkManagerTaskIsMutable();
        f.b.g.a.addAll((Iterable) iterable, (List) this.workManagerTask_);
    }

    public void addApiCall(int i2, a aVar) {
        aVar.getClass();
        ensureApiCallIsMutable();
        this.apiCall_.add(i2, aVar);
    }

    public void addApiCall(a aVar) {
        aVar.getClass();
        ensureApiCallIsMutable();
        this.apiCall_.add(aVar);
    }

    public void addRpcCall(int i2, d dVar) {
        dVar.getClass();
        ensureRpcCallIsMutable();
        this.rpcCall_.add(i2, dVar);
    }

    public void addRpcCall(d dVar) {
        dVar.getClass();
        ensureRpcCallIsMutable();
        this.rpcCall_.add(dVar);
    }

    public void addUiInteraction(int i2, n nVar) {
        nVar.getClass();
        ensureUiInteractionIsMutable();
        this.uiInteraction_.add(i2, nVar);
    }

    public void addUiInteraction(n nVar) {
        nVar.getClass();
        ensureUiInteractionIsMutable();
        this.uiInteraction_.add(nVar);
    }

    public void addWorkManagerTask(int i2, p pVar) {
        pVar.getClass();
        ensureWorkManagerTaskIsMutable();
        this.workManagerTask_.add(i2, pVar);
    }

    public void addWorkManagerTask(p pVar) {
        pVar.getClass();
        ensureWorkManagerTaskIsMutable();
        this.workManagerTask_.add(pVar);
    }

    public void clearApiCall() {
        this.apiCall_ = z.emptyProtobufList();
    }

    public void clearBuildId() {
        this.bitField0_ &= -2;
        this.buildId_ = 0;
    }

    public void clearHoursSinceLastBatch() {
        this.bitField0_ &= -5;
        this.hoursSinceLastBatch_ = 0;
    }

    public void clearRegionIdentifier() {
        this.bitField0_ &= -3;
        this.regionIdentifier_ = getDefaultInstance().getRegionIdentifier();
    }

    public void clearRpcCall() {
        this.rpcCall_ = z.emptyProtobufList();
    }

    public void clearUiInteraction() {
        this.uiInteraction_ = z.emptyProtobufList();
    }

    public void clearWorkManagerTask() {
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

    public static c getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static b newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static b newBuilder(c cVar) {
        return DEFAULT_INSTANCE.createBuilder(cVar);
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

    public void removeApiCall(int i2) {
        ensureApiCallIsMutable();
        this.apiCall_.remove(i2);
    }

    public void removeRpcCall(int i2) {
        ensureRpcCallIsMutable();
        this.rpcCall_.remove(i2);
    }

    public void removeUiInteraction(int i2) {
        ensureUiInteractionIsMutable();
        this.uiInteraction_.remove(i2);
    }

    public void removeWorkManagerTask(int i2) {
        ensureWorkManagerTaskIsMutable();
        this.workManagerTask_.remove(i2);
    }

    public void setApiCall(int i2, a aVar) {
        aVar.getClass();
        ensureApiCallIsMutable();
        this.apiCall_.set(i2, aVar);
    }

    public void setBuildId(int i2) {
        this.bitField0_ |= 1;
        this.buildId_ = i2;
    }

    public void setHoursSinceLastBatch(int i2) {
        this.bitField0_ |= 4;
        this.hoursSinceLastBatch_ = i2;
    }

    public void setRegionIdentifier(String str) {
        str.getClass();
        this.bitField0_ |= 2;
        this.regionIdentifier_ = str;
    }

    public void setRegionIdentifierBytes(j jVar) {
        this.regionIdentifier_ = jVar.B();
        this.bitField0_ |= 2;
    }

    public void setRpcCall(int i2, d dVar) {
        dVar.getClass();
        ensureRpcCallIsMutable();
        this.rpcCall_.set(i2, dVar);
    }

    public void setUiInteraction(int i2, n nVar) {
        nVar.getClass();
        ensureUiInteractionIsMutable();
        this.uiInteraction_.set(i2, nVar);
    }

    public void setWorkManagerTask(int i2, p pVar) {
        pVar.getClass();
        ensureWorkManagerTaskIsMutable();
        this.workManagerTask_.set(i2, pVar);
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004\u001b\u0005\u0004\u0000\u0006\b\u0001\u0007\u0004\u0002", new Object[]{"bitField0_", "rpcCall_", d.class, "apiCall_", a.class, "workManagerTask_", p.class, "uiInteraction_", n.class, "buildId_", "regionIdentifier_", "hoursSinceLastBatch_"});
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

    public d getRpcCall(int i2) {
        return this.rpcCall_.get(i2);
    }

    public int getRpcCallCount() {
        return this.rpcCall_.size();
    }

    public List<d> getRpcCallList() {
        return this.rpcCall_;
    }

    public e getRpcCallOrBuilder(int i2) {
        return this.rpcCall_.get(i2);
    }

    public List<? extends e> getRpcCallOrBuilderList() {
        return this.rpcCall_;
    }

    public n getUiInteraction(int i2) {
        return this.uiInteraction_.get(i2);
    }

    public int getUiInteractionCount() {
        return this.uiInteraction_.size();
    }

    public List<n> getUiInteractionList() {
        return this.uiInteraction_;
    }

    public o getUiInteractionOrBuilder(int i2) {
        return this.uiInteraction_.get(i2);
    }

    public List<? extends o> getUiInteractionOrBuilderList() {
        return this.uiInteraction_;
    }

    public p getWorkManagerTask(int i2) {
        return this.workManagerTask_.get(i2);
    }

    public int getWorkManagerTaskCount() {
        return this.workManagerTask_.size();
    }

    public List<p> getWorkManagerTaskList() {
        return this.workManagerTask_;
    }

    public q getWorkManagerTaskOrBuilder(int i2) {
        return this.workManagerTask_.get(i2);
    }

    public List<? extends q> getWorkManagerTaskOrBuilderList() {
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
