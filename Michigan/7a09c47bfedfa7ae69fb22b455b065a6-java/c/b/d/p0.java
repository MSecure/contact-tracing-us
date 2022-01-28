package c.b.d;

public enum p0 {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(j.class, j.class, j.f5320c),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    

    /* renamed from: b  reason: collision with root package name */
    public final Class<?> f5460b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f5461c;

    /* access modifiers changed from: public */
    p0(Class cls, Class cls2, Object obj) {
        this.f5460b = cls2;
        this.f5461c = obj;
    }
}
