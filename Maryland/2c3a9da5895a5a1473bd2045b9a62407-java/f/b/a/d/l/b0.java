package f.b.a.d.l;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import e.s.a.n;

public class b0 extends LinearLayoutManager {

    public class a extends n {
        public a(b0 b0Var, Context context) {
            super(context);
        }

        @Override // e.s.a.n
        public float f(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }
    }

    public b0(Context context, int i2, boolean z) {
        super(i2, z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public void Y0(RecyclerView recyclerView, RecyclerView.y yVar, int i2) {
        a aVar = new a(this, recyclerView.getContext());
        aVar.a = i2;
        Z0(aVar);
    }
}
