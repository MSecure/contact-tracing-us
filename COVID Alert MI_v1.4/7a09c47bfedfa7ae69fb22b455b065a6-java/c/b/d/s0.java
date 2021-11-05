package c.b.d;

import c.b.d.n0;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class s0 extends d<String> implements t0, RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    public static final s0 f5862d;

    /* renamed from: e  reason: collision with root package name */
    public static final t0 f5863e;

    /* renamed from: c  reason: collision with root package name */
    public final List<Object> f5864c;

    static {
        s0 s0Var = new s0(10);
        f5862d = s0Var;
        s0Var.f5244b = false;
        f5863e = s0Var;
    }

    public s0(int i) {
        this.f5864c = new ArrayList(i);
    }

    public s0(ArrayList<Object> arrayList) {
        this.f5864c = arrayList;
    }

    public static String c(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof j ? ((j) obj).z() : n0.h((byte[]) obj);
    }

    @Override // c.b.d.t0
    public void D(j jVar) {
        a();
        this.f5864c.add(jVar);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, Object obj) {
        a();
        this.f5864c.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // c.b.d.d, java.util.List, java.util.AbstractList
    public boolean addAll(int i, Collection<? extends String> collection) {
        a();
        if (collection instanceof t0) {
            collection = ((t0) collection).k();
        }
        boolean addAll = this.f5864c.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // c.b.d.d, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // c.b.d.t0
    public Object b(int i) {
        return this.f5864c.get(i);
    }

    @Override // c.b.d.d
    public void clear() {
        a();
        this.f5864c.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // c.b.d.t0
    public t0 d() {
        return this.f5244b ? new u2(this) : this;
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
        Object obj = this.f5864c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            h = jVar.z();
        } else {
            byte[] bArr = (byte[]) obj;
            h = n0.h(bArr);
            boolean z = false;
            if (w2.f5905a.e(0, bArr, 0, bArr.length) == 0) {
                z = true;
            }
        }
        this.f5864c.set(i, h);
        return h;
    }

    @Override // c.b.d.n0.h
    public n0.h i(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.f5864c);
            return new s0(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // c.b.d.t0
    public List<?> k() {
        return Collections.unmodifiableList(this.f5864c);
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i) {
        a();
        Object remove = this.f5864c.remove(i);
        ((AbstractList) this).modCount++;
        return c(remove);
    }

    @Override // java.util.List, java.util.AbstractList
    public Object set(int i, Object obj) {
        a();
        return c(this.f5864c.set(i, (String) obj));
    }

    public int size() {
        return this.f5864c.size();
    }

    public s0(t0 t0Var) {
        this.f5864c = new ArrayList(t0Var.size());
        addAll(size(), t0Var);
    }
}
