package b.z.y.p;

import androidx.recyclerview.widget.RecyclerView;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2027a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f2028b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f2029c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2030d;

    public b(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f2027a = z;
        this.f2028b = z2;
        this.f2029c = z3;
        this.f2030d = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2027a == bVar.f2027a && this.f2028b == bVar.f2028b && this.f2029c == bVar.f2029c && this.f2030d == bVar.f2030d;
    }

    public int hashCode() {
        int i = this.f2027a ? 1 : 0;
        if (this.f2028b) {
            i += 16;
        }
        if (this.f2029c) {
            i += RecyclerView.d0.FLAG_TMP_DETACHED;
        }
        return this.f2030d ? i + 4096 : i;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.f2027a), Boolean.valueOf(this.f2028b), Boolean.valueOf(this.f2029c), Boolean.valueOf(this.f2030d));
    }
}
