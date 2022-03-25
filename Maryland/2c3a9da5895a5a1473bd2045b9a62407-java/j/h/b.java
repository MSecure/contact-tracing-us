package j.h;

import f.a.a.a.a;
import j.j.b.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class b {
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> a(List<? extends T> list) {
        e.c(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        return size != 0 ? size != 1 ? list : f.b.a.c.b.o.b.o1(list.get(0)) : d.b;
    }

    public static final <T> List<T> b(Iterable<? extends T> iterable, int i2) {
        d dVar = d.b;
        e.c(iterable, "$this$take");
        int i3 = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(a.r("Requested element count ", i2, " is less than zero.").toString());
        } else if (i2 == 0) {
            return dVar;
        } else {
            Collection collection = (Collection) iterable;
            if (i2 >= collection.size()) {
                e.c(iterable, "$this$toList");
                int size = collection.size();
                if (size == 0) {
                    return dVar;
                }
                if (size == 1) {
                    return f.b.a.c.b.o.b.o1(((List) iterable).get(0));
                }
                e.c(collection, "$this$toMutableList");
                return new ArrayList(collection);
            } else if (i2 == 1) {
                e.c(iterable, "$this$first");
                List list = (List) iterable;
                e.c(list, "$this$first");
                if (!list.isEmpty()) {
                    return f.b.a.c.b.o.b.o1(list.get(0));
                }
                throw new NoSuchElementException("List is empty.");
            } else {
                ArrayList arrayList = new ArrayList(i2);
                Iterator<? extends T> it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                    i3++;
                    if (i3 == i2) {
                        break;
                    }
                }
                return a(arrayList);
            }
        }
    }
}
