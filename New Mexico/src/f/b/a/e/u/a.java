package f.b.a.e.u;

import android.graphics.Paint;
import android.graphics.Path;
/* loaded from: classes.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f3059i = new int[3];

    /* renamed from: j  reason: collision with root package name */
    public static final float[] f3060j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f3061k = new int[4];

    /* renamed from: l  reason: collision with root package name */
    public static final float[] f3062l = {0.0f, 0.0f, 0.5f, 1.0f};
    public final Paint b;
    public final Paint c;

    /* renamed from: d  reason: collision with root package name */
    public int f3063d;

    /* renamed from: e  reason: collision with root package name */
    public int f3064e;

    /* renamed from: f  reason: collision with root package name */
    public int f3065f;

    /* renamed from: g  reason: collision with root package name */
    public final Path f3066g = new Path();

    /* renamed from: h  reason: collision with root package name */
    public Paint f3067h = new Paint();
    public final Paint a = new Paint();

    public a() {
        a(-16777216);
        this.f3067h.setColor(0);
        Paint paint = new Paint(4);
        this.b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.c = new Paint(paint);
    }

    public void a(int i2) {
        this.f3063d = e.j.c.a.c(i2, 68);
        this.f3064e = e.j.c.a.c(i2, 20);
        this.f3065f = e.j.c.a.c(i2, 0);
        this.a.setColor(this.f3063d);
    }
}
