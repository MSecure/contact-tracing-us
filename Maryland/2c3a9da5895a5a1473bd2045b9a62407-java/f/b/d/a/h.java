package f.b.d.a;

import f.b.f.b1;
import f.b.f.c0;
import f.b.f.p1;
import f.b.f.z;
import java.util.List;

public final class h extends z<h, b> implements Object {
    private static final h DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile b1<h> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 4;
    public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 2;
    private String document_ = "";
    private p1 readTime_;
    private int removedTargetIdsMemoizedSerializedSize = -1;
    private c0.g removedTargetIds_ = z.emptyIntList();

    public static final class b extends z.a<h, b> implements Object {
        public b(a aVar) {
            super(h.DEFAULT_INSTANCE);
        }
    }

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        z.registerDefaultInstance(h.class, hVar);
    }

    public static h c() {
        return DEFAULT_INSTANCE;
    }

    public String d() {
        return this.document_;
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0004\u0003\u0000\u0001\u0000\u0001Ȉ\u0002'\u0004\t", new Object[]{"document_", "removedTargetIds_", "readTime_"});
            case 3:
                return new h();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<h> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (h.class) {
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

    public List<Integer> e() {
        return this.removedTargetIds_;
    }
}
