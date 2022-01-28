package f.b.c.f;

public class n {
    public final Class<?> a;
    public final boolean b;

    public n(Class cls, boolean z, l lVar) {
        this.a = cls;
        this.b = z;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return nVar.a.equals(this.a) && nVar.b == this.b;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.b).hashCode();
    }
}
