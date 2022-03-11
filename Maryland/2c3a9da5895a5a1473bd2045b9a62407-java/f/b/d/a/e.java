package f.b.d.a;

import f.b.f.b1;
import f.b.f.c0;
import f.b.f.z;
import java.util.List;

public final class e extends z<e, b> implements Object {
    private static final e DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile b1<e> PARSER = null;
    public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 6;
    public static final int TARGET_IDS_FIELD_NUMBER = 5;
    private d document_;
    private int removedTargetIdsMemoizedSerializedSize = -1;
    private c0.g removedTargetIds_ = z.emptyIntList();
    private int targetIdsMemoizedSerializedSize = -1;
    private c0.g targetIds_ = z.emptyIntList();

    public static final class b extends z.a<e, b> implements Object {
        public b(a aVar) {
            super(e.DEFAULT_INSTANCE);
        }
    }

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        z.registerDefaultInstance(e.class, eVar);
    }

    public static e c() {
        return DEFAULT_INSTANCE;
    }

    public d d() {
        d dVar = this.document_;
        return dVar == null ? d.f() : dVar;
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0006\u0003\u0000\u0002\u0000\u0001\t\u0005'\u0006'", new Object[]{"document_", "targetIds_", "removedTargetIds_"});
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

    public List<Integer> e() {
        return this.removedTargetIds_;
    }

    public List<Integer> f() {
        return this.targetIds_;
    }
}
