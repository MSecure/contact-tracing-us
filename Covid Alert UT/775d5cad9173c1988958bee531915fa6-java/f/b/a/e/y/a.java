package f.b.a.e.y;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;

public class a extends m {

    /* renamed from: e  reason: collision with root package name */
    public final TextWatcher f3085e = new C0099a();

    /* renamed from: f  reason: collision with root package name */
    public final View.OnFocusChangeListener f3086f = new b();

    /* renamed from: g  reason: collision with root package name */
    public final TextInputLayout.f f3087g = new c();

    /* renamed from: h  reason: collision with root package name */
    public final TextInputLayout.g f3088h = new d();

    /* renamed from: i  reason: collision with root package name */
    public AnimatorSet f3089i;

    /* renamed from: j  reason: collision with root package name */
    public ValueAnimator f3090j;

    /* renamed from: f.b.a.e.y.a$a  reason: collision with other inner class name */
    public class C0099a implements TextWatcher {
        public C0099a() {
        }

        public void afterTextChanged(Editable editable) {
            if (a.this.a.getSuffixText() == null) {
                a aVar = a.this;
                aVar.f(a.e(aVar));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        public void onFocusChange(View view, boolean z) {
            a aVar = a.this;
            aVar.f(a.e(aVar));
        }
    }

    public class c implements TextInputLayout.f {
        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(a.e(a.this));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.f3086f);
            a aVar = a.this;
            aVar.c.setOnFocusChangeListener(aVar.f3086f);
            editText.removeTextChangedListener(a.this.f3085e);
            editText.addTextChangedListener(a.this.f3085e);
        }
    }

    public class d implements TextInputLayout.g {

        /* renamed from: f.b.a.e.y.a$d$a  reason: collision with other inner class name */
        public class RunnableC0100a implements Runnable {
            public final /* synthetic */ EditText b;

            public RunnableC0100a(EditText editText) {
                this.b = editText;
            }

            public void run() {
                this.b.removeTextChangedListener(a.this.f3085e);
            }
        }

        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i2 == 2) {
                editText.post(new RunnableC0100a(editText));
                if (editText.getOnFocusChangeListener() == a.this.f3086f) {
                    editText.setOnFocusChangeListener(null);
                }
                View.OnFocusChangeListener onFocusChangeListener = a.this.c.getOnFocusChangeListener();
                a aVar = a.this;
                if (onFocusChangeListener == aVar.f3086f) {
                    aVar.c.setOnFocusChangeListener(null);
                }
            }
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            Editable text = a.this.a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            a.this.a.q();
        }
    }

    public a(TextInputLayout textInputLayout, int i2) {
        super(textInputLayout, i2);
    }

    public static boolean e(a aVar) {
        EditText editText = aVar.a.getEditText();
        return editText != null && (editText.hasFocus() || aVar.c.hasFocus()) && editText.getText().length() > 0;
    }

    @Override // f.b.a.e.y.m
    public void a() {
        TextInputLayout textInputLayout = this.a;
        int i2 = this.f3100d;
        if (i2 == 0) {
            i2 = R$drawable.mtrl_ic_cancel;
        }
        textInputLayout.setEndIconDrawable(i2);
        TextInputLayout textInputLayout2 = this.a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(R$string.clear_text_end_icon_content_description));
        this.a.setEndIconOnClickListener(new e());
        this.a.a(this.f3087g);
        TextInputLayout textInputLayout3 = this.a;
        textInputLayout3.l0.add(this.f3088h);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(f.b.a.e.a.a.f2831d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new e(this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = f.b.a.e.a.a.a;
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(100L);
        ofFloat2.addUpdateListener(new d(this));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f3089i = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.f3089i.addListener(new b(this));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(timeInterpolator);
        ofFloat3.setDuration(100L);
        ofFloat3.addUpdateListener(new d(this));
        this.f3090j = ofFloat3;
        ofFloat3.addListener(new c(this));
    }

    @Override // f.b.a.e.y.m
    public void c(boolean z) {
        if (this.a.getSuffixText() != null) {
            f(z);
        }
    }

    public final void f(boolean z) {
        boolean z2 = this.a.m() == z;
        if (z && !this.f3089i.isRunning()) {
            this.f3090j.cancel();
            this.f3089i.start();
            if (z2) {
                this.f3089i.end();
            }
        } else if (!z) {
            this.f3089i.cancel();
            this.f3090j.start();
            if (z2) {
                this.f3090j.end();
            }
        }
    }
}
