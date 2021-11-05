package c.b.a.b.e0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.TypedValue;
import b.b.k.i;
import b.i.e.b.g;
import c.b.a.a.c.n.c;
import c.b.a.b.l;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final float f2958a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f2959b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2960c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2961d;

    /* renamed from: e  reason: collision with root package name */
    public final String f2962e;
    public final ColorStateList f;
    public final float g;
    public final float h;
    public final float i;
    public final int j;
    public boolean k = false;
    public Typeface l;

    public class a extends g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f2963a;

        public a(d dVar) {
            this.f2963a = dVar;
        }

        @Override // b.i.e.b.g
        public void c(int i) {
            b.this.k = true;
            this.f2963a.a(i);
        }

        @Override // b.i.e.b.g
        public void d(Typeface typeface) {
            b bVar = b.this;
            bVar.l = Typeface.create(typeface, bVar.f2960c);
            b bVar2 = b.this;
            bVar2.k = true;
            this.f2963a.b(bVar2.l, false);
        }
    }

    public b(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, l.TextAppearance);
        this.f2958a = obtainStyledAttributes.getDimension(l.TextAppearance_android_textSize, 0.0f);
        this.f2959b = c.Z0(context, obtainStyledAttributes, l.TextAppearance_android_textColor);
        c.Z0(context, obtainStyledAttributes, l.TextAppearance_android_textColorHint);
        c.Z0(context, obtainStyledAttributes, l.TextAppearance_android_textColorLink);
        this.f2960c = obtainStyledAttributes.getInt(l.TextAppearance_android_textStyle, 0);
        this.f2961d = obtainStyledAttributes.getInt(l.TextAppearance_android_typeface, 1);
        int i3 = l.TextAppearance_fontFamily;
        i3 = !obtainStyledAttributes.hasValue(i3) ? l.TextAppearance_android_fontFamily : i3;
        this.j = obtainStyledAttributes.getResourceId(i3, 0);
        this.f2962e = obtainStyledAttributes.getString(i3);
        obtainStyledAttributes.getBoolean(l.TextAppearance_textAllCaps, false);
        this.f = c.Z0(context, obtainStyledAttributes, l.TextAppearance_android_shadowColor);
        this.g = obtainStyledAttributes.getFloat(l.TextAppearance_android_shadowDx, 0.0f);
        this.h = obtainStyledAttributes.getFloat(l.TextAppearance_android_shadowDy, 0.0f);
        this.i = obtainStyledAttributes.getFloat(l.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public final void a() {
        String str;
        if (this.l == null && (str = this.f2962e) != null) {
            this.l = Typeface.create(str, this.f2960c);
        }
        if (this.l == null) {
            int i2 = this.f2961d;
            this.l = i2 != 1 ? i2 != 2 ? i2 != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.l = Typeface.create(this.l, this.f2960c);
        }
    }

    public void b(Context context, d dVar) {
        a();
        if (this.j == 0) {
            this.k = true;
        }
        if (this.k) {
            dVar.b(this.l, true);
            return;
        }
        try {
            int i2 = this.j;
            a aVar = new a(dVar);
            if (context.isRestricted()) {
                aVar.a(-4, null);
            } else {
                i.j.y0(context, i2, new TypedValue(), 0, aVar, null, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.k = true;
            dVar.a(1);
        } catch (Exception unused2) {
            this.k = true;
            dVar.a(-3);
        }
    }

    public void c(Context context, TextPaint textPaint, d dVar) {
        a();
        d(textPaint, this.l);
        b(context, new c(this, textPaint, dVar));
        ColorStateList colorStateList = this.f2959b;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f2 = this.i;
        float f3 = this.g;
        float f4 = this.h;
        ColorStateList colorStateList2 = this.f;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void d(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i2 = (~typeface.getStyle()) & this.f2960c;
        textPaint.setFakeBoldText((i2 & 1) != 0);
        textPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f2958a);
    }
}
