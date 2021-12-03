package f.b.a.e.k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import com.google.android.material.R$styleable;
import e.b.a.m;
import f.b.a.e.u.a;
import f.b.a.e.u.g;
import f.b.a.e.u.j;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    public final Rect a;
    public final ColorStateList b;
    public final ColorStateList c;

    /* renamed from: d  reason: collision with root package name */
    public final ColorStateList f2832d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2833e;

    /* renamed from: f  reason: collision with root package name */
    public final j f2834f;

    public b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i2, j jVar, Rect rect) {
        m.h.k(rect.left);
        m.h.k(rect.top);
        m.h.k(rect.right);
        m.h.k(rect.bottom);
        this.a = rect;
        this.b = colorStateList2;
        this.c = colorStateList;
        this.f2832d = colorStateList3;
        this.f2833e = i2;
        this.f2834f = jVar;
    }

    public static b a(Context context, int i2) {
        if (i2 != 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.MaterialCalendarItem);
            Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetBottom, 0));
            ColorStateList w0 = f.b.a.c.b.o.b.w0(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemFillColor);
            ColorStateList w02 = f.b.a.c.b.o.b.w0(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemTextColor);
            ColorStateList w03 = f.b.a.c.b.o.b.w0(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemStrokeColor);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCalendarItem_itemStrokeWidth, 0);
            j a2 = j.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0), new a((float) 0)).a();
            obtainStyledAttributes.recycle();
            return new b(w0, w02, w03, dimensionPixelSize, a2, rect);
        }
        throw new IllegalArgumentException("Cannot create a CalendarItemStyle with a styleResId of 0");
    }

    public void b(TextView textView) {
        g gVar = new g();
        g gVar2 = new g();
        gVar.setShapeAppearanceModel(this.f2834f);
        gVar2.setShapeAppearanceModel(this.f2834f);
        gVar.q(this.c);
        gVar.u((float) this.f2833e, this.f2832d);
        textView.setTextColor(this.b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.b.withAlpha(30), gVar, gVar2);
        Rect rect = this.a;
        InsetDrawable insetDrawable = new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
        AtomicInteger atomicInteger = e.i.i.m.a;
        textView.setBackground(insetDrawable);
    }
}
