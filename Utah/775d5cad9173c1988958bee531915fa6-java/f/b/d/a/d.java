package f.b.d.a;

import f.b.g.b1;
import f.b.g.m0;
import f.b.g.n0;
import f.b.g.p1;
import f.b.g.y1;
import f.b.g.z;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public final class d extends z<d, b> implements Object {
    public static final int CREATE_TIME_FIELD_NUMBER = 3;
    private static final d DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile b1<d> PARSER = null;
    public static final int UPDATE_TIME_FIELD_NUMBER = 4;
    private p1 createTime_;
    private n0<String, s> fields_ = n0.c;
    private String name_ = "";
    private p1 updateTime_;

    public static final class b extends z.a<d, b> implements Object {
        public b() {
            super(d.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(d.DEFAULT_INSTANCE);
        }
    }

    public static final class c {
        public static final m0<String, s> a = new m0<>(y1.STRING, "", y1.MESSAGE, s.q());
    }

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        z.registerDefaultInstance(d.class, dVar);
    }

    public static void c(d dVar, String str) {
        Objects.requireNonNull(dVar);
        str.getClass();
        dVar.name_ = str;
    }

    public static Map d(d dVar) {
        n0<String, s> n0Var = dVar.fields_;
        if (!n0Var.b) {
            dVar.fields_ = n0Var.c();
        }
        return dVar.fields_;
    }

    public static void e(d dVar, p1 p1Var) {
        Objects.requireNonNull(dVar);
        p1Var.getClass();
        dVar.updateTime_ = p1Var;
    }

    public static d f() {
        return DEFAULT_INSTANCE;
    }

    public static b j() {
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0001\u0000\u0000\u0001Ȉ\u00022\u0003\t\u0004\t", new Object[]{"name_", "fields_", c.a, "createTime_", "updateTime_"});
            case 3:
                return new d();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<d> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (d.class) {
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

    public Map<String, s> g() {
        return Collections.unmodifiableMap(this.fields_);
    }

    public String h() {
        return this.name_;
    }

    public p1 i() {
        p1 p1Var = this.updateTime_;
        return p1Var == null ? p1.e() : p1Var;
    }
}
