package b.r.d;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class g0 extends t {
    public final /* synthetic */ f0 q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g0(f0 f0Var, Context context) {
        super(context);
        this.q = f0Var;
    }

    @Override // b.r.d.t, androidx.recyclerview.widget.RecyclerView.w
    public void c(View view, RecyclerView.x xVar, RecyclerView.w.a aVar) {
        f0 f0Var = this.q;
        RecyclerView recyclerView = f0Var.f2337a;
        if (recyclerView != null) {
            int[] a2 = f0Var.a(recyclerView.getLayoutManager(), view);
            int i = a2[0];
            int i2 = a2[1];
            int ceil = (int) Math.ceil(((double) g(Math.max(Math.abs(i), Math.abs(i2)))) / 0.3356d);
            if (ceil > 0) {
                aVar.b(i, i2, ceil, this.j);
            }
        }
    }

    @Override // b.r.d.t
    public float f(DisplayMetrics displayMetrics) {
        return 100.0f / ((float) displayMetrics.densityDpi);
    }
}
