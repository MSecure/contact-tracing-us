package f.b.d.a;

import f.b.g.b1;
import f.b.g.c0;
import f.b.g.j;
import f.b.g.p1;
import f.b.g.z;
import java.util.Objects;
/* loaded from: classes.dex */
public final class q extends z<q, b> implements Object {
    private static final q DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER;
    public static final int ONCE_FIELD_NUMBER;
    private static volatile b1<q> PARSER;
    public static final int QUERY_FIELD_NUMBER;
    public static final int READ_TIME_FIELD_NUMBER;
    public static final int RESUME_TOKEN_FIELD_NUMBER;
    public static final int TARGET_ID_FIELD_NUMBER;
    private boolean once_;
    private Object resumeType_;
    private int targetId_;
    private Object targetType_;
    private int targetTypeCase_ = 0;
    private int resumeTypeCase_ = 0;

    /* loaded from: classes.dex */
    public static final class b extends z.a<q, b> implements Object {
        public b() {
            super(q.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(q.DEFAULT_INSTANCE);
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends z<c, a> implements Object {
        private static final c DEFAULT_INSTANCE;
        public static final int DOCUMENTS_FIELD_NUMBER;
        private static volatile b1<c> PARSER;
        private c0.i<String> documents_ = z.emptyProtobufList();

        /* loaded from: classes.dex */
        public static final class a extends z.a<c, a> implements Object {
            public a() {
                super(c.DEFAULT_INSTANCE);
            }

            public a(a aVar) {
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
            if (!cVar.documents_.g()) {
                cVar.documents_ = z.mutableCopy(cVar.documents_);
            }
            cVar.documents_.add(str);
        }

        public static c d() {
            return DEFAULT_INSTANCE;
        }

        public static a g() {
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
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002Ț", new Object[]{"documents_"});
                case 3:
                    return new c();
                case 4:
                    return new a(null);
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

        public String e(int i2) {
            return this.documents_.get(i2);
        }

        public int f() {
            return this.documents_.size();
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends z<d, a> implements Object {
        private static final d DEFAULT_INSTANCE;
        public static final int PARENT_FIELD_NUMBER;
        private static volatile b1<d> PARSER;
        public static final int STRUCTURED_QUERY_FIELD_NUMBER;
        private Object queryType_;
        private int queryTypeCase_ = 0;
        private String parent_ = "";

        /* loaded from: classes.dex */
        public static final class a extends z.a<d, a> implements Object {
            public a() {
                super(d.DEFAULT_INSTANCE);
            }

            public a(a aVar) {
                super(d.DEFAULT_INSTANCE);
            }
        }

        static {
            d dVar = new d();
            DEFAULT_INSTANCE = dVar;
            z.registerDefaultInstance(d.class, dVar);
        }

        public static void b(d dVar, p pVar) {
            Objects.requireNonNull(dVar);
            pVar.getClass();
            dVar.queryType_ = pVar;
            dVar.queryTypeCase_ = 2;
        }

        public static void d(d dVar, String str) {
            Objects.requireNonNull(dVar);
            str.getClass();
            dVar.parent_ = str;
        }

        public static d e() {
            return DEFAULT_INSTANCE;
        }

        public static a h() {
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
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000", new Object[]{"queryType_", "queryTypeCase_", "parent_", p.class});
                case 3:
                    return new d();
                case 4:
                    return new a(null);
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

        public String f() {
            return this.parent_;
        }

        public p g() {
            return this.queryTypeCase_ == 2 ? (p) this.queryType_ : p.i();
        }
    }

    static {
        q qVar = new q();
        DEFAULT_INSTANCE = qVar;
        z.registerDefaultInstance(q.class, qVar);
    }

    public static void c(q qVar, d dVar) {
        Objects.requireNonNull(qVar);
        dVar.getClass();
        qVar.targetType_ = dVar;
        qVar.targetTypeCase_ = 2;
    }

    public static void d(q qVar, c cVar) {
        Objects.requireNonNull(qVar);
        cVar.getClass();
        qVar.targetType_ = cVar;
        qVar.targetTypeCase_ = 3;
    }

    public static void e(q qVar, j jVar) {
        Objects.requireNonNull(qVar);
        jVar.getClass();
        qVar.resumeTypeCase_ = 4;
        qVar.resumeType_ = jVar;
    }

    public static void f(q qVar, int i2) {
        qVar.targetId_ = i2;
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0002\u0000\u0002\u000b\u0006\u0000\u0000\u0000\u0002<\u0000\u0003<\u0000\u0004=\u0001\u0005\u0004\u0006\u0007\u000b<\u0001", new Object[]{"targetType_", "targetTypeCase_", "resumeType_", "resumeTypeCase_", d.class, c.class, "targetId_", "once_", p1.class});
            case 3:
                return new q();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<q> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (q.class) {
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
