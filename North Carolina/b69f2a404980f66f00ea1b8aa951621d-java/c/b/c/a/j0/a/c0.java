package c.b.c.a.j0.a;

public enum c0 {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(i.class, i.class, i.f3564c),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    

    /* renamed from: b  reason: collision with root package name */
    public final Class<?> f3529b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f3530c;

    /* access modifiers changed from: public */
    c0(Class cls, Class cls2, Object obj) {
        this.f3529b = cls2;
        this.f3530c = obj;
    }
}
