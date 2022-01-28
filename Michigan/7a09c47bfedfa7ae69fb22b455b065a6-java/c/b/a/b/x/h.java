package c.b.a.b.x;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.i.k.a;
import java.util.Calendar;

public class h extends RecyclerView.l {

    /* renamed from: a  reason: collision with root package name */
    public final Calendar f4585a = a0.g();

    /* renamed from: b  reason: collision with root package name */
    public final Calendar f4586b = a0.g();

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ g f4587c;

    public h(g gVar) {
        this.f4587c = gVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void d(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar) {
        if ((recyclerView.getAdapter() instanceof c0) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            c0 c0Var = (c0) recyclerView.getAdapter();
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            for (a<Long, Long> aVar : this.f4587c.f4575d.i()) {
                F f2 = aVar.f1841a;
                if (!(f2 == null || aVar.f1842b == null)) {
                    this.f4585a.setTimeInMillis(f2.longValue());
                    this.f4586b.setTimeInMillis(aVar.f1842b.longValue());
                    int a2 = c0Var.a(this.f4585a.get(1));
                    int a3 = c0Var.a(this.f4586b.get(1));
                    View t = gridLayoutManager.t(a2);
                    View t2 = gridLayoutManager.t(a3);
                    int i = gridLayoutManager.I;
                    int i2 = a2 / i;
                    int i3 = a3 / i;
                    for (int i4 = i2; i4 <= i3; i4++) {
                        View t3 = gridLayoutManager.t(gridLayoutManager.I * i4);
                        if (t3 != null) {
                            int top = t3.getTop() + this.f4587c.h.f4563d.f4552a.top;
                            int bottom = t3.getBottom() - this.f4587c.h.f4563d.f4552a.bottom;
                            canvas.drawRect((float) (i4 == i2 ? (t.getWidth() / 2) + t.getLeft() : 0), (float) top, (float) (i4 == i3 ? (t2.getWidth() / 2) + t2.getLeft() : recyclerView.getWidth()), (float) bottom, this.f4587c.h.h);
                        }
                    }
                }
            }
        }
    }
}
