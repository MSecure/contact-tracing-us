package e.c0;

import android.os.Build;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: i  reason: collision with root package name */
    public static final d f1240i = new d(new a());
    public o a;
    public boolean b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1241d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1242e;

    /* renamed from: f  reason: collision with root package name */
    public long f1243f;

    /* renamed from: g  reason: collision with root package name */
    public long f1244g;

    /* renamed from: h  reason: collision with root package name */
    public e f1245h;

    /* loaded from: classes.dex */
    public static final class a {
        public o a = o.NOT_REQUIRED;
        public boolean b = false;
        public e c = new e();
    }

    public d() {
        this.a = o.NOT_REQUIRED;
        this.f1243f = -1;
        this.f1244g = -1;
        this.f1245h = new e();
    }

    public d(a aVar) {
        this.a = o.NOT_REQUIRED;
        this.f1243f = -1;
        this.f1244g = -1;
        this.f1245h = new e();
        this.b = false;
        int i2 = Build.VERSION.SDK_INT;
        this.c = false;
        this.a = aVar.a;
        this.f1241d = aVar.b;
        this.f1242e = false;
        if (i2 >= 24) {
            this.f1245h = aVar.c;
            this.f1243f = -1;
            this.f1244g = -1;
        }
    }

    public d(d dVar) {
        this.a = o.NOT_REQUIRED;
        this.f1243f = -1;
        this.f1244g = -1;
        this.f1245h = new e();
        this.b = dVar.b;
        this.c = dVar.c;
        this.a = dVar.a;
        this.f1241d = dVar.f1241d;
        this.f1242e = dVar.f1242e;
        this.f1245h = dVar.f1245h;
    }

    public boolean a() {
        return this.f1245h.a() > 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.b == dVar.b && this.c == dVar.c && this.f1241d == dVar.f1241d && this.f1242e == dVar.f1242e && this.f1243f == dVar.f1243f && this.f1244g == dVar.f1244g && this.a == dVar.a) {
            return this.f1245h.equals(dVar.f1245h);
        }
        return false;
    }

    public int hashCode() {
        long j2 = this.f1243f;
        long j3 = this.f1244g;
        return this.f1245h.hashCode() + (((((((((((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.f1241d ? 1 : 0)) * 31) + (this.f1242e ? 1 : 0)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31);
    }
}
