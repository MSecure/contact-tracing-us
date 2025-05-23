package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
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
import b.b.k.i;
import b.i.l.w.b;
import b.q.d.a0;
import b.q.d.r;
import b.q.d.s;
import b.q.d.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    public boolean A;
    public BitSet B;
    public int C;
    public int D;
    public d E;
    public int F;
    public boolean G;
    public boolean H;
    public e I;
    public int J;
    public final Rect K;
    public final b L;
    public boolean M;
    public boolean N;
    public int[] O;
    public final Runnable P;
    public int s = -1;
    public f[] t;
    public a0 u;
    public a0 v;
    public int w;
    public int x;
    public final s y;
    public boolean z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            StaggeredGridLayoutManager.this.Y0();
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f257a;

        /* renamed from: b  reason: collision with root package name */
        public int f258b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f259c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f260d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f261e;
        public int[] f;

        public b() {
            b();
        }

        public void a() {
            this.f258b = this.f259c ? StaggeredGridLayoutManager.this.u.g() : StaggeredGridLayoutManager.this.u.k();
        }

        public void b() {
            this.f257a = -1;
            this.f258b = Integer.MIN_VALUE;
            this.f259c = false;
            this.f260d = false;
            this.f261e = false;
            int[] iArr = this.f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    public static class c extends RecyclerView.p {

        /* renamed from: e  reason: collision with root package name */
        public f f262e;
        public boolean f;

        public c(int i, int i2) {
            super(i, i2);
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

        /* renamed from: a  reason: collision with root package name */
        public int[] f263a;

        /* renamed from: b  reason: collision with root package name */
        public List<a> f264b;

        @SuppressLint({"BanParcelableUsage"})
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new C0003a();

            /* renamed from: b  reason: collision with root package name */
            public int f265b;

            /* renamed from: c  reason: collision with root package name */
            public int f266c;

            /* renamed from: d  reason: collision with root package name */
            public int[] f267d;

            /* renamed from: e  reason: collision with root package name */
            public boolean f268e;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$d$a$a  reason: collision with other inner class name */
            public static class C0003a implements Parcelable.Creator<a> {
                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public a createFromParcel(Parcel parcel) {
                    return new a(parcel);
                }

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public a[] newArray(int i) {
                    return new a[i];
                }
            }

            public a() {
            }

            public a(Parcel parcel) {
                this.f265b = parcel.readInt();
                this.f266c = parcel.readInt();
                this.f268e = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f267d = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                StringBuilder g = c.a.a.a.a.g("FullSpanItem{mPosition=");
                g.append(this.f265b);
                g.append(", mGapDir=");
                g.append(this.f266c);
                g.append(", mHasUnwantedGapAfter=");
                g.append(this.f268e);
                g.append(", mGapPerSpan=");
                g.append(Arrays.toString(this.f267d));
                g.append('}');
                return g.toString();
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f265b);
                parcel.writeInt(this.f266c);
                parcel.writeInt(this.f268e ? 1 : 0);
                int[] iArr = this.f267d;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f267d);
            }
        }

        public void a(a aVar) {
            if (this.f264b == null) {
                this.f264b = new ArrayList();
            }
            int size = this.f264b.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.f264b.get(i);
                if (aVar2.f265b == aVar.f265b) {
                    this.f264b.remove(i);
                }
                if (aVar2.f265b >= aVar.f265b) {
                    this.f264b.add(i, aVar);
                    return;
                }
            }
            this.f264b.add(aVar);
        }

        public void b() {
            int[] iArr = this.f263a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f264b = null;
        }

        public void c(int i) {
            int[] iArr = this.f263a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i, 10) + 1)];
                this.f263a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int length = iArr.length;
                while (length <= i) {
                    length *= 2;
                }
                int[] iArr3 = new int[length];
                this.f263a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f263a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int d(int i) {
            List<a> list = this.f264b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f264b.get(size).f265b >= i) {
                        this.f264b.remove(size);
                    }
                }
            }
            return g(i);
        }

        public a e(int i, int i2, int i3, boolean z) {
            List<a> list = this.f264b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.f264b.get(i4);
                int i5 = aVar.f265b;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || aVar.f266c == i3 || (z && aVar.f268e))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i) {
            List<a> list = this.f264b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f264b.get(size);
                if (aVar.f265b == i) {
                    return aVar;
                }
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
        public int g(int i) {
            int i2;
            int[] iArr = this.f263a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            if (this.f264b != null) {
                a f = f(i);
                if (f != null) {
                    this.f264b.remove(f);
                }
                int size = this.f264b.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        i3 = -1;
                        break;
                    } else if (this.f264b.get(i3).f265b >= i) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 != -1) {
                    this.f264b.remove(i3);
                    i2 = this.f264b.get(i3).f265b;
                    if (i2 != -1) {
                        int[] iArr2 = this.f263a;
                        Arrays.fill(iArr2, i, iArr2.length, -1);
                        return this.f263a.length;
                    }
                    int i4 = i2 + 1;
                    Arrays.fill(this.f263a, i, i4, -1);
                    return i4;
                }
            }
            i2 = -1;
            if (i2 != -1) {
            }
        }

        public void h(int i, int i2) {
            int[] iArr = this.f263a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                c(i3);
                int[] iArr2 = this.f263a;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.f263a, i, i3, -1);
                List<a> list = this.f264b;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        a aVar = this.f264b.get(size);
                        int i4 = aVar.f265b;
                        if (i4 >= i) {
                            aVar.f265b = i4 + i2;
                        }
                    }
                }
            }
        }

        public void i(int i, int i2) {
            int[] iArr = this.f263a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                c(i3);
                int[] iArr2 = this.f263a;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.f263a;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
                List<a> list = this.f264b;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        a aVar = this.f264b.get(size);
                        int i4 = aVar.f265b;
                        if (i4 >= i) {
                            if (i4 < i3) {
                                this.f264b.remove(size);
                            } else {
                                aVar.f265b = i4 - i2;
                            }
                        }
                    }
                }
            }
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f269b;

        /* renamed from: c  reason: collision with root package name */
        public int f270c;

        /* renamed from: d  reason: collision with root package name */
        public int f271d;

        /* renamed from: e  reason: collision with root package name */
        public int[] f272e;
        public int f;
        public int[] g;
        public List<d.a> h;
        public boolean i;
        public boolean j;
        public boolean k;

        public static class a implements Parcelable.Creator<e> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public e[] newArray(int i) {
                return new e[i];
            }
        }

        public e() {
        }

        public e(Parcel parcel) {
            this.f269b = parcel.readInt();
            this.f270c = parcel.readInt();
            int readInt = parcel.readInt();
            this.f271d = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f272e = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.g = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z = false;
            this.i = parcel.readInt() == 1;
            this.j = parcel.readInt() == 1;
            this.k = parcel.readInt() == 1 ? true : z;
            this.h = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.f271d = eVar.f271d;
            this.f269b = eVar.f269b;
            this.f270c = eVar.f270c;
            this.f272e = eVar.f272e;
            this.f = eVar.f;
            this.g = eVar.g;
            this.i = eVar.i;
            this.j = eVar.j;
            this.k = eVar.k;
            this.h = eVar.h;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f269b);
            parcel.writeInt(this.f270c);
            parcel.writeInt(this.f271d);
            if (this.f271d > 0) {
                parcel.writeIntArray(this.f272e);
            }
            parcel.writeInt(this.f);
            if (this.f > 0) {
                parcel.writeIntArray(this.g);
            }
            parcel.writeInt(this.i ? 1 : 0);
            parcel.writeInt(this.j ? 1 : 0);
            parcel.writeInt(this.k ? 1 : 0);
            parcel.writeList(this.h);
        }
    }

    public class f {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<View> f273a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        public int f274b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        public int f275c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        public int f276d = 0;

        /* renamed from: e  reason: collision with root package name */
        public final int f277e;

        public f(int i) {
            this.f277e = i;
        }

        public void a(View view) {
            c j = j(view);
            j.f262e = this;
            this.f273a.add(view);
            this.f275c = Integer.MIN_VALUE;
            if (this.f273a.size() == 1) {
                this.f274b = Integer.MIN_VALUE;
            }
            if (j.c() || j.b()) {
                this.f276d = StaggeredGridLayoutManager.this.u.c(view) + this.f276d;
            }
        }

        public void b() {
            d.a f2;
            ArrayList<View> arrayList = this.f273a;
            View view = arrayList.get(arrayList.size() - 1);
            c j = j(view);
            this.f275c = StaggeredGridLayoutManager.this.u.b(view);
            if (j.f && (f2 = StaggeredGridLayoutManager.this.E.f(j.a())) != null && f2.f266c == 1) {
                int i = this.f275c;
                int i2 = this.f277e;
                int[] iArr = f2.f267d;
                this.f275c = i + (iArr == null ? 0 : iArr[i2]);
            }
        }

        public void c() {
            d.a f2;
            int i = 0;
            View view = this.f273a.get(0);
            c j = j(view);
            this.f274b = StaggeredGridLayoutManager.this.u.e(view);
            if (j.f && (f2 = StaggeredGridLayoutManager.this.E.f(j.a())) != null && f2.f266c == -1) {
                int i2 = this.f274b;
                int i3 = this.f277e;
                int[] iArr = f2.f267d;
                if (iArr != null) {
                    i = iArr[i3];
                }
                this.f274b = i2 - i;
            }
        }

        public void d() {
            this.f273a.clear();
            this.f274b = Integer.MIN_VALUE;
            this.f275c = Integer.MIN_VALUE;
            this.f276d = 0;
        }

        public int e() {
            int i;
            int i2;
            if (StaggeredGridLayoutManager.this.z) {
                i2 = this.f273a.size() - 1;
                i = -1;
            } else {
                i2 = 0;
                i = this.f273a.size();
            }
            return g(i2, i, true);
        }

        public int f() {
            int i;
            int i2;
            if (StaggeredGridLayoutManager.this.z) {
                i2 = 0;
                i = this.f273a.size();
            } else {
                i2 = this.f273a.size() - 1;
                i = -1;
            }
            return g(i2, i, true);
        }

        public int g(int i, int i2, boolean z) {
            int k = StaggeredGridLayoutManager.this.u.k();
            int g = StaggeredGridLayoutManager.this.u.g();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f273a.get(i);
                int e2 = StaggeredGridLayoutManager.this.u.e(view);
                int b2 = StaggeredGridLayoutManager.this.u.b(view);
                boolean z2 = false;
                boolean z3 = !z ? e2 < g : e2 <= g;
                if (!z ? b2 > k : b2 >= k) {
                    z2 = true;
                }
                if (z3 && z2 && (e2 < k || b2 > g)) {
                    return StaggeredGridLayoutManager.this.P(view);
                }
                i += i3;
            }
            return -1;
        }

        public int h(int i) {
            int i2 = this.f275c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f273a.size() == 0) {
                return i;
            }
            b();
            return this.f275c;
        }

        public View i(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f273a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f273a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.z && staggeredGridLayoutManager.P(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.z && staggeredGridLayoutManager2.P(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f273a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f273a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.z && staggeredGridLayoutManager3.P(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.z && staggeredGridLayoutManager4.P(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        public c j(View view) {
            return (c) view.getLayoutParams();
        }

        public int k(int i) {
            int i2 = this.f274b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f273a.size() == 0) {
                return i;
            }
            c();
            return this.f274b;
        }

        public void l() {
            int size = this.f273a.size();
            View remove = this.f273a.remove(size - 1);
            c j = j(remove);
            j.f262e = null;
            if (j.c() || j.b()) {
                this.f276d -= StaggeredGridLayoutManager.this.u.c(remove);
            }
            if (size == 1) {
                this.f274b = Integer.MIN_VALUE;
            }
            this.f275c = Integer.MIN_VALUE;
        }

        public void m() {
            View remove = this.f273a.remove(0);
            c j = j(remove);
            j.f262e = null;
            if (this.f273a.size() == 0) {
                this.f275c = Integer.MIN_VALUE;
            }
            if (j.c() || j.b()) {
                this.f276d -= StaggeredGridLayoutManager.this.u.c(remove);
            }
            this.f274b = Integer.MIN_VALUE;
        }

        public void n(View view) {
            c j = j(view);
            j.f262e = this;
            this.f273a.add(0, view);
            this.f274b = Integer.MIN_VALUE;
            if (this.f273a.size() == 1) {
                this.f275c = Integer.MIN_VALUE;
            }
            if (j.c() || j.b()) {
                this.f276d = StaggeredGridLayoutManager.this.u.c(view) + this.f276d;
            }
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.z = false;
        this.A = false;
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.E = new d();
        this.F = 2;
        this.K = new Rect();
        this.L = new b();
        this.M = false;
        this.N = true;
        this.P = new a();
        RecyclerView.o.d Q = RecyclerView.o.Q(context, attributeSet, i, i2);
        int i3 = Q.f225a;
        if (i3 == 0 || i3 == 1) {
            d(null);
            if (i3 != this.w) {
                this.w = i3;
                a0 a0Var = this.u;
                this.u = this.v;
                this.v = a0Var;
                I0();
            }
            int i4 = Q.f226b;
            d(null);
            if (i4 != this.s) {
                this.E.b();
                I0();
                this.s = i4;
                this.B = new BitSet(this.s);
                this.t = new f[this.s];
                for (int i5 = 0; i5 < this.s; i5++) {
                    this.t[i5] = new f(i5);
                }
                I0();
            }
            boolean z2 = Q.f227c;
            d(null);
            e eVar = this.I;
            if (!(eVar == null || eVar.i == z2)) {
                eVar.i = z2;
            }
            this.z = z2;
            I0();
            this.y = new s();
            this.u = a0.a(this, this.w);
            this.v = a0.a(this, 1 - this.w);
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int A(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.w == 1 ? this.s : super.A(vVar, a0Var);
    }

    public final void A1(f fVar, int i, int i2) {
        int i3 = fVar.f276d;
        if (i == -1) {
            int i4 = fVar.f274b;
            if (i4 == Integer.MIN_VALUE) {
                fVar.c();
                i4 = fVar.f274b;
            }
            if (i4 + i3 > i2) {
                return;
            }
        } else {
            int i5 = fVar.f275c;
            if (i5 == Integer.MIN_VALUE) {
                fVar.b();
                i5 = fVar.f275c;
            }
            if (i5 - i3 < i2) {
                return;
            }
        }
        this.B.set(fVar.f277e, false);
    }

    public final int B1(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int J0(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return w1(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(int i) {
        e eVar = this.I;
        if (!(eVar == null || eVar.f269b == i)) {
            eVar.f272e = null;
            eVar.f271d = 0;
            eVar.f269b = -1;
            eVar.f270c = -1;
        }
        this.C = i;
        this.D = Integer.MIN_VALUE;
        I0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int L0(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return w1(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int N2 = N() + M();
        int L2 = L() + O();
        if (this.w == 1) {
            i4 = RecyclerView.o.h(i2, rect.height() + L2, J());
            i3 = RecyclerView.o.h(i, (this.x * this.s) + N2, K());
        } else {
            i3 = RecyclerView.o.h(i, rect.width() + N2, K());
            i4 = RecyclerView.o.h(i2, (this.x * this.s) + L2, J());
        }
        this.f219b.setMeasuredDimension(i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int R(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.w == 0 ? this.s : super.R(vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean U() {
        return this.F != 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i) {
        t tVar = new t(recyclerView.getContext());
        tVar.f246a = i;
        V0(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean W0() {
        return this.I == null;
    }

    public final int X0(int i) {
        if (y() == 0) {
            return this.A ? 1 : -1;
        }
        return (i < h1()) != this.A ? -1 : 1;
    }

    public boolean Y0() {
        int i;
        int i2;
        if (y() == 0 || this.F == 0 || !this.i) {
            return false;
        }
        if (this.A) {
            i2 = i1();
            i = h1();
        } else {
            i2 = h1();
            i = i1();
        }
        if (i2 == 0 && m1() != null) {
            this.E.b();
        } else if (!this.M) {
            return false;
        } else {
            int i3 = this.A ? -1 : 1;
            int i4 = i + 1;
            d.a e2 = this.E.e(i2, i4, i3, true);
            if (e2 == null) {
                this.M = false;
                this.E.d(i4);
                return false;
            }
            d.a e3 = this.E.e(i2, e2.f265b, i3 * -1, true);
            if (e3 == null) {
                this.E.d(e2.f265b);
            } else {
                this.E.d(e3.f265b + 1);
            }
        }
        this.h = true;
        I0();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z(int i) {
        RecyclerView recyclerView = this.f219b;
        if (recyclerView != null) {
            recyclerView.offsetChildrenHorizontal(i);
        }
        for (int i2 = 0; i2 < this.s; i2++) {
            f fVar = this.t[i2];
            int i3 = fVar.f274b;
            if (i3 != Integer.MIN_VALUE) {
                fVar.f274b = i3 + i;
            }
            int i4 = fVar.f275c;
            if (i4 != Integer.MIN_VALUE) {
                fVar.f275c = i4 + i;
            }
        }
    }

    public final int Z0(RecyclerView.a0 a0Var) {
        if (y() == 0) {
            return 0;
        }
        return i.j.x(a0Var, this.u, e1(!this.N), d1(!this.N), this, this.N);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i) {
        int X0 = X0(i);
        PointF pointF = new PointF();
        if (X0 == 0) {
            return null;
        }
        if (this.w == 0) {
            pointF.x = (float) X0;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) X0;
        }
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a0(int i) {
        RecyclerView recyclerView = this.f219b;
        if (recyclerView != null) {
            recyclerView.offsetChildrenVertical(i);
        }
        for (int i2 = 0; i2 < this.s; i2++) {
            f fVar = this.t[i2];
            int i3 = fVar.f274b;
            if (i3 != Integer.MIN_VALUE) {
                fVar.f274b = i3 + i;
            }
            int i4 = fVar.f275c;
            if (i4 != Integer.MIN_VALUE) {
                fVar.f275c = i4 + i;
            }
        }
    }

    public final int a1(RecyclerView.a0 a0Var) {
        if (y() == 0) {
            return 0;
        }
        return i.j.y(a0Var, this.u, e1(!this.N), d1(!this.N), this, this.N, this.A);
    }

    public final int b1(RecyclerView.a0 a0Var) {
        if (y() == 0) {
            return 0;
        }
        return i.j.z(a0Var, this.u, e1(!this.N), d1(!this.N), this, this.N);
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x02ed  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0335  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0351  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0357  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01cf  */
    public final int c1(RecyclerView.v vVar, s sVar, RecyclerView.a0 a0Var) {
        f fVar;
        int i;
        int i2;
        boolean z2;
        int i3;
        int i4;
        boolean z3;
        c cVar;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z9 = false;
        boolean z10 = true;
        this.B.set(0, this.s, true);
        int i10 = this.y.i ? sVar.f1591e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : sVar.f1591e == 1 ? sVar.g + sVar.f1588b : sVar.f - sVar.f1588b;
        y1(sVar.f1591e, i10);
        int g = this.A ? this.u.g() : this.u.k();
        boolean z11 = false;
        while (true) {
            int i11 = sVar.f1589c;
            if (((i11 < 0 || i11 >= a0Var.b()) ? z9 : z10) && (this.y.i || !this.B.isEmpty())) {
                View view = vVar.k(sVar.f1589c, z9, RecyclerView.FOREVER_NS).itemView;
                sVar.f1589c += sVar.f1590d;
                c cVar2 = (c) view.getLayoutParams();
                int a2 = cVar2.a();
                int[] iArr = this.E.f263a;
                int i12 = (iArr == null || a2 >= iArr.length) ? -1 : iArr[a2];
                boolean z12 = i12 == -1 ? z10 : z9;
                if (z12) {
                    if (cVar2.f) {
                        f[] fVarArr = this.t;
                        char c2 = z9 ? 1 : 0;
                        char c3 = z9 ? 1 : 0;
                        char c4 = z9 ? 1 : 0;
                        fVar = fVarArr[c2];
                    } else {
                        if (q1(sVar.f1591e)) {
                            int i13 = this.s;
                            int i14 = z10 ? 1 : 0;
                            int i15 = z10 ? 1 : 0;
                            int i16 = z10 ? 1 : 0;
                            i9 = i13 - i14;
                            i8 = -1;
                            i7 = -1;
                        } else {
                            i8 = this.s;
                            int i17 = z9 ? 1 : 0;
                            Object[] objArr = z9 ? 1 : 0;
                            Object[] objArr2 = z9 ? 1 : 0;
                            i9 = i17;
                            int i18 = z10 ? 1 : 0;
                            Object[] objArr3 = z10 ? 1 : 0;
                            Object[] objArr4 = z10 ? 1 : 0;
                            i7 = i18;
                        }
                        f fVar2 = null;
                        if (sVar.f1591e == z10) {
                            int k = this.u.k();
                            int i19 = Integer.MAX_VALUE;
                            while (i9 != i8) {
                                f fVar3 = this.t[i9];
                                int h = fVar3.h(k);
                                if (h < i19) {
                                    fVar2 = fVar3;
                                    i19 = h;
                                }
                                i9 += i7;
                            }
                        } else {
                            int g2 = this.u.g();
                            int i20 = Integer.MIN_VALUE;
                            while (i9 != i8) {
                                f fVar4 = this.t[i9];
                                int k2 = fVar4.k(g2);
                                if (k2 > i20) {
                                    fVar2 = fVar4;
                                    i20 = k2;
                                }
                                i9 += i7;
                            }
                        }
                        fVar = fVar2;
                    }
                    d dVar = this.E;
                    dVar.c(a2);
                    dVar.f263a[a2] = fVar.f277e;
                } else {
                    fVar = this.t[i12];
                }
                cVar2.f262e = fVar;
                if (sVar.f1591e == z10) {
                    c(view, -1, false);
                } else {
                    c(view, 0, false);
                }
                if (cVar2.f) {
                    if (this.w == z10) {
                        i6 = this.J;
                    } else {
                        o1(view, RecyclerView.o.z(this.q, this.o, N() + M(), ((ViewGroup.MarginLayoutParams) cVar2).width, z10), this.J, false);
                        if (sVar.f1591e == z10) {
                            int j1 = cVar2.f ? j1(g) : fVar.h(g);
                            int c5 = this.u.c(view) + j1;
                            if (z12 && cVar2.f) {
                                d.a aVar = new d.a();
                                aVar.f267d = new int[this.s];
                                for (int i21 = 0; i21 < this.s; i21++) {
                                    aVar.f267d[i21] = j1 - this.t[i21].h(j1);
                                }
                                aVar.f266c = -1;
                                aVar.f265b = a2;
                                this.E.a(aVar);
                            }
                            i2 = j1;
                            i = c5;
                        } else {
                            int k1 = cVar2.f ? k1(g) : fVar.k(g);
                            int c6 = k1 - this.u.c(view);
                            if (z12 && cVar2.f) {
                                d.a aVar2 = new d.a();
                                aVar2.f267d = new int[this.s];
                                for (int i22 = 0; i22 < this.s; i22++) {
                                    aVar2.f267d[i22] = this.t[i22].k(k1) - k1;
                                }
                                aVar2.f266c = 1;
                                aVar2.f265b = a2;
                                this.E.a(aVar2);
                            }
                            i = k1;
                            i2 = c6;
                        }
                        if (cVar2.f || sVar.f1590d != -1) {
                            z2 = true;
                        } else {
                            z2 = true;
                            if (z12) {
                                this.M = true;
                            } else {
                                if (sVar.f1591e == 1) {
                                    int h2 = this.t[0].h(Integer.MIN_VALUE);
                                    int i23 = 1;
                                    while (true) {
                                        if (i23 >= this.s) {
                                            z2 = true;
                                            z7 = true;
                                            break;
                                        } else if (this.t[i23].h(Integer.MIN_VALUE) != h2) {
                                            z2 = true;
                                            z7 = false;
                                            break;
                                        } else {
                                            i23++;
                                        }
                                    }
                                    z5 = !z7;
                                } else {
                                    int k3 = this.t[0].k(Integer.MIN_VALUE);
                                    int i24 = 1;
                                    while (true) {
                                        if (i24 >= this.s) {
                                            z2 = true;
                                            z6 = true;
                                            break;
                                        } else if (this.t[i24].k(Integer.MIN_VALUE) != k3) {
                                            z2 = true;
                                            z6 = false;
                                            break;
                                        } else {
                                            i24++;
                                        }
                                    }
                                    z5 = z6 ^ z2;
                                }
                                if (z5) {
                                    d.a f2 = this.E.f(a2);
                                    if (f2 != null) {
                                        f2.f268e = z2;
                                    }
                                    this.M = z2;
                                }
                                if (sVar.f1591e != z2) {
                                    if (cVar2.f) {
                                        int i25 = this.s;
                                        while (true) {
                                            i25--;
                                            if (i25 < 0) {
                                                break;
                                            }
                                            this.t[i25].a(view);
                                        }
                                    } else {
                                        cVar2.f262e.a(view);
                                    }
                                } else if (cVar2.f) {
                                    int i26 = this.s;
                                    while (true) {
                                        i26--;
                                        if (i26 < 0) {
                                            break;
                                        }
                                        this.t[i26].n(view);
                                    }
                                } else {
                                    cVar2.f262e.n(view);
                                }
                                if (n1() || this.w != 1) {
                                    int k4 = !cVar2.f ? this.v.k() : (fVar.f277e * this.x) + this.v.k();
                                    i4 = k4;
                                    i3 = this.v.c(view) + k4;
                                } else {
                                    int g3 = cVar2.f ? this.v.g() : this.v.g() - (((this.s - 1) - fVar.f277e) * this.x);
                                    i3 = g3;
                                    i4 = g3 - this.v.c(view);
                                }
                                if (this.w != 1) {
                                    z3 = true;
                                    Y(view, i4, i2, i3, i);
                                    cVar = cVar2;
                                } else {
                                    z3 = true;
                                    cVar = cVar2;
                                    Y(view, i2, i4, i, i3);
                                }
                                if (!cVar.f) {
                                    y1(this.y.f1591e, i10);
                                } else {
                                    A1(fVar, this.y.f1591e, i10);
                                }
                                s1(vVar, this.y);
                                if (this.y.h && view.hasFocusable()) {
                                    if (!cVar.f) {
                                        this.B.clear();
                                    } else {
                                        z4 = false;
                                        this.B.set(fVar.f277e, false);
                                        z9 = z4;
                                        z11 = z3;
                                        z10 = z11;
                                    }
                                }
                                z4 = false;
                                z9 = z4;
                                z11 = z3;
                                z10 = z11;
                            }
                        }
                        if (sVar.f1591e != z2) {
                        }
                        if (n1()) {
                        }
                        if (!cVar2.f) {
                        }
                        i4 = k4;
                        i3 = this.v.c(view) + k4;
                        if (this.w != 1) {
                        }
                        if (!cVar.f) {
                        }
                        s1(vVar, this.y);
                        if (!cVar.f) {
                        }
                    }
                } else if (this.w == z10) {
                    i6 = RecyclerView.o.z(this.x, this.o, 0, ((ViewGroup.MarginLayoutParams) cVar2).width, false);
                } else {
                    i6 = RecyclerView.o.z(this.q, this.o, N() + M(), ((ViewGroup.MarginLayoutParams) cVar2).width, z10);
                    z8 = false;
                    i5 = RecyclerView.o.z(this.x, this.p, 0, ((ViewGroup.MarginLayoutParams) cVar2).height, false);
                    o1(view, i6, i5, z8);
                    if (sVar.f1591e == z10) {
                    }
                    if (cVar2.f) {
                    }
                    z2 = true;
                    if (sVar.f1591e != z2) {
                    }
                    if (n1()) {
                    }
                    if (!cVar2.f) {
                    }
                    i4 = k4;
                    i3 = this.v.c(view) + k4;
                    if (this.w != 1) {
                    }
                    if (!cVar.f) {
                    }
                    s1(vVar, this.y);
                    if (!cVar.f) {
                    }
                }
                i5 = RecyclerView.o.z(this.r, this.p, L() + O(), ((ViewGroup.MarginLayoutParams) cVar2).height, z10);
                z8 = false;
                o1(view, i6, i5, z8);
                if (sVar.f1591e == z10) {
                }
                if (cVar2.f) {
                }
                z2 = true;
                if (sVar.f1591e != z2) {
                }
                if (n1()) {
                }
                if (!cVar2.f) {
                }
                i4 = k4;
                i3 = this.v.c(view) + k4;
                if (this.w != 1) {
                }
                if (!cVar.f) {
                }
                s1(vVar, this.y);
                if (!cVar.f) {
                }
            }
        }
        if (!z11) {
            s1(vVar, this.y);
        }
        int k5 = this.y.f1591e == -1 ? this.u.k() - k1(this.u.k()) : j1(this.u.g()) - this.u.g();
        if (k5 > 0) {
            return Math.min(sVar.f1588b, k5);
        }
        int i27 = z9 ? 1 : 0;
        int i28 = z9 ? 1 : 0;
        int i29 = z9 ? 1 : 0;
        return i27;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d(String str) {
        RecyclerView recyclerView;
        if (this.I == null && (recyclerView = this.f219b) != null) {
            recyclerView.assertNotInLayoutOrScroll(str);
        }
    }

    public View d1(boolean z2) {
        int k = this.u.k();
        int g = this.u.g();
        View view = null;
        for (int y2 = y() - 1; y2 >= 0; y2--) {
            View x2 = x(y2);
            int e2 = this.u.e(x2);
            int b2 = this.u.b(x2);
            if (b2 > k && e2 < g) {
                if (b2 <= g || !z2) {
                    return x2;
                }
                if (view == null) {
                    view = x2;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean e() {
        return this.w == 0;
    }

    public View e1(boolean z2) {
        int k = this.u.k();
        int g = this.u.g();
        int y2 = y();
        View view = null;
        for (int i = 0; i < y2; i++) {
            View x2 = x(i);
            int e2 = this.u.e(x2);
            if (this.u.b(x2) > k && e2 < g) {
                if (e2 >= k || !z2) {
                    return x2;
                }
                if (view == null) {
                    view = x2;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean f() {
        return this.w == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void f0(RecyclerView recyclerView, RecyclerView.v vVar) {
        e0();
        Runnable runnable = this.P;
        RecyclerView recyclerView2 = this.f219b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(runnable);
        }
        for (int i = 0; i < this.s; i++) {
            this.t[i].d();
        }
        recyclerView.requestLayout();
    }

    public final void f1(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z2) {
        int g;
        int j1 = j1(Integer.MIN_VALUE);
        if (j1 != Integer.MIN_VALUE && (g = this.u.g() - j1) > 0) {
            int i = g - (-w1(-g, vVar, a0Var));
            if (z2 && i > 0) {
                this.u.p(i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean g(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003b, code lost:
        if (r9.w == 1) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        if (r9.w == 0) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004d, code lost:
        if (n1() == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0059, code lost:
        if (n1() == false) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005f  */
    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View g0(View view, int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View s2;
        int i2;
        View i3;
        if (y() == 0 || (s2 = s(view)) == null) {
            return null;
        }
        v1();
        if (i == 1) {
            if (this.w != 1) {
            }
            i2 = -1;
            if (i2 == Integer.MIN_VALUE) {
            }
        } else if (i != 2) {
            if (i != 17) {
                if (i != 33) {
                    if (i == 66) {
                    }
                }
            }
            i2 = Integer.MIN_VALUE;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            c cVar = (c) s2.getLayoutParams();
            boolean z2 = cVar.f;
            f fVar = cVar.f262e;
            int i1 = i2 == 1 ? i1() : h1();
            z1(i1, a0Var);
            x1(i2);
            s sVar = this.y;
            sVar.f1589c = sVar.f1590d + i1;
            sVar.f1588b = (int) (((float) this.u.l()) * 0.33333334f);
            s sVar2 = this.y;
            sVar2.h = true;
            sVar2.f1587a = false;
            c1(vVar, sVar2, a0Var);
            this.G = this.A;
            if (!(z2 || (i3 = fVar.i(i1, i2)) == null || i3 == s2)) {
                return i3;
            }
            if (q1(i2)) {
                for (int i4 = this.s - 1; i4 >= 0; i4--) {
                    View i5 = this.t[i4].i(i1, i2);
                    if (!(i5 == null || i5 == s2)) {
                        return i5;
                    }
                }
            } else {
                for (int i6 = 0; i6 < this.s; i6++) {
                    View i7 = this.t[i6].i(i1, i2);
                    if (!(i7 == null || i7 == s2)) {
                        return i7;
                    }
                }
            }
            boolean z3 = (this.z ^ true) == (i2 == -1);
            if (!z2) {
                View t2 = t(z3 ? fVar.e() : fVar.f());
                if (!(t2 == null || t2 == s2)) {
                    return t2;
                }
            }
            if (q1(i2)) {
                for (int i8 = this.s - 1; i8 >= 0; i8--) {
                    if (i8 != fVar.f277e) {
                        f[] fVarArr = this.t;
                        View t3 = t(z3 ? fVarArr[i8].e() : fVarArr[i8].f());
                        if (!(t3 == null || t3 == s2)) {
                            return t3;
                        }
                    }
                }
            } else {
                for (int i9 = 0; i9 < this.s; i9++) {
                    f[] fVarArr2 = this.t;
                    View t4 = t(z3 ? fVarArr2[i9].e() : fVarArr2[i9].f());
                    if (!(t4 == null || t4 == s2)) {
                        return t4;
                    }
                }
            }
            return null;
        } else if (this.w != 1) {
        }
        i2 = 1;
        if (i2 == Integer.MIN_VALUE) {
        }
    }

    public final void g1(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z2) {
        int k;
        int k1 = k1(Integer.MAX_VALUE);
        if (k1 != Integer.MAX_VALUE && (k = k1 - this.u.k()) > 0) {
            int w1 = k - w1(k, vVar, a0Var);
            if (z2 && w1 > 0) {
                this.u.p(-w1);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void h0(AccessibilityEvent accessibilityEvent) {
        RecyclerView.v vVar = this.f219b.mRecycler;
        i0(accessibilityEvent);
        if (y() > 0) {
            View e1 = e1(false);
            View d1 = d1(false);
            if (e1 != null && d1 != null) {
                int P2 = P(e1);
                int P3 = P(d1);
                if (P2 < P3) {
                    accessibilityEvent.setFromIndex(P2);
                    accessibilityEvent.setToIndex(P3);
                    return;
                }
                accessibilityEvent.setFromIndex(P3);
                accessibilityEvent.setToIndex(P2);
            }
        }
    }

    public int h1() {
        if (y() == 0) {
            return 0;
        }
        return P(x(0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i(int i, int i2, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        int i3;
        int i4;
        if (this.w != 0) {
            i = i2;
        }
        if (!(y() == 0 || i == 0)) {
            r1(i, a0Var);
            int[] iArr = this.O;
            if (iArr == null || iArr.length < this.s) {
                this.O = new int[this.s];
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.s; i6++) {
                s sVar = this.y;
                if (sVar.f1590d == -1) {
                    i4 = sVar.f;
                    i3 = this.t[i6].k(i4);
                } else {
                    i4 = this.t[i6].h(sVar.g);
                    i3 = this.y.g;
                }
                int i7 = i4 - i3;
                if (i7 >= 0) {
                    this.O[i5] = i7;
                    i5++;
                }
            }
            Arrays.sort(this.O, 0, i5);
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = this.y.f1589c;
                if (i9 >= 0 && i9 < a0Var.b()) {
                    ((r.b) cVar).a(this.y.f1589c, this.O[i8]);
                    s sVar2 = this.y;
                    sVar2.f1589c += sVar2.f1590d;
                } else {
                    return;
                }
            }
        }
    }

    public int i1() {
        int y2 = y();
        if (y2 == 0) {
            return 0;
        }
        return P(x(y2 - 1));
    }

    public final int j1(int i) {
        int h = this.t[0].h(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int h2 = this.t[i2].h(i);
            if (h2 > h) {
                h = h2;
            }
        }
        return h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int k(RecyclerView.a0 a0Var) {
        return Z0(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void k0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, b.i.l.w.b bVar) {
        b.c cVar;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.j0(view, bVar);
            return;
        }
        c cVar2 = (c) layoutParams;
        int i = 1;
        int i2 = -1;
        if (this.w == 0) {
            f fVar = cVar2.f262e;
            if (fVar != null) {
                i2 = fVar.f277e;
            }
            if (cVar2.f) {
                i = this.s;
            }
            cVar = b.c.a(i2, i, -1, -1, false, false);
        } else {
            f fVar2 = cVar2.f262e;
            if (fVar2 != null) {
                i2 = fVar2.f277e;
            }
            if (cVar2.f) {
                i = this.s;
            }
            cVar = b.c.a(-1, -1, i2, i, false, false);
        }
        bVar.j(cVar);
    }

    public final int k1(int i) {
        int k = this.t[0].k(i);
        for (int i2 = 1; i2 < this.s; i2++) {
            int k2 = this.t[i2].k(i);
            if (k2 < k) {
                k = k2;
            }
        }
        return k;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int l(RecyclerView.a0 a0Var) {
        return a1(a0Var);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    public final void l1(int i, int i2, int i3) {
        int i4;
        int i5;
        int i1 = this.A ? i1() : h1();
        if (i3 != 8) {
            i5 = i + i2;
        } else if (i < i2) {
            i5 = i2 + 1;
        } else {
            i5 = i + 1;
            i4 = i2;
            this.E.g(i4);
            if (i3 != 1) {
                this.E.h(i, i2);
            } else if (i3 == 2) {
                this.E.i(i, i2);
            } else if (i3 == 8) {
                this.E.i(i, 1);
                this.E.h(i2, 1);
            }
            if (i5 <= i1) {
                if (i4 <= (this.A ? h1() : i1())) {
                    I0();
                    return;
                }
                return;
            }
            return;
        }
        i4 = i;
        this.E.g(i4);
        if (i3 != 1) {
        }
        if (i5 <= i1) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int m(RecyclerView.a0 a0Var) {
        return b1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void m0(RecyclerView recyclerView, int i, int i2) {
        l1(i, i2, 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b9, code lost:
        if (r11 == r12) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00cb, code lost:
        if (r11 == r12) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00cf, code lost:
        r11 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0091 A[SYNTHETIC] */
    public View m1() {
        int i;
        int i2;
        boolean z2;
        View view;
        int y2 = y() - 1;
        BitSet bitSet = new BitSet(this.s);
        bitSet.set(0, this.s, true);
        char c2 = (this.w != 1 || !n1()) ? (char) 65535 : 1;
        if (this.A) {
            i = -1;
        } else {
            i = y2 + 1;
            y2 = 0;
        }
        int i3 = y2 < i ? 1 : -1;
        while (y2 != i) {
            View x2 = x(y2);
            c cVar = (c) x2.getLayoutParams();
            if (bitSet.get(cVar.f262e.f277e)) {
                f fVar = cVar.f262e;
                if (this.A) {
                    int i4 = fVar.f275c;
                    if (i4 == Integer.MIN_VALUE) {
                        fVar.b();
                        i4 = fVar.f275c;
                    }
                    if (i4 < this.u.g()) {
                        ArrayList<View> arrayList = fVar.f273a;
                        view = arrayList.get(arrayList.size() - 1);
                    }
                    z2 = false;
                    if (z2) {
                        return x2;
                    }
                    bitSet.clear(cVar.f262e.f277e);
                } else {
                    int i5 = fVar.f274b;
                    if (i5 == Integer.MIN_VALUE) {
                        fVar.c();
                        i5 = fVar.f274b;
                    }
                    if (i5 > this.u.k()) {
                        view = fVar.f273a.get(0);
                    }
                    z2 = false;
                    if (z2) {
                    }
                }
                z2 = !fVar.j(view).f;
                if (z2) {
                }
            }
            if (!cVar.f && (i2 = y2 + i3) != i) {
                View x3 = x(i2);
                if (this.A) {
                    int b2 = this.u.b(x2);
                    int b3 = this.u.b(x3);
                    if (b2 < b3) {
                        return x2;
                    }
                } else {
                    int e2 = this.u.e(x2);
                    int e3 = this.u.e(x3);
                    if (e2 > e3) {
                        return x2;
                    }
                }
                boolean z3 = true;
                if (!z3) {
                    continue;
                } else {
                    if ((cVar.f262e.f277e - ((c) x3.getLayoutParams()).f262e.f277e < 0) != (c2 < 0)) {
                        return x2;
                    }
                }
            }
            y2 += i3;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int n(RecyclerView.a0 a0Var) {
        return Z0(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void n0(RecyclerView recyclerView) {
        this.E.b();
        I0();
    }

    public boolean n1() {
        return I() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int o(RecyclerView.a0 a0Var) {
        return a1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o0(RecyclerView recyclerView, int i, int i2, int i3) {
        l1(i, i2, 8);
    }

    public final void o1(View view, int i, int i2, boolean z2) {
        Rect rect = this.K;
        RecyclerView recyclerView = this.f219b;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.getItemDecorInsetsForChild(view));
        }
        c cVar = (c) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect2 = this.K;
        int B1 = B1(i, i3 + rect2.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect2.right);
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect3 = this.K;
        int B12 = B1(i2, i4 + rect3.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect3.bottom);
        if (z2 ? T0(view, B1, B12, cVar) : R0(view, B1, B12, cVar)) {
            view.measure(B1, B12);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int p(RecyclerView.a0 a0Var) {
        return b1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p0(RecyclerView recyclerView, int i, int i2) {
        l1(i, i2, 2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:244:0x03fe, code lost:
        if (Y0() != false) goto L_0x0402;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01ae  */
    public final void p1(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z2) {
        e eVar;
        boolean z3;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z4;
        b bVar = this.L;
        if (!(this.I == null && this.C == -1) && a0Var.b() == 0) {
            C0(vVar);
            bVar.b();
            return;
        }
        boolean z5 = true;
        boolean z6 = (bVar.f261e && this.C == -1 && this.I == null) ? false : true;
        if (z6) {
            bVar.b();
            e eVar2 = this.I;
            if (eVar2 != null) {
                int i7 = eVar2.f271d;
                if (i7 > 0) {
                    if (i7 == this.s) {
                        for (int i8 = 0; i8 < this.s; i8++) {
                            this.t[i8].d();
                            e eVar3 = this.I;
                            int i9 = eVar3.f272e[i8];
                            if (i9 != Integer.MIN_VALUE) {
                                i9 += eVar3.j ? this.u.g() : this.u.k();
                            }
                            f fVar = this.t[i8];
                            fVar.f274b = i9;
                            fVar.f275c = i9;
                        }
                    } else {
                        eVar2.f272e = null;
                        eVar2.f271d = 0;
                        eVar2.f = 0;
                        eVar2.g = null;
                        eVar2.h = null;
                        eVar2.f269b = eVar2.f270c;
                    }
                }
                e eVar4 = this.I;
                this.H = eVar4.k;
                boolean z7 = eVar4.i;
                d(null);
                e eVar5 = this.I;
                if (!(eVar5 == null || eVar5.i == z7)) {
                    eVar5.i = z7;
                }
                this.z = z7;
                I0();
                v1();
                e eVar6 = this.I;
                int i10 = eVar6.f269b;
                if (i10 != -1) {
                    this.C = i10;
                    z4 = eVar6.j;
                } else {
                    z4 = this.A;
                }
                bVar.f259c = z4;
                e eVar7 = this.I;
                if (eVar7.f > 1) {
                    d dVar = this.E;
                    dVar.f263a = eVar7.g;
                    dVar.f264b = eVar7.h;
                }
            } else {
                v1();
                bVar.f259c = this.A;
            }
            if (!a0Var.g && (i2 = this.C) != -1) {
                if (i2 < 0 || i2 >= a0Var.b()) {
                    this.C = -1;
                    this.D = Integer.MIN_VALUE;
                } else {
                    e eVar8 = this.I;
                    if (eVar8 == null || eVar8.f269b == -1 || eVar8.f271d < 1) {
                        View t2 = t(this.C);
                        if (t2 != null) {
                            bVar.f257a = this.A ? i1() : h1();
                            if (this.D != Integer.MIN_VALUE) {
                                if (bVar.f259c) {
                                    i5 = this.u.g() - this.D;
                                    i6 = this.u.b(t2);
                                } else {
                                    i5 = this.u.k() + this.D;
                                    i6 = this.u.e(t2);
                                }
                                i3 = i5 - i6;
                            } else {
                                if (this.u.c(t2) > this.u.l()) {
                                    i4 = bVar.f259c ? this.u.g() : this.u.k();
                                } else {
                                    int e2 = this.u.e(t2) - this.u.k();
                                    if (e2 < 0) {
                                        i4 = -e2;
                                    } else {
                                        i3 = this.u.g() - this.u.b(t2);
                                        if (i3 >= 0) {
                                            bVar.f258b = Integer.MIN_VALUE;
                                        }
                                    }
                                }
                                bVar.f258b = i4;
                            }
                            bVar.f258b = i3;
                        } else {
                            int i11 = this.C;
                            bVar.f257a = i11;
                            int i12 = this.D;
                            if (i12 == Integer.MIN_VALUE) {
                                bVar.f259c = X0(i11) == 1;
                                bVar.a();
                            } else {
                                bVar.f258b = bVar.f259c ? StaggeredGridLayoutManager.this.u.g() - i12 : StaggeredGridLayoutManager.this.u.k() + i12;
                            }
                            bVar.f260d = true;
                        }
                    } else {
                        bVar.f258b = Integer.MIN_VALUE;
                        bVar.f257a = this.C;
                    }
                    z3 = true;
                    if (!z3) {
                        boolean z8 = this.G;
                        int b2 = a0Var.b();
                        if (z8) {
                            int y2 = y();
                            while (true) {
                                y2--;
                                if (y2 < 0) {
                                    break;
                                }
                                i = P(x(y2));
                                if (i >= 0 && i < b2) {
                                    break;
                                }
                            }
                        } else {
                            int y3 = y();
                            int i13 = 0;
                            while (true) {
                                if (i13 >= y3) {
                                    break;
                                }
                                int P2 = P(x(i13));
                                if (P2 >= 0 && P2 < b2) {
                                    i = P2;
                                    break;
                                }
                                i13++;
                            }
                        }
                        i = 0;
                        bVar.f257a = i;
                        bVar.f258b = Integer.MIN_VALUE;
                    }
                    bVar.f261e = true;
                }
            }
            z3 = false;
            if (!z3) {
            }
            bVar.f261e = true;
        }
        if (this.I == null && this.C == -1 && !(bVar.f259c == this.G && n1() == this.H)) {
            this.E.b();
            bVar.f260d = true;
        }
        if (y() > 0 && ((eVar = this.I) == null || eVar.f271d < 1)) {
            if (bVar.f260d) {
                for (int i14 = 0; i14 < this.s; i14++) {
                    this.t[i14].d();
                    int i15 = bVar.f258b;
                    if (i15 != Integer.MIN_VALUE) {
                        f fVar2 = this.t[i14];
                        fVar2.f274b = i15;
                        fVar2.f275c = i15;
                    }
                }
            } else if (z6 || this.L.f == null) {
                for (int i16 = 0; i16 < this.s; i16++) {
                    f fVar3 = this.t[i16];
                    boolean z9 = this.A;
                    int i17 = bVar.f258b;
                    int h = z9 ? fVar3.h(Integer.MIN_VALUE) : fVar3.k(Integer.MIN_VALUE);
                    fVar3.d();
                    if (h != Integer.MIN_VALUE && ((!z9 || h >= StaggeredGridLayoutManager.this.u.g()) && (z9 || h <= StaggeredGridLayoutManager.this.u.k()))) {
                        if (i17 != Integer.MIN_VALUE) {
                            h += i17;
                        }
                        fVar3.f275c = h;
                        fVar3.f274b = h;
                    }
                }
                b bVar2 = this.L;
                f[] fVarArr = this.t;
                if (bVar2 != null) {
                    int length = fVarArr.length;
                    int[] iArr = bVar2.f;
                    if (iArr == null || iArr.length < length) {
                        bVar2.f = new int[StaggeredGridLayoutManager.this.t.length];
                    }
                    for (int i18 = 0; i18 < length; i18++) {
                        bVar2.f[i18] = fVarArr[i18].k(Integer.MIN_VALUE);
                    }
                } else {
                    throw null;
                }
            } else {
                for (int i19 = 0; i19 < this.s; i19++) {
                    f fVar4 = this.t[i19];
                    fVar4.d();
                    int i20 = this.L.f[i19];
                    fVar4.f274b = i20;
                    fVar4.f275c = i20;
                }
            }
        }
        q(vVar);
        this.y.f1587a = false;
        this.M = false;
        int l = this.v.l();
        this.x = l / this.s;
        this.J = View.MeasureSpec.makeMeasureSpec(l, this.v.i());
        z1(bVar.f257a, a0Var);
        if (bVar.f259c) {
            x1(-1);
            c1(vVar, this.y, a0Var);
            x1(1);
        } else {
            x1(1);
            c1(vVar, this.y, a0Var);
            x1(-1);
        }
        s sVar = this.y;
        sVar.f1589c = bVar.f257a + sVar.f1590d;
        c1(vVar, sVar, a0Var);
        if (this.v.i() != 1073741824) {
            float f2 = 0.0f;
            int y4 = y();
            for (int i21 = 0; i21 < y4; i21++) {
                View x2 = x(i21);
                float c2 = (float) this.v.c(x2);
                if (c2 >= f2) {
                    if (((c) x2.getLayoutParams()) != null) {
                        f2 = Math.max(f2, c2);
                    } else {
                        throw null;
                    }
                }
            }
            int i22 = this.x;
            int round = Math.round(f2 * ((float) this.s));
            if (this.v.i() == Integer.MIN_VALUE) {
                round = Math.min(round, this.v.l());
            }
            this.x = round / this.s;
            this.J = View.MeasureSpec.makeMeasureSpec(round, this.v.i());
            if (this.x != i22) {
                for (int i23 = 0; i23 < y4; i23++) {
                    View x3 = x(i23);
                    c cVar = (c) x3.getLayoutParams();
                    if (!cVar.f) {
                        if (!n1() || this.w != 1) {
                            int i24 = cVar.f262e.f277e;
                            int i25 = this.w;
                            int i26 = (this.x * i24) - (i24 * i22);
                            if (i25 == 1) {
                                x3.offsetLeftAndRight(i26);
                            } else {
                                x3.offsetTopAndBottom(i26);
                            }
                        } else {
                            int i27 = this.s;
                            int i28 = cVar.f262e.f277e;
                            x3.offsetLeftAndRight(((-((i27 - 1) - i28)) * this.x) - ((-((i27 - 1) - i28)) * i22));
                        }
                    }
                }
            }
        }
        if (y() > 0) {
            if (this.A) {
                f1(vVar, a0Var, true);
                g1(vVar, a0Var, false);
            } else {
                g1(vVar, a0Var, true);
                f1(vVar, a0Var, false);
            }
        }
        if (z2 && !a0Var.g) {
            if (this.F != 0 && y() > 0 && (this.M || m1() != null)) {
                Runnable runnable = this.P;
                RecyclerView recyclerView = this.f219b;
                if (recyclerView != null) {
                    recyclerView.removeCallbacks(runnable);
                }
            }
        }
        z5 = false;
        if (a0Var.g) {
            this.L.b();
        }
        this.G = bVar.f259c;
        this.H = n1();
        if (z5) {
            this.L.b();
            p1(vVar, a0Var, false);
        }
    }

    public final boolean q1(int i) {
        if (this.w == 0) {
            return (i == -1) != this.A;
        }
        return ((i == -1) == this.A) == n1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void r0(RecyclerView recyclerView, int i, int i2, Object obj) {
        l1(i, i2, 4);
    }

    public void r1(int i, RecyclerView.a0 a0Var) {
        int i2;
        int i3;
        if (i > 0) {
            i3 = i1();
            i2 = 1;
        } else {
            i2 = -1;
            i3 = h1();
        }
        this.y.f1587a = true;
        z1(i3, a0Var);
        x1(i2);
        s sVar = this.y;
        sVar.f1589c = i3 + sVar.f1590d;
        sVar.f1588b = Math.abs(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void s0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        p1(vVar, a0Var, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (r6.f1591e == -1) goto L_0x0013;
     */
    public final void s1(RecyclerView.v vVar, s sVar) {
        int min;
        int min2;
        if (sVar.f1587a && !sVar.i) {
            if (sVar.f1588b != 0) {
                int i = 1;
                if (sVar.f1591e == -1) {
                    int i2 = sVar.f;
                    int k = this.t[0].k(i2);
                    while (i < this.s) {
                        int k2 = this.t[i].k(i2);
                        if (k2 > k) {
                            k = k2;
                        }
                        i++;
                    }
                    int i3 = i2 - k;
                    if (i3 >= 0) {
                        min2 = sVar.g - Math.min(i3, sVar.f1588b);
                        t1(vVar, min2);
                    }
                } else {
                    int i4 = sVar.g;
                    int h = this.t[0].h(i4);
                    while (i < this.s) {
                        int h2 = this.t[i].h(i4);
                        if (h2 < h) {
                            h = h2;
                        }
                        i++;
                    }
                    int i5 = h - sVar.g;
                    if (i5 >= 0) {
                        min = Math.min(i5, sVar.f1588b) + sVar.f;
                        u1(vVar, min);
                        return;
                    }
                    min = sVar.f;
                    u1(vVar, min);
                    return;
                }
            }
            min2 = sVar.g;
            t1(vVar, min2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void t0(RecyclerView.a0 a0Var) {
        this.C = -1;
        this.D = Integer.MIN_VALUE;
        this.I = null;
        this.L.b();
    }

    public final void t1(RecyclerView.v vVar, int i) {
        for (int y2 = y() - 1; y2 >= 0; y2--) {
            View x2 = x(y2);
            if (this.u.e(x2) >= i && this.u.o(x2) >= i) {
                c cVar = (c) x2.getLayoutParams();
                if (cVar.f) {
                    for (int i2 = 0; i2 < this.s; i2++) {
                        if (this.t[i2].f273a.size() == 1) {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.s; i3++) {
                        this.t[i3].l();
                    }
                } else if (cVar.f262e.f273a.size() != 1) {
                    cVar.f262e.l();
                } else {
                    return;
                }
                E0(x2, vVar);
            } else {
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p u() {
        return this.w == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    public final void u1(RecyclerView.v vVar, int i) {
        while (y() > 0) {
            View x2 = x(0);
            if (this.u.b(x2) <= i && this.u.n(x2) <= i) {
                c cVar = (c) x2.getLayoutParams();
                if (cVar.f) {
                    for (int i2 = 0; i2 < this.s; i2++) {
                        if (this.t[i2].f273a.size() == 1) {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.s; i3++) {
                        this.t[i3].m();
                    }
                } else if (cVar.f262e.f273a.size() != 1) {
                    cVar.f262e.m();
                } else {
                    return;
                }
                E0(x2, vVar);
            } else {
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p v(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    public final void v1() {
        this.A = (this.w == 1 || !n1()) ? this.z : !this.z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p w(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    public int w1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (y() == 0 || i == 0) {
            return 0;
        }
        r1(i, a0Var);
        int c1 = c1(vVar, this.y, a0Var);
        if (this.y.f1588b >= c1) {
            i = i < 0 ? -c1 : c1;
        }
        this.u.p(-i);
        this.G = this.A;
        s sVar = this.y;
        sVar.f1588b = 0;
        s1(vVar, sVar);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x0(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.I = (e) parcelable;
            I0();
        }
    }

    public final void x1(int i) {
        s sVar = this.y;
        sVar.f1591e = i;
        int i2 = 1;
        if (this.A != (i == -1)) {
            i2 = -1;
        }
        sVar.f1590d = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable y0() {
        int i;
        int i2;
        int[] iArr;
        e eVar = this.I;
        if (eVar != null) {
            return new e(eVar);
        }
        e eVar2 = new e();
        eVar2.i = this.z;
        eVar2.j = this.G;
        eVar2.k = this.H;
        d dVar = this.E;
        if (dVar == null || (iArr = dVar.f263a) == null) {
            eVar2.f = 0;
        } else {
            eVar2.g = iArr;
            eVar2.f = iArr.length;
            eVar2.h = dVar.f264b;
        }
        int i3 = -1;
        if (y() > 0) {
            eVar2.f269b = this.G ? i1() : h1();
            View d1 = this.A ? d1(true) : e1(true);
            if (d1 != null) {
                i3 = P(d1);
            }
            eVar2.f270c = i3;
            int i4 = this.s;
            eVar2.f271d = i4;
            eVar2.f272e = new int[i4];
            for (int i5 = 0; i5 < this.s; i5++) {
                if (this.G) {
                    i = this.t[i5].h(Integer.MIN_VALUE);
                    if (i != Integer.MIN_VALUE) {
                        i2 = this.u.g();
                    } else {
                        eVar2.f272e[i5] = i;
                    }
                } else {
                    i = this.t[i5].k(Integer.MIN_VALUE);
                    if (i != Integer.MIN_VALUE) {
                        i2 = this.u.k();
                    } else {
                        eVar2.f272e[i5] = i;
                    }
                }
                i -= i2;
                eVar2.f272e[i5] = i;
            }
        } else {
            eVar2.f269b = -1;
            eVar2.f270c = -1;
            eVar2.f271d = 0;
        }
        return eVar2;
    }

    public final void y1(int i, int i2) {
        for (int i3 = 0; i3 < this.s; i3++) {
            if (!this.t[i3].f273a.isEmpty()) {
                A1(this.t[i3], i, i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void z0(int i) {
        if (i == 0) {
            Y0();
        }
    }

    public final void z1(int i, RecyclerView.a0 a0Var) {
        int i2;
        int i3;
        int i4;
        s sVar = this.y;
        boolean z2 = false;
        sVar.f1588b = 0;
        sVar.f1589c = i;
        RecyclerView.z zVar = this.g;
        if (!(zVar != null && zVar.f250e) || (i4 = a0Var.f197a) == -1) {
            i3 = 0;
            i2 = 0;
        } else {
            if (this.A == (i4 < i)) {
                i3 = this.u.l();
                i2 = 0;
            } else {
                i2 = this.u.l();
                i3 = 0;
            }
        }
        RecyclerView recyclerView = this.f219b;
        if (recyclerView != null && recyclerView.mClipToPadding) {
            this.y.f = this.u.k() - i2;
            this.y.g = this.u.g() + i3;
        } else {
            this.y.g = this.u.f() + i3;
            this.y.f = -i2;
        }
        s sVar2 = this.y;
        sVar2.h = false;
        sVar2.f1587a = true;
        if (this.u.i() == 0 && this.u.f() == 0) {
            z2 = true;
        }
        sVar2.i = z2;
    }
}
