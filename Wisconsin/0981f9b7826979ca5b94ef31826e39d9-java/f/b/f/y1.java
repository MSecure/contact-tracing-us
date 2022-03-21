package f.b.f;

/* JADX WARN: Init of enum f can be incorrect */
/* JADX WARN: Init of enum g can be incorrect */
/* JADX WARN: Init of enum h can be incorrect */
/* JADX WARN: Init of enum i can be incorrect */
/* JADX WARN: Init of enum j can be incorrect */
/* JADX WARN: Init of enum m can be incorrect */
/* JADX WARN: Init of enum n can be incorrect */
/* JADX WARN: Init of enum p can be incorrect */
/* JADX WARN: Init of enum r can be incorrect */
/* JADX WARN: Init of enum s can be incorrect */
/* JADX WARN: Init of enum t can be incorrect */
/* JADX WARN: Init of enum u can be incorrect */
public enum y1 {
    DOUBLE(z1.DOUBLE, 1),
    FLOAT(z1.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(z1.BOOLEAN, 0),
    STRING(z1.STRING, 2) {
    },
    GROUP(r13, 3) {
    },
    MESSAGE(r13, 2) {
    },
    BYTES(z1.BYTE_STRING, 2) {
    },
    UINT32(r11, 0),
    ENUM(z1.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    public final z1 b;
    public final int c;

    /* access modifiers changed from: public */
    static {
        z1 z1Var = z1.LONG;
        z1 z1Var2 = z1.INT;
        z1 z1Var3 = z1.MESSAGE;
    }

    /* access modifiers changed from: public */
    y1(z1 z1Var, int i2) {
        this.b = z1Var;
        this.c = i2;
    }

    /* access modifiers changed from: public */
    y1(z1 z1Var, int i2, x1 x1Var) {
        this.b = z1Var;
        this.c = i2;
    }
}
