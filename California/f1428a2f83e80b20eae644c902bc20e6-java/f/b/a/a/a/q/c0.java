package f.b.a.a.a.q;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import e.b.a.m;
import e.m.a.a;
import e.m.a.l;
import e.p.b0;
import f.b.a.a.a.h.j;
import f.b.a.a.a.w.n0;
import gov.ca.covid19.exposurenotifications.R;
import java.util.Objects;

public class c0 extends x {
    public OnboardingViewModel Z;

    public static void z0(l lVar) {
        lVar.t().a0(null, 1);
        a aVar = new a(lVar.t());
        aVar.f(R.id.home_fragment, new c0(), "ExposureNotificationActivity.HOME_FRAGMENT_TAG");
        aVar.f1638f = 4097;
        aVar.c();
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_onboarding_private_analytics, viewGroup, false);
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        this.Z = (OnboardingViewModel) new b0(this).a(OnboardingViewModel.class);
        ((Button) view.findViewById(R.id.private_analytics_dismiss)).setOnClickListener(new r(this));
        ((Button) view.findViewById(R.id.private_analytics_accept)).setOnClickListener(new s(this));
        n0 n0Var = this.Z.c;
        Objects.requireNonNull(n0Var);
        m.h.R(new j(n0Var.a, "ExposureNotificationSharedPreferences.SHARE_PRIVATE_ANALYTICS_KEY")).f(B(), new t(this));
        String z = z(R.string.private_analytics_footer_learn_more);
        URLSpan uRLSpan = new URLSpan(z(R.string.private_analytics_link));
        String A = A(R.string.private_analytics_footer_onboarding, z);
        SpannableString spannableString = new SpannableString(A);
        int indexOf = A.indexOf(z);
        spannableString.setSpan(uRLSpan, indexOf, z.length() + indexOf, 33);
        TextView textView = (TextView) view.findViewById(R.id.private_analytics_footer);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
