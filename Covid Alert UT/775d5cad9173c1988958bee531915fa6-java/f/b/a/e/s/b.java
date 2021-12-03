package f.b.a.e.s;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.TypedValue;
import com.google.android.material.R$styleable;
import e.i.b.b.h;

public class b {
    public final ColorStateList a;
    public final String b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3008d;

    /* renamed from: e  reason: collision with root package name */
    public final float f3009e;

    /* renamed from: f  reason: collision with root package name */
    public final float f3010f;

    /* renamed from: g  reason: collision with root package name */
    public final float f3011g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f3012h;

    /* renamed from: i  reason: collision with root package name */
    public final float f3013i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f3014j;

    /* renamed from: k  reason: collision with root package name */
    public float f3015k;

    /* renamed from: l  reason: collision with root package name */
    public final int f3016l;
    public boolean m = false;
    public Typeface n;

    public class a extends h.c {
        public final /* synthetic */ d a;

        public a(d dVar) {
            this.a = dVar;
        }

        @Override // e.i.b.b.h.c
        public void d(int i2) {
            b.this.m = true;
            this.a.a(i2);
        }

        @Override // e.i.b.b.h.c
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
        this.f3015k = obtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f);
        this.f3014j = f.b.a.c.b.o.b.x0(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColor);
        f.b.a.c.b.o.b.x0(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        f.b.a.c.b.o.b.x0(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        this.c = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        this.f3008d = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int i3 = R$styleable.TextAppearance_fontFamily;
        i3 = !obtainStyledAttributes.hasValue(i3) ? R$styleable.TextAppearance_android_fontFamily : i3;
        this.f3016l = obtainStyledAttributes.getResourceId(i3, 0);
        this.b = obtainStyledAttributes.getString(i3);
        obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        this.a = f.b.a.c.b.o.b.x0(context, obtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        this.f3009e = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f3010f = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f3011g = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i2, R$styleable.MaterialTextAppearance);
        int i4 = R$styleable.MaterialTextAppearance_android_letterSpacing;
        this.f3012h = obtainStyledAttributes2.hasValue(i4);
        this.f3013i = obtainStyledAttributes2.getFloat(i4, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        if (this.n == null && (str = this.b) != null) {
            this.n = Typeface.create(str, this.c);
        }
        if (this.n == null) {
            int i2 = this.f3008d;
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
                Typeface a2 = h.a(context, this.f3016l);
                this.n = a2;
                if (a2 != null) {
                    this.n = Typeface.create(a2, this.c);
                }
            } catch (Resources.NotFoundException | Exception | UnsupportedOperationException unused) {
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
        int i2 = this.f3016l;
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
            this.m = true;
            dVar.a(1);
        } catch (Exception unused2) {
            this.m = true;
            dVar.a(-3);
        }
    }

    public final boolean d(Context context) {
        int i2 = this.f3016l;
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
        ColorStateList colorStateList = this.f3014j;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f2 = this.f3011g;
        float f3 = this.f3009e;
        float f4 = this.f3010f;
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
        textPaint.setTextSize(this.f3015k);
        if (this.f3012h) {
            textPaint.setLetterSpacing(this.f3013i);
        }
    }
}
