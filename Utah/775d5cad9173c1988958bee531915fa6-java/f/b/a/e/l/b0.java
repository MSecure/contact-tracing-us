package f.b.a.e.l;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import e.t.a.n;

public class b0 extends LinearLayoutManager {

    public class a extends n {
        public a(b0 b0Var, Context context) {
            super(context);
        }

        @Override // e.t.a.n
        public float e(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }
    }

    public b0(Context context, int i2, boolean z) {
        super(i2, z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public void X0(RecyclerView recyclerView, RecyclerView.y yVar, int i2) {
        a aVar = new a(this, recyclerView.getContext());
        aVar.a = i2;
        Y0(aVar);
    }
}
