package f.b.a.a.a.l;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.material.tabs.TabLayout;
import e.m.a.a;
import e.m.a.l;
import e.p.b0;
import f.b.a.a.a.h.n;
import f.b.a.a.a.i.m;
import f.b.a.d.y.e;
import gov.md.covid19.exposurenotifications.R;

public class l0 extends j0 {
    public static final /* synthetic */ int d0 = 0;
    public m a0;
    public ViewPager2 b0;
    public ExposureNotificationViewModel c0;

    public static void z0(l lVar) {
        lVar.t().a0(null, 1);
        a aVar = new a(lVar.t());
        aVar.f(R.id.home_fragment, new l0(), "ExposureNotificationActivity.HOME_FRAGMENT_TAG");
        aVar.f1665f = 4097;
        aVar.c();
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
        int i2 = R.id.tab_layout;
        TabLayout tabLayout = (TabLayout) inflate.findViewById(R.id.tab_layout);
        if (tabLayout != null) {
            i2 = R.id.view_pager;
            ViewPager2 viewPager2 = (ViewPager2) inflate.findViewById(R.id.view_pager);
            if (viewPager2 != null) {
                LinearLayout linearLayout = (LinearLayout) inflate;
                this.a0 = new m(linearLayout, tabLayout, viewPager2);
                return linearLayout;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.l
    public void R() {
        this.D = true;
        this.a0 = null;
    }

    @Override // e.m.a.l
    public void d0(Bundle bundle) {
        bundle.putInt("HomeFragment.SAVED_INSTANCE_STATE_CURRENT_ITEM", this.b0.getCurrentItem());
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        g().setTitle(R.string.app_name);
        m0 m0Var = new m0(this);
        this.c0 = (ExposureNotificationViewModel) new b0(m0()).a(ExposureNotificationViewModel.class);
        ViewPager2 viewPager2 = this.a0.c;
        this.b0 = viewPager2;
        int i2 = 0;
        viewPager2.setUserInputEnabled(false);
        this.b0.setOffscreenPageLimit(2);
        this.b0.setAdapter(m0Var);
        this.b0.setPageTransformer(y.a);
        if (bundle != null) {
            ViewPager2 viewPager22 = this.b0;
            Bundle bundle2 = this.f1632g;
            if (bundle2 != null) {
                i2 = bundle2.getInt("KEY_START_TAB", 0);
            }
            viewPager22.setCurrentItem(bundle.getInt("HomeFragment.SAVED_INSTANCE_STATE_CURRENT_ITEM", i2));
        } else {
            ViewPager2 viewPager23 = this.b0;
            Bundle bundle3 = this.f1632g;
            if (bundle3 != null) {
                i2 = bundle3.getInt("KEY_START_TAB", 0);
            }
            viewPager23.setCurrentItem(i2);
        }
        TabLayout tabLayout = this.a0.b;
        ViewPager2 viewPager24 = this.b0;
        e eVar = new e(tabLayout, viewPager24, z.a);
        if (!eVar.f2924d) {
            RecyclerView.e<?> adapter = viewPager24.getAdapter();
            eVar.c = adapter;
            if (adapter != null) {
                eVar.f2924d = true;
                e.c cVar = new e.c(eVar.a);
                eVar.f2925e = cVar;
                eVar.b.f298d.a.add(cVar);
                e.d dVar = new e.d(eVar.b, true);
                eVar.f2926f = dVar;
                TabLayout tabLayout2 = eVar.a;
                if (!tabLayout2.H.contains(dVar)) {
                    tabLayout2.H.add(dVar);
                }
                e.a aVar = new e.a();
                eVar.f2927g = aVar;
                eVar.c.a.registerObserver(aVar);
                eVar.a();
                eVar.a.l(eVar.b.getCurrentItem(), 0.0f, true, true);
                TabLayout tabLayout3 = this.a0.b;
                n nVar = new n(n0(), view);
                if (!tabLayout3.H.contains(nVar)) {
                    tabLayout3.H.add(nVar);
                }
                this.c0.f345i.f(B(), new x(this));
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }
}
