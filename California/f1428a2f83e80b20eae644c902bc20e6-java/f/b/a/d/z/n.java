package f.b.a.d.z;

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
import e.i.i.l;
import f.b.a.c.b.o.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class n {
    public final Context a;
    public final TextInputLayout b;
    public LinearLayout c;

    /* renamed from: d  reason: collision with root package name */
    public int f2840d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f2841e;

    /* renamed from: f  reason: collision with root package name */
    public Animator f2842f;

    /* renamed from: g  reason: collision with root package name */
    public final float f2843g;

    /* renamed from: h  reason: collision with root package name */
    public int f2844h;

    /* renamed from: i  reason: collision with root package name */
    public int f2845i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f2846j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2847k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f2848l;
    public CharSequence m;
    public int n;
    public ColorStateList o;
    public CharSequence p;
    public boolean q;
    public TextView r;
    public int s;
    public ColorStateList t;
    public Typeface u;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ int a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ int c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TextView f2849d;

        public a(int i2, TextView textView, int i3, TextView textView2) {
            this.a = i2;
            this.b = textView;
            this.c = i3;
            this.f2849d = textView2;
        }

        public void onAnimationEnd(Animator animator) {
            TextView textView;
            n nVar = n.this;
            nVar.f2844h = this.a;
            nVar.f2842f = null;
            TextView textView2 = this.b;
            if (textView2 != null) {
                textView2.setVisibility(4);
                if (this.c == 1 && (textView = n.this.f2848l) != null) {
                    textView.setText((CharSequence) null);
                }
            }
            TextView textView3 = this.f2849d;
            if (textView3 != null) {
                textView3.setTranslationY(0.0f);
                this.f2849d.setAlpha(1.0f);
            }
        }

        public void onAnimationStart(Animator animator) {
            TextView textView = this.f2849d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public n(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.a = context;
        this.b = textInputLayout;
        this.f2843g = (float) context.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
    }

    public void a(TextView textView, int i2) {
        if (this.c == null && this.f2841e == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            this.c = linearLayout;
            linearLayout.setOrientation(0);
            this.b.addView(this.c, -1, -2);
            this.f2841e = new FrameLayout(this.a);
            this.c.addView(this.f2841e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.b.getEditText() != null) {
                b();
            }
        }
        if (i2 == 0 || i2 == 1) {
            this.f2841e.setVisibility(0);
            this.f2841e.addView(textView);
        } else {
            this.c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.c.setVisibility(0);
        this.f2840d++;
    }

    public void b() {
        if ((this.c == null || this.b.getEditText() == null) ? false : true) {
            EditText editText = this.b.getEditText();
            boolean e1 = b.e1(this.a);
            LinearLayout linearLayout = this.c;
            int i2 = R$dimen.material_helper_text_font_1_3_padding_horizontal;
            AtomicInteger atomicInteger = l.a;
            linearLayout.setPaddingRelative(h(e1, i2, editText.getPaddingStart()), h(e1, R$dimen.material_helper_text_font_1_3_padding_top, 0), h(e1, i2, editText.getPaddingEnd()), 0);
        }
    }

    public void c() {
        Animator animator = this.f2842f;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void d(List<Animator> list, boolean z, TextView textView, int i2, int i3, int i4) {
        if (textView != null && z) {
            if (i2 == i4 || i2 == i3) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, i4 == i2 ? 1.0f : 0.0f);
                ofFloat.setDuration(167L);
                ofFloat.setInterpolator(f.b.a.d.a.a.a);
                list.add(ofFloat);
                if (i4 == i2) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.f2843g, 0.0f);
                    ofFloat2.setDuration(217L);
                    ofFloat2.setInterpolator(f.b.a.d.a.a.f2545d);
                    list.add(ofFloat2);
                }
            }
        }
    }

    public boolean e() {
        return this.f2845i == 1 && this.f2848l != null && !TextUtils.isEmpty(this.f2846j);
    }

    public final TextView f(int i2) {
        if (i2 == 1) {
            return this.f2848l;
        }
        if (i2 != 2) {
            return null;
        }
        return this.r;
    }

    public int g() {
        TextView textView = this.f2848l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public final int h(boolean z, int i2, int i3) {
        return z ? this.a.getResources().getDimensionPixelSize(i2) : i3;
    }

    public void i() {
        this.f2846j = null;
        c();
        if (this.f2844h == 1) {
            this.f2845i = (!this.q || TextUtils.isEmpty(this.p)) ? 0 : 2;
        }
        l(this.f2844h, this.f2845i, k(this.f2848l, null));
    }

    public void j(TextView textView, int i2) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.c;
        if (linearLayout != null) {
            if (!(i2 == 0 || i2 == 1) || (frameLayout = this.f2841e) == null) {
                linearLayout.removeView(textView);
            } else {
                frameLayout.removeView(textView);
            }
            int i3 = this.f2840d - 1;
            this.f2840d = i3;
            LinearLayout linearLayout2 = this.c;
            if (i3 == 0) {
                linearLayout2.setVisibility(8);
            }
        }
    }

    public final boolean k(TextView textView, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.b;
        AtomicInteger atomicInteger = l.a;
        return textInputLayout.isLaidOut() && this.b.isEnabled() && (this.f2845i != this.f2844h || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    public final void l(int i2, int i3, boolean z) {
        TextView f2;
        TextView f3;
        if (i2 != i3) {
            if (z) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f2842f = animatorSet;
                ArrayList arrayList = new ArrayList();
                d(arrayList, this.q, this.r, 2, i2, i3);
                d(arrayList, this.f2847k, this.f2848l, 1, i2, i3);
                b.w1(animatorSet, arrayList);
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
                this.f2844h = i3;
            }
            this.b.w();
            this.b.y(z, false);
            this.b.F();
        }
    }
}
