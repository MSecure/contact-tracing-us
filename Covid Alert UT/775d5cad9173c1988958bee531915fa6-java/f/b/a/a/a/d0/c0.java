package f.b.a.a.a.d0;

import android.text.TextUtils;
import android.widget.EditText;
import e.q.t;
import java.util.Objects;

public final /* synthetic */ class c0 implements t {
    public final /* synthetic */ u5 a;
    public final /* synthetic */ EditText b;

    public /* synthetic */ c0(u5 u5Var, EditText editText) {
        this.a = u5Var;
        this.b = editText;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        u5 u5Var = this.a;
        EditText editText = this.b;
        String str = (String) obj;
        Objects.requireNonNull(u5Var);
        if (str != null) {
            editText.setText(str);
            editText.setSelection(editText.getText().length());
            u5Var.i0.n.setEnabled(!TextUtils.isEmpty(str));
        }
    }
}
