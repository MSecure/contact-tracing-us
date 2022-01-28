package com.proudcrowd.exposure.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.proudcrowd.exposure.R;

public class AboutActivity extends BaseActivity {
    private SwitchMaterial mDiagSwitch;
    private Button mPolicyButton;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.proudcrowd.exposure.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_about);
        ((TextView) findViewById(R.id.about_version_code)).setText("Version " + this.mAppContext.mAppVersion);
        Button button = (Button) findViewById(R.id.about_privacy_policy_button);
        this.mPolicyButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.proudcrowd.exposure.activity.AboutActivity.AnonymousClass1 */

            public void onClick(View view) {
                AboutActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://" + AboutActivity.this.mAppContext.mStudy.privacyPolicyLink)));
            }
        });
        SwitchMaterial switchMaterial = (SwitchMaterial) findViewById(R.id.about_diagnostics_switch);
        this.mDiagSwitch = switchMaterial;
        switchMaterial.setChecked(this.mAppContext.getPreferences().getUseBugfender());
        this.mDiagSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.proudcrowd.exposure.activity.$$Lambda$AboutActivity$8xpEK9QMMutA1U2Fn0JSI7M3iLM */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AboutActivity.this.lambda$onCreate$0$AboutActivity(compoundButton, z);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$AboutActivity(CompoundButton compoundButton, boolean z) {
        this.mAppContext.getPreferences().setUseBugfender(z);
    }
}
