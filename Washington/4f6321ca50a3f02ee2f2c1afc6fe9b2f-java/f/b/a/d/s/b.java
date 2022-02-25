package f.b.a.d.s;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.TypedValue;
import com.google.android.material.R$styleable;
import e.i.b.b.g;
import e.i.b.b.h;

public class b {
    public final ColorStateList a;
    public final ColorStateList b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2743d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2744e;

    /* renamed from: f  reason: collision with root package name */
    public final float f2745f;

    /* renamed from: g  reason: collision with root package name */
    public final float f2746g;

    /* renamed from: h  reason: collision with root package name */
    public final float f2747h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f2748i;

    /* renamed from: j  reason: collision with root package name */
    public final float f2749j;

    /* renamed from: k  reason: collision with root package name */
    public float f2750k;

    /* renamed from: l  reason: collision with root package name */
    public final int f2751l;
    public boolean m = false;
    public Typeface n;

    public class a extends g {
        public final /* synthetic */ d a;

        public a(d dVar) {
            this.a = dVar;
        }

        @Override // e.i.b.b.g
        public void c(int i2) {
            b.this.m = true;
            this.a.a(i2);
        }

        @Override // e.i.b.b.g
        public void d(Typeface typeface) {
            b bVar = b.this;
            bVar.n = Typeface.create(typeface, bVar.f2743d);
            b bVar2 = b.this;
            bVar2.m = true;
            this.a.b(bVar2.n, false);
        }
    }

    public b(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.TextAppearance);
        this.f2750k = obtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f);
        this.a = f.b.a.c.b.o.b.L0(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColor);
        f.b.a.c.b.o.b.L0(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        f.b.a.c.b.o.b.L0(context, obtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        this.f2743d = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        this.f2744e = obtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int i3 = R$styleable.TextAppearance_fontFamily;
        i3 = !obtainStyledAttributes.hasValue(i3) ? R$styleable.TextAppearance_android_fontFamily : i3;
        this.f2751l = obtainStyledAttributes.getResourceId(i3, 0);
        this.c = obtainStyledAttributes.getString(i3);
        obtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        this.b = f.b.a.c.b.o.b.L0(context, obtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        this.f2745f = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f2746g = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f2747h = obtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i2, R$styleable.MaterialTextAppearance);
        int i4 = R$styleable.MaterialTextAppearance_android_letterSpacing;
        this.f2748i = obtainStyledAttributes2.hasValue(i4);
        this.f2749j = obtainStyledAttributes2.getFloat(i4, 0.0f);
        obtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        if (this.n == null && (str = this.c) != null) {
            this.n = Typeface.create(str, this.f2743d);
        }
        if (this.n == null) {
            int i2 = this.f2744e;
            this.n = i2 != 1 ? i2 != 2 ? i2 != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.n = Typeface.create(this.n, this.f2743d);
        }
    }

    public void b(Context context, d dVar) {
        a();
        int i2 = this.f2751l;
        if (i2 == 0) {
            this.m = true;
        }
        if (this.m) {
            dVar.b(this.n, true);
            return;
        }
        try {
            a aVar = new a(dVar);
            if (context.isRestricted()) {
                aVar.a(-4, null);
            } else {
                h.d(context, i2, new TypedValue(), 0, aVar, null, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.m = true;
            dVar.a(1);
        } catch (Exception unused2) {
            this.m = true;
            dVar.a(-3);
        }
    }

    public void c(Context context, TextPaint textPaint, d dVar) {
        a();
        d(textPaint, this.n);
        b(context, new c(this, textPaint, dVar));
        ColorStateList colorStateList = this.a;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f2 = this.f2747h;
        float f3 = this.f2745f;
        float f4 = this.f2746g;
        ColorStateList colorStateList2 = this.b;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void d(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i2 = (~typeface.getStyle()) & this.f2743d;
        textPaint.setFakeBoldText((i2 & 1) != 0);
        textPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f2750k);
        if (this.f2748i) {
            textPaint.setLetterSpacing(this.f2749j);
        }
    }
}
