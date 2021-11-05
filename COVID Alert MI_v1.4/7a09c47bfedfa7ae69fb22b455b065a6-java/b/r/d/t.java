package b.r.d;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

public class t extends RecyclerView.w {
    public final LinearInterpolator i = new LinearInterpolator();
    public final DecelerateInterpolator j = new DecelerateInterpolator();
    public PointF k;
    public final DisplayMetrics l;
    public boolean m = false;
    public float n;
    public int o = 0;
    public int p = 0;

    public t(Context context) {
        this.l = context.getResources().getDisplayMetrics();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.w
    public void c(View view, RecyclerView.x xVar, RecyclerView.w.a aVar) {
        int i2;
        int i3;
        int i4;
        PointF pointF = this.k;
        int i5 = 0;
        int i6 = (pointF == null || pointF.x == 0.0f) ? 0 : i4 > 0 ? 1 : -1;
        RecyclerView.m mVar = this.f331c;
        if (mVar == null || !mVar.e()) {
            i2 = 0;
        } else {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            i2 = e(mVar.C(view) - ((ViewGroup.MarginLayoutParams) nVar).leftMargin, mVar.F(view) + ((ViewGroup.MarginLayoutParams) nVar).rightMargin, mVar.M(), mVar.q - mVar.N(), i6);
        }
        PointF pointF2 = this.k;
        int i7 = (pointF2 == null || pointF2.y == 0.0f) ? 0 : i3 > 0 ? 1 : -1;
        RecyclerView.m mVar2 = this.f331c;
        if (mVar2 != null && mVar2.f()) {
            RecyclerView.n nVar2 = (RecyclerView.n) view.getLayoutParams();
            i5 = e(mVar2.G(view) - ((ViewGroup.MarginLayoutParams) nVar2).topMargin, mVar2.B(view) + ((ViewGroup.MarginLayoutParams) nVar2).bottomMargin, mVar2.O(), mVar2.r - mVar2.L(), i7);
        }
        int ceil = (int) Math.ceil(((double) g((int) Math.sqrt((double) ((i5 * i5) + (i2 * i2))))) / 0.3356d);
        if (ceil > 0) {
            aVar.b(-i2, -i5, ceil, this.j);
        }
    }

    public int e(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == -1) {
            return i4 - i2;
        }
        if (i6 == 0) {
            int i7 = i4 - i2;
            if (i7 > 0) {
                return i7;
            }
            int i8 = i5 - i3;
            if (i8 < 0) {
                return i8;
            }
            return 0;
        } else if (i6 == 1) {
            return i5 - i3;
        } else {
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public float f(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    public int g(int i2) {
        float abs = (float) Math.abs(i2);
        if (!this.m) {
            this.n = f(this.l);
            this.m = true;
        }
        return (int) Math.ceil((double) (abs * this.n));
    }
}
