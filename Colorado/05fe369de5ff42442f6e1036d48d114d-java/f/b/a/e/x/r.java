package f.b.a.e.x;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import f.b.a.e.p.j;

public class r extends m {

    /* renamed from: d  reason: collision with root package name */
    public final TextWatcher f3051d = new a();

    /* renamed from: e  reason: collision with root package name */
    public final TextInputLayout.f f3052e = new b();

    /* renamed from: f  reason: collision with root package name */
    public final TextInputLayout.g f3053f = new c();

    public class a extends j {
        public a() {
        }

        @Override // f.b.a.e.p.j
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            r rVar = r.this;
            rVar.c.setChecked(!r.e(rVar));
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
            rVar.c.setChecked(!r.e(rVar));
            editText.removeTextChangedListener(r.this.f3051d);
            editText.addTextChangedListener(r.this.f3051d);
        }
    }

    public class c implements TextInputLayout.g {

        public class a implements Runnable {
            public final /* synthetic */ EditText b;

            public a(EditText editText) {
                this.b = editText;
            }

            public void run() {
                this.b.removeTextChangedListener(r.this.f3051d);
            }
        }

        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i2 == 1) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                editText.post(new a(editText));
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            EditText editText = r.this.a.getEditText();
            if (editText != null) {
                int selectionEnd = editText.getSelectionEnd();
                editText.setTransformationMethod(r.e(r.this) ? null : PasswordTransformationMethod.getInstance());
                if (selectionEnd >= 0) {
                    editText.setSelection(selectionEnd);
                }
                r.this.a.o();
            }
        }
    }

    public r(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public static boolean e(r rVar) {
        EditText editText = rVar.a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // f.b.a.e.x.m
    public void a() {
        this.a.setEndIconDrawable(e.b.b.a.a.b(this.b, R$drawable.design_password_eye));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.password_toggle_content_description));
        this.a.setEndIconOnClickListener(new d());
        this.a.a(this.f3052e);
        this.a.g0.add(this.f3053f);
        EditText editText = this.a.getEditText();
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
