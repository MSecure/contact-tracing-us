package c.b.a.a.g.b;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class n1 extends s<String> implements o1, RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    public static final n1 f3362d;

    /* renamed from: c  reason: collision with root package name */
    public final List<Object> f3363c;

    static {
        n1 n1Var = new n1(10);
        f3362d = n1Var;
        n1Var.f3405b = false;
    }

    public n1(int i) {
        this.f3363c = new ArrayList(i);
    }

    public n1(ArrayList<Object> arrayList) {
        this.f3363c = arrayList;
    }

    public static String c(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof y ? ((y) obj).h() : b1.g((byte[]) obj);
    }

    @Override // c.b.a.a.g.b.o1
    public final List<?> F() {
        return Collections.unmodifiableList(this.f3363c);
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ void add(int i, Object obj) {
        a();
        this.f3363c.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.List, c.b.a.a.g.b.s, java.util.AbstractList
    public final boolean addAll(int i, Collection<? extends String> collection) {
        a();
        if (collection instanceof o1) {
            collection = ((o1) collection).F();
        }
        boolean addAll = this.f3363c.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, c.b.a.a.g.b.s
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // c.b.a.a.g.b.o1
    public final Object b(int i) {
        return this.f3363c.get(i);
    }

    @Override // c.b.a.a.g.b.s
    public final void clear() {
        a();
        this.f3363c.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.List, java.util.AbstractList
    public final Object get(int i) {
        Object obj = this.f3363c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof y) {
            y yVar = (y) obj;
            String h = yVar.h();
            d0 d0Var = (d0) yVar;
            int j = d0Var.j();
            if (p3.f(d0Var.f3242e, j, d0Var.size() + j)) {
                this.f3363c.set(i, h);
            }
            return h;
        }
        byte[] bArr = (byte[]) obj;
        String g2 = b1.g(bArr);
        boolean z = false;
        if (p3.f3393a.a(0, bArr, 0, bArr.length) == 0) {
            z = true;
        }
        if (z) {
            this.f3363c.set(i, g2);
        }
        return g2;
    }

    @Override // c.b.a.a.g.b.e1
    public final /* synthetic */ e1 r(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f3363c);
            return new n1(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object remove(int i) {
        a();
        Object remove = this.f3363c.remove(i);
        ((AbstractList) this).modCount++;
        return c(remove);
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object set(int i, Object obj) {
        a();
        return c(this.f3363c.set(i, (String) obj));
    }

    public final int size() {
        return this.f3363c.size();
    }

    @Override // c.b.a.a.g.b.o1
    public final o1 t() {
        return this.f3405b ? new k3(this) : this;
    }
}
