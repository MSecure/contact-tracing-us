package gov.nc.dhhs.exposurenotification.home;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import b.l.d.q;
import b.l.d.x;
import gov.nc.dhhs.exposurenotification.exposure.ExposureHomeFragment;
import gov.nc.dhhs.exposurenotification.notify.NotifyHomeFragment;

public class HomeFragmentPagerAdapter extends x {
    public Fragment currentFragment;

    public HomeFragmentPagerAdapter(q qVar) {
        super(qVar, 1);
    }

    @Override // b.y.a.a
    public int getCount() {
        return 5;
    }

    public Fragment getCurrentFragment() {
        return this.currentFragment;
    }

    @Override // b.l.d.x
    public Fragment getItem(int i) {
        return i != 0 ? i != 2 ? i != 3 ? i != 4 ? new NotifyHomeFragment() : new StatsHomeFragment() : new ShareHomeFragment() : new VirtualAgentHomeFragment() : new ExposureHomeFragment();
    }

    @Override // b.y.a.a, b.l.d.x
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.currentFragment = (Fragment) obj;
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
