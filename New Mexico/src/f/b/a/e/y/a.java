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
/* loaded from: classes.dex */
public class a extends m {

    /* renamed from: e */
    public final TextWatcher f3127e = new C0101a();

    /* renamed from: f */
    public final View.OnFocusChangeListener f3128f = new b();

    /* renamed from: g */
    public final TextInputLayout.f f3129g = new c();

    /* renamed from: h */
    public final TextInputLayout.g f3130h = new d();

    /* renamed from: i */
    public AnimatorSet f3131i;

    /* renamed from: j */
    public ValueAnimator f3132j;

    /* renamed from: f.b.a.e.y.a$a */
    /* loaded from: classes.dex */
    public class C0101a implements TextWatcher {
        public C0101a() {
            a.this = r1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (a.this.a.getSuffixText() == null) {
                a aVar = a.this;
                aVar.f(a.e(aVar));
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
            a.this = r1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            a aVar = a.this;
            aVar.f(a.e(aVar));
        }
    }

    /* loaded from: classes.dex */
    public class c implements TextInputLayout.f {
        public c() {
            a.this = r1;
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(a.e(a.this));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.f3128f);
            a aVar = a.this;
            aVar.c.setOnFocusChangeListener(aVar.f3128f);
            editText.removeTextChangedListener(a.this.f3127e);
            editText.addTextChangedListener(a.this.f3127e);
        }
    }

    /* loaded from: classes.dex */
    public class d implements TextInputLayout.g {

        /* renamed from: f.b.a.e.y.a$d$a */
        /* loaded from: classes.dex */
        public class RunnableC0102a implements Runnable {
            public final /* synthetic */ EditText b;

            public RunnableC0102a(EditText editText) {
                d.this = r1;
                this.b = editText;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.b.removeTextChangedListener(a.this.f3127e);
            }
        }

        public d() {
            a.this = r1;
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i2 == 2) {
                editText.post(new RunnableC0102a(editText));
                if (editText.getOnFocusChangeListener() == a.this.f3128f) {
                    editText.setOnFocusChangeListener(null);
                }
                View.OnFocusChangeListener onFocusChangeListener = a.this.c.getOnFocusChangeListener();
                a aVar = a.this;
                if (onFocusChangeListener == aVar.f3128f) {
                    aVar.c.setOnFocusChangeListener(null);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        public e() {
            a.this = r1;
        }

        @Override // android.view.View.OnClickListener
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
        int i2 = this.f3142d;
        if (i2 == 0) {
            i2 = R$drawable.mtrl_ic_cancel;
        }
        textInputLayout.setEndIconDrawable(i2);
        TextInputLayout textInputLayout2 = this.a;
        textInputLayout2.setEndIconContentDescription(textInputLayout2.getResources().getText(R$string.clear_text_end_icon_content_description));
        this.a.setEndIconOnClickListener(new e());
        this.a.a(this.f3129g);
        this.a.k0.add(this.f3130h);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(f.b.a.e.a.a.f2873d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new e(this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = f.b.a.e.a.a.a;
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(100L);
        ofFloat2.addUpdateListener(new d(this));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f3131i = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.f3131i.addListener(new b(this));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(timeInterpolator);
        ofFloat3.setDuration(100L);
        ofFloat3.addUpdateListener(new d(this));
        this.f3132j = ofFloat3;
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
        if (z && !this.f3131i.isRunning()) {
            this.f3132j.cancel();
            this.f3131i.start();
            if (z2) {
                this.f3131i.end();
            }
        } else if (!z) {
            this.f3131i.cancel();
            this.f3132j.start();
            if (z2) {
                this.f3132j.end();
            }
        }
    }
}
