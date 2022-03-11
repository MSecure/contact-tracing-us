package f.b.g;

import f.b.g.c0;
/* loaded from: classes.dex */
public enum a1 implements c0.c {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);
    
    public final int b;

    a1(int i2) {
        this.b = i2;
    }

    @Override // f.b.g.c0.c
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.b;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
