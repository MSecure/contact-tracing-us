package c.b.a.b.l0;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import c.b.a.b.j;
import com.google.android.material.textfield.TextInputLayout;

public class a extends m {

    /* renamed from: d  reason: collision with root package name */
    public final TextWatcher f4354d = new C0075a();

    /* renamed from: e  reason: collision with root package name */
    public final View.OnFocusChangeListener f4355e = new b();

    /* renamed from: f  reason: collision with root package name */
    public final TextInputLayout.f f4356f = new c();

    /* renamed from: g  reason: collision with root package name */
    public final TextInputLayout.g f4357g = new d();
    public AnimatorSet h;
    public ValueAnimator i;

    /* renamed from: c.b.a.b.l0.a$a  reason: collision with other inner class name */
    public class C0075a implements TextWatcher {
        public C0075a() {
        }

        public void afterTextChanged(Editable editable) {
            if (a.this.f4384a.getSuffixText() == null) {
                a.this.e(editable.length() > 0);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        public void onFocusChange(View view, boolean z) {
            boolean z2 = true;
            boolean z3 = !TextUtils.isEmpty(((EditText) view).getText());
            a aVar = a.this;
            if (!z3 || !z) {
                z2 = false;
            }
            aVar.e(z2);
        }
    }

    public class c implements TextInputLayout.f {
        public c() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
            if ((r0.getText().length() > 0) != false) goto L_0x001d;
         */
        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            boolean z = true;
            if (editText.hasFocus()) {
            }
            z = false;
            textInputLayout.setEndIconVisible(z);
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.f4355e);
            editText.removeTextChangedListener(a.this.f4354d);
            editText.addTextChangedListener(a.this.f4354d);
        }
    }

    public class d implements TextInputLayout.g {
        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i == 2) {
                editText.removeTextChangedListener(a.this.f4354d);
                if (editText.getOnFocusChangeListener() == a.this.f4355e) {
                    editText.setOnFocusChangeListener(null);
                }
            }
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            Editable text = a.this.f4384a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.f4384a.o();
        }
    }

    public a(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // c.b.a.b.l0.m
    public void a() {
        this.f4384a.setEndIconDrawable(b.b.l.a.a.b(this.f4385b, c.b.a.b.e.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.f4384a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(j.clear_text_end_icon_content_description));
        this.f4384a.setEndIconOnClickListener(new e());
        this.f4384a.a(this.f4356f);
        TextInputLayout textInputLayout2 = this.f4384a;
        textInputLayout2.g0.add(this.f4357g);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(c.b.a.b.m.a.f4413d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new e(this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setInterpolator(c.b.a.b.m.a.f4410a);
        ofFloat2.setDuration(100L);
        ofFloat2.addUpdateListener(new d(this));
        AnimatorSet animatorSet = new AnimatorSet();
        this.h = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.h.addListener(new b(this));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(c.b.a.b.m.a.f4410a);
        ofFloat3.setDuration(100L);
        ofFloat3.addUpdateListener(new d(this));
        this.i = ofFloat3;
        ofFloat3.addListener(new c(this));
    }

    @Override // c.b.a.b.l0.m
    public void c(boolean z) {
        if (this.f4384a.getSuffixText() != null) {
            e(z);
        }
    }

    public final void e(boolean z) {
        boolean z2 = this.f4384a.k() == z;
        if (z) {
            this.i.cancel();
            this.h.start();
            if (z2) {
                this.h.end();
                return;
            }
            return;
        }
        this.h.cancel();
        this.i.start();
        if (z2) {
            this.i.end();
        }
    }
}
