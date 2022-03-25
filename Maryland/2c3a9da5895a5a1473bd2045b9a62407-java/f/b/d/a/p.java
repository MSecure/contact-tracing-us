package f.b.d.a;

import f.b.f.a0;
import f.b.f.b1;
import f.b.f.c0;
import f.b.f.z;
import java.util.List;
import java.util.Objects;

public final class p extends z<p, b> implements Object {
    private static final p DEFAULT_INSTANCE;
    public static final int END_AT_FIELD_NUMBER = 8;
    public static final int FROM_FIELD_NUMBER = 2;
    public static final int LIMIT_FIELD_NUMBER = 5;
    public static final int OFFSET_FIELD_NUMBER = 6;
    public static final int ORDER_BY_FIELD_NUMBER = 4;
    private static volatile b1<p> PARSER = null;
    public static final int SELECT_FIELD_NUMBER = 1;
    public static final int START_AT_FIELD_NUMBER = 7;
    public static final int WHERE_FIELD_NUMBER = 3;
    private c endAt_;
    private c0.i<c> from_ = z.emptyProtobufList();
    private a0 limit_;
    private int offset_;
    private c0.i<i> orderBy_ = z.emptyProtobufList();
    private j select_;
    private c startAt_;
    private h where_;

    public static final class b extends z.a<p, b> implements Object {
        public b() {
            super(p.DEFAULT_INSTANCE);
        }

        public b(a aVar) {
            super(p.DEFAULT_INSTANCE);
        }
    }

    public static final class c extends z<c, a> implements Object {
        public static final int ALL_DESCENDANTS_FIELD_NUMBER = 3;
        public static final int COLLECTION_ID_FIELD_NUMBER = 2;
        private static final c DEFAULT_INSTANCE;
        private static volatile b1<c> PARSER;
        private boolean allDescendants_;
        private String collectionId_ = "";

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
            cVar.collectionId_ = str;
        }

        public static void d(c cVar, boolean z) {
            cVar.allDescendants_ = z;
        }

        public static a g() {
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
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002Ȉ\u0003\u0007", new Object[]{"collectionId_", "allDescendants_"});
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

        public boolean e() {
            return this.allDescendants_;
        }

        public String f() {
            return this.collectionId_;
        }
    }

    public static final class d extends z<d, a> implements Object {
        private static final d DEFAULT_INSTANCE;
        public static final int FILTERS_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile b1<d> PARSER;
        private c0.i<h> filters_ = z.emptyProtobufList();
        private int op_;

        public static final class a extends z.a<d, a> implements Object {
            public a() {
                super(d.DEFAULT_INSTANCE);
            }

            public a(a aVar) {
                super(d.DEFAULT_INSTANCE);
            }
        }

        public enum b implements c0.c {
            OPERATOR_UNSPECIFIED(0),
            AND(1),
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

        static {
            d dVar = new d();
            DEFAULT_INSTANCE = dVar;
            z.registerDefaultInstance(d.class, dVar);
        }

        public static void c(d dVar, b bVar) {
            Objects.requireNonNull(dVar);
            dVar.op_ = bVar.getNumber();
        }

        public static void d(d dVar, Iterable iterable) {
            if (!dVar.filters_.g()) {
                dVar.filters_ = z.mutableCopy(dVar.filters_);
            }
            f.b.f.a.addAll(iterable, (List) dVar.filters_);
        }

        public static d e() {
            return DEFAULT_INSTANCE;
        }

        public static a h() {
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
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0002\u001b", new Object[]{"op_", "filters_", h.class});
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

        public List<h> f() {
            return this.filters_;
        }

        public b g() {
            int i2 = this.op_;
            b bVar = i2 != 0 ? i2 != 1 ? null : b.AND : b.OPERATOR_UNSPECIFIED;
            return bVar == null ? b.UNRECOGNIZED : bVar;
        }
    }

    public enum e implements c0.c {
        DIRECTION_UNSPECIFIED(0),
        ASCENDING(1),
        DESCENDING(2),
        UNRECOGNIZED(-1);
        
        public final int b;

        /* access modifiers changed from: public */
        e(int i2) {
            this.b = i2;
        }

        public static e a(int i2) {
            if (i2 == 0) {
                return DIRECTION_UNSPECIFIED;
            }
            if (i2 == 1) {
                return ASCENDING;
            }
            if (i2 != 2) {
                return null;
            }
            return DESCENDING;
        }

        @Override // f.b.f.c0.c
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.b;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
    }

    public static final class f extends z<f, a> implements Object {
        private static final f DEFAULT_INSTANCE;
        public static final int FIELD_FIELD_NUMBER = 1;
        public static final int OP_FIELD_NUMBER = 2;
        private static volatile b1<f> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 3;
        private g field_;
        private int op_;
        private s value_;

