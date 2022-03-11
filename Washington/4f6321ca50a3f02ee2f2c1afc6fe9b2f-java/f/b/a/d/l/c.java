package f.b.a.d.l;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import f.b.a.c.b.o.b;

public final class c {
    public final b a;
    public final b b;
    public final b c;

    /* renamed from: d  reason: collision with root package name */
    public final b f2630d;

    /* renamed from: e  reason: collision with root package name */
    public final b f2631e;

    /* renamed from: f  reason: collision with root package name */
    public final b f2632f;

    /* renamed from: g  reason: collision with root package name */
    public final b f2633g;

    /* renamed from: h  reason: collision with root package name */
    public final Paint f2634h;

    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(b.E1(context, R$attr.materialCalendarStyle, i.class.getCanonicalName()), R$styleable.MaterialCalendar);
        this.a = b.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayStyle, 0));
        this.f2633g = b.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.b = b.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_daySelectedStyle, 0));
        this.c = b.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList L0 = b.L0(context, obtainStyledAttributes, R$styleable.MaterialCalendar_rangeFillColor);
        this.f2630d = b.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearStyle, 0));
        this.f2631e = b.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f2632f = b.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f2634h = paint;
        paint.setColor(L0.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
