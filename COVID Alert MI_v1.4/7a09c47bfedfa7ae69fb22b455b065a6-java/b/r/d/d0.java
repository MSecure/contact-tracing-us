package b.r.d;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import b.i.l.w.b;
import b.i.l.w.c;
import java.util.Map;
import java.util.WeakHashMap;

public class d0 extends b.i.l.a {

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f2322d;

    /* renamed from: e  reason: collision with root package name */
    public final a f2323e;

    public static class a extends b.i.l.a {

        /* renamed from: d  reason: collision with root package name */
        public final d0 f2324d;

        /* renamed from: e  reason: collision with root package name */
        public Map<View, b.i.l.a> f2325e = new WeakHashMap();

        public a(d0 d0Var) {
            this.f2324d = d0Var;
        }

        @Override // b.i.l.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            b.i.l.a aVar = this.f2325e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : this.f1847a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // b.i.l.a
        public c b(View view) {
            b.i.l.a aVar = this.f2325e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // b.i.l.a
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            b.i.l.a aVar = this.f2325e.get(view);
            if (aVar != null) {
                aVar.c(view, accessibilityEvent);
            } else {
                this.f1847a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // b.i.l.a
        public void d(View view, b bVar) {
            if (!this.f2324d.j() && this.f2324d.f2322d.getLayoutManager() != null) {
                this.f2324d.f2322d.getLayoutManager().j0(view, bVar);
                b.i.l.a aVar = this.f2325e.get(view);
                if (aVar != null) {
                    aVar.d(view, bVar);
                    return;
                }
            }
            this.f1847a.onInitializeAccessibilityNodeInfo(view, bVar.f1906a);
        }

        @Override // b.i.l.a
        public void e(View view, AccessibilityEvent accessibilityEvent) {
            b.i.l.a aVar = this.f2325e.get(view);
            if (aVar != null) {
                aVar.e(view, accessibilityEvent);
            } else {
                this.f1847a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // b.i.l.a
        public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            b.i.l.a aVar = this.f2325e.get(viewGroup);
            return aVar != null ? aVar.f(viewGroup, view, accessibilityEvent) : this.f1847a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // b.i.l.a
        public boolean g(View view, int i, Bundle bundle) {
            if (this.f2324d.j() || this.f2324d.f2322d.getLayoutManager() == null) {
                return super.g(view, i, bundle);
            }
            b.i.l.a aVar = this.f2325e.get(view);
            if (aVar != null) {
                if (aVar.g(view, i, bundle)) {
                    return true;
                }
            } else if (super.g(view, i, bundle)) {
                return true;
            }
            RecyclerView.m layoutManager = this.f2324d.f2322d.getLayoutManager();
            RecyclerView.s sVar = layoutManager.f298b.f280c;
            return layoutManager.B0();
        }

        @Override // b.i.l.a
        public void h(View view, int i) {
            b.i.l.a aVar = this.f2325e.get(view);
            if (aVar != null) {
                aVar.h(view, i);
            } else {
                this.f1847a.sendAccessibilityEvent(view, i);
            }
        }

        @Override // b.i.l.a
        public void i(View view, AccessibilityEvent accessibilityEvent) {
            b.i.l.a aVar = this.f2325e.get(view);
            if (aVar != null) {
                aVar.i(view, accessibilityEvent);
            } else {
                this.f1847a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public d0(RecyclerView recyclerView) {
        this.f2322d = recyclerView;
        a aVar = this.f2323e;
        this.f2323e = aVar == null ? new a(this) : aVar;
    }

    @Override // b.i.l.a
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f1847a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !j()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().h0(accessibilityEvent);
            }
        }
    }

    @Override // b.i.l.a
    public void d(View view, b bVar) {
        this.f1847a.onInitializeAccessibilityNodeInfo(view, bVar.f1906a);
        if (!j() && this.f2322d.getLayoutManager() != null) {
            RecyclerView.m layoutManager = this.f2322d.getLayoutManager();
            RecyclerView recyclerView = layoutManager.f298b;
            RecyclerView.s sVar = recyclerView.f280c;
            RecyclerView.x xVar = recyclerView.h0;
            if (recyclerView.canScrollVertically(-1) || layoutManager.f298b.canScrollHorizontally(-1)) {
                bVar.f1906a.addAction(RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
                bVar.f1906a.setScrollable(true);
            }
            if (layoutManager.f298b.canScrollVertically(1) || layoutManager.f298b.canScrollHorizontally(1)) {
                bVar.f1906a.addAction(4096);
                bVar.f1906a.setScrollable(true);
            }
            bVar.i(b.C0036b.a(layoutManager.R(sVar, xVar), layoutManager.A(sVar, xVar), layoutManager.V(), layoutManager.S()));
        }
    }

    @Override // b.i.l.a
    public boolean g(View view, int i, Bundle bundle) {
        if (super.g(view, i, bundle)) {
            return true;
        }
        if (j() || this.f2322d.getLayoutManager() == null) {
            return false;
        }
        RecyclerView.m layoutManager = this.f2322d.getLayoutManager();
        RecyclerView.s sVar = layoutManager.f298b.f280c;
        return layoutManager.A0(i);
    }

    public boolean j() {
        return this.f2322d.N();
    }
}
