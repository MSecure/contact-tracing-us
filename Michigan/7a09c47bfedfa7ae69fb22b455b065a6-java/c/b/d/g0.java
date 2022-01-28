package c.b.d;

/* JADX WARN: Init of enum e can be incorrect */
/* JADX WARN: Init of enum f can be incorrect */
/* JADX WARN: Init of enum g can be incorrect */
/* JADX WARN: Init of enum h can be incorrect */
/* JADX WARN: Init of enum i can be incorrect */
/* JADX WARN: Init of enum j can be incorrect */
/* JADX WARN: Init of enum k can be incorrect */
/* JADX WARN: Init of enum l can be incorrect */
/* JADX WARN: Init of enum m can be incorrect */
/* JADX WARN: Init of enum n can be incorrect */
/* JADX WARN: Init of enum o can be incorrect */
/* JADX WARN: Init of enum p can be incorrect */
/* JADX WARN: Init of enum q can be incorrect */
/* JADX WARN: Init of enum r can be incorrect */
/* JADX WARN: Init of enum s can be incorrect */
/* JADX WARN: Init of enum t can be incorrect */
/* JADX WARN: Init of enum u can be incorrect */
/* JADX WARN: Init of enum v can be incorrect */
/* JADX WARN: Init of enum w can be incorrect */
/* JADX WARN: Init of enum x can be incorrect */
/* JADX WARN: Init of enum y can be incorrect */
/* JADX WARN: Init of enum z can be incorrect */
/* JADX WARN: Init of enum A can be incorrect */
/* JADX WARN: Init of enum B can be incorrect */
/* JADX WARN: Init of enum C can be incorrect */
/* JADX WARN: Init of enum D can be incorrect */
/* JADX WARN: Init of enum E can be incorrect */
/* JADX WARN: Init of enum F can be incorrect */
/* JADX WARN: Init of enum G can be incorrect */
/* JADX WARN: Init of enum H can be incorrect */
/* JADX WARN: Init of enum I can be incorrect */
/* JADX WARN: Init of enum J can be incorrect */
/* JADX WARN: Init of enum K can be incorrect */
/* JADX WARN: Init of enum L can be incorrect */
/* JADX WARN: Init of enum M can be incorrect */
/* JADX WARN: Init of enum N can be incorrect */
/* JADX WARN: Init of enum O can be incorrect */
/* JADX WARN: Init of enum P can be incorrect */
/* JADX WARN: Init of enum Q can be incorrect */
/* JADX WARN: Init of enum R can be incorrect */
/* JADX WARN: Init of enum S can be incorrect */
/* JADX WARN: Init of enum T can be incorrect */
/* JADX WARN: Init of enum U can be incorrect */
/* JADX WARN: Init of enum V can be incorrect */
/* JADX WARN: Init of enum W can be incorrect */
/* JADX WARN: Init of enum X can be incorrect */
/* JADX WARN: Init of enum Y can be incorrect */
/* JADX WARN: Init of enum Z can be incorrect */
/* JADX WARN: Init of enum a0 can be incorrect */
/* JADX WARN: Init of enum b0 can be incorrect */
public enum g0 {
    DOUBLE(0, r8, p0.DOUBLE),
    FLOAT(1, r8, p0.FLOAT),
    INT64(2, r8, p0.LONG),
    UINT64(3, r8, p0.LONG),
    INT32(4, r8, p0.INT),
    FIXED64(5, r8, p0.LONG),
    FIXED32(6, r8, p0.INT),
    BOOL(7, r8, p0.BOOLEAN),
    STRING(8, r8, p0.STRING),
    MESSAGE(9, r8, p0.MESSAGE),
    BYTES(10, r8, p0.BYTE_STRING),
    UINT32(11, r8, p0.INT),
    ENUM(12, r8, p0.ENUM),
    SFIXED32(13, r8, p0.INT),
    SFIXED64(14, r8, p0.LONG),
    SINT32(15, r8, p0.INT),
    SINT64(16, r8, p0.LONG),
    GROUP(17, r8, p0.MESSAGE),
    DOUBLE_LIST(18, r7, p0.DOUBLE),
    FLOAT_LIST(19, r7, p0.FLOAT),
    INT64_LIST(20, r7, p0.LONG),
    UINT64_LIST(21, r7, p0.LONG),
    INT32_LIST(22, r7, p0.INT),
    FIXED64_LIST(23, r7, p0.LONG),
    FIXED32_LIST(24, r7, p0.INT),
    BOOL_LIST(25, r7, p0.BOOLEAN),
    STRING_LIST(26, r7, p0.STRING),
    MESSAGE_LIST(27, r7, p0.MESSAGE),
    BYTES_LIST(28, r7, p0.BYTE_STRING),
    UINT32_LIST(29, r7, p0.INT),
    ENUM_LIST(30, r7, p0.ENUM),
    SFIXED32_LIST(31, r7, p0.INT),
    SFIXED64_LIST(32, r7, p0.LONG),
    SINT32_LIST(33, r7, p0.INT),
    SINT64_LIST(34, r7, p0.LONG),
    DOUBLE_LIST_PACKED(35, r6, p0.DOUBLE),
    FLOAT_LIST_PACKED(36, r6, p0.FLOAT),
    INT64_LIST_PACKED(37, r6, p0.LONG),
    UINT64_LIST_PACKED(38, r6, p0.LONG),
    INT32_LIST_PACKED(39, r6, p0.INT),
    FIXED64_LIST_PACKED(40, r6, p0.LONG),
    FIXED32_LIST_PACKED(41, r6, p0.INT),
    BOOL_LIST_PACKED(42, r6, p0.BOOLEAN),
    UINT32_LIST_PACKED(43, r6, p0.INT),
    ENUM_LIST_PACKED(44, r6, p0.ENUM),
    SFIXED32_LIST_PACKED(45, r6, p0.INT),
    SFIXED64_LIST_PACKED(46, r6, p0.LONG),
    SINT32_LIST_PACKED(47, r6, p0.INT),
    SINT64_LIST_PACKED(48, r6, p0.LONG),
    GROUP_LIST(49, r7, p0.MESSAGE),
    MAP(50, a.MAP, p0.VOID);
    
    public static final g0[] d0;

    /* renamed from: b  reason: collision with root package name */
    public final p0 f5279b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5280c;

    /* renamed from: d  reason: collision with root package name */
    public final a f5281d;

    public enum a {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);
        

        /* renamed from: b  reason: collision with root package name */
        public final boolean f5287b;

        /* access modifiers changed from: public */
        a(boolean z) {
            this.f5287b = z;
        }
    }

    /* access modifiers changed from: public */
    static {
        a aVar = a.PACKED_VECTOR;
        a aVar2 = a.VECTOR;
        a aVar3 = a.SCALAR;
        g0[] values = values();
        d0 = new g0[values.length];
        for (g0 g0Var : values) {
            d0[g0Var.f5280c] = g0Var;
        }
    }

    /* access modifiers changed from: public */
    g0(int i, a aVar, p0 p0Var) {
        this.f5280c = i;
        this.f5281d = aVar;
        this.f5279b = p0Var;
        int ordinal = aVar.ordinal();
        if (ordinal == 1 || ordinal == 3) {
            Class<?> cls = p0Var.f5460b;
        }
        if (aVar == a.SCALAR && p0Var.ordinal() != 6) {
        }
    }
}
