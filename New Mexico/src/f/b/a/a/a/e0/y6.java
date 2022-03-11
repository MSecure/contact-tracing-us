package f.b.a.a.a.e0;

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
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.radiobutton.MaterialRadioButton;
import e.b.a.m;
import e.r.t;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.o0.b;
import f.b.a.a.a.t.p0.a;
import f.b.a.a.a.u.d;
import f.b.a.a.a.u.n0;
import f.b.b.a.l;
import f.b.b.a.o;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Objects;
import l.b.a.e;
/* loaded from: classes.dex */
public class y6 extends e6 {
    public static final a j0 = a.e("ShareExposureVaccFrag");
    public n0 i0;

    @Override // f.b.a.a.a.e0.e6, f.b.a.a.a.x.a1
    public boolean I0() {
        L0();
        return true;
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                                                this.i0 = new n0(linearLayout, relativeLayout, textView, button, nestedScrollView, button2, new d((MaterialCardView) findViewById, materialRadioButton, materialRadioButton2, radioGroup, materialRadioButton3));
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

    @Override // e.o.a.m
    public void X() {
        this.D = true;
        this.i0 = null;
    }

    @Override // f.b.a.a.a.e0.e6, f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u0().setTitle(R.string.share_confirm_title);
        n0 n0Var = this.i0;
        S0(n0Var.f2455e, n0Var.b);
        this.i0.f2456f.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.e0.t2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                y6 y6Var = y6.this;
                int checkedRadioButtonId = y6Var.i0.f2457g.f2407d.getCheckedRadioButtonId();
                a1.i iVar = checkedRadioButtonId != R.id.no_radio_button ? checkedRadioButtonId != R.id.yes_radio_button ? a1.i.UNKNOWN : a1.i.VACCINATED : a1.i.NOT_VACCINATED;
                a aVar = y6.j0;
                StringBuilder h2 = f.a.a.a.a.h("setLastVaccinationResponse to ");
                h2.append(iVar.name());
                aVar.a(h2.toString());
                ShareDiagnosisViewModel shareDiagnosisViewModel = y6Var.b0;
                a1 a1Var = shareDiagnosisViewModel.f410h;
                e c = shareDiagnosisViewModel.f412j.c();
                if (a1Var.j()) {
                    a1Var.a.edit().putInt("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS", iVar.b).putLong("ExposureNotificationSharedPreferences.EXPOSURE_NOTIFICATION_LAST_VACCINATION_STATUS_TIME_MS", c.G()).apply();
                }
                y6Var.L0();
            }
        });
        this.i0.c.setText(G(R.string.share_vaccination_description, F(R.string.health_authority_name)));
        this.i0.f2454d.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.e0.q2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                y6 y6Var = y6.this;
                b.a(y6Var.i0.a, y6Var.F(R.string.private_analytics_link));
            }
        });
        this.i0.f2457g.f2407d.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: f.b.a.a.a.e0.s2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                y6.this.b0.x.j(new o(i2 != R.id.no_radio_button ? i2 != R.id.yes_radio_button ? a1.i.UNKNOWN : a1.i.VACCINATED : a1.i.NOT_VACCINATED));
            }
        });
        m.e.V(this.b0.x).f(H(), new t() { // from class: f.b.a.a.a.e0.r2
            @Override // e.r.t
            public final void a(Object obj) {
                MaterialRadioButton materialRadioButton;
                y6 y6Var = y6.this;
                l lVar = (l) obj;
                Objects.requireNonNull(y6Var);
                if (lVar.b()) {
                    int ordinal = ((a1.i) lVar.a()).ordinal();
                    if (ordinal == 0) {
                        materialRadioButton = y6Var.i0.f2457g.c;
                    } else if (ordinal == 1) {
                        materialRadioButton = y6Var.i0.f2457g.f2408e;
                    } else if (ordinal == 2) {
                        materialRadioButton = y6Var.i0.f2457g.b;
                    } else {
                        throw new IllegalStateException("Failed to map vaccination status to radio button id");
                    }
                    materialRadioButton.setChecked(true);
                }
            }
        });
    }
}
