package c.b.a.a.g.b;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class r1 extends p1 {

    /* renamed from: c  reason: collision with root package name */
    public static final Class<?> f3402c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public r1(q1 q1Var) {
        super(null);
    }

    @Override // c.b.a.a.g.b.p1
    public final void a(Object obj, long j) {
        Object obj2;
        List list = (List) n3.t(obj, j);
        if (list instanceof o1) {
            obj2 = ((o1) list).t();
        } else if (!f3402c.isAssignableFrom(list.getClass())) {
            obj2 = Collections.unmodifiableList(list);
        } else {
            return;
        }
        n3.f(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006d  */
    @Override // c.b.a.a.g.b.p1
    public final <E> void b(Object obj, Object obj2, long j) {
        int size;
        n1 n1Var;
        List list = (List) n3.t(obj2, j);
        int size2 = list.size();
        List list2 = (List) n3.t(obj, j);
        if (list2.isEmpty()) {
            list2 = list2 instanceof o1 ? new n1(size2) : new ArrayList(size2);
        } else {
            if (f3402c.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList = new ArrayList(list2.size() + size2);
                arrayList.addAll(list2);
                n1Var = arrayList;
            } else {
                if (list2 instanceof k3) {
                    n1 n1Var2 = new n1(list2.size() + size2);
                    n1Var2.addAll(n1Var2.size(), (k3) list2);
                    n1Var = n1Var2;
                }
                size = list2.size();
                int size3 = list.size();
                if (size > 0 && size3 > 0) {
                    list2.addAll(list);
                }
                if (size > 0) {
                    list = list2;
                }
                n3.f(obj, j, list);
            }
            list2 = n1Var;
        }
        n3.f(obj, j, list2);
        size = list2.size();
        int size32 = list.size();
        list2.addAll(list);
        if (size > 0) {
        }
        n3.f(obj, j, list);
    }
}
