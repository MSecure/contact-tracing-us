package gov.nc.dhhs.exposurenotification.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import b.l.d.a;
import b.l.d.q;
import b.n.y;
import com.google.android.material.snackbar.Snackbar;
import d.a.a.a.i.o;
import d.a.a.a.i.p;
import d.a.a.a.i.r;
import d.a.a.a.i.s;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.home.ExposureNotificationActivity;
import gov.nc.dhhs.exposurenotification.home.ExposureNotificationViewModel;
import gov.nc.dhhs.exposurenotification.home.HomeFragment;
import gov.nc.dhhs.exposurenotification.storage.ExposureNotificationSharedPreferences;

public class OnboardingPermissionFragment extends Fragment {
    public static final String TAG = "OnboardingPermission";
    public ExposureNotificationViewModel exposureNotificationViewModel;

    private void nextAction() {
        this.exposureNotificationViewModel.startExposureNotifications();
    }

    private void skipOnboarding() {
        new ExposureNotificationSharedPreferences(requireContext()).setOnboardedState(false);
        HomeFragment.transitionToHomeFragment(this);
    }

    private void transitionToFinishFragment() {
        getParentFragmentManager().a0(null, 1);
        q parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager != null) {
            a aVar = new a(parentFragmentManager);
            aVar.i(R.id.home_fragment, new OnboardingFinishFragment(), ExposureNotificationActivity.HOME_FRAGMENT_TAG);
            aVar.f = 4099;
            aVar.d();
            return;
        }
        throw null;
    }

    public /* synthetic */ void d(Boolean bool) {
        if (bool.booleanValue()) {
            transitionToFinishFragment();
        }
    }

    public /* synthetic */ void e(Void r3) {
        View view = getView();
        if (view != null) {
            Snackbar.h(view, R.string.api_update_error_message_text, 0).j();
        }
    }

    public /* synthetic */ void f(View view) {
        nextAction();
    }

    public /* synthetic */ void h(View view) {
        skipOnboarding();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_onboarding_permission, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ExposureNotificationViewModel exposureNotificationViewModel2 = (ExposureNotificationViewModel) new y(requireActivity()).a(ExposureNotificationViewModel.class);
        this.exposureNotificationViewModel = exposureNotificationViewModel2;
        exposureNotificationViewModel2.getIsEnabledLiveData().observe(getViewLifecycleOwner(), new s(this));
        this.exposureNotificationViewModel.getApiErrorLiveEvent().observe(getViewLifecycleOwner(), new d.a.a.a.i.q(this));
        Button button = (Button) view.findViewById(R.id.onboarding_next_button);
        button.setOnClickListener(new r(this));
        this.exposureNotificationViewModel.getInFlightLiveData().observe(getViewLifecycleOwner(), new p(button));
        view.findViewById(R.id.onboarding_no_thanks_button).setOnClickListener(new o(this));
    }
}
