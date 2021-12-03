package f.b.a.e.y;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;
import f.b.a.e.q.j;

public class r extends m {

    /* renamed from: e  reason: collision with root package name */
    public final TextWatcher f3115e = new a();

    /* renamed from: f  reason: collision with root package name */
    public final TextInputLayout.f f3116f = new b();

    /* renamed from: g  reason: collision with root package name */
    public final TextInputLayout.g f3117g = new c();

    public class a extends j {
        public a() {
        }

        @Override // f.b.a.e.q.j
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
            editText.removeTextChangedListener(r.this.f3115e);
            editText.addTextChangedListener(r.this.f3115e);
        }
    }

    public class c implements TextInputLayout.g {

        public class a implements Runnable {
            public final /* synthetic */ EditText b;

            public a(EditText editText) {
                this.b = editText;
            }

            public void run() {
                this.b.removeTextChangedListener(r.this.f3115e);
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
                r.this.a.q();
            }
        }
    }

    public r(TextInputLayout textInputLayout, int i2) {
        super(textInputLayout, i2);
    }

    public static boolean e(r rVar) {
        EditText editText = rVar.a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // f.b.a.e.y.m
    public void a() {
        TextInputLayout textInputLayout = this.a;
        int i2 = this.f3100d;
        if (i2 == 0) {
            i2 = R$drawable.design_password_eye;
        }
        textInputLayout.setEndIconDrawable(i2);
        TextInputLayout textInputLayout2 = this.a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(R$string.password_toggle_content_description));
        this.a.setEndIconOnClickListener(new d());
        this.a.a(this.f3116f);
        this.a.l0.add(this.f3117g);
        EditText editText = this.a.getEditText();
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
