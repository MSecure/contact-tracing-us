package f.b.c.k.s;

import f.a.a.a.a;
import f.b.c.g.a.f;
import f.b.c.k.u.g;
import java.util.List;
/* loaded from: classes.dex */
public class j0 {
    public final x a;
    public final g b;
    public final g c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Object> f3555d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f3556e;

    /* renamed from: f  reason: collision with root package name */
    public final f<f.b.c.k.u.f> f3557f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3558g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f3559h;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        if (this.f3556e == j0Var.f3556e && this.f3558g == j0Var.f3558g && this.f3559h == j0Var.f3559h && this.a.equals(j0Var.a) && this.f3557f.equals(j0Var.f3557f) && this.b.equals(j0Var.b) && this.c.equals(j0Var.c)) {
            return this.f3555d.equals(j0Var.f3555d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        int hashCode3 = this.f3555d.hashCode();
        return ((((((this.f3557f.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31) + (this.f3556e ? 1 : 0)) * 31) + (this.f3558g ? 1 : 0)) * 31) + (this.f3559h ? 1 : 0);
    }

    public String toString() {
        StringBuilder h2 = a.h("ViewSnapshot(");
        h2.append(this.a);
        h2.append(", ");
        h2.append(this.b);
        h2.append(", ");
        h2.append(this.c);
        h2.append(", ");
        h2.append(this.f3555d);
        h2.append(", isFromCache=");
        h2.append(this.f3556e);
        h2.append(", mutatedKeys=");
        h2.append(this.f3557f.size());
        h2.append(", didSyncStateChange=");
        h2.append(this.f3558g);
        h2.append(", excludesMetadataChanges=");
        h2.append(this.f3559h);
        h2.append(")");
        return h2.toString();
    }
}
