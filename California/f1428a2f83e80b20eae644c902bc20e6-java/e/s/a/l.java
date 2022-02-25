package e.s.a;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

public class l extends RecyclerView.x {

    /* renamed from: i  reason: collision with root package name */
    public final LinearInterpolator f1816i = new LinearInterpolator();

    /* renamed from: j  reason: collision with root package name */
    public final DecelerateInterpolator f1817j = new DecelerateInterpolator();

    /* renamed from: k  reason: collision with root package name */
    public PointF f1818k;

    /* renamed from: l  reason: collision with root package name */
    public final DisplayMetrics f1819l;
    public boolean m = false;
    public float n;
    public int o = 0;
    public int p = 0;

    public l(Context context) {
        this.f1819l = context.getResources().getDisplayMetrics();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x
    public void c(View view, RecyclerView.y yVar, RecyclerView.x.a aVar) {
        int i2;
        int i3;
        int i4;
        PointF pointF = this.f1818k;
        int i5 = 0;
        int i6 = (pointF == null || pointF.x == 0.0f) ? 0 : i4 > 0 ? 1 : -1;
        RecyclerView.m mVar = this.c;
        if (mVar == null || !mVar.e()) {
            i2 = 0;
        } else {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            i2 = e(mVar.D(view) - ((ViewGroup.MarginLayoutParams) nVar).leftMargin, mVar.G(view) + ((ViewGroup.MarginLayoutParams) nVar).rightMargin, mVar.O(), mVar.p - mVar.P(), i6);
        }
        PointF pointF2 = this.f1818k;
        int i7 = (pointF2 == null || pointF2.y == 0.0f) ? 0 : i3 > 0 ? 1 : -1;
        RecyclerView.m mVar2 = this.c;
        if (mVar2 != null && mVar2.f()) {
            RecyclerView.n nVar2 = (RecyclerView.n) view.getLayoutParams();
            i5 = e(mVar2.H(view) - ((ViewGroup.MarginLayoutParams) nVar2).topMargin, mVar2.B(view) + ((ViewGroup.MarginLayoutParams) nVar2).bottomMargin, mVar2.Q(), mVar2.q - mVar2.N(), i7);
        }
        int g2 = g((int) Math.sqrt((double) ((i5 * i5) + (i2 * i2))));
        if (g2 > 0) {
            aVar.b(-i2, -i5, g2, this.f1817j);
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
        return (int) Math.ceil(((double) h(i2)) / 0.3356d);
    }

    public int h(int i2) {
        float abs = (float) Math.abs(i2);
        if (!this.m) {
            this.n = f(this.f1819l);
            this.m = true;
        }
        return (int) Math.ceil((double) (abs * this.n));
    }
}
