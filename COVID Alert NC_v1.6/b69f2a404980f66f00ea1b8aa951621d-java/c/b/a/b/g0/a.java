package c.b.a.b.g0;

import android.graphics.Paint;
import android.graphics.Path;

public class a {
    public static final int[] i = new int[3];
    public static final float[] j = {0.0f, 0.5f, 1.0f};
    public static final int[] k = new int[4];
    public static final float[] l = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    public final Paint f2973a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    public final Paint f2974b;

    /* renamed from: c  reason: collision with root package name */
    public final Paint f2975c;

    /* renamed from: d  reason: collision with root package name */
    public int f2976d;

    /* renamed from: e  reason: collision with root package name */
    public int f2977e;
    public int f;
    public final Path g = new Path();
    public Paint h = new Paint();

    public a() {
        a(-16777216);
        this.h.setColor(0);
        Paint paint = new Paint(4);
        this.f2974b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f2975c = new Paint(this.f2974b);
    }

    public void a(int i2) {
        this.f2976d = b.i.f.a.c(i2, 68);
        this.f2977e = b.i.f.a.c(i2, 20);
        this.f = b.i.f.a.c(i2, 0);
        this.f2973a.setColor(this.f2976d);
    }
}
