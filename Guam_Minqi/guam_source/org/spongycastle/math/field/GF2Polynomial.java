package org.spongycastle.math.field;

import com.horcrux.svg.PathParser;

public class GF2Polynomial {
    public final int[] exponents;

    public GF2Polynomial(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        this.exponents = iArr2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GF2Polynomial)) {
            return false;
        }
        return PathParser.areEqual(this.exponents, ((GF2Polynomial) obj).exponents);
    }

    public int hashCode() {
        return PathParser.hashCode(this.exponents);
    }
}
