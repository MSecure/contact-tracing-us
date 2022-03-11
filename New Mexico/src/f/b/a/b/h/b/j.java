package f.b.a.b.h.b;

import f.a.a.a.a;
import f.b.a.b.h.b.p;
/* loaded from: classes.dex */
public final class j extends p {
    public final p.a a;
    public final a b;

    public /* synthetic */ j(p.a aVar, a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // f.b.a.b.h.b.p
    public a a() {
        return this.b;
    }

    @Override // f.b.a.b.h.b.p
    public p.a b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p.a aVar = this.a;
        if (aVar != null ? aVar.equals(((j) obj).a) : ((j) obj).a == null) {
            a aVar2 = this.b;
            a aVar3 = ((j) obj).b;
            if (aVar2 == null) {
                if (aVar3 == null) {
                    return true;
                }
            } else if (aVar2.equals(aVar3)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        p.a aVar = this.a;
        int i2 = 0;
        int hashCode = ((aVar == null ? 0 : aVar.hashCode()) ^ 1000003) * 1000003;
        a aVar2 = this.b;
        if (aVar2 != null) {
            i2 = aVar2.hashCode();
        }
        return hashCode ^ i2;
    }

    public String toString() {
        StringBuilder h2 = a.h("ClientInfo{clientType=");
        h2.append(this.a);
        h2.append(", androidClientInfo=");
        h2.append(this.b);
        h2.append("}");
        return h2.toString();
    }
}
