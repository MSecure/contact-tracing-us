package c.b.d;

import c.b.d.m0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class t0 {

    /* renamed from: a  reason: collision with root package name */
    public static final t0 f4328a = new b(null);

    /* renamed from: b  reason: collision with root package name */
    public static final t0 f4329b = new c(null);

    public static final class b extends t0 {

        /* renamed from: c  reason: collision with root package name */
        public static final Class<?> f4330c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        public b(a aVar) {
            super(null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.util.ArrayList */
        /* JADX WARN: Multi-variable type inference failed */
        public static <L> List<L> d(Object obj, long j, int i) {
            m0.h g;
            r0 r0Var;
            List<L> list = (List) u2.p(obj, j);
            if (list.isEmpty()) {
                if (list instanceof s0) {
                    list = new r0(i);
                } else if (!(list instanceof w1) || !(list instanceof m0.h)) {
                    list = new ArrayList<>(i);
                } else {
                    g = ((m0.h) list).g(i);
                }
                u2.f.t(obj, j, list);
                return list;
            }
            if (f4330c.isAssignableFrom(list.getClass())) {
                ArrayList arrayList = new ArrayList(list.size() + i);
                arrayList.addAll(list);
                r0Var = arrayList;
            } else if (list instanceof t2) {
                r0 r0Var2 = new r0(list.size() + i);
                r0Var2.addAll(r0Var2.size(), (t2) list);
                r0Var = r0Var2;
            } else {
                if ((list instanceof w1) && (list instanceof m0.h)) {
                    m0.h hVar = (m0.h) list;
                    if (!hVar.k()) {
                        g = hVar.g(list.size() + i);
                    }
                }
                return list;
            }
            list = r0Var;
            u2.f.t(obj, j, list);
            return list;
            list = g;
            u2.f.t(obj, j, list);
            return list;
        }

        @Override // c.b.d.t0
        public void a(Object obj, long j) {
            Object obj2;
            List list = (List) u2.p(obj, j);
            if (list instanceof s0) {
                obj2 = ((s0) list).b();
            } else if (!f4330c.isAssignableFrom(list.getClass())) {
                if (!(list instanceof w1) || !(list instanceof m0.h)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    m0.h hVar = (m0.h) list;
                    if (hVar.k()) {
                        hVar.d();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            u2.f.t(obj, j, obj2);
        }

        @Override // c.b.d.t0
        public <E> void b(Object obj, Object obj2, long j) {
            List list = (List) u2.p(obj2, j);
            List d2 = d(obj, j, list.size());
            int size = d2.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                d2.addAll(list);
            }
            if (size > 0) {
                list = d2;
            }
            u2.f.t(obj, j, list);
        }

        @Override // c.b.d.t0
        public <L> List<L> c(Object obj, long j) {
            return d(obj, j, 10);
        }
    }

    public static final class c extends t0 {
        public c(a aVar) {
            super(null);
        }

        public static <E> m0.h<E> d(Object obj, long j) {
            return (m0.h) u2.p(obj, j);
        }

        @Override // c.b.d.t0
        public void a(Object obj, long j) {
            d(obj, j).d();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
        @Override // c.b.d.t0
        public <E> void b(Object obj, Object obj2, long j) {
            m0.h<E> d2 = d(obj, j);
            m0.h<E> d3 = d(obj2, j);
            int size = d2.size();
            int size2 = d3.size();
            m0.h<E> hVar = d2;
            hVar = d2;
            if (size > 0 && size2 > 0) {
                boolean k = d2.k();
                m0.h<E> hVar2 = d2;
                if (!k) {
                    hVar2 = d2.g(size2 + size);
                }
                hVar2.addAll(d3);
                hVar = hVar2;
            }
            if (size > 0) {
                d3 = hVar;
            }
            u2.f.t(obj, j, d3);
        }

        @Override // c.b.d.t0
        public <L> List<L> c(Object obj, long j) {
            m0.h d2 = d(obj, j);
            if (d2.k()) {
                return d2;
            }
            int size = d2.size();
            m0.h g = d2.g(size == 0 ? 10 : size * 2);
            u2.f.t(obj, j, g);
            return g;
        }
    }

    public t0(a aVar) {
    }

    public abstract void a(Object obj, long j);

    public abstract <L> void b(Object obj, Object obj2, long j);

    public abstract <L> List<L> c(Object obj, long j);
}
