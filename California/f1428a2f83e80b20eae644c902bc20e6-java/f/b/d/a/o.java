package f.b.d.a;

import f.b.f.b1;
import f.b.f.p1;
import f.b.f.z;
import java.util.Objects;

public final class o extends z<o, b> implements Object {
    private static final o DEFAULT_INSTANCE;
    public static final int EXISTS_FIELD_NUMBER = 1;
    private static volatile b1<o> PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 2;
    private int conditionTypeCase_ = 0;
    private Object conditionType_;

    public static final class b extends z.a<o, b> implements Object {
        public b() {
            super(o.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(o.DEFAULT_INSTANCE);
        }
    }

    public enum c {
        EXISTS(1),
        UPDATE_TIME(2),
        CONDITIONTYPE_NOT_SET(0);

        /* access modifiers changed from: public */
        c(int i2) {
        }
    }

    static {
        o oVar = new o();
        DEFAULT_INSTANCE = oVar;
        z.registerDefaultInstance(o.class, oVar);
    }

    public static void c(o oVar, boolean z) {
        oVar.conditionTypeCase_ = 1;
        oVar.conditionType_ = Boolean.valueOf(z);
    }

    public static void d(o oVar, p1 p1Var) {
        Objects.requireNonNull(oVar);
        p1Var.getClass();
        oVar.conditionType_ = p1Var;
        oVar.conditionTypeCase_ = 2;
    }

    public static o f() {
        return DEFAULT_INSTANCE;
    }

    public static b i() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    @Override // f.b.f.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001:\u0000\u0002<\u0000", new Object[]{"conditionType_", "conditionTypeCase_", p1.class});
            case 3:
                return new o();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<o> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (o.class) {
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

    public c e() {
        int i2 = this.conditionTypeCase_;
        if (i2 == 0) {
            return c.CONDITIONTYPE_NOT_SET;
        }
        if (i2 == 1) {
            return c.EXISTS;
        }
        if (i2 != 2) {
            return null;
        }
        return c.UPDATE_TIME;
    }

    public boolean g() {
        if (this.conditionTypeCase_ == 1) {
            return ((Boolean) this.conditionType_).booleanValue();
        }
        return false;
    }

    public p1 h() {
        return this.conditionTypeCase_ == 2 ? (p1) this.conditionType_ : p1.e();
    }
}
