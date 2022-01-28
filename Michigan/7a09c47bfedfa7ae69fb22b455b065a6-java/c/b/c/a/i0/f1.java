package c.b.c.a.i0;

import c.b.c.a.j0.a.a0;

public enum f1 implements a0.a {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);
    

    /* renamed from: b  reason: collision with root package name */
    public final int f4853b;

    /* access modifiers changed from: public */
    f1(int i2) {
        this.f4853b = i2;
    }

    public static f1 b(int i2) {
        if (i2 == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i2 == 1) {
            return TINK;
        }
        if (i2 == 2) {
            return LEGACY;
        }
        if (i2 == 3) {
            return RAW;
        }
        if (i2 != 4) {
            return null;
        }
        return CRUNCHY;
    }

    @Override // c.b.c.a.j0.a.a0.a
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f4853b;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
