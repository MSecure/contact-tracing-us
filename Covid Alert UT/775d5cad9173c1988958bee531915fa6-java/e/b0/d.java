package e.b0;

import android.os.Build;

public final class d {

    /* renamed from: i  reason: collision with root package name */
    public static final d f1161i = new d(new a());
    public o a;
    public boolean b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1162d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1163e;

    /* renamed from: f  reason: collision with root package name */
    public long f1164f;

    /* renamed from: g  reason: collision with root package name */
    public long f1165g;

    /* renamed from: h  reason: collision with root package name */
    public e f1166h;

    public static final class a {
        public o a = o.NOT_REQUIRED;
        public boolean b = false;
        public e c = new e();
    }

    public d() {
        this.a = o.NOT_REQUIRED;
        this.f1164f = -1;
        this.f1165g = -1;
        this.f1166h = new e();
    }

    public d(a aVar) {
        this.a = o.NOT_REQUIRED;
        this.f1164f = -1;
        this.f1165g = -1;
        this.f1166h = new e();
        this.b = false;
        int i2 = Build.VERSION.SDK_INT;
        this.c = false;
        this.a = aVar.a;
        this.f1162d = aVar.b;
        this.f1163e = false;
        if (i2 >= 24) {
            this.f1166h = aVar.c;
            this.f1164f = -1;
            this.f1165g = -1;
        }
    }

    public d(d dVar) {
        this.a = o.NOT_REQUIRED;
        this.f1164f = -1;
        this.f1165g = -1;
        this.f1166h = new e();
        this.b = dVar.b;
        this.c = dVar.c;
        this.a = dVar.a;
        this.f1162d = dVar.f1162d;
        this.f1163e = dVar.f1163e;
        this.f1166h = dVar.f1166h;
    }

    public boolean a() {
        return this.f1166h.a() > 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.b == dVar.b && this.c == dVar.c && this.f1162d == dVar.f1162d && this.f1163e == dVar.f1163e && this.f1164f == dVar.f1164f && this.f1165g == dVar.f1165g && this.a == dVar.a) {
            return this.f1166h.equals(dVar.f1166h);
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f1164f;
        long j3 = this.f1165g;
        return this.f1166h.hashCode() + (((((((((((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.f1162d ? 1 : 0)) * 31) + (this.f1163e ? 1 : 0)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31);
    }
}
