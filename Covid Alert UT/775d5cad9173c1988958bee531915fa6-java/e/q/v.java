package e.q;

import android.os.Handler;
import e.q.h;
import e.q.x;

public class v implements l {

    /* renamed from: j  reason: collision with root package name */
    public static final v f1815j = new v();
    public int b = 0;
    public int c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1816d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1817e = true;

    /* renamed from: f  reason: collision with root package name */
    public Handler f1818f;

    /* renamed from: g  reason: collision with root package name */
    public final m f1819g = new m(this);

    /* renamed from: h  reason: collision with root package name */
    public Runnable f1820h = new a();

    /* renamed from: i  reason: collision with root package name */
    public x.a f1821i = new b();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            v vVar = v.this;
            if (vVar.c == 0) {
                vVar.f1816d = true;
                vVar.f1819g.e(h.a.ON_PAUSE);
            }
            v vVar2 = v.this;
            if (vVar2.b == 0 && vVar2.f1816d) {
                vVar2.f1819g.e(h.a.ON_STOP);
                vVar2.f1817e = true;
            }
        }
    }

    public class b implements x.a {
        public b() {
        }
    }

    @Override // e.q.l
    public h a() {
        return this.f1819g;
    }

    public void b() {
        int i2 = this.c + 1;
        this.c = i2;
        if (i2 != 1) {
            return;
        }
        if (this.f1816d) {
            this.f1819g.e(h.a.ON_RESUME);
            this.f1816d = false;
            return;
        }
        this.f1818f.removeCallbacks(this.f1820h);
    }

    public void e() {
        int i2 = this.b + 1;
        this.b = i2;
        if (i2 == 1 && this.f1817e) {
            this.f1819g.e(h.a.ON_START);
            this.f1817e = false;
        }
    }
}
