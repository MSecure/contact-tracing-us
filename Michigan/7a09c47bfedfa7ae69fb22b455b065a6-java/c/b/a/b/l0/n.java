package c.b.a.b.l0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.i.l.m;
import b.x.t;
import c.b.a.b.d;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4387a;

    /* renamed from: b  reason: collision with root package name */
    public final TextInputLayout f4388b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f4389c;

    /* renamed from: d  reason: collision with root package name */
    public int f4390d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f4391e;

    /* renamed from: f  reason: collision with root package name */
    public int f4392f;

    /* renamed from: g  reason: collision with root package name */
    public Animator f4393g;
    public final float h;
    public int i;
    public int j;
    public CharSequence k;
    public boolean l;
    public TextView m;
    public CharSequence n;
    public int o;
    public ColorStateList p;
    public CharSequence q;
    public boolean r;
    public TextView s;
    public int t;
    public ColorStateList u;
    public Typeface v;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f4394a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f4395b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4396c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TextView f4397d;

        public a(int i, TextView textView, int i2, TextView textView2) {
            this.f4394a = i;
            this.f4395b = textView;
            this.f4396c = i2;
            this.f4397d = textView2;
        }

        public void onAnimationEnd(Animator animator) {
            TextView textView;
            n nVar = n.this;
            nVar.i = this.f4394a;
            nVar.f4393g = null;
            TextView textView2 = this.f4395b;
            if (textView2 != null) {
                textView2.setVisibility(4);
                if (this.f4396c == 1 && (textView = n.this.m) != null) {
                    textView.setText((CharSequence) null);
                }
            }
            TextView textView3 = this.f4397d;
            if (textView3 != null) {
                textView3.setTranslationY(0.0f);
                this.f4397d.setAlpha(1.0f);
            }
        }

        public void onAnimationStart(Animator animator) {
            TextView textView = this.f4397d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public n(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f4387a = context;
        this.f4388b = textInputLayout;
        this.h = (float) context.getResources().getDimensionPixelSize(d.design_textinput_caption_translate_y);
    }

    public void a(TextView textView, int i2) {
        if (this.f4389c == null && this.f4391e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f4387a);
            this.f4389c = linearLayout;
            linearLayout.setOrientation(0);
            this.f4388b.addView(this.f4389c, -1, -2);
            this.f4391e = new FrameLayout(this.f4387a);
            this.f4389c.addView(this.f4391e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f4388b.getEditText() != null) {
                b();
            }
        }
        if (i2 == 0 || i2 == 1) {
            this.f4391e.setVisibility(0);
            this.f4391e.addView(textView);
            this.f4392f++;
        } else {
            this.f4389c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f4389c.setVisibility(0);
        this.f4390d++;
    }

    public void b() {
        if ((this.f4389c == null || this.f4388b.getEditText() == null) ? false : true) {
            this.f4389c.setPaddingRelative(m.t(this.f4388b.getEditText()), 0, this.f4388b.getEditText().getPaddingEnd(), 0);
        }
    }

    public void c() {
        Animator animator = this.f4393g;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void d(List<Animator> list, boolean z, TextView textView, int i2, int i3, int i4) {
        if (textView != null && z) {
            if (i2 == i4 || i2 == i3) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, i4 == i2 ? 1.0f : 0.0f);
                ofFloat.setDuration(167L);
                ofFloat.setInterpolator(c.b.a.b.m.a.f4410a);
                list.add(ofFloat);
                if (i4 == i2) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.h, 0.0f);
                    ofFloat2.setDuration(217L);
                    ofFloat2.setInterpolator(c.b.a.b.m.a.f4413d);
                    list.add(ofFloat2);
                }
            }
        }
    }

    public boolean e() {
        return this.j == 1 && this.m != null && !TextUtils.isEmpty(this.k);
    }

    public final TextView f(int i2) {
        if (i2 == 1) {
            return this.m;
        }
        if (i2 != 2) {
            return null;
        }
        return this.s;
    }

    public int g() {
        TextView textView = this.m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public void h() {
        this.k = null;
        c();
        if (this.i == 1) {
            this.j = (!this.r || TextUtils.isEmpty(this.q)) ? 0 : 2;
        }
        k(this.i, this.j, j(this.m, null));
    }

    public void i(TextView textView, int i2) {
        FrameLayout frameLayout;
        if (this.f4389c != null) {
            if (!(i2 == 0 || i2 == 1) || (frameLayout = this.f4391e) == null) {
                this.f4389c.removeView(textView);
            } else {
                int i3 = this.f4392f - 1;
                this.f4392f = i3;
                if (i3 == 0) {
                    frameLayout.setVisibility(8);
                }
                this.f4391e.removeView(textView);
            }
            int i4 = this.f4390d - 1;
            this.f4390d = i4;
            LinearLayout linearLayout = this.f4389c;
            if (i4 == 0) {
                linearLayout.setVisibility(8);
            }
        }
    }

    public final boolean j(TextView textView, CharSequence charSequence) {
        return m.C(this.f4388b) && this.f4388b.isEnabled() && (this.j != this.i || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    public final void k(int i2, int i3, boolean z) {
        TextView f2;
        TextView f3;
        if (i2 != i3) {
            if (z) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f4393g = animatorSet;
                ArrayList arrayList = new ArrayList();
                d(arrayList, this.r, this.s, 2, i2, i3);
                d(arrayList, this.l, this.m, 1, i2, i3);
                t.n2(animatorSet, arrayList);
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
                this.i = i3;
            }
            this.f4388b.w();
            this.f4388b.y(z, false);
            this.f4388b.F();
        }
    }
}
