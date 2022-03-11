package f.b.a.e.y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R$dimen;
import com.google.android.material.textfield.TextInputLayout;
import e.j.j.v;
import f.b.a.c.b.o.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class n {
    public final Context a;
    public final TextInputLayout b;
    public LinearLayout c;

    /* renamed from: d  reason: collision with root package name */
    public int f3143d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f3144e;

    /* renamed from: f  reason: collision with root package name */
    public Animator f3145f;

    /* renamed from: g  reason: collision with root package name */
    public final float f3146g;

    /* renamed from: h  reason: collision with root package name */
    public int f3147h;

    /* renamed from: i  reason: collision with root package name */
    public int f3148i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f3149j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3150k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f3151l;
    public CharSequence m;
    public int n;
    public ColorStateList o;
    public CharSequence p;
    public boolean q;
    public TextView r;
    public int s;
    public ColorStateList t;
    public Typeface u;

    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ int a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ int c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TextView f3152d;

        public a(int i2, TextView textView, int i3, TextView textView2) {
            this.a = i2;
            this.b = textView;
            this.c = i3;
            this.f3152d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            TextView textView;
            n nVar = n.this;
            nVar.f3147h = this.a;
            nVar.f3145f = null;
            TextView textView2 = this.b;
            if (textView2 != null) {
                textView2.setVisibility(4);
                if (this.c == 1 && (textView = n.this.f3151l) != null) {
                    textView.setText((CharSequence) null);
                }
            }
            TextView textView3 = this.f3152d;
            if (textView3 != null) {
                textView3.setTranslationY(0.0f);
                this.f3152d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f3152d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public n(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.a = context;
        this.b = textInputLayout;
        this.f3146g = (float) context.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
    }

    public void a(TextView textView, int i2) {
        if (this.c == null && this.f3144e == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            this.c = linearLayout;
            linearLayout.setOrientation(0);
            this.b.addView(this.c, -1, -2);
            this.f3144e = new FrameLayout(this.a);
            this.c.addView(this.f3144e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.b.getEditText() != null) {
                b();
            }
        }
        if (i2 == 0 || i2 == 1) {
            this.f3144e.setVisibility(0);
            this.f3144e.addView(textView);
        } else {
            this.c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.c.setVisibility(0);
        this.f3143d++;
    }

    public void b() {
        if ((this.c == null || this.b.getEditText() == null) ? false : true) {
            EditText editText = this.b.getEditText();
            boolean U0 = b.U0(this.a);
            LinearLayout linearLayout = this.c;
            int i2 = R$dimen.material_helper_text_font_1_3_padding_horizontal;
            AtomicInteger atomicInteger = v.a;
            v.e.k(linearLayout, h(U0, i2, v.e.f(editText)), h(U0, R$dimen.material_helper_text_font_1_3_padding_top, this.a.getResources().getDimensionPixelSize(R$dimen.material_helper_text_default_padding_top)), h(U0, i2, v.e.e(editText)), 0);
        }
    }

    public void c() {
        Animator animator = this.f3145f;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void d(List<Animator> list, boolean z, TextView textView, int i2, int i3, int i4) {
        if (textView != null && z) {
            if (i2 == i4 || i2 == i3) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, i4 == i2 ? 1.0f : 0.0f);
                ofFloat.setDuration(167L);
                ofFloat.setInterpolator(f.b.a.e.a.a.a);
                list.add(ofFloat);
                if (i4 == i2) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.f3146g, 0.0f);
                    ofFloat2.setDuration(217L);
                    ofFloat2.setInterpolator(f.b.a.e.a.a.f2873d);
                    list.add(ofFloat2);
                }
            }
        }
    }

    public boolean e() {
        return this.f3148i == 1 && this.f3151l != null && !TextUtils.isEmpty(this.f3149j);
    }

    public final TextView f(int i2) {
        if (i2 == 1) {
            return this.f3151l;
        }
        if (i2 != 2) {
            return null;
        }
        return this.r;
    }

    public int g() {
        TextView textView = this.f3151l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public final int h(boolean z, int i2, int i3) {
        return z ? this.a.getResources().getDimensionPixelSize(i2) : i3;
    }

    public void i() {
        this.f3149j = null;
        c();
        if (this.f3147h == 1) {
            this.f3148i = (!this.q || TextUtils.isEmpty(this.p)) ? 0 : 2;
        }
        l(this.f3147h, this.f3148i, k(this.f3151l, null));
    }

    public void j(TextView textView, int i2) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.c;
        if (linearLayout != null) {
            if (!(i2 == 0 || i2 == 1) || (frameLayout = this.f3144e) == null) {
                linearLayout.removeView(textView);
            } else {
                frameLayout.removeView(textView);
            }
            int i3 = this.f3143d - 1;
            this.f3143d = i3;
            LinearLayout linearLayout2 = this.c;
            if (i3 == 0) {
                linearLayout2.setVisibility(8);
            }
        }
    }

    public final boolean k(TextView textView, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.b;
        AtomicInteger atomicInteger = v.a;
        return v.g.c(textInputLayout) && this.b.isEnabled() && (this.f3148i != this.f3147h || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    public final void l(int i2, int i3, boolean z) {
        TextView f2;
        TextView f3;
        if (i2 != i3) {
            if (z) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f3145f = animatorSet;
                ArrayList arrayList = new ArrayList();
                d(arrayList, this.q, this.r, 2, i2, i3);
                d(arrayList, this.f3150k, this.f3151l, 1, i2, i3);
                b.h1(animatorSet, arrayList);
                animatorSet.addListener(new a(i3, f(i2), i2, f(i3)));
                animatorSet.start();
            } else if (i2 != i3) {
                if (!(i3 == 0 || (f3 = f(i3)) == null)) {
                    f3.setVisibility(0);
                    f3.setAlpha(1.0f);
                }
                if (!(i2 == 0 || (f2 = f(i2)) == null)) {
                    f2.setVisibility(4);
                    if (i2 == 1) {
                        f2.setText((CharSequence) null);
                    }
                }
                this.f3147h = i3;
            }
            this.b.y();
            this.b.A(z, false);
            this.b.H();
        }
    }
}
