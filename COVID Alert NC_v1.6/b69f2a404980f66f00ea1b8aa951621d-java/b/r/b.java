package b.r;

import b.u.a.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class b<T> extends m {
    public b(h hVar) {
        super(hVar);
    }

    public abstract void bind(f fVar, T t);

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: b.r.b<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void insert(Iterable<? extends T> iterable) {
        f acquire = acquire();
        try {
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                ((b.u.a.g.f) acquire).a();
            }
        } finally {
            release(acquire);
        }
    }

    public final void insert(T t) {
        b.u.a.g.f acquire = acquire();
        try {
            bind(acquire, t);
            acquire = (b.u.a.g.f) acquire;
            acquire.a();
        } finally {
            release(acquire);
        }
    }

    public final void insert(T[] tArr) {
        f acquire = acquire();
        try {
            for (T t : tArr) {
                bind(acquire, t);
                ((b.u.a.g.f) acquire).a();
            }
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(T t) {
        b.u.a.g.f acquire = acquire();
        try {
            bind(acquire, t);
            acquire = (b.u.a.g.f) acquire;
            return acquire.a();
        } finally {
            release(acquire);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: b.r.b<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final long[] insertAndReturnIdsArray(Collection<? extends T> collection) {
        f acquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            int i = 0;
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                jArr[i] = ((b.u.a.g.f) acquire).a();
                i++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] tArr) {
        f acquire = acquire();
        try {
            long[] jArr = new long[tArr.length];
            int i = 0;
            for (T t : tArr) {
                bind(acquire, t);
                jArr[i] = ((b.u.a.g.f) acquire).a();
                i++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: b.r.b<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        f acquire = acquire();
        try {
            Long[] lArr = new Long[collection.size()];
            int i = 0;
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                lArr[i] = Long.valueOf(((b.u.a.g.f) acquire).a());
                i++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] tArr) {
        f acquire = acquire();
        try {
            Long[] lArr = new Long[tArr.length];
            int i = 0;
            for (T t : tArr) {
                bind(acquire, t);
                lArr[i] = Long.valueOf(((b.u.a.g.f) acquire).a());
                i++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: b.r.b<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<Long> insertAndReturnIdsList(Collection<? extends T> collection) {
        f acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(collection.size());
            int i = 0;
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                arrayList.add(i, Long.valueOf(((b.u.a.g.f) acquire).a()));
                i++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] tArr) {
        f acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(tArr.length);
            int i = 0;
            for (T t : tArr) {
                bind(acquire, t);
                arrayList.add(i, Long.valueOf(((b.u.a.g.f) acquire).a()));
                i++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }
}
