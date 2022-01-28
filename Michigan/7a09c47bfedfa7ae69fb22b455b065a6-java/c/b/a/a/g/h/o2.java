package c.b.a.a.g.h;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class o2 extends m2 {

    /* renamed from: c  reason: collision with root package name */
    public static final Class<?> f3983c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public o2(l2 l2Var) {
        super(null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    @Override // c.b.a.a.g.h.m2
    public final <E> void a(Object obj, Object obj2, long j) {
        int size;
        z1<E> z1Var;
        ArrayList arrayList;
        List list = (List) j4.s(obj2, j);
        int size2 = list.size();
        List list2 = (List) j4.s(obj, j);
        if (list2.isEmpty()) {
            if (list2 instanceof j2) {
                list2 = new k2(size2);
            } else if (!(list2 instanceof l3) || !(list2 instanceof z1)) {
                list2 = new ArrayList(size2);
            } else {
                z1Var = ((z1) list2).B(size2);
            }
            j4.e(obj, j, list2);
            size = list2.size();
            int size3 = list.size();
            if (size > 0 && size3 > 0) {
                list2.addAll(list);
            }
            if (size > 0) {
                list = list2;
            }
            j4.e(obj, j, list);
        }
        if (f3983c.isAssignableFrom(list2.getClass())) {
            ArrayList arrayList2 = new ArrayList(list2.size() + size2);
            arrayList2.addAll(list2);
            arrayList = arrayList2;
        } else if (list2 instanceof e4) {
            k2 k2Var = new k2(list2.size() + size2);
            k2Var.addAll(k2Var.size(), (e4) list2);
            arrayList = k2Var;
        } else {
            if ((list2 instanceof l3) && (list2 instanceof z1)) {
                z1 z1Var2 = (z1) list2;
                if (!z1Var2.s()) {
                    z1Var = z1Var2.B(list2.size() + size2);
                }
            }
            size = list2.size();
            int size32 = list.size();
            list2.addAll(list);
            if (size > 0) {
            }
            j4.e(obj, j, list);
        }
        list2 = arrayList;
        j4.e(obj, j, list2);
        size = list2.size();
        int size322 = list.size();
        list2.addAll(list);
        if (size > 0) {
        }
        j4.e(obj, j, list);
        list2 = z1Var;
        j4.e(obj, j, list2);
        size = list2.size();
        int size3222 = list.size();
        list2.addAll(list);
        if (size > 0) {
        }
        j4.e(obj, j, list);
    }

    @Override // c.b.a.a.g.h.m2
    public final void b(Object obj, long j) {
        Object obj2;
        List list = (List) j4.s(obj, j);
        if (list instanceof j2) {
            obj2 = ((j2) list).A();
        } else if (!f3983c.isAssignableFrom(list.getClass())) {
            if (!(list instanceof l3) || !(list instanceof z1)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                z1 z1Var = (z1) list;
                if (z1Var.s()) {
                    z1Var.H();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        j4.e(obj, j, obj2);
    }
}
