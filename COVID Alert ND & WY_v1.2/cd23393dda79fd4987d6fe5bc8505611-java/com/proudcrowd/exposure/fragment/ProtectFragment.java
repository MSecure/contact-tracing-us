package com.proudcrowd.exposure.fragment;

import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.bugfender.sdk.Bugfender;
import com.google.android.gms.common.api.ApiException;
import com.google.common.util.concurrent.FutureCallback;
import com.proudcrowd.exposure.R;
import com.proudcrowd.exposure.core.ExposureManager;
import com.proudcrowd.exposure.datamodel.ProtectDetail;
import com.proudcrowd.exposure.datasource.ProtectDataSource;
import com.proudcrowd.exposure.misc.TabFragmentConsumer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProtectFragment extends BaseFragment implements TabFragmentConsumer, Callback<ProtectDetail> {
    private TextView mCitizenTextView;
    private ProtectDataSource mDataSource;
    private int mDiagnosisState;
    private TextView mHeaderText;
    private TextView mMainTextArea;
    private Button mNotifyButton;

    @Override // retrofit2.Callback
    public void onFailure(Call<ProtectDetail> call, Throwable th) {
    }

    @Override // com.proudcrowd.exposure.misc.TabFragmentConsumer
    public void onNotSelected() {
    }

    public static ProtectFragment newInstance() {
        return new ProtectFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mHeaderText = (TextView) getView().findViewById(R.id.protect_header_text);
        this.mMainTextArea = (TextView) getView().findViewById(R.id.protect_citizen_code_explain);
        TextView textView = (TextView) getView().findViewById(R.id.protect_citizen_code);
        this.mCitizenTextView = textView;
        textView.setText(this.mAppContext.mCitizenCode);
        Button button = (Button) getView().findViewById(R.id.notify_others_button);
        this.mNotifyButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            /* class com.proudcrowd.exposure.fragment.ProtectFragment.AnonymousClass1 */

            public void onClick(View view) {
                ProtectFragment.this.shareKeys();
            }
        });
        loadData();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_protect, viewGroup, false);
    }

    private void loadData() {
        ProtectDataSource protectDataSource = new ProtectDataSource(this, this.mAppContext.mDeviceGuid);
        this.mDataSource = protectDataSource;
        protectDataSource.ExecuteRequest();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setupViews() {
        int i = this.mDiagnosisState;
        if (i == 0) {
            this.mNotifyButton.setEnabled(false);
            this.mNotifyButton.setTextColor(-7829368);
            this.mMainTextArea.setText(this.mAppContext.mStudy.notifyOthersText);
        } else if (i == 1) {
            this.mHeaderText.setVisibility(8);
            this.mCitizenTextView.setVisibility(8);
            this.mNotifyButton.setEnabled(true);
            this.mNotifyButton.setTextColor(-1);
            this.mMainTextArea.setText(this.mAppContext.mStudy.notificationConsentText);
        } else if (i == 2) {
            this.mHeaderText.setVisibility(8);
            this.mCitizenTextView.setVisibility(8);
            this.mNotifyButton.setEnabled(false);
            this.mNotifyButton.setTextColor(-7829368);
            this.mMainTextArea.setText(R.string.protect_expired);
        } else if (i == 3) {
            this.mHeaderText.setVisibility(8);
            this.mCitizenTextView.setVisibility(8);
            this.mNotifyButton.setEnabled(false);
            this.mNotifyButton.setTextColor(-7829368);
            this.mMainTextArea.setText(R.string.protect_keys_successfully_shared);
        }
    }

    @Override // com.proudcrowd.exposure.misc.TabFragmentConsumer
    public void onSelected() {
        loadData();
    }

    @Override // retrofit2.Callback
    public void onResponse(Call<ProtectDetail> call, Response<ProtectDetail> response) {
        if (response.body() != null) {
            this.mDiagnosisState = response.body().diagnosisState;
            setupViews();
        }
    }

    public void shareKeys() {
        ExposureManager.get(this.mAppContext).getAndPostDiagnosisKeys(new FutureCallback<Exception>() {
            /* class com.proudcrowd.exposure.fragment.ProtectFragment.AnonymousClass2 */

            public void onSuccess(@NullableDecl Exception exc) {
                if (exc == null) {
                    ProtectFragment.this.getActivity().runOnUiThread(new Runnable() {
                        /* class com.proudcrowd.exposure.fragment.ProtectFragment.AnonymousClass2.AnonymousClass1 */

                        public void run() {
                            ProtectFragment.this.mDiagnosisState = 3;
                            ProtectFragment.this.setupViews();
                        }
                    });
                } else if (exc instanceof ApiException) {
                    ApiException apiException = (ApiException) exc;
                    try {
                        apiException.getStatus().startResolutionForResult(ProtectFragment.this.getActivity(), 2222);
                    } catch (IntentSender.SendIntentException unused) {
                        Log.w(ProtectFragment.class.getSimpleName(), "Error calling startResolutionForResult", apiException);
                    }
                } else {
                    Bugfender.e("Failed to get diagnosis keys and upload them.", "Exception: " + exc.getMessage());
                    Bugfender.forceSendOnce();
                }
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                Bugfender.e("Failed to get diagnosis keys and upload them.", "onFailure: " + th.getMessage());
                Bugfender.forceSendOnce();
            }
        });
    }
}
