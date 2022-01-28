package f.b.c.k.u;

import f.a.a.a.a;

public final class b implements Comparable<b> {
    public final String b;
    public final String c;

    public b(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(b bVar) {
        b bVar2 = bVar;
        int compareTo = this.b.compareTo(bVar2.b);
        return compareTo != 0 ? compareTo : this.c.compareTo(bVar2.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.b.equals(bVar.b) && this.c.equals(bVar.c);
    }

    public int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() * 31);
    }

    public String toString() {
        StringBuilder h2 = a.h("DatabaseId(");
        h2.append(this.b);
        h2.append(", ");
        return a.e(h2, this.c, ")");
    }
}
