package c.b.a.a.g.h;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class k2 extends k0<String> implements j2, RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    public static final k2 f3924d;

    /* renamed from: c  reason: collision with root package name */
    public final List<Object> f3925c;

    static {
        k2 k2Var = new k2(10);
        f3924d = k2Var;
        k2Var.f3921b = false;
    }

    public k2(int i) {
        this.f3925c = new ArrayList(i);
    }

    public k2(ArrayList<Object> arrayList) {
        this.f3925c = arrayList;
    }

    public static String c(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof q0 ? ((q0) obj).j() : u1.g((byte[]) obj);
    }

    @Override // c.b.a.a.g.h.j2
    public final j2 A() {
        return this.f3921b ? new e4(this) : this;
    }

    @Override // c.b.a.a.g.h.z1
    public final /* synthetic */ z1 B(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f3925c);
            return new k2(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // c.b.a.a.g.h.j2
    public final List<?> P() {
        return Collections.unmodifiableList(this.f3925c);
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, Object obj) {
        a();
        this.f3925c.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.List, c.b.a.a.g.h.k0, java.util.AbstractList
    public final boolean addAll(int i, Collection<? extends String> collection) {
        a();
        if (collection instanceof j2) {
            collection = ((j2) collection).P();
        }
        boolean addAll = this.f3925c.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // java.util.AbstractCollection, java.util.List, c.b.a.a.g.h.k0, java.util.Collection
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // c.b.a.a.g.h.k0
    public final void clear() {
        a();
        this.f3925c.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.List, java.util.AbstractList
    public final Object get(int i) {
        Object obj = this.f3925c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof q0) {
            q0 q0Var = (q0) obj;
            String j = q0Var.j();
            x0 x0Var = (x0) q0Var;
            int p = x0Var.p();
            if (k4.d(x0Var.f4062e, p, x0Var.size() + p)) {
                this.f3925c.set(i, j);
            }
            return j;
        }
        byte[] bArr = (byte[]) obj;
        String g2 = u1.g(bArr);
        boolean z = false;
        if (k4.f3928a.a(0, bArr, 0, bArr.length) == 0) {
            z = true;
        }
        if (z) {
            this.f3925c.set(i, g2);
        }
        return g2;
    }

    @Override // c.b.a.a.g.h.j2
    public final Object n(int i) {
        return this.f3925c.get(i);
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object remove(int i) {
        a();
        Object remove = this.f3925c.remove(i);
        ((AbstractList) this).modCount++;
        return c(remove);
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object set(int i, Object obj) {
        a();
        return c(this.f3925c.set(i, (String) obj));
    }

    public final int size() {
        return this.f3925c.size();
    }
}