        public static final class a extends z.a<f, a> implements Object {
            public a() {
                super(f.DEFAULT_INSTANCE);
            }

            public a(a aVar) {
                super(f.DEFAULT_INSTANCE);
            }
        }

        public enum b implements c0.c {
            OPERATOR_UNSPECIFIED(0),
            LESS_THAN(1),
            LESS_THAN_OR_EQUAL(2),
            GREATER_THAN(3),
            GREATER_THAN_OR_EQUAL(4),
            EQUAL(5),
            NOT_EQUAL(6),
            ARRAY_CONTAINS(7),
            IN(8),
            ARRAY_CONTAINS_ANY(9),
            NOT_IN(10),
            UNRECOGNIZED(-1);
            
            public final int b;

            /* access modifiers changed from: public */
            b(int i2) {
                this.b = i2;
            }

            public static b a(int i2) {
                switch (i2) {
                    case 0:
                        return OPERATOR_UNSPECIFIED;
                    case 1:
                        return LESS_THAN;
                    case 2:
                        return LESS_THAN_OR_EQUAL;
                    case 3:
                        return GREATER_THAN;
                    case 4:
                        return GREATER_THAN_OR_EQUAL;
                    case 5:
                        return EQUAL;
                    case 6:
                        return NOT_EQUAL;
                    case 7:
                        return ARRAY_CONTAINS;
                    case 8:
                        return IN;
                    case 9:
                        return ARRAY_CONTAINS_ANY;
                    case 10:
                        return NOT_IN;
                    default:
                        return null;
                }
            }

            @Override // f.b.f.c0.c
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.b;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            f fVar = new f();
            DEFAULT_INSTANCE = fVar;
            z.registerDefaultInstance(f.class, fVar);
        }

        public static void c(f fVar, g gVar) {
            Objects.requireNonNull(fVar);
            gVar.getClass();
            fVar.field_ = gVar;
        }

        public static void d(f fVar, b bVar) {
            Objects.requireNonNull(fVar);
            fVar.op_ = bVar.getNumber();
        }

        public static void e(f fVar, s sVar) {
            Objects.requireNonNull(fVar);
            sVar.getClass();
            fVar.value_ = sVar;
        }

        public static f f() {
            return DEFAULT_INSTANCE;
        }

