package f.b.d.a;

import f.b.g.b1;
import f.b.g.c0;
import f.b.g.z;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class a extends z<a, b> implements b {
    private static final a DEFAULT_INSTANCE;
    private static volatile b1<a> PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;
    private c0.i<s> values_ = z.emptyProtobufList();

    public static final class b extends z.a<a, b> implements b {
        public b() {
            super(a.DEFAULT_INSTANCE);
        }

        public b(C0121a aVar) {
            super(a.DEFAULT_INSTANCE);
        }

        @Override // f.b.d.a.b
        public List<s> a() {
            return Collections.unmodifiableList(((a) this.instance).a());
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        z.registerDefaultInstance(a.class, aVar);
    }

    public static void c(a aVar, s sVar) {
        Objects.requireNonNull(aVar);
        sVar.getClass();
        aVar.f();
        aVar.values_.add(sVar);
    }

    public static void d(a aVar, Iterable iterable) {
        aVar.f();
        f.b.g.a.addAll(iterable, (List) aVar.values_);
    }

    public static void e(a aVar, int i2) {
        aVar.f();
        aVar.values_.remove(i2);
    }

    public static a g() {
        return DEFAULT_INSTANCE;
    }

    public static b j() {
        return (b) DEFAULT_INSTANCE.createBuilder();
    }

    @Override // f.b.d.a.b
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"values_", s.class});
            case 3:
                return new a();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<a> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (a.class) {
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

    public final void f() {
        if (!this.values_.g()) {
            this.values_ = z.mutableCopy(this.values_);
        }
    }

    public s h(int i2) {
        return this.values_.get(i2);
    }

    public int i() {
        return this.values_.size();
    }
}
