package e.b0.a0.s;

public class g {
    public final String a;
    public final int b;

    public g(String str, int i2) {
        this.a = str;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.b != gVar.b) {
            return false;
        }
        return this.a.equals(gVar.a);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }
}
