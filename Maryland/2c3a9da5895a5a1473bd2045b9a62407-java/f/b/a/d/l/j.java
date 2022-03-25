package f.b.a.d.l;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import e.i.h.a;
import java.util.Calendar;
import java.util.Objects;

public class j extends RecyclerView.l {
    public final Calendar a = d0.g();
    public final Calendar b = d0.g();
    public final /* synthetic */ i c;

    public j(i iVar) {
        this.c = iVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        if ((recyclerView.getAdapter() instanceof f0) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            f0 f0Var = (f0) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            for (a<Long, Long> aVar : this.c.Z.e()) {
                Objects.requireNonNull(aVar);
            }
        }
    }
}
