package gov.michigan.MiCovidExposure.notify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import e.a.a.f.i;
import e.a.a.f.j;
import gov.michigan.MiCovidExposure.R;

public class ShareDiagnosisBeginFragment extends Fragment {
    public static final String TAG = "ShareExposureBeginFrag";

    private void cancelAction() {
        requireActivity().finish();
    }

    public /* synthetic */ void d(View view) {
        getParentFragmentManager().d().h(R.id.share_exposure_fragment, new ShareDiagnosisEditFragment(), ShareDiagnosisActivity.SHARE_EXPOSURE_FRAGMENT_TAG).c(null).j(4097).d();
    }

    public /* synthetic */ void e(View view) {
        cancelAction();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_begin, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        view.findViewById(R.id.share_next_button).setOnClickListener(new i(this));
        view.findViewById(16908332).setOnClickListener(new j(this));
    }
}
