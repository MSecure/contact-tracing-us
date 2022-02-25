package f.b.f;

import f.a.a.a.a;
import f.b.f.c0;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

public final class h extends c<Boolean> implements c0.a, RandomAccess, c1 {

    /* renamed from: e  reason: collision with root package name */
    public static final h f3300e;
    public boolean[] c;

    /* renamed from: d  reason: collision with root package name */
    public int f3301d;

    static {
        h hVar = new h(new boolean[0], 0);
        f3300e = hVar;
        hVar.b = false;
    }

    public h() {
        this.c = new boolean[10];
        this.f3301d = 0;
    }

    public h(boolean[] zArr, int i2) {
        this.c = zArr;
        this.f3301d = i2;
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i2, Object obj) {
        int i3;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        h();
        if (i2 < 0 || i2 > (i3 = this.f3301d)) {
            throw new IndexOutOfBoundsException(k(i2));
        }
        boolean[] zArr = this.c;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[a.b(i3, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.c, i2, zArr2, i2 + 1, this.f3301d - i2);
            this.c = zArr2;
        }
        this.c[i2] = booleanValue;
        this.f3301d++;
        ((AbstractList) this).modCount++;
    }

    @Override // f.b.f.c, java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Boolean> collection) {
        h();
        Charset charset = c0.a;
        Objects.requireNonNull(collection);
        if (!(collection instanceof h)) {
            return super.addAll(collection);
        }
        h hVar = (h) collection;
        int i2 = hVar.f3301d;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f3301d;
        if (Integer.MAX_VALUE - i3 >= i2) {
            int i4 = i3 + i2;
            boolean[] zArr = this.c;
            if (i4 > zArr.length) {
                this.c = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(hVar.c, 0, this.c, this.f3301d, hVar.f3301d);
            this.f3301d = i4;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // f.b.f.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return super.equals(obj);
        }
        h hVar = (h) obj;
        if (this.f3301d != hVar.f3301d) {
            return false;
        }
        boolean[] zArr = hVar.c;
        for (int i2 = 0; i2 < this.f3301d; i2++) {
            if (this.c[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List, java.util.AbstractList
    public Object get(int i2) {
        j(i2);
        return Boolean.valueOf(this.c[i2]);
    }

    @Override // f.b.f.c
    public int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.f3301d; i3++) {
            i2 = (i2 * 31) + c0.a(this.c[i3]);
        }
        return i2;
    }

    public void i(boolean z) {
        h();
        int i2 = this.f3301d;
        boolean[] zArr = this.c;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[a.b(i2, 3, 2, 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.c = zArr2;
        }
        boolean[] zArr3 = this.c;
        int i3 = this.f3301d;
        this.f3301d = i3 + 1;
        zArr3[i3] = z;
    }

    public final void j(int i2) {
        if (i2 < 0 || i2 >= this.f3301d) {
            throw new IndexOutOfBoundsException(k(i2));
        }
    }

    public final String k(int i2) {
        return "Index:" + i2 + ", Size:" + this.f3301d;
    }

    /* renamed from: l */
    public c0.a d(int i2) {
        if (i2 >= this.f3301d) {
            return new h(Arrays.copyOf(this.c, i2), this.f3301d);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public Object remove(int i2) {
        h();
        j(i2);
        boolean[] zArr = this.c;
        boolean z = zArr[i2];
        int i3 = this.f3301d;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.f3301d--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // f.b.f.c, java.util.List
    public boolean remove(Object obj) {
        h();
        for (int i2 = 0; i2 < this.f3301d; i2++) {
            if (obj.equals(Boolean.valueOf(this.c[i2]))) {
                boolean[] zArr = this.c;
                System.arraycopy(zArr, i2 + 1, zArr, i2, (this.f3301d - i2) - 1);
                this.f3301d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public void removeRange(int i2, int i3) {
        h();
        if (i3 >= i2) {
            boolean[] zArr = this.c;
            System.arraycopy(zArr, i3, zArr, i2, this.f3301d - i3);
            this.f3301d -= i3 - i2;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.List, java.util.AbstractList
    public Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        h();
        j(i2);
        boolean[] zArr = this.c;
        boolean z = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z);
    }

    public int size() {
        return this.f3301d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.f.c, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(Boolean bool) {
        i(bool.booleanValue());
        return true;
    }
}
