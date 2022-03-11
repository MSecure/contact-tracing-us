package e.r;

import android.os.Handler;
import e.r.h;
import e.r.x;
/* loaded from: classes.dex */
public class v implements l {

    /* renamed from: j  reason: collision with root package name */
    public static final v f1900j = new v();

    /* renamed from: f  reason: collision with root package name */
    public Handler f1903f;
    public int b = 0;
    public int c = 0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1901d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1902e = true;

    /* renamed from: g  reason: collision with root package name */
    public final m f1904g = new m(this);

    /* renamed from: h  reason: collision with root package name */
    public Runnable f1905h = new a();

    /* renamed from: i  reason: collision with root package name */
    public x.a f1906i = new b();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v vVar = v.this;
            if (vVar.c == 0) {
                vVar.f1901d = true;
                vVar.f1904g.e(h.a.ON_PAUSE);
            }
            v vVar2 = v.this;
            if (vVar2.b == 0 && vVar2.f1901d) {
                vVar2.f1904g.e(h.a.ON_STOP);
                vVar2.f1902e = true;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements x.a {
        public b() {
        }
    }

    @Override // e.r.l
    public h a() {
        return this.f1904g;
    }

    public void b() {
        int i2 = this.c + 1;
        this.c = i2;
        if (i2 != 1) {
            return;
        }
        if (this.f1901d) {
            this.f1904g.e(h.a.ON_RESUME);
            this.f1901d = false;
            return;
        }
        this.f1903f.removeCallbacks(this.f1905h);
    }

    public void e() {
        int i2 = this.b + 1;
        this.b = i2;
        if (i2 == 1 && this.f1902e) {
            this.f1904g.e(h.a.ON_START);
            this.f1902e = false;
        }
    }
}
