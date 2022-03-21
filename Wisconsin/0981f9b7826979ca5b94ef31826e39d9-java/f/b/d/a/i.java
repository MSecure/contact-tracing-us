package f.b.d.a;

import f.b.f.b1;
import f.b.f.c0;
import f.b.f.z;
import java.util.List;
import java.util.Objects;

public final class i extends z<i, b> implements Object {
    private static final i DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    public static final int FIELD_TRANSFORMS_FIELD_NUMBER = 2;
    private static volatile b1<i> PARSER;
    private String document_ = "";
    private c0.i<c> fieldTransforms_ = z.emptyProtobufList();

    public static final class b extends z.a<i, b> implements Object {
        public b() {
            super(i.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(i.DEFAULT_INSTANCE);
        }
    }

    public static final class c extends z<c, a> implements Object {
        public static final int APPEND_MISSING_ELEMENTS_FIELD_NUMBER = 6;
        private static final c DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int INCREMENT_FIELD_NUMBER = 3;
        public static final int MAXIMUM_FIELD_NUMBER = 4;
        public static final int MINIMUM_FIELD_NUMBER = 5;
        private static volatile b1<c> PARSER = null;
        public static final int REMOVE_ALL_FROM_ARRAY_FIELD_NUMBER = 7;
        public static final int SET_TO_SERVER_VALUE_FIELD_NUMBER = 2;
        private String fieldPath_ = "";
        private int transformTypeCase_ = 0;
        private Object transformType_;

        public static final class a extends z.a<c, a> implements Object {
            public a() {
                super(c.DEFAULT_INSTANCE);
            }

            public a(a aVar) {
                super(c.DEFAULT_INSTANCE);
            }

            public a b(String str) {
                copyOnWrite();
                c.d((c) this.instance, str);
                return this;
            }
        }

        public enum b implements c0.c {
            SERVER_VALUE_UNSPECIFIED(0),
            REQUEST_TIME(1),
            UNRECOGNIZED(-1);
            
            public final int b;

            /* access modifiers changed from: public */
            b(int i2) {
                this.b = i2;
            }

            @Override // f.b.f.c0.c
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.b;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        /* renamed from: f.b.d.a.i$c$c  reason: collision with other inner class name */
        public enum EnumC0119c {
            SET_TO_SERVER_VALUE(2),
            INCREMENT(3),
            MAXIMUM(4),
            MINIMUM(5),
            APPEND_MISSING_ELEMENTS(6),
            REMOVE_ALL_FROM_ARRAY(7),
            TRANSFORMTYPE_NOT_SET(0);

            /* access modifiers changed from: public */
            EnumC0119c(int i2) {
            }
        }

        static {
            c cVar = new c();
            DEFAULT_INSTANCE = cVar;
            z.registerDefaultInstance(c.class, cVar);
        }

        public static void c(c cVar, a aVar) {
            Objects.requireNonNull(cVar);
            aVar.getClass();
            cVar.transformType_ = aVar;
            cVar.transformTypeCase_ = 6;
        }

        public static void d(c cVar, String str) {
            Objects.requireNonNull(cVar);
            str.getClass();
            cVar.fieldPath_ = str;
        }

        public static void e(c cVar, a aVar) {
            Objects.requireNonNull(cVar);
            aVar.getClass();
            cVar.transformType_ = aVar;
            cVar.transformTypeCase_ = 7;
        }

        public static void f(c cVar, b bVar) {
            Objects.requireNonNull(cVar);
            cVar.transformType_ = Integer.valueOf(bVar.getNumber());
            cVar.transformTypeCase_ = 2;
        }

        public static void g(c cVar, s sVar) {
            Objects.requireNonNull(cVar);
            sVar.getClass();
            cVar.transformType_ = sVar;
            cVar.transformTypeCase_ = 3;
        }

        public static a n() {
            return (a) DEFAULT_INSTANCE.createBuilder();
        }

        @Override // f.b.f.z
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (fVar.ordinal()) {
                case 0:
                    return (byte) 1;
                case 1:
                    return null;
                case 2:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0001\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002?\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000\u0007<\u0000", new Object[]{"transformType_", "transformTypeCase_", "fieldPath_", s.class, s.class, s.class, a.class, a.class});
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

        public a h() {
            return this.transformTypeCase_ == 6 ? (a) this.transformType_ : a.g();
        }

        public String i() {
            return this.fieldPath_;
        }

        public s j() {
            return this.transformTypeCase_ == 3 ? (s) this.transformType_ : s.q();
        }

        public a k() {
            return this.transformTypeCase_ == 7 ? (a) this.transformType_ : a.g();
        }

        public b l() {
            b bVar = b.SERVER_VALUE_UNSPECIFIED;
            if (this.transformTypeCase_ != 2) {
                return bVar;
            }
            int intValue = ((Integer) this.transformType_).intValue();
            if (intValue != 0) {
                bVar = intValue != 1 ? null : b.REQUEST_TIME;
            }
            return bVar == null ? b.UNRECOGNIZED : bVar;
        }

        public EnumC0119c m() {
            int i2 = this.transformTypeCase_;
            if (i2 == 0) {
                return EnumC0119c.TRANSFORMTYPE_NOT_SET;
            }
            switch (i2) {
                case 2:
                    return EnumC0119c.SET_TO_SERVER_VALUE;
                case 3:
                    return EnumC0119c.INCREMENT;
                case 4:
                    return EnumC0119c.MAXIMUM;
                case 5:
                    return EnumC0119c.MINIMUM;
                case 6:
                    return EnumC0119c.APPEND_MISSING_ELEMENTS;
                case 7:
                    return EnumC0119c.REMOVE_ALL_FROM_ARRAY;
                default:
                    return null;
            }
        }
    }

    static {
        i iVar = new i();
        DEFAULT_INSTANCE = iVar;
        z.registerDefaultInstance(i.class, iVar);
    }

    public static void c(i iVar, String str) {
        Objects.requireNonNull(iVar);
        str.getClass();
        iVar.document_ = str;
    }

    public static void d(i iVar, c cVar) {
        Objects.requireNonNull(iVar);
        cVar.getClass();
        if (!iVar.fieldTransforms_.g()) {
            iVar.fieldTransforms_ = z.mutableCopy(iVar.fieldTransforms_);
        }
        iVar.fieldTransforms_.add(cVar);
    }

    public static i e() {
        return DEFAULT_INSTANCE;
    }

    public static b h() {
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"document_", "fieldTransforms_", c.class});
            case 3:
                return new i();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<i> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (i.class) {
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
        return this.document_;
    }

    public List<c> g() {
        return this.fieldTransforms_;
    }
}
