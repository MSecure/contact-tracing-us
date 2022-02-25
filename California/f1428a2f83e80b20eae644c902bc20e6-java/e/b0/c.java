package e.b0;

import android.os.Build;

public final class c {

    /* renamed from: i  reason: collision with root package name */
    public static final c f986i = new a().a();
    public m a;
    public boolean b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f987d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f988e;

    /* renamed from: f  reason: collision with root package name */
    public long f989f;

    /* renamed from: g  reason: collision with root package name */
    public long f990g;

    /* renamed from: h  reason: collision with root package name */
    public d f991h;

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
        this.f989f = -1;
        this.f990g = -1;
        this.f991h = new d();
    }

    public c(a aVar) {
        this.a = m.NOT_REQUIRED;
        this.f989f = -1;
        this.f990g = -1;
        this.f991h = new d();
        this.b = false;
        int i2 = Build.VERSION.SDK_INT;
        this.c = false;
        this.a = aVar.a;
        this.f987d = aVar.b;
        this.f988e = false;
        if (i2 >= 24) {
            this.f991h = aVar.c;
            this.f989f = -1;
            this.f990g = -1;
        }
    }

    public c(c cVar) {
        this.a = m.NOT_REQUIRED;
        this.f989f = -1;
        this.f990g = -1;
        this.f991h = new d();
        this.b = cVar.b;
        this.c = cVar.c;
        this.a = cVar.a;
        this.f987d = cVar.f987d;
        this.f988e = cVar.f988e;
        this.f991h = cVar.f991h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.b == cVar.b && this.c == cVar.c && this.f987d == cVar.f987d && this.f988e == cVar.f988e && this.f989f == cVar.f989f && this.f990g == cVar.f990g && this.a == cVar.a) {
            return this.f991h.equals(cVar.f991h);
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f989f;
        long j3 = this.f990g;
        return this.f991h.hashCode() + (((((((((((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.f987d ? 1 : 0)) * 31) + (this.f988e ? 1 : 0)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31);
    }
}
