package gov.nc.dhhs.exposurenotification.notify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.b.a.b.r.c;
import d.a.a.a.h.k;
import gov.nc.dhhs.exposurenotification.R;

public class ShareDiagnosisBeginFragmentBotom extends c {
    public static final String TAG = "ShareExposureBeginFrag";

    private void cancelAction() {
        dismiss();
    }

    public static ShareDiagnosisBeginFragmentBotom newInstance() {
        return new ShareDiagnosisBeginFragmentBotom();
    }

    public /* synthetic */ void d(View view) {
        cancelAction();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_begin, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        view.findViewById(R.id.share_next_button).setOnClickListener(new View.OnClickListener() {
            /* class gov.nc.dhhs.exposurenotification.notify.ShareDiagnosisBeginFragmentBotom.AnonymousClass1 */

            public void onClick(View view) {
                ShareDiagnosisBeginFragmentBotom shareDiagnosisBeginFragmentBotom = ShareDiagnosisBeginFragmentBotom.this;
                shareDiagnosisBeginFragmentBotom.startActivity(ShareDiagnosisActivity.newIntentForAddFlow(shareDiagnosisBeginFragmentBotom.requireContext()));
                ShareDiagnosisBeginFragmentBotom.this.dismiss();
            }
        });
        view.findViewById(16908332).setOnClickListener(new k(this));
    }
}
