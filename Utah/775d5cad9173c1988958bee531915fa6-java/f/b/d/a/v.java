package f.b.d.a;

import f.b.g.b1;
import f.b.g.c0;
import f.b.g.j;
import f.b.g.p1;
import f.b.g.z;

public final class v extends z<v, b> implements Object {
    public static final int COMMIT_TIME_FIELD_NUMBER = 4;
    private static final v DEFAULT_INSTANCE;
    private static volatile b1<v> PARSER = null;
    public static final int STREAM_ID_FIELD_NUMBER = 1;
    public static final int STREAM_TOKEN_FIELD_NUMBER = 2;
    public static final int WRITE_RESULTS_FIELD_NUMBER = 3;
    private p1 commitTime_;
    private String streamId_ = "";
    private j streamToken_ = j.c;
    private c0.i<w> writeResults_ = z.emptyProtobufList();

    public static final class b extends z.a<v, b> implements Object {
        public b(a aVar) {
            super(v.DEFAULT_INSTANCE);
        }
    }

    static {
        v vVar = new v();
        DEFAULT_INSTANCE = vVar;
        z.registerDefaultInstance(v.class, vVar);
    }

    public static v d() {
        return DEFAULT_INSTANCE;
    }

    public p1 c() {
        p1 p1Var = this.commitTime_;
        return p1Var == null ? p1.e() : p1Var;
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\n\u0003\u001b\u0004\t", new Object[]{"streamId_", "streamToken_", "writeResults_", w.class, "commitTime_"});
            case 3:
                return new v();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<v> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (v.class) {
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

    public j e() {
        return this.streamToken_;
    }

    public w f(int i2) {
        return this.writeResults_.get(i2);
    }

    public int g() {
        return this.writeResults_.size();
    }
}
