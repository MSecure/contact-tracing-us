package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import e.b.a.m;
import e.i.i.w.b;
import e.s.a.j;
import e.s.a.k;
import e.s.a.l;
import e.s.a.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Objects;

public class StaggeredGridLayoutManager extends RecyclerView.m implements RecyclerView.x.b {
    public BitSet A;
    public int B;
    public int C;
    public d D;
    public int E;
    public boolean F;
    public boolean G;
    public e H;
    public int I;
    public final Rect J;
    public final b K;
    public boolean L;
    public int[] M;
    public final Runnable N;
    public int r = -1;
    public f[] s;
    public q t;
    public q u;
    public int v;
    public int w;
    public final k x;
    public boolean y;
    public boolean z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            StaggeredGridLayoutManager.this.b1();
        }
    }

    public class b {
        public int a;
        public int b;
        public boolean c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f260d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f261e;

        /* renamed from: f  reason: collision with root package name */
        public int[] f262f;

        public b() {
            b();
        }

        public void a() {
            this.b = this.c ? StaggeredGridLayoutManager.this.t.g() : StaggeredGridLayoutManager.this.t.k();
        }

        public void b() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.c = false;
            this.f260d = false;
            this.f261e = false;
            int[] iArr = this.f262f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    public static class c extends RecyclerView.n {

        /* renamed from: e  reason: collision with root package name */
        public f f264e;

        public c(int i2, int i3) {
            super(i2, i3);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public static class d {
        public int[] a;
        public List<a> b;

        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0001a();
            public int b;
            public int c;

            /* renamed from: d  reason: collision with root package name */
            public int[] f265d;

            /* renamed from: e  reason: collision with root package name */
            public boolean f266e;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a  reason: collision with other inner class name */
            public static class C0001a implements Parcelable.Creator<a> {
                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public a[] newArray(int i2) {
                    return new a[i2];
                }
            }

            public a() {
            }

            public a(Parcel parcel) {
                this.b = parcel.readInt();
                this.c = parcel.readInt();
                this.f266e = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f265d = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                StringBuilder h2 = f.a.a.a.a.h("FullSpanItem{mPosition=");
                h2.append(this.b);
                h2.append(", mGapDir=");
                h2.append(this.c);
                h2.append(", mHasUnwantedGapAfter=");
                h2.append(this.f266e);
                h2.append(", mGapPerSpan=");
                h2.append(Arrays.toString(this.f265d));
                h2.append('}');
                return h2.toString();
            }

            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.b);
                parcel.writeInt(this.c);
                parcel.writeInt(this.f266e ? 1 : 0);
                int[] iArr = this.f265d;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f265d);
            }
        }

        public void a() {
            int[] iArr = this.a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.b = null;
        }

        public void b(int i2) {
            int[] iArr = this.a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i2, 10) + 1)];
                this.a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i2 >= iArr.length) {
                int length = iArr.length;
                while (length <= i2) {
                    length *= 2;
                }
                int[] iArr3 = new int[length];
                this.a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public a c(int i2) {
            List<a> list = this.b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.b.get(size);
                if (aVar.b == i2) {
                    return aVar;
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
        public int d(int i2) {
            int i3;
            int[] iArr = this.a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            if (this.b != null) {
                a c = c(i2);
                if (c != null) {
                    this.b.remove(c);
                }
                int size = this.b.size();
                int i4 = 0;
                while (true) {
                    if (i4 >= size) {
                        i4 = -1;
                        break;
                    } else if (this.b.get(i4).b >= i2) {
                        break;
                    } else {
                        i4++;
                    }
                }
                if (i4 != -1) {
                    this.b.remove(i4);
                    i3 = this.b.get(i4).b;
                    if (i3 != -1) {
                        int[] iArr2 = this.a;
                        Arrays.fill(iArr2, i2, iArr2.length, -1);
                        return this.a.length;
                    }
                    int i5 = i3 + 1;
                    Arrays.fill(this.a, i2, i5, -1);
                    return i5;
                }
            }
            i3 = -1;
            if (i3 != -1) {
            }
        }

        public void e(int i2, int i3) {
            int[] iArr = this.a;
            if (iArr != null && i2 < iArr.length) {
                int i4 = i2 + i3;
                b(i4);
                int[] iArr2 = this.a;
                System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
                Arrays.fill(this.a, i2, i4, -1);
                List<a> list = this.b;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        a aVar = this.b.get(size);
                        int i5 = aVar.b;
                        if (i5 >= i2) {
                            aVar.b = i5 + i3;
                        }
                    }
                }
            }
        }

        public void f(int i2, int i3) {
            int[] iArr = this.a;
            if (iArr != null && i2 < iArr.length) {
                int i4 = i2 + i3;
                b(i4);
                int[] iArr2 = this.a;
                System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
                int[] iArr3 = this.a;
                Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
                List<a> list = this.b;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        a aVar = this.b.get(size);
                        int i5 = aVar.b;
                        if (i5 >= i2) {
                            if (i5 < i4) {
                                this.b.remove(size);
                            } else {
                                aVar.b = i5 - i3;
                            }
                        }
                    }
                }
            }
        }
    }

    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f267d;

        /* renamed from: e  reason: collision with root package name */
        public int[] f268e;

        /* renamed from: f  reason: collision with root package name */
        public int f269f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f270g;

        /* renamed from: h  reason: collision with root package name */
        public List<d.a> f271h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f272i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f273j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f274k;

        public static class a implements Parcelable.Creator<e> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public e[] newArray(int i2) {
                return new e[i2];
            }
        }

        public e() {
        }

        public e(Parcel parcel) {
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            int readInt = parcel.readInt();
            this.f267d = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f268e = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f269f = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f270g = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z = false;
            this.f272i = parcel.readInt() == 1;
            this.f273j = parcel.readInt() == 1;
            this.f274k = parcel.readInt() == 1 ? true : z;
            this.f271h = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f267d = eVar.f267d;
            this.b = eVar.b;
            this.c = eVar.c;
            this.f268e = eVar.f268e;
            this.f269f = eVar.f269f;
            this.f270g = eVar.f270g;
            this.f272i = eVar.f272i;
            this.f273j = eVar.f273j;
            this.f274k = eVar.f274k;
            this.f271h = eVar.f271h;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.f267d);
            if (this.f267d > 0) {
                parcel.writeIntArray(this.f268e);
            }
            parcel.writeInt(this.f269f);
            if (this.f269f > 0) {
                parcel.writeIntArray(this.f270g);
            }
            parcel.writeInt(this.f272i ? 1 : 0);
            parcel.writeInt(this.f273j ? 1 : 0);
            parcel.writeInt(this.f274k ? 1 : 0);
            parcel.writeList(this.f271h);
        }
    }

    public class f {
        public ArrayList<View> a = new ArrayList<>();
        public int b = Integer.MIN_VALUE;
        public int c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        public int f275d = 0;

        /* renamed from: e  reason: collision with root package name */
        public final int f276e;

        public f(int i2) {
            this.f276e = i2;
        }

        public void a(View view) {
            c j2 = j(view);
            j2.f264e = this;
            this.a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.b = Integer.MIN_VALUE;
            }
            if (j2.c() || j2.b()) {
                this.f275d = StaggeredGridLayoutManager.this.t.c(view) + this.f275d;
            }
        }

        public void b() {
            ArrayList<View> arrayList = this.a;
            View view = arrayList.get(arrayList.size() - 1);
            c j2 = j(view);
            this.c = StaggeredGridLayoutManager.this.t.b(view);
            Objects.requireNonNull(j2);
        }

        public void c() {
            View view = this.a.get(0);
            c j2 = j(view);
            this.b = StaggeredGridLayoutManager.this.t.e(view);
            Objects.requireNonNull(j2);
        }

        public void d() {
            this.a.clear();
            this.b = Integer.MIN_VALUE;
            this.c = Integer.MIN_VALUE;
            this.f275d = 0;
        }

        public int e() {
            int i2;
            int i3;
            if (StaggeredGridLayoutManager.this.y) {
                i3 = this.a.size() - 1;
                i2 = -1;
            } else {
                i3 = 0;
                i2 = this.a.size();
            }
            return g(i3, i2, true);
        }

        public int f() {
            int i2;
            int i3;
            if (StaggeredGridLayoutManager.this.y) {
                i3 = 0;
                i2 = this.a.size();
            } else {
                i3 = this.a.size() - 1;
                i2 = -1;
            }
            return g(i3, i2, true);
        }

        public int g(int i2, int i3, boolean z) {
            int k2 = StaggeredGridLayoutManager.this.t.k();
            int g2 = StaggeredGridLayoutManager.this.t.g();
            int i4 = i3 > i2 ? 1 : -1;
            while (i2 != i3) {
                View view = this.a.get(i2);
                int e2 = StaggeredGridLayoutManager.this.t.e(view);
                int b2 = StaggeredGridLayoutManager.this.t.b(view);
                boolean z2 = false;
                boolean z3 = !z ? e2 < g2 : e2 <= g2;
                if (!z ? b2 > k2 : b2 >= k2) {
                    z2 = true;
                }
                if (z3 && z2 && (e2 < k2 || b2 > g2)) {
                    return StaggeredGridLayoutManager.this.R(view);
                }
                i2 += i4;
            }
            return -1;
        }

        public int h(int i2) {
            int i3 = this.c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.a.size() == 0) {
                return i2;
            }
            b();
            return this.c;
        }

        public View i(int i2, int i3) {
            View view = null;
            if (i3 != -1) {
                int size = this.a.size() - 1;
                while (size >= 0) {
                    View view2 = this.a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.y && staggeredGridLayoutManager.R(view2) >= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.y && staggeredGridLayoutManager2.R(view2) <= i2) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.a.size();
                int i4 = 0;
                while (i4 < size2) {
                    View view3 = this.a.get(i4);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.y && staggeredGridLayoutManager3.R(view3) <= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.y && staggeredGridLayoutManager4.R(view3) >= i2) || !view3.hasFocusable()) {
                        break;
                    }
                    i4++;
                    view = view3;
                }
            }
            return view;
        }

        public c j(View view) {
            return (c) view.getLayoutParams();
        }

        public int k(int i2) {
            int i3 = this.b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.a.size() == 0) {
                return i2;
            }
            c();
            return this.b;
        }

        public void l() {
            int size = this.a.size();
            View remove = this.a.remove(size - 1);
            c j2 = j(remove);
            j2.f264e = null;
            if (j2.c() || j2.b()) {
                this.f275d -= StaggeredGridLayoutManager.this.t.c(remove);
            }
            if (size == 1) {
                this.b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        public void m() {
            View remove = this.a.remove(0);
            c j2 = j(remove);
            j2.f264e = null;
            if (this.a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (j2.c() || j2.b()) {
                this.f275d -= StaggeredGridLayoutManager.this.t.c(remove);
            }
            this.b = Integer.MIN_VALUE;
        }

        public void n(View view) {
            c j2 = j(view);
            j2.f264e = this;
            this.a.add(0, view);
            this.b = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (j2.c() || j2.b()) {
                this.f275d = StaggeredGridLayoutManager.this.t.c(view) + this.f275d;
            }
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.y = false;
        this.z = false;
        this.B = -1;
        this.C = Integer.MIN_VALUE;
        this.D = new d();
        this.E = 2;
        this.J = new Rect();
        this.K = new b();
        this.L = true;
        this.N = new a();
        RecyclerView.m.d S = RecyclerView.m.S(context, attributeSet, i2, i3);
        int i4 = S.a;
        if (i4 == 0 || i4 == 1) {
            d(null);
            if (i4 != this.v) {
                this.v = i4;
                q qVar = this.t;
                this.t = this.u;
                this.u = qVar;
                L0();
            }
            int i5 = S.b;
            d(null);
            if (i5 != this.r) {
                this.D.a();
                L0();
                this.r = i5;
                this.A = new BitSet(this.r);
                this.s = new f[this.r];
                for (int i6 = 0; i6 < this.r; i6++) {
                    this.s[i6] = new f(i6);
                }
                L0();
            }
            boolean z2 = S.c;
            d(null);
            e eVar = this.H;
            if (!(eVar == null || eVar.f272i == z2)) {
                eVar.f272i = z2;
            }
            this.y = z2;
            L0();
            this.x = new k();
            this.t = q.a(this, this.v);
            this.u = q.a(this, 1 - this.v);
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int A(RecyclerView.t tVar, RecyclerView.y yVar) {
        return this.v == 1 ? this.r : super.A(tVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void A0(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.H = (e) parcelable;
            L0();
        }
    }

    public final void A1(int i2) {
        k kVar = this.x;
        kVar.f1810e = i2;
        int i3 = 1;
        if (this.z != (i2 == -1)) {
            i3 = -1;
        }
        kVar.f1809d = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public Parcelable B0() {
        int i2;
        int i3;
        int[] iArr;
        e eVar = this.H;
        if (eVar != null) {
            return new e(eVar);
        }
        e eVar2 = new e();
        eVar2.f272i = this.y;
        eVar2.f273j = this.F;
        eVar2.f274k = this.G;
        d dVar = this.D;
        if (dVar == null || (iArr = dVar.a) == null) {
            eVar2.f269f = 0;
        } else {
            eVar2.f270g = iArr;
            eVar2.f269f = iArr.length;
            eVar2.f271h = dVar.b;
        }
        int i4 = -1;
        if (y() > 0) {
            eVar2.b = this.F ? l1() : k1();
            View g1 = this.z ? g1(true) : h1(true);
            if (g1 != null) {
                i4 = R(g1);
            }
            eVar2.c = i4;
            int i5 = this.r;
            eVar2.f267d = i5;
            eVar2.f268e = new int[i5];
            for (int i6 = 0; i6 < this.r; i6++) {
                if (this.F) {
                    i2 = this.s[i6].h(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.t.g();
                    } else {
                        eVar2.f268e[i6] = i2;
                    }
                } else {
                    i2 = this.s[i6].k(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.t.k();
                    } else {
                        eVar2.f268e[i6] = i2;
                    }
                }
                i2 -= i3;
                eVar2.f268e[i6] = i2;
            }
        } else {
            eVar2.b = -1;
            eVar2.c = -1;
            eVar2.f267d = 0;
        }
        return eVar2;
    }

    public final void B1(int i2, int i3) {
        for (int i4 = 0; i4 < this.r; i4++) {
            if (!this.s[i4].a.isEmpty()) {
                D1(this.s[i4], i2, i3);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void C0(int i2) {
        if (i2 == 0) {
            b1();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0059  */
    public final void C1(int i2, RecyclerView.y yVar) {
        int i3;
        int i4;
        RecyclerView recyclerView;
        int i5;
        k kVar = this.x;
        boolean z2 = false;
        kVar.b = 0;
        kVar.c = i2;
        RecyclerView.x xVar = this.f227g;
        if (!(xVar != null && xVar.f243e) || (i5 = yVar.a) == -1) {
            i4 = 0;
        } else {
            if (this.z == (i5 < i2)) {
                i4 = this.t.l();
            } else {
                i3 = this.t.l();
                i4 = 0;
                recyclerView = this.b;
                if (!(recyclerView == null && recyclerView.f202h)) {
                    this.x.f1811f = this.t.k() - i3;
                    this.x.f1812g = this.t.g() + i4;
                } else {
                    this.x.f1812g = this.t.f() + i4;
                    this.x.f1811f = -i3;
                }
                k kVar2 = this.x;
                kVar2.f1813h = false;
                kVar2.a = true;
                if (this.t.i() == 0 && this.t.f() == 0) {
                    z2 = true;
                }
                kVar2.f1814i = z2;
            }
        }
        i3 = 0;
        recyclerView = this.b;
        if (!(recyclerView == null && recyclerView.f202h)) {
        }
        k kVar22 = this.x;
        kVar22.f1813h = false;
        kVar22.a = true;
        z2 = true;
        kVar22.f1814i = z2;
    }

    public final void D1(f fVar, int i2, int i3) {
        int i4 = fVar.f275d;
        if (i2 == -1) {
            int i5 = fVar.b;
            if (i5 == Integer.MIN_VALUE) {
                fVar.c();
                i5 = fVar.b;
            }
            if (i5 + i4 > i3) {
                return;
            }
        } else {
            int i6 = fVar.c;
            if (i6 == Integer.MIN_VALUE) {
                fVar.b();
                i6 = fVar.c;
            }
            if (i6 - i4 < i3) {
                return;
            }
        }
        this.A.set(fVar.f276e, false);
    }

    public final int E1(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode) : i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int M0(int i2, RecyclerView.t tVar, RecyclerView.y yVar) {
        return z1(i2, tVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void N0(int i2) {
        e eVar = this.H;
        if (!(eVar == null || eVar.b == i2)) {
            eVar.f268e = null;
            eVar.f267d = 0;
            eVar.b = -1;
            eVar.c = -1;
        }
        this.B = i2;
        this.C = Integer.MIN_VALUE;
        L0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int O0(int i2, RecyclerView.t tVar, RecyclerView.y yVar) {
        return z1(i2, tVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void R0(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        int P = P() + O();
        int N2 = N() + Q();
        if (this.v == 1) {
            i5 = RecyclerView.m.h(i3, rect.height() + N2, L());
            i4 = RecyclerView.m.h(i2, (this.w * this.r) + P, M());
        } else {
            i4 = RecyclerView.m.h(i2, rect.width() + P, M());
            i5 = RecyclerView.m.h(i3, (this.w * this.r) + N2, L());
        }
        this.b.setMeasuredDimension(i4, i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int T(RecyclerView.t tVar, RecyclerView.y yVar) {
        return this.v == 0 ? this.r : super.T(tVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean W() {
        return this.E != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void X0(RecyclerView recyclerView, RecyclerView.y yVar, int i2) {
        l lVar = new l(recyclerView.getContext());
        lVar.a = i2;
        Y0(lVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean Z0() {
        return this.H == null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x.b
    public PointF a(int i2) {
        int a1 = a1(i2);
        PointF pointF = new PointF();
        if (a1 == 0) {
            return null;
        }
        if (this.v == 0) {
            pointF.x = (float) a1;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) a1;
        }
        return pointF;
    }

    public final int a1(int i2) {
        if (y() == 0) {
            return this.z ? 1 : -1;
        }
        return (i2 < k1()) != this.z ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void b0(int i2) {
        super.b0(i2);
        for (int i3 = 0; i3 < this.r; i3++) {
            f fVar = this.s[i3];
            int i4 = fVar.b;
            if (i4 != Integer.MIN_VALUE) {
                fVar.b = i4 + i2;
            }
            int i5 = fVar.c;
            if (i5 != Integer.MIN_VALUE) {
                fVar.c = i5 + i2;
            }
        }
    }

    public boolean b1() {
        int i2;
        if (!(y() == 0 || this.E == 0 || !this.f229i)) {
            if (this.z) {
                i2 = l1();
                k1();
            } else {
                i2 = k1();
                l1();
            }
            if (i2 == 0 && p1() != null) {
                this.D.a();
                this.f228h = true;
                L0();
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void c0(int i2) {
        super.c0(i2);
        for (int i3 = 0; i3 < this.r; i3++) {
            f fVar = this.s[i3];
            int i4 = fVar.b;
            if (i4 != Integer.MIN_VALUE) {
                fVar.b = i4 + i2;
            }
            int i5 = fVar.c;
            if (i5 != Integer.MIN_VALUE) {
                fVar.c = i5 + i2;
            }
        }
    }

    public final int c1(RecyclerView.y yVar) {
        if (y() == 0) {
            return 0;
        }
        return m.h.u(yVar, this.t, h1(!this.L), g1(!this.L), this, this.L);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void d(String str) {
        RecyclerView recyclerView;
        if (this.H == null && (recyclerView = this.b) != null) {
            recyclerView.i(str);
        }
    }

    public final int d1(RecyclerView.y yVar) {
        if (y() == 0) {
            return 0;
        }
        return m.h.v(yVar, this.t, h1(!this.L), g1(!this.L), this, this.L, this.z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean e() {
        return this.v == 0;
    }

    public final int e1(RecyclerView.y yVar) {
        if (y() == 0) {
            return 0;
        }
        return m.h.w(yVar, this.t, h1(!this.L), g1(!this.L), this, this.L);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean f() {
        return this.v == 1;
    }

    public final int f1(RecyclerView.t tVar, k kVar, RecyclerView.y yVar) {
        int i2;
        f fVar;
        boolean z2;
        boolean z3;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z4 = false;
        this.A.set(0, this.r, true);
        if (this.x.f1814i) {
            i2 = kVar.f1810e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i2 = kVar.f1810e == 1 ? kVar.f1812g + kVar.b : kVar.f1811f - kVar.b;
        }
        B1(kVar.f1810e, i2);
        int g2 = this.z ? this.t.g() : this.t.k();
        boolean z5 = false;
        while (true) {
            int i15 = kVar.c;
            if ((i15 >= 0 && i15 < yVar.b()) && (this.x.f1814i || !this.A.isEmpty())) {
                View view = tVar.j(kVar.c, z4, Long.MAX_VALUE).a;
                kVar.c += kVar.f1809d;
                c cVar = (c) view.getLayoutParams();
                int a2 = cVar.a();
                int[] iArr = this.D.a;
                int i16 = (iArr == null || a2 >= iArr.length) ? -1 : iArr[a2];
                if (i16 == -1) {
                    if (t1(kVar.f1810e)) {
                        i14 = this.r - 1;
                        i13 = -1;
                        i12 = -1;
                    } else {
                        i13 = this.r;
                        i14 = 0;
                        i12 = 1;
                    }
                    f fVar2 = null;
                    if (kVar.f1810e == 1) {
                        int k2 = this.t.k();
                        int i17 = Integer.MAX_VALUE;
                        while (i14 != i13) {
                            f fVar3 = this.s[i14];
                            int h2 = fVar3.h(k2);
                            if (h2 < i17) {
                                fVar2 = fVar3;
                                i17 = h2;
                            }
                            i14 += i12;
                        }
                    } else {
                        int g3 = this.t.g();
                        int i18 = Integer.MIN_VALUE;
                        while (i14 != i13) {
                            f fVar4 = this.s[i14];
                            int k3 = fVar4.k(g3);
                            if (k3 > i18) {
                                fVar2 = fVar4;
                                i18 = k3;
                            }
                            i14 += i12;
                        }
                    }
                    fVar = fVar2;
                    d dVar = this.D;
                    dVar.b(a2);
                    dVar.a[a2] = fVar.f276e;
                } else {
                    fVar = this.s[i16];
                }
                cVar.f264e = fVar;
                if (kVar.f1810e == 1) {
                    z2 = false;
                    c(view, -1, false);
                } else {
                    z2 = false;
                    c(view, 0, false);
                }
                if (this.v == 1) {
                    int i19 = this.w;
                    int i20 = this.n;
                    int i21 = ((ViewGroup.MarginLayoutParams) cVar).width;
                    int i22 = z2 ? 1 : 0;
                    int i23 = z2 ? 1 : 0;
                    int i24 = z2 ? 1 : 0;
                    i4 = RecyclerView.m.z(i19, i20, i22, i21, z2);
                    i3 = RecyclerView.m.z(this.q, this.o, N() + Q(), ((ViewGroup.MarginLayoutParams) cVar).height, true);
                    z3 = false;
                } else {
                    i4 = RecyclerView.m.z(this.p, this.n, P() + O(), ((ViewGroup.MarginLayoutParams) cVar).width, true);
                    z3 = false;
                    i3 = RecyclerView.m.z(this.w, this.o, 0, ((ViewGroup.MarginLayoutParams) cVar).height, false);
                }
                r1(view, i4, i3, z3);
                if (kVar.f1810e == 1) {
                    i6 = fVar.h(g2);
                    i5 = this.t.c(view) + i6;
                } else {
                    i5 = fVar.k(g2);
                    i6 = i5 - this.t.c(view);
                }
                int i25 = kVar.f1810e;
                f fVar5 = cVar.f264e;
                if (i25 == 1) {
                    fVar5.a(view);
                } else {
                    fVar5.n(view);
                }
                if (!q1() || this.v != 1) {
                    i7 = this.u.k() + (fVar.f276e * this.w);
                    i8 = this.u.c(view) + i7;
                } else {
                    i8 = this.u.g() - (((this.r - 1) - fVar.f276e) * this.w);
                    i7 = i8 - this.u.c(view);
                }
                if (this.v == 1) {
                    i10 = i8;
                    i9 = i5;
                    i11 = i7;
                    i7 = i6;
                } else {
                    i9 = i8;
                    i10 = i5;
                    i11 = i6;
                }
                a0(view, i11, i7, i10, i9);
                D1(fVar, this.x.f1810e, i2);
                v1(tVar, this.x);
                if (this.x.f1813h && view.hasFocusable()) {
                    this.A.set(fVar.f276e, false);
                }
                z5 = true;
                z4 = false;
            }
        }
        if (!z5) {
            v1(tVar, this.x);
        }
        int k4 = this.x.f1810e == -1 ? this.t.k() - n1(this.t.k()) : m1(this.t.g()) - this.t.g();
        if (k4 > 0) {
            return Math.min(kVar.b, k4);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean g(RecyclerView.n nVar) {
        return nVar instanceof c;
    }

    public View g1(boolean z2) {
        int k2 = this.t.k();
        int g2 = this.t.g();
        View view = null;
        for (int y2 = y() - 1; y2 >= 0; y2--) {
            View x2 = x(y2);
            int e2 = this.t.e(x2);
            int b2 = this.t.b(x2);
            if (b2 > k2 && e2 < g2) {
                if (b2 <= g2 || !z2) {
                    return x2;
                }
                if (view == null) {
                    view = x2;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void h0(RecyclerView recyclerView, RecyclerView.t tVar) {
        g0();
        Runnable runnable = this.N;
        RecyclerView recyclerView2 = this.b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(runnable);
        }
        for (int i2 = 0; i2 < this.r; i2++) {
            this.s[i2].d();
        }
        recyclerView.requestLayout();
    }

    public View h1(boolean z2) {
        int k2 = this.t.k();
        int g2 = this.t.g();
        int y2 = y();
        View view = null;
        for (int i2 = 0; i2 < y2; i2++) {
            View x2 = x(i2);
            int e2 = this.t.e(x2);
            if (this.t.b(x2) > k2 && e2 < g2) {
                if (e2 >= k2 || !z2) {
                    return x2;
                }
                if (view == null) {
                    view = x2;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void i(int i2, int i3, RecyclerView.y yVar, RecyclerView.m.c cVar) {
        int i4;
        int i5;
        if (this.v != 0) {
            i2 = i3;
        }
        if (!(y() == 0 || i2 == 0)) {
            u1(i2, yVar);
            int[] iArr = this.M;
            if (iArr == null || iArr.length < this.r) {
                this.M = new int[this.r];
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.r; i7++) {
                k kVar = this.x;
                if (kVar.f1809d == -1) {
                    i5 = kVar.f1811f;
                    i4 = this.s[i7].k(i5);
                } else {
                    i5 = this.s[i7].h(kVar.f1812g);
                    i4 = this.x.f1812g;
                }
                int i8 = i5 - i4;
                if (i8 >= 0) {
                    this.M[i6] = i8;
                    i6++;
                }
            }
            Arrays.sort(this.M, 0, i6);
            for (int i9 = 0; i9 < i6; i9++) {
                int i10 = this.x.c;
                if (i10 >= 0 && i10 < yVar.b()) {
                    ((j.b) cVar).a(this.x.c, this.M[i9]);
                    k kVar2 = this.x;
                    kVar2.c += kVar2.f1809d;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0038, code lost:
        if (r8.v == 1) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003d, code lost:
        if (r8.v == 0) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004c, code lost:
        if (q1() == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0058, code lost:
        if (q1() == false) goto L_0x005c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0060  */
    @Override // androidx.recyclerview.widget.RecyclerView.m
    public View i0(View view, int i2, RecyclerView.t tVar, RecyclerView.y yVar) {
        View s2;
        int i3;
        if (y() == 0 || (s2 = s(view)) == null) {
            return null;
        }
        y1();
        if (i2 == 1) {
            if (this.v != 1) {
            }
            i3 = -1;
            if (i3 == Integer.MIN_VALUE) {
            }
        } else if (i2 != 2) {
            if (i2 != 17) {
                if (i2 != 33) {
                    if (i2 == 66) {
                    }
                }
            }
            i3 = Integer.MIN_VALUE;
            if (i3 == Integer.MIN_VALUE) {
                return null;
            }
            c cVar = (c) s2.getLayoutParams();
            Objects.requireNonNull(cVar);
            f fVar = cVar.f264e;
            int l1 = i3 == 1 ? l1() : k1();
            C1(l1, yVar);
            A1(i3);
            k kVar = this.x;
            kVar.c = kVar.f1809d + l1;
            kVar.b = (int) (((float) this.t.l()) * 0.33333334f);
            k kVar2 = this.x;
            kVar2.f1813h = true;
            kVar2.a = false;
            f1(tVar, kVar2, yVar);
            this.F = this.z;
            View i4 = fVar.i(l1, i3);
            if (!(i4 == null || i4 == s2)) {
                return i4;
            }
            if (t1(i3)) {
                for (int i5 = this.r - 1; i5 >= 0; i5--) {
                    View i6 = this.s[i5].i(l1, i3);
                    if (!(i6 == null || i6 == s2)) {
                        return i6;
                    }
                }
            } else {
                for (int i7 = 0; i7 < this.r; i7++) {
                    View i8 = this.s[i7].i(l1, i3);
                    if (!(i8 == null || i8 == s2)) {
                        return i8;
                    }
                }
            }
            boolean z2 = (this.y ^ true) == (i3 == -1);
            View t2 = t(z2 ? fVar.e() : fVar.f());
            if (!(t2 == null || t2 == s2)) {
                return t2;
            }
            if (t1(i3)) {
                for (int i9 = this.r - 1; i9 >= 0; i9--) {
                    if (i9 != fVar.f276e) {
                        f[] fVarArr = this.s;
                        View t3 = t(z2 ? fVarArr[i9].e() : fVarArr[i9].f());
                        if (!(t3 == null || t3 == s2)) {
                            return t3;
                        }
                    }
                }
            } else {
                for (int i10 = 0; i10 < this.r; i10++) {
                    f[] fVarArr2 = this.s;
                    View t4 = t(z2 ? fVarArr2[i10].e() : fVarArr2[i10].f());
                    if (!(t4 == null || t4 == s2)) {
                        return t4;
                    }
                }
            }
            return null;
        } else if (this.v != 1) {
        }
        i3 = 1;
        if (i3 == Integer.MIN_VALUE) {
        }
    }

    public final void i1(RecyclerView.t tVar, RecyclerView.y yVar, boolean z2) {
        int g2;
        int m1 = m1(Integer.MIN_VALUE);
        if (m1 != Integer.MIN_VALUE && (g2 = this.t.g() - m1) > 0) {
            int i2 = g2 - (-z1(-g2, tVar, yVar));
            if (z2 && i2 > 0) {
                this.t.p(i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void j0(AccessibilityEvent accessibilityEvent) {
        RecyclerView.t tVar = this.b.c;
        k0(accessibilityEvent);
        if (y() > 0) {
            View h1 = h1(false);
            View g1 = g1(false);
            if (h1 != null && g1 != null) {
                int R = R(h1);
                int R2 = R(g1);
                if (R < R2) {
                    accessibilityEvent.setFromIndex(R);
                    accessibilityEvent.setToIndex(R2);
                    return;
                }
                accessibilityEvent.setFromIndex(R2);
                accessibilityEvent.setToIndex(R);
            }
        }
    }

    public final void j1(RecyclerView.t tVar, RecyclerView.y yVar, boolean z2) {
        int k2;
        int n1 = n1(Integer.MAX_VALUE);
        if (n1 != Integer.MAX_VALUE && (k2 = n1 - this.t.k()) > 0) {
            int z1 = k2 - z1(k2, tVar, yVar);
            if (z2 && z1 > 0) {
                this.t.p(-z1);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int k(RecyclerView.y yVar) {
        return c1(yVar);
    }

    public int k1() {
        if (y() == 0) {
            return 0;
        }
        return R(x(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int l(RecyclerView.y yVar) {
        return d1(yVar);
    }

    public int l1() {
        int y2 = y();
        if (y2 == 0) {
            return 0;
        }
        return R(x(y2 - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int m(RecyclerView.y yVar) {
        return e1(yVar);
    }

    public final int m1(int i2) {
        int h2 = this.s[0].h(i2);
        for (int i3 = 1; i3 < this.r; i3++) {
            int h3 = this.s[i3].h(i2);
            if (h3 > h2) {
                h2 = h3;
            }
        }
        return h2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int n(RecyclerView.y yVar) {
        return c1(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void n0(RecyclerView.t tVar, RecyclerView.y yVar, View view, e.i.i.w.b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            m0(view, bVar);
            return;
        }
        c cVar = (c) layoutParams;
        if (this.v == 0) {
            f fVar = cVar.f264e;
            i5 = fVar == null ? -1 : fVar.f276e;
            i4 = 1;
            i3 = -1;
            i2 = -1;
        } else {
            f fVar2 = cVar.f264e;
            i3 = fVar2 == null ? -1 : fVar2.f276e;
            i5 = -1;
            i4 = -1;
            i2 = 1;
        }
        bVar.j(b.c.a(i5, i4, i3, i2, false, false));
    }

    public final int n1(int i2) {
        int k2 = this.s[0].k(i2);
        for (int i3 = 1; i3 < this.r; i3++) {
            int k3 = this.s[i3].k(i2);
            if (k3 < k2) {
                k2 = k3;
            }
        }
        return k2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int o(RecyclerView.y yVar) {
        return d1(yVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    public final void o1(int i2, int i3, int i4) {
        int i5;
        int i6;
        int l1 = this.z ? l1() : k1();
        if (i4 != 8) {
            i6 = i2 + i3;
        } else if (i2 < i3) {
            i6 = i3 + 1;
        } else {
            i6 = i2 + 1;
            i5 = i3;
            this.D.d(i5);
            if (i4 != 1) {
                this.D.e(i2, i3);
            } else if (i4 == 2) {
                this.D.f(i2, i3);
            } else if (i4 == 8) {
                this.D.f(i2, 1);
                this.D.e(i3, 1);
            }
            if (i6 <= l1) {
                if (i5 <= (this.z ? k1() : l1())) {
                    L0();
                    return;
                }
                return;
            }
            return;
        }
        i5 = i2;
        this.D.d(i5);
        if (i4 != 1) {
        }
        if (i6 <= l1) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int p(RecyclerView.y yVar) {
        return e1(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void p0(RecyclerView recyclerView, int i2, int i3) {
        o1(i2, i3, 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b3, code lost:
        if (r10 == r11) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c5, code lost:
        if (r10 == r11) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c9, code lost:
        r10 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0090 A[SYNTHETIC] */
    public View p1() {
        int i2;
        boolean z2;
        View view;
        int y2 = y() - 1;
        BitSet bitSet = new BitSet(this.r);
        bitSet.set(0, this.r, true);
        int i3 = -1;
        char c2 = (this.v != 1 || !q1()) ? (char) 65535 : 1;
        if (this.z) {
            i2 = -1;
        } else {
            i2 = y2 + 1;
            y2 = 0;
        }
        if (y2 < i2) {
            i3 = 1;
        }
        while (y2 != i2) {
            View x2 = x(y2);
            c cVar = (c) x2.getLayoutParams();
            if (bitSet.get(cVar.f264e.f276e)) {
                f fVar = cVar.f264e;
                if (this.z) {
                    int i4 = fVar.c;
                    if (i4 == Integer.MIN_VALUE) {
                        fVar.b();
                        i4 = fVar.c;
                    }
                    if (i4 < this.t.g()) {
                        ArrayList<View> arrayList = fVar.a;
                        view = arrayList.get(arrayList.size() - 1);
                    }
                    z2 = false;
                    if (z2) {
                        return x2;
                    }
                    bitSet.clear(cVar.f264e.f276e);
                } else {
                    int i5 = fVar.b;
                    if (i5 == Integer.MIN_VALUE) {
                        fVar.c();
                        i5 = fVar.b;
                    }
                    if (i5 > this.t.k()) {
                        view = fVar.a.get(0);
                    }
                    z2 = false;
                    if (z2) {
                    }
                }
                Objects.requireNonNull(fVar.j(view));
                z2 = true;
                if (z2) {
                }
            }
            int i6 = y2 + i3;
            if (i6 != i2) {
                View x3 = x(i6);
                if (this.z) {
                    int b2 = this.t.b(x2);
                    int b3 = this.t.b(x3);
                    if (b2 < b3) {
                        return x2;
                    }
                } else {
                    int e2 = this.t.e(x2);
                    int e3 = this.t.e(x3);
                    if (e2 > e3) {
                        return x2;
                    }
                }
                boolean z3 = true;
                if (!z3) {
                    continue;
                } else {
                    if ((cVar.f264e.f276e - ((c) x3.getLayoutParams()).f264e.f276e < 0) != (c2 < 0)) {
                        return x2;
                    }
                }
            }
            y2 += i3;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void q0(RecyclerView recyclerView) {
        this.D.a();
        L0();
    }

    public boolean q1() {
        return K() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void r0(RecyclerView recyclerView, int i2, int i3, int i4) {
        o1(i2, i3, 8);
    }

    public final void r1(View view, int i2, int i3, boolean z2) {
        Rect rect = this.J;
        RecyclerView recyclerView = this.b;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.L(view));
        }
        c cVar = (c) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect2 = this.J;
        int E1 = E1(i2, i4 + rect2.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect2.right);
        int i5 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect3 = this.J;
        int E12 = E1(i3, i5 + rect3.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect3.bottom);
        if (z2 ? W0(view, E1, E12, cVar) : U0(view, E1, E12, cVar)) {
            view.measure(E1, E12);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void s0(RecyclerView recyclerView, int i2, int i3) {
        o1(i2, i3, 2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:234:0x03f9, code lost:
        if (b1() != false) goto L_0x03fd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01ac  */
    public final void s1(RecyclerView.t tVar, RecyclerView.y yVar, boolean z2) {
        e eVar;
        boolean z3;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        boolean z4;
        b bVar = this.K;
        if (!(this.H == null && this.B == -1) && yVar.b() == 0) {
            F0(tVar);
            bVar.b();
            return;
        }
        boolean z5 = true;
        boolean z6 = (bVar.f261e && this.B == -1 && this.H == null) ? false : true;
        if (z6) {
            bVar.b();
            e eVar2 = this.H;
            if (eVar2 != null) {
                int i8 = eVar2.f267d;
                if (i8 > 0) {
                    if (i8 == this.r) {
                        for (int i9 = 0; i9 < this.r; i9++) {
                            this.s[i9].d();
                            e eVar3 = this.H;
                            int i10 = eVar3.f268e[i9];
                            if (i10 != Integer.MIN_VALUE) {
                                i10 += eVar3.f273j ? this.t.g() : this.t.k();
                            }
                            f fVar = this.s[i9];
                            fVar.b = i10;
                            fVar.c = i10;
                        }
                    } else {
                        eVar2.f268e = null;
                        eVar2.f267d = 0;
                        eVar2.f269f = 0;
                        eVar2.f270g = null;
                        eVar2.f271h = null;
                        eVar2.b = eVar2.c;
                    }
                }
                e eVar4 = this.H;
                this.G = eVar4.f274k;
                boolean z7 = eVar4.f272i;
                d(null);
                e eVar5 = this.H;
                if (!(eVar5 == null || eVar5.f272i == z7)) {
                    eVar5.f272i = z7;
                }
                this.y = z7;
                L0();
                y1();
                e eVar6 = this.H;
                int i11 = eVar6.b;
                if (i11 != -1) {
                    this.B = i11;
                    z4 = eVar6.f273j;
                } else {
                    z4 = this.z;
                }
                bVar.c = z4;
                if (eVar6.f269f > 1) {
                    d dVar = this.D;
                    dVar.a = eVar6.f270g;
                    dVar.b = eVar6.f271h;
                }
            } else {
                y1();
                bVar.c = this.z;
            }
            if (!yVar.f254g && (i3 = this.B) != -1) {
                if (i3 < 0 || i3 >= yVar.b()) {
                    this.B = -1;
                    this.C = Integer.MIN_VALUE;
                } else {
                    e eVar7 = this.H;
                    if (eVar7 == null || eVar7.b == -1 || eVar7.f267d < 1) {
                        View t2 = t(this.B);
                        if (t2 != null) {
                            bVar.a = this.z ? l1() : k1();
                            if (this.C != Integer.MIN_VALUE) {
                                if (bVar.c) {
                                    i6 = this.t.g() - this.C;
                                    i7 = this.t.b(t2);
                                } else {
                                    i6 = this.t.k() + this.C;
                                    i7 = this.t.e(t2);
                                }
                                i4 = i6 - i7;
                            } else {
                                if (this.t.c(t2) > this.t.l()) {
                                    i5 = bVar.c ? this.t.g() : this.t.k();
                                } else {
                                    int e2 = this.t.e(t2) - this.t.k();
                                    if (e2 < 0) {
                                        i5 = -e2;
                                    } else {
                                        i4 = this.t.g() - this.t.b(t2);
                                        if (i4 >= 0) {
                                            bVar.b = Integer.MIN_VALUE;
                                        }
                                    }
                                }
                                bVar.b = i5;
                            }
                            bVar.b = i4;
                        } else {
                            int i12 = this.B;
                            bVar.a = i12;
                            int i13 = this.C;
                            if (i13 == Integer.MIN_VALUE) {
                                bVar.c = a1(i12) == 1;
                                bVar.a();
                            } else {
                                bVar.b = bVar.c ? StaggeredGridLayoutManager.this.t.g() - i13 : StaggeredGridLayoutManager.this.t.k() + i13;
                            }
                            bVar.f260d = true;
                        }
                    } else {
                        bVar.b = Integer.MIN_VALUE;
                        bVar.a = this.B;
                    }
                    z3 = true;
                    if (!z3) {
                        boolean z8 = this.F;
                        int b2 = yVar.b();
                        if (z8) {
                            int y2 = y();
                            while (true) {
                                y2--;
                                if (y2 < 0) {
                                    break;
                                }
                                i2 = R(x(y2));
                                if (i2 >= 0 && i2 < b2) {
                                    break;
                                }
                            }
                        } else {
                            int y3 = y();
                            int i14 = 0;
                            while (true) {
                                if (i14 >= y3) {
                                    break;
                                }
                                int R = R(x(i14));
                                if (R >= 0 && R < b2) {
                                    i2 = R;
                                    break;
                                }
                                i14++;
                            }
                        }
                        i2 = 0;
                        bVar.a = i2;
                        bVar.b = Integer.MIN_VALUE;
                    }
                    bVar.f261e = true;
                }
            }
            z3 = false;
            if (!z3) {
            }
            bVar.f261e = true;
        }
        if (this.H == null && this.B == -1 && !(bVar.c == this.F && q1() == this.G)) {
            this.D.a();
            bVar.f260d = true;
        }
        if (y() > 0 && ((eVar = this.H) == null || eVar.f267d < 1)) {
            if (bVar.f260d) {
                for (int i15 = 0; i15 < this.r; i15++) {
                    this.s[i15].d();
                    int i16 = bVar.b;
                    if (i16 != Integer.MIN_VALUE) {
                        f fVar2 = this.s[i15];
                        fVar2.b = i16;
                        fVar2.c = i16;
                    }
                }
            } else if (z6 || this.K.f262f == null) {
                for (int i17 = 0; i17 < this.r; i17++) {
                    f fVar3 = this.s[i17];
                    boolean z9 = this.z;
                    int i18 = bVar.b;
                    int h2 = z9 ? fVar3.h(Integer.MIN_VALUE) : fVar3.k(Integer.MIN_VALUE);
                    fVar3.d();
                    if (h2 != Integer.MIN_VALUE && ((!z9 || h2 >= StaggeredGridLayoutManager.this.t.g()) && (z9 || h2 <= StaggeredGridLayoutManager.this.t.k()))) {
                        if (i18 != Integer.MIN_VALUE) {
                            h2 += i18;
                        }
                        fVar3.c = h2;
                        fVar3.b = h2;
                    }
                }
                b bVar2 = this.K;
                f[] fVarArr = this.s;
                Objects.requireNonNull(bVar2);
                int length = fVarArr.length;
                int[] iArr = bVar2.f262f;
                if (iArr == null || iArr.length < length) {
                    bVar2.f262f = new int[StaggeredGridLayoutManager.this.s.length];
                }
                for (int i19 = 0; i19 < length; i19++) {
                    bVar2.f262f[i19] = fVarArr[i19].k(Integer.MIN_VALUE);
                }
            } else {
                for (int i20 = 0; i20 < this.r; i20++) {
                    f fVar4 = this.s[i20];
                    fVar4.d();
                    int i21 = this.K.f262f[i20];
                    fVar4.b = i21;
                    fVar4.c = i21;
                }
            }
        }
        q(tVar);
        this.x.a = false;
        int l2 = this.u.l();
        this.w = l2 / this.r;
        this.I = View.MeasureSpec.makeMeasureSpec(l2, this.u.i());
        C1(bVar.a, yVar);
        if (bVar.c) {
            A1(-1);
            f1(tVar, this.x, yVar);
            A1(1);
        } else {
            A1(1);
            f1(tVar, this.x, yVar);
            A1(-1);
        }
        k kVar = this.x;
        kVar.c = bVar.a + kVar.f1809d;
        f1(tVar, kVar, yVar);
        if (this.u.i() != 1073741824) {
            float f2 = 0.0f;
            int y4 = y();
            for (int i22 = 0; i22 < y4; i22++) {
                View x2 = x(i22);
                float c2 = (float) this.u.c(x2);
                if (c2 >= f2) {
                    Objects.requireNonNull((c) x2.getLayoutParams());
                    f2 = Math.max(f2, c2);
                }
            }
            int i23 = this.w;
            int round = Math.round(f2 * ((float) this.r));
            if (this.u.i() == Integer.MIN_VALUE) {
                round = Math.min(round, this.u.l());
            }
            this.w = round / this.r;
            this.I = View.MeasureSpec.makeMeasureSpec(round, this.u.i());
            if (this.w != i23) {
                for (int i24 = 0; i24 < y4; i24++) {
                    View x3 = x(i24);
                    c cVar = (c) x3.getLayoutParams();
                    Objects.requireNonNull(cVar);
                    if (!q1() || this.v != 1) {
                        int i25 = cVar.f264e.f276e;
                        int i26 = this.v;
                        int i27 = (this.w * i25) - (i25 * i23);
                        if (i26 == 1) {
                            x3.offsetLeftAndRight(i27);
                        } else {
                            x3.offsetTopAndBottom(i27);
                        }
                    } else {
                        int i28 = this.r;
                        int i29 = cVar.f264e.f276e;
                        x3.offsetLeftAndRight(((-((i28 - 1) - i29)) * this.w) - ((-((i28 - 1) - i29)) * i23));
                    }
                }
            }
        }
        if (y() > 0) {
            if (this.z) {
                i1(tVar, yVar, true);
                j1(tVar, yVar, false);
            } else {
                j1(tVar, yVar, true);
                i1(tVar, yVar, false);
            }
        }
        if (z2 && !yVar.f254g) {
            if ((this.E == 0 || y() <= 0 || p1() == null) ? false : true) {
                Runnable runnable = this.N;
                RecyclerView recyclerView = this.b;
                if (recyclerView != null) {
                    recyclerView.removeCallbacks(runnable);
                }
            }
        }
        z5 = false;
        if (yVar.f254g) {
            this.K.b();
        }
        this.F = bVar.c;
        this.G = q1();
        if (z5) {
            this.K.b();
            s1(tVar, yVar, false);
        }
    }

    public final boolean t1(int i2) {
        if (this.v == 0) {
            return (i2 == -1) != this.z;
        }
        return ((i2 == -1) == this.z) == q1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n u() {
        return this.v == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void u0(RecyclerView recyclerView, int i2, int i3, Object obj) {
        o1(i2, i3, 4);
    }

    public void u1(int i2, RecyclerView.y yVar) {
        int i3;
        int i4;
        if (i2 > 0) {
            i4 = l1();
            i3 = 1;
        } else {
            i4 = k1();
            i3 = -1;
        }
        this.x.a = true;
        C1(i4, yVar);
        A1(i3);
        k kVar = this.x;
        kVar.c = i4 + kVar.f1809d;
        kVar.b = Math.abs(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n v(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void v0(RecyclerView.t tVar, RecyclerView.y yVar) {
        s1(tVar, yVar, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (r6.f1810e == -1) goto L_0x0013;
     */
    public final void v1(RecyclerView.t tVar, k kVar) {
        int min;
        int min2;
        if (kVar.a && !kVar.f1814i) {
            if (kVar.b != 0) {
                int i2 = 1;
                if (kVar.f1810e == -1) {
                    int i3 = kVar.f1811f;
                    int k2 = this.s[0].k(i3);
                    while (i2 < this.r) {
                        int k3 = this.s[i2].k(i3);
                        if (k3 > k2) {
                            k2 = k3;
                        }
                        i2++;
                    }
                    int i4 = i3 - k2;
                    if (i4 >= 0) {
                        min2 = kVar.f1812g - Math.min(i4, kVar.b);
                        w1(tVar, min2);
                    }
                } else {
                    int i5 = kVar.f1812g;
                    int h2 = this.s[0].h(i5);
                    while (i2 < this.r) {
                        int h3 = this.s[i2].h(i5);
                        if (h3 < h2) {
                            h2 = h3;
                        }
                        i2++;
                    }
                    int i6 = h2 - kVar.f1812g;
                    if (i6 >= 0) {
                        min = Math.min(i6, kVar.b) + kVar.f1811f;
                        x1(tVar, min);
                        return;
                    }
                    min = kVar.f1811f;
                    x1(tVar, min);
                    return;
                }
            }
            min2 = kVar.f1812g;
            w1(tVar, min2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n w(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void w0(RecyclerView.y yVar) {
        this.B = -1;
        this.C = Integer.MIN_VALUE;
        this.H = null;
        this.K.b();
    }

    public final void w1(RecyclerView.t tVar, int i2) {
        for (int y2 = y() - 1; y2 >= 0; y2--) {
            View x2 = x(y2);
            if (this.t.e(x2) >= i2 && this.t.o(x2) >= i2) {
                c cVar = (c) x2.getLayoutParams();
                Objects.requireNonNull(cVar);
                if (cVar.f264e.a.size() != 1) {
                    cVar.f264e.l();
                    H0(x2, tVar);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void x1(RecyclerView.t tVar, int i2) {
        while (y() > 0) {
            View x2 = x(0);
            if (this.t.b(x2) <= i2 && this.t.n(x2) <= i2) {
                c cVar = (c) x2.getLayoutParams();
                Objects.requireNonNull(cVar);
                if (cVar.f264e.a.size() != 1) {
                    cVar.f264e.m();
                    H0(x2, tVar);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void y1() {
        this.z = (this.v == 1 || !q1()) ? this.y : !this.y;
    }

    public int z1(int i2, RecyclerView.t tVar, RecyclerView.y yVar) {
        if (y() == 0 || i2 == 0) {
            return 0;
        }
        u1(i2, yVar);
        int f1 = f1(tVar, this.x, yVar);
        if (this.x.b >= f1) {
            i2 = i2 < 0 ? -f1 : f1;
        }
        this.t.p(-i2);
        this.F = this.z;
        k kVar = this.x;
        kVar.b = 0;
        v1(tVar, kVar);
        return i2;
    }
}
