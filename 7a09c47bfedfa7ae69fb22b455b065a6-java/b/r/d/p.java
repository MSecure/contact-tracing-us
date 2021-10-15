package b.r.d;

import b.r.d.d;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<g> f2394a = new a();

    public static class a implements Comparator<g> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(g gVar, g gVar2) {
            g gVar3 = gVar;
            g gVar4 = gVar2;
            int i = gVar3.f2409a - gVar4.f2409a;
            return i == 0 ? gVar3.f2410b - gVar4.f2410b : i;
        }
    }

    public static abstract class b {
        public abstract boolean a(int i, int i2);

        public abstract boolean b(int i, int i2);

        public abstract Object c(int i, int i2);
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final List<g> f2395a;

        /* renamed from: b  reason: collision with root package name */
        public final int[] f2396b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f2397c;

        /* renamed from: d  reason: collision with root package name */
        public final b f2398d;

        /* renamed from: e  reason: collision with root package name */
        public final int f2399e;

        /* renamed from: f  reason: collision with root package name */
        public final int f2400f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f2401g;

        public c(b bVar, List<g> list, int[] iArr, int[] iArr2, boolean z) {
            this.f2395a = list;
            this.f2396b = iArr;
            this.f2397c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(this.f2397c, 0);
            this.f2398d = bVar;
            d.a.C0045a aVar = (d.a.C0045a) bVar;
            this.f2399e = d.a.this.f2313b.size();
            this.f2400f = d.a.this.f2314c.size();
            this.f2401g = z;
            g gVar = this.f2395a.isEmpty() ? null : this.f2395a.get(0);
            if (!(gVar != null && gVar.f2409a == 0 && gVar.f2410b == 0)) {
                g gVar2 = new g();
                gVar2.f2409a = 0;
                gVar2.f2410b = 0;
                gVar2.f2412d = false;
                gVar2.f2411c = 0;
                gVar2.f2413e = false;
                this.f2395a.add(0, gVar2);
            }
            int i = this.f2399e;
            int i2 = this.f2400f;
            for (int size = this.f2395a.size() - 1; size >= 0; size--) {
                g gVar3 = this.f2395a.get(size);
                int i3 = gVar3.f2409a;
                int i4 = gVar3.f2411c;
                int i5 = i3 + i4;
                int i6 = gVar3.f2410b + i4;
                if (this.f2401g) {
                    while (i > i5) {
                        int i7 = i - 1;
                        if (this.f2396b[i7] == 0) {
                            a(i, i2, size, false);
                        }
                        i = i7;
                    }
                    while (i2 > i6) {
                        int i8 = i2 - 1;
                        if (this.f2397c[i8] == 0) {
                            a(i, i2, size, true);
                        }
                        i2 = i8;
                    }
                }
                for (int i9 = 0; i9 < gVar3.f2411c; i9++) {
                    int i10 = gVar3.f2409a + i9;
                    int i11 = gVar3.f2410b + i9;
                    int i12 = this.f2398d.a(i10, i11) ? 1 : 2;
                    this.f2396b[i10] = (i11 << 5) | i12;
                    this.f2397c[i11] = (i10 << 5) | i12;
                }
                i = gVar3.f2409a;
                i2 = gVar3.f2410b;
            }
        }

        public static e b(List<e> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                e eVar = list.get(size);
                if (eVar.f2402a == i && eVar.f2404c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f2403b += z ? 1 : -1;
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
                g gVar = this.f2395a.get(i3);
                int i6 = gVar.f2409a;
                int i7 = gVar.f2411c;
                int i8 = i6 + i7;
                int i9 = gVar.f2410b + i7;
                int i10 = 8;
                if (z) {
                    for (int i11 = i4 - 1; i11 >= i8; i11--) {
                        if (this.f2398d.b(i11, i5)) {
                            if (!this.f2398d.a(i11, i5)) {
                                i10 = 4;
                            }
                            this.f2397c[i5] = (i11 << 5) | 16;
                            this.f2396b[i11] = (i5 << 5) | i10;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int i12 = i2 - 1; i12 >= i9; i12--) {
                        if (this.f2398d.b(i5, i12)) {
                            if (!this.f2398d.a(i5, i12)) {
                                i10 = 4;
                            }
                            int i13 = i - 1;
                            this.f2396b[i13] = (i12 << 5) | 16;
                            this.f2397c[i12] = (i13 << 5) | i10;
                            return true;
                        }
                    }
                    continue;
                }
                i4 = gVar.f2409a;
                i2 = gVar.f2410b;
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
        public int f2402a;

        /* renamed from: b  reason: collision with root package name */
        public int f2403b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2404c;

        public e(int i, int i2, boolean z) {
            this.f2402a = i;
            this.f2403b = i2;
            this.f2404c = z;
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public int f2405a;

        /* renamed from: b  reason: collision with root package name */
        public int f2406b;

        /* renamed from: c  reason: collision with root package name */
        public int f2407c;

        /* renamed from: d  reason: collision with root package name */
        public int f2408d;

        public f() {
        }

        public f(int i, int i2, int i3, int i4) {
            this.f2405a = i;
            this.f2406b = i2;
            this.f2407c = i3;
            this.f2408d = i4;
        }
    }

    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public int f2409a;

        /* renamed from: b  reason: collision with root package name */
        public int f2410b;

        /* renamed from: c  reason: collision with root package name */
        public int f2411c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f2412d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2413e;
    }
}
