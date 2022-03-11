package f.b.a.e.l;

import android.content.Context;
import android.content.res.Resources;
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
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButton;
import e.j.j.v;
import e.u.a.t;
import java.util.List;
/* loaded from: classes.dex */
public final class i<S> extends z<S> {
    public static final /* synthetic */ int h0;
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

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ int b;

        public a(int i2) {
            i.this = r1;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView.m mVar;
            RecyclerView recyclerView = i.this.e0;
            int i2 = this.b;
            if (!recyclerView.y && (mVar = recyclerView.n) != null) {
                mVar.X0(recyclerView, recyclerView.i0, i2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends e.j.j.c {
        public b(i iVar) {
        }

        @Override // e.j.j.c
        public void d(View view, e.j.j.c0.b bVar) {
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
            bVar.i(null);
        }
    }

    /* loaded from: classes.dex */
    public class c extends b0 {
        public final /* synthetic */ int G;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, int i2, boolean z, int i3) {
            super(context, i2, z);
            i.this = r1;
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

    /* loaded from: classes.dex */
    public class d implements f {
        public d() {
            i.this = r1;
        }
    }

    /* loaded from: classes.dex */
    public enum e {
        DAY,
        YEAR
    }

    /* loaded from: classes.dex */
    public interface f {
    }

    @Override // f.b.a.e.l.z
    public boolean H0(y<S> yVar) {
        return this.W.add(yVar);
    }

    public LinearLayoutManager I0() {
        return (LinearLayoutManager) this.e0.getLayoutManager();
    }

    public final void J0(int i2) {
        this.e0.post(new a(i2));
    }

    public void K0(u uVar) {
        RecyclerView recyclerView;
        int i2;
        x xVar = (x) this.e0.getAdapter();
        int w = xVar.f2955d.b.w(uVar);
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
            J0(w);
        }
        recyclerView = this.e0;
        i2 = w - 3;
        recyclerView.j0(i2);
        J0(w);
    }

    public void L0(e eVar) {
        this.b0 = eVar;
        if (eVar == e.YEAR) {
            this.d0.getLayoutManager().N0(((f0) this.d0.getAdapter()).m(this.a0.f2946d));
            this.f0.setVisibility(0);
            this.g0.setVisibility(8);
        } else if (eVar == e.DAY) {
            this.f0.setVisibility(8);
            this.g0.setVisibility(0);
            K0(this.a0);
        }
    }

    @Override // e.o.a.m
    public void S(Bundle bundle) {
        super.S(bundle);
        if (bundle == null) {
            bundle = this.f1812g;
        }
        this.X = bundle.getInt("THEME_RES_ID_KEY");
        this.Y = (f) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.Z = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.a0 = (u) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x017a, code lost:
        r13 = new e.u.a.t();
     */
    @Override // e.o.a.m
    /* Code decompiled incorrectly, please refer to instructions dump */
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        t tVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(k(), this.X);
        this.c0 = new c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        u uVar = this.Z.b;
        if (q.N0(contextThemeWrapper)) {
            i3 = R$layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i3 = R$layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i3, viewGroup, false);
        Resources resources = v0().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R$dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_days_of_week_height);
        int i4 = v.f2951g;
        inflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_vertical_padding) * (i4 - 1)) + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) * i4) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) inflate.findViewById(R$id.mtrl_calendar_days_of_week);
        v.u(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new h());
        gridView.setNumColumns(uVar.f2947e);
        gridView.setEnabled(false);
        this.e0 = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_months);
        this.e0.setLayoutManager(new c(k(), i2, false, i2));
        this.e0.setTag("MONTHS_VIEW_GROUP_TAG");
        x xVar = new x(contextThemeWrapper, this.Y, this.Z, new d());
        this.e0.setAdapter(xVar);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        int i5 = R$id.mtrl_calendar_year_selector_frame;
        RecyclerView recyclerView3 = (RecyclerView) inflate.findViewById(i5);
        this.d0 = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.d0.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.d0.setAdapter(new f0(this));
            this.d0.g(new j(this));
        }
        int i6 = R$id.month_navigation_fragment_toggle;
        if (inflate.findViewById(i6) != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(i6);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            v.u(materialButton, new k(this));
            MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R$id.month_navigation_previous);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(R$id.month_navigation_next);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.f0 = inflate.findViewById(i5);
            this.g0 = inflate.findViewById(R$id.mtrl_calendar_day_selector_frame);
            L0(e.DAY);
            materialButton.setText(this.a0.u(inflate.getContext()));
            this.e0.h(new l(this, xVar, materialButton));
            materialButton.setOnClickListener(new m(this));
            materialButton3.setOnClickListener(new n(this, xVar));
            materialButton2.setOnClickListener(new o(this, xVar));
        }
        if (!q.N0(contextThemeWrapper) && (recyclerView2 = tVar.a) != (recyclerView = this.e0)) {
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

    @Override // e.o.a.m
    public void j0(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.X);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.Y);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.Z);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.a0);
    }
}
