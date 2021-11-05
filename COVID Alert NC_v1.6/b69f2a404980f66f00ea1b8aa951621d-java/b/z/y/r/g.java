package b.z.y.r;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final String f2076a;

    /* renamed from: b  reason: collision with root package name */
    public final int f2077b;

    public g(String str, int i) {
        this.f2076a = str;
        this.f2077b = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f2077b != gVar.f2077b) {
            return false;
        }
        return this.f2076a.equals(gVar.f2076a);
    }

    public int hashCode() {
        return (this.f2076a.hashCode() * 31) + this.f2077b;
    }
}
