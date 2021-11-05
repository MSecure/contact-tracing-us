package c.b.a.b.g0;

import android.graphics.Paint;
import android.graphics.Path;

public class a {
    public static final int[] i = new int[3];
    public static final float[] j = {0.0f, 0.5f, 1.0f};
    public static final int[] k = new int[4];
    public static final float[] l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    public final Paint f4250a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    public final Paint f4251b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f4252c;

    /* renamed from: d  reason: collision with root package name */
    public int f4253d;

    /* renamed from: e  reason: collision with root package name */
    public int f4254e;

    /* renamed from: f  reason: collision with root package name */
    public int f4255f;

    /* renamed from: g  reason: collision with root package name */
    public final Path f4256g = new Path();
    public Paint h = new Paint();

    public a() {
        a(-16777216);
        this.h.setColor(0);
        Paint paint = new Paint(4);
        this.f4251b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f4252c = new Paint(this.f4251b);
    }

    public void a(int i2) {
        this.f4253d = b.i.f.a.c(i2, 68);
        this.f4254e = b.i.f.a.c(i2, 20);
        this.f4255f = b.i.f.a.c(i2, 0);
        this.f4250a.setColor(this.f4253d);
    }
}
