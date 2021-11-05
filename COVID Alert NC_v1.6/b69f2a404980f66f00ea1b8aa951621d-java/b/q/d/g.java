package b.q.d;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b.q.d.o;
import java.util.ArrayList;
import java.util.Iterator;

public class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1503b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ o f1504c;

    public g(o oVar, ArrayList arrayList) {
        this.f1504c = oVar;
        this.f1503b = arrayList;
    }

    public void run() {
        Iterator it = this.f1503b.iterator();
        while (it.hasNext()) {
            o.b bVar = (o.b) it.next();
            o oVar = this.f1504c;
            RecyclerView.d0 d0Var = bVar.f1541a;
            int i = bVar.f1542b;
            int i2 = bVar.f1543c;
            int i3 = bVar.f1544d;
            int i4 = bVar.f1545e;
            if (oVar != null) {
                View view = d0Var.itemView;
                int i5 = i3 - i;
                int i6 = i4 - i2;
                if (i5 != 0) {
                    view.animate().translationX(0.0f);
                }
                if (i6 != 0) {
                    view.animate().translationY(0.0f);
                }
                ViewPropertyAnimator animate = view.animate();
                oVar.p.add(d0Var);
                animate.setDuration(oVar.f214e).setListener(new l(oVar, d0Var, i5, view, i6, animate)).start();
            } else {
                throw null;
            }
        }
        this.f1503b.clear();
        this.f1504c.m.remove(this.f1503b);
    }
}
