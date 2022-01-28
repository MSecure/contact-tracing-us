package f.b.a.a.a.s;

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
import e.t.i;
import e.t.p.c;
import f.b.a.a.a.b0.a0;
import f.b.a.a.a.b0.h0;
import f.b.a.a.a.b0.i0;
import f.b.a.a.a.b0.w;
import f.b.a.a.a.b0.y;
import f.b.a.a.a.j.f0;
import gov.co.cdphe.exposurenotifications.R;
import java.util.List;
import java.util.Objects;
import l.b.a.d;

public class b6 extends g5 {
    public f0 g0;

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                                this.g0 = new f0(linearLayout2, button, button2, linearLayout, textView, imageButton, nestedScrollView);
                                return linearLayout2;
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
        String str;
        super.g0(view, bundle);
        o0().setTitle(A(R.string.do_you_have_code_title));
        f0 f0Var = this.g0;
        J0(f0Var.f2185g, f0Var.f2182d);
        if (!TextUtils.isEmpty(A(R.string.self_report_intro))) {
            this.g0.f2183e.setText(R.string.self_report_intro);
        }
        this.a0.f().f(C(), new h1(this));
        this.g0.b.setOnClickListener(new k1(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a0;
        long G = shareDiagnosisViewModel.f409j.c().w(d.f(90)).G();
        w wVar = shareDiagnosisViewModel.c.a;
        List<h0.d> list = i0.f2094f;
        List<h0.c> list2 = i0.f2093e;
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
            String a0 = m.h.a0(cVar);
            if (a0 == null) {
                t.J(i3);
            } else {
                t.L(i3, a0);
            }
            i3++;
        }
        t.x(i4, G);
        a0Var.a.f1702e.b(new String[]{"DiagnosisEntity"}, false, new y(a0Var, t)).f(C(), new g1(this));
    }
}
