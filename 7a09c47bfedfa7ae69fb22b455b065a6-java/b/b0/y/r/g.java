package b.b0.y.r;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f1219a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1220b;

    public g(String str, int i) {
        this.f1219a = str;
        this.f1220b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f1220b != gVar.f1220b) {
            return false;
        }
        return this.f1219a.equals(gVar.f1219a);
    }

    public int hashCode() {
        return (this.f1219a.hashCode() * 31) + this.f1220b;
    }
}
