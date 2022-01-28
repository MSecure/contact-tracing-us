package b.q.d;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class u extends d0 {

    /* renamed from: d  reason: collision with root package name */
    public a0 f1592d;

    /* renamed from: e  reason: collision with root package name */
    public a0 f1593e;

    @Override // b.q.d.d0
    public int[] a(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.e()) {
            iArr[0] = d(view, g(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.f()) {
            iArr[1] = d(view, h(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // b.q.d.d0
    public View b(RecyclerView.o oVar) {
        a0 a0Var;
        if (oVar.f()) {
            a0Var = h(oVar);
        } else if (!oVar.e()) {
            return null;
        } else {
            a0Var = g(oVar);
        }
        return f(oVar, a0Var);
    }

    public final int d(View view, a0 a0Var) {
        return ((a0Var.c(view) / 2) + a0Var.e(view)) - ((a0Var.l() / 2) + a0Var.k());
    }

    public final int e(RecyclerView.o oVar, a0 a0Var, int i, int i2) {
        int max;
        this.f1482b.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int[] iArr = {this.f1482b.getFinalX(), this.f1482b.getFinalY()};
        int y = oVar.y();
        float f = 1.0f;
        if (y != 0) {
            View view = null;
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            View view2 = null;
            for (int i5 = 0; i5 < y; i5++) {
                View x = oVar.x(i5);
                int P = oVar.P(x);
                if (P != -1) {
                    if (P < i4) {
                        view = x;
                        i4 = P;
                    }
                    if (P > i3) {
                        view2 = x;
                        i3 = P;
                    }
                }
            }
            if (!(view == null || view2 == null || (max = Math.max(a0Var.b(view), a0Var.b(view2)) - Math.min(a0Var.e(view), a0Var.e(view2))) == 0)) {
                f = (((float) max) * 1.0f) / ((float) ((i3 - i4) + 1));
            }
        }
        if (f <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(iArr[0]) > Math.abs(iArr[1]) ? iArr[0] : iArr[1])) / f);
    }

    public final View f(RecyclerView.o oVar, a0 a0Var) {
        int y = oVar.y();
        View view = null;
        if (y == 0) {
            return null;
        }
        int l = (a0Var.l() / 2) + a0Var.k();
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < y; i2++) {
            View x = oVar.x(i2);
            int abs = Math.abs(((a0Var.c(x) / 2) + a0Var.e(x)) - l);
            if (abs < i) {
                view = x;
                i = abs;
            }
        }
        return view;
    }

    public final a0 g(RecyclerView.o oVar) {
        a0 a0Var = this.f1593e;
        if (a0Var == null || a0Var.f1453a != oVar) {
            this.f1593e = new y(oVar);
        }
        return this.f1593e;
    }

    public final a0 h(RecyclerView.o oVar) {
        a0 a0Var = this.f1592d;
        if (a0Var == null || a0Var.f1453a != oVar) {
            this.f1592d = new z(oVar);
        }
        return this.f1592d;
    }
}
