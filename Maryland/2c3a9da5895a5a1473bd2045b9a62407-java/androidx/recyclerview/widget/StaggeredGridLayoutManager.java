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
import e.i.i.x.b;
import e.s.a.j;
import e.s.a.m;
import e.s.a.n;
import e.s.a.r;
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
    public r t;
    public r u;
    public int v;
    public int w;
    public final m x;
    public boolean y;
    public boolean z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            StaggeredGridLayoutManager.this.c1();
        }
    }

    public class b {
        public int a;
        public int b;
        public boolean c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f268d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f269e;

        /* renamed from: f  reason: collision with root package name */
        public int[] f270f;

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
            this.f268d = false;
            this.f269e = false;
            int[] iArr = this.f270f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    public static class c extends RecyclerView.n {

        /* renamed from: e  reason: collision with root package name */
        public f f272e;

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
            public static final Parcelable.Creator<a> CREATOR = new C0002a();
            public int b;
            public int c;

            /* renamed from: d  reason: collision with root package name */
            public int[] f273d;

            /* renamed from: e  reason: collision with root package name */
            public boolean f274e;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a  reason: collision with other inner class name */
            public static class C0002a implements Parcelable.Creator<a> {
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
                this.f274e = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f273d = iArr;
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
                h2.append(this.f274e);
                h2.append(", mGapPerSpan=");
                h2.append(Arrays.toString(this.f273d));
                h2.append('}');
                return h2.toString();
            }

            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.b);
                parcel.writeInt(this.c);
                parcel.writeInt(this.f274e ? 1 : 0);
                int[] iArr = this.f273d;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f273d);
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
        public int f275d;

        /* renamed from: e  reason: collision with root package name */
        public int[] f276e;

        /* renamed from: f  reason: collision with root package name */
        public int f277f;

        /* renamed from: g  reason: collision with root package name */
        public int[] f278g;

        /* renamed from: h  reason: collision with root package name */
        public List<d.a> f279h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f280i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f281j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f282k;

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
            this.f275d = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f276e = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f277f = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f278g = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z = false;
            this.f280i = parcel.readInt() == 1;
            this.f281j = parcel.readInt() == 1;
            this.f282k = parcel.readInt() == 1 ? true : z;
            this.f279h = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f275d = eVar.f275d;
            this.b = eVar.b;
            this.c = eVar.c;
            this.f276e = eVar.f276e;
            this.f277f = eVar.f277f;
            this.f278g = eVar.f278g;
            this.f280i = eVar.f280i;
            this.f281j = eVar.f281j;
            this.f282k = eVar.f282k;
            this.f279h = eVar.f279h;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.f275d);
            if (this.f275d > 0) {
                parcel.writeIntArray(this.f276e);
            }
            parcel.writeInt(this.f277f);
            if (this.f277f > 0) {
                parcel.writeIntArray(this.f278g);
            }
            parcel.writeInt(this.f280i ? 1 : 0);
            parcel.writeInt(this.f281j ? 1 : 0);
            parcel.writeInt(this.f282k ? 1 : 0);
            parcel.writeList(this.f279h);
        }
    }

    public class f {
        public ArrayList<View> a = new ArrayList<>();
        public int b = Integer.MIN_VALUE;
        public int c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        public int f283d = 0;

        /* renamed from: e  reason: collision with root package name */
        public final int f284e;

        public f(int i2) {
            this.f284e = i2;
        }

        public void a(View view) {
            c j2 = j(view);
            j2.f272e = this;
            this.a.add(view);
            this.c = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.b = Integer.MIN_VALUE;
            }
            if (j2.c() || j2.b()) {
                this.f283d = StaggeredGridLayoutManager.this.t.c(view) + this.f283d;
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
            this.f283d = 0;
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
                    return StaggeredGridLayoutManager.this.S(view);
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
                    if (staggeredGridLayoutManager.y && staggeredGridLayoutManager.S(view2) >= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.y && staggeredGridLayoutManager2.S(view2) <= i2) || !view2.hasFocusable()) {
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
                    if (staggeredGridLayoutManager3.y && staggeredGridLayoutManager3.S(view3) <= i2) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.y && staggeredGridLayoutManager4.S(view3) >= i2) || !view3.hasFocusable()) {
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
            j2.f272e = null;
            if (j2.c() || j2.b()) {
                this.f283d -= StaggeredGridLayoutManager.this.t.c(remove);
            }
            if (size == 1) {
                this.b = Integer.MIN_VALUE;
            }
            this.c = Integer.MIN_VALUE;
        }

        public void m() {
            View remove = this.a.remove(0);
            c j2 = j(remove);
            j2.f272e = null;
            if (this.a.size() == 0) {
                this.c = Integer.MIN_VALUE;
            }
            if (j2.c() || j2.b()) {
                this.f283d -= StaggeredGridLayoutManager.this.t.c(remove);
            }
            this.b = Integer.MIN_VALUE;
        }

        public void n(View view) {
            c j2 = j(view);
            j2.f272e = this;
            this.a.add(0, view);
            this.b = Integer.MIN_VALUE;
            if (this.a.size() == 1) {
                this.c = Integer.MIN_VALUE;
            }
            if (j2.c() || j2.b()) {
                this.f283d = StaggeredGridLayoutManager.this.t.c(view) + this.f283d;
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
        RecyclerView.m.d T = RecyclerView.m.T(context, attributeSet, i2, i3);
        int i4 = T.a;
        if (i4 == 0 || i4 == 1) {
            d(null);
            if (i4 != this.v) {
                this.v = i4;
                r rVar = this.t;
                this.t = this.u;
                this.u = rVar;
                M0();
            }
            int i5 = T.b;
            d(null);
            if (i5 != this.r) {
                this.D.a();
                M0();
                this.r = i5;
                this.A = new BitSet(this.r);
                this.s = new f[this.r];
                for (int i6 = 0; i6 < this.r; i6++) {
                    this.s[i6] = new f(i6);
                }
                M0();
            }
            boolean z2 = T.c;
            d(null);
            e eVar = this.H;
            if (!(eVar == null || eVar.f280i == z2)) {
                eVar.f280i = z2;
            }
            this.y = z2;
            M0();
            this.x = new m();
            this.t = r.a(this, this.v);
            this.u = r.a(this, 1 - this.v);
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public int A1(int i2, RecyclerView.t tVar, RecyclerView.y yVar) {
        if (z() == 0 || i2 == 0) {
            return 0;
        }
        v1(i2, yVar);
        int g1 = g1(tVar, this.x, yVar);
        if (this.x.b >= g1) {
            i2 = i2 < 0 ? -g1 : g1;
        }
        this.t.p(-i2);
        this.F = this.z;
        m mVar = this.x;
        mVar.b = 0;
        w1(tVar, mVar);
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int B(RecyclerView.t tVar, RecyclerView.y yVar) {
        return this.v == 1 ? this.r : super.B(tVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void B0(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.H = (e) parcelable;
            M0();
        }
    }

    public final void B1(int i2) {
        m mVar = this.x;
        mVar.f1847e = i2;
        int i3 = 1;
        if (this.z != (i2 == -1)) {
            i3 = -1;
        }
        mVar.f1846d = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public Parcelable C0() {
        int i2;
        int i3;
        int[] iArr;
        e eVar = this.H;
        if (eVar != null) {
            return new e(eVar);
        }
        e eVar2 = new e();
        eVar2.f280i = this.y;
        eVar2.f281j = this.F;
        eVar2.f282k = this.G;
        d dVar = this.D;
        if (dVar == null || (iArr = dVar.a) == null) {
            eVar2.f277f = 0;
        } else {
            eVar2.f278g = iArr;
            eVar2.f277f = iArr.length;
            eVar2.f279h = dVar.b;
        }
        int i4 = -1;
        if (z() > 0) {
            eVar2.b = this.F ? m1() : l1();
            View h1 = this.z ? h1(true) : i1(true);
            if (h1 != null) {
                i4 = S(h1);
            }
            eVar2.c = i4;
            int i5 = this.r;
            eVar2.f275d = i5;
            eVar2.f276e = new int[i5];
            for (int i6 = 0; i6 < this.r; i6++) {
                if (this.F) {
                    i2 = this.s[i6].h(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.t.g();
                    } else {
                        eVar2.f276e[i6] = i2;
                    }
                } else {
                    i2 = this.s[i6].k(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.t.k();
                    } else {
                        eVar2.f276e[i6] = i2;
                    }
                }
                i2 -= i3;
                eVar2.f276e[i6] = i2;
            }
        } else {
            eVar2.b = -1;
            eVar2.c = -1;
            eVar2.f275d = 0;
        }
        return eVar2;
    }

    public final void C1(int i2, int i3) {
        for (int i4 = 0; i4 < this.r; i4++) {
            if (!this.s[i4].a.isEmpty()) {
                E1(this.s[i4], i2, i3);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void D0(int i2) {
        if (i2 == 0) {
            c1();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0059  */
    public final void D1(int i2, RecyclerView.y yVar) {
        int i3;
        int i4;
        RecyclerView recyclerView;
        int i5;
        m mVar = this.x;
        boolean z2 = false;
        mVar.b = 0;
        mVar.c = i2;
        RecyclerView.x xVar = this.f235g;
        if (!(xVar != null && xVar.f251e) || (i5 = yVar.a) == -1) {
            i4 = 0;
        } else {
            if (this.z == (i5 < i2)) {
                i4 = this.t.l();
            } else {
                i3 = this.t.l();
                i4 = 0;
                recyclerView = this.b;
                if (!(recyclerView == null && recyclerView.f210h)) {
                    this.x.f1848f = this.t.k() - i3;
                    this.x.f1849g = this.t.g() + i4;
                } else {
                    this.x.f1849g = this.t.f() + i4;
                    this.x.f1848f = -i3;
                }
                m mVar2 = this.x;
                mVar2.f1850h = false;
                mVar2.a = true;
                if (this.t.i() == 0 && this.t.f() == 0) {
                    z2 = true;
                }
                mVar2.f1851i = z2;
            }
        }
        i3 = 0;
        recyclerView = this.b;
        if (!(recyclerView == null && recyclerView.f210h)) {
        }
        m mVar22 = this.x;
        mVar22.f1850h = false;
        mVar22.a = true;
        z2 = true;
        mVar22.f1851i = z2;
    }

    public final void E1(f fVar, int i2, int i3) {
        int i4 = fVar.f283d;
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
        this.A.set(fVar.f284e, false);
    }

    public final int F1(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode) : i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int N0(int i2, RecyclerView.t tVar, RecyclerView.y yVar) {
        return A1(i2, tVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void O0(int i2) {
        e eVar = this.H;
        if (!(eVar == null || eVar.b == i2)) {
            eVar.f276e = null;
            eVar.f275d = 0;
            eVar.b = -1;
            eVar.c = -1;
        }
        this.B = i2;
        this.C = Integer.MIN_VALUE;
        M0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int P0(int i2, RecyclerView.t tVar, RecyclerView.y yVar) {
        return A1(i2, tVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void S0(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        int Q = Q() + P();
        int O = O() + R();
        if (this.v == 1) {
            i5 = RecyclerView.m.i(i3, rect.height() + O, M());
            i4 = RecyclerView.m.i(i2, (this.w * this.r) + Q, N());
        } else {
            i4 = RecyclerView.m.i(i2, rect.width() + Q, N());
            i5 = RecyclerView.m.i(i3, (this.w * this.r) + O, M());
        }
        this.b.setMeasuredDimension(i4, i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int U(RecyclerView.t tVar, RecyclerView.y yVar) {
        return this.v == 0 ? this.r : super.U(tVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean X() {
        return this.E != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void Y0(RecyclerView recyclerView, RecyclerView.y yVar, int i2) {
        n nVar = new n(recyclerView.getContext());
        nVar.a = i2;
        Z0(nVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x.b
    public PointF a(int i2) {
        int b1 = b1(i2);
        PointF pointF = new PointF();
        if (b1 == 0) {
            return null;
        }
        if (this.v == 0) {
            pointF.x = (float) b1;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) b1;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean a1() {
        return this.H == null;
    }

    public final int b1(int i2) {
        if (z() == 0) {
            return this.z ? 1 : -1;
        }
        return (i2 < l1()) != this.z ? -1 : 1;
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

    public boolean c1() {
        int i2;
        if (!(z() == 0 || this.E == 0 || !this.f237i)) {
            if (this.z) {
                i2 = m1();
                l1();
            } else {
                i2 = l1();
                m1();
            }
            if (i2 == 0 && q1() != null) {
                this.D.a();
                this.f236h = true;
                M0();
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void d(String str) {
        RecyclerView recyclerView;
        if (this.H == null && (recyclerView = this.b) != null) {
            recyclerView.i(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void d0(int i2) {
        super.d0(i2);
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

    public final int d1(RecyclerView.y yVar) {
        if (z() == 0) {
            return 0;
        }
        return m.h.u(yVar, this.t, i1(!this.L), h1(!this.L), this, this.L);
    }

    public final int e1(RecyclerView.y yVar) {
        if (z() == 0) {
            return 0;
        }
        return m.h.v(yVar, this.t, i1(!this.L), h1(!this.L), this, this.L, this.z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean f() {
        return this.v == 0;
    }

    public final int f1(RecyclerView.y yVar) {
        if (z() == 0) {
            return 0;
        }
        return m.h.w(yVar, this.t, i1(!this.L), h1(!this.L), this, this.L);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean g() {
        return this.v == 1;
    }

    public final int g1(RecyclerView.t tVar, e.s.a.m mVar, RecyclerView.y yVar) {
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
        if (this.x.f1851i) {
            i2 = mVar.f1847e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i2 = mVar.f1847e == 1 ? mVar.f1849g + mVar.b : mVar.f1848f - mVar.b;
        }
        C1(mVar.f1847e, i2);
        int g2 = this.z ? this.t.g() : this.t.k();
        boolean z5 = false;
        while (true) {
            int i15 = mVar.c;
            if ((i15 >= 0 && i15 < yVar.b()) && (this.x.f1851i || !this.A.isEmpty())) {
                View view = tVar.j(mVar.c, z4, Long.MAX_VALUE).a;
                mVar.c += mVar.f1846d;
                c cVar = (c) view.getLayoutParams();
                int a2 = cVar.a();
                int[] iArr = this.D.a;
                int i16 = (iArr == null || a2 >= iArr.length) ? -1 : iArr[a2];
                if (i16 == -1) {
                    if (u1(mVar.f1847e)) {
                        i14 = this.r - 1;
                        i13 = -1;
                        i12 = -1;
                    } else {
                        i13 = this.r;
                        i14 = 0;
                        i12 = 1;
                    }
                    f fVar2 = null;
                    if (mVar.f1847e == 1) {
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
                    dVar.a[a2] = fVar.f284e;
                } else {
                    fVar = this.s[i16];
                }
                cVar.f272e = fVar;
                if (mVar.f1847e == 1) {
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
                    i4 = RecyclerView.m.A(i19, i20, i22, i21, z2);
                    i3 = RecyclerView.m.A(this.q, this.o, O() + R(), ((ViewGroup.MarginLayoutParams) cVar).height, true);
                    z3 = false;
                } else {
                    i4 = RecyclerView.m.A(this.p, this.n, Q() + P(), ((ViewGroup.MarginLayoutParams) cVar).width, true);
                    z3 = false;
                    i3 = RecyclerView.m.A(this.w, this.o, 0, ((ViewGroup.MarginLayoutParams) cVar).height, false);
                }
                s1(view, i4, i3, z3);
                if (mVar.f1847e == 1) {
                    i6 = fVar.h(g2);
                    i5 = this.t.c(view) + i6;
                } else {
                    i5 = fVar.k(g2);
                    i6 = i5 - this.t.c(view);
                }
                int i25 = mVar.f1847e;
                f fVar5 = cVar.f272e;
                if (i25 == 1) {
                    fVar5.a(view);
                } else {
                    fVar5.n(view);
                }
                if (!r1() || this.v != 1) {
                    i7 = this.u.k() + (fVar.f284e * this.w);
                    i8 = this.u.c(view) + i7;
                } else {
                    i8 = this.u.g() - (((this.r - 1) - fVar.f284e) * this.w);
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
                b0(view, i11, i7, i10, i9);
                E1(fVar, this.x.f1847e, i2);
                w1(tVar, this.x);
                if (this.x.f1850h && view.hasFocusable()) {
                    this.A.set(fVar.f284e, false);
                }
                z5 = true;
                z4 = false;
            }
        }
        if (!z5) {
            w1(tVar, this.x);
        }
        int k4 = this.x.f1847e == -1 ? this.t.k() - o1(this.t.k()) : n1(this.t.g()) - this.t.g();
        if (k4 > 0) {
            return Math.min(mVar.b, k4);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean h(RecyclerView.n nVar) {
        return nVar instanceof c;
    }

    public View h1(boolean z2) {
        int k2 = this.t.k();
        int g2 = this.t.g();
        View view = null;
        for (int z3 = z() - 1; z3 >= 0; z3--) {
            View y2 = y(z3);
            int e2 = this.t.e(y2);
            int b2 = this.t.b(y2);
            if (b2 > k2 && e2 < g2) {
                if (b2 <= g2 || !z2) {
                    return y2;
                }
                if (view == null) {
                    view = y2;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void i0(RecyclerView recyclerView, RecyclerView.t tVar) {
        h0();
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

    public View i1(boolean z2) {
        int k2 = this.t.k();
        int g2 = this.t.g();
        int z3 = z();
        View view = null;
        for (int i2 = 0; i2 < z3; i2++) {
            View y2 = y(i2);
            int e2 = this.t.e(y2);
            if (this.t.b(y2) > k2 && e2 < g2) {
                if (e2 >= k2 || !z2) {
                    return y2;
                }
                if (view == null) {
                    view = y2;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void j(int i2, int i3, RecyclerView.y yVar, RecyclerView.m.c cVar) {
        int i4;
        int i5;
        if (this.v != 0) {
            i2 = i3;
        }
        if (!(z() == 0 || i2 == 0)) {
            v1(i2, yVar);
            int[] iArr = this.M;
            if (iArr == null || iArr.length < this.r) {
                this.M = new int[this.r];
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.r; i7++) {
                e.s.a.m mVar = this.x;
                if (mVar.f1846d == -1) {
                    i5 = mVar.f1848f;
                    i4 = this.s[i7].k(i5);
                } else {
                    i5 = this.s[i7].h(mVar.f1849g);
                    i4 = this.x.f1849g;
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
                    e.s.a.m mVar2 = this.x;
                    mVar2.c += mVar2.f1846d;
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
        if (r1() == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0058, code lost:
        if (r1() == false) goto L_0x005c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0060  */
    @Override // androidx.recyclerview.widget.RecyclerView.m
    public View j0(View view, int i2, RecyclerView.t tVar, RecyclerView.y yVar) {
        View t2;
        int i3;
        if (z() == 0 || (t2 = t(view)) == null) {
            return null;
        }
        z1();
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
            c cVar = (c) t2.getLayoutParams();
            Objects.requireNonNull(cVar);
            f fVar = cVar.f272e;
            int m1 = i3 == 1 ? m1() : l1();
            D1(m1, yVar);
            B1(i3);
            e.s.a.m mVar = this.x;
            mVar.c = mVar.f1846d + m1;
            mVar.b = (int) (((float) this.t.l()) * 0.33333334f);
            e.s.a.m mVar2 = this.x;
            mVar2.f1850h = true;
            mVar2.a = false;
            g1(tVar, mVar2, yVar);
            this.F = this.z;
            View i4 = fVar.i(m1, i3);
            if (!(i4 == null || i4 == t2)) {
                return i4;
            }
            if (u1(i3)) {
                for (int i5 = this.r - 1; i5 >= 0; i5--) {
                    View i6 = this.s[i5].i(m1, i3);
                    if (!(i6 == null || i6 == t2)) {
                        return i6;
                    }
                }
            } else {
                for (int i7 = 0; i7 < this.r; i7++) {
                    View i8 = this.s[i7].i(m1, i3);
                    if (!(i8 == null || i8 == t2)) {
                        return i8;
                    }
                }
            }
            boolean z2 = (this.y ^ true) == (i3 == -1);
            View u2 = u(z2 ? fVar.e() : fVar.f());
            if (!(u2 == null || u2 == t2)) {
                return u2;
            }
            if (u1(i3)) {
                for (int i9 = this.r - 1; i9 >= 0; i9--) {
                    if (i9 != fVar.f284e) {
                        f[] fVarArr = this.s;
                        View u3 = u(z2 ? fVarArr[i9].e() : fVarArr[i9].f());
                        if (!(u3 == null || u3 == t2)) {
                            return u3;
                        }
                    }
                }
            } else {
                for (int i10 = 0; i10 < this.r; i10++) {
                    f[] fVarArr2 = this.s;
                    View u4 = u(z2 ? fVarArr2[i10].e() : fVarArr2[i10].f());
                    if (!(u4 == null || u4 == t2)) {
                        return u4;
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

    public final void j1(RecyclerView.t tVar, RecyclerView.y yVar, boolean z2) {
        int g2;
        int n1 = n1(Integer.MIN_VALUE);
        if (n1 != Integer.MIN_VALUE && (g2 = this.t.g() - n1) > 0) {
            int i2 = g2 - (-A1(-g2, tVar, yVar));
            if (z2 && i2 > 0) {
                this.t.p(i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void k0(AccessibilityEvent accessibilityEvent) {
        RecyclerView.t tVar = this.b.c;
        l0(accessibilityEvent);
        if (z() > 0) {
            View i1 = i1(false);
            View h1 = h1(false);
            if (i1 != null && h1 != null) {
                int S = S(i1);
                int S2 = S(h1);
                if (S < S2) {
                    accessibilityEvent.setFromIndex(S);
                    accessibilityEvent.setToIndex(S2);
                    return;
                }
                accessibilityEvent.setFromIndex(S2);
                accessibilityEvent.setToIndex(S);
            }
        }
    }

    public final void k1(RecyclerView.t tVar, RecyclerView.y yVar, boolean z2) {
        int k2;
        int o1 = o1(Integer.MAX_VALUE);
        if (o1 != Integer.MAX_VALUE && (k2 = o1 - this.t.k()) > 0) {
            int A1 = k2 - A1(k2, tVar, yVar);
            if (z2 && A1 > 0) {
                this.t.p(-A1);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int l(RecyclerView.y yVar) {
        return d1(yVar);
    }

    public int l1() {
        if (z() == 0) {
            return 0;
        }
        return S(y(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int m(RecyclerView.y yVar) {
        return e1(yVar);
    }

    public int m1() {
        int z2 = z();
        if (z2 == 0) {
            return 0;
        }
        return S(y(z2 - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int n(RecyclerView.y yVar) {
        return f1(yVar);
    }

    public final int n1(int i2) {
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
    public int o(RecyclerView.y yVar) {
        return d1(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void o0(RecyclerView.t tVar, RecyclerView.y yVar, View view, e.i.i.x.b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            n0(view, bVar);
            return;
        }
        c cVar = (c) layoutParams;
        if (this.v == 0) {
            f fVar = cVar.f272e;
            i5 = fVar == null ? -1 : fVar.f284e;
            i4 = 1;
            i3 = -1;
            i2 = -1;
        } else {
            f fVar2 = cVar.f272e;
            i3 = fVar2 == null ? -1 : fVar2.f284e;
            i5 = -1;
            i4 = -1;
            i2 = 1;
        }
        bVar.j(b.c.a(i5, i4, i3, i2, false, false));
    }

    public final int o1(int i2) {
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
    public int p(RecyclerView.y yVar) {
        return e1(yVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    public final void p1(int i2, int i3, int i4) {
        int i5;
        int i6;
        int m1 = this.z ? m1() : l1();
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
            if (i6 <= m1) {
                if (i5 <= (this.z ? l1() : m1())) {
                    M0();
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
        if (i6 <= m1) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int q(RecyclerView.y yVar) {
        return f1(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void q0(RecyclerView recyclerView, int i2, int i3) {
        p1(i2, i3, 1);
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
    public View q1() {
        int i2;
        boolean z2;
        View view;
        int z3 = z() - 1;
        BitSet bitSet = new BitSet(this.r);
        bitSet.set(0, this.r, true);
        int i3 = -1;
        char c2 = (this.v != 1 || !r1()) ? (char) 65535 : 1;
        if (this.z) {
            i2 = -1;
        } else {
            i2 = z3 + 1;
            z3 = 0;
        }
        if (z3 < i2) {
            i3 = 1;
        }
        while (z3 != i2) {
            View y2 = y(z3);
            c cVar = (c) y2.getLayoutParams();
            if (bitSet.get(cVar.f272e.f284e)) {
                f fVar = cVar.f272e;
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
                        return y2;
                    }
                    bitSet.clear(cVar.f272e.f284e);
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
            int i6 = z3 + i3;
            if (i6 != i2) {
                View y3 = y(i6);
                if (this.z) {
                    int b2 = this.t.b(y2);
                    int b3 = this.t.b(y3);
                    if (b2 < b3) {
                        return y2;
                    }
                } else {
                    int e2 = this.t.e(y2);
                    int e3 = this.t.e(y3);
                    if (e2 > e3) {
                        return y2;
                    }
                }
                boolean z4 = true;
                if (!z4) {
                    continue;
                } else {
                    if ((cVar.f272e.f284e - ((c) y3.getLayoutParams()).f272e.f284e < 0) != (c2 < 0)) {
                        return y2;
                    }
                }
            }
            z3 += i3;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void r0(RecyclerView recyclerView) {
        this.D.a();
        M0();
    }

    public boolean r1() {
        return L() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void s0(RecyclerView recyclerView, int i2, int i3, int i4) {
        p1(i2, i3, 8);
    }

    public final void s1(View view, int i2, int i3, boolean z2) {
        e(view, this.J);
        c cVar = (c) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.J;
        int F1 = F1(i2, i4 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i5 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.J;
        int F12 = F1(i3, i5 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z2 ? X0(view, F1, F12, cVar) : V0(view, F1, F12, cVar)) {
            view.measure(F1, F12);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void t0(RecyclerView recyclerView, int i2, int i3) {
        p1(i2, i3, 2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:234:0x03f9, code lost:
        if (c1() != false) goto L_0x03fd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01ac  */
    public final void t1(RecyclerView.t tVar, RecyclerView.y yVar, boolean z2) {
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
            G0(tVar);
            bVar.b();
            return;
        }
        boolean z5 = true;
        boolean z6 = (bVar.f269e && this.B == -1 && this.H == null) ? false : true;
        if (z6) {
            bVar.b();
            e eVar2 = this.H;
            if (eVar2 != null) {
                int i8 = eVar2.f275d;
                if (i8 > 0) {
                    if (i8 == this.r) {
                        for (int i9 = 0; i9 < this.r; i9++) {
                            this.s[i9].d();
                            e eVar3 = this.H;
                            int i10 = eVar3.f276e[i9];
                            if (i10 != Integer.MIN_VALUE) {
                                i10 += eVar3.f281j ? this.t.g() : this.t.k();
                            }
                            f fVar = this.s[i9];
                            fVar.b = i10;
                            fVar.c = i10;
                        }
                    } else {
                        eVar2.f276e = null;
                        eVar2.f275d = 0;
                        eVar2.f277f = 0;
                        eVar2.f278g = null;
                        eVar2.f279h = null;
                        eVar2.b = eVar2.c;
                    }
                }
                e eVar4 = this.H;
                this.G = eVar4.f282k;
                boolean z7 = eVar4.f280i;
                d(null);
                e eVar5 = this.H;
                if (!(eVar5 == null || eVar5.f280i == z7)) {
                    eVar5.f280i = z7;
                }
                this.y = z7;
                M0();
                z1();
                e eVar6 = this.H;
                int i11 = eVar6.b;
                if (i11 != -1) {
                    this.B = i11;
                    z4 = eVar6.f281j;
                } else {
                    z4 = this.z;
                }
                bVar.c = z4;
                if (eVar6.f277f > 1) {
                    d dVar = this.D;
                    dVar.a = eVar6.f278g;
                    dVar.b = eVar6.f279h;
                }
            } else {
                z1();
                bVar.c = this.z;
            }
            if (!yVar.f262g && (i3 = this.B) != -1) {
                if (i3 < 0 || i3 >= yVar.b()) {
                    this.B = -1;
                    this.C = Integer.MIN_VALUE;
                } else {
                    e eVar7 = this.H;
                    if (eVar7 == null || eVar7.b == -1 || eVar7.f275d < 1) {
                        View u2 = u(this.B);
                        if (u2 != null) {
                            bVar.a = this.z ? m1() : l1();
                            if (this.C != Integer.MIN_VALUE) {
                                if (bVar.c) {
                                    i6 = this.t.g() - this.C;
                                    i7 = this.t.b(u2);
                                } else {
                                    i6 = this.t.k() + this.C;
                                    i7 = this.t.e(u2);
                                }
                                i4 = i6 - i7;
                            } else {
                                if (this.t.c(u2) > this.t.l()) {
                                    i5 = bVar.c ? this.t.g() : this.t.k();
                                } else {
                                    int e2 = this.t.e(u2) - this.t.k();
                                    if (e2 < 0) {
                                        i5 = -e2;
                                    } else {
                                        i4 = this.t.g() - this.t.b(u2);
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
                                bVar.c = b1(i12) == 1;
                                bVar.a();
                            } else {
                                bVar.b = bVar.c ? StaggeredGridLayoutManager.this.t.g() - i13 : StaggeredGridLayoutManager.this.t.k() + i13;
                            }
                            bVar.f268d = true;
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
                            int z9 = z();
                            while (true) {
                                z9--;
                                if (z9 < 0) {
                                    break;
                                }
                                i2 = S(y(z9));
                                if (i2 >= 0 && i2 < b2) {
                                    break;
                                }
                            }
                        } else {
                            int z10 = z();
                            int i14 = 0;
                            while (true) {
                                if (i14 >= z10) {
                                    break;
                                }
                                int S = S(y(i14));
                                if (S >= 0 && S < b2) {
                                    i2 = S;
                                    break;
                                }
                                i14++;
                            }
                        }
                        i2 = 0;
                        bVar.a = i2;
                        bVar.b = Integer.MIN_VALUE;
                    }
                    bVar.f269e = true;
                }
            }
            z3 = false;
            if (!z3) {
            }
            bVar.f269e = true;
        }
        if (this.H == null && this.B == -1 && !(bVar.c == this.F && r1() == this.G)) {
            this.D.a();
            bVar.f268d = true;
        }
        if (z() > 0 && ((eVar = this.H) == null || eVar.f275d < 1)) {
            if (bVar.f268d) {
                for (int i15 = 0; i15 < this.r; i15++) {
                    this.s[i15].d();
                    int i16 = bVar.b;
                    if (i16 != Integer.MIN_VALUE) {
                        f fVar2 = this.s[i15];
                        fVar2.b = i16;
                        fVar2.c = i16;
                    }
                }
            } else if (z6 || this.K.f270f == null) {
                for (int i17 = 0; i17 < this.r; i17++) {
                    f fVar3 = this.s[i17];
                    boolean z11 = this.z;
                    int i18 = bVar.b;
                    int h2 = z11 ? fVar3.h(Integer.MIN_VALUE) : fVar3.k(Integer.MIN_VALUE);
                    fVar3.d();
                    if (h2 != Integer.MIN_VALUE && ((!z11 || h2 >= StaggeredGridLayoutManager.this.t.g()) && (z11 || h2 <= StaggeredGridLayoutManager.this.t.k()))) {
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
                int[] iArr = bVar2.f270f;
                if (iArr == null || iArr.length < length) {
                    bVar2.f270f = new int[StaggeredGridLayoutManager.this.s.length];
                }
                for (int i19 = 0; i19 < length; i19++) {
                    bVar2.f270f[i19] = fVarArr[i19].k(Integer.MIN_VALUE);
                }
            } else {
                for (int i20 = 0; i20 < this.r; i20++) {
                    f fVar4 = this.s[i20];
                    fVar4.d();
                    int i21 = this.K.f270f[i20];
                    fVar4.b = i21;
                    fVar4.c = i21;
                }
            }
        }
        r(tVar);
        this.x.a = false;
        int l2 = this.u.l();
        this.w = l2 / this.r;
        this.I = View.MeasureSpec.makeMeasureSpec(l2, this.u.i());
        D1(bVar.a, yVar);
        if (bVar.c) {
            B1(-1);
            g1(tVar, this.x, yVar);
            B1(1);
        } else {
            B1(1);
            g1(tVar, this.x, yVar);
            B1(-1);
        }
        e.s.a.m mVar = this.x;
        mVar.c = bVar.a + mVar.f1846d;
        g1(tVar, mVar, yVar);
        if (this.u.i() != 1073741824) {
            float f2 = 0.0f;
            int z12 = z();
            for (int i22 = 0; i22 < z12; i22++) {
                View y2 = y(i22);
                float c2 = (float) this.u.c(y2);
                if (c2 >= f2) {
                    Objects.requireNonNull((c) y2.getLayoutParams());
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
                for (int i24 = 0; i24 < z12; i24++) {
                    View y3 = y(i24);
                    c cVar = (c) y3.getLayoutParams();
                    Objects.requireNonNull(cVar);
                    if (!r1() || this.v != 1) {
                        int i25 = cVar.f272e.f284e;
                        int i26 = this.v;
                        int i27 = (this.w * i25) - (i25 * i23);
                        if (i26 == 1) {
                            y3.offsetLeftAndRight(i27);
                        } else {
                            y3.offsetTopAndBottom(i27);
                        }
                    } else {
                        int i28 = this.r;
                        int i29 = cVar.f272e.f284e;
                        y3.offsetLeftAndRight(((-((i28 - 1) - i29)) * this.w) - ((-((i28 - 1) - i29)) * i23));
                    }
                }
            }
        }
        if (z() > 0) {
            if (this.z) {
                j1(tVar, yVar, true);
                k1(tVar, yVar, false);
            } else {
                k1(tVar, yVar, true);
                j1(tVar, yVar, false);
            }
        }
        if (z2 && !yVar.f262g) {
            if ((this.E == 0 || z() <= 0 || q1() == null) ? false : true) {
                Runnable runnable = this.N;
                RecyclerView recyclerView = this.b;
                if (recyclerView != null) {
                    recyclerView.removeCallbacks(runnable);
                }
            }
        }
        z5 = false;
        if (yVar.f262g) {
            this.K.b();
        }
        this.F = bVar.c;
        this.G = r1();
        if (z5) {
            this.K.b();
            t1(tVar, yVar, false);
        }
    }

    public final boolean u1(int i2) {
        if (this.v == 0) {
            return (i2 == -1) != this.z;
        }
        return ((i2 == -1) == this.z) == r1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n v() {
        return this.v == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void v0(RecyclerView recyclerView, int i2, int i3, Object obj) {
        p1(i2, i3, 4);
    }

    public void v1(int i2, RecyclerView.y yVar) {
        int i3;
        int i4;
        if (i2 > 0) {
            i4 = m1();
            i3 = 1;
        } else {
            i4 = l1();
            i3 = -1;
        }
        this.x.a = true;
        D1(i4, yVar);
        B1(i3);
        e.s.a.m mVar = this.x;
        mVar.c = i4 + mVar.f1846d;
        mVar.b = Math.abs(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n w(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void w0(RecyclerView.t tVar, RecyclerView.y yVar) {
        t1(tVar, yVar, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (r6.f1847e == -1) goto L_0x0013;
     */
    public final void w1(RecyclerView.t tVar, e.s.a.m mVar) {
        int min;
        int min2;
        if (mVar.a && !mVar.f1851i) {
            if (mVar.b != 0) {
                int i2 = 1;
                if (mVar.f1847e == -1) {
                    int i3 = mVar.f1848f;
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
                        min2 = mVar.f1849g - Math.min(i4, mVar.b);
                        x1(tVar, min2);
                    }
                } else {
                    int i5 = mVar.f1849g;
                    int h2 = this.s[0].h(i5);
                    while (i2 < this.r) {
                        int h3 = this.s[i2].h(i5);
                        if (h3 < h2) {
                            h2 = h3;
                        }
                        i2++;
                    }
                    int i6 = h2 - mVar.f1849g;
                    if (i6 >= 0) {
                        min = Math.min(i6, mVar.b) + mVar.f1848f;
                        y1(tVar, min);
                        return;
                    }
                    min = mVar.f1848f;
                    y1(tVar, min);
                    return;
                }
            }
            min2 = mVar.f1849g;
            x1(tVar, min2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n x(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void x0(RecyclerView.y yVar) {
        this.B = -1;
        this.C = Integer.MIN_VALUE;
        this.H = null;
        this.K.b();
    }

    public final void x1(RecyclerView.t tVar, int i2) {
        for (int z2 = z() - 1; z2 >= 0; z2--) {
            View y2 = y(z2);
            if (this.t.e(y2) >= i2 && this.t.o(y2) >= i2) {
                c cVar = (c) y2.getLayoutParams();
                Objects.requireNonNull(cVar);
                if (cVar.f272e.a.size() != 1) {
                    cVar.f272e.l();
                    I0(y2, tVar);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void y1(RecyclerView.t tVar, int i2) {
        while (z() > 0) {
            View y2 = y(0);
            if (this.t.b(y2) <= i2 && this.t.n(y2) <= i2) {
                c cVar = (c) y2.getLayoutParams();
                Objects.requireNonNull(cVar);
                if (cVar.f272e.a.size() != 1) {
                    cVar.f272e.m();
                    I0(y2, tVar);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void z1() {
        this.z = (this.v == 1 || !r1()) ? this.y : !this.y;
    }
}
