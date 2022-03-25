package e.i.h;

import java.util.Objects;

public class a<F, S> {
    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        Objects.requireNonNull((a) obj);
        return Objects.equals(null, null) && Objects.equals(null, null);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "Pair{null null}";
    }
}
