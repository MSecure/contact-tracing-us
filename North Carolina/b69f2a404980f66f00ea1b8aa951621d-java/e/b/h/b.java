package e.b.h;

import c.b.a.a.c.n.c;
import e.b.h.f;
import e.b.i.f;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class b implements Iterable<a>, Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f4828e = new String[0];

    /* renamed from: b  reason: collision with root package name */
    public int f4829b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String[] f4830c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f4831d;

    public class a implements Iterator<a> {

        /* renamed from: b  reason: collision with root package name */
        public int f4832b = 0;

        public a() {
        }

        public boolean hasNext() {
            while (true) {
                int i = this.f4832b;
                b bVar = b.this;
                if (i < bVar.f4829b && bVar.u(bVar.f4830c[i])) {
                    this.f4832b++;
                }
            }
            if (this.f4832b < b.this.f4829b) {
                return true;
            }
            return false;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public a next() {
            b bVar = b.this;
            String[] strArr = bVar.f4830c;
            int i = this.f4832b;
            a aVar = new a(strArr[i], bVar.f4831d[i], bVar);
            this.f4832b++;
            return aVar;
        }

        public void remove() {
            b bVar = b.this;
            int i = this.f4832b - 1;
            this.f4832b = i;
            bVar.x(i);
        }
    }

    public b() {
        String[] strArr = f4828e;
        this.f4830c = strArr;
        this.f4831d = strArr;
    }

    public static String[] j(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i));
        return strArr2;
    }

    public b a(String str, String str2) {
        e(this.f4829b + 1);
        String[] strArr = this.f4830c;
        int i = this.f4829b;
        strArr[i] = str;
        this.f4831d[i] = str2;
        this.f4829b = i + 1;
        return this;
    }

    public void c(b bVar) {
        if (bVar.size() != 0) {
            e(this.f4829b + bVar.f4829b);
            a aVar = new a();
            while (aVar.hasNext()) {
                w((a) aVar.next());
            }
        }
    }

    public final void e(int i) {
        c.t1(i >= this.f4829b);
        int length = this.f4830c.length;
        if (length < i) {
            int i2 = 2;
            if (length >= 2) {
                i2 = 2 * this.f4829b;
            }
            if (i <= i2) {
                i = i2;
            }
            this.f4830c = j(this.f4830c, i);
            this.f4831d = j(this.f4831d, i);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f4829b == bVar.f4829b && Arrays.equals(this.f4830c, bVar.f4830c)) {
            return Arrays.equals(this.f4831d, bVar.f4831d);
        }
        return false;
    }

    /* renamed from: h */
    public b clone() {
        try {
            b bVar = (b) super.clone();
            bVar.f4829b = this.f4829b;
            this.f4830c = j(this.f4830c, this.f4829b);
            this.f4831d = j(this.f4831d, this.f4829b);
            return bVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public int hashCode() {
        return (((this.f4829b * 31) + Arrays.hashCode(this.f4830c)) * 31) + Arrays.hashCode(this.f4831d);
    }

    @Override // java.lang.Iterable
    public Iterator<a> iterator() {
        return new a();
    }

    public int m(f fVar) {
        int i = 0;
        if (this.f4829b == 0) {
            return 0;
        }
        boolean z = fVar.f4885b;
        int i2 = 0;
        while (i < this.f4830c.length) {
            int i3 = i + 1;
            int i4 = i3;
            while (true) {
                String[] strArr = this.f4830c;
                if (i4 >= strArr.length || strArr[i4] == null) {
                    i = i3;
                } else {
                    if (!z || !strArr[i].equals(strArr[i4])) {
                        if (!z) {
                            String[] strArr2 = this.f4830c;
                            if (!strArr2[i].equalsIgnoreCase(strArr2[i4])) {
                            }
                        }
                        i4++;
                    }
                    i2++;
                    x(i4);
                    i4--;
                    i4++;
                }
            }
            i = i3;
        }
        return i2;
    }

    public String o(String str) {
        String str2;
        int s = s(str);
        return (s == -1 || (str2 = this.f4831d[s]) == null) ? "" : str2;
    }

    public String p(String str) {
        String str2;
        int t = t(str);
        return (t == -1 || (str2 = this.f4831d[t]) == null) ? "" : str2;
    }

    public boolean q(String str) {
        return s(str) != -1;
    }

    public final void r(Appendable appendable, f.a aVar) {
        int i = this.f4829b;
        for (int i2 = 0; i2 < i; i2++) {
            if (!u(this.f4830c[i2])) {
                String str = this.f4830c[i2];
                String str2 = this.f4831d[i2];
                appendable.append(' ').append(str);
                if (!a.b(str, str2, aVar)) {
                    appendable.append("=\"");
                    if (str2 == null) {
                        str2 = "";
                    }
                    j.c(appendable, str2, aVar, true, false, false);
                    appendable.append('\"');
                }
            }
        }
    }

    public int s(String str) {
        c.J1(str);
        for (int i = 0; i < this.f4829b; i++) {
            if (str.equals(this.f4830c[i])) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        int i = 0;
        for (int i2 = 0; i2 < this.f4829b; i2++) {
            if (!u(this.f4830c[i2])) {
                i++;
            }
        }
        return i;
    }

    public final int t(String str) {
        c.J1(str);
        for (int i = 0; i < this.f4829b; i++) {
            if (str.equalsIgnoreCase(this.f4830c[i])) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        StringBuilder b2 = e.b.g.b.b();
        try {
            r(b2, new f("").j);
            return e.b.g.b.j(b2);
        } catch (IOException e2) {
            throw new e.b.c(e2);
        }
    }

    public final boolean u(String str) {
        return str != null && str.length() > 1 && str.charAt(0) == '/';
    }

    public b v(String str, String str2) {
        c.J1(str);
        int s = s(str);
        if (s != -1) {
            this.f4831d[s] = str2;
        } else {
            a(str, str2);
        }
        return this;
    }

    public b w(a aVar) {
        c.J1(aVar);
        String str = aVar.f4825b;
        String str2 = aVar.f4826c;
        if (str2 == null) {
            str2 = "";
        }
        v(str, str2);
        aVar.f4827d = this;
        return this;
    }

    public final void x(int i) {
        c.o1(i >= this.f4829b);
        int i2 = (this.f4829b - i) - 1;
        if (i2 > 0) {
            String[] strArr = this.f4830c;
            int i3 = i + 1;
            System.arraycopy(strArr, i3, strArr, i, i2);
            String[] strArr2 = this.f4831d;
            System.arraycopy(strArr2, i3, strArr2, i, i2);
        }
        int i4 = this.f4829b - 1;
        this.f4829b = i4;
        this.f4830c[i4] = null;
        this.f4831d[i4] = null;
    }
}
