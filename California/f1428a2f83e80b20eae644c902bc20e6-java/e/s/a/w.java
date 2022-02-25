package e.s.a;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public abstract class w extends RecyclerView.p {
    public RecyclerView a;
    public Scroller b;
    public final RecyclerView.r c = new a();

    public class a extends RecyclerView.r {
        public boolean a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void a(RecyclerView recyclerView, int i2) {
            if (i2 == 0 && this.a) {
                this.a = false;
                w.this.f();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void b(RecyclerView recyclerView, int i2, int i3) {
            if (i2 != 0 || i3 != 0) {
                this.a = true;
            }
        }
    }

    public class b extends l {
        public b(Context context) {
            super(context);
        }

        @Override // e.s.a.l, androidx.recyclerview.widget.RecyclerView.x
        public void c(View view, RecyclerView.y yVar, RecyclerView.x.a aVar) {
            w wVar = w.this;
            RecyclerView recyclerView = wVar.a;
            if (recyclerView != null) {
                int[] b = wVar.b(recyclerView.getLayoutManager(), view);
                int i2 = b[0];
                int i3 = b[1];
                int g2 = g(Math.max(Math.abs(i2), Math.abs(i3)));
                if (g2 > 0) {
                    aVar.b(i2, i3, g2, this.f1817j);
                }
            }
        }

        @Override // e.s.a.l
        public float f(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.a;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                RecyclerView.r rVar = this.c;
                List<RecyclerView.r> list = recyclerView2.k0;
                if (list != null) {
                    list.remove(rVar);
                }
                this.a.setOnFlingListener(null);
            }
            this.a = recyclerView;
            if (recyclerView == null) {
                return;
            }
            if (recyclerView.getOnFlingListener() == null) {
                this.a.h(this.c);
                this.a.setOnFlingListener(this);
                this.b = new Scroller(this.a.getContext(), new DecelerateInterpolator());
                f();
                return;
            }
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
    }

    public abstract int[] b(RecyclerView.m mVar, View view);

    @Deprecated
    public l c(RecyclerView.m mVar) {
        if (!(mVar instanceof RecyclerView.x.b)) {
            return null;
        }
        return new b(this.a.getContext());
    }

    public abstract View d(RecyclerView.m mVar);

    public abstract int e(RecyclerView.m mVar, int i2, int i3);

    public void f() {
        RecyclerView.m layoutManager;
        View d2;
        RecyclerView recyclerView = this.a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (d2 = d(layoutManager)) != null) {
            int[] b2 = b(layoutManager, d2);
            if (b2[0] != 0 || b2[1] != 0) {
                this.a.k0(b2[0], b2[1], null, Integer.MIN_VALUE, false);
            }
        }
    }
}
