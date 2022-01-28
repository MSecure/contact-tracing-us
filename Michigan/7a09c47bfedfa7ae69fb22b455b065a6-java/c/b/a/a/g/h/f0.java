package c.b.a.a.g.h;

public enum f0 implements w1 {
    UNKNOWN_FORMAT(0),
    CONTACT_INFO(1),
    EMAIL(2),
    ISBN(3),
    PHONE(4),
    PRODUCT(5),
    SMS(6),
    TEXT(7),
    URL(8),
    WIFI(9),
    GEO(10),
    CALENDAR_EVENT(11),
    DRIVER_LICENSE(12),
    BOARDING_PASS(13);
    

    /* renamed from: b  reason: collision with root package name */
    public final int f3892b;

    /* access modifiers changed from: public */
    f0(int i) {
        this.f3892b = i;
    }

    public static f0 b(int i) {
        switch (i) {
            case 0:
                return UNKNOWN_FORMAT;
            case 1:
                return CONTACT_INFO;
            case 2:
                return EMAIL;
            case 3:
                return ISBN;
            case 4:
                return PHONE;
            case 5:
                return PRODUCT;
            case 6:
                return SMS;
            case 7:
                return TEXT;
            case 8:
                return URL;
            case 9:
                return WIFI;
            case 10:
                return GEO;
            case 11:
                return CALENDAR_EVENT;
            case 12:
                return DRIVER_LICENSE;
            case 13:
                return BOARDING_PASS;
            default:
                return null;
        }
    }

    @Override // c.b.a.a.g.h.w1
    public final int h() {
        return this.f3892b;
    }

    public final String toString() {
        return "<" + f0.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f3892b + " name=" + name() + '>';
    }
}
