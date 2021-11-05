package c.b.c.a.j0.a;

import c.b.c.a.j0.a.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class h0 {

    /* renamed from: a  reason: collision with root package name */
    public static final h0 f3557a = new b(null);

    /* renamed from: b  reason: collision with root package name */
    public static final h0 f3558b = new c(null);

    public static final class b extends h0 {

        /* renamed from: c  reason: collision with root package name */
        public static final Class<?> f3559c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        public b(a aVar) {
            super(null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.util.ArrayList */
        /* JADX WARN: Multi-variable type inference failed */
        public static <L> List<L> d(Object obj, long j, int i) {
            a0.c g;
            f0 f0Var;
            List<L> list = (List) p1.n(obj, j);
            if (list.isEmpty()) {
                if (list instanceof g0) {
                    list = new f0(i);
                } else if (!(list instanceof z0) || !(list instanceof a0.c)) {
                    list = new ArrayList<>(i);
                } else {
                    g = ((a0.c) list).g(i);
                }
                p1.f.q(obj, j, list);
                return list;
            }
            if (f3559c.isAssignableFrom(list.getClass())) {
                ArrayList arrayList = new ArrayList(list.size() + i);
                arrayList.addAll(list);
                f0Var = arrayList;
            } else if (list instanceof o1) {
                f0 f0Var2 = new f0(list.size() + i);
                f0Var2.addAll(f0Var2.size(), (o1) list);
                f0Var = f0Var2;
            } else {
                if ((list instanceof z0) && (list instanceof a0.c)) {
                    a0.c cVar = (a0.c) list;
                    if (!cVar.k()) {
                        g = cVar.g(list.size() + i);
                    }
                }
                return list;
            }
            list = f0Var;
            p1.f.q(obj, j, list);
            return list;
            list = g;
            p1.f.q(obj, j, list);
            return list;
        }

        @Override // c.b.c.a.j0.a.h0
        public void a(Object obj, long j) {
            Object obj2;
            List list = (List) p1.n(obj, j);
            if (list instanceof g0) {
                obj2 = ((g0) list).b();
            } else if (!f3559c.isAssignableFrom(list.getClass())) {
                if (!(list instanceof z0) || !(list instanceof a0.c)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    a0.c cVar = (a0.c) list;
                    if (cVar.k()) {
                        cVar.d();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            p1.f.q(obj, j, obj2);
        }

        @Override // c.b.c.a.j0.a.h0
        public <E> void b(Object obj, Object obj2, long j) {
            List list = (List) p1.n(obj2, j);
            List d2 = d(obj, j, list.size());
            int size = d2.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                d2.addAll(list);
            }
            if (size > 0) {
                list = d2;
            }
            p1.f.q(obj, j, list);
        }

        @Override // c.b.c.a.j0.a.h0
        public <L> List<L> c(Object obj, long j) {
            return d(obj, j, 10);
        }
    }

    public static final class c extends h0 {
        public c(a aVar) {
            super(null);
        }

        public static <E> a0.c<E> d(Object obj, long j) {
            return (a0.c) p1.n(obj, j);
        }

        @Override // c.b.c.a.j0.a.h0
        public void a(Object obj, long j) {
            d(obj, j).d();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
        @Override // c.b.c.a.j0.a.h0
        public <E> void b(Object obj, Object obj2, long j) {
            a0.c<E> d2 = d(obj, j);
            a0.c<E> d3 = d(obj2, j);
            int size = d2.size();
            int size2 = d3.size();
            a0.c<E> cVar = d2;
            cVar = d2;
            if (size > 0 && size2 > 0) {
                boolean k = d2.k();
                a0.c<E> cVar2 = d2;
                if (!k) {
                    cVar2 = d2.g(size2 + size);
                }
                cVar2.addAll(d3);
                cVar = cVar2;
            }
            if (size > 0) {
                d3 = cVar;
            }
            p1.f.q(obj, j, d3);
        }

        @Override // c.b.c.a.j0.a.h0
        public <L> List<L> c(Object obj, long j) {
            a0.c d2 = d(obj, j);
            if (d2.k()) {
                return d2;
            }
            int size = d2.size();
            a0.c g = d2.g(size == 0 ? 10 : size * 2);
            p1.f.q(obj, j, g);
            return g;
        }
    }

    public h0(a aVar) {
    }

    public abstract void a(Object obj, long j);

    public abstract <L> void b(Object obj, Object obj2, long j);

    public abstract <L> List<L> c(Object obj, long j);
}
