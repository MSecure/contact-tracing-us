package b.b.q;

public class p0 {

    /* renamed from: a  reason: collision with root package name */
    public int f691a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f692b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f693c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public int f694d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public int f695e = 0;
    public int f = 0;
    public boolean g = false;
    public boolean h = false;

    public void a(int i, int i2) {
        this.f693c = i;
        this.f694d = i2;
        this.h = true;
        if (this.g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f691a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f692b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f691a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f692b = i2;
        }
    }
}
