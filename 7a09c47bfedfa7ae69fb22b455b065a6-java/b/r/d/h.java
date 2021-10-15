package b.r.d;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.r.d.o;
import java.util.ArrayList;
import java.util.Iterator;

public class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2344b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ o f2345c;

    public h(o oVar, ArrayList arrayList) {
        this.f2345c = oVar;
        this.f2344b = arrayList;
    }

    public void run() {
        Iterator it = this.f2344b.iterator();
        while (it.hasNext()) {
            o.a aVar = (o.a) it.next();
            o oVar = this.f2345c;
            View view = null;
            if (oVar != null) {
                RecyclerView.a0 a0Var = aVar.f2383a;
                View view2 = a0Var == null ? null : a0Var.itemView;
                RecyclerView.a0 a0Var2 = aVar.f2384b;
                if (a0Var2 != null) {
                    view = a0Var2.itemView;
                }
                if (view2 != null) {
                    ViewPropertyAnimator duration = view2.animate().setDuration(oVar.f293f);
                    oVar.r.add(aVar.f2383a);
                    duration.translationX((float) (aVar.f2387e - aVar.f2385c));
                    duration.translationY((float) (aVar.f2388f - aVar.f2386d));
                    duration.alpha(0.0f).setListener(new m(oVar, aVar, duration, view2)).start();
                }
                if (view != null) {
                    ViewPropertyAnimator animate = view.animate();
                    oVar.r.add(aVar.f2384b);
                    animate.translationX(0.0f).translationY(0.0f).setDuration(oVar.f293f).alpha(1.0f).setListener(new n(oVar, aVar, animate, view)).start();
                }
            } else {
                throw null;
            }
        }
        this.f2344b.clear();
        this.f2345c.n.remove(this.f2344b);
    }
}
