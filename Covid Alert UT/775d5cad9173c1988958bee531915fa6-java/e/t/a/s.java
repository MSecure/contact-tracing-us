package e.t.a;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class s extends n {
    public final /* synthetic */ t q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public s(t tVar, Context context) {
        super(context);
        this.q = tVar;
    }

    @Override // e.t.a.n, androidx.recyclerview.widget.RecyclerView.x
    public void b(View view, RecyclerView.y yVar, RecyclerView.x.a aVar) {
        t tVar = this.q;
        int[] a = tVar.a(tVar.a.getLayoutManager(), view);
        int i2 = a[0];
        int i3 = a[1];
        int ceil = (int) Math.ceil(((double) f(Math.max(Math.abs(i2), Math.abs(i3)))) / 0.3356d);
        if (ceil > 0) {
            aVar.b(i2, i3, ceil, this.f1944j);
        }
    }

    @Override // e.t.a.n
    public float e(DisplayMetrics displayMetrics) {
        return 100.0f / ((float) displayMetrics.densityDpi);
    }

    @Override // e.t.a.n
    public int f(int i2) {
        return Math.min(100, super.f(i2));
    }
}
