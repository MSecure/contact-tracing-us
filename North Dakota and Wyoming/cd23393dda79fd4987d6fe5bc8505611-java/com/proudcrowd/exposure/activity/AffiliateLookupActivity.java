package com.proudcrowd.exposure.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.fragment.AffiliateLookupFragment;

public class AffiliateLookupActivity extends BaseActivity {
    ImageButton mBackButton;
    AffiliateLookupFragment mFragment;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.proudcrowd.exposure.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fragment_host_dialog);
        int intExtra = getIntent().getIntExtra("CategoryId", 0);
        AffiliateLookupFragment affiliateLookupFragment = (AffiliateLookupFragment) getSupportFragmentManager().findFragmentByTag("AffiliateLookupFragment");
        this.mFragment = affiliateLookupFragment;
        if (affiliateLookupFragment == null) {
            this.mFragment = AffiliateLookupFragment.newInstance(intExtra);
            getSupportFragmentManager().beginTransaction().add(R.id.activity_fragment_host, this.mFragment, "AffiliateLookupFragment").commit();
        }
        ((TextView) findViewById(R.id.dialog_prompt)).setText("Affiliates");
        ImageButton imageButton = (ImageButton) findViewById(R.id.dialog_back_button);
        this.mBackButton = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            /* class com.proudcrowd.exposure.activity.AffiliateLookupActivity.AnonymousClass1 */

            public void onClick(View view) {
                AffiliateLookupActivity.this.finish();
                AffiliateLookupActivity.this.overridePendingTransition(R.anim.animation_none, R.anim.animation_exit);
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
