package gov.nc.dhhs.exposurenotification.notify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import d.a.a.a.h.m;
import gov.nc.dhhs.exposurenotification.R;

public class ShareDiagnosisLearnMoreFragment extends Fragment {
    public static final String TAG = "ShareExposureLearnMoreFrag";

    private void navigateUp() {
        getParentFragmentManager().Z();
    }

    public /* synthetic */ void d(View view) {
        navigateUp();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_learn_more, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        view.findViewById(16908332).setOnClickListener(new m(this));
    }
}
