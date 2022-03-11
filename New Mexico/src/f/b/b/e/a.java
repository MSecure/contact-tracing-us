package f.b.b.e;

import f.b.a.c.b.o.b;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;
/* loaded from: classes.dex */
public class a extends AbstractList<Integer> implements RandomAccess, Serializable {
    public final int[] b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3424d;

    public a(int[] iArr) {
        int length = iArr.length;
        this.b = iArr;
        this.c = 0;
        this.f3424d = length;
    }

    public a(int[] iArr, int i2, int i3) {
        this.b = iArr;
        this.c = i2;
        this.f3424d = i3;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        if (obj instanceof Integer) {
            int[] iArr = this.b;
            int intValue = ((Integer) obj).intValue();
            int i2 = this.c;
            int i3 = this.f3424d;
            while (true) {
                if (i2 >= i3) {
                    i2 = -1;
                    break;
                } else if (iArr[i2] == intValue) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return super.equals(obj);
        }
        a aVar = (a) obj;
        int size = size();
        if (aVar.size() != size) {
            return false;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (this.b[this.c + i2] != aVar.b[aVar.c + i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i2) {
        b.w(i2, size());
        return Integer.valueOf(this.b[this.c + i2]);
    }

    @Override // java.util.AbstractList, java.util.List, java.util.Collection, java.lang.Object
    public int hashCode() {
        int i2 = 1;
        for (int i3 = this.c; i3 < this.f3424d; i3++) {
            i2 = (i2 * 31) + this.b[i3];
        }
        return i2;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int[] iArr = this.b;
            int intValue = ((Integer) obj).intValue();
            int i2 = this.c;
            int i3 = this.f3424d;
            while (true) {
                if (i2 >= i3) {
                    i2 = -1;
                    break;
                } else if (iArr[i2] == intValue) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 >= 0) {
                return i2 - this.c;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        if (obj instanceof Integer) {
            int[] iArr = this.b;
            int intValue = ((Integer) obj).intValue();
            int i2 = this.c;
            int i3 = this.f3424d - 1;
            while (true) {
                if (i3 < i2) {
                    i3 = -1;
                    break;
                } else if (iArr[i3] == intValue) {
                    break;
                } else {
                    i3--;
                }
            }
            if (i3 >= 0) {
                return i3 - this.c;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i2, Object obj) {
        Integer num = (Integer) obj;
        b.w(i2, size());
        int[] iArr = this.b;
        int i3 = this.c + i2;
        int i4 = iArr[i3];
        Objects.requireNonNull(num);
        iArr[i3] = num.intValue();
        return Integer.valueOf(i4);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public int size() {
        return this.f3424d - this.c;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<Integer> subList(int i2, int i3) {
        b.E(i2, i3, size());
        if (i2 == i3) {
            return Collections.emptyList();
        }
        int[] iArr = this.b;
        int i4 = this.c;
        return new a(iArr, i2 + i4, i4 + i3);
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder(size() * 5);
        sb.append('[');
        sb.append(this.b[this.c]);
        int i2 = this.c;
        while (true) {
            i2++;
            if (i2 < this.f3424d) {
                sb.append(", ");
                sb.append(this.b[i2]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }
}
