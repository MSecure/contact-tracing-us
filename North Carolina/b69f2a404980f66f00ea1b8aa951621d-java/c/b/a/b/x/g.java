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
import b.q.d.u;
import c.b.a.b.h;
import com.google.android.material.button.MaterialButton;

public final class g<S> extends x<S> {
    public static final Object m = "MONTHS_VIEW_GROUP_TAG";
    public static final Object n = "NAVIGATION_PREV_TAG";
    public static final Object o = "NAVIGATION_NEXT_TAG";
    public static final Object p = "SELECTOR_TOGGLE_TAG";

    /* renamed from: c  reason: collision with root package name */
    public int f3247c;

    /* renamed from: d  reason: collision with root package name */
    public d<S> f3248d;

    /* renamed from: e  reason: collision with root package name */
    public a f3249e;
    public s f;
    public e g;
    public c h;
    public RecyclerView i;
    public RecyclerView j;
    public View k;
    public View l;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3250b;

        public a(int i) {
            this.f3250b = i;
        }

        public void run() {
            g.this.j.smoothScrollToPosition(this.f3250b);
        }
    }

    public class b extends b.i.l.a {
        public b(g gVar) {
        }

        @Override // b.i.l.a
        public void d(View view, b.i.l.w.b bVar) {
            this.f1139a.onInitializeAccessibilityNodeInfo(view, bVar.f1195a);
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
        public void X0(RecyclerView.a0 a0Var, int[] iArr) {
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
        int w = vVar.f3289a.f3218b.w(sVar);
        int b2 = w - vVar.b(this.f);
        boolean z = true;
        boolean z2 = Math.abs(b2) > 3;
        if (b2 <= 0) {
            z = false;
        }
        this.f = sVar;
        if (!z2 || !z) {
            if (z2) {
                recyclerView = this.j;
                i2 = w + 3;
            }
            f(w);
        }
        recyclerView = this.j;
        i2 = w - 3;
        recyclerView.scrollToPosition(i2);
        f(w);
    }

    public void h(e eVar) {
        this.g = eVar;
        if (eVar == e.YEAR) {
            this.i.getLayoutManager().K0(((c0) this.i.getAdapter()).a(this.f.f3282e));
            this.k.setVisibility(0);
            this.l.setVisibility(8);
        } else if (eVar == e.DAY) {
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            g(this.f);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f3247c = bundle.getInt("THEME_RES_ID_KEY");
        this.f3248d = (d) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f3249e = (a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f = (s) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        u uVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f3247c);
        this.h = new c(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        s sVar = this.f3249e.f3218b;
        if (o.f(contextThemeWrapper)) {
            i3 = h.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i3 = h.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i3, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(c.b.a.b.f.mtrl_calendar_days_of_week);
        m.T(gridView, new b(this));
        gridView.setAdapter((ListAdapter) new f());
        gridView.setNumColumns(sVar.f);
        gridView.setEnabled(false);
        this.j = (RecyclerView) inflate.findViewById(c.b.a.b.f.mtrl_calendar_months);
        this.j.setLayoutManager(new c(getContext(), i2, false, i2));
        this.j.setTag("MONTHS_VIEW_GROUP_TAG");
        v vVar = new v(contextThemeWrapper, this.f3248d, this.f3249e, new d());
        this.j.setAdapter(vVar);
        int integer = contextThemeWrapper.getResources().getInteger(c.b.a.b.g.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView3 = (RecyclerView) inflate.findViewById(c.b.a.b.f.mtrl_calendar_year_selector_frame);
        this.i = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.i.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.i.setAdapter(new c0(this));
            this.i.addItemDecoration(new h(this));
        }
        if (inflate.findViewById(c.b.a.b.f.month_navigation_fragment_toggle) != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(c.b.a.b.f.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            m.T(materialButton, new i(this));
            MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(c.b.a.b.f.month_navigation_previous);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(c.b.a.b.f.month_navigation_next);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.k = inflate.findViewById(c.b.a.b.f.mtrl_calendar_year_selector_frame);
            this.l = inflate.findViewById(c.b.a.b.f.mtrl_calendar_day_selector_frame);
            h(e.DAY);
            materialButton.setText(this.f.f3280c);
            this.j.addOnScrollListener(new j(this, vVar, materialButton));
            materialButton.setOnClickListener(new k(this));
            materialButton3.setOnClickListener(new l(this, vVar));
            materialButton2.setOnClickListener(new m(this, vVar));
        }
        if (!o.f(contextThemeWrapper) && (recyclerView2 = (uVar = new u()).f1481a) != (recyclerView = this.j)) {
            if (recyclerView2 != null) {
                recyclerView2.removeOnScrollListener(uVar.f1483c);
                uVar.f1481a.setOnFlingListener(null);
            }
            uVar.f1481a = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() == null) {
                    uVar.f1481a.addOnScrollListener(uVar.f1483c);
                    uVar.f1481a.setOnFlingListener(uVar);
                    uVar.f1482b = new Scroller(uVar.f1481a.getContext(), new DecelerateInterpolator());
                    uVar.c();
                } else {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
            }
        }
        this.j.scrollToPosition(vVar.b(this.f));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f3247c);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f3248d);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f3249e);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f);
    }
}
