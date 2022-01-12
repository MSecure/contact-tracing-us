package io.realm.internal.util;

import com.android.tools.r8.GeneratedOutlineSupport;

public class Pair<F, S> {
    public F first;
    public S second;

    public Pair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        F f = pair.first;
        F f2 = this.first;
        if (!(f == f2 || (f != null && f.equals(f2)))) {
            return false;
        }
        S s = pair.second;
        S s2 = this.second;
        if (s == s2 || (s != null && s.equals(s2))) {
            return true;
        }
        return false;
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
