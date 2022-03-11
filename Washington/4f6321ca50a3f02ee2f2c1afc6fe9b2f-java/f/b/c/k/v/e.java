package f.b.c.k.v;

import f.b.d.a.t;
import f.b.f.b1;
import f.b.f.c0;
import f.b.f.j;
import f.b.f.p1;
import f.b.f.z;
import java.util.Objects;

public final class e extends z<e, b> implements Object {
    public static final int BASE_WRITES_FIELD_NUMBER = 4;
    public static final int BATCH_ID_FIELD_NUMBER = 1;
    private static final e DEFAULT_INSTANCE;
    public static final int LOCAL_WRITE_TIME_FIELD_NUMBER = 3;
    private static volatile b1<e> PARSER = null;
    public static final int WRITES_FIELD_NUMBER = 2;
    private c0.i<t> baseWrites_ = z.emptyProtobufList();
    private int batchId_;
    private p1 localWriteTime_;
    private c0.i<t> writes_ = z.emptyProtobufList();

    public static final class b extends z.a<e, b> implements Object {
        public b() {
            super(e.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(e.DEFAULT_INSTANCE);
        }
    }

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        z.registerDefaultInstance(e.class, eVar);
    }

    public static void c(e eVar, int i2) {
        eVar.batchId_ = i2;
    }

    public static void d(e eVar, t tVar) {
        Objects.requireNonNull(eVar);
        tVar.getClass();
        if (!eVar.baseWrites_.g()) {
            eVar.baseWrites_ = z.mutableCopy(eVar.baseWrites_);
        }
        eVar.baseWrites_.add(tVar);
    }

    public static void e(e eVar, t tVar) {
        Objects.requireNonNull(eVar);
        tVar.getClass();
        if (!eVar.writes_.g()) {
            eVar.writes_ = z.mutableCopy(eVar.writes_);
        }
        eVar.writes_.add(tVar);
    }

    public static void f(e eVar, p1 p1Var) {
        Objects.requireNonNull(eVar);
        p1Var.getClass();
        eVar.localWriteTime_ = p1Var;
    }

    public static b m() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    public static e n(j jVar) {
        return (e) z.parseFrom(DEFAULT_INSTANCE, jVar);
    }

    public static e o(byte[] bArr) {
        return (e) z.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0002\u0000\u0001\u0004\u0002\u001b\u0003\t\u0004\u001b", new Object[]{"batchId_", "writes_", t.class, "localWriteTime_", "baseWrites_", t.class});
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

    public t g(int i2) {
        return this.baseWrites_.get(i2);
    }

    public int h() {
        return this.baseWrites_.size();
    }

    public int i() {
        return this.batchId_;
    }

    public p1 j() {
        p1 p1Var = this.localWriteTime_;
        return p1Var == null ? p1.e() : p1Var;
    }

    public t k(int i2) {
        return this.writes_.get(i2);
    }

    public int l() {
        return this.writes_.size();
    }
}
