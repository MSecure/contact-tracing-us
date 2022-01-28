package b.h.d;

import b.e.h;
import b.i.k.c;
import java.util.ArrayList;
import java.util.HashSet;

public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final c<ArrayList<T>> f957a = new c<>(10);

    /* renamed from: b  reason: collision with root package name */
    public final h<T, ArrayList<T>> f958b = new h<>();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<T> f959c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public final HashSet<T> f960d = new HashSet<>();

    public void a(T t) {
        if (!(this.f958b.e(t) >= 0)) {
            this.f958b.put(t, null);
        }
    }

    public final void b(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList<T> orDefault = this.f958b.getOrDefault(t, null);
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
