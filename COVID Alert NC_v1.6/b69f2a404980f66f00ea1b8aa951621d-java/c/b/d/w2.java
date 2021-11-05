package c.b.d;

public final class w2 {

    public enum b {
        DOUBLE(c.DOUBLE, 1),
        FLOAT(c.FLOAT, 5),
        INT64(c.LONG, 0),
        UINT64(c.LONG, 0),
        INT32(c.INT, 0),
        FIXED64(c.LONG, 1),
        FIXED32(c.INT, 5),
        BOOL(c.BOOLEAN, 0),
        STRING(c.STRING, 2) {
            @Override // c.b.d.w2.b
            public boolean b() {
                return false;
            }
        },
        GROUP(c.MESSAGE, 3) {
            @Override // c.b.d.w2.b
            public boolean b() {
                return false;
            }
        },
        MESSAGE(c.MESSAGE, 2) {
            @Override // c.b.d.w2.b
            public boolean b() {
                return false;
            }
        },
        BYTES(c.BYTE_STRING, 2) {
            @Override // c.b.d.w2.b
            public boolean b() {
                return false;
            }
        },
        UINT32(c.INT, 0),
        ENUM(c.ENUM, 0),
        SFIXED32(c.INT, 5),
        SFIXED64(c.LONG, 1),
        SINT32(c.INT, 0),
        SINT64(c.LONG, 0);
        

        /* renamed from: b  reason: collision with root package name */
        public final c f4373b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4374c;

        /* access modifiers changed from: public */
        b(c cVar, int i) {
            this.f4373b = cVar;
            this.f4374c = i;
        }

        /* access modifiers changed from: public */
        b(c cVar, int i, a aVar) {
            this.f4373b = cVar;
            this.f4374c = i;
        }

        public boolean b() {
            return true;
        }
    }

    public enum c {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(j.f3914c),
        ENUM(null),
        MESSAGE(null);
        

        /* renamed from: b  reason: collision with root package name */
        public final Object f4378b;

        /* access modifiers changed from: public */
        c(Object obj) {
            this.f4378b = obj;
        }
    }

    public enum d {
        LOOSE {
            @Override // c.b.d.w2.d
            public Object b(k kVar) {
                return kVar.E();
            }
        },
        STRICT {
            @Override // c.b.d.w2.d
            public Object b(k kVar) {
                return kVar.F();
            }
        },
        LAZY {
            @Override // c.b.d.w2.d
            public Object b(k kVar) {
                return kVar.n();
            }
        };

        /* access modifiers changed from: public */
        d(a aVar) {
        }

        public abstract Object b(k kVar);
    }

    public static Object a(k kVar, b bVar, d dVar) {
        switch (bVar.ordinal()) {
            case 0:
                return Double.valueOf(kVar.o());
            case 1:
                return Float.valueOf(kVar.s());
            case 2:
                return Long.valueOf(kVar.v());
            case 3:
                return Long.valueOf(kVar.I());
            case 4:
                return Integer.valueOf(kVar.u());
            case 5:
                return Long.valueOf(kVar.r());
            case 6:
                return Integer.valueOf(kVar.q());
            case 7:
                return Boolean.valueOf(kVar.m());
            case 8:
                return dVar.b(kVar);
            case 9:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 10:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 11:
                return kVar.n();
            case 12:
                return Integer.valueOf(kVar.H());
            case 13:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            case 14:
                return Integer.valueOf(kVar.A());
            case 15:
                return Long.valueOf(kVar.B());
            case 16:
                return Integer.valueOf(kVar.C());
            case 17:
                return Long.valueOf(kVar.D());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
