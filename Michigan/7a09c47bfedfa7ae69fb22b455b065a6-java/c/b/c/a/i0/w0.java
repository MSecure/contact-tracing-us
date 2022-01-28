package c.b.c.a.i0;

import c.b.c.a.j0.a.a0;

public enum w0 implements a0.a {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);
    

    /* renamed from: b  reason: collision with root package name */
    public final int f4877b;

    /* access modifiers changed from: public */
    w0(int i) {
        this.f4877b = i;
    }

    public static w0 b(int i) {
        if (i == 0) {
            return UNKNOWN_STATUS;
        }
        if (i == 1) {
            return ENABLED;
        }
        if (i == 2) {
            return DISABLED;
        }
        if (i != 3) {
            return null;
        }
        return DESTROYED;
    }

    @Override // c.b.c.a.j0.a.a0.a
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f4877b;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
