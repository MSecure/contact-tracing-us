package f.b.g;

import f.b.g.c0;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class h0 extends c<String> implements i0, RandomAccess {

    /* renamed from: d  reason: collision with root package name */
    public static final h0 f3552d;
    public final List<Object> c;

    static {
        h0 h0Var = new h0(10);
        f3552d = h0Var;
        h0Var.b = false;
    }

    public h0(int i2) {
        this.c = new ArrayList(i2);
    }

    public h0(ArrayList<Object> arrayList) {
        this.c = arrayList;
    }

    public static String i(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof j) {
            return ((j) obj).B();
        }
        Charset charset = c0.a;
        return new String((byte[]) obj, c0.a);
    }

    @Override // f.b.g.i0
    public i0 a() {
        return this.b ? new u1(this) : this;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i2, Object obj) {
        h();
        this.c.add(i2, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.List, java.util.AbstractList, f.b.g.c
    public boolean addAll(int i2, Collection<? extends String> collection) {
        h();
        if (collection instanceof i0) {
            collection = ((i0) collection).f();
        }
        boolean addAll = this.c.addAll(i2, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, f.b.g.c
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // f.b.g.i0
    public Object c(int i2) {
        return this.c.get(i2);
    }

    @Override // f.b.g.c
    public void clear() {
        h();
        this.c.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // f.b.g.c0.i
    public c0.i d(int i2) {
        if (i2 >= size()) {
            ArrayList arrayList = new ArrayList(i2);
            arrayList.addAll(this.c);
            return new h0(arrayList);
        }
        throw new IllegalArgumentException();
    }

    @Override // f.b.g.i0
    public void e(j jVar) {
        h();
        this.c.add(jVar);
        ((AbstractList) this).modCount++;
    }

    @Override // f.b.g.i0
    public List<?> f() {
        return Collections.unmodifiableList(this.c);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        if (r4 != false) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (r0.t() != false) goto L_0x001d;
     */
    @Override // java.util.List, java.util.AbstractList
    public Object get(int i2) {
        String str;
        Object obj = this.c.get(i2);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            str = jVar.B();
        } else {
            byte[] bArr = (byte[]) obj;
            Charset charset = c0.a;
            str = new String(bArr, c0.a);
            boolean z = false;
            if (w1.a.e(0, bArr, 0, bArr.length) == 0) {
                z = true;
            }
        }
        this.c.set(i2, str);
        return str;
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i2) {
        h();
        Object remove = this.c.remove(i2);
        ((AbstractList) this).modCount++;
        return i(remove);
    }

    @Override // java.util.List, java.util.AbstractList
    public Object set(int i2, Object obj) {
        h();
        return i(this.c.set(i2, (String) obj));
    }

    public int size() {
        return this.c.size();
    }
}
