package f.b.c.k.u;

import f.b.a.c.b.o.b;
import java.util.Collections;
/* loaded from: classes.dex */
public final class f implements Comparable<f> {
    public static final f.b.c.g.a.f<f> c = new f.b.c.g.a.f<>(Collections.emptyList(), e.a);
    public final l b;

    public f(l lVar) {
        b.P0(c(lVar), "Not a document key path: %s", lVar);
        this.b = lVar;
    }

    public static f b(String str) {
        l s = l.s(str);
        b.P0(s.n() >= 4 && s.i(0).equals("projects") && s.i(2).equals("databases") && s.i(4).equals("documents"), "Tried to parse an invalid key: %s", s);
        return new f(s.o(5));
    }

    public static boolean c(l lVar) {
        return lVar.n() % 2 == 0;
    }

    /* renamed from: a */
    public int compareTo(f fVar) {
        return this.b.compareTo(fVar.b);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        return this.b.equals(((f) obj).b);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return this.b.c();
    }
}
