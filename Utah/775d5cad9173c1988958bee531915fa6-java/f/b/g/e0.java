package f.b.g;

/* JADX WARN: Init of enum e can be incorrect */
/* JADX WARN: Init of enum l can be incorrect */
public enum e0 {
    VOID(Void.class, Void.class, null),
    INT(r1, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(j.class, j.class, j.c),
    ENUM(r1, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    public final Class<?> b;
    public final Object c;

    /* access modifiers changed from: public */
    static {
        Class cls = Integer.TYPE;
    }

    /* access modifiers changed from: public */
    e0(Class cls, Class cls2, Object obj) {
        this.b = cls2;
        this.c = obj;
    }
}
