package c.b.a.a.g.h;

public enum e2 {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(q0.class, q0.class, q0.f4006c),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    

    /* renamed from: b  reason: collision with root package name */
    public final Class<?> f3877b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f3878c;

    /* access modifiers changed from: public */
    e2(Class cls, Class cls2, Object obj) {
        this.f3877b = cls2;
        this.f3878c = obj;
    }
}
