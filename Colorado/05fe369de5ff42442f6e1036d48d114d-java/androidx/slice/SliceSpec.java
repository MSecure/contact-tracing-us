package androidx.slice;

import e.y.d;

public final class SliceSpec implements d {
    public String a;
    public int b;

    public boolean equals(Object obj) {
        if (!(obj instanceof SliceSpec)) {
            return false;
        }
        SliceSpec sliceSpec = (SliceSpec) obj;
        return this.a.equals(sliceSpec.a) && this.b == sliceSpec.b;
    }

    public int hashCode() {
        return this.a.hashCode() + this.b;
    }

    public String toString() {
        return String.format("SliceSpec{%s,%d}", this.a, Integer.valueOf(this.b));
    }
}
