package c.b.a.b.x;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.i.k.b;
import java.util.Calendar;

public class h extends RecyclerView.n {

    /* renamed from: a  reason: collision with root package name */
    public final Calendar f3256a = a0.g();

    /* renamed from: b  reason: collision with root package name */
    public final Calendar f3257b = a0.g();

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f3258c;

    public h(g gVar) {
        this.f3258c = gVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if ((recyclerView.getAdapter() instanceof c0) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            c0 c0Var = (c0) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            for (b<Long, Long> bVar : this.f3258c.f3248d.g()) {
                F f = bVar.f1133a;
                if (!(f == null || bVar.f1134b == null)) {
                    this.f3256a.setTimeInMillis(f.longValue());
                    this.f3257b.setTimeInMillis(bVar.f1134b.longValue());
                    int a2 = c0Var.a(this.f3256a.get(1));
                    int a3 = c0Var.a(this.f3257b.get(1));
                    View t = gridLayoutManager.t(a2);
                    View t2 = gridLayoutManager.t(a3);
                    int i = gridLayoutManager.I;
                    int i2 = a2 / i;
                    int i3 = a3 / i;
                    for (int i4 = i2; i4 <= i3; i4++) {
                        View t3 = gridLayoutManager.t(gridLayoutManager.I * i4);
                        if (t3 != null) {
                            int top = t3.getTop() + this.f3258c.h.f3238d.f3228a.top;
                            int bottom = t3.getBottom() - this.f3258c.h.f3238d.f3228a.bottom;
                            canvas.drawRect((float) (i4 == i2 ? (t.getWidth() / 2) + t.getLeft() : 0), (float) top, (float) (i4 == i3 ? (t2.getWidth() / 2) + t2.getLeft() : recyclerView.getWidth()), (float) bottom, this.f3258c.h.h);
                        }
                    }
                }
            }
        }
    }
}
