package b.q.d;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.q.d.o;
import java.util.ArrayList;
import java.util.Iterator;

public class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1511b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ o f1512c;

    public h(o oVar, ArrayList arrayList) {
        this.f1512c = oVar;
        this.f1511b = arrayList;
    }

    public void run() {
        Iterator it = this.f1511b.iterator();
        while (it.hasNext()) {
            o.a aVar = (o.a) it.next();
            o oVar = this.f1512c;
            View view = null;
            if (oVar != null) {
                RecyclerView.d0 d0Var = aVar.f1536a;
                View view2 = d0Var == null ? null : d0Var.itemView;
                RecyclerView.d0 d0Var2 = aVar.f1537b;
                if (d0Var2 != null) {
                    view = d0Var2.itemView;
                }
                if (view2 != null) {
                    ViewPropertyAnimator duration = view2.animate().setDuration(oVar.f);
                    oVar.r.add(aVar.f1536a);
                    duration.translationX((float) (aVar.f1540e - aVar.f1538c));
                    duration.translationY((float) (aVar.f - aVar.f1539d));
                    duration.alpha(0.0f).setListener(new m(oVar, aVar, duration, view2)).start();
                }
                if (view != null) {
                    ViewPropertyAnimator animate = view.animate();
                    oVar.r.add(aVar.f1537b);
                    animate.translationX(0.0f).translationY(0.0f).setDuration(oVar.f).alpha(1.0f).setListener(new n(oVar, aVar, animate, view)).start();
                }
            } else {
                throw null;
            }
        }
        this.f1511b.clear();
        this.f1512c.n.remove(this.f1511b);
    }
}
