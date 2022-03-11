package e.b.f;
/* loaded from: classes.dex */
public class t0 {
    public int a = 0;
    public int b = 0;
    public int c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f1024d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f1025e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f1026f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1027g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1028h = false;

    public void a(int i2, int i3) {
        this.c = i2;
        this.f1024d = i3;
        this.f1028h = true;
        if (this.f1027g) {
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
