package f.b.c.k.x;

import f.b.c.k.g;
import f.b.g.j;
import h.a.c1;
import h.a.d1;
import java.security.SecureRandom;
import java.util.Comparator;
import java.util.Objects;

public class r {
    public static final Comparator a = new a();
    public static final f.b.a.c.i.a<Void, Void> b = q.a;

    public class a implements Comparator<Comparable<?>> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    static {
        new SecureRandom();
    }

    public static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static g b(c1 c1Var) {
        Objects.requireNonNull(c1Var);
        d1 d1Var = new d1(c1Var);
        return new g(d1Var.getMessage(), g.a.t.get(c1Var.a.b, g.a.UNKNOWN), d1Var);
    }

    public static String c(j jVar) {
        int size = jVar.size();
        StringBuilder sb = new StringBuilder(size * 2);
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = jVar.i(i2) & 255;
            sb.append(Character.forDigit(i3 >>> 4, 16));
            sb.append(Character.forDigit(i3 & 15, 16));
        }
        return sb.toString();
    }

    public static String d(Object obj) {
        return obj == null ? "null" : obj.getClass().getName();
    }
}
