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
    public final RecyclerView f1857d;

    /* renamed from: e  reason: collision with root package name */
    public final a f1858e;

    public static class a extends e.i.i.a {

        /* renamed from: d  reason: collision with root package name */
        public final w f1859d;

        /* renamed from: e  reason: collision with root package name */
        public Map<View, e.i.i.a> f1860e = new WeakHashMap();

        public a(w wVar) {
            this.f1859d = wVar;
        }

        @Override // e.i.i.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            e.i.i.a aVar = this.f1860e.get(view);
            return aVar != null ? aVar.a(view, accessibilityEvent) : this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // e.i.i.a
        public c b(View view) {
            e.i.i.a aVar = this.f1860e.get(view);
            return aVar != null ? aVar.b(view) : super.b(view);
        }

        @Override // e.i.i.a
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            e.i.i.a aVar = this.f1860e.get(view);
            if (aVar != null) {
                aVar.c(view, accessibilityEvent);
            } else {
                this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // e.i.i.a
        public void d(View view, b bVar) {
            if (!this.f1859d.j() && this.f1859d.f1857d.getLayoutManager() != null) {
                this.f1859d.f1857d.getLayoutManager().n0(view, bVar);
                e.i.i.a aVar = this.f1860e.get(view);
                if (aVar != null) {
                    aVar.d(view, bVar);
                    return;
                }
            }
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        }

        @Override // e.i.i.a
        public void e(View view, AccessibilityEvent accessibilityEvent) {
            e.i.i.a aVar = this.f1860e.get(view);
            if (aVar != null) {
                aVar.e(view, accessibilityEvent);
            } else {
                this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // e.i.i.a
        public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            e.i.i.a aVar = this.f1860e.get(viewGroup);
            return aVar != null ? aVar.f(viewGroup, view, accessibilityEvent) : this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // e.i.i.a
        public boolean g(View view, int i2, Bundle bundle) {
            if (this.f1859d.j() || this.f1859d.f1857d.getLayoutManager() == null) {
                return super.g(view, i2, bundle);
            }
            e.i.i.a aVar = this.f1860e.get(view);
            if (aVar != null) {
                if (aVar.g(view, i2, bundle)) {
                    return true;
                }
            } else if (super.g(view, i2, bundle)) {
                return true;
            }
            RecyclerView.m layoutManager = this.f1859d.f1857d.getLayoutManager();
            RecyclerView.t tVar = layoutManager.b.c;
            return layoutManager.F0();
        }

        @Override // e.i.i.a
        public void h(View view, int i2) {
            e.i.i.a aVar = this.f1860e.get(view);
            if (aVar != null) {
                aVar.h(view, i2);
            } else {
                this.a.sendAccessibilityEvent(view, i2);
            }
        }

        @Override // e.i.i.a
        public void i(View view, AccessibilityEvent accessibilityEvent) {
            e.i.i.a aVar = this.f1860e.get(view);
            if (aVar != null) {
                aVar.i(view, accessibilityEvent);
            } else {
                this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public w(RecyclerView recyclerView) {
        this.f1857d = recyclerView;
        a aVar = this.f1858e;
        this.f1858e = aVar == null ? new a(this) : aVar;
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
        if (!j() && this.f1857d.getLayoutManager() != null) {
            RecyclerView.m layoutManager = this.f1857d.getLayoutManager();
            RecyclerView recyclerView = layoutManager.b;
            layoutManager.m0(recyclerView.c, recyclerView.i0, bVar);
        }
    }

    @Override // e.i.i.a
    public boolean g(View view, int i2, Bundle bundle) {
        if (super.g(view, i2, bundle)) {
            return true;
        }
        if (j() || this.f1857d.getLayoutManager() == null) {
            return false;
        }
        RecyclerView.m layoutManager = this.f1857d.getLayoutManager();
        RecyclerView recyclerView = layoutManager.b;
        return layoutManager.E0(recyclerView.c, recyclerView.i0, i2, bundle);
    }

    public boolean j() {
        return this.f1857d.M();
    }
}
