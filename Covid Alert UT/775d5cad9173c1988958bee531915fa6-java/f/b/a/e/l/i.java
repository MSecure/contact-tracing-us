package f.b.a.e.l;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButton;
import e.i.i.v;
import e.t.a.t;
import java.util.List;

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
            RecyclerView.m mVar;
            RecyclerView recyclerView = i.this.e0;
            int i2 = this.b;
            if (!recyclerView.y && (mVar = recyclerView.n) != null) {
                mVar.X0(recyclerView, recyclerView.i0, i2);
            }
        }
    }

    public class b extends e.i.i.c {
        public b(i iVar) {
        }

        @Override // e.i.i.c
        public void d(View view, e.i.i.c0.b bVar) {
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

    @Override // f.b.a.e.l.z
    public boolean F0(y<S> yVar) {
        return this.W.add(yVar);
    }

    public LinearLayoutManager G0() {
        return (LinearLayoutManager) this.e0.getLayoutManager();
    }

    public final void H0(int i2) {
        this.e0.post(new a(i2));
    }

    public void I0(u uVar) {
        RecyclerView recyclerView;
        int i2;
        x xVar = (x) this.e0.getAdapter();
        int w = xVar.f2913d.b.w(uVar);
        int n = w - xVar.n(this.a0);
        boolean z = true;
        boolean z2 = Math.abs(n) > 3;
        if (n <= 0) {
            z = false;
        }
        this.a0 = uVar;
        if (!z2 || !z) {
            if (z2) {
                recyclerView = this.e0;
                i2 = w + 3;
            }
            H0(w);
        }
        recyclerView = this.e0;
        i2 = w - 3;
        recyclerView.j0(i2);
        H0(w);
    }

    public void J0(e eVar) {
        this.b0 = eVar;
        if (eVar == e.YEAR) {
            this.d0.getLayoutManager().N0(((f0) this.d0.getAdapter()).m(this.a0.f2904d));
            this.f0.setVisibility(0);
            this.g0.setVisibility(8);
        } else if (eVar == e.DAY) {
            this.f0.setVisibility(8);
            this.g0.setVisibility(0);
            I0(this.a0);
        }
    }

    @Override // e.n.a.m
    public void Q(Bundle bundle) {
        super.Q(bundle);
        if (bundle == null) {
            bundle = this.f1727g;
        }
        this.X = bundle.getInt("THEME_RES_ID_KEY");
        this.Y = (f) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.Z = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.a0 = (u) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0137, code lost:
        r13 = new e.t.a.t();
     */
    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        t tVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(j(), this.X);
        this.c0 = new c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        u uVar = this.Z.b;
        if (q.L0(contextThemeWrapper)) {
            i3 = R$layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i3 = R$layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i3, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R$id.mtrl_calendar_days_of_week);
        v.u(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new h());
        gridView.setNumColumns(uVar.f2905e);
        gridView.setEnabled(false);
        this.e0 = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_months);
        this.e0.setLayoutManager(new c(j(), i2, false, i2));
        this.e0.setTag("MONTHS_VIEW_GROUP_TAG");
        x xVar = new x(contextThemeWrapper, this.Y, this.Z, new d());
        this.e0.setAdapter(xVar);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        int i4 = R$id.mtrl_calendar_year_selector_frame;
        RecyclerView recyclerView3 = (RecyclerView) inflate.findViewById(i4);
        this.d0 = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.d0.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.d0.setAdapter(new f0(this));
            this.d0.g(new j(this));
        }
        int i5 = R$id.month_navigation_fragment_toggle;
        if (inflate.findViewById(i5) != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(i5);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            v.u(materialButton, new k(this));
            MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R$id.month_navigation_previous);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(R$id.month_navigation_next);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.f0 = inflate.findViewById(i4);
            this.g0 = inflate.findViewById(R$id.mtrl_calendar_day_selector_frame);
            J0(e.DAY);
            materialButton.setText(this.a0.u(inflate.getContext()));
            this.e0.h(new l(this, xVar, materialButton));
            materialButton.setOnClickListener(new m(this));
            materialButton3.setOnClickListener(new n(this, xVar));
            materialButton2.setOnClickListener(new o(this, xVar));
        }
        if (!q.L0(contextThemeWrapper) && (recyclerView2 = tVar.a) != (recyclerView = this.e0)) {
            if (recyclerView2 != null) {
                RecyclerView.r rVar = tVar.b;
                List<RecyclerView.r> list = recyclerView2.k0;
                if (list != null) {
                    list.remove(rVar);
                }
                tVar.a.setOnFlingListener(null);
            }
            tVar.a = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() == null) {
                    tVar.a.h(tVar.b);
                    tVar.a.setOnFlingListener(tVar);
                    new Scroller(tVar.a.getContext(), new DecelerateInterpolator());
                    tVar.b();
                } else {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
            }
        }
        this.e0.j0(xVar.n(this.a0));
        return inflate;
    }

    @Override // e.n.a.m
    public void h0(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.X);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.Y);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.Z);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.a0);
    }
}
