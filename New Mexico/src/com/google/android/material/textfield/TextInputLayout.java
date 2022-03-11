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
import e.j.j.v;
import e.z.l;
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
/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {
    public static final int O0 = R$style.Widget_Design_TextInputLayout;
    public final TextView A;
    public int A0;
    public CharSequence B;
    public ColorStateList B0;
    public final TextView C;
    public int C0;
    public boolean D;
    public int D0;
    public CharSequence E;
    public int E0;
    public boolean F;
    public int F0;
    public f.b.a.e.v.g G;
    public int G0;
    public f.b.a.e.v.g H;
    public boolean H0;
    public j I;
    public final f.b.a.e.q.c I0;
    public final int J;
    public boolean J0;
    public int K;
    public boolean K0;
    public int L;
    public ValueAnimator L0;
    public int M;
    public boolean M0;
    public int N;
    public boolean N0;
    public int O;
    public int P;
    public int Q;
    public Typeface U;
    public final CheckableImageButton V;
    public ColorStateList W;
    public boolean a0;
    public final FrameLayout b;
    public PorterDuff.Mode b0;
    public final LinearLayout c;
    public boolean c0;

    /* renamed from: d */
    public final LinearLayout f616d;
    public Drawable d0;

    /* renamed from: e */
    public final FrameLayout f617e;
    public int e0;

    /* renamed from: f */
    public EditText f618f;
    public View.OnLongClickListener f0;

    /* renamed from: g */
    public CharSequence f619g;
    public final CheckableImageButton j0;

    /* renamed from: k */
    public boolean f623k;

    /* renamed from: l */
    public int f624l;
    public ColorStateList l0;
    public boolean m;
    public boolean m0;
    public TextView n;
    public PorterDuff.Mode n0;
    public int o;
    public boolean o0;
    public int p;
    public Drawable p0;
    public CharSequence q;
    public int q0;
    public boolean r;
    public Drawable r0;
    public TextView s;
    public View.OnLongClickListener s0;
    public ColorStateList t;
    public View.OnLongClickListener t0;
    public int u;
    public final CheckableImageButton u0;
    public e.z.c v;
    public ColorStateList v0;
    public e.z.c w;
    public ColorStateList w0;
    public ColorStateList x;
    public ColorStateList x0;
    public ColorStateList y;
    public int y0;
    public CharSequence z;
    public int z0;

    /* renamed from: h */
    public int f620h = -1;

    /* renamed from: i */
    public int f621i = -1;

    /* renamed from: j */
    public final n f622j = new n(this);
    public final Rect R = new Rect();
    public final Rect S = new Rect();
    public final RectF T = new RectF();
    public final LinkedHashSet<f> g0 = new LinkedHashSet<>();
    public int h0 = 0;
    public final SparseArray<m> i0 = new SparseArray<>();
    public final LinkedHashSet<g> k0 = new LinkedHashSet<>();

    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        public a() {
            TextInputLayout.this = r1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.A(!textInputLayout.N0, false);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f623k) {
                textInputLayout2.v(editable.length());
            }
            TextInputLayout textInputLayout3 = TextInputLayout.this;
            if (textInputLayout3.r) {
                textInputLayout3.B(editable.length());
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
    public class b implements Runnable {
        public b() {
            TextInputLayout.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.j0.performClick();
            TextInputLayout.this.j0.jumpDrawablesToCurrentState();
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
            TextInputLayout.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            TextInputLayout.this.f618f.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
            TextInputLayout.this = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.I0.n(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes.dex */
    public static class e extends e.j.j.c {

        /* renamed from: d */
        public final TextInputLayout f625d;

        public e(TextInputLayout textInputLayout) {
            this.f625d = textInputLayout;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x008e, code lost:
            if (r3 != null) goto L_0x0088;
         */
        @Override // e.j.j.c
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void d(View view, e.j.j.c0.b bVar) {
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
            EditText editText = this.f625d.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f625d.getHint();
            CharSequence error = this.f625d.getError();
            CharSequence placeholderText = this.f625d.getPlaceholderText();
            int counterMaxLength = this.f625d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f625d.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !this.f625d.H0;
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z2 ? hint.toString() : "";
            if (z) {
                bVar.a.setText(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                bVar.a.setText(charSequence);
                if (z3 && placeholderText != null) {
                    placeholderText = charSequence + ", " + ((Object) placeholderText);
                    bVar.a.setText(placeholderText);
                }
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

    /* loaded from: classes.dex */
    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(TextInputLayout textInputLayout, int i2);
    }

    /* loaded from: classes.dex */
    public static class h extends e.l.a.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: d */
        public CharSequence f626d;

        /* renamed from: e */
        public boolean f627e;

        /* renamed from: f */
        public CharSequence f628f;

        /* renamed from: g */
        public CharSequence f629g;

        /* renamed from: h */
        public CharSequence f630h;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.ClassLoaderCreator<h> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i2) {
                return new h[i2];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f626d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f627e = parcel.readInt() != 1 ? false : true;
            this.f628f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f629g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f630h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("TextInputLayout.SavedState{");
            h2.append(Integer.toHexString(System.identityHashCode(this)));
            h2.append(" error=");
            h2.append((Object) this.f626d);
            h2.append(" hint=");
            h2.append((Object) this.f628f);
            h2.append(" helperText=");
            h2.append((Object) this.f629g);
            h2.append(" placeholderText=");
            h2.append((Object) this.f630h);
            h2.append("}");
            return h2.toString();
        }

        @Override // e.l.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.b, i2);
            TextUtils.writeToParcel(this.f626d, parcel, i2);
            parcel.writeInt(this.f627e ? 1 : 0);
            TextUtils.writeToParcel(this.f628f, parcel, i2);
            TextUtils.writeToParcel(this.f629g, parcel, i2);
            TextUtils.writeToParcel(this.f630h, parcel, i2);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x05c4  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x05d3  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0600  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x060f  */
    /* JADX WARN: Type inference failed for: r2v154 */
    /* JADX WARN: Type inference failed for: r2v155 */
    /* JADX WARN: Type inference failed for: r2v47, types: [int, boolean] */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
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
        int i16 = O0;
        f.b.a.e.q.c cVar = new f.b.a.e.q.c(this);
        this.I0 = cVar;
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
        this.f616d = linearLayout2;
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout.addView(linearLayout2);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f617e = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator timeInterpolator = f.b.a.e.a.a.a;
        cVar.I = timeInterpolator;
        cVar.j();
        cVar.H = timeInterpolator;
        cVar.j();
        cVar.m(8388659);
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
        this.K0 = c1Var.a(R$styleable.TextInputLayout_hintAnimationEnabled, true);
        this.J0 = c1Var.a(R$styleable.TextInputLayout_expandedHintEnabled, true);
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
        this.L = c1Var.e(R$styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.N = c1Var.f(R$styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_default));
        this.O = c1Var.f(R$styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_focused));
        this.M = this.N;
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
        ColorStateList z0 = f.b.a.c.b.o.b.z0(context2, c1Var, R$styleable.TextInputLayout_boxBackgroundColor);
        if (z0 != null) {
            int defaultColor = z0.getDefaultColor();
            this.C0 = defaultColor;
            this.Q = defaultColor;
            if (z0.isStateful()) {
                this.D0 = z0.getColorForState(new int[]{-16842910}, -1);
                i3 = 2;
                this.E0 = z0.getColorForState(new int[]{16842908, 16842910}, -1);
                i14 = z0.getColorForState(new int[]{16843623, 16842910}, -1);
            } else {
                i3 = 2;
                this.E0 = this.C0;
                ColorStateList g0 = m.e.g0(context2, R$color.mtrl_filled_background_color);
                this.D0 = g0.getColorForState(new int[]{-16842910}, -1);
                i14 = g0.getColorForState(new int[]{16843623}, -1);
            }
            this.F0 = i14;
        } else {
            i3 = 2;
            this.Q = 0;
            this.C0 = 0;
            this.D0 = 0;
            this.E0 = 0;
            this.F0 = 0;
        }
        int i24 = R$styleable.TextInputLayout_android_textColorHint;
        if (c1Var.o(i24)) {
            ColorStateList c2 = c1Var.c(i24);
            this.x0 = c2;
            this.w0 = c2;
        }
        int i25 = R$styleable.TextInputLayout_boxStrokeColor;
        ColorStateList z02 = f.b.a.c.b.o.b.z0(context2, c1Var, i25);
        this.A0 = c1Var.b(i25, 0);
        this.y0 = e.j.b.a.a(context2, R$color.mtrl_textinput_default_box_stroke_color);
        this.G0 = e.j.b.a.a(context2, R$color.mtrl_textinput_disabled_color);
        this.z0 = e.j.b.a.a(context2, R$color.mtrl_textinput_hovered_box_stroke_color);
        if (z02 != null) {
            setBoxStrokeColorStateList(z02);
        }
        int i26 = R$styleable.TextInputLayout_boxStrokeErrorColor;
        if (c1Var.o(i26)) {
            setBoxStrokeErrorColor(f.b.a.c.b.o.b.z0(context2, c1Var, i26));
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
        CharSequence n = c1Var.n(R$styleable.TextInputLayout_errorContentDescription);
        boolean a2 = c1Var.a(R$styleable.TextInputLayout_errorEnabled, r2);
        LayoutInflater from = LayoutInflater.from(getContext());
        int i30 = R$layout.design_text_input_end_icon;
        CheckableImageButton checkableImageButton = (CheckableImageButton) from.inflate(i30, linearLayout2, (boolean) r2);
        this.u0 = checkableImageButton;
        checkableImageButton.setId(R$id.text_input_error_icon);
        checkableImageButton.setVisibility(8);
        if (f.b.a.c.b.o.b.U0(context2)) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(r2);
        }
        int i31 = R$styleable.TextInputLayout_errorIconDrawable;
        if (c1Var.o(i31)) {
            setErrorIconDrawable(c1Var.g(i31));
        }
        int i32 = R$styleable.TextInputLayout_errorIconTint;
        if (c1Var.o(i32)) {
            setErrorIconTintList(f.b.a.c.b.o.b.z0(context2, c1Var, i32));
        }
        int i33 = R$styleable.TextInputLayout_errorIconTintMode;
        if (c1Var.o(i33)) {
            setErrorIconTintMode(f.b.a.c.b.o.b.g1(c1Var.j(i33, -1), null));
        }
        checkableImageButton.setContentDescription(getResources().getText(R$string.error_icon_content_description));
        AtomicInteger atomicInteger = v.a;
        v.d.s(checkableImageButton, i3);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int l3 = c1Var.l(i20, 0);
        boolean a3 = c1Var.a(R$styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence n2 = c1Var.n(R$styleable.TextInputLayout_helperText);
        int l4 = c1Var.l(R$styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence n3 = c1Var.n(R$styleable.TextInputLayout_placeholderText);
        int l5 = c1Var.l(R$styleable.TextInputLayout_prefixTextAppearance, 0);
        CharSequence n4 = c1Var.n(R$styleable.TextInputLayout_prefixText);
        int l6 = c1Var.l(R$styleable.TextInputLayout_suffixTextAppearance, 0);
        CharSequence n5 = c1Var.n(R$styleable.TextInputLayout_suffixText);
        boolean a4 = c1Var.a(R$styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(c1Var.j(R$styleable.TextInputLayout_counterMaxLength, -1));
        this.p = c1Var.l(i17, 0);
        this.o = c1Var.l(i18, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_start_icon, (ViewGroup) this.c, false);
        this.V = checkableImageButton2;
        checkableImageButton2.setVisibility(8);
        if (f.b.a.c.b.o.b.U0(context2)) {
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
            setStartIconTintList(f.b.a.c.b.o.b.z0(context2, c1Var, i36));
        }
        int i37 = R$styleable.TextInputLayout_startIconTintMode;
        if (c1Var.o(i37)) {
            setStartIconTintMode(f.b.a.c.b.o.b.g1(c1Var.j(i37, -1), null));
        }
        setBoxBackgroundMode(c1Var.j(R$styleable.TextInputLayout_boxBackgroundMode, 0));
        this.j0 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(i30, (ViewGroup) this.f617e, false);
        this.f617e.addView(this.j0);
        this.j0.setVisibility(8);
        if (f.b.a.c.b.o.b.U0(context2)) {
            i4 = 0;
            ((ViewGroup.MarginLayoutParams) this.j0.getLayoutParams()).setMarginStart(0);
        } else {
            i4 = 0;
        }
        int l7 = c1Var.l(R$styleable.TextInputLayout_endIconDrawable, i4);
        this.i0.append(-1, new f.b.a.e.y.f(this, l7));
        this.i0.append(i4, new q(this));
        this.i0.append(1, new r(this, l7 == 0 ? c1Var.l(R$styleable.TextInputLayout_passwordToggleDrawable, i4) : l7));
        this.i0.append(2, new f.b.a.e.y.a(this, l7));
        this.i0.append(3, new f.b.a.e.y.h(this, l7));
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
                    setEndIconTintList(f.b.a.c.b.o.b.z0(context2, c1Var, i41));
                }
                int i42 = R$styleable.TextInputLayout_passwordToggleTintMode;
                if (c1Var.o(i42)) {
                    setEndIconTintMode(f.b.a.c.b.o.b.g1(c1Var.j(i42, -1), null));
                }
            }
        }
        if (!c1Var.o(R$styleable.TextInputLayout_passwordToggleEnabled)) {
            int i43 = R$styleable.TextInputLayout_endIconTint;
            if (c1Var.o(i43)) {
                setEndIconTintList(f.b.a.c.b.o.b.z0(context2, c1Var, i43));
            }
            int i44 = R$styleable.TextInputLayout_endIconTintMode;
            if (c1Var.o(i44)) {
                attributeSet2 = null;
                setEndIconTintMode(f.b.a.c.b.o.b.g1(c1Var.j(i44, -1), null));
                d0 d0Var = new d0(context2, attributeSet2);
                this.A = d0Var;
                d0Var.setId(R$id.textinput_prefix_text);
                d0Var.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                v.g.f(d0Var, 1);
                this.c.addView(this.V);
                this.c.addView(d0Var);
                d0 d0Var2 = new d0(context2, null);
                this.C = d0Var2;
                d0Var2.setId(R$id.textinput_suffix_text);
                d0Var2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
                v.g.f(d0Var2, 1);
                this.f616d.addView(this.C);
                this.f616d.addView(this.u0);
                this.f616d.addView(this.f617e);
                setHelperTextEnabled(a3);
                setHelperText(n2);
                setHelperTextTextAppearance(l3);
                setErrorEnabled(a2);
                setErrorTextAppearance(l2);
                setErrorContentDescription(n);
                setCounterTextAppearance(this.p);
                setCounterOverflowTextAppearance(this.o);
                setPlaceholderText(n3);
                setPlaceholderTextAppearance(l4);
                setPrefixText(n4);
                setPrefixTextAppearance(l5);
                setSuffixText(n5);
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
        this.c.addView(this.V);
        this.c.addView(d0Var3);
        d0 d0Var22 = new d0(context2, null);
        this.C = d0Var22;
        d0Var22.setId(R$id.textinput_suffix_text);
        d0Var22.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        v.g.f(d0Var22, 1);
        this.f616d.addView(this.C);
        this.f616d.addView(this.u0);
        this.f616d.addView(this.f617e);
        setHelperTextEnabled(a3);
        setHelperText(n2);
        setHelperTextTextAppearance(l3);
        setErrorEnabled(a2);
        setErrorTextAppearance(l2);
        setErrorContentDescription(n);
        setCounterTextAppearance(this.p);
        setCounterOverflowTextAppearance(this.o);
        setPlaceholderText(n3);
        setPlaceholderTextAppearance(l4);
        setPrefixText(n4);
        setPrefixTextAppearance(l5);
        setSuffixText(n5);
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
        f.b.a.e.y.m mVar = this.i0.get(this.h0);
        return mVar != null ? mVar : this.i0.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.u0.getVisibility() == 0) {
            return this.u0;
        }
        if (!k() || !m()) {
            return null;
        }
        return this.j0;
    }

    public static void p(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                p((ViewGroup) childAt, z);
            }
        }
    }

    public static void s(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        AtomicInteger atomicInteger = v.a;
        boolean a2 = v.c.a(checkableImageButton);
        boolean z = false;
        int i2 = 1;
        boolean z2 = onLongClickListener != null;
        if (a2 || z2) {
            z = true;
        }
        checkableImageButton.setFocusable(z);
        checkableImageButton.setClickable(a2);
        checkableImageButton.setPressable(a2);
        checkableImageButton.setLongClickable(z2);
        if (!z) {
            i2 = 2;
        }
        v.d.s(checkableImageButton, i2);
    }

    private void setEditText(EditText editText) {
        if (this.f618f == null) {
            if (this.h0 != 3) {
                boolean z = editText instanceof TextInputEditText;
            }
            this.f618f = editText;
            setMinWidth(this.f620h);
            setMaxWidth(this.f621i);
            n();
            setTextInputAccessibilityDelegate(new e(this));
            this.I0.p(this.f618f.getTypeface());
            f.b.a.e.q.c cVar = this.I0;
            float textSize = this.f618f.getTextSize();
            if (cVar.f2995j != textSize) {
                cVar.f2995j = textSize;
                cVar.j();
            }
            int gravity = this.f618f.getGravity();
            this.I0.m((gravity & -113) | 48);
            f.b.a.e.q.c cVar2 = this.I0;
            if (cVar2.f2993h != gravity) {
                cVar2.f2993h = gravity;
                cVar2.j();
            }
            this.f618f.addTextChangedListener(new a());
            if (this.w0 == null) {
                this.w0 = this.f618f.getHintTextColors();
            }
            if (this.D) {
                if (TextUtils.isEmpty(this.E)) {
                    CharSequence hint = this.f618f.getHint();
                    this.f619g = hint;
                    setHint(hint);
                    this.f618f.setHint((CharSequence) null);
                }
                this.F = true;
            }
            if (this.n != null) {
                v(this.f618f.getText().length());
            }
            y();
            this.f622j.b();
            this.c.bringToFront();
            this.f616d.bringToFront();
            this.f617e.bringToFront();
            this.u0.bringToFront();
            Iterator<f> it = this.g0.iterator();
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

    private void setErrorIconVisible(boolean z) {
        int i2 = 0;
        this.u0.setVisibility(z ? 0 : 8);
        FrameLayout frameLayout = this.f617e;
        if (z) {
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
            f.b.a.e.q.c cVar = this.I0;
            if (charSequence == null || !TextUtils.equals(cVar.x, charSequence)) {
                cVar.x = charSequence;
                cVar.y = null;
                Bitmap bitmap = cVar.A;
                if (bitmap != null) {
                    bitmap.recycle();
                    cVar.A = null;
                }
                cVar.j();
            }
            if (!this.H0) {
                o();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.r != z) {
            if (z) {
                d0 d0Var = new d0(getContext(), null);
                this.s = d0Var;
                d0Var.setId(R$id.textinput_placeholder);
                e.z.c cVar = new e.z.c();
                cVar.f2131d = 87;
                TimeInterpolator timeInterpolator = f.b.a.e.a.a.a;
                cVar.f2132e = timeInterpolator;
                this.v = cVar;
                cVar.c = 67;
                e.z.c cVar2 = new e.z.c();
                cVar2.f2131d = 87;
                cVar2.f2132e = timeInterpolator;
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
            this.r = z;
        }
    }

    public final void A(boolean z, boolean z2) {
        f.b.a.e.q.c cVar;
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f618f;
        int i2 = 0;
        boolean z3 = editText != null && !TextUtils.isEmpty(editText.getText());
        EditText editText2 = this.f618f;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean e2 = this.f622j.e();
        ColorStateList colorStateList2 = this.w0;
        if (colorStateList2 != null) {
            f.b.a.e.q.c cVar2 = this.I0;
            if (cVar2.m != colorStateList2) {
                cVar2.m = colorStateList2;
                cVar2.j();
            }
            f.b.a.e.q.c cVar3 = this.I0;
            ColorStateList colorStateList3 = this.w0;
            if (cVar3.f2997l != colorStateList3) {
                cVar3.f2997l = colorStateList3;
                cVar3.j();
            }
        }
        if (!isEnabled) {
            ColorStateList colorStateList4 = this.w0;
            int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(new int[]{-16842910}, this.G0) : this.G0;
            this.I0.l(ColorStateList.valueOf(colorForState));
            f.b.a.e.q.c cVar4 = this.I0;
            ColorStateList valueOf = ColorStateList.valueOf(colorForState);
            if (cVar4.f2997l != valueOf) {
                cVar4.f2997l = valueOf;
                cVar4.j();
            }
        } else if (e2) {
            f.b.a.e.q.c cVar5 = this.I0;
            TextView textView2 = this.f622j.f3151l;
            cVar5.l(textView2 != null ? textView2.getTextColors() : null);
        } else {
            if (this.m && (textView = this.n) != null) {
                cVar = this.I0;
                colorStateList = textView.getTextColors();
            } else if (z4 && (colorStateList = this.x0) != null) {
                cVar = this.I0;
            }
            cVar.l(colorStateList);
        }
        if (z3 || !this.J0 || (isEnabled() && z4)) {
            if (z2 || this.H0) {
                ValueAnimator valueAnimator = this.L0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.L0.cancel();
                }
                if (!z || !this.K0) {
                    this.I0.n(1.0f);
                } else {
                    b(1.0f);
                }
                this.H0 = false;
                if (h()) {
                    o();
                }
                EditText editText3 = this.f618f;
                if (editText3 != null) {
                    i2 = editText3.getText().length();
                }
                B(i2);
                D();
                G();
            }
        } else if (z2 || !this.H0) {
            ValueAnimator valueAnimator2 = this.L0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.L0.cancel();
            }
            if (!z || !this.K0) {
                this.I0.n(0.0f);
            } else {
                b(0.0f);
            }
            if (h() && (!((f.b.a.e.y.g) this.G).B.isEmpty()) && h()) {
                ((f.b.a.e.y.g) this.G).A(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.H0 = true;
            l();
            D();
            G();
        }
    }

    public final void B(int i2) {
        if (i2 != 0 || this.H0) {
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
        if (this.f618f != null) {
            int i2 = 0;
            if (!(this.V.getVisibility() == 0)) {
                EditText editText = this.f618f;
                AtomicInteger atomicInteger = v.a;
                i2 = v.e.f(editText);
            }
            TextView textView = this.A;
            int compoundPaddingTop = this.f618f.getCompoundPaddingTop();
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding);
            int compoundPaddingBottom = this.f618f.getCompoundPaddingBottom();
            AtomicInteger atomicInteger2 = v.a;
            v.e.k(textView, i2, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
        }
    }

    public final void D() {
        this.A.setVisibility((this.z == null || this.H0) ? 8 : 0);
        x();
    }

    public final void E(boolean z, boolean z2) {
        int defaultColor = this.B0.getDefaultColor();
        int colorForState = this.B0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.B0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z) {
            this.P = colorForState2;
        } else if (z2) {
            this.P = colorForState;
        } else {
            this.P = defaultColor;
        }
    }

    public final void F() {
        if (this.f618f != null) {
            int i2 = 0;
            if (!m()) {
                if (!(this.u0.getVisibility() == 0)) {
                    EditText editText = this.f618f;
                    AtomicInteger atomicInteger = v.a;
                    i2 = v.e.e(editText);
                }
            }
            TextView textView = this.C;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding);
            int paddingTop = this.f618f.getPaddingTop();
            int paddingBottom = this.f618f.getPaddingBottom();
            AtomicInteger atomicInteger2 = v.a;
            v.e.k(textView, dimensionPixelSize, paddingTop, i2, paddingBottom);
        }
    }

    public final void G() {
        int visibility = this.C.getVisibility();
        int i2 = 0;
        boolean z = this.B != null && !this.H0;
        TextView textView = this.C;
        if (!z) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (visibility != this.C.getVisibility()) {
            getEndIconDelegate().c(z);
        }
        x();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void H() {
        int i2;
        int i3;
        int i4;
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.G != null && this.K != 0) {
            boolean z = false;
            boolean z2 = isFocused() || ((editText2 = this.f618f) != null && editText2.hasFocus());
            boolean z3 = isHovered() || ((editText = this.f618f) != null && editText.isHovered());
            if (!isEnabled()) {
                i4 = this.G0;
            } else {
                if (this.f622j.e()) {
                    if (this.B0 == null) {
                        i4 = this.f622j.g();
                    }
                    E(z2, z3);
                } else if (!this.m || (textView = this.n) == null) {
                    i4 = z2 ? this.A0 : z3 ? this.z0 : this.y0;
                } else {
                    if (this.B0 == null) {
                        i4 = textView.getCurrentTextColor();
                    }
                    E(z2, z3);
                }
                if (getErrorIconDrawable() != null) {
                    n nVar = this.f622j;
                    if (nVar.f3150k && nVar.e()) {
                        z = true;
                    }
                }
                setErrorIconVisible(z);
                r(this.u0, this.v0);
                r(this.V, this.W);
                q();
                if (getEndIconDelegate().d()) {
                    if (!this.f622j.e() || getEndIconDrawable() == null) {
                        d();
                    } else {
                        Drawable mutate = m.e.X1(getEndIconDrawable()).mutate();
                        mutate.setTint(this.f622j.g());
                        this.j0.setImageDrawable(mutate);
                    }
                }
                i2 = this.M;
                i3 = (z2 || !isEnabled()) ? this.N : this.O;
                this.M = i3;
                if (i3 != i2 && this.K == 2 && h() && !this.H0) {
                    if (h()) {
                        ((f.b.a.e.y.g) this.G).A(0.0f, 0.0f, 0.0f, 0.0f);
                    }
                    o();
                }
                if (this.K == 1) {
                    this.Q = !isEnabled() ? this.D0 : (!z3 || z2) ? z2 ? this.E0 : this.C0 : this.F0;
                }
                c();
            }
            this.P = i4;
            if (getErrorIconDrawable() != null) {
            }
            setErrorIconVisible(z);
            r(this.u0, this.v0);
            r(this.V, this.W);
            q();
            if (getEndIconDelegate().d()) {
            }
            i2 = this.M;
            if (z2) {
            }
            this.M = i3;
            if (i3 != i2) {
                if (h()) {
                }
                o();
            }
            if (this.K == 1) {
            }
            c();
        }
    }

    public void a(f fVar) {
        this.g0.add(fVar);
        if (this.f618f != null) {
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
        if (this.I0.c != f2) {
            if (this.L0 == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.L0 = valueAnimator;
                valueAnimator.setInterpolator(f.b.a.e.a.a.b);
                this.L0.setDuration(167L);
                this.L0.addUpdateListener(new d());
            }
            this.L0.setFloatValues(this.I0.c, f2);
            this.L0.start();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void c() {
        boolean z;
        f.b.a.e.v.g gVar;
        f.b.a.e.v.g gVar2 = this.G;
        if (gVar2 != null) {
            gVar2.setShapeAppearanceModel(this.I);
            boolean z2 = false;
            if (this.K == 2) {
                if (this.M > -1 && this.P != 0) {
                    z = true;
                    if (z) {
                        this.G.u((float) this.M, this.P);
                    }
                    int i2 = this.Q;
                    if (this.K == 1) {
                        i2 = e.j.c.a.a(this.Q, f.b.a.c.b.o.b.w0(getContext(), R$attr.colorSurface, 0));
                    }
                    this.Q = i2;
                    this.G.r(ColorStateList.valueOf(i2));
                    if (this.h0 == 3) {
                        this.f618f.getBackground().invalidateSelf();
                    }
                    gVar = this.H;
                    if (gVar != null) {
                        if (this.M > -1 && this.P != 0) {
                            z2 = true;
                        }
                        if (z2) {
                            gVar.r(ColorStateList.valueOf(this.P));
                        }
                        invalidate();
                    }
                    invalidate();
                }
            }
            z = false;
            if (z) {
            }
            int i22 = this.Q;
            if (this.K == 1) {
            }
            this.Q = i22;
            this.G.r(ColorStateList.valueOf(i22));
            if (this.h0 == 3) {
            }
            gVar = this.H;
            if (gVar != null) {
            }
            invalidate();
        }
    }

    public final void d() {
        e(this.j0, this.m0, this.l0, this.o0, this.n0);
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        EditText editText = this.f618f;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        if (this.f619g != null) {
            boolean z = this.F;
            this.F = false;
            CharSequence hint = editText.getHint();
            this.f618f.setHint(this.f619g);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i2);
            } finally {
                this.f618f.setHint(hint);
                this.F = z;
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
                if (childAt == this.f618f) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.N0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.N0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.D) {
            f.b.a.e.q.c cVar = this.I0;
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
            bounds.top = bounds.bottom - this.M;
            this.H.draw(canvas);
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void drawableStateChanged() {
        boolean z;
        boolean z2;
        ColorStateList colorStateList;
        if (!this.M0) {
            boolean z3 = true;
            this.M0 = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            f.b.a.e.q.c cVar = this.I0;
            if (cVar != null) {
                cVar.D = drawableState;
                ColorStateList colorStateList2 = cVar.m;
                if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = cVar.f2997l) != null && colorStateList.isStateful())) {
                    cVar.j();
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = z2 | false;
            } else {
                z = false;
            }
            if (this.f618f != null) {
                AtomicInteger atomicInteger = v.a;
                if (!v.g.c(this) || !isEnabled()) {
                    z3 = false;
                }
                A(z3, false);
            }
            y();
            H();
            if (z) {
                invalidate();
            }
            this.M0 = false;
        }
    }

    public final void e(CheckableImageButton checkableImageButton, boolean z, ColorStateList colorStateList, boolean z2, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z || z2)) {
            drawable = m.e.X1(drawable).mutate();
            if (z) {
                drawable.setTintList(colorStateList);
            }
            if (z2) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public final void f() {
        e(this.V, this.a0, this.W, this.c0, this.b0);
    }

    public final int g() {
        float e2;
        if (!this.D) {
            return 0;
        }
        int i2 = this.K;
        if (i2 == 0 || i2 == 1) {
            e2 = this.I0.e();
        } else if (i2 != 2) {
            return 0;
        } else {
            e2 = this.I0.e() / 2.0f;
        }
        return (int) e2;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f618f;
        if (editText == null) {
            return super.getBaseline();
        }
        return g() + getPaddingTop() + editText.getBaseline();
    }

    public f.b.a.e.v.g getBoxBackground() {
        int i2 = this.K;
        if (i2 == 1 || i2 == 2) {
            return this.G;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.Q;
    }

    public int getBoxBackgroundMode() {
        return this.K;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.L;
    }

    public float getBoxCornerRadiusBottomEnd() {
        f.b.a.e.v.g gVar = this.G;
        return gVar.b.a.f3090h.a(gVar.i());
    }

    public float getBoxCornerRadiusBottomStart() {
        f.b.a.e.v.g gVar = this.G;
        return gVar.b.a.f3089g.a(gVar.i());
    }

    public float getBoxCornerRadiusTopEnd() {
        f.b.a.e.v.g gVar = this.G;
        return gVar.b.a.f3088f.a(gVar.i());
    }

    public float getBoxCornerRadiusTopStart() {
        return this.G.m();
    }

    public int getBoxStrokeColor() {
        return this.A0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.B0;
    }

    public int getBoxStrokeWidth() {
        return this.N;
    }

    public int getBoxStrokeWidthFocused() {
        return this.O;
    }

    public int getCounterMaxLength() {
        return this.f624l;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.f623k || !this.m || (textView = this.n) == null) {
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
        return this.w0;
    }

    public EditText getEditText() {
        return this.f618f;
    }

    public CharSequence getEndIconContentDescription() {
        return this.j0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.j0.getDrawable();
    }

    public int getEndIconMode() {
        return this.h0;
    }

    public CheckableImageButton getEndIconView() {
        return this.j0;
    }

    public CharSequence getError() {
        n nVar = this.f622j;
        if (nVar.f3150k) {
            return nVar.f3149j;
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.f622j.m;
    }

    public int getErrorCurrentTextColors() {
        return this.f622j.g();
    }

    public Drawable getErrorIconDrawable() {
        return this.u0.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        return this.f622j.g();
    }

    public CharSequence getHelperText() {
        n nVar = this.f622j;
        if (nVar.q) {
            return nVar.p;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        TextView textView = this.f622j.r;
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
        return this.I0.e();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.I0.f();
    }

    public ColorStateList getHintTextColor() {
        return this.x0;
    }

    public int getMaxWidth() {
        return this.f621i;
    }

    public int getMinWidth() {
        return this.f620h;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.j0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.j0.getDrawable();
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
        return this.V.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.V.getDrawable();
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
        return this.U;
    }

    public final boolean h() {
        return this.D && !TextUtils.isEmpty(this.E) && (this.G instanceof f.b.a.e.y.g);
    }

    public final int i(int i2, boolean z) {
        int compoundPaddingLeft = this.f618f.getCompoundPaddingLeft() + i2;
        return (this.z == null || z) ? compoundPaddingLeft : (compoundPaddingLeft - this.A.getMeasuredWidth()) + this.A.getPaddingLeft();
    }

    public final int j(int i2, boolean z) {
        int compoundPaddingRight = i2 - this.f618f.getCompoundPaddingRight();
        return (this.z == null || !z) ? compoundPaddingRight : compoundPaddingRight + (this.A.getMeasuredWidth() - this.A.getPaddingRight());
    }

    public final boolean k() {
        return this.h0 != 0;
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
        return this.f617e.getVisibility() == 0 && this.j0.getVisibility() == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
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
        int i7 = this.K;
        if (i7 == 0) {
            this.G = null;
        } else if (i7 == 1) {
            this.G = new f.b.a.e.v.g(this.I);
            this.H = new f.b.a.e.v.g();
            editText = this.f618f;
            if (editText == null && this.G != null && editText.getBackground() == null && this.K != 0) {
                EditText editText3 = this.f618f;
                f.b.a.e.v.g gVar = this.G;
                AtomicInteger atomicInteger = v.a;
                v.d.q(editText3, gVar);
            }
            H();
            if (this.K == 1) {
                if (f.b.a.c.b.o.b.V0(getContext())) {
                    resources2 = getResources();
                    i6 = R$dimen.material_font_2_0_box_collapsed_padding_top;
                } else if (f.b.a.c.b.o.b.U0(getContext())) {
                    resources2 = getResources();
                    i6 = R$dimen.material_font_1_3_box_collapsed_padding_top;
                }
                this.L = resources2.getDimensionPixelSize(i6);
            }
            if (this.f618f != null && this.K == 1) {
                if (!f.b.a.c.b.o.b.V0(getContext())) {
                    editText2 = this.f618f;
                    AtomicInteger atomicInteger2 = v.a;
                    i5 = v.e.f(editText2);
                    i4 = getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_top);
                    i3 = v.e.e(this.f618f);
                    resources = getResources();
                    i2 = R$dimen.material_filled_edittext_font_2_0_padding_bottom;
                } else if (f.b.a.c.b.o.b.U0(getContext())) {
                    editText2 = this.f618f;
                    AtomicInteger atomicInteger3 = v.a;
                    i5 = v.e.f(editText2);
                    i4 = getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_top);
                    i3 = v.e.e(this.f618f);
                    resources = getResources();
                    i2 = R$dimen.material_filled_edittext_font_1_3_padding_bottom;
                }
                v.e.k(editText2, i5, i4, i3, resources.getDimensionPixelSize(i2));
            }
            if (this.K == 0) {
                z();
                return;
            }
            return;
        } else if (i7 == 2) {
            this.G = (!this.D || (this.G instanceof f.b.a.e.y.g)) ? new f.b.a.e.v.g(this.I) : new f.b.a.e.y.g(this.I);
        } else {
            throw new IllegalArgumentException(this.K + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
        this.H = null;
        editText = this.f618f;
        if (editText == null && this.G != null && editText.getBackground() == null && this.K != 0) {
        }
        H();
        if (this.K == 1) {
        }
        if (this.f618f != null) {
            if (!f.b.a.c.b.o.b.V0(getContext())) {
            }
            v.e.k(editText2, i5, i4, i3, resources.getDimensionPixelSize(i2));
        }
        if (this.K == 0) {
        }
    }

    public final void o() {
        float f2;
        float f3;
        float f4;
        float f5;
        if (h()) {
            RectF rectF = this.T;
            f.b.a.e.q.c cVar = this.I0;
            int width = this.f618f.getWidth();
            int gravity = this.f618f.getGravity();
            boolean b2 = cVar.b(cVar.x);
            cVar.z = b2;
            if (gravity == 17 || (gravity & 7) == 1) {
                f5 = ((float) width) / 2.0f;
                f4 = cVar.P / 2.0f;
            } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5 ? !b2 : b2) {
                f5 = (float) cVar.f2991f.right;
                f4 = cVar.P;
            } else {
                f2 = (float) cVar.f2991f.left;
                rectF.left = f2;
                Rect rect = cVar.f2991f;
                float f6 = (float) rect.top;
                rectF.top = f6;
                if (gravity != 17 || (gravity & 7) == 1) {
                    f3 = (((float) width) / 2.0f) + (cVar.P / 2.0f);
                } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (b2) {
                        f3 = cVar.P + f2;
                    }
                    f3 = (float) rect.right;
                } else {
                    if (!b2) {
                        f3 = cVar.P + f2;
                    }
                    f3 = (float) rect.right;
                }
                rectF.right = f3;
                rectF.bottom = cVar.e() + f6;
                float f7 = rectF.left;
                float f8 = (float) this.J;
                rectF.left = f7 - f8;
                rectF.right += f8;
                rectF.offset((float) (-getPaddingLeft()), (((float) (-getPaddingTop())) - (rectF.height() / 2.0f)) + ((float) this.M));
                f.b.a.e.y.g gVar = (f.b.a.e.y.g) this.G;
                Objects.requireNonNull(gVar);
                gVar.A(rectF.left, rectF.top, rectF.right, rectF.bottom);
            }
            f2 = f5 - f4;
            rectF.left = f2;
            Rect rect2 = cVar.f2991f;
            float f62 = (float) rect2.top;
            rectF.top = f62;
            if (gravity != 17) {
            }
            f3 = (((float) width) / 2.0f) + (cVar.P / 2.0f);
            rectF.right = f3;
            rectF.bottom = cVar.e() + f62;
            float f72 = rectF.left;
            float f82 = (float) this.J;
            rectF.left = f72 - f82;
            rectF.right += f82;
            rectF.offset((float) (-getPaddingLeft()), (((float) (-getPaddingTop())) - (rectF.height() / 2.0f)) + ((float) this.M));
            f.b.a.e.y.g gVar2 = (f.b.a.e.y.g) this.G;
            Objects.requireNonNull(gVar2);
            gVar2.A(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0175  */
    @Override // android.widget.LinearLayout, android.view.View, android.view.ViewGroup
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        super.onLayout(z, i2, i3, i4, i5);
        EditText editText = this.f618f;
        if (editText != null) {
            Rect rect = this.R;
            f.b.a.e.q.d.a(this, editText, rect);
            f.b.a.e.v.g gVar = this.H;
            if (gVar != null) {
                int i12 = rect.bottom;
                gVar.setBounds(rect.left, i12 - this.O, rect.right, i12);
            }
            if (this.D) {
                f.b.a.e.q.c cVar = this.I0;
                float textSize = this.f618f.getTextSize();
                if (cVar.f2995j != textSize) {
                    cVar.f2995j = textSize;
                    cVar.j();
                }
                int gravity = this.f618f.getGravity();
                this.I0.m((gravity & -113) | 48);
                f.b.a.e.q.c cVar2 = this.I0;
                if (cVar2.f2993h != gravity) {
                    cVar2.f2993h = gravity;
                    cVar2.j();
                }
                f.b.a.e.q.c cVar3 = this.I0;
                if (this.f618f != null) {
                    Rect rect2 = this.S;
                    AtomicInteger atomicInteger = v.a;
                    boolean z2 = false;
                    boolean z3 = v.e.d(this) == 1;
                    rect2.bottom = rect.bottom;
                    int i13 = this.K;
                    if (i13 == 1) {
                        rect2.left = i(rect.left, z3);
                        i11 = rect.top + this.L;
                    } else if (i13 != 2) {
                        rect2.left = i(rect.left, z3);
                        i11 = getPaddingTop();
                    } else {
                        rect2.left = this.f618f.getPaddingLeft() + rect.left;
                        rect2.top = rect.top - g();
                        i6 = rect.right - this.f618f.getPaddingRight();
                        rect2.right = i6;
                        Objects.requireNonNull(cVar3);
                        i7 = rect2.left;
                        i8 = rect2.top;
                        i9 = rect2.right;
                        i10 = rect2.bottom;
                        if (!f.b.a.e.q.c.k(cVar3.f2991f, i7, i8, i9, i10)) {
                            cVar3.f2991f.set(i7, i8, i9, i10);
                            cVar3.E = true;
                            cVar3.i();
                        }
                        f.b.a.e.q.c cVar4 = this.I0;
                        if (this.f618f == null) {
                            Rect rect3 = this.S;
                            TextPaint textPaint = cVar4.G;
                            textPaint.setTextSize(cVar4.f2995j);
                            textPaint.setTypeface(cVar4.u);
                            textPaint.setLetterSpacing(0.0f);
                            float f2 = -cVar4.G.ascent();
                            rect3.left = this.f618f.getCompoundPaddingLeft() + rect.left;
                            rect3.top = this.K == 1 && this.f618f.getMinLines() <= 1 ? (int) (((float) rect.centerY()) - (f2 / 2.0f)) : rect.top + this.f618f.getCompoundPaddingTop();
                            rect3.right = rect.right - this.f618f.getCompoundPaddingRight();
                            if (this.K == 1 && this.f618f.getMinLines() <= 1) {
                                z2 = true;
                            }
                            int compoundPaddingBottom = z2 ? (int) (((float) rect3.top) + f2) : rect.bottom - this.f618f.getCompoundPaddingBottom();
                            rect3.bottom = compoundPaddingBottom;
                            int i14 = rect3.left;
                            int i15 = rect3.top;
                            int i16 = rect3.right;
                            if (!f.b.a.e.q.c.k(cVar4.f2990e, i14, i15, i16, compoundPaddingBottom)) {
                                cVar4.f2990e.set(i14, i15, i16, compoundPaddingBottom);
                                cVar4.E = true;
                                cVar4.i();
                            }
                            this.I0.j();
                            if (h() && !this.H0) {
                                o();
                                return;
                            }
                            return;
                        }
                        throw new IllegalStateException();
                    }
                    rect2.top = i11;
                    i6 = j(rect.right, z3);
                    rect2.right = i6;
                    Objects.requireNonNull(cVar3);
                    i7 = rect2.left;
                    i8 = rect2.top;
                    i9 = rect2.right;
                    i10 = rect2.bottom;
                    if (!f.b.a.e.q.c.k(cVar3.f2991f, i7, i8, i9, i10)) {
                    }
                    f.b.a.e.q.c cVar42 = this.I0;
                    if (this.f618f == null) {
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        EditText editText;
        int max;
        super.onMeasure(i2, i3);
        boolean z = false;
        if (this.f618f != null && this.f618f.getMeasuredHeight() < (max = Math.max(this.f616d.getMeasuredHeight(), this.c.getMeasuredHeight()))) {
            this.f618f.setMinimumHeight(max);
            z = true;
        }
        boolean x = x();
        if (z || x) {
            this.f618f.post(new c());
        }
        if (!(this.s == null || (editText = this.f618f) == null)) {
            this.s.setGravity(editText.getGravity());
            this.s.setPadding(this.f618f.getCompoundPaddingLeft(), this.f618f.getCompoundPaddingTop(), this.f618f.getCompoundPaddingRight(), this.f618f.getCompoundPaddingBottom());
        }
        C();
        F();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.b);
        setError(hVar.f626d);
        if (hVar.f627e) {
            this.j0.post(new b());
        }
        setHint(hVar.f628f);
        setHelperText(hVar.f629g);
        setPlaceholderText(hVar.f630h);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (this.f622j.e()) {
            hVar.f626d = getError();
        }
        hVar.f627e = k() && this.j0.isChecked();
        hVar.f628f = getHint();
        hVar.f629g = getHelperText();
        hVar.f630h = getPlaceholderText();
        return hVar;
    }

    public void q() {
        r(this.j0, this.l0);
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
            Drawable mutate = m.e.X1(drawable).mutate();
            mutate.setTintList(ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    public void setBoxBackgroundColor(int i2) {
        if (this.Q != i2) {
            this.Q = i2;
            this.C0 = i2;
            this.E0 = i2;
            this.F0 = i2;
            c();
        }
    }

    public void setBoxBackgroundColorResource(int i2) {
        setBoxBackgroundColor(e.j.b.a.a(getContext(), i2));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.C0 = defaultColor;
        this.Q = defaultColor;
        this.D0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.E0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.F0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        c();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 != this.K) {
            this.K = i2;
            if (this.f618f != null) {
                n();
            }
        }
    }

    public void setBoxCollapsedPaddingTop(int i2) {
        this.L = i2;
    }

    public void setBoxStrokeColor(int i2) {
        if (this.A0 != i2) {
            this.A0 = i2;
            H();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        int defaultColor;
        if (colorStateList.isStateful()) {
            this.y0 = colorStateList.getDefaultColor();
            this.G0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.z0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            defaultColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else {
            if (this.A0 != colorStateList.getDefaultColor()) {
                defaultColor = colorStateList.getDefaultColor();
            }
            H();
        }
        this.A0 = defaultColor;
        H();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.B0 != colorStateList) {
            this.B0 = colorStateList;
            H();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.N = i2;
        H();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.O = i2;
        H();
    }

    public void setBoxStrokeWidthFocusedResource(int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z) {
        if (this.f623k != z) {
            if (z) {
                d0 d0Var = new d0(getContext(), null);
                this.n = d0Var;
                d0Var.setId(R$id.textinput_counter);
                Typeface typeface = this.U;
                if (typeface != null) {
                    this.n.setTypeface(typeface);
                }
                this.n.setMaxLines(1);
                this.f622j.a(this.n, 2);
                ((ViewGroup.MarginLayoutParams) this.n.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_counter_margin_start));
                w();
                u();
            } else {
                this.f622j.j(this.n, 2);
                this.n = null;
            }
            this.f623k = z;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.f624l != i2) {
            if (i2 <= 0) {
                i2 = -1;
            }
            this.f624l = i2;
            if (this.f623k) {
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
        this.w0 = colorStateList;
        this.x0 = colorStateList;
        if (this.f618f != null) {
            A(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        p(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.j0.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.j0.setCheckable(z);
    }

    public void setEndIconContentDescription(int i2) {
        setEndIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.j0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(int i2) {
        setEndIconDrawable(i2 != 0 ? m.e.i0(getContext(), i2) : null);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.j0.setImageDrawable(drawable);
        if (drawable != null) {
            d();
            q();
        }
    }

    public void setEndIconMode(int i2) {
        int i3 = this.h0;
        this.h0 = i2;
        Iterator<g> it = this.k0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i3);
        }
        setEndIconVisible(i2 != 0);
        if (getEndIconDelegate().b(this.K)) {
            getEndIconDelegate().a();
            d();
            return;
        }
        StringBuilder h2 = f.a.a.a.a.h("The current box background mode ");
        h2.append(this.K);
        h2.append(" is not supported by the end icon mode ");
        h2.append(i2);
        throw new IllegalStateException(h2.toString());
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.j0;
        View.OnLongClickListener onLongClickListener = this.s0;
        checkableImageButton.setOnClickListener(onClickListener);
        s(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.s0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.j0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        s(checkableImageButton, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.l0 != colorStateList) {
            this.l0 = colorStateList;
            this.m0 = true;
            d();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.n0 != mode) {
            this.n0 = mode;
            this.o0 = true;
            d();
        }
    }

    public void setEndIconVisible(boolean z) {
        if (m() != z) {
            this.j0.setVisibility(z ? 0 : 8);
            F();
            x();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.f622j.f3150k) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            n nVar = this.f622j;
            nVar.c();
            nVar.f3149j = charSequence;
            nVar.f3151l.setText(charSequence);
            int i2 = nVar.f3147h;
            if (i2 != 1) {
                nVar.f3148i = 1;
            }
            nVar.l(i2, nVar.f3148i, nVar.k(nVar.f3151l, charSequence));
            return;
        }
        this.f622j.i();
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        n nVar = this.f622j;
        nVar.m = charSequence;
        TextView textView = nVar.f3151l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        n nVar = this.f622j;
        if (nVar.f3150k != z) {
            nVar.c();
            if (z) {
                d0 d0Var = new d0(nVar.a, null);
                nVar.f3151l = d0Var;
                d0Var.setId(R$id.textinput_error);
                nVar.f3151l.setTextAlignment(5);
                Typeface typeface = nVar.u;
                if (typeface != null) {
                    nVar.f3151l.setTypeface(typeface);
                }
                int i2 = nVar.n;
                nVar.n = i2;
                TextView textView = nVar.f3151l;
                if (textView != null) {
                    nVar.b.t(textView, i2);
                }
                ColorStateList colorStateList = nVar.o;
                nVar.o = colorStateList;
                TextView textView2 = nVar.f3151l;
                if (!(textView2 == null || colorStateList == null)) {
                    textView2.setTextColor(colorStateList);
                }
                CharSequence charSequence = nVar.m;
                nVar.m = charSequence;
                TextView textView3 = nVar.f3151l;
                if (textView3 != null) {
                    textView3.setContentDescription(charSequence);
                }
                nVar.f3151l.setVisibility(4);
                TextView textView4 = nVar.f3151l;
                AtomicInteger atomicInteger = v.a;
                v.g.f(textView4, 1);
                nVar.a(nVar.f3151l, 0);
            } else {
                nVar.i();
                nVar.j(nVar.f3151l, 0);
                nVar.f3151l = null;
                nVar.b.y();
                nVar.b.H();
            }
            nVar.f3150k = z;
        }
    }

    public void setErrorIconDrawable(int i2) {
        setErrorIconDrawable(i2 != 0 ? m.e.i0(getContext(), i2) : null);
        r(this.u0, this.v0);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.u0;
        View.OnLongClickListener onLongClickListener = this.t0;
        checkableImageButton.setOnClickListener(onClickListener);
        s(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.t0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.u0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        s(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.v0 = colorStateList;
        Drawable drawable = this.u0.getDrawable();
        if (drawable != null) {
            drawable = m.e.X1(drawable).mutate();
            drawable.setTintList(colorStateList);
        }
        if (this.u0.getDrawable() != drawable) {
            this.u0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.u0.getDrawable();
        if (drawable != null) {
            drawable = m.e.X1(drawable).mutate();
            drawable.setTintMode(mode);
        }
        if (this.u0.getDrawable() != drawable) {
            this.u0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i2) {
        n nVar = this.f622j;
        nVar.n = i2;
        TextView textView = nVar.f3151l;
        if (textView != null) {
            nVar.b.t(textView, i2);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        n nVar = this.f622j;
        nVar.o = colorStateList;
        TextView textView = nVar.f3151l;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.J0 != z) {
            this.J0 = z;
            A(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!this.f622j.q) {
                setHelperTextEnabled(true);
            }
            n nVar = this.f622j;
            nVar.c();
            nVar.p = charSequence;
            nVar.r.setText(charSequence);
            int i2 = nVar.f3147h;
            if (i2 != 2) {
                nVar.f3148i = 2;
            }
            nVar.l(i2, nVar.f3148i, nVar.k(nVar.r, charSequence));
        } else if (this.f622j.q) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        n nVar = this.f622j;
        nVar.t = colorStateList;
        TextView textView = nVar.r;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setHelperTextEnabled(boolean z) {
        n nVar = this.f622j;
        if (nVar.q != z) {
            nVar.c();
            if (z) {
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
                    m.e.D1(textView2, i2);
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
                int i3 = nVar.f3147h;
                if (i3 == 2) {
                    nVar.f3148i = 0;
                }
                nVar.l(i3, nVar.f3148i, nVar.k(nVar.r, null));
                nVar.j(nVar.r, 1);
                nVar.r = null;
                nVar.b.y();
                nVar.b.H();
            }
            nVar.q = z;
        }
    }

    public void setHelperTextTextAppearance(int i2) {
        n nVar = this.f622j;
        nVar.s = i2;
        TextView textView = nVar.r;
        if (textView != null) {
            m.e.D1(textView, i2);
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

    public void setHintAnimationEnabled(boolean z) {
        this.K0 = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.D) {
            this.D = z;
            if (!z) {
                this.F = false;
                if (!TextUtils.isEmpty(this.E) && TextUtils.isEmpty(this.f618f.getHint())) {
                    this.f618f.setHint(this.E);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f618f.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.E)) {
                        setHint(hint);
                    }
                    this.f618f.setHint((CharSequence) null);
                }
                this.F = true;
            }
            if (this.f618f != null) {
                z();
            }
        }
    }

    public void setHintTextAppearance(int i2) {
        f.b.a.e.q.c cVar = this.I0;
        f.b.a.e.s.b bVar = new f.b.a.e.s.b(cVar.a.getContext(), i2);
        ColorStateList colorStateList = bVar.f3056j;
        if (colorStateList != null) {
            cVar.m = colorStateList;
        }
        float f2 = bVar.f3057k;
        if (f2 != 0.0f) {
            cVar.f2996k = f2;
        }
        ColorStateList colorStateList2 = bVar.a;
        if (colorStateList2 != null) {
            cVar.M = colorStateList2;
        }
        cVar.K = bVar.f3051e;
        cVar.L = bVar.f3052f;
        cVar.J = bVar.f3053g;
        cVar.N = bVar.f3055i;
        f.b.a.e.s.a aVar = cVar.w;
        if (aVar != null) {
            aVar.c = true;
        }
        f.b.a.e.q.b bVar2 = new f.b.a.e.q.b(cVar);
        bVar.a();
        cVar.w = new f.b.a.e.s.a(bVar2, bVar.n);
        bVar.c(cVar.a.getContext(), cVar.w);
        cVar.j();
        this.x0 = this.I0.m;
        if (this.f618f != null) {
            A(false, false);
            z();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.x0 != colorStateList) {
            if (this.w0 == null) {
                f.b.a.e.q.c cVar = this.I0;
                if (cVar.m != colorStateList) {
                    cVar.m = colorStateList;
                    cVar.j();
                }
            }
            this.x0 = colorStateList;
            if (this.f618f != null) {
                A(false, false);
            }
        }
    }

    public void setMaxWidth(int i2) {
        this.f621i = i2;
        EditText editText = this.f618f;
        if (editText != null && i2 != -1) {
            editText.setMaxWidth(i2);
        }
    }

    public void setMaxWidthResource(int i2) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    public void setMinWidth(int i2) {
        this.f620h = i2;
        EditText editText = this.f618f;
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
        this.j0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? m.e.i0(getContext(), i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.j0.setImageDrawable(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.h0 != 1) {
            setEndIconMode(1);
        } else if (!z) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.l0 = colorStateList;
        this.m0 = true;
        d();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.n0 = mode;
        this.o0 = true;
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
        EditText editText = this.f618f;
        if (editText != null) {
            i2 = editText.getText().length();
        }
        B(i2);
    }

    public void setPlaceholderTextAppearance(int i2) {
        this.u = i2;
        TextView textView = this.s;
        if (textView != null) {
            m.e.D1(textView, i2);
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
        m.e.D1(this.A, i2);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.A.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z) {
        this.V.setCheckable(z);
    }

    public void setStartIconContentDescription(int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.V.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i2) {
        setStartIconDrawable(i2 != 0 ? m.e.i0(getContext(), i2) : null);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.V.setImageDrawable(drawable);
        if (drawable != null) {
            f();
            setStartIconVisible(true);
            r(this.V, this.W);
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.V;
        View.OnLongClickListener onLongClickListener = this.f0;
        checkableImageButton.setOnClickListener(onClickListener);
        s(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.V;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        s(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.W != colorStateList) {
            this.W = colorStateList;
            this.a0 = true;
            f();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.b0 != mode) {
            this.b0 = mode;
            this.c0 = true;
            f();
        }
    }

    public void setStartIconVisible(boolean z) {
        int i2 = 0;
        if ((this.V.getVisibility() == 0) != z) {
            CheckableImageButton checkableImageButton = this.V;
            if (!z) {
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
        m.e.D1(this.C, i2);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.C.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f618f;
        if (editText != null) {
            v.u(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.U) {
            this.U = typeface;
            this.I0.p(typeface);
            n nVar = this.f622j;
            if (typeface != nVar.u) {
                nVar.u = typeface;
                TextView textView = nVar.f3151l;
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

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
        if (r3.getTextColors().getDefaultColor() == -65281) goto L_0x001c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void t(TextView textView, int i2) {
        boolean z = true;
        try {
            m.e.D1(textView, i2);
            if (Build.VERSION.SDK_INT >= 23) {
            }
            z = false;
        } catch (Exception unused) {
        }
        if (z) {
            m.e.D1(textView, R$style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(e.j.b.a.a(getContext(), R$color.design_error));
        }
    }

    public final void u() {
        if (this.n != null) {
            EditText editText = this.f618f;
            v(editText == null ? 0 : editText.getText().length());
        }
    }

    public void v(int i2) {
        boolean z = this.m;
        int i3 = this.f624l;
        if (i3 == -1) {
            this.n.setText(String.valueOf(i2));
            this.n.setContentDescription(null);
            this.m = false;
        } else {
            this.m = i2 > i3;
            Context context = getContext();
            this.n.setContentDescription(context.getString(this.m ? R$string.character_counter_overflowed_content_description : R$string.character_counter_content_description, Integer.valueOf(i2), Integer.valueOf(this.f624l)));
            if (z != this.m) {
                w();
            }
            this.n.setText(e.j.h.a.c().e(getContext().getString(R$string.character_counter_pattern, Integer.valueOf(i2), Integer.valueOf(this.f624l))));
        }
        if (this.f618f != null && z != this.m) {
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

    public final boolean x() {
        boolean z;
        if (this.f618f == null) {
            return false;
        }
        boolean z2 = true;
        if (!(getStartIconDrawable() == null && this.z == null) && this.c.getMeasuredWidth() > 0) {
            int measuredWidth = this.c.getMeasuredWidth() - this.f618f.getPaddingLeft();
            if (this.d0 == null || this.e0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.d0 = colorDrawable;
                this.e0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = this.f618f.getCompoundDrawablesRelative();
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.d0;
            if (drawable != drawable2) {
                this.f618f.setCompoundDrawablesRelative(drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
                z = true;
            }
            z = false;
        } else {
            if (this.d0 != null) {
                Drawable[] compoundDrawablesRelative2 = this.f618f.getCompoundDrawablesRelative();
                this.f618f.setCompoundDrawablesRelative(null, compoundDrawablesRelative2[1], compoundDrawablesRelative2[2], compoundDrawablesRelative2[3]);
                this.d0 = null;
                z = true;
            }
            z = false;
        }
        if ((this.u0.getVisibility() == 0 || ((k() && m()) || this.B != null)) && this.f616d.getMeasuredWidth() > 0) {
            int measuredWidth2 = this.C.getMeasuredWidth() - this.f618f.getPaddingRight();
            CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
            if (endIconToUpdateDummyDrawable != null) {
                measuredWidth2 = ((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams()).getMarginStart() + endIconToUpdateDummyDrawable.getMeasuredWidth() + measuredWidth2;
            }
            Drawable[] compoundDrawablesRelative3 = this.f618f.getCompoundDrawablesRelative();
            Drawable drawable3 = this.p0;
            if (drawable3 == null || this.q0 == measuredWidth2) {
                if (drawable3 == null) {
                    ColorDrawable colorDrawable2 = new ColorDrawable();
                    this.p0 = colorDrawable2;
                    this.q0 = measuredWidth2;
                    colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                }
                Drawable drawable4 = compoundDrawablesRelative3[2];
                Drawable drawable5 = this.p0;
                if (drawable4 != drawable5) {
                    this.r0 = compoundDrawablesRelative3[2];
                    this.f618f.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], drawable5, compoundDrawablesRelative3[3]);
                } else {
                    z2 = z;
                }
            } else {
                this.q0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                this.f618f.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.p0, compoundDrawablesRelative3[3]);
            }
        } else if (this.p0 == null) {
            return z;
        } else {
            Drawable[] compoundDrawablesRelative4 = this.f618f.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative4[2] == this.p0) {
                this.f618f.setCompoundDrawablesRelative(compoundDrawablesRelative4[0], compoundDrawablesRelative4[1], this.r0, compoundDrawablesRelative4[3]);
            } else {
                z2 = z;
            }
            this.p0 = null;
        }
        return z2;
    }

    public void y() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.f618f;
        if (editText != null && this.K == 0 && (background = editText.getBackground()) != null) {
            if (i0.a(background)) {
                background = background.mutate();
            }
            if (this.f622j.e()) {
                currentTextColor = this.f622j.g();
            } else if (!this.m || (textView = this.n) == null) {
                m.e.w(background);
                this.f618f.refreshDrawableState();
                return;
            } else {
                currentTextColor = textView.getCurrentTextColor();
            }
            background.setColorFilter(e.b.f.k.c(currentTextColor, PorterDuff.Mode.SRC_IN));
        }
    }

    public final void z() {
        if (this.K != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            int g2 = g();
            if (g2 != layoutParams.topMargin) {
                layoutParams.topMargin = g2;
                this.b.requestLayout();
            }
        }
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.u0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.f622j.f3150k);
    }
}
