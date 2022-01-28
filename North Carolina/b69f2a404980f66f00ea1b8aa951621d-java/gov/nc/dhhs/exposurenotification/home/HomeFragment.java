package gov.nc.dhhs.exposurenotification.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import b.l.d.a;
import b.l.d.q;
import com.google.android.material.tabs.TabLayout;
import gov.nc.dhhs.exposurenotification.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class HomeFragment extends Fragment {
    public static final String KEY_START_TAB = "KEY_START_TAB";
    public static final int TAB_DEFAULT = 0;
    public static final int TAB_EXPOSURES = 0;
    public static final int TAB_NOTIFY = 1;
    public static final int TAB_SHARE = 3;
    public static final int TAB_STATS = 4;
    public static final int TAB_VIRTUAL_AGENT = 2;
    public HomeFragmentPagerAdapter fragmentPagerAdapter;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TabName {
    }

    private int getStartTab() {
        if (getArguments() != null) {
            return getArguments().getInt(KEY_START_TAB, 0);
        }
        return 0;
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    public static HomeFragment newInstance(int i) {
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_START_TAB, i);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    public static void transitionToHomeFragment(Fragment fragment) {
        fragment.getParentFragmentManager().a0(null, 1);
        q parentFragmentManager = fragment.getParentFragmentManager();
        if (parentFragmentManager != null) {
            a aVar = new a(parentFragmentManager);
            aVar.i(R.id.home_fragment, newInstance(), ExposureNotificationActivity.HOME_FRAGMENT_TAG);
            aVar.f = 4097;
            aVar.d();
            return;
        }
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.fragmentPagerAdapter.getCurrentFragment().onActivityResult(i, i2, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.fragmentPagerAdapter = new HomeFragmentPagerAdapter(getParentFragmentManager());
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(this.fragmentPagerAdapter);
        viewPager.setCurrentItem(getStartTab());
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.g(0).b(R.drawable.ic_exclamation_circle);
        tabLayout.g(0).d(R.string.home_tab_exposures_text);
        tabLayout.g(0).a(R.string.exposures_desc);
        tabLayout.g(1).b(R.drawable.ic_flag);
        tabLayout.g(1).d(R.string.home_tab_notify_text);
        tabLayout.g(1).a(R.string.notify_others_desc);
        tabLayout.g(4).b(R.drawable.stats);
        tabLayout.g(4).d(R.string.home_tab_stats);
        tabLayout.g(4).a(R.string.stats_desc);
        tabLayout.g(3).b(R.drawable.ic_baseline_share_24);
        tabLayout.g(3).d(R.string.share);
        tabLayout.g(3).a(R.string.share_desc);
        tabLayout.g(2).b(R.drawable.info);
        tabLayout.g(2).d(R.string.home_tab_virtual_agent);
        tabLayout.g(2).a(R.string.more_information_desc);
    }
}
