package f.b.g;
/* loaded from: classes.dex */
public enum z1 {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(j.c),
    ENUM(null),
    MESSAGE(null);
    
    public final Object b;

    z1(Object obj) {
        this.b = obj;
    }
}
