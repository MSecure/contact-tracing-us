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
import e.s.a.j;
import e.s.a.l;
import e.s.a.q;
import java.util.List;
import java.util.Objects;

public class LinearLayoutManager extends RecyclerView.m implements RecyclerView.x.b {
    public int A;
    public d B;
    public final a C;
    public final b D;
    public int E;
    public int[] F;
    public int r;
    public c s;
    public q t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public int z;

    public static class a {
        public q a;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f185d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f186e;

        public a() {
            d();
        }

        public void a() {
            this.c = this.f185d ? this.a.g() : this.a.k();
        }

        public void b(View view, int i2) {
            if (this.f185d) {
                this.c = this.a.m() + this.a.b(view);
            } else {
                this.c = this.a.e(view);
            }
            this.b = i2;
        }

        public void c(View view, int i2) {
            int i3;
            int m = this.a.m();
            if (m >= 0) {
                b(view, i2);
                return;
            }
            this.b = i2;
            if (this.f185d) {
                int g2 = (this.a.g() - m) - this.a.b(view);
                this.c = this.a.g() - g2;
                if (g2 > 0) {
                    int c2 = this.c - this.a.c(view);
                    int k2 = this.a.k();
                    int min = c2 - (Math.min(this.a.e(view) - k2, 0) + k2);
                    if (min < 0) {
                        i3 = Math.min(g2, -min) + this.c;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                int e2 = this.a.e(view);
                int k3 = e2 - this.a.k();
                this.c = e2;
                if (k3 > 0) {
                    int g3 = (this.a.g() - Math.min(0, (this.a.g() - m) - this.a.b(view))) - (this.a.c(view) + e2);
                    if (g3 < 0) {
                        i3 = this.c - Math.min(k3, -g3);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.c = i3;
        }

        public void d() {
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            this.f185d = false;
            this.f186e = false;
        }

        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("AnchorInfo{mPosition=");
            h2.append(this.b);
            h2.append(", mCoordinate=");
            h2.append(this.c);
            h2.append(", mLayoutFromEnd=");
            h2.append(this.f185d);
            h2.append(", mValid=");
            h2.append(this.f186e);
            h2.append('}');
            return h2.toString();
        }
    }

    public static class b {
        public int a;
        public boolean b;
        public boolean c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f187d;
    }

    public static class c {
        public boolean a = true;
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f188d;

        /* renamed from: e  reason: collision with root package name */
        public int f189e;

        /* renamed from: f  reason: collision with root package name */
        public int f190f;

        /* renamed from: g  reason: collision with root package name */
        public int f191g;

        /* renamed from: h  reason: collision with root package name */
        public int f192h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f193i = 0;

        /* renamed from: j  reason: collision with root package name */
        public int f194j;

        /* renamed from: k  reason: collision with root package name */
        public List<RecyclerView.b0> f195k = null;

        /* renamed from: l  reason: collision with root package name */
        public boolean f196l;

        public void a(View view) {
            int i2;
            int a2;
            int size = this.f195k.size();
            View view2 = null;
            int i3 = Integer.MAX_VALUE;
            for (int i4 = 0; i4 < size; i4++) {
                View view3 = this.f195k.get(i4).a;
                RecyclerView.n nVar = (RecyclerView.n) view3.getLayoutParams();
                if (view3 != view && !nVar.c() && (a2 = (nVar.a() - this.f188d) * this.f189e) >= 0 && a2 < i3) {
                    view2 = view3;
                    if (a2 == 0) {
                        break;
                    }
                    i3 = a2;
                }
            }
            if (view2 == null) {
                i2 = -1;
            } else {
                i2 = ((RecyclerView.n) view2.getLayoutParams()).a();
            }
            this.f188d = i2;
        }

        public boolean b(RecyclerView.y yVar) {
            int i2 = this.f188d;
            return i2 >= 0 && i2 < yVar.b();
        }

        public View c(RecyclerView.t tVar) {
            List<RecyclerView.b0> list = this.f195k;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    View view = this.f195k.get(i2).a;
                    RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
                    if (!nVar.c() && this.f188d == nVar.a()) {
                        a(view);
                        return view;
                    }
                }
                return null;
            }
            View view2 = tVar.j(this.f188d, false, Long.MAX_VALUE).a;
            this.f188d += this.f189e;
            return view2;
        }
    }

    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();
        public int b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f197d;

        public static class a implements Parcelable.Creator<d> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i2) {
                return new d[i2];
            }
        }

        public d() {
        }

