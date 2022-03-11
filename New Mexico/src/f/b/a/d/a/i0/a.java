package f.b.a.d.a.i0;

import f.b.g.b1;
import f.b.g.c;
import f.b.g.c0;
import f.b.g.z;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public final class a extends z<a, b> implements Object {
    public static final int DATA_BITS_FIELD_NUMBER;
    private static final a DEFAULT_INSTANCE;
    private static volatile b1<a> PARSER;
    public static final int PRIO_PARAMETERS_FIELD_NUMBER;
    public static final int PUBLIC_KEYS_FIELD_NUMBER;
    private int bitField0_;
    private d prioParameters_;
    private c0.i<String> publicKeys_ = z.emptyProtobufList();
    private c0.g dataBits_ = z.emptyIntList();

    /* loaded from: classes.dex */
    public static final class b extends z.a<a, b> implements Object {
        public b() {
            super(a.DEFAULT_INSTANCE);
        }

        public b(C0090a aVar) {
            super(a.DEFAULT_INSTANCE);
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        z.registerDefaultInstance(a.class, aVar);
    }

    public static void c(a aVar, d dVar) {
        Objects.requireNonNull(aVar);
        dVar.getClass();
        aVar.prioParameters_ = dVar;
        aVar.bitField0_ |= 1;
    }

    public static void d(a aVar, Iterable iterable) {
        c0.g gVar = aVar.dataBits_;
        if (!((c) gVar).b) {
            aVar.dataBits_ = z.mutableCopy(gVar);
        }
        f.b.g.a.addAll(iterable, (List) aVar.dataBits_);
    }

    public static void e(a aVar, String str) {
        Objects.requireNonNull(aVar);
        str.getClass();
        if (!aVar.publicKeys_.g()) {
            aVar.publicKeys_ = z.mutableCopy(aVar.publicKeys_);
        }
        aVar.publicKeys_.add(str);
    }

    public static b g() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    @Override // f.b.g.z
    public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\t\u0000\u0002\u001a\u0003\u001d", new Object[]{"bitField0_", "prioParameters_", "publicKeys_", "dataBits_"});
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

    public d f() {
        d dVar = this.prioParameters_;
        return dVar == null ? d.h() : dVar;
    }
}
