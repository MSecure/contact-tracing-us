package b.r.d;

public class e implements w {

    /* renamed from: a  reason: collision with root package name */
    public final w f2326a;

    /* renamed from: b  reason: collision with root package name */
    public int f2327b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f2328c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f2329d = -1;

    /* renamed from: e  reason: collision with root package name */
    public Object f2330e = null;

    public e(w wVar) {
        this.f2326a = wVar;
    }

    @Override // b.r.d.w
    public void a(int i, int i2) {
        int i3;
        if (this.f2327b != 2 || (i3 = this.f2328c) < i || i3 > i + i2) {
            e();
            this.f2328c = i;
            this.f2329d = i2;
            this.f2327b = 2;
            return;
        }
        this.f2329d += i2;
        this.f2328c = i;
    }

    @Override // b.r.d.w
    public void b(int i, int i2) {
        int i3;
        if (this.f2327b == 1 && i >= (i3 = this.f2328c)) {
            int i4 = this.f2329d;
            if (i <= i3 + i4) {
                this.f2329d = i4 + i2;
                this.f2328c = Math.min(i, i3);
                return;
            }
        }
        e();
        this.f2328c = i;
        this.f2329d = i2;
        this.f2327b = 1;
    }

    @Override // b.r.d.w
    public void c(int i, int i2) {
        e();
        this.f2326a.c(i, i2);
    }

    @Override // b.r.d.w
    public void d(int i, int i2, Object obj) {
        int i3;
        if (this.f2327b == 3) {
            int i4 = this.f2328c;
            int i5 = this.f2329d;
            if (i <= i4 + i5 && (i3 = i + i2) >= i4 && this.f2330e == obj) {
                this.f2328c = Math.min(i, i4);
                this.f2329d = Math.max(i5 + i4, i3) - this.f2328c;
                return;
            }
        }
        e();
        this.f2328c = i;
        this.f2329d = i2;
        this.f2330e = obj;
        this.f2327b = 3;
    }

    public void e() {
        int i = this.f2327b;
        if (i != 0) {
            if (i == 1) {
                this.f2326a.b(this.f2328c, this.f2329d);
            } else if (i == 2) {
                this.f2326a.a(this.f2328c, this.f2329d);
            } else if (i == 3) {
                this.f2326a.d(this.f2328c, this.f2329d, this.f2330e);
            }
            this.f2330e = null;
            this.f2327b = 0;
        }
    }
}
