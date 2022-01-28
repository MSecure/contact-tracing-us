package gov.michigan.MiCovidExposure.onboarding;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.l.d.a;
import b.l.d.z;
import b.o.y;
import com.google.android.material.snackbar.Snackbar;
import e.a.a.g.b;
import e.a.a.g.c;
import e.a.a.g.d;
import e.a.a.g.e;
import e.a.a.g.f;
import gov.michigan.MiCovidExposure.R;
import gov.michigan.MiCovidExposure.home.ExposureNotificationActivity;
import gov.michigan.MiCovidExposure.home.ExposureNotificationViewModel;
import gov.michigan.MiCovidExposure.home.HomeFragment;
import gov.michigan.MiCovidExposure.storage.ExposureNotificationSharedPreferences;

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
        getParentFragmentManager().Z(null, 1);
        z parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager != null) {
            a aVar = new a(parentFragmentManager);
            aVar.h(R.id.home_fragment, new OnboardingFinishFragment(), ExposureNotificationActivity.HOME_FRAGMENT_TAG);
            aVar.f2040f = 4099;
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
        ((TextView) view.findViewById(R.id.onboarding_message)).setMovementMethod(LinkMovementMethod.getInstance());
        ExposureNotificationViewModel exposureNotificationViewModel2 = (ExposureNotificationViewModel) new y(requireActivity()).a(ExposureNotificationViewModel.class);
        this.exposureNotificationViewModel = exposureNotificationViewModel2;
        exposureNotificationViewModel2.getIsEnabledLiveData().observe(getViewLifecycleOwner(), new b(this));
        this.exposureNotificationViewModel.getApiErrorLiveEvent().observe(getViewLifecycleOwner(), new c(this));
        Button button = (Button) view.findViewById(R.id.onboarding_next_button);
        button.setOnClickListener(new d(this));
        this.exposureNotificationViewModel.getInFlightLiveData().observe(getViewLifecycleOwner(), new e(button));
        view.findViewById(R.id.onboarding_no_thanks_button).setOnClickListener(new f(this));
    }
}
