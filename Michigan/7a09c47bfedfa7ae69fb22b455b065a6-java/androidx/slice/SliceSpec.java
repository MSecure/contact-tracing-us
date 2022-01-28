package androidx.slice;

import b.z.d;

public final class SliceSpec implements d {

    /* renamed from: a  reason: collision with root package name */
    public String f407a;

    /* renamed from: b  reason: collision with root package name */
    public int f408b;

    public boolean equals(Object obj) {
        if (!(obj instanceof SliceSpec)) {
            return false;
        }
        SliceSpec sliceSpec = (SliceSpec) obj;
        return this.f407a.equals(sliceSpec.f407a) && this.f408b == sliceSpec.f408b;
    }

    public int hashCode() {
        return this.f407a.hashCode() + this.f408b;
    }

    public String toString() {
        return String.format("SliceSpec{%s,%d}", this.f407a, Integer.valueOf(this.f408b));
    }
}
