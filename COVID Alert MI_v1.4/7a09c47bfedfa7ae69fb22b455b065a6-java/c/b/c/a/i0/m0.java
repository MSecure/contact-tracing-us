package c.b.c.a.i0;

import c.b.c.a.j0.a.a0;

public enum m0 implements a0.a {
    UNKNOWN_CURVE(0),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    CURVE25519(5),
    UNRECOGNIZED(-1);
    

    /* renamed from: b  reason: collision with root package name */
    public final int f4859b;

    /* access modifiers changed from: public */
    m0(int i2) {
        this.f4859b = i2;
    }

    public static m0 b(int i2) {
        if (i2 == 0) {
            return UNKNOWN_CURVE;
        }
        if (i2 == 2) {
            return NIST_P256;
        }
        if (i2 == 3) {
            return NIST_P384;
        }
        if (i2 == 4) {
            return NIST_P521;
        }
        if (i2 != 5) {
            return null;
        }
        return CURVE25519;
    }

    @Override // c.b.c.a.j0.a.a0.a
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f4859b;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
