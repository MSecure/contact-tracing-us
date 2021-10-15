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
import b.r.d.a0;
import b.r.d.r;
import b.r.d.t;
import com.google.android.gms.nearby.messages.BleSignal;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.m implements RecyclerView.w.b {
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
        public a0 f260a;

        /* renamed from: b  reason: collision with root package name */
        public int f261b;

        /* renamed from: c  reason: collision with root package name */
        public int f262c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f263d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f264e;

        public a() {
            d();
        }

        public void a() {
            this.f262c = this.f263d ? this.f260a.g() : this.f260a.k();
        }

        public void b(View view, int i) {
            if (this.f263d) {
                this.f262c = this.f260a.m() + this.f260a.b(view);
            } else {
                this.f262c = this.f260a.e(view);
            }
            this.f261b = i;
        }

        public void c(View view, int i) {
            int i2;
            int m = this.f260a.m();
            if (m >= 0) {
                b(view, i);
                return;
            }
            this.f261b = i;
            if (this.f263d) {
                int g2 = (this.f260a.g() - m) - this.f260a.b(view);
                this.f262c = this.f260a.g() - g2;
                if (g2 > 0) {
                    int c2 = this.f262c - this.f260a.c(view);
                    int k = this.f260a.k();
                    int min = c2 - (Math.min(this.f260a.e(view) - k, 0) + k);
                    if (min < 0) {
                        i2 = Math.min(g2, -min) + this.f262c;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                int e2 = this.f260a.e(view);
                int k2 = e2 - this.f260a.k();
                this.f262c = e2;
                if (k2 > 0) {
                    int g3 = (this.f260a.g() - Math.min(0, (this.f260a.g() - m) - this.f260a.b(view))) - (this.f260a.c(view) + e2);
                    if (g3 < 0) {
                        i2 = this.f262c - Math.min(k2, -g3);
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f262c = i2;
        }

        public void d() {
            this.f261b = -1;
            this.f262c = BleSignal.UNKNOWN_TX_POWER;
            this.f263d = false;
            this.f264e = false;
        }

        public String toString() {
            StringBuilder h = c.a.a.a.a.h("AnchorInfo{mPosition=");
            h.append(this.f261b);
            h.append(", mCoordinate=");
            h.append(this.f262c);
            h.append(", mLayoutFromEnd=");
            h.append(this.f263d);
            h.append(", mValid=");
            h.append(this.f264e);
            h.append('}');
            return h.toString();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f265a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f266b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f267c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f268d;
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f269a = true;

        /* renamed from: b  reason: collision with root package name */
        public int f270b;

        /* renamed from: c  reason: collision with root package name */
        public int f271c;

        /* renamed from: d  reason: collision with root package name */
        public int f272d;

        /* renamed from: e  reason: collision with root package name */
        public int f273e;

        /* renamed from: f  reason: collision with root package name */
        public int f274f;

        /* renamed from: g  reason: collision with root package name */
        public int f275g;
        public int h = 0;
        public int i = 0;
        public boolean j;
        public int k;
        public List<RecyclerView.a0> l = null;
        public boolean m;

        public void a(View view) {
            int i2;
            int a2;
            int size = this.l.size();
            View view2 = null;
            int i3 = Integer.MAX_VALUE;
            for (int i4 = 0; i4 < size; i4++) {
                View view3 = this.l.get(i4).itemView;
                RecyclerView.n nVar = (RecyclerView.n) view3.getLayoutParams();
                if (view3 != view && !nVar.c() && (a2 = (nVar.a() - this.f272d) * this.f273e) >= 0 && a2 < i3) {
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
            this.f272d = i2;
        }

        public boolean b(RecyclerView.x xVar) {
            int i2 = this.f272d;
            return i2 >= 0 && i2 < xVar.b();
        }

        public View c(RecyclerView.s sVar) {
            List<RecyclerView.a0> list = this.l;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    View view = this.l.get(i2).itemView;
                    RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
                    if (!nVar.c() && this.f272d == nVar.a()) {
                        a(view);
                        return view;
                    }
                }
                return null;
            }
            View view2 = sVar.j(this.f272d, false, Long.MAX_VALUE).itemView;
            this.f272d += this.f273e;
            return view2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class d implements Parcelable {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: b  reason: collision with root package name */
        public int f276b;

        /* renamed from: c  reason: collision with root package name */
        public int f277c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f278d;

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
            this.f276b = parcel.readInt();
            this.f277c = parcel.readInt();
            this.f278d = parcel.readInt() != 1 ? false : true;
        }

        public d(d dVar) {
            this.f276b = dVar.f276b;
            this.f277c = dVar.f277c;
            this.f278d = dVar.f278d;
        }

        public boolean a() {
            return this.f276b >= 0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f276b);
            parcel.writeInt(this.f277c);
            parcel.writeInt(this.f278d ? 1 : 0);
        }
    }

    public LinearLayoutManager(int i, boolean z2) {
        this.s = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = -1;
        this.B = BleSignal.UNKNOWN_TX_POWER;
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
                this.D.f260a = a2;
                this.s = i;
                I0();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(c.a.a.a.a.n("invalid orientation:", i));
    }

    public void B1(boolean z2) {
        d(null);
        if (this.y != z2) {
            this.y = z2;
            I0();
        }
    }

    public final void C1(int i, int i2, boolean z2, RecyclerView.x xVar) {
        int i3;
        this.t.m = x1();
        this.t.f274f = i;
        int[] iArr = this.G;
        boolean z3 = false;
        iArr[0] = 0;
        int i4 = 1;
        iArr[1] = 0;
        X0(xVar, iArr);
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
            cVar3.f273e = i4;
            c cVar4 = this.t;
            int P = P(q1);
            c cVar5 = this.t;
            cVar4.f272d = P + cVar5.f273e;
            cVar5.f270b = this.u.b(q1);
            i3 = this.u.b(q1) - this.u.g();
        } else {
            View r1 = r1();
            c cVar6 = this.t;
            cVar6.h = this.u.k() + cVar6.h;
            c cVar7 = this.t;
            if (!this.x) {
                i4 = -1;
            }
            cVar7.f273e = i4;
            c cVar8 = this.t;
            int P2 = P(r1);
            c cVar9 = this.t;
            cVar8.f272d = P2 + cVar9.f273e;
            cVar9.f270b = this.u.e(r1);
            i3 = (-this.u.e(r1)) + this.u.k();
        }
        c cVar10 = this.t;
        cVar10.f271c = i2;
        if (z2) {
            cVar10.f271c = i2 - i3;
        }
        this.t.f275g = i3;
    }

    public final void D1(int i, int i2) {
        this.t.f271c = this.u.g() - i2;
        this.t.f273e = this.x ? -1 : 1;
        c cVar = this.t;
        cVar.f272d = i;
        cVar.f274f = 1;
        cVar.f270b = i2;
        cVar.f275g = BleSignal.UNKNOWN_TX_POWER;
    }

    public final void E1(int i, int i2) {
        this.t.f271c = i2 - this.u.k();
        c cVar = this.t;
        cVar.f272d = i;
        cVar.f273e = this.x ? 1 : -1;
        c cVar2 = this.t;
        cVar2.f274f = -1;
        cVar2.f270b = i2;
        cVar2.f275g = BleSignal.UNKNOWN_TX_POWER;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int J0(int i, RecyclerView.s sVar, RecyclerView.x xVar) {
        if (this.s == 1) {
            return 0;
        }
        return z1(i, sVar, xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void K0(int i) {
        this.A = i;
        this.B = BleSignal.UNKNOWN_TX_POWER;
        d dVar = this.C;
        if (dVar != null) {
            dVar.f276b = -1;
        }
        I0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int L0(int i, RecyclerView.s sVar, RecyclerView.x xVar) {
        if (this.s == 0) {
            return 0;
        }
        return z1(i, sVar, xVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
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

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean U() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void U0(RecyclerView recyclerView, RecyclerView.x xVar, int i) {
        t tVar = new t(recyclerView.getContext());
        tVar.f329a = i;
        V0(tVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean W0() {
        return this.C == null && this.v == this.y;
    }

    public void X0(RecyclerView.x xVar, int[] iArr) {
        int i;
        int l = xVar.f343a != -1 ? this.u.l() : 0;
        if (this.t.f274f == -1) {
            i = 0;
        } else {
            i = l;
            l = 0;
        }
        iArr[0] = l;
        iArr[1] = i;
    }

    public void Y0(RecyclerView.x xVar, c cVar, RecyclerView.m.c cVar2) {
        int i = cVar.f272d;
        if (i >= 0 && i < xVar.b()) {
            ((r.b) cVar2).a(i, Math.max(0, cVar.f275g));
        }
    }

    public final int Z0(RecyclerView.x xVar) {
        if (y() == 0) {
            return 0;
        }
        d1();
        return i.j.k(xVar, this.u, h1(!this.z, true), g1(!this.z, true), this, this.z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w.b
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

    public final int a1(RecyclerView.x xVar) {
        if (y() == 0) {
            return 0;
        }
        d1();
        return i.j.l(xVar, this.u, h1(!this.z, true), g1(!this.z, true), this, this.z, this.x);
    }

    public final int b1(RecyclerView.x xVar) {
        if (y() == 0) {
            return 0;
        }
        d1();
        return i.j.m(xVar, this.u, h1(!this.z, true), g1(!this.z, true), this, this.z);
    }

    public int c1(int i) {
        if (i == 1) {
            return (this.s != 1 && s1()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.s != 1 && s1()) ? -1 : 1;
        }
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        return BleSignal.UNKNOWN_TX_POWER;
                    }
                    if (this.s == 1) {
                        return 1;
                    }
                    return BleSignal.UNKNOWN_TX_POWER;
                } else if (this.s == 0) {
                    return 1;
                } else {
                    return BleSignal.UNKNOWN_TX_POWER;
                }
            } else if (this.s == 1) {
                return -1;
            } else {
                return BleSignal.UNKNOWN_TX_POWER;
            }
        } else if (this.s == 0) {
            return -1;
        } else {
            return BleSignal.UNKNOWN_TX_POWER;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void d(String str) {
        RecyclerView recyclerView;
        if (this.C == null && (recyclerView = this.f298b) != null) {
            recyclerView.i(str);
        }
    }

    public void d1() {
        if (this.t == null) {
            this.t = new c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean e() {
        return this.s == 0;
    }

    public int e1(RecyclerView.s sVar, c cVar, RecyclerView.x xVar, boolean z2) {
        int i = cVar.f271c;
        int i2 = cVar.f275g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                cVar.f275g = i2 + i;
            }
            v1(sVar, cVar);
        }
        int i3 = cVar.f271c + cVar.h;
        b bVar = this.E;
        while (true) {
            if ((!cVar.m && i3 <= 0) || !cVar.b(xVar)) {
                break;
            }
            bVar.f265a = 0;
            bVar.f266b = false;
            bVar.f267c = false;
            bVar.f268d = false;
            t1(sVar, xVar, cVar, bVar);
            if (!bVar.f266b) {
                cVar.f270b = (bVar.f265a * cVar.f274f) + cVar.f270b;
                if (!bVar.f267c || cVar.l != null || !xVar.f349g) {
                    int i4 = cVar.f271c;
                    int i5 = bVar.f265a;
                    cVar.f271c = i4 - i5;
                    i3 -= i5;
                }
                int i6 = cVar.f275g;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + bVar.f265a;
                    cVar.f275g = i7;
                    int i8 = cVar.f271c;
                    if (i8 < 0) {
                        cVar.f275g = i7 + i8;
                    }
                    v1(sVar, cVar);
                }
                if (z2 && bVar.f268d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - cVar.f271c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean f() {
        return this.s == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void f0(RecyclerView recyclerView, RecyclerView.s sVar) {
        e0();
    }

    public final View f1(RecyclerView.s sVar, RecyclerView.x xVar) {
        return n1(sVar, xVar, 0, y(), xVar.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public View g0(View view, int i, RecyclerView.s sVar, RecyclerView.x xVar) {
        int c1;
        View view2;
        y1();
        if (y() == 0 || (c1 = c1(i)) == Integer.MIN_VALUE) {
            return null;
        }
        d1();
        C1(c1, (int) (((float) this.u.l()) * 0.33333334f), false, xVar);
        c cVar = this.t;
        cVar.f275g = BleSignal.UNKNOWN_TX_POWER;
        cVar.f269a = false;
        e1(sVar, cVar, xVar, true);
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

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void h0(AccessibilityEvent accessibilityEvent) {
        RecyclerView.s sVar = this.f298b.f280c;
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

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void i(int i, int i2, RecyclerView.x xVar, RecyclerView.m.c cVar) {
        if (this.s != 0) {
            i = i2;
        }
        if (y() != 0 && i != 0) {
            d1();
            C1(i > 0 ? 1 : -1, Math.abs(i), true, xVar);
            Y0(xVar, this.t, cVar);
        }
    }

    public int i1() {
        View m1 = m1(0, y(), false, true);
        if (m1 == null) {
            return -1;
        }
        return P(m1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void j(int i, RecyclerView.m.c cVar) {
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
            z2 = dVar2.f278d;
            i2 = dVar2.f276b;
        }
        if (!z2) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.F && i2 >= 0 && i2 < i; i4++) {
            ((r.b) cVar).a(i2, 0);
            i2 += i3;
        }
    }

    public final View j1(RecyclerView.s sVar, RecyclerView.x xVar) {
        return n1(sVar, xVar, y() - 1, -1, xVar.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int k(RecyclerView.x xVar) {
        return Z0(xVar);
    }

    public int k1() {
        View m1 = m1(y() - 1, -1, false, true);
        if (m1 == null) {
            return -1;
        }
        return P(m1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int l(RecyclerView.x xVar) {
        return a1(xVar);
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
        return (this.s == 0 ? this.f301e : this.f302f).a(i, i2, i4, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int m(RecyclerView.x xVar) {
        return b1(xVar);
    }

    public View m1(int i, int i2, boolean z2, boolean z3) {
        d1();
        int i3 = 320;
        int i4 = z2 ? 24579 : 320;
        if (!z3) {
            i3 = 0;
        }
        return (this.s == 0 ? this.f301e : this.f302f).a(i, i2, i4, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int n(RecyclerView.x xVar) {
        return Z0(xVar);
    }

    public View n1(RecyclerView.s sVar, RecyclerView.x xVar, int i, int i2, int i3) {
        d1();
        int k = this.u.k();
        int g2 = this.u.g();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View x2 = x(i);
            int P = P(x2);
            if (P >= 0 && P < i3) {
                if (((RecyclerView.n) x2.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = x2;
                    }
                } else if (this.u.e(x2) < g2 && this.u.b(x2) >= k) {
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

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int o(RecyclerView.x xVar) {
        return a1(xVar);
    }

    public final int o1(int i, RecyclerView.s sVar, RecyclerView.x xVar, boolean z2) {
        int g2;
        int g3 = this.u.g() - i;
        if (g3 <= 0) {
            return 0;
        }
        int i2 = -z1(-g3, sVar, xVar);
        int i3 = i + i2;
        if (!z2 || (g2 = this.u.g() - i3) <= 0) {
            return i2;
        }
        this.u.p(g2);
        return g2 + i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int p(RecyclerView.x xVar) {
        return b1(xVar);
    }

    public final int p1(int i, RecyclerView.s sVar, RecyclerView.x xVar, boolean z2) {
        int k;
        int k2 = i - this.u.k();
        if (k2 <= 0) {
            return 0;
        }
        int i2 = -z1(k2, sVar, xVar);
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
    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void s0(RecyclerView.s sVar, RecyclerView.x xVar) {
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
        if (!(this.C == null && this.A == -1) && xVar.b() == 0) {
            C0(sVar);
            return;
        }
        d dVar = this.C;
        if (dVar != null && dVar.a()) {
            this.A = this.C.f276b;
        }
        d1();
        this.t.f269a = false;
        y1();
        View H = H();
        boolean z4 = true;
        if (!this.D.f264e || this.A != -1 || this.C != null) {
            this.D.d();
            a aVar = this.D;
            aVar.f263d = this.x ^ this.y;
            if (!xVar.f349g && (i9 = this.A) != -1) {
                if (i9 < 0 || i9 >= xVar.b()) {
                    this.A = -1;
                    this.B = BleSignal.UNKNOWN_TX_POWER;
                } else {
                    aVar.f261b = this.A;
                    d dVar2 = this.C;
                    if (dVar2 != null && dVar2.a()) {
                        boolean z5 = this.C.f278d;
                        aVar.f263d = z5;
                        if (z5) {
                            i14 = this.u.g();
                            i13 = this.C.f277c;
                        } else {
                            i12 = this.u.k();
                            i11 = this.C.f277c;
                            i10 = i12 + i11;
                            aVar.f262c = i10;
                            z2 = true;
                            if (!z2) {
                            }
                            this.D.f264e = true;
                        }
                    } else if (this.B == Integer.MIN_VALUE) {
                        View t3 = t(this.A);
                        if (t3 != null) {
                            if (this.u.c(t3) <= this.u.l()) {
                                if (this.u.e(t3) - this.u.k() < 0) {
                                    aVar.f262c = this.u.k();
                                    aVar.f263d = false;
                                } else if (this.u.g() - this.u.b(t3) < 0) {
                                    aVar.f262c = this.u.g();
                                    aVar.f263d = true;
                                } else {
                                    aVar.f262c = aVar.f263d ? this.u.m() + this.u.b(t3) : this.u.e(t3);
                                }
                                z2 = true;
                                if (!z2) {
                                    if (y() != 0) {
                                        View H2 = H();
                                        if (H2 != null) {
                                            RecyclerView.n nVar = (RecyclerView.n) H2.getLayoutParams();
                                            if (!nVar.c() && nVar.a() >= 0 && nVar.a() < xVar.b()) {
                                                aVar.c(H2, P(H2));
                                                z3 = true;
                                                if (!z3) {
                                                    aVar.a();
                                                    aVar.f261b = this.y ? xVar.b() - 1 : 0;
                                                }
                                            }
                                        }
                                        if (this.v == this.y) {
                                            if (aVar.f263d) {
                                                view = this.x ? f1(sVar, xVar) : j1(sVar, xVar);
                                            } else {
                                                view = this.x ? j1(sVar, xVar) : f1(sVar, xVar);
                                            }
                                            if (view != null) {
                                                aVar.b(view, P(view));
                                                if (!xVar.f349g && W0()) {
                                                    if (this.u.e(view) >= this.u.g() || this.u.b(view) < this.u.k()) {
                                                        aVar.f262c = aVar.f263d ? this.u.g() : this.u.k();
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
                                this.D.f264e = true;
                            }
                        } else if (y() > 0) {
                            aVar.f263d = (this.A < P(x(0))) == this.x;
                        }
                        aVar.a();
                        z2 = true;
                        if (!z2) {
                        }
                        this.D.f264e = true;
                    } else {
                        boolean z6 = this.x;
                        aVar.f263d = z6;
                        if (z6) {
                            i14 = this.u.g();
                            i13 = this.B;
                        } else {
                            i12 = this.u.k();
                            i11 = this.B;
                            i10 = i12 + i11;
                            aVar.f262c = i10;
                            z2 = true;
                            if (!z2) {
                            }
                            this.D.f264e = true;
                        }
                    }
                    i10 = i14 - i13;
                    aVar.f262c = i10;
                    z2 = true;
                    if (!z2) {
                    }
                    this.D.f264e = true;
                }
            }
            z2 = false;
            if (!z2) {
            }
            this.D.f264e = true;
        } else if (H != null && (this.u.e(H) >= this.u.g() || this.u.b(H) <= this.u.k())) {
            this.D.c(H, P(H));
        }
        c cVar = this.t;
        cVar.f274f = cVar.k >= 0 ? 1 : -1;
        int[] iArr = this.G;
        iArr[0] = 0;
        iArr[1] = 0;
        X0(xVar, iArr);
        int k = this.u.k() + Math.max(0, this.G[0]);
        int h = this.u.h() + Math.max(0, this.G[1]);
        if (!(!xVar.f349g || (i6 = this.A) == -1 || this.B == Integer.MIN_VALUE || (t2 = t(i6)) == null)) {
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
        u1(sVar, xVar, this.D, (!this.D.f263d ? !this.x : this.x) ? 1 : -1);
        q(sVar);
        this.t.m = x1();
        c cVar2 = this.t;
        cVar2.j = xVar.f349g;
        cVar2.i = 0;
        a aVar2 = this.D;
        if (aVar2.f263d) {
            E1(aVar2.f261b, aVar2.f262c);
            c cVar3 = this.t;
            cVar3.h = k;
            e1(sVar, cVar3, xVar, false);
            c cVar4 = this.t;
            i2 = cVar4.f270b;
            int i16 = cVar4.f272d;
            int i17 = cVar4.f271c;
            if (i17 > 0) {
                h += i17;
            }
            a aVar3 = this.D;
            D1(aVar3.f261b, aVar3.f262c);
            c cVar5 = this.t;
            cVar5.h = h;
            cVar5.f272d += cVar5.f273e;
            e1(sVar, cVar5, xVar, false);
            c cVar6 = this.t;
            i = cVar6.f270b;
            int i18 = cVar6.f271c;
            if (i18 > 0) {
                E1(i16, i2);
                c cVar7 = this.t;
                cVar7.h = i18;
                e1(sVar, cVar7, xVar, false);
                i2 = this.t.f270b;
            }
        } else {
            D1(aVar2.f261b, aVar2.f262c);
            c cVar8 = this.t;
            cVar8.h = h;
            e1(sVar, cVar8, xVar, false);
            c cVar9 = this.t;
            i = cVar9.f270b;
            int i19 = cVar9.f272d;
            int i20 = cVar9.f271c;
            if (i20 > 0) {
                k += i20;
            }
            a aVar4 = this.D;
            E1(aVar4.f261b, aVar4.f262c);
            c cVar10 = this.t;
            cVar10.h = k;
            cVar10.f272d += cVar10.f273e;
            e1(sVar, cVar10, xVar, false);
            c cVar11 = this.t;
            i2 = cVar11.f270b;
            int i21 = cVar11.f271c;
            if (i21 > 0) {
                D1(i19, i);
                c cVar12 = this.t;
                cVar12.h = i21;
                e1(sVar, cVar12, xVar, false);
                i = this.t.f270b;
            }
        }
        if (y() > 0) {
            if (this.x ^ this.y) {
                int o1 = o1(i, sVar, xVar, true);
                i4 = i2 + o1;
                i3 = i + o1;
                i5 = p1(i4, sVar, xVar, false);
            } else {
                int p1 = p1(i2, sVar, xVar, true);
                i4 = i2 + p1;
                i3 = i + p1;
                i5 = o1(i3, sVar, xVar, false);
            }
            i2 = i4 + i5;
            i = i3 + i5;
        }
        if (xVar.k && y() != 0 && !xVar.f349g && W0()) {
            List<RecyclerView.a0> list = sVar.f323d;
            int size = list.size();
            int P = P(x(0));
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            while (i22 < size) {
                RecyclerView.a0 a0Var = list.get(i22);
                if (!a0Var.isRemoved()) {
                    boolean z7 = (a0Var.getLayoutPosition() < P ? z4 : false) != this.x ? true : true;
                    int c2 = this.u.c(a0Var.itemView);
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
                cVar13.f271c = 0;
                cVar13.a(null);
                e1(sVar, this.t, xVar, false);
            }
            if (i24 > 0) {
                D1(P(q1()), i);
                c cVar14 = this.t;
                cVar14.h = i24;
                cVar14.f271c = 0;
                cVar14.a(null);
                e1(sVar, this.t, xVar, false);
            }
            this.t.l = null;
        }
        if (!xVar.f349g) {
            a0 a0Var2 = this.u;
            a0Var2.f2294b = a0Var2.l();
        } else {
            this.D.d();
        }
        this.v = this.y;
    }

    public boolean s1() {
        return I() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
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

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void t0(RecyclerView.x xVar) {
        this.C = null;
        this.A = -1;
        this.B = BleSignal.UNKNOWN_TX_POWER;
        this.D.d();
    }

    public void t1(RecyclerView.s sVar, RecyclerView.x xVar, c cVar, b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        View c2 = cVar.c(sVar);
        if (c2 == null) {
            bVar.f266b = true;
            return;
        }
        RecyclerView.n nVar = (RecyclerView.n) c2.getLayoutParams();
        if (cVar.l == null) {
            if (this.x == (cVar.f274f == -1)) {
                c(c2, -1, false);
            } else {
                c(c2, 0, false);
            }
        } else {
            if (this.x == (cVar.f274f == -1)) {
                c(c2, -1, true);
            } else {
                c(c2, 0, true);
            }
        }
        RecyclerView.n nVar2 = (RecyclerView.n) c2.getLayoutParams();
        Rect M = this.f298b.M(c2);
        int z2 = RecyclerView.m.z(this.q, this.o, N() + M() + ((ViewGroup.MarginLayoutParams) nVar2).leftMargin + ((ViewGroup.MarginLayoutParams) nVar2).rightMargin + M.left + M.right + 0, ((ViewGroup.MarginLayoutParams) nVar2).width, e());
        int z3 = RecyclerView.m.z(this.r, this.p, L() + O() + ((ViewGroup.MarginLayoutParams) nVar2).topMargin + ((ViewGroup.MarginLayoutParams) nVar2).bottomMargin + M.top + M.bottom + 0, ((ViewGroup.MarginLayoutParams) nVar2).height, f());
        if (R0(c2, z2, z3, nVar2)) {
            c2.measure(z2, z3);
        }
        bVar.f265a = this.u.c(c2);
        if (this.s == 1) {
            if (s1()) {
                i5 = this.q - N();
                i4 = i5 - this.u.d(c2);
            } else {
                i4 = M();
                i5 = this.u.d(c2) + i4;
            }
            int i6 = cVar.f274f;
            int i7 = cVar.f270b;
            if (i6 == -1) {
                i = i7;
                i2 = i5;
                i3 = i7 - bVar.f265a;
            } else {
                i3 = i7;
                i2 = i5;
                i = bVar.f265a + i7;
            }
        } else {
            int O = O();
            int d2 = this.u.d(c2) + O;
            int i8 = cVar.f274f;
            int i9 = cVar.f270b;
            if (i8 == -1) {
                i2 = i9;
                i3 = O;
                i = d2;
                i4 = i9 - bVar.f265a;
            } else {
                i3 = O;
                i2 = bVar.f265a + i9;
                i = d2;
                i4 = i9;
            }
        }
        Y(c2, i4, i3, i2, i);
        if (nVar.c() || nVar.b()) {
            bVar.f267c = true;
        }
        bVar.f268d = c2.hasFocusable();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n u() {
        return new RecyclerView.n(-2, -2);
    }

    public void u1(RecyclerView.s sVar, RecyclerView.x xVar, a aVar, int i) {
    }

    public final void v1(RecyclerView.s sVar, c cVar) {
        if (cVar.f269a && !cVar.m) {
            int i = cVar.f275g;
            int i2 = cVar.i;
            if (cVar.f274f == -1) {
                int y2 = y();
                if (i >= 0) {
                    int f2 = (this.u.f() - i) + i2;
                    if (this.x) {
                        for (int i3 = 0; i3 < y2; i3++) {
                            View x2 = x(i3);
                            if (this.u.e(x2) < f2 || this.u.o(x2) < f2) {
                                w1(sVar, 0, i3);
                                return;
                            }
                        }
                        return;
                    }
                    int i4 = y2 - 1;
                    for (int i5 = i4; i5 >= 0; i5--) {
                        View x3 = x(i5);
                        if (this.u.e(x3) < f2 || this.u.o(x3) < f2) {
                            w1(sVar, i4, i5);
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
                            w1(sVar, i7, i8);
                            return;
                        }
                    }
                    return;
                }
                for (int i9 = 0; i9 < y3; i9++) {
                    View x5 = x(i9);
                    if (this.u.b(x5) > i6 || this.u.n(x5) > i6) {
                        w1(sVar, 0, i9);
                        return;
                    }
                }
            }
        }
    }

    public final void w1(RecyclerView.s sVar, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    F0(i3, sVar);
                }
                return;
            }
            while (i > i2) {
                F0(i, sVar);
                i--;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void x0(Parcelable parcelable) {
        if (parcelable instanceof d) {
            this.C = (d) parcelable;
            I0();
        }
    }

    public boolean x1() {
        return this.u.i() == 0 && this.u.f() == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public Parcelable y0() {
        d dVar = this.C;
        if (dVar != null) {
            return new d(dVar);
        }
        d dVar2 = new d();
        if (y() > 0) {
            d1();
            boolean z2 = this.v ^ this.x;
            dVar2.f278d = z2;
            if (z2) {
                View q1 = q1();
                dVar2.f277c = this.u.g() - this.u.b(q1);
                dVar2.f276b = P(q1);
            } else {
                View r1 = r1();
                dVar2.f276b = P(r1);
                dVar2.f277c = this.u.e(r1) - this.u.k();
            }
        } else {
            dVar2.f276b = -1;
        }
        return dVar2;
    }

    public final void y1() {
        this.x = (this.s == 1 || !s1()) ? this.w : !this.w;
    }

    public int z1(int i, RecyclerView.s sVar, RecyclerView.x xVar) {
        if (y() == 0 || i == 0) {
            return 0;
        }
        d1();
        this.t.f269a = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        C1(i2, abs, true, xVar);
        c cVar = this.t;
        int e1 = e1(sVar, cVar, xVar, false) + cVar.f275g;
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
        this.B = BleSignal.UNKNOWN_TX_POWER;
        this.C = null;
        this.D = new a();
        this.E = new b();
        this.F = 2;
        this.G = new int[2];
        RecyclerView.m.d Q = RecyclerView.m.Q(context, attributeSet, i, i2);
        A1(Q.f306a);
        boolean z2 = Q.f308c;
        d(null);
        if (z2 != this.w) {
            this.w = z2;
            I0();
        }
        B1(Q.f309d);
    }
}
