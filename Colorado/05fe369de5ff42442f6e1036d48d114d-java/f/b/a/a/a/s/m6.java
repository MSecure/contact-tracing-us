package f.b.a.a.a.s;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import f.b.a.a.a.j.l0;
import gov.co.cdphe.exposurenotifications.R;
import l.b.a.v.c;
import l.b.a.v.k;

public class m6 extends k5 {
    public final c g0 = c.c(k.MEDIUM);
    public l0 h0;

    @Override // f.b.a.a.a.m.z0, f.b.a.a.a.s.r5
    public boolean A0() {
        C0();
        return true;
    }

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_view, viewGroup, false);
        int i2 = R.id.button_container;
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.button_container);
        if (relativeLayout != null) {
            i2 = R.id.diagnosis_delete_button;
            Button button = (Button) inflate.findViewById(R.id.diagnosis_delete_button);
            if (button != null) {
                i2 = 16908332;
                ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                if (imageButton != null) {
                    i2 = R.id.share_diagnosis_scroll_view;
                    NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.share_diagnosis_scroll_view);
                    if (nestedScrollView != null) {
                        i2 = R.id.share_review_date;
                        TextView textView = (TextView) inflate.findViewById(R.id.share_review_date);
                        if (textView != null) {
                            i2 = R.id.share_review_status;
                            TextView textView2 = (TextView) inflate.findViewById(R.id.share_review_status);
                            if (textView2 != null) {
                                i2 = R.id.share_review_travel;
                                TextView textView3 = (TextView) inflate.findViewById(R.id.share_review_travel);
                                if (textView3 != null) {
                                    i2 = R.id.share_review_travel_subtitle;
                                    TextView textView4 = (TextView) inflate.findViewById(R.id.share_review_travel_subtitle);
                                    if (textView4 != null) {
                                        LinearLayout linearLayout = (LinearLayout) inflate;
                                        this.h0 = new l0(linearLayout, relativeLayout, button, imageButton, nestedScrollView, textView, textView2, textView3, textView4);
                                        return linearLayout;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.m
    public void R() {
        this.D = true;
        this.h0 = null;
    }

    @Override // f.b.a.a.a.m.z0, f.b.a.a.a.s.r5, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        o0().setTitle(R.string.status_shared_detail_title);
        l0 l0Var = this.h0;
        J0(l0Var.f2204e, l0Var.b);
        this.h0.f2203d.setOnClickListener(new r2(this));
        this.a0.f().f(C(), new o2(this));
        this.a0.p.f(C(), new p2(this));
    }
}
