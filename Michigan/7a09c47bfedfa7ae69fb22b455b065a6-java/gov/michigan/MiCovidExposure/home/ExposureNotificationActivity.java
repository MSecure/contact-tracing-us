package gov.michigan.MiCovidExposure.home;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import b.b.k.f;
import b.l.d.a;
import b.l.d.z;
import b.o.y;
import c.b.a.a.d.k.b;
import gov.michigan.MiCovidExposure.R;
import gov.michigan.MiCovidExposure.nearby.StateUpdatedWorker;
import gov.michigan.MiCovidExposure.onboarding.OnboardingStartFragment;
import gov.michigan.MiCovidExposure.storage.ExposureNotificationSharedPreferences;
import gov.michigan.MiCovidExposure.utils.CustomUtility;
import gov.michigan.MiCovidExposure.utils.RequestCodes;
import java.util.Objects;

public final class ExposureNotificationActivity extends f {
    public static final String ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION = "com.google.android.apps.exposurenotification.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION";
    public static final String HOME_FRAGMENT_TAG = "ExposureNotificationActivity.HOME_FRAGMENT_TAG";
    public static final String SAVED_INSTANCE_STATE_FRAGMENT_KEY = "ExposureNotificationActivity.SAVED_INSTANCE_STATE_FRAGMENT_KEY";
    public static final String TAG = "ExposureNotifnActivity";
    public ExposureNotificationViewModel exposureNotificationViewModel;

    public void a(b bVar) {
        try {
            bVar.f2941b.x(this, RequestCodes.REQUEST_CODE_START_EXPOSURE_NOTIFICATION);
        } catch (IntentSender.SendIntentException unused) {
        }
    }

    @Override // androidx.activity.ComponentActivity, b.l.d.m
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        onResolutionComplete(i, i2);
    }

    @Override // androidx.activity.ComponentActivity, b.b.k.f, b.i.d.e, b.l.d.m
    public void onCreate(Bundle bundle) {
        a aVar;
        Fragment newInstance;
        super.onCreate(bundle);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.mi_dark_blue));
        getWindow().setStatusBarColor(getResources().getColor(R.color.mi_dark_blue));
        setContentView(R.layout.activity_exposure_notification);
        ExposureNotificationViewModel exposureNotificationViewModel2 = (ExposureNotificationViewModel) new y(this).a(ExposureNotificationViewModel.class);
        this.exposureNotificationViewModel = exposureNotificationViewModel2;
        exposureNotificationViewModel2.getResolutionRequiredLiveEvent().observe(this, new e.a.a.c.a(this));
        if (bundle != null) {
            z supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager != null) {
                aVar = new a(supportFragmentManager);
                newInstance = (Fragment) Objects.requireNonNull(getSupportFragmentManager().K(bundle, SAVED_INSTANCE_STATE_FRAGMENT_KEY));
            } else {
                throw null;
            }
        } else {
            ExposureNotificationSharedPreferences exposureNotificationSharedPreferences = new ExposureNotificationSharedPreferences(this);
            if (exposureNotificationSharedPreferences.getOnboardedState() == ExposureNotificationSharedPreferences.OnboardingStatus.UNKNOWN) {
                if (exposureNotificationSharedPreferences.getFirstOnboardingStatus(false)) {
                    exposureNotificationSharedPreferences.setFirstOnboardingStatus(true);
                } else {
                    CustomUtility.customLogger("A91005 - whenever post-install onboarding screens are shown");
                }
                z supportFragmentManager2 = getSupportFragmentManager();
                if (supportFragmentManager2 != null) {
                    a aVar2 = new a(supportFragmentManager2);
                    aVar2.h(R.id.home_fragment, new OnboardingStartFragment(), HOME_FRAGMENT_TAG);
                    aVar2.f2040f = 4097;
                    aVar2.e();
                    return;
                }
                throw null;
            }
            z supportFragmentManager3 = getSupportFragmentManager();
            if (supportFragmentManager3 != null) {
                aVar = new a(supportFragmentManager3);
                Intent intent = getIntent();
                newInstance = (intent == null || intent.getAction() == null || !intent.getAction().equals(StateUpdatedWorker.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION)) ? HomeFragment.newInstance() : HomeFragment.newInstance(0);
            } else {
                throw null;
            }
        }
        aVar.h(R.id.home_fragment, newInstance, HOME_FRAGMENT_TAG);
        aVar.d();
    }

    @Override // androidx.activity.ComponentActivity, b.l.d.m
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onResolutionComplete(int i, int i2) {
        if (i == 1111) {
            if (i2 == -1) {
                this.exposureNotificationViewModel.startResolutionResultOk();
            } else {
                this.exposureNotificationViewModel.startResolutionResultNotOk();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, b.b.k.f, b.i.d.e
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getSupportFragmentManager().c0(bundle, SAVED_INSTANCE_STATE_FRAGMENT_KEY, (Fragment) Objects.requireNonNull(getSupportFragmentManager().J(HOME_FRAGMENT_TAG)));
    }
}
