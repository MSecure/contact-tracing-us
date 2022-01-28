package c.b.a.b.x;

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
import b.i.l.m;
import b.r.d.u;
import c.b.a.b.h;
import com.google.android.material.button.MaterialButton;
import java.util.List;

public final class g<S> extends x<S> {
    public static final Object m = "MONTHS_VIEW_GROUP_TAG";
    public static final Object n = "NAVIGATION_PREV_TAG";
    public static final Object o = "NAVIGATION_NEXT_TAG";
    public static final Object p = "SELECTOR_TOGGLE_TAG";

    /* renamed from: c  reason: collision with root package name */
    public int f4574c;

    /* renamed from: d  reason: collision with root package name */
    public d<S> f4575d;

    /* renamed from: e  reason: collision with root package name */
    public a f4576e;

    /* renamed from: f  reason: collision with root package name */
    public s f4577f;

    /* renamed from: g  reason: collision with root package name */
    public e f4578g;
    public c h;
    public RecyclerView i;
    public RecyclerView j;
    public View k;
    public View l;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f4579b;

        public a(int i) {
            this.f4579b = i;
        }

        public void run() {
            RecyclerView.m mVar;
            RecyclerView recyclerView = g.this.j;
            int i = this.f4579b;
            if (!recyclerView.y && (mVar = recyclerView.n) != null) {
                mVar.U0(recyclerView, recyclerView.h0, i);
            }
        }
    }

    public class b extends b.i.l.a {
        public b(g gVar) {
        }

        @Override // b.i.l.a
        public void d(View view, b.i.l.w.b bVar) {
            this.f1847a.onInitializeAccessibilityNodeInfo(view, bVar.f1906a);
            bVar.i(null);
        }
    }

    public class c extends y {
        public final /* synthetic */ int H;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Context context, int i, boolean z, int i2) {
            super(context, i, z);
            this.H = i2;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void X0(RecyclerView.x xVar, int[] iArr) {
            if (this.H == 0) {
                iArr[0] = g.this.j.getWidth();
                iArr[1] = g.this.j.getWidth();
                return;
            }
            iArr[0] = g.this.j.getHeight();
            iArr[1] = g.this.j.getHeight();
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

    public static int d(Context context) {
        return context.getResources().getDimensionPixelSize(c.b.a.b.d.mtrl_calendar_day_height);
    }

    public LinearLayoutManager e() {
        return (LinearLayoutManager) this.j.getLayoutManager();
    }

    public final void f(int i2) {
        this.j.post(new a(i2));
    }

    public void g(s sVar) {
        RecyclerView recyclerView;
        int i2;
        v vVar = (v) this.j.getAdapter();
        int D = vVar.f4623a.f4539b.D(sVar);
        int b2 = D - vVar.b(this.f4577f);
        boolean z = true;
        boolean z2 = Math.abs(b2) > 3;
        if (b2 <= 0) {
            z = false;
        }
        this.f4577f = sVar;
        if (!z2 || !z) {
            if (z2) {
                recyclerView = this.j;
                i2 = D + 3;
            }
            f(D);
        }
        recyclerView = this.j;
        i2 = D - 3;
        recyclerView.j0(i2);
        f(D);
    }

    public void h(e eVar) {
        this.f4578g = eVar;
        if (eVar == e.YEAR) {
            this.i.getLayoutManager().K0(((c0) this.i.getAdapter()).a(this.f4577f.f4613e));
            this.k.setVisibility(0);
            this.l.setVisibility(8);
        } else if (eVar == e.DAY) {
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            g(this.f4577f);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f4574c = bundle.getInt("THEME_RES_ID_KEY");
        this.f4575d = (d) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f4576e = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f4577f = (s) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        u uVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f4574c);
        this.h = new c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        s sVar = this.f4576e.f4539b;
        if (o.f(contextThemeWrapper)) {
            i3 = h.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i3 = h.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i3, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(c.b.a.b.f.mtrl_calendar_days_of_week);
        m.U(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new f());
        gridView.setNumColumns(sVar.f4614f);
        gridView.setEnabled(false);
        this.j = (RecyclerView) inflate.findViewById(c.b.a.b.f.mtrl_calendar_months);
        this.j.setLayoutManager(new c(getContext(), i2, false, i2));
        this.j.setTag("MONTHS_VIEW_GROUP_TAG");
        v vVar = new v(contextThemeWrapper, this.f4575d, this.f4576e, new d());
        this.j.setAdapter(vVar);
        int integer = contextThemeWrapper.getResources().getInteger(c.b.a.b.g.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView3 = (RecyclerView) inflate.findViewById(c.b.a.b.f.mtrl_calendar_year_selector_frame);
        this.i = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.i.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.i.setAdapter(new c0(this));
            this.i.g(new h(this));
        }
        if (inflate.findViewById(c.b.a.b.f.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(c.b.a.b.f.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            m.U(materialButton, new i(this));
            MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(c.b.a.b.f.month_navigation_previous);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(c.b.a.b.f.month_navigation_next);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.k = inflate.findViewById(c.b.a.b.f.mtrl_calendar_year_selector_frame);
            this.l = inflate.findViewById(c.b.a.b.f.mtrl_calendar_day_selector_frame);
            h(e.DAY);
            materialButton.setText(this.f4577f.f4611c);
            this.j.h(new j(this, vVar, materialButton));
            materialButton.setOnClickListener(new k(this));
            materialButton3.setOnClickListener(new l(this, vVar));
            materialButton2.setOnClickListener(new m(this, vVar));
        }
        if (!o.f(contextThemeWrapper) && (recyclerView2 = (uVar = new u()).f2337a) != (recyclerView = this.j)) {
            if (recyclerView2 != null) {
                RecyclerView.q qVar = uVar.f2339c;
                List<RecyclerView.q> list = recyclerView2.j0;
                if (list != null) {
                    list.remove(qVar);
                }
                uVar.f2337a.setOnFlingListener(null);
            }
            uVar.f2337a = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() == null) {
                    uVar.f2337a.h(uVar.f2339c);
                    uVar.f2337a.setOnFlingListener(uVar);
                    uVar.f2338b = new Scroller(uVar.f2337a.getContext(), new DecelerateInterpolator());
                    uVar.c();
                } else {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
            }
        }
        this.j.j0(vVar.b(this.f4577f));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f4574c);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f4575d);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f4576e);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f4577f);
    }
}
