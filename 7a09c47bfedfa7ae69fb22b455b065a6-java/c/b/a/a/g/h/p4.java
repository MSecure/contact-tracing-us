package c.b.a.a.g.h;

public enum p4 {
    DOUBLE(w4.DOUBLE, 1),
    FLOAT(w4.FLOAT, 5),
    INT64(w4.LONG, 0),
    UINT64(w4.LONG, 0),
    INT32(w4.INT, 0),
    FIXED64(w4.LONG, 1),
    FIXED32(w4.INT, 5),
    BOOL(w4.BOOLEAN, 0),
    STRING {
    },
    GROUP {
    },
    MESSAGE {
    },
    BYTES {
    },
    UINT32(w4.INT, 0),
    ENUM(w4.ENUM, 0),
    SFIXED32(w4.INT, 5),
    SFIXED64(w4.LONG, 1),
    SINT32(w4.INT, 0),
    SINT64(w4.LONG, 0);
    

    /* renamed from: b  reason: collision with root package name */
    public final w4 f3998b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3999c;

    /* access modifiers changed from: public */
    p4(w4 w4Var, int i) {
        this.f3998b = w4Var;
        this.f3999c = i;
    }

    /* access modifiers changed from: public */
    p4(w4 w4Var, int i, q4 q4Var) {
        this.f3998b = w4Var;
        this.f3999c = i;
    }
}
