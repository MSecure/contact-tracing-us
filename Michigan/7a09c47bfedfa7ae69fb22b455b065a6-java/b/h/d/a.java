package b.h.d;

import b.e.h;
import b.i.k.b;
import java.util.ArrayList;
import java.util.HashSet;

public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final b<ArrayList<T>> f1641a = new b<>(10);

    /* renamed from: b  reason: collision with root package name */
    public final h<T, ArrayList<T>> f1642b = new h<>();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<T> f1643c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public final HashSet<T> f1644d = new HashSet<>();

    public void a(T t) {
        if (!(this.f1642b.e(t) >= 0)) {
            this.f1642b.put(t, null);
        }
    }

    public final void b(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList<T> orDefault = this.f1642b.getOrDefault(t, null);
                if (orDefault != null) {
                    int size = orDefault.size();
                    for (int i = 0; i < size; i++) {
                        b(orDefault.get(i), arrayList, hashSet);
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
