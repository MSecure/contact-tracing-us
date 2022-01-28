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
import b.x.t;
import c.b.a.b.h0.a;
import c.b.a.b.h0.g;
import c.b.a.b.h0.j;
import c.b.a.b.l;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Rect f4552a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f4553b;

    /* renamed from: c  reason: collision with root package name */
    public final ColorStateList f4554c;

    /* renamed from: d  reason: collision with root package name */
    public final ColorStateList f4555d;

    /* renamed from: e  reason: collision with root package name */
    public final int f4556e;

    /* renamed from: f  reason: collision with root package name */
    public final j f4557f;

    public b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, j jVar, Rect rect) {
        i.j.f(rect.left);
        i.j.f(rect.top);
        i.j.f(rect.right);
        i.j.f(rect.bottom);
        this.f4552a = rect;
        this.f4553b = colorStateList2;
        this.f4554c = colorStateList;
        this.f4555d = colorStateList3;
        this.f4556e = i;
        this.f4557f = jVar;
    }

    public static b a(Context context, int i) {
        if (i != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, l.MaterialCalendarItem);
            Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(l.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(l.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(l.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(l.MaterialCalendarItem_android_insetBottom, 0));
            ColorStateList B1 = t.B1(context, obtainStyledAttributes, l.MaterialCalendarItem_itemFillColor);
            ColorStateList B12 = t.B1(context, obtainStyledAttributes, l.MaterialCalendarItem_itemTextColor);
            ColorStateList B13 = t.B1(context, obtainStyledAttributes, l.MaterialCalendarItem_itemStrokeColor);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(l.MaterialCalendarItem_itemStrokeWidth, 0);
            j a2 = j.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(l.MaterialCalendarItem_itemShapeAppearanceOverlay, 0), new a((float) 0)).a();
            obtainStyledAttributes.recycle();
            return new b(B1, B12, B13, dimensionPixelSize, a2, rect);
        }
        throw new IllegalArgumentException("Cannot create a CalendarItemStyle with a styleResId of 0");
    }

    public void b(TextView textView) {
        g gVar = new g();
        g gVar2 = new g();
        gVar.setShapeAppearanceModel(this.f4557f);
        gVar2.setShapeAppearanceModel(this.f4557f);
        gVar.r(this.f4554c);
        gVar.v((float) this.f4556e, this.f4555d);
        textView.setTextColor(this.f4553b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f4553b.withAlpha(30), gVar, gVar2);
        Rect rect = this.f4552a;
        m.X(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
