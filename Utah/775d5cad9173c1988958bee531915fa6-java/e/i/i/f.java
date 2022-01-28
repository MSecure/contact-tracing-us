package e.i.i;

import f.a.a.a.a;
import java.util.Objects;

public final class f {
    public final Object a;

    public f(Object obj) {
        this.a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.a, ((f) obj).a);
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        StringBuilder h2 = a.h("DisplayCutoutCompat{");
        h2.append(this.a);
        h2.append("}");
        return h2.toString();
    }
}
