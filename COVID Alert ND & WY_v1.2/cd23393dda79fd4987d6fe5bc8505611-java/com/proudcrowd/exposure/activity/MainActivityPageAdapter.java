package com.proudcrowd.exposure.activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.proudcrowd.exposure.core.ExposureApplication;
import com.proudcrowd.exposure.fragment.AffiliateFragment;
import com.proudcrowd.exposure.fragment.CheckFragment;
import com.proudcrowd.exposure.fragment.InfoFragment;
import com.proudcrowd.exposure.fragment.ProtectFragment;
import com.proudcrowd.exposure.misc.TabFragmentConsumer;
import java.lang.ref.WeakReference;

public class MainActivityPageAdapter extends FragmentPagerAdapter {
    public WeakReference<TabFragmentConsumer> mAffiliateFragment;
    private ExposureApplication mAppContext;
    public WeakReference<TabFragmentConsumer> mCheckFragment;
    private FragmentManager mFragmentManager;
    public WeakReference<TabFragmentConsumer> mInfoFragment;
    public WeakReference<TabFragmentConsumer> mProtectFragment;

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 4;
    }

    public MainActivityPageAdapter(FragmentManager fragmentManager, ExposureApplication exposureApplication) {
        super(fragmentManager, 1);
        this.mFragmentManager = fragmentManager;
        this.mAppContext = exposureApplication;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        if (i == 0) {
            WeakReference<TabFragmentConsumer> weakReference = this.mCheckFragment;
            if (weakReference == null || weakReference.get() == null) {
                this.mCheckFragment = new WeakReference<>(CheckFragment.newInstance());
            }
            return (Fragment) this.mCheckFragment.get();
        } else if (i == 1) {
            WeakReference<TabFragmentConsumer> weakReference2 = this.mProtectFragment;
            if (weakReference2 == null || weakReference2.get() == null) {
                this.mProtectFragment = new WeakReference<>(ProtectFragment.newInstance());
            }
            return (Fragment) this.mProtectFragment.get();
        } else if (i == 2) {
            WeakReference<TabFragmentConsumer> weakReference3 = this.mAffiliateFragment;
            if (weakReference3 == null || weakReference3.get() == null) {
                this.mAffiliateFragment = new WeakReference<>(AffiliateFragment.newInstance());
            }
            return (Fragment) this.mAffiliateFragment.get();
        } else if (i != 3) {
            return null;
        } else {
            WeakReference<TabFragmentConsumer> weakReference4 = this.mInfoFragment;
            if (weakReference4 == null || weakReference4.get() == null) {
                this.mInfoFragment = new WeakReference<>(InfoFragment.newInstance());
            }
            return (Fragment) this.mInfoFragment.get();
        }
    }

    public void newFragmentVisible(int i) {
        WeakReference<TabFragmentConsumer> weakReference = this.mProtectFragment;
        if (weakReference != null && weakReference.get() != null) {
            if (i == 1) {
                this.mProtectFragment.get().onSelected();
            } else {
                this.mProtectFragment.get().onNotSelected();
            }
        }
    }
}
