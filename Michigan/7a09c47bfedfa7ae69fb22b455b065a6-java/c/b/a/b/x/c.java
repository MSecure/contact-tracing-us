package c.b.a.b.x;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import b.x.t;
import c.b.a.b.b;
import c.b.a.b.l;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final b f4560a;

    /* renamed from: b  reason: collision with root package name */
    public final b f4561b;

    /* renamed from: c  reason: collision with root package name */
    public final b f4562c;

    /* renamed from: d  reason: collision with root package name */
    public final b f4563d;

    /* renamed from: e  reason: collision with root package name */
    public final b f4564e;

    /* renamed from: f  reason: collision with root package name */
    public final b f4565f;

    /* renamed from: g  reason: collision with root package name */
    public final b f4566g;
    public final Paint h;

    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(t.B2(context, b.materialCalendarStyle, g.class.getCanonicalName()), l.MaterialCalendar);
        this.f4560a = b.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_dayStyle, 0));
        this.f4566g = b.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_dayInvalidStyle, 0));
        this.f4561b = b.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_daySelectedStyle, 0));
        this.f4562c = b.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList B1 = t.B1(context, obtainStyledAttributes, l.MaterialCalendar_rangeFillColor);
        this.f4563d = b.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_yearStyle, 0));
        this.f4564e = b.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_yearSelectedStyle, 0));
        this.f4565f = b.a(context, obtainStyledAttributes.getResourceId(l.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.h = paint;
        paint.setColor(B1.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
