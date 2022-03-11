package e.u.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public abstract class y extends RecyclerView.p {
    public RecyclerView a;
    public final RecyclerView.r b = new a();

    /* loaded from: classes.dex */
    public class a extends RecyclerView.r {
        public boolean a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void a(RecyclerView recyclerView, int i2) {
            if (i2 == 0 && this.a) {
                this.a = false;
                y.this.b();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void b(RecyclerView recyclerView, int i2, int i3) {
            if (i2 != 0 || i3 != 0) {
                this.a = true;
            }
        }
    }

    public abstract int[] a(RecyclerView.m mVar, View view);

    /* JADX WARN: Removed duplicated region for block: B:17:0x002c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void b() {
        RecyclerView.m layoutManager;
        View view;
        r rVar;
        RecyclerView recyclerView = this.a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
            t tVar = (t) this;
            if (layoutManager.g()) {
                rVar = tVar.f(layoutManager);
            } else if (layoutManager.f()) {
                rVar = tVar.e(layoutManager);
            } else {
                view = null;
                if (view == null) {
                    int[] a2 = a(layoutManager, view);
                    if (a2[0] != 0 || a2[1] != 0) {
                        this.a.l0(a2[0], a2[1], null, Integer.MIN_VALUE, false);
                        return;
                    }
                    return;
                }
                return;
            }
            view = tVar.d(layoutManager, rVar);
            if (view == null) {
            }
        }
    }
}
