package c.b.a.b.x;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import c.b.a.b.b;
import c.b.a.b.l;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final b f3235a;

    /* renamed from: b  reason: collision with root package name */
    public final b f3236b;

    /* renamed from: c  reason: collision with root package name */
    public final b f3237c;

    /* renamed from: d  reason: collision with root package name */
    public final b f3238d;

    /* renamed from: e  reason: collision with root package name */
    public final b f3239e;
    public final b f;
    public final b g;
    public final Paint h;

    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c.b.a.a.c.n.c.W1(context, b.materialCalendarStyle, g.class.getCanonicalName()), l.MaterialCalendar);
        this.f3235a = b.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_dayStyle, 0));
        this.g = b.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_dayInvalidStyle, 0));
        this.f3236b = b.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_daySelectedStyle, 0));
        this.f3237c = b.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList Z0 = c.b.a.a.c.n.c.Z0(context, obtainStyledAttributes, l.MaterialCalendar_rangeFillColor);
        this.f3238d = b.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_yearStyle, 0));
        this.f3239e = b.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_yearSelectedStyle, 0));
        this.f = b.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(Z0.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
