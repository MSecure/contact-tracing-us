package f.b.a.a.a.t;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import e.p.f0;
import f.b.a.a.a.c0.b;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.m.z0;
import gov.co.cdphe.exposurenotifications.R;

public abstract class c0 extends z0 {
    public OnboardingViewModel X;

    public abstract void B0();

    public abstract void C0();

    @Override // f.b.a.a.a.m.z0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        this.X = (OnboardingViewModel) new f0(this).a(OnboardingViewModel.class);
        TextView textView = (TextView) view.findViewById(R.id.private_analytics_footer);
        String A = A(R.string.private_analytics_footer_learn_more);
        String A2 = A(R.string.private_analytics_link);
        a aVar = b.a;
        f.b.a.a.a.c0.a aVar2 = new f.b.a.a.a.c0.a(A2);
        String B = B(R.string.private_analytics_footer_onboarding, A);
        SpannableString spannableString = new SpannableString(B);
        int indexOf = B.indexOf(A);
        spannableString.setSpan(aVar2, indexOf, A.length() + indexOf, 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        ((Button) view.findViewById(R.id.private_analytics_dismiss)).setOnClickListener(new k(this));
        ((Button) view.findViewById(R.id.private_analytics_accept)).setOnClickListener(new l(this));
    }
}
