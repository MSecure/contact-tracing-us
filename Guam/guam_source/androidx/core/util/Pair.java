package androidx.core.util;

import java.util.Objects;

public class Pair<F, S> {
    public final F first;
    public final S second;

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!Objects.equals(pair.first, null) || !Objects.equals(pair.second, null)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "Pair{null null}";
    }
}
