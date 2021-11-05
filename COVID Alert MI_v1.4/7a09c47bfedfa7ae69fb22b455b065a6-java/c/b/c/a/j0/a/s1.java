package c.b.c.a.j0.a;

public enum s1 {
    DOUBLE(t1.DOUBLE, 1),
    FLOAT(t1.FLOAT, 5),
    INT64(t1.LONG, 0),
    UINT64(t1.LONG, 0),
    INT32(t1.INT, 0),
    FIXED64(t1.LONG, 1),
    FIXED32(t1.INT, 5),
    BOOL(t1.BOOLEAN, 0),
    STRING(t1.STRING, 2) {
    },
    GROUP(t1.MESSAGE, 3) {
    },
    MESSAGE(t1.MESSAGE, 2) {
    },
    BYTES(t1.BYTE_STRING, 2) {
    },
    UINT32(t1.INT, 0),
    ENUM(t1.ENUM, 0),
    SFIXED32(t1.INT, 5),
    SFIXED64(t1.LONG, 1),
    SINT32(t1.INT, 0),
    SINT64(t1.LONG, 0);
    

    /* renamed from: b  reason: collision with root package name */
    public final t1 f5019b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5020c;

    /* access modifiers changed from: public */
    s1(t1 t1Var, int i) {
        this.f5019b = t1Var;
        this.f5020c = i;
    }

    /* access modifiers changed from: public */
    s1(t1 t1Var, int i, r1 r1Var) {
        this.f5019b = t1Var;
        this.f5020c = i;
    }
}
