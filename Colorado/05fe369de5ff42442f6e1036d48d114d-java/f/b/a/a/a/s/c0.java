package f.b.a.a.a.s;

import android.text.TextUtils;
import android.widget.EditText;
import e.p.t;
import java.util.Objects;

public final /* synthetic */ class c0 implements t {
    public final /* synthetic */ v5 a;
    public final /* synthetic */ EditText b;

    public /* synthetic */ c0(v5 v5Var, EditText editText) {
        this.a = v5Var;
        this.b = editText;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        v5 v5Var = this.a;
        EditText editText = this.b;
        String str = (String) obj;
        Objects.requireNonNull(v5Var);
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.getText().length());
            v5Var.h0.n.setEnabled(!TextUtils.isEmpty(str));
        }
    }
}
