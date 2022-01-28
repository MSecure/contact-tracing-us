package f.b.a.a.a.s;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import e.p.t;
import java.util.Objects;

public final /* synthetic */ class j0 implements t {
    public final /* synthetic */ v5 a;
    public final /* synthetic */ LinearLayout b;
    public final /* synthetic */ LinearLayout c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EditText f2376d;

    public /* synthetic */ j0(v5 v5Var, LinearLayout linearLayout, LinearLayout linearLayout2, EditText editText) {
        this.a = v5Var;
        this.b = linearLayout;
        this.c = linearLayout2;
        this.f2376d = editText;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        v5 v5Var = this.a;
        LinearLayout linearLayout = this.b;
        LinearLayout linearLayout2 = this.c;
        EditText editText = this.f2376d;
        String str = (String) obj;
        Objects.requireNonNull(v5Var);
        if (TextUtils.isEmpty(str)) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout2.setVisibility(8);
        linearLayout.setVisibility(0);
        v5Var.h0.f2167k.setText(str);
        editText.setEnabled(true);
        v5Var.h0.f2162f.setDisplayedChild(0);
    }
}
