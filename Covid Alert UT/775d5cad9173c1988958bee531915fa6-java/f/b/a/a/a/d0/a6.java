package f.b.a.a.a.d0;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import e.u.i;
import e.u.p.c;
import f.b.a.a.a.l0.a0;
import f.b.a.a.a.l0.h0;
import f.b.a.a.a.l0.i0;
import f.b.a.a.a.l0.w;
import f.b.a.a.a.l0.y;
import f.b.a.a.a.t.f0;
import gov.ut.covid19.exposurenotifications.R;
import java.util.List;
import java.util.Objects;
import l.b.a.d;

public class a6 extends g5 {
    public f0 h0;

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_is_code_needed, viewGroup, false);
        int i2 = R.id.btn_i_have_code;
        Button button = (Button) inflate.findViewById(R.id.btn_i_have_code);
        if (button != null) {
            i2 = R.id.btn_i_need_code;
            Button button2 = (Button) inflate.findViewById(R.id.btn_i_need_code);
            if (button2 != null) {
                i2 = R.id.button_container;
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.button_container);
                if (linearLayout != null) {
                    i2 = R.id.do_you_have_code_content;
                    TextView textView = (TextView) inflate.findViewById(R.id.do_you_have_code_content);
                    if (textView != null) {
                        i2 = 16908332;
                        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                        if (imageButton != null) {
                            i2 = R.id.share_diagnosis_scroll_view;
                            NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.share_diagnosis_scroll_view);
                            if (nestedScrollView != null) {
                                LinearLayout linearLayout2 = (LinearLayout) inflate;
                                this.h0 = new f0(linearLayout2, button, button2, linearLayout, textView, imageButton, nestedScrollView);
                                return linearLayout2;
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
        this.h0 = null;
    }

    @Override // f.b.a.a.a.d0.q5, e.n.a.m, f.b.a.a.a.w.z0
    public void k0(View view, Bundle bundle) {
        String str;
        super.k0(view, bundle);
        s0().setTitle(E(R.string.do_you_have_code_title));
        f0 f0Var = this.h0;
        P0(f0Var.f2380g, f0Var.f2377d);
        if (!TextUtils.isEmpty(E(R.string.self_report_intro))) {
            this.h0.f2378e.setText(R.string.self_report_intro);
        }
        this.b0.f().f(G(), new h1(this));
        this.h0.b.setOnClickListener(new k1(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        long G = shareDiagnosisViewModel.f405j.c().w(d.f(90)).G();
        w wVar = shareDiagnosisViewModel.c.a;
        List<h0.d> list = i0.f2291f;
        List<h0.c> list2 = i0.f2290e;
        a0 a0Var = (a0) wVar;
        Objects.requireNonNull(a0Var);
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("*");
        sb.append(" FROM DiagnosisEntity WHERE testResult IN (");
        int size = list.size();
        c.a(sb, size);
        sb.append(") AND sharedStatus IN (");
        int size2 = list2.size();
        c.a(sb, size2);
        sb.append(") AND lastUpdatedTimestampMs > ");
        sb.append("?");
        sb.append(" ORDER BY lastUpdatedTimestampMs DESC LIMIT 1");
        int i2 = 1;
        int i3 = size + 1;
        int i4 = size2 + i3;
        i t = i.t(sb.toString(), i4);
        for (h0.d dVar : list) {
            if (dVar == null) {
                str = null;
            } else {
                str = dVar.name();
            }
            if (str == null) {
                t.J(i2);
            } else {
                t.L(i2, str);
            }
            i2++;
        }
        for (h0.c cVar : list2) {
            String c0 = m.e.c0(cVar);
            if (c0 == null) {
                t.J(i3);
            } else {
                t.L(i3, c0);
            }
            i3++;
        }
        t.x(i4, G);
        a0Var.a.f1977e.b(new String[]{"DiagnosisEntity"}, false, new y(a0Var, t)).f(G(), new g1(this));
    }
}
