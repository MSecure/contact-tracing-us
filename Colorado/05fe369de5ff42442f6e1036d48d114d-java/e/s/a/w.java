package e.s.a;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import e.i.i.x.b;
import e.i.i.x.c;
import java.util.Map;
import java.util.WeakHashMap;

public class w extends e.i.i.a {

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f1673d;

    /* renamed from: e  reason: collision with root package name */
    public final a f1674e;

    public static class a extends e.i.i.a {

        /* renamed from: d  reason: collision with root package name */
        public final w f1675d;

        /* renamed from: e  reason: collision with root package name */
        public Map<View, e.i.i.a> f1676e = new WeakHashMap();

        public a(w wVar) {
            this.f1675d = wVar;
        }

        @Override // e.i.i.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            e.i.i.a aVar = this.f1676e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // e.i.i.a
        public c b(View view) {
            e.i.i.a aVar = this.f1676e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // e.i.i.a
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            e.i.i.a aVar = this.f1676e.get(view);
            if (aVar != null) {
                aVar.c(view, accessibilityEvent);
            } else {
                this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // e.i.i.a
        public void d(View view, b bVar) {
            if (!this.f1675d.j() && this.f1675d.f1673d.getLayoutManager() != null) {
                this.f1675d.f1673d.getLayoutManager().m0(view, bVar);
                e.i.i.a aVar = this.f1676e.get(view);
                if (aVar != null) {
                    aVar.d(view, bVar);
                    return;
                }
            }
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        }

        @Override // e.i.i.a
        public void e(View view, AccessibilityEvent accessibilityEvent) {
            e.i.i.a aVar = this.f1676e.get(view);
            if (aVar != null) {
                aVar.e(view, accessibilityEvent);
            } else {
                this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // e.i.i.a
        public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            e.i.i.a aVar = this.f1676e.get(viewGroup);
            return aVar != null ? aVar.f(viewGroup, view, accessibilityEvent) : this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // e.i.i.a
        public boolean g(View view, int i2, Bundle bundle) {
            if (this.f1675d.j() || this.f1675d.f1673d.getLayoutManager() == null) {
                return super.g(view, i2, bundle);
            }
            e.i.i.a aVar = this.f1676e.get(view);
            if (aVar != null) {
                if (aVar.g(view, i2, bundle)) {
                    return true;
                }
            } else if (super.g(view, i2, bundle)) {
                return true;
            }
            RecyclerView.m layoutManager = this.f1675d.f1673d.getLayoutManager();
            RecyclerView.t tVar = layoutManager.b.c;
            return layoutManager.E0();
        }

        @Override // e.i.i.a
        public void h(View view, int i2) {
            e.i.i.a aVar = this.f1676e.get(view);
            if (aVar != null) {
                aVar.h(view, i2);
            } else {
                this.a.sendAccessibilityEvent(view, i2);
            }
        }

        @Override // e.i.i.a
        public void i(View view, AccessibilityEvent accessibilityEvent) {
            e.i.i.a aVar = this.f1676e.get(view);
            if (aVar != null) {
                aVar.i(view, accessibilityEvent);
            } else {
                this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public w(RecyclerView recyclerView) {
        this.f1673d = recyclerView;
        a aVar = this.f1674e;
        this.f1674e = aVar == null ? new a(this) : aVar;
    }

    @Override // e.i.i.a
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !j()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().k0(accessibilityEvent);
            }
        }
    }

    @Override // e.i.i.a
    public void d(View view, b bVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        if (!j() && this.f1673d.getLayoutManager() != null) {
            RecyclerView.m layoutManager = this.f1673d.getLayoutManager();
            RecyclerView recyclerView = layoutManager.b;
            RecyclerView.t tVar = recyclerView.c;
            RecyclerView.y yVar = recyclerView.i0;
            if (recyclerView.canScrollVertically(-1) || layoutManager.b.canScrollHorizontally(-1)) {
                bVar.a.addAction(8192);
                bVar.a.setScrollable(true);
            }
            if (layoutManager.b.canScrollVertically(1) || layoutManager.b.canScrollHorizontally(1)) {
                bVar.a.addAction(4096);
                bVar.a.setScrollable(true);
            }
            bVar.i(b.C0034b.a(layoutManager.U(tVar, yVar), layoutManager.B(tVar, yVar), layoutManager.Y(), layoutManager.V()));
        }
    }

    @Override // e.i.i.a
    public boolean g(View view, int i2, Bundle bundle) {
        if (super.g(view, i2, bundle)) {
            return true;
        }
        if (j() || this.f1673d.getLayoutManager() == null) {
            return false;
        }
        RecyclerView.m layoutManager = this.f1673d.getLayoutManager();
        RecyclerView.t tVar = layoutManager.b.c;
        return layoutManager.D0(i2);
    }

    public boolean j() {
        return this.f1673d.M();
    }
}
