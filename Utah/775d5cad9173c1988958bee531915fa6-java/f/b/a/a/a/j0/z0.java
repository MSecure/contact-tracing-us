package f.b.a.a.a.j0;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.settings.PrivateAnalyticsViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.q.f0;
import f.b.a.a.a.m0.b;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.t.y;
import gov.ut.covid19.exposurenotifications.R;

public class z0 extends u0 {
    public static final /* synthetic */ int c0 = 0;
    public y b0;

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = s().inflate(R.layout.fragment_private_analytics, (ViewGroup) null, false);
        int i2 = 16908332;
        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
        if (imageButton != null) {
            i2 = R.id.private_analytics_footer;
            TextView textView = (TextView) inflate.findViewById(R.id.private_analytics_footer);
            if (textView != null) {
                i2 = R.id.private_analytics_switch;
                SwitchMaterial switchMaterial = (SwitchMaterial) inflate.findViewById(R.id.private_analytics_switch);
                if (switchMaterial != null) {
                    i2 = R.id.watermark;
                    TextView textView2 = (TextView) inflate.findViewById(R.id.watermark);
                    if (textView2 != null) {
                        FrameLayout frameLayout = (FrameLayout) inflate;
                        this.b0 = new y(frameLayout, imageButton, textView, switchMaterial, textView2, frameLayout);
                        return frameLayout;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        s0().setTitle(R.string.settings_private_analytics_subtitle);
        PrivateAnalyticsViewModel privateAnalyticsViewModel = (PrivateAnalyticsViewModel) new f0(this).a(PrivateAnalyticsViewModel.class);
        this.b0.b.setContentDescription(E(R.string.navigate_up));
        this.b0.b.setOnClickListener(new u(this));
        this.b0.f2435d.setText(E(R.string.private_analytics_subtitle));
        privateAnalyticsViewModel.c.f2313e.f(G(), new w(this, privateAnalyticsViewModel));
        String E = E(R.string.private_analytics_footer_learn_more);
        String E2 = E(R.string.private_analytics_link);
        a aVar = b.a;
        f.b.a.a.a.m0.a aVar2 = new f.b.a.a.a.m0.a(E2);
        String F = F(R.string.private_analytics_footer, E);
        SpannableString spannableString = new SpannableString(F);
        int indexOf = F.indexOf(E);
        spannableString.setSpan(aVar2, indexOf, E.length() + indexOf, 33);
        this.b0.c.setText(spannableString);
        this.b0.c.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