        public d(Parcel parcel) {
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.f197d = parcel.readInt() != 1 ? false : true;
        }

        public d(d dVar) {
            this.b = dVar.b;
            this.c = dVar.c;
            this.f197d = dVar.f197d;
        }

        public boolean d() {
            return this.b >= 0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.f197d ? 1 : 0);
        }
    }

    public LinearLayoutManager(int i2, boolean z2) {
        this.r = 1;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = true;
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.B = null;
        this.C = new a();
        this.D = new b();
        this.E = 2;
        this.F = new int[2];
        D1(i2);
        d(null);
        if (z2 != this.v) {
            this.v = z2;
            L0();
        }
    }

    public LinearLayoutManager(Context context) {
        this(1, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void A0(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.B = (d) parcelable;
            L0();
        }
    }

    public boolean A1() {
        return this.t.i() == 0 && this.t.f() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public Parcelable B0() {
        d dVar = this.B;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        if (y() > 0) {
            g1();
            boolean z2 = this.u ^ this.w;
            dVar2.f197d = z2;
            if (z2) {
                View t1 = t1();
                dVar2.c = this.t.g() - this.t.b(t1);
                dVar2.b = R(t1);
            } else {
                View u1 = u1();
                dVar2.b = R(u1);
                dVar2.c = this.t.e(u1) - this.t.k();
            }
        } else {
            dVar2.b = -1;
        }
        return dVar2;
    }

    public final void B1() {
        this.w = (this.r == 1 || !v1()) ? this.v : !this.v;
    }

    public int C1(int i2, RecyclerView.t tVar, RecyclerView.y yVar) {
        if (y() == 0 || i2 == 0) {
            return 0;
        }
        g1();
        this.s.a = true;
        int i3 = i2 > 0 ? 1 : -1;
        int abs = Math.abs(i2);
        F1(i3, abs, true, yVar);
        c cVar = this.s;
        int h1 = h1(tVar, cVar, yVar, false) + cVar.f191g;
        if (h1 < 0) {
            return 0;
        }
        if (abs > h1) {
            i2 = i3 * h1;
        }
        this.t.p(-i2);
        this.s.f194j = i2;
        return i2;
    }

    public void D1(int i2) {
        if (i2 == 0 || i2 == 1) {
            d(null);
            if (i2 != this.r || this.t == null) {
                q a2 = q.a(this, i2);
                this.t = a2;
                this.C.a = a2;
                this.r = i2;
                L0();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(f.a.a.a.a.q("invalid orientation:", i2));
    }

    public void E1(boolean z2) {
        d(null);
        if (this.x != z2) {
            this.x = z2;
            L0();
        }
    }

    public final void F1(int i2, int i3, boolean z2, RecyclerView.y yVar) {
        int i4;
        this.s.f196l = A1();
        this.s.f190f = i2;
        int[] iArr = this.F;
        boolean z3 = false;
        iArr[0] = 0;
        int i5 = 1;
        iArr[1] = 0;
        a1(yVar, iArr);
        int max = Math.max(0, this.F[0]);
        int max2 = Math.max(0, this.F[1]);
        if (i2 == 1) {
            z3 = true;
        }
        c cVar = this.s;
        int i6 = z3 ? max2 : max;
        cVar.f192h = i6;
        if (!z3) {
            max = max2;
        }
        cVar.f193i = max;
        if (z3) {
            cVar.f192h = this.t.h() + i6;
            View t1 = t1();
            c cVar2 = this.s;
            if (this.w) {
                i5 = -1;
            }
            cVar2.f189e = i5;
            int R = R(t1);
            c cVar3 = this.s;
            cVar2.f188d = R + cVar3.f189e;
            cVar3.b = this.t.b(t1);
            i4 = this.t.b(t1) - this.t.g();
        } else {
            View u1 = u1();
            c cVar4 = this.s;
            cVar4.f192h = this.t.k() + cVar4.f192h;
            c cVar5 = this.s;
            if (!this.w) {
                i5 = -1;
            }
            cVar5.f189e = i5;
            int R2 = R(u1);
            c cVar6 = this.s;
            cVar5.f188d = R2 + cVar6.f189e;
            cVar6.b = this.t.e(u1);
            i4 = (-this.t.e(u1)) + this.t.k();
        }
        c cVar7 = this.s;
        cVar7.c = i3;
        if (z2) {
            cVar7.c = i3 - i4;
        }
        cVar7.f191g = i4;
    }

    public final void G1(int i2, int i3) {
        this.s.c = this.t.g() - i3;
        c cVar = this.s;
        cVar.f189e = this.w ? -1 : 1;
        cVar.f188d = i2;
        cVar.f190f = 1;
        cVar.b = i3;
        cVar.f191g = Integer.MIN_VALUE;
    }

    public final void H1(int i2, int i3) {
        this.s.c = i3 - this.t.k();
        c cVar = this.s;
        cVar.f188d = i2;
        cVar.f189e = this.w ? 1 : -1;
        cVar.f190f = -1;
        cVar.b = i3;
        cVar.f191g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int M0(int i2, RecyclerView.t tVar, RecyclerView.y yVar) {
        if (this.r == 1) {
            return 0;
        }
        return C1(i2, tVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void N0(int i2) {
        this.z = i2;
        this.A = Integer.MIN_VALUE;
        d dVar = this.B;
        if (dVar != null) {
            dVar.b = -1;
        }
        L0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int O0(int i2, RecyclerView.t tVar, RecyclerView.y yVar) {
        if (this.r == 0) {
            return 0;
        }
        return C1(i2, tVar, yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean V0() {
        boolean z2;
        if (!(this.o == 1073741824 || this.n == 1073741824)) {
            int y2 = y();
            int i2 = 0;
            while (true) {
                if (i2 >= y2) {
                    z2 = false;
                    break;
                }
                ViewGroup.LayoutParams layoutParams = x(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean W() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void X0(RecyclerView recyclerView, RecyclerView.y yVar, int i2) {
        l lVar = new l(recyclerView.getContext());
        lVar.a = i2;
        Y0(lVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean Z0() {
        return this.B == null && this.u == this.x;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x.b
    public PointF a(int i2) {
        if (y() == 0) {
            return null;
        }
        boolean z2 = false;
        int i3 = 1;
        if (i2 < R(x(0))) {
            z2 = true;
        }
        if (z2 != this.w) {
            i3 = -1;
        }
        return this.r == 0 ? new PointF((float) i3, 0.0f) : new PointF(0.0f, (float) i3);
    }

    public void a1(RecyclerView.y yVar, int[] iArr) {
        int i2;
        int l2 = yVar.a != -1 ? this.t.l() : 0;
        if (this.s.f190f == -1) {
            i2 = 0;
        } else {
            i2 = l2;
            l2 = 0;
        }
        iArr[0] = l2;
        iArr[1] = i2;
    }

    public void b1(RecyclerView.y yVar, c cVar, RecyclerView.m.c cVar2) {
        int i2 = cVar.f188d;
        if (i2 >= 0 && i2 < yVar.b()) {
            ((j.b) cVar2).a(i2, Math.max(0, cVar.f191g));
        }
    }

    public final int c1(RecyclerView.y yVar) {
        if (y() == 0) {
            return 0;
        }
        g1();
        return m.h.u(yVar, this.t, k1(!this.y, true), j1(!this.y, true), this, this.y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void d(String str) {
        RecyclerView recyclerView;
        if (this.B == null && (recyclerView = this.b) != null) {
            recyclerView.i(str);
        }
    }

    public final int d1(RecyclerView.y yVar) {
        if (y() == 0) {
            return 0;
        }
        g1();
        return m.h.v(yVar, this.t, k1(!this.y, true), j1(!this.y, true), this, this.y, this.w);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean e() {
        return this.r == 0;
    }

    public final int e1(RecyclerView.y yVar) {
        if (y() == 0) {
            return 0;
        }
        g1();
        return m.h.w(yVar, this.t, k1(!this.y, true), j1(!this.y, true), this, this.y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean f() {
        return this.r == 1;
    }

    public int f1(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.r == 1) ? 1 : Integer.MIN_VALUE : this.r == 0 ? 1 : Integer.MIN_VALUE : this.r == 1 ? -1 : Integer.MIN_VALUE : this.r == 0 ? -1 : Integer.MIN_VALUE : (this.r != 1 && v1()) ? -1 : 1 : (this.r != 1 && v1()) ? 1 : -1;
    }

    public void g1() {
        if (this.s == null) {
            this.s = new c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void h0(RecyclerView recyclerView, RecyclerView.t tVar) {
        g0();
    }

    public int h1(RecyclerView.t tVar, c cVar, RecyclerView.y yVar, boolean z2) {
        int i2 = cVar.c;
        int i3 = cVar.f191g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                cVar.f191g = i3 + i2;
            }
            y1(tVar, cVar);
        }
        int i4 = cVar.c + cVar.f192h;
        b bVar = this.D;
        while (true) {
            if ((!cVar.f196l && i4 <= 0) || !cVar.b(yVar)) {
                break;
            }
            bVar.a = 0;
            bVar.b = false;
            bVar.c = false;
            bVar.f187d = false;
            w1(tVar, yVar, cVar, bVar);
            if (!bVar.b) {
                int i5 = cVar.b;
                int i6 = bVar.a;
                cVar.b = (cVar.f190f * i6) + i5;
                if (!bVar.c || cVar.f195k != null || !yVar.f254g) {
                    cVar.c -= i6;
                    i4 -= i6;
                }
                int i7 = cVar.f191g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + i6;
                    cVar.f191g = i8;
                    int i9 = cVar.c;
                    if (i9 < 0) {
                        cVar.f191g = i8 + i9;
                    }
                    y1(tVar, cVar);
                }
                if (z2 && bVar.f187d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - cVar.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void i(int i2, int i3, RecyclerView.y yVar, RecyclerView.m.c cVar) {
        if (this.r != 0) {
            i2 = i3;
        }
        if (y() != 0 && i2 != 0) {
            g1();
            F1(i2 > 0 ? 1 : -1, Math.abs(i2), true, yVar);
            b1(yVar, this.s, cVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public View i0(View view, int i2, RecyclerView.t tVar, RecyclerView.y yVar) {
        int f1;
        View view2;
        B1();
        if (y() == 0 || (f1 = f1(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        g1();
        F1(f1, (int) (((float) this.t.l()) * 0.33333334f), false, yVar);
        c cVar = this.s;
        cVar.f191g = Integer.MIN_VALUE;
        cVar.a = false;
        h1(tVar, cVar, yVar, true);
        if (f1 == -1) {
            if (this.w) {
                view2 = o1(y() - 1, -1);
            } else {
                view2 = o1(0, y());
            }
        } else if (this.w) {
            view2 = o1(0, y());
        } else {
            view2 = o1(y() - 1, -1);
        }
        View u1 = f1 == -1 ? u1() : t1();
        if (!u1.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return u1;
    }

    public final View i1(RecyclerView.t tVar, RecyclerView.y yVar) {
        return q1(tVar, yVar, 0, y(), yVar.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void j(int i2, RecyclerView.m.c cVar) {
        boolean z2;
        int i3;
        d dVar = this.B;
        int i4 = -1;
        if (dVar == null || !dVar.d()) {
            B1();
            z2 = this.w;
            i3 = this.z;
            if (i3 == -1) {
                i3 = z2 ? i2 - 1 : 0;
            }
        } else {
            d dVar2 = this.B;
            z2 = dVar2.f197d;
            i3 = dVar2.b;
        }
        if (!z2) {
            i4 = 1;
        }
        for (int i5 = 0; i5 < this.E && i3 >= 0 && i3 < i2; i5++) {
            ((j.b) cVar).a(i3, 0);
            i3 += i4;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void j0(AccessibilityEvent accessibilityEvent) {
        RecyclerView.t tVar = this.b.c;
        k0(accessibilityEvent);
        if (y() > 0) {
            accessibilityEvent.setFromIndex(l1());
            accessibilityEvent.setToIndex(n1());
        }
    }

    public View j1(boolean z2, boolean z3) {
        int y2;
        int i2;
        if (this.w) {
            y2 = 0;
            i2 = y();
        } else {
            y2 = y() - 1;
            i2 = -1;
        }
        return p1(y2, i2, z2, z3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int k(RecyclerView.y yVar) {
        return c1(yVar);
    }

    public View k1(boolean z2, boolean z3) {
        int i2;
        int y2;
        if (this.w) {
            i2 = y() - 1;
            y2 = -1;
        } else {
            i2 = 0;
            y2 = y();
        }
        return p1(i2, y2, z2, z3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int l(RecyclerView.y yVar) {
        return d1(yVar);
    }

    public int l1() {
        View p1 = p1(0, y(), false, true);
        if (p1 == null) {
            return -1;
        }
        return R(p1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int m(RecyclerView.y yVar) {
        return e1(yVar);
    }

    public final View m1(RecyclerView.t tVar, RecyclerView.y yVar) {
        return q1(tVar, yVar, y() - 1, -1, yVar.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int n(RecyclerView.y yVar) {
        return c1(yVar);
    }

    public int n1() {
        View p1 = p1(y() - 1, -1, false, true);
        if (p1 == null) {
            return -1;
        }
        return R(p1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int o(RecyclerView.y yVar) {
        return d1(yVar);
    }

    public View o1(int i2, int i3) {
        int i4;
        int i5;
        g1();
        if ((i3 > i2 ? 1 : i3 < i2 ? (char) 65535 : 0) == 0) {
            return x(i2);
        }
        if (this.t.e(x(i2)) < this.t.k()) {
            i5 = 16644;
            i4 = 16388;
        } else {
            i5 = 4161;
            i4 = 4097;
        }
        return (this.r == 0 ? this.f225e : this.f226f).a(i2, i3, i5, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int p(RecyclerView.y yVar) {
        return e1(yVar);
    }

    public View p1(int i2, int i3, boolean z2, boolean z3) {
        g1();
        int i4 = 320;
        int i5 = z2 ? 24579 : 320;
        if (!z3) {
            i4 = 0;
        }
        return (this.r == 0 ? this.f225e : this.f226f).a(i2, i3, i5, i4);
    }

    public View q1(RecyclerView.t tVar, RecyclerView.y yVar, int i2, int i3, int i4) {
        g1();
        int k2 = this.t.k();
        int g2 = this.t.g();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View x2 = x(i2);
            int R = R(x2);
            if (R >= 0 && R < i4) {
                if (((RecyclerView.n) x2.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = x2;
                    }
                } else if (this.t.e(x2) < g2 && this.t.b(x2) >= k2) {
                    return x2;
                } else {
                    if (view == null) {
                        view = x2;
                    }
                }
            }
            i2 += i5;
        }
        return view != null ? view : view2;
    }

    public final int r1(int i2, RecyclerView.t tVar, RecyclerView.y yVar, boolean z2) {
        int g2;
        int g3 = this.t.g() - i2;
        if (g3 <= 0) {
            return 0;
        }
        int i3 = -C1(-g3, tVar, yVar);
        int i4 = i2 + i3;
        if (!z2 || (g2 = this.t.g() - i4) <= 0) {
            return i3;
        }
        this.t.p(g2);
        return g2 + i3;
    }

    public final int s1(int i2, RecyclerView.t tVar, RecyclerView.y yVar, boolean z2) {
        int k2;
        int k3 = i2 - this.t.k();
        if (k3 <= 0) {
            return 0;
        }
        int i3 = -C1(k3, tVar, yVar);
        int i4 = i2 + i3;
        if (!z2 || (k2 = i4 - this.t.k()) <= 0) {
            return i3;
        }
        this.t.p(-k2);
        return i3 - k2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public View t(int i2) {
        int y2 = y();
        if (y2 == 0) {
            return null;
        }
        int R = i2 - R(x(0));
        if (R >= 0 && R < y2) {
            View x2 = x(R);
            if (R(x2) == i2) {
                return x2;
            }
        }
        return super.t(i2);
    }

    public final View t1() {
        return x(this.w ? 0 : y() - 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n u() {
        return new RecyclerView.n(-2, -2);
    }

    public final View u1() {
        return x(this.w ? y() - 1 : 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0175  */
    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void v0(RecyclerView.t tVar, RecyclerView.y yVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        View t2;
        int i8;
        int i9;
        boolean z2;
        boolean z3;
        View view;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        if (!(this.B == null && this.z == -1) && yVar.b() == 0) {
            F0(tVar);
            return;
        }
        d dVar = this.B;
        if (dVar != null && dVar.d()) {
            this.z = this.B.b;
        }
        g1();
        this.s.a = false;
        B1();
        View I = I();
        a aVar = this.C;
        if (!aVar.f186e || this.z != -1 || this.B != null) {
            aVar.d();
            a aVar2 = this.C;
            aVar2.f185d = this.w ^ this.x;
            if (!yVar.f254g && (i10 = this.z) != -1) {
                if (i10 < 0 || i10 >= yVar.b()) {
                    this.z = -1;
                    this.A = Integer.MIN_VALUE;
                } else {
                    aVar2.b = this.z;
                    d dVar2 = this.B;
                    if (dVar2 != null && dVar2.d()) {
                        boolean z4 = this.B.f197d;
                        aVar2.f185d = z4;
                        if (z4) {
                            i15 = this.t.g();
                            i14 = this.B.c;
                        } else {
                            i13 = this.t.k();
                            i12 = this.B.c;
                            i11 = i13 + i12;
                            aVar2.c = i11;
                            z2 = true;
                            if (!z2) {
                            }
                            this.C.f186e = true;
                        }
                    } else if (this.A == Integer.MIN_VALUE) {
                        View t3 = t(this.z);
                        if (t3 != null) {
                            if (this.t.c(t3) <= this.t.l()) {
                                if (this.t.e(t3) - this.t.k() < 0) {
                                    aVar2.c = this.t.k();
                                    aVar2.f185d = false;
                                } else if (this.t.g() - this.t.b(t3) < 0) {
                                    aVar2.c = this.t.g();
                                    aVar2.f185d = true;
                                } else {
                                    aVar2.c = aVar2.f185d ? this.t.m() + this.t.b(t3) : this.t.e(t3);
                                }
                                z2 = true;
                                if (!z2) {
                                    if (y() != 0) {
                                        View I2 = I();
                                        if (I2 != null) {
                                            RecyclerView.n nVar = (RecyclerView.n) I2.getLayoutParams();
                                            if (!nVar.c() && nVar.a() >= 0 && nVar.a() < yVar.b()) {
                                                aVar2.c(I2, R(I2));
                                                z3 = true;
                                                if (!z3) {
                                                    aVar2.a();
                                                    aVar2.b = this.x ? yVar.b() - 1 : 0;
                                                }
                                            }
                                        }
                                        if (this.u == this.x) {
                                            if (aVar2.f185d) {
                                                view = this.w ? i1(tVar, yVar) : m1(tVar, yVar);
                                            } else {
                                                view = this.w ? m1(tVar, yVar) : i1(tVar, yVar);
                                            }
                                            if (view != null) {
                                                aVar2.b(view, R(view));
                                                if (!yVar.f254g && Z0()) {
                                                    if (this.t.e(view) >= this.t.g() || this.t.b(view) < this.t.k()) {
                                                        aVar2.c = aVar2.f185d ? this.t.g() : this.t.k();
                                                    }
                                                }
                                                z3 = true;
                                                if (!z3) {
                                                }
                                            }
                                        }
                                    }
                                    z3 = false;
                                    if (!z3) {
                                    }
                                }
                                this.C.f186e = true;
                            }
                        } else if (y() > 0) {
                            aVar2.f185d = (this.z < R(x(0))) == this.w;
                        }
                        aVar2.a();
                        z2 = true;
                        if (!z2) {
                        }
                        this.C.f186e = true;
                    } else {
                        boolean z5 = this.w;
                        aVar2.f185d = z5;
                        if (z5) {
                            i15 = this.t.g();
                            i14 = this.A;
                        } else {
                            i13 = this.t.k();
                            i12 = this.A;
                            i11 = i13 + i12;
                            aVar2.c = i11;
                            z2 = true;
                            if (!z2) {
                            }
                            this.C.f186e = true;
                        }
                    }
                    i11 = i15 - i14;
                    aVar2.c = i11;
                    z2 = true;
                    if (!z2) {
                    }
                    this.C.f186e = true;
                }
            }
            z2 = false;
            if (!z2) {
            }
            this.C.f186e = true;
        } else if (I != null && (this.t.e(I) >= this.t.g() || this.t.b(I) <= this.t.k())) {
            this.C.c(I, R(I));
        }
        c cVar = this.s;
        cVar.f190f = cVar.f194j >= 0 ? 1 : -1;
        int[] iArr = this.F;
        iArr[0] = 0;
        iArr[1] = 0;
        a1(yVar, iArr);
        int k2 = this.t.k() + Math.max(0, this.F[0]);
        int h2 = this.t.h() + Math.max(0, this.F[1]);
        if (!(!yVar.f254g || (i7 = this.z) == -1 || this.A == Integer.MIN_VALUE || (t2 = t(i7)) == null)) {
            if (this.w) {
                i8 = this.t.g() - this.t.b(t2);
                i9 = this.A;
            } else {
                i9 = this.t.e(t2) - this.t.k();
                i8 = this.A;
            }
            int i16 = i8 - i9;
            if (i16 > 0) {
                k2 += i16;
            } else {
                h2 -= i16;
            }
        }
        a aVar3 = this.C;
        x1(tVar, yVar, aVar3, (!aVar3.f185d ? !this.w : this.w) ? 1 : -1);
        q(tVar);
        this.s.f196l = A1();
        Objects.requireNonNull(this.s);
        this.s.f193i = 0;
        a aVar4 = this.C;
        if (aVar4.f185d) {
            H1(aVar4.b, aVar4.c);
            c cVar2 = this.s;
            cVar2.f192h = k2;
            h1(tVar, cVar2, yVar, false);
            c cVar3 = this.s;
            i3 = cVar3.b;
            int i17 = cVar3.f188d;
            int i18 = cVar3.c;
            if (i18 > 0) {
                h2 += i18;
            }
            a aVar5 = this.C;
            G1(aVar5.b, aVar5.c);
            c cVar4 = this.s;
            cVar4.f192h = h2;
            cVar4.f188d += cVar4.f189e;
            h1(tVar, cVar4, yVar, false);
            c cVar5 = this.s;
            i2 = cVar5.b;
            int i19 = cVar5.c;
            if (i19 > 0) {
                H1(i17, i3);
                c cVar6 = this.s;
                cVar6.f192h = i19;
                h1(tVar, cVar6, yVar, false);
                i3 = this.s.b;
            }
        } else {
            G1(aVar4.b, aVar4.c);
            c cVar7 = this.s;
            cVar7.f192h = h2;
            h1(tVar, cVar7, yVar, false);
            c cVar8 = this.s;
            i2 = cVar8.b;
            int i20 = cVar8.f188d;
            int i21 = cVar8.c;
            if (i21 > 0) {
                k2 += i21;
            }
            a aVar6 = this.C;
            H1(aVar6.b, aVar6.c);
            c cVar9 = this.s;
            cVar9.f192h = k2;
            cVar9.f188d += cVar9.f189e;
            h1(tVar, cVar9, yVar, false);
            c cVar10 = this.s;
            i3 = cVar10.b;
            int i22 = cVar10.c;
            if (i22 > 0) {
                G1(i20, i2);
                c cVar11 = this.s;
                cVar11.f192h = i22;
                h1(tVar, cVar11, yVar, false);
                i2 = this.s.b;
            }
        }
        if (y() > 0) {
            if (this.w ^ this.x) {
                int r1 = r1(i2, tVar, yVar, true);
                i5 = i3 + r1;
                i4 = i2 + r1;
                i6 = s1(i5, tVar, yVar, false);
            } else {
                int s1 = s1(i3, tVar, yVar, true);
                i5 = i3 + s1;
                i4 = i2 + s1;
                i6 = r1(i4, tVar, yVar, false);
            }
            i3 = i5 + i6;
            i2 = i4 + i6;
        }
        if (yVar.f258k && y() != 0 && !yVar.f254g && Z0()) {
            List<RecyclerView.b0> list = tVar.f236d;
            int size = list.size();
            int R = R(x(0));
            int i23 = 0;
            int i24 = 0;
            for (int i25 = 0; i25 < size; i25++) {
                RecyclerView.b0 b0Var = list.get(i25);
                if (!b0Var.m()) {
                    char c2 = (b0Var.f() < R) != this.w ? (char) 65535 : 1;
                    int c3 = this.t.c(b0Var.a);
                    if (c2 == 65535) {
                        i23 += c3;
                    } else {
                        i24 += c3;
                    }
                }
            }
            this.s.f195k = list;
            if (i23 > 0) {
                H1(R(u1()), i3);
                c cVar12 = this.s;
                cVar12.f192h = i23;
                cVar12.c = 0;
                cVar12.a(null);
                h1(tVar, this.s, yVar, false);
            }
            if (i24 > 0) {
                G1(R(t1()), i2);
                c cVar13 = this.s;
                cVar13.f192h = i24;
                cVar13.c = 0;
                cVar13.a(null);
                h1(tVar, this.s, yVar, false);
            }
            this.s.f195k = null;
        }
        if (!yVar.f254g) {
            q qVar = this.t;
            qVar.b = qVar.l();
        } else {
            this.C.d();
        }
        this.u = this.x;
    }

    public boolean v1() {
        return K() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void w0(RecyclerView.y yVar) {
        this.B = null;
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.C.d();
    }

    public void w1(RecyclerView.t tVar, RecyclerView.y yVar, c cVar, b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View c2 = cVar.c(tVar);
        if (c2 == null) {
            bVar.b = true;
            return;
        }
        RecyclerView.n nVar = (RecyclerView.n) c2.getLayoutParams();
        if (cVar.f195k == null) {
            if (this.w == (cVar.f190f == -1)) {
                c(c2, -1, false);
            } else {
                c(c2, 0, false);
            }
        } else {
            if (this.w == (cVar.f190f == -1)) {
                c(c2, -1, true);
            } else {
                c(c2, 0, true);
            }
        }
        RecyclerView.n nVar2 = (RecyclerView.n) c2.getLayoutParams();
        Rect L = this.b.L(c2);
        int z2 = RecyclerView.m.z(this.p, this.n, P() + O() + ((ViewGroup.MarginLayoutParams) nVar2).leftMargin + ((ViewGroup.MarginLayoutParams) nVar2).rightMargin + L.left + L.right + 0, ((ViewGroup.MarginLayoutParams) nVar2).width, e());
        int z3 = RecyclerView.m.z(this.q, this.o, N() + Q() + ((ViewGroup.MarginLayoutParams) nVar2).topMargin + ((ViewGroup.MarginLayoutParams) nVar2).bottomMargin + L.top + L.bottom + 0, ((ViewGroup.MarginLayoutParams) nVar2).height, f());
        if (U0(c2, z2, z3, nVar2)) {
            c2.measure(z2, z3);
        }
        bVar.a = this.t.c(c2);
        if (this.r == 1) {
            if (v1()) {
                i6 = this.p - P();
                i5 = i6 - this.t.d(c2);
            } else {
                i5 = O();
                i6 = this.t.d(c2) + i5;
            }
            int i7 = cVar.f190f;
            int i8 = cVar.b;
            if (i7 == -1) {
                i2 = i8;
                i3 = i6;
                i4 = i8 - bVar.a;
            } else {
                i4 = i8;
                i3 = i6;
                i2 = bVar.a + i8;
            }
        } else {
            int Q = Q();
            int d2 = this.t.d(c2) + Q;
            int i9 = cVar.f190f;
            int i10 = cVar.b;
            if (i9 == -1) {
                i3 = i10;
                i4 = Q;
                i2 = d2;
                i5 = i10 - bVar.a;
            } else {
                i4 = Q;
                i3 = bVar.a + i10;
                i2 = d2;
                i5 = i10;
            }
        }
        a0(c2, i5, i4, i3, i2);
        if (nVar.c() || nVar.b()) {
            bVar.c = true;
        }
        bVar.f187d = c2.hasFocusable();
    }

    public void x1(RecyclerView.t tVar, RecyclerView.y yVar, a aVar, int i2) {
    }

    public final void y1(RecyclerView.t tVar, c cVar) {
        if (cVar.a && !cVar.f196l) {
            int i2 = cVar.f191g;
            int i3 = cVar.f193i;
            if (cVar.f190f == -1) {
                int y2 = y();
                if (i2 >= 0) {
                    int f2 = (this.t.f() - i2) + i3;
                    if (this.w) {
                        for (int i4 = 0; i4 < y2; i4++) {
                            View x2 = x(i4);
                            if (this.t.e(x2) < f2 || this.t.o(x2) < f2) {
                                z1(tVar, 0, i4);
                                return;
                            }
                        }
                        return;
                    }
                    int i5 = y2 - 1;
                    for (int i6 = i5; i6 >= 0; i6--) {
                        View x3 = x(i6);
                        if (this.t.e(x3) < f2 || this.t.o(x3) < f2) {
                            z1(tVar, i5, i6);
                            return;
                        }
                    }
                }
            } else if (i2 >= 0) {
                int i7 = i2 - i3;
                int y3 = y();
                if (this.w) {
                    int i8 = y3 - 1;
                    for (int i9 = i8; i9 >= 0; i9--) {
                        View x4 = x(i9);
                        if (this.t.b(x4) > i7 || this.t.n(x4) > i7) {
                            z1(tVar, i8, i9);
                            return;
                        }
                    }
                    return;
                }
                for (int i10 = 0; i10 < y3; i10++) {
                    View x5 = x(i10);
                    if (this.t.b(x5) > i7 || this.t.n(x5) > i7) {
                        z1(tVar, 0, i10);
                        return;
                    }
                }
            }
        }
    }

    public final void z1(RecyclerView.t tVar, int i2, int i3) {
        if (i2 != i3) {
            if (i3 > i2) {
                for (int i4 = i3 - 1; i4 >= i2; i4--) {
                    I0(i4, tVar);
                }
                return;
            }
            while (i2 > i3) {
                I0(i2, tVar);
                i2--;
            }
        }
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.r = 1;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = true;
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.B = null;
        this.C = new a();
        this.D = new b();
        this.E = 2;
        this.F = new int[2];
        RecyclerView.m.d S = RecyclerView.m.S(context, attributeSet, i2, i3);
        D1(S.a);
        boolean z2 = S.c;
        d(null);
        if (z2 != this.v) {
            this.v = z2;
            L0();
        }
        E1(S.f233d);
    }
}
