package f.b.d.a;

import f.b.g.b1;
import f.b.g.c0;
import f.b.g.z;
import java.util.List;
/* loaded from: classes.dex */
public final class c extends z<c, b> implements Object {
    public static final int BEFORE_FIELD_NUMBER = 2;
    private static final c DEFAULT_INSTANCE;
    private static volatile b1<c> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private boolean before_;
    private c0.i<s> values_ = z.emptyProtobufList();

    /* loaded from: classes.dex */
    public static final class b extends z.a<c, b> implements Object {
        public b() {
            super(c.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(c.DEFAULT_INSTANCE);
        }
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        z.registerDefaultInstance(c.class, cVar);
    }

    public static void c(c cVar, Iterable iterable) {
        if (!cVar.values_.g()) {
            cVar.values_ = z.mutableCopy(cVar.values_);
        }
        f.b.g.a.addAll(iterable, (List) cVar.values_);
    }

    public static void d(c cVar, boolean z) {
        cVar.before_ = z;
    }

    public static c f() {
        return DEFAULT_INSTANCE;
    }

    public static b g() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public List<s> a() {
        return this.values_;
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0007", new Object[]{"values_", s.class, "before_"});
            case 3:
                return new c();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<c> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (c.class) {
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

    public boolean e() {
        return this.before_;
    }
}
