package gov.nc.dhhs.exposurenotification.onboarding;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import b.b.k.f;
import b.l.d.a;
import b.l.d.q;
import gov.nc.dhhs.exposurenotification.R;
import java.util.Objects;

public class HowItWorksActivity extends f {
    public static final String HOW_IT_WORKS_FRAGMENT_TAG = "HowItWorksActivity.POSITIVE_TEST_FRAGMENT_TAG";
    public static final String SAVED_INSTANCE_STATE_FRAGMENT_KEY = "HowItWorksActivity.SAVED_INSTANCE_STATE_FRAGMENT_KEY";

    @Override // b.l.d.d
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment I = getSupportFragmentManager().I(R.id.onboarding_fragment);
        if (I != null) {
            I.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, b.b.k.f, b.l.d.d, b.i.d.d
    public void onCreate(Bundle bundle) {
        Fragment fragment;
        a aVar;
        super.onCreate(bundle);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        setContentView(R.layout.activity_how_it_works);
        if (bundle != null) {
            PrivacyChecklist.review_privacy_checklist_enabled = true;
            q supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager != null) {
                aVar = new a(supportFragmentManager);
                fragment = (Fragment) Objects.requireNonNull(getSupportFragmentManager().L(bundle, SAVED_INSTANCE_STATE_FRAGMENT_KEY));
            } else {
                throw null;
            }
        } else {
            q supportFragmentManager2 = getSupportFragmentManager();
            if (supportFragmentManager2 != null) {
                aVar = new a(supportFragmentManager2);
                fragment = new OnboardingHowItWorks1();
            } else {
                throw null;
            }
        }
        aVar.i(R.id.onboarding_fragment, fragment, HOW_IT_WORKS_FRAGMENT_TAG);
        aVar.d();
    }

    @Override // b.l.d.d
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // androidx.activity.ComponentActivity, b.b.k.f, b.l.d.d, b.i.d.d
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getSupportFragmentManager().d0(bundle, SAVED_INSTANCE_STATE_FRAGMENT_KEY, (Fragment) Objects.requireNonNull(getSupportFragmentManager().J(HOW_IT_WORKS_FRAGMENT_TAG)));
    }
}
