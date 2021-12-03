package e.p;

import android.os.Handler;
import e.p.h;
import e.p.x;

public class v implements l {

    /* renamed from: j  reason: collision with root package name */
    public static final v f1540j = new v();
    public int b = 0;
    public int c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1541d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1542e = true;

    /* renamed from: f  reason: collision with root package name */
    public Handler f1543f;

    /* renamed from: g  reason: collision with root package name */
    public final m f1544g = new m(this);

    /* renamed from: h  reason: collision with root package name */
    public Runnable f1545h = new a();

    /* renamed from: i  reason: collision with root package name */
    public x.a f1546i = new b();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            v vVar = v.this;
            if (vVar.c == 0) {
                vVar.f1541d = true;
                vVar.f1544g.e(h.a.ON_PAUSE);
            }
            v vVar2 = v.this;
            if (vVar2.b == 0 && vVar2.f1541d) {
                vVar2.f1544g.e(h.a.ON_STOP);
                vVar2.f1542e = true;
            }
        }
    }

    public class b implements x.a {
        public b() {
        }
    }

    @Override // e.p.l
    public h a() {
        return this.f1544g;
    }

    public void b() {
        int i2 = this.c + 1;
        this.c = i2;
        if (i2 != 1) {
            return;
        }
        if (this.f1541d) {
            this.f1544g.e(h.a.ON_RESUME);
            this.f1541d = false;
            return;
        }
        this.f1543f.removeCallbacks(this.f1545h);
    }

    public void e() {
        int i2 = this.b + 1;
        this.b = i2;
        if (i2 == 1 && this.f1542e) {
            this.f1544g.e(h.a.ON_START);
            this.f1542e = false;
        }
    }
}
