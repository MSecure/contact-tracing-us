package c.b.c.a.j0.a;

import c.b.c.a.j0.a.a0;
import c.b.c.a.j0.a.i;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class f0 extends c<String> implements g0, RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    public static final f0 f3552d;

    /* renamed from: c  reason: collision with root package name */
    public final List<Object> f3553c;

    static {
        f0 f0Var = new f0(10);
        f3552d = f0Var;
        f0Var.f3526b = false;
    }

    public f0(int i) {
        this.f3553c = new ArrayList(i);
    }

    public f0(ArrayList<Object> arrayList) {
        this.f3553c = arrayList;
    }

    public static String c(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof i ? ((i) obj).s() : a0.h((byte[]) obj);
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        a();
        this.f3553c.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.List, c.b.c.a.j0.a.c, java.util.AbstractList
    public boolean addAll(int i, Collection<? extends String> collection) {
        a();
        if (collection instanceof g0) {
            collection = ((g0) collection).i();
        }
        boolean addAll = this.f3553c.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // java.util.AbstractCollection, java.util.List, c.b.c.a.j0.a.c, java.util.Collection
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // c.b.c.a.j0.a.g0
    public g0 b() {
        return this.f3526b ? new o1(this) : this;
    }

    @Override // c.b.c.a.j0.a.c
    public void clear() {
        a();
        this.f3553c.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // c.b.c.a.j0.a.g0
    public Object f(int i) {
        return this.f3553c.get(i);
    }

    @Override // c.b.c.a.j0.a.a0.c
    public a0.c g(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f3553c);
            return new f0(arrayList);
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        if (r4 != false) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0028, code lost:
        if (c.b.c.a.j0.a.q1.f(r0.f3569e, r2, r0.size() + r2) != false) goto L_0x002a;
     */
    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        String h;
        Object obj = this.f3553c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            h = iVar.s();
            i.g gVar = (i.g) iVar;
            int u = gVar.u();
        } else {
            byte[] bArr = (byte[]) obj;
            h = a0.h(bArr);
            boolean z = false;
            if (q1.f3635a.c(0, bArr, 0, bArr.length) == 0) {
                z = true;
            }
        }
        this.f3553c.set(i, h);
        return h;
    }

    @Override // c.b.c.a.j0.a.g0
    public List<?> i() {
        return Collections.unmodifiableList(this.f3553c);
    }

    @Override // c.b.c.a.j0.a.g0
    public void n(i iVar) {
        a();
        this.f3553c.add(iVar);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        Object remove = this.f3553c.remove(i);
        ((AbstractList) this).modCount++;
        return c(remove);
    }

    @Override // java.util.List, java.util.AbstractList
    public Object set(int i, Object obj) {
        a();
        return c(this.f3553c.set(i, (String) obj));
    }

    public int size() {
        return this.f3553c.size();
    }
}
