package c.b.a.a.g.b;

/* JADX WARN: Init of enum c can be incorrect */
/* JADX WARN: Init of enum d can be incorrect */
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
public enum u0 {
    DOUBLE(0, r8, h1.DOUBLE),
    FLOAT(1, r8, h1.FLOAT),
    INT64(2, r8, h1.LONG),
    UINT64(3, r8, h1.LONG),
    INT32(4, r8, h1.INT),
    FIXED64(5, r8, h1.LONG),
    FIXED32(6, r8, h1.INT),
    BOOL(7, r8, h1.BOOLEAN),
    STRING(8, r8, h1.STRING),
    MESSAGE(9, r8, h1.MESSAGE),
    BYTES(10, r8, h1.BYTE_STRING),
    UINT32(11, r8, h1.INT),
    ENUM(12, r8, h1.ENUM),
    SFIXED32(13, r8, h1.INT),
    SFIXED64(14, r8, h1.LONG),
    SINT32(15, r8, h1.INT),
    SINT64(16, r8, h1.LONG),
    GROUP(17, r8, h1.MESSAGE),
    DOUBLE_LIST(18, r7, h1.DOUBLE),
    FLOAT_LIST(19, r7, h1.FLOAT),
    INT64_LIST(20, r7, h1.LONG),
    UINT64_LIST(21, r7, h1.LONG),
    INT32_LIST(22, r7, h1.INT),
    FIXED64_LIST(23, r7, h1.LONG),
    FIXED32_LIST(24, r7, h1.INT),
    BOOL_LIST(25, r7, h1.BOOLEAN),
    STRING_LIST(26, r7, h1.STRING),
    MESSAGE_LIST(27, r7, h1.MESSAGE),
    BYTES_LIST(28, r7, h1.BYTE_STRING),
    UINT32_LIST(29, r7, h1.INT),
    ENUM_LIST(30, r7, h1.ENUM),
    SFIXED32_LIST(31, r7, h1.INT),
    SFIXED64_LIST(32, r7, h1.LONG),
    SINT32_LIST(33, r7, h1.INT),
    SINT64_LIST(34, r7, h1.LONG),
    DOUBLE_LIST_PACKED(35, r6, h1.DOUBLE),
    FLOAT_LIST_PACKED(36, r6, h1.FLOAT),
    INT64_LIST_PACKED(37, r6, h1.LONG),
    UINT64_LIST_PACKED(38, r6, h1.LONG),
    INT32_LIST_PACKED(39, r6, h1.INT),
    FIXED64_LIST_PACKED(40, r6, h1.LONG),
    FIXED32_LIST_PACKED(41, r6, h1.INT),
    BOOL_LIST_PACKED(42, r6, h1.BOOLEAN),
    UINT32_LIST_PACKED(43, r6, h1.INT),
    ENUM_LIST_PACKED(44, r6, h1.ENUM),
    SFIXED32_LIST_PACKED(45, r6, h1.INT),
    SFIXED64_LIST_PACKED(46, r6, h1.LONG),
    SINT32_LIST_PACKED(47, r6, h1.INT),
    SINT64_LIST_PACKED(48, r6, h1.LONG),
    GROUP_LIST(49, r7, h1.MESSAGE),
    MAP(50, w0.MAP, h1.VOID);
    
    public static final u0[] b0;

    /* renamed from: b  reason: collision with root package name */
    public final int f3432b;

    /* access modifiers changed from: public */
    static {
        w0 w0Var = w0.PACKED_VECTOR;
        w0 w0Var2 = w0.VECTOR;
        w0 w0Var3 = w0.SCALAR;
        u0[] values = values();
        b0 = new u0[values.length];
        for (u0 u0Var : values) {
            b0[u0Var.f3432b] = u0Var;
        }
    }

    /* access modifiers changed from: public */
    u0(int i, w0 w0Var, h1 h1Var) {
        this.f3432b = i;
        int i2 = v0.f3440a[w0Var.ordinal()];
        if (i2 == 1 || i2 == 2) {
            Class<?> cls = h1Var.f3297b;
        }
        if (w0Var == w0.SCALAR) {
            int i3 = v0.f3441b[h1Var.ordinal()];
        }
    }
}
