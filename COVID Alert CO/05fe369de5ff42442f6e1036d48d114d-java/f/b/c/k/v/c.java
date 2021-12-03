package f.b.c.k.v;

import f.b.d.a.q;
import f.b.g.b1;
import f.b.g.j;
import f.b.g.p1;
import f.b.g.z;
import java.util.Objects;

public final class c extends z<c, b> implements Object {
    private static final c DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 6;
    public static final int LAST_LIMBO_FREE_SNAPSHOT_VERSION_FIELD_NUMBER = 7;
    public static final int LAST_LISTEN_SEQUENCE_NUMBER_FIELD_NUMBER = 4;
    private static volatile b1<c> PARSER = null;
    public static final int QUERY_FIELD_NUMBER = 5;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 3;
    public static final int SNAPSHOT_VERSION_FIELD_NUMBER = 2;
    public static final int TARGET_ID_FIELD_NUMBER = 1;
    private p1 lastLimboFreeSnapshotVersion_;
    private long lastListenSequenceNumber_;
    private j resumeToken_ = j.c;
    private p1 snapshotVersion_;
    private int targetId_;
    private int targetTypeCase_ = 0;
    private Object targetType_;

    public static final class b extends z.a<c, b> implements Object {
        public b() {
            super(c.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(c.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: f.b.c.k.v.c$c  reason: collision with other inner class name */
    public enum EnumC0118c {
        QUERY(5),
        DOCUMENTS(6),
        TARGETTYPE_NOT_SET(0);

        /* access modifiers changed from: public */
        EnumC0118c(int i2) {
        }
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        z.registerDefaultInstance(c.class, cVar);
    }

    public static void c(c cVar, q.d dVar) {
        Objects.requireNonNull(cVar);
        dVar.getClass();
        cVar.targetType_ = dVar;
        cVar.targetTypeCase_ = 5;
    }

    public static void d(c cVar, q.c cVar2) {
        Objects.requireNonNull(cVar);
        cVar2.getClass();
        cVar.targetType_ = cVar2;
        cVar.targetTypeCase_ = 6;
    }

    public static void e(c cVar, p1 p1Var) {
        Objects.requireNonNull(cVar);
        p1Var.getClass();
        cVar.lastLimboFreeSnapshotVersion_ = p1Var;
    }

    public static void f(c cVar) {
        cVar.lastLimboFreeSnapshotVersion_ = null;
    }

    public static void g(c cVar, int i2) {
        cVar.targetId_ = i2;
    }

    public static void h(c cVar, p1 p1Var) {
        Objects.requireNonNull(cVar);
        p1Var.getClass();
        cVar.snapshotVersion_ = p1Var;
    }

    public static void i(c cVar, j jVar) {
        Objects.requireNonNull(cVar);
        jVar.getClass();
        cVar.resumeToken_ = jVar;
    }

    public static void j(c cVar, long j2) {
        cVar.lastListenSequenceNumber_ = j2;
    }

    public static b s() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static c t(byte[] bArr) {
        return (c) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002\t\u0003\n\u0004\u0002\u0005<\u0000\u0006<\u0000\u0007\t", new Object[]{"targetType_", "targetTypeCase_", "targetId_", "snapshotVersion_", "resumeToken_", "lastListenSequenceNumber_", q.d.class, q.c.class, "lastLimboFreeSnapshotVersion_"});
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

    public q.c k() {
        return this.targetTypeCase_ == 6 ? (q.c) this.targetType_ : q.c.d();
    }

    public p1 l() {
        p1 p1Var = this.lastLimboFreeSnapshotVersion_;
        return p1Var == null ? p1.e() : p1Var;
    }

    public long m() {
        return this.lastListenSequenceNumber_;
    }

    public q.d n() {
        return this.targetTypeCase_ == 5 ? (q.d) this.targetType_ : q.d.e();
    }

    public j o() {
        return this.resumeToken_;
    }

    public p1 p() {
        p1 p1Var = this.snapshotVersion_;
        return p1Var == null ? p1.e() : p1Var;
    }

    public int q() {
        return this.targetId_;
    }

    public EnumC0118c r() {
        int i2 = this.targetTypeCase_;
        if (i2 == 0) {
            return EnumC0118c.TARGETTYPE_NOT_SET;
        }
        if (i2 == 5) {
            return EnumC0118c.QUERY;
        }
        if (i2 != 6) {
            return null;
        }
        return EnumC0118c.DOCUMENTS;
    }
}
