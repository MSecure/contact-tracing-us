package j.k;

import f.b.a.c.b.o.b;
import java.util.Iterator;

public class a implements Iterable<Integer> {
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4096d;

    public a(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i4 != Integer.MIN_VALUE) {
            this.b = i2;
            if (i4 > 0) {
                if (i2 < i3) {
                    i3 -= b.q1(b.q1(i3, i4) - b.q1(i2, i4), i4);
                }
            } else if (i4 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            } else if (i2 > i3) {
                int i5 = -i4;
                i3 += b.q1(b.q1(i2, i5) - b.q1(i3, i5), i5);
            }
            this.c = i3;
            this.f4096d = i4;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (!(this.b == aVar.b && this.c == aVar.c && this.f4096d == aVar.f4096d)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.b * 31) + this.c) * 31) + this.f4096d;
    }

    public boolean isEmpty() {
        if (this.f4096d > 0) {
            if (this.b > this.c) {
                return true;
            }
        } else if (this.b < this.c) {
            return true;
        }
        return false;
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return new b(this.b, this.c, this.f4096d);
    }

    public String toString() {
        int i2;
        StringBuilder sb;
        if (this.f4096d > 0) {
            sb = new StringBuilder();
            sb.append(this.b);
            sb.append("..");
            sb.append(this.c);
            sb.append(" step ");
            i2 = this.f4096d;
        } else {
            sb = new StringBuilder();
            sb.append(this.b);
            sb.append(" downTo ");
            sb.append(this.c);
            sb.append(" step ");
            i2 = -this.f4096d;
        }
        sb.append(i2);
        return sb.toString();
    }
}
