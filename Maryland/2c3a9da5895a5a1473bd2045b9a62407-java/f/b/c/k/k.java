package f.b.c.k;

import f.b.a.c.b.o.b;
import f.b.c.k.x.r;
import java.util.Comparator;
import java.util.Objects;

public class k implements Comparable<k> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(k kVar) {
        Objects.requireNonNull(kVar);
        Comparator comparator = r.a;
        int A0 = b.A0(0.0d, 0.0d);
        return A0 == 0 ? b.A0(0.0d, 0.0d) : A0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        Objects.requireNonNull((k) obj);
        return true;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(0.0d);
        long doubleToLongBits2 = Double.doubleToLongBits(0.0d);
        return (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "GeoPoint { latitude=0.0, longitude=0.0 }";
    }
}
