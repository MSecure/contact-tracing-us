package f.b.a.a.a.s;

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
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.j.d;
import f.b.a.a.a.j.k0;
import gov.co.cdphe.exposurenotifications.R;

public class l6 extends r5 {
    public static final a f0 = a.e("ShareExposureVaccFrag");
    public k0 e0;

    @Override // f.b.a.a.a.m.z0, f.b.a.a.a.s.r5
    public boolean A0() {
        C0();
        return true;
    }

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                                                this.e0 = new k0(linearLayout, relativeLayout, textView, button, nestedScrollView, button2, new d((MaterialCardView) findViewById, materialRadioButton, materialRadioButton2, radioGroup, materialRadioButton3));
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

    @Override // e.m.a.m
    public void R() {
        this.D = true;
        this.e0 = null;
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m, f.b.a.a.a.s.r5
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        o0().setTitle(R.string.share_confirm_title);
        k0 k0Var = this.e0;
        J0(k0Var.f2199e, k0Var.b);
        this.e0.f2200f.setOnClickListener(new n2(this));
        this.e0.c.setText(B(R.string.share_vaccination_description, A(R.string.health_authority_name)));
        this.e0.f2198d.setOnClickListener(new k2(this));
        this.e0.f2201g.f2158d.setOnCheckedChangeListener(new m2(this));
        m.h.S(this.a0.w).f(C(), new l2(this));
    }
}
