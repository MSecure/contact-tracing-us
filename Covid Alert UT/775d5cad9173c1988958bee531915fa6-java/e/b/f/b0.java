package e.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import e.b.a.m;
import e.i.b.b.h;
import e.i.i.v;
import e.i.j.b;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class b0 {
    public final TextView a;
    public a1 b;
    public a1 c;

    /* renamed from: d  reason: collision with root package name */
    public a1 f837d;

    /* renamed from: e  reason: collision with root package name */
    public a1 f838e;

    /* renamed from: f  reason: collision with root package name */
    public a1 f839f;

    /* renamed from: g  reason: collision with root package name */
    public a1 f840g;

    /* renamed from: h  reason: collision with root package name */
    public a1 f841h;

    /* renamed from: i  reason: collision with root package name */
    public final e0 f842i;

    /* renamed from: j  reason: collision with root package name */
    public int f843j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f844k = -1;

    /* renamed from: l  reason: collision with root package name */
    public Typeface f845l;
    public boolean m;

    public class a extends h.c {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ WeakReference c;

        public a(int i2, int i3, WeakReference weakReference) {
            this.a = i2;
            this.b = i3;
            this.c = weakReference;
        }

        @Override // e.i.b.b.h.c
        public void d(int i2) {
        }

        @Override // e.i.b.b.h.c
        public void e(Typeface typeface) {
            int i2;
            if (Build.VERSION.SDK_INT >= 28 && (i2 = this.a) != -1) {
                typeface = Typeface.create(typeface, i2, (this.b & 2) != 0);
            }
            b0 b0Var = b0.this;
            WeakReference weakReference = this.c;
            if (b0Var.m) {
                b0Var.f845l = typeface;
                TextView textView = (TextView) weakReference.get();
                if (textView != null) {
                    AtomicInteger atomicInteger = v.a;
                    if (v.g.b(textView)) {
                        textView.post(new c0(b0Var, textView, typeface, b0Var.f843j));
                    } else {
                        textView.setTypeface(typeface, b0Var.f843j);
                    }
                }
            }
        }
    }

    public b0(TextView textView) {
        this.a = textView;
        this.f842i = new e0(textView);
    }

    public static a1 c(Context context, k kVar, int i2) {
        ColorStateList d2 = kVar.d(context, i2);
        if (d2 == null) {
            return null;
        }
        a1 a1Var = new a1();
        a1Var.f836d = true;
        a1Var.a = d2;
        return a1Var;
    }

    public final void a(Drawable drawable, a1 a1Var) {
        if (drawable != null && a1Var != null) {
            k.f(drawable, a1Var, this.a.getDrawableState());
        }
    }

    public void b() {
        if (!(this.b == null && this.c == null && this.f837d == null && this.f838e == null)) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.f837d);
            a(compoundDrawables[3], this.f838e);
        }
        if (this.f839f != null || this.f840g != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f839f);
            a(compoundDrawablesRelative[2], this.f840g);
        }
    }

    public boolean d() {
        e0 e0Var = this.f842i;
        return e0Var.i() && e0Var.a != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02e5  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x033d  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0348  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0356  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0364  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0369  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0372  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0377  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0380  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0385  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0389 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x03e6  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x03ed  */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x03f3  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x03f8  */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0405  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x043b  */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0473  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x047a  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0481  */
    /* JADX WARNING: Removed duplicated region for block: B:257:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01d7  */
    public void e(AttributeSet attributeSet, int i2) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        boolean z;
        String str;
        String str2;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        k kVar;
        Typeface typeface;
        int i4;
        e0 e0Var;
        TypedArray obtainStyledAttributes;
        int i5;
        TypedArray obtainStyledAttributes2;
        int resourceId;
        k kVar2;
        Drawable drawable;
        Drawable b2;
        Drawable b3;
        Drawable b4;
        Drawable b5;
        int i6;
        int i7;
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int dimensionPixelSize3;
        ColorStateList colorStateList4;
        int resourceId2;
        int resourceId3;
        int length;
        Context context = this.a.getContext();
        k a2 = k.a();
        int[] iArr = R$styleable.AppCompatTextHelper;
        c1 q = c1.q(context, attributeSet, iArr, i2, 0);
        TextView textView = this.a;
        v.t(textView, textView.getContext(), iArr, attributeSet, q.b, i2, 0);
        int l2 = q.l(R$styleable.AppCompatTextHelper_android_textAppearance, -1);
        int i8 = R$styleable.AppCompatTextHelper_android_drawableLeft;
        if (q.o(i8)) {
            this.b = c(context, a2, q.l(i8, 0));
        }
        int i9 = R$styleable.AppCompatTextHelper_android_drawableTop;
        if (q.o(i9)) {
            this.c = c(context, a2, q.l(i9, 0));
        }
        int i10 = R$styleable.AppCompatTextHelper_android_drawableRight;
        if (q.o(i10)) {
            this.f837d = c(context, a2, q.l(i10, 0));
        }
        int i11 = R$styleable.AppCompatTextHelper_android_drawableBottom;
        if (q.o(i11)) {
            this.f838e = c(context, a2, q.l(i11, 0));
        }
        int i12 = Build.VERSION.SDK_INT;
        int i13 = R$styleable.AppCompatTextHelper_android_drawableStart;
        if (q.o(i13)) {
            this.f839f = c(context, a2, q.l(i13, 0));
        }
        int i14 = R$styleable.AppCompatTextHelper_android_drawableEnd;
        if (q.o(i14)) {
            this.f840g = c(context, a2, q.l(i14, 0));
        }
        q.b.recycle();
        boolean z5 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (l2 != -1) {
            c1 c1Var = new c1(context, context.obtainStyledAttributes(l2, R$styleable.TextAppearance));
            if (!z5) {
                int i15 = R$styleable.TextAppearance_textAllCaps;
                if (c1Var.o(i15)) {
                    z2 = c1Var.a(i15, false);
                    z = true;
                    m(context, c1Var);
                    if (i12 >= 23) {
                        int i16 = R$styleable.TextAppearance_android_textColor;
                        colorStateList = c1Var.o(i16) ? c1Var.c(i16) : null;
                        int i17 = R$styleable.TextAppearance_android_textColorHint;
                        colorStateList3 = c1Var.o(i17) ? c1Var.c(i17) : null;
                        int i18 = R$styleable.TextAppearance_android_textColorLink;
                        colorStateList2 = c1Var.o(i18) ? c1Var.c(i18) : null;
                    } else {
                        colorStateList3 = null;
                        colorStateList2 = null;
                        colorStateList = null;
                    }
                    int i19 = R$styleable.TextAppearance_textLocale;
                    str2 = !c1Var.o(i19) ? c1Var.m(i19) : null;
                    if (i12 >= 26) {
                        int i20 = R$styleable.TextAppearance_fontVariationSettings;
                        if (c1Var.o(i20)) {
                            str = c1Var.m(i20);
                            c1Var.b.recycle();
                        }
                    }
                    str = null;
                    c1Var.b.recycle();
                }
            }
            z2 = false;
            z = false;
            m(context, c1Var);
            if (i12 >= 23) {
            }
            int i192 = R$styleable.TextAppearance_textLocale;
            if (!c1Var.o(i192)) {
            }
            if (i12 >= 26) {
            }
            str = null;
            c1Var.b.recycle();
        } else {
            z2 = false;
            str2 = null;
            str = null;
            z = false;
            colorStateList3 = null;
            colorStateList2 = null;
            colorStateList = null;
        }
        c1 c1Var2 = new c1(context, context.obtainStyledAttributes(attributeSet, R$styleable.TextAppearance, i2, 0));
        if (!z5) {
            int i21 = R$styleable.TextAppearance_textAllCaps;
            if (c1Var2.o(i21)) {
                z4 = c1Var2.a(i21, false);
                z3 = true;
                if (i12 < 23) {
                    int i22 = R$styleable.TextAppearance_android_textColor;
                    if (c1Var2.o(i22)) {
                        colorStateList = c1Var2.c(i22);
                    }
                    int i23 = R$styleable.TextAppearance_android_textColorHint;
                    if (c1Var2.o(i23)) {
                        colorStateList3 = c1Var2.c(i23);
                    }
                    int i24 = R$styleable.TextAppearance_android_textColorLink;
                    if (c1Var2.o(i24)) {
                        colorStateList2 = c1Var2.c(i24);
                    }
                }
                i3 = R$styleable.TextAppearance_textLocale;
                if (c1Var2.o(i3)) {
                    str2 = c1Var2.m(i3);
                }
                if (i12 >= 26) {
                    int i25 = R$styleable.TextAppearance_fontVariationSettings;
                    if (c1Var2.o(i25)) {
                        str = c1Var2.m(i25);
                    }
                }
                if (i12 >= 28) {
                    int i26 = R$styleable.TextAppearance_android_textSize;
                    if (c1Var2.o(i26)) {
                        kVar = a2;
                        if (c1Var2.f(i26, -1) == 0) {
                            this.a.setTextSize(0, 0.0f);
                        }
                        m(context, c1Var2);
                        c1Var2.b.recycle();
                        if (colorStateList != null) {
                            this.a.setTextColor(colorStateList);
                        }
                        if (colorStateList3 != null) {
                            this.a.setHintTextColor(colorStateList3);
                        }
                        if (colorStateList2 != null) {
                            this.a.setLinkTextColor(colorStateList2);
                        }
                        if (!z5 && z3) {
                            this.a.setAllCaps(z4);
                        }
                        typeface = this.f845l;
                        if (typeface != null) {
                            if (this.f844k == -1) {
                                this.a.setTypeface(typeface, this.f843j);
                            } else {
                                this.a.setTypeface(typeface);
                            }
                        }
                        if (str != null) {
                            this.a.setFontVariationSettings(str);
                        }
                        if (str2 != null) {
                            if (i12 >= 24) {
                                this.a.setTextLocales(LocaleList.forLanguageTags(str2));
                            } else {
                                i4 = 0;
                                this.a.setTextLocale(Locale.forLanguageTag(str2.substring(0, str2.indexOf(44))));
                                e0Var = this.f842i;
                                Context context2 = e0Var.f869j;
                                int[] iArr2 = R$styleable.AppCompatTextView;
                                obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr2, i2, i4);
                                TextView textView2 = e0Var.f868i;
                                v.t(textView2, textView2.getContext(), iArr2, attributeSet, obtainStyledAttributes, i2, 0);
                                i5 = R$styleable.AppCompatTextView_autoSizeTextType;
                                if (obtainStyledAttributes.hasValue(i5)) {
                                    e0Var.a = obtainStyledAttributes.getInt(i5, 0);
                                }
                                int i27 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
                                float dimension = !obtainStyledAttributes.hasValue(i27) ? obtainStyledAttributes.getDimension(i27, -1.0f) : -1.0f;
                                int i28 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
                                float dimension2 = !obtainStyledAttributes.hasValue(i28) ? obtainStyledAttributes.getDimension(i28, -1.0f) : -1.0f;
                                int i29 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
                                float dimension3 = !obtainStyledAttributes.hasValue(i29) ? obtainStyledAttributes.getDimension(i29, -1.0f) : -1.0f;
                                int i30 = R$styleable.AppCompatTextView_autoSizePresetSizes;
                                if (obtainStyledAttributes.hasValue(i30) && (resourceId3 = obtainStyledAttributes.getResourceId(i30, 0)) > 0) {
                                    TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId3);
                                    length = obtainTypedArray.length();
                                    int[] iArr3 = new int[length];
                                    if (length > 0) {
                                        for (int i31 = 0; i31 < length; i31++) {
                                            iArr3[i31] = obtainTypedArray.getDimensionPixelSize(i31, -1);
                                        }
                                        e0Var.f865f = e0Var.b(iArr3);
                                        e0Var.h();
                                    }
                                    obtainTypedArray.recycle();
                                }
                                obtainStyledAttributes.recycle();
                                if (e0Var.i()) {
                                    e0Var.a = 0;
                                } else if (e0Var.a == 1) {
                                    if (!e0Var.f866g) {
                                        DisplayMetrics displayMetrics = e0Var.f869j.getResources().getDisplayMetrics();
                                        if (dimension2 == -1.0f) {
                                            dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                                        }
                                        if (dimension3 == -1.0f) {
                                            dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                                        }
                                        if (dimension == -1.0f) {
                                            dimension = 1.0f;
                                        }
                                        e0Var.j(dimension2, dimension3, dimension);
                                    }
                                    e0Var.g();
                                }
                                if (b.a) {
                                    e0 e0Var2 = this.f842i;
                                    if (e0Var2.a != 0) {
                                        int[] iArr4 = e0Var2.f865f;
                                        if (iArr4.length > 0) {
                                            if (((float) this.a.getAutoSizeStepGranularity()) != -1.0f) {
                                                this.a.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.f842i.f863d), Math.round(this.f842i.f864e), Math.round(this.f842i.c), 0);
                                            } else {
                                                this.a.setAutoSizeTextTypeUniformWithPresetSizes(iArr4, 0);
                                            }
                                        }
                                    }
                                }
                                obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView);
                                resourceId = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
                                if (resourceId == -1) {
                                    kVar2 = kVar;
                                    drawable = kVar2.b(context, resourceId);
                                } else {
                                    kVar2 = kVar;
                                    drawable = null;
                                }
                                int resourceId4 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableTopCompat, -1);
                                b2 = resourceId4 == -1 ? kVar2.b(context, resourceId4) : null;
                                int resourceId5 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableRightCompat, -1);
                                Drawable b6 = resourceId5 == -1 ? kVar2.b(context, resourceId5) : null;
                                int resourceId6 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
                                b3 = resourceId6 == -1 ? kVar2.b(context, resourceId6) : null;
                                int resourceId7 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableStartCompat, -1);
                                b4 = resourceId7 == -1 ? kVar2.b(context, resourceId7) : null;
                                int resourceId8 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableEndCompat, -1);
                                b5 = resourceId8 == -1 ? kVar2.b(context, resourceId8) : null;
                                if (b4 == null || b5 != null) {
                                    Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
                                    TextView textView3 = this.a;
                                    if (b4 == null) {
                                        b4 = compoundDrawablesRelative[0];
                                    }
                                    if (b2 == null) {
                                        b2 = compoundDrawablesRelative[1];
                                    }
                                    if (b5 == null) {
                                        b5 = compoundDrawablesRelative[2];
                                    }
                                    if (b3 == null) {
                                        b3 = compoundDrawablesRelative[3];
                                    }
                                    textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(b4, b2, b5, b3);
                                } else if (!(drawable == null && b2 == null && b6 == null && b3 == null)) {
                                    Drawable[] compoundDrawablesRelative2 = this.a.getCompoundDrawablesRelative();
                                    if (compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null) {
                                        Drawable[] compoundDrawables = this.a.getCompoundDrawables();
                                        TextView textView4 = this.a;
                                        if (drawable == null) {
                                            drawable = compoundDrawables[0];
                                        }
                                        if (b2 == null) {
                                            b2 = compoundDrawables[1];
                                        }
                                        if (b6 == null) {
                                            b6 = compoundDrawables[2];
                                        }
                                        if (b3 == null) {
                                            b3 = compoundDrawables[3];
                                        }
                                        textView4.setCompoundDrawablesWithIntrinsicBounds(drawable, b2, b6, b3);
                                    } else {
                                        TextView textView5 = this.a;
                                        Drawable drawable2 = compoundDrawablesRelative2[0];
                                        if (b2 == null) {
                                            b2 = compoundDrawablesRelative2[1];
                                        }
                                        Drawable drawable3 = compoundDrawablesRelative2[2];
                                        if (b3 == null) {
                                            b3 = compoundDrawablesRelative2[3];
                                        }
                                        textView5.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, b2, drawable3, b3);
                                    }
                                }
                                i6 = R$styleable.AppCompatTextView_drawableTint;
                                if (obtainStyledAttributes2.hasValue(i6)) {
                                    if (!obtainStyledAttributes2.hasValue(i6) || (resourceId2 = obtainStyledAttributes2.getResourceId(i6, 0)) == 0 || (colorStateList4 = m.e.f0(context, resourceId2)) == null) {
                                        colorStateList4 = obtainStyledAttributes2.getColorStateList(i6);
                                    }
                                    TextView textView6 = this.a;
                                    Objects.requireNonNull(textView6);
                                    if (Build.VERSION.SDK_INT >= 24) {
                                        textView6.setCompoundDrawableTintList(colorStateList4);
                                    } else if (textView6 instanceof e.i.j.h) {
                                        ((e.i.j.h) textView6).setSupportCompoundDrawablesTintList(colorStateList4);
                                    }
                                }
                                i7 = R$styleable.AppCompatTextView_drawableTintMode;
                                if (obtainStyledAttributes2.hasValue(i7)) {
                                    PorterDuff.Mode e2 = i0.e(obtainStyledAttributes2.getInt(i7, -1), null);
                                    TextView textView7 = this.a;
                                    Objects.requireNonNull(textView7);
                                    if (Build.VERSION.SDK_INT >= 24) {
                                        textView7.setCompoundDrawableTintMode(e2);
                                    } else if (textView7 instanceof e.i.j.h) {
                                        ((e.i.j.h) textView7).setSupportCompoundDrawablesTintMode(e2);
                                    }
                                }
                                dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
                                dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
                                dimensionPixelSize3 = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.AppCompatTextView_lineHeight, -1);
                                obtainStyledAttributes2.recycle();
                                if (dimensionPixelSize != -1) {
                                    m.e.p1(this.a, dimensionPixelSize);
                                }
                                if (dimensionPixelSize2 != -1) {
                                    m.e.q1(this.a, dimensionPixelSize2);
                                }
                                if (dimensionPixelSize3 == -1) {
                                    m.e.s1(this.a, dimensionPixelSize3);
                                    return;
                                }
                                return;
                            }
                        }
                        i4 = 0;
                        e0Var = this.f842i;
                        Context context22 = e0Var.f869j;
                        int[] iArr22 = R$styleable.AppCompatTextView;
                        obtainStyledAttributes = context22.obtainStyledAttributes(attributeSet, iArr22, i2, i4);
                        TextView textView22 = e0Var.f868i;
                        v.t(textView22, textView22.getContext(), iArr22, attributeSet, obtainStyledAttributes, i2, 0);
                        i5 = R$styleable.AppCompatTextView_autoSizeTextType;
                        if (obtainStyledAttributes.hasValue(i5)) {
                        }
                        int i272 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
                        if (!obtainStyledAttributes.hasValue(i272)) {
                        }
                        int i282 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
                        if (!obtainStyledAttributes.hasValue(i282)) {
                        }
                        int i292 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
                        if (!obtainStyledAttributes.hasValue(i292)) {
                        }
                        int i302 = R$styleable.AppCompatTextView_autoSizePresetSizes;
                        TypedArray obtainTypedArray2 = obtainStyledAttributes.getResources().obtainTypedArray(resourceId3);
                        length = obtainTypedArray2.length();
                        int[] iArr32 = new int[length];
                        if (length > 0) {
                        }
                        obtainTypedArray2.recycle();
                        obtainStyledAttributes.recycle();
                        if (e0Var.i()) {
                        }
                        if (b.a) {
                        }
                        obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView);
                        resourceId = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
                        if (resourceId == -1) {
                        }
                        int resourceId42 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableTopCompat, -1);
                        if (resourceId42 == -1) {
                        }
                        int resourceId52 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableRightCompat, -1);
                        if (resourceId52 == -1) {
                        }
                        int resourceId62 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
                        if (resourceId62 == -1) {
                        }
                        int resourceId72 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableStartCompat, -1);
                        if (resourceId72 == -1) {
                        }
                        int resourceId82 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableEndCompat, -1);
                        if (resourceId82 == -1) {
                        }
                        if (b4 == null) {
                        }
                        Drawable[] compoundDrawablesRelative3 = this.a.getCompoundDrawablesRelative();
                        TextView textView32 = this.a;
                        if (b4 == null) {
                        }
                        if (b2 == null) {
                        }
                        if (b5 == null) {
                        }
                        if (b3 == null) {
                        }
                        textView32.setCompoundDrawablesRelativeWithIntrinsicBounds(b4, b2, b5, b3);
                        i6 = R$styleable.AppCompatTextView_drawableTint;
                        if (obtainStyledAttributes2.hasValue(i6)) {
                        }
                        i7 = R$styleable.AppCompatTextView_drawableTintMode;
                        if (obtainStyledAttributes2.hasValue(i7)) {
                        }
                        dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
                        dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
                        dimensionPixelSize3 = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.AppCompatTextView_lineHeight, -1);
                        obtainStyledAttributes2.recycle();
                        if (dimensionPixelSize != -1) {
                        }
                        if (dimensionPixelSize2 != -1) {
                        }
                        if (dimensionPixelSize3 == -1) {
                        }
                    }
                }
                kVar = a2;
                m(context, c1Var2);
                c1Var2.b.recycle();
                if (colorStateList != null) {
                }
                if (colorStateList3 != null) {
                }
                if (colorStateList2 != null) {
                }
                this.a.setAllCaps(z4);
                typeface = this.f845l;
                if (typeface != null) {
                }
                if (str != null) {
                }
                if (str2 != null) {
                }
                i4 = 0;
                e0Var = this.f842i;
                Context context222 = e0Var.f869j;
                int[] iArr222 = R$styleable.AppCompatTextView;
                obtainStyledAttributes = context222.obtainStyledAttributes(attributeSet, iArr222, i2, i4);
                TextView textView222 = e0Var.f868i;
                v.t(textView222, textView222.getContext(), iArr222, attributeSet, obtainStyledAttributes, i2, 0);
                i5 = R$styleable.AppCompatTextView_autoSizeTextType;
                if (obtainStyledAttributes.hasValue(i5)) {
                }
                int i2722 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
                if (!obtainStyledAttributes.hasValue(i2722)) {
                }
                int i2822 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
                if (!obtainStyledAttributes.hasValue(i2822)) {
                }
                int i2922 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
                if (!obtainStyledAttributes.hasValue(i2922)) {
                }
                int i3022 = R$styleable.AppCompatTextView_autoSizePresetSizes;
                TypedArray obtainTypedArray22 = obtainStyledAttributes.getResources().obtainTypedArray(resourceId3);
                length = obtainTypedArray22.length();
                int[] iArr322 = new int[length];
                if (length > 0) {
                }
                obtainTypedArray22.recycle();
                obtainStyledAttributes.recycle();
                if (e0Var.i()) {
                }
                if (b.a) {
                }
                obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView);
                resourceId = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
                if (resourceId == -1) {
                }
                int resourceId422 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableTopCompat, -1);
                if (resourceId422 == -1) {
                }
                int resourceId522 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableRightCompat, -1);
                if (resourceId522 == -1) {
                }
                int resourceId622 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
                if (resourceId622 == -1) {
                }
                int resourceId722 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableStartCompat, -1);
                if (resourceId722 == -1) {
                }
                int resourceId822 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableEndCompat, -1);
                if (resourceId822 == -1) {
                }
                if (b4 == null) {
                }
                Drawable[] compoundDrawablesRelative32 = this.a.getCompoundDrawablesRelative();
                TextView textView322 = this.a;
                if (b4 == null) {
                }
                if (b2 == null) {
                }
                if (b5 == null) {
                }
                if (b3 == null) {
                }
                textView322.setCompoundDrawablesRelativeWithIntrinsicBounds(b4, b2, b5, b3);
                i6 = R$styleable.AppCompatTextView_drawableTint;
                if (obtainStyledAttributes2.hasValue(i6)) {
                }
                i7 = R$styleable.AppCompatTextView_drawableTintMode;
                if (obtainStyledAttributes2.hasValue(i7)) {
                }
                dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
                dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
                dimensionPixelSize3 = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.AppCompatTextView_lineHeight, -1);
                obtainStyledAttributes2.recycle();
                if (dimensionPixelSize != -1) {
                }
                if (dimensionPixelSize2 != -1) {
                }
                if (dimensionPixelSize3 == -1) {
                }
            }
        }
        z3 = z;
        z4 = z2;
        if (i12 < 23) {
        }
        i3 = R$styleable.TextAppearance_textLocale;
        if (c1Var2.o(i3)) {
        }
        if (i12 >= 26) {
        }
        if (i12 >= 28) {
        }
        kVar = a2;
        m(context, c1Var2);
        c1Var2.b.recycle();
        if (colorStateList != null) {
        }
        if (colorStateList3 != null) {
        }
        if (colorStateList2 != null) {
        }
        this.a.setAllCaps(z4);
        typeface = this.f845l;
        if (typeface != null) {
        }
        if (str != null) {
        }
        if (str2 != null) {
        }
        i4 = 0;
        e0Var = this.f842i;
        Context context2222 = e0Var.f869j;
        int[] iArr2222 = R$styleable.AppCompatTextView;
        obtainStyledAttributes = context2222.obtainStyledAttributes(attributeSet, iArr2222, i2, i4);
        TextView textView2222 = e0Var.f868i;
        v.t(textView2222, textView2222.getContext(), iArr2222, attributeSet, obtainStyledAttributes, i2, 0);
        i5 = R$styleable.AppCompatTextView_autoSizeTextType;
        if (obtainStyledAttributes.hasValue(i5)) {
        }
        int i27222 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
        if (!obtainStyledAttributes.hasValue(i27222)) {
        }
        int i28222 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
        if (!obtainStyledAttributes.hasValue(i28222)) {
        }
        int i29222 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
        if (!obtainStyledAttributes.hasValue(i29222)) {
        }
        int i30222 = R$styleable.AppCompatTextView_autoSizePresetSizes;
        TypedArray obtainTypedArray222 = obtainStyledAttributes.getResources().obtainTypedArray(resourceId3);
        length = obtainTypedArray222.length();
        int[] iArr3222 = new int[length];
        if (length > 0) {
        }
        obtainTypedArray222.recycle();
        obtainStyledAttributes.recycle();
        if (e0Var.i()) {
        }
        if (b.a) {
        }
        obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView);
        resourceId = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableLeftCompat, -1);
        if (resourceId == -1) {
        }
        int resourceId4222 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableTopCompat, -1);
        if (resourceId4222 == -1) {
        }
        int resourceId5222 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableRightCompat, -1);
        if (resourceId5222 == -1) {
        }
        int resourceId6222 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
        if (resourceId6222 == -1) {
        }
        int resourceId7222 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableStartCompat, -1);
        if (resourceId7222 == -1) {
        }
        int resourceId8222 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableEndCompat, -1);
        if (resourceId8222 == -1) {
        }
        if (b4 == null) {
        }
        Drawable[] compoundDrawablesRelative322 = this.a.getCompoundDrawablesRelative();
        TextView textView3222 = this.a;
        if (b4 == null) {
        }
        if (b2 == null) {
        }
        if (b5 == null) {
        }
        if (b3 == null) {
        }
        textView3222.setCompoundDrawablesRelativeWithIntrinsicBounds(b4, b2, b5, b3);
        i6 = R$styleable.AppCompatTextView_drawableTint;
        if (obtainStyledAttributes2.hasValue(i6)) {
        }
        i7 = R$styleable.AppCompatTextView_drawableTintMode;
        if (obtainStyledAttributes2.hasValue(i7)) {
        }
        dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        dimensionPixelSize3 = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.AppCompatTextView_lineHeight, -1);
        obtainStyledAttributes2.recycle();
        if (dimensionPixelSize != -1) {
        }
        if (dimensionPixelSize2 != -1) {
        }
        if (dimensionPixelSize3 == -1) {
        }
    }

    public void f(Context context, int i2) {
        String m2;
        ColorStateList c2;
        ColorStateList c3;
        ColorStateList c4;
        c1 c1Var = new c1(context, context.obtainStyledAttributes(i2, R$styleable.TextAppearance));
        int i3 = R$styleable.TextAppearance_textAllCaps;
        if (c1Var.o(i3)) {
            this.a.setAllCaps(c1Var.a(i3, false));
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 23) {
            int i5 = R$styleable.TextAppearance_android_textColor;
            if (c1Var.o(i5) && (c4 = c1Var.c(i5)) != null) {
                this.a.setTextColor(c4);
            }
            int i6 = R$styleable.TextAppearance_android_textColorLink;
            if (c1Var.o(i6) && (c3 = c1Var.c(i6)) != null) {
                this.a.setLinkTextColor(c3);
            }
            int i7 = R$styleable.TextAppearance_android_textColorHint;
            if (c1Var.o(i7) && (c2 = c1Var.c(i7)) != null) {
                this.a.setHintTextColor(c2);
            }
        }
        int i8 = R$styleable.TextAppearance_android_textSize;
        if (c1Var.o(i8) && c1Var.f(i8, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        m(context, c1Var);
        if (i4 >= 26) {
            int i9 = R$styleable.TextAppearance_fontVariationSettings;
            if (c1Var.o(i9) && (m2 = c1Var.m(i9)) != null) {
                this.a.setFontVariationSettings(m2);
            }
        }
        c1Var.b.recycle();
        Typeface typeface = this.f845l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.f843j);
        }
    }

    public void g(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 30 && inputConnection != null) {
            CharSequence text = textView.getText();
            if (i2 >= 30) {
                editorInfo.setInitialSurroundingSubText(text, 0);
                return;
            }
            Objects.requireNonNull(text);
            if (i2 >= 30) {
                editorInfo.setInitialSurroundingSubText(text, 0);
                return;
            }
            int i3 = editorInfo.initialSelStart;
            int i4 = editorInfo.initialSelEnd;
            int i5 = i3 > i4 ? i4 + 0 : i3 + 0;
            int i6 = i3 > i4 ? i3 - 0 : i4 + 0;
            int length = text.length();
            if (i5 >= 0 && i6 <= length) {
                int i7 = editorInfo.inputType & 4095;
                if (!(i7 == 129 || i7 == 225 || i7 == 18)) {
                    if (length <= 2048) {
                        e.i.i.d0.a.b(editorInfo, text, i5, i6);
                        return;
                    }
                    int i8 = i6 - i5;
                    int i9 = i8 > 1024 ? 0 : i8;
                    int i10 = 2048 - i9;
                    int min = Math.min(text.length() - i6, i10 - Math.min(i5, (int) (((double) i10) * 0.8d)));
                    int min2 = Math.min(i5, i10 - min);
                    int i11 = i5 - min2;
                    if (e.i.i.d0.a.a(text, i11, 0)) {
                        i11++;
                        min2--;
                    }
                    if (e.i.i.d0.a.a(text, (i6 + min) - 1, 1)) {
                        min--;
                    }
                    CharSequence concat = i9 != i8 ? TextUtils.concat(text.subSequence(i11, i11 + min2), text.subSequence(i6, min + i6)) : text.subSequence(i11, min2 + i9 + min + i11);
                    int i12 = min2 + 0;
                    e.i.i.d0.a.b(editorInfo, concat, i12, i9 + i12);
                    return;
                }
            }
            e.i.i.d0.a.b(editorInfo, null, 0, 0);
        }
    }

    public void h(int i2, int i3, int i4, int i5) {
        e0 e0Var = this.f842i;
        if (e0Var.i()) {
            DisplayMetrics displayMetrics = e0Var.f869j.getResources().getDisplayMetrics();
            e0Var.j(TypedValue.applyDimension(i5, (float) i2, displayMetrics), TypedValue.applyDimension(i5, (float) i3, displayMetrics), TypedValue.applyDimension(i5, (float) i4, displayMetrics));
            if (e0Var.g()) {
                e0Var.a();
            }
        }
    }

    public void i(int[] iArr, int i2) {
        e0 e0Var = this.f842i;
        if (e0Var.i()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = e0Var.f869j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, (float) iArr[i3], displayMetrics));
                    }
                }
                e0Var.f865f = e0Var.b(iArr2);
                if (!e0Var.h()) {
                    StringBuilder h2 = f.a.a.a.a.h("None of the preset sizes is valid: ");
                    h2.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(h2.toString());
                }
            } else {
                e0Var.f866g = false;
            }
            if (e0Var.g()) {
                e0Var.a();
            }
        }
    }

    public void j(int i2) {
        e0 e0Var = this.f842i;
        if (!e0Var.i()) {
            return;
        }
        if (i2 == 0) {
            e0Var.a = 0;
            e0Var.f863d = -1.0f;
            e0Var.f864e = -1.0f;
            e0Var.c = -1.0f;
            e0Var.f865f = new int[0];
            e0Var.b = false;
        } else if (i2 == 1) {
            DisplayMetrics displayMetrics = e0Var.f869j.getResources().getDisplayMetrics();
            e0Var.j(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (e0Var.g()) {
                e0Var.a();
            }
        } else {
            throw new IllegalArgumentException(f.a.a.a.a.t("Unknown auto-size text type: ", i2));
        }
    }

    public void k(ColorStateList colorStateList) {
        if (this.f841h == null) {
            this.f841h = new a1();
        }
        a1 a1Var = this.f841h;
        a1Var.a = colorStateList;
        a1Var.f836d = colorStateList != null;
        this.b = a1Var;
        this.c = a1Var;
        this.f837d = a1Var;
        this.f838e = a1Var;
        this.f839f = a1Var;
        this.f840g = a1Var;
    }

    public void l(PorterDuff.Mode mode) {
        if (this.f841h == null) {
            this.f841h = new a1();
        }
        a1 a1Var = this.f841h;
        a1Var.b = mode;
        a1Var.c = mode != null;
        this.b = a1Var;
        this.c = a1Var;
        this.f837d = a1Var;
        this.f838e = a1Var;
        this.f839f = a1Var;
        this.f840g = a1Var;
    }

    public final void m(Context context, c1 c1Var) {
        String m2;
        Typeface typeface;
        Typeface typeface2;
        this.f843j = c1Var.j(R$styleable.TextAppearance_android_textStyle, this.f843j);
        int i2 = Build.VERSION.SDK_INT;
        boolean z = false;
        if (i2 >= 28) {
            int j2 = c1Var.j(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.f844k = j2;
            if (j2 != -1) {
                this.f843j = (this.f843j & 2) | 0;
            }
        }
        int i3 = R$styleable.TextAppearance_android_fontFamily;
        if (c1Var.o(i3) || c1Var.o(R$styleable.TextAppearance_fontFamily)) {
            this.f845l = null;
            int i4 = R$styleable.TextAppearance_fontFamily;
            if (c1Var.o(i4)) {
                i3 = i4;
            }
            int i5 = this.f844k;
            int i6 = this.f843j;
            if (!context.isRestricted()) {
                try {
                    Typeface i7 = c1Var.i(i3, this.f843j, new a(i5, i6, new WeakReference(this.a)));
                    if (i7 != null) {
                        if (i2 >= 28 && this.f844k != -1) {
                            i7 = Typeface.create(Typeface.create(i7, 0), this.f844k, (this.f843j & 2) != 0);
                        }
                        this.f845l = i7;
                    }
                    this.m = this.f845l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f845l == null && (m2 = c1Var.m(i3)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.f844k == -1) {
                    typeface = Typeface.create(m2, this.f843j);
                } else {
                    Typeface create = Typeface.create(m2, 0);
                    int i8 = this.f844k;
                    if ((this.f843j & 2) != 0) {
                        z = true;
                    }
                    typeface = Typeface.create(create, i8, z);
                }
                this.f845l = typeface;
                return;
            }
            return;
        }
        int i9 = R$styleable.TextAppearance_android_typeface;
        if (c1Var.o(i9)) {
            this.m = false;
            int j3 = c1Var.j(i9, 1);
            if (j3 == 1) {
                typeface2 = Typeface.SANS_SERIF;
            } else if (j3 == 2) {
                typeface2 = Typeface.SERIF;
            } else if (j3 == 3) {
                typeface2 = Typeface.MONOSPACE;
            } else {
                return;
            }
            this.f845l = typeface2;
        }
    }
}
