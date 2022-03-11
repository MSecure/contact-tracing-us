package f.b.c.k.u.p;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.c.d;
import f.b.c.k.u.f;
import f.b.c.k.u.i;
import f.b.c.k.u.k;

public abstract class e {
    public final f a;
    public final k b;

    public e(f fVar, k kVar) {
        this.a = fVar;
        this.b = kVar;
    }

    public abstract i a(i iVar, i iVar2, d dVar);

    public abstract i b(i iVar, h hVar);

    public abstract k c(i iVar);

    public boolean d(e eVar) {
        return this.a.equals(eVar.a) && this.b.equals(eVar.b);
    }

    public int e() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public String f() {
        StringBuilder h2 = a.h("key=");
        h2.append(this.a);
        h2.append(", precondition=");
        h2.append(this.b);
        return h2.toString();
    }

    public void g(i iVar) {
        if (iVar != null) {
            b.a1(iVar.a.equals(this.a), "Can only apply a mutation to a document with the same key", new Object[0]);
        }
    }
}
