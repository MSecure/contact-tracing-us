package gov.michigan.MiCovidExposure.home;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import b.l.d.e0;
import b.l.d.z;
import gov.michigan.MiCovidExposure.StatsHomeFragment;
import gov.michigan.MiCovidExposure.exposure.ExposureHomeFragment;
import gov.michigan.MiCovidExposure.notify.NotifyHomeFragment;

public class HomeFragmentPagerAdapter extends e0 {
    public Fragment currentFragment;

    public HomeFragmentPagerAdapter(z zVar) {
        super(zVar, 1);
    }

    @Override // b.a0.a.a
    public int getCount() {
        return 5;
    }

    public Fragment getCurrentFragment() {
        return this.currentFragment;
    }

    @Override // b.l.d.e0
    public Fragment getItem(int i) {
        return i != 0 ? i != 2 ? i != 3 ? i != 4 ? new NotifyHomeFragment() : new StatsHomeFragment() : new ShareHomeFragment() : new VirtualAgentHomeFragment() : new ExposureHomeFragment();
    }

    @Override // b.l.d.e0, b.a0.a.a
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.currentFragment = (Fragment) obj;
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
