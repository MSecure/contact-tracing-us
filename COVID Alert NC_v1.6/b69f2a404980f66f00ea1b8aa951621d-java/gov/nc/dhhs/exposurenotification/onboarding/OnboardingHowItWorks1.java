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
import d.a.a.a.i.b;
import d.a.a.a.i.c;
import d.a.a.a.i.d;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.exposure.ExposureHomeFragment;
import gov.nc.dhhs.exposurenotification.home.ExposureNotificationViewModel;

public class OnboardingHowItWorks1 extends Fragment {
    public static final String TAG = "OnboardingPermission";
    public ExposureNotificationViewModel exposureNotificationViewModel;

    private void transitionToNextFragment(int i) {
        getParentFragmentManager().a0(null, 1);
        q parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager != null) {
            a aVar = new a(parentFragmentManager);
            aVar.i(i, new OnboardingHowItWorks2(), HowItWorksActivity.HOW_IT_WORKS_FRAGMENT_TAG);
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
        requireActivity().finish();
    }

    public /* synthetic */ void f(View view) {
        requireActivity().finish();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_how_it_works_1, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        final ScrollView scrollView = (ScrollView) view.findViewById(R.id.scrollview_1);
        scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class gov.nc.dhhs.exposurenotification.onboarding.OnboardingHowItWorks1.AnonymousClass1 */

            public void onGlobalLayout() {
                if (scrollView.getMeasuredHeight() - scrollView.getChildAt(0).getHeight() < 0) {
                    scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                        /* class gov.nc.dhhs.exposurenotification.onboarding.OnboardingHowItWorks1.AnonymousClass1.AnonymousClass1 */

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
        ((Button) view.findViewById(R.id.onboarding_next_button)).setOnClickListener(new c(this));
        ImageView imageView = (ImageView) view.findViewById(R.id.back_icon);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.exit_icon);
        if (ExposureHomeFragment.how_it_works_in_navbar_enabled) {
            imageView.setVisibility(8);
        }
        imageView2.setOnClickListener(new b(this));
        imageView.setOnClickListener(new d(this));
    }
}
