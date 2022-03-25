package f.b.f;

import f.b.f.c0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class j0 {
    public static final j0 a = new b(null);
    public static final j0 b = new c(null);

    public static final class b extends j0 {
        public static final Class<?> c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        public b(a aVar) {
            super(null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.util.ArrayList */
        /* JADX WARN: Multi-variable type inference failed */
        public static <L> List<L> d(Object obj, long j2, int i2) {
            c0.i d2;
            h0 h0Var;
            List<L> list = (List) v1.p(obj, j2);
            if (list.isEmpty()) {
                if (list instanceof i0) {
                    list = new h0(i2);
                } else if (!(list instanceof c1) || !(list instanceof c0.i)) {
                    list = new ArrayList<>(i2);
                } else {
                    d2 = ((c0.i) list).d(i2);
                }
                v1.f3480f.s(obj, j2, list);
                return list;
            }
            if (c.isAssignableFrom(list.getClass())) {
                ArrayList arrayList = new ArrayList(list.size() + i2);
                arrayList.addAll(list);
                h0Var = arrayList;
            } else if (list instanceof u1) {
                h0 h0Var2 = new h0(list.size() + i2);
                h0Var2.addAll(h0Var2.size(), (u1) list);
                h0Var = h0Var2;
            } else {
                if ((list instanceof c1) && (list instanceof c0.i)) {
                    c0.i iVar = (c0.i) list;
                    if (!iVar.g()) {
                        d2 = iVar.d(list.size() + i2);
                    }
                }
                return list;
            }
            list = h0Var;
            v1.f3480f.s(obj, j2, list);
            return list;
            list = d2;
            v1.f3480f.s(obj, j2, list);
            return list;
        }

        @Override // f.b.f.j0
        public void a(Object obj, long j2) {
            Object obj2;
            List list = (List) v1.p(obj, j2);
            if (list instanceof i0) {
                obj2 = ((i0) list).a();
            } else if (!c.isAssignableFrom(list.getClass())) {
                if (!(list instanceof c1) || !(list instanceof c0.i)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    c0.i iVar = (c0.i) list;
                    if (iVar.g()) {
                        iVar.b();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            v1.f3480f.s(obj, j2, obj2);
        }

        @Override // f.b.f.j0
        public <E> void b(Object obj, Object obj2, long j2) {
            List list = (List) v1.p(obj2, j2);
            List d2 = d(obj, j2, list.size());
            int size = d2.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                d2.addAll(list);
            }
            if (size > 0) {
                list = d2;
            }
            v1.f3480f.s(obj, j2, list);
        }

        @Override // f.b.f.j0
        public <L> List<L> c(Object obj, long j2) {
            return d(obj, j2, 10);
        }
    }

    public static final class c extends j0 {
        public c(a aVar) {
            super(null);
        }

        public static <E> c0.i<E> d(Object obj, long j2) {
            return (c0.i) v1.p(obj, j2);
        }

        @Override // f.b.f.j0
        public void a(Object obj, long j2) {
            d(obj, j2).b();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
        @Override // f.b.f.j0
        public <E> void b(Object obj, Object obj2, long j2) {
            c0.i<E> d2 = d(obj, j2);
            c0.i<E> d3 = d(obj2, j2);
            int size = d2.size();
            int size2 = d3.size();
            c0.i<E> iVar = d2;
            iVar = d2;
            if (size > 0 && size2 > 0) {
                boolean g2 = d2.g();
                c0.i<E> iVar2 = d2;
                if (!g2) {
                    iVar2 = d2.d(size2 + size);
                }
                iVar2.addAll(d3);
                iVar = iVar2;
            }
            if (size > 0) {
                d3 = iVar;
            }
            v1.f3480f.s(obj, j2, d3);
        }

        @Override // f.b.f.j0
        public <L> List<L> c(Object obj, long j2) {
            c0.i d2 = d(obj, j2);
            if (d2.g()) {
                return d2;
            }
            int size = d2.size();
            c0.i d3 = d2.d(size == 0 ? 10 : size * 2);
            v1.f3480f.s(obj, j2, d3);
            return d3;
        }
    }

    public j0(a aVar) {
    }

    public abstract void a(Object obj, long j2);

    public abstract <L> void b(Object obj, Object obj2, long j2);

    public abstract <L> List<L> c(Object obj, long j2);
}
