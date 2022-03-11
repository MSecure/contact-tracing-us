package f.b.a.e.l;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import f.b.a.c.b.o.b;
/* loaded from: classes.dex */
public final class c {
    public final b a;
    public final b b;
    public final b c;

    /* renamed from: d */
    public final b f2933d;

    /* renamed from: e */
    public final b f2934e;

    /* renamed from: f */
    public final b f2935f;

    /* renamed from: g */
    public final b f2936g;

    /* renamed from: h */
    public final Paint f2937h;

    public c(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(b.n1(context, R$attr.materialCalendarStyle, i.class.getCanonicalName()), R$styleable.MaterialCalendar);
        this.a = b.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayStyle, 0));
        this.f2936g = b.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.b = b.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_daySelectedStyle, 0));
        this.c = b.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList y0 = b.y0(context, obtainStyledAttributes, R$styleable.MaterialCalendar_rangeFillColor);
        this.f2933d = b.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearStyle, 0));
        this.f2934e = b.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f2935f = b.a(context, obtainStyledAttributes.getResourceId(R$styleable.MaterialCalendar_yearTodayStyle, 0));
        Paint paint = new Paint();
        this.f2937h = paint;
        paint.setColor(y0.getDefaultColor());
        obtainStyledAttributes.recycle();
    }
}
