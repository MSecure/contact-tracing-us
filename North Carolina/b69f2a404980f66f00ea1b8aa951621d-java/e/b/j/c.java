package e.b.j;

import e.b.g.b;
import e.b.h.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c extends ArrayList<i> {
    public c() {
    }

    public c(int i) {
        super(i);
    }

    public c(List<i> list) {
        super(list);
    }

    @Override // java.lang.Object
    public Object clone() {
        c cVar = new c(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            cVar.add(((i) it.next()).j());
        }
        return cVar;
    }

    public String toString() {
        StringBuilder b2 = b.b();
        Iterator it = iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (b2.length() != 0) {
                b2.append("\n");
            }
            b2.append(iVar.t());
        }
        return b.j(b2);
    }
}
