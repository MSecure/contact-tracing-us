package b.q.d;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

public class t extends RecyclerView.z {
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

    @Override // androidx.recyclerview.widget.RecyclerView.z
    public void b(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
        int i2;
        int i3;
        int i4;
        PointF pointF = this.k;
        int i5 = 0;
        int i6 = (pointF == null || pointF.x == 0.0f) ? 0 : i4 > 0 ? 1 : -1;
        RecyclerView.o oVar = this.f248c;
        if (oVar == null || !oVar.e()) {
            i2 = 0;
        } else {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            i2 = d(oVar.C(view) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, oVar.F(view) + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, oVar.M(), oVar.q - oVar.N(), i6);
        }
        PointF pointF2 = this.k;
        int i7 = (pointF2 == null || pointF2.y == 0.0f) ? 0 : i3 > 0 ? 1 : -1;
        RecyclerView.o oVar2 = this.f248c;
        if (oVar2 != null && oVar2.f()) {
            RecyclerView.p pVar2 = (RecyclerView.p) view.getLayoutParams();
            i5 = d(oVar2.G(view) - ((ViewGroup.MarginLayoutParams) pVar2).topMargin, oVar2.B(view) + ((ViewGroup.MarginLayoutParams) pVar2).bottomMargin, oVar2.O(), oVar2.r - oVar2.L(), i7);
        }
        int ceil = (int) Math.ceil(((double) f((int) Math.sqrt((double) ((i5 * i5) + (i2 * i2))))) / 0.3356d);
        if (ceil > 0) {
            aVar.b(-i2, -i5, ceil, this.j);
        }
    }

    public int d(int i2, int i3, int i4, int i5, int i6) {
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

    public float e(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    public int f(int i2) {
        float abs = (float) Math.abs(i2);
        if (!this.m) {
            this.n = e(this.l);
            this.m = true;
        }
        return (int) Math.ceil((double) (abs * this.n));
    }
}
