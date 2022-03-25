package e.b.f;

public class p0 {
    public int a = 0;
    public int b = 0;
    public int c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f929d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f930e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f931f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f932g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f933h = false;

    public void a(int i2, int i3) {
        this.c = i2;
        this.f929d = i3;
        this.f933h = true;
        if (this.f932g) {
            if (i3 != Integer.MIN_VALUE) {
                this.a = i3;
            }
            if (i2 != Integer.MIN_VALUE) {
                this.b = i2;
                return;
            }
            return;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.a = i2;
        }
        if (i3 != Integer.MIN_VALUE) {
            this.b = i3;
        }
    }
}
