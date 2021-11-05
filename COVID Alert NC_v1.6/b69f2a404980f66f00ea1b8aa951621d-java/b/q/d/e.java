package b.q.d;

public class e implements w {

    /* renamed from: a  reason: collision with root package name */
    public final w f1486a;

    /* renamed from: b  reason: collision with root package name */
    public int f1487b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f1488c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f1489d = -1;

    /* renamed from: e  reason: collision with root package name */
    public Object f1490e = null;

    public e(w wVar) {
        this.f1486a = wVar;
    }

    @Override // b.q.d.w
    public void a(int i, int i2) {
        int i3;
        if (this.f1487b != 2 || (i3 = this.f1488c) < i || i3 > i + i2) {
            e();
            this.f1488c = i;
            this.f1489d = i2;
            this.f1487b = 2;
            return;
        }
        this.f1489d += i2;
        this.f1488c = i;
    }

    @Override // b.q.d.w
    public void b(int i, int i2) {
        int i3;
        if (this.f1487b == 1 && i >= (i3 = this.f1488c)) {
            int i4 = this.f1489d;
            if (i <= i3 + i4) {
                this.f1489d = i4 + i2;
                this.f1488c = Math.min(i, i3);
                return;
            }
        }
        e();
        this.f1488c = i;
        this.f1489d = i2;
        this.f1487b = 1;
    }

    @Override // b.q.d.w
    public void c(int i, int i2) {
        e();
        this.f1486a.c(i, i2);
    }

    @Override // b.q.d.w
    public void d(int i, int i2, Object obj) {
        int i3;
        if (this.f1487b == 3) {
            int i4 = this.f1488c;
            int i5 = this.f1489d;
            if (i <= i4 + i5 && (i3 = i + i2) >= i4 && this.f1490e == obj) {
                this.f1488c = Math.min(i, i4);
                this.f1489d = Math.max(i5 + i4, i3) - this.f1488c;
                return;
            }
        }
        e();
        this.f1488c = i;
        this.f1489d = i2;
        this.f1490e = obj;
        this.f1487b = 3;
    }

    public void e() {
        int i = this.f1487b;
        if (i != 0) {
            if (i == 1) {
                this.f1486a.b(this.f1488c, this.f1489d);
            } else if (i == 2) {
                this.f1486a.a(this.f1488c, this.f1489d);
            } else if (i == 3) {
                this.f1486a.d(this.f1488c, this.f1489d, this.f1490e);
            }
            this.f1490e = null;
            this.f1487b = 0;
        }
    }
}
