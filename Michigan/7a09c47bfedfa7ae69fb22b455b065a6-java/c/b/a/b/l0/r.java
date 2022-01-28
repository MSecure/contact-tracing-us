package c.b.a.b.l0;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import c.b.a.b.c0.j;
import c.b.a.b.e;
import com.google.android.material.textfield.TextInputLayout;

public class r extends m {

    /* renamed from: d  reason: collision with root package name */
    public final TextWatcher f4403d = new a();

    /* renamed from: e  reason: collision with root package name */
    public final TextInputLayout.f f4404e = new b();

    /* renamed from: f  reason: collision with root package name */
    public final TextInputLayout.g f4405f = new c();

    public class a extends j {
        public a() {
        }

        @Override // c.b.a.b.c0.j
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            r rVar = r.this;
            rVar.f4386c.setChecked(!r.e(rVar));
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
            rVar.f4386c.setChecked(!r.e(rVar));
            editText.removeTextChangedListener(r.this.f4403d);
            editText.addTextChangedListener(r.this.f4403d);
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
                editText.removeTextChangedListener(r.this.f4403d);
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            EditText editText = r.this.f4384a.getEditText();
            if (editText != null) {
                int selectionEnd = editText.getSelectionEnd();
                editText.setTransformationMethod(r.e(r.this) ? null : PasswordTransformationMethod.getInstance());
                if (selectionEnd >= 0) {
                    editText.setSelection(selectionEnd);
                }
                r.this.f4384a.o();
            }
        }
    }

    public r(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public static boolean e(r rVar) {
        EditText editText = rVar.f4384a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // c.b.a.b.l0.m
    public void a() {
        this.f4384a.setEndIconDrawable(b.b.l.a.a.b(this.f4385b, e.design_password_eye));
        TextInputLayout textInputLayout = this.f4384a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(c.b.a.b.j.password_toggle_content_description));
        this.f4384a.setEndIconOnClickListener(new d());
        this.f4384a.a(this.f4404e);
        this.f4384a.g0.add(this.f4405f);
        EditText editText = this.f4384a.getEditText();
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
