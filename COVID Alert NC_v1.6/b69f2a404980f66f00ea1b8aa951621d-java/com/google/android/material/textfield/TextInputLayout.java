package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.b.q.e0;
import b.b.q.y0;
import b.b.q.z;
import c.b.a.b.c0.i;
import c.b.a.b.h0.j;
import c.b.a.b.k;
import c.b.a.b.l;
import c.b.a.b.l0.m;
import c.b.a.b.l0.n;
import c.b.a.b.l0.q;
import c.b.a.b.l0.r;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class TextInputLayout extends LinearLayout {
    public static final int J0 = k.Widget_Design_TextInputLayout;
    public CharSequence A;
    public int A0;
    public boolean B;
    public int B0;
    public c.b.a.b.h0.g C;
    public int C0;
    public c.b.a.b.h0.g D;
    public boolean D0;
    public j E;
    public final c.b.a.b.c0.b E0 = new c.b.a.b.c0.b(this);
    public final int F;
    public boolean F0;
    public int G;
    public ValueAnimator G0;
    public final int H;
    public boolean H0;
    public int I;
    public boolean I0;
    public int J;
    public int K;
    public int L;
    public int M;
    public final Rect N = new Rect();
    public final Rect O = new Rect();
    public final RectF P = new RectF();
    public Typeface Q;
    public final CheckableImageButton R;
    public ColorStateList S;
    public boolean T;
    public PorterDuff.Mode U;
    public boolean V;
    public Drawable W;
    public int a0;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f4564b;
    public View.OnLongClickListener b0;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f4565c;
    public final LinkedHashSet<f> c0 = new LinkedHashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f4566d;
    public int d0 = 0;

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f4567e;
    public final SparseArray<m> e0 = new SparseArray<>();
    public EditText f;
    public final CheckableImageButton f0;
    public CharSequence g;
    public final LinkedHashSet<g> g0 = new LinkedHashSet<>();
    public final n h = new n(this);
    public ColorStateList h0;
    public boolean i;
    public boolean i0;
    public int j;
    public PorterDuff.Mode j0;
    public boolean k;
    public boolean k0;
    public TextView l;
    public Drawable l0;
    public int m;
    public int m0;
    public int n;
    public Drawable n0;
    public CharSequence o;
    public View.OnLongClickListener o0;
    public boolean p;
    public View.OnLongClickListener p0;
    public TextView q;
    public final CheckableImageButton q0;
    public ColorStateList r;
    public ColorStateList r0;
    public int s;
    public ColorStateList s0;
    public ColorStateList t;
    public ColorStateList t0;
    public ColorStateList u;
    public int u0;
    public CharSequence v;
    public int v0;
    public final TextView w;
    public int w0;
    public CharSequence x;
    public ColorStateList x0;
    public final TextView y;
    public int y0;
    public boolean z;
    public int z0;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.z(!textInputLayout.I0, false);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.i) {
                textInputLayout2.t(editable.length());
            }
            TextInputLayout textInputLayout3 = TextInputLayout.this;
            if (textInputLayout3.p) {
                textInputLayout3.A(editable.length());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            TextInputLayout.this.f0.performClick();
            TextInputLayout.this.f0.jumpDrawablesToCurrentState();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            TextInputLayout.this.f.requestLayout();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.E0.w(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends b.i.l.a {

        /* renamed from: d  reason: collision with root package name */
        public final TextInputLayout f4572d;

        public e(TextInputLayout textInputLayout) {
            this.f4572d = textInputLayout;
        }

        @Override // b.i.l.a
        public void d(View view, b.i.l.w.b bVar) {
            this.f1139a.onInitializeAccessibilityNodeInfo(view, bVar.f1195a);
            EditText editText = this.f4572d.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f4572d.getHint();
            CharSequence helperText = this.f4572d.getHelperText();
            CharSequence error = this.f4572d.getError();
            int counterMaxLength = this.f4572d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f4572d.getCounterOverflowDescription();
            boolean z = true;
            boolean z2 = !TextUtils.isEmpty(text);
            boolean z3 = !TextUtils.isEmpty(hint);
            boolean z4 = !TextUtils.isEmpty(helperText);
            boolean z5 = !TextUtils.isEmpty(error);
            if (!z5 && TextUtils.isEmpty(counterOverflowDescription)) {
                z = false;
            }
            String charSequence = z3 ? hint.toString() : "";
            StringBuilder g = c.a.a.a.a.g(charSequence);
            g.append(((z5 || z4) && !TextUtils.isEmpty(charSequence)) ? ", " : "");
            StringBuilder g2 = c.a.a.a.a.g(g.toString());
            if (z5) {
                helperText = error;
            } else if (!z4) {
                helperText = "";
            }
            g2.append((Object) helperText);
            String sb = g2.toString();
            if (z2) {
                bVar.f1195a.setText(text);
            } else if (!TextUtils.isEmpty(sb)) {
                bVar.f1195a.setText(sb);
            }
            if (!TextUtils.isEmpty(sb)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    bVar.k(sb);
                } else {
                    if (z2) {
                        sb = ((Object) text) + ", " + sb;
                    }
                    bVar.f1195a.setText(sb);
                }
                boolean z6 = !z2;
                if (Build.VERSION.SDK_INT >= 26) {
                    bVar.f1195a.setShowingHintText(z6);
                } else {
                    bVar.h(4, z6);
                }
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            bVar.f1195a.setMaxTextLength(counterMaxLength);
            if (z) {
                if (!z5) {
                    error = counterOverflowDescription;
                }
                bVar.f1195a.setError(error);
            }
        }
    }

    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    public interface g {
        void a(TextInputLayout textInputLayout, int i);
    }

    public static class h extends b.k.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f4573d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4574e;

        public static class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new h[i];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f4573d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f4574e = parcel.readInt() != 1 ? false : true;
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder g = c.a.a.a.a.g("TextInputLayout.SavedState{");
            g.append(Integer.toHexString(System.identityHashCode(this)));
            g.append(" error=");
            g.append((Object) this.f4573d);
            g.append("}");
            return g.toString();
        }

        @Override // b.k.a.a
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f1231b, i);
            TextUtils.writeToParcel(this.f4573d, parcel, i);
            parcel.writeInt(this.f4574e ? 1 : 0);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x05e8  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x05f9  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0582  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0593  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x05a4  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x05b5  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x05c6  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x05d7  */
    public TextInputLayout(Context context, AttributeSet attributeSet) {
        super(c.b.a.b.m0.a.a.a(context, attributeSet, r8, J0), attributeSet, r8);
        AttributeSet attributeSet2;
        int i2;
        int i3 = c.b.a.b.b.textInputStyle;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f4564b = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(this.f4564b);
        LinearLayout linearLayout = new LinearLayout(context2);
        this.f4565c = linearLayout;
        linearLayout.setOrientation(0);
        this.f4565c.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        this.f4564b.addView(this.f4565c);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        this.f4566d = linearLayout2;
        linearLayout2.setOrientation(0);
        this.f4566d.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        this.f4564b.addView(this.f4566d);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f4567e = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        c.b.a.b.c0.b bVar = this.E0;
        bVar.K = c.b.a.b.m.a.f3108a;
        bVar.m();
        c.b.a.b.c0.b bVar2 = this.E0;
        bVar2.J = c.b.a.b.m.a.f3108a;
        bVar2.m();
        this.E0.q(8388659);
        int[] iArr = l.TextInputLayout;
        int i4 = J0;
        int[] iArr2 = {l.TextInputLayout_counterTextAppearance, l.TextInputLayout_counterOverflowTextAppearance, l.TextInputLayout_errorTextAppearance, l.TextInputLayout_helperTextTextAppearance, l.TextInputLayout_hintTextAppearance};
        i.a(context2, attributeSet, i3, i4);
        i.b(context2, attributeSet, iArr, i3, i4, iArr2);
        y0 y0Var = new y0(context2, context2.obtainStyledAttributes(attributeSet, iArr, i3, i4));
        this.z = y0Var.a(l.TextInputLayout_hintEnabled, true);
        setHint(y0Var.n(l.TextInputLayout_android_hint));
        this.F0 = y0Var.a(l.TextInputLayout_hintAnimationEnabled, true);
        this.E = j.b(context2, attributeSet, i3, J0).a();
        this.F = context2.getResources().getDimensionPixelOffset(c.b.a.b.d.mtrl_textinput_box_label_cutout_padding);
        this.H = y0Var.e(l.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.J = y0Var.f(l.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(c.b.a.b.d.mtrl_textinput_box_stroke_width_default));
        this.K = y0Var.f(l.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(c.b.a.b.d.mtrl_textinput_box_stroke_width_focused));
        this.I = this.J;
        float d2 = y0Var.d(l.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float d3 = y0Var.d(l.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float d4 = y0Var.d(l.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float d5 = y0Var.d(l.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        j jVar = this.E;
        if (jVar != null) {
            j.b bVar3 = new j.b(jVar);
            if (d2 >= 0.0f) {
                bVar3.f(d2);
            }
            if (d3 >= 0.0f) {
                bVar3.g(d3);
            }
            if (d4 >= 0.0f) {
                bVar3.e(d4);
            }
            if (d5 >= 0.0f) {
                bVar3.d(d5);
            }
            this.E = bVar3.a();
            ColorStateList a1 = c.b.a.a.c.n.c.a1(context2, y0Var, l.TextInputLayout_boxBackgroundColor);
            if (a1 != null) {
                int defaultColor = a1.getDefaultColor();
                this.y0 = defaultColor;
                this.M = defaultColor;
                if (a1.isStateful()) {
                    this.z0 = a1.getColorForState(new int[]{-16842910}, -1);
                    this.A0 = a1.getColorForState(new int[]{16842908, 16842910}, -1);
                    i2 = a1.getColorForState(new int[]{16843623, 16842910}, -1);
                } else {
                    this.A0 = this.y0;
                    ColorStateList a2 = b.b.l.a.a.a(context2, c.b.a.b.c.mtrl_filled_background_color);
                    this.z0 = a2.getColorForState(new int[]{-16842910}, -1);
                    i2 = a2.getColorForState(new int[]{16843623}, -1);
                }
                this.B0 = i2;
            } else {
                this.M = 0;
                this.y0 = 0;
                this.z0 = 0;
                this.A0 = 0;
                this.B0 = 0;
            }
            if (y0Var.o(l.TextInputLayout_android_textColorHint)) {
                ColorStateList c2 = y0Var.c(l.TextInputLayout_android_textColorHint);
                this.t0 = c2;
                this.s0 = c2;
            }
            ColorStateList a12 = c.b.a.a.c.n.c.a1(context2, y0Var, l.TextInputLayout_boxStrokeColor);
            this.w0 = y0Var.b(l.TextInputLayout_boxStrokeColor, 0);
            this.u0 = b.i.e.a.b(context2, c.b.a.b.c.mtrl_textinput_default_box_stroke_color);
            this.C0 = context2.getColor(c.b.a.b.c.mtrl_textinput_disabled_color);
            this.v0 = context2.getColor(c.b.a.b.c.mtrl_textinput_hovered_box_stroke_color);
            if (a12 != null) {
                setBoxStrokeColorStateList(a12);
            }
            if (y0Var.o(l.TextInputLayout_boxStrokeErrorColor)) {
                setBoxStrokeErrorColor(c.b.a.a.c.n.c.a1(context2, y0Var, l.TextInputLayout_boxStrokeErrorColor));
            }
            if (y0Var.l(l.TextInputLayout_hintTextAppearance, -1) != -1) {
                setHintTextAppearance(y0Var.l(l.TextInputLayout_hintTextAppearance, 0));
            }
            int l2 = y0Var.l(l.TextInputLayout_errorTextAppearance, 0);
            CharSequence n2 = y0Var.n(l.TextInputLayout_errorContentDescription);
            boolean a3 = y0Var.a(l.TextInputLayout_errorEnabled, false);
            CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(c.b.a.b.h.design_text_input_end_icon, (ViewGroup) this.f4566d, false);
            this.q0 = checkableImageButton;
            checkableImageButton.setVisibility(8);
            if (y0Var.o(l.TextInputLayout_errorIconDrawable)) {
                setErrorIconDrawable(y0Var.g(l.TextInputLayout_errorIconDrawable));
            }
            if (y0Var.o(l.TextInputLayout_errorIconTint)) {
                setErrorIconTintList(c.b.a.a.c.n.c.a1(context2, y0Var, l.TextInputLayout_errorIconTint));
            }
            if (y0Var.o(l.TextInputLayout_errorIconTintMode)) {
                setErrorIconTintMode(c.b.a.a.c.n.c.M1(y0Var.j(l.TextInputLayout_errorIconTintMode, -1), null));
            }
            this.q0.setContentDescription(getResources().getText(c.b.a.b.j.error_icon_content_description));
            b.i.l.m.a0(this.q0, 2);
            this.q0.setClickable(false);
            this.q0.setPressable(false);
            this.q0.setFocusable(false);
            int l3 = y0Var.l(l.TextInputLayout_helperTextTextAppearance, 0);
            boolean a4 = y0Var.a(l.TextInputLayout_helperTextEnabled, false);
            CharSequence n3 = y0Var.n(l.TextInputLayout_helperText);
            int l4 = y0Var.l(l.TextInputLayout_placeholderTextAppearance, 0);
            CharSequence n4 = y0Var.n(l.TextInputLayout_placeholderText);
            int l5 = y0Var.l(l.TextInputLayout_prefixTextAppearance, 0);
            CharSequence n5 = y0Var.n(l.TextInputLayout_prefixText);
            int l6 = y0Var.l(l.TextInputLayout_suffixTextAppearance, 0);
            CharSequence n6 = y0Var.n(l.TextInputLayout_suffixText);
            boolean a5 = y0Var.a(l.TextInputLayout_counterEnabled, false);
            setCounterMaxLength(y0Var.j(l.TextInputLayout_counterMaxLength, -1));
            this.n = y0Var.l(l.TextInputLayout_counterTextAppearance, 0);
            this.m = y0Var.l(l.TextInputLayout_counterOverflowTextAppearance, 0);
            CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(c.b.a.b.h.design_text_input_start_icon, (ViewGroup) this.f4565c, false);
            this.R = checkableImageButton2;
            checkableImageButton2.setVisibility(8);
            setStartIconOnClickListener(null);
            setStartIconOnLongClickListener(null);
            if (y0Var.o(l.TextInputLayout_startIconDrawable)) {
                setStartIconDrawable(y0Var.g(l.TextInputLayout_startIconDrawable));
                if (y0Var.o(l.TextInputLayout_startIconContentDescription)) {
                    setStartIconContentDescription(y0Var.n(l.TextInputLayout_startIconContentDescription));
                }
                setStartIconCheckable(y0Var.a(l.TextInputLayout_startIconCheckable, true));
            }
            if (y0Var.o(l.TextInputLayout_startIconTint)) {
                setStartIconTintList(c.b.a.a.c.n.c.a1(context2, y0Var, l.TextInputLayout_startIconTint));
            }
            if (y0Var.o(l.TextInputLayout_startIconTintMode)) {
                setStartIconTintMode(c.b.a.a.c.n.c.M1(y0Var.j(l.TextInputLayout_startIconTintMode, -1), null));
            }
            setBoxBackgroundMode(y0Var.j(l.TextInputLayout_boxBackgroundMode, 0));
            CheckableImageButton checkableImageButton3 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(c.b.a.b.h.design_text_input_end_icon, (ViewGroup) this.f4567e, false);
            this.f0 = checkableImageButton3;
            this.f4567e.addView(checkableImageButton3);
            this.f0.setVisibility(8);
            this.e0.append(-1, new c.b.a.b.l0.f(this));
            this.e0.append(0, new q(this));
            this.e0.append(1, new r(this));
            this.e0.append(2, new c.b.a.b.l0.a(this));
            this.e0.append(3, new c.b.a.b.l0.h(this));
            if (y0Var.o(l.TextInputLayout_endIconMode)) {
                setEndIconMode(y0Var.j(l.TextInputLayout_endIconMode, 0));
                if (y0Var.o(l.TextInputLayout_endIconDrawable)) {
                    setEndIconDrawable(y0Var.g(l.TextInputLayout_endIconDrawable));
                }
                if (y0Var.o(l.TextInputLayout_endIconContentDescription)) {
                    setEndIconContentDescription(y0Var.n(l.TextInputLayout_endIconContentDescription));
                }
                setEndIconCheckable(y0Var.a(l.TextInputLayout_endIconCheckable, true));
            } else if (y0Var.o(l.TextInputLayout_passwordToggleEnabled)) {
                setEndIconMode(y0Var.a(l.TextInputLayout_passwordToggleEnabled, false) ? 1 : 0);
                setEndIconDrawable(y0Var.g(l.TextInputLayout_passwordToggleDrawable));
                setEndIconContentDescription(y0Var.n(l.TextInputLayout_passwordToggleContentDescription));
                if (y0Var.o(l.TextInputLayout_passwordToggleTint)) {
                    setEndIconTintList(c.b.a.a.c.n.c.a1(context2, y0Var, l.TextInputLayout_passwordToggleTint));
                }
                if (y0Var.o(l.TextInputLayout_passwordToggleTintMode)) {
                    setEndIconTintMode(c.b.a.a.c.n.c.M1(y0Var.j(l.TextInputLayout_passwordToggleTintMode, -1), null));
                }
            }
            if (!y0Var.o(l.TextInputLayout_passwordToggleEnabled)) {
                if (y0Var.o(l.TextInputLayout_endIconTint)) {
                    setEndIconTintList(c.b.a.a.c.n.c.a1(context2, y0Var, l.TextInputLayout_endIconTint));
                }
                if (y0Var.o(l.TextInputLayout_endIconTintMode)) {
                    attributeSet2 = null;
                    setEndIconTintMode(c.b.a.a.c.n.c.M1(y0Var.j(l.TextInputLayout_endIconTintMode, -1), null));
                    z zVar = new z(context2, attributeSet2);
                    this.w = zVar;
                    zVar.setId(c.b.a.b.f.textinput_prefix_text);
                    this.w.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                    this.w.setAccessibilityLiveRegion(1);
                    this.f4565c.addView(this.R);
                    this.f4565c.addView(this.w);
                    z zVar2 = new z(context2, null);
                    this.y = zVar2;
                    zVar2.setId(c.b.a.b.f.textinput_suffix_text);
                    this.y.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
                    this.y.setAccessibilityLiveRegion(1);
                    this.f4566d.addView(this.y);
                    this.f4566d.addView(this.q0);
                    this.f4566d.addView(this.f4567e);
                    setHelperTextEnabled(a4);
                    setHelperText(n3);
                    setHelperTextTextAppearance(l3);
                    setErrorEnabled(a3);
                    setErrorTextAppearance(l2);
                    setErrorContentDescription(n2);
                    setCounterTextAppearance(this.n);
                    setCounterOverflowTextAppearance(this.m);
                    setPlaceholderText(n4);
                    setPlaceholderTextAppearance(l4);
                    setPrefixText(n5);
                    setPrefixTextAppearance(l5);
                    setSuffixText(n6);
                    setSuffixTextAppearance(l6);
                    if (y0Var.o(l.TextInputLayout_errorTextColor)) {
                        setErrorTextColor(y0Var.c(l.TextInputLayout_errorTextColor));
                    }
                    if (y0Var.o(l.TextInputLayout_helperTextTextColor)) {
                        setHelperTextColor(y0Var.c(l.TextInputLayout_helperTextTextColor));
                    }
                    if (y0Var.o(l.TextInputLayout_hintTextColor)) {
                        setHintTextColor(y0Var.c(l.TextInputLayout_hintTextColor));
                    }
                    if (y0Var.o(l.TextInputLayout_counterTextColor)) {
                        setCounterTextColor(y0Var.c(l.TextInputLayout_counterTextColor));
                    }
                    if (y0Var.o(l.TextInputLayout_counterOverflowTextColor)) {
                        setCounterOverflowTextColor(y0Var.c(l.TextInputLayout_counterOverflowTextColor));
                    }
                    if (y0Var.o(l.TextInputLayout_placeholderTextColor)) {
                        setPlaceholderTextColor(y0Var.c(l.TextInputLayout_placeholderTextColor));
                    }
                    if (y0Var.o(l.TextInputLayout_prefixTextColor)) {
                        setPrefixTextColor(y0Var.c(l.TextInputLayout_prefixTextColor));
                    }
                    if (y0Var.o(l.TextInputLayout_suffixTextColor)) {
                        setSuffixTextColor(y0Var.c(l.TextInputLayout_suffixTextColor));
                    }
                    setCounterEnabled(a5);
                    setEnabled(y0Var.a(l.TextInputLayout_android_enabled, true));
                    y0Var.f759b.recycle();
                    setImportantForAccessibility(2);
                    return;
                }
            }
            attributeSet2 = null;
            z zVar3 = new z(context2, attributeSet2);
            this.w = zVar3;
            zVar3.setId(c.b.a.b.f.textinput_prefix_text);
            this.w.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            this.w.setAccessibilityLiveRegion(1);
            this.f4565c.addView(this.R);
            this.f4565c.addView(this.w);
            z zVar22 = new z(context2, null);
            this.y = zVar22;
            zVar22.setId(c.b.a.b.f.textinput_suffix_text);
            this.y.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
            this.y.setAccessibilityLiveRegion(1);
            this.f4566d.addView(this.y);
            this.f4566d.addView(this.q0);
            this.f4566d.addView(this.f4567e);
            setHelperTextEnabled(a4);
            setHelperText(n3);
            setHelperTextTextAppearance(l3);
            setErrorEnabled(a3);
            setErrorTextAppearance(l2);
            setErrorContentDescription(n2);
            setCounterTextAppearance(this.n);
            setCounterOverflowTextAppearance(this.m);
            setPlaceholderText(n4);
            setPlaceholderTextAppearance(l4);
            setPrefixText(n5);
            setPrefixTextAppearance(l5);
            setSuffixText(n6);
            setSuffixTextAppearance(l6);
            if (y0Var.o(l.TextInputLayout_errorTextColor)) {
            }
            if (y0Var.o(l.TextInputLayout_helperTextTextColor)) {
            }
            if (y0Var.o(l.TextInputLayout_hintTextColor)) {
            }
            if (y0Var.o(l.TextInputLayout_counterTextColor)) {
            }
            if (y0Var.o(l.TextInputLayout_counterOverflowTextColor)) {
            }
            if (y0Var.o(l.TextInputLayout_placeholderTextColor)) {
            }
            if (y0Var.o(l.TextInputLayout_prefixTextColor)) {
            }
            if (y0Var.o(l.TextInputLayout_suffixTextColor)) {
            }
            setCounterEnabled(a5);
            setEnabled(y0Var.a(l.TextInputLayout_android_enabled, true));
            y0Var.f759b.recycle();
            setImportantForAccessibility(2);
            return;
        }
        throw null;
    }

    private m getEndIconDelegate() {
        m mVar = this.e0.get(this.d0);
        return mVar != null ? mVar : this.e0.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.q0.getVisibility() == 0) {
            return this.q0;
        }
        if (!k() || !l()) {
            return null;
        }
        return this.f0;
    }

    public static void o(ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
                o((ViewGroup) childAt, z2);
            }
        }
    }

    public static void p(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean x2 = b.i.l.m.x(checkableImageButton);
        boolean z2 = false;
        int i2 = 1;
        boolean z3 = onLongClickListener != null;
        if (x2 || z3) {
            z2 = true;
        }
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(x2);
        checkableImageButton.setPressable(x2);
        checkableImageButton.setLongClickable(z3);
        if (!z2) {
            i2 = 2;
        }
        checkableImageButton.setImportantForAccessibility(i2);
    }

    private void setEditText(EditText editText) {
        if (this.f == null) {
            if (this.d0 != 3) {
                boolean z2 = editText instanceof TextInputEditText;
            }
            this.f = editText;
            m();
            setTextInputAccessibilityDelegate(new e(this));
            this.E0.A(this.f.getTypeface());
            c.b.a.b.c0.b bVar = this.E0;
            float textSize = this.f.getTextSize();
            if (bVar.i != textSize) {
                bVar.i = textSize;
                bVar.m();
            }
            int gravity = this.f.getGravity();
            this.E0.q((gravity & -113) | 48);
            this.E0.u(gravity);
            this.f.addTextChangedListener(new a());
            if (this.s0 == null) {
                this.s0 = this.f.getHintTextColors();
            }
            if (this.z) {
                if (TextUtils.isEmpty(this.A)) {
                    CharSequence hint = this.f.getHint();
                    this.g = hint;
                    setHint(hint);
                    this.f.setHint((CharSequence) null);
                }
                this.B = true;
            }
            if (this.l != null) {
                t(this.f.getText().length());
            }
            w();
            this.h.b();
            this.f4565c.bringToFront();
            this.f4566d.bringToFront();
            this.f4567e.bringToFront();
            this.q0.bringToFront();
            Iterator<f> it = this.c0.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            B();
            E();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            z(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setErrorIconVisible(boolean z2) {
        int i2 = 0;
        this.q0.setVisibility(z2 ? 0 : 8);
        FrameLayout frameLayout = this.f4567e;
        if (z2) {
            i2 = 8;
        }
        frameLayout.setVisibility(i2);
        E();
        if (!k()) {
            v();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.A)) {
            this.A = charSequence;
            this.E0.z(charSequence);
            if (!this.D0) {
                n();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z2) {
        if (this.p != z2) {
            if (z2) {
                z zVar = new z(getContext(), null);
                this.q = zVar;
                zVar.setId(c.b.a.b.f.textinput_placeholder);
                b.i.l.m.V(this.q, 1);
                setPlaceholderTextAppearance(this.s);
                setPlaceholderTextColor(this.r);
                TextView textView = this.q;
                if (textView != null) {
                    this.f4564b.addView(textView);
                    this.q.setVisibility(0);
                }
            } else {
                TextView textView2 = this.q;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                this.q = null;
            }
            this.p = z2;
        }
    }

    public final void A(int i2) {
        if (i2 != 0 || this.D0) {
            TextView textView = this.q;
            if (textView != null && this.p) {
                textView.setText((CharSequence) null);
                this.q.setVisibility(4);
                return;
            }
            return;
        }
        r();
    }

    public final void B() {
        if (this.f != null) {
            TextView textView = this.w;
            int i2 = 0;
            if (!(this.R.getVisibility() == 0)) {
                i2 = this.f.getPaddingLeft();
            }
            textView.setPadding(i2, this.f.getCompoundPaddingTop(), this.w.getCompoundPaddingRight(), this.f.getCompoundPaddingBottom());
        }
    }

    public final void C() {
        this.w.setVisibility((this.v == null || this.D0) ? 8 : 0);
        v();
    }

    public final void D(boolean z2, boolean z3) {
        int defaultColor = this.x0.getDefaultColor();
        int colorForState = this.x0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.x0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z2) {
            this.L = colorForState2;
        } else if (z3) {
            this.L = colorForState;
        } else {
            this.L = defaultColor;
        }
    }

    public final void E() {
        if (this.f != null) {
            TextView textView = this.y;
            int paddingLeft = textView.getPaddingLeft();
            int paddingTop = this.f.getPaddingTop();
            int i2 = 0;
            if (!l()) {
                if (!(this.q0.getVisibility() == 0)) {
                    i2 = this.f.getPaddingRight();
                }
            }
            textView.setPadding(paddingLeft, paddingTop, i2, this.f.getPaddingBottom());
        }
    }

    public final void F() {
        int visibility = this.y.getVisibility();
        int i2 = 0;
        boolean z2 = this.x != null && !this.D0;
        TextView textView = this.y;
        if (!z2) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (visibility != this.y.getVisibility()) {
            getEndIconDelegate().c(z2);
        }
        v();
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e5  */
    public void G() {
        int i2;
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.C != null && this.G != 0) {
            boolean z2 = false;
            boolean z3 = isFocused() || ((editText2 = this.f) != null && editText2.hasFocus());
            boolean z4 = isHovered() || ((editText = this.f) != null && editText.isHovered());
            if (!isEnabled()) {
                i2 = this.C0;
            } else {
                if (this.h.e()) {
                    if (this.x0 == null) {
                        i2 = this.h.g();
                    }
                } else if (!this.k || (textView = this.l) == null) {
                    i2 = z3 ? this.w0 : z4 ? this.v0 : this.u0;
                } else if (this.x0 == null) {
                    i2 = textView.getCurrentTextColor();
                }
                D(z3, z4);
                if (getErrorIconDrawable() != null) {
                    n nVar = this.h;
                    if (nVar.l && nVar.e()) {
                        z2 = true;
                    }
                }
                setErrorIconVisible(z2);
                x(this.q0, this.r0);
                x(this.R, this.S);
                x(this.f0, this.h0);
                if (getEndIconDelegate().d()) {
                    if (!this.h.e() || getEndIconDrawable() == null) {
                        d();
                    } else {
                        Drawable mutate = getEndIconDrawable().mutate();
                        mutate.setTint(this.h.g());
                        this.f0.setImageDrawable(mutate);
                    }
                }
                this.I = (z3 || !isEnabled()) ? this.J : this.K;
                if (this.G == 1) {
                    this.M = !isEnabled() ? this.z0 : (!z4 || z3) ? z3 ? this.A0 : this.y0 : this.B0;
                }
                c();
            }
            this.L = i2;
            if (getErrorIconDrawable() != null) {
            }
            setErrorIconVisible(z2);
            x(this.q0, this.r0);
            x(this.R, this.S);
            x(this.f0, this.h0);
            if (getEndIconDelegate().d()) {
            }
            this.I = (z3 || !isEnabled()) ? this.J : this.K;
            if (this.G == 1) {
            }
            c();
        }
    }

    public void a(f fVar) {
        this.c0.add(fVar);
        if (this.f != null) {
            fVar.a(this);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.f4564b.addView(view, layoutParams2);
            this.f4564b.setLayoutParams(layoutParams);
            y();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    public void b(float f2) {
        if (this.E0.f2927c != f2) {
            if (this.G0 == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.G0 = valueAnimator;
                valueAnimator.setInterpolator(c.b.a.b.m.a.f3109b);
                this.G0.setDuration(167L);
                this.G0.addUpdateListener(new d());
            }
            this.G0.setFloatValues(this.E0.f2927c, f2);
            this.G0.start();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
    public final void c() {
        boolean z2;
        c.b.a.b.h0.g gVar = this.C;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(this.E);
            boolean z3 = false;
            if (this.G == 2) {
                if (this.I > -1 && this.L != 0) {
                    z2 = true;
                    if (z2) {
                        this.C.u((float) this.I, this.L);
                    }
                    int i2 = this.M;
                    if (this.G == 1) {
                        i2 = b.i.f.a.a(this.M, c.b.a.a.c.n.c.X0(getContext(), c.b.a.b.b.colorSurface, 0));
                    }
                    this.M = i2;
                    this.C.r(ColorStateList.valueOf(i2));
                    if (this.d0 == 3) {
                        this.f.getBackground().invalidateSelf();
                    }
                    if (this.D != null) {
                        if (this.I > -1 && this.L != 0) {
                            z3 = true;
                        }
                        if (z3) {
                            this.D.r(ColorStateList.valueOf(this.L));
                        }
                        invalidate();
                    }
                    invalidate();
                }
            }
            z2 = false;
            if (z2) {
            }
            int i22 = this.M;
            if (this.G == 1) {
            }
            this.M = i22;
            this.C.r(ColorStateList.valueOf(i22));
            if (this.d0 == 3) {
            }
            if (this.D != null) {
            }
            invalidate();
        }
    }

    public final void d() {
        e(this.f0, this.i0, this.h0, this.k0, this.j0);
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        EditText editText;
        if (this.g == null || (editText = this.f) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        boolean z2 = this.B;
        this.B = false;
        CharSequence hint = editText.getHint();
        this.f.setHint(this.g);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
        } finally {
            this.f.setHint(hint);
            this.B = z2;
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.I0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.I0 = false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.z) {
            this.E0.g(canvas);
        }
        c.b.a.b.h0.g gVar = this.D;
        if (gVar != null) {
            Rect bounds = gVar.getBounds();
            bounds.top = bounds.bottom - this.I;
            this.D.draw(canvas);
        }
    }

    public void drawableStateChanged() {
        if (!this.H0) {
            boolean z2 = true;
            this.H0 = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            c.b.a.b.c0.b bVar = this.E0;
            boolean y2 = bVar != null ? bVar.y(drawableState) | false : false;
            if (this.f != null) {
                if (!b.i.l.m.B(this) || !isEnabled()) {
                    z2 = false;
                }
                z(z2, false);
            }
            w();
            G();
            if (y2) {
                invalidate();
            }
            this.H0 = false;
        }
    }

    public final void e(CheckableImageButton checkableImageButton, boolean z2, ColorStateList colorStateList, boolean z3, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z2 || z3)) {
            drawable = drawable.mutate();
            if (z2) {
                drawable.setTintList(colorStateList);
            }
            if (z3) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public final void f() {
        e(this.R, this.T, this.S, this.V, this.U);
    }

    public final int g() {
        float h2;
        if (!this.z) {
            return 0;
        }
        int i2 = this.G;
        if (i2 == 0 || i2 == 1) {
            h2 = this.E0.h();
        } else if (i2 != 2) {
            return 0;
        } else {
            h2 = this.E0.h() / 2.0f;
        }
        return (int) h2;
    }

    public int getBaseline() {
        EditText editText = this.f;
        if (editText == null) {
            return super.getBaseline();
        }
        return g() + getPaddingTop() + editText.getBaseline();
    }

    public c.b.a.b.h0.g getBoxBackground() {
        int i2 = this.G;
        if (i2 == 1 || i2 == 2) {
            return this.C;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.M;
    }

    public int getBoxBackgroundMode() {
        return this.G;
    }

    public float getBoxCornerRadiusBottomEnd() {
        c.b.a.b.h0.g gVar = this.C;
        return gVar.f2982b.f2987a.h.a(gVar.i());
    }

    public float getBoxCornerRadiusBottomStart() {
        c.b.a.b.h0.g gVar = this.C;
        return gVar.f2982b.f2987a.g.a(gVar.i());
    }

    public float getBoxCornerRadiusTopEnd() {
        c.b.a.b.h0.g gVar = this.C;
        return gVar.f2982b.f2987a.f.a(gVar.i());
    }

    public float getBoxCornerRadiusTopStart() {
        return this.C.m();
    }

    public int getBoxStrokeColor() {
        return this.w0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.x0;
    }

    public int getBoxStrokeWidth() {
        return this.J;
    }

    public int getBoxStrokeWidthFocused() {
        return this.K;
    }

    public int getCounterMaxLength() {
        return this.j;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.i || !this.k || (textView = this.l) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.t;
    }

    public ColorStateList getCounterTextColor() {
        return this.t;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.s0;
    }

    public EditText getEditText() {
        return this.f;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f0.getDrawable();
    }

    public int getEndIconMode() {
        return this.d0;
    }

    public CheckableImageButton getEndIconView() {
        return this.f0;
    }

    public CharSequence getError() {
        n nVar = this.h;
        if (nVar.l) {
            return nVar.k;
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.h.n;
    }

    public int getErrorCurrentTextColors() {
        return this.h.g();
    }

    public Drawable getErrorIconDrawable() {
        return this.q0.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        return this.h.g();
    }

    public CharSequence getHelperText() {
        n nVar = this.h;
        if (nVar.r) {
            return nVar.q;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        TextView textView = this.h.s;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.z) {
            return this.A;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.E0.h();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.E0.i();
    }

    public ColorStateList getHintTextColor() {
        return this.t0;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.p) {
            return this.o;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.s;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.r;
    }

    public CharSequence getPrefixText() {
        return this.v;
    }

    public ColorStateList getPrefixTextColor() {
        return this.w.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.w;
    }

    public CharSequence getStartIconContentDescription() {
        return this.R.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.R.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.x;
    }

    public ColorStateList getSuffixTextColor() {
        return this.y.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.y;
    }

    public Typeface getTypeface() {
        return this.Q;
    }

    public final boolean h() {
        return this.z && !TextUtils.isEmpty(this.A) && (this.C instanceof c.b.a.b.l0.g);
    }

    public final int i(int i2, boolean z2) {
        int compoundPaddingLeft = this.f.getCompoundPaddingLeft() + i2;
        return (this.v == null || z2) ? compoundPaddingLeft : (compoundPaddingLeft - this.w.getMeasuredWidth()) + this.w.getPaddingLeft();
    }

    public final int j(int i2, boolean z2) {
        int compoundPaddingRight = i2 - this.f.getCompoundPaddingRight();
        if (this.v == null || !z2) {
            return compoundPaddingRight;
        }
        return this.w.getPaddingRight() + this.w.getMeasuredWidth() + compoundPaddingRight;
    }

    public final boolean k() {
        return this.d0 != 0;
    }

    public boolean l() {
        return this.f4567e.getVisibility() == 0 && this.f0.getVisibility() == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    public final void m() {
        int i2 = this.G;
        boolean z2 = true;
        if (i2 == 0) {
            this.C = null;
        } else if (i2 == 1) {
            this.C = new c.b.a.b.h0.g(this.E);
            this.D = new c.b.a.b.h0.g();
            EditText editText = this.f;
            if (editText == null || this.C == null || editText.getBackground() != null || this.G == 0) {
                z2 = false;
            }
            if (z2) {
                b.i.l.m.W(this.f, this.C);
            }
            G();
            if (this.G == 0) {
                y();
                return;
            }
            return;
        } else if (i2 == 2) {
            this.C = (!this.z || (this.C instanceof c.b.a.b.l0.g)) ? new c.b.a.b.h0.g(this.E) : new c.b.a.b.l0.g(this.E);
        } else {
            throw new IllegalArgumentException(this.G + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
        this.D = null;
        EditText editText2 = this.f;
        z2 = false;
        if (z2) {
        }
        G();
        if (this.G == 0) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00da  */
    public final void n() {
        float f2;
        float f3;
        c.b.a.b.l0.g gVar;
        float f4;
        float f5;
        int i2;
        float f6;
        float f7;
        if (h()) {
            RectF rectF = this.P;
            c.b.a.b.c0.b bVar = this.E0;
            int width = this.f.getWidth();
            int gravity = this.f.getGravity();
            boolean c2 = bVar.c(bVar.x);
            bVar.z = c2;
            if (gravity == 17 || (gravity & 7) == 1) {
                f7 = ((float) width) / 2.0f;
                f6 = bVar.b() / 2.0f;
            } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5 ? !bVar.z : c2) {
                f7 = (float) bVar.f2929e.right;
                f6 = bVar.b();
            } else {
                f2 = (float) bVar.f2929e.left;
                rectF.left = f2;
                Rect rect = bVar.f2929e;
                rectF.top = (float) rect.top;
                if (gravity != 17 || (gravity & 7) == 1) {
                    f5 = ((float) width) / 2.0f;
                    f4 = bVar.b() / 2.0f;
                } else {
                    if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                        if (bVar.z) {
                            f5 = rectF.left;
                            f4 = bVar.b();
                        } else {
                            i2 = bVar.f2929e.right;
                        }
                    } else if (bVar.z) {
                        i2 = rect.right;
                    } else {
                        f3 = bVar.b() + f2;
                        rectF.right = f3;
                        float h2 = bVar.h() + ((float) bVar.f2929e.top);
                        rectF.bottom = h2;
                        float f8 = rectF.left;
                        float f9 = (float) this.F;
                        rectF.left = f8 - f9;
                        rectF.top -= f9;
                        rectF.right += f9;
                        rectF.bottom = h2 + f9;
                        rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
                        gVar = (c.b.a.b.l0.g) this.C;
                        if (gVar == null) {
                            gVar.A(rectF.left, rectF.top, rectF.right, rectF.bottom);
                            return;
                        }
                        throw null;
                    }
                    f3 = (float) i2;
                    rectF.right = f3;
                    float h22 = bVar.h() + ((float) bVar.f2929e.top);
                    rectF.bottom = h22;
                    float f82 = rectF.left;
                    float f92 = (float) this.F;
                    rectF.left = f82 - f92;
                    rectF.top -= f92;
                    rectF.right += f92;
                    rectF.bottom = h22 + f92;
                    rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
                    gVar = (c.b.a.b.l0.g) this.C;
                    if (gVar == null) {
                    }
                }
                f3 = f5 + f4;
                rectF.right = f3;
                float h222 = bVar.h() + ((float) bVar.f2929e.top);
                rectF.bottom = h222;
                float f822 = rectF.left;
                float f922 = (float) this.F;
                rectF.left = f822 - f922;
                rectF.top -= f922;
                rectF.right += f922;
                rectF.bottom = h222 + f922;
                rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
                gVar = (c.b.a.b.l0.g) this.C;
                if (gVar == null) {
                }
            }
            f2 = f7 - f6;
            rectF.left = f2;
            Rect rect2 = bVar.f2929e;
            rectF.top = (float) rect2.top;
            if (gravity != 17) {
            }
            f5 = ((float) width) / 2.0f;
            f4 = bVar.b() / 2.0f;
            f3 = f5 + f4;
            rectF.right = f3;
            float h2222 = bVar.h() + ((float) bVar.f2929e.top);
            rectF.bottom = h2222;
            float f8222 = rectF.left;
            float f9222 = (float) this.F;
            rectF.left = f8222 - f9222;
            rectF.top -= f9222;
            rectF.right += f9222;
            rectF.bottom = h2222 + f9222;
            rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
            gVar = (c.b.a.b.l0.g) this.C;
            if (gVar == null) {
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x016d  */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        super.onLayout(z2, i2, i3, i4, i5);
        EditText editText = this.f;
        if (editText != null) {
            Rect rect = this.N;
            c.b.a.b.c0.c.a(this, editText, rect);
            c.b.a.b.h0.g gVar = this.D;
            if (gVar != null) {
                int i8 = rect.bottom;
                gVar.setBounds(rect.left, i8 - this.K, rect.right, i8);
            }
            if (this.z) {
                c.b.a.b.c0.b bVar = this.E0;
                float textSize = this.f.getTextSize();
                if (bVar.i != textSize) {
                    bVar.i = textSize;
                    bVar.m();
                }
                int gravity = this.f.getGravity();
                this.E0.q((gravity & -113) | 48);
                this.E0.u(gravity);
                c.b.a.b.c0.b bVar2 = this.E0;
                if (this.f != null) {
                    Rect rect2 = this.O;
                    boolean z3 = false;
                    boolean z4 = b.i.l.m.o(this) == 1;
                    rect2.bottom = rect.bottom;
                    int i9 = this.G;
                    if (i9 == 1) {
                        rect2.left = i(rect.left, z4);
                        i7 = rect.top + this.H;
                    } else if (i9 != 2) {
                        rect2.left = i(rect.left, z4);
                        i7 = getPaddingTop();
                    } else {
                        rect2.left = this.f.getPaddingLeft() + rect.left;
                        rect2.top = rect.top - g();
                        i6 = rect.right - this.f.getPaddingRight();
                        rect2.right = i6;
                        if (bVar2 == null) {
                            int i10 = rect2.left;
                            int i11 = rect2.top;
                            int i12 = rect2.bottom;
                            if (!c.b.a.b.c0.b.n(bVar2.f2929e, i10, i11, i6, i12)) {
                                bVar2.f2929e.set(i10, i11, i6, i12);
                                bVar2.G = true;
                                bVar2.l();
                            }
                            c.b.a.b.c0.b bVar3 = this.E0;
                            if (this.f != null) {
                                Rect rect3 = this.O;
                                TextPaint textPaint = bVar3.I;
                                textPaint.setTextSize(bVar3.i);
                                textPaint.setTypeface(bVar3.t);
                                float f2 = -bVar3.I.ascent();
                                rect3.left = this.f.getCompoundPaddingLeft() + rect.left;
                                rect3.top = this.G == 1 && this.f.getMinLines() <= 1 ? (int) (((float) rect.centerY()) - (f2 / 2.0f)) : rect.top + this.f.getCompoundPaddingTop();
                                rect3.right = rect.right - this.f.getCompoundPaddingRight();
                                if (this.G == 1 && this.f.getMinLines() <= 1) {
                                    z3 = true;
                                }
                                int compoundPaddingBottom = z3 ? (int) (((float) rect3.top) + f2) : rect.bottom - this.f.getCompoundPaddingBottom();
                                rect3.bottom = compoundPaddingBottom;
                                int i13 = rect3.left;
                                int i14 = rect3.top;
                                int i15 = rect3.right;
                                if (!c.b.a.b.c0.b.n(bVar3.f2928d, i13, i14, i15, compoundPaddingBottom)) {
                                    bVar3.f2928d.set(i13, i14, i15, compoundPaddingBottom);
                                    bVar3.G = true;
                                    bVar3.l();
                                }
                                this.E0.m();
                                if (h() && !this.D0) {
                                    n();
                                    return;
                                }
                                return;
                            }
                            throw new IllegalStateException();
                        }
                        throw null;
                    }
                    rect2.top = i7;
                    i6 = j(rect.right, z4);
                    rect2.right = i6;
                    if (bVar2 == null) {
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        EditText editText;
        int max;
        super.onMeasure(i2, i3);
        boolean z2 = false;
        if (this.f != null && this.f.getMeasuredHeight() < (max = Math.max(this.f4566d.getMeasuredHeight(), this.f4565c.getMeasuredHeight()))) {
            this.f.setMinimumHeight(max);
            z2 = true;
        }
        boolean v2 = v();
        if (z2 || v2) {
            this.f.post(new c());
        }
        if (this.q != null && (editText = this.f) != null) {
            this.q.setGravity(editText.getGravity());
            this.q.setPadding(this.f.getCompoundPaddingLeft(), this.f.getCompoundPaddingTop(), this.f.getCompoundPaddingRight(), this.f.getCompoundPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.f1231b);
        setError(hVar.f4573d);
        if (hVar.f4574e) {
            this.f0.post(new b());
        }
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (this.h.e()) {
            hVar.f4573d = getError();
        }
        hVar.f4574e = k() && this.f0.isChecked();
        return hVar;
    }

    public void q(TextView textView, int i2) {
        boolean z2 = true;
        try {
            textView.setTextAppearance(i2);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                z2 = false;
            }
        } catch (Exception unused) {
        }
        if (z2) {
            textView.setTextAppearance(k.TextAppearance_AppCompat_Caption);
            textView.setTextColor(b.i.e.a.b(getContext(), c.b.a.b.c.design_error));
        }
    }

    public final void r() {
        TextView textView = this.q;
        if (textView != null && this.p) {
            textView.setText(this.o);
            this.q.setVisibility(0);
            this.q.bringToFront();
        }
    }

    public final void s() {
        if (this.l != null) {
            EditText editText = this.f;
            t(editText == null ? 0 : editText.getText().length());
        }
    }

    public void setBoxBackgroundColor(int i2) {
        if (this.M != i2) {
            this.M = i2;
            this.y0 = i2;
            this.A0 = i2;
            this.B0 = i2;
            c();
        }
    }

    public void setBoxBackgroundColorResource(int i2) {
        setBoxBackgroundColor(b.i.e.a.b(getContext(), i2));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.y0 = defaultColor;
        this.M = defaultColor;
        this.z0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.A0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.B0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        c();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 != this.G) {
            this.G = i2;
            if (this.f != null) {
                m();
            }
        }
    }

    public void setBoxStrokeColor(int i2) {
        if (this.w0 != i2) {
            this.w0 = i2;
            G();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        int defaultColor;
        if (colorStateList.isStateful()) {
            this.u0 = colorStateList.getDefaultColor();
            this.C0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.v0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            defaultColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else {
            if (this.w0 != colorStateList.getDefaultColor()) {
                defaultColor = colorStateList.getDefaultColor();
            }
            G();
        }
        this.w0 = defaultColor;
        G();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.x0 != colorStateList) {
            this.x0 = colorStateList;
            G();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.J = i2;
        G();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.K = i2;
        G();
    }

    public void setBoxStrokeWidthFocusedResource(int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z2) {
        if (this.i != z2) {
            if (z2) {
                z zVar = new z(getContext(), null);
                this.l = zVar;
                zVar.setId(c.b.a.b.f.textinput_counter);
                Typeface typeface = this.Q;
                if (typeface != null) {
                    this.l.setTypeface(typeface);
                }
                this.l.setMaxLines(1);
                this.h.a(this.l, 2);
                ((ViewGroup.MarginLayoutParams) this.l.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(c.b.a.b.d.mtrl_textinput_counter_margin_start));
                u();
                s();
            } else {
                this.h.i(this.l, 2);
                this.l = null;
            }
            this.i = z2;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.j != i2) {
            if (i2 <= 0) {
                i2 = -1;
            }
            this.j = i2;
            if (this.i) {
                s();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.m != i2) {
            this.m = i2;
            u();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.u != colorStateList) {
            this.u = colorStateList;
            u();
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.n != i2) {
            this.n = i2;
            u();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.t != colorStateList) {
            this.t = colorStateList;
            u();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.s0 = colorStateList;
        this.t0 = colorStateList;
        if (this.f != null) {
            z(false, false);
        }
    }

    public void setEnabled(boolean z2) {
        o(this, z2);
        super.setEnabled(z2);
    }

    public void setEndIconActivated(boolean z2) {
        this.f0.setActivated(z2);
    }

    public void setEndIconCheckable(boolean z2) {
        this.f0.setCheckable(z2);
    }

    public void setEndIconContentDescription(int i2) {
        setEndIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(int i2) {
        setEndIconDrawable(i2 != 0 ? b.b.l.a.a.b(getContext(), i2) : null);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f0.setImageDrawable(drawable);
    }

    public void setEndIconMode(int i2) {
        int i3 = this.d0;
        this.d0 = i2;
        Iterator<g> it = this.g0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i3);
        }
        setEndIconVisible(i2 != 0);
        if (getEndIconDelegate().b(this.G)) {
            getEndIconDelegate().a();
            d();
            return;
        }
        StringBuilder g2 = c.a.a.a.a.g("The current box background mode ");
        g2.append(this.G);
        g2.append(" is not supported by the end icon mode ");
        g2.append(i2);
        throw new IllegalStateException(g2.toString());
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.f0;
        View.OnLongClickListener onLongClickListener = this.o0;
        checkableImageButton.setOnClickListener(onClickListener);
        p(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.o0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.f0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        p(checkableImageButton, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.h0 != colorStateList) {
            this.h0 = colorStateList;
            this.i0 = true;
            d();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.j0 != mode) {
            this.j0 = mode;
            this.k0 = true;
            d();
        }
    }

    public void setEndIconVisible(boolean z2) {
        if (l() != z2) {
            this.f0.setVisibility(z2 ? 0 : 8);
            E();
            v();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.h.l) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            n nVar = this.h;
            nVar.c();
            nVar.k = charSequence;
            nVar.m.setText(charSequence);
            if (nVar.i != 1) {
                nVar.j = 1;
            }
            nVar.k(nVar.i, nVar.j, nVar.j(nVar.m, charSequence));
            return;
        }
        this.h.h();
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        n nVar = this.h;
        nVar.n = charSequence;
        TextView textView = nVar.m;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z2) {
        n nVar = this.h;
        if (nVar.l != z2) {
            nVar.c();
            if (z2) {
                z zVar = new z(nVar.f3090a, null);
                nVar.m = zVar;
                zVar.setId(c.b.a.b.f.textinput_error);
                nVar.m.setTextAlignment(5);
                Typeface typeface = nVar.v;
                if (typeface != null) {
                    nVar.m.setTypeface(typeface);
                }
                int i2 = nVar.o;
                nVar.o = i2;
                TextView textView = nVar.m;
                if (textView != null) {
                    nVar.f3091b.q(textView, i2);
                }
                ColorStateList colorStateList = nVar.p;
                nVar.p = colorStateList;
                TextView textView2 = nVar.m;
                if (!(textView2 == null || colorStateList == null)) {
                    textView2.setTextColor(colorStateList);
                }
                CharSequence charSequence = nVar.n;
                nVar.n = charSequence;
                TextView textView3 = nVar.m;
                if (textView3 != null) {
                    textView3.setContentDescription(charSequence);
                }
                nVar.m.setVisibility(4);
                b.i.l.m.V(nVar.m, 1);
                nVar.a(nVar.m, 0);
            } else {
                nVar.h();
                nVar.i(nVar.m, 0);
                nVar.m = null;
                nVar.f3091b.w();
                nVar.f3091b.G();
            }
            nVar.l = z2;
        }
    }

    public void setErrorIconDrawable(int i2) {
        setErrorIconDrawable(i2 != 0 ? b.b.l.a.a.b(getContext(), i2) : null);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.q0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.h.l);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.q0;
        View.OnLongClickListener onLongClickListener = this.p0;
        checkableImageButton.setOnClickListener(onClickListener);
        p(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.p0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.q0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        p(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.r0 = colorStateList;
        Drawable drawable = this.q0.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            drawable.setTintList(colorStateList);
        }
        if (this.q0.getDrawable() != drawable) {
            this.q0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.q0.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            drawable.setTintMode(mode);
        }
        if (this.q0.getDrawable() != drawable) {
            this.q0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i2) {
        n nVar = this.h;
        nVar.o = i2;
        TextView textView = nVar.m;
        if (textView != null) {
            nVar.f3091b.q(textView, i2);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        n nVar = this.h;
        nVar.p = colorStateList;
        TextView textView = nVar.m;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!this.h.r) {
                setHelperTextEnabled(true);
            }
            n nVar = this.h;
            nVar.c();
            nVar.q = charSequence;
            nVar.s.setText(charSequence);
            if (nVar.i != 2) {
                nVar.j = 2;
            }
            nVar.k(nVar.i, nVar.j, nVar.j(nVar.s, charSequence));
        } else if (this.h.r) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        n nVar = this.h;
        nVar.u = colorStateList;
        TextView textView = nVar.s;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setHelperTextEnabled(boolean z2) {
        n nVar = this.h;
        if (nVar.r != z2) {
            nVar.c();
            if (z2) {
                z zVar = new z(nVar.f3090a, null);
                nVar.s = zVar;
                zVar.setId(c.b.a.b.f.textinput_helper_text);
                nVar.s.setTextAlignment(5);
                Typeface typeface = nVar.v;
                if (typeface != null) {
                    nVar.s.setTypeface(typeface);
                }
                nVar.s.setVisibility(4);
                b.i.l.m.V(nVar.s, 1);
                int i2 = nVar.t;
                nVar.t = i2;
                TextView textView = nVar.s;
                if (textView != null) {
                    textView.setTextAppearance(i2);
                }
                ColorStateList colorStateList = nVar.u;
                nVar.u = colorStateList;
                TextView textView2 = nVar.s;
                if (!(textView2 == null || colorStateList == null)) {
                    textView2.setTextColor(colorStateList);
                }
                nVar.a(nVar.s, 1);
            } else {
                nVar.c();
                if (nVar.i == 2) {
                    nVar.j = 0;
                }
                nVar.k(nVar.i, nVar.j, nVar.j(nVar.s, null));
                nVar.i(nVar.s, 1);
                nVar.s = null;
                nVar.f3091b.w();
                nVar.f3091b.G();
            }
            nVar.r = z2;
        }
    }

    public void setHelperTextTextAppearance(int i2) {
        n nVar = this.h;
        nVar.t = i2;
        TextView textView = nVar.s;
        if (textView != null) {
            textView.setTextAppearance(i2);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.z) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z2) {
        this.F0 = z2;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.z) {
            this.z = z2;
            if (!z2) {
                this.B = false;
                if (!TextUtils.isEmpty(this.A) && TextUtils.isEmpty(this.f.getHint())) {
                    this.f.setHint(this.A);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.A)) {
                        setHint(hint);
                    }
                    this.f.setHint((CharSequence) null);
                }
                this.B = true;
            }
            if (this.f != null) {
                y();
            }
        }
    }

    public void setHintTextAppearance(int i2) {
        this.E0.o(i2);
        this.t0 = this.E0.l;
        if (this.f != null) {
            z(false, false);
            y();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.t0 != colorStateList) {
            if (this.s0 == null) {
                c.b.a.b.c0.b bVar = this.E0;
                if (bVar.l != colorStateList) {
                    bVar.l = colorStateList;
                    bVar.m();
                }
            }
            this.t0 = colorStateList;
            if (this.f != null) {
                z(false, false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? b.b.l.a.a.b(getContext(), i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f0.setImageDrawable(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z2) {
        if (z2 && this.d0 != 1) {
            setEndIconMode(1);
        } else if (!z2) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.h0 = colorStateList;
        this.i0 = true;
        d();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.j0 = mode;
        this.k0 = true;
        d();
    }

    public void setPlaceholderText(CharSequence charSequence) {
        int i2 = 0;
        if (!this.p || !TextUtils.isEmpty(charSequence)) {
            if (!this.p) {
                setPlaceholderTextEnabled(true);
            }
            this.o = charSequence;
        } else {
            setPlaceholderTextEnabled(false);
        }
        EditText editText = this.f;
        if (editText != null) {
            i2 = editText.getText().length();
        }
        A(i2);
    }

    public void setPlaceholderTextAppearance(int i2) {
        this.s = i2;
        TextView textView = this.q;
        if (textView != null) {
            textView.setTextAppearance(i2);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.r != colorStateList) {
            this.r = colorStateList;
            TextView textView = this.q;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.v = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.w.setText(charSequence);
        C();
    }

    public void setPrefixTextAppearance(int i2) {
        this.w.setTextAppearance(i2);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.w.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z2) {
        this.R.setCheckable(z2);
    }

    public void setStartIconContentDescription(int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.R.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i2) {
        setStartIconDrawable(i2 != 0 ? b.b.l.a.a.b(getContext(), i2) : null);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.R.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            f();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.R;
        View.OnLongClickListener onLongClickListener = this.b0;
        checkableImageButton.setOnClickListener(onClickListener);
        p(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.b0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.R;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        p(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.S != colorStateList) {
            this.S = colorStateList;
            this.T = true;
            f();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.U != mode) {
            this.U = mode;
            this.V = true;
            f();
        }
    }

    public void setStartIconVisible(boolean z2) {
        int i2 = 0;
        if ((this.R.getVisibility() == 0) != z2) {
            CheckableImageButton checkableImageButton = this.R;
            if (!z2) {
                i2 = 8;
            }
            checkableImageButton.setVisibility(i2);
            B();
            v();
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.x = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.y.setText(charSequence);
        F();
    }

    public void setSuffixTextAppearance(int i2) {
        this.y.setTextAppearance(i2);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.y.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f;
        if (editText != null) {
            b.i.l.m.T(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.Q) {
            this.Q = typeface;
            this.E0.A(typeface);
            n nVar = this.h;
            if (typeface != nVar.v) {
                nVar.v = typeface;
                TextView textView = nVar.m;
                if (textView != null) {
                    textView.setTypeface(typeface);
                }
                TextView textView2 = nVar.s;
                if (textView2 != null) {
                    textView2.setTypeface(typeface);
                }
            }
            TextView textView3 = this.l;
            if (textView3 != null) {
                textView3.setTypeface(typeface);
            }
        }
    }

    public void t(int i2) {
        boolean z2 = this.k;
        int i3 = this.j;
        String str = null;
        if (i3 == -1) {
            this.l.setText(String.valueOf(i2));
            this.l.setContentDescription(null);
            this.k = false;
        } else {
            this.k = i2 > i3;
            Context context = getContext();
            this.l.setContentDescription(context.getString(this.k ? c.b.a.b.j.character_counter_overflowed_content_description : c.b.a.b.j.character_counter_content_description, Integer.valueOf(i2), Integer.valueOf(this.j)));
            if (z2 != this.k) {
                u();
            }
            b.i.j.a c2 = b.i.j.a.c();
            TextView textView = this.l;
            String string = getContext().getString(c.b.a.b.j.character_counter_pattern, Integer.valueOf(i2), Integer.valueOf(this.j));
            b.i.j.c cVar = c2.f1113c;
            if (string != null) {
                str = c2.d(string, cVar, true).toString();
            }
            textView.setText(str);
        }
        if (this.f != null && z2 != this.k) {
            z(false, false);
            G();
            w();
        }
    }

    public final void u() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.l;
        if (textView != null) {
            q(textView, this.k ? this.m : this.n);
            if (!this.k && (colorStateList2 = this.t) != null) {
                this.l.setTextColor(colorStateList2);
            }
            if (this.k && (colorStateList = this.u) != null) {
                this.l.setTextColor(colorStateList);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0106  */
    public final boolean v() {
        boolean z2;
        if (this.f == null) {
            return false;
        }
        boolean z3 = true;
        if (!(getStartIconDrawable() == null && this.v == null) && this.f4565c.getMeasuredWidth() > 0) {
            int measuredWidth = this.f4565c.getMeasuredWidth() - this.f.getPaddingLeft();
            if (this.W == null || this.a0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.W = colorDrawable;
                this.a0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = this.f.getCompoundDrawablesRelative();
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.W;
            if (drawable != drawable2) {
                this.f.setCompoundDrawablesRelative(drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
            }
            z2 = false;
            if ((this.q0.getVisibility() != 0 || ((k() && l()) || this.x != null)) && this.f4566d.getMeasuredWidth() > 0) {
                int measuredWidth2 = this.y.getMeasuredWidth() - this.f.getPaddingRight();
                CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
                if (endIconToUpdateDummyDrawable != null) {
                    measuredWidth2 = ((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams()).getMarginStart() + endIconToUpdateDummyDrawable.getMeasuredWidth() + measuredWidth2;
                }
                Drawable[] compoundDrawablesRelative2 = this.f.getCompoundDrawablesRelative();
                Drawable drawable3 = this.l0;
                if (drawable3 == null || this.m0 == measuredWidth2) {
                    if (this.l0 == null) {
                        ColorDrawable colorDrawable2 = new ColorDrawable();
                        this.l0 = colorDrawable2;
                        this.m0 = measuredWidth2;
                        colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                    }
                    Drawable drawable4 = compoundDrawablesRelative2[2];
                    Drawable drawable5 = this.l0;
                    if (drawable4 != drawable5) {
                        this.n0 = compoundDrawablesRelative2[2];
                        this.f.setCompoundDrawablesRelative(compoundDrawablesRelative2[0], compoundDrawablesRelative2[1], drawable5, compoundDrawablesRelative2[3]);
                    } else {
                        z3 = z2;
                    }
                } else {
                    this.m0 = measuredWidth2;
                    drawable3.setBounds(0, 0, measuredWidth2, 1);
                    this.f.setCompoundDrawablesRelative(compoundDrawablesRelative2[0], compoundDrawablesRelative2[1], this.l0, compoundDrawablesRelative2[3]);
                }
            } else if (this.l0 == null) {
                return z2;
            } else {
                Drawable[] compoundDrawablesRelative3 = this.f.getCompoundDrawablesRelative();
                if (compoundDrawablesRelative3[2] == this.l0) {
                    this.f.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.n0, compoundDrawablesRelative3[3]);
                } else {
                    z3 = z2;
                }
                this.l0 = null;
            }
            return z3;
        }
        if (this.W != null) {
            Drawable[] compoundDrawablesRelative4 = this.f.getCompoundDrawablesRelative();
            this.f.setCompoundDrawablesRelative(null, compoundDrawablesRelative4[1], compoundDrawablesRelative4[2], compoundDrawablesRelative4[3]);
            this.W = null;
        }
        z2 = false;
        if ((this.q0.getVisibility() != 0 || ((k() && l()) || this.x != null)) && this.f4566d.getMeasuredWidth() > 0) {
        }
        return z3;
        z2 = true;
        if ((this.q0.getVisibility() != 0 || ((k() && l()) || this.x != null)) && this.f4566d.getMeasuredWidth() > 0) {
        }
        return z3;
    }

    public void w() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.f;
        if (editText != null && this.G == 0 && (background = editText.getBackground()) != null) {
            if (e0.a(background)) {
                background = background.mutate();
            }
            if (this.h.e()) {
                currentTextColor = this.h.g();
            } else if (!this.k || (textView = this.l) == null) {
                background.clearColorFilter();
                this.f.refreshDrawableState();
                return;
            } else {
                currentTextColor = textView.getCurrentTextColor();
            }
            background.setColorFilter(b.b.q.j.c(currentTextColor, PorterDuff.Mode.SRC_IN));
        }
    }

    public final void x(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int colorForState = colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
            Drawable mutate = drawable.mutate();
            mutate.setTintList(ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    public final void y() {
        if (this.G != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f4564b.getLayoutParams();
            int g2 = g();
            if (g2 != layoutParams.topMargin) {
                layoutParams.topMargin = g2;
                this.f4564b.requestLayout();
            }
        }
    }

    public final void z(boolean z2, boolean z3) {
        ColorStateList colorStateList;
        c.b.a.b.c0.b bVar;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f;
        boolean z4 = editText != null && !TextUtils.isEmpty(editText.getText());
        EditText editText2 = this.f;
        boolean z5 = editText2 != null && editText2.hasFocus();
        boolean e2 = this.h.e();
        ColorStateList colorStateList2 = this.s0;
        if (colorStateList2 != null) {
            this.E0.p(colorStateList2);
            this.E0.t(this.s0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.s0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.C0) : this.C0;
            this.E0.p(ColorStateList.valueOf(colorForState));
            this.E0.t(ColorStateList.valueOf(colorForState));
        } else if (e2) {
            c.b.a.b.c0.b bVar2 = this.E0;
            TextView textView2 = this.h.m;
            bVar2.p(textView2 != null ? textView2.getTextColors() : null);
        } else {
            if (this.k && (textView = this.l) != null) {
                bVar = this.E0;
                colorStateList = textView.getTextColors();
            } else if (z5 && (colorStateList = this.t0) != null) {
                bVar = this.E0;
            }
            bVar.p(colorStateList);
        }
        if (z4 || (isEnabled() && (z5 || e2))) {
            if (z3 || this.D0) {
                ValueAnimator valueAnimator = this.G0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.G0.cancel();
                }
                if (!z2 || !this.F0) {
                    this.E0.w(1.0f);
                } else {
                    b(1.0f);
                }
                this.D0 = false;
                if (h()) {
                    n();
                }
                r();
                C();
                F();
            }
        } else if (z3 || !this.D0) {
            ValueAnimator valueAnimator2 = this.G0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.G0.cancel();
            }
            if (!z2 || !this.F0) {
                this.E0.w(0.0f);
            } else {
                b(0.0f);
            }
            if (h() && (!((c.b.a.b.l0.g) this.C).A.isEmpty()) && h()) {
                ((c.b.a.b.l0.g) this.C).A(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.D0 = true;
            TextView textView3 = this.q;
            if (textView3 != null && this.p) {
                textView3.setText((CharSequence) null);
                this.q.setVisibility(4);
            }
            C();
            F();
        }
    }
}
