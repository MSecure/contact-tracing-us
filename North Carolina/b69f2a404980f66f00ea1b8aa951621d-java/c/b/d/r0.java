package c.b.d;

import c.b.d.m0;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class r0 extends d<String> implements s0, RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    public static final r0 f4260d;

    /* renamed from: e  reason: collision with root package name */
    public static final s0 f4261e;

    /* renamed from: c  reason: collision with root package name */
    public final List<Object> f4262c;

    static {
        r0 r0Var = new r0(10);
        f4260d = r0Var;
        r0Var.f3839b = false;
        f4261e = r0Var;
    }

    public r0(int i) {
        this.f4262c = new ArrayList(i);
    }

    public r0(ArrayList<Object> arrayList) {
        this.f4262c = arrayList;
    }

    public static String c(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof j ? ((j) obj).u() : m0.h((byte[]) obj);
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        a();
        this.f4262c.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // c.b.d.d, java.util.List, java.util.AbstractList
    public boolean addAll(int i, Collection<? extends String> collection) {
        a();
        if (collection instanceof s0) {
            collection = ((s0) collection).i();
        }
        boolean addAll = this.f4262c.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // c.b.d.s0
    public s0 b() {
        return this.f3839b ? new t2(this) : this;
    }

    @Override // c.b.d.d
    public void clear() {
        a();
        this.f4262c.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // c.b.d.s0
    public Object f(int i) {
        return this.f4262c.get(i);
    }

    @Override // c.b.d.m0.h
    public m0.h g(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f4262c);
            return new r0(arrayList);
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        if (r4 != false) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (r0.o() != false) goto L_0x001d;
     */
    @Override // java.util.List, java.util.AbstractList
    public Object get(int i) {
        String h;
        Object obj = this.f4262c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            h = jVar.u();
        } else {
            byte[] bArr = (byte[]) obj;
            h = m0.h(bArr);
            boolean z = false;
            if (v2.f4362a.e(0, bArr, 0, bArr.length) == 0) {
                z = true;
            }
        }
        this.f4262c.set(i, h);
        return h;
    }

    @Override // c.b.d.s0
    public List<?> i() {
        return Collections.unmodifiableList(this.f4262c);
    }

    @Override // c.b.d.s0
    public void l(j jVar) {
        a();
        this.f4262c.add(jVar);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        Object remove = this.f4262c.remove(i);
        ((AbstractList) this).modCount++;
        return c(remove);
    }

    @Override // java.util.List, java.util.AbstractList
    public Object set(int i, Object obj) {
        a();
        return c(this.f4262c.set(i, (String) obj));
    }

    public int size() {
        return this.f4262c.size();
    }

    public r0(s0 s0Var) {
        this.f4262c = new ArrayList(s0Var.size());
        addAll(size(), s0Var);
    }
}
