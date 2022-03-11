package e.i.i;

import f.a.a.a.a;
import java.util.Objects;

public final class c {
    public final Object a;

    public c(Object obj) {
        this.a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.a, ((c) obj).a);
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
