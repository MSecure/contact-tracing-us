package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.i.l.w.b;
import b.q.d.r;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    public boolean H = false;
    public int I = -1;
    public int[] J;
    public View[] K;
    public final SparseIntArray L = new SparseIntArray();
    public final SparseIntArray M = new SparseIntArray();
    public c N = new a();
    public final Rect O = new Rect();

    public static final class a extends c {
    }

    public static class b extends RecyclerView.p {

        /* renamed from: e  reason: collision with root package name */
        public int f174e = -1;
        public int f = 0;

        public b(int i, int i2) {
            super(i, i2);
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

        /* renamed from: a  reason: collision with root package name */
        public final SparseIntArray f175a = new SparseIntArray();

        /* renamed from: b  reason: collision with root package name */
        public final SparseIntArray f176b = new SparseIntArray();

        /* renamed from: c  reason: collision with root package name */
        public boolean f177c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f178d = false;

        public int a(int i, int i2) {
            if (!this.f178d) {
                return c(i, i2);
            }
            int i3 = this.f176b.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int c2 = c(i, i2);
            this.f176b.put(i, c2);
            return c2;
        }

        public int b(int i, int i2) {
            if (!this.f177c) {
                return i % i2;
            }
            int i3 = this.f175a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int i4 = i % i2;
            this.f175a.put(i, i4);
            return i4;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0049  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
        public int c(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (this.f178d) {
                SparseIntArray sparseIntArray = this.f176b;
                int size = sparseIntArray.size() - 1;
                int i6 = 0;
                while (i6 <= size) {
                    int i7 = (i6 + size) >>> 1;
                    if (sparseIntArray.keyAt(i7) < i) {
                        i6 = i7 + 1;
                    } else {
                        size = i7 - 1;
                    }
                }
                int i8 = i6 - 1;
                int keyAt = (i8 < 0 || i8 >= sparseIntArray.size()) ? -1 : sparseIntArray.keyAt(i8);
                if (keyAt != -1) {
                    i4 = this.f176b.get(keyAt);
                    i3 = keyAt + 1;
                    i5 = b(keyAt, i2) + 1;
                    if (i5 == i2) {
                        i4++;
                        i5 = 0;
                    }
                    while (i3 < i) {
                        i5++;
                        if (i5 == i2) {
                            i4++;
                            i5 = 0;
                        } else if (i5 > i2) {
                            i4++;
                            i5 = 1;
                        }
                        i3++;
                    }
                    return i5 + 1 <= i2 ? i4 + 1 : i4;
                }
            }
            i5 = 0;
            i4 = 0;
            i3 = 0;
            while (i3 < i) {
            }
            if (i5 + 1 <= i2) {
            }
        }
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(i2, z);
        N1(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        N1(RecyclerView.o.Q(context, attributeSet, i, i2).f226b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int A(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 1) {
            return this.I;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return I1(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void B1(boolean z) {
        if (!z) {
            d(null);
            if (this.y) {
                this.y = false;
                I0();
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public final void F1(int i) {
        int i2;
        int[] iArr = this.J;
        int i3 = this.I;
        if (!(iArr != null && iArr.length == i3 + 1 && iArr[iArr.length - 1] == i)) {
            iArr = new int[(i3 + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.J = iArr;
    }

    public final void G1() {
        View[] viewArr = this.K;
        if (viewArr == null || viewArr.length != this.I) {
            this.K = new View[this.I];
        }
    }

    public int H1(int i, int i2) {
        if (this.s != 1 || !s1()) {
            int[] iArr = this.J;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.J;
        int i3 = this.I;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public final int I1(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i) {
        if (!a0Var.g) {
            return this.N.a(i, this.I);
        }
        int c2 = vVar.c(i);
        if (c2 == -1) {
            return 0;
        }
        return this.N.a(c2, this.I);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public int J0(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        O1();
        G1();
        if (this.s == 1) {
            return 0;
        }
        return z1(i, vVar, a0Var);
    }

    public final int J1(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i) {
        if (!a0Var.g) {
            return this.N.b(i, this.I);
        }
        int i2 = this.M.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int c2 = vVar.c(i);
        if (c2 == -1) {
            return 0;
        }
        return this.N.b(c2, this.I);
    }

    public final int K1(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i) {
        if (a0Var.g) {
            int i2 = this.L.get(i, -1);
            if (i2 != -1) {
                return i2;
            }
            if (vVar.c(i) == -1 || ((a) this.N) != null) {
                return 1;
            }
            throw null;
        } else if (((a) this.N) != null) {
            return 1;
        } else {
            throw null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public int L0(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        O1();
        G1();
        if (this.s == 0) {
            return 0;
        }
        return z1(i, vVar, a0Var);
    }

    public final void L1(View view, int i, boolean z) {
        int i2;
        int i3;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f230b;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int H1 = H1(bVar.f174e, bVar.f);
        if (this.s == 1) {
            i2 = RecyclerView.o.z(H1, i, i5, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i3 = RecyclerView.o.z(this.u.l(), this.p, i4, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int z2 = RecyclerView.o.z(H1, i, i4, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int z3 = RecyclerView.o.z(this.u.l(), this.o, i5, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            i3 = z2;
            i2 = z3;
        }
        M1(view, i2, i3, z);
    }

    public final void M1(View view, int i, int i2, boolean z) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z ? T0(view, i, i2, pVar) : R0(view, i, i2, pVar)) {
            view.measure(i, i2);
        }
    }

    public void N1(int i) {
        if (i != this.I) {
            this.H = true;
            if (i >= 1) {
                this.I = i;
                this.N.f175a.clear();
                I0();
                return;
            }
            throw new IllegalArgumentException(c.a.a.a.a.l("Span count should be at least 1. Provided ", i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.J == null) {
            super.O0(rect, i, i2);
        }
        int N2 = N() + M();
        int L2 = L() + O();
        if (this.s == 1) {
            i4 = RecyclerView.o.h(i2, rect.height() + L2, J());
            int[] iArr = this.J;
            i3 = RecyclerView.o.h(i, iArr[iArr.length - 1] + N2, K());
        } else {
            i3 = RecyclerView.o.h(i, rect.width() + N2, K());
            int[] iArr2 = this.J;
            i4 = RecyclerView.o.h(i2, iArr2[iArr2.length - 1] + L2, J());
        }
        this.f219b.setMeasuredDimension(i3, i4);
    }

    public final void O1() {
        int i;
        int i2;
        if (this.s == 1) {
            i2 = this.q - N();
            i = M();
        } else {
            i2 = this.r - L();
            i = O();
        }
        F1(i2 - i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int R(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (this.s == 0) {
            return this.I;
        }
        if (a0Var.b() < 1) {
            return 0;
        }
        return I1(vVar, a0Var, a0Var.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public boolean W0() {
        return this.C == null && !this.H;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void Y0(RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int i = this.I;
        for (int i2 = 0; i2 < this.I && cVar.b(a0Var) && i > 0; i2++) {
            ((r.b) cVar2).a(cVar.f191d, Math.max(0, cVar.g));
            if (((a) this.N) != null) {
                i--;
                cVar.f191d += cVar.f192e;
            } else {
                throw null;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean g(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ce, code lost:
        if (r13 == (r2 > r15)) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e7, code lost:
        if (r13 == (r2 > r9)) goto L_0x00de;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f0  */
    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public View g0(View view, int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i2;
        int i3;
        int i4;
        int i5;
        View view2;
        View view3;
        boolean z;
        boolean z2;
        RecyclerView.v vVar2 = vVar;
        RecyclerView.a0 a0Var2 = a0Var;
        View s = s(view);
        View view4 = null;
        if (s == null) {
            return null;
        }
        b bVar = (b) s.getLayoutParams();
        int i6 = bVar.f174e;
        int i7 = bVar.f + i6;
        if (super.g0(view, i, vVar, a0Var) == null) {
            return null;
        }
        if ((c1(i) == 1) != this.x) {
            i4 = y() - 1;
            i3 = -1;
            i2 = -1;
        } else {
            i3 = y();
            i2 = 1;
            i4 = 0;
        }
        boolean z3 = this.s == 1 && s1();
        int I1 = I1(vVar2, a0Var2, i4);
        int i8 = -1;
        int i9 = -1;
        int i10 = 0;
        int i11 = 0;
        int i12 = i4;
        View view5 = null;
        while (i12 != i3) {
            int I12 = I1(vVar2, a0Var2, i12);
            View x = x(i12);
            if (x == s) {
                break;
            }
            if (!x.hasFocusable() || I12 == I1) {
                b bVar2 = (b) x.getLayoutParams();
                int i13 = bVar2.f174e;
                view2 = s;
                int i14 = bVar2.f + i13;
                if (x.hasFocusable() && i13 == i6 && i14 == i7) {
                    return x;
                }
                if ((!x.hasFocusable() || view4 != null) && (x.hasFocusable() || view5 != null)) {
                    view3 = view5;
                    int min = Math.min(i14, i7) - Math.max(i13, i6);
                    if (x.hasFocusable()) {
                        if (min <= i10) {
                            if (min == i10) {
                            }
                        }
                    } else if (view4 == null) {
                        i5 = i10;
                        z2 = false;
                        if (X(x, false)) {
                            if (min <= i11) {
                                if (min == i11) {
                                }
                            }
                            z = true;
                            if (z) {
                                if (x.hasFocusable()) {
                                    int i15 = bVar2.f174e;
                                    i5 = Math.min(i14, i7) - Math.max(i13, i6);
                                    i9 = i15;
                                    view5 = view3;
                                    view4 = x;
                                } else {
                                    int i16 = bVar2.f174e;
                                    i11 = Math.min(i14, i7) - Math.max(i13, i6);
                                    i8 = i16;
                                    view5 = x;
                                }
                                i12 += i2;
                                vVar2 = vVar;
                                a0Var2 = a0Var;
                                i3 = i3;
                                s = view2;
                                i10 = i5;
                            }
                        }
                        z = z2;
                        if (z) {
                        }
                    }
                    i5 = i10;
                    z2 = false;
                    z = z2;
                    if (z) {
                    }
                } else {
                    view3 = view5;
                }
                i5 = i10;
                z = true;
                if (z) {
                }
            } else if (view4 != null) {
                break;
            } else {
                view2 = s;
                view3 = view5;
                i5 = i10;
            }
            view5 = view3;
            i12 += i2;
            vVar2 = vVar;
            a0Var2 = a0Var;
            i3 = i3;
            s = view2;
            i10 = i5;
        }
        return view4 != null ? view4 : view5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void k0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, b.i.l.w.b bVar) {
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        int i4;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.j0(view, bVar);
            return;
        }
        b bVar2 = (b) layoutParams;
        int I1 = I1(vVar, a0Var, bVar2.a());
        if (this.s == 0) {
            i4 = bVar2.f174e;
            i3 = bVar2.f;
            i = 1;
            z2 = false;
            z = false;
            i2 = I1;
        } else {
            i3 = 1;
            i2 = bVar2.f174e;
            i = bVar2.f;
            z2 = false;
            z = false;
            i4 = I1;
        }
        bVar.j(b.c.a(i4, i3, i2, i, z2, z));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public int l(RecyclerView.a0 a0Var) {
        return a1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public int m(RecyclerView.a0 a0Var) {
        return b1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void m0(RecyclerView recyclerView, int i, int i2) {
        this.N.f175a.clear();
        this.N.f176b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void n0(RecyclerView recyclerView) {
        this.N.f175a.clear();
        this.N.f176b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View n1(RecyclerView.v vVar, RecyclerView.a0 a0Var, int i, int i2, int i3) {
        d1();
        int k = this.u.k();
        int g = this.u.g();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View x = x(i);
            int P = P(x);
            if (P >= 0 && P < i3 && J1(vVar, a0Var, P) == 0) {
                if (((RecyclerView.p) x.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = x;
                    }
                } else if (this.u.e(x) < g && this.u.b(x) >= k) {
                    return x;
                } else {
                    if (view == null) {
                        view = x;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public int o(RecyclerView.a0 a0Var) {
        return a1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o0(RecyclerView recyclerView, int i, int i2, int i3) {
        this.N.f175a.clear();
        this.N.f176b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public int p(RecyclerView.a0 a0Var) {
        return b1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p0(RecyclerView recyclerView, int i, int i2) {
        this.N.f175a.clear();
        this.N.f176b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void r0(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.N.f175a.clear();
        this.N.f176b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public void s0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (a0Var.g) {
            int y = y();
            for (int i = 0; i < y; i++) {
                b bVar = (b) x(i).getLayoutParams();
                int a2 = bVar.a();
                this.L.put(a2, bVar.f);
                this.M.put(a2, bVar.f174e);
            }
        }
        super.s0(vVar, a0Var);
        this.L.clear();
        this.M.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public void t0(RecyclerView.a0 a0Var) {
        this.C = null;
        this.A = -1;
        this.B = Integer.MIN_VALUE;
        this.D.d();
        this.H = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void t1(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i;
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
        View c2;
        int j = this.u.j();
        boolean z = j != 1073741824;
        int i18 = y() > 0 ? this.J[this.I] : 0;
        if (z) {
            O1();
        }
        boolean z2 = cVar.f192e == 1;
        int i19 = this.I;
        if (!z2) {
            i19 = J1(vVar, a0Var, cVar.f191d) + K1(vVar, a0Var, cVar.f191d);
        }
        int i20 = 0;
        while (i20 < this.I && cVar.b(a0Var) && i19 > 0) {
            int i21 = cVar.f191d;
            int K1 = K1(vVar, a0Var, i21);
            if (K1 <= this.I) {
                i19 -= K1;
                if (i19 < 0 || (c2 = cVar.c(vVar)) == null) {
                    break;
                }
                this.K[i20] = c2;
                i20++;
            } else {
                throw new IllegalArgumentException("Item at position " + i21 + " requires " + K1 + " spans but GridLayoutManager has only " + this.I + " spans.");
            }
        }
        if (i20 == 0) {
            bVar.f185b = true;
            return;
        }
        if (z2) {
            i4 = 0;
            i2 = 0;
            i = 1;
            i3 = i20;
        } else {
            i4 = i20 - 1;
            i2 = 0;
            i3 = -1;
            i = -1;
        }
        while (i4 != i3) {
            View view = this.K[i4];
            b bVar2 = (b) view.getLayoutParams();
            int K12 = K1(vVar, a0Var, P(view));
            bVar2.f = K12;
            bVar2.f174e = i2;
            i2 += K12;
            i4 += i;
        }
        float f = 0.0f;
        int i22 = 0;
        for (int i23 = 0; i23 < i20; i23++) {
            View view2 = this.K[i23];
            if (cVar.l == null) {
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
            Rect rect = this.O;
            RecyclerView recyclerView = this.f219b;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view2));
            }
            L1(view2, j, false);
            int c3 = this.u.c(view2);
            if (c3 > i22) {
                i22 = c3;
            }
            float d2 = (((float) this.u.d(view2)) * 1.0f) / ((float) ((b) view2.getLayoutParams()).f);
            if (d2 > f) {
                f = d2;
            }
        }
        if (z) {
            F1(Math.max(Math.round(f * ((float) this.I)), i18));
            i22 = 0;
            for (int i24 = 0; i24 < i20; i24++) {
                View view3 = this.K[i24];
                L1(view3, 1073741824, true);
                int c4 = this.u.c(view3);
                if (c4 > i22) {
                    i22 = c4;
                }
            }
        }
        for (int i25 = 0; i25 < i20; i25++) {
            View view4 = this.K[i25];
            if (this.u.c(view4) != i22) {
                b bVar3 = (b) view4.getLayoutParams();
                Rect rect2 = bVar3.f230b;
                int i26 = rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) bVar3).topMargin + ((ViewGroup.MarginLayoutParams) bVar3).bottomMargin;
                int i27 = rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) bVar3).leftMargin + ((ViewGroup.MarginLayoutParams) bVar3).rightMargin;
                int H1 = H1(bVar3.f174e, bVar3.f);
                if (this.s == 1) {
                    i17 = RecyclerView.o.z(H1, 1073741824, i27, ((ViewGroup.MarginLayoutParams) bVar3).width, false);
                    i16 = View.MeasureSpec.makeMeasureSpec(i22 - i26, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i22 - i27, 1073741824);
                    i16 = RecyclerView.o.z(H1, 1073741824, i26, ((ViewGroup.MarginLayoutParams) bVar3).height, false);
                    i17 = makeMeasureSpec;
                }
                M1(view4, i17, i16, true);
            }
        }
        bVar.f184a = i22;
        if (this.s == 1) {
            if (cVar.f == -1) {
                i8 = cVar.f189b;
                i15 = i8 - i22;
            } else {
                i15 = cVar.f189b;
                i8 = i22 + i15;
            }
            i6 = i15;
            i7 = 0;
            i5 = 0;
        } else {
            if (cVar.f == -1) {
                i14 = cVar.f189b;
                i13 = i14 - i22;
            } else {
                i13 = cVar.f189b;
                i14 = i22 + i13;
            }
            i5 = i13;
            i6 = 0;
            i7 = i14;
            i8 = 0;
        }
        int i28 = 0;
        while (i28 < i20) {
            View view5 = this.K[i28];
            b bVar4 = (b) view5.getLayoutParams();
            if (this.s != 1) {
                i6 = this.J[bVar4.f174e] + O();
                i8 = this.u.d(view5) + i6;
            } else if (s1()) {
                i7 = M() + this.J[this.I - bVar4.f174e];
                i5 = i7 - this.u.d(view5);
            } else {
                int M2 = M() + this.J[bVar4.f174e];
                i12 = i8;
                i9 = M2;
                i10 = i6;
                i11 = this.u.d(view5) + M2;
                Y(view5, i9, i10, i11, i12);
                if (!bVar4.c() || bVar4.b()) {
                    bVar.f186c = true;
                }
                bVar.f187d |= view5.hasFocusable();
                i28++;
                i8 = i12;
                i7 = i11;
                i6 = i10;
                i5 = i9;
            }
            i12 = i8;
            i11 = i7;
            i10 = i6;
            i9 = i5;
            Y(view5, i9, i10, i11, i12);
            if (!bVar4.c()) {
            }
            bVar.f186c = true;
            bVar.f187d |= view5.hasFocusable();
            i28++;
            i8 = i12;
            i7 = i11;
            i6 = i10;
            i5 = i9;
        }
        Arrays.fill(this.K, (Object) null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o, androidx.recyclerview.widget.LinearLayoutManager
    public RecyclerView.p u() {
        return this.s == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void u1(RecyclerView.v vVar, RecyclerView.a0 a0Var, LinearLayoutManager.a aVar, int i) {
        O1();
        if (a0Var.b() > 0 && !a0Var.g) {
            boolean z = i == 1;
            int J1 = J1(vVar, a0Var, aVar.f180b);
            if (z) {
                while (J1 > 0) {
                    int i2 = aVar.f180b;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    aVar.f180b = i3;
                    J1 = J1(vVar, a0Var, i3);
                }
            } else {
                int b2 = a0Var.b() - 1;
                int i4 = aVar.f180b;
                while (i4 < b2) {
                    int i5 = i4 + 1;
                    int J12 = J1(vVar, a0Var, i5);
                    if (J12 <= J1) {
                        break;
                    }
                    i4 = i5;
                    J1 = J12;
                }
                aVar.f180b = i4;
            }
        }
        G1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p v(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p w(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }
}
