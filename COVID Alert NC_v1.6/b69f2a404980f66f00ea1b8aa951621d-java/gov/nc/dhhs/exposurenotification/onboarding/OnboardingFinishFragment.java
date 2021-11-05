package gov.nc.dhhs.exposurenotification.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import d.a.a.a.i.a;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.home.HomeFragment;

public class OnboardingFinishFragment extends Fragment {
    public /* synthetic */ void d(View view) {
        HomeFragment.transitionToHomeFragment(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_onboarding_finish, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ((Button) view.findViewById(R.id.onboarding_next_button)).setOnClickListener(new a(this));
    }
}
