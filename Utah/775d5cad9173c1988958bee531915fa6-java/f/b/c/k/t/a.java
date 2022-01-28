package f.b.c.k.t;

import f.b.c.k.x.r;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {
    public static final a a = new a();

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        c cVar = (c) obj;
        c cVar2 = (c) obj2;
        int a2 = cVar.a.compareTo(cVar2.a);
        return a2 != 0 ? a2 : r.a(cVar.b, cVar2.b);
    }
}
