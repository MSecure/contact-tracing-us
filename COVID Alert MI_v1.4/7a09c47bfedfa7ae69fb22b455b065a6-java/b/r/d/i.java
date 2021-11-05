package b.r.d;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

public class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2353b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ o f2354c;

    public i(o oVar, ArrayList arrayList) {
        this.f2354c = oVar;
        this.f2353b = arrayList;
    }

    public void run() {
        Iterator it = this.f2353b.iterator();
        while (it.hasNext()) {
            RecyclerView.a0 a0Var = (RecyclerView.a0) it.next();
            o oVar = this.f2354c;
            if (oVar != null) {
                View view = a0Var.itemView;
                ViewPropertyAnimator animate = view.animate();
                oVar.o.add(a0Var);
                animate.alpha(1.0f).setDuration(oVar.f290c).setListener(new k(oVar, a0Var, view, animate)).start();
            } else {
                throw null;
            }
        }
        this.f2353b.clear();
        this.f2354c.l.remove(this.f2353b);
    }
}
