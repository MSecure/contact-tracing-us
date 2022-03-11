package e.s.a;

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

    @Override // e.s.a.n, androidx.recyclerview.widget.RecyclerView.x
    public void c(View view, RecyclerView.y yVar, RecyclerView.x.a aVar) {
        t tVar = this.q;
        int[] b = tVar.b(tVar.a.getLayoutManager(), view);
        int i2 = b[0];
        int i3 = b[1];
        int ceil = (int) Math.ceil(((double) g(Math.max(Math.abs(i2), Math.abs(i3)))) / 0.3356d);
        if (ceil > 0) {
            aVar.b(i2, i3, ceil, this.f1853j);
        }
    }

    @Override // e.s.a.n
    public float f(DisplayMetrics displayMetrics) {
        return 100.0f / ((float) displayMetrics.densityDpi);
    }

    @Override // e.s.a.n
    public int g(int i2) {
        return Math.min(100, super.g(i2));
    }
}
