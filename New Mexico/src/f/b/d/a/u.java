package f.b.d.a;

import f.b.g.b1;
import f.b.g.c0;
import f.b.g.j;
import f.b.g.m0;
import f.b.g.n0;
import f.b.g.y1;
import f.b.g.z;
import java.util.Objects;
/* loaded from: classes.dex */
public final class u extends z<u, b> implements Object {
    public static final int DATABASE_FIELD_NUMBER;
    private static final u DEFAULT_INSTANCE;
    public static final int LABELS_FIELD_NUMBER;
    private static volatile b1<u> PARSER;
    public static final int STREAM_ID_FIELD_NUMBER;
    public static final int STREAM_TOKEN_FIELD_NUMBER;
    public static final int WRITES_FIELD_NUMBER;
    private n0<String, String> labels_ = n0.c;
    private String database_ = "";
    private String streamId_ = "";
    private c0.i<t> writes_ = z.emptyProtobufList();
    private j streamToken_ = j.c;

    /* loaded from: classes.dex */
    public static final class b extends z.a<u, b> implements Object {
        public b() {
            super(u.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(u.DEFAULT_INSTANCE);
        }
    }

    /* loaded from: classes.dex */
    public static final class c {
        public static final m0<String, String> a;

        static {
            y1 y1Var = y1.STRING;
            a = new m0<>(y1Var, "", y1Var, "");
        }
    }

    static {
        u uVar = new u();
        DEFAULT_INSTANCE = uVar;
        z.registerDefaultInstance(u.class, uVar);
    }

    public static void c(u uVar, String str) {
        Objects.requireNonNull(uVar);
        str.getClass();
        uVar.database_ = str;
    }

    public static void d(u uVar, j jVar) {
        Objects.requireNonNull(uVar);
        jVar.getClass();
        uVar.streamToken_ = jVar;
    }

    public static void e(u uVar, t tVar) {
        Objects.requireNonNull(uVar);
        tVar.getClass();
        if (!uVar.writes_.g()) {
            uVar.writes_ = z.mutableCopy(uVar.writes_);
        }
        uVar.writes_.add(tVar);
    }

    public static u f() {
        return DEFAULT_INSTANCE;
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b\u0004\n\u00052", new Object[]{"database_", "streamId_", "writes_", t.class, "streamToken_", "labels_", c.a});
            case 3:
                return new u();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<u> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (u.class) {
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
