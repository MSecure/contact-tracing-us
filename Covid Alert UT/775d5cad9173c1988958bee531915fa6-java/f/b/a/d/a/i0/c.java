package f.b.a.d.a.i0;

import f.b.g.b1;
import f.b.g.z;
import java.util.Objects;

public final class c extends z<c, b> implements Object {
    public static final int CREATED_FIELD_NUMBER = 2;
    private static final c DEFAULT_INSTANCE;
    public static final int PACKETS_RESPONSE_FIELD_NUMBER = 5;
    private static volatile b1<c> PARSER = null;
    public static final int PRIO_PARAMS_FIELD_NUMBER = 3;
    public static final int SCHEMA_VERSION_FIELD_NUMBER = 4;
    public static final int UUID_FIELD_NUMBER = 1;
    private int bitField0_;
    private String created_ = "";
    private b packetsResponse_;
    private d prioParams_;
    private int schemaVersion_;
    private String uuid_ = "";

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

    public static void c(c cVar, String str) {
        Objects.requireNonNull(cVar);
        str.getClass();
        cVar.bitField0_ |= 1;
        cVar.uuid_ = str;
    }

    public static void d(c cVar, int i2) {
        cVar.bitField0_ |= 8;
        cVar.schemaVersion_ = i2;
    }

    public static void e(c cVar, b bVar) {
        Objects.requireNonNull(cVar);
        bVar.getClass();
        cVar.packetsResponse_ = bVar;
        cVar.bitField0_ |= 16;
    }

    public static void f(c cVar, d dVar) {
        Objects.requireNonNull(cVar);
        dVar.getClass();
        cVar.prioParams_ = dVar;
        cVar.bitField0_ |= 4;
    }

    public static b g() {
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\t\u0002\u0004\u0004\u0003\u0005\t\u0004", new Object[]{"bitField0_", "uuid_", "created_", "prioParams_", "schemaVersion_", "packetsResponse_"});
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
}
