package f.b.a.d.u;

import android.graphics.Paint;
import android.graphics.Path;

public class a {

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f2752i = new int[3];

    /* renamed from: j  reason: collision with root package name */
    public static final float[] f2753j = {0.0f, 0.5f, 1.0f};

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f2754k = new int[4];

    /* renamed from: l  reason: collision with root package name */
    public static final float[] f2755l = {0.0f, 0.0f, 0.5f, 1.0f};
    public final Paint a = new Paint();
    public final Paint b;
    public final Paint c;

    /* renamed from: d  reason: collision with root package name */
    public int f2756d;

    /* renamed from: e  reason: collision with root package name */
    public int f2757e;

    /* renamed from: f  reason: collision with root package name */
    public int f2758f;

    /* renamed from: g  reason: collision with root package name */
    public final Path f2759g = new Path();

    /* renamed from: h  reason: collision with root package name */
    public Paint f2760h = new Paint();

    public a() {
        a(-16777216);
        this.f2760h.setColor(0);
        Paint paint = new Paint(4);
        this.b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.c = new Paint(paint);
    }

    public void a(int i2) {
        this.f2756d = e.i.c.a.c(i2, 68);
        this.f2757e = e.i.c.a.c(i2, 20);
        this.f2758f = e.i.c.a.c(i2, 0);
        this.a.setColor(this.f2756d);
    }
}
