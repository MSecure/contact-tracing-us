package gov.michigan.MiCovidExposure.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import b.i.d.n;
import e.a.a.c.l;
import gov.michigan.MiCovidExposure.R;

public class ShareHomeFragment extends Fragment {
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";

    public /* synthetic */ void d(View view) {
        n.b(getActivity()).d("text/plain").c(getResources().getString(R.string.share_app_message)).e();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_home, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        view.findViewById(R.id.share_app_button).setOnClickListener(new l(this));
    }
}
