package e.i.h;

import java.util.Objects;

public class a<F, S> {
    public final F a;
    public final S b;

    public a(F f2, S s) {
        this.a = f2;
        this.b = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!Objects.equals(aVar.a, this.a) || !Objects.equals(aVar.b, this.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        F f2 = this.a;
        int i2 = 0;
        int hashCode = f2 == null ? 0 : f2.hashCode();
        S s = this.b;
        if (s != null) {
            i2 = s.hashCode();
        }
        return hashCode ^ i2;
    }

    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("Pair{");
        i2.append((Object) this.a);
        i2.append(" ");
        i2.append((Object) this.b);
        i2.append("}");
        return i2.toString();
    }
}
