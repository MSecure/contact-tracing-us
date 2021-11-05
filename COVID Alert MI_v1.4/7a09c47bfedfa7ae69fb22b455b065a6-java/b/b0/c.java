package b.b0;

import android.os.Build;

public final class c {
    public static final c i = new a().a();

    /* renamed from: a  reason: collision with root package name */
    public n f1009a = n.NOT_REQUIRED;

    /* renamed from: b  reason: collision with root package name */
    public boolean f1010b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1011c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1012d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1013e;

    /* renamed from: f  reason: collision with root package name */
    public long f1014f = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f1015g = -1;
    public d h = new d();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1016a = false;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1017b = false;

        /* renamed from: c  reason: collision with root package name */
        public n f1018c = n.NOT_REQUIRED;

        /* renamed from: d  reason: collision with root package name */
        public boolean f1019d = false;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1020e = false;

        /* renamed from: f  reason: collision with root package name */
        public long f1021f = -1;

        /* renamed from: g  reason: collision with root package name */
        public long f1022g = -1;
        public d h = new d();

        public c a() {
            return new c(this);
        }
    }

    public c() {
    }

    public c(a aVar) {
        this.f1010b = aVar.f1016a;
        this.f1011c = aVar.f1017b;
        this.f1009a = aVar.f1018c;
        this.f1012d = aVar.f1019d;
        this.f1013e = aVar.f1020e;
        if (Build.VERSION.SDK_INT >= 24) {
            this.h = aVar.h;
            this.f1014f = aVar.f1021f;
            this.f1015g = aVar.f1022g;
        }
    }

    public c(c cVar) {
        this.f1010b = cVar.f1010b;
        this.f1011c = cVar.f1011c;
        this.f1009a = cVar.f1009a;
        this.f1012d = cVar.f1012d;
        this.f1013e = cVar.f1013e;
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
        if (this.f1010b == cVar.f1010b && this.f1011c == cVar.f1011c && this.f1012d == cVar.f1012d && this.f1013e == cVar.f1013e && this.f1014f == cVar.f1014f && this.f1015g == cVar.f1015g && this.f1009a == cVar.f1009a) {
            return this.h.equals(cVar.h);
        }
        return false;
    }

    public int hashCode() {
        long j = this.f1014f;
        long j2 = this.f1015g;
        return this.h.hashCode() + (((((((((((((this.f1009a.hashCode() * 31) + (this.f1010b ? 1 : 0)) * 31) + (this.f1011c ? 1 : 0)) * 31) + (this.f1012d ? 1 : 0)) * 31) + (this.f1013e ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31);
    }
}
