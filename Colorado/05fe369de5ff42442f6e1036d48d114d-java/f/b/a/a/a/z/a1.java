package f.b.a.a.a.z;

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
import e.p.f0;
import f.b.a.a.a.c0.b;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.j.y;
import gov.co.cdphe.exposurenotifications.R;

public class a1 extends v0 {
    public static final /* synthetic */ int b0 = 0;
    public y a0;

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = q().inflate(R.layout.fragment_private_analytics, (ViewGroup) null, false);
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
                        this.a0 = new y(frameLayout, imageButton, textView, switchMaterial, textView2, frameLayout);
                        return frameLayout;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        o0().setTitle(R.string.settings_private_analytics_subtitle);
        PrivateAnalyticsViewModel privateAnalyticsViewModel = (PrivateAnalyticsViewModel) new f0(this).a(PrivateAnalyticsViewModel.class);
        this.a0.b.setContentDescription(A(R.string.navigate_up));
        this.a0.b.setOnClickListener(new u(this));
        this.a0.f2237d.setText(A(R.string.private_analytics_subtitle));
        privateAnalyticsViewModel.c.f2116e.f(C(), new w(this, privateAnalyticsViewModel));
        String A = A(R.string.private_analytics_footer_learn_more);
        String A2 = A(R.string.private_analytics_link);
        a aVar = b.a;
        f.b.a.a.a.c0.a aVar2 = new f.b.a.a.a.c0.a(A2);
        String B = B(R.string.private_analytics_footer, A);
        SpannableString spannableString = new SpannableString(B);
        int indexOf = B.indexOf(A);
        spannableString.setSpan(aVar2, indexOf, A.length() + indexOf, 33);
        this.a0.c.setText(spannableString);
        this.a0.c.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
