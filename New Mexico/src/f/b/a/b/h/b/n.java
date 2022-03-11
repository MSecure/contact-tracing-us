package f.b.a.b.h.b;

import f.a.a.a.a;
import f.b.a.b.h.b.t;
/* loaded from: classes.dex */
public final class n extends t {
    public final t.b a;
    public final t.a b;

    public /* synthetic */ n(t.b bVar, t.a aVar) {
        this.a = bVar;
        this.b = aVar;
    }

    @Override // f.b.a.b.h.b.t
    public t.a a() {
        return this.b;
    }

    @Override // f.b.a.b.h.b.t
    public t.b b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t.b bVar = this.a;
        if (bVar != null ? bVar.equals(((n) obj).a) : ((n) obj).a == null) {
            t.a aVar = this.b;
            t.a aVar2 = ((n) obj).b;
            if (aVar == null) {
                if (aVar2 == null) {
                    return true;
                }
            } else if (aVar.equals(aVar2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        t.b bVar = this.a;
        int i2 = 0;
        int hashCode = ((bVar == null ? 0 : bVar.hashCode()) ^ 1000003) * 1000003;
        t.a aVar = this.b;
        if (aVar != null) {
            i2 = aVar.hashCode();
        }
        return hashCode ^ i2;
    }

    public String toString() {
        StringBuilder h2 = a.h("NetworkConnectionInfo{networkType=");
        h2.append(this.a);
        h2.append(", mobileSubtype=");
        h2.append(this.b);
        h2.append("}");
        return h2.toString();
    }
}
