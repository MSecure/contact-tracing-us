package e.h.a;

import e.e.h;
import e.i.h.b;
import java.util.ArrayList;
import java.util.HashSet;

public final class a<T> {
    public final b<ArrayList<T>> a = new b<>(10);
    public final h<T, ArrayList<T>> b = new h<>();
    public final ArrayList<T> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public final HashSet<T> f1396d = new HashSet<>();

    public void a(T t) {
        if (!(this.b.e(t) >= 0)) {
            this.b.put(t, null);
        }
    }

    public final void b(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList<T> orDefault = this.b.getOrDefault(t, null);
                if (orDefault != null) {
                    int size = orDefault.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        b(orDefault.get(i2), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }
}
