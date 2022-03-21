package e.s.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import e.s.a.a;

public class t implements a.AbstractC0049a {
    public final /* synthetic */ RecyclerView a;

    public t(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public void a(a.b bVar) {
        int i2 = bVar.a;
        if (i2 == 1) {
            RecyclerView recyclerView = this.a;
            recyclerView.n.p0(recyclerView, bVar.b, bVar.f1775d);
        } else if (i2 == 2) {
            RecyclerView recyclerView2 = this.a;
            recyclerView2.n.s0(recyclerView2, bVar.b, bVar.f1775d);
        } else if (i2 == 4) {
            RecyclerView recyclerView3 = this.a;
            recyclerView3.n.u0(recyclerView3, bVar.b, bVar.f1775d, bVar.c);
        } else if (i2 == 8) {
            RecyclerView recyclerView4 = this.a;
            recyclerView4.n.r0(recyclerView4, bVar.b, bVar.f1775d, 1);
        }
    }

    public RecyclerView.b0 b(int i2) {
        RecyclerView recyclerView = this.a;
        int h2 = recyclerView.f200f.h();
        int i3 = 0;
        RecyclerView.b0 b0Var = null;
        while (true) {
            if (i3 >= h2) {
                break;
            }
            RecyclerView.b0 K = RecyclerView.K(recyclerView.f200f.g(i3));
            if (K != null && !K.m() && K.c == i2) {
                if (!recyclerView.f200f.k(K.a)) {
                    b0Var = K;
                    break;
                }
                b0Var = K;
            }
            i3++;
        }
        if (b0Var != null && !this.a.f200f.k(b0Var.a)) {
            return b0Var;
        }
        return null;
    }

    public void c(int i2, int i3, Object obj) {
        int i4;
        int i5;
        RecyclerView recyclerView = this.a;
        int h2 = recyclerView.f200f.h();
        int i6 = i3 + i2;
        for (int i7 = 0; i7 < h2; i7++) {
            View g2 = recyclerView.f200f.g(i7);
            RecyclerView.b0 K = RecyclerView.K(g2);
            if (K != null && !K.u() && (i5 = K.c) >= i2 && i5 < i6) {
                K.b(2);
                K.a(obj);
                ((RecyclerView.n) g2.getLayoutParams()).c = true;
            }
        }
        RecyclerView.t tVar = recyclerView.c;
        int size = tVar.c.size();
        while (true) {
            size--;
            if (size >= 0) {
                RecyclerView.b0 b0Var = tVar.c.get(size);
                if (b0Var != null && (i4 = b0Var.c) >= i2 && i4 < i6) {
                    b0Var.b(2);
                    tVar.f(size);
                }
            } else {
                this.a.m0 = true;
                return;
            }
        }
    }

    public void d(int i2, int i3) {
        RecyclerView recyclerView = this.a;
        int h2 = recyclerView.f200f.h();
        for (int i4 = 0; i4 < h2; i4++) {
            RecyclerView.b0 K = RecyclerView.K(recyclerView.f200f.g(i4));
            if (K != null && !K.u() && K.c >= i2) {
                K.q(i3, false);
                recyclerView.i0.f253f = true;
            }
        }
        RecyclerView.t tVar = recyclerView.c;
        int size = tVar.c.size();
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.b0 b0Var = tVar.c.get(i5);
            if (b0Var != null && b0Var.c >= i2) {
                b0Var.q(i3, true);
            }
        }
        recyclerView.requestLayout();
        this.a.l0 = true;
    }

    public void e(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        RecyclerView recyclerView = this.a;
        int h2 = recyclerView.f200f.h();
        int i11 = -1;
        if (i2 < i3) {
            i6 = i2;
            i5 = i3;
            i4 = -1;
        } else {
            i5 = i2;
            i6 = i3;
            i4 = 1;
        }
        for (int i12 = 0; i12 < h2; i12++) {
            RecyclerView.b0 K = RecyclerView.K(recyclerView.f200f.g(i12));
            if (K != null && (i10 = K.c) >= i6 && i10 <= i5) {
                if (i10 == i2) {
                    K.q(i3 - i2, false);
                } else {
                    K.q(i4, false);
                }
                recyclerView.i0.f253f = true;
            }
        }
        RecyclerView.t tVar = recyclerView.c;
        if (i2 < i3) {
            i8 = i2;
            i7 = i3;
        } else {
            i7 = i2;
            i8 = i3;
            i11 = 1;
        }
        int size = tVar.c.size();
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView.b0 b0Var = tVar.c.get(i13);
            if (b0Var != null && (i9 = b0Var.c) >= i8 && i9 <= i7) {
                if (i9 == i2) {
                    b0Var.q(i3 - i2, false);
                } else {
                    b0Var.q(i11, false);
                }
            }
        }
        recyclerView.requestLayout();
        this.a.l0 = true;
    }
}
