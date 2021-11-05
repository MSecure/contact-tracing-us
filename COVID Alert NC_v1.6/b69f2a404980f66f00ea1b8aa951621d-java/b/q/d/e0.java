package b.q.d;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class e0 extends t {
    public final /* synthetic */ d0 q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e0(d0 d0Var, Context context) {
        super(context);
        this.q = d0Var;
    }

    @Override // b.q.d.t, androidx.recyclerview.widget.RecyclerView.z
    public void b(View view, RecyclerView.a0 a0Var, RecyclerView.z.a aVar) {
        d0 d0Var = this.q;
        RecyclerView recyclerView = d0Var.f1481a;
        if (recyclerView != null) {
            int[] a2 = d0Var.a(recyclerView.getLayoutManager(), view);
            int i = a2[0];
            int i2 = a2[1];
            int ceil = (int) Math.ceil(((double) f(Math.max(Math.abs(i), Math.abs(i2)))) / 0.3356d);
            if (ceil > 0) {
                aVar.b(i, i2, ceil, this.j);
            }
        }
    }

    @Override // b.q.d.t
    public float e(DisplayMetrics displayMetrics) {
        return 100.0f / ((float) displayMetrics.densityDpi);
    }
}
