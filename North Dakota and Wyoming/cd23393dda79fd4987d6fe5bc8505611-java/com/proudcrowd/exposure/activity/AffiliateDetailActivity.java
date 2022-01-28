package com.proudcrowd.exposure.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.fragment.AffiliateDetailFragment;

public class AffiliateDetailActivity extends BaseActivity {
    public static int AFFILIATE_DETAIL_RESULT = 42;
    int mAffiliateId;
    ImageButton mBackButton;
    AffiliateDetailFragment mFragment;
    boolean mIsJoinMode;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.proudcrowd.exposure.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fragment_host_dialog);
        this.mAffiliateId = getIntent().getIntExtra("AffiliateId", 0);
        this.mIsJoinMode = getIntent().getBooleanExtra("IsJoinMode", false);
        AffiliateDetailFragment affiliateDetailFragment = (AffiliateDetailFragment) getSupportFragmentManager().findFragmentByTag("AffiliateDetailFragment");
        this.mFragment = affiliateDetailFragment;
        if (affiliateDetailFragment == null) {
            this.mFragment = AffiliateDetailFragment.newInstance(this.mAffiliateId, this.mIsJoinMode);
            getSupportFragmentManager().beginTransaction().add(R.id.activity_fragment_host, this.mFragment, "AffiliateDetailFragment").commit();
        }
        ((TextView) findViewById(R.id.dialog_prompt)).setText("Affiliate");
        ImageButton imageButton = (ImageButton) findViewById(R.id.dialog_back_button);
        this.mBackButton = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            /* class com.proudcrowd.exposure.activity.AffiliateDetailActivity.AnonymousClass1 */

            public void onClick(View view) {
                AffiliateDetailActivity.this.finish();
                AffiliateDetailActivity.this.overridePendingTransition(R.anim.animation_none, R.anim.animation_exit);
            }
        });
    }
}
