package f.b.d.a;

import f.b.f.b1;
import f.b.f.m0;
import f.b.f.n0;
import f.b.f.y1;
import f.b.f.z;
import java.util.Collections;
import java.util.Map;

public final class n extends z<n, b> implements Object {
    private static final n DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 1;
    private static volatile b1<n> PARSER;
    private n0<String, s> fields_ = n0.c;

    public static final class b extends z.a<n, b> implements Object {
        public b() {
            super(n.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(n.DEFAULT_INSTANCE);
        }

        public b b(String str, s sVar) {
            str.getClass();
            sVar.getClass();
            copyOnWrite();
            ((n0) n.c((n) this.instance)).put(str, sVar);
            return this;
        }
    }

    public static final class c {
        public static final m0<String, s> a = new m0<>(y1.STRING, "", y1.MESSAGE, s.q());
    }

    static {
        n nVar = new n();
        DEFAULT_INSTANCE = nVar;
        z.registerDefaultInstance(n.class, nVar);
    }

    public static Map c(n nVar) {
        n0<String, s> n0Var = nVar.fields_;
        if (!n0Var.b) {
            nVar.fields_ = n0Var.c();
        }
        return nVar.fields_;
    }

    public static n d() {
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"fields_", c.a});
            case 3:
                return new n();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<n> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (n.class) {
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

    public int e() {
        return this.fields_.size();
    }

    public Map<String, s> f() {
        return Collections.unmodifiableMap(this.fields_);
    }

    public s g(String str, s sVar) {
        str.getClass();
        n0<String, s> n0Var = this.fields_;
        if (n0Var.containsKey(str)) {
            return n0Var.get(str);
        }
        return null;
    }

    public s h(String str) {
        str.getClass();
        n0<String, s> n0Var = this.fields_;
        if (n0Var.containsKey(str)) {
            return n0Var.get(str);
        }
        throw new IllegalArgumentException();
    }
}
