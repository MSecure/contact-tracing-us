package f.b.a.a.a.d0;

import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import e.q.t;
import java.util.Objects;

public final /* synthetic */ class j0 implements t {
    public final /* synthetic */ u5 a;
    public final /* synthetic */ LinearLayout b;
    public final /* synthetic */ LinearLayout c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EditText f2181d;

    public /* synthetic */ j0(u5 u5Var, LinearLayout linearLayout, LinearLayout linearLayout2, EditText editText) {
        this.a = u5Var;
        this.b = linearLayout;
        this.c = linearLayout2;
        this.f2181d = editText;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        u5 u5Var = this.a;
        LinearLayout linearLayout = this.b;
        LinearLayout linearLayout2 = this.c;
        EditText editText = this.f2181d;
        String str = (String) obj;
        Objects.requireNonNull(u5Var);
        if (TextUtils.isEmpty(str)) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout2.setVisibility(8);
        linearLayout.setVisibility(0);
        u5Var.i0.f2362k.setText(str);
        editText.setEnabled(true);
        u5Var.i0.f2357f.setDisplayedChild(0);
    }
}
