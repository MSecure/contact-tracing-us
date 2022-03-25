package e.c0.x.s;

import e.c0.c;
import e.c0.e;
import e.c0.l;
import e.c0.s;

public final class o {
    public static final String r = l.e("WorkSpec");
    public String a;
    public s b = s.ENQUEUED;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public String f1133d;

    /* renamed from: e  reason: collision with root package name */
    public e f1134e;

    /* renamed from: f  reason: collision with root package name */
    public e f1135f;

    /* renamed from: g  reason: collision with root package name */
    public long f1136g;

    /* renamed from: h  reason: collision with root package name */
    public long f1137h;

    /* renamed from: i  reason: collision with root package name */
    public long f1138i;

    /* renamed from: j  reason: collision with root package name */
    public c f1139j;

    /* renamed from: k  reason: collision with root package name */
    public int f1140k;

    /* renamed from: l  reason: collision with root package name */
    public e.c0.a f1141l;
    public long m;
    public long n;
    public long o;
    public long p;
    public boolean q;

    public static class a {
        public String a;
        public s b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.b != aVar.b) {
                return false;
            }
            return this.a.equals(aVar.a);
        }

        public int hashCode() {
            return this.b.hashCode() + (this.a.hashCode() * 31);
        }
    }

    public o(o oVar) {
        e eVar = e.c;
        this.f1134e = eVar;
        this.f1135f = eVar;
        this.f1139j = c.f1005i;
        this.f1141l = e.c0.a.EXPONENTIAL;
        this.m = 30000;
        this.p = -1;
        this.a = oVar.a;
        this.c = oVar.c;
        this.b = oVar.b;
        this.f1133d = oVar.f1133d;
        this.f1134e = new e(oVar.f1134e);
        this.f1135f = new e(oVar.f1135f);
        this.f1136g = oVar.f1136g;
        this.f1137h = oVar.f1137h;
        this.f1138i = oVar.f1138i;
        this.f1139j = new c(oVar.f1139j);
        this.f1140k = oVar.f1140k;
        this.f1141l = oVar.f1141l;
        this.m = oVar.m;
        this.n = oVar.n;
        this.o = oVar.o;
        this.p = oVar.p;
        this.q = oVar.q;
    }

    public o(String str, String str2) {
        e eVar = e.c;
        this.f1134e = eVar;
        this.f1135f = eVar;
        this.f1139j = c.f1005i;
        this.f1141l = e.c0.a.EXPONENTIAL;
        this.m = 30000;
        this.p = -1;
        this.a = str;
        this.c = str2;
    }

    public long a() {
        long j2;
        long j3;
        boolean z = false;
        if (this.b == s.ENQUEUED && this.f1140k > 0) {
            if (this.f1141l == e.c0.a.LINEAR) {
                z = true;
            }
            long j4 = this.m;
            long scalb = z ? j4 * ((long) this.f1140k) : (long) Math.scalb((float) j4, this.f1140k - 1);
            j3 = this.n;
            j2 = Math.min(18000000L, scalb);
        } else {
            long j5 = 0;
            if (c()) {
                long currentTimeMillis = System.currentTimeMillis();
                long j6 = this.n;
                int i2 = (j6 > 0 ? 1 : (j6 == 0 ? 0 : -1));
                if (i2 == 0) {
                    j6 = this.f1136g + currentTimeMillis;
                }
                long j7 = this.f1138i;
                long j8 = this.f1137h;
                if (j7 != j8) {
                    z = true;
                }
                if (z) {
                    if (i2 == 0) {
                        j5 = j7 * -1;
                    }
                    return j6 + j8 + j5;
                }
                if (i2 != 0) {
                    j5 = j8;
                }
                return j6 + j5;
            }
            j2 = this.n;
            if (j2 == 0) {
                j2 = System.currentTimeMillis();
            }
            j3 = this.f1136g;
        }
        return j2 + j3;
    }

    public boolean b() {
        return !c.f1005i.equals(this.f1139j);
    }

    public boolean c() {
        return this.f1137h != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f1136g != oVar.f1136g || this.f1137h != oVar.f1137h || this.f1138i != oVar.f1138i || this.f1140k != oVar.f1140k || this.m != oVar.m || this.n != oVar.n || this.o != oVar.o || this.p != oVar.p || this.q != oVar.q || !this.a.equals(oVar.a) || this.b != oVar.b || !this.c.equals(oVar.c)) {
            return false;
        }
        String str = this.f1133d;
        if (str == null ? oVar.f1133d == null : str.equals(oVar.f1133d)) {
            return this.f1134e.equals(oVar.f1134e) && this.f1135f.equals(oVar.f1135f) && this.f1139j.equals(oVar.f1139j) && this.f1141l == oVar.f1141l;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31;
        String str = this.f1133d;
        int hashCode2 = str != null ? str.hashCode() : 0;
        int hashCode3 = this.f1134e.hashCode();
        int hashCode4 = this.f1135f.hashCode();
        long j2 = this.f1136g;
        long j3 = this.f1137h;
        long j4 = this.f1138i;
        int hashCode5 = this.f1139j.hashCode();
        int hashCode6 = this.f1141l.hashCode();
        long j5 = this.m;
        long j6 = this.n;
        long j7 = this.o;
        long j8 = this.p;
        return ((((((((((hashCode6 + ((((hashCode5 + ((((((((hashCode4 + ((hashCode3 + ((hashCode + hashCode2) * 31)) * 31)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31)) * 31) + this.f1140k) * 31)) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + ((int) (j6 ^ (j6 >>> 32)))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.q ? 1 : 0);
    }

    public String toString() {
        return f.a.a.a.a.e(f.a.a.a.a.h("{WorkSpec: "), this.a, "}");
    }
}
