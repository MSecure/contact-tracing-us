package f.b.a.a.a.u;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import gov.nm.covid19.exposurenotifications.R;
/* loaded from: classes.dex */
public final class e {
    public final MaterialCardView a;
    public final LinearLayout b;
    public final MaterialCardView c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f2409d;

    /* renamed from: e  reason: collision with root package name */
    public final Button f2410e;

    public e(MaterialCardView materialCardView, LinearLayout linearLayout, MaterialCardView materialCardView2, TextView textView, Button button) {
        this.a = materialCardView;
        this.b = linearLayout;
        this.c = materialCardView2;
        this.f2409d = textView;
        this.f2410e = button;
    }

    public static e a(View view) {
        int i2 = R.id.content_layout;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content_layout);
        if (linearLayout != null) {
            MaterialCardView materialCardView = (MaterialCardView) view;
            i2 = R.id.possible_exposure_card_title;
            TextView textView = (TextView) view.findViewById(R.id.possible_exposure_card_title);
            if (textView != null) {
                i2 = R.id.see_details_button;
                Button button = (Button) view.findViewById(R.id.see_details_button);
                if (button != null) {
                    return new e(materialCardView, linearLayout, materialCardView, textView, button);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
    }
}
