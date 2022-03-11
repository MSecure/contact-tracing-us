package f.b.a.d.l;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButton;
import e.i.i.m;
import e.s.a.t;

public final class i<S> extends z<S> {
    public static final /* synthetic */ int i0 = 0;
    public int Y;
    public f<S> Z;
    public a a0;
    public u b0;
    public e c0;
    public c d0;
    public RecyclerView e0;
    public RecyclerView f0;
    public View g0;
    public View h0;

    public class a implements Runnable {
        public final /* synthetic */ int b;

        public a(int i2) {
            this.b = i2;
        }

        public void run() {
            i.this.f0.m0(this.b);
        }
    }

    public class b extends e.i.i.a {
        public b(i iVar) {
        }

        @Override // e.i.i.a
        public void d(View view, e.i.i.x.b bVar) {
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
            bVar.i(null);
        }
    }

    public class c extends b0 {
        public final /* synthetic */ int G;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Context context, int i2, boolean z, int i3) {
            super(context, i2, z);
            this.G = i3;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void b1(RecyclerView.y yVar, int[] iArr) {
            if (this.G == 0) {
                iArr[0] = i.this.f0.getWidth();
                iArr[1] = i.this.f0.getWidth();
                return;
            }
            iArr[0] = i.this.f0.getHeight();
            iArr[1] = i.this.f0.getHeight();
        }
    }

    public class d implements f {
        public d() {
        }
    }

    public enum e {
        DAY,
        YEAR
    }

    public interface f {
    }

    public final void A0(int i2) {
        this.f0.post(new a(i2));
    }

    public void B0(u uVar) {
        RecyclerView recyclerView;
        int i2;
        x xVar = (x) this.f0.getAdapter();
        int w = xVar.f2752d.b.w(uVar);
        int q = w - xVar.q(this.b0);
        boolean z = true;
        boolean z2 = Math.abs(q) > 3;
        if (q <= 0) {
            z = false;
        }
        this.b0 = uVar;
        if (!z2 || !z) {
            if (z2) {
                recyclerView = this.f0;
                i2 = w + 3;
            }
            A0(w);
        }
        recyclerView = this.f0;
        i2 = w - 3;
        recyclerView.j0(i2);
        A0(w);
    }

    public void C0(e eVar) {
        this.c0 = eVar;
        if (eVar == e.YEAR) {
            this.e0.getLayoutManager().O0(((f0) this.e0.getAdapter()).p(this.b0.f2743d));
            this.g0.setVisibility(0);
            this.h0.setVisibility(8);
        } else if (eVar == e.DAY) {
            this.g0.setVisibility(8);
            this.h0.setVisibility(0);
            B0(this.b0);
        }
    }

    @Override // e.m.a.l
    public void N(Bundle bundle) {
        super.N(bundle);
        if (bundle == null) {
            bundle = this.f1632g;
        }
        this.Y = bundle.getInt("THEME_RES_ID_KEY");
        this.Z = (f) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.a0 = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.b0 = (u) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(k(), this.Y);
        this.d0 = new c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        u uVar = this.a0.b;
        if (q.D0(contextThemeWrapper)) {
            i3 = R$layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i3 = R$layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i3, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R$id.mtrl_calendar_days_of_week);
        m.r(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new h());
        gridView.setNumColumns(uVar.f2744e);
        gridView.setEnabled(false);
        this.f0 = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_months);
        this.f0.setLayoutManager(new c(k(), i2, false, i2));
        this.f0.setTag("MONTHS_VIEW_GROUP_TAG");
        x xVar = new x(contextThemeWrapper, this.Z, this.a0, new d());
        this.f0.setAdapter(xVar);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        int i4 = R$id.mtrl_calendar_year_selector_frame;
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(i4);
        this.e0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.e0.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.e0.setAdapter(new f0(this));
            this.e0.g(new j(this));
        }
        int i5 = R$id.month_navigation_fragment_toggle;
        if (inflate.findViewById(i5) != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(i5);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            m.r(materialButton, new k(this));
            MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R$id.month_navigation_previous);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(R$id.month_navigation_next);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.g0 = inflate.findViewById(i4);
            this.h0 = inflate.findViewById(R$id.mtrl_calendar_day_selector_frame);
            C0(e.DAY);
            materialButton.setText(this.b0.u(inflate.getContext()));
            this.f0.h(new l(this, xVar, materialButton));
            materialButton.setOnClickListener(new m(this));
            materialButton3.setOnClickListener(new n(this, xVar));
            materialButton2.setOnClickListener(new o(this, xVar));
        }
        if (!q.D0(contextThemeWrapper)) {
            new t().a(this.f0);
        }
        this.f0.j0(xVar.q(this.b0));
        return inflate;
    }

    @Override // e.m.a.l
    public void d0(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.Y);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.Z);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.a0);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.b0);
    }

    @Override // f.b.a.d.l.z
    public boolean y0(y<S> yVar) {
        return this.X.add(yVar);
    }

    public LinearLayoutManager z0() {
        return (LinearLayoutManager) this.f0.getLayoutManager();
    }
}
