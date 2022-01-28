package b.b0.y.p;

import androidx.recyclerview.widget.RecyclerView;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1165a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1166b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1167c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1168d;

    public b(boolean z, boolean z2, boolean z3, boolean z4) {
        this.f1165a = z;
        this.f1166b = z2;
        this.f1167c = z3;
        this.f1168d = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f1165a == bVar.f1165a && this.f1166b == bVar.f1166b && this.f1167c == bVar.f1167c && this.f1168d == bVar.f1168d;
    }

    public int hashCode() {
        int i = this.f1165a ? 1 : 0;
        if (this.f1166b) {
            i += 16;
        }
        if (this.f1167c) {
            i += RecyclerView.a0.FLAG_TMP_DETACHED;
        }
        return this.f1168d ? i + 4096 : i;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.f1165a), Boolean.valueOf(this.f1166b), Boolean.valueOf(this.f1167c), Boolean.valueOf(this.f1168d));
    }
}