        public static a j() {
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
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\f\u0003\t", new Object[]{"field_", "op_", "value_"});
                case 3:
                    return new f();
                case 4:
                    return new a(null);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    b1<f> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (f.class) {
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

        public g g() {
            g gVar = this.field_;
            return gVar == null ? g.d() : gVar;
        }

        public b h() {
            b a2 = b.a(this.op_);
            return a2 == null ? b.UNRECOGNIZED : a2;
        }

        public s i() {
            s sVar = this.value_;
            return sVar == null ? s.q() : sVar;
        }
    }

    public static final class g extends z<g, a> implements Object {
        private static final g DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 2;
        private static volatile b1<g> PARSER;
        private String fieldPath_ = "";

        public static final class a extends z.a<g, a> implements Object {
            public a() {
                super(g.DEFAULT_INSTANCE);
            }

            public a(a aVar) {
                super(g.DEFAULT_INSTANCE);
            }
        }

        static {
            g gVar = new g();
            DEFAULT_INSTANCE = gVar;
            z.registerDefaultInstance(g.class, gVar);
        }

        public static void c(g gVar, String str) {
            Objects.requireNonNull(gVar);
            str.getClass();
            gVar.fieldPath_ = str;
        }

        public static g d() {
            return DEFAULT_INSTANCE;
        }

        public static a f() {
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
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002Ȉ", new Object[]{"fieldPath_"});
                case 3:
                    return new g();
                case 4:
                    return new a(null);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    b1<g> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (g.class) {
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

        public String e() {
            return this.fieldPath_;
        }
    }

    public static final class h extends z<h, a> implements Object {
        public static final int COMPOSITE_FILTER_FIELD_NUMBER = 1;
        private static final h DEFAULT_INSTANCE;
        public static final int FIELD_FILTER_FIELD_NUMBER = 2;
        private static volatile b1<h> PARSER = null;
        public static final int UNARY_FILTER_FIELD_NUMBER = 3;
        private int filterTypeCase_ = 0;
        private Object filterType_;

        public static final class a extends z.a<h, a> implements Object {
            public a() {
                super(h.DEFAULT_INSTANCE);
            }

            public a(a aVar) {
                super(h.DEFAULT_INSTANCE);
            }
        }

        public enum b {
            COMPOSITE_FILTER(1),
            FIELD_FILTER(2),
            UNARY_FILTER(3),
            FILTERTYPE_NOT_SET(0);

            /* access modifiers changed from: public */
            b(int i2) {
            }
        }

        static {
            h hVar = new h();
            DEFAULT_INSTANCE = hVar;
            z.registerDefaultInstance(h.class, hVar);
        }

        public static void b(h hVar, f fVar) {
            Objects.requireNonNull(hVar);
            fVar.getClass();
            hVar.filterType_ = fVar;
            hVar.filterTypeCase_ = 2;
        }

        public static void c(h hVar, k kVar) {
            Objects.requireNonNull(hVar);
            kVar.getClass();
            hVar.filterType_ = kVar;
            hVar.filterTypeCase_ = 3;
        }

        public static void e(h hVar, d dVar) {
            Objects.requireNonNull(hVar);
            dVar.getClass();
            hVar.filterType_ = dVar;
            hVar.filterTypeCase_ = 1;
        }

        public static h g() {
            return DEFAULT_INSTANCE;
        }

        public static a k() {
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
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"filterType_", "filterTypeCase_", d.class, f.class, k.class});
                case 3:
                    return new h();
                case 4:
                    return new a(null);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    b1<h> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (h.class) {
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
            return this.filterTypeCase_ == 1 ? (d) this.filterType_ : d.e();
        }

        public f h() {
            return this.filterTypeCase_ == 2 ? (f) this.filterType_ : f.f();
        }

        public b i() {
            int i2 = this.filterTypeCase_;
            if (i2 == 0) {
                return b.FILTERTYPE_NOT_SET;
            }
            if (i2 == 1) {
                return b.COMPOSITE_FILTER;
            }
            if (i2 == 2) {
                return b.FIELD_FILTER;
            }
            if (i2 != 3) {
                return null;
            }
            return b.UNARY_FILTER;
        }

        public k j() {
            return this.filterTypeCase_ == 3 ? (k) this.filterType_ : k.e();
        }
    }

    public static final class i extends z<i, a> implements Object {
        private static final i DEFAULT_INSTANCE;
        public static final int DIRECTION_FIELD_NUMBER = 2;
        public static final int FIELD_FIELD_NUMBER = 1;
        private static volatile b1<i> PARSER;
        private int direction_;
        private g field_;

        public static final class a extends z.a<i, a> implements Object {
            public a() {
                super(i.DEFAULT_INSTANCE);
            }

            public a(a aVar) {
                super(i.DEFAULT_INSTANCE);
            }
        }

        static {
            i iVar = new i();
            DEFAULT_INSTANCE = iVar;
            z.registerDefaultInstance(i.class, iVar);
        }

        public static void c(i iVar, g gVar) {
            Objects.requireNonNull(iVar);
            gVar.getClass();
            iVar.field_ = gVar;
        }

        public static void d(i iVar, e eVar) {
            Objects.requireNonNull(iVar);
            iVar.direction_ = eVar.getNumber();
        }

        public static a g() {
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
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\f", new Object[]{"field_", "direction_"});
                case 3:
                    return new i();
                case 4:
                    return new a(null);
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

        public e e() {
            e a2 = e.a(this.direction_);
            return a2 == null ? e.UNRECOGNIZED : a2;
        }

        public g f() {
            g gVar = this.field_;
            return gVar == null ? g.d() : gVar;
        }
    }

    public static final class j extends z<j, a> implements Object {
        private static final j DEFAULT_INSTANCE;
        public static final int FIELDS_FIELD_NUMBER = 2;
        private static volatile b1<j> PARSER;
        private c0.i<g> fields_ = z.emptyProtobufList();

        public static final class a extends z.a<j, a> implements Object {
            public a(a aVar) {
                super(j.DEFAULT_INSTANCE);
            }
        }

        static {
            j jVar = new j();
            DEFAULT_INSTANCE = jVar;
            z.registerDefaultInstance(j.class, jVar);
        }

        @Override // f.b.f.z
        public final Object dynamicMethod(z.f fVar, Object obj, Object obj2) {
            switch (fVar.ordinal()) {
                case 0:
                    return (byte) 1;
                case 1:
                    return null;
                case 2:
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002\u001b", new Object[]{"fields_", g.class});
                case 3:
                    return new j();
                case 4:
                    return new a(null);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    b1<j> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (j.class) {
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

    public static final class k extends z<k, a> implements Object {
        private static final k DEFAULT_INSTANCE;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile b1<k> PARSER;
        private int op_;
        private int operandTypeCase_ = 0;
        private Object operandType_;

        public static final class a extends z.a<k, a> implements Object {
            public a() {
                super(k.DEFAULT_INSTANCE);
            }

            public a(a aVar) {
                super(k.DEFAULT_INSTANCE);
            }
        }

        public enum b implements c0.c {
            OPERATOR_UNSPECIFIED(0),
            IS_NAN(2),
            IS_NULL(3),
            IS_NOT_NAN(4),
            IS_NOT_NULL(5),
            UNRECOGNIZED(-1);
            
            public final int b;

            /* access modifiers changed from: public */
            b(int i2) {
                this.b = i2;
            }

            public static b a(int i2) {
                if (i2 == 0) {
                    return OPERATOR_UNSPECIFIED;
                }
                if (i2 == 2) {
                    return IS_NAN;
                }
                if (i2 == 3) {
                    return IS_NULL;
                }
                if (i2 == 4) {
                    return IS_NOT_NAN;
                }
                if (i2 != 5) {
                    return null;
                }
                return IS_NOT_NULL;
            }

            @Override // f.b.f.c0.c
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.b;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }
        }

        static {
            k kVar = new k();
            DEFAULT_INSTANCE = kVar;
            z.registerDefaultInstance(k.class, kVar);
        }

        public static void c(k kVar, b bVar) {
            Objects.requireNonNull(kVar);
            kVar.op_ = bVar.getNumber();
        }

        public static void d(k kVar, g gVar) {
            Objects.requireNonNull(kVar);
            gVar.getClass();
            kVar.operandType_ = gVar;
            kVar.operandTypeCase_ = 2;
        }

        public static k e() {
            return DEFAULT_INSTANCE;
        }

        public static a h() {
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
                    return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002<\u0000", new Object[]{"operandType_", "operandTypeCase_", "op_", g.class});
                case 3:
                    return new k();
                case 4:
                    return new a(null);
                case 5:
                    return DEFAULT_INSTANCE;
                case 6:
                    b1<k> b1Var = PARSER;
                    if (b1Var == null) {
                        synchronized (k.class) {
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

        public g f() {
            return this.operandTypeCase_ == 2 ? (g) this.operandType_ : g.d();
        }

        public b g() {
            b a2 = b.a(this.op_);
            return a2 == null ? b.UNRECOGNIZED : a2;
        }
    }

    static {
        p pVar = new p();
        DEFAULT_INSTANCE = pVar;
        z.registerDefaultInstance(p.class, pVar);
    }

    public static void c(p pVar, c cVar) {
        Objects.requireNonNull(pVar);
        cVar.getClass();
        if (!pVar.from_.g()) {
            pVar.from_ = z.mutableCopy(pVar.from_);
        }
        pVar.from_.add(cVar);
    }

    public static void d(p pVar, h hVar) {
        Objects.requireNonNull(pVar);
        hVar.getClass();
        pVar.where_ = hVar;
    }

    public static void e(p pVar, i iVar) {
        Objects.requireNonNull(pVar);
        iVar.getClass();
        if (!pVar.orderBy_.g()) {
            pVar.orderBy_ = z.mutableCopy(pVar.orderBy_);
        }
        pVar.orderBy_.add(iVar);
    }

    public static void f(p pVar, c cVar) {
        Objects.requireNonNull(pVar);
        cVar.getClass();
        pVar.startAt_ = cVar;
    }

    public static void g(p pVar, c cVar) {
        Objects.requireNonNull(pVar);
        cVar.getClass();
        pVar.endAt_ = cVar;
    }

    public static void h(p pVar, a0 a0Var) {
        Objects.requireNonNull(pVar);
        a0Var.getClass();
        pVar.limit_ = a0Var;
    }

    public static p i() {
        return DEFAULT_INSTANCE;
    }

    public static b v() {
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
                return z.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0002\u0000\u0001\t\u0002\u001b\u0003\t\u0004\u001b\u0005\t\u0006\u0004\u0007\t\b\t", new Object[]{"select_", "from_", c.class, "where_", "orderBy_", i.class, "limit_", "offset_", "startAt_", "endAt_"});
            case 3:
                return new p();
            case 4:
                return new b(null);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                b1<p> b1Var = PARSER;
                if (b1Var == null) {
                    synchronized (p.class) {
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

    public c j() {
        c cVar = this.endAt_;
        return cVar == null ? c.f() : cVar;
    }

    public c k(int i2) {
        return this.from_.get(i2);
    }

    public int l() {
        return this.from_.size();
    }

    public a0 m() {
        a0 a0Var = this.limit_;
        return a0Var == null ? a0.d() : a0Var;
    }

    public i n(int i2) {
        return this.orderBy_.get(i2);
    }

    public int o() {
        return this.orderBy_.size();
    }

    public c p() {
        c cVar = this.startAt_;
        return cVar == null ? c.f() : cVar;
    }

    public h q() {
        h hVar = this.where_;
        return hVar == null ? h.g() : hVar;
    }

    public boolean r() {
        return this.endAt_ != null;
    }

    public boolean s() {
        return this.limit_ != null;
    }

    public boolean t() {
        return this.startAt_ != null;
    }

    public boolean u() {
        return this.where_ != null;
    }
}
