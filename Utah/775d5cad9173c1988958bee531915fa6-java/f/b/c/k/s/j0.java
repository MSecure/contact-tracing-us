package f.b.c.k.s;

import f.a.a.a.a;
import f.b.c.g.a.f;
import f.b.c.k.u.g;
import java.util.List;

public class j0 {
    public final x a;
    public final g b;
    public final g c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Object> f3300d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f3301e;

    /* renamed from: f  reason: collision with root package name */
    public final f<f.b.c.k.u.f> f3302f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3303g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3304h;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        if (this.f3301e == j0Var.f3301e && this.f3303g == j0Var.f3303g && this.f3304h == j0Var.f3304h && this.a.equals(j0Var.a) && this.f3302f.equals(j0Var.f3302f) && this.b.equals(j0Var.b) && this.c.equals(j0Var.c)) {
            return this.f3300d.equals(j0Var.f3300d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        int hashCode3 = this.f3300d.hashCode();
        return ((((((this.f3302f.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31) + (this.f3301e ? 1 : 0)) * 31) + (this.f3303g ? 1 : 0)) * 31) + (this.f3304h ? 1 : 0);
    }

    public String toString() {
        StringBuilder h2 = a.h("ViewSnapshot(");
        h2.append(this.a);
        h2.append(", ");
        h2.append(this.b);
        h2.append(", ");
        h2.append(this.c);
        h2.append(", ");
        h2.append(this.f3300d);
        h2.append(", isFromCache=");
        h2.append(this.f3301e);
        h2.append(", mutatedKeys=");
        h2.append(this.f3302f.size());
        h2.append(", didSyncStateChange=");
        h2.append(this.f3303g);
        h2.append(", excludesMetadataChanges=");
        h2.append(this.f3304h);
        h2.append(")");
        return h2.toString();
    }
}
