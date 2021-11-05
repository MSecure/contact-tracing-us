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
import b.l.d.z;
import d.a.a.a.i.k;
import d.a.a.a.i.l;
import d.a.a.a.i.m;
import d.a.a.a.i.n;
import gov.nc.dhhs.exposurenotification.R;
import gov.nc.dhhs.exposurenotification.home.ExposureNotificationViewModel;

public class OnboardingHowItWorks4 extends Fragment {
    public static final String TAG = "OnboardingPermission";
    public ExposureNotificationViewModel exposureNotificationViewModel;

    public /* synthetic */ void d(View view) {
        PrivacyChecklist.review_privacy_checklist_enabled = true;
        z f = getParentFragmentManager().f();
        f.i(R.id.onboarding_fragment, new PrivacyChecklist(), HowItWorksActivity.HOW_IT_WORKS_FRAGMENT_TAG);
        f.k(4099);
        f.c(null);
        f.d();
    }

    public /* synthetic */ void e(View view) {
        z f = getParentFragmentManager().f();
        f.i(R.id.onboarding_fragment, new OnboardingHowItWorks3(), HowItWorksActivity.HOW_IT_WORKS_FRAGMENT_TAG);
        f.k(4099);
        f.c(null);
        f.d();
    }

    public /* synthetic */ void f(View view) {
        requireActivity().finish();
    }

    public /* synthetic */ void g(View view) {
        requireActivity().finish();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_how_it_works_4, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        final ScrollView scrollView = (ScrollView) view.findViewById(R.id.scrollview_4);
        scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class gov.nc.dhhs.exposurenotification.onboarding.OnboardingHowItWorks4.AnonymousClass1 */

            public void onGlobalLayout() {
                if (scrollView.getMeasuredHeight() - scrollView.getChildAt(0).getHeight() < 0) {
                    scrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
                        /* class gov.nc.dhhs.exposurenotification.onboarding.OnboardingHowItWorks4.AnonymousClass1.AnonymousClass1 */

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
        view.findViewById(R.id.review_checklist).setOnClickListener(new n(this));
        ((ImageView) view.findViewById(R.id.back_icon)).setOnClickListener(new k(this));
        ((Button) view.findViewById(R.id.onboarding_next_button)).setOnClickListener(new l(this));
        ((ImageView) view.findViewById(R.id.exit_icon)).setOnClickListener(new m(this));
    }
}
