package c.b.c.a.i0;

import c.b.c.a.j0.a.a0;

public enum c0 implements a0.a {
    UNKNOWN_ENCODING(0),
    IEEE_P1363(1),
    DER(2),
    UNRECOGNIZED(-1);
    

    /* renamed from: b  reason: collision with root package name */
    public final int f4847b;

    /* access modifiers changed from: public */
    c0(int i) {
        this.f4847b = i;
    }

    public static c0 b(int i) {
        if (i == 0) {
            return UNKNOWN_ENCODING;
        }
        if (i == 1) {
            return IEEE_P1363;
        }
        if (i != 2) {
            return null;
        }
        return DER;
    }

    @Override // c.b.c.a.j0.a.a0.a
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.f4847b;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
