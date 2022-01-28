package c.b.a.b.x;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.r.d.t;

public class y extends LinearLayoutManager {

    public class a extends t {
        public a(y yVar, Context context) {
            super(context);
        }

        @Override // b.r.d.t
        public float f(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }
    }

    public y(Context context, int i, boolean z) {
        super(i, z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m, androidx.recyclerview.widget.LinearLayoutManager
    public void U0(RecyclerView recyclerView, RecyclerView.x xVar, int i) {
        a aVar = new a(this, recyclerView.getContext());
        aVar.f329a = i;
        V0(aVar);
    }
}
