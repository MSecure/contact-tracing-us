package b.r.d;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.nearby.messages.BleSignal;

public class u extends f0 {

    /* renamed from: d  reason: collision with root package name */
    public a0 f2448d;

    /* renamed from: e  reason: collision with root package name */
    public a0 f2449e;

    @Override // b.r.d.f0
    public int[] a(RecyclerView.m mVar, View view) {
        int[] iArr = new int[2];
        if (mVar.e()) {
            iArr[0] = d(view, g(mVar));
        } else {
            iArr[0] = 0;
        }
        if (mVar.f()) {
            iArr[1] = d(view, h(mVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // b.r.d.f0
    public View b(RecyclerView.m mVar) {
        a0 a0Var;
        if (mVar.f()) {
            a0Var = h(mVar);
        } else if (!mVar.e()) {
            return null;
        } else {
            a0Var = g(mVar);
        }
        return f(mVar, a0Var);
    }

    public final int d(View view, a0 a0Var) {
        return ((a0Var.c(view) / 2) + a0Var.e(view)) - ((a0Var.l() / 2) + a0Var.k());
    }

    public final int e(RecyclerView.m mVar, a0 a0Var, int i, int i2) {
        int max;
        this.f2338b.fling(0, 0, i, i2, BleSignal.UNKNOWN_TX_POWER, Integer.MAX_VALUE, BleSignal.UNKNOWN_TX_POWER, Integer.MAX_VALUE);
        int[] iArr = {this.f2338b.getFinalX(), this.f2338b.getFinalY()};
        int y = mVar.y();
        float f2 = 1.0f;
        if (y != 0) {
            View view = null;
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            View view2 = null;
            for (int i5 = 0; i5 < y; i5++) {
                View x = mVar.x(i5);
                int P = mVar.P(x);
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
                f2 = (((float) max) * 1.0f) / ((float) ((i3 - i4) + 1));
            }
        }
        if (f2 <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(iArr[0]) > Math.abs(iArr[1]) ? iArr[0] : iArr[1])) / f2);
    }

    public final View f(RecyclerView.m mVar, a0 a0Var) {
        int y = mVar.y();
        View view = null;
        if (y == 0) {
            return null;
        }
        int l = (a0Var.l() / 2) + a0Var.k();
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < y; i2++) {
            View x = mVar.x(i2);
            int abs = Math.abs(((a0Var.c(x) / 2) + a0Var.e(x)) - l);
            if (abs < i) {
                view = x;
                i = abs;
            }
        }
        return view;
    }

    public final a0 g(RecyclerView.m mVar) {
        a0 a0Var = this.f2449e;
        if (a0Var == null || a0Var.f2293a != mVar) {
            this.f2449e = new y(mVar);
        }
        return this.f2449e;
    }

    public final a0 h(RecyclerView.m mVar) {
        a0 a0Var = this.f2448d;
        if (a0Var == null || a0Var.f2293a != mVar) {
            this.f2448d = new z(mVar);
        }
        return this.f2448d;
    }
}
