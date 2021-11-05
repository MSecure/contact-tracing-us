package gov.nc.dhhs.exposurenotification.notify;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import b.b.k.f;
import b.l.d.a;
import b.l.d.q;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisEntity;
import java.util.Objects;

public class ShareDiagnosisActivity extends f {
    public static final String EXTRA_VIEW_POSITIVE_DIAGNOSIS_ID = "ShareExposureActivity.EXTRA_VIEW_POSITIVE_DIAGNOSIS_ID";
    public static final String SAVED_INSTANCE_STATE_FRAGMENT_KEY = "ShareExposureActivity.SAVED_INSTANCE_STATE_FRAGMENT_KEY";
    public static final String SHARE_EXPOSURE_FRAGMENT_TAG = "ShareExposureActivity.POSITIVE_TEST_FRAGMENT_TAG";

    public static Intent newIntentForAddFlow(Context context) {
        return new Intent(context, ShareDiagnosisActivity.class);
    }

    public static Intent newIntentForViewFlow(Context context, PositiveDiagnosisEntity positiveDiagnosisEntity) {
        Intent intent = new Intent(context, ShareDiagnosisActivity.class);
        intent.putExtra(EXTRA_VIEW_POSITIVE_DIAGNOSIS_ID, positiveDiagnosisEntity.getId());
        return intent;
    }

    @Override // b.l.d.d
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment I = getSupportFragmentManager().I(R.id.share_exposure_fragment);
        if (I != null) {
            I.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, b.b.k.f, b.l.d.d, b.i.d.d
    public void onCreate(Bundle bundle) {
        a aVar;
        Fragment shareDiagnosisBeginFragment;
        super.onCreate(bundle);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        setContentView(R.layout.activity_share_diagnosis);
        if (bundle != null) {
            q supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager != null) {
                aVar = new a(supportFragmentManager);
                shareDiagnosisBeginFragment = (Fragment) Objects.requireNonNull(getSupportFragmentManager().L(bundle, SAVED_INSTANCE_STATE_FRAGMENT_KEY));
            } else {
                throw null;
            }
        } else if (getIntent().hasExtra(EXTRA_VIEW_POSITIVE_DIAGNOSIS_ID)) {
            q supportFragmentManager2 = getSupportFragmentManager();
            if (supportFragmentManager2 != null) {
                aVar = new a(supportFragmentManager2);
                shareDiagnosisBeginFragment = ShareDiagnosisViewFragment.newInstance(getIntent().getLongExtra(EXTRA_VIEW_POSITIVE_DIAGNOSIS_ID, -1));
            } else {
                throw null;
            }
        } else {
            q supportFragmentManager3 = getSupportFragmentManager();
            if (supportFragmentManager3 != null) {
                aVar = new a(supportFragmentManager3);
                shareDiagnosisBeginFragment = new ShareDiagnosisBeginFragment();
            } else {
                throw null;
            }
        }
        aVar.i(R.id.share_exposure_fragment, shareDiagnosisBeginFragment, SHARE_EXPOSURE_FRAGMENT_TAG);
        aVar.d();
    }

    @Override // b.l.d.d
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // androidx.activity.ComponentActivity, b.b.k.f, b.l.d.d, b.i.d.d
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getSupportFragmentManager().d0(bundle, SAVED_INSTANCE_STATE_FRAGMENT_KEY, (Fragment) Objects.requireNonNull(getSupportFragmentManager().J(SHARE_EXPOSURE_FRAGMENT_TAG)));
    }
}
