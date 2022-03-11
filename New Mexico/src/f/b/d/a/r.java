package f.b.d.a;

import f.b.g.b0;
import f.b.g.b1;
import f.b.g.c0;
import f.b.g.j;
import f.b.g.p1;
import f.b.g.z;
import java.util.List;
/* loaded from: classes.dex */
public final class r extends z<r, b> implements Object {
    public static final int CAUSE_FIELD_NUMBER = 3;
    private static final r DEFAULT_INSTANCE;
    private static volatile b1<r> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 6;
    public static final int RESUME_TOKEN_FIELD_NUMBER = 4;
    public static final int TARGET_CHANGE_TYPE_FIELD_NUMBER = 1;
    public static final int TARGET_IDS_FIELD_NUMBER = 2;
    private f.b.h.a cause_;
    private p1 readTime_;
    private int targetChangeType_;
    private int targetIdsMemoizedSerializedSize = -1;
    private c0.g targetIds_ = z.emptyIntList();
    private j resumeToken_ = j.c;

    /* loaded from: classes.dex */
    public static final class b extends z.a<r, b> implements Object {
        public b(a aVar) {
            super(r.DEFAULT_INSTANCE);
        }
    }

    /* loaded from: classes.dex */
    public enum c implements c0.c {
        NO_CHANGE(0),
        ADD(1),
        REMOVE(2),
        CURRENT(3),
        RESET(4),
        UNRECOGNIZED(-1);
        
        public final int b;

        c(int i2) {
            this.b = i2;
        }

        public static c a(int i2) {
            if (i2 == 0) {
                return NO_CHANGE;
            }
            if (i2 == 1) {
                return ADD;
            }
            if (i2 == 2) {
                return REMOVE;
            }
            if (i2 == 3) {
                return CURRENT;
            }
            if (i2 != 4) {
                return null;
            }
            return RESET;
        }

        @Override // f.b.g.c0.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.b;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    static {
        r rVar = new r();
        DEFAULT_INSTANCE = rVar;
        z.registerDefaultInstance(r.class, rVar);
    }

    public static r d() {
        return DEFAULT_INSTANCE;
    }

    public f.b.h.a c() {
        f.b.h.a aVar = this.cause_;
        return aVar == null ? f.b.h.a.d() : aVar;
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0006\u0005\u0000\u0001\u0000\u0001\f\u0002'\u0003\t\u0004\n\u0006\t", new Object[]{"targetChangeType_", "targetIds_", "cause_", "resumeToken_", "readTime_"});
            case 3:
                return new r();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<r> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (r.class) {
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

    public j f() {
        return this.resumeToken_;
    }

    public c g() {
        c a2 = c.a(this.targetChangeType_);
        return a2 == null ? c.UNRECOGNIZED : a2;
    }

    public int h() {
        return ((b0) this.targetIds_).size();
    }

    public List<Integer> i() {
        return this.targetIds_;
    }
}
