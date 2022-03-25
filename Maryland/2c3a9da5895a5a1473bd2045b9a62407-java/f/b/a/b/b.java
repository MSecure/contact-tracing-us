package f.b.a.b;

import f.a.a.a.a;
import java.util.Objects;

public final class b {
    public final String a;

    public b(String str) {
        Objects.requireNonNull(str, "name is null");
        this.a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        return this.a.equals(((b) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return a.e(a.h("Encoding{name=\""), this.a, "\"}");
    }
}
