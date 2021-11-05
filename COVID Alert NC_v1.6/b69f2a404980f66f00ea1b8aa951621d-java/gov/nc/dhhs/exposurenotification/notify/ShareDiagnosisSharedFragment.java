package gov.nc.dhhs.exposurenotification.notify;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import d.a.a.a.h.e0;
import gov.nc.dhhs.exposurenotification.R;

public class ShareDiagnosisSharedFragment extends Fragment {
    public static final String TAG = "ShareExposureSharedFrag";

    public /* synthetic */ void d(View view) {
        requireActivity().finish();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_shared, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        view.findViewById(R.id.share_done_button).setOnClickListener(new e0(this));
        ((TextView) view.findViewById(R.id.share_complete_detail)).setMovementMethod(LinkMovementMethod.getInstance());
    }
}
