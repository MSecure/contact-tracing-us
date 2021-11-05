package gov.nc.dhhs.exposurenotification.onboarding;

import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.l.d.z;
import gov.nc.dhhs.exposurenotification.R;

public class PrivacyChecklist extends Fragment {
    public static boolean review_privacy_checklist_enabled = false;

    public void d(int i, Fragment fragment, View view) {
        z f = getParentFragmentManager().f();
        f.i(i, fragment, HowItWorksActivity.HOW_IT_WORKS_FRAGMENT_TAG);
        f.f = 4099;
        f.c(null);
        f.d();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_privacy_checklist, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Fragment fragment;
        int i;
        TextView textView = (TextView) view.findViewById(R.id.checklist_privacy_policy);
        Spannable spannable = (Spannable) Html.fromHtml(Html.toHtml((Spanned) getText(R.string.checklist_privacy_policy)));
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (URLSpan uRLSpan : uRLSpanArr) {
            spannable.setSpan(new UnderlineSpan() {
                /* class gov.nc.dhhs.exposurenotification.onboarding.PrivacyChecklist.AnonymousClass1 */

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 0);
        }
        textView.setText(spannable);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        Button button = (Button) view.findViewById(R.id.done_btn);
        if (review_privacy_checklist_enabled) {
            review_privacy_checklist_enabled = false;
            fragment = new OnboardingHowItWorks4();
            i = R.id.onboarding_fragment;
        } else {
            fragment = new OnboardingStartFragment();
            i = R.id.home_fragment;
        }
        button.setOnClickListener(new d.a.a.a.i.z(this, i, fragment));
    }
}
