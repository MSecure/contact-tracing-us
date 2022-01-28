package com.proudcrowd.exposure.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.fragment.PartyLookupFragment;

public class PartyLookupActivity extends BaseActivity {
    ImageButton mBackButton;
    PartyLookupFragment mFragment;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.proudcrowd.exposure.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fragment_host_dialog);
        PartyLookupFragment partyLookupFragment = (PartyLookupFragment) getSupportFragmentManager().findFragmentByTag("PartyLookupFragment");
        this.mFragment = partyLookupFragment;
        if (partyLookupFragment == null) {
            this.mFragment = PartyLookupFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.activity_fragment_host, this.mFragment, "PartyLookupFragment").commit();
        }
        ((TextView) findViewById(R.id.dialog_prompt)).setText("INSTRUCTIONS");
        ImageButton imageButton = (ImageButton) findViewById(R.id.dialog_back_button);
        this.mBackButton = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            /* class com.proudcrowd.exposure.activity.PartyLookupActivity.AnonymousClass1 */

            public void onClick(View view) {
                PartyLookupActivity.this.finish();
                PartyLookupActivity.this.overridePendingTransition(R.anim.animation_none, R.anim.animation_exit);
            }
        });
    }
}
