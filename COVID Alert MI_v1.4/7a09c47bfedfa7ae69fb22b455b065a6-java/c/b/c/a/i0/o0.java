package c.b.c.a.i0;

import c.b.c.a.j0.a.a0;

public enum o0 implements a0.a {
    UNKNOWN_HASH(0),
    SHA1(1),
    SHA384(2),
    SHA256(3),
    SHA512(4),
    UNRECOGNIZED(-1);
    

    /* renamed from: b  reason: collision with root package name */
    public final int f4865b;

    /* access modifiers changed from: public */
    o0(int i2) {
        this.f4865b = i2;
    }

    public static o0 b(int i2) {
        if (i2 == 0) {
            return UNKNOWN_HASH;
        }
        if (i2 == 1) {
            return SHA1;
        }
        if (i2 == 2) {
            return SHA384;
        }
        if (i2 == 3) {
            return SHA256;
        }
        if (i2 != 4) {
            return null;
        }
        return SHA512;
    }

    @Override // c.b.c.a.j0.a.a0.a
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f4865b;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
