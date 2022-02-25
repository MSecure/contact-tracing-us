package f.b.c.k.u;

import f.b.a.c.b.o.b;
import f.b.c.k.u.a;
import f.b.c.k.x.r;
import java.util.ArrayList;
import java.util.List;

public abstract class a<B extends a<B>> implements Comparable<B> {
    public final List<String> b;

    public a(List<String> list) {
        this.b = list;
    }

    public B a(B b2) {
        ArrayList arrayList = new ArrayList(this.b);
        arrayList.addAll(b2.b);
        return f(arrayList);
    }

    public B b(String str) {
        ArrayList arrayList = new ArrayList(this.b);
        arrayList.add(str);
        return f(arrayList);
    }

    public abstract String c();

    /* renamed from: e */
    public int compareTo(B b2) {
        int n = n();
        int n2 = b2.n();
        int i2 = 0;
        while (i2 < n && i2 < n2) {
            int compareTo = i(i2).compareTo(b2.i(i2));
            if (compareTo != 0) {
                return compareTo;
            }
            i2++;
        }
        return r.a(n, n2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: f.b.c.k.u.a<B extends f.b.c.k.u.a<B>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && compareTo((a) obj) == 0;
    }

    public abstract B f(List<String> list);

    public String h() {
        return this.b.get(n() - 1);
    }

    public int hashCode() {
        return this.b.hashCode() + ((getClass().hashCode() + 37) * 37);
    }

    public String i(int i2) {
        return this.b.get(i2);
    }

    public boolean l() {
        return n() == 0;
    }

    public boolean m(B b2) {
        if (n() > b2.n()) {
            return false;
        }
        for (int i2 = 0; i2 < n(); i2++) {
            if (!i(i2).equals(b2.i(i2))) {
                return false;
            }
        }
        return true;
    }

    public int n() {
        return this.b.size();
    }

    public B o(int i2) {
        int n = n();
        b.a1(n >= i2, "Can't call popFirst with count > length() (%d > %d)", Integer.valueOf(i2), Integer.valueOf(n));
        return new l(this.b.subList(i2, n));
    }

    public B q() {
        return f(this.b.subList(0, n() - 1));
    }

    public String toString() {
        return c();
    }
}
