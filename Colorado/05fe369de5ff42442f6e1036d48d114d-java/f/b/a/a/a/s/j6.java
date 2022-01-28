package f.b.a.a.a.s;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import e.a.e.f.d;
import e.b.a.m;
import f.b.a.a.a.i.b0;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.i.x;
import f.b.a.a.a.j.j0;
import f.b.a.e.k.q;
import gov.co.cdphe.exposurenotifications.R;

public class j6 extends j5 {
    public static final a h0 = a.e("ShareDiagnosisUploadFragment");
    public j0 g0;

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_upload, viewGroup, false);
        int i2 = R.id.button_container;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.button_container);
        if (linearLayout != null) {
            i2 = R.id.has_symptom_chip_group;
            ChipGroup chipGroup = (ChipGroup) inflate.findViewById(R.id.has_symptom_chip_group);
            if (chipGroup != null) {
                i2 = R.id.has_symptom_confirmed_selected_date_choice;
                Chip chip = (Chip) inflate.findViewById(R.id.has_symptom_confirmed_selected_date_choice);
                if (chip != null) {
                    i2 = R.id.has_symptoms_date_fixed_description;
                    TextView textView = (TextView) inflate.findViewById(R.id.has_symptoms_date_fixed_description);
                    if (textView != null) {
                        i2 = 16908332;
                        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                        if (imageButton != null) {
                            i2 = R.id.no_travel_choice;
                            Chip chip2 = (Chip) inflate.findViewById(R.id.no_travel_choice);
                            if (chip2 != null) {
                                i2 = R.id.share_button;
                                Button button = (Button) inflate.findViewById(R.id.share_button);
                                if (button != null) {
                                    i2 = R.id.share_diagnosis_scroll_view;
                                    NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.share_diagnosis_scroll_view);
                                    if (nestedScrollView != null) {
                                        i2 = R.id.share_previous_button;
                                        Button button2 = (Button) inflate.findViewById(R.id.share_previous_button);
                                        if (button2 != null) {
                                            i2 = R.id.share_progress_bar;
                                            ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.share_progress_bar);
                                            if (progressBar != null) {
                                                i2 = R.id.share_upload_status;
                                                TextView textView2 = (TextView) inflate.findViewById(R.id.share_upload_status);
                                                if (textView2 != null) {
                                                    i2 = R.id.share_upload_test_result_description;
                                                    TextView textView3 = (TextView) inflate.findViewById(R.id.share_upload_test_result_description);
                                                    if (textView3 != null) {
                                                        i2 = R.id.share_upload_travel_subtitle;
                                                        TextView textView4 = (TextView) inflate.findViewById(R.id.share_upload_travel_subtitle);
                                                        if (textView4 != null) {
                                                            i2 = R.id.skip_symptom_date_choice;
                                                            Chip chip3 = (Chip) inflate.findViewById(R.id.skip_symptom_date_choice);
                                                            if (chip3 != null) {
                                                                i2 = R.id.skip_travel_history_choice;
                                                                Chip chip4 = (Chip) inflate.findViewById(R.id.skip_travel_history_choice);
                                                                if (chip4 != null) {
                                                                    i2 = R.id.step_x_of_y_text_view;
                                                                    TextView textView5 = (TextView) inflate.findViewById(R.id.step_x_of_y_text_view);
                                                                    if (textView5 != null) {
                                                                        i2 = R.id.travel_confirmed_choice;
                                                                        Chip chip5 = (Chip) inflate.findViewById(R.id.travel_confirmed_choice);
                                                                        if (chip5 != null) {
                                                                            i2 = R.id.travel_history_chip_group;
                                                                            ChipGroup chipGroup2 = (ChipGroup) inflate.findViewById(R.id.travel_history_chip_group);
                                                                            if (chipGroup2 != null) {
                                                                                i2 = R.id.travel_history_layout;
                                                                                LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.travel_history_layout);
                                                                                if (linearLayout2 != null) {
                                                                                    LinearLayout linearLayout3 = (LinearLayout) inflate;
                                                                                    this.g0 = new j0(linearLayout3, linearLayout, chipGroup, chip, textView, imageButton, chip2, button, nestedScrollView, button2, progressBar, textView2, textView3, textView4, chip3, chip4, textView5, chip5, chipGroup2, linearLayout2);
                                                                                    return linearLayout3;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
        this.g0 = null;
    }

    @Override // f.b.a.a.a.m.z0, f.b.a.a.a.s.r5, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        o0().setTitle(R.string.verify_test_result_title);
        j0 j0Var = this.g0;
        J0(j0Var.f2193i, j0Var.b);
        this.g0.f2190f.setOnClickListener(new c2(this));
        this.a0.g().f(C(), new g2(this));
        TextView textView = this.g0.m;
        Context p0 = p0();
        a aVar = b0.a;
        textView.setText(B(R.string.share_upload_test_result_source_description, p0.getString(R.string.health_authority_name)));
        this.g0.c.setOnCheckedChangeListener(new j2(this));
        this.g0.f2188d.addTextChangedListener(new i6(this));
        if (!this.a0.h()) {
            this.g0.s.setVisibility(0);
        }
        q<Long> E0 = E0("ShareDiagnosisUploadFragment.DATE_PICKER_TAG");
        if (E0 != null) {
            E0.m0.clear();
            E0.m0.add(new d2(this));
        }
        this.g0.r.setOnCheckedChangeListener(new i2(this));
        this.g0.f2192h.setEnabled(false);
        this.g0.f2192h.setOnClickListener(new x1(this));
        this.a0.o.f(C(), new y1(this));
        new x(this.a0.f(), this.a0.t).n(C(), new z1(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a0;
        m.h.G0(shareDiagnosisViewModel.f(), new n3(shareDiagnosisViewModel, ShareDiagnosisViewModel.b.UPLOAD)).f(C(), new u1(this, view));
        this.a0.q.f(C(), new f2(this));
        this.a0.r.f(C(), new e2(this, n0(new d(), new v1(this))));
        this.a0.f().f(C(), new w1(this));
    }
}
