package f.b.d.a;

import f.b.g.b1;
import f.b.g.z;
import java.util.Objects;

public final class t extends z<t, b> implements Object {
    public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 4;
    private static final t DEFAULT_INSTANCE;
    public static final int DELETE_FIELD_NUMBER = 2;
    private static volatile b1<t> PARSER = null;
    public static final int TRANSFORM_FIELD_NUMBER = 6;
    public static final int UPDATE_FIELD_NUMBER = 1;
    public static final int UPDATE_MASK_FIELD_NUMBER = 3;
    public static final int VERIFY_FIELD_NUMBER = 5;
    private o currentDocument_;
    private int operationCase_ = 0;
    private Object operation_;
    private g updateMask_;

    public static final class b extends z.a<t, b> implements Object {
        public b() {
            super(t.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(t.DEFAULT_INSTANCE);
        }
    }

    public enum c {
        UPDATE(1),
        DELETE(2),
        VERIFY(5),
        TRANSFORM(6),
        OPERATION_NOT_SET(0);

        /* access modifiers changed from: public */
        c(int i2) {
        }
    }

    static {
        t tVar = new t();
        DEFAULT_INSTANCE = tVar;
        z.registerDefaultInstance(t.class, tVar);
    }

    public static void c(t tVar, i iVar) {
        Objects.requireNonNull(tVar);
        iVar.getClass();
        tVar.operation_ = iVar;
        tVar.operationCase_ = 6;
    }

    public static void d(t tVar, g gVar) {
        Objects.requireNonNull(tVar);
        gVar.getClass();
        tVar.updateMask_ = gVar;
    }

    public static void e(t tVar, o oVar) {
        Objects.requireNonNull(tVar);
        oVar.getClass();
        tVar.currentDocument_ = oVar;
    }

    public static void f(t tVar, d dVar) {
        Objects.requireNonNull(tVar);
        dVar.getClass();
        tVar.operation_ = dVar;
        tVar.operationCase_ = 1;
    }

    public static void g(t tVar, String str) {
        Objects.requireNonNull(tVar);
        str.getClass();
        tVar.operationCase_ = 2;
        tVar.operation_ = str;
    }

    public static void h(t tVar, String str) {
        Objects.requireNonNull(tVar);
        str.getClass();
        tVar.operationCase_ = 5;
        tVar.operation_ = str;
    }

    public static b r() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001<\u0000\u0002Ȼ\u0000\u0003\t\u0004\t\u0005Ȼ\u0000\u0006<\u0000", new Object[]{"operation_", "operationCase_", d.class, "updateMask_", "currentDocument_", i.class});
            case 3:
                return new t();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<t> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (t.class) {
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

    public o i() {
        o oVar = this.currentDocument_;
        return oVar == null ? o.f() : oVar;
    }

    public String j() {
        return this.operationCase_ == 2 ? (String) this.operation_ : "";
    }

    public c k() {
        int i2 = this.operationCase_;
        if (i2 == 0) {
            return c.OPERATION_NOT_SET;
        }
        if (i2 == 1) {
            return c.UPDATE;
        }
        if (i2 == 2) {
            return c.DELETE;
        }
        if (i2 == 5) {
            return c.VERIFY;
        }
        if (i2 != 6) {
            return null;
        }
        return c.TRANSFORM;
    }

    public i l() {
        return this.operationCase_ == 6 ? (i) this.operation_ : i.e();
    }

    public d m() {
        return this.operationCase_ == 1 ? (d) this.operation_ : d.f();
    }

    public g n() {
        g gVar = this.updateMask_;
        return gVar == null ? g.d() : gVar;
    }

    public String o() {
        return this.operationCase_ == 5 ? (String) this.operation_ : "";
    }

    public boolean p() {
        return this.currentDocument_ != null;
    }

    public boolean q() {
        return this.updateMask_ != null;
    }
}
