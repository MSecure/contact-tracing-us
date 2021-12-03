package f.b.c.k.u;

import f.b.d.a.s;

public final class c extends i {
    public final a c;

    /* renamed from: d  reason: collision with root package name */
    public k f3306d;

    public enum a {
        LOCAL_MUTATIONS,
        COMMITTED_MUTATIONS,
        SYNCED
    }

    public c(f fVar, m mVar, k kVar, a aVar) {
        super(fVar, mVar);
        this.c = aVar;
        this.f3306d = kVar;
    }

    @Override // f.b.c.k.u.i
    public boolean a() {
        return this.c.equals(a.LOCAL_MUTATIONS) || this.c.equals(a.COMMITTED_MUTATIONS);
    }

    public s b(h hVar) {
        return this.f3306d.c(hVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.b.equals(cVar.b) || !this.a.equals(cVar.a) || !this.c.equals(cVar.c) || !this.f3306d.equals(cVar.f3306d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        return this.f3306d.hashCode() + ((hashCode2 + ((hashCode + (this.a.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("Document{key=");
        i2.append(this.a);
        i2.append(", data=");
        i2.append(this.f3306d);
        i2.append(", version=");
        i2.append(this.b);
        i2.append(", documentState=");
        i2.append(this.c.name());
        i2.append('}');
        return i2.toString();
    }
}
