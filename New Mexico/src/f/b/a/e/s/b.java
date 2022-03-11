package f.b.a.e.s;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.TypedValue;
import com.google.android.material.R$styleable;
import e.j.b.b.h;
/* loaded from: classes.dex */
public class b {
    public final ColorStateList a;
    public final String b;
    public final int c;

    /* renamed from: d */
    public final int f3050d;

    /* renamed from: e */
    public final float f3051e;

    /* renamed from: f */
    public final float f3052f;

    /* renamed from: g */
    public final float f3053g;

    /* renamed from: h */
    public final boolean f3054h;

    /* renamed from: i */
    public final float f3055i;

    /* renamed from: j */
    public ColorStateList f3056j;

    /* renamed from: k */
    public float f3057k;

    /* renamed from: l */
    public final int f3058l;
    public boolean m = false;
    public Typeface n;

    /* loaded from: classes.dex */
    public class a extends h.c {
        public final /* synthetic */ d a;

        public a(d dVar) {
            b.this = r1;
            this.a = dVar;
        }

        @Override // e.j.b.b.h.c
        public void d(int i2) {
            b.this.m = true;
            this.a.a(i2);
        }

        @Override // e.j.b.b.h.c
        public void e(Typeface typeface) {
            b bVar = b.this;
            bVar.n = Typeface.create(typeface, bVar.c);
            b bVar2 = b.this;
            bVar2.m = true;
            this.a.b(bVar2.n, false);
        }
    }

    public b(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.TextAppearance);
        this.f3057k = obtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f);
        this.f3056j = f.b.a.c.b.o.b.y0(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColor);
        f.b.a.c.b.o.b.y0(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        f.b.a.c.b.o.b.y0(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        this.c = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        this.f3050d = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int i3 = R$styleable.TextAppearance_fontFamily;
        i3 = !obtainStyledAttributes.hasValue(i3) ? R$styleable.TextAppearance_android_fontFamily : i3;
        this.f3058l = obtainStyledAttributes.getResourceId(i3, 0);
        this.b = obtainStyledAttributes.getString(i3);
        obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        this.a = f.b.a.c.b.o.b.y0(context, obtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        this.f3051e = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f3052f = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f3053g = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i2, R$styleable.MaterialTextAppearance);
        int i4 = R$styleable.MaterialTextAppearance_android_letterSpacing;
        this.f3054h = obtainStyledAttributes2.hasValue(i4);
        this.f3055i = obtainStyledAttributes2.getFloat(i4, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        if (this.n == null && (str = this.b) != null) {
            this.n = Typeface.create(str, this.c);
        }
        if (this.n == null) {
            int i2 = this.f3050d;
            this.n = i2 != 1 ? i2 != 2 ? i2 != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.n = Typeface.create(this.n, this.c);
        }
    }

    public Typeface b(Context context) {
        if (this.m) {
            return this.n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface a2 = h.a(context, this.f3058l);
                this.n = a2;
                if (a2 != null) {
                    this.n = Typeface.create(a2, this.c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException | Exception unused) {
            }
        }
        a();
        this.m = true;
        return this.n;
    }

    public void c(Context context, d dVar) {
        if (d(context)) {
            b(context);
        } else {
            a();
        }
        int i2 = this.f3058l;
        if (i2 == 0) {
            this.m = true;
        }
        if (this.m) {
            dVar.b(this.n, true);
            return;
        }
        try {
            a aVar = new a(dVar);
            ThreadLocal<TypedValue> threadLocal = h.a;
            if (context.isRestricted()) {
                aVar.a(-4, null);
            } else {
                h.b(context, i2, new TypedValue(), 0, aVar, null, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            while (true) {
                this.m = true;
                dVar.a(1);
                return;
            }
        } catch (Exception unused2) {
            this.m = true;
            dVar.a(-3);
        }
    }

    public final boolean d(Context context) {
        int i2 = this.f3058l;
        Typeface typeface = null;
        if (i2 != 0) {
            ThreadLocal<TypedValue> threadLocal = h.a;
            if (!context.isRestricted()) {
                typeface = h.b(context, i2, new TypedValue(), 0, null, null, false, true);
            }
        }
        return typeface != null;
    }

    public void e(Context context, TextPaint textPaint, d dVar) {
        f(context, textPaint, dVar);
        ColorStateList colorStateList = this.f3056j;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f2 = this.f3053g;
        float f3 = this.f3051e;
        float f4 = this.f3052f;
        ColorStateList colorStateList2 = this.a;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void f(Context context, TextPaint textPaint, d dVar) {
        if (d(context)) {
            g(textPaint, b(context));
            return;
        }
        a();
        g(textPaint, this.n);
        c(context, new c(this, textPaint, dVar));
    }

    public void g(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i2 = (~typeface.getStyle()) & this.c;
        textPaint.setFakeBoldText((i2 & 1) != 0);
        textPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f3057k);
        if (this.f3054h) {
            textPaint.setLetterSpacing(this.f3055i);
        }
    }
}
