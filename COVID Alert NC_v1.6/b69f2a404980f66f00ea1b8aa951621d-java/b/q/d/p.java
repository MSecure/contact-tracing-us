package b.q.d;

import b.q.d.d;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<g> f1546a = new a();

    public static class a implements Comparator<g> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(g gVar, g gVar2) {
            g gVar3 = gVar;
            g gVar4 = gVar2;
            int i = gVar3.f1559a - gVar4.f1559a;
            return i == 0 ? gVar3.f1560b - gVar4.f1560b : i;
        }
    }

    public static abstract class b {
        public abstract boolean a(int i, int i2);

        public abstract boolean b(int i, int i2);

        public abstract Object c(int i, int i2);
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final List<g> f1547a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f1548b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f1549c;

        /* renamed from: d  reason: collision with root package name */
        public final b f1550d;

        /* renamed from: e  reason: collision with root package name */
        public final int f1551e;
        public final int f;
        public final boolean g;

        public c(b bVar, List<g> list, int[] iArr, int[] iArr2, boolean z) {
            this.f1547a = list;
            this.f1548b = iArr;
            this.f1549c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(this.f1549c, 0);
            this.f1550d = bVar;
            d.a.C0035a aVar = (d.a.C0035a) bVar;
            this.f1551e = d.a.this.f1473b.size();
            this.f = d.a.this.f1474c.size();
            this.g = z;
            g gVar = this.f1547a.isEmpty() ? null : this.f1547a.get(0);
            if (!(gVar != null && gVar.f1559a == 0 && gVar.f1560b == 0)) {
                g gVar2 = new g();
                gVar2.f1559a = 0;
                gVar2.f1560b = 0;
                gVar2.f1562d = false;
                gVar2.f1561c = 0;
                gVar2.f1563e = false;
                this.f1547a.add(0, gVar2);
            }
            int i = this.f1551e;
            int i2 = this.f;
            for (int size = this.f1547a.size() - 1; size >= 0; size--) {
                g gVar3 = this.f1547a.get(size);
                int i3 = gVar3.f1559a;
                int i4 = gVar3.f1561c;
                int i5 = i3 + i4;
                int i6 = gVar3.f1560b + i4;
                if (this.g) {
                    while (i > i5) {
                        int i7 = i - 1;
                        if (this.f1548b[i7] == 0) {
                            a(i, i2, size, false);
                        }
                        i = i7;
                    }
                    while (i2 > i6) {
                        int i8 = i2 - 1;
                        if (this.f1549c[i8] == 0) {
                            a(i, i2, size, true);
                        }
                        i2 = i8;
                    }
                }
                for (int i9 = 0; i9 < gVar3.f1561c; i9++) {
                    int i10 = gVar3.f1559a + i9;
                    int i11 = gVar3.f1560b + i9;
                    int i12 = this.f1550d.a(i10, i11) ? 1 : 2;
                    this.f1548b[i10] = (i11 << 5) | i12;
                    this.f1549c[i11] = (i10 << 5) | i12;
                }
                i = gVar3.f1559a;
                i2 = gVar3.f1560b;
            }
        }

        public static e b(List<e> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                e eVar = list.get(size);
                if (eVar.f1552a == i && eVar.f1554c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f1553b += z ? 1 : -1;
                        size++;
                    }
                    return eVar;
                }
                size--;
            }
            return null;
        }

        public final boolean a(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            if (z) {
                i2--;
                i4 = i;
                i5 = i2;
            } else {
                i5 = i - 1;
                i4 = i5;
            }
            while (i3 >= 0) {
                g gVar = this.f1547a.get(i3);
                int i6 = gVar.f1559a;
                int i7 = gVar.f1561c;
                int i8 = i6 + i7;
                int i9 = gVar.f1560b + i7;
                int i10 = 8;
                if (z) {
                    for (int i11 = i4 - 1; i11 >= i8; i11--) {
                        if (this.f1550d.b(i11, i5)) {
                            if (!this.f1550d.a(i11, i5)) {
                                i10 = 4;
                            }
                            this.f1549c[i5] = (i11 << 5) | 16;
                            this.f1548b[i11] = (i5 << 5) | i10;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i12 = i2 - 1; i12 >= i9; i12--) {
                        if (this.f1550d.b(i5, i12)) {
                            if (!this.f1550d.a(i5, i12)) {
                                i10 = 4;
                            }
                            int i13 = i - 1;
                            this.f1548b[i13] = (i12 << 5) | 16;
                            this.f1549c[i12] = (i13 << 5) | i10;
                            return true;
                        }
                    }
                    continue;
                }
                i4 = gVar.f1559a;
                i2 = gVar.f1560b;
                i3--;
            }
            return false;
        }
    }

    public static abstract class d<T> {
        public abstract boolean areContentsTheSame(T t, T t2);

        public abstract boolean areItemsTheSame(T t, T t2);

        public Object getChangePayload(T t, T t2) {
            return null;
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public int f1552a;

        /* renamed from: b  reason: collision with root package name */
        public int f1553b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f1554c;

        public e(int i, int i2, boolean z) {
            this.f1552a = i;
            this.f1553b = i2;
            this.f1554c = z;
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public int f1555a;

        /* renamed from: b  reason: collision with root package name */
        public int f1556b;

        /* renamed from: c  reason: collision with root package name */
        public int f1557c;

        /* renamed from: d  reason: collision with root package name */
        public int f1558d;

        public f() {
        }

        public f(int i, int i2, int i3, int i4) {
            this.f1555a = i;
            this.f1556b = i2;
            this.f1557c = i3;
            this.f1558d = i4;
        }
    }

    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public int f1559a;

        /* renamed from: b  reason: collision with root package name */
        public int f1560b;

        /* renamed from: c  reason: collision with root package name */
        public int f1561c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1562d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1563e;
    }
}
