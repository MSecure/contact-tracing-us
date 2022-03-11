package f.b.a.a.a.f0;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import e.r.f0;
import f.b.a.a.a.o0.b;
import f.b.a.a.a.t.p0.a;
import f.b.a.a.a.x.a1;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public abstract class g0 extends a1 {
    public OnboardingViewModel X;

    public abstract void J0();

    public abstract void K0();

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        this.X = (OnboardingViewModel) new f0(this).a(OnboardingViewModel.class);
        TextView textView = (TextView) view.findViewById(R.id.private_analytics_footer);
        String F = F(R.string.private_analytics_footer_learn_more);
        String F2 = F(R.string.private_analytics_link);
        a aVar = b.a;
        f.b.a.a.a.o0.a aVar2 = new f.b.a.a.a.o0.a(F2);
        String G = G(R.string.private_analytics_footer_onboarding, F);
        SpannableString spannableString = new SpannableString(G);
        int indexOf = G.indexOf(F);
        spannableString.setSpan(aVar2, indexOf, F.length() + indexOf, 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        ((Button) view.findViewById(R.id.private_analytics_dismiss)).setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.f0.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g0.this.J0();
            }
        });
        ((Button) view.findViewById(R.id.private_analytics_accept)).setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.f0.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g0.this.K0();
            }
        });
    }
}
