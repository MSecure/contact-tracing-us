package c.b.a.b.x;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import b.b.k.i;
import b.i.l.m;
import c.b.a.a.c.n.c;
import c.b.a.b.h0.a;
import c.b.a.b.h0.g;
import c.b.a.b.h0.j;
import c.b.a.b.l;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f3228a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f3229b;

    /* renamed from: c  reason: collision with root package name */
    public final ColorStateList f3230c;

    /* renamed from: d  reason: collision with root package name */
    public final ColorStateList f3231d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3232e;
    public final j f;

    public b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, j jVar, Rect rect) {
        i.j.l(rect.left);
        i.j.l(rect.top);
        i.j.l(rect.right);
        i.j.l(rect.bottom);
        this.f3228a = rect;
        this.f3229b = colorStateList2;
        this.f3230c = colorStateList;
        this.f3231d = colorStateList3;
        this.f3232e = i;
        this.f = jVar;
    }

    public static b a(Context context, int i) {
        if (i != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, l.MaterialCalendarItem);
            Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(l.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(l.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(l.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(l.MaterialCalendarItem_android_insetBottom, 0));
            ColorStateList Z0 = c.Z0(context, obtainStyledAttributes, l.MaterialCalendarItem_itemFillColor);
            ColorStateList Z02 = c.Z0(context, obtainStyledAttributes, l.MaterialCalendarItem_itemTextColor);
            ColorStateList Z03 = c.Z0(context, obtainStyledAttributes, l.MaterialCalendarItem_itemStrokeColor);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(l.MaterialCalendarItem_itemStrokeWidth, 0);
            j a2 = j.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(l.MaterialCalendarItem_itemShapeAppearanceOverlay, 0), new a((float) 0)).a();
            obtainStyledAttributes.recycle();
            return new b(Z0, Z02, Z03, dimensionPixelSize, a2, rect);
        }
        throw new IllegalArgumentException("Cannot create a CalendarItemStyle with a styleResId of 0");
    }

    public void b(TextView textView) {
        g gVar = new g();
        g gVar2 = new g();
        gVar.setShapeAppearanceModel(this.f);
        gVar2.setShapeAppearanceModel(this.f);
        gVar.r(this.f3230c);
        gVar.v((float) this.f3232e, this.f3231d);
        textView.setTextColor(this.f3229b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f3229b.withAlpha(30), gVar, gVar2);
        Rect rect = this.f3228a;
        m.W(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
