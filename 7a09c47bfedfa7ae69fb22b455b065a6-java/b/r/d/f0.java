package b.r.d;

import android.view.View;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.nearby.messages.BleSignal;

public abstract class f0 extends RecyclerView.o {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f2337a;

    /* renamed from: b  reason: collision with root package name */
    public Scroller f2338b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView.q f2339c = new a();

    public class a extends RecyclerView.q {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2340a = false;

        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void a(RecyclerView recyclerView, int i) {
            if (i == 0 && this.f2340a) {
                this.f2340a = false;
                f0.this.c();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.q
        public void b(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.f2340a = true;
            }
        }
    }

    public abstract int[] a(RecyclerView.m mVar, View view);

    public abstract View b(RecyclerView.m mVar);

    public void c() {
        RecyclerView.m layoutManager;
        View b2;
        RecyclerView recyclerView = this.f2337a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (b2 = b(layoutManager)) != null) {
            int[] a2 = a(layoutManager, b2);
            if (a2[0] != 0 || a2[1] != 0) {
                this.f2337a.l0(a2[0], a2[1], null, BleSignal.UNKNOWN_TX_POWER, false);
            }
        }
    }
}
