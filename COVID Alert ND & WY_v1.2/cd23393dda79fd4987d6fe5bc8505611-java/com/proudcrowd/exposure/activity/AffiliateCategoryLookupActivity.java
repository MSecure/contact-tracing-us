package com.proudcrowd.exposure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.fragment.AffiliateCategoryFragment;

public class AffiliateCategoryLookupActivity extends BaseActivity {
    ImageButton mBackButton;
    AffiliateCategoryFragment mFragment;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.proudcrowd.exposure.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fragment_host_dialog);
        AffiliateCategoryFragment affiliateCategoryFragment = (AffiliateCategoryFragment) getSupportFragmentManager().findFragmentByTag("AffiliateCategoryFragment");
        this.mFragment = affiliateCategoryFragment;
        if (affiliateCategoryFragment == null) {
            this.mFragment = AffiliateCategoryFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.activity_fragment_host, this.mFragment, "AffiliateCategoryFragment").commit();
        }
        ((TextView) findViewById(R.id.dialog_prompt)).setText("Affiliate Categories");
        ImageButton imageButton = (ImageButton) findViewById(R.id.dialog_back_button);
        this.mBackButton = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            /* class com.proudcrowd.exposure.activity.AffiliateCategoryLookupActivity.AnonymousClass1 */

            public void onClick(View view) {
                AffiliateCategoryLookupActivity.this.finish();
                AffiliateCategoryLookupActivity.this.overridePendingTransition(R.anim.animation_none, R.anim.animation_exit);
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == AffiliateDetailActivity.AFFILIATE_DETAIL_RESULT && i2 == -1) {
            setResult(-1, new Intent());
            finish();
            overridePendingTransition(R.anim.animation_none, R.anim.animation_exit);
        }
    }
}
