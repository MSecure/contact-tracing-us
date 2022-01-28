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
import b.x.t;
import c.b.a.b.l;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final ColorStateList f4231a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f4232b;

    /* renamed from: c  reason: collision with root package name */
    public final ColorStateList f4233c;

    /* renamed from: d  reason: collision with root package name */
    public final ColorStateList f4234d;

    /* renamed from: e  reason: collision with root package name */
    public final String f4235e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4236f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4237g;
    public final float h;
    public final float i;
    public final float j;
    public float k;
    public final int l;
    public boolean m = false;
    public Typeface n;

    public class a extends g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f4238a;

        public a(d dVar) {
            this.f4238a = dVar;
        }

        @Override // b.i.e.b.g
        public void c(int i) {
            b.this.m = true;
            this.f4238a.a(i);
        }

        @Override // b.i.e.b.g
        public void d(Typeface typeface) {
            b bVar = b.this;
            bVar.n = Typeface.create(typeface, bVar.f4236f);
            b bVar2 = b.this;
            bVar2.m = true;
            this.f4238a.b(bVar2.n, false);
        }
    }

    public b(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, l.TextAppearance);
        this.k = obtainStyledAttributes.getDimension(l.TextAppearance_android_textSize, 0.0f);
        this.f4231a = t.B1(context, obtainStyledAttributes, l.TextAppearance_android_textColor);
        this.f4232b = t.B1(context, obtainStyledAttributes, l.TextAppearance_android_textColorHint);
        this.f4233c = t.B1(context, obtainStyledAttributes, l.TextAppearance_android_textColorLink);
        this.f4236f = obtainStyledAttributes.getInt(l.TextAppearance_android_textStyle, 0);
        this.f4237g = obtainStyledAttributes.getInt(l.TextAppearance_android_typeface, 1);
        int i3 = l.TextAppearance_fontFamily;
        i3 = !obtainStyledAttributes.hasValue(i3) ? l.TextAppearance_android_fontFamily : i3;
        this.l = obtainStyledAttributes.getResourceId(i3, 0);
        this.f4235e = obtainStyledAttributes.getString(i3);
        obtainStyledAttributes.getBoolean(l.TextAppearance_textAllCaps, false);
        this.f4234d = t.B1(context, obtainStyledAttributes, l.TextAppearance_android_shadowColor);
        this.h = obtainStyledAttributes.getFloat(l.TextAppearance_android_shadowDx, 0.0f);
        this.i = obtainStyledAttributes.getFloat(l.TextAppearance_android_shadowDy, 0.0f);
        this.j = obtainStyledAttributes.getFloat(l.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public final void a() {
        String str;
        if (this.n == null && (str = this.f4235e) != null) {
            this.n = Typeface.create(str, this.f4236f);
        }
        if (this.n == null) {
            int i2 = this.f4237g;
            this.n = i2 != 1 ? i2 != 2 ? i2 != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.n = Typeface.create(this.n, this.f4236f);
        }
    }

    public void b(Context context, d dVar) {
        a();
        if (this.l == 0) {
            this.m = true;
        }
        if (this.m) {
            dVar.b(this.n, true);
            return;
        }
        try {
            int i2 = this.l;
            a aVar = new a(dVar);
            if (context.isRestricted()) {
                aVar.a(-4, null);
            } else {
                i.j.O(context, i2, new TypedValue(), 0, aVar, null, false);
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
        ColorStateList colorStateList = this.f4231a;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f2 = this.j;
        float f3 = this.h;
        float f4 = this.i;
        ColorStateList colorStateList2 = this.f4234d;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void d(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i2 = (~typeface.getStyle()) & this.f4236f;
        textPaint.setFakeBoldText((i2 & 1) != 0);
        textPaint.setTextSkewX((i2 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.k);
    }
}
