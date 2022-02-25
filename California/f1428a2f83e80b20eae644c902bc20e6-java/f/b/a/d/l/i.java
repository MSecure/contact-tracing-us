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
import e.i.i.l;
import e.s.a.m;

public final class i<S> extends z<S> {
    public static final /* synthetic */ int h0 = 0;
    public int X;
    public f<S> Y;
    public a Z;
    public u a0;
    public e b0;
    public c c0;
    public RecyclerView d0;
    public RecyclerView e0;
    public View f0;
    public View g0;

    public class a implements Runnable {
        public final /* synthetic */ int b;

        public a(int i2) {
            this.b = i2;
        }

        public void run() {
            i.this.e0.l0(this.b);
        }
    }

    public class b extends e.i.i.a {
        public b(i iVar) {
        }

        @Override // e.i.i.a
        public void d(View view, e.i.i.w.b bVar) {
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
        public void a1(RecyclerView.y yVar, int[] iArr) {
            if (this.G == 0) {
                iArr[0] = i.this.e0.getWidth();
                iArr[1] = i.this.e0.getWidth();
                return;
            }
            iArr[0] = i.this.e0.getHeight();
            iArr[1] = i.this.e0.getHeight();
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
        this.e0.post(new a(i2));
    }

    public void B0(u uVar) {
        RecyclerView recyclerView;
        int i2;
        x xVar = (x) this.e0.getAdapter();
        int w = xVar.f2644d.b.w(uVar);
        int q = w - xVar.q(this.a0);
        boolean z = true;
        boolean z2 = Math.abs(q) > 3;
        if (q <= 0) {
            z = false;
        }
        this.a0 = uVar;
        if (!z2 || !z) {
            if (z2) {
                recyclerView = this.e0;
                i2 = w + 3;
            }
            A0(w);
        }
        recyclerView = this.e0;
        i2 = w - 3;
        recyclerView.i0(i2);
        A0(w);
    }

    public void C0(e eVar) {
        this.b0 = eVar;
        if (eVar == e.YEAR) {
            this.d0.getLayoutManager().N0(((f0) this.d0.getAdapter()).p(this.a0.f2635d));
            this.f0.setVisibility(0);
            this.g0.setVisibility(8);
        } else if (eVar == e.DAY) {
            this.f0.setVisibility(8);
            this.g0.setVisibility(0);
            B0(this.a0);
        }
    }

    @Override // e.m.a.l
    public void N(Bundle bundle) {
        super.N(bundle);
        if (bundle == null) {
            bundle = this.f1621g;
        }
        this.X = bundle.getInt("THEME_RES_ID_KEY");
        this.Y = (f) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.Z = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.a0 = (u) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(l(), this.X);
        this.c0 = new c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        u uVar = this.Z.b;
        if (q.D0(contextThemeWrapper)) {
            i3 = R$layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i3 = R$layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i3, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R$id.mtrl_calendar_days_of_week);
        l.r(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new h());
        gridView.setNumColumns(uVar.f2636e);
        gridView.setEnabled(false);
        this.e0 = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_months);
        this.e0.setLayoutManager(new c(l(), i2, false, i2));
        this.e0.setTag("MONTHS_VIEW_GROUP_TAG");
        x xVar = new x(contextThemeWrapper, this.Y, this.Z, new d());
        this.e0.setAdapter(xVar);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        int i4 = R$id.mtrl_calendar_year_selector_frame;
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(i4);
        this.d0 = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.d0.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.d0.setAdapter(new f0(this));
            this.d0.g(new j(this));
        }
        int i5 = R$id.month_navigation_fragment_toggle;
        if (inflate.findViewById(i5) != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(i5);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            l.r(materialButton, new k(this));
            MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R$id.month_navigation_previous);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(R$id.month_navigation_next);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.f0 = inflate.findViewById(i4);
            this.g0 = inflate.findViewById(R$id.mtrl_calendar_day_selector_frame);
            C0(e.DAY);
            materialButton.setText(this.a0.u(inflate.getContext()));
            this.e0.h(new l(this, xVar, materialButton));
            materialButton.setOnClickListener(new m(this));
            materialButton3.setOnClickListener(new n(this, xVar));
            materialButton2.setOnClickListener(new o(this, xVar));
        }
        if (!q.D0(contextThemeWrapper)) {
            new m().a(this.e0);
        }
        this.e0.i0(xVar.q(this.a0));
        return inflate;
    }

    @Override // e.m.a.l
    public void d0(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.X);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.Y);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.Z);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.a0);
    }

    @Override // f.b.a.d.l.z
    public boolean y0(y<S> yVar) {
        return this.W.add(yVar);
    }

    public LinearLayoutManager z0() {
        return (LinearLayoutManager) this.e0.getLayoutManager();
    }
}
