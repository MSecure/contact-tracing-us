package e.w;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R$id;
import e.w.h;
import java.util.ArrayList;

public class z extends k {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a0 f1971d;

    public z(a0 a0Var, ViewGroup viewGroup, View view, View view2) {
        this.f1971d = a0Var;
        this.a = viewGroup;
        this.b = view;
        this.c = view2;
    }

    @Override // e.w.k, e.w.h.d
    public void a(h hVar) {
        this.a.getOverlay().remove(this.b);
    }

    @Override // e.w.k, e.w.h.d
    public void b(h hVar) {
        if (this.b.getParent() == null) {
            this.a.getOverlay().add(this.b);
            return;
        }
        a0 a0Var = this.f1971d;
        int size = a0Var.n.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            a0Var.n.get(size).cancel();
        }
        ArrayList<h.d> arrayList = a0Var.r;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) a0Var.r.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((h.d) arrayList2.get(i2)).d(a0Var);
            }
        }
    }

    @Override // e.w.h.d
    public void e(h hVar) {
        this.c.setTag(R$id.save_overlay_view, null);
        this.a.getOverlay().remove(this.b);
        hVar.v(this);
    }
}
