package e.t.a;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import e.i.i.c;
import e.i.i.c0.b;
import java.util.Map;
import java.util.WeakHashMap;

public class w extends c {

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f1948d;

    /* renamed from: e  reason: collision with root package name */
    public final a f1949e;

    public static class a extends c {

        /* renamed from: d  reason: collision with root package name */
        public final w f1950d;

        /* renamed from: e  reason: collision with root package name */
        public Map<View, c> f1951e = new WeakHashMap();

        public a(w wVar) {
            this.f1950d = wVar;
        }

        @Override // e.i.i.c
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            c cVar = this.f1951e.get(view);
            return cVar != null ? cVar.a(view, accessibilityEvent) : this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // e.i.i.c
        public e.i.i.c0.c b(View view) {
            c cVar = this.f1951e.get(view);
            return cVar != null ? cVar.b(view) : super.b(view);
        }

        @Override // e.i.i.c
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            c cVar = this.f1951e.get(view);
            if (cVar != null) {
                cVar.c(view, accessibilityEvent);
            } else {
                this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // e.i.i.c
        public void d(View view, b bVar) {
            if (!this.f1950d.j() && this.f1950d.f1948d.getLayoutManager() != null) {
                this.f1950d.f1948d.getLayoutManager().m0(view, bVar);
                c cVar = this.f1951e.get(view);
                if (cVar != null) {
                    cVar.d(view, bVar);
                    return;
                }
            }
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        }

        @Override // e.i.i.c
        public void e(View view, AccessibilityEvent accessibilityEvent) {
            c cVar = this.f1951e.get(view);
            if (cVar != null) {
                cVar.e(view, accessibilityEvent);
            } else {
                this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // e.i.i.c
        public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            c cVar = this.f1951e.get(viewGroup);
            return cVar != null ? cVar.f(viewGroup, view, accessibilityEvent) : this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // e.i.i.c
        public boolean g(View view, int i2, Bundle bundle) {
            if (this.f1950d.j() || this.f1950d.f1948d.getLayoutManager() == null) {
                return super.g(view, i2, bundle);
            }
            c cVar = this.f1951e.get(view);
            if (cVar != null) {
                if (cVar.g(view, i2, bundle)) {
                    return true;
                }
            } else if (super.g(view, i2, bundle)) {
                return true;
            }
            RecyclerView.m layoutManager = this.f1950d.f1948d.getLayoutManager();
            RecyclerView.t tVar = layoutManager.b.c;
            return layoutManager.E0();
        }

        @Override // e.i.i.c
        public void h(View view, int i2) {
            c cVar = this.f1951e.get(view);
            if (cVar != null) {
                cVar.h(view, i2);
            } else {
                this.a.sendAccessibilityEvent(view, i2);
            }
        }

        @Override // e.i.i.c
        public void i(View view, AccessibilityEvent accessibilityEvent) {
            c cVar = this.f1951e.get(view);
            if (cVar != null) {
                cVar.i(view, accessibilityEvent);
            } else {
                this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public w(RecyclerView recyclerView) {
        this.f1948d = recyclerView;
        a aVar = this.f1949e;
        this.f1949e = aVar == null ? new a(this) : aVar;
    }

    @Override // e.i.i.c
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !j()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().k0(accessibilityEvent);
            }
        }
    }

    @Override // e.i.i.c
    public void d(View view, b bVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        if (!j() && this.f1948d.getLayoutManager() != null) {
            RecyclerView.m layoutManager = this.f1948d.getLayoutManager();
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
            bVar.i(b.C0037b.a(layoutManager.U(tVar, yVar), layoutManager.B(tVar, yVar), layoutManager.Y(), layoutManager.V()));
        }
    }

    @Override // e.i.i.c
    public boolean g(View view, int i2, Bundle bundle) {
        if (super.g(view, i2, bundle)) {
            return true;
        }
        if (j() || this.f1948d.getLayoutManager() == null) {
            return false;
        }
        RecyclerView.m layoutManager = this.f1948d.getLayoutManager();
        RecyclerView.t tVar = layoutManager.b.c;
        return layoutManager.D0(i2);
    }

    public boolean j() {
        return this.f1948d.M();
    }
}
