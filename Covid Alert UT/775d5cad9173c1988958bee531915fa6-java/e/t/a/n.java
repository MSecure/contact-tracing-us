package e.t.a;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

public class n extends RecyclerView.x {

    /* renamed from: i  reason: collision with root package name */
    public final LinearInterpolator f1943i = new LinearInterpolator();

    /* renamed from: j  reason: collision with root package name */
    public final DecelerateInterpolator f1944j = new DecelerateInterpolator();

    /* renamed from: k  reason: collision with root package name */
    public PointF f1945k;

    /* renamed from: l  reason: collision with root package name */
    public final DisplayMetrics f1946l;
    public boolean m = false;
    public float n;
    public int o = 0;
    public int p = 0;

    public n(Context context) {
        this.f1946l = context.getResources().getDisplayMetrics();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x
    public void b(View view, RecyclerView.y yVar, RecyclerView.x.a aVar) {
        int i2;
        int i3;
        int i4;
        PointF pointF = this.f1945k;
        int i5 = 0;
        int i6 = (pointF == null || pointF.x == 0.0f) ? 0 : i4 > 0 ? 1 : -1;
        RecyclerView.m mVar = this.c;
        if (mVar == null || !mVar.f()) {
            i2 = 0;
        } else {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            i2 = d(mVar.E(view) - ((ViewGroup.MarginLayoutParams) nVar).leftMargin, mVar.H(view) + ((ViewGroup.MarginLayoutParams) nVar).rightMargin, mVar.P(), mVar.p - mVar.Q(), i6);
        }
        PointF pointF2 = this.f1945k;
        int i7 = (pointF2 == null || pointF2.y == 0.0f) ? 0 : i3 > 0 ? 1 : -1;
        RecyclerView.m mVar2 = this.c;
        if (mVar2 != null && mVar2.g()) {
            RecyclerView.n nVar2 = (RecyclerView.n) view.getLayoutParams();
            i5 = d(mVar2.I(view) - ((ViewGroup.MarginLayoutParams) nVar2).topMargin, mVar2.C(view) + ((ViewGroup.MarginLayoutParams) nVar2).bottomMargin, mVar2.R(), mVar2.q - mVar2.O(), i7);
        }
        int ceil = (int) Math.ceil(((double) f((int) Math.sqrt((double) ((i5 * i5) + (i2 * i2))))) / 0.3356d);
        if (ceil > 0) {
            aVar.b(-i2, -i5, ceil, this.f1944j);
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
            this.n = e(this.f1946l);
            this.m = true;
        }
        return (int) Math.ceil((double) (abs * this.n));
    }
}
