package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import e.i.i.w.b;
import e.s.a.j;
import java.util.Arrays;
import java.util.Objects;

public class GridLayoutManager extends LinearLayoutManager {
    public boolean G = false;
    public int H = -1;
    public int[] I;
    public View[] J;
    public final SparseIntArray K = new SparseIntArray();
    public final SparseIntArray L = new SparseIntArray();
    public c M = new a();
    public final Rect N = new Rect();

    public static final class a extends c {
    }

    public static class b extends RecyclerView.n {

        /* renamed from: e  reason: collision with root package name */
        public int f183e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f184f = 0;

        public b(int i2, int i3) {
            super(i2, i3);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public static abstract class c {
        public final SparseIntArray a = new SparseIntArray();
        public final SparseIntArray b = new SparseIntArray();

        public int a(int i2, int i3) {
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i4++;
                if (i4 == i3) {
                    i5++;
                    i4 = 0;
                } else if (i4 > i3) {
                    i5++;
                    i4 = 1;
                }
            }
            return i4 + 1 > i3 ? i5 + 1 : i5;
        }
    }

    public GridLayoutManager(Context context, int i2, int i3, boolean z) {
        super(i3, z);
        Q1(i2);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Q1(RecyclerView.m.S(context, attributeSet, i2, i3).b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int A(RecyclerView.t tVar, RecyclerView.y yVar) {
        if (this.r == 1) {
            return this.H;
        }
        if (yVar.b() < 1) {
            return 0;
        }
        return L1(tVar, yVar, yVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void E1(boolean z) {
        if (!z) {
            d(null);
            if (this.x) {
                this.x = false;
                L0();
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public final void I1(int i2) {
        int i3;
        int[] iArr = this.I;
        int i4 = this.H;
        if (!(iArr != null && iArr.length == i4 + 1 && iArr[iArr.length - 1] == i2)) {
            iArr = new int[(i4 + 1)];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i2 / i4;
        int i7 = i2 % i4;
        int i8 = 0;
        for (int i9 = 1; i9 <= i4; i9++) {
            i5 += i7;
            if (i5 <= 0 || i4 - i5 >= i7) {
                i3 = i6;
            } else {
                i3 = i6 + 1;
                i5 -= i4;
            }
            i8 += i3;
            iArr[i9] = i8;
        }
        this.I = iArr;
    }

    public final void J1() {
        View[] viewArr = this.J;
        if (viewArr == null || viewArr.length != this.H) {
            this.J = new View[this.H];
        }
    }

    public int K1(int i2, int i3) {
        if (this.r != 1 || !v1()) {
            int[] iArr = this.I;
            return iArr[i3 + i2] - iArr[i2];
        }
        int[] iArr2 = this.I;
        int i4 = this.H;
        return iArr2[i4 - i2] - iArr2[(i4 - i2) - i3];
    }

    public final int L1(RecyclerView.t tVar, RecyclerView.y yVar, int i2) {
        if (!yVar.f254g) {
            return this.M.a(i2, this.H);
        }
        int c2 = tVar.c(i2);
        if (c2 != -1) {
            return this.M.a(c2, this.H);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i2);
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public int M0(int i2, RecyclerView.t tVar, RecyclerView.y yVar) {
        R1();
        J1();
        if (this.r == 1) {
            return 0;
        }
        return C1(i2, tVar, yVar);
    }

    public final int M1(RecyclerView.t tVar, RecyclerView.y yVar, int i2) {
        if (!yVar.f254g) {
            c cVar = this.M;
            int i3 = this.H;
            Objects.requireNonNull(cVar);
            return i2 % i3;
        }
        int i4 = this.L.get(i2, -1);
        if (i4 != -1) {
            return i4;
        }
        int c2 = tVar.c(i2);
        if (c2 == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
            return 0;
        }
        c cVar2 = this.M;
        int i5 = this.H;
        Objects.requireNonNull(cVar2);
        return c2 % i5;
    }

    public final int N1(RecyclerView.t tVar, RecyclerView.y yVar, int i2) {
        if (!yVar.f254g) {
            Objects.requireNonNull(this.M);
            return 1;
        }
        int i3 = this.K.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        if (tVar.c(i2) == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
            return 1;
        }
        Objects.requireNonNull(this.M);
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public int O0(int i2, RecyclerView.t tVar, RecyclerView.y yVar) {
        R1();
        J1();
        if (this.r == 0) {
            return 0;
        }
        return C1(i2, tVar, yVar);
    }

    public final void O1(View view, int i2, boolean z) {
        int i3;
        int i4;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.b;
        int i5 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i6 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int K1 = K1(bVar.f183e, bVar.f184f);
        if (this.r == 1) {
            i3 = RecyclerView.m.z(K1, i2, i6, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i4 = RecyclerView.m.z(this.t.l(), this.o, i5, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int z2 = RecyclerView.m.z(K1, i2, i5, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int z3 = RecyclerView.m.z(this.t.l(), this.n, i6, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            i4 = z2;
            i3 = z3;
        }
        P1(view, i3, i4, z);
    }

    public final void P1(View view, int i2, int i3, boolean z) {
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        if (z ? W0(view, i2, i3, nVar) : U0(view, i2, i3, nVar)) {
            view.measure(i2, i3);
        }
    }

    public void Q1(int i2) {
        if (i2 != this.H) {
            this.G = true;
            if (i2 >= 1) {
                this.H = i2;
                this.M.a.clear();
                L0();
                return;
            }
            throw new IllegalArgumentException(f.a.a.a.a.q("Span count should be at least 1. Provided ", i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void R0(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        if (this.I == null) {
            super.R0(rect, i2, i3);
        }
        int P = P() + O();
        int N2 = N() + Q();
        if (this.r == 1) {
            i5 = RecyclerView.m.h(i3, rect.height() + N2, L());
            int[] iArr = this.I;
            i4 = RecyclerView.m.h(i2, iArr[iArr.length - 1] + P, M());
        } else {
            i4 = RecyclerView.m.h(i2, rect.width() + P, M());
            int[] iArr2 = this.I;
            i5 = RecyclerView.m.h(i3, iArr2[iArr2.length - 1] + N2, L());
        }
        this.b.setMeasuredDimension(i4, i5);
    }

    public final void R1() {
        int i2;
        int i3;
        if (this.r == 1) {
            i3 = this.p - P();
            i2 = O();
        } else {
            i3 = this.q - N();
            i2 = Q();
        }
        I1(i3 - i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int T(RecyclerView.t tVar, RecyclerView.y yVar) {
        if (this.r == 0) {
            return this.H;
        }
        if (yVar.b() < 1) {
            return 0;
        }
        return L1(tVar, yVar, yVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public boolean Z0() {
        return this.B == null && !this.G;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void b1(RecyclerView.y yVar, LinearLayoutManager.c cVar, RecyclerView.m.c cVar2) {
        int i2 = this.H;
        for (int i3 = 0; i3 < this.H && cVar.b(yVar) && i2 > 0; i3++) {
            ((j.b) cVar2).a(cVar.f188d, Math.max(0, cVar.f191g));
            Objects.requireNonNull(this.M);
            i2--;
            cVar.f188d += cVar.f189e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean g(RecyclerView.n nVar) {
        return nVar instanceof b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ca, code lost:
        if (r13 == (r2 > r15)) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e6, code lost:
        if (r13 == (r2 > r8)) goto L_0x00e8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f0  */
    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public View i0(View view, int i2, RecyclerView.t tVar, RecyclerView.y yVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        View view2;
        View view3;
        boolean z;
        RecyclerView.t tVar2 = tVar;
        RecyclerView.y yVar2 = yVar;
        View s = s(view);
        View view4 = null;
        if (s == null) {
            return null;
        }
        b bVar = (b) s.getLayoutParams();
        int i7 = bVar.f183e;
        int i8 = bVar.f184f + i7;
        if (super.i0(view, i2, tVar, yVar) == null) {
            return null;
        }
        if ((f1(i2) == 1) != this.w) {
            i5 = y() - 1;
            i4 = -1;
            i3 = -1;
        } else {
            i4 = y();
            i5 = 0;
            i3 = 1;
        }
        boolean z2 = this.r == 1 && v1();
        int L1 = L1(tVar2, yVar2, i5);
        int i9 = i5;
        int i10 = -1;
        int i11 = 0;
        int i12 = 0;
        int i13 = -1;
        View view5 = null;
        while (i9 != i4) {
            int L12 = L1(tVar2, yVar2, i9);
            View x = x(i9);
            if (x == s) {
                break;
            }
            if (!x.hasFocusable() || L12 == L1) {
                b bVar2 = (b) x.getLayoutParams();
                int i14 = bVar2.f183e;
                view2 = s;
                int i15 = bVar2.f184f + i14;
                if (x.hasFocusable() && i14 == i7 && i15 == i8) {
                    return x;
                }
                if ((!x.hasFocusable() || view4 != null) && (x.hasFocusable() || view5 != null)) {
                    view3 = view5;
                    int min = Math.min(i15, i8) - Math.max(i14, i7);
                    if (x.hasFocusable()) {
                        if (min <= i11) {
                            if (min == i11) {
                            }
                        }
                    } else if (view4 == null) {
                        i6 = i11;
                        if (Z(x, false)) {
                            if (min <= i12) {
                                if (min == i12) {
                                }
                            }
                            z = true;
                            if (z) {
                                if (x.hasFocusable()) {
                                    int i16 = bVar2.f183e;
                                    i6 = Math.min(i15, i8) - Math.max(i14, i7);
                                    i13 = i16;
                                    view5 = view3;
                                    view4 = x;
                                } else {
                                    int i17 = bVar2.f183e;
                                    i12 = Math.min(i15, i8) - Math.max(i14, i7);
                                    i10 = i17;
                                    view5 = x;
                                }
                                i9 += i3;
                                tVar2 = tVar;
                                yVar2 = yVar;
                                i4 = i4;
                                s = view2;
                                i11 = i6;
                            }
                        }
                        z = false;
                        if (z) {
                        }
                    }
                    i6 = i11;
                    z = false;
                    if (z) {
                    }
                } else {
                    view3 = view5;
                }
                i6 = i11;
                z = true;
                if (z) {
                }
            } else if (view4 != null) {
                break;
            } else {
                view2 = s;
                view3 = view5;
                i6 = i11;
            }
            view5 = view3;
            i9 += i3;
            tVar2 = tVar;
            yVar2 = yVar;
            i4 = i4;
            s = view2;
            i11 = i6;
        }
        return view4 != null ? view4 : view5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public int l(RecyclerView.y yVar) {
        return d1(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public int m(RecyclerView.y yVar) {
        return e1(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void n0(RecyclerView.t tVar, RecyclerView.y yVar, View view, e.i.i.w.b bVar) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            m0(view, bVar);
            return;
        }
        b bVar2 = (b) layoutParams;
        int L1 = L1(tVar, yVar, bVar2.a());
        if (this.r == 0) {
            i5 = bVar2.f183e;
            i4 = bVar2.f184f;
            i2 = 1;
            z2 = false;
            z = false;
            i3 = L1;
        } else {
            i4 = 1;
            i3 = bVar2.f183e;
            i2 = bVar2.f184f;
            z2 = false;
            z = false;
            i5 = L1;
        }
        bVar.j(b.c.a(i5, i4, i3, i2, z2, z));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public int o(RecyclerView.y yVar) {
        return d1(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public int p(RecyclerView.y yVar) {
        return e1(yVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void p0(RecyclerView recyclerView, int i2, int i3) {
        this.M.a.clear();
        this.M.b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void q0(RecyclerView recyclerView) {
        this.M.a.clear();
        this.M.b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View q1(RecyclerView.t tVar, RecyclerView.y yVar, int i2, int i3, int i4) {
        g1();
        int k2 = this.t.k();
        int g2 = this.t.g();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View x = x(i2);
            int R = R(x);
            if (R >= 0 && R < i4 && M1(tVar, yVar, R) == 0) {
                if (((RecyclerView.n) x.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = x;
                    }
                } else if (this.t.e(x) < g2 && this.t.b(x) >= k2) {
                    return x;
                } else {
                    if (view == null) {
                        view = x;
                    }
                }
            }
            i2 += i5;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void r0(RecyclerView recyclerView, int i2, int i3, int i4) {
        this.M.a.clear();
        this.M.b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void s0(RecyclerView recyclerView, int i2, int i3) {
        this.M.a.clear();
        this.M.b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public RecyclerView.n u() {
        return this.r == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void u0(RecyclerView recyclerView, int i2, int i3, Object obj) {
        this.M.a.clear();
        this.M.b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n v(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public void v0(RecyclerView.t tVar, RecyclerView.y yVar) {
        if (yVar.f254g) {
            int y = y();
            for (int i2 = 0; i2 < y; i2++) {
                b bVar = (b) x(i2).getLayoutParams();
                int a2 = bVar.a();
                this.K.put(a2, bVar.f184f);
                this.L.put(a2, bVar.f183e);
            }
        }
        super.v0(tVar, yVar);
        this.K.clear();
        this.L.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n w(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public void w0(RecyclerView.y yVar) {
        this.B = null;
        this.z = -1;
        this.A = Integer.MIN_VALUE;
        this.C.d();
        this.G = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void w1(RecyclerView.t tVar, RecyclerView.y yVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i2;
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
        int i15;
        int i16;
        int i17;
        int i18;
        View c2;
        int j2 = this.t.j();
        boolean z = j2 != 1073741824;
        int i19 = y() > 0 ? this.I[this.H] : 0;
        if (z) {
            R1();
        }
        boolean z2 = cVar.f189e == 1;
        int i20 = this.H;
        if (!z2) {
            i20 = M1(tVar, yVar, cVar.f188d) + N1(tVar, yVar, cVar.f188d);
        }
        int i21 = 0;
        while (i21 < this.H && cVar.b(yVar) && i20 > 0) {
            int i22 = cVar.f188d;
            int N1 = N1(tVar, yVar, i22);
            if (N1 <= this.H) {
                i20 -= N1;
                if (i20 < 0 || (c2 = cVar.c(tVar)) == null) {
                    break;
                }
                this.J[i21] = c2;
                i21++;
            } else {
                throw new IllegalArgumentException("Item at position " + i22 + " requires " + N1 + " spans but GridLayoutManager has only " + this.H + " spans.");
            }
        }
        if (i21 == 0) {
            bVar.b = true;
            return;
        }
        if (z2) {
            i4 = i21;
            i5 = 0;
            i3 = 0;
            i2 = 1;
        } else {
            i5 = i21 - 1;
            i4 = -1;
            i3 = 0;
            i2 = -1;
        }
        while (i5 != i4) {
            View view = this.J[i5];
            b bVar2 = (b) view.getLayoutParams();
            int N12 = N1(tVar, yVar, R(view));
            bVar2.f184f = N12;
            bVar2.f183e = i3;
            i3 += N12;
            i5 += i2;
        }
        float f2 = 0.0f;
        int i23 = 0;
        for (int i24 = 0; i24 < i21; i24++) {
            View view2 = this.J[i24];
            if (cVar.f195k == null) {
                if (z2) {
                    b(view2);
                } else {
                    c(view2, 0, false);
                }
            } else if (z2) {
                c(view2, -1, true);
            } else {
                c(view2, 0, true);
            }
            Rect rect = this.N;
            RecyclerView recyclerView = this.b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.L(view2));
            }
            O1(view2, j2, false);
            int c3 = this.t.c(view2);
            if (c3 > i23) {
                i23 = c3;
            }
            float d2 = (((float) this.t.d(view2)) * 1.0f) / ((float) ((b) view2.getLayoutParams()).f184f);
            if (d2 > f2) {
                f2 = d2;
            }
        }
        if (z) {
            I1(Math.max(Math.round(f2 * ((float) this.H)), i19));
            i23 = 0;
            for (int i25 = 0; i25 < i21; i25++) {
                View view3 = this.J[i25];
                O1(view3, 1073741824, true);
                int c4 = this.t.c(view3);
                if (c4 > i23) {
                    i23 = c4;
                }
            }
        }
        for (int i26 = 0; i26 < i21; i26++) {
            View view4 = this.J[i26];
            if (this.t.c(view4) != i23) {
                b bVar3 = (b) view4.getLayoutParams();
                Rect rect2 = bVar3.b;
                int i27 = rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) bVar3).topMargin + ((ViewGroup.MarginLayoutParams) bVar3).bottomMargin;
                int i28 = rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) bVar3).leftMargin + ((ViewGroup.MarginLayoutParams) bVar3).rightMargin;
                int K1 = K1(bVar3.f183e, bVar3.f184f);
                if (this.r == 1) {
                    i18 = RecyclerView.m.z(K1, 1073741824, i28, ((ViewGroup.MarginLayoutParams) bVar3).width, false);
                    i17 = View.MeasureSpec.makeMeasureSpec(i23 - i27, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i23 - i28, 1073741824);
                    i17 = RecyclerView.m.z(K1, 1073741824, i27, ((ViewGroup.MarginLayoutParams) bVar3).height, false);
                    i18 = makeMeasureSpec;
                }
                P1(view4, i18, i17, true);
            }
        }
        bVar.a = i23;
        if (this.r == 1) {
            if (cVar.f190f == -1) {
                i9 = cVar.b;
                i16 = i9 - i23;
            } else {
                i16 = cVar.b;
                i9 = i23 + i16;
            }
            i7 = i16;
            i8 = 0;
            i6 = 0;
        } else {
            if (cVar.f190f == -1) {
                i15 = cVar.b;
                i14 = i15 - i23;
            } else {
                i14 = cVar.b;
                i15 = i23 + i14;
            }
            i6 = i14;
            i7 = 0;
            i8 = i15;
            i9 = 0;
        }
        int i29 = 0;
        while (i29 < i21) {
            View view5 = this.J[i29];
            b bVar4 = (b) view5.getLayoutParams();
            if (this.r != 1) {
                i7 = this.I[bVar4.f183e] + Q();
                i9 = this.t.d(view5) + i7;
            } else if (v1()) {
                i8 = O() + this.I[this.H - bVar4.f183e];
                i6 = i8 - this.t.d(view5);
            } else {
                int O = O() + this.I[bVar4.f183e];
                i13 = i9;
                i10 = O;
                i11 = i7;
                i12 = this.t.d(view5) + O;
                a0(view5, i10, i11, i12, i13);
                if (!bVar4.c() || bVar4.b()) {
                    bVar.c = true;
                }
                bVar.f187d |= view5.hasFocusable();
                i29++;
                i9 = i13;
                i8 = i12;
                i7 = i11;
                i6 = i10;
            }
            i13 = i9;
            i12 = i8;
            i11 = i7;
            i10 = i6;
            a0(view5, i10, i11, i12, i13);
            if (!bVar4.c()) {
            }
            bVar.c = true;
            bVar.f187d |= view5.hasFocusable();
            i29++;
            i9 = i13;
            i8 = i12;
            i7 = i11;
            i6 = i10;
        }
        Arrays.fill(this.J, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void x1(RecyclerView.t tVar, RecyclerView.y yVar, LinearLayoutManager.a aVar, int i2) {
        R1();
        if (yVar.b() > 0 && !yVar.f254g) {
            boolean z = i2 == 1;
            int M1 = M1(tVar, yVar, aVar.b);
            if (z) {
                while (M1 > 0) {
                    int i3 = aVar.b;
                    if (i3 <= 0) {
                        break;
                    }
                    int i4 = i3 - 1;
                    aVar.b = i4;
                    M1 = M1(tVar, yVar, i4);
                }
            } else {
                int b2 = yVar.b() - 1;
                int i5 = aVar.b;
                while (i5 < b2) {
                    int i6 = i5 + 1;
                    int M12 = M1(tVar, yVar, i6);
                    if (M12 <= M1) {
                        break;
                    }
                    i5 = i6;
                    M1 = M12;
                }
                aVar.b = i5;
            }
        }
        J1();
    }
}
