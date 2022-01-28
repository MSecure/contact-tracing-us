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
    public final List<Object> f3237d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f3238e;

    /* renamed from: f  reason: collision with root package name */
    public final f<f.b.c.k.u.f> f3239f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3240g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3241h;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        if (this.f3238e == j0Var.f3238e && this.f3240g == j0Var.f3240g && this.f3241h == j0Var.f3241h && this.a.equals(j0Var.a) && this.f3239f.equals(j0Var.f3239f) && this.b.equals(j0Var.b) && this.c.equals(j0Var.c)) {
            return this.f3237d.equals(j0Var.f3237d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        int hashCode3 = this.f3237d.hashCode();
        return ((((((this.f3239f.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31) + (this.f3238e ? 1 : 0)) * 31) + (this.f3240g ? 1 : 0)) * 31) + (this.f3241h ? 1 : 0);
    }

    public String toString() {
        StringBuilder i2 = a.i("ViewSnapshot(");
        i2.append(this.a);
        i2.append(", ");
        i2.append(this.b);
        i2.append(", ");
        i2.append(this.c);
        i2.append(", ");
        i2.append(this.f3237d);
        i2.append(", isFromCache=");
        i2.append(this.f3238e);
        i2.append(", mutatedKeys=");
        i2.append(this.f3239f.size());
        i2.append(", didSyncStateChange=");
        i2.append(this.f3240g);
        i2.append(", excludesMetadataChanges=");
        i2.append(this.f3241h);
        i2.append(")");
        return i2.toString();
    }
}
