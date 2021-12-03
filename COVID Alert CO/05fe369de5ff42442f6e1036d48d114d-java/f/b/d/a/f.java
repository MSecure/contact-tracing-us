package f.b.d.a;

import f.b.g.b1;
import f.b.g.c0;
import f.b.g.p1;
import f.b.g.z;
import java.util.List;

public final class f extends z<f, b> implements Object {
    private static final f DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile b1<f> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 4;
    public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 6;
    private String document_ = "";
    private p1 readTime_;
    private int removedTargetIdsMemoizedSerializedSize = -1;
    private c0.g removedTargetIds_ = z.emptyIntList();

    public static final class b extends z.a<f, b> implements Object {
        public b(a aVar) {
            super(f.DEFAULT_INSTANCE);
        }
    }

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        z.registerDefaultInstance(f.class, fVar);
    }

    public static f c() {
        return DEFAULT_INSTANCE;
    }

    public String d() {
        return this.document_;
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0006\u0003\u0000\u0001\u0000\u0001Ȉ\u0004\t\u0006'", new Object[]{"document_", "readTime_", "removedTargetIds_"});
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

    public p1 e() {
        p1 p1Var = this.readTime_;
        return p1Var == null ? p1.e() : p1Var;
    }

    public List<Integer> f() {
        return this.removedTargetIds_;
    }
}
