package androidx.core.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Objects;

public class Pair<F, S> {
    public final F first;
    public final S second;

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!Objects.equals(pair.first, this.first) || !Objects.equals(pair.second, this.second)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        F f = this.first;
        int i = 0;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.second;
        if (s != null) {
            i = s.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Pair{");
        outline17.append(String.valueOf(this.first));
        outline17.append(" ");
        outline17.append(String.valueOf(this.second));
        outline17.append("}");
        return outline17.toString();
    }
}
