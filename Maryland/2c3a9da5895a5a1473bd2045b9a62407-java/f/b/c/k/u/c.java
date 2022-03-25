package f.b.c.k.u;

import f.b.d.a.s;

public final class c extends i {
    public final a c;

    /* renamed from: d  reason: collision with root package name */
    public k f3211d;

    public enum a {
        LOCAL_MUTATIONS,
        COMMITTED_MUTATIONS,
        SYNCED
    }

    public c(f fVar, m mVar, k kVar, a aVar) {
        super(fVar, mVar);
        this.c = aVar;
        this.f3211d = kVar;
    }

    @Override // f.b.c.k.u.i
    public boolean a() {
        return this.c.equals(a.LOCAL_MUTATIONS) || this.c.equals(a.COMMITTED_MUTATIONS);
    }

    public s b(h hVar) {
        return this.f3211d.c(hVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!this.b.equals(cVar.b) || !this.a.equals(cVar.a) || !this.c.equals(cVar.c) || !this.f3211d.equals(cVar.f3211d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        int hashCode2 = this.c.hashCode();
        return this.f3211d.hashCode() + ((hashCode2 + ((hashCode + (this.a.hashCode() * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("Document{key=");
        h2.append(this.a);
        h2.append(", data=");
        h2.append(this.f3211d);
        h2.append(", version=");
        h2.append(this.b);
        h2.append(", documentState=");
        h2.append(this.c.name());
        h2.append('}');
        return h2.toString();
    }
}
