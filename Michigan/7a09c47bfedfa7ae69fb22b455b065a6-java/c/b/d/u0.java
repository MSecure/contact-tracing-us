package c.b.d;

import c.b.d.n0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class u0 {

    /* renamed from: a  reason: collision with root package name */
    public static final u0 f5878a = new b(null);

    /* renamed from: b  reason: collision with root package name */
    public static final u0 f5879b = new c(null);

    public static final class b extends u0 {

        /* renamed from: c  reason: collision with root package name */
        public static final Class<?> f5880c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        public b(a aVar) {
            super(null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.util.ArrayList */
        /* JADX WARN: Multi-variable type inference failed */
        public static <L> List<L> d(Object obj, long j, int i) {
            n0.h i2;
            s0 s0Var;
            List<L> list = (List) v2.p(obj, j);
            if (list.isEmpty()) {
                if (list instanceof t0) {
                    list = new s0(i);
                } else if (!(list instanceof x1) || !(list instanceof n0.h)) {
                    list = new ArrayList<>(i);
                } else {
                    i2 = ((n0.h) list).i(i);
                }
                v2.f5899f.t(obj, j, list);
                return list;
            }
            if (f5880c.isAssignableFrom(list.getClass())) {
                ArrayList arrayList = new ArrayList(list.size() + i);
                arrayList.addAll(list);
                s0Var = arrayList;
            } else if (list instanceof u2) {
                s0 s0Var2 = new s0(list.size() + i);
                s0Var2.addAll(s0Var2.size(), (u2) list);
                s0Var = s0Var2;
            } else {
                if ((list instanceof x1) && (list instanceof n0.h)) {
                    n0.h hVar = (n0.h) list;
                    if (!hVar.m()) {
                        i2 = hVar.i(list.size() + i);
                    }
                }
                return list;
            }
            list = s0Var;
            v2.f5899f.t(obj, j, list);
            return list;
            list = i2;
            v2.f5899f.t(obj, j, list);
            return list;
        }

        @Override // c.b.d.u0
        public void a(Object obj, long j) {
            Object obj2;
            List list = (List) v2.p(obj, j);
            if (list instanceof t0) {
                obj2 = ((t0) list).d();
            } else if (!f5880c.isAssignableFrom(list.getClass())) {
                if (!(list instanceof x1) || !(list instanceof n0.h)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    n0.h hVar = (n0.h) list;
                    if (hVar.m()) {
                        hVar.f();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            v2.f5899f.t(obj, j, obj2);
        }

        @Override // c.b.d.u0
        public <E> void b(Object obj, Object obj2, long j) {
            List list = (List) v2.p(obj2, j);
            List d2 = d(obj, j, list.size());
            int size = d2.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                d2.addAll(list);
            }
            if (size > 0) {
                list = d2;
            }
            v2.f5899f.t(obj, j, list);
        }

        @Override // c.b.d.u0
        public <L> List<L> c(Object obj, long j) {
            return d(obj, j, 10);
        }
    }

    public static final class c extends u0 {
        public c(a aVar) {
            super(null);
        }

        public static <E> n0.h<E> d(Object obj, long j) {
            return (n0.h) v2.p(obj, j);
        }

        @Override // c.b.d.u0
        public void a(Object obj, long j) {
            d(obj, j).f();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
        @Override // c.b.d.u0
        public <E> void b(Object obj, Object obj2, long j) {
            n0.h<E> d2 = d(obj, j);
            n0.h<E> d3 = d(obj2, j);
            int size = d2.size();
            int size2 = d3.size();
            n0.h<E> hVar = d2;
            hVar = d2;
            if (size > 0 && size2 > 0) {
                boolean m = d2.m();
                n0.h<E> hVar2 = d2;
                if (!m) {
                    hVar2 = d2.i(size2 + size);
                }
                hVar2.addAll(d3);
                hVar = hVar2;
            }
            if (size > 0) {
                d3 = hVar;
            }
            v2.f5899f.t(obj, j, d3);
        }

        @Override // c.b.d.u0
        public <L> List<L> c(Object obj, long j) {
            n0.h d2 = d(obj, j);
            if (d2.m()) {
                return d2;
            }
            int size = d2.size();
            n0.h i = d2.i(size == 0 ? 10 : size * 2);
            v2.f5899f.t(obj, j, i);
            return i;
        }
    }

    public u0(a aVar) {
    }

    public abstract void a(Object obj, long j);

    public abstract <L> void b(Object obj, Object obj2, long j);

    public abstract <L> List<L> c(Object obj, long j);
}
