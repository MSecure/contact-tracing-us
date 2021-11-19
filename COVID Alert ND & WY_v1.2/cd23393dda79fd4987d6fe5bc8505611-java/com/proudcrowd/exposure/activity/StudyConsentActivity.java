package com.proudcrowd.exposure.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.bugfender.sdk.Bugfender;
import com.google.android.gms.common.api.ApiException;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.datamodel.DeviceRegisterDetail;
import com.proudcrowd.exposure.datamodel.StudyDetail;
import com.proudcrowd.exposure.datasource.DeviceRegisterDataSource;
import com.proudcrowd.exposure.datasource.StudyDataSource;
import com.proudcrowd.exposure.misc.RequestCodes;
import com.proudcrowd.exposure.viewmodel.ExposureViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudyConsentActivity extends BaseActivity implements Callback<StudyDetail> {
    private static final String TAG = "StudyConsentActivity";
    private ExposureViewModel exposureViewModel;
    private Button mContinueButton;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity, com.proudcrowd.exposure.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_study_consent);
        setupExposureApi();
        Button button = (Button) findViewById(R.id.consent_button);
        this.mContinueButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.proudcrowd.exposure.activity.StudyConsentActivity.AnonymousClass1 */

            public void onClick(View view) {
                StudyConsentActivity.this.mContinueButton.setEnabled(false);
                StudyConsentActivity studyConsentActivity = StudyConsentActivity.this;
                new StudyDataSource(studyConsentActivity, studyConsentActivity.mAppContext.mDeviceGuid, StudyConsentActivity.this.mAppContext.mStudy.id).ExecuteRequest();
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        ((TextView) findViewById(R.id.study_consent_text)).setText(this.mAppContext.mStudy.introPageTwoText);
    }

    private void setupExposureApi() {
        ExposureViewModel exposureViewModel2 = (ExposureViewModel) new ViewModelProvider(this).get(ExposureViewModel.class);
        this.exposureViewModel = exposureViewModel2;
        exposureViewModel2.getResolutionRequiredLiveEvent().observe(this, new Observer() {
            /* class com.proudcrowd.exposure.activity.$$Lambda$StudyConsentActivity$gwi8fHhQO4bh5iETOrtdaZnRCo */

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StudyConsentActivity.this.lambda$setupExposureApi$0$StudyConsentActivity((ApiException) obj);
            }
        });
        this.exposureViewModel.getIsEnabledLiveData().observe(this, new Observer() {
            /* class com.proudcrowd.exposure.activity.$$Lambda$StudyConsentActivity$kwhQeh9jdWQDeiRLs6E0MmEOtuM */

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StudyConsentActivity.this.lambda$setupExposureApi$1$StudyConsentActivity((Boolean) obj);
            }
        });
    }

    public /* synthetic */ void lambda$setupExposureApi$0$StudyConsentActivity(ApiException apiException) {
        try {
            Log.d(TAG, "startResolutionForResult");
            apiException.getStatus().startResolutionForResult(this, RequestCodes.REQUEST_CODE_START_EXPOSURE_NOTIFICATION);
        } catch (IntentSender.SendIntentException unused) {
            Log.w(TAG, "Error calling startResolutionForResult", apiException);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshUiForEnabled */
    public void lambda$setupExposureApi$1$StudyConsentActivity(Boolean bool) {
        if (bool.booleanValue()) {
            this.exposureViewModel.noteOnboardingCompleted();
            Intent intent = new Intent(this.mAppContext, IntroActivity.class);
            intent.addFlags(268468224);
            startActivity(intent);
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<StudyDetail> call, final Response<StudyDetail> response) {
        if (response.body() != null) {
            new DeviceRegisterDataSource(new Callback<DeviceRegisterDetail>() {
                /* class com.proudcrowd.exposure.activity.StudyConsentActivity.AnonymousClass2 */

                @Override // retrofit2.Callback
                public void onResponse(Call<DeviceRegisterDetail> call, Response<DeviceRegisterDetail> response) {
                    if (response.body() != null) {
                        StudyConsentActivity.this.mAppContext.setStudy((StudyDetail) response.body());
                        DeviceRegisterDetail body = response.body();
                        StudyConsentActivity.this.mAppContext.setCitizenCode(body.citizenCode);
                        StudyConsentActivity.this.exposureViewModel.startExposureNotifications();
                        Bugfender.setDeviceString("user.citizen_code", body.citizenCode);
                        return;
                    }
                    String str = StudyConsentActivity.TAG;
                    Bugfender.sendIssue(str, "Device Register Failure - " + response.message());
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<DeviceRegisterDetail> call, Throwable th) {
                    String str = StudyConsentActivity.TAG;
                    Bugfender.sendIssue(str, "Device Register Failure - " + th.getMessage());
                }
            }, this.mAppContext.mDeviceGuid, this.mAppContext.mDeviceName, this.mAppContext.mSimOperatorName, this.mAppContext.mStudy.id).ExecuteRequest();
            return;
        }
        this.mContinueButton.setEnabled(true);
        String str = TAG;
        Bugfender.sendIssue(str, "Home Setting Failure - " + response.message());
    }

    @Override // retrofit2.Callback
    public void onFailure(Call<StudyDetail> call, Throwable th) {
        this.mContinueButton.setEnabled(true);
        String str = TAG;
        Bugfender.sendIssue(str, "Home Setting Failure - " + th.getMessage());
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        onResolutionComplete(i, i2);
    }

    public void onResolutionComplete(int i, int i2) {
        if (i == 1111) {
            if (i2 == -1) {
                this.exposureViewModel.startResolutionResultOk();
            } else {
                this.exposureViewModel.startResolutionResultNotOk();
            }
        }
    }

    @Override // androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback, androidx.fragment.app.FragmentActivity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
    }
}
