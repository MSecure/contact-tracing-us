package f.b.a.a.a.u;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public final class c {
    public final MaterialCardView a;
    public final LinearLayout b;
    public final TextView c;

    /* renamed from: d  reason: collision with root package name */
    public final MaterialCardView f2395d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f2396e;

    /* renamed from: f  reason: collision with root package name */
    public final Button f2397f;

    public c(MaterialCardView materialCardView, LinearLayout linearLayout, TextView textView, MaterialCardView materialCardView2, TextView textView2, Button button) {
        this.a = materialCardView;
        this.b = linearLayout;
        this.c = textView;
        this.f2395d = materialCardView2;
        this.f2396e = textView2;
        this.f2397f = button;
    }

    public static c a(View view) {
        int i2 = R.id.content_layout;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content_layout);
        if (linearLayout != null) {
            i2 = R.id.no_recent_exposure_body;
            TextView textView = (TextView) view.findViewById(R.id.no_recent_exposure_body);
            if (textView != null) {
                MaterialCardView materialCardView = (MaterialCardView) view;
                i2 = R.id.no_recent_exposure_title;
                TextView textView2 = (TextView) view.findViewById(R.id.no_recent_exposure_title);
                if (textView2 != null) {
                    i2 = R.id.see_recent_checks_button;
                    Button button = (Button) view.findViewById(R.id.see_recent_checks_button);
                    if (button != null) {
                        return new c(materialCardView, linearLayout, textView, materialCardView, textView2, button);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }
}
