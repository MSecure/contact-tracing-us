package f.b.a.a.a.f0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import f.b.a.a.a.u.t;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public class m0 extends h0 {
    public t b0;

    @Override // f.b.a.a.a.x.a1
    public boolean I0() {
        H0();
        return true;
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_en_turndown_for_region, viewGroup, false);
        int i2 = R.id.btn_close_app;
        Button button = (Button) inflate.findViewById(R.id.btn_close_app);
        if (button != null) {
            i2 = R.id.en_turndown_content;
            TextView textView = (TextView) inflate.findViewById(R.id.en_turndown_content);
            if (textView != null) {
                i2 = R.id.en_turndown_title;
                TextView textView2 = (TextView) inflate.findViewById(R.id.en_turndown_title);
                if (textView2 != null) {
                    i2 = R.id.onboarding_scroll;
                    NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.onboarding_scroll);
                    if (nestedScrollView != null) {
                        LinearLayout linearLayout = (LinearLayout) inflate;
                        this.b0 = new t(linearLayout, button, textView, textView2, nestedScrollView);
                        return linearLayout;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.o.a.m
    public void X() {
        this.D = true;
        this.b0 = null;
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        this.b0.b.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.f0.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                m0.this.H0();
            }
        });
    }
}
