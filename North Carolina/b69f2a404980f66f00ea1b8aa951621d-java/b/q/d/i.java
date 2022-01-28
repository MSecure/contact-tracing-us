package b.q.d;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

public class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1513b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ o f1514c;

    public i(o oVar, ArrayList arrayList) {
        this.f1514c = oVar;
        this.f1513b = arrayList;
    }

    public void run() {
        Iterator it = this.f1513b.iterator();
        while (it.hasNext()) {
            RecyclerView.d0 d0Var = (RecyclerView.d0) it.next();
            o oVar = this.f1514c;
            if (oVar != null) {
                View view = d0Var.itemView;
                ViewPropertyAnimator animate = view.animate();
                oVar.o.add(d0Var);
                animate.alpha(1.0f).setDuration(oVar.f212c).setListener(new k(oVar, d0Var, view, animate)).start();
            } else {
                throw null;
            }
        }
        this.f1513b.clear();
        this.f1514c.l.remove(this.f1513b);
    }
}
