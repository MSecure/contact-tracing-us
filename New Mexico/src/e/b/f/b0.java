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
import e.j.b.b.h;
import e.j.j.v;
import e.j.k.b;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class b0 {
    public final TextView a;
    public a1 b;
    public a1 c;

    /* renamed from: d */
    public a1 f901d;

    /* renamed from: e */
    public a1 f902e;

    /* renamed from: f */
    public a1 f903f;

    /* renamed from: g */
    public a1 f904g;

    /* renamed from: h */
    public a1 f905h;

    /* renamed from: i */
    public final e0 f906i;

    /* renamed from: j */
    public int f907j = 0;

    /* renamed from: k */
    public int f908k = -1;

    /* renamed from: l */
    public Typeface f909l;
    public boolean m;

    /* loaded from: classes.dex */
    public class a extends h.c {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ WeakReference c;

        public a(int i2, int i3, WeakReference weakReference) {
            b0.this = r1;
            this.a = i2;
            this.b = i3;
            this.c = weakReference;
        }

        @Override // e.j.b.b.h.c
        public void d(int i2) {
        }

        @Override // e.j.b.b.h.c
        public void e(Typeface typeface) {
            int i2;
            if (Build.VERSION.SDK_INT >= 28 && (i2 = this.a) != -1) {
                typeface = Typeface.create(typeface, i2, (this.b & 2) != 0);
            }
            b0 b0Var = b0.this;
            WeakReference weakReference = this.c;
            if (b0Var.m) {
                b0Var.f909l = typeface;
                TextView textView = (TextView) weakReference.get();
                if (textView != null) {
                    AtomicInteger atomicInteger = v.a;
                    if (v.g.b(textView)) {
                        textView.post(new c0(b0Var, textView, typeface, b0Var.f907j));
                    } else {
                        textView.setTypeface(typeface, b0Var.f907j);
                    }
                }
            }
        }
    }

    public b0(TextView textView) {
        this.a = textView;
        this.f906i = new e0(textView);
    }

    public static a1 c(Context context, k kVar, int i2) {
        ColorStateList d2 = kVar.d(context, i2);
        if (d2 == null) {
            return null;
        }
        a1 a1Var = new a1();
        a1Var.f900d = true;
        a1Var.a = d2;
        return a1Var;
    }

    public final void a(Drawable drawable, a1 a1Var) {
        if (drawable != null && a1Var != null) {
            k.f(drawable, a1Var, this.a.getDrawableState());
        }
    }

    public void b() {
        if (!(this.b == null && this.c == null && this.f901d == null && this.f902e == null)) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.f901d);
            a(compoundDrawables[3], this.f902e);
        }
        if (this.f903f != null || this.f904g != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f903f);
            a(compoundDrawablesRelative[2], this.f904g);
        }
    }

    public boolean d() {
        e0 e0Var = this.f906i;
        return e0Var.i() && e0Var.a != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0389 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:259:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d7  */
    /* Code decompiled incorrectly, please refer to instructions dump */
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
        int i6;
        TypedArray obtainStyledAttributes2;
        int resourceId;
        k kVar2;
        Drawable drawable;
        Drawable b;
        Drawable b2;
        Drawable b3;
        Drawable b4;
        int i7;
        int i8;
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
        int i9 = R$styleable.AppCompatTextHelper_android_drawableLeft;
        if (q.o(i9)) {
            this.b = c(context, a2, q.l(i9, 0));
        }
        int i10 = R$styleable.AppCompatTextHelper_android_drawableTop;
        if (q.o(i10)) {
            this.c = c(context, a2, q.l(i10, 0));
        }
        int i11 = R$styleable.AppCompatTextHelper_android_drawableRight;
        if (q.o(i11)) {
            this.f901d = c(context, a2, q.l(i11, 0));
        }
        int i12 = R$styleable.AppCompatTextHelper_android_drawableBottom;
        if (q.o(i12)) {
            this.f902e = c(context, a2, q.l(i12, 0));
        }
        int i13 = Build.VERSION.SDK_INT;
        int i14 = R$styleable.AppCompatTextHelper_android_drawableStart;
        if (q.o(i14)) {
            this.f903f = c(context, a2, q.l(i14, 0));
        }
        int i15 = R$styleable.AppCompatTextHelper_android_drawableEnd;
        if (q.o(i15)) {
            this.f904g = c(context, a2, q.l(i15, 0));
        }
        q.b.recycle();
        boolean z5 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (l2 != -1) {
            c1 c1Var = new c1(context, context.obtainStyledAttributes(l2, R$styleable.TextAppearance));
            if (!z5) {
                int i16 = R$styleable.TextAppearance_textAllCaps;
                if (c1Var.o(i16)) {
                    z2 = c1Var.a(i16, false);
                    z = true;
                    m(context, c1Var);
                    if (i13 >= 23) {
                        int i17 = R$styleable.TextAppearance_android_textColor;
                        colorStateList = c1Var.o(i17) ? c1Var.c(i17) : null;
                        int i18 = R$styleable.TextAppearance_android_textColorHint;
                        colorStateList3 = c1Var.o(i18) ? c1Var.c(i18) : null;
                        int i19 = R$styleable.TextAppearance_android_textColorLink;
                        colorStateList2 = c1Var.o(i19) ? c1Var.c(i19) : null;
                    } else {
                        colorStateList3 = null;
                        colorStateList2 = null;
                        colorStateList = null;
                    }
                    int i20 = R$styleable.TextAppearance_textLocale;
                    str2 = !c1Var.o(i20) ? c1Var.m(i20) : null;
                    if (i13 >= 26) {
                        int i21 = R$styleable.TextAppearance_fontVariationSettings;
                        if (c1Var.o(i21)) {
                            str = c1Var.m(i21);
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
            if (i13 >= 23) {
            }
            int i202 = R$styleable.TextAppearance_textLocale;
            if (!c1Var.o(i202)) {
            }
            if (i13 >= 26) {
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
            int i22 = R$styleable.TextAppearance_textAllCaps;
            if (c1Var2.o(i22)) {
                z4 = c1Var2.a(i22, false);
                z3 = true;
                if (i13 < 23) {
                    int i23 = R$styleable.TextAppearance_android_textColor;
                    if (c1Var2.o(i23)) {
                        colorStateList = c1Var2.c(i23);
                    }
                    int i24 = R$styleable.TextAppearance_android_textColorHint;
                    if (c1Var2.o(i24)) {
                        colorStateList3 = c1Var2.c(i24);
                    }
                    int i25 = R$styleable.TextAppearance_android_textColorLink;
                    if (c1Var2.o(i25)) {
                        colorStateList2 = c1Var2.c(i25);
                    }
                }
                i3 = R$styleable.TextAppearance_textLocale;
                if (c1Var2.o(i3)) {
                    str2 = c1Var2.m(i3);
                }
                if (i13 >= 26) {
                    int i26 = R$styleable.TextAppearance_fontVariationSettings;
                    if (c1Var2.o(i26)) {
                        str = c1Var2.m(i26);
                    }
                }
                if (i13 >= 28) {
                    int i27 = R$styleable.TextAppearance_android_textSize;
                    if (c1Var2.o(i27)) {
                        kVar = a2;
                        if (c1Var2.f(i27, -1) == 0) {
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
                        typeface = this.f909l;
                        if (typeface != null) {
                            if (this.f908k == -1) {
                                this.a.setTypeface(typeface, this.f907j);
                            } else {
                                this.a.setTypeface(typeface);
                            }
                        }
                        if (str != null) {
                            this.a.setFontVariationSettings(str);
                        }
                        if (str2 != null) {
                            if (i13 >= 24) {
                                this.a.setTextLocales(LocaleList.forLanguageTags(str2));
                            } else {
                                i4 = 0;
                                this.a.setTextLocale(Locale.forLanguageTag(str2.substring(0, str2.indexOf(44))));
                                e0Var = this.f906i;
                                Context context2 = e0Var.f933j;
                                int[] iArr2 = R$styleable.AppCompatTextView;
                                obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr2, i2, i4);
                                TextView textView2 = e0Var.f932i;
                                v.t(textView2, textView2.getContext(), iArr2, attributeSet, obtainStyledAttributes, i2, 0);
                                i5 = R$styleable.AppCompatTextView_autoSizeTextType;
                                if (obtainStyledAttributes.hasValue(i5)) {
                                    e0Var.a = obtainStyledAttributes.getInt(i5, 0);
                                }
                                int i28 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
                                float dimension = !obtainStyledAttributes.hasValue(i28) ? obtainStyledAttributes.getDimension(i28, -1.0f) : -1.0f;
                                int i29 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
                                float dimension2 = !obtainStyledAttributes.hasValue(i29) ? obtainStyledAttributes.getDimension(i29, -1.0f) : -1.0f;
                                int i30 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
                                float dimension3 = !obtainStyledAttributes.hasValue(i30) ? obtainStyledAttributes.getDimension(i30, -1.0f) : -1.0f;
                                i6 = R$styleable.AppCompatTextView_autoSizePresetSizes;
                                if (obtainStyledAttributes.hasValue(i6) && (resourceId3 = obtainStyledAttributes.getResourceId(i6, 0)) > 0) {
                                    TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId3);
                                    length = obtainTypedArray.length();
                                    int[] iArr3 = new int[length];
                                    if (length > 0) {
                                        for (int i31 = 0; i31 < length; i31++) {
                                            iArr3[i31] = obtainTypedArray.getDimensionPixelSize(i31, -1);
                                        }
                                        e0Var.f929f = e0Var.b(iArr3);
                                        e0Var.h();
                                    }
                                    obtainTypedArray.recycle();
                                }
                                obtainStyledAttributes.recycle();
                                if (e0Var.i()) {
                                    e0Var.a = 0;
                                } else if (e0Var.a == 1) {
                                    if (!e0Var.f930g) {
                                        DisplayMetrics displayMetrics = e0Var.f933j.getResources().getDisplayMetrics();
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
                                    e0 e0Var2 = this.f906i;
                                    if (e0Var2.a != 0) {
                                        int[] iArr4 = e0Var2.f929f;
                                        if (iArr4.length > 0) {
                                            if (((float) this.a.getAutoSizeStepGranularity()) != -1.0f) {
                                                this.a.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.f906i.f927d), Math.round(this.f906i.f928e), Math.round(this.f906i.c), 0);
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
                                b = resourceId4 == -1 ? kVar2.b(context, resourceId4) : null;
                                int resourceId5 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableRightCompat, -1);
                                Drawable b5 = resourceId5 == -1 ? kVar2.b(context, resourceId5) : null;
                                int resourceId6 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableBottomCompat, -1);
                                b2 = resourceId6 == -1 ? kVar2.b(context, resourceId6) : null;
                                int resourceId7 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableStartCompat, -1);
                                b3 = resourceId7 == -1 ? kVar2.b(context, resourceId7) : null;
                                int resourceId8 = obtainStyledAttributes2.getResourceId(R$styleable.AppCompatTextView_drawableEndCompat, -1);
                                b4 = resourceId8 == -1 ? kVar2.b(context, resourceId8) : null;
                                if (b3 == null || b4 != null) {
                                    Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
                                    TextView textView3 = this.a;
                                    if (b3 == null) {
                                        b3 = compoundDrawablesRelative[0];
                                    }
                                    if (b == null) {
                                        b = compoundDrawablesRelative[1];
                                    }
                                    if (b4 == null) {
                                        b4 = compoundDrawablesRelative[2];
                                    }
                                    if (b2 == null) {
                                        b2 = compoundDrawablesRelative[3];
                                    }
                                    textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(b3, b, b4, b2);
                                } else if (!(drawable == null && b == null && b5 == null && b2 == null)) {
                                    Drawable[] compoundDrawablesRelative2 = this.a.getCompoundDrawablesRelative();
                                    if (compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null) {
                                        Drawable[] compoundDrawables = this.a.getCompoundDrawables();
                                        TextView textView4 = this.a;
                                        if (drawable == null) {
                                            drawable = compoundDrawables[0];
                                        }
                                        if (b == null) {
                                            b = compoundDrawables[1];
                                        }
                                        if (b5 == null) {
                                            b5 = compoundDrawables[2];
                                        }
                                        if (b2 == null) {
                                            b2 = compoundDrawables[3];
                                        }
                                        textView4.setCompoundDrawablesWithIntrinsicBounds(drawable, b, b5, b2);
                                    } else {
                                        TextView textView5 = this.a;
                                        Drawable drawable2 = compoundDrawablesRelative2[0];
                                        if (b == null) {
                                            b = compoundDrawablesRelative2[1];
                                        }
                                        Drawable drawable3 = compoundDrawablesRelative2[2];
                                        if (b2 == null) {
                                            b2 = compoundDrawablesRelative2[3];
                                        }
                                        textView5.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, b, drawable3, b2);
                                    }
                                }
                                i7 = R$styleable.AppCompatTextView_drawableTint;
                                if (obtainStyledAttributes2.hasValue(i7)) {
                                    if (!obtainStyledAttributes2.hasValue(i7) || (resourceId2 = obtainStyledAttributes2.getResourceId(i7, 0)) == 0 || (colorStateList4 = m.e.g0(context, resourceId2)) == null) {
                                        colorStateList4 = obtainStyledAttributes2.getColorStateList(i7);
                                    }
                                    TextView textView6 = this.a;
                                    Objects.requireNonNull(textView6);
                                    if (Build.VERSION.SDK_INT >= 24) {
                                        textView6.setCompoundDrawableTintList(colorStateList4);
                                    } else if (textView6 instanceof e.j.k.h) {
                                        ((e.j.k.h) textView6).setSupportCompoundDrawablesTintList(colorStateList4);
                                    }
                                }
                                i8 = R$styleable.AppCompatTextView_drawableTintMode;
                                if (obtainStyledAttributes2.hasValue(i8)) {
                                    PorterDuff.Mode e2 = i0.e(obtainStyledAttributes2.getInt(i8, -1), null);
                                    TextView textView7 = this.a;
                                    Objects.requireNonNull(textView7);
                                    if (Build.VERSION.SDK_INT >= 24) {
                                        textView7.setCompoundDrawableTintMode(e2);
                                    } else if (textView7 instanceof e.j.k.h) {
                                        ((e.j.k.h) textView7).setSupportCompoundDrawablesTintMode(e2);
                                    }
                                }
                                dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
                                dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
                                dimensionPixelSize3 = obtainStyledAttributes2.getDimensionPixelSize(R$styleable.AppCompatTextView_lineHeight, -1);
                                obtainStyledAttributes2.recycle();
                                if (dimensionPixelSize != -1) {
                                    m.e.x1(this.a, dimensionPixelSize);
                                }
                                if (dimensionPixelSize2 != -1) {
                                    m.e.y1(this.a, dimensionPixelSize2);
                                }
                                if (dimensionPixelSize3 == -1) {
                                    m.e.A1(this.a, dimensionPixelSize3);
                                    return;
                                }
                                return;
                            }
                        }
                        i4 = 0;
                        e0Var = this.f906i;
                        Context context22 = e0Var.f933j;
                        int[] iArr22 = R$styleable.AppCompatTextView;
                        obtainStyledAttributes = context22.obtainStyledAttributes(attributeSet, iArr22, i2, i4);
                        TextView textView22 = e0Var.f932i;
                        v.t(textView22, textView22.getContext(), iArr22, attributeSet, obtainStyledAttributes, i2, 0);
                        i5 = R$styleable.AppCompatTextView_autoSizeTextType;
                        if (obtainStyledAttributes.hasValue(i5)) {
                        }
                        int i282 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
                        if (!obtainStyledAttributes.hasValue(i282)) {
                        }
                        int i292 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
                        if (!obtainStyledAttributes.hasValue(i292)) {
                        }
                        int i302 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
                        if (!obtainStyledAttributes.hasValue(i302)) {
                        }
                        i6 = R$styleable.AppCompatTextView_autoSizePresetSizes;
                        if (obtainStyledAttributes.hasValue(i6)) {
                            TypedArray obtainTypedArray2 = obtainStyledAttributes.getResources().obtainTypedArray(resourceId3);
                            length = obtainTypedArray2.length();
                            int[] iArr32 = new int[length];
                            if (length > 0) {
                            }
                            obtainTypedArray2.recycle();
                        }
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
                        if (b3 == null) {
                        }
                        Drawable[] compoundDrawablesRelative3 = this.a.getCompoundDrawablesRelative();
                        TextView textView32 = this.a;
                        if (b3 == null) {
                        }
                        if (b == null) {
                        }
                        if (b4 == null) {
                        }
                        if (b2 == null) {
                        }
                        textView32.setCompoundDrawablesRelativeWithIntrinsicBounds(b3, b, b4, b2);
                        i7 = R$styleable.AppCompatTextView_drawableTint;
                        if (obtainStyledAttributes2.hasValue(i7)) {
                        }
                        i8 = R$styleable.AppCompatTextView_drawableTintMode;
                        if (obtainStyledAttributes2.hasValue(i8)) {
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
                if (!z5) {
                    this.a.setAllCaps(z4);
                }
                typeface = this.f909l;
                if (typeface != null) {
                }
                if (str != null) {
                }
                if (str2 != null) {
                }
                i4 = 0;
                e0Var = this.f906i;
                Context context222 = e0Var.f933j;
                int[] iArr222 = R$styleable.AppCompatTextView;
                obtainStyledAttributes = context222.obtainStyledAttributes(attributeSet, iArr222, i2, i4);
                TextView textView222 = e0Var.f932i;
                v.t(textView222, textView222.getContext(), iArr222, attributeSet, obtainStyledAttributes, i2, 0);
                i5 = R$styleable.AppCompatTextView_autoSizeTextType;
                if (obtainStyledAttributes.hasValue(i5)) {
                }
                int i2822 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
                if (!obtainStyledAttributes.hasValue(i2822)) {
                }
                int i2922 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
                if (!obtainStyledAttributes.hasValue(i2922)) {
                }
                int i3022 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
                if (!obtainStyledAttributes.hasValue(i3022)) {
                }
                i6 = R$styleable.AppCompatTextView_autoSizePresetSizes;
                if (obtainStyledAttributes.hasValue(i6)) {
                }
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
                if (b3 == null) {
                }
                Drawable[] compoundDrawablesRelative32 = this.a.getCompoundDrawablesRelative();
                TextView textView322 = this.a;
                if (b3 == null) {
                }
                if (b == null) {
                }
                if (b4 == null) {
                }
                if (b2 == null) {
                }
                textView322.setCompoundDrawablesRelativeWithIntrinsicBounds(b3, b, b4, b2);
                i7 = R$styleable.AppCompatTextView_drawableTint;
                if (obtainStyledAttributes2.hasValue(i7)) {
                }
                i8 = R$styleable.AppCompatTextView_drawableTintMode;
                if (obtainStyledAttributes2.hasValue(i8)) {
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
        if (i13 < 23) {
        }
        i3 = R$styleable.TextAppearance_textLocale;
        if (c1Var2.o(i3)) {
        }
        if (i13 >= 26) {
        }
        if (i13 >= 28) {
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
        if (!z5) {
        }
        typeface = this.f909l;
        if (typeface != null) {
        }
        if (str != null) {
        }
        if (str2 != null) {
        }
        i4 = 0;
        e0Var = this.f906i;
        Context context2222 = e0Var.f933j;
        int[] iArr2222 = R$styleable.AppCompatTextView;
        obtainStyledAttributes = context2222.obtainStyledAttributes(attributeSet, iArr2222, i2, i4);
        TextView textView2222 = e0Var.f932i;
        v.t(textView2222, textView2222.getContext(), iArr2222, attributeSet, obtainStyledAttributes, i2, 0);
        i5 = R$styleable.AppCompatTextView_autoSizeTextType;
        if (obtainStyledAttributes.hasValue(i5)) {
        }
        int i28222 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
        if (!obtainStyledAttributes.hasValue(i28222)) {
        }
        int i29222 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
        if (!obtainStyledAttributes.hasValue(i29222)) {
        }
        int i30222 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
        if (!obtainStyledAttributes.hasValue(i30222)) {
        }
        i6 = R$styleable.AppCompatTextView_autoSizePresetSizes;
        if (obtainStyledAttributes.hasValue(i6)) {
        }
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
        if (b3 == null) {
        }
        Drawable[] compoundDrawablesRelative322 = this.a.getCompoundDrawablesRelative();
        TextView textView3222 = this.a;
        if (b3 == null) {
        }
        if (b == null) {
        }
        if (b4 == null) {
        }
        if (b2 == null) {
        }
        textView3222.setCompoundDrawablesRelativeWithIntrinsicBounds(b3, b, b4, b2);
        i7 = R$styleable.AppCompatTextView_drawableTint;
        if (obtainStyledAttributes2.hasValue(i7)) {
        }
        i8 = R$styleable.AppCompatTextView_drawableTintMode;
        if (obtainStyledAttributes2.hasValue(i8)) {
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
        String m;
        ColorStateList c;
        ColorStateList c2;
        ColorStateList c3;
        c1 c1Var = new c1(context, context.obtainStyledAttributes(i2, R$styleable.TextAppearance));
        int i3 = R$styleable.TextAppearance_textAllCaps;
        if (c1Var.o(i3)) {
            this.a.setAllCaps(c1Var.a(i3, false));
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 23) {
            int i5 = R$styleable.TextAppearance_android_textColor;
            if (c1Var.o(i5) && (c3 = c1Var.c(i5)) != null) {
                this.a.setTextColor(c3);
            }
            int i6 = R$styleable.TextAppearance_android_textColorLink;
            if (c1Var.o(i6) && (c2 = c1Var.c(i6)) != null) {
                this.a.setLinkTextColor(c2);
            }
            int i7 = R$styleable.TextAppearance_android_textColorHint;
            if (c1Var.o(i7) && (c = c1Var.c(i7)) != null) {
                this.a.setHintTextColor(c);
            }
        }
        int i8 = R$styleable.TextAppearance_android_textSize;
        if (c1Var.o(i8) && c1Var.f(i8, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        m(context, c1Var);
        if (i4 >= 26) {
            int i9 = R$styleable.TextAppearance_fontVariationSettings;
            if (c1Var.o(i9) && (m = c1Var.m(i9)) != null) {
                this.a.setFontVariationSettings(m);
            }
        }
        c1Var.b.recycle();
        Typeface typeface = this.f909l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.f907j);
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
                        e.j.j.d0.a.b(editorInfo, text, i5, i6);
                        return;
                    }
                    int i8 = i6 - i5;
                    int i9 = i8 > 1024 ? 0 : i8;
                    int i10 = 2048 - i9;
                    int min = Math.min(text.length() - i6, i10 - Math.min(i5, (int) (((double) i10) * 0.8d)));
                    int min2 = Math.min(i5, i10 - min);
                    int i11 = i5 - min2;
                    if (e.j.j.d0.a.a(text, i11, 0)) {
                        i11++;
                        min2--;
                    }
                    if (e.j.j.d0.a.a(text, (i6 + min) - 1, 1)) {
                        min--;
                    }
                    CharSequence concat = i9 != i8 ? TextUtils.concat(text.subSequence(i11, i11 + min2), text.subSequence(i6, min + i6)) : text.subSequence(i11, min2 + i9 + min + i11);
                    int i12 = min2 + 0;
                    e.j.j.d0.a.b(editorInfo, concat, i12, i9 + i12);
                    return;
                }
            }
            e.j.j.d0.a.b(editorInfo, null, 0, 0);
        }
    }

    public void h(int i2, int i3, int i4, int i5) {
        e0 e0Var = this.f906i;
        if (e0Var.i()) {
            DisplayMetrics displayMetrics = e0Var.f933j.getResources().getDisplayMetrics();
            e0Var.j(TypedValue.applyDimension(i5, (float) i2, displayMetrics), TypedValue.applyDimension(i5, (float) i3, displayMetrics), TypedValue.applyDimension(i5, (float) i4, displayMetrics));
            if (e0Var.g()) {
                e0Var.a();
            }
        }
    }

    public void i(int[] iArr, int i2) {
        e0 e0Var = this.f906i;
        if (e0Var.i()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = e0Var.f933j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, (float) iArr[i3], displayMetrics));
                    }
                }
                e0Var.f929f = e0Var.b(iArr2);
                if (!e0Var.h()) {
                    StringBuilder h2 = f.a.a.a.a.h("None of the preset sizes is valid: ");
                    h2.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(h2.toString());
                }
            } else {
                e0Var.f930g = false;
            }
            if (e0Var.g()) {
                e0Var.a();
            }
        }
    }

    public void j(int i2) {
        e0 e0Var = this.f906i;
        if (!e0Var.i()) {
            return;
        }
        if (i2 == 0) {
            e0Var.a = 0;
            e0Var.f927d = -1.0f;
            e0Var.f928e = -1.0f;
            e0Var.c = -1.0f;
            e0Var.f929f = new int[0];
            e0Var.b = false;
        } else if (i2 == 1) {
            DisplayMetrics displayMetrics = e0Var.f933j.getResources().getDisplayMetrics();
            e0Var.j(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (e0Var.g()) {
                e0Var.a();
            }
        } else {
            throw new IllegalArgumentException(f.a.a.a.a.u("Unknown auto-size text type: ", i2));
        }
    }

    public void k(ColorStateList colorStateList) {
        if (this.f905h == null) {
            this.f905h = new a1();
        }
        a1 a1Var = this.f905h;
        a1Var.a = colorStateList;
        a1Var.f900d = colorStateList != null;
        this.b = a1Var;
        this.c = a1Var;
        this.f901d = a1Var;
        this.f902e = a1Var;
        this.f903f = a1Var;
        this.f904g = a1Var;
    }

    public void l(PorterDuff.Mode mode) {
        if (this.f905h == null) {
            this.f905h = new a1();
        }
        a1 a1Var = this.f905h;
        a1Var.b = mode;
        a1Var.c = mode != null;
        this.b = a1Var;
        this.c = a1Var;
        this.f901d = a1Var;
        this.f902e = a1Var;
        this.f903f = a1Var;
        this.f904g = a1Var;
    }

    public final void m(Context context, c1 c1Var) {
        String m;
        Typeface typeface;
        Typeface typeface2;
        this.f907j = c1Var.j(R$styleable.TextAppearance_android_textStyle, this.f907j);
        int i2 = Build.VERSION.SDK_INT;
        boolean z = false;
        if (i2 >= 28) {
            int j2 = c1Var.j(R$styleable.TextAppearance_android_textFontWeight, -1);
            this.f908k = j2;
            if (j2 != -1) {
                this.f907j = (this.f907j & 2) | 0;
            }
        }
        int i3 = R$styleable.TextAppearance_android_fontFamily;
        if (c1Var.o(i3) || c1Var.o(R$styleable.TextAppearance_fontFamily)) {
            this.f909l = null;
            int i4 = R$styleable.TextAppearance_fontFamily;
            if (c1Var.o(i4)) {
                i3 = i4;
            }
            int i5 = this.f908k;
            int i6 = this.f907j;
            if (!context.isRestricted()) {
                try {
                    Typeface i7 = c1Var.i(i3, this.f907j, new a(i5, i6, new WeakReference(this.a)));
                    if (i7 != null) {
                        if (i2 >= 28 && this.f908k != -1) {
                            i7 = Typeface.create(Typeface.create(i7, 0), this.f908k, (this.f907j & 2) != 0);
                        }
                        this.f909l = i7;
                    }
                    this.m = this.f909l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f909l == null && (m = c1Var.m(i3)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.f908k == -1) {
                    typeface = Typeface.create(m, this.f907j);
                } else {
                    Typeface create = Typeface.create(m, 0);
                    int i8 = this.f908k;
                    if ((this.f907j & 2) != 0) {
                        z = true;
                    }
                    typeface = Typeface.create(create, i8, z);
                }
                this.f909l = typeface;
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
            this.f909l = typeface2;
        }
    }
}
