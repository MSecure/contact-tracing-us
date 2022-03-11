package e.s.a;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class r extends w {

    /* renamed from: d  reason: collision with root package name */
    public q f1821d;

    /* renamed from: e  reason: collision with root package name */
    public q f1822e;

    public class a extends l {
        public a(Context context) {
            super(context);
        }

        @Override // e.s.a.l, androidx.recyclerview.widget.RecyclerView.x
        public void c(View view, RecyclerView.y yVar, RecyclerView.x.a aVar) {
            r rVar = r.this;
            int[] b = rVar.b(rVar.a.getLayoutManager(), view);
            int i2 = b[0];
            int i3 = b[1];
            int g2 = g(Math.max(Math.abs(i2), Math.abs(i3)));
            if (g2 > 0) {
                aVar.b(i2, i3, g2, this.f1816j);
            }
        }

        @Override // e.s.a.l
        public float f(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }

        @Override // e.s.a.l
        public int h(int i2) {
            return Math.min(100, super.h(i2));
        }
    }

    @Override // e.s.a.w
    public int[] b(RecyclerView.m mVar, View view) {
        int[] iArr = new int[2];
        if (mVar.e()) {
            iArr[0] = g(view, i(mVar));
        } else {
            iArr[0] = 0;
        }
        if (mVar.f()) {
            iArr[1] = g(view, j(mVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // e.s.a.w
    public l c(RecyclerView.m mVar) {
        if (!(mVar instanceof RecyclerView.x.b)) {
            return null;
        }
        return new a(this.a.getContext());
    }

    @Override // e.s.a.w
    public View d(RecyclerView.m mVar) {
        throw null;
    }

    @Override // e.s.a.w
    public int e(RecyclerView.m mVar, int i2, int i3) {
        PointF a2;
        int J = mVar.J();
        if (J == 0) {
            return -1;
        }
        View view = null;
        q j2 = mVar.f() ? j(mVar) : mVar.e() ? i(mVar) : null;
        if (j2 == null) {
            return -1;
        }
        int y = mVar.y();
        boolean z = false;
        View view2 = null;
        int i4 = Integer.MIN_VALUE;
        int i5 = Integer.MAX_VALUE;
        for (int i6 = 0; i6 < y; i6++) {
            View x = mVar.x(i6);
            if (x != null) {
                int g2 = g(x, j2);
                if (g2 <= 0 && g2 > i4) {
                    view2 = x;
                    i4 = g2;
                }
                if (g2 >= 0 && g2 < i5) {
                    view = x;
                    i5 = g2;
                }
            }
        }
        int i7 = 1;
        boolean z2 = !mVar.e() ? i3 > 0 : i2 > 0;
        if (z2 && view != null) {
            return mVar.R(view);
        }
        if (!(z2 || view2 == null)) {
            return mVar.R(view2);
        }
        if (z2) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int R = mVar.R(view);
        int J2 = mVar.J();
        if ((mVar instanceof RecyclerView.x.b) && (a2 = ((RecyclerView.x.b) mVar).a(J2 - 1)) != null && (a2.x < 0.0f || a2.y < 0.0f)) {
            z = true;
        }
        if (z == z2) {
            i7 = -1;
        }
        int i8 = R + i7;
        if (i8 < 0 || i8 >= J) {
            return -1;
        }
        return i8;
    }

    public final int g(View view, q qVar) {
        return ((qVar.c(view) / 2) + qVar.e(view)) - ((qVar.l() / 2) + qVar.k());
    }

    public final View h(RecyclerView.m mVar, q qVar) {
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

    public final q i(RecyclerView.m mVar) {
        q qVar = this.f1822e;
        if (qVar == null || qVar.a != mVar) {
            this.f1822e = new o(mVar);
        }
        return this.f1822e;
    }

    public final q j(RecyclerView.m mVar) {
        q qVar = this.f1821d;
        if (qVar == null || qVar.a != mVar) {
            this.f1821d = new p(mVar);
        }
        return this.f1821d;
    }
}
