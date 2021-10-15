package gov.michigan.MiCovidExposure.notify;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import b.b.k.f;
import b.l.d.a;
import b.l.d.z;
import gov.michigan.MiCovidExposure.R;
import gov.michigan.MiCovidExposure.storage.PositiveDiagnosisEntity;
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

    @Override // androidx.activity.ComponentActivity, b.l.d.m
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Fragment I = getSupportFragmentManager().I(R.id.share_exposure_fragment);
        if (I != null) {
            I.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, b.b.k.f, b.i.d.e, b.l.d.m
    public void onCreate(Bundle bundle) {
        a aVar;
        Fragment shareDiagnosisEditFragment;
        super.onCreate(bundle);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.mi_dark_blue));
        getWindow().setStatusBarColor(getResources().getColor(R.color.mi_dark_blue));
        setContentView(R.layout.activity_share_diagnosis);
        if (bundle != null) {
            z supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager != null) {
                aVar = new a(supportFragmentManager);
                shareDiagnosisEditFragment = (Fragment) Objects.requireNonNull(getSupportFragmentManager().K(bundle, SAVED_INSTANCE_STATE_FRAGMENT_KEY));
            } else {
                throw null;
            }
        } else if (getIntent().hasExtra(EXTRA_VIEW_POSITIVE_DIAGNOSIS_ID)) {
            z supportFragmentManager2 = getSupportFragmentManager();
            if (supportFragmentManager2 != null) {
                aVar = new a(supportFragmentManager2);
                shareDiagnosisEditFragment = ShareDiagnosisViewFragment.newInstance(getIntent().getLongExtra(EXTRA_VIEW_POSITIVE_DIAGNOSIS_ID, -1));
            } else {
                throw null;
            }
        } else {
            z supportFragmentManager3 = getSupportFragmentManager();
            if (supportFragmentManager3 != null) {
                aVar = new a(supportFragmentManager3);
                shareDiagnosisEditFragment = new ShareDiagnosisEditFragment();
            } else {
                throw null;
            }
        }
        aVar.h(R.id.share_exposure_fragment, shareDiagnosisEditFragment, SHARE_EXPOSURE_FRAGMENT_TAG);
        aVar.d();
    }

    @Override // androidx.activity.ComponentActivity, b.l.d.m
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // androidx.activity.ComponentActivity, b.b.k.f, b.i.d.e
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getSupportFragmentManager().c0(bundle, SAVED_INSTANCE_STATE_FRAGMENT_KEY, (Fragment) Objects.requireNonNull(getSupportFragmentManager().J(SHARE_EXPOSURE_FRAGMENT_TAG)));
    }
}
