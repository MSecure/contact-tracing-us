package b.r.d;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import b.r.d.a;

public class c0 implements a.AbstractC0044a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2305a;

    public c0(RecyclerView recyclerView) {
        this.f2305a = recyclerView;
    }

    public void a(a.b bVar) {
        int i = bVar.f2289a;
        if (i == 1) {
            RecyclerView recyclerView = this.f2305a;
            recyclerView.n.m0(recyclerView, bVar.f2290b, bVar.f2292d);
        } else if (i == 2) {
            RecyclerView recyclerView2 = this.f2305a;
            recyclerView2.n.p0(recyclerView2, bVar.f2290b, bVar.f2292d);
        } else if (i == 4) {
            RecyclerView recyclerView3 = this.f2305a;
            recyclerView3.n.r0(recyclerView3, bVar.f2290b, bVar.f2292d, bVar.f2291c);
        } else if (i == 8) {
            RecyclerView recyclerView4 = this.f2305a;
            recyclerView4.n.o0(recyclerView4, bVar.f2290b, bVar.f2292d, 1);
        }
    }

    public RecyclerView.a0 b(int i) {
        RecyclerView recyclerView = this.f2305a;
        int h = recyclerView.f283f.h();
        int i2 = 0;
        RecyclerView.a0 a0Var = null;
        while (true) {
            if (i2 >= h) {
                break;
            }
            RecyclerView.a0 K = RecyclerView.K(recyclerView.f283f.g(i2));
            if (K != null && !K.isRemoved() && K.mPosition == i) {
                if (!recyclerView.f283f.k(K.itemView)) {
                    a0Var = K;
                    break;
                }
                a0Var = K;
            }
            i2++;
        }
        if (a0Var != null && !this.f2305a.f283f.k(a0Var.itemView)) {
            return a0Var;
        }
        return null;
    }

    public void c(int i, int i2, Object obj) {
        int i3;
        int i4;
        RecyclerView recyclerView = this.f2305a;
        int h = recyclerView.f283f.h();
        int i5 = i2 + i;
        for (int i6 = 0; i6 < h; i6++) {
            View g2 = recyclerView.f283f.g(i6);
            RecyclerView.a0 K = RecyclerView.K(g2);
            if (K != null && !K.shouldIgnore() && (i4 = K.mPosition) >= i && i4 < i5) {
                K.addFlags(2);
                K.addChangePayload(obj);
                ((RecyclerView.n) g2.getLayoutParams()).f312c = true;
            }
        }
        RecyclerView.s sVar = recyclerView.f280c;
        int size = sVar.f322c.size();
        while (true) {
            size--;
            if (size >= 0) {
                RecyclerView.a0 a0Var = sVar.f322c.get(size);
                if (a0Var != null && (i3 = a0Var.mPosition) >= i && i3 < i5) {
                    a0Var.addFlags(2);
                    sVar.f(size);
                }
            } else {
                this.f2305a.l0 = true;
                return;
            }
        }
    }

    public void d(int i, int i2) {
        RecyclerView recyclerView = this.f2305a;
        int h = recyclerView.f283f.h();
        for (int i3 = 0; i3 < h; i3++) {
            RecyclerView.a0 K = RecyclerView.K(recyclerView.f283f.g(i3));
            if (K != null && !K.shouldIgnore() && K.mPosition >= i) {
                K.offsetPosition(i2, false);
                recyclerView.h0.f348f = true;
            }
        }
        RecyclerView.s sVar = recyclerView.f280c;
        int size = sVar.f322c.size();
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView.a0 a0Var = sVar.f322c.get(i4);
            if (a0Var != null && a0Var.mPosition >= i) {
                a0Var.offsetPosition(i2, true);
            }
        }
        recyclerView.requestLayout();
        this.f2305a.k0 = true;
    }

    public void e(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        RecyclerView recyclerView = this.f2305a;
        int h = recyclerView.f283f.h();
        int i10 = -1;
        if (i < i2) {
            i5 = i;
            i4 = i2;
            i3 = -1;
        } else {
            i4 = i;
            i5 = i2;
            i3 = 1;
        }
        for (int i11 = 0; i11 < h; i11++) {
            RecyclerView.a0 K = RecyclerView.K(recyclerView.f283f.g(i11));
            if (K != null && (i9 = K.mPosition) >= i5 && i9 <= i4) {
                if (i9 == i) {
                    K.offsetPosition(i2 - i, false);
                } else {
                    K.offsetPosition(i3, false);
                }
                recyclerView.h0.f348f = true;
            }
        }
        RecyclerView.s sVar = recyclerView.f280c;
        if (i < i2) {
            i7 = i;
            i6 = i2;
        } else {
            i6 = i;
            i7 = i2;
            i10 = 1;
        }
        int size = sVar.f322c.size();
        for (int i12 = 0; i12 < size; i12++) {
            RecyclerView.a0 a0Var = sVar.f322c.get(i12);
            if (a0Var != null && (i8 = a0Var.mPosition) >= i7 && i8 <= i6) {
                if (i8 == i) {
                    a0Var.offsetPosition(i2 - i, false);
                } else {
                    a0Var.offsetPosition(i10, false);
                }
            }
        }
        recyclerView.requestLayout();
        this.f2305a.k0 = true;
    }
}
