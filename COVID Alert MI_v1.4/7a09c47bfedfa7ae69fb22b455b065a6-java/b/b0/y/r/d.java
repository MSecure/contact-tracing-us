package b.b0.y.r;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f1215a;

    /* renamed from: b  reason: collision with root package name */
    public Long f1216b;

    public d(String str, long j) {
        this.f1215a = str;
        this.f1216b = Long.valueOf(j);
    }

    public d(String str, boolean z) {
        long j = z ? 1 : 0;
        this.f1215a = str;
        this.f1216b = Long.valueOf(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!this.f1215a.equals(dVar.f1215a)) {
            return false;
        }
        Long l = this.f1216b;
        Long l2 = dVar.f1216b;
        return l != null ? l.equals(l2) : l2 == null;
    }

    public int hashCode() {
        int hashCode = this.f1215a.hashCode() * 31;
        Long l = this.f1216b;
        return hashCode + (l != null ? l.hashCode() : 0);
    }
}
