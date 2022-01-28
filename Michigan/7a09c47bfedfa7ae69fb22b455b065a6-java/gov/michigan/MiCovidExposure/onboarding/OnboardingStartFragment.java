package gov.michigan.MiCovidExposure.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import b.l.d.i0;
import e.a.a.g.g;
import gov.michigan.MiCovidExposure.R;
import gov.michigan.MiCovidExposure.home.ExposureNotificationActivity;
import gov.michigan.MiCovidExposure.home.ExposureNotificationViewModel;

public class OnboardingStartFragment extends Fragment {
    public ExposureNotificationViewModel exposureNotificationViewModel;

    public /* synthetic */ void d(View view) {
        i0 d2 = getParentFragmentManager().d();
        d2.h(R.id.home_fragment, new OnboardingPermissionFragment(), ExposureNotificationActivity.HOME_FRAGMENT_TAG);
        d2.j(4099);
        d2.c(null);
        d2.d();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_onboarding_start, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ((Button) view.findViewById(R.id.onboarding_next_button)).setOnClickListener(new g(this));
    }
}
