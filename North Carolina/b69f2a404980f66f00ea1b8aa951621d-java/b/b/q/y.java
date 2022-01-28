package b.b.q;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import b.b.j;
import b.b.k.i;
import b.i.e.b.g;
import b.i.l.m;
import b.i.m.b;
import b.i.m.e;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;

public class y {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f749a;

    /* renamed from: b  reason: collision with root package name */
    public w0 f750b;

    /* renamed from: c  reason: collision with root package name */
    public w0 f751c;

    /* renamed from: d  reason: collision with root package name */
    public w0 f752d;

    /* renamed from: e  reason: collision with root package name */
    public w0 f753e;
    public w0 f;
    public w0 g;
    public w0 h;
    public final a0 i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    public class a extends g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f754a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f755b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ WeakReference f756c;

        public a(int i, int i2, WeakReference weakReference) {
            this.f754a = i;
            this.f755b = i2;
            this.f756c = weakReference;
        }

        @Override // b.i.e.b.g
        public void c(int i) {
        }

        @Override // b.i.e.b.g
        public void d(Typeface typeface) {
            int i;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.f754a) != -1) {
                typeface = Typeface.create(typeface, i, (this.f755b & 2) != 0);
            }
            y yVar = y.this;
            WeakReference weakReference = this.f756c;
            if (yVar.m) {
                yVar.l = typeface;
                TextView textView = (TextView) weakReference.get();
                if (textView != null) {
                    textView.setTypeface(typeface, yVar.j);
                }
            }
        }
    }

    public y(TextView textView) {
        this.f749a = textView;
        this.i = new a0(this.f749a);
    }

    public static w0 c(Context context, j jVar, int i2) {
        ColorStateList d2 = jVar.d(context, i2);
        if (d2 == null) {
            return null;
        }
        w0 w0Var = new w0();
        w0Var.f746d = true;
        w0Var.f743a = d2;
        return w0Var;
    }

    public final void a(Drawable drawable, w0 w0Var) {
        if (drawable != null && w0Var != null) {
            j.f(drawable, w0Var, this.f749a.getDrawableState());
        }
    }

    public void b() {
        if (!(this.f750b == null && this.f751c == null && this.f752d == null && this.f753e == null)) {
            Drawable[] compoundDrawables = this.f749a.getCompoundDrawables();
            a(compoundDrawables[0], this.f750b);
            a(compoundDrawables[1], this.f751c);
            a(compoundDrawables[2], this.f752d);
            a(compoundDrawables[3], this.f753e);
        }
        if (this.f != null || this.g != null) {
            Drawable[] compoundDrawablesRelative = this.f749a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    public boolean d() {
        a0 a0Var = this.i;
        return a0Var.i() && a0Var.f585a != 0;
    }

    @SuppressLint({"NewApi"})
    public void e(AttributeSet attributeSet, int i2) {
        String str;
        String str2;
        boolean z;
        boolean z2;
        ColorStateList colorStateList;
        int resourceId;
        int resourceId2;
        Context context = this.f749a.getContext();
        j a2 = j.a();
        y0 q = y0.q(context, attributeSet, j.AppCompatTextHelper, i2, 0);
        TextView textView = this.f749a;
        m.S(textView, textView.getContext(), j.AppCompatTextHelper, attributeSet, q.f759b, i2, 0);
        int l2 = q.l(j.AppCompatTextHelper_android_textAppearance, -1);
        if (q.o(j.AppCompatTextHelper_android_drawableLeft)) {
            this.f750b = c(context, a2, q.l(j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (q.o(j.AppCompatTextHelper_android_drawableTop)) {
            this.f751c = c(context, a2, q.l(j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (q.o(j.AppCompatTextHelper_android_drawableRight)) {
            this.f752d = c(context, a2, q.l(j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (q.o(j.AppCompatTextHelper_android_drawableBottom)) {
            this.f753e = c(context, a2, q.l(j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (q.o(j.AppCompatTextHelper_android_drawableStart)) {
            this.f = c(context, a2, q.l(j.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (q.o(j.AppCompatTextHelper_android_drawableEnd)) {
            this.g = c(context, a2, q.l(j.AppCompatTextHelper_android_drawableEnd, 0));
        }
        q.f759b.recycle();
        boolean z3 = this.f749a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (l2 != -1) {
            y0 y0Var = new y0(context, context.obtainStyledAttributes(l2, j.TextAppearance));
            if (z3 || !y0Var.o(j.TextAppearance_textAllCaps)) {
                z2 = false;
                z = false;
            } else {
                z2 = y0Var.a(j.TextAppearance_textAllCaps, false);
                z = true;
            }
            l(context, y0Var);
            str2 = y0Var.o(j.TextAppearance_textLocale) ? y0Var.m(j.TextAppearance_textLocale) : null;
            str = (Build.VERSION.SDK_INT < 26 || !y0Var.o(j.TextAppearance_fontVariationSettings)) ? null : y0Var.m(j.TextAppearance_fontVariationSettings);
            y0Var.f759b.recycle();
        } else {
            z2 = false;
            z = false;
            str2 = null;
            str = null;
        }
        y0 y0Var2 = new y0(context, context.obtainStyledAttributes(attributeSet, j.TextAppearance, i2, 0));
        if (!z3 && y0Var2.o(j.TextAppearance_textAllCaps)) {
            z2 = y0Var2.a(j.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (y0Var2.o(j.TextAppearance_textLocale)) {
            str2 = y0Var2.m(j.TextAppearance_textLocale);
        }
        if (Build.VERSION.SDK_INT >= 26 && y0Var2.o(j.TextAppearance_fontVariationSettings)) {
            str = y0Var2.m(j.TextAppearance_fontVariationSettings);
        }
        if (Build.VERSION.SDK_INT >= 28 && y0Var2.o(j.TextAppearance_android_textSize) && y0Var2.f(j.TextAppearance_android_textSize, -1) == 0) {
            this.f749a.setTextSize(0, 0.0f);
        }
        l(context, y0Var2);
        y0Var2.f759b.recycle();
        if (!z3 && z) {
            this.f749a.setAllCaps(z2);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.k == -1) {
                this.f749a.setTypeface(typeface, this.j);
            } else {
                this.f749a.setTypeface(typeface);
            }
        }
        if (str != null) {
            this.f749a.setFontVariationSettings(str);
        }
        if (str2 != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.f749a.setTextLocales(LocaleList.forLanguageTags(str2));
            } else {
                this.f749a.setTextLocale(Locale.forLanguageTag(str2.substring(0, str2.indexOf(44))));
            }
        }
        a0 a0Var = this.i;
        TypedArray obtainStyledAttributes = a0Var.j.obtainStyledAttributes(attributeSet, j.AppCompatTextView, i2, 0);
        TextView textView2 = a0Var.i;
        m.S(textView2, textView2.getContext(), j.AppCompatTextView, attributeSet, obtainStyledAttributes, i2, 0);
        if (obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeTextType)) {
            a0Var.f585a = obtainStyledAttributes.getInt(j.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(j.AppCompatTextView_autoSizePresetSizes) && (resourceId2 = obtainStyledAttributes.getResourceId(j.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId2);
            int length = obtainTypedArray.length();
            int[] iArr = new int[length];
            if (length > 0) {
                for (int i3 = 0; i3 < length; i3++) {
                    iArr[i3] = obtainTypedArray.getDimensionPixelSize(i3, -1);
                }
                a0Var.f = a0Var.b(iArr);
                a0Var.h();
            }
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!a0Var.i()) {
            a0Var.f585a = 0;
        } else if (a0Var.f585a == 1) {
            if (!a0Var.g) {
                DisplayMetrics displayMetrics = a0Var.j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                a0Var.j(dimension2, dimension3, dimension);
            }
            a0Var.g();
        }
        if (b.f1217a) {
            a0 a0Var2 = this.i;
            if (a0Var2.f585a != 0) {
                int[] iArr2 = a0Var2.f;
                if (iArr2.length > 0) {
                    if (((float) this.f749a.getAutoSizeStepGranularity()) != -1.0f) {
                        this.f749a.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.i.f588d), Math.round(this.i.f589e), Math.round(this.i.f587c), 0);
                    } else {
                        this.f749a.setAutoSizeTextTypeUniformWithPresetSizes(iArr2, 0);
                    }
                }
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, j.AppCompatTextView);
        int resourceId3 = obtainStyledAttributes2.getResourceId(j.AppCompatTextView_drawableLeftCompat, -1);
        Drawable b2 = resourceId3 != -1 ? a2.b(context, resourceId3) : null;
        int resourceId4 = obtainStyledAttributes2.getResourceId(j.AppCompatTextView_drawableTopCompat, -1);
        Drawable b3 = resourceId4 != -1 ? a2.b(context, resourceId4) : null;
        int resourceId5 = obtainStyledAttributes2.getResourceId(j.AppCompatTextView_drawableRightCompat, -1);
        Drawable b4 = resourceId5 != -1 ? a2.b(context, resourceId5) : null;
        int resourceId6 = obtainStyledAttributes2.getResourceId(j.AppCompatTextView_drawableBottomCompat, -1);
        Drawable b5 = resourceId6 != -1 ? a2.b(context, resourceId6) : null;
        int resourceId7 = obtainStyledAttributes2.getResourceId(j.AppCompatTextView_drawableStartCompat, -1);
        Drawable b6 = resourceId7 != -1 ? a2.b(context, resourceId7) : null;
        int resourceId8 = obtainStyledAttributes2.getResourceId(j.AppCompatTextView_drawableEndCompat, -1);
        Drawable b7 = resourceId8 != -1 ? a2.b(context, resourceId8) : null;
        if (b6 != null || b7 != null) {
            Drawable[] compoundDrawablesRelative = this.f749a.getCompoundDrawablesRelative();
            TextView textView3 = this.f749a;
            if (b6 == null) {
                b6 = compoundDrawablesRelative[0];
            }
            if (b3 == null) {
                b3 = compoundDrawablesRelative[1];
            }
            if (b7 == null) {
                b7 = compoundDrawablesRelative[2];
            }
            if (b5 == null) {
                b5 = compoundDrawablesRelative[3];
            }
            textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(b6, b3, b7, b5);
        } else if (!(b2 == null && b3 == null && b4 == null && b5 == null)) {
            Drawable[] compoundDrawablesRelative2 = this.f749a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = this.f749a.getCompoundDrawables();
                TextView textView4 = this.f749a;
                if (b2 == null) {
                    b2 = compoundDrawables[0];
                }
                if (b3 == null) {
                    b3 = compoundDrawables[1];
                }
                if (b4 == null) {
                    b4 = compoundDrawables[2];
                }
                if (b5 == null) {
                    b5 = compoundDrawables[3];
                }
                textView4.setCompoundDrawablesWithIntrinsicBounds(b2, b3, b4, b5);
            } else {
                TextView textView5 = this.f749a;
                Drawable drawable = compoundDrawablesRelative2[0];
                if (b3 == null) {
                    b3 = compoundDrawablesRelative2[1];
                }
                Drawable drawable2 = compoundDrawablesRelative2[2];
                if (b5 == null) {
                    b5 = compoundDrawablesRelative2[3];
                }
                textView5.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, b3, drawable2, b5);
            }
        }
        if (obtainStyledAttributes2.hasValue(j.AppCompatTextView_drawableTint)) {
            int i4 = j.AppCompatTextView_drawableTint;
            if (!obtainStyledAttributes2.hasValue(i4) || (resourceId = obtainStyledAttributes2.getResourceId(i4, 0)) == 0 || (colorStateList = b.b.l.a.a.a(context, resourceId)) == null) {
                colorStateList = obtainStyledAttributes2.getColorStateList(i4);
            }
            TextView textView6 = this.f749a;
            if (textView6 == null) {
                throw null;
            } else if (Build.VERSION.SDK_INT >= 24) {
                textView6.setCompoundDrawableTintList(colorStateList);
            } else if (textView6 instanceof e) {
                ((e) textView6).setSupportCompoundDrawablesTintList(colorStateList);
            }
        }
        if (obtainStyledAttributes2.hasValue(j.AppCompatTextView_drawableTintMode)) {
            PorterDuff.Mode d2 = e0.d(obtainStyledAttributes2.getInt(j.AppCompatTextView_drawableTintMode, -1), null);
            TextView textView7 = this.f749a;
            if (textView7 == null) {
                throw null;
            } else if (Build.VERSION.SDK_INT >= 24) {
                textView7.setCompoundDrawableTintMode(d2);
            } else if (textView7 instanceof e) {
                ((e) textView7).setSupportCompoundDrawablesTintMode(d2);
            }
        }
        int dimensionPixelSize = obtainStyledAttributes2.getDimensionPixelSize(j.AppCompatTextView_firstBaselineToTopHeight, -1);
        int dimensionPixelSize2 = obtainStyledAttributes2.getDimensionPixelSize(j.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int dimensionPixelSize3 = obtainStyledAttributes2.getDimensionPixelSize(j.AppCompatTextView_lineHeight, -1);
        obtainStyledAttributes2.recycle();
        if (dimensionPixelSize != -1) {
            i.j.V0(this.f749a, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != -1) {
            i.j.W0(this.f749a, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != -1) {
            i.j.X0(this.f749a, dimensionPixelSize3);
        }
    }

    public void f(Context context, int i2) {
        String m2;
        y0 y0Var = new y0(context, context.obtainStyledAttributes(i2, j.TextAppearance));
        if (y0Var.o(j.TextAppearance_textAllCaps)) {
            this.f749a.setAllCaps(y0Var.a(j.TextAppearance_textAllCaps, false));
        }
        if (y0Var.o(j.TextAppearance_android_textSize) && y0Var.f(j.TextAppearance_android_textSize, -1) == 0) {
            this.f749a.setTextSize(0, 0.0f);
        }
        l(context, y0Var);
        if (Build.VERSION.SDK_INT >= 26 && y0Var.o(j.TextAppearance_fontVariationSettings) && (m2 = y0Var.m(j.TextAppearance_fontVariationSettings)) != null) {
            this.f749a.setFontVariationSettings(m2);
        }
        y0Var.f759b.recycle();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.f749a.setTypeface(typeface, this.j);
        }
    }

    public void g(int i2, int i3, int i4, int i5) {
        a0 a0Var = this.i;
        if (a0Var.i()) {
            DisplayMetrics displayMetrics = a0Var.j.getResources().getDisplayMetrics();
            a0Var.j(TypedValue.applyDimension(i5, (float) i2, displayMetrics), TypedValue.applyDimension(i5, (float) i3, displayMetrics), TypedValue.applyDimension(i5, (float) i4, displayMetrics));
            if (a0Var.g()) {
                a0Var.a();
            }
        }
    }

    public void h(int[] iArr, int i2) {
        a0 a0Var = this.i;
        if (a0Var.i()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = a0Var.j.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, (float) iArr[i3], displayMetrics));
                    }
                }
                a0Var.f = a0Var.b(iArr2);
                if (!a0Var.h()) {
                    StringBuilder g2 = c.a.a.a.a.g("None of the preset sizes is valid: ");
                    g2.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(g2.toString());
                }
            } else {
                a0Var.g = false;
            }
            if (a0Var.g()) {
                a0Var.a();
            }
        }
    }

    public void i(int i2) {
        a0 a0Var = this.i;
        if (!a0Var.i()) {
            return;
        }
        if (i2 == 0) {
            a0Var.f585a = 0;
            a0Var.f588d = -1.0f;
            a0Var.f589e = -1.0f;
            a0Var.f587c = -1.0f;
            a0Var.f = new int[0];
            a0Var.f586b = false;
        } else if (i2 == 1) {
            DisplayMetrics displayMetrics = a0Var.j.getResources().getDisplayMetrics();
            a0Var.j(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (a0Var.g()) {
                a0Var.a();
            }
        } else {
            throw new IllegalArgumentException(c.a.a.a.a.l("Unknown auto-size text type: ", i2));
        }
    }

    public void j(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new w0();
        }
        w0 w0Var = this.h;
        w0Var.f743a = colorStateList;
        w0Var.f746d = colorStateList != null;
        w0 w0Var2 = this.h;
        this.f750b = w0Var2;
        this.f751c = w0Var2;
        this.f752d = w0Var2;
        this.f753e = w0Var2;
        this.f = w0Var2;
        this.g = w0Var2;
    }

    public void k(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new w0();
        }
        w0 w0Var = this.h;
        w0Var.f744b = mode;
        w0Var.f745c = mode != null;
        w0 w0Var2 = this.h;
        this.f750b = w0Var2;
        this.f751c = w0Var2;
        this.f752d = w0Var2;
        this.f753e = w0Var2;
        this.f = w0Var2;
        this.g = w0Var2;
    }

    public final void l(Context context, y0 y0Var) {
        String m2;
        Typeface typeface;
        Typeface typeface2;
        this.j = y0Var.j(j.TextAppearance_android_textStyle, this.j);
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 28) {
            int j2 = y0Var.j(j.TextAppearance_android_textFontWeight, -1);
            this.k = j2;
            if (j2 != -1) {
                this.j = (this.j & 2) | 0;
            }
        }
        if (y0Var.o(j.TextAppearance_android_fontFamily) || y0Var.o(j.TextAppearance_fontFamily)) {
            this.l = null;
            int i2 = y0Var.o(j.TextAppearance_fontFamily) ? j.TextAppearance_fontFamily : j.TextAppearance_android_fontFamily;
            int i3 = this.k;
            int i4 = this.j;
            if (!context.isRestricted()) {
                try {
                    Typeface i5 = y0Var.i(i2, this.j, new a(i3, i4, new WeakReference(this.f749a)));
                    if (i5 != null) {
                        if (Build.VERSION.SDK_INT >= 28 && this.k != -1) {
                            i5 = Typeface.create(Typeface.create(i5, 0), this.k, (this.j & 2) != 0);
                        }
                        this.l = i5;
                    }
                    this.m = this.l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.l == null && (m2 = y0Var.m(i2)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
                    typeface = Typeface.create(m2, this.j);
                } else {
                    Typeface create = Typeface.create(m2, 0);
                    int i6 = this.k;
                    if ((this.j & 2) != 0) {
                        z = true;
                    }
                    typeface = Typeface.create(create, i6, z);
                }
                this.l = typeface;
            }
        } else if (y0Var.o(j.TextAppearance_android_typeface)) {
            this.m = false;
            int j3 = y0Var.j(j.TextAppearance_android_typeface, 1);
            if (j3 == 1) {
                typeface2 = Typeface.SANS_SERIF;
            } else if (j3 == 2) {
                typeface2 = Typeface.SERIF;
            } else if (j3 == 3) {
                typeface2 = Typeface.MONOSPACE;
            } else {
                return;
            }
            this.l = typeface2;
        }
    }
}
