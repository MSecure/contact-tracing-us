package f.b.a.a.a.d0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import e.b.a.m;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.t.d;
import f.b.a.a.a.t.k0;
import gov.ut.covid19.exposurenotifications.R;

public class k6 extends q5 {
    public static final a g0 = a.e("ShareExposureVaccFrag");
    public k0 f0;

    @Override // f.b.a.a.a.w.z0, f.b.a.a.a.d0.q5
    public boolean F0() {
        I0();
        return true;
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_vaccination, viewGroup, false);
        int i2 = R.id.button_container;
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.button_container);
        if (relativeLayout != null) {
            i2 = R.id.help_more_text;
            TextView textView = (TextView) inflate.findViewById(R.id.help_more_text);
            if (textView != null) {
                i2 = R.id.learn_more_button;
                Button button = (Button) inflate.findViewById(R.id.learn_more_button);
                if (button != null) {
                    i2 = R.id.share_diagnosis_scroll_view;
                    NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.share_diagnosis_scroll_view);
                    if (nestedScrollView != null) {
                        i2 = R.id.share_done_button;
                        Button button2 = (Button) inflate.findViewById(R.id.share_done_button);
                        if (button2 != null) {
                            i2 = R.id.vaccination_status_layout;
                            View findViewById = inflate.findViewById(R.id.vaccination_status_layout);
                            if (findViewById != null) {
                                int i3 = R.id.no_radio_button;
                                MaterialRadioButton materialRadioButton = (MaterialRadioButton) findViewById.findViewById(R.id.no_radio_button);
                                if (materialRadioButton != null) {
                                    i3 = R.id.unknown_radio_button;
                                    MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) findViewById.findViewById(R.id.unknown_radio_button);
                                    if (materialRadioButton2 != null) {
                                        i3 = R.id.vaccination_question_radio_group;
                                        RadioGroup radioGroup = (RadioGroup) findViewById.findViewById(R.id.vaccination_question_radio_group);
                                        if (radioGroup != null) {
                                            i3 = R.id.yes_radio_button;
                                            MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) findViewById.findViewById(R.id.yes_radio_button);
                                            if (materialRadioButton3 != null) {
                                                LinearLayout linearLayout = (LinearLayout) inflate;
                                                this.f0 = new k0(linearLayout, relativeLayout, textView, button, nestedScrollView, button2, new d((MaterialCardView) findViewById, materialRadioButton, materialRadioButton2, radioGroup, materialRadioButton3));
                                                return linearLayout;
                                            }
                                        }
                                    }
                                }
                                throw new NullPointerException("Missing required view with ID: ".concat(findViewById.getResources().getResourceName(i3)));
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
        this.f0 = null;
    }

    @Override // f.b.a.a.a.w.z0, f.b.a.a.a.d0.q5, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        s0().setTitle(R.string.share_confirm_title);
        k0 k0Var = this.f0;
        P0(k0Var.f2394e, k0Var.b);
        this.f0.f2395f.setOnClickListener(new n2(this));
        this.f0.c.setText(F(R.string.share_vaccination_description, E(R.string.health_authority_name)));
        this.f0.f2393d.setOnClickListener(new k2(this));
        this.f0.f2396g.f2353d.setOnCheckedChangeListener(new m2(this));
        m.e.U(this.b0.w).f(G(), new l2(this));
    }
}
