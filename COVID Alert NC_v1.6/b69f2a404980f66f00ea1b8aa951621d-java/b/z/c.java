package b.z;

import android.os.Build;

public final class c {
    public static final c i = new a().a();

    /* renamed from: a  reason: collision with root package name */
    public n f1898a = n.NOT_REQUIRED;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1899b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1900c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1901d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1902e;
    public long f = -1;
    public long g = -1;
    public d h = new d();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1903a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1904b = false;

        /* renamed from: c  reason: collision with root package name */
        public n f1905c = n.NOT_REQUIRED;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1906d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1907e = false;
        public long f = -1;
        public long g = -1;
        public d h = new d();

        public c a() {
            return new c(this);
        }
    }

    public c() {
    }

    public c(a aVar) {
        this.f1899b = aVar.f1903a;
        this.f1900c = aVar.f1904b;
        this.f1898a = aVar.f1905c;
        this.f1901d = aVar.f1906d;
        this.f1902e = aVar.f1907e;
        if (Build.VERSION.SDK_INT >= 24) {
            this.h = aVar.h;
            this.f = aVar.f;
            this.g = aVar.g;
        }
    }

    public c(c cVar) {
        this.f1899b = cVar.f1899b;
        this.f1900c = cVar.f1900c;
        this.f1898a = cVar.f1898a;
        this.f1901d = cVar.f1901d;
        this.f1902e = cVar.f1902e;
        this.h = cVar.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f1899b == cVar.f1899b && this.f1900c == cVar.f1900c && this.f1901d == cVar.f1901d && this.f1902e == cVar.f1902e && this.f == cVar.f && this.g == cVar.g && this.f1898a == cVar.f1898a) {
            return this.h.equals(cVar.h);
        }
        return false;
    }

    public int hashCode() {
        long j = this.f;
        long j2 = this.g;
        return this.h.hashCode() + (((((((((((((this.f1898a.hashCode() * 31) + (this.f1899b ? 1 : 0)) * 31) + (this.f1900c ? 1 : 0)) * 31) + (this.f1901d ? 1 : 0)) * 31) + (this.f1902e ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }
}
