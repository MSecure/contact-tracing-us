package f.b.a.a.a.j;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.material.tabs.TabLayout;
import e.m.a.a;
import e.m.a.l;
import e.p.b0;
import f.b.a.a.a.h.n;
import f.b.a.d.y.c;
import gov.ca.covid19.exposurenotifications.R;

public class e0 extends c0 {
    public static final /* synthetic */ int b0 = 0;
    public ViewPager2 Z;
    public ExposureNotificationViewModel a0;

    public static void z0(l lVar) {
        lVar.t().a0(null, 1);
        a aVar = new a(lVar.t());
        aVar.f(R.id.home_fragment, new e0(), "ExposureNotificationActivity.HOME_FRAGMENT_TAG");
        aVar.f1638f = 4097;
        aVar.c();
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
    }

    @Override // e.m.a.l
    public void d0(Bundle bundle) {
        bundle.putInt("HomeFragment.SAVED_INSTANCE_STATE_CURRENT_ITEM", this.Z.getCurrentItem());
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        g().setTitle(R.string.app_name);
        f0 f0Var = new f0(this);
        this.a0 = (ExposureNotificationViewModel) new b0(m0()).a(ExposureNotificationViewModel.class);
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.view_pager);
        this.Z = viewPager2;
        int i2 = 0;
        viewPager2.setUserInputEnabled(false);
        this.Z.setOffscreenPageLimit(2);
        this.Z.setAdapter(f0Var);
        this.Z.setPageTransformer(r.a);
        if (bundle != null) {
            ViewPager2 viewPager22 = this.Z;
            Bundle bundle2 = this.f1621g;
            if (bundle2 != null) {
                i2 = bundle2.getInt("KEY_START_TAB", 0);
            }
            viewPager22.setCurrentItem(bundle.getInt("HomeFragment.SAVED_INSTANCE_STATE_CURRENT_ITEM", i2));
        } else {
            ViewPager2 viewPager23 = this.Z;
            Bundle bundle3 = this.f1621g;
            if (bundle3 != null) {
                i2 = bundle3.getInt("KEY_START_TAB", 0);
            }
            viewPager23.setCurrentItem(i2);
        }
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        ViewPager2 viewPager24 = this.Z;
        c cVar = new c(tabLayout, viewPager24, s.a);
        if (!cVar.f2820d) {
            RecyclerView.e<?> adapter = viewPager24.getAdapter();
            cVar.c = adapter;
            if (adapter != null) {
                cVar.f2820d = true;
                c.C0096c cVar2 = new c.C0096c(cVar.a);
                cVar.f2821e = cVar2;
                cVar.b.f290d.a.add(cVar2);
                c.d dVar = new c.d(cVar.b, true);
                cVar.f2822f = dVar;
                TabLayout tabLayout2 = cVar.a;
                if (!tabLayout2.F.contains(dVar)) {
                    tabLayout2.F.add(dVar);
                }
                c.a aVar = new c.a();
                cVar.f2823g = aVar;
                cVar.c.a.registerObserver(aVar);
                cVar.a();
                cVar.a.l(cVar.b.getCurrentItem(), 0.0f, true, true);
                n nVar = new n(n0(), view);
                if (!tabLayout.F.contains(nVar)) {
                    tabLayout.F.add(nVar);
                }
                this.a0.f335h.f(B(), new q(this));
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }
}
