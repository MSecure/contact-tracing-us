package f.b.a.e.x;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.google.android.material.textfield.TextInputLayout;

public class a extends m {

    /* renamed from: d  reason: collision with root package name */
    public final TextWatcher f3021d = new C0099a();

    /* renamed from: e  reason: collision with root package name */
    public final View.OnFocusChangeListener f3022e = new b();

    /* renamed from: f  reason: collision with root package name */
    public final TextInputLayout.f f3023f = new c();

    /* renamed from: g  reason: collision with root package name */
    public final TextInputLayout.g f3024g = new d();

    /* renamed from: h  reason: collision with root package name */
    public AnimatorSet f3025h;

    /* renamed from: i  reason: collision with root package name */
    public ValueAnimator f3026i;

    /* renamed from: f.b.a.e.x.a$a  reason: collision with other inner class name */
    public class C0099a implements TextWatcher {
        public C0099a() {
        }

        public void afterTextChanged(Editable editable) {
            if (a.this.a.getSuffixText() == null) {
                a.this.e(editable.length() > 0);
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
            editText.setOnFocusChangeListener(a.this.f3022e);
            editText.removeTextChangedListener(a.this.f3021d);
            editText.addTextChangedListener(a.this.f3021d);
        }
    }

    public class d implements TextInputLayout.g {

        /* renamed from: f.b.a.e.x.a$d$a  reason: collision with other inner class name */
        public class RunnableC0100a implements Runnable {
            public final /* synthetic */ EditText b;

            public RunnableC0100a(EditText editText) {
                this.b = editText;
            }

            public void run() {
                this.b.removeTextChangedListener(a.this.f3021d);
            }
        }

        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i2 == 2) {
                editText.post(new RunnableC0100a(editText));
                if (editText.getOnFocusChangeListener() == a.this.f3022e) {
                    editText.setOnFocusChangeListener(null);
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
            a.this.a.o();
        }
    }

    public a(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // f.b.a.e.x.m
    public void a() {
        this.a.setEndIconDrawable(e.b.b.a.a.b(this.b, R$drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R$string.clear_text_end_icon_content_description));
        this.a.setEndIconOnClickListener(new e());
        this.a.a(this.f3023f);
        TextInputLayout textInputLayout2 = this.a;
        textInputLayout2.g0.add(this.f3024g);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(f.b.a.e.a.a.f2777d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new e(this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = f.b.a.e.a.a.a;
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(100L);
        ofFloat2.addUpdateListener(new d(this));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f3025h = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.f3025h.addListener(new b(this));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(timeInterpolator);
        ofFloat3.setDuration(100L);
        ofFloat3.addUpdateListener(new d(this));
        this.f3026i = ofFloat3;
        ofFloat3.addListener(new c(this));
    }

    @Override // f.b.a.e.x.m
    public void c(boolean z) {
        if (this.a.getSuffixText() != null) {
            e(z);
        }
    }

    public final void e(boolean z) {
        boolean z2 = this.a.k() == z;
        if (z && !this.f3025h.isRunning()) {
            this.f3026i.cancel();
            this.f3025h.start();
            if (z2) {
                this.f3025h.end();
            }
        } else if (!z) {
            this.f3025h.cancel();
            this.f3026i.start();
            if (z2) {
                this.f3026i.end();
            }
        }
    }
}
