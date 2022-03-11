package f.b.a.e.l;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import e.j.i.b;
import java.util.Calendar;
/* loaded from: classes.dex */
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
            for (b<Long, Long> bVar : this.c.Y.e()) {
                Long l2 = bVar.a;
                if (!(l2 == null || bVar.b == null)) {
                    this.a.setTimeInMillis(l2.longValue());
                    this.b.setTimeInMillis(bVar.b.longValue());
                    int m = f0Var.m(this.a.get(1));
                    int m2 = f0Var.m(this.b.get(1));
                    View u = gridLayoutManager.u(m);
                    View u2 = gridLayoutManager.u(m2);
                    int i2 = gridLayoutManager.H;
                    int i3 = m / i2;
                    int i4 = m2 / i2;
                    for (int i5 = i3; i5 <= i4; i5++) {
                        View u3 = gridLayoutManager.u(gridLayoutManager.H * i5);
                        if (u3 != null) {
                            int top = u3.getTop() + this.c.c0.f2933d.a.top;
                            int bottom = u3.getBottom() - this.c.c0.f2933d.a.bottom;
                            canvas.drawRect((float) (i5 == i3 ? (u.getWidth() / 2) + u.getLeft() : 0), (float) top, (float) (i5 == i4 ? (u2.getWidth() / 2) + u2.getLeft() : recyclerView.getWidth()), (float) bottom, this.c.c0.f2937h);
                        }
                    }
                }
            }
        }
    }
}
