package gov.nc.dhhs.exposurenotification.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.fragment.app.Fragment;
import b.l.d.a;
import b.l.d.q;
import b.l.d.z;
import d.a.a.a.i.h;
import d.a.a.a.i.i;
import d.a.a.a.i.j;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.home.ExposureNotificationViewModel;

public class OnboardingHowItWorks3 extends Fragment {
    public static final String TAG = "OnboardingPermission";
    public ExposureNotificationViewModel exposureNotificationViewModel;

    private void transitionToNextFragment(int i) {
        getParentFragmentManager().a0(null, 1);
        q parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager != null) {
            a aVar = new a(parentFragmentManager);
            aVar.i(i, new OnboardingHowItWorks4(), HowItWorksActivity.HOW_IT_WORKS_FRAGMENT_TAG);
            aVar.f = 4099;
            aVar.d();
            return;
        }
        throw null;
    }

    public /* synthetic */ void d(View view) {
        transitionToNextFragment(R.id.onboarding_fragment);
    }

    public /* synthetic */ void e(View view) {
        z f = getParentFragmentManager().f();
        f.i(R.id.onboarding_fragment, new OnboardingHowItWorks2(), HowItWorksActivity.HOW_IT_WORKS_FRAGMENT_TAG);
        f.k(4099);
        f.c(null);
        f.d();
    }

    public /* synthetic */ void f(View view) {
        requireActivity().finish();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_how_it_works_3, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        final ScrollView scrollView = (ScrollView) view.findViewById(R.id.scrollview_3);
        scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class gov.nc.dhhs.exposurenotification.onboarding.OnboardingHowItWorks3.AnonymousClass1 */

            public void onGlobalLayout() {
                if (scrollView.getMeasuredHeight() - scrollView.getChildAt(0).getHeight() < 0) {
                    scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                        /* class gov.nc.dhhs.exposurenotification.onboarding.OnboardingHowItWorks3.AnonymousClass1.AnonymousClass1 */

                        public void onScrollChanged() {
                            if (!scrollView.canScrollVertically(1)) {
                                view.findViewById(R.id.onboarding_buttons).setVisibility(0);
                            }
                        }
                    });
                } else {
                    view.findViewById(R.id.onboarding_buttons).setVisibility(0);
                }
            }
        });
        ((Button) view.findViewById(R.id.onboarding_next_button)).setOnClickListener(new j(this));
        ((ImageView) view.findViewById(R.id.back_icon)).setOnClickListener(new h(this));
        ((ImageView) view.findViewById(R.id.exit_icon)).setOnClickListener(new i(this));
    }
}
