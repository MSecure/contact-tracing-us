package f.b.a.a.a.d0;

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
import f.b.a.a.a.t.l0;
import gov.ut.covid19.exposurenotifications.R;
import l.b.a.v.c;
import l.b.a.v.k;

public class l6 extends k5 {
    public final c h0 = c.c(k.MEDIUM);
    public l0 i0;

    @Override // f.b.a.a.a.d0.q5, f.b.a.a.a.w.z0
    public boolean F0() {
        I0();
        return true;
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                                        this.i0 = new l0(linearLayout, relativeLayout, button, imageButton, nestedScrollView, textView, textView2, textView3, textView4);
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

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        this.i0 = null;
    }

    @Override // f.b.a.a.a.d0.q5, e.n.a.m, f.b.a.a.a.w.z0
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        s0().setTitle(R.string.status_shared_detail_title);
        l0 l0Var = this.i0;
        P0(l0Var.f2399e, l0Var.b);
        this.i0.f2398d.setOnClickListener(new r2(this));
        this.b0.f().f(G(), new o2(this));
        this.b0.p.f(G(), new p2(this));
    }
}
