package f.b.c.k.s;

import f.a.a.a.a;
import f.b.c.k.u.o;
import f.b.d.a.s;
import java.util.List;
/* loaded from: classes.dex */
public final class c {
    public final boolean a;
    public final List<s> b;

    public c(List<s> list, boolean z) {
        this.b = list;
        this.a = z;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a ? "b:" : "a:");
        boolean z = true;
        for (s sVar : this.b) {
            if (!z) {
                sb.append(",");
            }
            z = false;
            StringBuilder sb2 = new StringBuilder();
            o.a(sb2, sVar);
            sb.append(sb2.toString());
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && this.b.equals(cVar.b);
    }

    public int hashCode() {
        return this.b.hashCode() + ((this.a ? 1 : 0) * 31);
    }

    public String toString() {
        StringBuilder h2 = a.h("Bound{before=");
        h2.append(this.a);
        h2.append(", position=");
        h2.append(this.b);
        h2.append('}');
        return h2.toString();
    }
}
