package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
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
import b.x.t;
import c.b.a.b.h0.j;
import c.b.a.b.k;
import c.b.a.b.l;
import c.b.a.b.l0.m;
import c.b.a.b.l0.n;
import c.b.a.b.l0.q;
import c.b.a.b.l0.r;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;
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
    public final c.b.a.b.c0.c E0 = new c.b.a.b.c0.c(this);
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
    public final FrameLayout f6163b;
    public View.OnLongClickListener b0;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f6164c;
    public final LinkedHashSet<f> c0 = new LinkedHashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f6165d;
    public int d0 = 0;

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f6166e;
    public final SparseArray<m> e0 = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public EditText f6167f;
    public final CheckableImageButton f0;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f6168g;
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
            textInputLayout.y(!textInputLayout.I0, false);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.i) {
                textInputLayout2.t(editable.length());
            }
            TextInputLayout textInputLayout3 = TextInputLayout.this;
            if (textInputLayout3.p) {
                textInputLayout3.z(editable.length());
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
            TextInputLayout.this.f6167f.requestLayout();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.E0.o(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends b.i.l.a {

        /* renamed from: d  reason: collision with root package name */
        public final TextInputLayout f6173d;

        public e(TextInputLayout textInputLayout) {
            this.f6173d = textInputLayout;
        }

        @Override // b.i.l.a
        public void d(View view, b.i.l.w.b bVar) {
            this.f1847a.onInitializeAccessibilityNodeInfo(view, bVar.f1906a);
            EditText editText = this.f6173d.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f6173d.getHint();
            CharSequence error = this.f6173d.getError();
            int counterMaxLength = this.f6173d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f6173d.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z2 ? hint.toString() : "";
            if (z) {
                bVar.f1906a.setText(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                bVar.f1906a.setText(charSequence);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    bVar.k(charSequence);
                } else {
                    if (z) {
                        charSequence = ((Object) text) + ", " + charSequence;
                    }
                    bVar.f1906a.setText(charSequence);
                }
                boolean z5 = !z;
                if (Build.VERSION.SDK_INT >= 26) {
                    bVar.f1906a.setShowingHintText(z5);
                } else {
                    bVar.h(4, z5);
                }
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            bVar.f1906a.setMaxTextLength(counterMaxLength);
            if (z4) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                bVar.f1906a.setError(error);
            }
            if (editText != null) {
                editText.setLabelFor(c.b.a.b.f.textinput_helper_text);
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
        public CharSequence f6174d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f6175e;

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
            this.f6174d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f6175e = parcel.readInt() != 1 ? false : true;
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder h = c.a.a.a.a.h("TextInputLayout.SavedState{");
            h.append(Integer.toHexString(System.identityHashCode(this)));
            h.append(" error=");
            h.append((Object) this.f6174d);
            h.append("}");
            return h.toString();
        }

        @Override // b.k.a.a
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f1952b, i);
            TextUtils.writeToParcel(this.f6174d, parcel, i);
            parcel.writeInt(this.f6175e ? 1 : 0);
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
        this.f6163b = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(this.f6163b);
        LinearLayout linearLayout = new LinearLayout(context2);
        this.f6164c = linearLayout;
        linearLayout.setOrientation(0);
        this.f6164c.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        this.f6163b.addView(this.f6164c);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        this.f6165d = linearLayout2;
        linearLayout2.setOrientation(0);
        this.f6165d.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        this.f6163b.addView(this.f6165d);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f6166e = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        c.b.a.b.c0.c cVar = this.E0;
        cVar.J = c.b.a.b.m.a.f4410a;
        cVar.k();
        c.b.a.b.c0.c cVar2 = this.E0;
        cVar2.I = c.b.a.b.m.a.f4410a;
        cVar2.k();
        this.E0.n(8388659);
        int[] iArr = l.TextInputLayout;
        int i4 = J0;
        int[] iArr2 = {l.TextInputLayout_counterTextAppearance, l.TextInputLayout_counterOverflowTextAppearance, l.TextInputLayout_errorTextAppearance, l.TextInputLayout_helperTextTextAppearance, l.TextInputLayout_hintTextAppearance};
        c.b.a.b.c0.k.a(context2, attributeSet, i3, i4);
        c.b.a.b.c0.k.b(context2, attributeSet, iArr, i3, i4, iArr2);
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
            j.b bVar = new j.b(jVar);
            if (d2 >= 0.0f) {
                bVar.f(d2);
            }
            if (d3 >= 0.0f) {
                bVar.g(d3);
            }
            if (d4 >= 0.0f) {
                bVar.e(d4);
            }
            if (d5 >= 0.0f) {
                bVar.d(d5);
            }
            this.E = bVar.a();
            ColorStateList C1 = t.C1(context2, y0Var, l.TextInputLayout_boxBackgroundColor);
            if (C1 != null) {
                int defaultColor = C1.getDefaultColor();
                this.y0 = defaultColor;
                this.M = defaultColor;
                if (C1.isStateful()) {
                    this.z0 = C1.getColorForState(new int[]{-16842910}, -1);
                    this.A0 = C1.getColorForState(new int[]{16842908, 16842910}, -1);
                    i2 = C1.getColorForState(new int[]{16843623, 16842910}, -1);
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
            ColorStateList C12 = t.C1(context2, y0Var, l.TextInputLayout_boxStrokeColor);
            this.w0 = y0Var.b(l.TextInputLayout_boxStrokeColor, 0);
            this.u0 = b.i.e.a.b(context2, c.b.a.b.c.mtrl_textinput_default_box_stroke_color);
            this.C0 = context2.getColor(c.b.a.b.c.mtrl_textinput_disabled_color);
            this.v0 = context2.getColor(c.b.a.b.c.mtrl_textinput_hovered_box_stroke_color);
            if (C12 != null) {
                setBoxStrokeColorStateList(C12);
            }
            if (y0Var.o(l.TextInputLayout_boxStrokeErrorColor)) {
                setBoxStrokeErrorColor(t.C1(context2, y0Var, l.TextInputLayout_boxStrokeErrorColor));
            }
            if (y0Var.l(l.TextInputLayout_hintTextAppearance, -1) != -1) {
                setHintTextAppearance(y0Var.l(l.TextInputLayout_hintTextAppearance, 0));
            }
            int l2 = y0Var.l(l.TextInputLayout_errorTextAppearance, 0);
            CharSequence n2 = y0Var.n(l.TextInputLayout_errorContentDescription);
            boolean a3 = y0Var.a(l.TextInputLayout_errorEnabled, false);
            CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(c.b.a.b.h.design_text_input_end_icon, (ViewGroup) this.f6165d, false);
            this.q0 = checkableImageButton;
            checkableImageButton.setVisibility(8);
            if (y0Var.o(l.TextInputLayout_errorIconDrawable)) {
                setErrorIconDrawable(y0Var.g(l.TextInputLayout_errorIconDrawable));
            }
            if (y0Var.o(l.TextInputLayout_errorIconTint)) {
                setErrorIconTintList(t.C1(context2, y0Var, l.TextInputLayout_errorIconTint));
            }
            if (y0Var.o(l.TextInputLayout_errorIconTintMode)) {
                setErrorIconTintMode(t.m2(y0Var.j(l.TextInputLayout_errorIconTintMode, -1), null));
            }
            this.q0.setContentDescription(getResources().getText(c.b.a.b.j.error_icon_content_description));
            b.i.l.m.b0(this.q0, 2);
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
            CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(c.b.a.b.h.design_text_input_start_icon, (ViewGroup) this.f6164c, false);
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
                setStartIconTintList(t.C1(context2, y0Var, l.TextInputLayout_startIconTint));
            }
            if (y0Var.o(l.TextInputLayout_startIconTintMode)) {
                setStartIconTintMode(t.m2(y0Var.j(l.TextInputLayout_startIconTintMode, -1), null));
            }
            setBoxBackgroundMode(y0Var.j(l.TextInputLayout_boxBackgroundMode, 0));
            CheckableImageButton checkableImageButton3 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(c.b.a.b.h.design_text_input_end_icon, (ViewGroup) this.f6166e, false);
            this.f0 = checkableImageButton3;
            this.f6166e.addView(checkableImageButton3);
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
                    setEndIconTintList(t.C1(context2, y0Var, l.TextInputLayout_passwordToggleTint));
                }
                if (y0Var.o(l.TextInputLayout_passwordToggleTintMode)) {
                    setEndIconTintMode(t.m2(y0Var.j(l.TextInputLayout_passwordToggleTintMode, -1), null));
                }
            }
            if (!y0Var.o(l.TextInputLayout_passwordToggleEnabled)) {
                if (y0Var.o(l.TextInputLayout_endIconTint)) {
                    setEndIconTintList(t.C1(context2, y0Var, l.TextInputLayout_endIconTint));
                }
                if (y0Var.o(l.TextInputLayout_endIconTintMode)) {
                    attributeSet2 = null;
                    setEndIconTintMode(t.m2(y0Var.j(l.TextInputLayout_endIconTintMode, -1), null));
                    z zVar = new z(context2, attributeSet2);
                    this.w = zVar;
                    zVar.setId(c.b.a.b.f.textinput_prefix_text);
                    this.w.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                    this.w.setAccessibilityLiveRegion(1);
                    this.f6164c.addView(this.R);
                    this.f6164c.addView(this.w);
                    z zVar2 = new z(context2, null);
                    this.y = zVar2;
                    zVar2.setId(c.b.a.b.f.textinput_suffix_text);
                    this.y.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
                    this.y.setAccessibilityLiveRegion(1);
                    this.f6165d.addView(this.y);
                    this.f6165d.addView(this.q0);
                    this.f6165d.addView(this.f6166e);
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
                    y0Var.f986b.recycle();
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
            this.f6164c.addView(this.R);
            this.f6164c.addView(this.w);
            z zVar22 = new z(context2, null);
            this.y = zVar22;
            zVar22.setId(c.b.a.b.f.textinput_suffix_text);
            this.y.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
            this.y.setAccessibilityLiveRegion(1);
            this.f6165d.addView(this.y);
            this.f6165d.addView(this.q0);
            this.f6165d.addView(this.f6166e);
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
            y0Var.f986b.recycle();
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
        if (!j() || !k()) {
            return null;
        }
        return this.f0;
    }

    public static void n(ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
                n((ViewGroup) childAt, z2);
            }
        }
    }

    public static void q(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean y2 = b.i.l.m.y(checkableImageButton);
        boolean z2 = false;
        int i2 = 1;
        boolean z3 = onLongClickListener != null;
        if (y2 || z3) {
            z2 = true;
        }
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(y2);
        checkableImageButton.setPressable(y2);
        checkableImageButton.setLongClickable(z3);
        if (!z2) {
            i2 = 2;
        }
        checkableImageButton.setImportantForAccessibility(i2);
    }

    private void setEditText(EditText editText) {
        if (this.f6167f == null) {
            if (this.d0 != 3) {
                boolean z2 = editText instanceof TextInputEditText;
            }
            this.f6167f = editText;
            l();
            setTextInputAccessibilityDelegate(new e(this));
            this.E0.q(this.f6167f.getTypeface());
            c.b.a.b.c0.c cVar = this.E0;
            float textSize = this.f6167f.getTextSize();
            if (cVar.i != textSize) {
                cVar.i = textSize;
                cVar.k();
            }
            int gravity = this.f6167f.getGravity();
            this.E0.n((gravity & -113) | 48);
            c.b.a.b.c0.c cVar2 = this.E0;
            if (cVar2.f4195g != gravity) {
                cVar2.f4195g = gravity;
                cVar2.k();
            }
            this.f6167f.addTextChangedListener(new a());
            if (this.s0 == null) {
                this.s0 = this.f6167f.getHintTextColors();
            }
            if (this.z) {
                if (TextUtils.isEmpty(this.A)) {
                    CharSequence hint = this.f6167f.getHint();
                    this.f6168g = hint;
                    setHint(hint);
                    this.f6167f.setHint((CharSequence) null);
                }
                this.B = true;
            }
            if (this.l != null) {
                t(this.f6167f.getText().length());
            }
            w();
            this.h.b();
            this.f6164c.bringToFront();
            this.f6165d.bringToFront();
            this.f6166e.bringToFront();
            this.q0.bringToFront();
            Iterator<f> it = this.c0.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            A();
            D();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            y(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setErrorIconVisible(boolean z2) {
        int i2 = 0;
        this.q0.setVisibility(z2 ? 0 : 8);
        FrameLayout frameLayout = this.f6166e;
        if (z2) {
            i2 = 8;
        }
        frameLayout.setVisibility(i2);
        D();
        if (!j()) {
            v();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.A)) {
            this.A = charSequence;
            c.b.a.b.c0.c cVar = this.E0;
            if (charSequence == null || !TextUtils.equals(cVar.w, charSequence)) {
                cVar.w = charSequence;
                cVar.x = null;
                Bitmap bitmap = cVar.A;
                if (bitmap != null) {
                    bitmap.recycle();
                    cVar.A = null;
                }
                cVar.k();
            }
            if (!this.D0) {
                m();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z2) {
        if (this.p != z2) {
            if (z2) {
                z zVar = new z(getContext(), null);
                this.q = zVar;
                zVar.setId(c.b.a.b.f.textinput_placeholder);
                b.i.l.m.W(this.q, 1);
                setPlaceholderTextAppearance(this.s);
                setPlaceholderTextColor(this.r);
                TextView textView = this.q;
                if (textView != null) {
                    this.f6163b.addView(textView);
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

    public final void A() {
        int i2;
        if (this.f6167f != null) {
            if (this.R.getVisibility() == 0) {
                i2 = 0;
            } else {
                i2 = b.i.l.m.t(this.f6167f);
            }
            b.i.l.m.d0(this.w, i2, this.f6167f.getCompoundPaddingTop(), 0, this.f6167f.getCompoundPaddingBottom());
        }
    }

    public final void B() {
        this.w.setVisibility((this.v == null || this.D0) ? 8 : 0);
        v();
    }

    public final void C(boolean z2, boolean z3) {
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

    public final void D() {
        int i2;
        if (this.f6167f != null) {
            if (!k()) {
                if (!(this.q0.getVisibility() == 0)) {
                    i2 = b.i.l.m.s(this.f6167f);
                    b.i.l.m.d0(this.y, 0, this.f6167f.getPaddingTop(), i2, this.f6167f.getPaddingBottom());
                }
            }
            i2 = 0;
            b.i.l.m.d0(this.y, 0, this.f6167f.getPaddingTop(), i2, this.f6167f.getPaddingBottom());
        }
    }

    public final void E() {
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

    /* JADX WARNING: Removed duplicated region for block: B:44:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e0  */
    public void F() {
        int i2;
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.C != null && this.G != 0) {
            boolean z2 = false;
            boolean z3 = isFocused() || ((editText2 = this.f6167f) != null && editText2.hasFocus());
            boolean z4 = isHovered() || ((editText = this.f6167f) != null && editText.isHovered());
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
                C(z3, z4);
                if (getErrorIconDrawable() != null) {
                    n nVar = this.h;
                    if (nVar.l && nVar.e()) {
                        z2 = true;
                    }
                }
                setErrorIconVisible(z2);
                p(this.q0, this.r0);
                p(this.R, this.S);
                o();
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
            p(this.q0, this.r0);
            p(this.R, this.S);
            o();
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
        if (this.f6167f != null) {
            fVar.a(this);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.f6163b.addView(view, layoutParams2);
            this.f6163b.setLayoutParams(layoutParams);
            x();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    public void b(float f2) {
        if (this.E0.f4191c != f2) {
            if (this.G0 == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.G0 = valueAnimator;
                valueAnimator.setInterpolator(c.b.a.b.m.a.f4411b);
                this.G0.setDuration(167L);
                this.G0.addUpdateListener(new d());
            }
            this.G0.setFloatValues(this.E0.f4191c, f2);
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
                        i2 = b.i.f.a.a(this.M, t.z1(getContext(), c.b.a.b.b.colorSurface, 0));
                    }
                    this.M = i2;
                    this.C.r(ColorStateList.valueOf(i2));
                    if (this.d0 == 3) {
                        this.f6167f.getBackground().invalidateSelf();
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
        if (this.f6168g == null || (editText = this.f6167f) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        boolean z2 = this.B;
        this.B = false;
        CharSequence hint = editText.getHint();
        this.f6167f.setHint(this.f6168g);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
        } finally {
            this.f6167f.setHint(hint);
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
            c.b.a.b.c0.c cVar = this.E0;
            if (cVar != null) {
                int save = canvas.save();
                if (cVar.x != null && cVar.f4190b) {
                    float lineLeft = (cVar.O.getLineLeft(0) + cVar.q) - (cVar.R * 2.0f);
                    cVar.G.setTextSize(cVar.D);
                    float f2 = cVar.q;
                    float f3 = cVar.r;
                    boolean z2 = true;
                    boolean z3 = cVar.z && cVar.A != null;
                    float f4 = cVar.C;
                    if (f4 != 1.0f) {
                        canvas.scale(f4, f4, f2, f3);
                    }
                    if (z3) {
                        canvas.drawBitmap(cVar.A, f2, f3, cVar.B);
                    } else {
                        if (cVar.T <= 1 || cVar.y || cVar.z) {
                            z2 = false;
                        }
                        if (z2) {
                            int alpha = cVar.G.getAlpha();
                            canvas.translate(lineLeft, f3);
                            float f5 = (float) alpha;
                            cVar.G.setAlpha((int) (cVar.Q * f5));
                            cVar.O.draw(canvas);
                            cVar.G.setAlpha((int) (cVar.P * f5));
                            int lineBaseline = cVar.O.getLineBaseline(0);
                            CharSequence charSequence = cVar.S;
                            float f6 = (float) lineBaseline;
                            canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f6, cVar.G);
                            String trim = cVar.S.toString().trim();
                            if (trim.endsWith("…")) {
                                trim = trim.substring(0, trim.length() - 1);
                            }
                            cVar.G.setAlpha(alpha);
                            canvas.drawText(trim, 0, Math.min(cVar.O.getLineEnd(0), trim.length()), 0.0f, f6, (Paint) cVar.G);
                        } else {
                            canvas.translate(f2, f3);
                            cVar.O.draw(canvas);
                        }
                    }
                    canvas.restoreToCount(save);
                }
            } else {
                throw null;
            }
        }
        c.b.a.b.h0.g gVar = this.D;
        if (gVar != null) {
            Rect bounds = gVar.getBounds();
            bounds.top = bounds.bottom - this.I;
            this.D.draw(canvas);
        }
    }

    public void drawableStateChanged() {
        boolean z2;
        boolean z3;
        ColorStateList colorStateList;
        if (!this.H0) {
            boolean z4 = true;
            this.H0 = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            c.b.a.b.c0.c cVar = this.E0;
            if (cVar != null) {
                cVar.E = drawableState;
                ColorStateList colorStateList2 = cVar.l;
                if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = cVar.k) != null && colorStateList.isStateful())) {
                    cVar.k();
                    z3 = true;
                } else {
                    z3 = false;
                }
                z2 = z3 | false;
            } else {
                z2 = false;
            }
            if (this.f6167f != null) {
                if (!b.i.l.m.C(this) || !isEnabled()) {
                    z4 = false;
                }
                y(z4, false);
            }
            w();
            F();
            if (z2) {
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

    public final int f() {
        float f2;
        if (!this.z) {
            return 0;
        }
        int i2 = this.G;
        if (i2 == 0 || i2 == 1) {
            f2 = this.E0.f();
        } else if (i2 != 2) {
            return 0;
        } else {
            f2 = this.E0.f() / 2.0f;
        }
        return (int) f2;
    }

    public final boolean g() {
        return this.z && !TextUtils.isEmpty(this.A) && (this.C instanceof c.b.a.b.l0.g);
    }

    public int getBaseline() {
        EditText editText = this.f6167f;
        if (editText == null) {
            return super.getBaseline();
        }
        return f() + getPaddingTop() + editText.getBaseline();
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
        return gVar.f4261b.f4268a.h.a(gVar.i());
    }

    public float getBoxCornerRadiusBottomStart() {
        c.b.a.b.h0.g gVar = this.C;
        return gVar.f4261b.f4268a.f4283g.a(gVar.i());
    }

    public float getBoxCornerRadiusTopEnd() {
        c.b.a.b.h0.g gVar = this.C;
        return gVar.f4261b.f4268a.f4282f.a(gVar.i());
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
        return this.f6167f;
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
        return this.E0.f();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.E0.g();
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

    public final int h(int i2, boolean z2) {
        int compoundPaddingLeft = this.f6167f.getCompoundPaddingLeft() + i2;
        return (this.v == null || z2) ? compoundPaddingLeft : (compoundPaddingLeft - this.w.getMeasuredWidth()) + this.w.getPaddingLeft();
    }

    public final int i(int i2, boolean z2) {
        int compoundPaddingRight = i2 - this.f6167f.getCompoundPaddingRight();
        return (this.v == null || !z2) ? compoundPaddingRight : compoundPaddingRight + (this.w.getMeasuredWidth() - this.w.getPaddingRight());
    }

    public final boolean j() {
        return this.d0 != 0;
    }

    public boolean k() {
        return this.f6166e.getVisibility() == 0 && this.f0.getVisibility() == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    public final void l() {
        int i2 = this.G;
        boolean z2 = true;
        if (i2 == 0) {
            this.C = null;
        } else if (i2 == 1) {
            this.C = new c.b.a.b.h0.g(this.E);
            this.D = new c.b.a.b.h0.g();
            EditText editText = this.f6167f;
            if (editText == null || this.C == null || editText.getBackground() != null || this.G == 0) {
                z2 = false;
            }
            if (z2) {
                b.i.l.m.X(this.f6167f, this.C);
            }
            F();
            if (this.G == 0) {
                x();
                return;
            }
            return;
        } else if (i2 == 2) {
            this.C = (!this.z || (this.C instanceof c.b.a.b.l0.g)) ? new c.b.a.b.h0.g(this.E) : new c.b.a.b.l0.g(this.E);
        } else {
            throw new IllegalArgumentException(this.G + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
        this.D = null;
        EditText editText2 = this.f6167f;
        z2 = false;
        if (z2) {
        }
        F();
        if (this.G == 0) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00da  */
    public final void m() {
        float f2;
        float f3;
        c.b.a.b.l0.g gVar;
        float f4;
        float f5;
        int i2;
        float f6;
        float f7;
        if (g()) {
            RectF rectF = this.P;
            c.b.a.b.c0.c cVar = this.E0;
            int width = this.f6167f.getWidth();
            int gravity = this.f6167f.getGravity();
            boolean c2 = cVar.c(cVar.w);
            cVar.y = c2;
            if (gravity == 17 || (gravity & 7) == 1) {
                f7 = ((float) width) / 2.0f;
                f6 = cVar.b() / 2.0f;
            } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5 ? !cVar.y : c2) {
                f7 = (float) cVar.f4193e.right;
                f6 = cVar.b();
            } else {
                f2 = (float) cVar.f4193e.left;
                rectF.left = f2;
                Rect rect = cVar.f4193e;
                rectF.top = (float) rect.top;
                if (gravity != 17 || (gravity & 7) == 1) {
                    f5 = ((float) width) / 2.0f;
                    f4 = cVar.b() / 2.0f;
                } else {
                    if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                        if (cVar.y) {
                            f5 = rectF.left;
                            f4 = cVar.b();
                        } else {
                            i2 = cVar.f4193e.right;
                        }
                    } else if (cVar.y) {
                        i2 = rect.right;
                    } else {
                        f3 = cVar.b() + f2;
                        rectF.right = f3;
                        float f8 = cVar.f() + ((float) cVar.f4193e.top);
                        rectF.bottom = f8;
                        float f9 = rectF.left;
                        float f10 = (float) this.F;
                        rectF.left = f9 - f10;
                        rectF.top -= f10;
                        rectF.right += f10;
                        rectF.bottom = f8 + f10;
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
                    float f82 = cVar.f() + ((float) cVar.f4193e.top);
                    rectF.bottom = f82;
                    float f92 = rectF.left;
                    float f102 = (float) this.F;
                    rectF.left = f92 - f102;
                    rectF.top -= f102;
                    rectF.right += f102;
                    rectF.bottom = f82 + f102;
                    rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
                    gVar = (c.b.a.b.l0.g) this.C;
                    if (gVar == null) {
                    }
                }
                f3 = f5 + f4;
                rectF.right = f3;
                float f822 = cVar.f() + ((float) cVar.f4193e.top);
                rectF.bottom = f822;
                float f922 = rectF.left;
                float f1022 = (float) this.F;
                rectF.left = f922 - f1022;
                rectF.top -= f1022;
                rectF.right += f1022;
                rectF.bottom = f822 + f1022;
                rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
                gVar = (c.b.a.b.l0.g) this.C;
                if (gVar == null) {
                }
            }
            f2 = f7 - f6;
            rectF.left = f2;
            Rect rect2 = cVar.f4193e;
            rectF.top = (float) rect2.top;
            if (gravity != 17) {
            }
            f5 = ((float) width) / 2.0f;
            f4 = cVar.b() / 2.0f;
            f3 = f5 + f4;
            rectF.right = f3;
            float f8222 = cVar.f() + ((float) cVar.f4193e.top);
            rectF.bottom = f8222;
            float f9222 = rectF.left;
            float f10222 = (float) this.F;
            rectF.left = f9222 - f10222;
            rectF.top -= f10222;
            rectF.right += f10222;
            rectF.bottom = f8222 + f10222;
            rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
            gVar = (c.b.a.b.l0.g) this.C;
            if (gVar == null) {
            }
        }
    }

    public void o() {
        p(this.f0, this.h0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0173  */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        super.onLayout(z2, i2, i3, i4, i5);
        EditText editText = this.f6167f;
        if (editText != null) {
            Rect rect = this.N;
            c.b.a.b.c0.d.a(this, editText, rect);
            c.b.a.b.h0.g gVar = this.D;
            if (gVar != null) {
                int i8 = rect.bottom;
                gVar.setBounds(rect.left, i8 - this.K, rect.right, i8);
            }
            if (this.z) {
                c.b.a.b.c0.c cVar = this.E0;
                float textSize = this.f6167f.getTextSize();
                if (cVar.i != textSize) {
                    cVar.i = textSize;
                    cVar.k();
                }
                int gravity = this.f6167f.getGravity();
                this.E0.n((gravity & -113) | 48);
                c.b.a.b.c0.c cVar2 = this.E0;
                if (cVar2.f4195g != gravity) {
                    cVar2.f4195g = gravity;
                    cVar2.k();
                }
                c.b.a.b.c0.c cVar3 = this.E0;
                if (this.f6167f != null) {
                    Rect rect2 = this.O;
                    boolean z3 = false;
                    boolean z4 = b.i.l.m.p(this) == 1;
                    rect2.bottom = rect.bottom;
                    int i9 = this.G;
                    if (i9 == 1) {
                        rect2.left = h(rect.left, z4);
                        i7 = rect.top + this.H;
                    } else if (i9 != 2) {
                        rect2.left = h(rect.left, z4);
                        i7 = getPaddingTop();
                    } else {
                        rect2.left = this.f6167f.getPaddingLeft() + rect.left;
                        rect2.top = rect.top - f();
                        i6 = rect.right - this.f6167f.getPaddingRight();
                        rect2.right = i6;
                        if (cVar3 == null) {
                            int i10 = rect2.left;
                            int i11 = rect2.top;
                            int i12 = rect2.bottom;
                            if (!c.b.a.b.c0.c.l(cVar3.f4193e, i10, i11, i6, i12)) {
                                cVar3.f4193e.set(i10, i11, i6, i12);
                                cVar3.F = true;
                                cVar3.j();
                            }
                            c.b.a.b.c0.c cVar4 = this.E0;
                            if (this.f6167f != null) {
                                Rect rect3 = this.O;
                                TextPaint textPaint = cVar4.H;
                                textPaint.setTextSize(cVar4.i);
                                textPaint.setTypeface(cVar4.t);
                                float f2 = -cVar4.H.ascent();
                                rect3.left = this.f6167f.getCompoundPaddingLeft() + rect.left;
                                rect3.top = this.G == 1 && this.f6167f.getMinLines() <= 1 ? (int) (((float) rect.centerY()) - (f2 / 2.0f)) : rect.top + this.f6167f.getCompoundPaddingTop();
                                rect3.right = rect.right - this.f6167f.getCompoundPaddingRight();
                                if (this.G == 1 && this.f6167f.getMinLines() <= 1) {
                                    z3 = true;
                                }
                                int compoundPaddingBottom = z3 ? (int) (((float) rect3.top) + f2) : rect.bottom - this.f6167f.getCompoundPaddingBottom();
                                rect3.bottom = compoundPaddingBottom;
                                int i13 = rect3.left;
                                int i14 = rect3.top;
                                int i15 = rect3.right;
                                if (!c.b.a.b.c0.c.l(cVar4.f4192d, i13, i14, i15, compoundPaddingBottom)) {
                                    cVar4.f4192d.set(i13, i14, i15, compoundPaddingBottom);
                                    cVar4.F = true;
                                    cVar4.j();
                                }
                                this.E0.k();
                                if (g() && !this.D0) {
                                    m();
                                    return;
                                }
                                return;
                            }
                            throw new IllegalStateException();
                        }
                        throw null;
                    }
                    rect2.top = i7;
                    i6 = i(rect.right, z4);
                    rect2.right = i6;
                    if (cVar3 == null) {
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
        if (this.f6167f != null && this.f6167f.getMeasuredHeight() < (max = Math.max(this.f6165d.getMeasuredHeight(), this.f6164c.getMeasuredHeight()))) {
            this.f6167f.setMinimumHeight(max);
            z2 = true;
        }
        boolean v2 = v();
        if (z2 || v2) {
            this.f6167f.post(new c());
        }
        if (!(this.q == null || (editText = this.f6167f) == null)) {
            this.q.setGravity(editText.getGravity());
            this.q.setPadding(this.f6167f.getCompoundPaddingLeft(), this.f6167f.getCompoundPaddingTop(), this.f6167f.getCompoundPaddingRight(), this.f6167f.getCompoundPaddingBottom());
        }
        A();
        D();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.f1952b);
        setError(hVar.f6174d);
        if (hVar.f6175e) {
            this.f0.post(new b());
        }
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (this.h.e()) {
            hVar.f6174d = getError();
        }
        hVar.f6175e = j() && this.f0.isChecked();
        return hVar;
    }

    public final void p(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int[] drawableState = getDrawableState();
            int[] drawableState2 = checkableImageButton.getDrawableState();
            int length = drawableState.length;
            int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
            System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
            int colorForState = colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor());
            Drawable mutate = drawable.mutate();
            mutate.setTintList(ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    public void r(TextView textView, int i2) {
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

    public final void s() {
        if (this.l != null) {
            EditText editText = this.f6167f;
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
            if (this.f6167f != null) {
                l();
            }
        }
    }

    public void setBoxStrokeColor(int i2) {
        if (this.w0 != i2) {
            this.w0 = i2;
            F();
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
            F();
        }
        this.w0 = defaultColor;
        F();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.x0 != colorStateList) {
            this.x0 = colorStateList;
            F();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.J = i2;
        F();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.K = i2;
        F();
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
        if (this.f6167f != null) {
            y(false, false);
        }
    }

    public void setEnabled(boolean z2) {
        n(this, z2);
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
        o();
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
        StringBuilder h2 = c.a.a.a.a.h("The current box background mode ");
        h2.append(this.G);
        h2.append(" is not supported by the end icon mode ");
        h2.append(i2);
        throw new IllegalStateException(h2.toString());
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.f0;
        View.OnLongClickListener onLongClickListener = this.o0;
        checkableImageButton.setOnClickListener(onClickListener);
        q(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.o0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.f0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        q(checkableImageButton, onLongClickListener);
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
        if (k() != z2) {
            this.f0.setVisibility(z2 ? 0 : 8);
            D();
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
                z zVar = new z(nVar.f4387a, null);
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
                    nVar.f4388b.r(textView, i2);
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
                b.i.l.m.W(nVar.m, 1);
                nVar.a(nVar.m, 0);
            } else {
                nVar.h();
                nVar.i(nVar.m, 0);
                nVar.m = null;
                nVar.f4388b.w();
                nVar.f4388b.F();
            }
            nVar.l = z2;
        }
    }

    public void setErrorIconDrawable(int i2) {
        setErrorIconDrawable(i2 != 0 ? b.b.l.a.a.b(getContext(), i2) : null);
        p(this.q0, this.r0);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.q0;
        View.OnLongClickListener onLongClickListener = this.p0;
        checkableImageButton.setOnClickListener(onClickListener);
        q(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.p0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.q0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        q(checkableImageButton, onLongClickListener);
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
            nVar.f4388b.r(textView, i2);
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
                z zVar = new z(nVar.f4387a, null);
                nVar.s = zVar;
                zVar.setId(c.b.a.b.f.textinput_helper_text);
                nVar.s.setTextAlignment(5);
                Typeface typeface = nVar.v;
                if (typeface != null) {
                    nVar.s.setTypeface(typeface);
                }
                nVar.s.setVisibility(4);
                b.i.l.m.W(nVar.s, 1);
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
                nVar.f4388b.w();
                nVar.f4388b.F();
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
                if (!TextUtils.isEmpty(this.A) && TextUtils.isEmpty(this.f6167f.getHint())) {
                    this.f6167f.setHint(this.A);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f6167f.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.A)) {
                        setHint(hint);
                    }
                    this.f6167f.setHint((CharSequence) null);
                }
                this.B = true;
            }
            if (this.f6167f != null) {
                x();
            }
        }
    }

    public void setHintTextAppearance(int i2) {
        c.b.a.b.c0.c cVar = this.E0;
        c.b.a.b.e0.b bVar = new c.b.a.b.e0.b(cVar.f4189a.getContext(), i2);
        ColorStateList colorStateList = bVar.f4231a;
        if (colorStateList != null) {
            cVar.l = colorStateList;
        }
        float f2 = bVar.k;
        if (f2 != 0.0f) {
            cVar.j = f2;
        }
        ColorStateList colorStateList2 = bVar.f4234d;
        if (colorStateList2 != null) {
            cVar.N = colorStateList2;
        }
        cVar.L = bVar.h;
        cVar.M = bVar.i;
        cVar.K = bVar.j;
        c.b.a.b.e0.a aVar = cVar.v;
        if (aVar != null) {
            aVar.f4230c = true;
        }
        c.b.a.b.c0.b bVar2 = new c.b.a.b.c0.b(cVar);
        bVar.a();
        cVar.v = new c.b.a.b.e0.a(bVar2, bVar.n);
        bVar.b(cVar.f4189a.getContext(), cVar.v);
        cVar.k();
        this.t0 = this.E0.l;
        if (this.f6167f != null) {
            y(false, false);
            x();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.t0 != colorStateList) {
            if (this.s0 == null) {
                c.b.a.b.c0.c cVar = this.E0;
                if (cVar.l != colorStateList) {
                    cVar.l = colorStateList;
                    cVar.k();
                }
            }
            this.t0 = colorStateList;
            if (this.f6167f != null) {
                y(false, false);
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
        EditText editText = this.f6167f;
        if (editText != null) {
            i2 = editText.getText().length();
        }
        z(i2);
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
        B();
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
            p(this.R, this.S);
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
        q(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.b0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.R;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        q(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.S != colorStateList) {
            this.S = colorStateList;
            this.T = true;
            e(this.R, true, colorStateList, this.V, this.U);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.U != mode) {
            this.U = mode;
            this.V = true;
            e(this.R, this.T, this.S, true, mode);
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
            A();
            v();
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.x = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.y.setText(charSequence);
        E();
    }

    public void setSuffixTextAppearance(int i2) {
        this.y.setTextAppearance(i2);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.y.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f6167f;
        if (editText != null) {
            b.i.l.m.U(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.Q) {
            this.Q = typeface;
            this.E0.q(typeface);
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
            this.l.setText(b.i.j.a.c().e(getContext().getString(c.b.a.b.j.character_counter_pattern, Integer.valueOf(i2), Integer.valueOf(this.j))));
        }
        if (this.f6167f != null && z2 != this.k) {
            y(false, false);
            F();
            w();
        }
    }

    public final void u() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.l;
        if (textView != null) {
            r(textView, this.k ? this.m : this.n);
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
        if (this.f6167f == null) {
            return false;
        }
        boolean z3 = true;
        if (!(getStartIconDrawable() == null && this.v == null) && this.f6164c.getMeasuredWidth() > 0) {
            int measuredWidth = this.f6164c.getMeasuredWidth() - this.f6167f.getPaddingLeft();
            if (this.W == null || this.a0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.W = colorDrawable;
                this.a0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = this.f6167f.getCompoundDrawablesRelative();
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.W;
            if (drawable != drawable2) {
                this.f6167f.setCompoundDrawablesRelative(drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
            }
            z2 = false;
            if ((this.q0.getVisibility() != 0 || ((j() && k()) || this.x != null)) && this.f6165d.getMeasuredWidth() > 0) {
                int measuredWidth2 = this.y.getMeasuredWidth() - this.f6167f.getPaddingRight();
                CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
                if (endIconToUpdateDummyDrawable != null) {
                    measuredWidth2 = ((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams()).getMarginStart() + endIconToUpdateDummyDrawable.getMeasuredWidth() + measuredWidth2;
                }
                Drawable[] compoundDrawablesRelative2 = this.f6167f.getCompoundDrawablesRelative();
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
                        this.f6167f.setCompoundDrawablesRelative(compoundDrawablesRelative2[0], compoundDrawablesRelative2[1], drawable5, compoundDrawablesRelative2[3]);
                    } else {
                        z3 = z2;
                    }
                } else {
                    this.m0 = measuredWidth2;
                    drawable3.setBounds(0, 0, measuredWidth2, 1);
                    this.f6167f.setCompoundDrawablesRelative(compoundDrawablesRelative2[0], compoundDrawablesRelative2[1], this.l0, compoundDrawablesRelative2[3]);
                }
            } else if (this.l0 == null) {
                return z2;
            } else {
                Drawable[] compoundDrawablesRelative3 = this.f6167f.getCompoundDrawablesRelative();
                if (compoundDrawablesRelative3[2] == this.l0) {
                    this.f6167f.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.n0, compoundDrawablesRelative3[3]);
                } else {
                    z3 = z2;
                }
                this.l0 = null;
            }
            return z3;
        }
        if (this.W != null) {
            Drawable[] compoundDrawablesRelative4 = this.f6167f.getCompoundDrawablesRelative();
            this.f6167f.setCompoundDrawablesRelative(null, compoundDrawablesRelative4[1], compoundDrawablesRelative4[2], compoundDrawablesRelative4[3]);
            this.W = null;
        }
        z2 = false;
        if ((this.q0.getVisibility() != 0 || ((j() && k()) || this.x != null)) && this.f6165d.getMeasuredWidth() > 0) {
        }
        return z3;
        z2 = true;
        if ((this.q0.getVisibility() != 0 || ((j() && k()) || this.x != null)) && this.f6165d.getMeasuredWidth() > 0) {
        }
        return z3;
    }

    public void w() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.f6167f;
        if (editText != null && this.G == 0 && (background = editText.getBackground()) != null) {
            if (e0.a(background)) {
                background = background.mutate();
            }
            if (this.h.e()) {
                currentTextColor = this.h.g();
            } else if (!this.k || (textView = this.l) == null) {
                background.clearColorFilter();
                this.f6167f.refreshDrawableState();
                return;
            } else {
                currentTextColor = textView.getCurrentTextColor();
            }
            background.setColorFilter(b.b.q.j.c(currentTextColor, PorterDuff.Mode.SRC_IN));
        }
    }

    public final void x() {
        if (this.G != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f6163b.getLayoutParams();
            int f2 = f();
            if (f2 != layoutParams.topMargin) {
                layoutParams.topMargin = f2;
                this.f6163b.requestLayout();
            }
        }
    }

    public final void y(boolean z2, boolean z3) {
        c.b.a.b.c0.c cVar;
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f6167f;
        int i2 = 0;
        boolean z4 = editText != null && !TextUtils.isEmpty(editText.getText());
        EditText editText2 = this.f6167f;
        boolean z5 = editText2 != null && editText2.hasFocus();
        boolean e2 = this.h.e();
        ColorStateList colorStateList2 = this.s0;
        if (colorStateList2 != null) {
            c.b.a.b.c0.c cVar2 = this.E0;
            if (cVar2.l != colorStateList2) {
                cVar2.l = colorStateList2;
                cVar2.k();
            }
            c.b.a.b.c0.c cVar3 = this.E0;
            ColorStateList colorStateList3 = this.s0;
            if (cVar3.k != colorStateList3) {
                cVar3.k = colorStateList3;
                cVar3.k();
            }
        }
        if (!isEnabled) {
            ColorStateList colorStateList4 = this.s0;
            int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(new int[]{-16842910}, this.C0) : this.C0;
            this.E0.m(ColorStateList.valueOf(colorForState));
            c.b.a.b.c0.c cVar4 = this.E0;
            ColorStateList valueOf = ColorStateList.valueOf(colorForState);
            if (cVar4.k != valueOf) {
                cVar4.k = valueOf;
                cVar4.k();
            }
        } else if (e2) {
            c.b.a.b.c0.c cVar5 = this.E0;
            TextView textView2 = this.h.m;
            cVar5.m(textView2 != null ? textView2.getTextColors() : null);
        } else {
            if (this.k && (textView = this.l) != null) {
                cVar = this.E0;
                colorStateList = textView.getTextColors();
            } else if (z5 && (colorStateList = this.t0) != null) {
                cVar = this.E0;
            }
            cVar.m(colorStateList);
        }
        if (z4 || (isEnabled() && (z5 || e2))) {
            if (z3 || this.D0) {
                ValueAnimator valueAnimator = this.G0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.G0.cancel();
                }
                if (!z2 || !this.F0) {
                    this.E0.o(1.0f);
                } else {
                    b(1.0f);
                }
                this.D0 = false;
                if (g()) {
                    m();
                }
                EditText editText3 = this.f6167f;
                if (editText3 != null) {
                    i2 = editText3.getText().length();
                }
                z(i2);
                B();
                E();
            }
        } else if (z3 || !this.D0) {
            ValueAnimator valueAnimator2 = this.G0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.G0.cancel();
            }
            if (!z2 || !this.F0) {
                this.E0.o(0.0f);
            } else {
                b(0.0f);
            }
            if (g() && (!((c.b.a.b.l0.g) this.C).A.isEmpty()) && g()) {
                ((c.b.a.b.l0.g) this.C).A(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.D0 = true;
            TextView textView3 = this.q;
            if (textView3 != null && this.p) {
                textView3.setText((CharSequence) null);
                this.q.setVisibility(4);
            }
            B();
            E();
        }
    }

    public final void z(int i2) {
        if (i2 != 0 || this.D0) {
            TextView textView = this.q;
            if (textView != null && this.p) {
                textView.setText((CharSequence) null);
                this.q.setVisibility(4);
                return;
            }
            return;
        }
        TextView textView2 = this.q;
        if (textView2 != null && this.p) {
            textView2.setText(this.o);
            this.q.setVisibility(0);
            this.q.bringToFront();
        }
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.q0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.h.l);
    }
}
