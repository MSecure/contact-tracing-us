package c.b.c.a.i0;

import c.b.c.a.j0.a.a0;
import c.b.c.a.j0.a.c1;
import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class a1 extends y<a1, b> implements Object {
    public static final a1 DEFAULT_INSTANCE;
    public static final int KEY_INFO_FIELD_NUMBER = 2;
    public static volatile y0<a1> PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    public a0.c<c> keyInfo_ = c1.f3531e;
    public int primaryKeyId_;

    public static final class c extends y<c, a> implements Object {
        public static final c DEFAULT_INSTANCE;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        public static volatile y0<c> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        public static final int TYPE_URL_FIELD_NUMBER = 1;
        public int keyId_;
        public int outputPrefixType_;
        public int status_;
        public String typeUrl_ = "";

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            y.defaultInstanceMap.put(c.class, cVar);
        }

        public static void n(c cVar, String str) {
            if (cVar != null) {
                str.getClass();
                cVar.typeUrl_ = str;
                return;
            }
            throw null;
        }

        public static void o(c cVar, f1 f1Var) {
            if (cVar != null) {
                cVar.outputPrefixType_ = f1Var.a();
                return;
            }
            throw null;
        }

        public static void p(c cVar, w0 w0Var) {
            if (cVar != null) {
                cVar.status_ = w0Var.a();
                return;
            }
            throw null;
        }

        @Override // c.b.c.a.j0.a.y
        public final Object f(y.f fVar, Object obj, Object obj2) {
            switch (fVar.ordinal()) {
                case 0:
                    return (byte) 1;
                case 1:
                    return null;
                case 2:
                    return new d1(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"typeUrl_", "status_", "keyId_", "outputPrefixType_"});
                case 3:
                    return new c();
                case 4:
                    return new a(null);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    y0<c> y0Var = PARSER;
                    if (y0Var == null) {
                        synchronized (c.class) {
                            y0Var = PARSER;
                            if (y0Var == null) {
                                y0Var = new y.b<>(DEFAULT_INSTANCE);
                                PARSER = y0Var;
                            }
                        }
                    }
                    return y0Var;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends y.a<c, a> implements Object {
            public a() {
                super(c.DEFAULT_INSTANCE);
            }

            public a(a aVar) {
                super(c.DEFAULT_INSTANCE);
            }
        }
    }

    static {
        a1 a1Var = new a1();
        DEFAULT_INSTANCE = a1Var;
        y.defaultInstanceMap.put(a1.class, a1Var);
    }

    public static void n(a1 a1Var, c cVar) {
        if (a1Var != null) {
            cVar.getClass();
            if (!a1Var.keyInfo_.k()) {
                a0.c<c> cVar2 = a1Var.keyInfo_;
                int size = cVar2.size();
                a1Var.keyInfo_ = cVar2.g(size == 0 ? 10 : size * 2);
            }
            a1Var.keyInfo_.add(cVar);
            return;
        }
        throw null;
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "keyInfo_", c.class});
            case 3:
                return new a1();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<a1> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (a1.class) {
                        y0Var = PARSER;
                        if (y0Var == null) {
                            y0Var = new y.b<>(DEFAULT_INSTANCE);
                            PARSER = y0Var;
                        }
                    }
                }
                return y0Var;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static final class b extends y.a<a1, b> implements Object {
        public b() {
            super(a1.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(a1.DEFAULT_INSTANCE);
        }
    }
}
