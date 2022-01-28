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
import b.q.d.a0;
import b.q.d.r;
import b.q.d.t;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.z.b {
    public int A;
    public int B;
    public d C;
    public final a D;
    public final b E;
    public int F;
    public int[] G;
    public int s;
    public c t;
    public a0 u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public a0 f179a;

        /* renamed from: b  reason: collision with root package name */
        public int f180b;

        /* renamed from: c  reason: collision with root package name */
        public int f181c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f182d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f183e;

        public a() {
            d();
        }

        public void a() {
            this.f181c = this.f182d ? this.f179a.g() : this.f179a.k();
        }

        public void b(View view, int i) {
            if (this.f182d) {
                this.f181c = this.f179a.m() + this.f179a.b(view);
            } else {
                this.f181c = this.f179a.e(view);
            }
            this.f180b = i;
        }

        public void c(View view, int i) {
            int i2;
            int m = this.f179a.m();
            if (m >= 0) {
                b(view, i);
                return;
            }
            this.f180b = i;
            if (this.f182d) {
                int g = (this.f179a.g() - m) - this.f179a.b(view);
                this.f181c = this.f179a.g() - g;
                if (g > 0) {
                    int c2 = this.f181c - this.f179a.c(view);
                    int k = this.f179a.k();
                    int min = c2 - (Math.min(this.f179a.e(view) - k, 0) + k);
                    if (min < 0) {
                        i2 = Math.min(g, -min) + this.f181c;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                int e2 = this.f179a.e(view);
                int k2 = e2 - this.f179a.k();
                this.f181c = e2;
                if (k2 > 0) {
                    int g2 = (this.f179a.g() - Math.min(0, (this.f179a.g() - m) - this.f179a.b(view))) - (this.f179a.c(view) + e2);
                    if (g2 < 0) {
                        i2 = this.f181c - Math.min(k2, -g2);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f181c = i2;
        }

        public void d() {
            this.f180b = -1;
            this.f181c = Integer.MIN_VALUE;
            this.f182d = false;
            this.f183e = false;
        }

        public String toString() {
            StringBuilder g = c.a.a.a.a.g("AnchorInfo{mPosition=");
            g.append(this.f180b);
            g.append(", mCoordinate=");
            g.append(this.f181c);
            g.append(", mLayoutFromEnd=");
            g.append(this.f182d);
            g.append(", mValid=");
            g.append(this.f183e);
            g.append('}');
            return g.toString();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f184a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f185b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f186c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f187d;
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f188a = true;

        /* renamed from: b  reason: collision with root package name */
        public int f189b;

        /* renamed from: c  reason: collision with root package name */
        public int f190c;

        /* renamed from: d  reason: collision with root package name */
        public int f191d;

        /* renamed from: e  reason: collision with root package name */
        public int f192e;
        public int f;
        public int g;
        public int h = 0;
        public int i = 0;
        public boolean j;
        public int k;
        public List<RecyclerView.d0> l = null;
        public boolean m;

        public void a(View view) {
            int i2;
            int a2;
            int size = this.l.size();
            View view2 = null;
            int i3 = Integer.MAX_VALUE;
            for (int i4 = 0; i4 < size; i4++) {
                View view3 = this.l.get(i4).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (a2 = (pVar.a() - this.f191d) * this.f192e) >= 0 && a2 < i3) {
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
                i2 = ((RecyclerView.p) view2.getLayoutParams()).a();
            }
            this.f191d = i2;
        }

        public boolean b(RecyclerView.a0 a0Var) {
            int i2 = this.f191d;
            return i2 >= 0 && i2 < a0Var.b();
        }

        public View c(RecyclerView.v vVar) {
            List<RecyclerView.d0> list = this.l;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    View view = this.l.get(i2).itemView;
                    RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                    if (!pVar.c() && this.f191d == pVar.a()) {
                        a(view);
                        return view;
                    }
                }
                return null;
            }
            View view2 = vVar.k(this.f191d, false, RecyclerView.FOREVER_NS).itemView;
            this.f191d += this.f192e;
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f193b;

        /* renamed from: c  reason: collision with root package name */
        public int f194c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f195d;

        public static class a implements Parcelable.Creator<d> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public d createFromParcel(Parcel parcel) {
                return new d(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public d[] newArray(int i) {
                return new d[i];
            }
        }

        public d() {
        }

        public d(Parcel parcel) {
            this.f193b = parcel.readInt();
            this.f194c = parcel.readInt();
            this.f195d = parcel.readInt() != 1 ? false : true;
        }

        public d(d dVar) {
            this.f193b = dVar.f193b;
            this.f194c = dVar.f194c;
            this.f195d = dVar.f195d;
        }

        public boolean a() {
            return this.f193b >= 0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f193b);
            parcel.writeInt(this.f194c);
            parcel.writeInt(this.f195d ? 1 : 0);
        }
    }

    public LinearLayoutManager(int i, boolean z2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.C = null;
        this.D = new a();
        this.E = new b();
        this.F = 2;
        this.G = new int[2];
        A1(i);
        d(null);
        if (z2 != this.w) {
            this.w = z2;
            I0();
        }
    }

    public void A1(int i) {
        if (i == 0 || i == 1) {
            d(null);
            if (i != this.s || this.u == null) {
                a0 a2 = a0.a(this, i);
                this.u = a2;
                this.D.f179a = a2;
                this.s = i;
                I0();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(c.a.a.a.a.l("invalid orientation:", i));
    }

    public void B1(boolean z2) {
        d(null);
        if (this.y != z2) {
            this.y = z2;
            I0();
        }
    }

    public final void C1(int i, int i2, boolean z2, RecyclerView.a0 a0Var) {
        int i3;
        this.t.m = x1();
        this.t.f = i;
        int[] iArr = this.G;
        boolean z3 = false;
        iArr[0] = 0;
        int i4 = 1;
        iArr[1] = 0;
        X0(a0Var, iArr);
        int max = Math.max(0, this.G[0]);
        int max2 = Math.max(0, this.G[1]);
        if (i == 1) {
            z3 = true;
        }
        this.t.h = z3 ? max2 : max;
        c cVar = this.t;
        if (!z3) {
            max = max2;
        }
        cVar.i = max;
        if (z3) {
            c cVar2 = this.t;
            cVar2.h = this.u.h() + cVar2.h;
            View q1 = q1();
            c cVar3 = this.t;
            if (this.x) {
                i4 = -1;
            }
            cVar3.f192e = i4;
            c cVar4 = this.t;
            int P = P(q1);
            c cVar5 = this.t;
            cVar4.f191d = P + cVar5.f192e;
            cVar5.f189b = this.u.b(q1);
            i3 = this.u.b(q1) - this.u.g();
        } else {
            View r1 = r1();
            c cVar6 = this.t;
            cVar6.h = this.u.k() + cVar6.h;
            c cVar7 = this.t;
            if (!this.x) {
                i4 = -1;
            }
            cVar7.f192e = i4;
            c cVar8 = this.t;
            int P2 = P(r1);
            c cVar9 = this.t;
            cVar8.f191d = P2 + cVar9.f192e;
            cVar9.f189b = this.u.e(r1);
            i3 = (-this.u.e(r1)) + this.u.k();
        }
        c cVar10 = this.t;
        cVar10.f190c = i2;
        if (z2) {
            cVar10.f190c = i2 - i3;
        }
        this.t.g = i3;
    }

    public final void D1(int i, int i2) {
        this.t.f190c = this.u.g() - i2;
        this.t.f192e = this.x ? -1 : 1;
        c cVar = this.t;
        cVar.f191d = i;
        cVar.f = 1;
        cVar.f189b = i2;
        cVar.g = Integer.MIN_VALUE;
    }

    public final void E1(int i, int i2) {
        this.t.f190c = i2 - this.u.k();
        c cVar = this.t;
        cVar.f191d = i;
        cVar.f192e = this.x ? 1 : -1;
        c cVar2 = this.t;
        cVar2.f = -1;
        cVar2.f189b = i2;
        cVar2.g = Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int J0(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 1) {
            return 0;
        }
        return z1(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(int i) {
        this.A = i;
        this.B = Integer.MIN_VALUE;
        d dVar = this.C;
        if (dVar != null) {
            dVar.f193b = -1;
        }
        I0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int L0(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 0) {
            return 0;
        }
        return z1(i, vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean S0() {
        boolean z2;
        if (this.p == 1073741824 || this.o == 1073741824) {
            return false;
        }
        int y2 = y();
        int i = 0;
        while (true) {
            if (i >= y2) {
                z2 = false;
                break;
            }
            ViewGroup.LayoutParams layoutParams = x(i).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                z2 = true;
                break;
            }
            i++;
        }
        return z2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean U() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void U0(RecyclerView recyclerView, RecyclerView.a0 a0Var, int i) {
        t tVar = new t(recyclerView.getContext());
        tVar.f246a = i;
        V0(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean W0() {
        return this.C == null && this.v == this.y;
    }

    public void X0(RecyclerView.a0 a0Var, int[] iArr) {
        int i;
        int l = a0Var.f197a != -1 ? this.u.l() : 0;
        if (this.t.f == -1) {
            i = 0;
        } else {
            i = l;
            l = 0;
        }
        iArr[0] = l;
        iArr[1] = i;
    }

    public void Y0(RecyclerView.a0 a0Var, c cVar, RecyclerView.o.c cVar2) {
        int i = cVar.f191d;
        if (i >= 0 && i < a0Var.b()) {
            ((r.b) cVar2).a(i, Math.max(0, cVar.g));
        }
    }

    public final int Z0(RecyclerView.a0 a0Var) {
        if (y() == 0) {
            return 0;
        }
        d1();
        return i.j.x(a0Var, this.u, h1(!this.z, true), g1(!this.z, true), this, this.z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.z.b
    public PointF a(int i) {
        if (y() == 0) {
            return null;
        }
        boolean z2 = false;
        int i2 = 1;
        if (i < P(x(0))) {
            z2 = true;
        }
        if (z2 != this.x) {
            i2 = -1;
        }
        return this.s == 0 ? new PointF((float) i2, 0.0f) : new PointF(0.0f, (float) i2);
    }

    public final int a1(RecyclerView.a0 a0Var) {
        if (y() == 0) {
            return 0;
        }
        d1();
        return i.j.y(a0Var, this.u, h1(!this.z, true), g1(!this.z, true), this, this.z, this.x);
    }

    public final int b1(RecyclerView.a0 a0Var) {
        if (y() == 0) {
            return 0;
        }
        d1();
        return i.j.z(a0Var, this.u, h1(!this.z, true), g1(!this.z, true), this, this.z);
    }

    public int c1(int i) {
        if (i == 1) {
            return (this.s != 1 && s1()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.s != 1 && s1()) ? -1 : 1;
        }
        if (i == 17) {
            return this.s == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 33) {
            return this.s == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 66) {
            return this.s == 0 ? 1 : Integer.MIN_VALUE;
        }
        if (i != 130) {
            return Integer.MIN_VALUE;
        }
        return this.s == 1 ? 1 : Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d(String str) {
        RecyclerView recyclerView;
        if (this.C == null && (recyclerView = this.f219b) != null) {
            recyclerView.assertNotInLayoutOrScroll(str);
        }
    }

    public void d1() {
        if (this.t == null) {
            this.t = new c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean e() {
        return this.s == 0;
    }

    public int e1(RecyclerView.v vVar, c cVar, RecyclerView.a0 a0Var, boolean z2) {
        int i = cVar.f190c;
        int i2 = cVar.g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.g = i2 + i;
            }
            v1(vVar, cVar);
        }
        int i3 = cVar.f190c + cVar.h;
        b bVar = this.E;
        while (true) {
            if ((!cVar.m && i3 <= 0) || !cVar.b(a0Var)) {
                break;
            }
            bVar.f184a = 0;
            bVar.f185b = false;
            bVar.f186c = false;
            bVar.f187d = false;
            t1(vVar, a0Var, cVar, bVar);
            if (!bVar.f185b) {
                cVar.f189b = (bVar.f184a * cVar.f) + cVar.f189b;
                if (!bVar.f186c || cVar.l != null || !a0Var.g) {
                    int i4 = cVar.f190c;
                    int i5 = bVar.f184a;
                    cVar.f190c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.g;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + bVar.f184a;
                    cVar.g = i7;
                    int i8 = cVar.f190c;
                    if (i8 < 0) {
                        cVar.g = i7 + i8;
                    }
                    v1(vVar, cVar);
                }
                if (z2 && bVar.f187d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.f190c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean f() {
        return this.s == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void f0(RecyclerView recyclerView, RecyclerView.v vVar) {
        e0();
    }

    public final View f1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return n1(vVar, a0Var, 0, y(), a0Var.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View g0(View view, int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int c1;
        View view2;
        y1();
        if (y() == 0 || (c1 = c1(i)) == Integer.MIN_VALUE) {
            return null;
        }
        d1();
        C1(c1, (int) (((float) this.u.l()) * 0.33333334f), false, a0Var);
        c cVar = this.t;
        cVar.g = Integer.MIN_VALUE;
        cVar.f188a = false;
        e1(vVar, cVar, a0Var, true);
        if (c1 == -1) {
            if (this.x) {
                view2 = l1(y() - 1, -1);
            } else {
                view2 = l1(0, y());
            }
        } else if (this.x) {
            view2 = l1(0, y());
        } else {
            view2 = l1(y() - 1, -1);
        }
        View r1 = c1 == -1 ? r1() : q1();
        if (!r1.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return r1;
    }

    public View g1(boolean z2, boolean z3) {
        int y2;
        int i;
        if (this.x) {
            y2 = 0;
            i = y();
        } else {
            y2 = y() - 1;
            i = -1;
        }
        return m1(y2, i, z2, z3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void h0(AccessibilityEvent accessibilityEvent) {
        RecyclerView.v vVar = this.f219b.mRecycler;
        i0(accessibilityEvent);
        if (y() > 0) {
            accessibilityEvent.setFromIndex(i1());
            accessibilityEvent.setToIndex(k1());
        }
    }

    public View h1(boolean z2, boolean z3) {
        int i;
        int y2;
        if (this.x) {
            i = y() - 1;
            y2 = -1;
        } else {
            i = 0;
            y2 = y();
        }
        return m1(i, y2, z2, z3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i(int i, int i2, RecyclerView.a0 a0Var, RecyclerView.o.c cVar) {
        if (this.s != 0) {
            i = i2;
        }
        if (y() != 0 && i != 0) {
            d1();
            C1(i > 0 ? 1 : -1, Math.abs(i), true, a0Var);
            Y0(a0Var, this.t, cVar);
        }
    }

    public int i1() {
        View m1 = m1(0, y(), false, true);
        if (m1 == null) {
            return -1;
        }
        return P(m1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void j(int i, RecyclerView.o.c cVar) {
        boolean z2;
        int i2;
        d dVar = this.C;
        int i3 = -1;
        if (dVar == null || !dVar.a()) {
            y1();
            z2 = this.x;
            i2 = this.A;
            if (i2 == -1) {
                i2 = z2 ? i - 1 : 0;
            }
        } else {
            d dVar2 = this.C;
            z2 = dVar2.f195d;
            i2 = dVar2.f193b;
        }
        if (!z2) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.F && i2 >= 0 && i2 < i; i4++) {
            ((r.b) cVar).a(i2, 0);
            i2 += i3;
        }
    }

    public final View j1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return n1(vVar, a0Var, y() - 1, -1, a0Var.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int k(RecyclerView.a0 a0Var) {
        return Z0(a0Var);
    }

    public int k1() {
        View m1 = m1(y() - 1, -1, false, true);
        if (m1 == null) {
            return -1;
        }
        return P(m1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int l(RecyclerView.a0 a0Var) {
        return a1(a0Var);
    }

    public View l1(int i, int i2) {
        int i3;
        int i4;
        d1();
        if ((i2 > i ? 1 : i2 < i ? (char) 65535 : 0) == 0) {
            return x(i);
        }
        if (this.u.e(x(i)) < this.u.k()) {
            i4 = 16644;
            i3 = 16388;
        } else {
            i4 = 4161;
            i3 = 4097;
        }
        return (this.s == 0 ? this.f222e : this.f).a(i, i2, i4, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int m(RecyclerView.a0 a0Var) {
        return b1(a0Var);
    }

    public View m1(int i, int i2, boolean z2, boolean z3) {
        d1();
        int i3 = 320;
        int i4 = z2 ? 24579 : 320;
        if (!z3) {
            i3 = 0;
        }
        return (this.s == 0 ? this.f222e : this.f).a(i, i2, i4, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int n(RecyclerView.a0 a0Var) {
        return Z0(a0Var);
    }

    public View n1(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i, int i2, int i3) {
        d1();
        int k = this.u.k();
        int g = this.u.g();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View x2 = x(i);
            int P = P(x2);
            if (P >= 0 && P < i3) {
                if (((RecyclerView.p) x2.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = x2;
                    }
                } else if (this.u.e(x2) < g && this.u.b(x2) >= k) {
                    return x2;
                } else {
                    if (view == null) {
                        view = x2;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int o(RecyclerView.a0 a0Var) {
        return a1(a0Var);
    }

    public final int o1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z2) {
        int g;
        int g2 = this.u.g() - i;
        if (g2 <= 0) {
            return 0;
        }
        int i2 = -z1(-g2, vVar, a0Var);
        int i3 = i + i2;
        if (!z2 || (g = this.u.g() - i3) <= 0) {
            return i2;
        }
        this.u.p(g);
        return g + i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int p(RecyclerView.a0 a0Var) {
        return b1(a0Var);
    }

    public final int p1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z2) {
        int k;
        int k2 = i - this.u.k();
        if (k2 <= 0) {
            return 0;
        }
        int i2 = -z1(k2, vVar, a0Var);
        int i3 = i + i2;
        if (!z2 || (k = i3 - this.u.k()) <= 0) {
            return i2;
        }
        this.u.p(-k);
        return i2 - k;
    }

    public final View q1() {
        return x(this.x ? 0 : y() - 1);
    }

    public final View r1() {
        return x(this.x ? y() - 1 : 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0177  */
    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void s0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View t2;
        int i7;
        int i8;
        boolean z2;
        boolean z3;
        View view;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        if (!(this.C == null && this.A == -1) && a0Var.b() == 0) {
            C0(vVar);
            return;
        }
        d dVar = this.C;
        if (dVar != null && dVar.a()) {
            this.A = this.C.f193b;
        }
        d1();
        this.t.f188a = false;
        y1();
        View H = H();
        boolean z4 = true;
        if (!this.D.f183e || this.A != -1 || this.C != null) {
            this.D.d();
            a aVar = this.D;
            aVar.f182d = this.x ^ this.y;
            if (!a0Var.g && (i9 = this.A) != -1) {
                if (i9 < 0 || i9 >= a0Var.b()) {
                    this.A = -1;
                    this.B = Integer.MIN_VALUE;
                } else {
                    aVar.f180b = this.A;
                    d dVar2 = this.C;
                    if (dVar2 != null && dVar2.a()) {
                        boolean z5 = this.C.f195d;
                        aVar.f182d = z5;
                        if (z5) {
                            i14 = this.u.g();
                            i13 = this.C.f194c;
                        } else {
                            i12 = this.u.k();
                            i11 = this.C.f194c;
                            i10 = i12 + i11;
                            aVar.f181c = i10;
                            z2 = true;
                            if (!z2) {
                            }
                            this.D.f183e = true;
                        }
                    } else if (this.B == Integer.MIN_VALUE) {
                        View t3 = t(this.A);
                        if (t3 != null) {
                            if (this.u.c(t3) <= this.u.l()) {
                                if (this.u.e(t3) - this.u.k() < 0) {
                                    aVar.f181c = this.u.k();
                                    aVar.f182d = false;
                                } else if (this.u.g() - this.u.b(t3) < 0) {
                                    aVar.f181c = this.u.g();
                                    aVar.f182d = true;
                                } else {
                                    aVar.f181c = aVar.f182d ? this.u.m() + this.u.b(t3) : this.u.e(t3);
                                }
                                z2 = true;
                                if (!z2) {
                                    if (y() != 0) {
                                        View H2 = H();
                                        if (H2 != null) {
                                            RecyclerView.p pVar = (RecyclerView.p) H2.getLayoutParams();
                                            if (!pVar.c() && pVar.a() >= 0 && pVar.a() < a0Var.b()) {
                                                aVar.c(H2, P(H2));
                                                z3 = true;
                                                if (!z3) {
                                                    aVar.a();
                                                    aVar.f180b = this.y ? a0Var.b() - 1 : 0;
                                                }
                                            }
                                        }
                                        if (this.v == this.y) {
                                            if (aVar.f182d) {
                                                view = this.x ? f1(vVar, a0Var) : j1(vVar, a0Var);
                                            } else {
                                                view = this.x ? j1(vVar, a0Var) : f1(vVar, a0Var);
                                            }
                                            if (view != null) {
                                                aVar.b(view, P(view));
                                                if (!a0Var.g && W0()) {
                                                    if (this.u.e(view) >= this.u.g() || this.u.b(view) < this.u.k()) {
                                                        aVar.f181c = aVar.f182d ? this.u.g() : this.u.k();
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
                                this.D.f183e = true;
                            }
                        } else if (y() > 0) {
                            aVar.f182d = (this.A < P(x(0))) == this.x;
                        }
                        aVar.a();
                        z2 = true;
                        if (!z2) {
                        }
                        this.D.f183e = true;
                    } else {
                        boolean z6 = this.x;
                        aVar.f182d = z6;
                        if (z6) {
                            i14 = this.u.g();
                            i13 = this.B;
                        } else {
                            i12 = this.u.k();
                            i11 = this.B;
                            i10 = i12 + i11;
                            aVar.f181c = i10;
                            z2 = true;
                            if (!z2) {
                            }
                            this.D.f183e = true;
                        }
                    }
                    i10 = i14 - i13;
                    aVar.f181c = i10;
                    z2 = true;
                    if (!z2) {
                    }
                    this.D.f183e = true;
                }
            }
            z2 = false;
            if (!z2) {
            }
            this.D.f183e = true;
        } else if (H != null && (this.u.e(H) >= this.u.g() || this.u.b(H) <= this.u.k())) {
            this.D.c(H, P(H));
        }
        c cVar = this.t;
        cVar.f = cVar.k >= 0 ? 1 : -1;
        int[] iArr = this.G;
        iArr[0] = 0;
        iArr[1] = 0;
        X0(a0Var, iArr);
        int k = this.u.k() + Math.max(0, this.G[0]);
        int h = this.u.h() + Math.max(0, this.G[1]);
        if (!(!a0Var.g || (i6 = this.A) == -1 || this.B == Integer.MIN_VALUE || (t2 = t(i6)) == null)) {
            if (this.x) {
                i7 = this.u.g() - this.u.b(t2);
                i8 = this.B;
            } else {
                i8 = this.u.e(t2) - this.u.k();
                i7 = this.B;
            }
            int i15 = i7 - i8;
            if (i15 > 0) {
                k += i15;
            } else {
                h -= i15;
            }
        }
        u1(vVar, a0Var, this.D, (!this.D.f182d ? !this.x : this.x) ? 1 : -1);
        q(vVar);
        this.t.m = x1();
        c cVar2 = this.t;
        cVar2.j = a0Var.g;
        cVar2.i = 0;
        a aVar2 = this.D;
        if (aVar2.f182d) {
            E1(aVar2.f180b, aVar2.f181c);
            c cVar3 = this.t;
            cVar3.h = k;
            e1(vVar, cVar3, a0Var, false);
            c cVar4 = this.t;
            i2 = cVar4.f189b;
            int i16 = cVar4.f191d;
            int i17 = cVar4.f190c;
            if (i17 > 0) {
                h += i17;
            }
            a aVar3 = this.D;
            D1(aVar3.f180b, aVar3.f181c);
            c cVar5 = this.t;
            cVar5.h = h;
            cVar5.f191d += cVar5.f192e;
            e1(vVar, cVar5, a0Var, false);
            c cVar6 = this.t;
            i = cVar6.f189b;
            int i18 = cVar6.f190c;
            if (i18 > 0) {
                E1(i16, i2);
                c cVar7 = this.t;
                cVar7.h = i18;
                e1(vVar, cVar7, a0Var, false);
                i2 = this.t.f189b;
            }
        } else {
            D1(aVar2.f180b, aVar2.f181c);
            c cVar8 = this.t;
            cVar8.h = h;
            e1(vVar, cVar8, a0Var, false);
            c cVar9 = this.t;
            i = cVar9.f189b;
            int i19 = cVar9.f191d;
            int i20 = cVar9.f190c;
            if (i20 > 0) {
                k += i20;
            }
            a aVar4 = this.D;
            E1(aVar4.f180b, aVar4.f181c);
            c cVar10 = this.t;
            cVar10.h = k;
            cVar10.f191d += cVar10.f192e;
            e1(vVar, cVar10, a0Var, false);
            c cVar11 = this.t;
            i2 = cVar11.f189b;
            int i21 = cVar11.f190c;
            if (i21 > 0) {
                D1(i19, i);
                c cVar12 = this.t;
                cVar12.h = i21;
                e1(vVar, cVar12, a0Var, false);
                i = this.t.f189b;
            }
        }
        if (y() > 0) {
            if (this.x ^ this.y) {
                int o1 = o1(i, vVar, a0Var, true);
                i4 = i2 + o1;
                i3 = i + o1;
                i5 = p1(i4, vVar, a0Var, false);
            } else {
                int p1 = p1(i2, vVar, a0Var, true);
                i4 = i2 + p1;
                i3 = i + p1;
                i5 = o1(i3, vVar, a0Var, false);
            }
            i2 = i4 + i5;
            i = i3 + i5;
        }
        if (a0Var.k && y() != 0 && !a0Var.g && W0()) {
            List<RecyclerView.d0> list = vVar.f242d;
            int size = list.size();
            int P = P(x(0));
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            while (i22 < size) {
                RecyclerView.d0 d0Var = list.get(i22);
                if (!d0Var.isRemoved()) {
                    boolean z7 = (d0Var.getLayoutPosition() < P ? z4 : false) != this.x ? true : true;
                    int c2 = this.u.c(d0Var.itemView);
                    if (z7) {
                        i23 += c2;
                    } else {
                        i24 += c2;
                    }
                }
                i22++;
                z4 = true;
            }
            this.t.l = list;
            if (i23 > 0) {
                E1(P(r1()), i2);
                c cVar13 = this.t;
                cVar13.h = i23;
                cVar13.f190c = 0;
                cVar13.a(null);
                e1(vVar, this.t, a0Var, false);
            }
            if (i24 > 0) {
                D1(P(q1()), i);
                c cVar14 = this.t;
                cVar14.h = i24;
                cVar14.f190c = 0;
                cVar14.a(null);
                e1(vVar, this.t, a0Var, false);
            }
            this.t.l = null;
        }
        if (!a0Var.g) {
            a0 a0Var2 = this.u;
            a0Var2.f1454b = a0Var2.l();
        } else {
            this.D.d();
        }
        this.v = this.y;
    }

    public boolean s1() {
        return I() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View t(int i) {
        int y2 = y();
        if (y2 == 0) {
            return null;
        }
        int P = i - P(x(0));
        if (P >= 0 && P < y2) {
            View x2 = x(P);
            if (P(x2) == i) {
                return x2;
            }
        }
        return super.t(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void t0(RecyclerView.a0 a0Var) {
        this.C = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D.d();
    }

    public void t1(RecyclerView.v vVar, RecyclerView.a0 a0Var, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View c2 = cVar.c(vVar);
        if (c2 == null) {
            bVar.f185b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) c2.getLayoutParams();
        if (cVar.l == null) {
            if (this.x == (cVar.f == -1)) {
                c(c2, -1, false);
            } else {
                c(c2, 0, false);
            }
        } else {
            if (this.x == (cVar.f == -1)) {
                c(c2, -1, true);
            } else {
                c(c2, 0, true);
            }
        }
        RecyclerView.p pVar2 = (RecyclerView.p) c2.getLayoutParams();
        Rect itemDecorInsetsForChild = this.f219b.getItemDecorInsetsForChild(c2);
        int z2 = RecyclerView.o.z(this.q, this.o, N() + M() + ((ViewGroup.MarginLayoutParams) pVar2).leftMargin + ((ViewGroup.MarginLayoutParams) pVar2).rightMargin + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + 0, ((ViewGroup.MarginLayoutParams) pVar2).width, e());
        int z3 = RecyclerView.o.z(this.r, this.p, L() + O() + ((ViewGroup.MarginLayoutParams) pVar2).topMargin + ((ViewGroup.MarginLayoutParams) pVar2).bottomMargin + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + 0, ((ViewGroup.MarginLayoutParams) pVar2).height, f());
        if (R0(c2, z2, z3, pVar2)) {
            c2.measure(z2, z3);
        }
        bVar.f184a = this.u.c(c2);
        if (this.s == 1) {
            if (s1()) {
                i5 = this.q - N();
                i4 = i5 - this.u.d(c2);
            } else {
                i4 = M();
                i5 = this.u.d(c2) + i4;
            }
            int i6 = cVar.f;
            int i7 = cVar.f189b;
            if (i6 == -1) {
                i = i7;
                i2 = i5;
                i3 = i7 - bVar.f184a;
            } else {
                i3 = i7;
                i2 = i5;
                i = bVar.f184a + i7;
            }
        } else {
            int O = O();
            int d2 = this.u.d(c2) + O;
            int i8 = cVar.f;
            int i9 = cVar.f189b;
            if (i8 == -1) {
                i2 = i9;
                i3 = O;
                i = d2;
                i4 = i9 - bVar.f184a;
            } else {
                i3 = O;
                i2 = bVar.f184a + i9;
                i = d2;
                i4 = i9;
            }
        }
        Y(c2, i4, i3, i2, i);
        if (pVar.c() || pVar.b()) {
            bVar.f186c = true;
        }
        bVar.f187d = c2.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p u() {
        return new RecyclerView.p(-2, -2);
    }

    public void u1(RecyclerView.v vVar, RecyclerView.a0 a0Var, a aVar, int i) {
    }

    public final void v1(RecyclerView.v vVar, c cVar) {
        if (cVar.f188a && !cVar.m) {
            int i = cVar.g;
            int i2 = cVar.i;
            if (cVar.f == -1) {
                int y2 = y();
                if (i >= 0) {
                    int f = (this.u.f() - i) + i2;
                    if (this.x) {
                        for (int i3 = 0; i3 < y2; i3++) {
                            View x2 = x(i3);
                            if (this.u.e(x2) < f || this.u.o(x2) < f) {
                                w1(vVar, 0, i3);
                                return;
                            }
                        }
                        return;
                    }
                    int i4 = y2 - 1;
                    for (int i5 = i4; i5 >= 0; i5--) {
                        View x3 = x(i5);
                        if (this.u.e(x3) < f || this.u.o(x3) < f) {
                            w1(vVar, i4, i5);
                            return;
                        }
                    }
                }
            } else if (i >= 0) {
                int i6 = i - i2;
                int y3 = y();
                if (this.x) {
                    int i7 = y3 - 1;
                    for (int i8 = i7; i8 >= 0; i8--) {
                        View x4 = x(i8);
                        if (this.u.b(x4) > i6 || this.u.n(x4) > i6) {
                            w1(vVar, i7, i8);
                            return;
                        }
                    }
                    return;
                }
                for (int i9 = 0; i9 < y3; i9++) {
                    View x5 = x(i9);
                    if (this.u.b(x5) > i6 || this.u.n(x5) > i6) {
                        w1(vVar, 0, i9);
                        return;
                    }
                }
            }
        }
    }

    public final void w1(RecyclerView.v vVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    F0(i3, vVar);
                }
                return;
            }
            while (i > i2) {
                F0(i, vVar);
                i--;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void x0(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.C = (d) parcelable;
            I0();
        }
    }

    public boolean x1() {
        return this.u.i() == 0 && this.u.f() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable y0() {
        d dVar = this.C;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        if (y() > 0) {
            d1();
            boolean z2 = this.v ^ this.x;
            dVar2.f195d = z2;
            if (z2) {
                View q1 = q1();
                dVar2.f194c = this.u.g() - this.u.b(q1);
                dVar2.f193b = P(q1);
            } else {
                View r1 = r1();
                dVar2.f193b = P(r1);
                dVar2.f194c = this.u.e(r1) - this.u.k();
            }
        } else {
            dVar2.f193b = -1;
        }
        return dVar2;
    }

    public final void y1() {
        this.x = (this.s == 1 || !s1()) ? this.w : !this.w;
    }

    public int z1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (y() == 0 || i == 0) {
            return 0;
        }
        d1();
        this.t.f188a = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        C1(i2, abs, true, a0Var);
        c cVar = this.t;
        int e1 = e1(vVar, cVar, a0Var, false) + cVar.g;
        if (e1 < 0) {
            return 0;
        }
        if (abs > e1) {
            i = i2 * e1;
        }
        this.u.p(-i);
        this.t.k = i;
        return i;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.C = null;
        this.D = new a();
        this.E = new b();
        this.F = 2;
        this.G = new int[2];
        RecyclerView.o.d Q = RecyclerView.o.Q(context, attributeSet, i, i2);
        A1(Q.f225a);
        boolean z2 = Q.f227c;
        d(null);
        if (z2 != this.w) {
            this.w = z2;
            I0();
        }
        B1(Q.f228d);
    }
}
