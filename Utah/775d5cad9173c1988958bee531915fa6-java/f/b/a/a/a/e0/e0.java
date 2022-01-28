package f.b.a.a.a.e0;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import e.q.f0;
import f.b.a.a.a.m0.b;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.w.z0;
import gov.ut.covid19.exposurenotifications.R;

public abstract class e0 extends z0 {
    public OnboardingViewModel X;

    public abstract void G0();

    public abstract void H0();

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        this.X = (OnboardingViewModel) new f0(this).a(OnboardingViewModel.class);
        TextView textView = (TextView) view.findViewById(R.id.private_analytics_footer);
        String E = E(R.string.private_analytics_footer_learn_more);
        String E2 = E(R.string.private_analytics_link);
        a aVar = b.a;
        f.b.a.a.a.m0.a aVar2 = new f.b.a.a.a.m0.a(E2);
        String F = F(R.string.private_analytics_footer_onboarding, E);
        SpannableString spannableString = new SpannableString(F);
        int indexOf = F.indexOf(E);
        spannableString.setSpan(aVar2, indexOf, E.length() + indexOf, 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        ((Button) view.findViewById(R.id.private_analytics_dismiss)).setOnClickListener(new k(this));
        ((Button) view.findViewById(R.id.private_analytics_accept)).setOnClickListener(new l(this));
    }
}
