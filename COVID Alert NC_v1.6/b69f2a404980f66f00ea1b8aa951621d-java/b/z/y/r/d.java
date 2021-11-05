package b.z.y.r;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f2072a;

    /* renamed from: b  reason: collision with root package name */
    public Long f2073b;

    public d(String str, long j) {
        this.f2072a = str;
        this.f2073b = Long.valueOf(j);
    }

    public d(String str, boolean z) {
        long j = z ? 1 : 0;
        this.f2072a = str;
        this.f2073b = Long.valueOf(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f2072a.equals(dVar.f2072a)) {
            return false;
        }
        Long l = this.f2073b;
        Long l2 = dVar.f2073b;
        return l != null ? l.equals(l2) : l2 == null;
    }

    public int hashCode() {
        int hashCode = this.f2072a.hashCode() * 31;
        Long l = this.f2073b;
        return hashCode + (l != null ? l.hashCode() : 0);
    }
}
