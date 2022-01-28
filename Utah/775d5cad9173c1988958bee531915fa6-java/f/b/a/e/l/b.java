package f.b.a.e.l;

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
import e.i.i.v;
import f.b.a.e.v.a;
import f.b.a.e.v.g;
import f.b.a.e.v.j;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    public final Rect a;
    public final ColorStateList b;
    public final ColorStateList c;

    /* renamed from: d  reason: collision with root package name */
    public final ColorStateList f2888d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2889e;

    /* renamed from: f  reason: collision with root package name */
    public final j f2890f;

    public b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i2, j jVar, Rect rect) {
        m.e.l(rect.left);
        m.e.l(rect.top);
        m.e.l(rect.right);
        m.e.l(rect.bottom);
        this.a = rect;
        this.b = colorStateList2;
        this.c = colorStateList;
        this.f2888d = colorStateList3;
        this.f2889e = i2;
        this.f2890f = jVar;
    }

    public static b a(Context context, int i2) {
        m.e.i(i2 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R$styleable.MaterialCalendarItem);
        Rect rect = new Rect(obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetLeft, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetTop, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetRight, 0), obtainStyledAttributes.getDimensionPixelOffset(R$styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList x0 = f.b.a.c.b.o.b.x0(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList x02 = f.b.a.c.b.o.b.x0(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList x03 = f.b.a.c.b.o.b.x0(context, obtainStyledAttributes, R$styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        j a2 = j.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearance, 0), obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0), new a((float) 0)).a();
        obtainStyledAttributes.recycle();
        return new b(x0, x02, x03, dimensionPixelSize, a2, rect);
    }

    public void b(TextView textView) {
        g gVar = new g();
        g gVar2 = new g();
        gVar.setShapeAppearanceModel(this.f2890f);
        gVar2.setShapeAppearanceModel(this.f2890f);
        gVar.q(this.c);
        gVar.u((float) this.f2889e, this.f2888d);
        textView.setTextColor(this.b);
        RippleDrawable rippleDrawable = new RippleDrawable(this.b.withAlpha(30), gVar, gVar2);
        Rect rect = this.a;
        InsetDrawable insetDrawable = new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
        AtomicInteger atomicInteger = v.a;
        v.d.q(textView, insetDrawable);
    }
}
