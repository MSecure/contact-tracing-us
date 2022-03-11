package e.j.i;

import f.a.a.a.a;
import java.util.Objects;
/* loaded from: classes.dex */
public class b<F, S> {
    public final F a;
    public final S b;

    public b(F f2, S s) {
        this.a = f2;
        this.b = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!Objects.equals(bVar.a, this.a) || !Objects.equals(bVar.b, this.b)) {
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
        StringBuilder h2 = a.h("Pair{");
        h2.append(this.a);
        h2.append(" ");
        h2.append(this.b);
        h2.append("}");
        return h2.toString();
    }
}
