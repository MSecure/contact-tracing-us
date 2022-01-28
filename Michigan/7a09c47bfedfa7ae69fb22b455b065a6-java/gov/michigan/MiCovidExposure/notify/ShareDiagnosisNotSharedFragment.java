package gov.michigan.MiCovidExposure.notify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import e.a.a.f.n;
import gov.michigan.MiCovidExposure.R;

public class ShareDiagnosisNotSharedFragment extends Fragment {
    public static final String TAG = "ShareExposureNotSharedFrag";

    public /* synthetic */ void d(View view) {
        requireActivity().finish();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_not_shared, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        view.findViewById(R.id.share_done_button).setOnClickListener(new n(this));
    }
}
