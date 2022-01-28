package c.b.a.b.l0;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import c.b.a.b.e;
import c.b.a.b.j;
import com.google.android.material.textfield.TextInputLayout;

public class r extends m {

    /* renamed from: d  reason: collision with root package name */
    public final TextWatcher f3102d = new a();

    /* renamed from: e  reason: collision with root package name */
    public final TextInputLayout.f f3103e = new b();
    public final TextInputLayout.g f = new c();

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            r rVar = r.this;
            rVar.f3089c.setChecked(!r.e(rVar));
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements TextInputLayout.f {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            r rVar = r.this;
            rVar.f3089c.setChecked(!r.e(rVar));
            editText.removeTextChangedListener(r.this.f3102d);
            editText.addTextChangedListener(r.this.f3102d);
        }
    }

    public class c implements TextInputLayout.g {
        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i == 1) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                editText.removeTextChangedListener(r.this.f3102d);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            EditText editText = r.this.f3087a.getEditText();
            if (editText != null) {
                int selectionEnd = editText.getSelectionEnd();
                editText.setTransformationMethod(r.e(r.this) ? null : PasswordTransformationMethod.getInstance());
                if (selectionEnd >= 0) {
                    editText.setSelection(selectionEnd);
                }
            }
        }
    }

    public r(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public static boolean e(r rVar) {
        EditText editText = rVar.f3087a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // c.b.a.b.l0.m
    public void a() {
        this.f3087a.setEndIconDrawable(b.b.l.a.a.b(this.f3088b, e.design_password_eye));
        TextInputLayout textInputLayout = this.f3087a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(j.password_toggle_content_description));
        this.f3087a.setEndIconOnClickListener(new d());
        this.f3087a.a(this.f3103e);
        this.f3087a.g0.add(this.f);
        EditText editText = this.f3087a.getEditText();
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
