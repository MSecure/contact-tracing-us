package f.b.d.a;

import f.b.g.b1;
import f.b.g.z;
/* loaded from: classes.dex */
public final class m extends z<m, b> implements Object {
    private static final m DEFAULT_INSTANCE;
    public static final int DOCUMENT_CHANGE_FIELD_NUMBER;
    public static final int DOCUMENT_DELETE_FIELD_NUMBER;
    public static final int DOCUMENT_REMOVE_FIELD_NUMBER;
    public static final int FILTER_FIELD_NUMBER;
    private static volatile b1<m> PARSER;
    public static final int TARGET_CHANGE_FIELD_NUMBER;
    private int responseTypeCase_ = 0;
    private Object responseType_;

    /* loaded from: classes.dex */
    public static final class b extends z.a<m, b> implements Object {
        public b(a aVar) {
            super(m.DEFAULT_INSTANCE);
        }
    }

    /* loaded from: classes.dex */
    public enum c {
        TARGET_CHANGE(2),
        DOCUMENT_CHANGE(3),
        DOCUMENT_DELETE(4),
        DOCUMENT_REMOVE(6),
        FILTER(5),
        RESPONSETYPE_NOT_SET(0);

        c(int i2) {
        }
    }

    static {
        m mVar = new m();
        DEFAULT_INSTANCE = mVar;
        z.registerDefaultInstance(m.class, mVar);
    }

    public static m c() {
        return DEFAULT_INSTANCE;
    }

    public e d() {
        return this.responseTypeCase_ == 3 ? (e) this.responseType_ : e.c();
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0001\u0000\u0002\u0006\u0005\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"responseType_", "responseTypeCase_", r.class, e.class, f.class, j.class, h.class});
            case 3:
                return new m();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<m> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (m.class) {
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

    public f e() {
        return this.responseTypeCase_ == 4 ? (f) this.responseType_ : f.c();
    }

    public h f() {
        return this.responseTypeCase_ == 6 ? (h) this.responseType_ : h.c();
    }

    public j g() {
        return this.responseTypeCase_ == 5 ? (j) this.responseType_ : j.c();
    }

    public c h() {
        int i2 = this.responseTypeCase_;
        if (i2 == 0) {
            return c.RESPONSETYPE_NOT_SET;
        }
        if (i2 == 2) {
            return c.TARGET_CHANGE;
        }
        if (i2 == 3) {
            return c.DOCUMENT_CHANGE;
        }
        if (i2 == 4) {
            return c.DOCUMENT_DELETE;
        }
        if (i2 == 5) {
            return c.FILTER;
        }
        if (i2 != 6) {
            return null;
        }
        return c.DOCUMENT_REMOVE;
    }

    public r i() {
        return this.responseTypeCase_ == 2 ? (r) this.responseType_ : r.d();
    }
}
