package com.proudcrowd.exposure.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.fragment.PartyInstructionsFragment;

public class PartyInstructionsActivity extends BaseActivity {
    ImageButton mBackButton;
    PartyInstructionsFragment mFragment;
    private int mPartyId;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.proudcrowd.exposure.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_fragment_host_dialog);
        this.mPartyId = getIntent().getIntExtra("PartyId", 0);
        PartyInstructionsFragment partyInstructionsFragment = (PartyInstructionsFragment) getSupportFragmentManager().findFragmentByTag("PartyInstructionsFragment");
        this.mFragment = partyInstructionsFragment;
        if (partyInstructionsFragment == null) {
            this.mFragment = PartyInstructionsFragment.newInstance(this.mPartyId);
            getSupportFragmentManager().beginTransaction().add(R.id.activity_fragment_host, this.mFragment, "PartyInstructionsFragment").commit();
        }
        ((TextView) findViewById(R.id.dialog_prompt)).setText("INSTRUCTIONS");
        ImageButton imageButton = (ImageButton) findViewById(R.id.dialog_back_button);
        this.mBackButton = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            /* class com.proudcrowd.exposure.activity.PartyInstructionsActivity.AnonymousClass1 */

            public void onClick(View view) {
                PartyInstructionsActivity.this.finish();
                PartyInstructionsActivity.this.overridePendingTransition(R.anim.animation_none, R.anim.animation_exit);
            }
        });
    }
}
