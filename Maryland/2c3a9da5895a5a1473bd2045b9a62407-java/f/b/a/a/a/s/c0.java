package f.b.a.a.a.s;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import e.b.a.m;
import e.m.a.a;
import e.m.a.l;
import e.p.b0;
import f.b.a.a.a.i.q;
import gov.md.covid19.exposurenotifications.R;

public class c0 extends x {
    public q a0;
    public OnboardingViewModel b0;

    public static void z0(l lVar) {
        lVar.t().a0(null, 1);
        a aVar = new a(lVar.t());
        aVar.f(R.id.home_fragment, new c0(), "ExposureNotificationActivity.HOME_FRAGMENT_TAG");
        aVar.f1665f = 4097;
        aVar.c();
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_private_analytics, viewGroup, false);
        int i2 = R.id.private_analytics_accept;
        Button button = (Button) inflate.findViewById(R.id.private_analytics_accept);
        if (button != null) {
            i2 = R.id.private_analytics_dismiss;
            Button button2 = (Button) inflate.findViewById(R.id.private_analytics_dismiss);
            if (button2 != null) {
                i2 = R.id.private_analytics_footer;
                TextView textView = (TextView) inflate.findViewById(R.id.private_analytics_footer);
                if (textView != null) {
                    LinearLayout linearLayout = (LinearLayout) inflate;
                    this.a0 = new q(linearLayout, button, button2, textView);
                    return linearLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.l
    public void R() {
        this.D = true;
        this.a0 = null;
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        this.b0 = (OnboardingViewModel) new b0(this).a(OnboardingViewModel.class);
        this.a0.c.setOnClickListener(new r(this));
        this.a0.b.setOnClickListener(new s(this));
        m.h.R(this.b0.c.f2359f).f(B(), new t(this));
        String z = z(R.string.private_analytics_footer_learn_more);
        URLSpan uRLSpan = new URLSpan(z(R.string.private_analytics_link));
        String A = A(R.string.private_analytics_footer_onboarding, z);
        SpannableString spannableString = new SpannableString(A);
        int indexOf = A.indexOf(z);
        spannableString.setSpan(uRLSpan, indexOf, z.length() + indexOf, 33);
        this.a0.f2126d.setText(spannableString);
        this.a0.f2126d.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
