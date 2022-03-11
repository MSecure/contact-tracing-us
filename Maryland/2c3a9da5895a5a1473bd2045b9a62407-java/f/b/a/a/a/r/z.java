package f.b.a.a.a.r;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import e.p.r;
import java.util.Objects;

public final /* synthetic */ class z implements r {
    public final /* synthetic */ x3 a;
    public final /* synthetic */ LinearLayout b;
    public final /* synthetic */ LinearLayout c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EditText f2271d;

    public /* synthetic */ z(x3 x3Var, LinearLayout linearLayout, LinearLayout linearLayout2, EditText editText) {
        this.a = x3Var;
        this.b = linearLayout;
        this.c = linearLayout2;
        this.f2271d = editText;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        x3 x3Var = this.a;
        LinearLayout linearLayout = this.b;
        LinearLayout linearLayout2 = this.c;
        EditText editText = this.f2271d;
        String str = (String) obj;
        Objects.requireNonNull(x3Var);
        if (TextUtils.isEmpty(str)) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout2.setVisibility(8);
        linearLayout.setVisibility(0);
        x3Var.a0.f2140h.setText(str);
        editText.setEnabled(true);
        x3Var.a0.f2136d.setDisplayedChild(0);
    }
}
