package e.c0;

import android.os.Build;

public final class c {

    /* renamed from: i  reason: collision with root package name */
    public static final c f1005i = new a().a();
    public m a;
    public boolean b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1006d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1007e;

    /* renamed from: f  reason: collision with root package name */
    public long f1008f;

    /* renamed from: g  reason: collision with root package name */
    public long f1009g;

    /* renamed from: h  reason: collision with root package name */
    public d f1010h;

    public static final class a {
        public m a = m.NOT_REQUIRED;
        public boolean b = false;
        public d c = new d();

        public c a() {
            return new c(this);
        }
    }

    public c() {
        this.a = m.NOT_REQUIRED;
        this.f1008f = -1;
        this.f1009g = -1;
        this.f1010h = new d();
    }

    public c(a aVar) {
        this.a = m.NOT_REQUIRED;
        this.f1008f = -1;
        this.f1009g = -1;
        this.f1010h = new d();
        this.b = false;
        int i2 = Build.VERSION.SDK_INT;
        this.c = false;
        this.a = aVar.a;
        this.f1006d = aVar.b;
        this.f1007e = false;
        if (i2 >= 24) {
            this.f1010h = aVar.c;
            this.f1008f = -1;
            this.f1009g = -1;
        }
    }

    public c(c cVar) {
        this.a = m.NOT_REQUIRED;
        this.f1008f = -1;
        this.f1009g = -1;
        this.f1010h = new d();
        this.b = cVar.b;
        this.c = cVar.c;
        this.a = cVar.a;
        this.f1006d = cVar.f1006d;
        this.f1007e = cVar.f1007e;
        this.f1010h = cVar.f1010h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.b == cVar.b && this.c == cVar.c && this.f1006d == cVar.f1006d && this.f1007e == cVar.f1007e && this.f1008f == cVar.f1008f && this.f1009g == cVar.f1009g && this.a == cVar.a) {
            return this.f1010h.equals(cVar.f1010h);
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f1008f;
        long j3 = this.f1009g;
        return this.f1010h.hashCode() + (((((((((((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.f1006d ? 1 : 0)) * 31) + (this.f1007e ? 1 : 0)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31);
    }
}
