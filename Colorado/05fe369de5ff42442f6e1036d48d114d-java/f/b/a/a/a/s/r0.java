package f.b.a.a.a.s;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import e.p.t;
import f.b.a.a.a.c0.b;
import f.b.a.a.a.i.b0;
import f.b.a.a.a.i.e0.a;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class r0 implements t {
    public final /* synthetic */ a6 a;

    public /* synthetic */ r0(a6 a6Var) {
        this.a = a6Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        a6 a6Var = this.a;
        String str = (String) obj;
        Objects.requireNonNull(a6Var);
        if (!TextUtils.isEmpty(str)) {
            String A = a6Var.A(R.string.learn_more);
            if (str.contains(A)) {
                TextView textView = a6Var.g0.f2175h;
                String A2 = a6Var.A(R.string.en_reporting_info_link);
                a aVar = b.a;
                textView.setText(b0.b(new f.b.a.a.a.c0.a(A2), str, A));
                a6Var.g0.f2175h.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                a6Var.g0.f2175h.setText(str);
            }
            a6Var.g0.f2175h.setVisibility(0);
            a6Var.g0.c.setEnabled(false);
            return;
        }
        a6Var.g0.f2175h.setVisibility(8);
    }
}
