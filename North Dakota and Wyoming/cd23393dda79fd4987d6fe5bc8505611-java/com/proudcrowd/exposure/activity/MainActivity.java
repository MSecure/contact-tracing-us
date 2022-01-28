package com.proudcrowd.exposure.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import com.bugfender.sdk.Bugfender;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.core.ExposureApplication;
import com.proudcrowd.exposure.datasource.DeviceUpdateDataSource;
import com.proudcrowd.exposure.fragment.AffiliateFragment;
import com.proudcrowd.exposure.fragment.ProtectFragment;
import com.proudcrowd.exposure.viewmodel.ExposureViewModel;

public class MainActivity extends AppCompatActivity {
    ExposureApplication mAppContext;
    MainActivityPageAdapter mPageAdapter;
    TabHost mTabHost;
    ViewPager mViewPager;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.mAppContext = (ExposureApplication) getApplication();
        this.mViewPager = (ViewPager) findViewById(R.id.pager);
        MainActivityPageAdapter mainActivityPageAdapter = new MainActivityPageAdapter(getSupportFragmentManager(), this.mAppContext);
        this.mPageAdapter = mainActivityPageAdapter;
        this.mViewPager.setAdapter(mainActivityPageAdapter);
        refreshMessagingToken();
        loadTabs();
        setupTabHost(0);
        ExposureViewModel.schedulePeriodicJobs(this.mAppContext);
    }

    private void refreshMessagingToken() {
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            /* class com.proudcrowd.exposure.activity.MainActivity.AnonymousClass1 */

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<InstanceIdResult> task) {
                if (!task.isSuccessful()) {
                    Bugfender.d("getInstanceId failed", task.getException().getMessage());
                    return;
                }
                MainActivity.this.mAppContext.getPreferences().setMessagingToken(task.getResult().getToken());
                new DeviceUpdateDataSource(MainActivity.this.mAppContext.mDeviceGuid, task.getResult().getToken()).ExecuteRequest();
            }
        });
    }

    private void loadTabs() {
        this.mPageAdapter.notifyDataSetChanged();
        this.mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /* class com.proudcrowd.exposure.activity.MainActivity.AnonymousClass2 */

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                MainActivity.this.mTabHost.setCurrentTab(i);
                MainActivity.this.mPageAdapter.newFragmentVisible(i);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void setupTabHost(int i) {
        TabHost tabHost = (TabHost) findViewById(16908306);
        this.mTabHost = tabHost;
        tabHost.setup();
        this.mTabHost.getTabWidget().setStripEnabled(false);
        setNewTab(this, this.mTabHost, "Check", getString(R.string.tab_check), 16908305, R.drawable.ic_verified_user_white_36dp);
        setNewTab(this, this.mTabHost, "Protect", getString(R.string.tab_protect), 16908305, R.drawable.ic_outline_people_alt_white_36dp);
        setNewTab(this, this.mTabHost, "Affiliate", getString(R.string.tab_affiliate), 16908305, R.drawable.ic_home_work_white_36pt);
        setNewTab(this, this.mTabHost, "Info", getString(R.string.tab_info), 16908305, R.drawable.ic_info_white_36dp);
        this.mTabHost.getTabWidget().setPadding(0, 0, 0, 0);
        this.mTabHost.setCurrentTab(i);
        resetTabTint();
        this.mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            /* class com.proudcrowd.exposure.activity.MainActivity.AnonymousClass3 */

            public void onTabChanged(String str) {
                if (str.equals("Check")) {
                    MainActivity.this.mViewPager.setCurrentItem(0);
                } else if (str.equals("Protect")) {
                    MainActivity.this.mViewPager.setCurrentItem(1);
                } else if (str.equals("Affiliate")) {
                    MainActivity.this.mViewPager.setCurrentItem(2);
                } else if (str.equals("Info")) {
                    MainActivity.this.mViewPager.setCurrentItem(3);
                }
                MainActivity.this.resetTabTint();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void resetTabTint() {
        for (int i = 0; i < this.mTabHost.getTabWidget().getChildCount(); i++) {
            this.mTabHost.getTabWidget().getChildTabViewAt(i).setBackgroundColor(getColor(R.color.u_tab_selected_background));
        }
        this.mTabHost.getTabWidget().getChildTabViewAt(this.mTabHost.getCurrentTab()).setBackgroundColor(getColor(R.color.colorAccent));
    }

    private TabHost.TabSpec setNewTab(Context context, TabHost tabHost, String str, String str2, int i, int i2) {
        TabHost.TabSpec newTabSpec = tabHost.newTabSpec(str);
        newTabSpec.setIndicator(getTabIndicator(context, str2, i2));
        newTabSpec.setContent(i);
        tabHost.addTab(newTabSpec);
        return newTabSpec;
    }

    private View getTabIndicator(Context context, String str, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tab_layout, (ViewGroup) null);
        inflate.setBackgroundColor(getColor(R.color.colorAccent));
        TextView textView = (TextView) inflate.findViewById(R.id.textView);
        textView.setText(str);
        textView.setTextColor(getColor(R.color.u_button_text_color));
        ((ImageView) inflate.findViewById(R.id.tabLogo)).setImageDrawable(getResources().getDrawable(i));
        return inflate;
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        AffiliateFragment affiliateFragment;
        super.onActivityResult(i, i2, intent);
        if (i == 2222) {
            ProtectFragment protectFragment = (ProtectFragment) this.mPageAdapter.mProtectFragment.get();
            if (i2 == -1) {
                protectFragment.shareKeys();
            }
        } else if (i == AffiliateDetailActivity.AFFILIATE_DETAIL_RESULT && (affiliateFragment = (AffiliateFragment) this.mPageAdapter.mAffiliateFragment.get()) != null) {
            affiliateFragment.childDialogComplete();
        }
    }
}
