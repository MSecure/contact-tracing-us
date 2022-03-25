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
import e.i.i.m;
import f.b.a.c.b.o.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class n {
    public final Context a;
    public final TextInputLayout b;
    public LinearLayout c;

    /* renamed from: d  reason: collision with root package name */
    public int f2944d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f2945e;

    /* renamed from: f  reason: collision with root package name */
    public Animator f2946f;

    /* renamed from: g  reason: collision with root package name */
    public final float f2947g;

    /* renamed from: h  reason: collision with root package name */
    public int f2948h;

    /* renamed from: i  reason: collision with root package name */
    public int f2949i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f2950j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2951k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f2952l;
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
        public final /* synthetic */ TextView f2953d;

        public a(int i2, TextView textView, int i3, TextView textView2) {
            this.a = i2;
            this.b = textView;
            this.c = i3;
            this.f2953d = textView2;
        }

        public void onAnimationEnd(Animator animator) {
            TextView textView;
            n nVar = n.this;
            nVar.f2948h = this.a;
            nVar.f2946f = null;
            TextView textView2 = this.b;
            if (textView2 != null) {
                textView2.setVisibility(4);
                if (this.c == 1 && (textView = n.this.f2952l) != null) {
                    textView.setText((CharSequence) null);
                }
            }
            TextView textView3 = this.f2953d;
            if (textView3 != null) {
                textView3.setTranslationY(0.0f);
                this.f2953d.setAlpha(1.0f);
            }
        }

        public void onAnimationStart(Animator animator) {
            TextView textView = this.f2953d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public n(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.a = context;
        this.b = textInputLayout;
        this.f2947g = (float) context.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
    }

    public void a(TextView textView, int i2) {
        if (this.c == null && this.f2945e == null) {
            LinearLayout linearLayout = new LinearLayout(this.a);
            this.c = linearLayout;
            linearLayout.setOrientation(0);
            this.b.addView(this.c, -1, -2);
            this.f2945e = new FrameLayout(this.a);
            this.c.addView(this.f2945e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.b.getEditText() != null) {
                b();
            }
        }
        if (i2 == 0 || i2 == 1) {
            this.f2945e.setVisibility(0);
            this.f2945e.addView(textView);
        } else {
            this.c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.c.setVisibility(0);
        this.f2944d++;
    }

    public void b() {
        if ((this.c == null || this.b.getEditText() == null) ? false : true) {
            EditText editText = this.b.getEditText();
            boolean f1 = b.f1(this.a);
            LinearLayout linearLayout = this.c;
            int i2 = R$dimen.material_helper_text_font_1_3_padding_horizontal;
            AtomicInteger atomicInteger = m.a;
            linearLayout.setPaddingRelative(h(f1, i2, editText.getPaddingStart()), h(f1, R$dimen.material_helper_text_font_1_3_padding_top, this.a.getResources().getDimensionPixelSize(R$dimen.material_helper_text_default_padding_top)), h(f1, i2, editText.getPaddingEnd()), 0);
        }
    }

    public void c() {
        Animator animator = this.f2946f;
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
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.f2947g, 0.0f);
                    ofFloat2.setDuration(217L);
                    ofFloat2.setInterpolator(f.b.a.d.a.a.f2653d);
                    list.add(ofFloat2);
                }
            }
        }
    }

    public boolean e() {
        return this.f2949i == 1 && this.f2952l != null && !TextUtils.isEmpty(this.f2950j);
    }

    public final TextView f(int i2) {
        if (i2 == 1) {
            return this.f2952l;
        }
        if (i2 != 2) {
            return null;
        }
        return this.r;
    }

    public int g() {
        TextView textView = this.f2952l;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public final int h(boolean z, int i2, int i3) {
        return z ? this.a.getResources().getDimensionPixelSize(i2) : i3;
    }

    public void i() {
        this.f2950j = null;
        c();
        if (this.f2948h == 1) {
            this.f2949i = (!this.q || TextUtils.isEmpty(this.p)) ? 0 : 2;
        }
        l(this.f2948h, this.f2949i, k(this.f2952l, null));
    }

    public void j(TextView textView, int i2) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.c;
        if (linearLayout != null) {
            if (!(i2 == 0 || i2 == 1) || (frameLayout = this.f2945e) == null) {
                linearLayout.removeView(textView);
            } else {
                frameLayout.removeView(textView);
            }
            int i3 = this.f2944d - 1;
            this.f2944d = i3;
            LinearLayout linearLayout2 = this.c;
            if (i3 == 0) {
                linearLayout2.setVisibility(8);
            }
        }
    }

    public final boolean k(TextView textView, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.b;
        AtomicInteger atomicInteger = m.a;
        return textInputLayout.isLaidOut() && this.b.isEnabled() && (this.f2949i != this.f2948h || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    public final void l(int i2, int i3, boolean z) {
        TextView f2;
        TextView f3;
        if (i2 != i3) {
            if (z) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f2946f = animatorSet;
                ArrayList arrayList = new ArrayList();
                d(arrayList, this.q, this.r, 2, i2, i3);
                d(arrayList, this.f2951k, this.f2952l, 1, i2, i3);
                b.v1(animatorSet, arrayList);
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
                this.f2948h = i3;
            }
            this.b.w();
            this.b.y(z, false);
            this.b.F();
        }
    }
}
