package f.b.a.a.a.d0;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import e.q.t;
import f.b.a.a.a.m0.b;
import f.b.a.a.a.s.a0;
import f.b.a.a.a.s.d0.a;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class r0 implements t {
    public final /* synthetic */ z5 a;

    public /* synthetic */ r0(z5 z5Var) {
        this.a = z5Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        z5 z5Var = this.a;
        String str = (String) obj;
        Objects.requireNonNull(z5Var);
        if (!TextUtils.isEmpty(str)) {
            String E = z5Var.E(R.string.learn_more);
            if (str.contains(E)) {
                TextView textView = z5Var.h0.f2370h;
                String E2 = z5Var.E(R.string.en_reporting_info_link);
                a aVar = b.a;
                textView.setText(a0.b(new f.b.a.a.a.m0.a(E2), str, E));
                z5Var.h0.f2370h.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                z5Var.h0.f2370h.setText(str);
            }
            z5Var.h0.f2370h.setVisibility(0);
            z5Var.h0.c.setEnabled(false);
            return;
        }
        z5Var.h0.f2370h.setVisibility(8);
    }
}
