package f.b.a.c.f.b;

public enum l {
    INFECTIOUSNESS_NONE(0),
    INFECTIOUSNESS_STANDARD(1),
    INFECTIOUSNESS_HIGH(2);
    
    public final int b;

    /* access modifiers changed from: public */
    l(int i2) {
        this.b = i2;
    }

    public static l a(int i2) {
        if (i2 == 0) {
            return INFECTIOUSNESS_NONE;
        }
        if (i2 == 1) {
            return INFECTIOUSNESS_STANDARD;
        }
        if (i2 != 2) {
            return null;
        }
        return INFECTIOUSNESS_HIGH;
    }

    public final String toString() {
        return "<" + l.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.b + " name=" + name() + '>';
    }
}
