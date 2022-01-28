package b.r.d;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.r.d.o;
import java.util.ArrayList;
import java.util.Iterator;

public class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2342b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ o f2343c;

    public g(o oVar, ArrayList arrayList) {
        this.f2343c = oVar;
        this.f2342b = arrayList;
    }

    public void run() {
        Iterator it = this.f2342b.iterator();
        while (it.hasNext()) {
            o.b bVar = (o.b) it.next();
            o oVar = this.f2343c;
            RecyclerView.a0 a0Var = bVar.f2389a;
            int i = bVar.f2390b;
            int i2 = bVar.f2391c;
            int i3 = bVar.f2392d;
            int i4 = bVar.f2393e;
            if (oVar != null) {
                View view = a0Var.itemView;
                int i5 = i3 - i;
                int i6 = i4 - i2;
                if (i5 != 0) {
                    view.animate().translationX(0.0f);
                }
                if (i6 != 0) {
                    view.animate().translationY(0.0f);
                }
                ViewPropertyAnimator animate = view.animate();
                oVar.p.add(a0Var);
                animate.setDuration(oVar.f292e).setListener(new l(oVar, a0Var, i5, view, i6, animate)).start();
            } else {
                throw null;
            }
        }
        this.f2342b.clear();
        this.f2343c.m.remove(this.f2342b);
    }
}
