package b.q.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import b.i.l.w.b;
import b.i.l.w.c;
import java.util.Map;
import java.util.WeakHashMap;

public class b0 extends b.i.l.a {

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f1457d;

    /* renamed from: e  reason: collision with root package name */
    public final a f1458e;

    public static class a extends b.i.l.a {

        /* renamed from: d  reason: collision with root package name */
        public final b0 f1459d;

        /* renamed from: e  reason: collision with root package name */
        public Map<View, b.i.l.a> f1460e = new WeakHashMap();

        public a(b0 b0Var) {
            this.f1459d = b0Var;
        }

        @Override // b.i.l.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            b.i.l.a aVar = this.f1460e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : this.f1139a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // b.i.l.a
        public c b(View view) {
            b.i.l.a aVar = this.f1460e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // b.i.l.a
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            b.i.l.a aVar = this.f1460e.get(view);
            if (aVar != null) {
                aVar.c(view, accessibilityEvent);
            } else {
                this.f1139a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // b.i.l.a
        public void d(View view, b bVar) {
            if (!this.f1459d.j() && this.f1459d.f1457d.getLayoutManager() != null) {
                this.f1459d.f1457d.getLayoutManager().j0(view, bVar);
                b.i.l.a aVar = this.f1460e.get(view);
                if (aVar != null) {
                    aVar.d(view, bVar);
                    return;
                }
            }
            this.f1139a.onInitializeAccessibilityNodeInfo(view, bVar.f1195a);
        }

        @Override // b.i.l.a
        public void e(View view, AccessibilityEvent accessibilityEvent) {
            b.i.l.a aVar = this.f1460e.get(view);
            if (aVar != null) {
                aVar.e(view, accessibilityEvent);
            } else {
                this.f1139a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // b.i.l.a
        public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            b.i.l.a aVar = this.f1460e.get(viewGroup);
            return aVar != null ? aVar.f(viewGroup, view, accessibilityEvent) : this.f1139a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // b.i.l.a
        public boolean g(View view, int i, Bundle bundle) {
            if (this.f1459d.j() || this.f1459d.f1457d.getLayoutManager() == null) {
                return super.g(view, i, bundle);
            }
            b.i.l.a aVar = this.f1460e.get(view);
            if (aVar != null) {
                if (aVar.g(view, i, bundle)) {
                    return true;
                }
            } else if (super.g(view, i, bundle)) {
                return true;
            }
            RecyclerView.o layoutManager = this.f1459d.f1457d.getLayoutManager();
            RecyclerView.v vVar = layoutManager.f219b.mRecycler;
            return layoutManager.B0();
        }

        @Override // b.i.l.a
        public void h(View view, int i) {
            b.i.l.a aVar = this.f1460e.get(view);
            if (aVar != null) {
                aVar.h(view, i);
            } else {
                this.f1139a.sendAccessibilityEvent(view, i);
            }
        }

        @Override // b.i.l.a
        public void i(View view, AccessibilityEvent accessibilityEvent) {
            b.i.l.a aVar = this.f1460e.get(view);
            if (aVar != null) {
                aVar.i(view, accessibilityEvent);
            } else {
                this.f1139a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public b0(RecyclerView recyclerView) {
        this.f1457d = recyclerView;
        a aVar = this.f1458e;
        this.f1458e = aVar == null ? new a(this) : aVar;
    }

    @Override // b.i.l.a
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f1139a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !j()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().h0(accessibilityEvent);
            }
        }
    }

    @Override // b.i.l.a
    public void d(View view, b bVar) {
        this.f1139a.onInitializeAccessibilityNodeInfo(view, bVar.f1195a);
        if (!j() && this.f1457d.getLayoutManager() != null) {
            RecyclerView.o layoutManager = this.f1457d.getLayoutManager();
            RecyclerView recyclerView = layoutManager.f219b;
            RecyclerView.v vVar = recyclerView.mRecycler;
            RecyclerView.a0 a0Var = recyclerView.mState;
            if (recyclerView.canScrollVertically(-1) || layoutManager.f219b.canScrollHorizontally(-1)) {
                bVar.f1195a.addAction(RecyclerView.d0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
                bVar.f1195a.setScrollable(true);
            }
            if (layoutManager.f219b.canScrollVertically(1) || layoutManager.f219b.canScrollHorizontally(1)) {
                bVar.f1195a.addAction(4096);
                bVar.f1195a.setScrollable(true);
            }
            bVar.i(b.C0026b.a(layoutManager.R(vVar, a0Var), layoutManager.A(vVar, a0Var), layoutManager.V(), layoutManager.S()));
        }
    }

    @Override // b.i.l.a
    public boolean g(View view, int i, Bundle bundle) {
        if (super.g(view, i, bundle)) {
            return true;
        }
        if (j() || this.f1457d.getLayoutManager() == null) {
            return false;
        }
        RecyclerView.o layoutManager = this.f1457d.getLayoutManager();
        RecyclerView.v vVar = layoutManager.f219b.mRecycler;
        return layoutManager.A0(i);
    }

    public boolean j() {
        return this.f1457d.hasPendingAdapterUpdates();
    }
}
