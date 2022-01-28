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
import c.b.a.a.c.n.c;
import c.b.a.b.d;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3090a;

    /* renamed from: b  reason: collision with root package name */
    public final TextInputLayout f3091b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f3092c;

    /* renamed from: d  reason: collision with root package name */
    public int f3093d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f3094e;
    public int f;
    public Animator g;
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
        public final /* synthetic */ int f3095a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TextView f3096b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3097c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ TextView f3098d;

        public a(int i, TextView textView, int i2, TextView textView2) {
            this.f3095a = i;
            this.f3096b = textView;
            this.f3097c = i2;
            this.f3098d = textView2;
        }

        public void onAnimationEnd(Animator animator) {
            TextView textView;
            n nVar = n.this;
            nVar.i = this.f3095a;
            nVar.g = null;
            TextView textView2 = this.f3096b;
            if (textView2 != null) {
                textView2.setVisibility(4);
                if (this.f3097c == 1 && (textView = n.this.m) != null) {
                    textView.setText((CharSequence) null);
                }
            }
            TextView textView3 = this.f3098d;
            if (textView3 != null) {
                textView3.setTranslationY(0.0f);
                this.f3098d.setAlpha(1.0f);
            }
        }

        public void onAnimationStart(Animator animator) {
            TextView textView = this.f3098d;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
    }

    public n(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f3090a = context;
        this.f3091b = textInputLayout;
        this.h = (float) context.getResources().getDimensionPixelSize(d.design_textinput_caption_translate_y);
    }

    public void a(TextView textView, int i2) {
        if (this.f3092c == null && this.f3094e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f3090a);
            this.f3092c = linearLayout;
            linearLayout.setOrientation(0);
            this.f3091b.addView(this.f3092c, -1, -2);
            this.f3094e = new FrameLayout(this.f3090a);
            this.f3092c.addView(this.f3094e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f3091b.getEditText() != null) {
                b();
            }
        }
        if (i2 == 0 || i2 == 1) {
            this.f3094e.setVisibility(0);
            this.f3094e.addView(textView);
            this.f++;
        } else {
            this.f3092c.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f3092c.setVisibility(0);
        this.f3093d++;
    }

    public void b() {
        if ((this.f3092c == null || this.f3091b.getEditText() == null) ? false : true) {
            this.f3092c.setPaddingRelative(m.s(this.f3091b.getEditText()), 0, this.f3091b.getEditText().getPaddingEnd(), 0);
        }
    }

    public void c() {
        Animator animator = this.g;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void d(List<Animator> list, boolean z, TextView textView, int i2, int i3, int i4) {
        if (textView != null && z) {
            if (i2 == i4 || i2 == i3) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, i4 == i2 ? 1.0f : 0.0f);
                ofFloat.setDuration(167L);
                ofFloat.setInterpolator(c.b.a.b.m.a.f3108a);
                list.add(ofFloat);
                if (i4 == i2) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, -this.h, 0.0f);
                    ofFloat2.setDuration(217L);
                    ofFloat2.setInterpolator(c.b.a.b.m.a.f3111d);
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
        if (this.f3092c != null) {
            if (!(i2 == 0 || i2 == 1) || (frameLayout = this.f3094e) == null) {
                this.f3092c.removeView(textView);
            } else {
                int i3 = this.f - 1;
                this.f = i3;
                if (i3 == 0) {
                    frameLayout.setVisibility(8);
                }
                this.f3094e.removeView(textView);
            }
            int i4 = this.f3093d - 1;
            this.f3093d = i4;
            LinearLayout linearLayout = this.f3092c;
            if (i4 == 0) {
                linearLayout.setVisibility(8);
            }
        }
    }

    public final boolean j(TextView textView, CharSequence charSequence) {
        return m.B(this.f3091b) && this.f3091b.isEnabled() && (this.j != this.i || textView == null || !TextUtils.equals(textView.getText(), charSequence));
    }

    public final void k(int i2, int i3, boolean z) {
        TextView f2;
        TextView f3;
        if (i2 != i3) {
            if (z) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.g = animatorSet;
                ArrayList arrayList = new ArrayList();
                d(arrayList, this.r, this.s, 2, i2, i3);
                d(arrayList, this.l, this.m, 1, i2, i3);
                c.O1(animatorSet, arrayList);
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
            this.f3091b.w();
            this.f3091b.z(z, false);
            this.f3091b.G();
        }
    }
}
