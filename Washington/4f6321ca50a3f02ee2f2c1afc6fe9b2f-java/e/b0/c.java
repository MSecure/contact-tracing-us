package e.b0;

import android.os.Build;

public final class c {

    /* renamed from: i  reason: collision with root package name */
    public static final c f985i = new a().a();
    public m a;
    public boolean b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f986d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f987e;

    /* renamed from: f  reason: collision with root package name */
    public long f988f;

    /* renamed from: g  reason: collision with root package name */
    public long f989g;

    /* renamed from: h  reason: collision with root package name */
    public d f990h;

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
        this.f988f = -1;
        this.f989g = -1;
        this.f990h = new d();
    }

    public c(a aVar) {
        this.a = m.NOT_REQUIRED;
        this.f988f = -1;
        this.f989g = -1;
        this.f990h = new d();
        this.b = false;
        int i2 = Build.VERSION.SDK_INT;
        this.c = false;
        this.a = aVar.a;
        this.f986d = aVar.b;
        this.f987e = false;
        if (i2 >= 24) {
            this.f990h = aVar.c;
            this.f988f = -1;
            this.f989g = -1;
        }
    }

    public c(c cVar) {
        this.a = m.NOT_REQUIRED;
        this.f988f = -1;
        this.f989g = -1;
        this.f990h = new d();
        this.b = cVar.b;
        this.c = cVar.c;
        this.a = cVar.a;
        this.f986d = cVar.f986d;
        this.f987e = cVar.f987e;
        this.f990h = cVar.f990h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.b == cVar.b && this.c == cVar.c && this.f986d == cVar.f986d && this.f987e == cVar.f987e && this.f988f == cVar.f988f && this.f989g == cVar.f989g && this.a == cVar.a) {
            return this.f990h.equals(cVar.f990h);
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f988f;
        long j3 = this.f989g;
        return this.f990h.hashCode() + (((((((((((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.f986d ? 1 : 0)) * 31) + (this.f987e ? 1 : 0)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31);
    }
}
