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
import android.util.Log;
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
import e.b.f.e0;
import e.b.f.y0;
import e.b.f.z;
import f.b.a.d.q.k;
import f.b.a.d.v.j;
import f.b.a.d.z.m;
import f.b.a.d.z.n;
import f.b.a.d.z.q;
import f.b.a.d.z.r;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class TextInputLayout extends LinearLayout {
    public static final int K0 = R$style.Widget_Design_TextInputLayout;
    public CharSequence A;
    public int A0;
    public boolean B;
    public int B0;
    public f.b.a.d.v.g C;
    public int C0;
    public f.b.a.d.v.g D;
    public boolean D0;
    public j E;
    public final f.b.a.d.q.c E0;
    public final int F;
    public boolean F0;
    public int G;
    public boolean G0;
    public int H;
    public ValueAnimator H0;
    public int I;
    public boolean I0;
    public int J;
    public boolean J0;
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
    public final FrameLayout b;
    public View.OnLongClickListener b0;
    public final LinearLayout c;
    public final LinkedHashSet<f> c0 = new LinkedHashSet<>();

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f606d;
    public int d0 = 0;

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f607e;
    public final SparseArray<m> e0 = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    public EditText f608f;
    public final CheckableImageButton f0;

    /* renamed from: g  reason: collision with root package name */
    public CharSequence f609g;
    public final LinkedHashSet<g> g0 = new LinkedHashSet<>();

    /* renamed from: h  reason: collision with root package name */
    public final n f610h = new n(this);
    public ColorStateList h0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f611i;
    public boolean i0;

    /* renamed from: j  reason: collision with root package name */
    public int f612j;
    public PorterDuff.Mode j0;

    /* renamed from: k  reason: collision with root package name */
    public boolean f613k;
    public boolean k0;

    /* renamed from: l  reason: collision with root package name */
    public TextView f614l;
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
            textInputLayout.y(!textInputLayout.J0, false);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.f611i) {
                textInputLayout2.t(editable.length());
            }
            TextInputLayout textInputLayout3 = TextInputLayout.this;
            if (textInputLayout3.p) {
                textInputLayout3.z(editable.length());
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
            TextInputLayout.this.f0.performClick();
            TextInputLayout.this.f0.jumpDrawablesToCurrentState();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            TextInputLayout.this.f608f.requestLayout();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.E0.o(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends e.i.i.a {

        /* renamed from: d  reason: collision with root package name */
        public final TextInputLayout f615d;

        public e(TextInputLayout textInputLayout) {
            this.f615d = textInputLayout;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
            if (r3 != null) goto L_0x0088;
         */
        @Override // e.i.i.a
        public void d(View view, e.i.i.x.b bVar) {
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
            EditText editText = this.f615d.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f615d.getHint();
            CharSequence error = this.f615d.getError();
            CharSequence placeholderText = this.f615d.getPlaceholderText();
            int counterMaxLength = this.f615d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f615d.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !this.f615d.D0;
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
        public CharSequence f616d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f617e;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f618f;

        /* renamed from: g  reason: collision with root package name */
        public CharSequence f619g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f620h;

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
            this.f616d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f617e = parcel.readInt() != 1 ? false : true;
            this.f618f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f619g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f620h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder h2 = f.a.a.a.a.h("TextInputLayout.SavedState{");
            h2.append(Integer.toHexString(System.identityHashCode(this)));
            h2.append(" error=");
            h2.append((Object) this.f616d);
            h2.append(" hint=");
            h2.append((Object) this.f618f);
            h2.append(" helperText=");
            h2.append((Object) this.f619g);
            h2.append(" placeholderText=");
            h2.append((Object) this.f620h);
            h2.append("}");
            return h2.toString();
        }

        @Override // e.k.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.b, i2);
            TextUtils.writeToParcel(this.f616d, parcel, i2);
            parcel.writeInt(this.f617e ? 1 : 0);
            TextUtils.writeToParcel(this.f618f, parcel, i2);
            TextUtils.writeToParcel(this.f619g, parcel, i2);
            TextUtils.writeToParcel(this.f620h, parcel, i2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: e.b.f.y0 */
    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: android.view.LayoutInflater */
    /* JADX DEBUG: Multi-variable search result rejected for r10v11, resolved type: android.view.ViewGroup$MarginLayoutParams */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v45, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v157 */
    /* JADX WARN: Type inference failed for: r2v158 */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x05b4  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x05c3  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x05d2  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x05e1  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x05f0  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0587  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0596  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x05a5  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public TextInputLayout(Context context, AttributeSet attributeSet) {
        super(f.b.a.d.a0.a.a.a(context, attributeSet, r8, r9), attributeSet, r8);
        int i2;
        ?? r2;
        int i3;
        AttributeSet attributeSet2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = R$attr.textInputStyle;
        int i15 = K0;
        f.b.a.d.q.c cVar = new f.b.a.d.q.c(this);
        this.E0 = cVar;
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
        this.f606d = linearLayout2;
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        frameLayout.addView(linearLayout2);
        FrameLayout frameLayout2 = new FrameLayout(context2);
        this.f607e = frameLayout2;
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        TimeInterpolator timeInterpolator = f.b.a.d.a.a.a;
        cVar.H = timeInterpolator;
        cVar.k();
        cVar.G = timeInterpolator;
        cVar.k();
        cVar.n(8388659);
        int[] iArr = R$styleable.TextInputLayout;
        int i16 = R$styleable.TextInputLayout_counterTextAppearance;
        int i17 = R$styleable.TextInputLayout_counterOverflowTextAppearance;
        int i18 = R$styleable.TextInputLayout_errorTextAppearance;
        int i19 = R$styleable.TextInputLayout_helperTextTextAppearance;
        int i20 = R$styleable.TextInputLayout_hintTextAppearance;
        k.a(context2, attributeSet, i14, i15);
        k.b(context2, attributeSet, iArr, i14, i15, i16, i17, i18, i19, i20);
        y0 y0Var = new y0(context2, context2.obtainStyledAttributes(attributeSet, iArr, i14, i15));
        this.z = y0Var.a(R$styleable.TextInputLayout_hintEnabled, true);
        setHint(y0Var.n(R$styleable.TextInputLayout_android_hint));
        this.G0 = y0Var.a(R$styleable.TextInputLayout_hintAnimationEnabled, true);
        this.F0 = y0Var.a(R$styleable.TextInputLayout_expandedHintEnabled, true);
        this.E = j.b(context2, attributeSet, i14, i15).a();
        this.F = context2.getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_box_label_cutout_padding);
        this.H = y0Var.e(R$styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.J = y0Var.f(R$styleable.TextInputLayout_boxStrokeWidth, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_default));
        this.K = y0Var.f(R$styleable.TextInputLayout_boxStrokeWidthFocused, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_focused));
        this.I = this.J;
        float d2 = y0Var.d(R$styleable.TextInputLayout_boxCornerRadiusTopStart, -1.0f);
        float d3 = y0Var.d(R$styleable.TextInputLayout_boxCornerRadiusTopEnd, -1.0f);
        float d4 = y0Var.d(R$styleable.TextInputLayout_boxCornerRadiusBottomEnd, -1.0f);
        float d5 = y0Var.d(R$styleable.TextInputLayout_boxCornerRadiusBottomStart, -1.0f);
        j jVar = this.E;
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
        this.E = bVar.a();
        ColorStateList M0 = f.b.a.c.b.o.b.M0(context2, y0Var, R$styleable.TextInputLayout_boxBackgroundColor);
        if (M0 != null) {
            int defaultColor = M0.getDefaultColor();
            this.y0 = defaultColor;
            this.M = defaultColor;
            if (M0.isStateful()) {
                this.z0 = M0.getColorForState(new int[]{-16842910}, -1);
                i2 = 2;
                this.A0 = M0.getColorForState(new int[]{16842908, 16842910}, -1);
                i13 = M0.getColorForState(new int[]{16843623, 16842910}, -1);
            } else {
                i2 = 2;
                this.A0 = this.y0;
                ColorStateList a2 = e.b.b.a.a.a(context2, R$color.mtrl_filled_background_color);
                this.z0 = a2.getColorForState(new int[]{-16842910}, -1);
                i13 = a2.getColorForState(new int[]{16843623}, -1);
            }
            this.B0 = i13;
        } else {
            i2 = 2;
            this.M = 0;
            this.y0 = 0;
            this.z0 = 0;
            this.A0 = 0;
            this.B0 = 0;
        }
        int i21 = R$styleable.TextInputLayout_android_textColorHint;
        if (y0Var.o(i21)) {
            ColorStateList c2 = y0Var.c(i21);
            this.t0 = c2;
            this.s0 = c2;
        }
        int i22 = R$styleable.TextInputLayout_boxStrokeColor;
        ColorStateList M02 = f.b.a.c.b.o.b.M0(context2, y0Var, i22);
        this.w0 = y0Var.b(i22, 0);
        this.u0 = e.i.b.a.a(context2, R$color.mtrl_textinput_default_box_stroke_color);
        this.C0 = e.i.b.a.a(context2, R$color.mtrl_textinput_disabled_color);
        this.v0 = e.i.b.a.a(context2, R$color.mtrl_textinput_hovered_box_stroke_color);
        if (M02 != null) {
            setBoxStrokeColorStateList(M02);
        }
        int i23 = R$styleable.TextInputLayout_boxStrokeErrorColor;
        if (y0Var.o(i23)) {
            setBoxStrokeErrorColor(f.b.a.c.b.o.b.M0(context2, y0Var, i23));
        }
        if (y0Var.l(i20, -1) != -1) {
            r2 = 0;
            setHintTextAppearance(y0Var.l(i20, 0));
        } else {
            r2 = 0;
        }
        int i24 = r2 == true ? 1 : 0;
        int i25 = r2 == true ? 1 : 0;
        int i26 = r2 == true ? 1 : 0;
        int l2 = y0Var.l(i18, i24);
        CharSequence n2 = y0Var.n(R$styleable.TextInputLayout_errorContentDescription);
        boolean a3 = y0Var.a(R$styleable.TextInputLayout_errorEnabled, r2);
        LayoutInflater from = LayoutInflater.from(getContext());
        int i27 = R$layout.design_text_input_end_icon;
        CheckableImageButton checkableImageButton = (CheckableImageButton) from.inflate(i27, linearLayout2, (boolean) r2);
        this.q0 = checkableImageButton;
        checkableImageButton.setId(R$id.text_input_error_icon);
        checkableImageButton.setVisibility(8);
        if (f.b.a.c.b.o.b.f1(context2)) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(r2);
        }
        int i28 = R$styleable.TextInputLayout_errorIconDrawable;
        if (y0Var.o(i28)) {
            setErrorIconDrawable(y0Var.g(i28));
        }
        int i29 = R$styleable.TextInputLayout_errorIconTint;
        if (y0Var.o(i29)) {
            setErrorIconTintList(f.b.a.c.b.o.b.M0(context2, y0Var, i29));
        }
        int i30 = R$styleable.TextInputLayout_errorIconTintMode;
        if (y0Var.o(i30)) {
            setErrorIconTintMode(f.b.a.c.b.o.b.u1(y0Var.j(i30, -1), null));
        }
        checkableImageButton.setContentDescription(getResources().getText(R$string.error_icon_content_description));
        AtomicInteger atomicInteger = e.i.i.m.a;
        checkableImageButton.setImportantForAccessibility(i2);
        checkableImageButton.setClickable(false);
        checkableImageButton.setPressable(false);
        checkableImageButton.setFocusable(false);
        int l3 = y0Var.l(i19, 0);
        boolean a4 = y0Var.a(R$styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence n3 = y0Var.n(R$styleable.TextInputLayout_helperText);
        int l4 = y0Var.l(R$styleable.TextInputLayout_placeholderTextAppearance, 0);
        CharSequence n4 = y0Var.n(R$styleable.TextInputLayout_placeholderText);
        int l5 = y0Var.l(R$styleable.TextInputLayout_prefixTextAppearance, 0);
        CharSequence n5 = y0Var.n(R$styleable.TextInputLayout_prefixText);
        int l6 = y0Var.l(R$styleable.TextInputLayout_suffixTextAppearance, 0);
        CharSequence n6 = y0Var.n(R$styleable.TextInputLayout_suffixText);
        boolean a5 = y0Var.a(R$styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(y0Var.j(R$styleable.TextInputLayout_counterMaxLength, -1));
        this.n = y0Var.l(i16, 0);
        this.m = y0Var.l(i17, 0);
        CheckableImageButton checkableImageButton2 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_start_icon, (ViewGroup) this.c, false);
        this.R = checkableImageButton2;
        checkableImageButton2.setVisibility(8);
        if (f.b.a.c.b.o.b.f1(context2)) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton2.getLayoutParams()).setMarginEnd(0);
        }
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        int i31 = R$styleable.TextInputLayout_startIconDrawable;
        if (y0Var.o(i31)) {
            setStartIconDrawable(y0Var.g(i31));
            int i32 = R$styleable.TextInputLayout_startIconContentDescription;
            if (y0Var.o(i32)) {
                setStartIconContentDescription(y0Var.n(i32));
            }
            setStartIconCheckable(y0Var.a(R$styleable.TextInputLayout_startIconCheckable, true));
        }
        int i33 = R$styleable.TextInputLayout_startIconTint;
        if (y0Var.o(i33)) {
            setStartIconTintList(f.b.a.c.b.o.b.M0(context2, y0Var, i33));
        }
        int i34 = R$styleable.TextInputLayout_startIconTintMode;
        if (y0Var.o(i34)) {
            setStartIconTintMode(f.b.a.c.b.o.b.u1(y0Var.j(i34, -1), null));
        }
        setBoxBackgroundMode(y0Var.j(R$styleable.TextInputLayout_boxBackgroundMode, 0));
        this.f0 = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(i27, (ViewGroup) this.f607e, false);
        this.f607e.addView(this.f0);
        this.f0.setVisibility(8);
        if (f.b.a.c.b.o.b.f1(context2)) {
            i3 = 0;
            ((ViewGroup.MarginLayoutParams) this.f0.getLayoutParams()).setMarginStart(0);
        } else {
            i3 = 0;
        }
        this.e0.append(-1, new f.b.a.d.z.f(this));
        this.e0.append(i3, new q(this));
        this.e0.append(1, new r(this));
        this.e0.append(2, new f.b.a.d.z.a(this));
        this.e0.append(3, new f.b.a.d.z.h(this));
        int i35 = R$styleable.TextInputLayout_endIconMode;
        if (y0Var.o(i35)) {
            setEndIconMode(y0Var.j(i35, 0));
            int i36 = R$styleable.TextInputLayout_endIconDrawable;
            if (y0Var.o(i36)) {
                setEndIconDrawable(y0Var.g(i36));
            }
            int i37 = R$styleable.TextInputLayout_endIconContentDescription;
            if (y0Var.o(i37)) {
                setEndIconContentDescription(y0Var.n(i37));
            }
            setEndIconCheckable(y0Var.a(R$styleable.TextInputLayout_endIconCheckable, true));
        } else {
            int i38 = R$styleable.TextInputLayout_passwordToggleEnabled;
            if (y0Var.o(i38)) {
                setEndIconMode(y0Var.a(i38, false) ? 1 : 0);
                setEndIconDrawable(y0Var.g(R$styleable.TextInputLayout_passwordToggleDrawable));
                setEndIconContentDescription(y0Var.n(R$styleable.TextInputLayout_passwordToggleContentDescription));
                int i39 = R$styleable.TextInputLayout_passwordToggleTint;
                if (y0Var.o(i39)) {
                    setEndIconTintList(f.b.a.c.b.o.b.M0(context2, y0Var, i39));
                }
                int i40 = R$styleable.TextInputLayout_passwordToggleTintMode;
                if (y0Var.o(i40)) {
                    setEndIconTintMode(f.b.a.c.b.o.b.u1(y0Var.j(i40, -1), null));
                }
            }
        }
        if (!y0Var.o(R$styleable.TextInputLayout_passwordToggleEnabled)) {
            int i41 = R$styleable.TextInputLayout_endIconTint;
            if (y0Var.o(i41)) {
                setEndIconTintList(f.b.a.c.b.o.b.M0(context2, y0Var, i41));
            }
            int i42 = R$styleable.TextInputLayout_endIconTintMode;
            if (y0Var.o(i42)) {
                attributeSet2 = null;
                setEndIconTintMode(f.b.a.c.b.o.b.u1(y0Var.j(i42, -1), null));
                z zVar = new z(context2, attributeSet2);
                this.w = zVar;
                zVar.setId(R$id.textinput_prefix_text);
                zVar.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                zVar.setAccessibilityLiveRegion(1);
                this.c.addView(this.R);
                this.c.addView(zVar);
                z zVar2 = new z(context2, null);
                this.y = zVar2;
                zVar2.setId(R$id.textinput_suffix_text);
                zVar2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
                zVar2.setAccessibilityLiveRegion(1);
                this.f606d.addView(zVar2);
                this.f606d.addView(this.q0);
                this.f606d.addView(this.f607e);
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
                i4 = R$styleable.TextInputLayout_errorTextColor;
                if (y0Var.o(i4)) {
                    setErrorTextColor(y0Var.c(i4));
                }
                i5 = R$styleable.TextInputLayout_helperTextTextColor;
                if (y0Var.o(i5)) {
                    setHelperTextColor(y0Var.c(i5));
                }
                i6 = R$styleable.TextInputLayout_hintTextColor;
                if (y0Var.o(i6)) {
                    setHintTextColor(y0Var.c(i6));
                }
                i7 = R$styleable.TextInputLayout_counterTextColor;
                if (y0Var.o(i7)) {
                    setCounterTextColor(y0Var.c(i7));
                }
                i8 = R$styleable.TextInputLayout_counterOverflowTextColor;
                if (y0Var.o(i8)) {
                    setCounterOverflowTextColor(y0Var.c(i8));
                }
                i9 = R$styleable.TextInputLayout_placeholderTextColor;
                if (y0Var.o(i9)) {
                    setPlaceholderTextColor(y0Var.c(i9));
                }
                i10 = R$styleable.TextInputLayout_prefixTextColor;
                if (y0Var.o(i10)) {
                    setPrefixTextColor(y0Var.c(i10));
                }
                i11 = R$styleable.TextInputLayout_suffixTextColor;
                if (y0Var.o(i11)) {
                    setSuffixTextColor(y0Var.c(i11));
                }
                setCounterEnabled(a5);
                setEnabled(y0Var.a(R$styleable.TextInputLayout_android_enabled, true));
                y0Var.b.recycle();
                setImportantForAccessibility(2);
                i12 = Build.VERSION.SDK_INT;
                if (i12 >= 26 && i12 >= 26) {
                    setImportantForAutofill(1);
                    return;
                }
            }
        }
        attributeSet2 = null;
        z zVar3 = new z(context2, attributeSet2);
        this.w = zVar3;
        zVar3.setId(R$id.textinput_prefix_text);
        zVar3.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        zVar3.setAccessibilityLiveRegion(1);
        this.c.addView(this.R);
        this.c.addView(zVar3);
        z zVar22 = new z(context2, null);
        this.y = zVar22;
        zVar22.setId(R$id.textinput_suffix_text);
        zVar22.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 80));
        zVar22.setAccessibilityLiveRegion(1);
        this.f606d.addView(zVar22);
        this.f606d.addView(this.q0);
        this.f606d.addView(this.f607e);
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
        i4 = R$styleable.TextInputLayout_errorTextColor;
        if (y0Var.o(i4)) {
        }
        i5 = R$styleable.TextInputLayout_helperTextTextColor;
        if (y0Var.o(i5)) {
        }
        i6 = R$styleable.TextInputLayout_hintTextColor;
        if (y0Var.o(i6)) {
        }
        i7 = R$styleable.TextInputLayout_counterTextColor;
        if (y0Var.o(i7)) {
        }
        i8 = R$styleable.TextInputLayout_counterOverflowTextColor;
        if (y0Var.o(i8)) {
        }
        i9 = R$styleable.TextInputLayout_placeholderTextColor;
        if (y0Var.o(i9)) {
        }
        i10 = R$styleable.TextInputLayout_prefixTextColor;
        if (y0Var.o(i10)) {
        }
        i11 = R$styleable.TextInputLayout_suffixTextColor;
        if (y0Var.o(i11)) {
        }
        setCounterEnabled(a5);
        setEnabled(y0Var.a(R$styleable.TextInputLayout_android_enabled, true));
        y0Var.b.recycle();
        setImportantForAccessibility(2);
        i12 = Build.VERSION.SDK_INT;
        if (i12 >= 26) {
        }
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
        AtomicInteger atomicInteger = e.i.i.m.a;
        boolean hasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z2 = false;
        int i2 = 1;
        boolean z3 = onLongClickListener != null;
        if (hasOnClickListeners || z3) {
            z2 = true;
        }
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z3);
        if (!z2) {
            i2 = 2;
        }
        checkableImageButton.setImportantForAccessibility(i2);
    }

    private void setEditText(EditText editText) {
        if (this.f608f == null) {
            if (this.d0 != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f608f = editText;
            l();
            setTextInputAccessibilityDelegate(new e(this));
            this.E0.q(this.f608f.getTypeface());
            f.b.a.d.q.c cVar = this.E0;
            float textSize = this.f608f.getTextSize();
            if (cVar.f2783i != textSize) {
                cVar.f2783i = textSize;
                cVar.k();
            }
            int gravity = this.f608f.getGravity();
            this.E0.n((gravity & -113) | 48);
            f.b.a.d.q.c cVar2 = this.E0;
            if (cVar2.f2781g != gravity) {
                cVar2.f2781g = gravity;
                cVar2.k();
            }
            this.f608f.addTextChangedListener(new a());
            if (this.s0 == null) {
                this.s0 = this.f608f.getHintTextColors();
            }
            if (this.z) {
                if (TextUtils.isEmpty(this.A)) {
                    CharSequence hint = this.f608f.getHint();
                    this.f609g = hint;
                    setHint(hint);
                    this.f608f.setHint((CharSequence) null);
                }
                this.B = true;
            }
            if (this.f614l != null) {
                t(this.f608f.getText().length());
            }
            w();
            this.f610h.b();
            this.c.bringToFront();
            this.f606d.bringToFront();
            this.f607e.bringToFront();
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
        FrameLayout frameLayout = this.f607e;
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
            f.b.a.d.q.c cVar = this.E0;
            if (charSequence == null || !TextUtils.equals(cVar.w, charSequence)) {
                cVar.w = charSequence;
                cVar.x = null;
                Bitmap bitmap = cVar.z;
                if (bitmap != null) {
                    bitmap.recycle();
                    cVar.z = null;
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
                zVar.setId(R$id.textinput_placeholder);
                TextView textView = this.q;
                AtomicInteger atomicInteger = e.i.i.m.a;
                textView.setAccessibilityLiveRegion(1);
                setPlaceholderTextAppearance(this.s);
                setPlaceholderTextColor(this.r);
                TextView textView2 = this.q;
                if (textView2 != null) {
                    this.b.addView(textView2);
                    this.q.setVisibility(0);
                }
            } else {
                TextView textView3 = this.q;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                this.q = null;
            }
            this.p = z2;
        }
    }

    public final void A() {
        if (this.f608f != null) {
            int i2 = 0;
            if (!(this.R.getVisibility() == 0)) {
                EditText editText = this.f608f;
                AtomicInteger atomicInteger = e.i.i.m.a;
                i2 = editText.getPaddingStart();
            }
            TextView textView = this.w;
            int compoundPaddingTop = this.f608f.getCompoundPaddingTop();
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding);
            int compoundPaddingBottom = this.f608f.getCompoundPaddingBottom();
            AtomicInteger atomicInteger2 = e.i.i.m.a;
            textView.setPaddingRelative(i2, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
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
        if (this.f608f != null) {
            int i2 = 0;
            if (!k()) {
                if (!(this.q0.getVisibility() == 0)) {
                    EditText editText = this.f608f;
                    AtomicInteger atomicInteger = e.i.i.m.a;
                    i2 = editText.getPaddingEnd();
                }
            }
            TextView textView = this.y;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R$dimen.material_input_text_to_prefix_suffix_padding);
            int paddingTop = this.f608f.getPaddingTop();
            int paddingBottom = this.f608f.getPaddingBottom();
            AtomicInteger atomicInteger2 = e.i.i.m.a;
            textView.setPaddingRelative(dimensionPixelSize, paddingTop, i2, paddingBottom);
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
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e4  */
    public void F() {
        int i2;
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.C != null && this.G != 0) {
            boolean z2 = false;
            boolean z3 = isFocused() || ((editText2 = this.f608f) != null && editText2.hasFocus());
            boolean z4 = isHovered() || ((editText = this.f608f) != null && editText.isHovered());
            if (!isEnabled()) {
                i2 = this.C0;
            } else {
                if (this.f610h.e()) {
                    if (this.x0 == null) {
                        i2 = this.f610h.g();
                    }
                } else if (!this.f613k || (textView = this.f614l) == null) {
                    i2 = z3 ? this.w0 : z4 ? this.v0 : this.u0;
                } else if (this.x0 == null) {
                    i2 = textView.getCurrentTextColor();
                }
                C(z3, z4);
                if (getErrorIconDrawable() != null) {
                    n nVar = this.f610h;
                    if (nVar.f2951k && nVar.e()) {
                        z2 = true;
                    }
                }
                setErrorIconVisible(z2);
                p(this.q0, this.r0);
                p(this.R, this.S);
                o();
                if (getEndIconDelegate().d()) {
                    if (!this.f610h.e() || getEndIconDrawable() == null) {
                        d();
                    } else {
                        Drawable mutate = m.h.w1(getEndIconDrawable()).mutate();
                        mutate.setTint(this.f610h.g());
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
        if (this.f608f != null) {
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
            x();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    public void b(float f2) {
        if (this.E0.c != f2) {
            if (this.H0 == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.H0 = valueAnimator;
                valueAnimator.setInterpolator(f.b.a.d.a.a.b);
                this.H0.setDuration(167L);
                this.H0.addUpdateListener(new d());
            }
            this.H0.setFloatValues(this.E0.c, f2);
            this.H0.start();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
    public final void c() {
        boolean z2;
        f.b.a.d.v.g gVar;
        f.b.a.d.v.g gVar2 = this.C;
        if (gVar2 != null) {
            gVar2.setShapeAppearanceModel(this.E);
            boolean z3 = false;
            if (this.G == 2) {
                if (this.I > -1 && this.L != 0) {
                    z2 = true;
                    if (z2) {
                        this.C.t((float) this.I, this.L);
                    }
                    int i2 = this.M;
                    if (this.G == 1) {
                        i2 = e.i.c.a.a(this.M, f.b.a.c.b.o.b.J0(getContext(), R$attr.colorSurface, 0));
                    }
                    this.M = i2;
                    this.C.q(ColorStateList.valueOf(i2));
                    if (this.d0 == 3) {
                        this.f608f.getBackground().invalidateSelf();
                    }
                    gVar = this.D;
                    if (gVar != null) {
                        if (this.I > -1 && this.L != 0) {
                            z3 = true;
                        }
                        if (z3) {
                            gVar.q(ColorStateList.valueOf(this.L));
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
            this.C.q(ColorStateList.valueOf(i22));
            if (this.d0 == 3) {
            }
            gVar = this.D;
            if (gVar != null) {
            }
            invalidate();
        }
    }

    public final void d() {
        e(this.f0, this.i0, this.h0, this.k0, this.j0);
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        EditText editText = this.f608f;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        if (this.f609g != null) {
            boolean z2 = this.B;
            this.B = false;
            CharSequence hint = editText.getHint();
            this.f608f.setHint(this.f609g);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i2);
            } finally {
                this.f608f.setHint(hint);
                this.B = z2;
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
                if (childAt == this.f608f) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.J0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.J0 = false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.z) {
            f.b.a.d.q.c cVar = this.E0;
            Objects.requireNonNull(cVar);
            int save = canvas.save();
            if (cVar.x != null && cVar.b) {
                cVar.N.getLineLeft(0);
                cVar.E.setTextSize(cVar.B);
                float f2 = cVar.q;
                float f3 = cVar.r;
                float f4 = cVar.A;
                if (f4 != 1.0f) {
                    canvas.scale(f4, f4, f2, f3);
                }
                canvas.translate(f2, f3);
                cVar.N.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        f.b.a.d.v.g gVar = this.D;
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
        if (!this.I0) {
            boolean z4 = true;
            this.I0 = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            f.b.a.d.q.c cVar = this.E0;
            if (cVar != null) {
                cVar.C = drawableState;
                ColorStateList colorStateList2 = cVar.f2786l;
                if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = cVar.f2785k) != null && colorStateList.isStateful())) {
                    cVar.k();
                    z3 = true;
                } else {
                    z3 = false;
                }
                z2 = z3 | false;
            } else {
                z2 = false;
            }
            if (this.f608f != null) {
                AtomicInteger atomicInteger = e.i.i.m.a;
                if (!isLaidOut() || !isEnabled()) {
                    z4 = false;
                }
                y(z4, false);
            }
            w();
            F();
            if (z2) {
                invalidate();
            }
            this.I0 = false;
        }
    }

    public final void e(CheckableImageButton checkableImageButton, boolean z2, ColorStateList colorStateList, boolean z3, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z2 || z3)) {
            drawable = m.h.w1(drawable).mutate();
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
        return this.z && !TextUtils.isEmpty(this.A) && (this.C instanceof f.b.a.d.z.g);
    }

    public int getBaseline() {
        EditText editText = this.f608f;
        if (editText == null) {
            return super.getBaseline();
        }
        return f() + getPaddingTop() + editText.getBaseline();
    }

    public f.b.a.d.v.g getBoxBackground() {
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
        f.b.a.d.v.g gVar = this.C;
        return gVar.b.a.f2887h.a(gVar.h());
    }

    public float getBoxCornerRadiusBottomStart() {
        f.b.a.d.v.g gVar = this.C;
        return gVar.b.a.f2886g.a(gVar.h());
    }

    public float getBoxCornerRadiusTopEnd() {
        f.b.a.d.v.g gVar = this.C;
        return gVar.b.a.f2885f.a(gVar.h());
    }

    public float getBoxCornerRadiusTopStart() {
        return this.C.l();
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
        return this.f612j;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.f611i || !this.f613k || (textView = this.f614l) == null) {
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
        return this.f608f;
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
        n nVar = this.f610h;
        if (nVar.f2951k) {
            return nVar.f2950j;
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.f610h.m;
    }

    public int getErrorCurrentTextColors() {
        return this.f610h.g();
    }

    public Drawable getErrorIconDrawable() {
        return this.q0.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        return this.f610h.g();
    }

    public CharSequence getHelperText() {
        n nVar = this.f610h;
        if (nVar.q) {
            return nVar.p;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        TextView textView = this.f610h.r;
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
        int compoundPaddingLeft = this.f608f.getCompoundPaddingLeft() + i2;
        return (this.v == null || z2) ? compoundPaddingLeft : (compoundPaddingLeft - this.w.getMeasuredWidth()) + this.w.getPaddingLeft();
    }

    public final int i(int i2, boolean z2) {
        int compoundPaddingRight = i2 - this.f608f.getCompoundPaddingRight();
        return (this.v == null || !z2) ? compoundPaddingRight : compoundPaddingRight + (this.w.getMeasuredWidth() - this.w.getPaddingRight());
    }

    public final boolean j() {
        return this.d0 != 0;
    }

    public boolean k() {
        return this.f607e.getVisibility() == 0 && this.f0.getVisibility() == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    public final void l() {
        EditText editText;
        int i2;
        Resources resources;
        int i3;
        int i4;
        int i5;
        EditText editText2;
        int i6;
        Resources resources2;
        int i7 = this.G;
        if (i7 == 0) {
            this.C = null;
        } else if (i7 == 1) {
            this.C = new f.b.a.d.v.g(this.E);
            this.D = new f.b.a.d.v.g();
            editText = this.f608f;
            if (editText == null && this.C != null && editText.getBackground() == null && this.G != 0) {
                EditText editText3 = this.f608f;
                f.b.a.d.v.g gVar = this.C;
                AtomicInteger atomicInteger = e.i.i.m.a;
                editText3.setBackground(gVar);
            }
            F();
            if (this.G == 1) {
                if (f.b.a.c.b.o.b.g1(getContext())) {
                    resources2 = getResources();
                    i6 = R$dimen.material_font_2_0_box_collapsed_padding_top;
                } else if (f.b.a.c.b.o.b.f1(getContext())) {
                    resources2 = getResources();
                    i6 = R$dimen.material_font_1_3_box_collapsed_padding_top;
                }
                this.H = resources2.getDimensionPixelSize(i6);
            }
            if (this.f608f != null && this.G == 1) {
                if (!f.b.a.c.b.o.b.g1(getContext())) {
                    editText2 = this.f608f;
                    AtomicInteger atomicInteger2 = e.i.i.m.a;
                    i5 = editText2.getPaddingStart();
                    i4 = getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_2_0_padding_top);
                    i3 = this.f608f.getPaddingEnd();
                    resources = getResources();
                    i2 = R$dimen.material_filled_edittext_font_2_0_padding_bottom;
                } else if (f.b.a.c.b.o.b.f1(getContext())) {
                    editText2 = this.f608f;
                    AtomicInteger atomicInteger3 = e.i.i.m.a;
                    i5 = editText2.getPaddingStart();
                    i4 = getResources().getDimensionPixelSize(R$dimen.material_filled_edittext_font_1_3_padding_top);
                    i3 = this.f608f.getPaddingEnd();
                    resources = getResources();
                    i2 = R$dimen.material_filled_edittext_font_1_3_padding_bottom;
                }
                editText2.setPaddingRelative(i5, i4, i3, resources.getDimensionPixelSize(i2));
            }
            if (this.G == 0) {
                x();
                return;
            }
            return;
        } else if (i7 == 2) {
            this.C = (!this.z || (this.C instanceof f.b.a.d.z.g)) ? new f.b.a.d.v.g(this.E) : new f.b.a.d.z.g(this.E);
        } else {
            throw new IllegalArgumentException(this.G + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
        this.D = null;
        editText = this.f608f;
        if (editText == null && this.C != null && editText.getBackground() == null && this.G != 0) {
        }
        F();
        if (this.G == 1) {
        }
        if (!f.b.a.c.b.o.b.g1(getContext())) {
        }
        editText2.setPaddingRelative(i5, i4, i3, resources.getDimensionPixelSize(i2));
        if (this.G == 0) {
        }
    }

    public final void m() {
        float f2;
        float f3;
        float f4;
        if (g()) {
            RectF rectF = this.P;
            f.b.a.d.q.c cVar = this.E0;
            int width = this.f608f.getWidth();
            int gravity = this.f608f.getGravity();
            boolean c2 = cVar.c(cVar.w);
            cVar.y = c2;
            if (gravity == 17 || (gravity & 7) == 1) {
                f4 = ((float) width) / 2.0f;
                f3 = cVar.b() / 2.0f;
            } else if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5 ? !c2 : c2) {
                f4 = (float) cVar.f2779e.right;
                f3 = cVar.b();
            } else {
                f2 = (float) cVar.f2779e.left;
                rectF.left = f2;
                Rect rect = cVar.f2779e;
                rectF.top = (float) rect.top;
                rectF.right = (gravity != 17 || (gravity & 7) == 1) ? (((float) width) / 2.0f) + (cVar.b() / 2.0f) : ((gravity & 8388613) == 8388613 || (gravity & 5) == 5 ? !cVar.y : cVar.y) ? (float) rect.right : cVar.b() + f2;
                float f5 = cVar.f() + ((float) cVar.f2779e.top);
                rectF.bottom = f5;
                float f6 = rectF.left;
                float f7 = (float) this.F;
                rectF.left = f6 - f7;
                rectF.top -= f7;
                rectF.right += f7;
                rectF.bottom = f5 + f7;
                rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
                f.b.a.d.z.g gVar = (f.b.a.d.z.g) this.C;
                Objects.requireNonNull(gVar);
                gVar.z(rectF.left, rectF.top, rectF.right, rectF.bottom);
            }
            f2 = f4 - f3;
            rectF.left = f2;
            Rect rect2 = cVar.f2779e;
            rectF.top = (float) rect2.top;
            rectF.right = (gravity != 17 || (gravity & 7) == 1) ? (((float) width) / 2.0f) + (cVar.b() / 2.0f) : ((gravity & 8388613) == 8388613 || (gravity & 5) == 5 ? !cVar.y : cVar.y) ? (float) rect2.right : cVar.b() + f2;
            float f52 = cVar.f() + ((float) cVar.f2779e.top);
            rectF.bottom = f52;
            float f62 = rectF.left;
            float f72 = (float) this.F;
            rectF.left = f62 - f72;
            rectF.top -= f72;
            rectF.right += f72;
            rectF.bottom = f52 + f72;
            rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
            f.b.a.d.z.g gVar2 = (f.b.a.d.z.g) this.C;
            Objects.requireNonNull(gVar2);
            gVar2.z(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    public void o() {
        p(this.f0, this.h0);
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
        EditText editText = this.f608f;
        if (editText != null) {
            Rect rect = this.N;
            f.b.a.d.q.d.a(this, editText, rect);
            f.b.a.d.v.g gVar = this.D;
            if (gVar != null) {
                int i12 = rect.bottom;
                gVar.setBounds(rect.left, i12 - this.K, rect.right, i12);
            }
            if (this.z) {
                f.b.a.d.q.c cVar = this.E0;
                float textSize = this.f608f.getTextSize();
                if (cVar.f2783i != textSize) {
                    cVar.f2783i = textSize;
                    cVar.k();
                }
                int gravity = this.f608f.getGravity();
                this.E0.n((gravity & -113) | 48);
                f.b.a.d.q.c cVar2 = this.E0;
                if (cVar2.f2781g != gravity) {
                    cVar2.f2781g = gravity;
                    cVar2.k();
                }
                f.b.a.d.q.c cVar3 = this.E0;
                if (this.f608f != null) {
                    Rect rect2 = this.O;
                    AtomicInteger atomicInteger = e.i.i.m.a;
                    boolean z3 = false;
                    boolean z4 = getLayoutDirection() == 1;
                    rect2.bottom = rect.bottom;
                    int i13 = this.G;
                    if (i13 == 1) {
                        rect2.left = h(rect.left, z4);
                        i11 = rect.top + this.H;
                    } else if (i13 != 2) {
                        rect2.left = h(rect.left, z4);
                        i11 = getPaddingTop();
                    } else {
                        rect2.left = this.f608f.getPaddingLeft() + rect.left;
                        rect2.top = rect.top - f();
                        i6 = rect.right - this.f608f.getPaddingRight();
                        rect2.right = i6;
                        Objects.requireNonNull(cVar3);
                        i7 = rect2.left;
                        i8 = rect2.top;
                        i9 = rect2.right;
                        i10 = rect2.bottom;
                        if (!f.b.a.d.q.c.l(cVar3.f2779e, i7, i8, i9, i10)) {
                            cVar3.f2779e.set(i7, i8, i9, i10);
                            cVar3.D = true;
                            cVar3.j();
                        }
                        f.b.a.d.q.c cVar4 = this.E0;
                        if (this.f608f == null) {
                            Rect rect3 = this.O;
                            TextPaint textPaint = cVar4.F;
                            textPaint.setTextSize(cVar4.f2783i);
                            textPaint.setTypeface(cVar4.t);
                            textPaint.setLetterSpacing(0.0f);
                            float f2 = -cVar4.F.ascent();
                            rect3.left = this.f608f.getCompoundPaddingLeft() + rect.left;
                            rect3.top = this.G == 1 && this.f608f.getMinLines() <= 1 ? (int) (((float) rect.centerY()) - (f2 / 2.0f)) : rect.top + this.f608f.getCompoundPaddingTop();
                            rect3.right = rect.right - this.f608f.getCompoundPaddingRight();
                            if (this.G == 1 && this.f608f.getMinLines() <= 1) {
                                z3 = true;
                            }
                            int compoundPaddingBottom = z3 ? (int) (((float) rect3.top) + f2) : rect.bottom - this.f608f.getCompoundPaddingBottom();
                            rect3.bottom = compoundPaddingBottom;
                            int i14 = rect3.left;
                            int i15 = rect3.top;
                            int i16 = rect3.right;
                            if (!f.b.a.d.q.c.l(cVar4.f2778d, i14, i15, i16, compoundPaddingBottom)) {
                                cVar4.f2778d.set(i14, i15, i16, compoundPaddingBottom);
                                cVar4.D = true;
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
                    rect2.top = i11;
                    i6 = i(rect.right, z4);
                    rect2.right = i6;
                    Objects.requireNonNull(cVar3);
                    i7 = rect2.left;
                    i8 = rect2.top;
                    i9 = rect2.right;
                    i10 = rect2.bottom;
                    if (!f.b.a.d.q.c.l(cVar3.f2779e, i7, i8, i9, i10)) {
                    }
                    f.b.a.d.q.c cVar42 = this.E0;
                    if (this.f608f == null) {
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
        if (this.f608f != null && this.f608f.getMeasuredHeight() < (max = Math.max(this.f606d.getMeasuredHeight(), this.c.getMeasuredHeight()))) {
            this.f608f.setMinimumHeight(max);
            z2 = true;
        }
        boolean v2 = v();
        if (z2 || v2) {
            this.f608f.post(new c());
        }
        if (!(this.q == null || (editText = this.f608f) == null)) {
            this.q.setGravity(editText.getGravity());
            this.q.setPadding(this.f608f.getCompoundPaddingLeft(), this.f608f.getCompoundPaddingTop(), this.f608f.getCompoundPaddingRight(), this.f608f.getCompoundPaddingBottom());
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
        super.onRestoreInstanceState(hVar.b);
        setError(hVar.f616d);
        if (hVar.f617e) {
            this.f0.post(new b());
        }
        setHint(hVar.f618f);
        setHelperText(hVar.f619g);
        setPlaceholderText(hVar.f620h);
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        if (this.f610h.e()) {
            hVar.f616d = getError();
        }
        hVar.f617e = j() && this.f0.isChecked();
        hVar.f618f = getHint();
        hVar.f619g = getHelperText();
        hVar.f620h = getPlaceholderText();
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
            Drawable mutate = m.h.w1(drawable).mutate();
            mutate.setTintList(ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    public void r(TextView textView, int i2) {
        boolean z2 = true;
        try {
            m.h.d1(textView, i2);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z2 = false;
            }
        } catch (Exception unused) {
        }
        if (z2) {
            m.h.d1(textView, R$style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(e.i.b.a.a(getContext(), R$color.design_error));
        }
    }

    public final void s() {
        if (this.f614l != null) {
            EditText editText = this.f608f;
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
        setBoxBackgroundColor(e.i.b.a.a(getContext(), i2));
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
            if (this.f608f != null) {
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
        if (this.f611i != z2) {
            if (z2) {
                z zVar = new z(getContext(), null);
                this.f614l = zVar;
                zVar.setId(R$id.textinput_counter);
                Typeface typeface = this.Q;
                if (typeface != null) {
                    this.f614l.setTypeface(typeface);
                }
                this.f614l.setMaxLines(1);
                this.f610h.a(this.f614l, 2);
                ((ViewGroup.MarginLayoutParams) this.f614l.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_counter_margin_start));
                u();
                s();
            } else {
                this.f610h.j(this.f614l, 2);
                this.f614l = null;
            }
            this.f611i = z2;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.f612j != i2) {
            if (i2 <= 0) {
                i2 = -1;
            }
            this.f612j = i2;
            if (this.f611i) {
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
        if (this.f608f != null) {
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
        setEndIconDrawable(i2 != 0 ? e.b.b.a.a.b(getContext(), i2) : null);
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
        StringBuilder h2 = f.a.a.a.a.h("The current box background mode ");
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
        if (!this.f610h.f2951k) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            n nVar = this.f610h;
            nVar.c();
            nVar.f2950j = charSequence;
            nVar.f2952l.setText(charSequence);
            int i2 = nVar.f2948h;
            if (i2 != 1) {
                nVar.f2949i = 1;
            }
            nVar.l(i2, nVar.f2949i, nVar.k(nVar.f2952l, charSequence));
            return;
        }
        this.f610h.i();
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        n nVar = this.f610h;
        nVar.m = charSequence;
        TextView textView = nVar.f2952l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z2) {
        n nVar = this.f610h;
        if (nVar.f2951k != z2) {
            nVar.c();
            if (z2) {
                z zVar = new z(nVar.a, null);
                nVar.f2952l = zVar;
                zVar.setId(R$id.textinput_error);
                nVar.f2952l.setTextAlignment(5);
                Typeface typeface = nVar.u;
                if (typeface != null) {
                    nVar.f2952l.setTypeface(typeface);
                }
                int i2 = nVar.n;
                nVar.n = i2;
                TextView textView = nVar.f2952l;
                if (textView != null) {
                    nVar.b.r(textView, i2);
                }
                ColorStateList colorStateList = nVar.o;
                nVar.o = colorStateList;
                TextView textView2 = nVar.f2952l;
                if (!(textView2 == null || colorStateList == null)) {
                    textView2.setTextColor(colorStateList);
                }
                CharSequence charSequence = nVar.m;
                nVar.m = charSequence;
                TextView textView3 = nVar.f2952l;
                if (textView3 != null) {
                    textView3.setContentDescription(charSequence);
                }
                nVar.f2952l.setVisibility(4);
                TextView textView4 = nVar.f2952l;
                AtomicInteger atomicInteger = e.i.i.m.a;
                textView4.setAccessibilityLiveRegion(1);
                nVar.a(nVar.f2952l, 0);
            } else {
                nVar.i();
                nVar.j(nVar.f2952l, 0);
                nVar.f2952l = null;
                nVar.b.w();
                nVar.b.F();
            }
            nVar.f2951k = z2;
        }
    }

    public void setErrorIconDrawable(int i2) {
        setErrorIconDrawable(i2 != 0 ? e.b.b.a.a.b(getContext(), i2) : null);
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
            drawable = m.h.w1(drawable).mutate();
            drawable.setTintList(colorStateList);
        }
        if (this.q0.getDrawable() != drawable) {
            this.q0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.q0.getDrawable();
        if (drawable != null) {
            drawable = m.h.w1(drawable).mutate();
            drawable.setTintMode(mode);
        }
        if (this.q0.getDrawable() != drawable) {
            this.q0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i2) {
        n nVar = this.f610h;
        nVar.n = i2;
        TextView textView = nVar.f2952l;
        if (textView != null) {
            nVar.b.r(textView, i2);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        n nVar = this.f610h;
        nVar.o = colorStateList;
        TextView textView = nVar.f2952l;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setExpandedHintEnabled(boolean z2) {
        if (this.F0 != z2) {
            this.F0 = z2;
            y(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!this.f610h.q) {
                setHelperTextEnabled(true);
            }
            n nVar = this.f610h;
            nVar.c();
            nVar.p = charSequence;
            nVar.r.setText(charSequence);
            int i2 = nVar.f2948h;
            if (i2 != 2) {
                nVar.f2949i = 2;
            }
            nVar.l(i2, nVar.f2949i, nVar.k(nVar.r, charSequence));
        } else if (this.f610h.q) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        n nVar = this.f610h;
        nVar.t = colorStateList;
        TextView textView = nVar.r;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setHelperTextEnabled(boolean z2) {
        n nVar = this.f610h;
        if (nVar.q != z2) {
            nVar.c();
            if (z2) {
                z zVar = new z(nVar.a, null);
                nVar.r = zVar;
                zVar.setId(R$id.textinput_helper_text);
                nVar.r.setTextAlignment(5);
                Typeface typeface = nVar.u;
                if (typeface != null) {
                    nVar.r.setTypeface(typeface);
                }
                nVar.r.setVisibility(4);
                TextView textView = nVar.r;
                AtomicInteger atomicInteger = e.i.i.m.a;
                textView.setAccessibilityLiveRegion(1);
                int i2 = nVar.s;
                nVar.s = i2;
                TextView textView2 = nVar.r;
                if (textView2 != null) {
                    m.h.d1(textView2, i2);
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
                int i3 = nVar.f2948h;
                if (i3 == 2) {
                    nVar.f2949i = 0;
                }
                nVar.l(i3, nVar.f2949i, nVar.k(nVar.r, null));
                nVar.j(nVar.r, 1);
                nVar.r = null;
                nVar.b.w();
                nVar.b.F();
            }
            nVar.q = z2;
        }
    }

    public void setHelperTextTextAppearance(int i2) {
        n nVar = this.f610h;
        nVar.s = i2;
        TextView textView = nVar.r;
        if (textView != null) {
            m.h.d1(textView, i2);
        }
    }

    public void setHint(int i2) {
        setHint(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setHint(CharSequence charSequence) {
        if (this.z) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z2) {
        this.G0 = z2;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.z) {
            this.z = z2;
            if (!z2) {
                this.B = false;
                if (!TextUtils.isEmpty(this.A) && TextUtils.isEmpty(this.f608f.getHint())) {
                    this.f608f.setHint(this.A);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f608f.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.A)) {
                        setHint(hint);
                    }
                    this.f608f.setHint((CharSequence) null);
                }
                this.B = true;
            }
            if (this.f608f != null) {
                x();
            }
        }
    }

    public void setHintTextAppearance(int i2) {
        f.b.a.d.q.c cVar = this.E0;
        f.b.a.d.s.b bVar = new f.b.a.d.s.b(cVar.a.getContext(), i2);
        ColorStateList colorStateList = bVar.a;
        if (colorStateList != null) {
            cVar.f2786l = colorStateList;
        }
        float f2 = bVar.f2846k;
        if (f2 != 0.0f) {
            cVar.f2784j = f2;
        }
        ColorStateList colorStateList2 = bVar.b;
        if (colorStateList2 != null) {
            cVar.L = colorStateList2;
        }
        cVar.J = bVar.f2841f;
        cVar.K = bVar.f2842g;
        cVar.I = bVar.f2843h;
        cVar.M = bVar.f2845j;
        f.b.a.d.s.a aVar = cVar.v;
        if (aVar != null) {
            aVar.c = true;
        }
        f.b.a.d.q.b bVar2 = new f.b.a.d.q.b(cVar);
        bVar.a();
        cVar.v = new f.b.a.d.s.a(bVar2, bVar.n);
        bVar.b(cVar.a.getContext(), cVar.v);
        cVar.k();
        this.t0 = this.E0.f2786l;
        if (this.f608f != null) {
            y(false, false);
            x();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.t0 != colorStateList) {
            if (this.s0 == null) {
                f.b.a.d.q.c cVar = this.E0;
                if (cVar.f2786l != colorStateList) {
                    cVar.f2786l = colorStateList;
                    cVar.k();
                }
            }
            this.t0 = colorStateList;
            if (this.f608f != null) {
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
        setPasswordVisibilityToggleDrawable(i2 != 0 ? e.b.b.a.a.b(getContext(), i2) : null);
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
        EditText editText = this.f608f;
        if (editText != null) {
            i2 = editText.getText().length();
        }
        z(i2);
    }

    public void setPlaceholderTextAppearance(int i2) {
        this.s = i2;
        TextView textView = this.q;
        if (textView != null) {
            m.h.d1(textView, i2);
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
        m.h.d1(this.w, i2);
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
        setStartIconDrawable(i2 != 0 ? e.b.b.a.a.b(getContext(), i2) : null);
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
        m.h.d1(this.y, i2);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.y.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.f608f;
        if (editText != null) {
            e.i.i.m.r(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.Q) {
            this.Q = typeface;
            this.E0.q(typeface);
            n nVar = this.f610h;
            if (typeface != nVar.u) {
                nVar.u = typeface;
                TextView textView = nVar.f2952l;
                if (textView != null) {
                    textView.setTypeface(typeface);
                }
                TextView textView2 = nVar.r;
                if (textView2 != null) {
                    textView2.setTypeface(typeface);
                }
            }
            TextView textView3 = this.f614l;
            if (textView3 != null) {
                textView3.setTypeface(typeface);
            }
        }
    }

    public void t(int i2) {
        boolean z2 = this.f613k;
        int i3 = this.f612j;
        String str = null;
        if (i3 == -1) {
            this.f614l.setText(String.valueOf(i2));
            this.f614l.setContentDescription(null);
            this.f613k = false;
        } else {
            this.f613k = i2 > i3;
            Context context = getContext();
            this.f614l.setContentDescription(context.getString(this.f613k ? R$string.character_counter_overflowed_content_description : R$string.character_counter_content_description, Integer.valueOf(i2), Integer.valueOf(this.f612j)));
            if (z2 != this.f613k) {
                u();
            }
            e.i.g.a c2 = e.i.g.a.c();
            TextView textView = this.f614l;
            String string = getContext().getString(R$string.character_counter_pattern, Integer.valueOf(i2), Integer.valueOf(this.f612j));
            e.i.g.c cVar = c2.c;
            if (string != null) {
                str = c2.d(string, cVar, true).toString();
            }
            textView.setText(str);
        }
        if (this.f608f != null && z2 != this.f613k) {
            y(false, false);
            F();
            w();
        }
    }

    public final void u() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f614l;
        if (textView != null) {
            r(textView, this.f613k ? this.m : this.n);
            if (!this.f613k && (colorStateList2 = this.t) != null) {
                this.f614l.setTextColor(colorStateList2);
            }
            if (this.f613k && (colorStateList = this.u) != null) {
                this.f614l.setTextColor(colorStateList);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0104  */
    public final boolean v() {
        boolean z2;
        if (this.f608f == null) {
            return false;
        }
        boolean z3 = true;
        if (!(getStartIconDrawable() == null && this.v == null) && this.c.getMeasuredWidth() > 0) {
            int measuredWidth = this.c.getMeasuredWidth() - this.f608f.getPaddingLeft();
            if (this.W == null || this.a0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.W = colorDrawable;
                this.a0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] compoundDrawablesRelative = this.f608f.getCompoundDrawablesRelative();
            Drawable drawable = compoundDrawablesRelative[0];
            Drawable drawable2 = this.W;
            if (drawable != drawable2) {
                this.f608f.setCompoundDrawablesRelative(drawable2, compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
            }
            z2 = false;
            if ((this.q0.getVisibility() != 0 || ((j() && k()) || this.x != null)) && this.f606d.getMeasuredWidth() > 0) {
                int measuredWidth2 = this.y.getMeasuredWidth() - this.f608f.getPaddingRight();
                CheckableImageButton endIconToUpdateDummyDrawable = getEndIconToUpdateDummyDrawable();
                if (endIconToUpdateDummyDrawable != null) {
                    measuredWidth2 = ((ViewGroup.MarginLayoutParams) endIconToUpdateDummyDrawable.getLayoutParams()).getMarginStart() + endIconToUpdateDummyDrawable.getMeasuredWidth() + measuredWidth2;
                }
                Drawable[] compoundDrawablesRelative2 = this.f608f.getCompoundDrawablesRelative();
                Drawable drawable3 = this.l0;
                if (drawable3 == null || this.m0 == measuredWidth2) {
                    if (drawable3 == null) {
                        ColorDrawable colorDrawable2 = new ColorDrawable();
                        this.l0 = colorDrawable2;
                        this.m0 = measuredWidth2;
                        colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
                    }
                    Drawable drawable4 = compoundDrawablesRelative2[2];
                    Drawable drawable5 = this.l0;
                    if (drawable4 != drawable5) {
                        this.n0 = compoundDrawablesRelative2[2];
                        this.f608f.setCompoundDrawablesRelative(compoundDrawablesRelative2[0], compoundDrawablesRelative2[1], drawable5, compoundDrawablesRelative2[3]);
                    } else {
                        z3 = z2;
                    }
                } else {
                    this.m0 = measuredWidth2;
                    drawable3.setBounds(0, 0, measuredWidth2, 1);
                    this.f608f.setCompoundDrawablesRelative(compoundDrawablesRelative2[0], compoundDrawablesRelative2[1], this.l0, compoundDrawablesRelative2[3]);
                }
            } else if (this.l0 == null) {
                return z2;
            } else {
                Drawable[] compoundDrawablesRelative3 = this.f608f.getCompoundDrawablesRelative();
                if (compoundDrawablesRelative3[2] == this.l0) {
                    this.f608f.setCompoundDrawablesRelative(compoundDrawablesRelative3[0], compoundDrawablesRelative3[1], this.n0, compoundDrawablesRelative3[3]);
                } else {
                    z3 = z2;
                }
                this.l0 = null;
            }
            return z3;
        }
        if (this.W != null) {
            Drawable[] compoundDrawablesRelative4 = this.f608f.getCompoundDrawablesRelative();
            this.f608f.setCompoundDrawablesRelative(null, compoundDrawablesRelative4[1], compoundDrawablesRelative4[2], compoundDrawablesRelative4[3]);
            this.W = null;
        }
        z2 = false;
        if ((this.q0.getVisibility() != 0 || ((j() && k()) || this.x != null)) && this.f606d.getMeasuredWidth() > 0) {
        }
        return z3;
        z2 = true;
        if ((this.q0.getVisibility() != 0 || ((j() && k()) || this.x != null)) && this.f606d.getMeasuredWidth() > 0) {
        }
        return z3;
    }

    public void w() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.f608f;
        if (editText != null && this.G == 0 && (background = editText.getBackground()) != null) {
            if (e0.a(background)) {
                background = background.mutate();
            }
            if (this.f610h.e()) {
                currentTextColor = this.f610h.g();
            } else if (!this.f613k || (textView = this.f614l) == null) {
                m.h.t(background);
                this.f608f.refreshDrawableState();
                return;
            } else {
                currentTextColor = textView.getCurrentTextColor();
            }
            background.setColorFilter(e.b.f.j.c(currentTextColor, PorterDuff.Mode.SRC_IN));
        }
    }

    public final void x() {
        if (this.G != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.b.getLayoutParams();
            int f2 = f();
            if (f2 != layoutParams.topMargin) {
                layoutParams.topMargin = f2;
                this.b.requestLayout();
            }
        }
    }

    public final void y(boolean z2, boolean z3) {
        f.b.a.d.q.c cVar;
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f608f;
        int i2 = 0;
        boolean z4 = editText != null && !TextUtils.isEmpty(editText.getText());
        EditText editText2 = this.f608f;
        boolean z5 = editText2 != null && editText2.hasFocus();
        boolean e2 = this.f610h.e();
        ColorStateList colorStateList2 = this.s0;
        if (colorStateList2 != null) {
            f.b.a.d.q.c cVar2 = this.E0;
            if (cVar2.f2786l != colorStateList2) {
                cVar2.f2786l = colorStateList2;
                cVar2.k();
            }
            f.b.a.d.q.c cVar3 = this.E0;
            ColorStateList colorStateList3 = this.s0;
            if (cVar3.f2785k != colorStateList3) {
                cVar3.f2785k = colorStateList3;
                cVar3.k();
            }
        }
        if (!isEnabled) {
            ColorStateList colorStateList4 = this.s0;
            int colorForState = colorStateList4 != null ? colorStateList4.getColorForState(new int[]{-16842910}, this.C0) : this.C0;
            this.E0.m(ColorStateList.valueOf(colorForState));
            f.b.a.d.q.c cVar4 = this.E0;
            ColorStateList valueOf = ColorStateList.valueOf(colorForState);
            if (cVar4.f2785k != valueOf) {
                cVar4.f2785k = valueOf;
                cVar4.k();
            }
        } else if (e2) {
            f.b.a.d.q.c cVar5 = this.E0;
            TextView textView2 = this.f610h.f2952l;
            cVar5.m(textView2 != null ? textView2.getTextColors() : null);
        } else {
            if (this.f613k && (textView = this.f614l) != null) {
                cVar = this.E0;
                colorStateList = textView.getTextColors();
            } else if (z5 && (colorStateList = this.t0) != null) {
                cVar = this.E0;
            }
            cVar.m(colorStateList);
        }
        if (z4 || !this.F0 || (isEnabled() && z5)) {
            if (z3 || this.D0) {
                ValueAnimator valueAnimator = this.H0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.H0.cancel();
                }
                if (!z2 || !this.G0) {
                    this.E0.o(1.0f);
                } else {
                    b(1.0f);
                }
                this.D0 = false;
                if (g()) {
                    m();
                }
                EditText editText3 = this.f608f;
                if (editText3 != null) {
                    i2 = editText3.getText().length();
                }
                z(i2);
                B();
                E();
            }
        } else if (z3 || !this.D0) {
            ValueAnimator valueAnimator2 = this.H0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.H0.cancel();
            }
            if (!z2 || !this.G0) {
                this.E0.o(0.0f);
            } else {
                b(0.0f);
            }
            if (g() && (!((f.b.a.d.z.g) this.C).A.isEmpty()) && g()) {
                ((f.b.a.d.z.g) this.C).z(0.0f, 0.0f, 0.0f, 0.0f);
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
        setErrorIconVisible(drawable != null && this.f610h.f2951k);
    }
}
