package c.b.c.a.i0;

import c.b.c.a.j0.a.a0;
import c.b.c.a.j0.a.c1;
import c.b.c.a.j0.a.d1;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import c.b.c.a.j0.a.y0;

public final class z0 extends y<z0, b> implements Object {
    public static final z0 DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    public static volatile y0<z0> PARSER = null;
    public static final int PRIMARY_KEY_ID_FIELD_NUMBER = 1;
    public a0.c<c> key_ = c1.f4900e;
    public int primaryKeyId_;

    public static final class c extends y<c, a> implements Object {
        public static final c DEFAULT_INSTANCE;
        public static final int KEY_DATA_FIELD_NUMBER = 1;
        public static final int KEY_ID_FIELD_NUMBER = 3;
        public static final int OUTPUT_PREFIX_TYPE_FIELD_NUMBER = 4;
        public static volatile y0<c> PARSER = null;
        public static final int STATUS_FIELD_NUMBER = 2;
        public v0 keyData_;
        public int keyId_;
        public int outputPrefixType_;
        public int status_;

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            y.defaultInstanceMap.put(c.class, cVar);
        }

        public static void n(c cVar, v0 v0Var) {
            if (cVar != null) {
                v0Var.getClass();
                cVar.keyData_ = v0Var;
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
                    return new d1(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"keyData_", "status_", "keyId_", "outputPrefixType_"});
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

        public v0 q() {
            v0 v0Var = this.keyData_;
            return v0Var == null ? v0.DEFAULT_INSTANCE : v0Var;
        }

        public f1 r() {
            f1 b2 = f1.b(this.outputPrefixType_);
            return b2 == null ? f1.UNRECOGNIZED : b2;
        }

        public w0 s() {
            w0 b2 = w0.b(this.status_);
            return b2 == null ? w0.UNRECOGNIZED : b2;
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
        z0 z0Var = new z0();
        DEFAULT_INSTANCE = z0Var;
        y.defaultInstanceMap.put(z0.class, z0Var);
    }

    public static void n(z0 z0Var, c cVar) {
        if (z0Var != null) {
            cVar.getClass();
            if (!z0Var.key_.m()) {
                a0.c<c> cVar2 = z0Var.key_;
                int size = cVar2.size();
                z0Var.key_ = cVar2.i(size == 0 ? 10 : size * 2);
            }
            z0Var.key_.add(cVar);
            return;
        }
        throw null;
    }

    public static z0 o(byte[] bArr, q qVar) {
        return (z0) y.l(DEFAULT_INSTANCE, bArr, qVar);
    }

    @Override // c.b.c.a.j0.a.y
    public final Object f(y.f fVar, Object obj, Object obj2) {
        switch (fVar.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new d1(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"primaryKeyId_", "key_", c.class});
            case 3:
                return new z0();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                y0<z0> y0Var = PARSER;
                if (y0Var == null) {
                    synchronized (z0.class) {
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

    public static final class b extends y.a<z0, b> implements Object {
        public b() {
            super(z0.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(z0.DEFAULT_INSTANCE);
        }
    }
}
