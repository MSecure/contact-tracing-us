package e.s.a;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class m extends w {

    /* renamed from: d  reason: collision with root package name */
    public q f1820d;

    /* renamed from: e  reason: collision with root package name */
    public q f1821e;

    @Override // e.s.a.w
    public int[] b(RecyclerView.m mVar, View view) {
        int[] iArr = new int[2];
        if (mVar.e()) {
            iArr[0] = g(view, j(mVar));
        } else {
            iArr[0] = 0;
        }
        if (mVar.f()) {
            iArr[1] = g(view, k(mVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // e.s.a.w
    public View d(RecyclerView.m mVar) {
        q qVar;
        if (mVar.f()) {
            qVar = k(mVar);
        } else if (!mVar.e()) {
            return null;
        } else {
            qVar = j(mVar);
        }
        return i(mVar, qVar);
    }

    @Override // e.s.a.w
    public int e(RecyclerView.m mVar, int i2, int i3) {
        int J;
        View d2;
        int R;
        int i4;
        PointF a;
        int i5;
        int i6;
        if (!(mVar instanceof RecyclerView.x.b) || (J = mVar.J()) == 0 || (d2 = d(mVar)) == null || (R = mVar.R(d2)) == -1 || (a = ((RecyclerView.x.b) mVar).a(J - 1)) == null) {
            return -1;
        }
        int i7 = 0;
        if (mVar.e()) {
            i5 = h(mVar, j(mVar), i2, 0);
            if (a.x < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (mVar.f()) {
            i6 = h(mVar, k(mVar), 0, i3);
            if (a.y < 0.0f) {
                i6 = -i6;
            }
        } else {
            i6 = 0;
        }
        if (mVar.f()) {
            i5 = i6;
        }
        if (i5 == 0) {
            return -1;
        }
        int i8 = R + i5;
        if (i8 >= 0) {
            i7 = i8;
        }
        return i7 >= J ? i4 : i7;
    }

    public final int g(View view, q qVar) {
        return ((qVar.c(view) / 2) + qVar.e(view)) - ((qVar.l() / 2) + qVar.k());
    }

    public final int h(RecyclerView.m mVar, q qVar, int i2, int i3) {
        int max;
        this.b.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int[] iArr = {this.b.getFinalX(), this.b.getFinalY()};
        int y = mVar.y();
        float f2 = 1.0f;
        if (y != 0) {
            View view = null;
            View view2 = null;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            for (int i6 = 0; i6 < y; i6++) {
                View x = mVar.x(i6);
                int R = mVar.R(x);
                if (R != -1) {
                    if (R < i4) {
                        view = x;
                        i4 = R;
                    }
                    if (R > i5) {
                        view2 = x;
                        i5 = R;
                    }
                }
            }
            if (!(view == null || view2 == null || (max = Math.max(qVar.b(view), qVar.b(view2)) - Math.min(qVar.e(view), qVar.e(view2))) == 0)) {
                f2 = (((float) max) * 1.0f) / ((float) ((i5 - i4) + 1));
            }
        }
        if (f2 <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(iArr[0]) > Math.abs(iArr[1]) ? iArr[0] : iArr[1])) / f2);
    }

    public final View i(RecyclerView.m mVar, q qVar) {
        int y = mVar.y();
        View view = null;
        if (y == 0) {
            return null;
        }
        int l2 = (qVar.l() / 2) + qVar.k();
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < y; i3++) {
            View x = mVar.x(i3);
            int abs = Math.abs(((qVar.c(x) / 2) + qVar.e(x)) - l2);
            if (abs < i2) {
                view = x;
                i2 = abs;
            }
        }
        return view;
    }

    public final q j(RecyclerView.m mVar) {
        q qVar = this.f1821e;
        if (qVar == null || qVar.a != mVar) {
            this.f1821e = new o(mVar);
        }
        return this.f1821e;
    }

    public final q k(RecyclerView.m mVar) {
        q qVar = this.f1820d;
        if (qVar == null || qVar.a != mVar) {
            this.f1820d = new p(mVar);
        }
        return this.f1820d;
    }
}
