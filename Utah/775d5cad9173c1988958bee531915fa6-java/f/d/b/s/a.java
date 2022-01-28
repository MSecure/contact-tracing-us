package f.d.b.s;

import f.d.b.i;
import f.d.b.j;
import j.k.b.e;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX WARN: Incorrect class signature, class is equals to this class: <Identifiable::Lf/d/b/j;>Lf/d/b/s/a<TIdentifiable;>; */
public final class a<Identifiable extends j> implements i {
    public final AtomicLong b = new AtomicLong(-2);

    @Override // f.d.b.i
    public List a(List list) {
        e.c(list, "identifiables");
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = (j) list.get(i2);
            e.c(jVar, "identifiable");
            if (jVar.f() == -1) {
                e.c(jVar, "identifiable");
                jVar.b(this.b.decrementAndGet());
            }
        }
        return list;
    }
}
