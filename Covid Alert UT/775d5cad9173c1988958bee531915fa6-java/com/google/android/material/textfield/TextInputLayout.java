package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import e.b.a.m;
import e.b.f.c1;
import e.b.f.d0;
import e.b.f.i0;
import e.i.i.v;
import e.y.l;
import f.b.a.e.q.k;
import f.b.a.e.v.j;
import f.b.a.e.y.m;
import f.b.a.e.y.n;
import f.b.a.e.y.q;
import f.b.a.e.y.r;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class TextInputLayout extends LinearLayout {
    public static final int P0 = R$style.Widget_Design_TextInputLayout;
    public final TextView A;
    public int A0;
    public CharSequence B;
    public int B0;
    public final TextView C;
    public ColorStateList C0;
    public boolean D;
    public int D0;
    public CharSequence E;
    public int E0;
    public boolean F;
    public int F0;
    public f.b.a.e.v.g G;
    public int G0;
    public f.b.a.e.v.g H;
    public int H0;
    public j I;
    public boolean I0;
    public final int J;
    public final f.b.a.e.q.c J0;
    public int K;
    public boolean K0;
    public int L;
    public boolean L0;
    public int M;
    public ValueAnimator M0;
    public int N;
    public boolean N0;
    public int O;
    public boolean O0;
    public int P;
    public int Q;
    public int R;
    public final Rect S = new Rect();
    public final Rect T = new Rect();
    public final RectF U = new RectF();
    public Typeface V;
    public final CheckableImageButton W;
    public ColorStateList a0;
    public final FrameLayout b;
    public boolean b0;
    public final LinearLayout c;
    public PorterDuff.Mode c0;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f602d;
    public boolean d0;

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f603e;
    public Drawable e0;

    /* renamed from: f  reason: collision with root package name */
    public EditText f604f;
    public int f0;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f605g;
    public View.OnLongClickListener g0;

    /* renamed from: h  reason: collision with root package name */
    public int f606h = -1;
    public final LinkedHashSet<f> h0 = new LinkedHashSet<>();

    /* renamed from: i  reason: collision with root package name */
    public int f607i = -1;
    public int i0 = 0;

    /* renamed from: j  reason: collision with root package name */
    public final n f608j = new n(this);
    public final SparseArray<m> j0 = new SparseArray<>();

    /* renamed from: k  reason: collision with root package name */
    public boolean f609k;
    public final CheckableImageButton k0;

    /* renamed from: l  reason: collision with root package name */
    public int f610l;
    public final LinkedHashSet<g> l0 = new LinkedHashSet<>();
    public boolean m;
    public ColorStateList m0;
    public TextView n;
    public boolean n0;
    public int o;
    public PorterDuff.Mode o0;
    public int p;
    public boolean p0;
    public CharSequence q;
    public Drawable q0;
    public boolean r;
    public int r0;
    public TextView s;
    public Drawable s0;
    public ColorStateList t;
    public View.OnLongClickListener t0;
    public int u;
    public View.OnLongClickListener u0;
    public e.y.c v;
    public final CheckableImageButton v0;
    public e.y.c w;
    public ColorStateList w0;
    public ColorStateList x;
    public ColorStateList x0;
    public ColorStateList y;
    public ColorStateList y0;
    public CharSequence z;
    public int z0;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.A(!textInputLayout.O0, false);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f609k) {
                textInputLayout2.v(editable.length());
            }
            TextInputLayout textInputLayout3 = TextInputLayout.this;
            if (textInputLayout3.r) {
                textInputLayout3.B(editable.length());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            TextInputLayout.this.k0.performClick();
            TextInputLayout.this.k0.jumpDrawablesToCurrentState();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            TextInputLayout.this.f604f.requestLayout();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.J0.o(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends e.i.i.c {

        /* renamed from: d  reason: collision with root package name */
        public final TextInputLayout f611d;

        public e(TextInputLayout textInputLayout) {
            this.f611d = textInputLayout;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
            if (r3 != null) goto L_0x0088;
         */
        @Override // e.i.i.c
        public void d(View view, e.i.i.c0.b bVar) {
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
            EditText editText = this.f611d.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f611d.getHint();
            CharSequence error = this.f611d.getError();
            CharSequence placeholderText = this.f611d.getPlaceholderText();
            int counterMaxLength = this.f611d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f611d.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !this.f611d.I0;
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z2 ? hint.toString() : "";
            if (z) {
                bVar.a.setText(text);
            } else {
                if (!TextUtils.isEmpty(charSequence)) {
                    bVar.a.setText(charSequence);
                    if (z3 && placeholderText != null) {
                        placeholderText = charSequence + ", " + ((Object) placeholderText);
                    }
                }
                bVar.a.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 26) {
                    bVar.k(charSequence);
                } else {
                    if (z) {
                        charSequence = ((Object) text) + ", " + charSequence;
                    }
                    bVar.a.setText(charSequence);
                }
                boolean z6 = !z;
                if (i2 >= 26) {
                    bVar.a.setShowingHintText(z6);
                } else {
                    bVar.h(4, z6);
                }
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            bVar.a.setMaxTextLength(counterMaxLength);
            if (z5) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                bVar.a.setError(error);
            }
            if (editText != null) {
                editText.setLabelFor(R$id.textinput_helper_text);
            }
        }
    }

    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    public interface g {
        void a(TextInputLayout textInputLayout, int i2);
    }

    public static class h extends e.k.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f612d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f613e;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f614f;

        /* renamed from: g  reason: collision with root package name */
        public CharSequence f615g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f616h;

        public static class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i2) {
                return new h[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f612d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f613e = parcel.readInt() != 1 ? false : true;
            this.f614f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f615g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f616h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("TextInputLayout.SavedState{");
            h2.append(Integer.toHexString(System.identityHashCode(this)));
            h2.append(" error=");
            h2.append((Object) this.f612d);
            h2.append(" hint=");
            h2.append((Object) this.f614f);
            h2.append(" helperText=");
            h2.append((Object) this.f615g);
            h2.append(" placeholderText=");
            h2.append((Object) this.f616h);
            h2.append("}");
            return h2.toString();
        }

        @Override // e.k.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.b, i2);
            TextUtils.writeToParcel(this.f612d, parcel, i2);
            parcel.writeInt(this.f613e ? 1 : 0);
            TextUtils.writeToParcel(this.f614f, parcel, i2);
            TextUtils.writeToParcel(this.f615g, parcel, i2);
            TextUtils.writeToParcel(this.f616h, parcel, i2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: e.b.f.c1 */
    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: android.view.LayoutInflater */
    /* JADX DEBUG: Multi-variable search result rejected for r10v11, resolved type: android.view.ViewGroup$MarginLayoutParams */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v47, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v154 */
    /* JADX WARN: Type inference failed for: r2v155 */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x05a6  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x05b5  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x05c4  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x05d3  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x05e2  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x05f1  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0600  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x060f  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public TextInputLayout(Context context, AttributeSet attributeSet) {
        super(f.b.a.e.z.a.a.a(context, attributeSet, r8, r9), attributeSet, r8);
        int i2;
        int i3;
        ?? r2;
        int i4;
        AttributeSet attributeSet2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = R$attr.textInputStyle;
        int i16 = P0;
        f.b.a.e.q.c cVar = new f.b.a.e.q.c(this);
        this.J0 = cVar;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.b = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(frameLayout);
        LinearLayout linearLayout = new LinearLayout(context2);
        this.c = linearLayout;
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        frameLayout.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context2);
        this.f602d = linearLayout2;
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout.addView(linearLayout2);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f603e = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator timeInterpolator = f.b.a.e.a.a.a;
        cVar.I = timeInterpolator;
        cVar.k();
        cVar.H = timeInterpolator;
        cVar.k();
        cVar.n(8388659);
        int[] iArr = R$styleable.TextInputLayout;
        int i17 = R$styleable.TextInputLayout_counterTextAppearance;
        int i18 = R$styleable.TextInputLayout_counterOverflowTextAppearance;
        int i19 = R$styleable.TextInputLayout_errorTextAppearance;
        int i20 = R$styleable.TextInputLayout_helperTextTextAppearance;
        int i21 = R$styleable.TextInputLayout_hintTextAppearance;
        k.a(context2, attributeSet, i15, i16);
        k.b(context2, attributeSet, iArr, i15, i16, i17, i18, i19, i20, i21);
        c1 c1Var = new c1(context2, context2.obtainStyledAttributes(attributeSet, iArr, i15, i16));
        this.D = c1Var.a(R$styleable.TextInputLayout_hintEnabled, true);
        setHint(c1Var.n(R$styleable.TextInputLayout_android_hint));
        this.L0 = c1Var.a(R$styleable.TextInputLayout_hintAnimationEnabled, true);
        this.K0 = c1Var.a(R$styleable.TextInputLayout_expandedHintEnabled, true);
        int i22 = R$styleable.TextInputLayout_android_minWidth;
        if (c1Var.o(i22)) {
            i2 = -1;
            setMinWidth(c1Var.f(i22, -1));
        } else {
            i2 = -1;
        }
        int i23 = R$styleable.TextInputLayout_android_maxWidth;
        if (c1Var.o(i23)) {
            setMaxWidth(c1Var.f(i23, i2));
        }
        this.I = j.b(context2, attributeSet, i15, i16).a();
        this.J = context2.getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_box_label_cutout_padding);
        this.M = c1Var.e(R$styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.O = c1Var.f(R$styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_default));
        this.P = c1Var.f(R$styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_focused));
        this.N = this.O;
        float d2 = c1Var.d(R$styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float d3 = c1Var.d(R$styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float d4 = c1Var.d(R$styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float d5 = c1Var.d(R$styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        j jVar = this.I;
        Objects.requireNonNull(jVar);
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
        this.I = bVar.a();
        ColorStateList y02 = f.b.a.c.b.o.b.y0(context2, c1Var, R$styleable.TextInputLayout_boxBackgroundColor);
        if (y02 != null) {
            int defaultColor = y02.getDefaultColor();
            this.D0 = defaultColor;
            this.R = defaultColor;
            if (y02.isStateful()) {
                this.E0 = y02.getColorForState(new int[]{-16842910}, -1);
                i3 = 2;
                this.F0 = y02.getColorForState(new int[]{16842908, 16842910}, -1);
                i14 = y02.getColorForState(new int[]{16843623, 16842910}, -1);
            } else {
                i3 = 2;
                this.F0 = this.D0;
                ColorStateList f02 = m.e.f0(context2, R$color.mtrl_filled_background_color);
                this.E0 = f02.getColorForState(new int[]{-16842910}, -1);
                i14 = f02.getColorForState(new int[]{16843623}, -1);
            }
            this.G0 = i14;
        } else {
            i3 = 2;
            this.R = 0;
            this.D0 = 0;
            this.E0 = 0;
            this.F0 = 0;
            this.G0 = 0;
        }
        int i24 = R$styleable.TextInputLayout_android_textColorHint;
        if (c1Var.o(i24)) {
            ColorStateList c2 = c1Var.c(i24);
            this.y0 = c2;
            this.x0 = c2;
        }
        int i25 = R$styleable.TextInputLayout_boxStrokeColor;
        ColorStateList y03 = f.b.a.c.b.o.b.y0(context2, c1Var, i25);
        this.B0 = c1Var.b(i25, 0);
        this.z0 = e.i.b.a.a(context2, R$color.mtrl_textinput_default_box_stroke_color);
        this.H0 = e.i.b.a.a(context2, R$color.mtrl_textinput_disabled_color);
        this.A0 = e.i.b.a.a(context2, R$color.mtrl_textinput_hovered_box_stroke_color);
        if (y03 != null) {
            setBoxStrokeColorStateList(y03);
        }
        int i26 = R$styleable.TextInputLayout_boxStrokeErrorColor;
        if (c1Var.o(i26)) {
            setBoxStrokeErrorColor(f.b.a.c.b.o.b.y0(context2, c1Var, i26));
        }
        if (c1Var.l(i21, -1) != -1) {
            r2 = 0;
            setHintTextAppearance(c1Var.l(i21, 0));
        } else {
            r2 = 0;
        }
        int i27 = r2 == true ? 1 : 0;
        int i28 = r2 == true ? 1 : 0;
        int i29 = r2 == true ? 1 : 0;
        int l2 = c1Var.l(i19, i27);
        CharSequence n2 = c1Var.n(R$styleable.TextInputLayout_errorContentDescription);
        boolean a2 = c1Var.a(R$styleable.TextInputLayout_errorEnabled, r2);
        LayoutInflater from = LayoutInflater.from(getContext());
        int i30 = R$layout.design_text_input_end_icon;
        CheckableImageButton checkableImageButton = (CheckableImageButton) from.inflate(i30, linearLayout2, (boolean) r2);
        this.v0 = checkableImageButton;
        checkableImageButton.setId(R$id.text_input_error_icon);
        checkableImageButton.setVisibility(8);
        if (f.b.a.c.b.o.b.T0(context2)) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(r2);
        }
        int i31 = R$styleable.TextInputLayout_errorIconDrawable;
        if (c1Var.o(i31)) {
            setErrorIconDrawable(c1Var.g(i31));
        }
        int i32 = R$styleable.TextInputLayout_errorIconTint;
        if (c1Var.o(i32)) {
            setErrorIconTintList(f.b.a.c.b.o.b.y0(context2, c1Var, i32));
        }
        int i33 = R$styleable.TextInputLayout_errorIconTintMode;
        if (c1Var.o(i33)) {
            setErrorIconTintMode(f.b.a.c.b.o.b.f1(c1Var.j(i33, -1), null));
        }
        checkableImageButton.setContentDescription(getResources().getText(R$string.error_icon_content_description));
        AtomicInteger atomicInteger = v.a;
        v.d.s(checkableImageButton, i3);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int l3 = c1Var.l(i20, 0);
        boolean a3 = c1Var.a(R$styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence n3 = c1Var.n(R$styleable.TextInputLayout_helperText);
        int l4 = c1Var.l(R$styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence n4 = c1Var.n(R$styleable.TextInputLayout_placeholderText);
        int l5 = c1Var.l(R$styleable.TextInputLayout_prefixTextAppearance, 0);
        CharSequence n5 = c1Var.n(R$styleable.TextInputLayout_prefixText);
        int l6 = c1Var.l(R$styleable.TextInputLayout_suffixTextAppearance, 0);
        CharSequence n6 = c1Var.n(R$styleable.TextInputLayout_suffixText);
        boolean a4 = c1Var.a(R$styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(c1Var.j(R$styleable.TextInputLayout_counterMaxLength, -1));
        this.p = c1Var.l(i17, 0);
        this.o = c1Var.l(i18, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_start_icon, (ViewGroup) this.c, false);
        this.W = checkableImageButton2;
        checkableImageButton2.setVisibility(8);
        if (f.b.a.c.b.o.b.T0(context2)) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams()).setMarginEnd(0);
        }
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        int i34 = R$styleable.TextInputLayout_startIconDrawable;
        if (c1Var.o(i34)) {
            setStartIconDrawable(c1Var.g(i34));
            int i35 = R$styleable.TextInputLayout_startIconContentDescription;
            if (c1Var.o(i35)) {
                setStartIconContentDescription(c1Var.n(i35));
            }
            setStartIconCheckable(c1Var.a(R$styleable.TextInputLayout_startIconCheckable, true));
        }
        int i36 = R$styleable.TextInputLayout_startIconTint;
        if (c1Var.o(i36)) {
            setStartIconTintList(f.b.a.c.b.o.b.y0(context2, c1Var, i36));
        }
        int i37 = R$styleable.TextInputLayout_startIconTintMode;
        if (c1Var.o(i37)) {
            setStartIconTintMode(f.b.a.c.b.o.b.f1(c1Var.j(i37, -1), null));
        }
        setBoxBackgroundMode(c1Var.j(R$styleable.TextInputLayout_boxBackgroundMode, 0));
        this.k0 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(i30, (ViewGroup) this.f603e, false);
        this.f603e.addView(this.k0);
        this.k0.setVisibility(8);
        if (f.b.a.c.b.o.b.T0(context2)) {
            i4 = 0;
            ((ViewGroup.MarginLayoutParams) this.k0.getLayoutParams()).setMarginStart(0);
        } else {
            i4 = 0;
        }
        int l7 = c1Var.l(R$styleable.TextInputLayout_endIconDrawable, i4);
        this.j0.append(-1, new f.b.a.e.y.f(this, l7));
        this.j0.append(i4, new q(this));
        this.j0.append(1, new r(this, l7 == 0 ? c1Var.l(R$styleable.TextInputLayout_passwordToggleDrawable, i4) : l7));
        this.j0.append(2, new f.b.a.e.y.a(this, l7));
        this.j0.append(3, new f.b.a.e.y.h(this, l7));
        int i38 = R$styleable.TextInputLayout_endIconMode;
        if (c1Var.o(i38)) {
            setEndIconMode(c1Var.j(i38, 0));
            int i39 = R$styleable.TextInputLayout_endIconContentDescription;
            if (c1Var.o(i39)) {
                setEndIconContentDescription(c1Var.n(i39));
            }
            setEndIconCheckable(c1Var.a(R$styleable.TextInputLayout_endIconCheckable, true));
        } else {
            int i40 = R$styleable.TextInputLayout_passwordToggleEnabled;
            if (c1Var.o(i40)) {
                setEndIconMode(c1Var.a(i40, false) ? 1 : 0);
                setEndIconContentDescription(c1Var.n(R$styleable.TextInputLayout_passwordToggleContentDescription));
                int i41 = R$styleable.TextInputLayout_passwordToggleTint;
                if (c1Var.o(i41)) {
                    setEndIconTintList(f.b.a.c.b.o.b.y0(context2, c1Var, i41));
                }
                int i42 = R$styleable.TextInputLayout_passwordToggleTintMode;
                if (c1Var.o(i42)) {
                    setEndIconTintMode(f.b.a.c.b.o.b.f1(c1Var.j(i42, -1), null));
                }
            }
        }
        if (!c1Var.o(R$styleable.TextInputLayout_passwordToggleEnabled)) {
            int i43 = R$styleable.TextInputLayout_endIconTint;
            if (c1Var.o(i43)) {
                setEndIconTintList(f.b.a.c.b.o.b.y0(context2, c1Var, i43));
            }
            int i44 = R$styleable.TextInputLayout_endIconTintMode;
            if (c1Var.o(i44)) {
                attributeSet2 = null;
                setEndIconTintMode(f.b.a.c.b.o.b.f1(c1Var.j(i44, -1), null));
                d0 d0Var = new d0(context2, attributeSet2);
                this.A = d0Var;
                d0Var.setId(R$id.textinput_prefix_text);
                d0Var.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                v.g.f(d0Var, 1);
                this.c.addView(this.W);
                this.c.addView(d0Var);
                d0 d0Var2 = new d0(context2, null);
                this.C = d0Var2;
                d0Var2.setId(R$id.textinput_suffix_text);
                d0Var2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
                v.g.f(d0Var2, 1);
                this.f602d.addView(this.C);
                this.f602d.addView(this.v0);
                this.f602d.addView(this.f603e);
                setHelperTextEnabled(a3);
                setHelperText(n3);
                setHelperTextTextAppearance(l3);
                setErrorEnabled(a2);
                setErrorTextAppearance(l2);
                setErrorContentDescription(n2);
                setCounterTextAppearance(this.p);
                setCounterOverflowTextAppearance(this.o);
                setPlaceholderText(n4);
                setPlaceholderTextAppearance(l4);
                setPrefixText(n5);
                setPrefixTextAppearance(l5);
                setSuffixText(n6);
                setSuffixTextAppearance(l6);
                i5 = R$styleable.TextInputLayout_errorTextColor;
                if (c1Var.o(i5)) {
                    setErrorTextColor(c1Var.c(i5));
                }
                i6 = R$styleable.TextInputLayout_helperTextTextColor;
                if (c1Var.o(i6)) {
                    setHelperTextColor(c1Var.c(i6));
                }
                i7 = R$styleable.TextInputLayout_hintTextColor;
                if (c1Var.o(i7)) {
                    setHintTextColor(c1Var.c(i7));
                }
                i8 = R$styleable.TextInputLayout_counterTextColor;
                if (c1Var.o(i8)) {
                    setCounterTextColor(c1Var.c(i8));
                }
                i9 = R$styleable.TextInputLayout_counterOverflowTextColor;
                if (c1Var.o(i9)) {
                    setCounterOverflowTextColor(c1Var.c(i9));
                }
                i10 = R$styleable.TextInputLayout_placeholderTextColor;
                if (c1Var.o(i10)) {
                    setPlaceholderTextColor(c1Var.c(i10));
                }
                i11 = R$styleable.TextInputLayout_prefixTextColor;
                if (c1Var.o(i11)) {
                    setPrefixTextColor(c1Var.c(i11));
                }
                i12 = R$styleable.TextInputLayout_suffixTextColor;
                if (c1Var.o(i12)) {
                    setSuffixTextColor(c1Var.c(i12));
                }
                setCounterEnabled(a4);
                setEnabled(c1Var.a(R$styleable.TextInputLayout_android_enabled, true));
                c1Var.b.recycle();
                v.d.s(this, 2);
                i13 = Build.VERSION.SDK_INT;
                if (i13 >= 26 && i13 >= 26) {
                    v.k.l(this, 1);
                    return;
                }
            }
        }
        attributeSet2 = null;
        d0 d0Var3 = new d0(context2, attributeSet2);
        this.A = d0Var3;
        d0Var3.setId(R$id.textinput_prefix_text);
        d0Var3.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        v.g.f(d0Var3, 1);
        this.c.addView(this.W);
        this.c.addView(d0Var3);
        d0 d0Var22 = new d0(context2, null);
        this.C = d0Var22;
        d0Var22.setId(R$id.textinput_suffix_text);
        d0Var22.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        v.g.f(d0Var22, 1);
        this.f602d.addView(this.C);
        this.f602d.addView(this.v0);
        this.f602d.addView(this.f603e);
        setHelperTextEnabled(a3);
        setHelperText(n3);
        setHelperTextTextAppearance(l3);
        setErrorEnabled(a2);
        setErrorTextAppearance(l2);
        setErrorContentDescription(n2);
        setCounterTextAppearance(this.p);
        setCounterOverflowTextAppearance(this.o);
        setPlaceholderText(n4);
        setPlaceholderTextAppearance(l4);
        setPrefixText(n5);
        setPrefixTextAppearance(l5);
        setSuffixText(n6);
        setSuffixTextAppearance(l6);
        i5 = R$styleable.TextInputLayout_errorTextColor;
        if (c1Var.o(i5)) {
        }
        i6 = R$styleable.TextInputLayout_helperTextTextColor;
        if (c1Var.o(i6)) {
        }
        i7 = R$styleable.TextInputLayout_hintTextColor;
        if (c1Var.o(i7)) {
        }
        i8 = R$styleable.TextInputLayout_counterTextColor;
        if (c1Var.o(i8)) {
        }
        i9 = R$styleable.TextInputLayout_counterOverflowTextColor;
        if (c1Var.o(i9)) {
        }
        i10 = R$styleable.TextInputLayout_placeholderTextColor;
        if (c1Var.o(i10)) {
        }
        i11 = R$styleable.TextInputLayout_prefixTextColor;
        if (c1Var.o(i11)) {
        }
        i12 = R$styleable.TextInputLayout_suffixTextColor;
        if (c1Var.o(i12)) {
        }
        setCounterEnabled(a4);
        setEnabled(c1Var.a(R$styleable.TextInputLayout_android_enabled, true));
        c1Var.b.recycle();
        v.d.s(this, 2);
        i13 = Build.VERSION.SDK_INT;
        if (i13 >= 26) {
        }
    }

    private f.b.a.e.y.m getEndIconDelegate() {
        f.b.a.e.y.m mVar = this.j0.get(this.i0);
        return mVar != null ? mVar : this.j0.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.v0.getVisibility() == 0) {
            return this.v0;
        }
        if (!k() || !m()) {
            return null;
        }
        return this.k0;
    }

    public static void p(ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
                p((ViewGroup) childAt, z2);
            }
        }
    }

    public static void s(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        AtomicInteger atomicInteger = v.a;
        boolean a2 = v.c.a(checkableImageButton);
        boolean z2 = false;
        int i2 = 1;
        boolean z3 = onLongClickListener != null;
        if (a2 || z3) {
            z2 = true;
        }
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(a2);
        checkableImageButton.setPressable(a2);
        checkableImageButton.setLongClickable(z3);
        if (!z2) {
            i2 = 2;
        }
        v.d.s(checkableImageButton, i2);
    }

    private void setEditText(EditText editText) {
        if (this.f604f == null) {
            if (this.i0 != 3) {
                boolean z2 = editText instanceof TextInputEditText;
            }
            this.f604f = editText;
            setMinWidth(this.f606h);
            setMaxWidth(this.f607i);
            n();
            setTextInputAccessibilityDelegate(new e(this));
            this.J0.q(this.f604f.getTypeface());
            f.b.a.e.q.c cVar = this.J0;
            float textSize = this.f604f.getTextSize();
            if (cVar.f2953j != textSize) {
                cVar.f2953j = textSize;
                cVar.k();
            }
            int gravity = this.f604f.getGravity();
            this.J0.n((gravity & -113) | 48);
            f.b.a.e.q.c cVar2 = this.J0;
            if (cVar2.f2951h != gravity) {
                cVar2.f2951h = gravity;
                cVar2.k();
            }
            this.f604f.addTextChangedListener(new a());
            if (this.x0 == null) {
                this.x0 = this.f604f.getHintTextColors();
            }
            if (this.D) {
                if (TextUtils.isEmpty(this.E)) {
                    CharSequence hint = this.f604f.getHint();
                    this.f605g = hint;
                    setHint(hint);
                    this.f604f.setHint((CharSequence) null);
                }
                this.F = true;
            }
            if (this.n != null) {
                v(this.f604f.getText().length());
            }
            y();
            this.f608j.b();
            this.c.bringToFront();
            this.f602d.bringToFront();
            this.f603e.bringToFront();
            this.v0.bringToFront();
            Iterator<f> it = this.h0.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            C();
            F();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            A(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setErrorIconVisible(boolean z2) {
        int i2 = 0;
        this.v0.setVisibility(z2 ? 0 : 8);
        FrameLayout frameLayout = this.f603e;
        if (z2) {
            i2 = 8;
        }
        frameLayout.setVisibility(i2);
        F();
        if (!k()) {
            x();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.E)) {
            this.E = charSequence;
            f.b.a.e.q.c cVar = this.J0;
            if (charSequence == null || !TextUtils.equals(cVar.x, charSequence)) {
                cVar.x = charSequence;
                cVar.y = null;
                Bitmap bitmap = cVar.A;
                if (bitmap != null) {
                    bitmap.recycle();
                    cVar.A = null;
                }
                cVar.k();
            }
            if (!this.I0) {
                o();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z2) {
        if (this.r != z2) {
            if (z2) {
                d0 d0Var = new d0(getContext(), null);
                this.s = d0Var;
                d0Var.setId(R$id.textinput_placeholder);
                e.y.c cVar = new e.y.c();
                cVar.f2046d = 87;
                TimeInterpolator timeInterpolator = f.b.a.e.a.a.a;
                cVar.f2047e = timeInterpolator;
                this.v = cVar;
                cVar.c = 67;
                e.y.c cVar2 = new e.y.c();
                cVar2.f2046d = 87;
                cVar2.f2047e = timeInterpolator;
                this.w = cVar2;
                TextView textView = this.s;
                AtomicInteger atomicInteger = v.a;
                v.g.f(textView, 1);
                setPlaceholderTextAppearance(this.u);
                setPlaceholderTextColor(this.t);
                TextView textView2 = this.s;
                if (textView2 != null) {
                    this.b.addView(textView2);
                    this.s.setVisibility(0);
                }
            } else {
                TextView textView3 = this.s;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                this.s = null;
            }
            this.r = z2;
        }
    }

    public final void A(boolean z2, boolean z3) {
        f.b.a.e.q.c cVar;
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f604f;
        int i2 = 0;
        boolean z4 = editText != null && !TextUtils.isEmpty(editText.getText());
        EditText editText2 = this.f604f;
        boolean z5 = editText2 != null && editText2.hasFocus();
        boolean e2 = this.f608j.e();
        ColorStateList colorStateList2 = this.x0;
        if (colorStateList2 != null) {
            f.b.a.e.q.c cVar2 = this.J0;
            if (cVar2.m != colorStateList2) {
                cVar2.m = colorStateList2;
                cVar2.k();
            }
            f.b.a.e.q.c cVar3 = this.J0;
            ColorStateList colorStateList3 = this.x0;
            if (cVar3.f2955l != colorStateList3) {
                cVar3.f2955l = colorStateList3;
                cVar3.k();
            }
        }
        if (!isEnabled) {
            ColorStateList colorStateList4 = this.x0;
            int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(new int[]{-16842910}, this.H0) : this.H0;
            this.J0.m(ColorStateList.valueOf(colorForState));
            f.b.a.e.q.c cVar4 = this.J0;
            ColorStateList valueOf = ColorStateList.valueOf(colorForState);
            if (cVar4.f2955l != valueOf) {
                cVar4.f2955l = valueOf;
                cVar4.k();
            }
        } else if (e2) {
            f.b.a.e.q.c cVar5 = this.J0;
            TextView textView2 = this.f608j.f3109l;
            cVar5.m(textView2 != null ? textView2.getTextColors() : null);
        } else {
            if (this.m && (textView = this.n) != null) {
                cVar = this.J0;
                colorStateList = textView.getTextColors();
            } else if (z5 && (colorStateList = this.y0) != null) {
                cVar = this.J0;
            }
            cVar.m(colorStateList);
        }
        if (z4 || !this.K0 || (isEnabled() && z5)) {
            if (z3 || this.I0) {
                ValueAnimator valueAnimator = this.M0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.M0.cancel();
                }
                if (!z2 || !this.L0) {
                    this.J0.o(1.0f);
                } else {
                    b(1.0f);
                }
                this.I0 = false;
                if (h()) {
                    o();
                }
                EditText editText3 = this.f604f;
                if (editText3 != null) {
                    i2 = editText3.getText().length();
                }
                B(i2);
                D();
                G();
            }
        } else if (z3 || !this.I0) {
            ValueAnimator valueAnimator2 = this.M0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.M0.cancel();
            }
            if (!z2 || !this.L0) {
                this.J0.o(0.0f);
            } else {
                b(0.0f);
            }
            if (h() && (!((f.b.a.e.y.g) this.G).B.isEmpty()) && h()) {
                ((f.b.a.e.y.g) this.G).z(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.I0 = true;
            l();
            D();
            G();
        }
    }

    public final void B(int i2) {
        if (i2 != 0 || this.I0) {
            l();
            return;
        }
        TextView textView = this.s;
        if (textView != null && this.r) {
            textView.setText(this.q);
            l.a(this.b, this.v);
            this.s.setVisibility(0);
            this.s.bringToFront();
        }
    }

    public final void C() {
        if (this.f604f != null) {
            int i2 = 0;
            if (!(this.W.getVisibility() == 0)) {
                EditText editText = this.f604f;
                AtomicInteger atomicInteger = v.a;
                i2 = v.e.f(editText);
            }
            TextView textView = this.A;
            int compoundPaddingTop = this.f604f.getCompoundPaddingTop();
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding);
            int compoundPaddingBottom = this.f604f.getCompoundPaddingBottom();
            AtomicInteger atomicInteger2 = v.a;
            v.e.k(textView, i2, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
        }
    }

    public final void D() {
        this.A.setVisibility((this.z == null || this.I0) ? 8 : 0);
        x();
    }

    public final void E(boolean z2, boolean z3) {
        int defaultColor = this.C0.getDefaultColor();
        int colorForState = this.C0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.C0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z2) {
            this.Q = colorForState2;
        } else if (z3) {
            this.Q = colorForState;
        } else {
            this.Q = defaultColor;
        }
    }

    public final void F() {
        if (this.f604f != null) {
            int i2 = 0;
            if (!m()) {
                if (!(this.v0.getVisibility() == 0)) {
                    EditText editText = this.f604f;
                    AtomicInteger atomicInteger = v.a;
                    i2 = v.e.e(editText);
                }
            }
            TextView textView = this.C;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding);
            int paddingTop = this.f604f.getPaddingTop();
            int paddingBottom = this.f604f.getPaddingBottom();
            AtomicInteger atomicInteger2 = v.a;
            v.e.k(textView, dimensionPixelSize, paddingTop, i2, paddingBottom);
        }
    }

    public final void G() {
        int visibility = this.C.getVisibility();
        int i2 = 0;
        boolean z2 = this.B != null && !this.I0;
        TextView textView = this.C;
        if (!z2) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (visibility != this.C.getVisibility()) {
            getEndIconDelegate().c(z2);
        }
        x();
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x010a  */
    public void H() {
        int i2;
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.G != null && this.L != 0) {
            boolean z2 = false;
            boolean z3 = isFocused() || ((editText2 = this.f604f) != null && editText2.hasFocus());
            boolean z4 = isHovered() || ((editText = this.f604f) != null && editText.isHovered());
            if (!isEnabled()) {
                i2 = this.H0;
            } else {
                if (this.f608j.e()) {
                    if (this.C0 == null) {
                        i2 = this.f608j.g();
                    }
                } else if (!this.m || (textView = this.n) == null) {
                    i2 = z3 ? this.B0 : z4 ? this.A0 : this.z0;
                } else if (this.C0 == null) {
                    i2 = textView.getCurrentTextColor();
                }
                E(z3, z4);
                if (getErrorIconDrawable() != null) {
                    n nVar = this.f608j;
                    if (nVar.f3108k && nVar.e()) {
                        z2 = true;
                    }
                }
                setErrorIconVisible(z2);
                r(this.v0, this.w0);
                r(this.W, this.a0);
                q();
                if (getEndIconDelegate().d()) {
                    if (!this.f608j.e() || getEndIconDrawable() == null) {
                        d();
                    } else {
                        Drawable mutate = m.e.P1(getEndIconDrawable()).mutate();
                        mutate.setTint(this.f608j.g());
                        this.k0.setImageDrawable(mutate);
                    }
                }
                this.N = (z3 || !isEnabled()) ? this.O : this.P;
                if (this.L == 2 && h() && !this.I0 && this.K != this.N) {
                    if (h()) {
                        ((f.b.a.e.y.g) this.G).z(0.0f, 0.0f, 0.0f, 0.0f);
                    }
                    o();
                }
                if (this.L == 1) {
                    this.R = !isEnabled() ? this.E0 : (!z4 || z3) ? z3 ? this.F0 : this.D0 : this.G0;
                }
                c();
            }
            this.Q = i2;
            if (getErrorIconDrawable() != null) {
            }
            setErrorIconVisible(z2);
            r(this.v0, this.w0);
            r(this.W, this.a0);
            q();
            if (getEndIconDelegate().d()) {
            }
            this.N = (z3 || !isEnabled()) ? this.O : this.P;
            if (h()) {
            }
            o();
            if (this.L == 1) {
            }
            c();
        }
    }

    public void a(f fVar) {
        this.h0.add(fVar);
        if (this.f604f != null) {
            fVar.a(this);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.b.addView(view, layoutParams2);
            this.b.setLayoutParams(layoutParams);
            z();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    public void b(float f2) {
        if (this.J0.c != f2) {
            if (this.M0 == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.M0 = valueAnimator;
                valueAnimator.setInterpolator(f.b.a.e.a.a.b);
                this.M0.setDuration(167L);
                this.M0.addUpdateListener(new d());
            }
            this.M0.setFloatValues(this.J0.c, f2);
            this.M0.start();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
    public final void c() {
        boolean z2;
        f.b.a.e.v.g gVar;
        f.b.a.e.v.g gVar2 = this.G;
        if (gVar2 != null) {
            gVar2.setShapeAppearanceModel(this.I);
            boolean z3 = false;
            if (this.L == 2) {
                if (this.N > -1 && this.Q != 0) {
                    z2 = true;
                    if (z2) {
                        this.G.t((float) this.N, this.Q);
                    }
                    int i2 = this.R;
                    if (this.L == 1) {
                        i2 = e.i.c.a.a(this.R, f.b.a.c.b.o.b.v0(getContext(), R$attr.colorSurface, 0));
                    }
                    this.R = i2;
                    this.G.q(ColorStateList.valueOf(i2));
                    if (this.i0 == 3) {
                        this.f604f.getBackground().invalidateSelf();
                    }
                    gVar = this.H;
                    if (gVar != null) {
                        if (this.N > -1 && this.Q != 0) {
                            z3 = true;
                        }
                        if (z3) {
                            gVar.q(ColorStateList.valueOf(this.Q));
                        }
                        invalidate();
                    }
                    invalidate();
                }
            }
            z2 = false;
            if (z2) {
            }
            int i22 = this.R;
            if (this.L == 1) {
            }
            this.R = i22;
            this.G.q(ColorStateList.valueOf(i22));
            if (this.i0 == 3) {
            }
            gVar = this.H;
            if (gVar != null) {
            }
            invalidate();
        }
    }

    public final void d() {
        e(this.k0, this.n0, this.m0, this.p0, this.o0);
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        EditText editText = this.f604f;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        if (this.f605g != null) {
            boolean z2 = this.F;
            this.F = false;
            CharSequence hint = editText.getHint();
            this.f604f.setHint(this.f605g);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i2);
            } finally {
                this.f604f.setHint(hint);
                this.F = z2;
            }
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i2);
            onProvideAutofillVirtualStructure(viewStructure, i2);
            viewStructure.setChildCount(this.b.getChildCount());
            for (int i3 = 0; i3 < this.b.getChildCount(); i3++) {
                View childAt = this.b.getChildAt(i3);
                ViewStructure newChild = viewStructure.newChild(i3);
                childAt.dispatchProvideAutofillStructure(newChild, i2);
                if (childAt == this.f604f) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.O0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.O0 = false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.D) {
            f.b.a.e.q.c cVar = this.J0;
            Objects.requireNonNull(cVar);
            int save = canvas.save();
            if (cVar.y != null && cVar.b) {
                cVar.O.getLineLeft(0);
                cVar.F.setTextSize(cVar.C);
                float f2 = cVar.r;
                float f3 = cVar.s;
                float f4 = cVar.B;
                if (f4 != 1.0f) {
                    canvas.scale(f4, f4, f2, f3);
                }
                canvas.translate(f2, f3);
                cVar.O.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        f.b.a.e.v.g gVar = this.H;
        if (gVar != null) {
            Rect bounds = gVar.getBounds();
            bounds.top = bounds.bottom - this.N;
            this.H.draw(canvas);
        }
    }

    public void drawableStateChanged() {
        boolean z2;
        boolean z3;
        ColorStateList colorStateList;
        if (!this.N0) {
            boolean z4 = true;
            this.N0 = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            f.b.a.e.q.c cVar = this.J0;
            if (cVar != null) {
                cVar.D = drawableState;
                ColorStateList colorStateList2 = cVar.m;
                if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = cVar.f2955l) != null && colorStateList.isStateful())) {
                    cVar.k();
                    z3 = true;
                } else {
                    z3 = false;
                }
                z2 = z3 | false;
            } else {
                z2 = false;
            }
            if (this.f604f != null) {
                AtomicInteger atomicInteger = v.a;
                if (!v.g.c(this) || !isEnabled()) {
                    z4 = false;
                }
                A(z4, false);
            }
            y();
            H();
            if (z2) {
                invalidate();
            }
            this.N0 = false;
        }
    }

    public final void e(CheckableImageButton checkableImageButton, boolean z2, ColorStateList colorStateList, boolean z3, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z2 || z3)) {
            drawable = m.e.P1(drawable).mutate();
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
        e(this.W, this.b0, this.a0, this.d0, this.c0);
    }

    public final int g() {
        float f2;
        if (!this.D) {
            return 0;
        }
        int i2 = this.L;
        if (i2 == 0 || i2 == 1) {
            f2 = this.J0.f();
        } else if (i2 != 2) {
            return 0;
        } else {
            f2 = this.J0.f() / 2.0f;
        }
        return (int) f2;
    }

    public int getBaseline() {
        EditText editText = this.f604f;
        if (editText == null) {
            return super.getBaseline();
        }
        return g() + getPaddingTop() + editText.getBaseline();
    }

    public f.b.a.e.v.g getBoxBackground() {
        int i2 = this.L;
        if (i2 == 1 || i2 == 2) {
            return this.G;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.R;
    }

    public int getBoxBackgroundMode() {
        return this.L;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.M;
    }

    public float getBoxCornerRadiusBottomEnd() {
        f.b.a.e.v.g gVar = this.G;
        return gVar.b.a.f3048h.a(gVar.h());
    }

    public float getBoxCornerRadiusBottomStart() {
        f.b.a.e.v.g gVar = this.G;
        return gVar.b.a.f3047g.a(gVar.h());
    }

    public float getBoxCornerRadiusTopEnd() {
        f.b.a.e.v.g gVar = this.G;
        return gVar.b.a.f3046f.a(gVar.h());
    }

    public float getBoxCornerRadiusTopStart() {
        return this.G.l();
    }

    public int getBoxStrokeColor() {
        return this.B0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.C0;
    }

    public int getBoxStrokeWidth() {
        return this.O;
    }

    public int getBoxStrokeWidthFocused() {
        return this.P;
    }

    public int getCounterMaxLength() {
        return this.f610l;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.f609k || !this.m || (textView = this.n) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.x;
    }

    public ColorStateList getCounterTextColor() {
        return this.x;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.x0;
    }

    public EditText getEditText() {
        return this.f604f;
    }

    public CharSequence getEndIconContentDescription() {
        return this.k0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.k0.getDrawable();
    }

    public int getEndIconMode() {
        return this.i0;
    }

    public CheckableImageButton getEndIconView() {
        return this.k0;
    }

    public CharSequence getError() {
        n nVar = this.f608j;
        if (nVar.f3108k) {
            return nVar.f3107j;
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.f608j.m;
    }

    public int getErrorCurrentTextColors() {
        return this.f608j.g();
    }

    public Drawable getErrorIconDrawable() {
        return this.v0.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        return this.f608j.g();
    }

    public CharSequence getHelperText() {
        n nVar = this.f608j;
        if (nVar.q) {
            return nVar.p;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        TextView textView = this.f608j.r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.D) {
            return this.E;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.J0.f();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.J0.g();
    }

    public ColorStateList getHintTextColor() {
        return this.y0;
    }

    public int getMaxWidth() {
        return this.f607i;
    }

    public int getMinWidth() {
        return this.f606h;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.k0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.k0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.r) {
            return this.q;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.u;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.t;
    }

    public CharSequence getPrefixText() {
        return this.z;
    }

    public ColorStateList getPrefixTextColor() {
        return this.A.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.A;
    }

    public CharSequence getStartIconContentDescription() {
        return this.W.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.W.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.B;
    }

    public ColorStateList getSuffixTextColor() {
        return this.C.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.C;
    }

    public Typeface getTypeface() {
        return this.V;
    }

    public final boolean h() {
        return this.D && !TextUtils.isEmpty(this.E) && (this.G instanceof f.b.a.e.y.g);
    }

    public final int i(int i2, boolean z2) {
        int compoundPaddingLeft = this.f604f.getCompoundPaddingLeft() + i2;
        return (this.z == null || z2) ? compoundPaddingLeft : (compoundPaddingLeft - this.A.getMeasuredWidth()) + this.A.getPaddingLeft();
    }

    public final int j(int i2, boolean z2) {
        int compoundPaddingRight = i2 - this.f604f.getCompoundPaddingRight();
        return (this.z == null || !z2) ? compoundPaddingRight : compoundPaddingRight + (this.A.getMeasuredWidth() - this.A.getPaddingRight());
    }

    public final boolean k() {
        return this.i0 != 0;
    }

    public final void l() {
        TextView textView = this.s;
        if (textView != null && this.r) {
            textView.setText((CharSequence) null);
            l.a(this.b, this.w);
            this.s.setVisibility(4);
        }
    }

    public boolean m() {
        return this.f603e.getVisibility() == 0 && this.k0.getVisibility() == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    public final void n() {
        EditText editText;
        int i2;
        Resources resources;
        int i3;
        int i4;
        int i5;
        EditText editText2;
        int i6;
        Resources resources2;
        int i7 = this.L;
        if (i7 == 0) {
            this.G = null;
        } else if (i7 == 1) {
            this.G = new f.b.a.e.v.g(this.I);
            this.H = new f.b.a.e.v.g();
            editText = this.f604f;
            if (editText == null && this.G != null && editText.getBackground() == null && this.L != 0) {
                EditText editText3 = this.f604f;
                f.b.a.e.v.g gVar = this.G;
                AtomicInteger atomicInteger = v.a;
                v.d.q(editText3, gVar);
            }
            H();
            if (this.L == 1) {
                if (f.b.a.c.b.o.b.U0(getContext())) {
                    resources2 = getResources();
                    i6 = R$dimen.material_font_2_0_box_collapsed_padding_top;
                } else if (f.b.a.c.b.o.b.T0(getContext())) {
                    resources2 = getResources();
                    i6 = R$dimen.material_font_1_3_box_collapsed_padding_top;
                }
                this.M = resources2.getDimensionPixelSize(i6);
            }
            if (this.f604f != null && this.L == 1) {
                if (!f.b.a.c.b.o.b.U0(getContext())) {
                    editText2 = this.f604f;
                    AtomicInteger atomicInteger2 = v.a;
                    i5 = v.e.f(editText2);
                    i4 = getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_top);
                    i3 = v.e.e(this.f604f);
                    resources = getResources();
                    i2 = R$dimen.material_filled_edittext_font_2_0_padding_bottom;
                } else if (f.b.a.c.b.o.b.T0(getContext())) {
                    editText2 = this.f604f;
                    AtomicInteger atomicInteger3 = v.a;
                    i5 = v.e.f(editText2);
                    i4 = getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_top);
                    i3 = v.e.e(this.f604f);
                    resources = getResources();
                    i2 = R$dimen.material_filled_edittext_font_1_3_padding_bottom;
                }
                v.e.k(editText2, i5, i4, i3, resources.getDimensionPixelSize(i2));
            }
            if (this.L == 0) {
                z();
                return;
            }
            return;
        } else if (i7 == 2) {
            this.G = (!this.D || (this.G instanceof f.b.a.e.y.g)) ? new f.b.a.e.v.g(this.I) : new f.b.a.e.y.g(this.I);
        } else {
            throw new IllegalArgumentException(this.L + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
        this.H = null;
        editText = this.f604f;
        if (editText == null && this.G != null && editText.getBackground() == null && this.L != 0) {
        }
        H();
        if (this.L == 1) {
        }
        if (!f.b.a.c.b.o.b.U0(getContext())) {
        }
        v.e.k(editText2, i5, i4, i3, resources.getDimensionPixelSize(i2));
        if (this.L == 0) {
        }
    }

    public final void o() {
        float f2;
        float f3;
        float f4;
        if (h()) {
            RectF rectF = this.U;
            f.b.a.e.q.c cVar = this.J0;
            int width = this.f604f.getWidth();
            int gravity = this.f604f.getGravity();
            boolean c2 = cVar.c(cVar.x);
            cVar.z = c2;
            if (gravity == 17 || (gravity & 7) == 1) {
                f4 = ((float) width) / 2.0f;
                f3 = cVar.b() / 2.0f;
            } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5 ? !c2 : c2) {
                f4 = (float) cVar.f2949f.right;
                f3 = cVar.b();
            } else {
                f2 = (float) cVar.f2949f.left;
                rectF.left = f2;
                Rect rect = cVar.f2949f;
                rectF.top = (float) rect.top;
                rectF.right = (gravity != 17 || (gravity & 7) == 1) ? (((float) width) / 2.0f) + (cVar.b() / 2.0f) : ((gravity & 8388613) == 8388613 || (gravity & 5) == 5 ? !cVar.z : cVar.z) ? (float) rect.right : cVar.b() + f2;
                rectF.bottom = cVar.f() + ((float) cVar.f2949f.top);
                float f5 = rectF.left;
                float f6 = (float) this.J;
                rectF.left = f5 - f6;
                rectF.right += f6;
                int i2 = this.N;
                this.K = i2;
                rectF.top = 0.0f;
                rectF.bottom = (float) i2;
                rectF.offset((float) (-getPaddingLeft()), 0.0f);
                f.b.a.e.y.g gVar = (f.b.a.e.y.g) this.G;
                Objects.requireNonNull(gVar);
                gVar.z(rectF.left, rectF.top, rectF.right, rectF.bottom);
            }
            f2 = f4 - f3;
            rectF.left = f2;
            Rect rect2 = cVar.f2949f;
            rectF.top = (float) rect2.top;
            rectF.right = (gravity != 17 || (gravity & 7) == 1) ? (((float) width) / 2.0f) + (cVar.b() / 2.0f) : ((gravity & 8388613) == 8388613 || (gravity & 5) == 5 ? !cVar.z : cVar.z) ? (float) rect2.right : cVar.b() + f2;
            rectF.bottom = cVar.f() + ((float) cVar.f2949f.top);
            float f52 = rectF.left;
            float f62 = (float) this.J;
            rectF.left = f52 - f62;
            rectF.right += f62;
            int i22 = this.N;
            this.K = i22;
            rectF.top = 0.0f;
            rectF.bottom = (float) i22;
            rectF.offset((float) (-getPaddingLeft()), 0.0f);
            f.b.a.e.y.g gVar2 = (f.b.a.e.y.g) this.G;
            Objects.requireNonNull(gVar2);
            gVar2.z(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0175  */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        super.onLayout(z2, i2, i3, i4, i5);
        EditText editText = this.f604f;
        if (editText != null) {
            Rect rect = this.S;
            f.b.a.e.q.d.a(this, editText, rect);
            f.b.a.e.v.g gVar = this.H;
            if (gVar != null) {
                int i12 = rect.bottom;
                gVar.setBounds(rect.left, i12 - this.P, rect.right, i12);
            }
            if (this.D) {
                f.b.a.e.q.c cVar = this.J0;
                float textSize = this.f604f.getTextSize();
                if (cVar.f2953j != textSize) {
                    cVar.f2953j = textSize;
                    cVar.k();
                }
                int gravity = this.f604f.getGravity();
                this.J0.n((gravity & -113) | 48);
                f.b.a.e.q.c cVar2 = this.J0;
                if (cVar2.f2951h != gravity) {
                    cVar2.f2951h = gravity;
                    cVar2.k();
                }
                f.b.a.e.q.c cVar3 = this.J0;
                if (this.f604f != null) {
                    Rect rect2 = this.T;
                    AtomicInteger atomicInteger = v.a;
                    boolean z3 = false;
                    boolean z4 = v.e.d(this) == 1;
                    rect2.bottom = rect.bottom;
                    int i13 = this.L;
                    if (i13 == 1) {
                        rect2.left = i(rect.left, z4);
                        i11 = rect.top + this.M;
                    } else if (i13 != 2) {
                        rect2.left = i(rect.left, z4);
                        i11 = getPaddingTop();
                    } else {
                        rect2.left = this.f604f.getPaddingLeft() + rect.left;
                        rect2.top = rect.top - g();
                        i6 = rect.right - this.f604f.getPaddingRight();
                        rect2.right = i6;
                        Objects.requireNonNull(cVar3);
                        i7 = rect2.left;
                        i8 = rect2.top;
                        i9 = rect2.right;
                        i10 = rect2.bottom;
                        if (!f.b.a.e.q.c.l(cVar3.f2949f, i7, i8, i9, i10)) {
                            cVar3.f2949f.set(i7, i8, i9, i10);
                            cVar3.E = true;
                            cVar3.j();
                        }
                        f.b.a.e.q.c cVar4 = this.J0;
                        if (this.f604f == null) {
                            Rect rect3 = this.T;
                            TextPaint textPaint = cVar4.G;
                            textPaint.setTextSize(cVar4.f2953j);
                            textPaint.setTypeface(cVar4.u);
                            textPaint.setLetterSpacing(0.0f);
                            float f2 = -cVar4.G.ascent();
                            rect3.left = this.f604f.getCompoundPaddingLeft() + rect.left;
                            rect3.top = this.L == 1 && this.f604f.getMinLines() <= 1 ? (int) (((float) rect.centerY()) - (f2 / 2.0f)) : rect.top + this.f604f.getCompoundPaddingTop();
                            rect3.right = rect.right - this.f604f.getCompoundPaddingRight();
                            if (this.L == 1 && this.f604f.getMinLines() <= 1) {
                                z3 = true;
                            }
                            int compoundPaddingBottom = z3 ? (int) (((float) rect3.top) + f2) : rect.bottom - this.f604f.getCompoundPaddingBottom();
                            rect3.bottom = compoundPaddingBottom;
                            int i14 = rect3.left;
                            int i15 = rect3.top;
                            int i16 = rect3.right;
                            if (!f.b.a.e.q.c.l(cVar4.f2948e, i14, i15, i16, compoundPaddingBottom)) {
                                cVar4.f2948e.set(i14, i15, i16, compoundPaddingBottom);
                                cVar4.E = true;
                                cVar4.j();
                            }
                            this.J0.k();
                            if (h() && !this.I0) {
                                o();
                                return;
                            }
                            return;
                        }
                        throw new IllegalStateException();
                    }
                    rect2.top = i11;
                    i6 = j(rect.right, z4);
                    rect2.right = i6;
                    Objects.requireNonNull(cVar3);
                    i7 = rect2.left;
                    i8 = rect2.top;
                    i9 = rect2.right;
                    i10 = rect2.bottom;
                    if (!f.b.a.e.q.c.l(cVar3.f2949f, i7, i8, i9, i10)) {
                    }
                    f.b.a.e.q.c cVar42 = this.J0;
                    if (this.f604f == null) {
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
        if (this.f604f != null && this.f604f.getMeasuredHeight() < (max = Math.max(this.f602d.getMeasuredHeight(), this.c.getMeasuredHeight()))) {
            this.f604f.setMinimumHeight(max);
            z2 = true;
        }
        boolean x2 = x();
        if (z2 || x2) {
            this.f604f.post(new c());
        }
        if (!(this.s == null || (editText = this.f604f) == null)) {
            this.s.setGravity(editText.getGravity());
            this.s.setPadding(this.f604f.getCompoundPaddingLeft(), this.f604f.getCompoundPaddingTop(), this.f604f.getCompoundPaddingRight(), this.f604f.getCompoundPaddingBottom());
        }
        C();
        F();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.b);
        setError(hVar.f612d);
        if (hVar.f613e) {
            this.k0.post(new b());
        }
        setHint(hVar.f614f);
        setHelperText(hVar.f615g);
        setPlaceholderText(hVar.f616h);
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (this.f608j.e()) {
            hVar.f612d = getError();
        }
        hVar.f613e = k() && this.k0.isChecked();
        hVar.f614f = getHint();
        hVar.f615g = getHelperText();
        hVar.f616h = getPlaceholderText();
        return hVar;
    }

    public void q() {
        r(this.k0, this.m0);
    }

    public final void r(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int[] drawableState = getDrawableState();
            int[] drawableState2 = checkableImageButton.getDrawableState();
            int length = drawableState.length;
            int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
            System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
            int colorForState = colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor());
            Drawable mutate = m.e.P1(drawable).mutate();
            mutate.setTintList(ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    public void setBoxBackgroundColor(int i2) {
        if (this.R != i2) {
            this.R = i2;
            this.D0 = i2;
            this.F0 = i2;
            this.G0 = i2;
            c();
        }
    }

    public void setBoxBackgroundColorResource(int i2) {
        setBoxBackgroundColor(e.i.b.a.a(getContext(), i2));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.D0 = defaultColor;
        this.R = defaultColor;
        this.E0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.F0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.G0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        c();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 != this.L) {
            this.L = i2;
            if (this.f604f != null) {
                n();
            }
        }
    }

    public void setBoxCollapsedPaddingTop(int i2) {
        this.M = i2;
    }

    public void setBoxStrokeColor(int i2) {
        if (this.B0 != i2) {
            this.B0 = i2;
            H();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        int defaultColor;
        if (colorStateList.isStateful()) {
            this.z0 = colorStateList.getDefaultColor();
            this.H0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.A0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            defaultColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else {
            if (this.B0 != colorStateList.getDefaultColor()) {
                defaultColor = colorStateList.getDefaultColor();
            }
            H();
        }
        this.B0 = defaultColor;
        H();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.C0 != colorStateList) {
            this.C0 = colorStateList;
            H();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.O = i2;
        H();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.P = i2;
        H();
    }

    public void setBoxStrokeWidthFocusedResource(int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z2) {
        if (this.f609k != z2) {
            if (z2) {
                d0 d0Var = new d0(getContext(), null);
                this.n = d0Var;
                d0Var.setId(R$id.textinput_counter);
                Typeface typeface = this.V;
                if (typeface != null) {
                    this.n.setTypeface(typeface);
                }
                this.n.setMaxLines(1);
                this.f608j.a(this.n, 2);
                ((ViewGroup.MarginLayoutParams) this.n.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_counter_margin_start));
                w();
                u();
            } else {
                this.f608j.j(this.n, 2);
                this.n = null;
            }
            this.f609k = z2;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.f610l != i2) {
            if (i2 <= 0) {
                i2 = -1;
            }
            this.f610l = i2;
            if (this.f609k) {
                u();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.o != i2) {
            this.o = i2;
            w();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.y != colorStateList) {
            this.y = colorStateList;
            w();
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.p != i2) {
            this.p = i2;
            w();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.x != colorStateList) {
            this.x = colorStateList;
            w();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.x0 = colorStateList;
        this.y0 = colorStateList;
        if (this.f604f != null) {
            A(false, false);
        }
    }

    public void setEnabled(boolean z2) {
        p(this, z2);
        super.setEnabled(z2);
    }

    public void setEndIconActivated(boolean z2) {
        this.k0.setActivated(z2);
    }

    public void setEndIconCheckable(boolean z2) {
        this.k0.setCheckable(z2);
    }

    public void setEndIconContentDescription(int i2) {
        setEndIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.k0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(int i2) {
        setEndIconDrawable(i2 != 0 ? m.e.h0(getContext(), i2) : null);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.k0.setImageDrawable(drawable);
        if (drawable != null) {
            d();
            q();
        }
    }

    public void setEndIconMode(int i2) {
        int i3 = this.i0;
        this.i0 = i2;
        Iterator<g> it = this.l0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i3);
        }
        setEndIconVisible(i2 != 0);
        if (getEndIconDelegate().b(this.L)) {
            getEndIconDelegate().a();
            d();
            return;
        }
        StringBuilder h2 = f.a.a.a.a.h("The current box background mode ");
        h2.append(this.L);
        h2.append(" is not supported by the end icon mode ");
        h2.append(i2);
        throw new IllegalStateException(h2.toString());
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.k0;
        View.OnLongClickListener onLongClickListener = this.t0;
        checkableImageButton.setOnClickListener(onClickListener);
        s(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.t0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.k0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        s(checkableImageButton, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.m0 != colorStateList) {
            this.m0 = colorStateList;
            this.n0 = true;
            d();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.o0 != mode) {
            this.o0 = mode;
            this.p0 = true;
            d();
        }
    }

    public void setEndIconVisible(boolean z2) {
        if (m() != z2) {
            this.k0.setVisibility(z2 ? 0 : 8);
            F();
            x();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.f608j.f3108k) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            n nVar = this.f608j;
            nVar.c();
            nVar.f3107j = charSequence;
            nVar.f3109l.setText(charSequence);
            int i2 = nVar.f3105h;
            if (i2 != 1) {
                nVar.f3106i = 1;
            }
            nVar.l(i2, nVar.f3106i, nVar.k(nVar.f3109l, charSequence));
            return;
        }
        this.f608j.i();
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        n nVar = this.f608j;
        nVar.m = charSequence;
        TextView textView = nVar.f3109l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z2) {
        n nVar = this.f608j;
        if (nVar.f3108k != z2) {
            nVar.c();
            if (z2) {
                d0 d0Var = new d0(nVar.a, null);
                nVar.f3109l = d0Var;
                d0Var.setId(R$id.textinput_error);
                nVar.f3109l.setTextAlignment(5);
                Typeface typeface = nVar.u;
                if (typeface != null) {
                    nVar.f3109l.setTypeface(typeface);
                }
                int i2 = nVar.n;
                nVar.n = i2;
                TextView textView = nVar.f3109l;
                if (textView != null) {
                    nVar.b.t(textView, i2);
                }
                ColorStateList colorStateList = nVar.o;
                nVar.o = colorStateList;
                TextView textView2 = nVar.f3109l;
                if (!(textView2 == null || colorStateList == null)) {
                    textView2.setTextColor(colorStateList);
                }
                CharSequence charSequence = nVar.m;
                nVar.m = charSequence;
                TextView textView3 = nVar.f3109l;
                if (textView3 != null) {
                    textView3.setContentDescription(charSequence);
                }
                nVar.f3109l.setVisibility(4);
                TextView textView4 = nVar.f3109l;
                AtomicInteger atomicInteger = v.a;
                v.g.f(textView4, 1);
                nVar.a(nVar.f3109l, 0);
            } else {
                nVar.i();
                nVar.j(nVar.f3109l, 0);
                nVar.f3109l = null;
                nVar.b.y();
                nVar.b.H();
            }
            nVar.f3108k = z2;
        }
    }

    public void setErrorIconDrawable(int i2) {
        setErrorIconDrawable(i2 != 0 ? m.e.h0(getContext(), i2) : null);
        r(this.v0, this.w0);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.v0;
        View.OnLongClickListener onLongClickListener = this.u0;
        checkableImageButton.setOnClickListener(onClickListener);
        s(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.u0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.v0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        s(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.w0 = colorStateList;
        Drawable drawable = this.v0.getDrawable();
        if (drawable != null) {
            drawable = m.e.P1(drawable).mutate();
            drawable.setTintList(colorStateList);
        }
        if (this.v0.getDrawable() != drawable) {
            this.v0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.v0.getDrawable();
        if (drawable != null) {
            drawable = m.e.P1(drawable).mutate();
            drawable.setTintMode(mode);
        }
        if (this.v0.getDrawable() != drawable) {
            this.v0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i2) {
        n nVar = this.f608j;
        nVar.n = i2;
        TextView textView = nVar.f3109l;
        if (textView != null) {
            nVar.b.t(textView, i2);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        n nVar = this.f608j;
        nVar.o = colorStateList;
        TextView textView = nVar.f3109l;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setExpandedHintEnabled(boolean z2) {
        if (this.K0 != z2) {
            this.K0 = z2;
            A(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!this.f608j.q) {
                setHelperTextEnabled(true);
            }
            n nVar = this.f608j;
            nVar.c();
            nVar.p = charSequence;
            nVar.r.setText(charSequence);
            int i2 = nVar.f3105h;
            if (i2 != 2) {
                nVar.f3106i = 2;
            }
            nVar.l(i2, nVar.f3106i, nVar.k(nVar.r, charSequence));
        } else if (this.f608j.q) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        n nVar = this.f608j;
        nVar.t = colorStateList;
        TextView textView = nVar.r;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setHelperTextEnabled(boolean z2) {
        n nVar = this.f608j;
        if (nVar.q != z2) {
            nVar.c();
            if (z2) {
                d0 d0Var = new d0(nVar.a, null);
                nVar.r = d0Var;
                d0Var.setId(R$id.textinput_helper_text);
                nVar.r.setTextAlignment(5);
                Typeface typeface = nVar.u;
                if (typeface != null) {
                    nVar.r.setTypeface(typeface);
                }
                nVar.r.setVisibility(4);
                TextView textView = nVar.r;
                AtomicInteger atomicInteger = v.a;
                v.g.f(textView, 1);
                int i2 = nVar.s;
                nVar.s = i2;
                TextView textView2 = nVar.r;
                if (textView2 != null) {
                    m.e.v1(textView2, i2);
                }
                ColorStateList colorStateList = nVar.t;
                nVar.t = colorStateList;
                TextView textView3 = nVar.r;
                if (!(textView3 == null || colorStateList == null)) {
                    textView3.setTextColor(colorStateList);
                }
                nVar.a(nVar.r, 1);
            } else {
                nVar.c();
                int i3 = nVar.f3105h;
                if (i3 == 2) {
                    nVar.f3106i = 0;
                }
                nVar.l(i3, nVar.f3106i, nVar.k(nVar.r, null));
                nVar.j(nVar.r, 1);
                nVar.r = null;
                nVar.b.y();
                nVar.b.H();
            }
            nVar.q = z2;
        }
    }

    public void setHelperTextTextAppearance(int i2) {
        n nVar = this.f608j;
        nVar.s = i2;
        TextView textView = nVar.r;
        if (textView != null) {
            m.e.v1(textView, i2);
        }
    }

    public void setHint(int i2) {
        setHint(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setHint(CharSequence charSequence) {
        if (this.D) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z2) {
        this.L0 = z2;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.D) {
            this.D = z2;
            if (!z2) {
                this.F = false;
                if (!TextUtils.isEmpty(this.E) && TextUtils.isEmpty(this.f604f.getHint())) {
                    this.f604f.setHint(this.E);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f604f.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.E)) {
                        setHint(hint);
                    }
                    this.f604f.setHint((CharSequence) null);
                }
                this.F = true;
            }
            if (this.f604f != null) {
                z();
            }
        }
    }

    public void setHintTextAppearance(int i2) {
        f.b.a.e.q.c cVar = this.J0;
        f.b.a.e.s.b bVar = new f.b.a.e.s.b(cVar.a.getContext(), i2);
        ColorStateList colorStateList = bVar.f3014j;
        if (colorStateList != null) {
            cVar.m = colorStateList;
        }
        float f2 = bVar.f3015k;
        if (f2 != 0.0f) {
            cVar.f2954k = f2;
        }
        ColorStateList colorStateList2 = bVar.a;
        if (colorStateList2 != null) {
            cVar.M = colorStateList2;
        }
        cVar.K = bVar.f3009e;
        cVar.L = bVar.f3010f;
        cVar.J = bVar.f3011g;
        cVar.N = bVar.f3013i;
        f.b.a.e.s.a aVar = cVar.w;
        if (aVar != null) {
            aVar.c = true;
        }
        f.b.a.e.q.b bVar2 = new f.b.a.e.q.b(cVar);
        bVar.a();
        cVar.w = new f.b.a.e.s.a(bVar2, bVar.n);
        bVar.c(cVar.a.getContext(), cVar.w);
        cVar.k();
        this.y0 = this.J0.m;
        if (this.f604f != null) {
            A(false, false);
            z();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.y0 != colorStateList) {
            if (this.x0 == null) {
                f.b.a.e.q.c cVar = this.J0;
                if (cVar.m != colorStateList) {
                    cVar.m = colorStateList;
                    cVar.k();
                }
            }
            this.y0 = colorStateList;
            if (this.f604f != null) {
                A(false, false);
            }
        }
    }

    public void setMaxWidth(int i2) {
        this.f607i = i2;
        EditText editText = this.f604f;
        if (editText != null && i2 != -1) {
            editText.setMaxWidth(i2);
        }
    }

    public void setMaxWidthResource(int i2) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    public void setMinWidth(int i2) {
        this.f606h = i2;
        EditText editText = this.f604f;
        if (editText != null && i2 != -1) {
            editText.setMinWidth(i2);
        }
    }

    public void setMinWidthResource(int i2) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.k0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? m.e.h0(getContext(), i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.k0.setImageDrawable(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z2) {
        if (z2 && this.i0 != 1) {
            setEndIconMode(1);
        } else if (!z2) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.m0 = colorStateList;
        this.n0 = true;
        d();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.o0 = mode;
        this.p0 = true;
        d();
    }

    public void setPlaceholderText(CharSequence charSequence) {
        int i2 = 0;
        if (!this.r || !TextUtils.isEmpty(charSequence)) {
            if (!this.r) {
                setPlaceholderTextEnabled(true);
            }
            this.q = charSequence;
        } else {
            setPlaceholderTextEnabled(false);
        }
        EditText editText = this.f604f;
        if (editText != null) {
            i2 = editText.getText().length();
        }
        B(i2);
    }

    public void setPlaceholderTextAppearance(int i2) {
        this.u = i2;
        TextView textView = this.s;
        if (textView != null) {
            m.e.v1(textView, i2);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.t != colorStateList) {
            this.t = colorStateList;
            TextView textView = this.s;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.z = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.A.setText(charSequence);
        D();
    }

    public void setPrefixTextAppearance(int i2) {
        m.e.v1(this.A, i2);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.A.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z2) {
        this.W.setCheckable(z2);
    }

    public void setStartIconContentDescription(int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.W.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i2) {
        setStartIconDrawable(i2 != 0 ? m.e.h0(getContext(), i2) : null);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.W.setImageDrawable(drawable);
        if (drawable != null) {
            f();
            setStartIconVisible(true);
            r(this.W, this.a0);
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.W;
        View.OnLongClickListener onLongClickListener = this.g0;
        checkableImageButton.setOnClickListener(onClickListener);
        s(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.g0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.W;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        s(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.a0 != colorStateList) {
            this.a0 = colorStateList;
            this.b0 = true;
            f();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.c0 != mode) {
            this.c0 = mode;
            this.d0 = true;
            f();
        }
    }

    public void setStartIconVisible(boolean z2) {
        int i2 = 0;
        if ((this.W.getVisibility() == 0) != z2) {
            CheckableImageButton checkableImageButton = this.W;
            if (!z2) {
                i2 = 8;
            }
            checkableImageButton.setVisibility(i2);
            C();
            x();
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.B = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.C.setText(charSequence);
        G();
    }

    public void setSuffixTextAppearance(int i2) {
        m.e.v1(this.C, i2);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.C.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f604f;
        if (editText != null) {
            v.u(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.V) {
            this.V = typeface;
            this.J0.q(typeface);
            n nVar = this.f608j;
            if (typeface != nVar.u) {
                nVar.u = typeface;
                TextView textView = nVar.f3109l;
                if (textView != null) {
                    textView.setTypeface(typeface);
                }
                TextView textView2 = nVar.r;
                if (textView2 != null) {
                    textView2.setTypeface(typeface);
                }
            }
            TextView textView3 = this.n;
            if (textView3 != null) {
                textView3.setTypeface(typeface);
            }
        }
    }

    public void t(TextView textView, int i2) {
        boolean z2 = true;
        try {
            m.e.v1(textView, i2);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z2 = false;
            }
        } catch (Exception unused) {
        }
        if (z2) {
            m.e.v1(textView, R$style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(e.i.b.a.a(getContext(), R$color.design_error));
        }
    }

    public final void u() {
        if (this.n != null) {
            EditText editText = this.f604f;
            v(editText == null ? 0 : editText.getText().length());
        }
    }

    public void v(int i2) {
        boolean z2 = this.m;
        int i3 = this.f610l;
        if (i3 == -1) {
            this.n.setText(String.valueOf(i2));
            this.n.setContentDescription(null);
            this.m = false;
        } else {
            this.m = i2 > i3;
            Context context = getContext();
            this.n.setContentDescription(context.getString(this.m ? R$string.character_counter_overflowed_content_description : R$string.character_counter_content_description, Integer.valueOf(i2), Integer.valueOf(this.f610l)));
            if (z2 != this.m) {
                w();
            }
            this.n.setText(e.i.g.a.c().e(getContext().getString(R$string.character_counter_pattern, Integer.valueOf(i2), Integer.valueOf(this.f610l))));
        }
        if (this.f604f != null && z2 != this.m) {
            A(false, false);
            H();
            y();
        }
    }

    public final void w() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.n;
        if (textView != null) {
            t(textView, this.m ? this.o : this.p);
            if (!this.m && (colorStateList2 = this.x) != null) {
                this.n.setTextColor(colorStateList2);
            }
            if (this.m && (colorStateList = this.y) != null) {
                this.n.setTextColor(colorStateList);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0104  */
    public final boolean x() {
        boolean z2;
        if (this.f604f == null) {
            return false;
        }
        boolean z3 = true;
        if (!(getStartIconDrawable() == null && this.z == null) && this.c.getMeasuredWidth() > 0) {
            int measuredWidth = this.c.getMeasuredWidth() - this.f604f.getPaddingLeft();
            if (this.e0 == null || this.f0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.e0 = colorDrawable;
                this.f0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = this.f604f.getCompoundDrawablesRelative();
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.e0;
            if (drawable != drawable2) {
                this.f604f.setCompoundDrawablesRelative(drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
            }
            z2 = false;
            if ((this.v0.getVisibility() != 0 || ((k() && m()) || this.B != null)) && this.f602d.getMeasuredWidth() > 0) {
                int measuredWidth2 = this.C.getMeasuredWidth() - this.f604f.getPaddingRight();
                CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
                if (endIconToUpdateDummyDrawable != null) {
                    measuredWidth2 = ((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams()).getMarginStart() + endIconToUpdateDummyDrawable.getMeasuredWidth() + measuredWidth2;
                }
                Drawable[] compoundDrawablesRelative2 = this.f604f.getCompoundDrawablesRelative();
                Drawable drawable3 = this.q0;
                if (drawable3 == null || this.r0 == measuredWidth2) {
                    if (drawable3 == null) {
                        ColorDrawable colorDrawable2 = new ColorDrawable();
                        this.q0 = colorDrawable2;
                        this.r0 = measuredWidth2;
                        colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                    }
                    Drawable drawable4 = compoundDrawablesRelative2[2];
                    Drawable drawable5 = this.q0;
                    if (drawable4 != drawable5) {
                        this.s0 = compoundDrawablesRelative2[2];
                        this.f604f.setCompoundDrawablesRelative(compoundDrawablesRelative2[0], compoundDrawablesRelative2[1], drawable5, compoundDrawablesRelative2[3]);
                    } else {
                        z3 = z2;
                    }
                } else {
                    this.r0 = measuredWidth2;
                    drawable3.setBounds(0, 0, measuredWidth2, 1);
                    this.f604f.setCompoundDrawablesRelative(compoundDrawablesRelative2[0], compoundDrawablesRelative2[1], this.q0, compoundDrawablesRelative2[3]);
                }
            } else if (this.q0 == null) {
                return z2;
            } else {
                Drawable[] compoundDrawablesRelative3 = this.f604f.getCompoundDrawablesRelative();
                if (compoundDrawablesRelative3[2] == this.q0) {
                    this.f604f.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.s0, compoundDrawablesRelative3[3]);
                } else {
                    z3 = z2;
                }
                this.q0 = null;
            }
            return z3;
        }
        if (this.e0 != null) {
            Drawable[] compoundDrawablesRelative4 = this.f604f.getCompoundDrawablesRelative();
            this.f604f.setCompoundDrawablesRelative(null, compoundDrawablesRelative4[1], compoundDrawablesRelative4[2], compoundDrawablesRelative4[3]);
            this.e0 = null;
        }
        z2 = false;
        if ((this.v0.getVisibility() != 0 || ((k() && m()) || this.B != null)) && this.f602d.getMeasuredWidth() > 0) {
        }
        return z3;
        z2 = true;
        if ((this.v0.getVisibility() != 0 || ((k() && m()) || this.B != null)) && this.f602d.getMeasuredWidth() > 0) {
        }
        return z3;
    }

    public void y() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.f604f;
        if (editText != null && this.L == 0 && (background = editText.getBackground()) != null) {
            if (i0.a(background)) {
                background = background.mutate();
            }
            if (this.f608j.e()) {
                currentTextColor = this.f608j.g();
            } else if (!this.m || (textView = this.n) == null) {
                m.e.w(background);
                this.f604f.refreshDrawableState();
                return;
            } else {
                currentTextColor = textView.getCurrentTextColor();
            }
            background.setColorFilter(e.b.f.k.c(currentTextColor, PorterDuff.Mode.SRC_IN));
        }
    }

    public final void z() {
        if (this.L != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            int g2 = g();
            if (g2 != layoutParams.topMargin) {
                layoutParams.topMargin = g2;
                this.b.requestLayout();
            }
        }
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.v0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.f608j.f3108k);
    }
}
